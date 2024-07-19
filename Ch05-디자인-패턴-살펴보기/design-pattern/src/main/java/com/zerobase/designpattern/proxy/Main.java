package com.zerobase.designpattern.proxy;

import org.springframework.context.annotation.Bean;

public class Main {
    private QueryExecutor readonlyQueryExecutor;

    public Main(QueryExecutor readonlyQueryExecutor) {
        this.readonlyQueryExecutor = readonlyQueryExecutor;
    }

    public void query(String sql){
        readonlyQueryExecutor.execute(sql);
    }

    public static void main(String[] args) {
        QueryExecutor queryExecutor = new QueryExecutorImpl();
        QueryExecutor readonlyQueryExecutor = new ReadonlyQueryExecutor(queryExecutor);

        readonlyQueryExecutor.execute("select * from user where id = 1");
        readonlyQueryExecutor.execute("update user set name='hello' where id = 1");
        readonlyQueryExecutor.execute("delete from user where id = 1");
    }

    @Bean
    public QueryExecutor queryExecutor(){
        return new QueryExecutorImpl();
    }

    @Bean
    public ReadonlyQueryExecutor readonlyQueryExecutor(QueryExecutor queryExecutor){
        return new ReadonlyQueryExecutor(queryExecutor);
    }
}
