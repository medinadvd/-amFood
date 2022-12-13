fetch('https://jsonplaceholder.typicode.com/users')

    .then(res => {
       return res.json();
    })
    .then(data => {
        data.forEach(user => {
            const markup = `${user.name}`; //cambiar name por la variable de la API del nombre del usuario

            document.querySelector('.user').insertAdjacentHTML('beforeend', markup);
        });
    })
    .catch(error => console.log(error));