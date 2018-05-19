<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="navTree">
            <li class="layui-nav-item">
                <a href="${rct.contextPath}/admin/main" class="layui-nav-parent-a">首页</a>
            </li>
            <li class="layui-nav-item">
                <a href="${rct.contextPath}/admin/order/list" class="layui-nav-parent-a">pc端订单</a>
            </li>
            <li class="layui-nav-item">
                <a href="${rct.contextPath}/admin/orderDetail/list" class="layui-nav-parent-a">pc端订单详情</a>
            </li>
            <li class="layui-nav-item">
                <a href="${rct.contextPath}/admin/weimobUserRelation/list" class="layui-nav-parent-a">用户关系列表</a>
            </li>
            <li class="layui-nav-item">
                <a href="${rct.contextPath}/admin/initToken/list" class="layui-nav-parent-a">token管理</a>
            </li>
            <li class="layui-nav-item">
                <a href="${rct.contextPath}/admin/qrtzConsole/list" class="layui-nav-parent-a">定时任务管理</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;" class="layui-nav-parent-a">系统管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${rct.contextPath}/admin/resource/list">资源列表</a></dd>
                    <dd><a href="${rct.contextPath}/admin/adminUser/list">系统用戶管理</a></dd>
                    <dd><a href="${rct.contextPath}/admin/role/list">角色管理</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript">
    layui.use(['element','jquery'],function(){
        var uri = window.location.pathname,$=layui.jquery;
        $.each($('ul.layui-nav-tree').find('a'),function(){
            if($(this).attr('href')===uri)
            {
                if(!$(this).hasClass('layui-nav-parent-a'))
                {
                    $(this).parent().addClass('layui-this');
                    $(this).parents('li.layui-nav-item').addClass('layui-nav-itemed');
                }else
                {
                    $(this).parent().addClass('layui-this');
                }
                return ;
            }
        });
    });
</script>
