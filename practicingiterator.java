import java.util.*;
public class practicingiterator{
    public static void main(String[] args) {
        List<String> names=new ArrayList<>(
            Arrays.asList("Akshat","Paridhi","Raktabeej")
        );
        Iterator<String> iter=names.iterator();
        while(iter.hasNext()){
            if(iter.next().startsWith("A")){
                iter.remove();
            }
        }
        System.out.println(names);
    }
}