#include <stdio.h>
#include <string.h>

int main()
{
    int n = 0, m = 0;
    
    while (scanf("%d %d", &n, &m) != EOF)
    {
        int array[n + 1];

        for (int i = 1; i <= n; i++)
        {
            array[i] = 1;
        }
        
        while (m > 0)
        {
            char op;
            int a = 0, b = 0;
            
            scanf(" %c %d %d", &op, &a, &b);
            
            int qtdH = 0, qtdE = 0, qtdR = 0;
            
            if (op == 'C')
            {
                for (int i = a; i <= b; i++)
                {
                    if (array[i] == 1) qtdH++;
                    if (array[i] == 2) qtdE++;
                    if (array[i] == 3) qtdR++;
                }
                printf("%d %d %d\n", qtdH, qtdE, qtdR);
            }
            
            if (op == 'M')
            {
                for (int i = a; i <= b; i++)
                {
                    if (array[i] == 3)
                        array[i] = 1;
                    else
                        array[i] += 1;
                }
            }
            
            m--;
        }
        
        printf("\n");
    }
    
    return 0;
}