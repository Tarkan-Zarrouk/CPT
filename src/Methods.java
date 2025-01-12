import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Author: Tarkan Zarrouk
 * date: (due date)
 */

/**
 * General purpose methods, callable throughout the files.
 */
public class Methods { 
    /**
     * @param accountName - name of the account
     * @param directoryName - name of the directory
     * @return void
     * Given the account name and the directoryName, we can create the base file for the account
     */
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
    /**
     * @param fileName - name of the file
     * @param directoryName - name of the directory
     * @param contents - contents of the file
     * @return void
     * Given the name of the file + the directory of the desired path with the contents, we can write to that path
     */
    public static void writeToFile(String fileName, String directoryName, String contents) {
        try {
            // initalize new file object
            FileWriter fileWriter = new FileWriter(directoryName + "/" + fileName + ".txt");
            // write to file
            fileWriter.write(contents);
            // close writer (similar to input)
            fileWriter.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    /**
     * @param directoryName - name of the directory
     * @param fileName - name of the file
     * @return void
     * Given the directory path and file, we can simply delete the specified file (account)
     */
    public static void deleteFile(String directoryName, String fileName) {
        // get path with object
        File file = new File(directoryName + "/" + fileName);
        // delete file
        if(file.delete()) {
            System.out.println(fileName + " has been succesfully deleted! 😊");
        } else {
            System.out.println("File has NOT been deleted. Try retyping it as a correct path or remove the '/'!");
        }
    }
    /**
     * @param fileName - name of the file
     * @param directoryName - name of the directory
     * @return boolean
     * Simple check to see whether or not the file actually exists 
     */
    public static boolean fileExists(String fileName, String directoryName) {
        File file = new File(directoryName + "/" + fileName + ".txt");
        return file.exists();
    }
    public static String readInFile(String fileName, String directoryName) {
        String data = "";
        try {
            File file = new File(directoryName + "/" + fileName + ".txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                data += scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return data;
    }
}
