package com.dubbo.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stony Created Date : 2016/4/21  11:01
 */
public abstract class JacksonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

    private static ObjectMapper mapper = new ObjectMapper();

    static{
        //设置序列化配置，为null的属性不加入到json中
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * 将对象转换成json字符串,如果转换失败则返回null
     * @param o 需要转换为json的对象
     * @return String 转换后的json字符串
     *
     * */
    public static String write2JsonStr(Object o){
        String jsonStr = "";
        try {
            jsonStr = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            logger.error("|JsonProcessingException|", e);
        }
        return jsonStr;
    }

    /**
     * 将对象转换成json字符串,如果转换失败则返回null
     * @param o 需要转换为json的对象
     * @return String 转换后的json字符串
     */
    public static String toJson(Object o){
        return write2JsonStr(o);
    }

    /**
     * 将json转换为对象 如果对象模版为内部类会出现问题，所以不要使用内部类
     * @param json 要转换的json
     * @param clazz 要映射的对象
     * @return 转换成的目标对象，如果转换失败返回null
     * */
    public static Object json2Object(String json, Class<?> clazz){
        return jsonConvertObject(json, clazz);
    }
    public static <T>T jsonConvertObject(String json, Class<T> clazz){
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonParseException e) {
            logger.error("|JsonParseException|异常字符串|" + json, e);
        } catch (JsonMappingException e) {
            logger.error("|JsonMappingException|异常字符串|" + json, e);
        } catch (IOException e) {
            logger.error("|IOException|异常字符串|" + json, e);
        }
        return null;
    }

    /**
     * 将json字符串转换为Map
     * @param  json 需要转换为Map的json字符串 {}开头结尾的
     * @return 转换后的map 如果转换失败返回null
     * */
    @SuppressWarnings("unchecked")
    public static Map<String,Object> json2Map(String json){
        try {
            if(json==null || json.length()==0) {
                return new HashMap<String,Object>() ;
            }
            return mapper.readValue(json,Map.class);
        } catch (JsonParseException e) {
            logger.error("|JsonParseException|异常字符串|" + json, e);
        } catch (JsonMappingException e) {
            logger.error("|JsonMappingException|异常字符串|" + json, e);
        } catch (IOException e) {
            logger.error("|IOException|异常字符串|" + json, e);
        }
        return new HashMap<String,Object>() ;
    }

    /**
     * 将json数组转换为List<Map<String,Object>> json数组格式[{},{}]
     * @param  jsonArray 需要转换的json数组
     * @return 转换后的列表   如果转换失败返回null
     * */
    @SuppressWarnings("unchecked")
    public static List jsonArray2List(String jsonArray){
        try {
            return mapper.readValue(jsonArray, List.class);
        } catch (JsonParseException e) {
            logger.error("|JsonParseException|异常字符串|" +  jsonArray, e);
        } catch (JsonMappingException e) {
            logger.error("|JsonMappingException|异常字符串|" +  jsonArray, e);
        } catch (IOException e) {
            logger.error("|IOException|异常字符串|" +  jsonArray, e);
        }
        return new ArrayList();
    }
}
