package com.liz.study.design;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/22 15:16
 */
public class 抽象工厂模式 {

    /**
     * 抽象工厂、具体工厂、抽象产品、具体产品
     */

}
interface AbstractFactory3
{
    public ConcreteProduct1 newProduct1();
    public ConcreteProduct2 newProduct2();
}

class ConcreteFactory3 implements AbstractFactory3 {
    public ConcreteProduct1 newProduct1() {
        System.out.println("具体工厂 1 生成-->具体产品 11...");
        return new ConcreteProduct1();
    }

    public ConcreteProduct2 newProduct2() {
        System.out.println("具体工厂 1 生成-->具体产品 21...");
        return new ConcreteProduct2();
    }
}
