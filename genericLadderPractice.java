import java.util.*;
class Box<T> {//Generic  Box class
    private T value;
    Box(T value){
        this.value=value;
    }
    public void setValue(T value){
        this.value=value;
    }
    public T getValue(){
        return value;
    }
}
//Generic method to print an array
class GenericPrint{
    public static <T> void printArray(T[] array){
        for(T element:array){
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
class SumCalc{
    public static double sum(List<? extends Number> list){
        double sum=0;
        for(Number n:list){
            sum+=n.doubleValue();
        }
        return sum;
    }
}
class copyList{
    public static void copyInt(List<? super Integer> dest){
        dest.add(1);
        dest.add(2);
        dest.add(3);
    }
}
class MaxFinder{
    public static <T extends Comparable<T>> T findMax(T[] arr){
        T max=arr[0];
        for(T element:arr){
            if(element.compareTo(max)>0){
                max=element;
            }
        }return max;
    }
}
public class genericLadderPractice {
    public static void main(String[] args){
        Box<Integer> it=new Box<>(5);
        System.out.println(it.getValue());

        Box<String> st=new Box<>("Hello");
        System.out.println(st.getValue());
        Integer[] intArr=   {1,2,3,4,5};
        String[] strArr={"Hello","World"};
        GenericPrint.printArray(intArr);
        GenericPrint.printArray(strArr);
        List<Integer> intList=Arrays.asList(1,2,3,4,5);
        List<Double> doubleList=Arrays.asList(1.1,2.2,3.3);
        System.out.println("Sum of integers: "+SumCalc.sum(intList));
        System.out.println("Sum of doubles: "+SumCalc.sum(doubleList));
        List<Number> numberList = new ArrayList<>();
        copyList.copyInt(numberList);
        System.out.println("Copied integers: ");
        GenericPrint.printArray(numberList.toArray()); 

        Integer[] intArr2={1,2,3,4,5};
        String[] strArr2={"Hello","World"};
        System.out.println("Max of integers: "+MaxFinder.findMax(intArr2));
        System.out.println("Max of strings: "+MaxFinder.findMax(strArr2));
    }
}
