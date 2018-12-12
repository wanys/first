window.load(
   dentlu()
)
function denglu() {
    var  username=$("#username").val();
    var  userpsw=$("#userpsw").val();
    var data={username:username,userpsw:userpsw};
    var  ww=JSON.stringify(data);
    $.ajax({
            url:"indexdo",
            type:"post",
            dataType:"json",
            contentType:'application/json;charset=UTF-8',
            success:function (data) {
                if (data==1){
                    alert("登录成功");
                    window.location.href="login"
                } else{
                    alert("登录失败");
                }
            },
            error:function (msg) {
                alert("ajax链接异常"+msg);
            }
        }

    )
}