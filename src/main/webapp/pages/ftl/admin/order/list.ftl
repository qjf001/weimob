<script type="text/javascript">
    var bts = [
        {btName: "上传文件", id:"upload", icon: "&#xe67c;", classes: "layui-btn-sm"}
    ];
    var searchInputs = [
        /*{formName: "id", labelName: "订单编号", type: "text"}
        , {formName: "payTime", labelName: "结算时间", type: "text"}
        , {formName: "memberAccount", labelName: "会员账号", type: "text"}
        , {formName: "memberName", labelName: "会员姓名", type: "text"}
        , {formName: "orderStatus", labelName: "订单状态", type: "text"}
        , {formName: "name", labelName: "姓名", type: "text"}
        , {formName: "address", labelName: "地址", type: "text"}
        , {formName: "mobile", labelName: "手机", type: "text"}
        , {formName: "zipCode", labelName: "邮编", type: "text"}
        , {formName: "distribution", labelName: "配送方式", type: "text"}
        , {formName: "payWay", labelName: "支付方式", type: "text"}*/
    ];
    var columns = [
        {field: 'id', title: '订单编号', width: 1}
        ,{field: 'memberAccount', title: '会员账号', width: 1}
        , {field: 'memberName', title: '会员姓名', width: 1}
        , {field: 'orderAmount', title: '订单金额', width: 1}
        , {field: 'orderStatus', title: '订单状态', width: 1}
        , {field: 'name', title: '姓名', width: 1}
        , {field: 'address', title: '地址', width: 1}
        , {field: 'mobile', title: '手机', width: 1}
        , {field: 'distribution', title: '配送方式', width: 1}
        , {field: 'distributionPrice', title: '配送价格', width: 1}
        , {field: 'payWay', title: '支付方式', width: 1}
        , {field: 'op', title: '操作', align: 'center', width: 1}
    ]
    var pageReadyCallBack = function(){
        layui.use([ 'upload'], function () {
            layui.upload.render({
                elem: '#upload'
                , url: '/admin/order/upload'
                , auto: true //是否选完文件后自动上传。如果设定 false，那么需要设置 bindAction 参数来指向一个其它按钮提交上传
                , accept: "file"
                , field: 'file'
                , acceptMime:"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"
                , size: 2000 // 设置文件最大可允许上传的大小，单位 KB。不支持ie8/9 ，0（即不限制）
                , done: function (res, index, upload) { //执行上传请求后的回调。返回三个参数，分别为：res（服务端响应信息）、index（当前文件的索引）、upload（重新上传的方法，一般在文件上传失败后使用）
                    if(res.action==="success"){
                        refreshTabel();
                        layui.layer.alert("文件上传成功");
                    }
                    else
                        layui.layer.alert(res.msg);
                }
            });
        });
    }
</script>
