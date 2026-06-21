import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int caso = 0; caso < n; caso++)
        {
            String linha = sc.nextLine();
            String resposta = "";

            for (int i = 0; i < linha.length(); i++)
            {
                char c = linha.charAt(i);

                if (c == '0' || c == ' ')
                {
                    int quantidade = 1;

                    while (i + 1 < linha.length() && linha.charAt(i + 1) == c)
                    {
                        quantidade++;
                        i++;
                    }

                    while (quantidade > 255)
                    {
                        if (c == '0')
                        {
                            resposta += "#";
                        }
                        else
                        {
                            resposta += "$";
                        }

                        resposta += (char) 255;
                        quantidade -= 255;
                    }

                    if (quantidade > 2)
                    {
                        if (c == '0')
                        {
                            resposta += "#";
                        }
                        else
                        {
                            resposta += "$";
                        }

                        resposta += (char) quantidade;
                    }
                    else
                    {
                        for (int j = 0; j < quantidade; j++)
                        {
                            resposta += c;
                        }
                    }
                }
                else
                {
                    resposta += c;
                }
            }

            System.out.println(resposta);
        }
    }
}
