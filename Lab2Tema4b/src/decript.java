import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class Decriptare{

    public static void main(String arg[]) throws IOException {
        //citesc cheia
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduceti cheia: ");
        String key = sc.nextLine();
        //pregatesc iesirea
        File file = new File("date.out");
        if (!file.exists()) file.createNewFile();

        FileWriter fw =new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw =new BufferedWriter(fw);

        //sc = new Scanner( new File("date.in"));
        //String input=sc.nextLine();

        //citesc fisierul
        String contets = new String(Files.readAllBytes(Paths.get("date.in")), StandardCharsets.UTF_8);
        //fac split
        String[] pieces = contets.split(" ");
        //decriptez si scriu in fisier rezultatul
        for (int i=0;i<pieces.length;i++){
                bw.write((char)((Integer.parseInt(pieces[i]) ^ (int)key.charAt(i%key.length()))));
              //  System.out.println(pieces[i]+' '+key.charAt(i%key.length())+' '+(char)(Integer.parseInt(pieces[i]) ^ (int)key.charAt(i%key.length())));
        }

        bw.close();
    }
}