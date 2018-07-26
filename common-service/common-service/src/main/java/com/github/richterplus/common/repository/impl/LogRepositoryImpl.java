package com.github.richterplus.common.repository.impl;

import com.github.mybatisq.Query;
import com.github.richterplus.common.entity.Log;
import com.github.richterplus.common.mapper.LogMapper;
import com.github.richterplus.common.mapper.LogTable;
import com.github.richterplus.common.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
class LogRepositoryImpl implements LogRepository {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void create(Log log) {
        logMapper.insert(log);
    }

    @Override
    public List<Log> listByDate(Date startInclusive, Date endExclusive) {

        LogTable l = LogTable.log;
        Query<LogTable> query = l.query();

        if (startInclusive != null) {
            query.where(l.log_date.ge(startInclusive));
        }

        if (endExclusive != null) {
            query.where(l.log_date.lt(endExclusive));
        }

        return logMapper.select(query);
    }
}
