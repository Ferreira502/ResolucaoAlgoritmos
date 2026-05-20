import java.util.*;

class No 
{
	private int elemento;
	private No esq;
	private No dir;

	public No( int elemento )
	{
		this.elemento = elemento;
		this.dir = null;
		this.esq = null;
	}
}

class ArvoreBinaria
{
	private No raiz

	public ArvoreBinaria ()
	{
		raiz = null;
	}

	public No inserir ( int x )
	{
		raiz = inserir ( raiz, x );
	}

	private No inserir ( No i, int x )
	{
		if ( x == i.elemento ) 
		{
			i = new No(x);
		}

		else if ( x > i.elemento )
		{
			i.dir = inserir ( i.dir, x );
		}

		else if ( x < i.elemento ) 
		{
			i.esq = inserir ( i.esq, x );
		}

		else 
		{
			System.out.println("Erro");
		}

		return i;


	}
}

class Main
{
	public static void main ( String[] args ) 
	{}
}
