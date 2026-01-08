#include<stdio.h>
#include<string.h>

#define MAX 20

void swap(int *i, int *j) 
{
   int temp = *i;
   *i = *j;
   *j = temp;
}

void bolha(int *array, int n)
{
    int i = 0, j = 0;
    for (i = 0; i < n-1; i++) 
    {
      for (j = 0; j < n-1; j++) 
      {
        if (array[j] > array[j + 1]) 
        {
           swap(&array[j], &array[j + 1]);
        }
      }
   }
}

int str_to_int ( char value [ ], int size )
{
    int sum = 0;

    for ( int i = 0; i < size; i ++ )
    {
        if ( value [ i ] >= 48 && value [ i ] <= 57 )
        {
            sum = sum * 10 + ( value [ i ] - '0' );
        }
    }

    // printf ( "soma : %d\n", sum );

    return sum;
}

int main ()
{
    int opcao = 1;
    // while (scanf("%d", &opcao) != EOF)
    // {
    //     /* code */
    // }

    char palavra[MAX];
}