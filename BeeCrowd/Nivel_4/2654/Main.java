import java.util.*;

class Deus 
{
    String nome;
    int p, k, m;

    public Deus( String nome, int p, int k, int m ) 
    {
        this.nome = nome;
        this.p = p;
        this.k = k;
        this.m = m;
    }
}

class Main 
{
    public static void main( String[] args ) 
    {
        Scanner sc = new Scanner(System.in);
        Deus[] deuses = new Deus[100];

        int n = 0;

        n = sc.nextInt();

        int cont = 0;

        while ( n > 0 ) 
        {
            String nome = sc.next();
            int p = sc.nextInt();
            int k = sc.nextInt();
            int m = sc.nextInt();

            deuses[cont] = new Deus(nome, p, k, m);

            cont++;
            n--;
        }

        int indiceMaior = 0; 

        for ( int i = 1; i < cont; i++ )
        {
            // Regra 1: Maior Poder (P)
            if ( deuses[i].p > deuses[indiceMaior].p )
            {
                indiceMaior = i;
            }
            else if ( deuses[i].p == deuses[indiceMaior].p )
            {
                // Regra 2: Maior número de deuses que matou (K)
                if ( deuses[i].k > deuses[indiceMaior].k ) 
                {
                    indiceMaior = i;
                }
                else if ( deuses[i].k == deuses[indiceMaior].k )
                {
                    // Regra 3: Menor número de vezes que morreu (M)
                    if ( deuses[i].m < deuses[indiceMaior].m )
                    {
                        indiceMaior = i;
                    }
                    else if ( deuses[i].m == deuses[indiceMaior].m )
                    {
                        // Regra 4: Ordem alfabética (caso todos os atributos sejam iguais)
                        if ( deuses[i].nome.compareTo(deuses[indiceMaior].nome) < 0 )
                        {
                            indiceMaior = i;
                        }
                    }
                }
            }
        }

        System.out.println( deuses[indiceMaior].nome );
    }
}