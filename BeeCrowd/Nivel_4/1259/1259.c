#include<stdio.h>

int ordenar (int x, int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n + 1; j++)
        {
            /* code */
        }
        
    }
    
}

int main () 
{
    int n = 0;
    scanf("%d", &n);

    int valor[n];
    int ordenadopar[n];
    int ordenadoimpar[n];

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &valor[i]);
        
        if (valor[i] % 2 == 0)
        {
            int ordenadopar = ordernar(valor[i], n);
        }

        else if (valor[i] % 2 != 0)
        {
            int ordenadoimpar = ordenar(valor[i], n);
        }
        
        
    }
    
}