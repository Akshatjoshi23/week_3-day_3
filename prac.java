import java.util.HashMap;
public class prac {
    void main(){
        HashMap<Integer,String> map=new HashMap<>();
        map.put(101,"Akshat");
        map.put(102,"Amit");
        System.out.println(map.get(101));

        String name="java";
        System.out.println(name.hashCode());
        int hash=name.hashCode();
        hash=hash ^ (hash>>>16);

        int n=16; // HashMap's default initial table capacity
        int bucketIndex=(n-1)&hash;
        System.err.println(bucketIndex);
    }
    
}
