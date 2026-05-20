import java.util.*;

class Celula 
{
    public String elemento; 
    public Celula prox;

    public Celula( String elemento )
    {
        this.elemento = elemento;
        this.prox = null;
    }

    public Celula() 
    {
        this(""); 
    }
}

class Lista 
{
    private Celula primeiro;
    private Celula ultimo;
    
    public Lista()
    {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserirFim( String x )
    {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public String removerInicio() 
    {
        if (primeiro == ultimo) 
        {
            System.out.println("Erro");
            return null;
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        String resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;

        return resp;
    }

    public void ordenar()
    {
        for ( Celula i = primeiro.prox; i != null; i = i.prox )
        {
            Celula menor = i;
            for ( Celula j = i.prox; j != null; j = j.prox )
            {
                if ( j.elemento.compareTo(menor.elemento) < 0 )
                {
                    menor = j;
                }
            }
        
            if ( menor != i )
            {
                String tmp = i.elemento;
                i.elemento = menor.elemento;
                menor.elemento = tmp;
            }
        }
    }

    public void mostrar() 
    {
        for ( Celula i = primeiro.prox; i != null; i = i.prox ) 
        {
            System.out.print(i.elemento + " ");
        }
        
        System.out.println();
    }
} 

class Main 
{   
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();

        while (sc.hasNext())
        {
            String palavra = sc.next();
            lista.inserirFim(palavra);
        }

        System.out.println("\nLista original:");
        lista.mostrar();

        lista.ordenar();

        System.out.println("\nLista ordenada:");
        lista.mostrar();

    }
}