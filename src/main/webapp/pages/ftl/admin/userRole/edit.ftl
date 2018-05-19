 <script type="text/javascript">

    var formRows = [
        {type: "hidden", formName: "id", formId: "id", value: "${data.id}"},
                    { formName: 'adminUserId',labelName: '后台用户主键', type: "text", value: "${data.adminUserId}"},
                { formName: 'adminRoleId',labelName: '后台角色主键', type: "text", value: "${data.adminRoleId}"},
                {
            type: "button", formName: "buttonGroup", options: [
            {btName: "保存", filterName: "save", laySubmit: true, type: "button", clickEvent: "page_save_ajax('save');"},
            {btName: "重置", btId: "reset", type: "reset"}
            ]
        }
    ];
</script>

