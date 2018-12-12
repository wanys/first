


//展示数据
function showData(data) {
    $("#tab").empty();
    var str = "";//定义用于拼接的字符串
    for (var i = 0; i < data.length; i++) {
        //拼接表格的行和列
        str = "<tr>" +
            "<td>" + data[i].stuid + "</td>" +
            "<td>" + data[i].stuname + "</td>" +
            "<td>" + data[i].stuage + "</td>" +
            "<td>" + data[i].stusex+"</td>" +
            "<td>" + "<a href='updateStu?id="+data[i].stuid+"'>修改</a>"+
            "</tr>"
        //追加到table中
        $("#tab").append(str);
    }
}
window.load(
    btn()
)

function btn(){
    var stuname=$("#stuname").val();
    var data={stuname:stuname};
    var ww=JSON.stringify(data);
    // noinspection JSAnnotator
    $.ajax({
        url: "logindo",
        type:"post",
        data:ww,
        dataType:"json",
        contentType: 'application/json;charset=UTF-8',
        success: function(data){
            /*这个方法里是ajax发送请求成功之后执行的代码*/
            showData(data);//我们仅做数据展示
        },
        error: function(msg){
            alert("ajax连接异常："+msg);
        }
    });
};
