package com.liz.study.clone;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.clone.Cloneable;

/**
 * @author liz
 * @Description:
 * @date: 2020/3/27 10:38
 */
public class Clone {
    /**
     * 实现接口
     */
    private static class Cat implements Cloneable<Cat> {
        private String name = "miaomiao";
        private int age = 2;

        @Override
        public Cat clone() {
            try {
                return (Cat) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new CloneRuntimeException(e);
            }
        }
    }

    /**
     * 继承
     */
    private static class Dog extends CloneSupport<Dog> {
        private String name = "wangwang";
        private int age = 3;
    }
}
