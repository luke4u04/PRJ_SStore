/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Account;
import entity.Cart;
import entity.Category;
import entity.DetailProduct;
import entity.Invoice;
import entity.Product;
import entity.Review;
import entity.SoLuongDaBan;
import entity.Status;
import entity.TongChiTieuBanHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DAO extends DBContext {

    ResultSet rs = null;

    public Account login(String user, String pass) {
        String query = "SELECT * FROM [dbo].[Account] WHERE [user] = ? AND pass = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void signUp(String user, String pass) {
        String query = "INSERT INTO [dbo].[Account]"
                + " VALUES(?,?,0)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account checkAccountExist(String user) {
        String query = "SELECT * FROM [dbo].[Account]"
                + " WHERE [user] = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Account]";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getTop4() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT TOP 4 * from [dbo].[product]"
                + " WHERE cateID IN (1,2,3,4)"
                + " order by id DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Category]";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[product]";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getTop4BestSeller() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT TOP 4 * FROM [dbo].[SoLuongDaBan]"
                + " JOIN [dbo].[product] ON product.id = SoLuongDaBan.productID"
                + " order by soLuongDaBan DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getNewProduct() {
        String query = "SELECT TOP 1 * FROM [dbo].[product]"
                + " ORDER BY id desc";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> getAllProductByCateId(String cateId) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[product] WHERE cateID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cateId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getTop6() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT TOP 6 * FROM [dbo].[product]";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getPage(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[product]"
                + " ORDER BY id "
                + "OFFSET ? ROWS "
                + "FETCH FIRST 6 ROWS ONLY";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getNumberPage() {
        String query = "SELECT COUNT(*) FROM [dbo].[product]\n";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 6;
                if (total % 6 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public List<Product> getTop5BestSeller() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT TOP 5 * FROM dbo.SoLuongDaBan "
                + "JOIN dbo.product ON product.id = SoLuongDaBan.productID "
                + "order by soLuongDaBan DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<TongChiTieuBanHang> getTop5Customers() {
        List<TongChiTieuBanHang> list = new ArrayList<>();
        String query = "SELECT TOP 5 * FROM dbo.TongChiTieuBanHang "
                + "JOIN dbo.Account ON Account.uID = TongChiTieuBanHang.userID "
                + "ORDER BY TongChiTieu DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TongChiTieuBanHang(rs.getDouble(2),
                        rs.getInt(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<TongChiTieuBanHang> getTop5Seller() {
        List<TongChiTieuBanHang> list = new ArrayList<>();
        String query = "SELECT TOP 5 * FROM dbo.TongChiTieuBanHang "
                + "JOIN dbo.Account ON Account.uID = TongChiTieuBanHang.userID "
                + "ORDER BY TongBanHang DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TongChiTieuBanHang(rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public double totalMoneyMonth(int month) {
        String query = "select SUM(tongGia) from dbo.Invoice "
                + "where MONTH(ngayXuat)=?"
                + " Group by MONTH(ngayXuat)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public double totalMoneyDay(int day) {
        String query = "select SUM(tongGia) "
                + "from dbo.Invoice "
                + "where DATEPART(dw,[ngayXuat]) = ?"
                + " Group by ngayXuat ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, day);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countAccount() {
        String query = "SELECT COUNT(uID) "
                + "FROM dbo.Account;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                return total;
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int countProduct() {
        String query = "SELECT COUNT(id) "
                + "FROM dbo.product;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                return total;
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int countReview() {
        String query = "SELECT COUNT(maReview) "
                + "FROM dbo.Review;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                return total;
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public float totalSeller() {
        String query = "SELECT SUM(TongChiTieu) "
                + "FROM dbo.TongChiTieuBanHang;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                float total = rs.getFloat(1);
                return total;
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public String getCategoryName(int stID) {
        String query = "SELECT cname FROM dbo.Category "
                + "WHERE cid = ?";
        String string = "";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, stID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return string = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return string;
    }

    public List<Product> getAllProductByName(String txt) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM dbo.product\n"
                + "WHERE [name] LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductById(String id) {
        String query = "SELECT * FROM dbo.product "
                + "WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Review> getAllReviewByProductID(String productId) {
        List<Review> list = new ArrayList<>();
        String query = "select * from dbo.Review "
                + "where [productID] =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Review(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getTop4RelatedProducts(int cateId) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT TOP 4 * FROM dbo.product\n"
                + "WHERE cateID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cateId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Cart> getCartByAccountID(int accountID) {
        List<Cart> list = new ArrayList<>();
        String query = "select * from dbo.Cart where accountID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteCartByAccountID(int accountID) {
        String query = "delete  from dbo.Cart where accountID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Cart checkCartExist(int accountID, int productID) {

        String query = "SELECT * FROM dbo.Cart\n"
                + "where [accountID] = ? and [productID] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void editAmountAndSizeCart(int accountID, int productID, int amount) {
        String query = "update dbo.Cart \n"
                + "SET [amount] = ?\n"
                + "where [accountID]=? and [productID]=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setInt(2, accountID);
            ps.setInt(3, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertCart(int accountID, int productID, int amount) {
        String query = "insert dbo.Cart(accountID, productID, amount)\n"
                + "        	values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            ps.setInt(3, amount);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertTongChiTieu(int accountID, double chi, double ban) {
        String query = "insert dbo.TongChiTieuBanHang(userID, TongChiTieu, TongBanHang)\n"
                + "        	values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setDouble(2, chi);
            ps.setDouble(3, ban);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editTongChiTieu(int sell_ID, double tongTienBanHangThem) {
        String query = "EXEC dbo.proc_CapNhatTongChiTieu ?,?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, sell_ID);
            ps.setDouble(2, tongTienBanHangThem);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public SoLuongDaBan checkSoLuongDaBanExist(int productID) {

        String query = "select * from dbo.SoLuongDaBan where productID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new SoLuongDaBan(rs.getInt(1),
                        rs.getInt(2)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertSoLuongDaBan(int productID, int soLuongDaBan) {
        String query = "insert dbo.SoLuongDaBan(productID,soLuongDaBan)\r\n"
                + "values(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ps.setInt(2, soLuongDaBan);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editAmountCart(int accountID, int productID, int amount) {
        String query = "update dbo.Cart set [amount]=? "
                + "where [accountID]=? and [productID]=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setInt(2, accountID);
            ps.setInt(3, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteCart(int productID) {
        String query = "delete from dbo.Cart where productID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account getAccountById(String id) {
        String query = "SELECT * FROM Account "
                + "WHERE uID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void deleteAccount(String pid) {
        String query = "DELETE FROM dbo.Account\n"
                + "                WHERE uID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertAccount(String user, String pass, int isAdmin) {
        String query = "INSERT [dbo].[Account] (  [user], [pass], [isAdmin])\n"
                + "                VALUES(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, isAdmin);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Product> getAllProductBySellID(int sellId) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM dbo.product\n"
                + "WHERE sell_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, sellId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateAccount(String user, String pass, int isAdmin, int id) {
        String query = "UPDATE dbo.Account \n"
                + "SET [user] = ?,\n"
                + "pass = ?,\n"
                + "isAdmin = ?\n"
                + "WHERE uID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, isAdmin);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Status> getAllStatus() {
        List<Status> list = new ArrayList<>();
        String query = "SELECT * FROM dbo.Status";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Status(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Invoice> getAllListInvoice() {
        List<Invoice> list = new ArrayList<>();
        String query = "SELECT * FROM dbo.Invoice";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Invoice(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public String getStatusName(int stID) {
        String query = "SELECT status FROM dbo.Status\n"
                + "WHERE stID = ?";
        String string = "";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, stID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return string = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return string;
    }

    public void editStatus(String mahd, int stid) {
        String query = "UPDATE .dbo.Invoice\n"
                + "SET statusID = ?\n"
                + "WHERE maHD = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, stid);
            ps.setString(2, mahd);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<DetailProduct> getDetailProductByMaHD(String maHD) {
        List<DetailProduct> list = new ArrayList<>();
        String query = "SELECT * FROM dbo.DetailProduct\n"
                + "WHERE maHD = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maHD);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DetailProduct(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Invoice getInvoiceByMaHD(String maHD) {

        String query = "SELECT * FROM dbo.Invoice\n"
                + "WHERE maHD = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Invoice(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Invoice> getListInvoiceByAccountID(int accountID) {
        List<Invoice> list = new ArrayList<>();
        String query = "SELECT * FROM dbo.Invoice\n"
                + "WHERE accountID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Invoice(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getSellIDByProductID(int productID) {
        String query = "select sell_ID\r\n"
                + "from dbo.product\r\n"
                + "where [id]=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public TongChiTieuBanHang checkTongChiTieuBanHangExist(int userID) {

        String query = "select * from dbo.TongChiTieuBanHang where [userID]=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userID);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new TongChiTieuBanHang(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void reduceTongBanHang(int sell_ID, double tongTienBanHangThem) {
        String query = "EXEC dbo.proc_GiamTienTongBanHang ?,?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, sell_ID);
            ps.setDouble(2, tongTienBanHangThem);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void reduceSoLuongDaBan(int productID, int quantity) {
        String query = "EXEC dbo.proc_GiamSoLuongBanHang ?,?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, productID);
            ps.setInt(2, quantity);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void reduceQuantityProduct(int quantity, int id) {
        String query = "EXEC [dbo].[proc_Product] ?,?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void editQuantityProduct(int quantity, int id) {
        String query = "UPDATE dbo.product\n"
                + "SET quantity = ?\n"
                + "WHERE id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void cancelOrder(String maHD, int accountID) {
        String query = "UPDATE dbo.Invoice\n"
                + "SET statusID = 5\n"
                + "WHERE maHD = ? AND accountID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maHD);
            ps.setInt(2, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertProduct(String name, String image, String price, String title, String des, String cate, int quantity) {
        String query = "INSERT [dbo].[product] ( [name], [image], [price], [title], [description], [cateID], [quantity]) \n"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, des);
            ps.setString(6, cate);
            ps.setInt(7, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int maHD() {
        String query = "SELECT dbo.fn_GetMaxMaHD() AS maxHDValue;";
        int maxMaHD = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxMaHD = rs.getInt("maxHDValue");
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return maxMaHD;
    }

    public void insertInvoice(int accountID, double price) {
        String query = "INSERT INTO dbo.Invoice (accountID, tongGia, ngayXuat, email, name, phone, deliveryAddress, statusID) "
                + "VALUES (?, ?, GETDATE(), ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setDouble(2, price);
            ps.setString(3, "account" + accountID + "@gmail.com");
            ps.setString(4, "Account" + accountID);
            ps.setString(5, "0123456789");
            ps.setString(6, "Hoa lac");
            ps.setString(7, "1");

            ps.executeUpdate();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void editSoLuongDaBan(int productID, int soLuongBanThem) {
        String query = "exec Honya.dbo.proc_CapNhatSoLuongDaBan ?,?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ps.setInt(2, soLuongBanThem);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void editTongBanHang(int sell_ID, double tongTienBanHangThem) {
        String query = "EXEC dbo.proc_CapNhatTongBanHang ?,?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, sell_ID);
            ps.setDouble(2, tongTienBanHangThem);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void updateProduct(String name, String image, String price, String title, String des, String cate, int quantity, int id) {
        String query = "UPDATE dbo.product\n"
                + "SET name = ?,\n"
                + "image = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "description = ?,\n"
                + "quantity = ?,\n"
                + "cateID = ?\n"
                + "WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, des);
            ps.setInt(6, quantity);
            ps.setString(7, cate);

            ps.setInt(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertDetail(int accountID, int pID, int amount) {
        String query = "INSERT [dbo].[DetailProduct] ( maHD, accountID, productID, amount) \n"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, maHD());
            ps.setInt(2, accountID);
            ps.setInt(3, pID);
            ps.setInt(4, amount);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertReview(int accountID, int productID, String contentReview) {
        String query = "insert dbo.Review(accountID, productID, contentReview, dateReview)\r\n"
                + "values(?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            ps.setString(3, contentReview);
            ps.setDate(4, getCurrentDate());
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public Review getNewReview(int accountID, int productID) {
        String query = "select top 1 * from dbo.Review\r\n"
                + "where accountID = ? and productID = ?\r\n"
                + "order by maReview desc";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Review(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
    

    public void deleteProduct(String pid) {
        String query = "DELETE FROM dbo.product\n"
                + "WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DAO d = new DAO();
        System.out.println(d.maHD());
    }
}
