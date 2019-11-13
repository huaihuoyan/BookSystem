package com.huai.booksystem.unit;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间的数据格式的处理
 * @Author: laiyunjing
 * @Date: 2019/11/13 0013 17:23
 * @Version 1.0
 */
public class DateUnit extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        jsonGenerator.writeString(sdf.format(date));
    }
}
