interface Shape{
    void draw();
}
class Circle implements Shape{
    public void draw(){System.out.println("Drawing Circle...");}
}
class Square implements Shape{
    public void draw(){System.out.println("Drawing Square...");}
}
class Triangle implements Shape{
    public void draw(){System.out.println("Drawing triangle...");}
}
enum ShapeType{
    CIRCLE,TRIANGLE,SQUARE;
}//without factory each screen has its own copy of if else
class ScreenA{
    void show(ShapeType type){
        Shape s;
        if(type == ShapeType.CIRCLE) s=new Circle();
        else if(type==ShapeType.SQUARE) s=new Square();
        else throw new IllegalArgumentException("Screen A cant built "+type);
        s.draw();
    }
}
class ScreenB{
    void show(ShapeType type){
        Shape s;
        if(type == ShapeType.CIRCLE) s=new Circle();
        else if(type==ShapeType.TRIANGLE) s=new Triangle();
        else throw new IllegalArgumentException("Screen A cant built "+type);
        s.draw();
    }
}
//with factory
class ShapeFactory{
    static Shape create(ShapeType type){
        if(type==null) throw new IllegalArgumentException("Type is required");
        switch (type) {
            case CIRCLE: return new Circle();
            case SQUARE: return new Square();
            case TRIANGLE: return new Triangle();
            default:throw new IllegalArgumentException("UNSUPPORTED "+type);
        }
    }
}
class GoodScreen{
    void show(ShapeType type){
        Shape s=ShapeFactory.create(type);
        s.draw();
    }
}
public class FactoryPattern {
    public static void main(String[] args) {
        new ScreenB().show(ShapeType.TRIANGLE);
        try {
            new ScreenA().show(ShapeType.TRIANGLE);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Bug: "+e.getMessage());
        }
        new GoodScreen().show(ShapeType.CIRCLE);
        new GoodScreen().show(ShapeType.TRIANGLE);
    }
}
