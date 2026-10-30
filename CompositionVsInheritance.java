import java.util.ArrayList; 
import java.util.List; 

// INHERITANCE: Borrowed ArrayList just to reuse add/remove
class BadStack<T> extends ArrayList<T> { // Fixed typo here
    void push(T item) { 
        add(item); 
    } 
    T pop() { 
        return remove(size() - 1); 
    } 
} 

class SimpleStack<T> { 
    private final List<T> items = new ArrayList<>(); 
    
    void push(T item) { 
        items.add(item); 
    } 
    
    T pop() { 
        if (items.isEmpty()) throw new IllegalStateException("Stack is empty"); 
        return items.remove(items.size() - 1); 
    } 
    
    int size() { 
        return items.size(); 
    } 
} 

interface Engine { 
    String start(); 
} 

class PetrolEngine implements Engine { 
    public String start() { 
        return "Vroom (petrol)"; 
    } 
} 

class ElectricEng implements Engine { 
    public String start() { 
        return "HUmmmmm(Electric)"; 
    } 
} 

class Car { 
    private Engine engine; 
    
    Car(Engine engine) { 
        this.engine = engine; 
    } 
    
    void setEngine(Engine engine) { 
        this.engine = engine; 
    } 
    
    void Drive() { 
        System.out.println(engine.start()); 
    } 
} 

public class CompositionVsInheritance { 
    public static void main(String[] args) { 
        // Inheritance leaks: anyone can break stack rules
        BadStack<String> bad = new BadStack<>(); 
        bad.push("A"); 
        bad.push("B"); 
        bad.push("C"); 
        System.out.println(bad); 
        
        // Composition protects
        SimpleStack<String> good = new SimpleStack<>(); 
        good.push("A"); 
        good.push("B"); 
        good.push("C"); 
        System.out.println(good.pop()); 
        System.out.println(good.size()); 
        
        Car car = new Car(new PetrolEngine()); 
        car.Drive(); 
        car.setEngine(new ElectricEng()); 
        car.Drive(); 
    } 
}
