import java.util.Objects;

class Emplo{
    private final int id;
    private final String name;
      Emplo(int id,String name){
        this.id=id;
        this.name=name;
     }

     @Override 
     public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(!(obj instanceof Emplo)){
            return false;
        }

        Emplo other = (Emplo) obj;
        return this.id == other.id;
     }
        public int hashCode(){
            return Objects.hash(id);
        }
}
public class m {
   public static void main(String[] args){
        Emplo e1=new Emplo(101, "Akshat");
        Emplo e2=new Emplo(101,"Akshat");
        System.out.println(e1.equals(e2));
        System.out.println(e1==e2);

        String name="Mohammed";
        name.concat("Shami");
        System.err.println(name);
        System.out.println(name.concat("kaif"));
    }
    
}
