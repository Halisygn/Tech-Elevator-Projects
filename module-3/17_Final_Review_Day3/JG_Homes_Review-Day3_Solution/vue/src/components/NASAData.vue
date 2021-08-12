<template>
  <div>
    <!--  {{info}} -->

      <button v-on:click="getData"> Click Here For Picture of the Day! </button>

      <h2>{{info.title}}</h2>
      <p>
          <img v-bind:src="info.url" v-bind:alt="info.explanation" >
      </p>
  </div>
</template>

<script>

import NASAService from '../services/NASAService.js';

export default {
  name: 'NASAData',
  data() {
      return {
          info: ''
      }
  },
  methods: {
      getData() {
           
        NASAService.retrieveNASAData().then(response => {

            this.info = response.data;
        })

      }
  }

}

</script>

<style>

</style>