document.addEventListener('DOMContentLoaded', () => {

   const body = document.querySelector('body');
   const btn = document.getElementById('btn1');
   btn.addEventListener('click', () => {
       body.classList.remove('color_1', 'color_3');
       body.classList.add('color_2');
   });
   btn.addEventListener('dblclick', () => {
    body.classList.remove('color_2', 'color_1');
    body.classList.add('color_3');
   })   

});
