/*
2. Implementati o aplicatie Java in care:
a) creati 2 tablouri unidimensionale de lungimi diferite, cu cate cel putin 5 elemente intregi.
b) implementati o metoda de sortare in ordine crescatoare a elementelor fiecarui tablou creat anterior.
Nota: se va folosi o implementare proprie, nu pe cea din clasa Arrays.
c) creati si afisati la consola un al treilea tablou in care veti insera in ordine crescatoare toate elementele din primele 2 tablouri.
Pentru eficienta si complexitate de timp liniara, utilizati o tehnica de implementare cu 2 pointeri (cate unul pt elementele fiecarui tablou initial).
exemplu:
   Array1 initial: [1, 7, 4, 3, 9, 1]
   Array1 sortat crescator: [1, 1, 3, 4, 7, 9]
   Array2 initial: [6, 4, 2, 8]
   Array2 sortat crescator: [2, 4, 6, 8]
   Output: [1, 1, 2, 3, 4, 4, 6, 7, 8, 9]
 */
package ExTema;
import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {
    private static final Scanner scanner= new Scanner(System.in);

    //a)
    public static int [] creeaza_tablou_unidimensional(){
        int val;
        while(true){

            System.out.print("Introduceti numarul de elemente al tabloului: ");

            val= scanner.nextInt();

            System.out.println();

            if(val<5){
                System.out.println("Introduceti un numar mai mare de 5 \n");
            }else{
                break;
            }
        }
        int [] v=new int[val];

        System.out.println("Introduceti elementele tabloului:");

        for(int i=0;i<val;i++){

            v[i]=scanner.nextInt();
        }
        System.out.println("Sirul creat: ");
        System.out.println(Arrays.toString(v));

        return v;
    }

    //b)
    public static void selectionSort(int[] v) {//Complexitate O(n^2)
        //nu se creeaza o copie a obiectului trimis (nu se apeleaza copy constructorul)
        //trimitem exact referinta
        //se va modifica obiectul trimis
            for (int i = 0; i < v.length - 1; i++) {
                int minIndex = i;

                for (int j = i + 1; j < v.length; j++) {
                    if (v[j] < v[minIndex]) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    int temp = v[i];
                    v[i] = v[minIndex];
                    v[minIndex] = temp;
                }
            }
        }

    //c)
     public static int[] interclasare(int [] s1 ,int [] s2 ){//Complexitate O(s1.length+s2.length) --> O(n)

        int [] s3=new int [s1.length+s2.length];

        int i=0,j=0,k=0;

        while(i<s1.length && j<s2.length){
            if(s1[i]>s2[j]){
                s3[k]=s2[j];
                j++;
            }else{
                s3[k]=s1[i];
                i++;
            }
            k++;
        }
        while(i<s1.length){
            s3[k]=s1[i];
            i++;
            k++;
        }
         while(j<s2.length){
             s3[k]=s2[j];
             j++;
             k++;
         }
         return s3;
     }

    public static void main(String[] args) {
        // Cream primul tablou
        System.out.println("crearea primului tablou:\n");
        int[] v1 = creeaza_tablou_unidimensional();
        System.out.println();

        // Cream al doilea tablou, cu verificare de lungime diferita fata de primul
        int[] v2;
        do {
            System.out.println("crearea celui de-al doilea tablou (lungime diferita de primul):\n");
            v2 = creeaza_tablou_unidimensional();
            if(v2.length == v1.length){
                System.out.println("Dimensiunea celui de-al doilea tablou nu poate fi aceeasi cu a primului. Incercati din nou!\n");
            }
        } while(v2.length == v1.length);

       selectionSort(v1);

       selectionSort(v2);

       int [] v3=interclasare(v1,v2);

         System.out.println("Sirul interclasat: ");

         System.out.println(Arrays.toString(v3));
    }
}
