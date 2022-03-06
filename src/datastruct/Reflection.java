package datastruct;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflection {
    public static void main(String[] args){

        test test = new test(4);
        son _son = new son(3);
        System.out.println("son a = "+_son.getA());
        System.out.println("son b = "+_son.b);

        son son = new son(1);
        son.setA(1);
        try {
            Constructor constructor = son.class.getConstructor(int.class);
            son son1 = null;
            try {
                son1 = (son)constructor.newInstance(1);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            printClassInfo(son.class);
            System.out.println(son1.b);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
class test{
    private int a;
    {
        a = 1;
        System.out.println("test init a =" + a);
    }
    public test(){
        System.out.println("a = "+a);
        System.out.println("test无参调用");
    }

    public test(int a){
        this.a = a;
        System.out.println("a = "+a);
        System.out.println("test有参调用");
    }

    public int getA(){
        return a;
    }
    public void setA(int a){
        this.a = a;
    }
}
class son extends test{
    public int b;
    public son(int b){
        //super();
        super(2);
        this.b = b;
        this.setA(2);
    }
}