USE [weimob]
GO

/****** Object:  Table [dbo].[t_weimob_user_relation]    Script Date: 04/11/2018 22:18:09 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[t_weimob_user_relation](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[nickname] [nvarchar](255) NULL,
	[nickname_openid] [nvarchar](255) NULL,
	[source_nickname] [nvarchar](255) NULL,
	[source_openid] [nvarchar](255) NULL,
 CONSTRAINT [PK_t_weimob_user_relation] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'昵称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_weimob_user_relation', @level2type=N'COLUMN',@level2name=N'nickname'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'昵称的openid' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_weimob_user_relation', @level2type=N'COLUMN',@level2name=N'nickname_openid'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'关注来源的昵称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_weimob_user_relation', @level2type=N'COLUMN',@level2name=N'source_nickname'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'关注来源的openid' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_weimob_user_relation', @level2type=N'COLUMN',@level2name=N'source_openid'
GO


/****** Object:  Table [dbo].[t_admin_role_resource]    Script Date: 04/11/2018 22:22:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
DROP TABLE [dbo].[t_admin_role_resource]
GO
CREATE TABLE [dbo].[t_admin_role_resource](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[admin_role_id] [bigint] NULL,
	[admin_resource_id] [bigint] NULL,
 CONSTRAINT [PK_t_admin_role_resource_id] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [t_admin_role_resource$index_unique_] UNIQUE NONCLUSTERED
(
	[admin_role_id] ASC,
	[admin_resource_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'demo.t_admin_role_resource' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_admin_role_resource'
GO
SET IDENTITY_INSERT [dbo].[t_admin_role_resource] ON
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (14, 1, 1)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (26, 1, 2)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (6, 1, 3)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (33, 1, 4)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (5, 1, 5)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (8, 1, 6)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (2, 1, 7)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (3, 1, 8)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (1, 1, 9)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (4, 1, 10)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (32, 1, 11)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (35, 1, 12)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (29, 1, 13)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (36, 1, 14)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (31, 1, 15)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (39, 1, 16)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (42, 1, 17)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (37, 1, 18)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (41, 1, 19)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (38, 1, 20)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (22, 1, 21)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (13, 1, 22)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (25, 1, 23)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (40, 1, 24)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (27, 1, 25)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (7, 1, 26)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (34, 1, 27)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (30, 1, 28)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (24, 1, 29)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (23, 1, 30)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (18, 1, 31)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (28, 1, 32)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (19, 1, 33)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (17, 1, 34)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (16, 1, 35)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (20, 1, 36)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (21, 1, 37)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (15, 1, 38)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (11, 1, 39)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (12, 1, 40)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (10, 1, 41)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (9, 1, 42)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (43, 1, 43)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (44, 1, 44)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (45, 1, 45)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (46, 1, 46)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (47, 1, 47)
INSERT [dbo].[t_admin_role_resource] ([id], [admin_role_id], [admin_resource_id]) VALUES (48, 1, 48)
SET IDENTITY_INSERT [dbo].[t_admin_role_resource] OFF
/****** Object:  Table [dbo].[t_admin_resource]    Script Date: 04/11/2018 22:22:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
DROP TABLE [dbo].[t_admin_resource]
GO
CREATE TABLE [dbo].[t_admin_resource](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NULL,
	[url] [nvarchar](255) NULL,
 CONSTRAINT [PK_t_admin_resource_id] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [t_admin_resource$index_unique_url] UNIQUE NONCLUSTERED
(
	[url] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'demo.t_admin_resource' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_admin_resource'
GO
SET IDENTITY_INSERT [dbo].[t_admin_resource] ON
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (1, N'首頁', N'/admin/main')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (2, N'資源_列表頁面', N'/admin/resource/list')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (3, N'系統用戶_列表頁面', N'/admin/adminUser/list')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (4, N'角色_列表頁面', N'/admin/role/list')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (5, N'系統用戶_新增/編輯頁面', N'/admin/adminUser/edit')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (6, N'系統用戶_保存/更新', N'/admin/adminUser/save')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (7, N'資源_新增/編輯頁面', N'/admin/adminResource/edit')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (8, N'資源_保存/更新', N'/admin/adminResource/save')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (9, N'資源_刪除', N'/admin/adminResource/delete')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (10, N'系統用戶_刪除', N'/admin/adminUser/delete')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (11, N'角色_新增/編輯頁面', N'/admin/role/edit')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (12, N'角色_保存/更新', N'/admin/role/save')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (13, N'資源_列表選擇頁面', N'/admin/resource/selectList')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (14, N'角色_更新權限', N'/admin/role/updateRoleResource')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (15, N'角色_刪除', N'/admin/role/delete')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (16, N'用戶_列表頁面', N'/admin/user/list')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (17, N'用戶_列表數據', N'/admin/user/userList')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (18, N'用戶_新增/編輯頁面', N'/admin/user/edit')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (19, N'用戶_保存/更新', N'/admin/user/save')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (20, N'用戶_凍結/解凍', N'/admin/user/freezeOrNot')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (21, N'其它_重置密碼', N'/admin/resetPwd')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (22, N'其它_登出', N'/admin/logout')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (23, N'資源_其它', N'/admin/resource/getRoleResourceId')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (24, N'用戶_列表數據', N'/admin/user/listData')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (25, N'資源_列表數據', N'/admin/resource/listData')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (26, N'系統用戶_列表數據', N'/admin/adminUser/listData')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (27, N'角色_列表數據', N'/admin/role/listData')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (28, N'資源_其它', N'/admin/resource/selectListData')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (29, N'資源_新增/編輯頁面', N'/admin/resource/edit')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (30, N'資源_刪除', N'/admin/resource/delete')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (31, N'定时任务_列表頁面', N'/admin/qrtzConsole/list')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (32, N'資源_保存/更新', N'/admin/resource/save')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (33, N'定时任务_列表數據', N'/admin/qrtzConsole/listData')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (34, N'定时任务_调度实例状态', N'/admin/qrtzConsole/getSchedulerStatus')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (35, N'定时任务_新增/編輯頁面', N'/admin/qrtzConsole/edit')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (36, N'定时任务_新增/更新', N'/admin/qrtzConsole/save')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (37, N'定时任务_启动/停止', N'/admin/qrtzConsole/update')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (38, N'定时任务_删除', N'/admin/qrtzConsole/delete')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (39, N'token管理_列表頁面', N'/admin/initToken/list')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (40, N'token管理_列表數據', N'/admin/initToken/listData')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (41, N'token管理_token初始化', N'/admin/initToken/init')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (43, N'用户关系_列表', N'/admin/weimobUserRelation/list')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (44, N'用户关系_列表数据', N'/admin/weimobUserRelation/listData')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (45, N'用户关系_编辑页面', N'/admin/weimobUserRelation/edit')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (46, N'用户关系_保存/更新', N'/admin/weimobUserRelation/save')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (47, N'用户关系_删除', N'/admin/weimobUserRelation/delete')
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (48, N'用户关系_文件上传', N'/admin/weimobUserRelation/upload')
SET IDENTITY_INSERT [dbo].[t_admin_resource] OFF
/****** Object:  Default [DF__t_admin_re__name__0CBAE877]    Script Date: 04/11/2018 22:22:45 ******/
ALTER TABLE [dbo].[t_admin_resource] ADD  DEFAULT (NULL) FOR [name]
GO
/****** Object:  Default [DF__t_admin_res__url__0DAF0CB0]    Script Date: 04/11/2018 22:22:45 ******/
ALTER TABLE [dbo].[t_admin_resource] ADD  DEFAULT (NULL) FOR [url]
GO
/****** Object:  Default [DF__t_admin_r__admin__0F975522]    Script Date: 04/11/2018 22:22:45 ******/
ALTER TABLE [dbo].[t_admin_role_resource] ADD  DEFAULT (NULL) FOR [admin_role_id]
GO
/****** Object:  Default [DF__t_admin_r__admin__108B795B]    Script Date: 04/11/2018 22:22:45 ******/
ALTER TABLE [dbo].[t_admin_role_resource] ADD  DEFAULT (NULL) FOR [admin_resource_id]
GO
