package com.dubbo.common.constants;

import java.io.IOException;
import java.util.Date;

import com.dubbo.common.util.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Jackson 日期格式序列化 yyyy-MM-dd HH:mm:ss
 * <pre class="code">
 *     @JsonSerialize(using = DateTime2StringSerializer.class)
 *     public Date getDate(){
 *         return date;
 *     }
 * </pre>
 *
 * @author: Stony  Date: 2016/4/15 Time: 11:22
 */
public class DateTime2StringSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(DateUtils.dateTime2string(date));
    }
}
