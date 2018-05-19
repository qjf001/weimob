 <script type="text/javascript">

    var formRows = [
        {type: "hidden", formName: "id", formId: "id", value: "${data.id}"},
                    { formName: 'name',labelName: '资源名称', type: "text", value: "${data.name}"},
                { formName: 'url',labelName: 'url', type: "text", value: "${data.url}"},
                {
            type: "button", formName: "buttonGroup", options: [
            {btName: "保存", filterName: "save", laySubmit: true, type: "button", clickEvent: "page_save_ajax('save');"},
            {btName: "重置", btId: "reset", type: "reset"}
            ]
        }
    ];
</script>

