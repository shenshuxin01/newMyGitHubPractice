import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TDemo {
    @Test
    public   void main1() {
        String format = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss").format(new Date());
        System.out.println(format);
        System.out.println(format.length());
    }
}
