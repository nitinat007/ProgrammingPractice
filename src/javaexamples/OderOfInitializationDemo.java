package javaexamples;


    interface Superinterface {
        int STATIC_FINAL3 = new OderOfInitializationDemo().getInt();
        int STATIC_FINAL5 = new OderOfInitializationDemo().getInt5();
        static void staticMethod() {
            System.out.println("Superinterface: staticMethod");
        }
    }
    class ObjectReference {
        ObjectReference() {
            System.out.println("ObjectReference: constructor");
        }
    }
    class Superclass {
        static {
            System.out.println("Superclass: static initializer");
        }
        {
            System.out.println("Superclass: instance initializer");
        }
        Superclass () {
            System.out.println("Superclass: constructor");
        }
    }
    class Subclass extends Superclass implements Superinterface {
        static final int STATIC_FINAL = 47;
        static final int STATIC_FINAL2 = (int) (Math.random() * 5);

        //static String stringLiteral = "hello";
        //public static int STATIC_FINAL4 = new ClassInitializationDemo().getInt();

        ObjectReference objectReference = new ObjectReference();
        static {
            System.out.println("Subclass: static initializer");
            //staticFinal = 47;
        }
        Subclass () {
            System.out.println("Subclass: constructor");
        }

        {
            System.out.println("Subclass: instance initializer");
        }
    }

    public class OderOfInitializationDemo {
        {
            System.out.println("\nOderOfInitializationDemo: instance initializer");
        }
        static {
            System.out.println("\nOderOfInitializationDemo: static initializer (Initialization Stage)");
        }
        static int getInt() {
            System.out.println("OderOfInitializationDemo: getInt()");
            return 3;
        }
        static int getInt5() {
            System.out.println("OderOfInitializationDemo: getInt5()");
            return 5;
        }
        public static void main(String[] args) throws Exception {
            System.out.println("\nJVM invoked the main method ... ");
            System.out.println("Subclass.STATIC_FINAL: " + Subclass.STATIC_FINAL);
            //System.out.println("Subclass.stringLiteral: " + Subclass.stringLiteral);
            System.out.println("Invoking Subclass.STATIC_FINAL2  ... ");
            System.out.println("Subclass.STATIC_FINAL2: " + Subclass.STATIC_FINAL2);
            System.out.println("\nInstantiating Subclass ...");
            new Subclass();
            System.out.println("Superinterface.STATIC_FINAL3: " + Superinterface.STATIC_FINAL3);
            //Superinterface.staticMethod();
        }
    }
    /*
O/P:
OderOfInitializationDemo: static initializer (Initialization Stage)

JVM invoked the main method ...
Subclass.STATIC_FINAL: 47
Invoking Subclass.STATIC_FINAL2  ...
Superclass: static initializer
Subclass: static initializer
Subclass.STATIC_FINAL2: 3

Instantiating Subclass ...
Superclass: instance initializer
Superclass: constructor
ObjectReference: constructor
Subclass: instance initializer
Subclass: constructor

OderOfInitializationDemo: instance initializer
OderOfInitializationDemo: getInt()

OderOfInitializationDemo: instance initializer
OderOfInitializationDemo: getInt5()
Superinterface.STATIC_FINAL3: 3
     */


