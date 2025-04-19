/*
2. Scrieti un program Java care:
    a. sa gaseasca cel mai lung cuvant dintr-un fisier text;
    b. sa adauge continutul clasei curente Java in fisierul text utilizat la exercitiul anterior;
    c. sa salveze intr-un array, linie cu linie, continutul fisierului folosit la primul exercitiu.
 */

package Ex2Lab7;

import java.nio.file.*;
import java.io.*;
import java.util.List;

public class FileTasks {

    public static void main(String[] args) throws IOException {
        Path file = Path.of("text.txt");

        if (Files.notExists(file)) {
            Files.writeString(file, """
                    Hoby-ul meu este algoritmica
                    Java este un limbaj de programare popular
                    Lucrul cu colectii si streamuri il face puternic
                    """);
        }
//a)
        String longest = longestWord(file);
        System.out.println("Cel mai lung cuvant: " + longest);
//b)
        appendSource(file);
//c)
        String[] lines = readLines(file);
        System.out.println("Numar de linii: " + lines.length);
    }

    static String longestWord(Path file) throws IOException {
        String max = "";
        for (String line : Files.readAllLines(file)) {
            for (String w : line.split("[^A-Za-z0-9]+")) {
                if (w.length() > max.length()) max = w;
            }
        }
        return max;
    }

    static void appendSource(Path target) throws IOException {
        Path src = Path.of("src/main/java/Ex2Lab7", FileTasks.class.getSimpleName() + ".java");
        if (Files.notExists(src)) src = Path.of(FileTasks.class.getSimpleName() + ".java");
        if (Files.notExists(src)) return;

        Files.writeString(target,
                System.lineSeparator() + System.lineSeparator() +
                        "===== " + src.getFileName() + " =====" + System.lineSeparator(),
                StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        Files.write(target, Files.readAllBytes(src), StandardOpenOption.APPEND);
    }

    static String[] readLines(Path file) throws IOException {
        List<String> list = Files.readAllLines(file);
        return list.toArray(new String[0]);
    }
}

