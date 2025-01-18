package tests;

import main.Methods;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * author: Tarkan Zarrouk
 * date: 2025/01/19
 * Unit testing
 */


 /**
  * Unit tests for the Methods class
  */
public class MethodsTest {
    // can be confident that 1 will suffice for each... It literally repeats the same thing I think one unit test can make me be sure...
    @Test
    void testFileExists() {
        // Arrange
        // we'll just use a random directory since this is not prevalent to the codebase itself, just as example
        String directoryName = "testDirectory";
        String fileName = "existingFile";
        Methods.createFile(fileName, directoryName);

        // Act
        boolean actualExists = Methods.fileExists(fileName, directoryName);

        // Assert
        Assertions.assertEquals(actualExists, true);
    }

    @Test
    void testReadInFile() {
        // Arrange
        String directoryName = "testDirectory";
        String fileName = "fileToRead";
        String expectedContents = "This is the content to read.";
        Methods.writeToFile(fileName, directoryName, expectedContents);

        // Act
        String actualContents = Methods.readInFile(fileName, directoryName);

        // Assert
        Assertions.assertEquals(expectedContents, actualContents);
    }
}
