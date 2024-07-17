public class Polymorphism {

    public static void main(String arg[])
    {
        Base b = new Child();
        System.out.println(b.add(2,4));// output=2
        //Child c =  new Base();// Compile time error
        Child c = (Child) new Base();//Run time error - ClassCastException
        System.out.println(c.add(2,4));

    }

}

class Base{
    int a;
    int b;

    public int add(int a,int b)
    {
        return a+b;
    }

}

class Child extends Base{
    int a;
    int b;

    public int add(int a, int b)
    {
        return a;
    }

}

interface A
{
    int a = 100;//By default static and final
}

class B implements A
{
    public static void main(String[] args) {
        //a = 200;//can't override final variable
    }

}




