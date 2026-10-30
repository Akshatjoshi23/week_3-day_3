import java.util.HashMap;
public class hashMapPractice {
    public static void main(String[] args) {
     HashMap <String,Integer> map = new HashMap<>();
     map.put("Akshat", 1);
     map.put("Rahul", 2);
     map.put("Rohit", 3);
     System.out.println(map.get("Akshat"));
     map.put("Rahul", 4);
     map.remove("Aman");
     System.out.println(map.size());
     System.out.println(map);
    }
}
