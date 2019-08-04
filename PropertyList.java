import java.nio.*;
import java.nio.file.*;
import java.nio.file.AccessMode.*;
import java.io.*;

public class PropertyList {

    private Property head;

    private static String textFileLoc = "./list_of_properties.txt";

    public PropertyList() {
        this.head = null;
    }

    public void insert(Property node) {
        if (head == null) {
            head = node;
            head.setNext(null);
        } else {
            Property ref = head;

            while (ref.getNext() != null) {
                ref = ref.getNext();
            }

            ref.setNext(node);
        }
    }

    public String getAllProperties() {
        String result = new String();
        Property ref;

        if (head == null) {
            return "No property info to return";
        } else {
            ref = head;
            while (ref != null) {
                result += ref.toString() + "\n";
                ref = ref.getNext();
            }
        }

        return result;
    }

    public String getSingleFamilyHouse() {
        String result = new String();
        Property ref;

        if (head == null) {
            return "No property info to return";
        } else {
            ref = head;
            while (ref != null) {
                if (ref instanceof SingleFamilyHouse) {
                    result += ref.toString() + "\n";
                }
                ref = ref.getNext();
            }
        }

        return result;
    }

    public String getCondo() {
        String result = new String();
        Property ref;

        if (head == null) {
            return "No property info to return";
        } else {
            ref = head;
            while (ref != null) {
                if (ref instanceof Condo) {
                    result += ref.toString() + "\n";
                }
                ref = ref.getNext();
            }
        }

        return result;
    }

    public String searchByPriceRange(double min, double max) {
        String result = new String();
        Property ref;

        if (head == null) {
            return "No property info to return";
        } else {
            ref = head;
            while (ref != null) {
                if (ref.getOfferedPrice() >= min &&
                    ref.getOfferedPrice() <= max) {
                    result += ref.toString() + "\n";
                }
                ref = ref.getNext();
            }
        }

        return result;
    }

    public void initialize() {
        // prop type, address, offerPrice, year, prop specific data
        // string string double int double
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath(textFileLoc);
        InputStream input = null;

        String[] array = new String[100];
        String delimiter = ";";

        String propertyType;
        String address;
        double price;
        int year;
        double propSpecificData;

        try {
            input = Files.newInputStream(path);
            BufferedReader reader = new 
                BufferedReader(new InputStreamReader(input));
            String s = null;
            s = reader.readLine();
            while (s != null) {
                s.trim();

                array = s.split(delimiter);
                propertyType = array[0].toLowerCase();
                address = array[1];
                price = Double.parseDouble(array[2]);
                year = Integer.parseInt(array[3]);
                propSpecificData = Double.parseDouble(array[4]);

                if (propertyType.compareTo("sfh") == 0) {
                    this.insert(new SingleFamilyHouse(
                        address,
                        price,
                        year,
                        (int)propSpecificData
                    ));
                } else if (propertyType.compareTo("condo") == 0) {
                    this.insert(new Condo(
                        address,
                        price,
                        year,
                        propSpecificData
                    ));
                } else {
                    System.out.println("Not a property was read from file");
                }

                s = reader.readLine();
            }
            input.close();
        } catch (IOException e) {
            System.out.println("File cannot be read or executed");
        }
    }
}
