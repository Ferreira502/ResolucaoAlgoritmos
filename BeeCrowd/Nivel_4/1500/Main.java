import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t > 0)
        {
            int n = sc.nextInt();
            int c = sc.nextInt();

            int[] array = new int[n + 1];

            while (c > 0)
            {
                int x = sc.nextInt();

                if (x == 0)
                {
                    int p = sc.nextInt();
                    int q = sc.nextInt();
                    int v = sc.nextInt();

                    for (int i = p; i <= q; i++)
                    {
                        array[i] += v;
                    }
                }
                
                else if (x == 1)
                {
                    int p = sc.nextInt();
                    int q = sc.nextInt();

                    int cont = 0;
                    for (int i = p; i <= q; i++)
                    {
                        cont += array[i];
                    }

                    System.out.println(cont);
                }

                c--;
            }

            t--;
        }
    }
}