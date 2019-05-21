function getProducts(server, port, id) {
    $.getJSON("http://" + server + ":" + port + "/products", function(result) {
        $.each(result, function(key, value) {
            $("#" + id ).append(value.id + " " + value.name + "; ");
        });
    });
}