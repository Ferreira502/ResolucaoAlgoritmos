import java.util.*;

class Main
{
    public static void main ( String[] args)
    {
        Scanner sc = new Scanner ( System.in );
        
        while ( sc.hasNext() ) 
        {
            int n = 0;
            n = sc.nextInt();

            int[] array = new int[n];

            for (int i = 0; i < n; i++) 
            {
                array[i] = sc.nextInt();
            }

            int cont = 0;

            for ( int i = 0; i < n; i++ )
            {   
                for ( int j = 0; j < i; j++)
                {
                    if ( array[j] > array[i]) 
                    {
                        cont++;
                    }
                }
            }

            System.out.println(cont + "");
            
        }
    }
}

// fazer um selecao no array e achar o menor
// depois pegar o menor contar quantos tem na frente dele e contar
// tirar o menor do array
// e repetir isso ate que não tenha mais nada no array