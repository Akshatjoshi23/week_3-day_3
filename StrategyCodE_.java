interface FeeStrategy{
    double totalWithFee(double amount);
}
class UpiFee implements FeeStrategy{
   public  double totalWithFee(double amount){return amount;}
}
class CardFee implements FeeStrategy{
    public double totalWithFee(double amount){return amount *1.02;}
}
class NetBanking implements FeeStrategy{
    public double totalWithFee(double amount){ return amount +10;}
}
public class StrategyCodE_ {
    public static void main(String[] args) {
        
    }
}
