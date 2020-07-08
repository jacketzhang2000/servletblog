package frank.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import frank.exceeption.SystemException;
import frank.model.Result;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @author 张益月
 * @version 1.0Exception in thread "main" java.lang.NullPointerException
 * @date 2020/3/7 19:57
 */
public class JSONUtil {
    private static final String DATE_PATTERN="yy-MM-dd HH:mm:ss";
//序列化操作
    public static String serialize(Object obj){
        ObjectMapper mapper=new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
             throw new SystemException(Contant.JSON_ERROR_CODE,"JSON序列化失败："+obj,e);

        }
    }
//反序列化操作
    public static <T> T deserialize(String json,Class<T> clazz){
        ObjectMapper mapper=new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
        try {
            return mapper.readValue(json,clazz);
        } catch (IOException e) {
            throw new SystemException(Contant.JSON_ERROR_CODE,"JSON字符串反序列化失败",e);

        }
    }
    public static <T> T deserialize(InputStream is, Class<T> clazz){
        ObjectMapper mapper=new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
        try {
            return mapper.readValue(is,clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON字符串反序列化失败",e);

        }
    }

    public static void main(String[]  args) {
        Result result=new Result();
        result.setCode("xxx001");
        result.setMessage("发表文章出错");
        result.setData("文章数据");
        String json=serialize(result);
        System.out.println(json);
        Result r2=deserialize(json,Result.class);
        System.out.println(r2);
    }
}
