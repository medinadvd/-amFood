import { store, storeShow } from "./localStorage.js";

cambiar();
myFunction();

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
    document.getElementById("imagenuser").src = imagenes[rand(10)-1]

  function myFunction() {
    var x = document.getElementById("restaurante");

    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

  function cambiar(){

    let mail = storeShow();

    var requestOptions = {
      method: 'GET',
      redirect: 'follow'
    };
    
    fetch("http://localhost:8090/user/userByMail?correo="+mail, requestOptions)
      .then(response => response.json())
      .then(result => {
        document.getElementById('infouser').innerHTML = result.nombre;
      })
      .catch(error => console.log('error', error));
    
  }



  const formEl = document.querySelector('.form');

  formEl.addEventListener('submit', event => {
    event.preventDefault();
    myFunction();

    var myHeaders = new Headers();
        myHeaders.append("con", "application/json");
        myHeaders.append("Content-Type", "application/json");
   
    const localizacion = document.getElementById('lang').value;

    var raw = JSON.stringify({
      "correo": storeShow(),
      "localizacion": localizacion
    });
    
    var requestOptions = {
      method: 'POST',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };

    fetch("http://localhost:8090/restaurant", requestOptions)
    .then(res => res.json()) 
    .then(data =>{
      data.forEach(restaurante => {
      const info = `<img src="/imagenes/${restaurante.imagen}"/> <li>Nombre: ${restaurante.nombre}</li> 
            <li>Localizacion: ${restaurante.localizacion}</li><li>Tipo Comida: ${restaurante.tipo_comida}</li> 
            <li>Telefono: ${restaurante.telefono}</li><li>Puntuacion: ${restaurante.puntuacion }</li>`;
 
            document.querySelector('.restaurante').insertAdjacentHTML('beforeend', info); 
            console.log(data);
    })
    .catch(error => console.log(error));    
    
    });

  });

  // document.addEventListener("DOMContentLoaded", function() {
  //   alert("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
  //   cambiar();
  // });

  