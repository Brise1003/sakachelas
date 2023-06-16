window.addEventListener("load", function (){ //cuando se cargue la página
       let div = document.getElementById("div_User"); //div donde se va a agregar los productos
       loadUser(div); //se llama a la función addItems
       loadOrders();
});

async function loadUser(){

    const request = await fetch('http://localhost:8090/sakachelas/api/users/1',{
        method : 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        }
    });
    
    const usuario = await request.json();

    let botonEliminar = '<button onclick="eliminarUsuario('+usuario.userId+')" type="button" class="btn btn-outline-dark" id="eraseAccountButton">Eliminar cuenta</button>';

    let usuarioHtml = '<h3><strong>'+usuario.username+' '+usuario.userLastname+', '+usuario.age+' años</strong></h3>'+botonEliminar+'<p>'+usuario.email+'</p>';

    document.querySelector('#div_User').outerHTML = usuarioHtml;
}

async function loadOrders(){

    const request = await fetch('http://localhost:8090/sakachelas/api/orders/1',{
        method : 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        }
    });
    const orders = await request.json();

    console.log(orders);

    listadoHTML = '';
    for(let order of orders){
        console.log(order.items);
        let itemsList = '';
        for(let item of order.items){
            
            console.log(item.productId);
            item = '<p>'+item.quantity+ 'pz.  '+ item.name+'</p>';
            itemsList+= item;
        }
        let orderHtml = '<tr><th scope="row">'+order.orderId+'</th><td>'+order.trackingGuide+'</td><td>'+order.status+'</td><td>'+order.date+'</td><td>'+order.payment+'</td><td>'+
        itemsList+'</td><td>'+order.total+'</td></tr>';
        listadoHTML += orderHtml;
    }

    document.querySelector('#sessionOrdersTable tbody').outerHTML = listadoHTML;
}

async function eliminarUsuario(){
    confirm("¿Está seguro que quiere eliminar su cuenta?");

    const request = await fetch('http://localhost:8090/sakachelas/api/users/delete/10',{
        method : 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        }
    });

    window.location.href = './Index.html1'; 
    
}