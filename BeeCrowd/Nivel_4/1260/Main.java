import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int casos = Integer.parseInt(sc.nextLine());
        sc.nextLine();

        for (int i = 0; i < casos; i++)
        {
            String[] arvores = new String[10000];
            int[] quantidade = new int[10000];
            int especies = 0;
            int total = 0;

            while (sc.hasNextLine())
            {
                String especie = sc.nextLine().trim();

                if (especie.length() == 0)
                    break;

                int posicao = -1;

                for (int j = 0; j < especies; j++)
                {
                    if (arvores[j].equals(especie))
                        posicao = j;
                }

                if (posicao == -1)
                {
                    arvores[especies] = especie;
                    quantidade[especies] = 1;
                    especies++;
                }
                else
                {
                    quantidade[posicao]++;
                }

                total++;
            }

            for (int j = 0; j < especies - 1; j++)
            {
                for (int k = j + 1; k < especies; k++)
                {
                    if (arvores[j].compareTo(arvores[k]) > 0)
                    {
                        String auxNome = arvores[j];
                        arvores[j] = arvores[k];
                        arvores[k] = auxNome;

                        int auxQuantidade = quantidade[j];
                        quantidade[j] = quantidade[k];
                        quantidade[k] = auxQuantidade;
                    }
                }
            }

            if (i > 0)
                System.out.println();

            for (int j = 0; j < especies; j++)
            {
                double porcentagem = quantidade[j] * 100.0 / total;
                int valor = (int)(porcentagem * 10000 + 0.5);
                int parteInteira = valor / 10000;
                int parteDecimal = valor % 10000;

                System.out.print(arvores[j] + " " + parteInteira + ".");

                if (parteDecimal < 1000)
                    System.out.print("0");
                if (parteDecimal < 100)
                    System.out.print("0");
                if (parteDecimal < 10)
                    System.out.print("0");

                System.out.println(parteDecimal);
            }
        }
    }
}
