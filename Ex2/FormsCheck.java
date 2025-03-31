package Ex2;
/*
a. Definiți clasa 'Form' cu un membru 'color' de tip String, o metoda getArea() care pentru început va intoarce 0 și o metodă toString() care va returna culoarea (valoarea pentru 'color').
Clasa va avea, de asemenea:
- un constructor fără parametri;
- un constructor ce va inițializa culoarea.

b. Din clasa Form derivați clasele Triangle și Circle:
- clasa Triangle va avea 2 membri height si base de tip float;
- clasa Circle va avea membrul radius de tip float.
Clasele vor avea:
- constructori fără parametri
- constructori care permit inițializarea membrilor. Identificați o modalitate de reutilizare a codului existent.

c. Instanțiati clasele Triangle și Circle și apelați metoda toString() pentru fiecare instanță.
Suprascrieti metoda getArea() pentru a intoarce aria specifica figurii geometrice.

d. Adăugați metode toString() în cele două clase derivate care să returneze tipul obiectului, culoarea si aria. De exemplu:
- pentru clasa Triangle, se va afișa: “Triunghi: rosu 10”
- pentru clasa Circle, se va afișa: “Cerc: verde 12.56”
Modificați implementarea toString() din clasele derivate astfel încât aceasta să utilizeze implementarea metodei toString() din clasa de bază.

e. Adăugați o metodă equals() în clasa Triangle. Justificați criteriul de echivalentă ales.

f. Creați un vector de obiecte Form și populați-l cu obiecte de tip Triangle și Circle (upcasting).
Parcurgeți acest vector și apelați metoda toString() pentru elementele sale. Ce observați?

g. Adăugați clasei Triangle metoda printTriangleDimensions() și clasei Circle metoda printCircleDimensions(). Implementarea metodelor constă în afișarea bazei si inaltimii, respectiv razei.
Parcurgeți vectorul de la exercițiul anterior și, folosind downcasting la clasa corespunzătoare, apelați metodele specifice fiecărei clase (printTriangleDimensions pentru Triangle și printCircleDimensions pentru Circle).
Pentru a stabili tipul obiectului curent folosiți operatorul instanceof.

h. Adaugati o implementare la programul anterior astfel încât să nu mai folositi operatorul "instanceof".
 */

public class FormsCheck {
    //c)
    public static void main(String[] args) {
        Circle circle = new Circle("verde", 5);
        Triangle triangle = new Triangle("rosu", 3, 4);
        System.out.println(circle);
        System.out.println(triangle);
        System.out.println();
        //f)
        //Cand stocam un obiect dintr-o clasa derivata intr-o variabila de tipul clasei de baza (upcasting), avem acces doar la metodele din clasa de baza. 
        //Totusi, daca in subclasa exista o metoda suprascrisa (de exemplu, toString()), Java va apela la executie varianta din subclasa, ilustrand polimorfismul dinamic.
        Form [] forms = new Form[4];
        forms[0] = new Circle("albastru", 2);//upcasting
        forms[1] = new Triangle("galben", 3, 4);
        forms[2] = new Circle("rosu", 5);
        forms[3] = new Triangle("verde", 6, 7);
        for(Form form : forms){
            System.out.println(form);
        }
        System.out.println();
        //g)
        for(Form form:forms){
            if(form instanceof Circle){
              Circle circle1=(Circle) form;//downcasting
                circle1.printCircleDimensions();
            }else if(form instanceof Triangle){
                Triangle triangle1=(Triangle)form;
                triangle1.printTriangleDimensions();
            }
        }


        //h)
        //fara instanceof
        for(Form form:forms){
            if(form.getClass().getSimpleName().equals("Circle")){
                Circle circle1=(Circle) form;//downcasting
                circle1.printCircleDimensions();
            }else if(form.getClass().getSimpleName().equals("Triangle")){
                Triangle triangle1=(Triangle)form;
                triangle1.printTriangleDimensions();
            }
        }
    }
}
