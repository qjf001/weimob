USE [weimob]
GO
/****** Object:  Table [dbo].[t_weimob_order_detail]    Script Date: 05/19/2018 21:13:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_weimob_order_detail](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[order_id] [bigint] NOT NULL,
	[return_type] [int] NULL,
	[amount] [decimal](18, 4) NULL,
	[spu_code] [nvarchar](50) NULL,
	[image_url] [nvarchar](255) NULL,
	[return_id] [int] NULL,
	[sku_id] [int] NULL,
	[sale_price] [decimal](18, 4) NULL,
	[is_delete] [nvarchar](50) NULL,
	[order_detail_id] [bigint] NULL,
	[price] [decimal](18, 4) NULL,
	[qty] [decimal](18, 4) NULL,
	[balance_amount] [decimal](18, 4) NULL,
	[return_status] [int] NULL,
	[sku_name] [nvarchar](500) NULL,
	[inventory_type] [int] NULL,
	[spu_id] [int] NULL,
	[sku_code] [nvarchar](50) NULL,
	[sku_description] [nvarchar](50) NULL,
	[return_qty] [int] NULL,
	[sale_amount] [decimal](18, 4) NULL,
 CONSTRAINT [PK_t_weimob_orderdetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N't_weimob_order 的明细表' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N't_weimob_order_detail'
GO
