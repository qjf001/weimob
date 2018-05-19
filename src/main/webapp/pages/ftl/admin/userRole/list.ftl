<script type="text/javascript">

    var bts = [
        {btName: "新增", clickEvent: "openPage('edit','編輯',true,2);", icon: "&#xe608;" ,classes:"layui-btn-sm"}
    ];
    var searchInputs = [
            {  formName:"id",  labelName:"id",  type:"text" }
                ,{  formName:"admin_user_id",  labelName:"后台用户主键",  type:"text" }
                ,{  formName:"admin_role_id",  labelName:"后台角色主键",  type:"text" }
            ];
    var columns = [
        {title: 'ID', field: 'id', width: 1}
                    ,{ field: 'adminUserId',title: '后台用户主键', width: 1}
                ,{ field: 'adminRoleId',title: '后台角色主键', width: 1}
                ,{field: 'op', title: '操作', align: 'center', width: 1}
    ]
</script>
