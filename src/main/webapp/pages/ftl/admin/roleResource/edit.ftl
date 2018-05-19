 <script type="text/javascript">

    var formRows = [
        {type: "hidden", formName: "id", formId: "id", value: "${data.id}"},
                    { formName: 'adminRoleId',labelName: 'adminRoleId', type: "text", value: "${data.adminRoleId}"},
                { formName: 'adminResourceId',labelName: 'adminResourceId', type: "text", value: "${data.adminResourceId}"},
                {
            type: "button", formName: "buttonGroup", options: [
            {btName: "保存", filterName: "save", laySubmit: true, type: "button", clickEvent: "page_save_ajax('save');"},
            {btName: "重置", btId: "reset", type: "reset"}
            ]
        }
    ];
</script>

