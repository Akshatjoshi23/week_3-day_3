import java.util.*;
class Employee{
     String name;
    private int[] ratings;

    Employee(String name,int[] ratings){
        this.name=name;
        this.ratings=ratings;
    }
    public String getName(){
        return name;
    }
    public double calculateAverage(){
        int total=0;
        for(int rating: ratings){
            total +=rating;
        }
        return (double) total/ratings.length;
    }

    public String getPerformance(){
        double avg=calculateAverage();
        if(avg>=9) return "Excellent";
        else if(avg>=7) return "Good";
        else if(avg>=5) return "Average";
        else return "Needs improvement";
    }

    public void display(){
        System.out.println("Name: " + name);
        System.out.println("Average Rating: " +calculateAverage());
        System.out.println("Performance: " + getPerformance());
    }

    class SeniorEmployee extends Employee{
        SeniorEmployee(String name,int[] ratings){
            super(name, ratings);
        }
        @Override
        public void display(){
            System.out.println("=== Senior Employee ===");
            super.display();
        }
    }
}
public class CoreJavaPractice{
    public static void main(String[] args) {
        int[] ratings = {8,9,10};
        Employee e1=new Employee("Akshat", ratings);
        e1.display();
    }
}