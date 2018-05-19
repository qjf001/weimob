<script type="text/javascript">

    var bts = [
        {btName: "新增", clickEvent: "openPage('edit','編輯',true,2);", icon: "&#xe608;", classes: "layui-btn-sm"}
    ];
    var searchInputs = [
            , {formName: "openid", labelName: "微信openid", type: "text"}
        , {formName: "weimobOpenid", labelName: "微盟openid", type: "text"}
        , {formName: "customerNo", labelName: "客户编号", type: "text"}
        , {formName: "qrcodeUrl", labelName: "二维码地址", type: "text"}
        , {formName: "barcodeUrl", labelName: "条形码地址", type: "text"}
        , {formName: "tags", labelName: "标签对象", type: "text"}
        , {formName: "isFans", labelName: "是否是粉丝", type: "text"}
        , {formName: "customerType", labelName: "客户类型", type: "text"}
        , {formName: "levelname", labelName: "类型名称", type: "text"}
        , {formName: "menbercardId", labelName: "会员卡号", type: "text"}
        , {formName: "currentGrowthValue", labelName: "成长值", type: "text"}
        , {formName: "wxcodeStatus", labelName: "微信会员卡状态((0:未领卡 1:已领卡 2:已激活)", type: "text"}
        , {formName: "wxcode", labelName: "微信Code", type: "text"}
        , {formName: "registerDate", labelName: "成为会员时间", type: "text"}
        , {formName: "cardValidityType", labelName: "会员卡有效期类型 会员卡有效期类型（1.永久有效 2.指定日期 3.固定天数）", type: "text"}
        , {formName: "cardValidityTime", labelName: "会员卡有效期", type: "text"}
        , {formName: "name", labelName: "name", type: "text"}
        , {formName: "nickname", labelName: "昵称", type: "text"}
        , {formName: "portraitUrl", labelName: "头像图片地址", type: "text"}
        , {formName: "phone", labelName: "手机号", type: "text"}
        , {formName: "sex", labelName: "sex", type: "text"}
        , {formName: "birthDay", labelName: "生日", type: "text"}
        , {formName: "totalPoints", labelName: "累计积分", type: "text"}
        , {formName: "currentPoints", labelName: "当前积分", type: "text"}
        , {formName: "currentAmount", labelName: "当前余额", type: "text"}
        , {formName: "totalTransactionAmount", labelName: "累积交易金额", type: "text"}
        , {formName: "totalTransactionCount", labelName: "交易次数", type: "text"}
        , {formName: "averageAmount", labelName: "客单价", type: "text"}
        , {formName: "lastTransactionTime", labelName: "上次交易时间", type: "text"}
        , {formName: "totalCount", labelName: "总记录数", type: "text"}
        , {formName: "createTime", labelName: "创建时间", type: "text"}
        , {formName: "updateTime", labelName: "修改时间", type: "text"}
    ];
    var columns = [
        {title: 'ID', field: 'id', width: 1}
        , {field: 'weimobOpenid', title: '微盟openid', width: 1}
        , {field: 'customerNo', title: '客户编号', width: 1}
        , {field: 'qrcodeUrl', title: '二维码地址', width: 1}
        , {field: 'barcodeUrl', title: '条形码地址', width: 1}
        , {field: 'tags', title: '标签对象', width: 1}
        , {field: 'isFans', title: '是否是粉丝', width: 1}
        , {field: 'customerType', title: '客户类型', width: 1}
        , {field: 'levelname', title: '类型名称', width: 1}
        , {field: 'menbercardId', title: '会员卡号', width: 1}
        , {field: 'currentGrowthValue', title: '成长值', width: 1}
        , {field: 'wxcodeStatus', title: '微信会员卡状态((0:未领卡 1:已领卡 2:已激活)', width: 1}
        , {field: 'wxcode', title: '微信Code', width: 1}
        , {field: 'registerDate', title: '成为会员时间', width: 1}
        , {field: 'cardValidityType', title: '会员卡有效期类型 会员卡有效期类型（1.永久有效 2.指定日期 3.固定天数）', width: 1}
        , {field: 'cardValidityTime', title: '会员卡有效期', width: 1}
        , {field: 'name', title: 'name', width: 1}
        , {field: 'nickname', title: '昵称', width: 1}
        , {field: 'portraitUrl', title: '头像图片地址', width: 1}
        , {field: 'phone', title: '手机号', width: 1}
        , {field: 'sex', title: 'sex', width: 1}
        , {field: 'birthDay', title: '生日', width: 1}
        , {field: 'totalPoints', title: '累计积分', width: 1}
        , {field: 'currentPoints', title: '当前积分', width: 1}
        , {field: 'currentAmount', title: '当前余额', width: 1}
        , {field: 'totalTransactionAmount', title: '累积交易金额', width: 1}
        , {field: 'totalTransactionCount', title: '交易次数', width: 1}
        , {field: 'averageAmount', title: '客单价', width: 1}
        , {field: 'lastTransactionTime', title: '上次交易时间', width: 1}
        , {field: 'totalCount', title: '总记录数', width: 1}
        , {field: 'createTime', title: '创建时间', width: 1}
        , {field: 'updateTime', title: '修改时间', width: 1}
        , {field: 'op', title: '操作', align: 'center', width: 1}
    ]
</script>
