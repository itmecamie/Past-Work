// Name: Camellia Yi
// Date: 10/16/2025
// Class: CS&141 3130
// Assignment:  Lab #3 - CY_Payroll_Two
// Purpose:  Create an interactive payroll program.  You will prompt the user for number of employees, salary type, and, if necessary, hours worked, and pay-rate.  From that, you will calculate their gross and net pay of each individual employee.  
// Citation: This program references chapter 3 of Deitel/Deitel - 11th edition
// For extra credit, I did this ....., See the following line numbers.
// I got all this working, but I couldn't get this to work. 

import java.util.Scanner; // To prompt user input

public class CY_Payroll_Two {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
   System.out.print("\nWelcome to the Cammy's Second Shop Payroll!\n\n");
   System.out.print("Please enter payee ID: ");
      
      int total = 0; //initializes sum of employees
   
   int number = input.nextInt(); // accepts user input for employee variable (Who is salary and who is hourly) 
   
   int count = 0;
   
   for (int numberCounter = input.nextInt(); number >= 5; number++) {
      if (number > 5) {
            break;
      }
      System.out.printf("Employee is Salaried Employee");
   }
   
    for (int numberCounter = input.nextInt(); number <= 5; number++) {
      if (number < 5) {
            continue;
      }
      System.out.printf("Employee is Hourly Employee");
   }
   
   int average = total / 10;
            
            System.out.printf("\nTotal of Employees: %d%n", total);
            System.out.printf("Staff Average is %d%n", average);
            
           
            
            switch (number) {
            
            case 1:
               number = "1";
               break;
               
            case 2:
               number = "2";
               break;
               
            case 3:
               number = "3";
               break;
               
            case 4:
               number = "4";
               break;
               
            case 5:
               number = "5";
               break;
               
            case 6:
               number = "6";
               break;
               
            case 7:
               number = "7";
               break;
               
            case 8:
               number = "8";
               break;
               
            case 9:
               number = "9";
               break;
               
            case 10:
               number = "10";
               break;
               
      default:
         number = "Invalid Number";
                          }
                          
  System.out.print("This employee is: #" + number);
                   }
              }