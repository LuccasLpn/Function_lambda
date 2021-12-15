package employe;

import entities.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Employe {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a full path: ");
        String path = sc.nextLine();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
           String line = br.readLine();
           List<Employee> list = new ArrayList<>();
           while(line != null){
           String [] fields = line.split(",");
           list.add(new Employee(fields [0], fields[1], Double.parseDouble(fields[2])));
           line = br.readLine();
           }
           
        Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
        System.out.println("Email of people whose salary is more than ");
        Double salary2 = sc.nextDouble();
        
        List<String> email = list.stream()
                .filter(p -> p.getSalary() > salary2)
                .map(p -> p.getEmail())
                .sorted(comp)
                .collect(Collectors.toList());
        
            System.out.println("");
            
            email.forEach(System.out::println);
            
           Double salary = list.stream()
                   .filter(p -> p.getName().charAt(0) == 'M')
                   .map(x -> x.getSalary())
                   .reduce(0.0, (x, y) -> x + y);
                   System.out.println("Sum of salary from people whose name starts with 'M': " + String.format("%.2f", salary));
                   
           
                   
                    
            
        } catch (IOException e) {
            
            System.out.println("Error: " + e.getMessage());
            
        }
        
}
}
