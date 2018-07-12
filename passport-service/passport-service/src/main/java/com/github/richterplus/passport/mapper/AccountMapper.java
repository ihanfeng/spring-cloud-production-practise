package com.github.richterplus.passport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.mybatisq.Query;
import com.github.richterplus.passport.entity.Account;

@Mapper
public interface AccountMapper {

    int count(Query<AccountTable> query);

    List<Account> select(Query<AccountTable> query);

    int insert(Account account);

    int batchInsert(@Param("entityList") List<Account> account);

    int update(Account account);

    int batchUpdate(@Param("entityList") List<Account> account);

    int delete(@Param("accountId") Integer accountId);

}