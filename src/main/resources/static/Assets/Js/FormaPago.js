let jItems = JSON.parse(localStorage.allProducts);
let itemsPaypal = "";
let itemHtml = "";
let totalProducts = JSON.parse(localStorage.totalProducts);
let totalPaypalChain = [];
let address_user = JSON.parse(localStorage.datosEnvio);
let estado = []; 
let request = "";
let itemCarrito = "";

jItems.forEach(element => {

    let itemPrice = element.price.split(" ");

    const itemHtml = {
        name: element.title,
        quantity: element.quantity,
        unit_amount: {
            currency_code: "MXN",
            value: itemPrice[1]
        }
    }

    itemsPaypal = [...itemsPaypal, itemHtml]

    itemCarrito += '<tr><td>'+element.quantity+'</td><td>'+element.title+'</td></tr>';
})

document.querySelector('#orderProducts tbody').innerHTML = itemCarrito;
document.querySelector('#totalGrid').innerHTML = 'Total: '+ totalProducts;

totalPaypalChain = totalProducts.split(" ");
estado = address_user.estado.split(" ");
console.log(estado[1]);

const address_info = {
    address_line_1: address_user.direccion+" "+ address_user.numero+", Colonia "+address_user.colonia,
    admin_area_2: address_user.ciudad,
    admin_area_1: estado[1],
    postal_code: address_user.cp,
    country_code: "MX"
}

request = {
    "intent": "CAPTURE",
    "purchase_units": [{
        "items": itemsPaypal,
        "amount": {
            "currency_code": "MXN",
            "value": totalPaypalChain[1],
            "breakdown": {
                "item_total": {
                    "currency_code": "MXN",
                    "value": `${totalPaypalChain[1]}`
                }
            }
        },
        "shipping": {
            "address": address_info
        }
    }]
}

paypal.Buttons({
    style: {
        layout: 'vertical',
        color: 'silver',
        shape: 'rect',
        label: 'pay'
    },
    // Sets up the transaction when a PayPal payment button is clicked
    createOrder: async (data, actions) => {
        const response = await fetch("http://localhost:8090/sakachelas/api/paypal/order", {
            method: "post",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': localStorage.token
            },
            body: JSON.stringify(request)
            // use the "body" param to optionally pass additional order information
            // like product ids or amount or you can pass them in the backend like we did.
        });
        const order = await response.json();
        return order.id;
    },
    // Finalize the transaction after payer approval
    onApprove: async (data, actions) => {
        const response = await fetch(`http://localhost:8090/sakachelas/api/paypal/order/${data.orderID}/capture`, {
            method: "post"
        });
        const orderData = await response.json();
        // Successful capture! For dev/demo purposes:
        console.log("Capture result", orderData, JSON.stringify(orderData, null, 2));
        const transaction = orderData.purchase_units[0].payments.captures[0];
        alert("Transaction " + transaction.status + ": " + transaction.id + "\n\nSee console for all available details");
        // Save order in DB
        saveOrder();
    },
}).render("#paypal-button-container");



async function saveOrder(){
    let orderItems = JSON.parse(localStorage.getItem('allProducts'));
    let orderItemsArray = [];
    let addressUser = JSON.parse(localStorage.datosEnvio);
    let totalProducts = JSON.parse(localStorage.totalProducts);
    let date = new Date().toLocaleString("sv-SE");

    const lastOrderIdRequest = await fetch('http://localhost:8090/sakachelas/api/orders/lastOrderId', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    });
    const lastOrderId = await lastOrderIdRequest.json();
    const currentId = JSON.parse(lastOrderId)+1;
    
    console.log(JSON.parse(lastOrderId));
    console.log(currentId);

    const getProductId = (product)=>{
        switch(product){
            case "First Batch" : return "1";
            case "Big Poppa-K" : return "2";
            case "k-101" : return "3";
            case "Perla" : return "4";
            case "Prieta" : return "5";
            case "Trigueña" : return "6";
            case "Rubia" : return "7";     
            case "Mestiza" :  return "8";            
            case "Fractal" : return "9";
        }
    }

    orderItems.forEach((beer)=>{

        let beerPrice = beer.price.split(" ");
        let totalPerBeer = beerPrice[1]*beer.quantity;

        let itemBody = {
            "orderId": currentId,
            "productId": getProductId(beer.title),
            "name": beer.title,
            "quantity": beer.quantity,
            "beerPrice": beerPrice[1],
            "beerTotal": totalPerBeer
        }

        console.log(itemBody);
        orderItemsArray = [...orderItemsArray, itemBody];
        console.log(orderItemsArray);
    })
    
    addressUser = JSON.stringify(addressUser);
    console.log(addressUser);
    let totalProduct = totalProducts.split(" ");
    let totalProductFloat = parseFloat(totalProduct[1]);
    let dateTime = date.split(" ");
    let datef = dateTime[0]+ "T" + dateTime[1]; 

    let approvedOrder = {
        "orderId": lastOrderId+1,
        "trackingGuide": "En proceso",
        "status": "En proceso",
        "address": addressUser,
        "date": datef,
        "userId": JSON.parse(localStorage.getItem('usuarioId')),
        "payment": "Tarjeta Cred",
        "total": totalProductFloat,
        "items": orderItemsArray
    }

    console.log(approvedOrder);

    const request = await fetch('http://localhost:8090/sakachelas/api/orders/save', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.token
        },
        body: JSON.stringify(approvedOrder)
    });
}