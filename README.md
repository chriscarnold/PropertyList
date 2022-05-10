# PropertyList
Application that is able to create a TreeSet of properties to create/maintain a property list. The database can be imported from a CSV file. The TreeSet can be updated and also exported into a CSV file

## Description
A Housing association works with a database that contains a CSV file of all the properties that it manages. 
Each property has a set of attributes which, for simplification, I have narrowed down to the following four: 
•	name (first line of the address) 
•	size (number of bedrooms) 
•	type (what type of resident it is, whether it is a tenant, leaseholder, or freeholder. A leasehold is the ownership over a property for a limited lease, whereas a freehold means absolute ownership over the property and the land it stands on). 
•	garage (whether the property has an integral garage or not). 
The above attributes are stored in such a way where every row contains one property and its property in the CSV file.  
For this scenario, a members class Property and an organisation class HousingManagement will be created. 

######Class representing a member : Property  
Property has the instance variables: 
- name and type of type String.  
- size of type integer. 
- arage of type Boolean. 
The class will have a constructor, getter and mutator methods for every instance variable and equals, hashCode and toString methods. The class implements the Comparable interface, and the assumption will be made that properties are unique so they can be sorted on the name field. 

######Class holding the membership database :  HousingManagement 
HousingManagement will have a TreeSet of Property. The TreeSet will be named properties and will have methods that can read and write from/to the CSV file. HousingManagement will also contain methods to add, delete, update, and remove the whole set. Another possible method could create a new set of properties based on property type and print the new set sorted by name. 

A TreeSet does not keep duplicates and sorts the set automatically. This is very useful in the example of the Housing association as properties are unique and will be sorted based on the property name. It will make sense to sort by name or by name and size of properties. If we sort based only on size, this will only show one property for each property size and this is not what we are looking to achieve. 
