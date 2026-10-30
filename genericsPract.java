import java.util.*;
class Gen<T>{
    private T value;
    public void setValue(T value){
        this.value=value;
    }
    public T getValue(){
        return value;
    }

    public static <T> void printValue(T value){
        System.out.println(value);
    }

    void printList(List<?> list){
        for(Object obj:list){
            System.out.println(obj);
        }
    }

}
class Calculator<T extends Number>{
    public double add(T a,T b){
        return a.doubleValue()+b.doubleValue();
    }
    double sum(List<? extends Number> list){
        double sum=0;
        for(Number n:list){
            sum+=n.doubleValue();
        }
        return sum;
    }
    void sumNum(List<? super Integer> list){
        int sum=0;
        for(Object obj:list){
            if(obj instanceof Integer){
                sum+=((Integer)obj).intValue();
            }
        }
        System.out.println("Sum of Integers: "+sum);
    }
}
class Mult<T extends Number & Comparable<T>>{
    public double multiply(T a,T b){
        return a.doubleValue()*b.doubleValue();
    }
}
public class genericsPract {
    public static void main(String[] args){
        Gen<Integer> g1=new Gen<>();
        g1.setValue(10);
        System.out.println(g1.getValue());

        Gen<String> g2=new Gen<>();
        g2.setValue("Hello");
        System.out.println(g2.getValue());
        Gen.printValue(10);
        Gen.printValue("Hello");

        Calculator<Double> calc=new Calculator<>();
        System.out.println(calc.add(5.44, 10.56));

        Mult<Double> mult=new Mult<>();
        System.out.println(mult.multiply(5.44, 10.56));

        System.out.println(calc.sum(Arrays.asList(1, 2, 3, 4, 5)));
        g1.printList(Arrays.asList(1,2,3,4,5));

        calc.sumNum(Arrays.asList(1, 2, 3, 4, 5));
    }
}
