<script type="text/javascript">

    var bts = [
        {btName: "新增", clickEvent: "openPage('edit','编辑',true,2);", icon: "&#xe608;" ,classes:"layui-btn-sm"}
    ];
    var searchInputs = [
       {  formName:"name",  labelName:"name",  type:"text" }
        ,{  formName:"nick_name",  labelName:"昵称",  type:"text" }
    ];
    var columns = [
        {title: 'ID', field: 'id', width: 20, align: 'center'},
        {title: '登录账号', field: 'name', width: 30, align: 'center'},
        {title: '昵称', field: 'nickName', width: 60, align: 'center'},
        {title: '手机', field: 'mobile', width: 60, align: 'center'},
        {title: 'Email', field: 'email', width: 60, align: 'center'},
        {title: '操作', field: 'operate', width: 60, align: 'center', tpl:'btnTpl'}
    ]
    var resetPwd = function (id) {
        layui.layer.confirm("确定为该用户重置密码", function (cindex) {
            layui.layer.close(cindex);
            layui.layer.prompt({
                formType: 2,
                value: '',
                title: '请输入新密码',
                area: ['400px', '200px'] //自定义文本域宽高
            }, function (value, index, elem) {
                layui.layer.close(index);
                $.post({
                    url: "resetPwd",
                    data: {"password": $.md5(value.trim()), "id": id},
                    dataType: "json",
                    success: function (data) {
                        if (data.action === 'success') {
                            layui.layer.alert("操作成功", {icon: 1, title: '提示'});
                        }
                        else {
                            layui.layer.alert("操作失败");
                        }
                    }
                });
            });
        }, function () {});
    }
</script>
<script type="text/html" id="btnTpl">
    <div class="layui-btn-group">
        <button class="layui-btn layui-btn-sm" onclick="openPage('edit?id={{d.id}}','资源系统用户',true,5);" title="编辑">
            <i class="layui-icon">&#xe642;</i> 编辑
        </button>
        <button class="layui-btn layui-btn-sm layui-btn-danger" type='button' onclick="resetPwd('{{d.id}}');"
                title="重置密码">
            <i class="layui-icon">&#xe631;</i> 重置密码
        </button>
        <button class="layui-btn layui-btn-sm layui-btn-danger" onclick="del('{{d.id}}');" title="刪除">
            <i class="layui-icon">&#xe640;</i>
        </button>
    </div>
</script>
