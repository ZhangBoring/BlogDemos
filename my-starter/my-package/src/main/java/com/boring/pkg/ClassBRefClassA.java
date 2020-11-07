package com.boring.pkg;

/**
 * @author boring
 * @date 2020/8/6 下午1:27
 */
public class ClassBRefClassA {

    private ClassA cA;

    public ClassA getcA() {
        return cA;
    }

    public void setcA(ClassA cA) {
        this.cA = cA;
    }

    public void print() {
        System.out.println(cA.getStr());
    }
}
