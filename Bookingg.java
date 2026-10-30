import java.util.*;
class BookingService{
    double calculateTotal(int seats){
        double total=seats*250;
        if(seats>=4){
            total-=total*0.85;
        }
        return total;
    }
}
class BookingRepository{
    private final List<String> db=new ArrayList<>();
    void save(String name,int seats, double total){
        db.add((name+":"+ seats +":"+total));
    }

}
public class Bookingg {
    public static void main(String[] args) {
        
    }
    
}
