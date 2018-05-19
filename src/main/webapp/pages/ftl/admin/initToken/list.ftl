<script type="text/javascript">
    var bts = [
        {btName: "初始化Token", clickEvent: "initToken();", icon: "&#xe608;" ,classes:"layui-btn-sm"}
    ];
    var columns = [
        {field: 'access_token', title: 'access_token', width: 7} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
        ,{field: 'expires_in_str', title: 'access_token有效时长', sort: true, width: 3}
        ,{field: 'refresh_token', title: 'refresh_token', sort: true, width: 7}
        ,{field: 'refresh_token_expires_str', title: 'refresh_token有效时长', sort: true, width: 3}
        ,{field: 'business_id', title: 'business_id', sort: true, width: 3}
        ,{field: 'public_account_id', title: 'public_account_id', sort: true, width: 3}
        ,{field: 'createtime', title: '更新时间', sort: true, align: 'right', width: 3}
    ]
    function initToken(){
        layer.prompt({
            formType: 2,
            value: '',
            title: '請輸入code',
            area: ['400px', '200px'] //自定义文本域宽高
        }, function (value, index, elem) {
            layer.close(index);
            $.post({
                url: "/admin/initToken/init",
                data: {"code": value.trim()},
                dataType: "json",
                success: function (data) {
                    if (data.action === 'success') {
                        auto_initDataGrid(window.parent.urlStr,window.parent._pageNum);
                        layui.layer.alert("操作成功", {icon: 1, title: '提示',closeBtn: 0}, function (index) {
                            layui.layer.closeAll();
                        });
                    }
                    else {
                        layer.alert("操作失敗");
                    }
                }
            });
        });
    }
</script>
