/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.ItemStats;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author HLC_2021
 */
public class ItemStatsDAO extends DAO {

    public ItemStatsDAO() {
        super();
    }
    
    public ArrayList<ItemStats> getItemStats(Date sd, Date ed) {
        ArrayList<ItemStats> result = new ArrayList<>();
        String sql = "SELECT " +
                    "tI.id, " +
                    "itemName, " +
                    "itemDescription, " +
                    "COALESCE(SUM(CASE WHEN dateIssue BETWEEN ? AND ? THEN quantity ELSE 0 END), 0) AS quantity_sold, " +
                    "COALESCE(SUM(CASE WHEN dateIssue BETWEEN ? AND ? THEN quantity * tII.itemPrice ELSE 0 END), 0) AS revenue " +
                    "FROM tblItem tI " +
                    "LEFT JOIN tblInvoiceItem tII " +
                    "ON tII.tblItemid = tI.id " +
                    "LEFT JOIN tblInvoice tInv " +
                    "ON tInv.id = tII.tblInvoiceid " +
                    "GROUP BY tI.id, itemName, itemDescription " +
                    "ORDER BY revenue DESC;";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sdf.format(sd));
            ps.setString(2, sdf.format(ed));
            ps.setString(3, sdf.format(sd));
            ps.setString(4, sdf.format(ed));
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                ItemStats is = new ItemStats();
                is.setId(rs.getInt("id"));
                is.setItemName(rs.getString("itemName"));
                is.setItemDescription(rs.getString("itemDescription"));
                is.setTotalQuantitySold(rs.getInt("quantity_sold"));
                is.setTotalRevenue(rs.getFloat("revenue"));
                result.add(is);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }       
        return result;
    }
}
