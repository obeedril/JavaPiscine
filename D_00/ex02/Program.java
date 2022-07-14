import java.util.Scanner;

public class Program {
    static int primeNumber(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return (0);
        }
        return (1);
    }

    public static void main(String[] args) {

        int x = 0;
        int sum = 0;
        int num = 0;
        Scanner s = new Scanner(System.in);
        while (x != 42) {
            System.out.println("Please enter some integer:");
            x = s.nextInt();
            if (x == 42)
                break;
            if (x <= 1) {
                System.err.println("IllegalArgument!");
               // System.exit(-1);
            } else {
                while (x > 0) {
                    sum += x % 10;
                    x /= 10;
                }
                num += primeNumber(sum);
                sum = 0;
             }
            }
        System.out.println("Count of coffee-request - "+num);
        }
}
