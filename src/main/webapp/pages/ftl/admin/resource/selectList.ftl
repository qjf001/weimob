<script>
    var urlStr ="/admin/resource/selectListData" ,title = "資源列表" ,pageSize=1000 ; hasCheckbox=true ,hasPager=false;
    var bts = [];
    var searchInputs = [
        {  labelName:"資源名稱",formName:"name",    type:"text" } ,
        {  labelName:"url",formName:"url",    type:"text" }
    ];
    var columns =[
        {title: 'ID', field: 'id', width: 4, align: 'center'},
        {title: '名稱', field: 'name', width: 10, align: 'left'},
        {title: 'url', field: 'url', width: 30, align: 'left'}
    ];
    var childClick = function(obj){
        var $=layui.jquery;var action ;
        if($(obj).hasClass('layui-form-checked')){
            action = "delete";
        }
        else{
            action = "add";
        }

        $.post({
            url:"/admin/role/updateRoleResource",
            data:{"roleId":"${roleId}","resourceId":obj.attr("data-id"),"action":action},
            dataType:"json",
            success:function(data){
                if(data.action==="success"){
                    auto_initDataGrid(window.urlStr, 1);
                   /* if(action==="delete"){
                        $(obj).removeClass('layui-form-checked');
                    }
                    if(action==="add"){
                        $(obj).addClass('layui-form-checked');
                    }*/
                }
                else{
                    layui.layer.alert("操作失敗",{icon:5});
                }
            }
        });
    }

    layui.use(['layer','laytpl', 'element','jquery','form','laypage','laydate'], function(){
        $(function(){
            $('.layui-form-item .layui-inline').css("margin-right","0");
        });
    });

    var pageReadyCallBack  = function(){
        var resourceIds = ","+getRoleResourceId()+",";
        console.log(resourceIds);
        var checkBoxTh = $('table.layui-table thead th:first');
        checkBoxTh.html("");
        checkBoxTh.attr("style","width:5%");
        var allCBTr = $('table.layui-table tbody tr');
        $.each(allCBTr,function() {
            var ckDiv = $($(this).find('td:first div.layui-form-checkbox:first')[0]);
            ckDiv.attr("style", "margin-left:20px");
            var ckDataId = ","+ckDiv.attr("data-id")+",";
            if (resourceIds.indexOf(ckDataId) >= 0) {
                ckDiv.addClass('layui-form-checked');
            }
        });
    }
    var getRoleResourceId = function(){
        var resourceIds = "";
        $.get({
            url:"getRoleResourceId?id=${roleId}",
            async:false,
            cache:false,
            dataType:"json",
            success:function(data){
                resourceIds = data.roleResourceIds;
            }
        });
        return resourceIds;
    }
</script>