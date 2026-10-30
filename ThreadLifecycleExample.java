class Hi extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Hi,im from class Hi");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Thread interrupted : "+e);
            }
        }
    }
}
class Hello extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Hello, I am from class hello");
        }
    }

}
public class ThreadLifecycleExample{
    public static void main(String[] args) {
        Hi obj=new Hi();
        Hello obj1=new Hello();
        obj.setPriority(1);
        obj1.setPriority(10);
        
        obj.start();
        
        obj1.start();
    }
}