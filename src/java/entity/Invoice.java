package entity;

import java.util.Date;

public class Invoice {

    private int maHD;
    private int accountID;
    private double tongGia;
    Date ngayXuat;
    private String email;
    private String name;
    private String phone;
    private String deliveryAddress;
    private int stid;

    public Invoice(int maHD, int accountID, double tongGia, Date ngayXuat) {

        this.maHD = maHD;
        this.accountID = accountID;
        this.tongGia = tongGia;
        this.ngayXuat = ngayXuat;
    }
    

    public Invoice(int maHD, int accountID, double tongGia, Date ngayXuat, String email, String name, String phone, String deliveryAddress) {
        this.maHD = maHD;
        this.accountID = accountID;
        this.tongGia = tongGia;
        this.ngayXuat = ngayXuat;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.deliveryAddress = deliveryAddress;
    }

    public Invoice(int maHD, int accountID, double tongGia, Date ngayXuat, String email, String name, String phone, String deliveryAddress,  int stid) {
        this.maHD = maHD;
        this.accountID = accountID;
        this.tongGia = tongGia;
        this.ngayXuat = ngayXuat;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.deliveryAddress = deliveryAddress;
        this.stid = stid;

    }

    
    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public Invoice() {

    }

    @Override
    public String toString() {
        return "Invoice [maHD=" + maHD + ", accountID=" + accountID + ", tongGia=" + tongGia + ", ngayXuat=" + ngayXuat
                + "]";
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getTongGia() {
        return tongGia;
    }

    public void setTongGia(double tongGia) {
        this.tongGia = tongGia;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }
}
