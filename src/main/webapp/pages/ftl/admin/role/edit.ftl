 <script type="text/javascript">

    var formRows = [
        {type: "hidden", formName: "id", formId: "id", value: "${data.id}"},
                    { formName: 'name',labelName: '角色名称', type: "text", value: "${data.name}"},
                { formName: 'nickName',labelName: '', type: "text", value: "${data.nickName}"},
                {
            type: "button", formName: "buttonGroup", options: [
            {btName: "保存", filterName: "save", laySubmit: true, type: "button", clickEvent: "page_save_ajax('save');"},
            {btName: "重置", btId: "reset", type: "reset"}
            ]
        }
    ];
</script>

