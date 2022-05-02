package serie5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben den Speicherort(Path), der Datei der verschlüsselten Datei an mit der Namen des Dateien und Dateiendung:");

        Leser leser = new Leser(scanner.nextLine().toString());
        Verschluesselung verschluesselung = new Verschluesselung();

        if(!leser.getHeader().equals("serie5 encryption")){
            System.err.println("Fehler beim Laden der Datei.");
            System.exit(1);
        }

        try {
            List<String> zeilen = new ArrayList<String>(leser.liesInhalt());
            verschluesselung.tauscheZeilen(zeilen);
            StringBuilder entschluesseln = new StringBuilder();
            for (String zeile : zeilen){
                entschluesseln.append(zeile+"\n");
            }

            entschluesseln.replace(0,entschluesseln.length(), verschluesselung.verschiebeBuchstaben(entschluesseln.toString(), 13));
            entschluesseln.replace(0,entschluesseln.length(), verschluesselung.tauscheZeichen(entschluesseln.toString(), 'r','g'));
            entschluesseln.replace(0,entschluesseln.length(), verschluesselung.tauscheZeichen(entschluesseln.toString(), 'a','t'));
            entschluesseln.replace(0,entschluesseln.length(), verschluesselung.tauscheZeichen(entschluesseln.toString(), ')','('));
            entschluesseln.replace(0,entschluesseln.length(), verschluesselung.tauscheZeichen(entschluesseln.toString(), ',','.'));

            zeilen.clear();
            String[] conv = entschluesseln.toString().split("\n");
            zeilen = Arrays.asList(conv);

            //File file = new File("C:\\Users\\Ahmad\\Desktop\\ScreenS\\AuszuegeGG.txt");


            System.out.println("Bitte geben den Speicherort(Path), der Datei der entschlüsselten Datei an mit der Namen des Dateien und Dateiendung: ");
            File file = new File(scanner.nextLine().toString());

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            writerLine(pw, zeilen);
            bw.close();
        }
        catch (FileNotFoundException fnfEX) {
            fnfEX.printStackTrace(System.err);
        }
        catch (IOException ioEX) {
            ioEX.printStackTrace(System.err);
        }
    }

    private static void writerLine(PrintWriter pw, List<String> lines){
        for(String i: lines){
            pw.println(i);
        }
    }

}
