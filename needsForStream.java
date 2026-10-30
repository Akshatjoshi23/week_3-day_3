import java.util.*;
public class needsForStream {
    public static void main(String[] args) {
        //if we want to calculate the sum of all numbers in an arraylist
        List<Integer> nums = Arrays.asList(4,5,7,3,2,6);
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        System.out.println("sum using loop: " + sum);

        //similiarly we can use stream to calculate the sum of all numbers in an arraylist
        int sum2=nums.stream().mapToInt(Integer::intValue).sum();//Using method reference to convert Integer to int and then calculate the sum
        System.out.println("sum2 using stream: " +sum2);

        //Same thing can be done using lambda expression
        int sum3=nums.stream().mapToInt(n->n).sum();//Using lambda
        System.out.println("sum3 using stream: " +sum3);
    }
}
