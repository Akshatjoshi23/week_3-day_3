interface Printer{
    void print(String text);
}
class ScreenPrinter implements  Printer{
    public void print(String text){System.out.println("Screen: "+text);}

}
class LoudPrinter implements  Printer{
    public void print(String text){System.out.println("LOUD: "+text);}
}
 
//WITHOUT DEPENDENCY INJECTION picks its own printer
class Greeter1{
    private final Printer printer=new ScreenPrinter();
    void greet(String name){printer.print("Helloooo: "+name);}
}

//With DEPENDENCY INJECTION
class Greeter2{
    private final Printer printer;
    Greeter2(Printer printer){
        this.printer=printer;
    }
    void greet(String name){
        printer.print("Helloouoou: "+name);
    }
}
public class DependencyInj {
    public static void main(String[] args) {
        new  Greeter1().greet("Akshat");
        new Greeter2(new ScreenPrinter()).greet("Akshat");
        new Greeter2(new LoudPrinter()).greet("Akshat");
    }
    
}
