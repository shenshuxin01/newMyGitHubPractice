import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 遍历某个文件下的文件夹 并且改名
 */

public class DemoFile {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\workTemporaryDir");
        FileInputStream inputStream =null;
        FileOutputStream outputStream=null;
        byte[] bytes = new byte[1024*10];

        File[] files = file.listFiles()[1].listFiles();
        ArrayList<String[]> list = new ArrayList<>();
        list.add(new String[]{"as.txt","001.pdf"});
        list.add(new String[]{"oraclerownameold.pdf","002.pdf"});

        //循环在数据库取数据
        for (int k = 0; k< list.size(); k++) {

            String databaseFileName = list.get(k)[0];

        for (int i = 0; i < files.length; i++) {

            if (/*"oraclerownameold.pdf"*/databaseFileName.equals(files[i].getName())){
                System.out.println("============================");
                System.out.println(i+"  "+files[i].getName());

                inputStream = new FileInputStream(files[i]);
                File tempFile = File.createTempFile("databaseFileName", ".pdf", new File("D:\\workTemporaryDir/newfile"));
                outputStream = new FileOutputStream(tempFile);

                while (true){
                    int read = inputStream.read(bytes, 0, 1024 * 10);
                    if (!(-1 != read)) break;
                    outputStream.write(bytes,0,read);
                    outputStream.flush();
                }
                outputStream.close();
                inputStream.close();

                boolean b = tempFile.renameTo(new File("D:\\workTemporaryDir/newfile/"+list.get(k)[1]));
                System.out.println("是否成功"+b);
            }

    }
        }
  }
}
