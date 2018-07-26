package com.github.richterplus.passport.repository;

import com.github.richterplus.passport.entity.Account;

public interface AccountRepository {

    Account getByUsername(String username);

    void create(Account account);
}
