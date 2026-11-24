import java.util.Scanner;

public class Pa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int temp = num;
        int reverse = 0;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;

            reverse = reverse * 10 + digit;
            sum = sum + digit * digit * digit;

            temp = temp / 10;
        }

        if (num == reverse) {
            System.out.println("Palindrome Number");
        } else {
            System.out.println("Not a Palindrome Number");
        }

        if (num == sum) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }

        sc.close();
    }
}