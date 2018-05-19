<script type="text/javascript">

    var bts = [
        {btName: "新增", clickEvent: "openPage('edit','編輯',true,2);", icon: "&#xe608;", classes: "layui-btn-sm"},
        {btName: "上传文件", id:"upload", icon: "&#xe67c;", classes: "layui-btn-sm"}
    ];
    var searchInputs = [
        {formName: "nickname", labelName: "昵称", type: "text"}
        , {formName: "sourceNickname", labelName: "关注来源昵称", type: "text"}
    ];
    var columns = [
        {title: 'ID', field: 'id', width: 1}
        , {field: 'nickname', title: '昵称', width: 1}
        , {field: 'nicknameOpenid', title: '昵称的openid', width: 1}
        , {field: 'sourceNickname', title: '关注来源的昵称', width: 1}
        , {field: 'sourceOpenid', title: '关注来源的openid', width: 1}
        , {field: 'op', title: '操作', align: 'center', width: 1}
    ];
var pageReadyCallBack = function(){
    layui.use([ 'upload'], function () {
        layui.upload.render({
            elem: '#upload'
            , url: '/admin/weimobUserRelation/upload'
            , auto: true //是否选完文件后自动上传。如果设定 false，那么需要设置 bindAction 参数来指向一个其它按钮提交上传
            , accept: "file"
            , field: 'file'
            , acceptMime:"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"
            , size: 2000 // 设置文件最大可允许上传的大小，单位 KB。不支持ie8/9 ，0（即不限制）
            , done: function (res, index, upload) { //执行上传请求后的回调。返回三个参数，分别为：res（服务端响应信息）、index（当前文件的索引）、upload（重新上传的方法，一般在文件上传失败后使用）
                if(res.action==="success"){
                    refreshTabel();
                    layui.layer.alert("文件上传成功");
                }
                else
                    layui.layer.alert(res.msg);
            }
        });
    });
}

</script>
