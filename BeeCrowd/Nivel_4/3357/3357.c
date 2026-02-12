#include <stdio.h>
#include <math.h>

int main() {

    int N;
    double L = 0.0;
    double Q = 0.0;
    int total_cuias = 0;
    double ultima_quantidade = 0.0;
    double resto = 0.0;
    int cuias_completas = 0;

    scanf("%d", &N);
    scanf("%f %f", &L, &Q);

    char nomes[10][13];

    for(int i = 0; i < N; i++) 
    {
        scanf("%s", nomes[i]);
    }

    cuias_completas = (int)(L / Q);

    resto = L - (cuias_completas * Q);

   

    if (fabs(resto) < 0.0001) 
    {
        total_cuias = cuias_completas;
        ultima_quantidade = Q;
    } 
    else
    {
        total_cuias = cuias_completas + 1;
        ultima_quantidade = resto;
    }

    int indice = (total_cuias - 1) % N;

    printf("%s %.1f\n", nomes[indice], ultima_quantidade);

    return 0;
}
