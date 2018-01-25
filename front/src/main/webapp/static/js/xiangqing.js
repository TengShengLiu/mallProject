function shop() {
    var data = {
        pid:$("#pid").val(),
        count:$("#count").val()
    };
    console.log(data);
    $.ajax({
        url:path+'/cart/addToCart',
        method:'post',
        data:data,
        success:function (res) {
            //添加商品到数据库后返回信息，去购物车计算
            if(res.flag){
                location = path+"/product/toCart";
            }else {
                location = path+"/login.jsp";
            }
        }
    })
}

function addToCart() {
    var data = {
        pid:$("#pid").val(),
        count:$("#count").val()
    };
    console.log(data);
    $.ajax({
        url:path+'/cart/addToCart',
        method:'post',
        data:data,
        success:function (res) {
            //添加商品到数据库后返回信息，去购物车计算
            if(res.flag){
                if(confirm("添加成功，是否继续购物") == true){
                    location = path+'/toMain';
                }else {
                    return false;
                }
            }else {
                location = path+"/login.jsp";
            }
        }
    })
}

function number(abc) {
    var value = $("#count").val();
    $("#zongjia").html(value * abc);
}