<template>
  <div>
    <reading-list />
    <nav>
      <router-link v-bind:to="{ name: 'new-book' }"
        >Add Book Reading List</router-link
      >
    </nav>
  </div>
</template>

<script>
import ReadingList from "@/components/ReadingList";
export default {
  components: {
    ReadingList,
  },
};
</script>

<style>
</style>