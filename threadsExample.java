class A implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("HI , I am from class A");
            try{
                Thread.sleep(1000);

            }catch(InterruptedException e){
                System.out.println("thread interrupted: "+e);
            }
        }
    }
}
class B implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Hi , I am from class B");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Thread Interrupted: "+e);
            }
        }
}}
public class threadsExample {
    public static void main(String[] args) {
        Runnable obj1=new A();
        Runnable obj2=new B();

        Thread t1=new Thread(obj1);
        Thread t2=new Thread(obj2);
        t1.start();
        t2.start();
        
    }
}
