#include <stdio.h>
#include <string.h>

int main() {
    int n = 0;
    char palavra[101];

    scanf("%d", &n);
    getchar();

    for (int i = 0; i < n; i++) {
        fgets(palavra, sizeof(palavra), stdin);
        palavra[strcspn(palavra, "\n")] = '\0';

        int tamanho = strlen(palavra);
        if (tamanho > 10) {
            printf("%c%d%c\n", palavra[0], tamanho - 2, palavra[tamanho - 1]);
        } else {
            printf("%s\n", palavra);
        }
    }

    return 0;
}
