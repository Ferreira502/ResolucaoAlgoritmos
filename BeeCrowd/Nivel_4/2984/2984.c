//RESOLUCAO DA QUESTAO 2984 DO BEECROWD
//AUTOR: GABRIEL FERREIRA PEREIRA

#include <stdio.h>
#include <string.h>

int main()
{
    char s[100001];
    scanf("%s", s);

    int n = strlen(s);
    int x = 0;

    for (int i = 0; i < n; i++)
    {
        if (s[i] == '(')
        {
            x++;
        }
        else if (s[i] == ')')
        {
            if (x > 0)
            {
                x--;
            }
        }
    }

    if (x > 0)
    {
        printf("Ainda temos %d assunto(s) pendente(s)!\n", x);
    }
    else
    {
        printf("Partiu RU!\n");
    }

    return 0;
}