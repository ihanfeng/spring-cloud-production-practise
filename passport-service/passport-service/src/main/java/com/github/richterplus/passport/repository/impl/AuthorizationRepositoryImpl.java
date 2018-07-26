package com.github.richterplus.passport.repository.impl;

import com.github.richterplus.passport.entity.Authorization;
import com.github.richterplus.passport.repository.AuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
class AuthorizationRepositoryImpl implements AuthorizationRepository {

    @Autowired
    private RedisTemplate<String, Authorization> redisTemplate;

    private String key(String key) {
        return "auth_" + key;
    }

    @Override
    public Authorization getByAccessToken(String accessToken) {
        if (accessToken == null) return null;
        return redisTemplate.opsForValue().get(key(accessToken));
    }

    @Override
    public void create(Authorization authorization) {
        String key = key(authorization.getAccessToken());
        redisTemplate.opsForValue().set(key, authorization);
        redisTemplate.expireAt(key, authorization.getExpireDate());
    }
}
