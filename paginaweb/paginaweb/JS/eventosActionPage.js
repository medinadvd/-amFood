function conexionAPI(){
  fetch('https://jsonplaceholder.typicode.com/users')

  .then(res => {
     return res.json();
  })
  .then(data => {
      data.forEach(user => {
          const name = `${user.Nombre}`; //cambiar name por la variable de la API del nombre del usuario

          document.querySelector('.user').insertAdjacentHTML('beforeend', name);
      })
  })
  /*.then(res => {
      return res.json();
    })
    .then(data =>{
        data.forEach(restaurante => {
        const restaurante = `<img src="${restaurante.imagen}"/> <li>Nombre: ${restaurante.Nombre}</li> 
              <li>Localizacion: ${restaurante.Localizacion}</li><li>Tipo Comida: ${restaurante.Tipo_comida}</li> 
              <li>Telefono: ${restaurante.Telefono}</li><li>Puntuacion: ${restaurante.Puntuacion }</li>`;

              document.querySelector('.restaurante').insertAdjacentHTML('beforeend', restaurante); 
      })
    })*/

    .catch(error => console.log(error));
}

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
      conexionAPI()
      restaurante.style.display = "none"
      document.getElementById("imagenuser").src = imagenes[rand(10)-1]
           
    }

    function evento(){
      restaurante.style.display= "block"
      element.remove()    
    }

    