package serie5;

import java.util.List;

public class Verschluesselung {

    public void tauscheZeilen(List<String> zeichenketten){

        for (int i = 0; i<zeichenketten.size(); i+=2){

            if(i+1 < zeichenketten.size()) {
                String tmpZeile;
                tmpZeile = zeichenketten.get(i);
                zeichenketten.set(i, zeichenketten.get(i+1));
                zeichenketten.set(i+1, tmpZeile);
            }
        }
    }

    public String tauscheZeichen(String zeichenkette, char A, char B){

        StringBuilder tauschZeichenn = new StringBuilder(zeichenkette.toString());

        for (int i = 0; i < tauschZeichenn.toString().length(); i++){
            if(tauschZeichenn.charAt(i) == A){
                tauschZeichenn.replace(i,i+1, Character.toString(B));
            }
            else if (tauschZeichenn.charAt(i) == B){
                tauschZeichenn.replace(i,i+1, Character.toString(A));
            }
        }

        return tauschZeichenn.toString();
    }

   public String verschiebeBuchstaben(String zeichenkette, int wert){

       StringBuilder verschiebe = new StringBuilder(zeichenkette);

       for (int i = 0; i < zeichenkette.toString().length(); i++){
           int chaInt = zeichenkette.charAt(i);
           if ( chaInt >= 65 && chaInt <= 90){
               int a = chaInt - wert;
               if(a < 65){
                   int b = 64 - a;
                   chaInt =  90 - b;
                   verschiebe.replace(i, i+1, Character.toString ((char)chaInt));
               }
               else {
                   verschiebe.replace(i, i + 1, Character.toString((char)a));
               }
           }
           else if ( chaInt >= 97 && chaInt <= 122){
               int a = chaInt - wert;
               if(a < 97){
                   int b = 96 - a;
                   chaInt =  122 - b;
                   verschiebe.replace(i, i+1, Character.toString ((char)chaInt));
               }
               else {
                   verschiebe.replace(i, i+1, Character.toString((char)a));
               }
           }
       }

       return verschiebe.toString();

   }

}
