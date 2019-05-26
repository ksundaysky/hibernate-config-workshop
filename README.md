# Hibernate - simple configuration - STAGE - 3

Maven project is ready, so we need to code something. 

First we need class which will be represented as a table in our db. Instance of this kinde of class is called POJO ( Plain Old Java Object )

1. Create: Person class
2. Every person must have pesel, name, surname and age. (pesel will be an id of the person)
3. Create 2 constructors, first with all parameters and second empty
4. Create getters and setters for all fields in your class.
5. You need to annotate class as @Entity from package javax.persistance
6. You need to annotate pesel field as @Id from package javax.persistance



