import java.util.*;
interface Subscriber{
    void OnnewVideo(String title);
}
class YoutubeChannel{
    private final List<Subscriber> subscribers=new ArrayList<>();
    private final String name;
    YoutubeChannel(String name){
        this.name=name;
    }
    void subscribe(Subscriber subscriber){
        subscribers.add(subscriber);
    }
    void unsubscribe(Subscriber subscriber){
        subscribers.remove(subscriber);
    }
    void newVideo(String title){
        System.out.println(name+" uploaded a new video: "+title);
        for(Subscriber subscriber:subscribers){
            subscriber.OnnewVideo(title);
        }
    }
}
class User implements Subscriber{
    private final String Username;
    User(String username){
        this.Username=username;
    }
    @Override
    public void OnnewVideo(String title){
        System.out.println(Username+" received notification for new video: "+title);
    }
}
public class ObserverPaternExample {
    public static void main(String[] args) {
        YoutubeChannel channel=new YoutubeChannel("TechWorld");
        User user1=new User("Alice");
        User user2=new User("Bob");
        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.newVideo("Observer Pattern in Java");
        channel.unsubscribe(user1);
        channel.newVideo("Adapter Pattern in Java");
    }
    
} 