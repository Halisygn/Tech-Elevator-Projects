<template>
  <div>
     <h1>Kevin's Resume</h1>
        <ul>
           <li v-for="job in jobs" v-bind:key="job.id">
               {{ job.title }}
           </li>

        </ul>

     <h2 v-if="birthday">Happy Birthday Kevin!!! You are {{calculateAge}} years old!</h2>

  </div>
</template>

<script>
export default {
    name: "kevins-resume",
    data() {
        return {
            jobs: [
                 {title : "CEO of Chase"},
                 {title : "Astronaut"},
                 {title : "fry guy"}
            ],
            age: 41,
            birthday: true
        }
    },
    computed: {
        calculateAge() {
            return this.age + 1;
        }
    }
    // computed: {
    //     calculateAge() {
    //         if (this.birthday) {
    //            this.addOneToAge();  
    //            return true;
    //         }
    //         return false;
        
    //     }
    // },
    // methods: {
    //     addOneToAge() {
    //         this.age = this.age + 1;
    //     }
    // }
}
</script>

<style scoped>

</style>

