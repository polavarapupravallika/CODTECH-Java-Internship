import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        // Name of the text file
        String fileName = "data.txt";

        // Write initial content into the file
        FileWriter fw = new FileWriter(fileName);
        fw.write("Hello, this is my Java internship project.");
        fw.close();

        // Open the file for reading
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        System.out.println("File Content:");
        String line;

        // Read and display the file line by line
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();

        // Open the file in append mode to modify it
        fw = new FileWriter(fileName, true);
        fw.write("\nThis file was modified successfully.");
        fw.close();

        System.out.println("\nFile modified successfully.");

        // Read the updated file
        br = new BufferedReader(new FileReader(fileName));

        System.out.println("\nUpdated File Content:");

        // Display the updated file content
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}