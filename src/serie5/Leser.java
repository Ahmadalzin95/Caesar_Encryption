package serie5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class Leser {

    private BufferedReader leser;
    private String header;

    public Leser(String pfad)  {
        File file = new File(pfad);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            InputStreamReader isr;

            if (file.getPath().endsWith(".gz")) {

                GZIPInputStream gzip = new GZIPInputStream(bis);
                isr = new InputStreamReader(gzip);

            }

            else {
                isr = new InputStreamReader(bis);
            }

            {
                this.leser = new BufferedReader(isr);
                this.header = this.leser.readLine();
            }
        }
        catch (FileNotFoundException fnfEX) {
            fnfEX.printStackTrace(System.err);
        }
        catch (IOException ioEX) {
            ioEX.printStackTrace(System.err);
        }
    }

    public String getHeader() {
        return header;
    }

    public List<String> liesInhalt() throws IOException{
        List<String> li = new ArrayList<>();
        String line = this.leser.readLine();

        while (line != null){
            li.add(line);
            line = leser.readLine();
        }
        leser.close();
        return li;
    }



}
