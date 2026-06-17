import java.util.*;

class Ex
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = 0;
        int[] array = new int[100]; 
        int[] descartados = new int[100]; 


        int primeiro = 0;
        int ultimo = n;
        int x = 0;

        while ( n != 0)
        {
            for ( int i = 0; i < n; i++ )
            {
                array[i] = i + 1;
            }



            while ( ultimo - primeiro > 1 )
            {
                descartados[x] = array[primeiro];
                x++;
                primeiro++;

                array[ultimo] = array[primeiro];
                ultimo++;
                primeiro++;
            }
        
        }
        System.out.println("Discarded cards: ");

        for (int i = 0; i < x; i++) 
        {
            System.out.println(array[i] +"");

            if (i < x - 1) 
            {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.println("Remaining card: " + array[primeiro]);
        
    }
}