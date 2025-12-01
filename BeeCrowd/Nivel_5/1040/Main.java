import java.util.*;
import java.math.BigDecimal;

class Main {
    public static void main ( String[] args )  
    {
        Scanner sc = new Scanner(System.in);

        double n1 = 0.00;
        double n2 = 0.00;
        double n3 = 0.00;
        double n4 = 0.00;
        double n5 = 0.00;
        double resultado = 0.0;
        double media = 0.0;
        
        n1 = sc.nextDouble();
        n2 = sc.nextDouble();
        n3 = sc.nextDouble();
        n4 = sc.nextDouble();

        n1 = n1 * 2;
        n2 = n2 * 3;
        n3 = n3 * 4;
        n4 = n4 * 1;
        media = (n1 + n2 + n3 + n4) / 10;

        System.out.printf("Media: %.1f%n", media);

        if ( media >= 7.0) 
        {
            System.out.println("Aluno aprovado.");   
        }
        else if ( media <= 6.9 && media >= 5.0 ) 
        {
            System.out.println("Aluno em exame.");    
            n5 = sc.nextDouble();
            resultado = ( media + n5 ) / 2; 
            System.out.printf("Nota do exame: %.1f%n", n5); 
        }
        else if (media <= 6.9) 
        {
            System.out.println("Aluno reprovado.");
        }

        if ( media <= 6.9 && media >= 5.0 && resultado >= 5.0) 
        {
            System.out.println("Aluno aprovado."); 
            System.out.printf("Media final: %.1f%n", resultado);  
        }

        else if (media <= 6.9 && media >= 5.0 && resultado <= 4.9) 
        {
            System.out.println("Aluno reprovado.");
            System.out.printf("Media final: %.1f%n", resultado); 
        }
            
        sc.close();
    }
}