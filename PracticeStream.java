import java.util.*;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
class Emp{
    String name;
    String Department;
      Emp(String name,String Department){
        this.name=name;
        this.Department=Department;
      }

      @Override 
      public String toString(){
        return "Name=" + name + ". Department= "+ Department;
      }
}
public class PracticeStream {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>(Arrays.asList("Akshat", "Akanksha", "Aman"));
        List<String> result=a.stream()
                        .filter(str -> str.contains("A"))
                        .collect(Collectors.toList());
        System.out.println(result);
        List<Integer> b= Arrays.asList(1,34,5,7665,754);
        int res=b.stream()
                .filter(n-> n>0)
                .map(n->n*2)
                .reduce(0,(c,e) -> c+e);
        
        System.out.println(res);

        List<Emp> employees=Arrays.asList(
            new Emp("Akshat","Java Backend"),
            new Emp("Paridhi","Java BAckend"),
            new Emp("Parikshit","Front End")

        );
        Map<String , List<Emp>> aj=employees.stream().collect(Collectors.groupingBy(employee -> employee.Department ));
        System.out.println(aj.toString());
    }
}
