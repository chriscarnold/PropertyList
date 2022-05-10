import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.*;
import java.text.*;

/**
 * HousingManagement models the information used by the Lambeth Walk Housing Association to maintain their housing register
 *
 * @author Christopher Arnold
 * @version 04/05/2022
 */
public class HousingManagement
{
    private SortedSet<Property> properties;

    /**
     * Constructor for objects of class HousingManagement, it will create a TreeSet of properties
     */
    public HousingManagement()
    {
        properties = new TreeSet<>();
    }

    /**
     * Method to clear the housing register
     */
    public void clear()
    {
        properties.clear();
    }

    /**
     * Method to populate the housing register with five different example member objects
     */
    public void populate()
    {
        properties.add(new Property("THE GLEBE", "tenant", 3, false));
        properties.add(new Property("CROMWELL HOUSE", "tenant", 3, false));
        properties.add(new Property("WARWICK HOUSE", "leaseholder", 5, false));
        properties.add(new Property("1 CLOISTER ROAD", "leaseholder", 2, true));
        properties.add(new Property("2 CLOISTER ROAD", "freeholder", 2, true));
    }

    /**
     * Method to write the housing register to a csv file
     * @param  fileName  name of the csv file
     */
    public void writeCSVFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Property p : properties) {
                writer.write(p.toString());
                writer.write("\n");
            }
        } catch (IOException ex) {
            System.out.println("Failed to Write File\n");
            ex.printStackTrace();
        }
    }

    /**
     * Method to read a csv file and add the properties to the collection
     * @param  fileName  name of the csv file
     */
    public void readCSVFile(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String line = reader.readLine();

            while (line != null) {
                try (Scanner lineScanner = new Scanner(line)) {
                    lineScanner.useDelimiter(",");
                    String aName = lineScanner.next();
                    String aType = lineScanner.next();
                    int aSize = Integer.parseInt(lineScanner.next());
                    boolean hasAGarage = lineScanner.nextBoolean();
                    properties.add(new Property(aName, aType, aSize, hasAGarage));
                    
                }
                line = reader.readLine();
            }

        } catch (IOException ex) {
            System.out.println("Failed to Read File\n");
            ex.printStackTrace();
        }
    }

    /**
     * Method to add a new property to the collection
     * @param  aProperty  new property object to be added to the collection
     */
    public void addMember(Property aProperty)
    {
        if (properties.contains(aProperty)) {
            System.out.println("The " + aProperty.getType() + " residing at the " + aProperty.getSize() 
                + " bedroom sized property " + aProperty.getName() 
                + " is already on the housing register.");

        }
        properties.add(aProperty);
    }

    /**
     * Method to remove an existing property from the collection
     * @param  aProperty  property object to be removed from the collection
     * @return    true if the property in question has been rmoved from the collection, otherwise false
     */
    public boolean removeMember(Property aProperty)
    {
        if (!(properties.contains(aProperty))) {
            return false;
        }
        properties.remove(aProperty);
        return true;
    }

    /**
     * Method to update the garage value of a specified property in the housing register
     * @param  aProperty  property object to be updated
     * @param  withGarage  new garage value
     */
    public void updateMember(Property aProperty, boolean withGarage)
    {
        if (properties.contains(aProperty)) {
            aProperty.setGarage(withGarage);
        } else {
            System.out.println("The property " + aProperty.getName()  + " could not be found. ");
        }
    }

    /**
     * Returns a subset of the original housing register, the subset is filtered by the property size in the parameter
     * @param  bedSize  filter attibute used to create a new subset
     * @return    sub_set a subset of the properties TreeSet containing properties with the same size 
     * as specified in the parameter
     */
    public TreeSet<Property> selectMembers(int bedSize)
    {
        TreeSet<Property> sub_set = new TreeSet<Property>();
        for (Property p : properties) {
            if(p.getSize() == bedSize) {
                sub_set.add(p);
            }
        }    
        return sub_set;
    }

    /**
     * Prints a each of the properties in the TreeSet, one property per line with one final blank line
     */
    public void printMembers()
    {
        for (Property p : properties) {
            System.out.printf("%-25s %-11s %-2d %b\n", p.getName(), p.getType(), p.getSize(), p.hasGarage());
        } 
    }
}
