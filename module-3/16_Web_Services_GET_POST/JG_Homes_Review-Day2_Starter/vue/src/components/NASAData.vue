<template>
  <div>
    <!-- {{ info }} -->
    <button v-on:click="getData">Click here for picture of the Day</button>
    <h3>{{ info.title }}</h3>
    <p><img v-bind:src="info.url" v-bind:alt="info.explanation" /></p>
  </div>
</template>

<script>
import nasaService from "../services/NASAService";
export default {
  //   name: "NASA-data",
  data() {
    return {
      info: "",
    };
  },
  methods: {
    getData() {
      nasaService.retrieveNASAData().then((response) => {
        this.info = response.data;
      });
    },
  },
};
</script>

<style>
</style>