import java.util.*;
class Employee implements Comparable<Employee>{
   String name; int salary; int age;
    Employee(String name,int salary,int age){
          this.name=name;
          this.salary=salary;
          this.age=age;
     }
     @Override 
     public int compareTo(Employee e){
          return this.salary-e.age;
     }
     public String toString(){
            return "Name: "+name+" Salary: "+salary+" Age: "+age;
     }
}
public class Comparatordemo {
    public static void main(String[] args){
        List<Employee> list=new ArrayList<>();
        list.add(new Employee("Alice",50000,30));
        list.add(new Employee("Bob",60000,25));
        list.add(new Employee("Charlie",55000,35));

        Collections.sort(list);
        System.out.println("Comparable (age) " +list);

        //Comparator to sort by salary
        list.sort((a,b) -> a.salary-b.salary);
        System.out.println("Comparator (salary) " +list);

        //chained comparator to sort by salary then age
        list.sort(Comparator.comparingInt((Employee e) -> e.salary).thenComparingInt(e -> e.age));
        System.out.println("Chained Comparator (salary then age) " +list);
    }
}
