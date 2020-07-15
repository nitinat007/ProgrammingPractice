package javaexamples.generics;

public class GenericsDemo {

   <T extends Number> GenericsDemo(T t){ //generic constructor
       System.out.println("Constructor creation: t is from "+t.getClass().getName()+ " class");
   }

    public static void main(String[] args) {
        System.out.println("\n** generic class demo **");
        Gen<String, Integer> obj = new Gen<>("Nitin", 1);
        System.out.println(obj.getName());
        System.out.println(obj.getValue());
        Gen<String, String> obj2 = new Gen<>("Aman", "One");
        System.out.println(obj2.getName());
        System.out.println(obj2.getValue());
        System.out.println("\n** generic method demo **");
        display(new String("SomeString"),new Integer(1));
        System.out.println("\n** generic constructor demo **");
        GenericsDemo gd= new GenericsDemo(new Integer("1"));
        GenericsDemo gd1= new GenericsDemo(new Double("1.1"));
    }

    static <T,U> void display(T t, U u){
        System.out.println("t is from "+t.getClass().getName()+ " class");
        System.out.println("u is from "+u.getClass().getName()+ " class");
    }
}

class Gen<T1, T2> {
    T1 name;
    T2 value;

    Gen(T1 o1, T2 o2) {
        name = o1;
        value = o2;
    }

    public T1 getName() {
        return name;
    }

    public T2 getValue() {
        return value;
    }
}

/*
** generic class demo **
Nitin
1
Aman
One

** generic method demo **
t is from java.lang.String class
u is from java.lang.Integer class

** generic constructor demo **
Constructor creation: t is from java.lang.Integer class
Constructor creation: t is from java.lang.Double class
 */
