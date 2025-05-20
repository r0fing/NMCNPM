
import dao.UserDAO;
import model.User;
import org.junit.Assert;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class UserDAOTest {
    
    @Test
    public void testCheckLogin1() {
        UserDAO ud = new UserDAO();
        User u = new User();
        u.setUsername("manager1");
        u.setPassword("M123");
        
        boolean check = ud.checkLogin(u);
        Assert.assertEquals(true, check);
        Assert.assertEquals("Nguyen Xuan Kien", u.getName());
        Assert.assertEquals("Manager", u.getRole());
        Assert.assertEquals("0912345678", u.getPhone());
        Assert.assertEquals("man1@gmail.com", u.getEmailAddress());
    }
    
    @Test
    public void testCheckLogin2() {
        UserDAO ud = new UserDAO();
        User u = new User();
        u.setUsername("manager1");
        u.setPassword("M1234");
        
        boolean check = ud.checkLogin(u);
        Assert.assertEquals(false, check);
    }
    
    @Test
    public void testCheckLogin3() {
        UserDAO ud = new UserDAO();
        User u = new User();
        u.setUsername("manager2");
        u.setPassword("M123");
        
        boolean check = ud.checkLogin(u);
        Assert.assertEquals(false, check);
    }
    
    @Test
    public void testCheckLogin4() {
        UserDAO ud = new UserDAO();
        User u = new User();
        u.setUsername("manager");
        u.setPassword("M234");
        
        boolean check = ud.checkLogin(u);
        Assert.assertEquals(false, check);
    }
}
