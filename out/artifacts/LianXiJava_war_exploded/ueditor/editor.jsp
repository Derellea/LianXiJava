<%--
  Created by IntelliJ IDEA.
  User: 14408
  Date: 2021/3/17
  Time: 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en-US">

<head>
    <meta charset="UTF-8">
    <title>ueditor demo</title>
</head>
<body>
<!-- 第一步：引入UDEITOR编辑器的js文件 -->
<script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.all.js"> </script>
<!-- 第二步：初始化 UDEITOR编辑器 -->
<script type="text/javascript">
    UE.getEditor('myeditor',{initialFrameHeight:300,initialFrameWidth:560})
</script>
<form name="upfile" id="upfile">
    <!-- 第三步：用于显示UDEITOR编辑器，可以是<textarea>，也可以是<script>... -->
    <textarea name="content" id="myeditor">默认值..</textarea>
</form>
</body>
<!--这里是处理加载文本编辑器和上传图片路径的脚本-->
<script>
    $(function(){
        //初始化下拉框
        initSelect();
        //初始化富文本
        initUedit();
    })
    //初始化Uedit
    function initUedit(){
        var ue = UE.getEditor('content_ue',{
            toolbars: [[
                'simpleupload', //单图上传
                'insertimage'//多图上传
            ]],
            zIndex : 9010,
            initialFrameWidth : 780,
            initialFrameHeight: 300
        });

        UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
        UE.Editor.prototype.getActionUrl = function(action) {
            if (action == 'uploadimage') {
                return '/ueditor/uploadImage';
            } else if(action == 'listimage') {
                return '/ueditor/listimage';
            } else {
                return this._bkGetActionUrl.call(this, action);
            }
        }
    }
</script>
</html>

