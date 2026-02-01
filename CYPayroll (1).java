// Name: Camellia Yi
// Date: 10/07/2025
// Class: CS&141 3130
// Assignment:  Lab #2 - Payroll
// Purpose:  Create a program to calculate employee income. 
// Citation: This program references chapter 3 of Deitel/Deitel - 11th edition
// For extra credit, I did this ....., See the following line numbers.
// I got all this working, but I couldn't get this to work. 

import java.util.Scanner; // To prompt user input

public class CYPayroll {
   public static void main(String[] args) {
   
   //Code organization -> Put all variables in beginning to easily locate them
   //NOTE: Some variables will need to be declared in the loop because they will change as each loop passes
   Scanner input = new Scanner(System.in);
   
   System.out.print("\nWelcome to the Cammy's Shop Payroll!\n\n");
   System.out.print("Number of employees for payroll: ");
   int employees = input.nextInt(); // accepts user input for employees variable (Number of employees) 
   
   int count = 0;
   
   while (count < employees) {
      count++;
          
            System.out.print("Enter employee's name: ");
            String employeeName = input.next();
            
            System.out.println("\nJob Code:\n Salary=1\n Hourly = 2");
            System.out.print("Is the employee Salary or Hourly: ");
            int paymentType = input.nextInt();
            
            double netPay = 0;
            
            if (paymentType == 1){
               
               System.out.print("Please enter " + employeeName + "'s salary: ");
               
               double salary = input.nextDouble();
               netPay = salary * 0.85;
            } else if (paymentType == 2) {
            
               System.out.println("Enter the number of hours worked by " + employeeName + ":");
               double hours = input.nextDouble();
               
               System.out.println("Enter " + employeeName + "'s hourly rate: ");
               double hourlyRate = input.nextDouble();
               
               double grossPay;
               if (hours > 40) {
                  double overtime = hours - 40;
                  double regularTime = 40;
                  grossPay = (overtime * (hourlyRate * 1.5)) + (regularTime * hourlyRate);
               } else {
                   grossPay = hours * hourlyRate;
               }
               
               netPay = grossPay * 0.85;
            }
           
           System.out.println("Employee name: " + employeeName);
           System.out.println("Net Pay: $" + netPay);
       }
       
    }
}