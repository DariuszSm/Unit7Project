import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ZipCodes {

    static private HashMap<String, String> zipCodes;

    static public void initZipCodes() throws FileNotFoundException {
        zipCodes = new HashMap<String, String>();

        File zipCodes = new File("data/zip_code_database.csv");
        Scanner s = new Scanner(zipCodes);

        s.nextLine();

        while (s.hasNextLine()) {
            String[] currentZip = s.nextLine().split(",");
            if (currentZip[11].equals("US")) {
                ZipCodes.zipCodes.put(currentZip[0], currentZip[11]);
            }
        }
    }

    public static HashMap<String, String> getZipCodes() {
        return zipCodes;
    }
}
