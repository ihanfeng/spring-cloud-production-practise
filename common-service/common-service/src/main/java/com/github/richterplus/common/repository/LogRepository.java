package com.github.richterplus.common.repository;

import com.github.richterplus.common.entity.Log;

import java.util.Date;
import java.util.List;

public interface LogRepository {

    void create(Log log);

    List<Log> listByDate(Date startInclusive, Date endExclusive);
}
