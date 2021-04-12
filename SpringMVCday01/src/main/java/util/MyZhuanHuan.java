package util;

import org.springframework.core.convert.converter.Converter;

public class MyZhuanHuan implements Converter<String,Integer> {
    @Override
    public Integer convert(String s) {
        return Integer.parseInt(s);
    }
}
