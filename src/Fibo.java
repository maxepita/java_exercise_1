import java.util.Scanner;

public class Fibo implements Command{
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scan) {
        try {
            System.out.println("Entrez un nombre n:");
            String n_string = scan.nextLine();
            int n = Integer.parseInt(n_string);
            System.out.println(fibo(n));
        } catch (StackOverflowError ignored){

            System.out.println("Nombre trop grand");
        }
        return false;
    }
    public static int fibo(int n){
        if(n <= 1) {
            return n;
        }
        int fib = 1;
        int fib2 = 1;

        for(int i=2; i<n; i++) {
            int temp = fib;
            fib+= fib2;
            fib2 = temp;
        }
        return fib;
    }
}