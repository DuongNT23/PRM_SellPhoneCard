package com.example.prm392_project.dal;

import android.util.Log;

import com.example.prm392_project.model.Product;
import com.example.prm392_project.model.Storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StorageDAO {
    public ArrayList<Storage> getAllStorage() {
        ArrayList<Storage> list = new ArrayList<>();
        try {
            String query = "select * from dbo.[storage] ";
            PreparedStatement ps = DAO.connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Storage(rs.getLong("id"), rs.getString("serialNumber"), rs.getString("cardNumber"),
                        rs.getTimestamp("expiredAt"), DAO.productDAO.findProductById(rs.getInt("productId")), rs.getBoolean("isUsed"),
                        rs.getBoolean("isDelete"),rs.getTimestamp("createdAt"), DAO.userDAO.getUserById(rs.getInt("createdBy")), rs.getTimestamp("updatedAt"),
                        DAO.userDAO.getUserById(rs.getInt("updatedBy")), rs.getTimestamp("deletedAt"), DAO.userDAO.getUserById(rs.getInt("deletedBy"))));
            }
        }catch (Exception ex){
            Log.e("", ex.getMessage());
        }
        return list;
    }
    public Storage getStorageById(long id) {

        try {
            String query = "select * from dbo.[storage] where id = ?;";
            PreparedStatement ps = DAO.connection.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Storage(rs.getLong("id"), rs.getString("serialNumber"), rs.getString("cardNumber"),
                        rs.getTimestamp("expiredAt"), DAO.productDAO.findProductById(rs.getInt("productId")), rs.getBoolean("isUsed"),
                        rs.getBoolean("isDelete"),rs.getTimestamp("createdAt"), DAO.userDAO.getUserById(rs.getInt("createdBy")), rs.getTimestamp("updatedAt"),
                        DAO.userDAO.getUserById(rs.getInt("updatedBy")), rs.getTimestamp("deletedAt"), DAO.userDAO.getUserById(rs.getInt("deletedBy")));
            }
        } catch (Exception ex){
            Log.e("", ex.getMessage());
        }
        return null;
    }
    public void delete(Storage storage) {
       // Storage s = new Storage();

        try {
            String query = "update storage\n" +
                    "set deletedAt = ?, deletedBy = ?, isDelete = ?\n" +
                    "where id = ?;";
            PreparedStatement ps = DAO.connection.prepareStatement(query);
            ps.setTimestamp(1, storage.getDeletedAt());
            ps.setInt(2, 2);
            ps.setBoolean(3, storage.isDelete());
            ps.setLong(4, storage.getId());
            ps.execute();
        } catch (Exception ex){
            Log.e("", ex.getMessage());
        }
    }
//    public Storage MuaNgay(int soLuong, int productId) {
//        Storage storage = null;
//        try {
//            // Lấy thông tin sản phẩm trước khi xóa từ bảng Storage
//            String storageQuery = "SELECT TOP (?) serialNumber, cardNumber FROM dbo.[Storage] WHERE productId = ?;";
//            PreparedStatement psStorage = DAO.connection.prepareStatement(storageQuery);
//            psStorage.setInt(1, soLuong);
//            psStorage.setInt(2, productId);
//            ResultSet rsStorage = psStorage.executeQuery();
//
//            // Xóa hàng từ bảng Storage
//            String deleteQuery = "DELETE TOP (?) FROM dbo.[Storage] WHERE productId = ?;";
//            PreparedStatement psDelete = DAO.connection.prepareStatement(deleteQuery);
//            psDelete.setInt(1, soLuong);
//            psDelete.setInt(2, productId);
//            psDelete.executeUpdate();
//
//            // Lấy thông tin serialNumber và cardNumber từ kết quả truy vấn
//            String serialNumber = null;
//            String cardNumber = null;
//            while (rsStorage.next()) {
//                serialNumber = rsStorage.getString("serialNumber");
//                cardNumber = rsStorage.getString("cardNumber");
//            }
//
//            // Tạo một đối tượng Storage với thông tin lấy được
//            storage = new Storage(serialNumber, cardNumber);
//        } catch (Exception ex) {
//            Log.e("", ex.getMessage());
//        }
//        return storage;
//    }
public List<Storage> MuaNgay(int soLuong, int productId) {
    List<Storage> storageList = new ArrayList<>();
    try {
        // Lấy thông tin sản phẩm trước khi xóa từ bảng Storage
        String storageQuery = "SELECT TOP (?) serialNumber, cardNumber FROM dbo.[Storage] WHERE productId = ?;";
        PreparedStatement psStorage = DAO.connection.prepareStatement(storageQuery);
        psStorage.setInt(1, soLuong);
        psStorage.setInt(2, productId);
        ResultSet rsStorage = psStorage.executeQuery();

        // Xóa hàng từ bảng Storage
        String deleteQuery = "DELETE TOP (?) FROM dbo.[Storage] WHERE productId = ?;";
        PreparedStatement psDelete = DAO.connection.prepareStatement(deleteQuery);
        psDelete.setInt(1, soLuong);
        psDelete.setInt(2, productId);
        psDelete.executeUpdate();

        // Lấy thông tin serialNumber và cardNumber từ kết quả truy vấn
        while (rsStorage.next()) {
            String serialNumber = rsStorage.getString("serialNumber");
            String cardNumber = rsStorage.getString("cardNumber");
            // Tạo một đối tượng Storage với thông tin lấy được và thêm vào danh sách
            storageList.add(new Storage(serialNumber, cardNumber));
        }
    } catch (Exception ex) {
        Log.e("", ex.getMessage());
    }
    return storageList;
}

}
