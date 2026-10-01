import java.util.*;

public class Conditional {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Write a Java program to get a number from the user and print whether it is positive or negative.

        // System.out.println("Enter a number : ");
        // int num = sc.nextInt();

        // if(num>0){
        //     System.out.println("The Number is Positive :)");
        // }else if(num<0){
        //     System.out.println("The Number is Negative :)");
        // }


        // Finish the following code so that it prints You have a fever if your temperature is above 100 and otherwise prints You don't have a fever.
        // double temp = 103.5;

        // if(temp>100){
        //     System.out.println("You have a FEVER !!");
        // }else{
        //     System.out.println("You don't have a FEVER :)");
        // }


        // Write a Java program to input week number(1-7) and print day of week name using switch case.

        // System.out.println("Enter a Week day number between 1-7 : ");
        // int num = sc.nextInt();

        // switch (num) {
        //     case 1: System.out.println("Sunday");                
        //         break;
             
        //     case 2: System.out.println("Monday");                
        //         break;
                
        //     case 3: System.out.println("Tuesday");                
        //         break;
                
        //     case 4: System.out.println("Wednesday");                
        //         break;
                
        //     case 5: System.out.println("Thursday");                
        //         break;
                
        //     case 6: System.out.println("Friday");                
        //         break;
                
        //     case 7: System.out.println("Saturday");                
        //         break;    
        
        //     default: System.out.println("Wrong Input number");
        //         break;
        // }


        // Write a Java program that takes a year from the user and print whether that year is a leap year or not.

        System.out.println("Enter a Year : ");
        int year = sc.nextInt();

        if(year % 4 == 0){
            if (year % 100 != 0) {
                System.out.println("This is a Leap Year");
            }else if (year % 400 == 0) {
                System.out.println("This is a Leap Year");
            }else{
                System.out.println("This is NOT a Leap Year");
            }
        }else{
            System.out.println("This is NOT a Leap Year");
        }
    }
}
