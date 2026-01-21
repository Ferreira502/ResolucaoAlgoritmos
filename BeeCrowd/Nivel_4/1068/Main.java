import java.util.*;

class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String palavra = sc.next();
        char c;
        int cont = 0; 
        int erro = 0;
 
        for(int i = 0; i < palavra.length(); i++)
        {
            c = palavra.charAt(i);
            if (c == '(')
            {
                cont++;
            }

            if (c == ')')
            {
                cont--;
                if (cont < 0) 
                {
                    erro = 1;
                    break;
                }
            }

        }

        if ( cont != 0 || erro == 1)
        {
            System.out.println("incorrect");
        }
        
        else
        {
            System.out.println("correct");
        }
    }
}