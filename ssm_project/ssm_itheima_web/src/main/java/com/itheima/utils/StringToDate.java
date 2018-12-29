package com.itheima.utils;

import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author duchengjun@itcast.cn
 * @date 2018/12/24
 */
public  class StringToDate implements Converter<String,Date>{
    @Override
    public  Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date parse = sdf.parse(source);
            return parse;
        } catch (ParseException e) {
            throw new RuntimeException("类型转换失败！");
        }
    }
}

