
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class MyFile {
    private String filename;

    public MyFile(String filename) {
        this.filename = filename;
    }

    public List<String> leggi() {
        List<String> domande = new ArrayList<String>();
        
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                domande.add(new String(line));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return domande;
    }

    /*public void scrivi(String s) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.append(s + '\n');
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(MyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void riscriviFile(List<String> persone) {
        clear();
        try {
            FileWriter fw = new FileWriter(filename, true);
            for(String x : persone)
                fw.append(x.toString() + '\n');
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(MyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clear() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(filename);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
