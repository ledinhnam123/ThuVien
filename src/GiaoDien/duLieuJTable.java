package GiaoDien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Data.Connect;
import net.proteanit.sql.DbUtils;

public class duLieuJTable {
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	public static Connection con = Connect.getConnect();
	public static void layDuLieuJtable(String sql, JTable tb) {
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			tb.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e ,"Thông Báo",1);
		}
	}
	public static ResultSet kiemTraKetNoi(String sql) {
        try{
            ps = con.prepareStatement(sql);
            return ps.executeQuery(); 
        }
        catch(Exception e) {
            return null;
        }
    }
}
