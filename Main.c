#include <stdio.h>

int main()
{
    int y = 0;

    if (scanf("%d", &y) != 1) return 1;

    while (y > 0)
    {
        int x = 0;
        char palavra[50];
        int array[100] = {0};

        // Le a linha inteira (incluindo espacos)
        scanf(" %[^\n]", palavra);

        // Descobre o tamanho da string
        for (int i = 0; palavra[i] != '\0'; i++)
        {
            x++;
        }

        // Processa caractere por caractere (apenas UM loop)
        for (int i = 0; i < x; i++)
        {
            if (palavra[i] == 'a' || palavra[i] == 'k' || palavra[i] == 'u' || palavra[i] == 'G' || palavra[i] == 'Q') {
                array[i] = 0;
            }
            else if (palavra[i] == 'b' || palavra[i] == 'l' || palavra[i] == 'v' || palavra[i] == 'I' || palavra[i] == 'S') {
                array[i] = 1;
            }
            else if (palavra[i] == 'c' || palavra[i] == 'm' || palavra[i] == 'w' || palavra[i] == 'E' || palavra[i] == 'O' || palavra[i] == 'Y') {
                array[i] = 2;
            }
            else if (palavra[i] == 'd' || palavra[i] == 'n' || palavra[i] == 'x' || palavra[i] == 'F' || palavra[i] == 'P' || palavra[i] == 'Z') {
                array[i] = 3;
            }
            else if (palavra[i] == 'e' || palavra[i] == 'o' || palavra[i] == 'y' || palavra[i] == 'J' || palavra[i] == 'T') {
                array[i] = 4;
            }
            else if (palavra[i] == 'f' || palavra[i] == 'p' || palavra[i] == 'z' || palavra[i] == 'D' || palavra[i] == 'N' || palavra[i] == 'X') {
                array[i] = 5;
            }
            else if (palavra[i] == 'g' || palavra[i] == 'q' || palavra[i] == 'A' || palavra[i] == 'K' || palavra[i] == 'U') {
                array[i] = 6;
            }
            else if (palavra[i] == 'h' || palavra[i] == 'r' || palavra[i] == 'C' || palavra[i] == 'M' || palavra[i] == 'W') {
                array[i] = 7;
            }
            else if (palavra[i] == 'i' || palavra[i] == 's' || palavra[i] == 'B' || palavra[i] == 'L' || palavra[i] == 'V') {
                array[i] = 8;
            }
            else if (palavra[i] == 'j' || palavra[i] == 't' || palavra[i] == 'H' || palavra[i] == 'R') {
                array[i] = 9;
            }
            else if (palavra[i] == ' ') 
            {
                array[i] = -1;
            }
        }

        // Exibe o resultado ignorando os espaços (-1)
        for (int i = 0; i < 12; i++)
        {
            if (array[i] != -1)
            {
                printf("%d", array[i]);
            }
        }
        printf("\n"); // Quebra de linha entre os casos de teste

        y--;
    }

    return 0;
}