<script type="text/javascript">

    var formRows = [
        {type: "hidden", formName: "id", formId: "id", value: "${data.id}"}
        , {formName: 'nickname', labelName: '昵称', type: "text", value: "${data.nickname}"}
        , {formName: 'nicknameOpenid', labelName: '昵称的openid', type: "text", value: "${data.nicknameOpenid}"}
        , {formName: 'sourceNickname', labelName: '关注来源的昵称', type: "text", value: "${data.sourceNickname}"}
        , {formName: 'sourceOpenid', labelName: '关注来源的openid', type: "text", value: "${data.sourceOpenid}"}
        , {
            type: "button", formName: "buttonGroup", options: [
                {
                    btName: "保存",
                    filterName: "save",
                    laySubmit: true,
                    type: "button",
                    clickEvent: "page_save_ajax('save');"
                },
                {btName: "重置", btId: "reset", type: "reset"}
            ]
        }
    ];
</script>

