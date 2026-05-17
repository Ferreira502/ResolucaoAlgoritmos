import java.util.*;
class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int m = 0;
        while ( sc.hasNext() ) 
        {
            n = sc.nextInt();
            m = sc.nextInt();

            //inicializa todas as posicoes com 1
            int[] array = new int[n + 1];

            for ( int i = 1; i <= n; i++)
            {
                array[i] = 1;
            }
            
            while ( m > 0) 
            {
                char op = sc.next().charAt(0); // C -> Contar       M - > avancar 1
                int a = sc.nextInt();
                int b = sc.nextInt();
                int qtdH = 0;
                int qtdE = 0;
                int qtdR = 0;

                if ( op == 'C' ) 
                {
                    for ( int i = a; i <= b; i++ )
                    {
                        if ( array[i] == 1) 
                        {
                            qtdH++;    
                        }
                        if ( array[i] == 2) 
                        {
                            qtdE++;    
                        }
                        if ( array[i] == 3) 
                        {
                            qtdR++;    
                        }
                    }
                    System.out.println(qtdH + " " +  qtdE + " " + qtdR);
                }
                if ( op == 'M' ) 
                {
                    for ( int i = a; i <= b; i++ )
                    {
                        if ( array[i] == 3)
                        {
                            array[i] = 1;
                        }
                        else
                        {
                            array[i] += 1;
                        }

                    }
                }

                m--;
            }
            System.out.println();
        }
    }
}
/* 
    1 = Homen
    2 = Elefante
    3 = Rato
    E > H
    R > E
    H > R 
    n -> numero de jogadores
    m -> numero de operacoes
    Homem → Elefante → Rato → Homem → ...
    M A B — Mudança de símbolo
    Todos os jogadores nas posições A até B (inclusive) avançam um passo no ciclo:
    Homem vira Elefante
    Elefante vira Rato
    Rato vira Homem
    C A B — Contagem
    Conta quantos jogadores nas posições A até B estão usando cada símbolo, e imprime:
    <qtd Homem> <qtd Elefante> <qtd Rato>
*/