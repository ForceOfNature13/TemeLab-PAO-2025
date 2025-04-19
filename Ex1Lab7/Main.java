/*
1. Definiţi o clasă care să implementeze operaţii pe numere double. Operaţiile vor arunca excepţii.

a. Clasa va trebui să implementeze interfața Calculator, ce conţine trei metode:
- add: primeşte două numere şi întoarce un double;
- divide: primeşte două numere şi întoarce un double;
- average: primeşte un vector ce conţine valori double şi întoarce media acestora ca numar de tip double. Pentru calculul mediei sunt folosite metodele add şi divide.
Toate aceste valori se citesc dintr-un fisier.

Metodele pot arunca următoarele excepții (definite în interfața Calculator):
- NullParameterException: este aruncată dacă vreunul din parametrii primiți este null;
- OverflowException: este aruncată dacă suma a două numere este egală cu Double.POSITIVE_INFINITY;
- UnderflowException: este aruncată dacă suma a două numere este egală cu Double.NEGATIVE_INFINITY;

De asemenea, definiti propriile clase de exceptii (care sa le extinda pe unele existente in Java) pentru alte situatii ce pot fi intalnite in implementarea proprie,
inclusiv in crearea si citirea din fisier a valorilor procesate de calculator.
De exemplu, creati clasa MyArithmeticException si folositi-o in metoda divide() pentru a acoperi situatia impartirii la 0.

b. Creati o clasa client cu metoda main in care sa evidentiati prin teste toate cazurile posibile care generează excepţii.


 */

//b)
package Ex1Lab7;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    @FunctionalInterface
    interface Executable { void run() throws Exception; }

    public static void main(String[] args) {
        Calculator calc = new DoubleCalculator();

        test("NullParameterException add", () -> calc.add(null, 1.0));
        test("OverflowException", () -> calc.add(Double.MAX_VALUE, Double.MAX_VALUE));
        test("UnderflowException", () -> calc.add(-Double.MAX_VALUE, -Double.MAX_VALUE));
        test("MyArithmeticException", () -> calc.divide(10.0, 0.0));
        test("NullParameterException average null", () -> calc.average(null));
        test("FileProcessingException empty", () -> calc.average(new Double[0]));
        test("FileProcessingException file missing",
                () -> calc.average(loadFromFile(Path.of("nu-exista.txt"))));

        try {
            Path okFile = Path.of("valori.txt");
            if (Files.notExists(okFile))
                Files.writeString(okFile, "1.0\n2.0\n3.0\n");
            Double[] vals = loadFromFile(okFile);
            double m = calc.average(vals);
            System.out.println("[OK] media = " + m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Double[] loadFromFile(Path p) throws FileProcessingException {
        List<Double> list = new ArrayList<>();
        try {
            Files.lines(p).forEach(l -> list.add(Double.parseDouble(l.trim())));
        } catch (Exception e) {
            throw new FileProcessingException("file error", e);
        }
        return list.toArray(new Double[0]);
    }

    private static void test(String label, Executable ex) {
        try {
            ex.run();
            System.out.println("[FAIL] " + label);
        } catch (Exception e) {
            System.out.println("[OK] " + label + " -> " + e.getClass().getSimpleName());
        }
    }
}
