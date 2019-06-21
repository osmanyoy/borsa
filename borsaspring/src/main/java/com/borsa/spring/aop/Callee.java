package com.borsa.spring.aop;

public class Callee {

    public String callMe(final String abc) throws Exception {
        if ("mehmet".equalsIgnoreCase(abc)) {
            throw new Exception("test exp");
        }
        return "hello " + abc;
    }
}