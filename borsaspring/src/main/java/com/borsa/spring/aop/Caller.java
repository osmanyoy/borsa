package com.borsa.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;

public class Caller {

    @Autowired
    private Callee callee;

    public void callOther() throws Exception {
        String callMeLoc = this.callee.callMe("osman");
        System.out.println(callMeLoc);
        callMeLoc = this.callee.callMe("mehmet");
        System.out.println(callMeLoc);

    }

}