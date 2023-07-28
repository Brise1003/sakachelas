
window.addEventListener("load", function (){ 
    let div = document.getElementById("div_Productos");

    if(this.localStorage.getItem("filtro")=='ASC' || this.localStorage.getItem("filtro")=='DESC'){
        loadBeers();
    } else{
        showItems(div);
    }
});

function updateFiltro(catalogo){
    localStorage.setItem("filtro", catalogo);
    window.location.href = './Catalogo.html'; 
}


function showItems(div_Productos) {  
    fetch('http://localhost:8090/sakachelas/api/products/'+localStorage.filtro, {
    method: 'get' 
    })
    .then(function(response) {
        response.json().then(function (json) { 
            Array.from(json).forEach((p, index) => { 
                div_Productos.innerHTML += `
                    <div class="col-sm-3">
                    <div class="card md-3 shadow-sm">
                        <img class="bd-placeholder-img card-img-top" role="img" src="Assets/img/${p.image}" />
                        <div class="card-body sm-1">
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
                    </div>`;
            }); 
        });
    }).catch(function(err) { 
        console.log(err); 
    });
    console.log(document.getElementById("div_Productos"));
}


async function loadBeers(){

    const request = await fetch('http://localhost:8090/sakachelas/api/products/available?sortDirection=' + localStorage.filtro,{
        method : 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.token
        }
    });
    const response = await request.json();

    for(let beer of response.content){
        div_Productos.innerHTML += '<div class="col-md-4"><div class="card mb-4 shadow-sm"><img class="bd-placeholder-img card-img-top" role="img" src="Assets/img/'+beer.image+'" /><div class="card-body"><p class="card-text"><strong>'+beer.name+'</strong></p><p class="card-text">'+beer.description+'</p><div class="d-flex justify-content-between align-items-center"><div class="btn-group"><a class="add-cart cart2" href="#"><i class="produto__icon fas fa-cart-plus"><img src="./Assets/Img/carrito.jpeg" alt=""class="img_carrito"></i></a></div><small class="text-muted">$ '+beer.price+' MXN</small></div></div></div></div>';
    }
    document.getElementById("div_Productos") = div_Productos;
    
}

