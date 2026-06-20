import java.util.*;

class Main
{

    public static void main (String[] args) 
    {
        
            Scanner sc = new Scanner(System.in);
            int n = 0;
            int x = 0;
            String palavra;
            
            n = sc.nextInt();
            
            String[] conjunto = new String[n];
            
        
            int diferentes = 0;
        
            for ( int i = 0; i < n; i++ )
            {
                conjunto[i] = sc.next();
                boolean repetido = false;
            
                for( int j = 0; j < i; j++ )
                {
                    if ( conjunto[i].compareTo(conjunto[j] ) == 0 )
                    {
                        repetido = true;
                    }
                }

                if ( repetido == false )
                {
                    x++;
                }
            }
        
            int resultado = 151 - x;
            
            System.out.printf("Falta(m) %d pomekon(s).", resultado);
    }
}