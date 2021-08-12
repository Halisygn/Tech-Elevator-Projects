document.addEventListener('DOMContentLoaded', () => {
    const button = document.querySelector('.btn');
    button.addEventListener('click', () => {
        document.getElementById('time').innerText = Date();
    });
});
