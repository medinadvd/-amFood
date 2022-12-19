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

      const imagenuserpequea = document.getElementById("imagenuser").src = imagenes[rand(10)-1]
      const imagenusergrande = document.getElementById("imguser").src = imagenuserpequea

     
      const formEl = document.querySelector('.form');
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
        .then(conexionAPI())
        .catch(error => console.log(error));       
        
    });


   function conexionAPI(){
      fetch('https://jsonplaceholder.typicode.com/users')
    
      .then(res => {
         return res.json();
      })
      .then(data => {
        data.forEach(user => {
          const nombre = `${user.nombre}`;

          //document.querySelector('.nombreuser').insertAdjacentHTML('beforeend', nombre);
          
          const inforuser = `<ul><li>Usuario:${user.nombre}</li><p></p><li>Correo:<br>${user.correo}</li> 
          <p></p> <li>Password:<br>${user.password}</li></ul>`;

          document.querySelector('.datosusario').insertAdjacentHTML('beforeend', inforuser); 
        
        })
      })
      .then(
        preferenciasusuario()
      )
        .catch(error => console.log(error));
    }

function preferenciasusuario(){
  fetch('https://jsonplaceholder.typicode.com/users')
  then(res => {
    return res.json();
 })
 .then(data => {
  data.forEach(preferencias_user =>{
    const vegetariano = `${preferencias_user.vegetariano}`;
    const vegano = `${preferencias_user.vegano}`;
    const halal = `${preferencias_user.halal}`;
    const glutenfree = `${preferencias_user.glutenfree}`;


    if (vegetariano== true) {
      const uno = document.getElementById("vegetariano");
      uno.checked = true;
    }
    if (vegano== true) {
      const dos = document.getElementById("vegano");
      dos.checked = true;
    }
    if (halal== true) {
      const tres = document.getElementById("halal");
      tres.checked = true;
    }
    if (glutenfree== true) {
      const cuatro = document.getElementById("glutenfree");
      cuatro.checked = true;
    }

})
 })
  
}
  

    