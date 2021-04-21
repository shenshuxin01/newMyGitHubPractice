package ssxlog4j;

import java.util.regex.Pattern;

class Test{
    public static void main(String[] args) {
    String sourceStr="小绵羊[[%F0%9F%A4%AA]]";
//        String sourceStr = "[[%F0%9F%98%99]]";
//    String sourceStr="[[";
        System.out.println(getFace(sourceStr));
    }

     /**
      * 此方法功能是：把字符串转换为表情，此表情采用utf8编码集。
      *         输入小绵羊[[%F0%9F%A4%AA]]，输出小绵羊🤪
      * @param sourceStr 输入值，表中字段：微信昵称nick_name
      * @return
      */
    public static String getFace(String sourceStr) {

        try {
            StringBuilder returnStr = new StringBuilder();
            if (zhengzeFun(sourceStr)) {
                boolean flag = false;

                for (int i = 0; i < sourceStr.length(); i++) {
                    char c = sourceStr.charAt(i);
                    if (c=='[' && i <= sourceStr.length()-16 && sourceStr.charAt(i+1)=='['){
                        String substring = sourceStr.substring(i + 2, i + 2 + 12);
                        if (zhengzeFun(substring)){
                            flag = true;
                            returnStr.append(addFace(substring));
//                            System.out.println(substring);
//                            System.out.println(returnStr);
                        }
                    }else {
                        if (!flag || (c==']' && sourceStr.charAt(i-1)==']')){
                            if(flag){
                                flag = false;
                                continue;
                            }
                            returnStr.append(c);
                        }
                    }

                }
                return returnStr.toString();
            }else {
                return sourceStr;
            }

        }catch (Exception e){
            return sourceStr;
        }
    }

    private static boolean zhengzeFun(String s) throws Exception{
        String pattern = ".*" +
                "%[a-z0-9A-Z][a-z0-9A-Z]" +
                "%[a-z0-9A-Z][a-z0-9A-Z]" +
                "%[a-z0-9A-Z][a-z0-9A-Z]" +
                "%[a-z0-9A-Z][a-z0-9A-Z].*";
//        System.out.println(pattern);
        return Pattern.matches(pattern, s);
    }

    private static String addFace(String s)  throws Exception{
        String[] split = s.split("%");
//        System.out.println("addFace===="+s);
        byte[] bytes = new byte[4];
        for (int i = 1; i < split.length; i++) {
            bytes[i-1] = (byte) Integer.parseUnsignedInt(split[i],16);
//            System.out.println("i:"+i+", 0x:"+split[i]+", 10:"+Integer.parseUnsignedInt(split[i],16)+", 2:"+(byte) Integer.parseUnsignedInt(split[i],16));
        }
        String returnString = "";
        try {
            returnString = new String(bytes, "UTF-8");
//            System.out.println("转换到表情:"+new String(bytes,"utf8"));
        } catch (Exception e) {
            System.out.println("转换表情失败，addFace方法失败");
        }
        return returnString;
    }
}
