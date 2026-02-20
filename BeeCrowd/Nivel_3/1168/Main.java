import java.util.Scanner;

public class Main 
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int[] leds = 
        {
            6,2,5,5,4,5,6,3,7,6
        };

        for(int i = 0; i < N; i++) 
        {

            String numero = sc.nextLine().trim();
            int total = 0;

            for(int j = 0; j < numero.length(); j++) 
            {
                char c = numero.charAt(j);
                int digito = c - '0';
                total += leds[digito];
            }

            System.out.println(total + " leds");
        }

        sc.close();
    }
}
