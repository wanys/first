window.load(
    $.ajax({
        url: "getStuId",
        type:"post",
        dataType:"json",
        contentType: 'application/json;charset=UTF-8',
        success: function(data){
           $("#stuid").val(data.stuid);
           $("#stuname").val(data.stuname);
           $("#stuage").val(data.stuage);
           $("#stusex").val(data.stusex);
        },
        error: function(msg){
            alert("ajax连接异常："+msg);
        }
    })
)

function updata() {
    var stuname=$("#stuname").val();
    var stuage=$("#stuage").val();
    var stusex=$("#stusex").val();
    var data={stuname:stuname,stuage:stuage,stusex:stusex};
    var ww=JSON.stringify(data);
    // noinspection JSAnnotator
    alert(ww);
    $.ajax({
        url: "updateStu",
        type:"post",
        data:ww,
        dataType:"json",
        contentType: 'application/json;charset=UTF-8',
        success: function(data){
            if (data==1){
                /*这个方法里是ajax发送请求成功之后执行的代码*/
                alert("更新成功");
                window.location.href="login"
            }else {
                alert("更新失败");
            }
        },
        error: function(msg){
            alert("ajax连接异常1："+msg);
        }
    });
}