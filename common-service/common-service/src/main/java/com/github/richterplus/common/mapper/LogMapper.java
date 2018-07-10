package com.github.richterplus.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.mybatisq.Query;
import com.github.richterplus.common.entity.Log;

@Mapper
public interface LogMapper {

    int count(Query<LogTable> query);

    List<Log> select(Query<LogTable> query);

    int insert(Log log);

    int batchInsert(@Param("entityList") List<Log> log);

    int update(Log log);

    int batchUpdate(@Param("entityList") List<Log> log);

    int delete(@Param("logId") Integer logId);

}