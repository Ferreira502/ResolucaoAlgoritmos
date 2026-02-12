//RESOLUCAO DA QUESTAO 1763 DO BEECROWD
//AUTOR: GABRIEL FERREIRA PEREIRA

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) 
        {
            String pais = sc.nextLine();

            if (pais.equals("brasil")) 
            {
                System.out.println("Feliz Natal!");
            } 
            else if (pais.equals("alemanha")) 
            {
                System.out.println("Frohliche Weihnachten!");
            } 
            else if (pais.equals("austria")) 
            {
                System.out.println("Frohe Weihnacht!");
            } 
            else if (pais.equals("coreia")) 
            {
                System.out.println("Chuk Sung Tan!");
            } 
            else if (pais.equals("espanha")) 
            {
                System.out.println("Feliz Navidad!");
            } 
            else if (pais.equals("grecia")) 
            {
                System.out.println("Kala Christougena!");
            } 
            else if (pais.equals("estados-unidos")) 
            {
                System.out.println("Merry Christmas!");
            } 
            else if (pais.equals("inglaterra")) 
            {
                System.out.println("Merry Christmas!");
            } 
            else if (pais.equals("australia")) 
            {
                System.out.println("Merry Christmas!");
            } 
            else if (pais.equals("portugal")) 
            {
                System.out.println("Feliz Natal!");
            }
            else if (pais.equals("suecia")) 
            {
                System.out.println("God Jul!");
            } 
            else if (pais.equals("turquia")) 
            {
                System.out.println("Mutlu Noeller");
            } 
            else if (pais.equals("argentina")) 
            {
                System.out.println("Feliz Navidad!");
            } 
            else if (pais.equals("chile")) 
            {
                System.out.println("Feliz Navidad!");
            } 
            else if (pais.equals("mexico")) 
            {
                System.out.println("Feliz Navidad!");
            } 
            else if (pais.equals("antardida"))
            {
                System.out.println("Merry Christmas!");
            } 
            else if (pais.equals("canada")) 
            {
                System.out.println("Merry Christmas!");
            } 
            else if (pais.equals("irlanda")) 
            {
                System.out.println("Nollaig Shona Dhuit!");
            } 
            else if (pais.equals("belgica")) 
            {
                System.out.println("Zalig Kerstfeest!");
            } 
            else if (pais.equals("italia")) 
            {
                System.out.println("Buon Natale!");
            }
            else if (pais.equals("libia")) 
            {
                System.out.println("Buon Natale!");
            } 
            else if (pais.equals("siria")) 
            {
                System.out.println("Milad Mubarak!");
            } 
            else if (pais.equals("marrocos")) 
            {
                System.out.println("Milad Mubarak!");
            } 
            else if (pais.equals("japao")) 
            {
                System.out.println("Merii Kurisumasu!");
            } 
            else 
            {
                System.out.println("--- NOT FOUND ---");
            }
        }

        sc.close();
    }
}