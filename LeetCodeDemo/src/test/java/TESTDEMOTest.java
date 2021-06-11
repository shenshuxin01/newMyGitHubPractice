import junit.framework.TestCase;

import java.util.HashMap;

public class TESTDEMOTest extends TestCase {

    public void testTestMain() {
        {
            System.out.println(1);
        }
        Integer a=86;
        String s = "" + a;
        System.out.println(s);


        assertEquals(1,1);
    }
}