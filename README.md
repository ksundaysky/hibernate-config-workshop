# Hibernate - simple configuration - STAGE - 4

Now we have got Person class ready to be represented as table in SQL database.

It is time to make connection between our java application and database.
There are two ways to achieve this: 
* Create Properties objects
* Create xml file with configuration

Today we will do it programmatically, so:

1. Create Class DatabaseConnection.
2. This class has one field SessionFactory.
3. Create static method which returns SessionFactory. We will initialize and return SessionFactory object in this method
4. In this method, create Properties object (Properties properties = new Properties())
5. Put to properties object (you need to replace *** with your data):

```java
                properties.put(Environment.DRIVER, "***");
                properties.put(Environment.URL, "***");
                properties.put(Environment.USER, "***");
                properties.put(Environment.PASS, "***");
                properties.put(Environment.DIALECT, "***");
                properties.put(Environment.SHOW_SQL, "***");
                properties.put(Environment.HBM2DDL_AUTO, "***");
```

6. Then add this code below (this code will make magic and connect db and application )

```java
Configuration configuration = new Configuration(); //creating Configuration object
configuration.setProperties(settings); // setting propperties of connection
configuration.addAnnotatedClass(Person.class); // adding classes which will be represented as tables
 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();  // creating ServiceRegistery interface with basic im
 sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
```

7. Now our Session factory object is set, you can test it by 
establishing session in main method.

[ link to documentation](https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/SessionFactory.html)

8. If everything is ok, table Person should be in db. 









