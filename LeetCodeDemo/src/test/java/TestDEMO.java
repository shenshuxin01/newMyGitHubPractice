import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TestDEMO extends TestCase {

    @Test
    public void testMain() {
        System.out.println("*********测试使用*********");
        System.out.println(new Date().getTime());
        
    }

    @Before
    public void testMai(){
        System.out.println("先执行");
    }

    @After
    public void testF(){
        System.out.println("后执行");
    }

}
