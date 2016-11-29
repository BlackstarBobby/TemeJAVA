import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class crirptare{

    public static void main(String arg[]) throws IOException {
        //retinem cheia
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduceti cheia: ");
        String key = sc.nextLine();

        //pregatim iesirea
        File file =new File("date.out");
        if (!file.exists()) file.createNewFile();

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        //incepem criptarea
        //sc = new Scanner(new File( "date.in"));
        String line;
        int last_pos=0,i;

        String contets = new String(Files.readAllBytes(Paths.get("date.in")),StandardCharsets.UTF_8);

            for ( i=0;i<contets.length();i++) {
                bw.write(((int) contets.charAt(i) ^ (int) key.charAt((i) % key.length())) + " ");
                //System.out.println(contets.charAt(i)+" "+key.charAt(i%key.length())+" "+(contets.charAt(i) ^ (int)key.charAt((i)%key.length())));last_pos++;

            }
        bw.close();
    }
}