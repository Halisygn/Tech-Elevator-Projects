<template>
  <div>
    <h2>Weather:</h2>
    <p>{{ weather }}</p>
    <div>

    </div>
  </div>
</template>

<script>


export default {
  name: "weather-report",

  data() {
    return {
      weather: ''
    };
  },
  created() {

fetch('http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=2f7bdcc26bc9669ab55f8341c4521509')
  .then((response) => {
      if (response.status !== 200) {
        console.log('Looks like there was a problem. Status Code: ' +
          response.status);
        return;
      }

      // Examine the text in the response
      response.json().then((data) => {
        console.log(data);
        this.weather = data;
      });
    }
  )
  .catch((err) => {
    console.log('Fetch Error', err);
  });
  },
};
</script>

<style>
</style>
