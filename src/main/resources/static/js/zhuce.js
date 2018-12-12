window.load(
    dentlu()
)
function denglu() {
    var  username=$("#username").val();
    var  userpsw=$("#userpsw").val();
    var data={username:username,userpsw:userpsw};
    var  ww=JSON.stringify(data);
    $.ajax({
            url:"zhucedo",
            type:"post",
            data:ww,
            dataType:"json",
            contentType:'application/json;charset=UTF-8',
            success:function (data) {
                if (data==1){
                    alert("注册成功");
                    window.location.href="index"
                } else{
                    alert("注册失败");
                }
            },
            error:function (msg) {
                alert("ajax链接异常"+msg);
            }
        }

    )
}