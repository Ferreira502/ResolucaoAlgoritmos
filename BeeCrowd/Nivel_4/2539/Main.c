#include<stdio.h>

int main()
{
    int n = 0;

    while ( (scanf("%d", &n)) != EOF ) 
    {

        int array[n];

        for (int i = 0; i < n; i++) 
        {
            scanf("%d", &array[i]);
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

        printf("%d\n", cont);
        
    }
}

// fazer um selecao no array e achar o menor
// depois pegar o menor contar quantos tem na frente dele e contar
// tirar o menor do array
// e repetir isso ate que não tenha mais nada no array