function login() {
    var data = {
        username:$("#username").val(),
        password:$("#password").val()
    };
    $.ajax({
        url:path+'/member/login',
        method:'post',
        data:data,
        success:function (res) {
            if(res.flag){
                location = path+'/toMain';
            }else {
                alert(res.msg);
            }
        }
    })


}

