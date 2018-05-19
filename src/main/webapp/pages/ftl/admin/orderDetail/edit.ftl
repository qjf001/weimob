<script type="text/javascript">

    var formRows = [
        {type: "hidden", formName: "id", formId: "id", value: "${data.id}"}
        , {formName: 'orderSn', labelName: '订单编号', type: "text",value: "${data.orderSn}"}
        , {formName: 'productName', labelName: '产品名称', type: "text",value: "${data.productName}"}
        , {formName: 'productCate', labelName: '产品分类', type: "text",value: "${data.productCate}"}
        , {formName: 'shoppingOption', labelName: '购物选项', type: "text",value: "${data.shoppingOption}"}
        , {formName: 'price', labelName: '单价', type: "text",value: "${data.price}"}
        , {formName: 'num', labelName: '数量', type: "text",value: "${data.num}"}
        , {formName: 'subtotal', labelName: 'subtotal', type: "text",value: "${data.subtotal}"}
        , {formName: 'memberAccount', labelName: '会员账号', type: "text",value: "${data.memberAccount}"}
        , {formName: 'leaveMessage', labelName: '买家留言', type: "textarea",value: "${data.leaveMessage}"}
        , {formName: 'name', labelName: '姓名', type: "text",value: "${data.name}"}
        , {formName: 'address', labelName: '地址', type: "text",value: "${data.address}"}
        , {formName: 'mobile', labelName: '手机', type: "text",value: "${data.mobile}"}
        , {formName: 'zipCode', labelName: '邮编', type: "text",value: "${data.zipCode}"}
        , {formName: 'distribution', labelName: '配送方式', type: "text",value: "${data.distribution}"}
        , {formName: 'distributionPrice', labelName: '配送价格', type: "text",value: "${data.distributionPrice}"}
        , {formName: 'payWay', labelName: '支付方式', type: "text",value: "${data.payWay}"}
        , {formName: 'orderMemo', labelName: '订单留备注', type: "textarea",value: "${data.orderMemo}"}
        ,{
            type: "button", formName: "buttonGroup", options: [
            {btName: "保存", filterName: "save", laySubmit: true, type: "button", clickEvent: "page_save_ajax('save');"},
            {btName: "重置", btId: "reset", type: "reset"}
        ]
        }
    ];
</script>

