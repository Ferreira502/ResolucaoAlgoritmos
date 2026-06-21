import java.util.*;

class Main 
{
    public static void main ( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] pais = new String[100];
        String[] frase = new String[100];
        String palavra;
        int x = 0, y = 0;

        while ( n > 0) 
        {
            palavra = sc.nextLine();
            pais[x] = palavra;
            x++;
            palavra = sc.nextLine();
            frase[y] = palavra;
            y++;

            n--;    
        }

        n = sc.nextInt();
        sc.nextLine();

        while ( n > 0) 
        {
            palavra = sc.nextLine();
            System.out.println(palavra + "");
            palavra = sc.nextLine();

            for ( int i = 0; i < y; i++)
            {
                if ( palavra.compareTo(pais[i]) == 0) 
                {
                    System.out.println(frase[i]);
                }
            }

            System.out.println();

            n--;
        }
    }
    
}