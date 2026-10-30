//This is our socket
interface Exporter{
    void export(String data);
}
//This is plug
class pdfExporter implements Exporter{
    @Override 
    public void export(String data){
        System.out.println("PDF : "+data);
    }
}
class csvExporter implements Exporter{
    @Override 
    public void export(String data){
        System.out.println("CSV : "+data);
    }
}
class reportGenerator{
    private final Exporter exp;
    reportGenerator(Exporter exp){
        this.exp=exp;
    }
    void generate(String title){
        String data="Report: "+title;
        exp.export(data);
    }
}
public class Demo{
    public static void main(String[] args){
        reportGenerator pdfRe=new reportGenerator(new pdfExporter());
        reportGenerator csvRe=new reportGenerator(new csvExporter());
        pdfRe.generate("Sales");
        csvRe.generate("Sales");
    }
}