document.addEventListener('DOMContentLoaded', () => {

    const button = document.getElementById('btn1');

    button.addEventListener('dblclick', () => {
        document.body.classList.add('.color_3');
    });

    button.addEventListener('click', (eve) => {
        document.body.classList.add('.color_2');
    });
});

