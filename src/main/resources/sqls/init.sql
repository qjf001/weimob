USE [weimob]
GO
/****** Object:  Table [dbo].[t_admin_resource]    Script Date: 2018/3/16 14:59:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_admin_resource](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NULL,
	[url] [nvarchar](255) NULL,
 CONSTRAINT [PK_t_admin_resource_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[t_admin_role]    Script Date: 2018/3/16 14:59:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_admin_role](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[nick_name] [nvarchar](255) NULL,
 CONSTRAINT [PK_t_admin_role_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[t_admin_role_resource]    Script Date: 2018/3/16 14:59:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_admin_role_resource](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[admin_role_id] [bigint] NULL,
	[admin_resource_id] [bigint] NULL,
 CONSTRAINT [PK_t_admin_role_resource_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[t_admin_user]    Script Date: 2018/3/16 14:59:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_admin_user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](20) NULL,
	[nick_name] [nvarchar](255) NULL,
	[password] [nvarchar](255) NULL,
	[age] [smallint] NULL,
 CONSTRAINT [PK_t_admin_user_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[t_admin_user_role]    Script Date: 2018/3/16 14:59:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_admin_user_role](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[admin_user_id] [bigint] NOT NULL,
	[admin_role_id] [bigint] NOT NULL,
 CONSTRAINT [PK_t_admin_user_role_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[t_qrtz_console]    Script Date: 2018/3/16 14:59:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_qrtz_console](
	[id] [bigint] IDENTITY(9,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[name_en] [nvarchar](50) NOT NULL,
	[full_class_name] [nvarchar](150) NOT NULL,
	[cron] [nvarchar](20) NOT NULL,
	[last_updatetime] [datetime2](0) NULL,
	[admin_user_id] [bigint] NULL,
	[admin_user_ip] [nvarchar](30) NULL,
	[memo] [nvarchar](255) NULL,
	[status] [int] NOT NULL,
 CONSTRAINT [PK_t_qrtz_console_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

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
INSERT [dbo].[t_admin_resource] ([id], [name], [url]) VALUES (42, N'其它_其它', N'/admin/initToken/getOrderDetailListTest')
SET IDENTITY_INSERT [dbo].[t_admin_resource] OFF
SET IDENTITY_INSERT [dbo].[t_admin_role] ON 

INSERT [dbo].[t_admin_role] ([id], [name], [nick_name]) VALUES (1, N'system', N'系统管理员')
INSERT [dbo].[t_admin_role] ([id], [name], [nick_name]) VALUES (2, N'dataManager', N'数据管理员')
INSERT [dbo].[t_admin_role] ([id], [name], [nick_name]) VALUES (3, N'generalManager', N'普通管理员')
SET IDENTITY_INSERT [dbo].[t_admin_role] OFF
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
SET IDENTITY_INSERT [dbo].[t_admin_role_resource] OFF
SET IDENTITY_INSERT [dbo].[t_admin_user] ON 

INSERT [dbo].[t_admin_user] ([id], [name], [nick_name], [password], [age]) VALUES (1, N'wxf', N'吴献峰', N'c3284d0f94606de1fd2af172aba15bf3', 0)
SET IDENTITY_INSERT [dbo].[t_admin_user] OFF
SET IDENTITY_INSERT [dbo].[t_admin_user_role] ON 

INSERT [dbo].[t_admin_user_role] ([id], [admin_user_id], [admin_role_id]) VALUES (1, 1, 1)
SET IDENTITY_INSERT [dbo].[t_admin_user_role] OFF
SET IDENTITY_INSERT [dbo].[t_qrtz_console] ON 

INSERT [dbo].[t_qrtz_console] ([id], [name], [name_en], [full_class_name], [cron], [last_updatetime], [admin_user_id], [admin_user_ip], [memo], [status]) VALUES (9, N'获取用户列表', N'GetUserListJob', N'com.qjf.quartz.job.GetUserListJob', N'0 0/5 * * * ?', CAST(0x0084C300003E0B0000 AS DateTime2), 1, N'0:0:0:0:0:0:0:1', N'', 2)
INSERT [dbo].[t_qrtz_console] ([id], [name], [name_en], [full_class_name], [cron], [last_updatetime], [admin_user_id], [admin_user_ip], [memo], [status]) VALUES (10, N'获取订单详情列表', N'GetOrderDetailListJob', N'com.qjf.quartz.job.GetOrderDetailListJob', N'0 2/5 * * * ?', CAST(0x0004D000003E0B0000 AS DateTime2), 1, N'0:0:0:0:0:0:0:1', N'', 2)
INSERT [dbo].[t_qrtz_console] ([id], [name], [name_en], [full_class_name], [cron], [last_updatetime], [admin_user_id], [admin_user_ip], [memo], [status]) VALUES (11, N'刷新token', N'RefreshTokenJob', N'com.qjf.quartz.job.RefreshTokenJob', N'0 0 0/2 * * ?', CAST(0x000CD000003E0B0000 AS DateTime2), 1, N'0:0:0:0:0:0:0:1', N'', 2)
SET IDENTITY_INSERT [dbo].[t_qrtz_console] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [t_admin_resource$index_unique_url]    Script Date: 2018/3/16 14:59:47 ******/
ALTER TABLE [dbo].[t_admin_resource] ADD  CONSTRAINT [t_admin_resource$index_unique_url] UNIQUE NONCLUSTERED 
(
	[url] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [t_admin_role_resource$index_unique_]    Script Date: 2018/3/16 14:59:47 ******/
ALTER TABLE [dbo].[t_admin_role_resource] ADD  CONSTRAINT [t_admin_role_resource$index_unique_] UNIQUE NONCLUSTERED 
(
	[admin_role_id] ASC,
	[admin_resource_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [t_admin_user$index_unique_name]    Script Date: 2018/3/16 14:59:47 ******/
ALTER TABLE [dbo].[t_admin_user] ADD  CONSTRAINT [t_admin_user$index_unique_name] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [t_qrtz_console$index_unique_name_en]    Script Date: 2018/3/16 14:59:47 ******/
ALTER TABLE [dbo].[t_qrtz_console] ADD  CONSTRAINT [t_qrtz_console$index_unique_name_en] UNIQUE NONCLUSTERED 
(
	[name_en] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[t_admin_resource] ADD  DEFAULT (NULL) FOR [name]
GO
ALTER TABLE [dbo].[t_admin_resource] ADD  DEFAULT (NULL) FOR [url]
GO
ALTER TABLE [dbo].[t_admin_role] ADD  DEFAULT (NULL) FOR [nick_name]
GO
ALTER TABLE [dbo].[t_admin_role_resource] ADD  DEFAULT (NULL) FOR [admin_role_id]
GO
ALTER TABLE [dbo].[t_admin_role_resource] ADD  DEFAULT (NULL) FOR [admin_resource_id]
GO
ALTER TABLE [dbo].[t_admin_user] ADD  DEFAULT (NULL) FOR [name]
GO
ALTER TABLE [dbo].[t_admin_user] ADD  DEFAULT (NULL) FOR [nick_name]
GO
ALTER TABLE [dbo].[t_admin_user] ADD  DEFAULT (NULL) FOR [password]
GO
ALTER TABLE [dbo].[t_admin_user] ADD  DEFAULT (NULL) FOR [age]
GO
ALTER TABLE [dbo].[t_qrtz_console] ADD  DEFAULT (NULL) FOR [last_updatetime]
GO
ALTER TABLE [dbo].[t_qrtz_console] ADD  DEFAULT (NULL) FOR [admin_user_id]
GO
ALTER TABLE [dbo].[t_qrtz_console] ADD  DEFAULT (NULL) FOR [admin_user_ip]
GO
ALTER TABLE [dbo].[t_qrtz_console] ADD  DEFAULT (NULL) FOR [memo]
GO
ALTER TABLE [dbo].[t_qrtz_console] ADD  DEFAULT ((2)) FOR [status]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'demo.t_admin_resource' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_admin_resource'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'demo.t_admin_role' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_admin_role'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'demo.t_admin_role_resource' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_admin_role_resource'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'demo.t_admin_user' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_admin_user'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'demo.t_admin_user_role' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_admin_user_role'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'weimob.t_qrtz_console' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_qrtz_console'
GO

USE [weimob]
GO
/****** Object:  Table [dbo].[t_weimob_order]    Script Date: 2018/3/19 10:32:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_weimob_order](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[activity_type] [bigint] NULL,
	[is_supplier_delivery] [nvarchar](10) NULL,
	[order_id] [bigint] NULL,
	[order_no] [nvarchar](255) NULL,
	[order_source] [nvarchar](255) NULL,
	[order_type] [int] NULL,
	[order_status] [int] NULL,
	[create_time] [nvarchar](50) NULL,
	[create_man] [nvarchar](255) NULL,
	[update_time] [nvarchar](50) NULL,
	[update_man] [nvarchar](255) NULL,
	[is_delete] [nvarchar](10) NULL,
	[discount_amount] [decimal](10, 2) NULL,
	[discount_detail] [nvarchar](255) NULL,
	[coupon_amount] [decimal](10, 2) NULL,
	[coupons_no] [nvarchar](50) NULL,
	[point_use] [bigint] NULL,
	[point_amount] [decimal](10, 2) NULL,
	[balance_amount] [decimal](10, 2) NULL,
	[real_amount] [decimal](10, 2) NULL,
	[is_onlinepay] [nvarchar](10) NULL,
	[pay_status] [bigint] NULL,
	[pay_time] [nvarchar](50) NULL,
	[payment_id] [nvarchar](255) NULL,
	[payment_code] [nvarchar](255) NULL,
	[payment_name] [nvarchar](255) NULL,
	[payment_thirdno] [nvarchar](255) NULL,
	[delivery_amount] [decimal](10, 2) NULL,
	[delivery_status] [bigint] NULL,
	[delivery_type] [nvarchar](255) NULL,
	[carrier_name] [nvarchar](255) NULL,
	[express_no] [nvarchar](255) NULL,
	[receiver_address] [nvarchar](255) NULL,
	[receiver_name] [nvarchar](255) NULL,
	[receiver_tel] [nvarchar](255) NULL,
	[sender_address] [nvarchar](255) NULL,
	[sender_name] [nvarchar](255) NULL,
	[sender_tel] [nvarchar](255) NULL,
	[delivery_time] [nvarchar](50) NULL,
	[receive_time] [nvarchar](50) NULL,
	[order_flag] [bigint] NULL,
	[order_flag_memo] [nvarchar](255) NULL,
	[remark] [nvarchar](255) NULL,
	[sku_qty] [bigint] NULL,
	[goods_amount] [decimal](10, 2) NULL,
	[member_id] [nvarchar](255) NULL,
	[open_id] [nvarchar](255) NULL,
	[user_ztInfo] [nvarchar](max) NULL,
	[zt_code] [nvarchar](255) NULL,
	[zt_qrCode] [nvarchar](255) NULL,
	[zt_shopSetId] [int] NULL,
	[hx_status] [nvarchar](10) NULL,
	[hx_by] [nvarchar](255) NULL,
	[distribution_timeType] [bigint] NULL,
	[mechant_deliveryTime] [nvarchar](50) NULL,
	[distribution_type] [int] NULL,
	[pt_status] [bigint] NULL,
	[packs] [nvarchar](max) NULL,
	[payment_details] [nvarchar](max) NULL,
	[fans_info] [nvarchar](max) NULL,
	[distribution_info] [nvarchar](max) NULL,
	[receiver_region] [nvarchar](max) NULL,
	[order_details] [nvarchar](max) NULL,
	[return_detail] [nvarchar](max) NULL,
 CONSTRAINT [PK_t_weimob_order_id] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[t_weimob_user]    Script Date: 2018/3/19 10:32:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_weimob_user](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[openid] [nvarchar](50) NULL,
	[weimob_openid] [nvarchar](50) NULL,
	[customer_no] [nvarchar](255) NULL,
	[qrcode_url] [nvarchar](255) NULL,
	[barcode_url] [nvarchar](255) NULL,
	[tags] [nvarchar](255) NULL,
	[is_fans] [nvarchar](255) NULL,
	[customer_type] [nvarchar](255) NULL,
	[levelname] [nvarchar](255) NULL,
	[menbercard_id] [nvarchar](255) NULL,
	[current_growth_value] [int] NULL,
	[wxcode_status] [int] NULL,
	[wxcode] [nvarchar](255) NULL,
	[register_date] [bigint] NULL,
	[card_validity_type] [nvarchar](255) NULL,
	[card_validity_time] [bigint] NULL,
	[name] [nvarchar](255) NULL,
	[nickname] [nvarchar](255) NULL,
	[portrait_url] [nvarchar](255) NULL,
	[phone] [nvarchar](255) NULL,
	[sex] [nvarchar](255) NULL,
	[birth_day] [bigint] NULL,
	[total_points] [int] NULL,
	[current_points] [bigint] NULL,
	[current_amount] [decimal](10, 2) NULL,
	[total_transaction_amount] [decimal](10, 2) NULL,
	[total_transaction_count] [bigint] NULL,
	[average_amount] [decimal](10, 2) NULL,
	[last_transaction_time] [bigint] NULL,
	[create_time] [bigint] NULL,
	[update_time] [bigint] NULL,
 CONSTRAINT [PK_t_weimob_user_id] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [activity_type]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [is_supplier_delivery]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [order_id]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [order_no]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [order_source]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [order_type]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [order_status]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [create_time]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [create_man]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [update_time]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [update_man]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [is_delete]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [discount_amount]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [discount_detail]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [coupon_amount]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [coupons_no]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [point_use]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [point_amount]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [balance_amount]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [real_amount]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [is_onlinepay]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [pay_status]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [pay_time]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [payment_id]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [payment_code]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [payment_name]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [payment_thirdno]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [delivery_amount]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [delivery_status]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [delivery_type]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [carrier_name]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [express_no]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [receiver_address]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [receiver_name]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [receiver_tel]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [sender_address]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [sender_name]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [sender_tel]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [delivery_time]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [receive_time]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [order_flag]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [order_flag_memo]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [remark]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [sku_qty]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [goods_amount]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [member_id]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [open_id]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [zt_code]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [zt_qrCode]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [zt_shopSetId]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [hx_status]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [hx_by]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [distribution_timeType]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [mechant_deliveryTime]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [distribution_type]
GO
ALTER TABLE [dbo].[t_weimob_order] ADD  DEFAULT (NULL) FOR [pt_status]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [openid]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [weimob_openid]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [customer_no]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [qrcode_url]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [barcode_url]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [tags]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [is_fans]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [customer_type]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [levelname]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [menbercard_id]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [current_growth_value]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [wxcode_status]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [wxcode]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [register_date]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [card_validity_type]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [card_validity_time]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [name]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [nickname]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [portrait_url]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [phone]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [sex]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [birth_day]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [total_points]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [current_points]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [current_amount]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [total_transaction_amount]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [total_transaction_count]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [average_amount]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [last_transaction_time]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [create_time]
GO
ALTER TABLE [dbo].[t_weimob_user] ADD  DEFAULT (NULL) FOR [update_time]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主键' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_weimob_order', @level2type=N'COLUMN',@level2name=N'id'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'demo.t_weimob_order' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_weimob_order'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'demo.t_weimob_user' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_weimob_user'
GO
