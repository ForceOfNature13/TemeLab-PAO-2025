/*

1. Implementati o aplicatie Java in care:
a) cititi de la tastatura un numar intreg n cuprins intre [0, 5].
Nota: interactiunea cu userul va continua atat timp cat acesta nu a furnizat o valoare valida.
        b) creati un tablou unidimensional de lungime n, ale carui elemente intregi le cititi de la tastatura.
        c) implementati o metoda care realizeaza inversarea ordinii initiale a elementelor tabloului si afisarea lui in consola.
exemplu: Input: [2, 4, 1, 5, 3]
Output: [3, 5, 1, 4, 2]

 */
package ExTema;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {

    private static final Scanner scanner=new Scanner(System.in);//nu permit sa se creeze o alta instanta Scanner,folosec
    //una singura pentru intreaga clasa,nu mai pot face o re-atribuire

    public static int citesteNumarValid() {
        int val;
        while (true) {
            System.out.print("Introduceti un numar cuprins intre [0, 5]: ");
            val = scanner.nextInt();
            if (val >= 0 && val <= 5) {
                System.out.println("Numarul " + val + " se afla in intervalul [0,5].");
                return val;
            } else {
                System.out.println("Numarul " + val + " NU se afla in intervalul [0,5]. Reincercati!");
                System.out.println();
            }
        }
    }


    public static int[] citesteVector(int n) {
        int[] v = new int[n];
        if (n == 0) {

            System.out.println("\nVector de lungime 0 (fara elemente).");
            return v;
        }

        System.out.println("\nIntroduceti cele " + n + " numere:");
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }

        System.out.println("\nVectorul initial este: " + Arrays.toString(v));
        return v;
    }


    public static void inverseazaVector(int[] v) {
        for (int i = 0; i < v.length / 2; i++) {
            int temp = v[i];
            v[i] = v[v.length - 1 - i];
            v[v.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {

        int n = citesteNumarValid();

        int[] vector = citesteVector(n);

        inverseazaVector(vector);

        System.out.println("\nVectorul inversat este: " + Arrays.toString(vector));
    }
}
