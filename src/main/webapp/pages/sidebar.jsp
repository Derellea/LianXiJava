<%--
  Created by IntelliJ IDEA.
  User: 14408
  Date: 2021/3/13
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="sidebar_blog_1">
    <div class="sidebar_user_info">
        <div class="icon_setting"></div>
        <div class="user_profle_side">
            <div class="user_img"><img class="img-responsive" src="${pageContext.request.contextPath}/images/layout_img/user_img.jpg" alt="#" /></div>
            <div class="user_info">
                <h6>John David</h6>
                <p><span class="online_animation"></span> Online</p>
            </div>
        </div>
    </div>
</div>
<div class="sidebar_blog_2">
    <h4 id="lianjava_59">练JAVA，恋JAVA</h4>
    <ul class="list-unstyled components" id="list">

    </ul>
</div>

</body>
<script src="${pageContext.request.contextPath}//jQuery/jquery-2.2.3.min.js"/>
<script></script>
<script>
    var vcStr='<ul class="collapse list-unstyled" id="element">';
    $.post("/vediocategory",{},function (list) {
        $(list).each(function (index,vc) {
            vcStr+='<li><a href="${pageContext.request.contextPath}/vedio/'+vc.vcId+'"> <span>'+vc.vcName+'</span></a></li>';

        })
        vcStr+="</ul></li>"
    },"json")

    $.post("/category/list",{},function (list){
        var str='';
        $(list).each(function (index,c){
            if(c.cId=='3'){
                str+='<li><a href="#element" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-diamond purple_color"></i> <span>'+c.cName+'</span></a>'
                str+=vcStr;
            }else{
                str+='<li><a href="${pageContext.request.contextPath}/'+c.cAdress+'"aria-expanded="false" ><i class="'+c.cClass+'"></i> <span>'+c.cName+'</span></a></li>'
            }
        })
        $("#list").html(str);
    },"json")
</script>
</html>
