<template>
  <div class="card" v-bind:class="book.read ? '' : 'read'">
    <div class="book-title">{{ book.title }}</div>
    <!-- Please leave <img> commented out until directed to remove open and close comment tags in the README. -->
    <img
      v-if="book.isbn"
      v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
      "
    />

    <div class="book-author">{{ book.author }}</div>
    <button
      v-bind:value="book.read"
      v-on:click="onReadChange(book)"
      v-bind:class="book.read ? 'mark-unread' : 'mark-read'"
    >
      {{ book.read ? "Mark Read" : "Mark Unread" }}
    </button>
  </div>
</template>

<script>
export default {
  name: "book-card",
  props: ["book"],
  methods: {
    onReadChange(book) {
      this.$store.commit("READ", book);
    },
  },
};
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
}

.card.read {
  background-color: lightgray;
}

.card .book-title {
  font-size: 1.5rem;
}

.card .book-author {
  font-size: 1rem;
}
</style>