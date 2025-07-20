package Saves;

import java.io.*;
import java.lang.ClassLoader.*;

public class SaveReader {
    
    public static void main(String[] args) {
        SaveReader reader = new SaveReader();
    }

    public SaveReader() {
        InputStream stream = SaveReader.class.getClassLoader().getResourceAsStream("Saves/save1.txt");
    
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        
        try {
            System.out.println(reader.readLine());
        }

        catch (IOException e) {
            System.out.println("error");
        }
        
    }   

}
