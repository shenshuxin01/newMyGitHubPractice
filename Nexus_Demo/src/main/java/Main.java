import jdk.nashorn.internal.parser.JSONParser;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.util.JsonParserSequence;

public class Main {
    public static void main(String[] args){
        String json="[\n" +
                " \n" +
                "  {\n" +
                " \n" +
                "    \"name\":\"张国立\",\n" +
                " \n" +
                "    \"sex\":\"男\",\n" +
                " \n" +
                "    \"email\":\"zhangguoli@123.com\",\n" +
                " \n" +
                "    \"url\":\"./img/1.jpg\"\n" +
                " \n" +
                "  },\n" +
                " \n" +
                "  {\n" +
                " \n" +
                "    \"name\":\"张铁林\",\n" +
                " \n" +
                "    \"sex\":\"男\",\n" +
                " \n" +
                "    \"email\":\"zhangtieli@123.com\",\n" +
                " \n" +
                "    \"url\":\"./img/2.jpg\"\n" +
                " \n" +
                "  },\n" +
                " \n" +
                "  {\n" +
                " \n" +
                "    \"name\":\"邓婕\",\n" +
                " \n" +
                "    \"sex\":\"女\",\n" +
                " \n" +
                "    \"email\":\"zhenjie@123.com\",\n" +
                " \n" +
                "    \"url\":\"./img/3.jpg\"\n" +
                " \n" +
                "  },\n" +
                " \n" +
                "  {\n" +
                " \n" +
                "    \"name\":\"张国立\",\n" +
                " \n" +
                "    \"sex\":\"男\",\n" +
                " \n" +
                "    \"email\":\"zhangguoli@123.com\",\n" +
                " \n" +
                "    \"url\":\"./img/4.jpg\"\n" +
                " \n" +
                "  },\n" +
                " \n" +
                "  {\n" +
                " \n" +
                "    \"name\":\"张铁林\",\n" +
                " \n" +
                "    \"sex\":\"男\",\n" +
                " \n" +
                "    \"email\":\"zhangtieli@123.com\",\n" +
                " \n" +
                "    \"url\":\"./img/5.jpg\"\n" +
                " \n" +
                "  },\n" +
                " \n" +
                "  {\n" +
                " \n" +
                "    \"name\":\"邓婕\",\n" +
                " \n" +
                "    \"sex\":\"女\",\n" +
                " \n" +
                "    \"email\":\"zhenjie@123.com\",\n" +
                " \n" +
                "    \"url\":\"./img/6.jpg\"\n" +
                " \n" +
                "  }\n" +
                " \n" +
                "]";
     }
}
