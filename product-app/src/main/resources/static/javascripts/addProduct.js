function addProduct(server, port, productModel) {
    var requestJSON = JSON.stringify(productModel);
    $.ajax({
        type: "POST",
        url: "http://" + server + ":" + port + "/products",
        headers: {
            "Content-Type": "application/json"
        },
        data: requestJSON,
        success: function(data) {
            alert(data);
        },
        error: function(data) {
            alert("error: " + data);
        }
    });
}