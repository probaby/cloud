package com.example.bean.vo;

public class TestA {
    TestB testB;

    public TestA(TestB testB) {

        this.testB = testB;
    }

    public void a() {
        testB.b();
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }

}
