<script type="text/javascript">

    var formRows = [
        {type: "hidden", formName: "id", formId: "id", value: "${data.id}"}
        , {formName: 'isSupplierDelivery', labelName: '是否需要供货商发货(部分分销商的订单是由分销商自己发货的，这里用于区别)', type: "text",value: "${data.isSupplierDelivery}"}
        , {formName: 'orderId', labelName: '订单ID(自增长主键，不同店铺间有可能重复)', type: "text",value: "${data.orderId}"}
        , {formName: 'orderNo', labelName: '订单编号(订单编号，全局唯一)', type: "text",value: "${data.orderNo}"}
        , {formName: 'orderSource', labelName: '订单来源(1、旺铺 2、不发货分销商 5、发货分销商 6、小程序，空值代表所有)', type: "text",value: "${data.orderSource}"}
        , {formName: 'orderType', labelName: '订单类型(全部 = 0,旺铺 = 1,分销 = 2,虚拟分销 = 4,旺铺小程序 = 8)', type: "text",value: "${data.orderType}"}
        , {formName: 'orderStatus', labelName: '订单状态(0所有，1交易中,2交易成功,3交易关闭)', type: "text",value: "${data.orderStatus}"}
        , {formName: 'createTime', labelName: '订单创建时间(时间格式为 yyyy-mm-dd hh24:mi:ss)', type: "text",value: "${data.createTime}"}
        , {formName: 'createMan', labelName: '创建人', type: "text",value: "${data.createMan}"}
        , {formName: 'updateTime', labelName: '最近修改时间(时间格式为 yyyy-mm-dd hh24:mi:ss)', type: "text",value: "${data.updateTime}"}
        , {formName: 'updateMan', labelName: '最近修改人', type: "text",value: "${data.updateMan}"}
        , {formName: 'isDelete', labelName: '是否删除(订单被删除或关闭，该状态下终止一切操作)', type: "text",value: "${data.isDelete}"}
        , {formName: 'discountAmount', labelName: '营销折扣金额', type: "text",value: "${data.discountAmount}"}
        , {formName: 'discountDetail', labelName: '营销活动明细', type: "text",value: "${data.discountDetail}"}
        , {formName: 'couponAmount', labelName: '优惠券金额', type: "text",value: "${data.couponAmount}"}
        , {formName: 'couponsNo', labelName: '优惠券号码', type: "text",value: "${data.couponsNo}"}
        , {formName: 'pointUse', labelName: '积分(所用积分数量)', type: "text",value: "${data.pointUse}"}
        , {formName: 'pointAmount', labelName: '积分金额(积分所抵扣的金额，假设10积分=1元，100积分抵扣10元)', type: "text",value: "${data.pointAmount}"}
        , {formName: 'balanceAmount', labelName: '余额支付金额', type: "text",value: "${data.balanceAmount}"}
        , {formName: 'realAmount', labelName: '实际支付费用(实际支付费用=商品金额+运费-所有折扣类金额)', type: "text",value: "${data.realAmount}"}
        , {formName: 'isOnlinepay', labelName: '是否在线支付(在线支付和线下支付)', type: "text",value: "${data.isOnlinepay}"}
        , {formName: 'payStatus', labelName: '订单支付状态(0待支付，1已支付)', type: "text",value: "${data.payStatus}"}
        , {formName: 'payTime', labelName: '订单支付时间(未支付时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)', type: "text",value: "${data.payTime}"}
        , {formName: 'paymentId', labelName: 'payment_id', type: "text",value: "${data.paymentId}"}
        , {formName: 'paymentCode', labelName: '支付方式编码', type: "text",value: "${data.paymentCode}"}
        , {formName: 'paymentName', labelName: '支付方式名称', type: "text",value: "${data.paymentName}"}
        , {formName: 'paymentThirdno', labelName: '第三方支付单号(淘宝或微信的支付单号)', type: "text",value: "${data.paymentThirdno}"}
        , {formName: 'deliveryAmount', labelName: '运费(运费)', type: "text",value: "${data.deliveryAmount}"}
        , {formName: 'deliveryStatus', labelName: '物流状态(0待发货，1卖家发货，2买家收货，3部分发货)', type: "text",value: "${data.deliveryStatus}"}
        , {formName: 'deliveryType', labelName: '快递类型', type: "text",value: "${data.deliveryType}"}
        , {formName: 'carrierName', labelName: '快递公司名称', type: "text",value: "${data.carrierName}"}
        , {formName: 'expressNo', labelName: '快递单号(快递单号)', type: "text",value: "${data.expressNo}"}
        , {formName: 'receiverAddress', labelName: '收件人地址(省市区之间以空格分隔)', type: "text",value: "${data.receiverAddress}"}
        , {formName: 'receiverName', labelName: '收件人姓名(发货人姓名)', type: "text",value: "${data.receiverName}"}
        , {formName: 'receiverTel', labelName: '收件人联系电话(发货人联系电话)', type: "text",value: "${data.receiverTel}"}
        , {formName: 'senderAddress', labelName: '发货人地址(省市区之间以空格分隔)', type: "text",value: "${data.senderAddress}"}
        , {formName: 'senderName', labelName: '发货人姓名(发货人姓名)', type: "text",value: "${data.senderName}"}
        , {formName: 'senderTel', labelName: '发货人联系电话(发货人联系电话)', type: "text",value: "${data.senderTel}"}
        , {formName: 'deliveryTime', labelName: '发货时间(未发货时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)', type: "text",value: "${data.deliveryTime}"}
        , {formName: 'receiveTime', labelName: '确认收货时间(未确认收货时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)', type: "text",value: "${data.receiveTime}"}
        , {formName: 'orderFlag', labelName: '订单旗标(默认0，红色1，黄色2，绿色3，浅蓝4，深蓝5。传0进来会清除原有备注内容)', type: "text",value: "${data.orderFlag}"}
        , {formName: 'orderFlagMemo', labelName: '订单旗帜备注(这是旗帜备注)', type: "text",value: "${data.orderFlagMemo}"}
        , {formName: 'remark', labelName: '订单备注(这是订单备注)', type: "text",value: "${data.remark}"}
        , {formName: 'skuQty', labelName: '商品总数量(SKU数量)', type: "text",value: "${data.skuQty}"}
        , {formName: 'goodsAmount', labelName: '商品金额(商品总金额(不含运费))', type: "text",value: "${data.goodsAmount}"}
        , {formName: 'memberId', labelName: '会员编号(会员编号)', type: "text",value: "${data.memberId}"}
        , {formName: 'openId', labelName: '粉丝编号(用户在微信每公众号下的唯一标识)', type: "text",value: "${data.openId}"}
        , {formName: 'userZtinfo', labelName: '用户自提信息JSON字符串(用户自提信息JSON字符串)', type: "text",value: "${data.userZtinfo}"}
        , {formName: 'ztCode', labelName: '自提码,随机生成6位数字,跟订单关联,ZT系统可用于查询订单,核销订单', type: "text",value: "${data.ztCode}"}
        , {formName: 'ztQrcode', labelName: '扫二维码到订单核销自提', type: "text",value: "${data.ztQrcode}"}
        , {formName: 'ztShopsetid', labelName: '自提点Id,下单的时候就要确定到哪里提货', type: "text",value: "${data.ztShopsetid}"}
        , {formName: 'hxStatus', labelName: '自提订单的核销状态,0未核销,1已核销', type: "text",value: "${data.hxStatus}"}
        , {formName: 'hxBy', labelName: '核销点,旺铺核销 或者自提点名称', type: "text",value: "${data.hxBy}"}
        , {formName: 'distributionTimetype', labelName: '下单时选择商家配送时间类型: 0=工作日x双休日或节假日均可送货,1=只工作日送货,2=只双休日x节假日送货,', type: "text",value: "${data.distributionTimetype}"}
        , {formName: 'mechantDeliverytime', labelName: '商家配送时,用户选择的配送时间,用于展示', type: "text",value: "${data.mechantDeliverytime}"}
        , {formName: 'distributionType', labelName: '配送类型（商家配送 = 1,到店自提 = 2，同城限时达 = 4）', type: "text",value: "${data.distributionType}"}
        , {formName: 'ptStatus', labelName: '拼团状态（全部 = 0,开团中 = 1, 开团成功 = 2,开团失败 = 3,拼团成功 = 4,拼团失败 = 5, 拼团失败财务退款中 = 6', type: "text",value: "${data.ptStatus}"}
        , {formName: 'packs', labelName: '包裹行明细', type: "text",value: "${data.packs}"}
        , {formName: 'paymentDetails', labelName: '支付单号详情，当支付方式为众筹或订单类型为夺宝时，会出现多个支付单号', type: "text",value: "${data.paymentDetails}"}
        , {formName: 'fansInfo', labelName: '粉丝信息(用户在微信的相关信息)', type: "text",value: "${data.fansInfo}"}
        , {formName: 'distributionInfo', labelName: 'distribution_info', type: "text",value: "${data.distributionInfo}"}
        , {formName: 'receiverRegion', labelName: '收件人地址', type: "text",value: "${data.receiverRegion}"}
        , {formName: 'orderDetails', labelName: '订单行明细', type: "text",value: "${data.orderDetails}"}
        {
            type: "button", formName: "buttonGroup", options: [
            {btName: "保存", filterName: "save", laySubmit: true, type: "button", clickEvent: "page_save_ajax('save');"},
            {btName: "重置", btId: "reset", type: "reset"}
        ]
        }
    ];
</script>

