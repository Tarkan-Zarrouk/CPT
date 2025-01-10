import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Methods {
    public static void createFile(String accountName) {
        try {
            File file = new File("accounts/" + accountName + ".txt");
            file.getParentFile().mkdirs();
            if(file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.err.println("Could not create file... Try another name!");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public static void writeToFile(String fileName, String contents) {
        try {
            FileWriter fileWriter = new FileWriter("accounts/" + fileName + ".txt");
            fileWriter.write(contents);
            fileWriter.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
