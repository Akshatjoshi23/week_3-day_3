import java.util.*;
class GradeCalculator{
    double calculateAverage(int[] marks){
        if(marks == null || marks.length==0){
            throw new IllegalArgumentException("Marks must not be empty");
        }
        int sum=0;
        for(int m: marks) sum+=m;
        return(double) sum/marks.length;
    }
}
class ReportCardFormatter{
    String format(String name, double avg){
        return "Report card -> "+name+ ": "+avg;
    }
}
class reportCardRepository{
    private final List<String> storage=new ArrayList<>();
    void saVE(String reportCard){
        storage.add(reportCard);
    }
}
class ParentNotifier{
    void notifyParent(String phone, String reportCard){
        System.out.println("SMS to "+ phone + ": "+reportCard);
    }
}
public class cohesionExample {
    public static void main(String[] args) {
        GradeCalculator calculator=new GradeCalculator();
        ReportCardFormatter reportCardFormatter=new ReportCardFormatter();
        reportCardRepository report=new reportCardRepository();
        ParentNotifier parentNotifier=new ParentNotifier();
        double avg=calculator.calculateAverage(new int[]{60,79,57,20});
        String card=reportCardFormatter.format("Akshat", avg);
        report.saVE(card);
        parentNotifier.notifyParent("9893253980", card);

    }
    
}
