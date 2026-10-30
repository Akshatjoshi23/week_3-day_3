import java.util.*;
class Students{
    private final int id;
    private final String name;
    Students(int id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Students)){
            return false;
        }
        Students other = (Students) obj;
        return this.id == other.id;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
public class hashMapEquals {
    public static void main(String[] args) {
        Students s1=new Students(101,"Akshat");
        Students s2=new Students(101,"Aksh");
        Students s3=new Students(102,"Rohit");

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
    }
}
