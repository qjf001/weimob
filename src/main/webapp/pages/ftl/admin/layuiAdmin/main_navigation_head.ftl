<div class="layui-header header header-demo">
    <div class="layui-main">
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav" lay-filter="demo">
               <li class="layui-nav-item " >
                   <a href="javascript:;"><i class="layui-icon">&#xe612;</i>${Session["user"].nickName?default("管理员")}</a>
                   <dl class="layui-nav-child">
                       <dd><a href="javascript:void(0);" onclick="changePwd();" style="text-align: left;">修改密码</a></dd>
                       <dd><a href="javascript:void(0);" onclick="logout();" style="text-align: left;">登出系统</a></dd>
                   </dl>
               </li>
        </ul>
    </div>
</div>