package com.github.richterplus.passport.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

@Configuration
class RedisConfig {

    private static final String KEY_PREFIX = "passport_";

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        redisTemplate.setKeySerializer(new RedisSerializer<String>() {
            @Override
            public byte[] serialize(String s) throws SerializationException {
                return (KEY_PREFIX + s).getBytes();
            }

            @Override
            public String deserialize(byte[] bytes) throws SerializationException {
                return new String(bytes).substring(KEY_PREFIX.length());
            }
        });

        redisTemplate.setValueSerializer(new RedisSerializer<Object>() {
            @Override
            public byte[] serialize(Object o) throws SerializationException {
                JSONObject json = (JSONObject) JSON.toJSON(o);
                Class<?> clazz = o.getClass();
                while (clazz.isAnonymousClass()) {
                    clazz = clazz.getSuperclass();
                }
                json.put("@@className", clazz.getName());
                return json.toJSONString().getBytes();
            }

            @Override
            public Object deserialize(byte[] bytes) throws SerializationException {
                if (bytes == null) {
                    return null;
                }
                JSONObject json = JSON.parseObject(new String(bytes));
                try {
                    return JSON.parseObject(json.toJSONString(), Class.forName(json.getString("@@className")));
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return redisTemplate;
    }
}
