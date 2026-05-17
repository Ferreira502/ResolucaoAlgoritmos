#include <stdio.h>

int main ()
{   

    int t = 0;

    while ( scanf("%d", &t) != EOF)
    {
        int n = 0, c = 0, x = 0, p = 0, q = 0, v = 0;

        scanf("%d %d", &n, &c);

        int array[n + 1];

        for ( int i = 1; i <= n; i++)
        {
            array[i] = 0;
        }
        

        while ( c != 0)
        {
            scanf("%d", &x);

            if ( x == 0)
            {
                scanf("%d %d %d", &p, &q, &v);
                
                for (int i = p; i <= q; i++)
                {
                    array[i] += v;
                }
            }

            if ( x == 1)
            {
                int cont = 0;

                scanf("%d %d", &p, &q);

                for (int i = p; i <= q; i++)
                {
                    cont += array[i];
                }
                
                printf("%d\n", cont);
            }

            c--;
        }
        
    }
    
}