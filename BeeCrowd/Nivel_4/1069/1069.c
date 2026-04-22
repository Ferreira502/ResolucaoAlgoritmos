//RESOLUCAO DA QUESTAO 1069 DO BEECROWD
//AUTOR: GABRIEL FERREIRA PEREIRA

#include <stdio.h>
#include <string.h>

int main() 
{
    int n = 0;
    scanf("%d", &n);

    while (n--) 
    {
        char array[1001];
        scanf("%s", array);

        int cont = 0;
        int diamonds = 0;

        for (int i = 0; i < strlen(array); i++) 
        {
            if (array[i] == '<') 
            {
                cont++;
            } 
            else if (array[i] == '>' && cont > 0) 
            {
                diamonds++;
                cont--;
            }
        }

        printf("%d\n", diamonds);
    }

    return 0;
}