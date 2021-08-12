<template>
  <div>
    <book-card
      class="book-card"
      v-bind:book="book"
      v-for="book in filteredList"
      v-bind:key="book.isbn"
    />
  </div>
</template>

<script>
import BookCard from "@/components/BookCard.vue";
export default {
  name: "book-details",
  components: {
    BookCard,
  },
  computed: {
    filteredList() {
      return this.$store.state.books.filter(
        (book) => book.isbn == this.$route.params.isbn
      );
    },
  },
};
</script>

<style>
</style>