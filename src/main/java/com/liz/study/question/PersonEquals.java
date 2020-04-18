package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/9 10:44
 */
public class PersonEquals {
        private String name;
        private String addr;

        public PersonEquals(String name, String addr) {
            this.name = name;
            this.addr = addr;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public boolean equals(Object another) {

            //先判断是不是自己,提高运行效率
            if (this == another)
                return true;

            //再判断是不是Person类,提高代码的健壮性
            if (another instanceof PersonEquals) {

                //向下转型,父类无法调用子类的成员和方法
                PersonEquals anotherPerson = (PersonEquals) another;

                //最后判断类的所有属性是否相等，其中String类型和Object类型可以用相应的equals()来判断
                if ((this.getName().equals(anotherPerson.getName())) && (this.getAddr() == anotherPerson.getAddr()))
                    return true;
            } else {
                return false;
            }

            return false;
        }
    }
