import java.util.*;
interface MessageSender{
    void send(String to,String body);
}
class EmailClient implements MessageSender{
    public void send(String to,String body)
    {
        System.out.println("Email to "+to+": "+body);}
}
class FakeSender implements MessageSender{
    private final List<String> sent=new ArrayList<>();
    public void send(String to,String body){
        sent.add(to+":"+body);
    }
    List<String> getSent(){
        return List.copyOf(sent);
    }
}
class WelcomeService{
    private final MessageSender sender;
    WelcomeService(MessageSender sender){
        this.sender=sender;
    }
    void welcome(String email){
        sender.send(email,"Welcome abroad!");
    }

}
public class DI {
    public static void main(String[] args) {
        new WelcomeService(new EmailClient()).welcome("akshat13@gmail.com");
        FakeSender fake=new FakeSender();
        new WelcomeService(fake).welcome("Paridhi43@gmail.com");
        System.out.println(fake.getSent());
    }
    
}
