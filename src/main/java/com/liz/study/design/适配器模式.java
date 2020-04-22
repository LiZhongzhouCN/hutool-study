package com.liz.study.design;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/22 15:27
 */
public class 适配器模式 {


}

//目标接口
interface Target
{
    public void request();
}
//适配者接口
class Adapter
{
    public void specificRequest()
    {
        System.out.println("适配者中的业务代码被调用！");
    }
}
//类适配器类
class ClassAdapter extends Adapter implements Target
{
    public void request()
    {
        specificRequest();
    }
}
//客户端代码
class ClassAdapterTest
{
    public static void main(String[] args)
    {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}


//对象适配器类
class ObjectAdapter implements Target
{
    private Adapter adaptee;
    public ObjectAdapter(Adapter adaptee)
    {
        this.adaptee=adaptee;
    }
    public void request()
    {
        adaptee.specificRequest();
    }
}
//客户端代码
class ObjectAdapterTest
{
    public static void main(String[] args)
    {
        System.out.println("对象适配器模式测试：");
        Adapter adaptee = new Adapter();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}