import { store, storeShow } from "./localStorage.js";

conexionAPI();

function rand(n) {
  // creamos un numero al azar entre 1 y 10 (o cual sea la cantidad de imágenes)
  return Math.floor(Math.random() * n + 1);
}
//guardas imagenes en el array
let imagenes = [
  "imagenes/avocado.png",
  "imagenes/banana.png",
  "imagenes/grapes.png",
  "imagenes/lemon.png",
  "imagenes/orange.png",
  "imagenes/peach.png",
  "imagenes/pear.png",
  "imagenes/pineapple.png",
  "imagenes/strawberry.png",
  "imagenes/watermelon.png",
];

const imagenuserpequea = (document.getElementById("imagenuser").src =
  imagenes[rand(10) - 1]);
const imagenusergrande = (document.getElementById("imguser").src =
  imagenuserpequea);

const formEl = document.querySelector(".form");
formEl.addEventListener("submit", (event) => {
  event.preventDefault();

  let mail = storeShow();

  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  let vege = document.getElementById("vegetariano").checked;
  vege = convertirInt(vege);
  let vegano = document.getElementById("vegano").checked;
  vegano = convertirInt(vegano);
  let halal = document.getElementById("halal").checked;
  halal = convertirInt(halal);
  let glutenfree = document.getElementById("glutenfree").checked;
  glutenfree = convertirInt(glutenfree);

  var raw = JSON.stringify({
    correo: mail,
    vegetariano: vege,
    vegano: vegano,
    halal: halal,
    gluten_free: glutenfree,
  });

  var requestOptions = {
    method: "POST",
    headers: myHeaders,
    body: raw,
    redirect: "follow",
  };

  fetch("http://localhost:8090/user/profile/modify", requestOptions)
    .then((response) => response.text())
    .then((result) => console.log(result))
    .catch((error) => console.log("error", error));
});

function conexionAPI() {
  let mail = storeShow();

  var requestOptions = {
    method: "GET",
    redirect: "follow",
  };

  fetch("http://localhost:8090/user/userByMail?correo=" + mail, requestOptions)
    .then((response) => response.json())
    .then((result) => {
      document.getElementById("nombreuser").innerHTML = result.nombre;
      const inforuser = `<ul><li>Usuario:${result.nombre}</li><p></p><li>Correo:<br>${result.correo}</li> 
        <p></p> <li>Password:<br>${result.password}</li></ul>`;
      document.getElementById("datosusario").innerHTML = inforuser;
    })
    .then(preferenciasusuario())
    .catch((error) => console.log("error", error));
}

function preferenciasusuario() {
  let mail = storeShow();

  var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };
  

  fetch("http://localhost:8090/user/profile?correo=" + mail, requestOptions)
  .then((response) => response.json())
  .then((result) => {
      const vegetariano = result.vegetariano;
      const vegano = result.vegano;
      const halal = result.halal;
      const glutenfree = result.glutenfree;

      if (vegetariano == 1) {
        const uno = document.getElementById("vegetariano");
        uno.checked = true;
      }
      if (vegano == 1) {
        const dos = document.getElementById("vegano");
        dos.checked = true;
      }
      if (halal == 1) {
        const tres = document.getElementById("halal");
        tres.checked = true;
      }
      if (glutenfree == 1) {
        const cuatro = document.getElementById("glutenfree");
        cuatro.checked = true;
      }
    }) 
    .catch((error) => console.log("error", error));
}

function convertirInt(variable){
  if(variable == true){
    variable = 1;
  }else{
    variable = 0;
  }
  return variable;
}
