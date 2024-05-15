package org.example.util;

import com.google.protobuf.GeneratedMessageV3;
import org.springframework.data.redis.serializer.SerializationException;

import java.lang.reflect.Method;

public class ProtoBufUtil {

    /**
     * 使用proto序列化javabean
     */
    public static byte[] serialize(GeneratedMessageV3 messageV3) {
        return messageV3.toByteArray();
    }

    /**
     * 使用proto反序列化javabean
     */
    public static <T> T deserialize(byte[] bytes, Class<T> target) {
        if (bytes.length == 0) {
            return null;
        }
        try {
            Method method = target.getMethod("parseFrom", bytes.getClass());
            return (T) method.invoke(target, new Object[]{bytes});
        } catch (Exception ex) {
            throw new SerializationException("Cannot deserialize", ex);
        }
    }
}
