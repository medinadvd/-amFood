
function rand(n){
  // creamos un numero al azar entre 1 y 10 (o cual sea la cantidad de imágenes)
   return(Math.floor(Math.random() * n + 1 ));
  }
  //guardas imagenes en el array
  let imagenes = [
      'imagenes/avocado.png',
      'imagenes/banana.png',
      'imagenes/grapes.png',
      'imagenes/lemon.png',
      'imagenes/orange.png',
      'imagenes/peach.png',
      'imagenes/pear.png',
      'imagenes/pineapple.png',
      'imagenes/strawberry.png',
      'imagenes/watermelon.png'
    ];

  var restaurante = document.getElementById("restaurante");
  const element = document.querySelector('.imagenLogo');

  function cambiar(){
    const cookieFunct = require("./cookies").default
    let mail = cookieFunct.getCookie()

    fetch('localhost:8090/user/userByMail?correo='+mail)

    .then(res => {
      return res.json();
    })
    .then(data => {
        data.forEach(user => {
            const nombre = `${user.nombre}`;
            const correo = `${user.correo}`;

            document.querySelector('.infouser').insertAdjacentHTML('beforeend', nombre);
            document.querySelector('.nombreuser').setAttribute("value", correo);
            
          
        })
    })
    .catch(error => console.log(error));

    


    restaurante.style.display = "none"
    element.style.display = "none"
    document.getElementById("imagenuser").src = imagenes[rand(10)-1]
         
  }

  function evento(){
    restaurante.style.display= "block"
    element.remove()
    llamarRestaurante();
  }


  const formEl = document.querySelector('.form');

  formEl.addEventListener('submit', event => {
    element.style.display = "block"
    event.preventDefault();
  
    const formData = new FormData(formEl);
    const data = new URLSearchParams(formData);

    fetch('https://reqres.in/api/users', {
            method: 'POST',
            body: data

    })
    .then(res => res.json())
    .then(data => console.log(data))
    .catch(error => console.log(error));    
    
});


function llamarRestaurante(){
    /*fetch('https://jsonplaceholder.typicode.com/users')
.then(res => {
   return res.json();
})
    .then(res => {
      return res.json();
    })
    .then(data =>{
        data.forEach(restaurante => {
        const restaurante = `<img src="/imagenes/${restaurante.imagen}"/> <li>Nombre: ${restaurante.nombre}</li> 
              <li>Localizacion: ${restaurante.localizacion}</li><li>Tipo Comida: ${restaurante.tipo_comida}</li> 
              <li>Telefono: ${restaurante.telefono}</li><li>Puntuacion: ${restaurante.puntuacion }</li>`;

              document.querySelector('.restaurante').insertAdjacentHTML('beforeend', restaurante); 
      })
    })*/
  }