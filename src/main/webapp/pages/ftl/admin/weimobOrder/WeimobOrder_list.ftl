<script type="text/javascript">

    var bts = [
        {btName: "新增", clickEvent: "openPage('edit','編輯',true,2);", icon: "&#xe608;", classes: "layui-btn-sm"}
    ];
    var searchInputs = [
            , {formName: "activityType", labelName: "活动类型: 普通=0,砍价=2,拼团=3,一元购=4,送礼=5", type: "text"}
        , {formName: "isSupplierDelivery", labelName: "是否需要供货商发货(部分分销商的订单是由分销商自己发货的，这里用于区别)", type: "text"}
        , {formName: "orderId", labelName: "订单ID(自增长主键，不同店铺间有可能重复)", type: "text"}
        , {formName: "orderNo", labelName: "订单编号(订单编号，全局唯一)", type: "text"}
        , {formName: "orderSource", labelName: "订单来源(1、旺铺 2、不发货分销商 5、发货分销商 6、小程序，空值代表所有)", type: "text"}
        , {formName: "orderType", labelName: "订单类型(全部 = 0,旺铺 = 1,分销 = 2,虚拟分销 = 4,旺铺小程序 = 8)", type: "text"}
        , {formName: "orderStatus", labelName: "订单状态(0所有，1交易中,2交易成功,3交易关闭)", type: "text"}
        , {formName: "createTime", labelName: "订单创建时间(时间格式为 yyyy-mm-dd hh24:mi:ss)", type: "text"}
        , {formName: "createMan", labelName: "创建人", type: "text"}
        , {formName: "updateTime", labelName: "最近修改时间(时间格式为 yyyy-mm-dd hh24:mi:ss)", type: "text"}
        , {formName: "updateMan", labelName: "最近修改人", type: "text"}
        , {formName: "isDelete", labelName: "是否删除(订单被删除或关闭，该状态下终止一切操作)", type: "text"}
        , {formName: "discountAmount", labelName: "营销折扣金额", type: "text"}
        , {formName: "discountDetail", labelName: "营销活动明细", type: "text"}
        , {formName: "couponAmount", labelName: "优惠券金额", type: "text"}
        , {formName: "couponsNo", labelName: "优惠券号码", type: "text"}
        , {formName: "pointUse", labelName: "积分(所用积分数量)", type: "text"}
        , {formName: "pointAmount", labelName: "积分金额(积分所抵扣的金额，假设10积分=1元，100积分抵扣10元)", type: "text"}
        , {formName: "balanceAmount", labelName: "余额支付金额", type: "text"}
        , {formName: "realAmount", labelName: "实际支付费用(实际支付费用=商品金额+运费-所有折扣类金额)", type: "text"}
        , {formName: "isOnlinepay", labelName: "是否在线支付(在线支付和线下支付)", type: "text"}
        , {formName: "payStatus", labelName: "订单支付状态(0待支付，1已支付)", type: "text"}
        , {formName: "payTime", labelName: "订单支付时间(未支付时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)", type: "text"}
        , {formName: "paymentId", labelName: "payment_id", type: "text"}
        , {formName: "paymentCode", labelName: "支付方式编码", type: "text"}
        , {formName: "paymentName", labelName: "支付方式名称", type: "text"}
        , {formName: "paymentThirdno", labelName: "第三方支付单号(淘宝或微信的支付单号)", type: "text"}
        , {formName: "deliveryAmount", labelName: "运费(运费)", type: "text"}
        , {formName: "deliveryStatus", labelName: "物流状态(0待发货，1卖家发货，2买家收货，3部分发货)", type: "text"}
        , {formName: "deliveryType", labelName: "快递类型", type: "text"}
        , {formName: "carrierName", labelName: "快递公司名称", type: "text"}
        , {formName: "expressNo", labelName: "快递单号(快递单号)", type: "text"}
        , {formName: "receiverAddress", labelName: "收件人地址(省市区之间以空格分隔)", type: "text"}
        , {formName: "receiverName", labelName: "收件人姓名(发货人姓名)", type: "text"}
        , {formName: "receiverTel", labelName: "收件人联系电话(发货人联系电话)", type: "text"}
        , {formName: "senderAddress", labelName: "发货人地址(省市区之间以空格分隔)", type: "text"}
        , {formName: "senderName", labelName: "发货人姓名(发货人姓名)", type: "text"}
        , {formName: "senderTel", labelName: "发货人联系电话(发货人联系电话)", type: "text"}
        , {formName: "deliveryTime", labelName: "发货时间(未发货时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)", type: "text"}
        , {formName: "receiveTime", labelName: "确认收货时间(未确认收货时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)", type: "text"}
        , {formName: "orderFlag", labelName: "订单旗标(默认0，红色1，黄色2，绿色3，浅蓝4，深蓝5。传0进来会清除原有备注内容)", type: "text"}
        , {formName: "orderFlagMemo", labelName: "订单旗帜备注(这是旗帜备注)", type: "text"}
        , {formName: "remark", labelName: "订单备注(这是订单备注)", type: "text"}
        , {formName: "skuQty", labelName: "商品总数量(SKU数量)", type: "text"}
        , {formName: "goodsAmount", labelName: "商品金额(商品总金额(不含运费))", type: "text"}
        , {formName: "memberId", labelName: "会员编号(会员编号)", type: "text"}
        , {formName: "openId", labelName: "粉丝编号(用户在微信每公众号下的唯一标识)", type: "text"}
        , {formName: "userZtinfo", labelName: "用户自提信息JSON字符串(用户自提信息JSON字符串)", type: "text"}
        , {formName: "ztCode", labelName: "自提码,随机生成6位数字,跟订单关联,ZT系统可用于查询订单,核销订单", type: "text"}
        , {formName: "ztQrcode", labelName: "扫二维码到订单核销自提", type: "text"}
        , {formName: "ztShopsetid", labelName: "自提点Id,下单的时候就要确定到哪里提货", type: "text"}
        , {formName: "hxStatus", labelName: "自提订单的核销状态,0未核销,1已核销", type: "text"}
        , {formName: "hxBy", labelName: "核销点,旺铺核销 或者自提点名称", type: "text"}
        , {formName: "distributionTimetype", labelName: "下单时选择商家配送时间类型: 0=工作日x双休日或节假日均可送货,1=只工作日送货,2=只双休日x节假日送货,", type: "text"}
        , {formName: "mechantDeliverytime", labelName: "商家配送时,用户选择的配送时间,用于展示", type: "text"}
        , {formName: "distributionType", labelName: "配送类型（商家配送 = 1,到店自提 = 2，同城限时达 = 4）", type: "text"}
        , {formName: "ptStatus", labelName: "拼团状态（全部 = 0,开团中 = 1, 开团成功 = 2,开团失败 = 3,拼团成功 = 4,拼团失败 = 5, 拼团失败财务退款中 = 6", type: "text"}
        , {formName: "packs", labelName: "包裹行明细", type: "text"}
        , {formName: "paymentDetails", labelName: "支付单号详情，当支付方式为众筹或订单类型为夺宝时，会出现多个支付单号", type: "text"}
        , {formName: "fansInfo", labelName: "粉丝信息(用户在微信的相关信息)", type: "text"}
        , {formName: "distributionInfo", labelName: "distribution_info", type: "text"}
        , {formName: "receiverRegion", labelName: "收件人地址", type: "text"}
        , {formName: "orderDetails", labelName: "订单行明细", type: "text"}
    ];
    var columns = [
        {title: 'ID', field: 'id', width: 1}
        , {field: 'isSupplierDelivery', title: '是否需要供货商发货(部分分销商的订单是由分销商自己发货的，这里用于区别)', width: 1}
        , {field: 'orderId', title: '订单ID(自增长主键，不同店铺间有可能重复)', width: 1}
        , {field: 'orderNo', title: '订单编号(订单编号，全局唯一)', width: 1}
        , {field: 'orderSource', title: '订单来源(1、旺铺 2、不发货分销商 5、发货分销商 6、小程序，空值代表所有)', width: 1}
        , {field: 'orderType', title: '订单类型(全部 = 0,旺铺 = 1,分销 = 2,虚拟分销 = 4,旺铺小程序 = 8)', width: 1}
        , {field: 'orderStatus', title: '订单状态(0所有，1交易中,2交易成功,3交易关闭)', width: 1}
        , {field: 'createTime', title: '订单创建时间(时间格式为 yyyy-mm-dd hh24:mi:ss)', width: 1}
        , {field: 'createMan', title: '创建人', width: 1}
        , {field: 'updateTime', title: '最近修改时间(时间格式为 yyyy-mm-dd hh24:mi:ss)', width: 1}
        , {field: 'updateMan', title: '最近修改人', width: 1}
        , {field: 'isDelete', title: '是否删除(订单被删除或关闭，该状态下终止一切操作)', width: 1}
        , {field: 'discountAmount', title: '营销折扣金额', width: 1}
        , {field: 'discountDetail', title: '营销活动明细', width: 1}
        , {field: 'couponAmount', title: '优惠券金额', width: 1}
        , {field: 'couponsNo', title: '优惠券号码', width: 1}
        , {field: 'pointUse', title: '积分(所用积分数量)', width: 1}
        , {field: 'pointAmount', title: '积分金额(积分所抵扣的金额，假设10积分=1元，100积分抵扣10元)', width: 1}
        , {field: 'balanceAmount', title: '余额支付金额', width: 1}
        , {field: 'realAmount', title: '实际支付费用(实际支付费用=商品金额+运费-所有折扣类金额)', width: 1}
        , {field: 'isOnlinepay', title: '是否在线支付(在线支付和线下支付)', width: 1}
        , {field: 'payStatus', title: '订单支付状态(0待支付，1已支付)', width: 1}
        , {field: 'payTime', title: '订单支付时间(未支付时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)', width: 1}
        , {field: 'paymentId', title: 'payment_id', width: 1}
        , {field: 'paymentCode', title: '支付方式编码', width: 1}
        , {field: 'paymentName', title: '支付方式名称', width: 1}
        , {field: 'paymentThirdno', title: '第三方支付单号(淘宝或微信的支付单号)', width: 1}
        , {field: 'deliveryAmount', title: '运费(运费)', width: 1}
        , {field: 'deliveryStatus', title: '物流状态(0待发货，1卖家发货，2买家收货，3部分发货)', width: 1}
        , {field: 'deliveryType', title: '快递类型', width: 1}
        , {field: 'carrierName', title: '快递公司名称', width: 1}
        , {field: 'expressNo', title: '快递单号(快递单号)', width: 1}
        , {field: 'receiverAddress', title: '收件人地址(省市区之间以空格分隔)', width: 1}
        , {field: 'receiverName', title: '收件人姓名(发货人姓名)', width: 1}
        , {field: 'receiverTel', title: '收件人联系电话(发货人联系电话)', width: 1}
        , {field: 'senderAddress', title: '发货人地址(省市区之间以空格分隔)', width: 1}
        , {field: 'senderName', title: '发货人姓名(发货人姓名)', width: 1}
        , {field: 'senderTel', title: '发货人联系电话(发货人联系电话)', width: 1}
        , {field: 'deliveryTime', title: '发货时间(未发货时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)', width: 1}
        , {field: 'receiveTime', title: '确认收货时间(未确认收货时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)', width: 1}
        , {field: 'orderFlag', title: '订单旗标(默认0，红色1，黄色2，绿色3，浅蓝4，深蓝5。传0进来会清除原有备注内容)', width: 1}
        , {field: 'orderFlagMemo', title: '订单旗帜备注(这是旗帜备注)', width: 1}
        , {field: 'remark', title: '订单备注(这是订单备注)', width: 1}
        , {field: 'skuQty', title: '商品总数量(SKU数量)', width: 1}
        , {field: 'goodsAmount', title: '商品金额(商品总金额(不含运费))', width: 1}
        , {field: 'memberId', title: '会员编号(会员编号)', width: 1}
        , {field: 'openId', title: '粉丝编号(用户在微信每公众号下的唯一标识)', width: 1}
        , {field: 'userZtinfo', title: '用户自提信息JSON字符串(用户自提信息JSON字符串)', width: 1}
        , {field: 'ztCode', title: '自提码,随机生成6位数字,跟订单关联,ZT系统可用于查询订单,核销订单', width: 1}
        , {field: 'ztQrcode', title: '扫二维码到订单核销自提', width: 1}
        , {field: 'ztShopsetid', title: '自提点Id,下单的时候就要确定到哪里提货', width: 1}
        , {field: 'hxStatus', title: '自提订单的核销状态,0未核销,1已核销', width: 1}
        , {field: 'hxBy', title: '核销点,旺铺核销 或者自提点名称', width: 1}
        , {field: 'distributionTimetype', title: '下单时选择商家配送时间类型: 0=工作日x双休日或节假日均可送货,1=只工作日送货,2=只双休日x节假日送货,', width: 1}
        , {field: 'mechantDeliverytime', title: '商家配送时,用户选择的配送时间,用于展示', width: 1}
        , {field: 'distributionType', title: '配送类型（商家配送 = 1,到店自提 = 2，同城限时达 = 4）', width: 1}
        , {field: 'ptStatus', title: '拼团状态（全部 = 0,开团中 = 1, 开团成功 = 2,开团失败 = 3,拼团成功 = 4,拼团失败 = 5, 拼团失败财务退款中 = 6', width: 1}
        , {field: 'packs', title: '包裹行明细', width: 1}
        , {field: 'paymentDetails', title: '支付单号详情，当支付方式为众筹或订单类型为夺宝时，会出现多个支付单号', width: 1}
        , {field: 'fansInfo', title: '粉丝信息(用户在微信的相关信息)', width: 1}
        , {field: 'distributionInfo', title: 'distribution_info', width: 1}
        , {field: 'receiverRegion', title: '收件人地址', width: 1}
        , {field: 'orderDetails', title: '订单行明细', width: 1}
        , {field: 'op', title: '操作', align: 'center', width: 1}
    ]
</script>
