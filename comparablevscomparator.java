import java.util.*;
class Studen implements Comparable<Studen>{
    int marks;
    String name;
    Studen(int marks , String name){
        this.marks=marks;
        this.name=name;

    }
    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
    @Override 
    public int compareTo(Studen other){
        return Integer.compare(this.marks, other.marks);
    }
}
public class comparablevscomparator {
    public static void main(String[] args){
        List<Studen> students=new ArrayList<>();
        students.add(new Studen(99, "Aksh"));
        students.add(new Studen(100,"Aman"));
        Collections.sort(students);
        System.out.println(students);
    }
    
}
