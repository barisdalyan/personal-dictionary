package utility;

import entity.Word;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Barış Dalyan Emre
 */

public class CrudUtil {

    public List selectWords() { // This method returns english word records from database.

        Session session = HibernateUtil.getSessionFactory().openSession(); // Taken session object from SessionFactory.
        // Field between Session creation and session.close is named as Persistence Contex (entity's life cycle). 
        List<Word> wordList;

        try {
            session.beginTransaction();
            // Persistence Contex
            // Query (getResultList()) returns a List object.
            wordList = session.createQuery("FROM Word w ORDER BY w.englishWord").getResultList(); // Ascending.

            session.getTransaction().commit(); // If there is any problem in entity's life cycle, Hibernate uses 
                                               // transaction functionality and rollback all process.

            return wordList;
        } finally {
            session.close(); // Session is not thread-safe so we have to close it end of entity's life cycle.   
        }

    }

    public String getSpecificValue(int idNumber) { // This method is used to get selected word's Turkish meaning in JList. 

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<String> word;
        String value;

        try {
            session.beginTransaction();

            word = session.createQuery("SELECT w.turkishWord FROM Word w WHERE w.id=" + idNumber).getResultList();
            value = word.get(0); // use get(Word.class,id)

            session.getTransaction().commit();
            return value;
        } finally {
            session.close();
        }

    }

    public void saveWord(String englishWord, String turkishWord) { // Adding new record to database.

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            Word word = new Word(englishWord, turkishWord); // Create new entity and save. 
            session.save(word);

            session.getTransaction().commit();

        } finally {
            session.close();
        }

    }

    public void updateWord(int wordId, String englishWord, String turkishWord) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            session.beginTransaction();

            Word word = session.get(Word.class, wordId); // Get selected entity class using Id.
            word.setEnglishWord(englishWord); // Update with new word
            word.setTurkishWord(turkishWord);
            session.save(word); // and save it again.

            session.getTransaction().commit();

        } finally {
            session.close();
        }

    }

    public void deleteWord(int wordId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            Word word = session.get(Word.class, wordId); // Get selected entity class using Id
            session.delete(word); // and delete it.

            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }

}
