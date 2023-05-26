package BankWriter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankFileWriter {
    public static void writeTransaction(String accountType, String transactionType, float amount) {
        String filename = "C:\\Users\\DELL LATITUDE 5300\\First.txt"; // Specify the file name or path as per your requirement

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateFormat.format(new Date());

            String transactionDetails = "Timestamp: " + timestamp + "\n"
                    + "Account Type: " + accountType + "\n"
                    + "Transaction Type: " + transactionType + "\n"
                    + "Amount: " + amount + "\n\n";

            writer.write(transactionDetails);
            System.out.println("Transaction details written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

}


