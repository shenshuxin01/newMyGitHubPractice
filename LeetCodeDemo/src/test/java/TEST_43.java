import junit.framework.TestCase;
import org.junit.Test;

public class TEST_43 extends TestCase {
    @Test
    public void testFun(){
        int i = 1231 % 10;
        //取个位
        assert i==1;
    }
}
