/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import db.DBConnection;
import model.Product;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ProductService {

    public DefaultTableModel getAllProductsTableModel() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","Name","Category","Price","Stock","MinStock"}, 0);
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM products")) {

            while (rs.next()) {
                Object[] row = new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("min_stock")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("getAllProductsTableModel error: " + e.getMessage());
        }
        return model;
    }

    public boolean addProduct(String name, String category, double price, int stock, int minStock) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO products(name, category, price, stock, min_stock) VALUES(?,?,?,?,?)")) {
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setDouble(3, price);
            ps.setInt(4, stock);
            ps.setInt(5, minStock);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("addProduct error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteProduct(int id) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE id=?")) {
            ps.setInt(1, id);
            int r = ps.executeUpdate();
            return r > 0;
        } catch (SQLException e) {
            System.out.println("deleteProduct error: " + e.getMessage());
            return false;
        }
    }

    
    
    
    public DefaultTableModel searchProductsByName(String keyword) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","Name","Category","Price","Stock","MinStock"}, 0);
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE name LIKE ?")) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("min_stock")
                });
            }
        } catch (SQLException e) {
            System.out.println("searchProductsByName error: " + e.getMessage());
        }
        return model;
    }

    public DefaultTableModel sortProductsByName(boolean ascending) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","Name","Category","Price","Stock","MinStock"}, 0);
        String order = ascending ? "ASC" : "DESC";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM products ORDER BY name " + order)) {
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("min_stock")
                });
            }
        } catch (SQLException e) {
            System.out.println("sortProductsByName error: " + e.getMessage());
        }
        return model;
    }

   
    public String sellProduct(int id, int qty) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return "Product not found.";
            int stock = rs.getInt("stock");
            double price = rs.getDouble("price");
            String name = rs.getString("name");
            int minStock = rs.getInt("min_stock");

            if (stock < qty) return "Not enough stock.";

            int newStock = stock - qty;
            try (PreparedStatement upd = con.prepareStatement("UPDATE products SET stock=? WHERE id=?")) {
                upd.setInt(1, newStock);
                upd.setInt(2, id);
                upd.executeUpdate();
            }

            
            try (PreparedStatement sale = con.prepareStatement("INSERT INTO sales(product_id, quantity, total_price) VALUES(?,?,?)")) {
                sale.setInt(1, id);
                sale.setInt(2, qty);
                sale.setDouble(3, qty * price);
                sale.executeUpdate();
            } catch (SQLException ex) {
                
            }

            
            return "Sold " + qty + " x " + name + " total " + (qty * price);
        } catch (SQLException e) {
            System.out.println("sellProduct error: " + e.getMessage());
            return "Error processing sale";
        }
    }

   public double getProductPriceById(int id) {
    try (Connection con = DBConnection.getConnection()) {
        PreparedStatement ps = con.prepareStatement("SELECT price FROM products WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getDouble("price");
        }
    } catch (SQLException e) {
        System.out.println("getProductPriceById error: " + e.getMessage());
    }
    return 0; // default if not found
}

    public DefaultTableModel getSalesHistoryModel() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ProductID","Quantity","Total","Date"}, 0);
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT product_id, quantity, total_price, sale_date FROM sales ORDER BY id DESC")) {
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("total_price"),
                        rs.getTimestamp("sale_date")
                });
            }
        } catch (SQLException e) {
            
        }
        return model;
    }

    
    public String undoLastSale() {
        
        return "Undo not implemented in this simplified service.";
    }
}
