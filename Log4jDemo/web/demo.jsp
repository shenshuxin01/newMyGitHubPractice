<%@ page import="java.util.regex.Pattern" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    //  [[%F0%9F%A4%AA]]
    String sourceStr="小绵羊[[%F0%9F%A4%AA]]";
//    String sourceStr="阿赫[[%F0%9F%A4%AA]][[%F0%9F%98%98]]";

    String pattern = ".*[[%.*]]";

    boolean matches = Pattern.matches(pattern, sourceStr);
    System.out.println(matches);


    String s1 = "F0";
    String s2 = "9F";
    String s3 = "A4";
    String s4 = "AA";
    int a1 = Integer.parseUnsignedInt(s1, 16);
    int a2 = Integer.parseUnsignedInt(s2, 16);
    int a3 = Integer.parseUnsignedInt(s3, 16);
    int a4 = Integer.parseUnsignedInt(s4, 16);
    byte[] bytes1 = {(byte) a1, (byte) a2, (byte) a3, (byte) a4};

    String utf8 = new String(bytes1, "utf8");
%>
<p>
    数据库的表情符合： <%= utf8 %>
</p>