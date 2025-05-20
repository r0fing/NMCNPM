



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import dao.ItemStatsDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import model.ItemStats;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ADMIN
 */
public class ItemStatsDAOTest {
    
    @Test
    public void testGetItemStats1() { 
        ItemStatsDAO isd = new ItemStatsDAO();
        Date startDate = new GregorianCalendar(2025, Calendar.JANUARY, 20).getTime();
        Date endDate = new GregorianCalendar(2025, Calendar.JANUARY, 22).getTime();
        
        ArrayList<ItemStats> lis = isd.getItemStats(startDate, endDate);
        Assert.assertNotNull(lis);
        
        Assert.assertEquals(3, lis.size());
        Assert.assertEquals(1, lis.get(0).getId());
        Assert.assertTrue(lis.get(0).getItemName().equalsIgnoreCase("Laptop"));
        Assert.assertEquals(13, lis.get(0).getTotalQuantitySold());
        Assert.assertEquals(130.0f, lis.get(0).getTotalRevenue(), 0.00001f);
        
        Assert.assertEquals(2, lis.get(1).getId());
        Assert.assertTrue(lis.get(1).getItemName().equalsIgnoreCase("Washing machine"));
        Assert.assertEquals(5, lis.get(1).getTotalQuantitySold());
        Assert.assertEquals(100.0f, lis.get(1).getTotalRevenue(), 0.00001f);
        
        Assert.assertEquals(3, lis.get(2).getId());
        Assert.assertTrue(lis.get(2).getItemName().equalsIgnoreCase("Printer"));
        Assert.assertEquals(3, lis.get(2).getTotalQuantitySold());
        Assert.assertEquals(75.0f, lis.get(2).getTotalRevenue(), 0.00001f);
    }
    
    @Test
    public void testGetItemStats2() { 
        ItemStatsDAO isd = new ItemStatsDAO();
        Date startDate = new GregorianCalendar(2025, Calendar.JANUARY, 28).getTime();
        Date endDate = new GregorianCalendar(2025, Calendar.JANUARY, 30).getTime();
        
        ArrayList<ItemStats> lis = isd.getItemStats(startDate, endDate);
        Assert.assertNotNull(lis);
        
        Assert.assertEquals(1, lis.size());
        Assert.assertEquals(2, lis.get(0).getId());
        Assert.assertTrue(lis.get(0).getItemName().equalsIgnoreCase("Washing machine"));
        Assert.assertEquals(7, lis.get(0).getTotalQuantitySold());
        Assert.assertEquals(140.0f, lis.get(0).getTotalRevenue(), 0.00001f);
       
    }
    
    @Test
    public void testGetItemStats3() { 
        ItemStatsDAO isd = new ItemStatsDAO();
        Date startDate = new GregorianCalendar(2025, Calendar.JANUARY, 16).getTime();
        Date endDate = new GregorianCalendar(2025, Calendar.JANUARY, 18).getTime();
        
        ArrayList<ItemStats> lis = isd.getItemStats(startDate, endDate);
        Assert.assertNotNull(lis);
        
        Assert.assertEquals(1, lis.size());
        Assert.assertEquals(7, lis.get(0).getId());
        Assert.assertTrue(lis.get(0).getItemName().equalsIgnoreCase("Blender"));
        Assert.assertEquals(10, lis.get(0).getTotalQuantitySold());
        Assert.assertEquals(10.0f, lis.get(0).getTotalRevenue(), 0.00001f);
       
    }

    @Test
    public void testGetItemStats4() {
        ItemStatsDAO isd = new ItemStatsDAO();
        Date startDate = new GregorianCalendar(2025, Calendar.FEBRUARY, 16).getTime();
        Date endDate = new GregorianCalendar(2025, Calendar.FEBRUARY, 18).getTime();
        
        ArrayList<ItemStats> lis = isd.getItemStats(startDate, endDate);
        Assert.assertNotNull(lis);
        
        Assert.assertEquals(0, lis.size());
    }
    
}
