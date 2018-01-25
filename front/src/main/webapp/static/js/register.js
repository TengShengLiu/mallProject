function register() {
    var data = {
        username:$("#username").val(),
        password:$("#password").val(),
        repassword:$("#repassword").val(),
        tel:$("#tel").val()
    };

    console.log(data);

    $.ajax({
        url:path+"/member/register",
        method:"post",
        data:data,
        success:function (res) {
            if(res.flag){
                // alert("注册成功，点击跳转到主界面");
                location = path+"/toMain";
            }
        }
    })
}


$(function () {
    $("#username").blur(function () {
        data={
          username:$("#username").val()
        };
        $.ajax({
            url:path+"/member/checkUsername",
            method:"post",
            dataType:"json",
            data:data,
            success:function (res) {
                if (res.flag){
                    $("#s1").html(res.msg);
                }else {
                    $("#s1").html(res.msg);
                }
            }
        })
    });

    $("#repassword").blur(function () {
        var data = {
            password:$("#password").val(),
            repassword:$("#repassword").val()
        };
        $.ajax({
            url:path+"/member/checkPwd1",
            method:"post",
            data:data,
            success:function (res) {
                if(res.flag){
                    $("#s3").html(res.msg);
                }else {
                    $("#s3").html(res.msg);
                }
            }
        })
    });



});
