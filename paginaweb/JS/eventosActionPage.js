const restaurante = document.querySelector('.restaurante');

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
    function cambiar(){
        restaurante.setAttribute('hidden', true)
        document.getElementById("imagenuser").src = imagenes[rand(10)-1];
        
        
    }

    
    const element = document.querySelector('.imagenLogo');
    element.addEventListener("click", evento);

    function evento() {
      conexion();
      restaurante.setAttribute('hidden', false)
      element.remove();
    }

    
function conexion(){
  fetch('https://jsonplaceholder.typicode.com/users')

  .then(res => {
     return res.json();
  })
  .then(data => {
      data.forEach(user => {
          const name = `${user.name}`; //cambiar name por la variable de la API del nombre del usuario
          
          document.querySelector('.user').insertAdjacentHTML('beforeend', name);

      });
  })
  .catch(error => console.log(error));
  
   
  
}



 


