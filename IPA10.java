import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IPA10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        for(int i=0;i<n;i++){
            int id=sc.nextInt();
            
            sc.nextLine();
            String name= sc.nextLine();
            String branch = sc.nextLine();

            double rating = sc.nextDouble();
            boolean transport = sc.nextBoolean();

            employees[i] = new Employee(id, name, branch, rating, transport);
        }
        sc.close();

        int count = countEmpTransport(employees);
        System.out.println(count);

        Employee emp = find2ndRating(employees);
        System.out.println(emp.getId());
        System.out.println(emp.getRating());
    }

    public static Employee find2ndRating(Employee[] employees){
        List<Employee> res = new ArrayList<>();

        for(Employee emp : employees){
            res.add(emp);
        }

        if(res.isEmpty()) return null;
        else{
            res.sort((l1,l2)->Double.compare(l2.getRating(), l1.getRating()));
            return res.get(1);
        }
    }

    public static int countEmpTransport(Employee[] employees){
        int count = 0;

        for(Employee emp : employees){
            if(emp.getTransport()){
                count++;
            }
        }

        return count;
    }
}

class Employee{
    int id;
    String name;
    String branch;
    double rating;
    boolean transport;

    Employee(int id,String name, String branch, double rating, boolean transport){
        this.id=id;
        this.name=name;
        this.branch=branch;
        this.rating=rating;
        this.transport=transport;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getBranch(){
        return this.branch;
    }
    public double getRating(){
        return this.rating;
    }
    public boolean getTransport(){
        return this.transport;
    }
}
