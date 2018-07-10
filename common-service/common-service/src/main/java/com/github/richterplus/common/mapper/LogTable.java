package com.github.richterplus.common.mapper;

import com.github.mybatisq.Column;
import com.github.mybatisq.Join;
import com.github.mybatisq.Query;
import com.github.mybatisq.Table;

public class LogTable extends Table {

    private LogTable() {
        super("log", "l");
    }

    public static final LogTable log = new LogTable();

    public Query<LogTable> query() {
        return new Query<>(log);
    }

    public <T extends Table> Join<LogTable, T> inner(T table) {
        return new Join<>("inner", this, table);
    }

    /**
     * 日志id
     */
    public Column<LogTable, Integer> log_id = new Column<>("log_id");

    /**
     * 客户端id
     */
    public Column<LogTable, String> client_id = new Column<>("client_id");

    /**
     * 客户端版本号
     */
    public Column<LogTable, String> client_version = new Column<>("client_version");

    /**
     * 用户id
     */
    public Column<LogTable, Integer> user_id = new Column<>("user_id");

    /**
     * 日志类型
     */
    public Column<LogTable, Integer> log_type = new Column<>("log_type");

    /**
     * 关联对象id
     */
    public Column<LogTable, String> object_ids = new Column<>("object_ids");

    /**
     * 日志内容
     */
    public Column<LogTable, String> message = new Column<>("message");

    /**
     * 日志记录日期
     */
    public Column<LogTable, java.util.Date> log_date = new Column<>("log_date");
}