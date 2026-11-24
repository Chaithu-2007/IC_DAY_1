import java.util.Scanner;

public class Calculator {
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the 1st number:");
    int a=sc.nextInt();
    System.out.println("Enter the 2nd number:");
    int b=sc.nextInt();
    System.out.println("Enter the operator(+,-,/,*):");
    char c=sc.next().charAt(0);
    int result;
    switch (c) {
        case '+' :
            result=a+b;
            System.out.println(result);
            
            break;
        case '-' :
            result=a-b;
            System.out.println(result);
            
            break;
        case '/' :
            result=a/b;
            System.out.println(result);
            
            break;
        case '*' :
            result=a*b;
            System.out.println(result);
            
            break;            
        default:
            System.out.println("invalid operator");
    }
    sc.close();
    }

    }




