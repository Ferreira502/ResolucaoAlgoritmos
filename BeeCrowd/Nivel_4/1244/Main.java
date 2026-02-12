//RESOLUCAO DA QUESTAO 1244 DO BEECROWD
//AUTOR: GABRIEL FERREIRA PEREIRA

import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        while (n > 0) 
        {
            String linha = sc.nextLine();
            String[] p = linha.split("\\s+");

            for (int i = 0; i < p.length - 1; i++) 
            {
                for (int j = i + 1; j < p.length; j++) 
                {
                    if (p[i].length() < p[j].length()) 
                    {
                        String tmp = p[i];
                        p[i] = p[j];
                        p[j] = tmp;
                    }
                }
            }

            for (int i = 0; i < p.length; i++) 
            {
                if (i > 0) System.out.print(" ");
                System.out.print(p[i]);
            }
            System.out.println();

            n--;
        }

        sc.close();
    }
}