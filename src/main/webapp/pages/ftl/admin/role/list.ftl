<script type="text/javascript">

    var bts = [
        {btName: "新增", clickEvent: "openPage('edit','编辑',true,2);", icon: "&#xe608;" ,classes:"layui-btn-sm"}
    ];
    var searchInputs = [
        {  formName:"name",  labelName:"角色名称",  type:"text" }
        ,{  formName:"nickName",  labelName:"角色昵称",  type:"text" }
    ];
    var columns = [
        {title: 'ID', field: 'id', width: 20, align: 'center'},
        {title: '角色名称', field: 'name', width: 60, align: 'center'},
        {title: '角色昵称', field: 'nickName', width: 60, align: 'center'},
        {title: '操作', field: 'operate', width: 30, align: 'center', tpl:"tpl"}
    ];
</script>
<script id="tpl" type="text/html">
    <div class="layui-btn-group">
        <button class="layui-btn layui-btn-sm" onclick="openPage('edit?id={{d.id}}','編輯角色',true,5);" title="编辑">
            <i class="layui-icon">&#xe642;</i> 编辑
        </button>
        <button class="layui-btn layui-btn-sm layui-btn-danger"
                onclick="openPage('/admin/resource/selectList?id={{d.id}}','權限設置',false,5,window.screen.width*0.5,window.screen.height*0.8);"
                title="權限設置">
            <i class="layui-icon">&#xe614;</i>权限设置
        </button>
        <button class="layui-btn layui-btn-sm layui-btn-danger" onclick="del('{{d.id}}');" title="刪除">
            <i class="layui-icon">&#xe640;</i>
        </button>
    </div>
</script>
