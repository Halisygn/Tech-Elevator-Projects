<template>
  <div class="main">
    <h2>Produt Reviews For {{ name }}</h2>
    <p class="description"></p>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Party For Kevin",
      description: "Kevin likes cigars and bourbon.",
      reviews: [{ reviewer: "Alex Malcom" }],
    };
  },
};
</script>

<style scoped>
div.main {
  margin: 1rem 0;
}
</style>