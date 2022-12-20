
    function setCookie(vcorreo) {
      
        document.cookie = "correo =" + vcorreo + ";path=/";
      }
      
      function getCookie() {
        let name = "correo =";
        let ca = document.cookie.split(';');
        for(let i = 0; i < ca.length; i++) {
          let c = ca[i];
          while (c.charAt(0) == ' ') {
            c = c.substring(1);
          }
          if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
          }
        }
        return "";
      }


      export default{
        "setCookie": setCookie,
        "getCookie": getCookie
      }
      

      
    
