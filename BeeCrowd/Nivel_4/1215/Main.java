import java.util.*;

class Main 
{
    public static void main ( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        String palavra;
        String[] conjunto = new String[1000];
        int x = 0;
        int y = 0;
        String organiza = "";

        while ( sc.hasNext() ) 
        {
            palavra = sc.next();

            for ( int i = 0; i < palavra.length(); i++ )
            {
                char c = palavra.charAt(i);

                if ( c >= 'A' && c <= 'Z' ||  c >= 'a' && c <= 'z' ) 
                {
                    if ( c >= 'A' && c <= 'Z' )
                    {
                        c = (char)(c + 32);   
                    }
                    organiza += c;
                }

                else
                {   
                    if ( organiza.length() > 0 )
                    {
                        conjunto[x] = organiza;
                        x++;
                        organiza = "";
                    }
                }
            }

            if ( organiza.length() > 0 )
            {
                conjunto[x] = organiza;
                x++;
                organiza = "";
            }
        }

        for ( int i = 0; i < x - 1; i++ )
        {
            for ( int j = i + 1; j < x; j++ )
            {

                if ( conjunto[i].compareTo(conjunto[j]) > 0)
                {
                    String tmp = conjunto[i];
                    conjunto[i] = conjunto[j];
                    conjunto[j] = tmp;
                }
                
            }
        }
    
        for ( int l = 0; l < x; l++ )
        {
            if ( l == 0 || conjunto[l].compareTo(conjunto[l - 1]) != 0 )
            {
                System.out.println(conjunto[l]);
            }
        }
    }
}
