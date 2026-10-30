import java.util.*;
public class hashmapPractic {
    public static void main(String[] args){
        int[] arr={1,2,2,3,3,3,4,5};
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        System.out.println("Frequency of each element: " + map);
    }
}
