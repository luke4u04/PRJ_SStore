/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import entity.Account;
import entity.Cart;
import entity.Product;
import entity.SoLuongDaBan;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AddDetail", urlPatterns = {"/adddetail"})
public class AddDetail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("ac");
        if (a == null) {
            response.sendRedirect("login");
            return;
        }
        int accountID = a.getId();
        DAO dao = new DAO();
        List<Cart> listC = dao.getCartByAccountID(accountID);
        List<Product> listP = dao.getAllProduct();
        for (Cart c : listC) {
            for (Product p : listP) {
                if (c.getProductID() == p.getId()) {
                    dao.insertDetail(accountID, p.getId(), c.getAmount());
                    SoLuongDaBan s = dao.checkSoLuongDaBanExist(p.getId());
                    if (s != null) {
                        dao.editSoLuongDaBan(p.getId(), c.getAccountID());
                        if(p.getId()%3==0){
                            dao.editTongBanHang(2,p.getPrice()*c.getAmount());
                        } else {dao.editTongBanHang(1,p.getPrice()*c.getAmount());}
                    } else {
                        dao.insertSoLuongDaBan(p.getId(), c.getAccountID());
                        if(p.getId()%3==0){
                            dao.editTongBanHang(2,p.getPrice()*c.getAmount());
                        } else {dao.editTongBanHang(1,p.getPrice()*c.getAmount());}
                    }
                    dao.reduceQuantityProduct(p.getId(), c.getAmount());
                }
            }
        }
        dao.deleteCartByAccountID(accountID);
        response.sendRedirect("managerInvoiceDB");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}