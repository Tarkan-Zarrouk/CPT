package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Author: Tarkan Zarrouk
 * date: 2025/01/17
 * Reuseable methods
 */
public class Methods { 
    /**
     * Given the account name and the directoryName, we can create the base file for the account
     * @param accountName - name of the account
     * @param directoryName - name of the directory
     * @return void
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
     * Generate a file based off the given name of the file, directory, and the contents of the file
     * @param fileName - name of the file
     * @param directoryName - name of the directory
     * @param contents - contents of the file
     * @return Generated file from the desired path and name of the file
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
     * Delete file given directory name and file name 
     * @param directoryName - name of the directory
     * @param fileName - name of the file
     * @return Deletion of the file with a message indicating if successful or not
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
     * Will return true or false depending on whether or not the file exists or not
     * @param fileName - name of the file
     * @param directoryName - name of the directory
     * @return boolean 
     */
    public static boolean fileExists(String fileName, String directoryName) {
        File file = new File(directoryName + "/" + fileName + ".txt");
        return file.exists();
    }
    /**
     * Read in any file and return the contents of the file as a string
     * @param fileName - name of the file
     * @param directoryName - name of the directory
     * @return returns the information existing within the file
     */
    public static String readInFile(String fileName, String directoryName) {
        // contents of our file
        String data = "";
        try {
            String filePath = directoryName + "/" + fileName + ".txt";
            File file = new File(filePath);
            // parse file using scanner
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
