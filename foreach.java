import java.util.*;
import java.util.function.Consumer;
public class foreach {
    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(4,5,7,3,2,6);
        Consumer<Integer> con=(Integer n) -> {
            System.out.println(n);
        };
        nums.forEach(con);
    }
}
