import java.util.*;
interface RouteStrategy{
    int estimateTime(int km);
}
class walkingRoute implements RouteStrategy{
    public int estimateTime(int km){return km *12;}
}
class cyclingRoute implements RouteStrategy{
    public int estimateTime(int km){return km *4;}
}
class DrivingRoute implements RouteStrategy{
    public int estimateTime(int km){return km*2;}
}
class Navigator{
    private RouteStrategy strategy;
    Navigator(RouteStrategy strategy){
        this.strategy=strategy;
    }
    void setStrategy(RouteStrategy strategy){
        this.strategy=Objects.requireNonNull(strategy, "Strategy is required");
    }
    void showEta(int km){
        System.out.println(km+" km -> "+strategy);
    }
}

public class StrategyCode {
    public static void main(String[] args) {
        Navigator nav=new Navigator(new walkingRoute());
        nav.showEta(5);
        nav.setStrategy(new cyclingRoute());
        nav.showEta(5);
        nav.setStrategy(new DrivingRoute());
        nav.showEta(5);

        nav.setStrategy(km -> 3+km);
        nav.showEta(5);
    }
    
}
