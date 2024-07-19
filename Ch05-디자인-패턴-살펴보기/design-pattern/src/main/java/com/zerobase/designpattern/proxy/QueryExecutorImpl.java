package com.zerobase.designpattern.proxy;

public class QueryExecutorImpl implements QueryExecutor {
    @Override
    public void execute(String sql) {
        System.out.println(sql+" 실행");
    }
}
