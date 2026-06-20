import java.util.*;

class Fruta
{
	String fruta;
	double preco;

	Fruta ( String fruta, double preco )
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
		sc.useLocale(Locale.US);
		
		int m = 0;

		m = sc.nextInt();

		while ( m != 0 )
		{	
			double valor = 0.0;
			
			int n = sc.nextInt();
			
			Fruta[] frutas = new Fruta[n];
			
			for ( int i = 0; i < n; i++ )
			{
				String nome = sc.next();
				double preco = sc.nextDouble();

				frutas[i] = new Fruta(nome, preco);
			}

			int l = sc.nextInt();
			
			for ( int j = 0; j < l; j++ )
			{
				String nome2 = sc.next();
				int quant = sc.nextInt();

				for ( int i = 0; i < n; i++ )
				{
					if ( frutas[i].fruta.compareTo(nome2) == 0 ) 
					{
						valor += frutas[i].preco * quant;
					}
				}
			}
			
			System.out.printf(Locale.US, "R$ %.2f\n", valor);

			m--;
		}
	}
}
