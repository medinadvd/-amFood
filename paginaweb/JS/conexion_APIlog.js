const formEl = document.querySelector('.form')
const operacion = require("./cookies")



formEl.addEventListener('submit', event => {
                event.preventDefault();
        
                const formData = new FormData(formEl);
                const data = new URLSearchParams(formData);
        
                fetch('https://reqres.in/api/users', {
                        method: 'POST',
                        body: data
        
                })
                .then(res => res.json())        
                .then(data => console.log(data))
                .then(operacion.setCookie(document.getElementById('.correo')))
                .catch(error => console.log(error));       
                


                const redirigir = window.location="ActionPage.html";
                setTimeout ("redirigir", 5000);
        });

        
        
        
        
