import java.util.*;

class No
{
    char elemento;
    No esq; No dir;

    public No(char elemento) 
    {
        this(elemento, null, null);
    }

    public No ( char elemento, No esq, No dir)
    {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    } 
}

class ArvoreBinaria
{
    No raiz;

    public ArvoreBinaria()
    {
        raiz = null;
    } 

    public boolean pesquisar ( char x )
    {
        return pesquisar(x, raiz);
    }

    private boolean pesquisar ( char x, No i )
    {
        boolean resp = false;

        if ( i == null ) 
        {
            resp = false;
        }

        else if ( i.elemento == x ) 
        {
            resp = true;
        }

        else if ( x > i.elemento )
        {
            resp = pesquisar( x, i.dir);
        }

        else if ( x < i.elemento )
        {
            resp = pesquisar( x, i.esq );
        }

        return resp;
    }

    public void inserir( char x )
    {
        raiz = inserir( x, raiz );
    }

    private No inserir ( char x, No i )
    { 
        if ( i == null ) 
        {
            i = new No(x);    
        }

        else  if ( x < i.elemento )
        {
            i.esq = inserir(x, i.esq);
        }

        else if ( x > i.elemento )
        {
            i.dir = inserir(x , i.dir);
        }

        else 
        {
            System.out.println("erro");
        }

        return i;
    }

    public void caminharCentral() 
    {
		caminharCentral(raiz);
	}

	private void caminharCentral(No i)
    {
		if (i != null) 
        {
			caminharCentral(i.esq);
			System.out.print(i.elemento + " ");
			caminharCentral(i.dir);
		}
	}

    public void caminharPre() 
    {
		caminharPre(raiz);
	}

	private void caminharPre(No i)
    {
		if (i != null) 
        {
            System.out.print(i.elemento + " ");
			caminharPre(i.esq);
			caminharPre(i.dir);
		}
	}

    public void caminharPos() 
    {
		caminharPos(raiz);
	}

	private void caminharPos(No i)
    {
		if (i != null) 
        {  
			caminharPos(i.esq);
			caminharPos(i.dir);
            System.out.print(i.elemento + " ");
		}
	}
}

public class Main 
{  
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria ab = new ArvoreBinaria();

        while (sc.hasNext()) 
        {
            String palavra = sc.next();
            
            if (palavra.compareTo("INFIXA") == 0) 
            {
                ab.caminharCentral();
                System.out.println();
            } 

            else if (palavra.compareTo("PREFIXA") == 0) 
            {
                ab.caminharPre();
                System.out.println();
            } 

            else if (palavra.compareTo("POSFIXA") == 0) 
            {
                ab.caminharPos();
                System.out.println();
            } 
            
            else 
            {
                char op = palavra.charAt(0);         // 'I' ou 'P'
                char letra = sc.next().charAt(0);  // 'c', 'f', 'z'

                if ( op == 'I') 
                {
                    ab.inserir(letra);    
                } 

                else if ( op == 'P')
                {
                    boolean resp = false;

                    resp = ab.pesquisar(letra);

                    if ( resp == false ) 
                    {
                        System.out.println( letra + " nao existe");    
                    }

                    else if ( resp == true ) 
                    {
                        System.out.println( letra + " existe");    
                    }
                }
            }
        }  
    }
}
