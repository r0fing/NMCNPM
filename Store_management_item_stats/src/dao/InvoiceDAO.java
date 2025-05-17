/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Invoice;
import model.InvoiceItem;
import model.Subagence;

/**
 *
 * @author HLC_2021
 */
public class InvoiceDAO extends DAO {

    public InvoiceDAO() {
        super();
    }
    
    public ArrayList<Invoice> getListInvoices(int itemId, Date sd, Date ed) {
        ArrayList<Invoice> result = new ArrayList<>();
        String sql = """
                    select 
                    	tInv.id as idInvoice,
                        dateIssue,
                        tS.id as idSubagence,
                        brandName,
                        address,
                        phoneNumber,
                        tII.id as idInvoiceItem,
                        quantity,
                        itemPrice
                    from tblInvoice tInv
                    join tblSubagence tS on tInv.tblSubagenceid=tS.id
                    join tblinvoiceitem tII on tInv.id=tII.tblInvoiceid and tblItemid = ?
                    where dateIssue between ? and ?
                    order by dateIssue""";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, itemId);
            ps.setString(2, sdf.format(sd));
            ps.setString(3, sdf.format(ed));
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Invoice i = new Invoice();
                i.setId(rs.getInt("idInvoice"));
                i.setDateIssued(rs.getDate("dateIssue"));
                i.setSubagenceName(rs.getString("brandName"));
                //Subagence
                Subagence s = new Subagence();
                s.setId(rs.getInt("idSubagence"));
                s.setBrandName(rs.getString("brandName"));
                s.setAddress(rs.getString("address"));
                s.setPhoneNumber(rs.getString("phoneNumber"));
                i.setSubagence(s);
                //Invoiceitem
                InvoiceItem ii = new InvoiceItem();
                ii.setId(rs.getInt("idInvoiceItem"));
                ii.setQuantity(rs.getInt("quantity"));
                ii.setItemPrice(rs.getFloat("itemPrice"));
                i.getInvoiceItem().add(ii);
                
                result.add(i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }       
        return result;
    }
}
