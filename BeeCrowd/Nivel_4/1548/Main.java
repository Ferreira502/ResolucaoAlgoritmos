//RESOLUCAO DA QUESTAO 1548 DO BEECROWD
//AUTOR: GABRIEL FERREIRA PEREIRA

import java.util.*;

class Main {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 

        for (int l = 0; l < n; l++) 
        {
            int m = sc.nextInt(); 

            int[] original = new int[m];
            int[] ordenado = new int[m];

            for (int i = 0; i < m; i++) 
            {
                original[i] = sc.nextInt();
                ordenado[i] = original[i];
            }

            for (int i = 0; i < m - 1; i++) 
            {
                for (int j = 0; j < m - 1 - i; j++) 
                {
                    if (ordenado[j] < ordenado[j + 1]) 
                    {
                        int aux = ordenado[j];
                        ordenado[j] = ordenado[j + 1];
                        ordenado[j + 1] = aux;
                    }
                }
            }

            int cont = 0;

            for (int i = 0; i < m; i++) 
            {
                if (original[i] == ordenado[i]) 
                {
                    cont++;
                }
            }

            System.out.println(cont);
        }

        sc.close();
    }
}
