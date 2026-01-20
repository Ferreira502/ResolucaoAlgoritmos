#include <stdio.h>

void ordenarCrec(int array[], int n)
{
    int aux;
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - 1 - i; j++)
        {
            if (array[j] > array[j + 1])
            {
                aux = array[j];
                array[j] = array[j + 1];
                array[j + 1] = aux;
            }
        }
    }
}

void ordenarDec(int array[], int n)
{
    int aux;
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - 1 - i; j++)
        {
            if (array[j] < array[j + 1])
            {
                aux = array[j];
                array[j] = array[j + 1];
                array[j + 1] = aux;
            }
        }
    }
}

int main()
{
    int n;
    scanf("%d", &n);

    int valor[n];
    int par[n], impar[n];
    int qtdPar = 0, qtdImpar = 0;

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &valor[i]);

        if (valor[i] % 2 == 0)
        {
            par[qtdPar++] = valor[i];
        }

        else
        {
            impar[qtdImpar++] = valor[i];
        }
    }

    ordenarCrec(par, qtdPar);
    ordenarDec(impar, qtdImpar);

    for (int i = 0; i < qtdPar; i++)
    {
        printf("\n%d", par[i]);
    }

    for (int i = 0; i < qtdImpar; i++)
    {
        printf("\n%d", impar[i]);
    }

    return 0;
}
