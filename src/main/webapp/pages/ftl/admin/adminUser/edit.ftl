 <script type="text/javascript">

     var formRows = [
         [
             {type:"hidden",formName:"id",labelName:"",value:"${data.id}"}
         ],
         {type:"text",formName:"name",labelName:"登登录账号",layVerify:'required',value:"${data.name}"},
         {type:"text",formName:"nickName",labelName:"昵称",value:"${data.nickName}"},
         {type:"text",formName:"mobile",labelName:"手机",value:"${data.mobile}"},
         {type:"text",formName:"email",labelName:"Email",layVerify:'email',value:"${data.email}"},
         {type:"select",formName:"roleId",labelName:"角色",value:"${ur.adminRoleId}",options:${roles}},
         {type:"button",formName:"buttonGroup", options:[
             {btName:"保存",filterName:"save",laySubmit:true,type:"button",clickEvent:"page_save_ajax('save');"},
             {btName:"重置",btId:"reset",type:"reset"}
         ]}
     ];
</script>

