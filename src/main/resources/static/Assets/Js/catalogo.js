//FETCH PARA METODO GET

let productos;
// Aquí se debe cambiar el URL del servicio en el BackEnd
const URL_MAIN ='http://localhost:8090/sakachelas/api/products/all'; //URL a donde se hace la petición
function addItems(div_Productos) { //div_Productos es el div donde se va a agregar los productos
    fetch(URL_MAIN, {
        method: 'get' //tipo de método
    }).then(function(response) {//response es la respuesta del servidor
        response.json().then(function (json) { //json es el objeto que se obtiene del servicio
            console.log(json); //imprime el json
            console.log(json.length); //imprime el tamaño del json
            productos=json; //se guarda el json en la variable productos
            Array.from(json).forEach((p, index) => { //Toma el JSON, si es un arreglo haces el forEach. Si no lo es, mandas el error.
                div_Productos.innerHTML += `
                    <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="bd-placeholder-img card-img-top" role="img" src="Assets/img/${p.image}" />
                        <div class="card-body">
                        <p class="card-text"><strong>${p.name}</strong></p>
                        <p class="card-text">${p.description}</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                            <a class="add-cart cart2" href="#"><i class="produto__icon fas fa-cart-plus"><img src="./Assets/Img/carrito.jpeg" alt=""
                            class="img_carrito"></i></a>
                            </div>
                            <small class="text-muted">$ ${p.price} MXN</small>
                        </div>
                        </div>
                    </div>
                    </div>
                `;
            }); // foreach para agregar los productos al div del HTML
        });//then
    }).catch(function(err) { //si hay un error
        console.log(err); //imprime el error
    });
    console.log(document.getElementById("div_Productos")); //imprime el div donde se va a agregar los productos
   
}// addItems

window.addEventListener("load", function (){ //cuando se cargue la página
    let div = document.getElementById("div_Productos"); //div donde se va a agregar los productos
    addItems(div); //se llama a la función addItems
   
});

//Esta funcion es para un modal
function view(index) { //index es el índice del producto que se va a ver
    // console.log(index);
    // console.table(productos[index]);
    document.getElementById("productTitleModal").innerHTML=productos[index].nombre; //se cambia el título del modal
    document.getElementById("productBodyModal").innerHTML=`${productos[index].descripcion}  <img class="bd-placeholder-img card-img-top" role="img" src="img/${productos[index].url_Imagen}" />
    <strong>$ ${productos[index].price} MXN<strong>`; //se cambia el cuerpo del modal
    $("#productModal").modal("show"); //se muestra el modal
}// view

// FETCH PARA HACER EL METODO POST

// Este es nuestro cuerpo del POST


/*
const data =     
    {nombre: "Sopa Maruchan de Res",
    descripcion: "Sopa Maruchan sabor Res de 150 grs",
    precio: 17.0,
    url_Imagen: "sopaMaruchanRes.jpg"
};

*/
fetch(URL_MAIN, { //URL del servicio a donde se hara el POST
  method: 'POST', // or 'PUT' 
  headers: { // se agrega el header
    'Content-Type': 'application/json', //tipo de contenido
  },
  body: JSON.stringify(data), //se agrega el cuerpo del POST
})
.then(response => response.json()) //se obtiene la respuesta del servidor
.then(data => { //se obtiene el json
  console.log('Success:', data); //se imprime el json
})
.catch((error) => { //si hay un error
  console.error('Error:', error); //se imprime el error
});


//MetodoGET
//MetodoPOST
//MetodoPUT
//MetodoDELETE
