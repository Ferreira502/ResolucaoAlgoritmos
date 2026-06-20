import java.util.*;

class Main 
{
    public static void main ( String[] args )
    {
        Scanner sc = new Scanner ( System.in );

        int n = 0;
        int m = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        while ( n != 0 && m != 0 ) 
        {
            int[] array = new int[10000];
            int[] impar = new int[10000];
            int[] par = new int[10000];

            int x = 0; 
            int y = 0;
            int z = 0;
            int l = 0;


            for ( int i = 0; i < n; i++ )
            {
                array[i] = sc.nextInt();

                if ( array[i] % 2 == 0 )
                {
                    par[x] = array[i];
                    x++;
                }

                else 
                {
                    impar[y] = array[i];
                    y++;
                }
            }

            for ( int i = 0; i < x - 1; i++)
            {
                for ( int j = i + 1; j < x; j++ )
                {
                    if ( (par[i] % m ) > par[j] % m )
                    {
                        int tmp = par[i];
                        par[i] = par[j];
                        par[j] = tmp;
                    }
                    
                    else if ( ( par[i] % m ) == par[j] % m )
                    {
                        if ( par[i] > par[j] )
                        {
                            int tmp = par[j];
                            par[j] = par[i];
                            par[i] = tmp;
                        }
                    }
                }
            }

            for ( int i = 0; i < y - 1; i++)
            {
                for ( int j = i + 1; j < y; j++ )
                {
                    if ( (impar[i] % m ) > impar[j] % m )
                    {
                        int tmp = impar[i];
                        impar[i] = impar[j];
                        impar[j] = tmp;
                    }

                    else if ( ( impar[i] % m ) == impar[j] % m )
                    {
                        if ( impar[i] < impar[j] )
                        {
                            int tmp = impar[j];
                            impar[j] = impar[i];
                            impar[i] = tmp;
                        }
                    }
                }
            }
        

            System.out.println(n + " " + m);

            for ( int i = 0; i < n; i ++ )
            {

                if ( z == x )
                {
                    array[i] = impar[l];
                    l++;
                }

                else if ( l == y )
                {
                    array[i] = par[z];
                    z++;
                }
                    
                else if ( ( par[z] % m) > impar[l] % m )
                {
                    array[i] = impar[l];
                    l++;
                }

                else if ( ( par[z] % m) < impar[l] % m )
                {
                    array[i] = par[z];
                    z++;
                }

                else if ( ( par[z] % m) == impar[l] % m )
                {
                    array[i] = impar[l];
                    l++;
                }

                System.out.println (array[i] + "" );
            }


            n = sc.nextInt();
            m = sc.nextInt();
        }

        System.out.println("0 0");
    }    
}