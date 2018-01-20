function delProductIncart(abc) {
    var data = {
        pid:$("#pid"+abc).val(),
        mid:$("#mid"+abc).val()
    };
    if(confirm("确定删除吗？")==true){
       $.ajax({
           url:path+'/cart/delProductIncart',
           method:'post',
           data:data,
           success:function (res) {
               if(res.flag){
                   location.reload();
                   alert("已删除！");
               }else {
                   location.reload();
                   alert("网络出了故障，删除失败！");
               }
           }
       })
    }else {

    }
}


function updataCount(bbc) {
    var data = {
        pid:$("#pid"+bbc).val(),
        mid:$("#mid"+bbc).val(),
        count:$("#count"+bbc).val()
    };

    console.log(data);

    $.ajax({
        url:path+'/cart/updateCount',
        method:'post',
        data:data,
        success:function (res) {
            if (res.flag){
                alert("success");
                location.reload();
            }else {
                alert("fail");
                location.reload();
            }
        }
    })
}

function dropProduct(cbc) {
    var data = {
        pid:$("#pid"+cbc).val(),
        mid:$("#mid"+cbc).val(),
        type:$("#checkbox"+cbc).val()
    };
    //修改哪个用户的哪个商品的type
    console.log(data);
    $.ajax({
        url:path+'/cart/updateCartType',
        method:'post',
        data:data,
        success:function (res) {
            if (res.flag){
                alert(res.msg);
                location.reload();
            }else {
                alert(res.msg);
            }
        }
    })
}

function balance() {
    if(confirm("是否去结算？")==true){
        location = path+'/cart/balance';
    }else {
        return false;
    }
}