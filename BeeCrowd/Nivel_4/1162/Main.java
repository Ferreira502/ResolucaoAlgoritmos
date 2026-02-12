//RESOLUCAO DA QUESTAO 1162 DO BEECROWD
//AUTOR: GABRIEL FERREIRA PEREIRA

import java.util.*;

class Main 
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int aux = 0;
        int cont = 0;

        n = sc.nextInt();

        while ( n > 0)
        {
            int l = sc.nextInt();
            int[] array = new int[l]; 
        
            for (int i = 0; i < l; i++) 
            {
                array[i] = sc.nextInt();
            }

           for (int i = 1; i < l; i++)
           {
               for (int j = 0; j < l - 1; j++)
               {
                   if (array[j] > array[j + 1])
                   {
                       aux = array[j];
                       array[j] = array[j + 1];
                       array[j + 1] = aux;
                       cont++;
                   }
               
               }
           }
            
            System.out.println("Optimal train swapping takes " + cont + " swaps.");
            cont = 0;
            n--;
        }
    }
}