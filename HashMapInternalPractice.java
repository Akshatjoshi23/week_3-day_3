import java.util.*;
public class HashMapInternalPractice {
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        System.out.println(map.get("Alice")); // Output: 25
        int hash=map.hashCode();
        System.out.println("Hash code of the map: "+hash);
        int spreadHash=hash^(hash>>>16);
        System.out.println("Spread hash code of the map: "+spreadHash);
        int index=spreadHash & (map.size()-1);
        System.out.println("Index for the map: "+index);
    }
}
