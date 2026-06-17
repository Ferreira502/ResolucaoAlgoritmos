import java.util.*;

class Fruta
{
	String fruta;
	int preco;

	Fruta ( String fruta, int preco )
	{
		this.fruta = fruta;
		this.preco = preco;
	}
}


class Main 
{
	public static void main ( String[] args ) 
	{
		Scanner sc = new Scanner(System.in);
		
		Fruta[] frutas = new Fruta[100];
		
		int m = 0;

		m = sc.nextInt();

		while ( m != 0 )
		{	
			int n = sc.nextInt();
			
			for ( int i = 0; i < n; i++ )
			{
				String nome = sc.next();
				double preco = sc.next();

				frutas(nome, preco);
			}

			int l = sc.nextInt();
			
			for ( int j = 0; i < l; i++ )
			{
				nome = sc.next();
				int quant = sc.nextInt();


			}
				
			m--;
		}
	}
}
