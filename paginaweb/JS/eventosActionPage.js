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
         document.getElementById("imagenuser").src = imagenes[rand(10)-1];
    }


    