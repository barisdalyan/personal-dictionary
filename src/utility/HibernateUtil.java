package utility;

import entity.Word;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Barış Dalyan Emre
 */
public class HibernateUtil {

    // Configuration object is used to create SessionFactory which configures Hibernate through 'hibernate.cfg.xml' file.
    // Further, sessionFactory is used to create Session object which sets connection with database.
    private static SessionFactory sessionFactory;

    static {
        
    // Static blocks used to initialize the static data member.
    // It is executed before the main method at the time of classloading.
         

        try {
            if (sessionFactory == null) {
                sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Word.class).buildSessionFactory();
            }
        } catch (Exception exception) {
            System.out.println("Failed to create sessionFactory object - " + exception);

        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
