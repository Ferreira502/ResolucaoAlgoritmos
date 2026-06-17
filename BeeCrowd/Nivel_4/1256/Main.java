class Hash
{
    String tabela[];
    int m;
    int r;
    int nr;

    public Hash( int m, int r )
    {
        this.m = m;
        this.r = r;
        this.nr = 0;
        this.tabela = new String[m + r];
    }

    private int hash( String chave )
    {
        int x = 0;

        for ( int i = 0; i < chave.length(); i++ )
        {
            char c = chave.charAt(i);
            x += c;
        }

        x = x % m;

        return x;
    }

    private boolean isPosicaoLivre( int pos )
    {
        boolean resp = true;

        if ( tabela[pos] != null )
        {
            resp = false;
        }

        return resp;
    }

    public void inserir ( String chave ) throws Exception
    {
        int pos = hash(chave);

        if ( tabela[pos].compareTo(chave) == 0 )
        {
            throw new Exception ( " repetido " );
        }

        if ( isPosicaoLivre(pos) == true )
        {
            tabela[pos] = chave;
        } 

        else 
        {
            if ( nr < r )
            {
                tabela[m + nr] = chave;
                nr++;
            }

            else
            {
                throw new Exception("ta cheia");
            }
        }
    }

    public void mostrar()
    {
        for ( int i = 0; i < m + r; i++ )
        {
            System.out.print(i + " ");

            if ( i < m )
            {
                System.out.print("Principal ");
            }

            else
            {
                System.out.print("Reserva ");
            }

            if ( tabela[i] == null )
            {
                System.out.println("-");
            }

            else
            {
                System.out.println(tabela[i]);
            }
        }
    }
}

class Main
{
    public static void main ( String[] args )
    {
        
    }
}