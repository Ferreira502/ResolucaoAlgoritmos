import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean primeiraLinha = true;

        while (sc.hasNextLine()) {
            String texto = sc.nextLine();

            int[] freq = new int[128];

            for (int i = 0; i < texto.length(); i++) {
                char c = texto.charAt(i);
                freq[c]++;
            }

            if (!primeiraLinha) {
                System.out.println();
            }

            primeiraLinha = false;

            for (int f = 1; f <= texto.length(); f++) {
                for (int ascii = 127; ascii >= 0; ascii--) {
                    if (freq[ascii] == f) {
                        System.out.println(ascii + " " + freq[ascii]);
                    }
                }
            }
        }

        sc.close();
    }
}