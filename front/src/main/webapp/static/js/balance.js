function balance(a,b) {
    var msg = "共选择了"+a+"件商品，共"+b+"元，是否结账？";
    if(confirm(msg)==true){
        location =path+'/orders/order';
    }else {
        return false;
    }
}