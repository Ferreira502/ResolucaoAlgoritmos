#include<stdio.h>

int main ()
{
    int x = 0, y = 0;
    int n = 0;
    int cont = 0;

    scanf("%d", &n);

    while ( n != 0 )
    {
        cont++;
        int pessoasPorConsumo[201] = {0};
        int totalPessoas = 0;
        int totalConsumo = 0;
        
        for ( int i = 0; i < n; i++ )
        {
            scanf("%d%d", &x, &y);

            int resultado = y / x;
            pessoasPorConsumo[resultado] += x;
            totalPessoas += x;
            totalConsumo += y;
        }

        if ( cont > 1 )
        {
            printf("\n");
        }

        printf("Cidade# %d:\n", cont);

        int primeiro = 1;

        for ( int i = 0; i <= 200; i++ )
        {
            if ( pessoasPorConsumo[i] > 0 )
            {
                if ( primeiro == 0 )
                {
                    printf(" ");
                }

                printf("%d-%d", pessoasPorConsumo[i], i);
                primeiro = 0;
            }
        }

        double consumoMedio = (double) totalConsumo / totalPessoas;
        consumoMedio = (int)(consumoMedio * 100) / 100.0;

        printf("\nConsumo medio: %.2lf m3.\n", consumoMedio);
        
        scanf("%d", &n);    
    }
    
}
