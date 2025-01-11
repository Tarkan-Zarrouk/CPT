import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author: Tarkan Zarrouk
 * date: (due date)
 */

/**
 * General purpose methods, callable throughout the files.
 */
public class Methods {
    // Uses FileWriter & File Objects to make writing to files easier 
    public static void createFile(String accountName, String directoryName) {
        try {
            // intialize new file object
            File file = new File(directoryName + "/" + accountName + ".txt");
            // create directory 
            file.getParentFile().mkdirs();
            // once it's created, we can simply just return a message
            if(file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.err.println("Could not create file... Please try again!");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public static void writeToFile(String fileName, String directoryName, String contents) {
        try {
            FileWriter fileWriter = new FileWriter(directoryName + "/" + fileName + ".txt");
            fileWriter.write(contents);
            fileWriter.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public static void deleteFile(String directoryName, String fileName) {
        // get path with object
        File file = new File(directoryName + "/" + fileName);
        if(file.delete()) {
            System.out.println(fileName + " has been succesfully deleted! 😊");
        } else {
            System.out.println("File has NOT been deleted. Try retyping it as a correct path or remove the '/'!");
        }
    }
}
