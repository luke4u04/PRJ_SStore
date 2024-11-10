CREATE DATABASE Project_SStore
--Account
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[uID] [int] IDENTITY(1,1) NOT NULL,
	[user] [varchar](255) NULL,
	[pass] [varchar](255) NULL,
	[isAdmin] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[uID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
--Product
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NULL,
	[image] [nvarchar](max) NULL,
	[price] [money] NULL,
	[title] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[cateID] [int] NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK_product] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
--Category
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cid] [int] NOT NULL,
	[cname] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
--Review
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Review](
	[accountID] [int] NULL,
	[productID] [int] NULL,
	[contentReview] [nvarchar](500) NULL,
	[dateReview] [date] NULL,
	[maReview] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Review] PRIMARY KEY CLUSTERED 
(
	[maReview] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
--Invoice
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[maHD] [int] IDENTITY(1,1) NOT NULL,
	[accountID] [int] NULL,
	[tongGia] [float] NULL,
	[ngayXuat] [datetime] NULL,
	[email] [nvarchar](500) NULL,
	[name] [nvarchar](500) NULL,
	[phone] [nvarchar](500) NULL,
	[deliveryAddress] [nvarchar](500) NULL,
	[statusID] [int] NULL,
 CONSTRAINT [PK_Invoice] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
--status
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Status](
	[stID] [int] IDENTITY(1,1) NOT NULL,
	[status] [nchar](500) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[stID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
--detailproduct
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetailProduct](
	[detailID] [int] IDENTITY(1,1) NOT NULL,
	[maHD] [int] NULL,
	[accountID] [int] NULL,
	[productID] [int] NULL,
	[amount] [int] NULL,
 CONSTRAINT [PK_DetailProduct] PRIMARY KEY CLUSTERED 
(
	[detailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
--cart
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[accountID] [int] NOT NULL,
	[productID] [int] NOT NULL,
	[amount] [int] NULL,
	[maCart] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Cart] PRIMARY KEY CLUSTERED 
(
	[maCart] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
--Solluongdaban
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SoLuongDaBan](
	[productID] [int] NULL,
	[soLuongDaBan] [int] NULL
) ON [PRIMARY]
GO
--Chitieu
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TongChiTieuBanHang](
	[userID] [int] NULL,
	[TongChiTieu] [float] NULL,
	[TongBanHang] [float] NULL
) ON [PRIMARY]
GO
--FK
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Account] FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_Account]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Product] FOREIGN KEY([productID])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_Product]
GO
ALTER TABLE [dbo].[DetailProduct]  WITH CHECK ADD  CONSTRAINT [FK_DetailProduct_Invoice] FOREIGN KEY([maHD])
REFERENCES [dbo].[Invoice] ([maHD])
GO
ALTER TABLE [dbo].[DetailProduct] CHECK CONSTRAINT [FK_DetailProduct_Invoice]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Account] FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FK_Invoice_Account]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Status] FOREIGN KEY([statusID])
REFERENCES [dbo].[Status] ([stID])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FK_Invoice_Status]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([cateID])
REFERENCES [dbo].[Category] ([cid])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_Account] FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_Account]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_Product] FOREIGN KEY([productID])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_Product]
GO
ALTER TABLE [dbo].[SoLuongDaBan]  WITH CHECK ADD  CONSTRAINT [FK_SoLuongDaBan_Product] FOREIGN KEY([productID])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[SoLuongDaBan] CHECK CONSTRAINT [FK_SoLuongDaBan_Product]
GO
ALTER TABLE [dbo].[TongChiTieuBanHang]  WITH CHECK ADD  CONSTRAINT [FK_TongChiTieuBanHang_Account] FOREIGN KEY([userID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[TongChiTieuBanHang] CHECK CONSTRAINT [FK_TongChiTieuBanHang_Account]
GO
--insert data
SET IDENTITY_INSERT [dbo].[Account] ON 
INSERT [dbo].[Account] ([uID], [user], [pass], [isAdmin]) VALUES (1, N'Tu', N'123', 1)
INSERT [dbo].[Account] ([uID], [user], [pass], [isAdmin]) VALUES (2, N'An', N'123', 1)
INSERT [dbo].[Account] ([uID], [user], [pass], [isAdmin]) VALUES (3, N'Huy', N'123', 0)
INSERT [dbo].[Account] ([uID], [user], [pass], [isAdmin]) VALUES (4, N'Minh', N'Minh123', 0)
INSERT [dbo].[Account] ([uID], [user], [pass], [isAdmin]) VALUES (5, N'Le', N'Le123', 0)
SET IDENTITY_INSERT [dbo].[Account] OFF
GO

INSERT [dbo].[Category] ([cid], [cname]) VALUES (1, N'Clothes')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (2, N'Ball')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (3, N'Shoes')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (4, N'Accessory')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (5, N'Combo')

SET IDENTITY_INSERT [dbo].[Status] ON 
INSERT [dbo].[Status] ([stID], [status]) VALUES (1, N'Ordered')
INSERT [dbo].[Status] ([stID], [status]) VALUES (2, N'In Transit') 
INSERT [dbo].[Status] ([stID], [status]) VALUES (3, N'Out for delivery') 
INSERT [dbo].[Status] ([stID], [status]) VALUES (4, N'Delivered') 
INSERT [dbo].[Status] ([stID], [status]) VALUES (5, N'Cancelled')                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
SET IDENTITY_INSERT [dbo].[Status] OFF
GO

INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (1, 0, 4447.3)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (2, 0, 1765)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (3, 3649.8, 0)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (4, 797.5, 0)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (5, 1265, 0)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (15, 500, 0)

SET IDENTITY_INSERT [dbo].[DetailProduct] ON 

INSERT [dbo].[DetailProduct] ([detailID], [maHD], [accountID], [productID], [amount]) VALUES (1, 1, 3, 2, 2)
INSERT [dbo].[DetailProduct] ([detailID], [maHD], [accountID], [productID], [amount]) VALUES (2, 2, 4, 10, 1)
INSERT [dbo].[DetailProduct] ([detailID], [maHD], [accountID], [productID], [amount]) VALUES (3, 2, 4, 1, 1)
INSERT [dbo].[DetailProduct] ([detailID], [maHD], [accountID], [productID], [amount]) VALUES (4, 3, 5, 19, 2)
INSERT [dbo].[DetailProduct] ([detailID], [maHD], [accountID], [productID], [amount]) VALUES (5, 4, 3,15, 1)
INSERT [dbo].[DetailProduct] ([detailID], [maHD], [accountID], [productID], [amount]) VALUES (6, 4, 3,1, 3)
INSERT [dbo].[DetailProduct] ([detailID], [maHD], [accountID], [productID], [amount]) VALUES (7, 5, 3,22, 1)

SET IDENTITY_INSERT [dbo].[DetailProduct] OFF
GO

INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (1, 5)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (2, 2)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (10, 1)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (19, 2)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (15, 1)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (22, 1)
--update so luong da ban
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[proc_CapNhatSoLuongDaBan] @productID int, @soLuongBanThem int
as
begin
	update SoLuongDaBan set [soLuongDaBan]=[soLuongDaBan] + @soLuongBanThem where productID=@productID
end
GO
/****** Object:  StoredProcedure [dbo].[proc_CapNhatTongBanHang]    Script Date: 11/10/2023 8:36:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[proc_CapNhatTongBanHang] @sell_ID int, @banHangThem float
as
begin
	update TongChiTieuBanHang set TongBanHang= TongBanHang + @banHangThem where [userID]=@sell_ID
end
GO
/****** Object:  StoredProcedure [dbo].[proc_CapNhatTongChiTieu]    Script Date: 11/10/2023 8:36:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[proc_CapNhatTongChiTieu] @userID int, @chiTieuThem float
as
begin
	update TongChiTieuBanHang set TongChiTieu= TongChiTieu + @chiTieuThem where [userID]=@userID
end
GO
/****** Object:  StoredProcedure [dbo].[proc_GiamSoLuongBanHang]    Script Date: 11/10/2023 8:36:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[proc_GiamSoLuongBanHang] @productID int, @soLuongBanThem int
as
begin
	update SoLuongDaBan set [soLuongDaBan]=[soLuongDaBan] - @soLuongBanThem where productID=@productID
end
GO
/****** Object:  StoredProcedure [dbo].[proc_GiamTienTongBanHang]    Script Date: 11/10/2023 8:36:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[proc_GiamTienTongBanHang] @sell_ID int, @banHangThem float
as
begin
	update TongChiTieuBanHang set TongBanHang= TongBanHang - @banHangThem where [userID]=@sell_ID
end
GO
/****** Object:  StoredProcedure [dbo].[proc_GiamTienTongChiTieu]    Script Date: 11/10/2023 8:36:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[proc_GiamTienTongChiTieu] @userID int, @chiTieuThem float
as
begin
	update TongChiTieuBanHang set TongChiTieu= TongChiTieu - @chiTieuThem where [userID]=@userID
end
GO

Create FUNCTION dbo.fn_GetMaxMaHD()
RETURNS INT
AS
BEGIN
    DECLARE @maxMaHD INT;

    SELECT @maxMaHD = MAX(maHD)
    FROM dbo.Invoice;

    RETURN ISNULL(@maxMaHD, 0); 
END;




