<script type="text/javascript">

    var formRows = [
        {type: "hidden", formName: "id", formId: "id", value: "${data.id}"}
        , {formName: 'weimobOpenid', labelName: '微盟openid', type: "text",value: "${data.weimobOpenid}"}
        , {formName: 'customerNo', labelName: '客户编号', type: "text",value: "${data.customerNo}"}
        , {formName: 'qrcodeUrl', labelName: '二维码地址', type: "text",value: "${data.qrcodeUrl}"}
        , {formName: 'barcodeUrl', labelName: '条形码地址', type: "text",value: "${data.barcodeUrl}"}
        , {formName: 'tags', labelName: '标签对象', type: "text",value: "${data.tags}"}
        , {formName: 'isFans', labelName: '是否是粉丝', type: "text",value: "${data.isFans}"}
        , {formName: 'customerType', labelName: '客户类型', type: "text",value: "${data.customerType}"}
        , {formName: 'levelname', labelName: '类型名称', type: "text",value: "${data.levelname}"}
        , {formName: 'menbercardId', labelName: '会员卡号', type: "text",value: "${data.menbercardId}"}
        , {formName: 'currentGrowthValue', labelName: '成长值', type: "text",value: "${data.currentGrowthValue}"}
        , {formName: 'wxcodeStatus', labelName: '微信会员卡状态((0:未领卡 1:已领卡 2:已激活)', type: "text",value: "${data.wxcodeStatus}"}
        , {formName: 'wxcode', labelName: '微信Code', type: "text",value: "${data.wxcode}"}
        , {formName: 'registerDate', labelName: '成为会员时间', type: "text",value: "${data.registerDate}"}
        , {formName: 'cardValidityType', labelName: '会员卡有效期类型 会员卡有效期类型（1.永久有效 2.指定日期 3.固定天数）', type: "text",value: "${data.cardValidityType}"}
        , {formName: 'cardValidityTime', labelName: '会员卡有效期', type: "text",value: "${data.cardValidityTime}"}
        , {formName: 'name', labelName: 'name', type: "text",value: "${data.name}"}
        , {formName: 'nickname', labelName: '昵称', type: "text",value: "${data.nickname}"}
        , {formName: 'portraitUrl', labelName: '头像图片地址', type: "text",value: "${data.portraitUrl}"}
        , {formName: 'phone', labelName: '手机号', type: "text",value: "${data.phone}"}
        , {formName: 'sex', labelName: 'sex', type: "text",value: "${data.sex}"}
        , {formName: 'birthDay', labelName: '生日', type: "text",value: "${data.birthDay}"}
        , {formName: 'totalPoints', labelName: '累计积分', type: "text",value: "${data.totalPoints}"}
        , {formName: 'currentPoints', labelName: '当前积分', type: "text",value: "${data.currentPoints}"}
        , {formName: 'currentAmount', labelName: '当前余额', type: "text",value: "${data.currentAmount}"}
        , {formName: 'totalTransactionAmount', labelName: '累积交易金额', type: "text",value: "${data.totalTransactionAmount}"}
        , {formName: 'totalTransactionCount', labelName: '交易次数', type: "text",value: "${data.totalTransactionCount}"}
        , {formName: 'averageAmount', labelName: '客单价', type: "text",value: "${data.averageAmount}"}
        , {formName: 'lastTransactionTime', labelName: '上次交易时间', type: "text",value: "${data.lastTransactionTime}"}
        , {formName: 'totalCount', labelName: '总记录数', type: "text",value: "${data.totalCount}"}
        , {formName: 'createTime', labelName: '创建时间', type: "text",value: "${data.createTime}"}
        , {formName: 'updateTime', labelName: '修改时间', type: "text",value: "${data.updateTime}"}
        {
            type: "button", formName: "buttonGroup", options: [
            {btName: "保存", filterName: "save", laySubmit: true, type: "button", clickEvent: "page_save_ajax('save');"},
            {btName: "重置", btId: "reset", type: "reset"}
        ]
        }
    ];
</script>

