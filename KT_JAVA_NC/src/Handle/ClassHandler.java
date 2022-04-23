package Handle;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Connection.Connect;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quốc Hùng
 */
public class ClassHandler {
    public BaoHiem Login(BaoHiem bh) {
        Connection conn = Connect.ConnectSQL();
        
        try {
           PreparedStatement ps = conn.prepareStatement("select * from Infomation where maBH = ?");
           ps.setString(1, bh.getMaBH());
           ResultSet result = ps.executeQuery();
            
           if(result.next()) {
               String password = bh.getPassword();
               if(!password.equals(result.getString("password"))) {
                   JOptionPane.showMessageDialog(null, "Password incorect!");
                   return null;
               } else {
                    BaoHiem user = new BaoHiem();
                    user.setMaBH(result.getString("maBH"));
                    user.setPassword(result.getString("password"));
                    user.setHoTen(result.getString("hoTen"));
                    user.setSDT(result.getString("SDT"));
                    user.setSoCCD(result.getString("soCCCD"));
                    user.setGioiTinh(result.getString("gioiTinh"));
               
                    return user;
               }  
           } else {
               JOptionPane.showMessageDialog(null,"Account doesn't exist!");
           }
           
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void AddBaoHiem(BaoHiem bh) {
        
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Infomation values (null,?,?,?,?,?,?)");
            ps.setString(1, bh.getMaBH());
            ps.setString(2, bh.getHoTen());
            ps.setString(3, bh.getSDT());
            ps.setString(4, bh.getSoCCD());
            ps.setString(5, bh.getGioiTinh());
            ps.setString(6, bh.getNgaySinh());
            
            
            int result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public List<BaoHiem> getAllBaoHiem() {
        List<BaoHiem> listBH = new ArrayList<>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Infomation");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                BaoHiem bh = new BaoHiem();
                
                bh.setMaBH(result.getString("maBH"));
                bh.setHoTen(result.getString("hoTen"));
                bh.setSDT(result.getString("SDT"));
                bh.setSoCCD(result.getString("soCCCD"));
                bh.setGioiTinh(result.getString("gioiTinh"));
                bh.setNgaySinh(result.getString("ngaySinh"));
                
                listBH.add(bh);
            }
            System.out.println("sucessss");
        } catch (SQLException ex) {
            Logger.getLogger(ClassHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBH;
    }
    
    public List<BaoHiem> GetResultSearchBH(String searchType,String valueSearch) {
        List<BaoHiem> staffs = new ArrayList<>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = null;
            switch(searchType) {
            case "Mã bảo hiểm" : 
                 ps = conn.prepareStatement("select * from Infomation where maBH = ?");
                ps.setObject(1, valueSearch);  
                break;
            
            case "Họ tên" : 
                 ps = conn.prepareStatement("select * from Infomation where hoTen = ?");
                ps.setObject(1, valueSearch);  
                break;
             
            case "Số ĐT" : 
                 ps = conn.prepareStatement("select * from Infomation where SDT = ?");
                ps.setObject(1, valueSearch);  
                break;
                
            case "Số CCCD" : 
                 ps = conn.prepareStatement("select * from Infomation where soCCCD = ?");
                ps.setObject(1, valueSearch);  
                break;   
             
            case "Giới tính" : 
                 ps = conn.prepareStatement("select * from Infomation where gioiTinh = ?");
                ps.setObject(1, valueSearch);  
                break;
            case "Ngày sinh" : 
                 ps = conn.prepareStatement("select * from Infomation where ngaySinh = ?");
                ps.setObject(1, valueSearch);  
                break;
            }
            

            ResultSet result = ps.executeQuery();
            
            while(result.next()) {
                BaoHiem staff = new BaoHiem();
                
                staff.setMaBH(result.getString("maBH"));
                staff.setHoTen(result.getString("hoTen"));
                staff.setSDT(result.getString("SDT"));
                staff.setSoCCD(result.getString("soCCCD"));
                staff.setGioiTinh(result.getString("gioiTinh"));
                staff.setNgaySinh(result.getString("ngaySinh"));
                
                    
                staffs.add(staff);
            }
            return staffs;
        } catch (SQLException ex) {
            Logger.getLogger(ClassHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
