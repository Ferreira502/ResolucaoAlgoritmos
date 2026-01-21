#include <stdio.h>

int main ()
{
    int n = 0;
    int array[1000];
    int cont = 0;
    int erro = 0;

    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &array[i]);

        if (array[i] == '<')
        {
            cont++;
        }
        
    }
    
}