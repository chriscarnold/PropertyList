import java.util.Objects; //importing the Object class for an easy way to create a hash code as we want to make property objects comparable
/**
 * The member class Property simulates a property that is managed by Lambeth Walk Housing Association
 *
 * @author Christopher Arnold
 * @version 04/05/2022
 */
public class Property implements Comparable<Property>
{
    private String name;
    private String type;
    private int size;
    private boolean garage;

    /**
     * Constructor for objects of class Property, creates a new property
     * @param aName the name of this property
     * @param aType what type of resident it is, 
     * whether it is a tenant, leaseholder, or freeholder. 
     * @param aSize number of bedrooms 
     * @param hasAGarage whether the property has an integral garage or not 
     */
    public Property(String aName, String aType, int aSize, boolean hasAGarage)
    {
        name = aName;
        type = aType;
        size = aSize;
        garage = hasAGarage;
    }

    /**
     * Getter for the name of the property
     * 
     * @return    the name of the property
     */
    public String getName()
    {
        return name;
    }

    /**
     * Mutator method to change the property name
     *
     * @param  aName  name of the property
     */
    public void setName(String aName)
    {
        name = aName;
    }

    /**
     * Getter for the type of the property
     *
     * @return    the property type
     */
    public String getType()
    {
        return type;
    }

    /**
     * Mutator method to change the property type
     *
     * @param  aType  type of the property
     */
    public void setType(String aType)
    {
        type = aType;
    }

    /**
     * Getter for the size of the property
     *
     * @return    the property size
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Mutator method to change the property type
     *
     * @param  aSize  size of the property
     */
    public void setSize(int aSize)
    {
        size = aSize;
    }

    /**
     * Tells whether the property has an integral garage or not 
     * 
     * @return    garage true if the property has an integral garage, otherwise false
     */    
    public boolean hasGarage()
    {
        return garage;
    }

    /**
     * setter method for garage
     * 
     * @param  aGarage  true if the property has an integral garage, otherwise false
     */    
    public void setGarage(boolean aGarage)
    {
        garage = aGarage;
    }

    /**
     * Get a string representation of this object including its 
     * name, type, size and garage.
     * @return     a String representation of the property.
     */
    @Override
    public String toString()
    {
        return name + "," + type + "," + size + "," + garage ;
    }

    /**
     * Compare a received object with this object for equality based on property name and type.
     * @param  obj  reference the object to be compared with this object.
     * @return     true if the received object is a property 
     * that has the same name and type as this object.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Property)
        {
            Property prop = (Property) obj;

            return  name.equals(prop.name) 
            && type.equals(prop.type);
        }

        return false;
    }

    /**
     * Returns a hash code for this property based on its name and type
     * 
     * @return    a hash code for this property based on its name and type
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(name,type);
    }

    /**
     * Returns an integer as to whether this property should come before or
     * after the argument property, or if it is equal to it in the order.
     * @return    an integer as to whether this property should come before or
     * after the argument property, or if it is equal to it in the order.
     */
    @Override
    public int compareTo(Property otherProperty)
    {
        return (int) (name.compareTo(otherProperty.name));
    }
}