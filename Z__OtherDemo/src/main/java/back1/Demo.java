package back1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ssxbase?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            Statement stat = conn.createStatement();
            String format = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss").format(new Date());
            stat.executeUpdate(" insert into user values ('main-jar' , '"+
                    format
                    +"' ) ");
            stat.execute("commit ");
            stat.close();
            conn.close();
            System.out.println("main插入成功："+format);
            System.out.println("main参数显示开始：");
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]+"  ");

            }
            System.out.println("main参数显示结束：");

        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

}
