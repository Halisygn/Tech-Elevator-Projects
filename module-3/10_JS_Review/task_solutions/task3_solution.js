
document.addEventListener('DOMContentLoaded', () => {

   const button = document.querySelector('.btn');
   button.addEventListener('click', (event) =>{
          document.getElementById('time').innerText = Date();
   });



});


