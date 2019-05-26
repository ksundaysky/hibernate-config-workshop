import org.hibernate.HibernateException;
import org.hibernate.Session;
import pl.ksundaysky.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        try(Session session = DatabaseConnection.getSessionFactory().openSession()){
            System.out.println("connection established");

        }catch (HibernateException e){
            System.out.println("something went wrong");
        }
    }
}
