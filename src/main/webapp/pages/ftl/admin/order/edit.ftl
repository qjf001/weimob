<script type="text/javascript">

    var formRows = [
        {formName: 'id', labelName: '订单编号', type: "text",value: "${data.id}"}
        , {formName: 'memberAccount', labelName: '会员账号', type: "text",value: "${data.memberAccount}"}
        , {formName: 'memberName', labelName: '会员姓名', type: "text",value: "${data.memberName}"}
        , {formName: 'orderAmount', labelName: '订单金额', type: "text",value: "${data.orderAmount}"}
        , {formName: 'orderStatus', labelName: '订单状态', type: "text",value: "${data.orderStatus}"}
        , {formName: 'leaveMessage', labelName: 'leaveMessage', type: "textarea",value: "${data.leaveMessage}"}
        , {formName: 'name', labelName: '姓名', type: "text",value: "${data.name}"}
        , {formName: 'address', labelName: '地址', type: "text",value: "${data.address}"}
        , {formName: 'mobile', labelName: '手机', type: "text",value: "${data.mobile}"}
        , {formName: 'zipCode', labelName: '邮编', type: "text",value: "${data.zipCode}"}
        , {formName: 'distribution', labelName: '配送方式', type: "text",value: "${data.distribution}"}
        , {formName: 'distributionPrice', labelName: 'distributionPrice', type: "text",value: "${data.distributionPrice}"}
        , {formName: 'payWay', labelName: '支付方式', type: "text",value: "${data.payWay}"}
        , {formName: 'orderMemo', labelName: 'orderMemo', type: "textarea",value: "${data.orderMemo}"}
        ,{
            type: "button", formName: "buttonGroup", options: [
            {btName: "保存", filterName: "save", laySubmit: true, type: "button", clickEvent: "page_save_ajax('save');"},
            {btName: "重置", btId: "reset", type: "reset"}
        ]
        }
    ];
</script>

