import java.util.*; 

class Main 
{
 
    public static void main(String[] args) 
    {
 
        Scanner sc = new Scanner(System.in);
        
        int n = 5;
        int x = sc.nextInt();
        int y = 0;
        int cont = 0;
        
        for ( int i = 0; i < n; i++ )
        {
            y = sc.nextInt();
            
            if ( y == x )
            {
                cont++;
            }
        }
        
        System.out.println(cont + "");
 
    }
 
}