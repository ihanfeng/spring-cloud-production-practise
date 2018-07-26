package com.github.richterplus.passport.repository;

import com.github.richterplus.passport.entity.Authorization;

public interface AuthorizationRepository {

    Authorization getByAccessToken(String accessToken);

    void create(Authorization authorization);
}
