<template>
  <div id="app">
    <product-review></product-review>
    <kevins-resume/>
  </div>
</template>

<script>
 import ProductReview from "./components/ProductReview.vue";
 import KevinsResume from "./components/KevinsResume.vue";

export default {
  name: "app",
  components: {
    ProductReview,
    KevinsResume
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
