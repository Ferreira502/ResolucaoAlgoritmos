import java.util.*;

class Main
{
    public static void main ( String[] args )
    {
        Scanner sc = new Scanner ( System.in );

        while ( sc.hasNextInt() )
        {
            int n = sc.nextInt();

            Stack<Integer> pilha = new Stack<>();
            Queue<Integer> fila = new LinkedList<>();
            PriorityQueue<Integer> prioridade = new PriorityQueue<>( Collections.reverseOrder() );

            boolean ehPilha = true;
            boolean ehFila = true;
            boolean ehPrioridade = true;

            for ( int i = 0; i < n; i++ )
            {
                int tipo = sc.nextInt();
                int x = sc.nextInt();

                if ( tipo == 1 )
                {
                    pilha.push( x );
                    fila.offer( x );
                    prioridade.offer( x );
                }
                else
                {
                    // Aqui entra a parte principal:
                    // verificar se cada estrutura conseguiria remover x.
                }
            }

            // Aqui no final voce decide entre:
            // "stack", "queue", "priority queue", "impossible" ou "not sure".
        }
    }
}
