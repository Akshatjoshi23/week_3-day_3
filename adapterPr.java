import java.util.*;
interface PaymentProcessor{
    boolean pay(String customer,double rupees);
}
//This class we cant edit
class OLDBankApi{
    String makeTransaction(String account, int paise){
        System.out.println("OLDBank: debit "+ paise+" paise from"+account);
        return paise>0 ?"OK" : "FAIL";
    }
}
class OLDBankAdapter implements PaymentProcessor{
    private final OLDBankApi api;
    OLDBankAdapter(OLDBankApi api){
        this.api=Objects.requireNonNull(api,"api is required");
    }
    @Override  
    public boolean pay(String customer,double rupees){
        int paise=(int)Math.round(rupees*100);
        String result=api.makeTransaction(customer, paise);
        return"OK".equals(result);
    }
}
class UpiProcessor implements PaymentProcessor{
    @Override 
    public boolean pay(String customer,double rupees){
        System.out.println("UPI: "+rupees+" From "+customer);
        return true;
    }
}
class CheckoutService {
    private final PaymentProcessor processor;
    CheckoutService(PaymentProcessor processor){
        this.processor=Objects.requireNonNull(processor);
    }
    void checkOut(String customer,double rupees){
        System.out.println(processor.pay(customer, rupees)?"PAID":"PAYMENT FAILED");
    }
}
public class adapterPr{
    public static void main(String[] args) {
        new CheckoutService(new UpiProcessor()).checkOut("AKshat", 10000);
        new CheckoutService(new OLDBankAdapter(new OLDBankApi())).checkOut("AMAN", 2000);
    }
}