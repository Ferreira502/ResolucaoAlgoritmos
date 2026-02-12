//RESOLUCAO DA QUESTAO 1566 DO BEECROWD
//AUTOR: GABRIEL FERREIRA PEREIRA

#include <stdio.h>

void ordenar(int n, int array[])
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

int main()
{
    int n = 0;
    int h = 0;

    scanf("%d", &n);

    while (n != 0)
    {

        scanf("%d", &h);
        int pessoas[h];

        for (int i = 0; i < h; i++)
        {
            scanf("%d", &pessoas[i]);
        }

        ordenar(h, pessoas);

        for (int i = 0; i < h; i++)
        {
            printf("\n%d", pessoas[i]);
        }

        n--;
    }
}