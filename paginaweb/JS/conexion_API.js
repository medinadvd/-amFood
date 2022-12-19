const formEl = document.querySelector('.form');

formEl.addEventListener('submit', event => {
        event.preventDefault();

        const formData = new FormData(formEl);
        const data = new URLSearchParams(formData);

        fetch('http://localhost:8090/user/singUp', {
                method: 'POST',
                body: data

        })
        .then(res => res.json())
        .then(data => console.log(data))
        .catch(error => console.log(error));       

        const redirigir = window.location="LogIn.html";
        setTimeout ("redirigir", 5000);
});

