package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Barış Dalyan Emre
 */

@Entity // We indicate class Word is a persistent object with this annotation.
@Table(name = "tbl_word_list", schema = "public") // Entity is mapped with our table. 
public class Word { // POJO stands for Plain-Old-Java-Object.

    @Id // We have to define Id annotation to authenticate Entity objects.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // We leted database to generate sequential id value. 
                                                        // (used strategy IDENTITY for PostgreSQL) 
    @Column(name = "word_id") // We mapped Entity persistent variables with table columns.
    private int id;
    @Column(name = "english_word")
    private String englishWord;
    @Column(name = "turkish_word")
    private String turkishWord;

    public Word(String englishWord, String turkishWord) {
        this.englishWord = englishWord;
        this.turkishWord = turkishWord;
    }
    
    public Word(){ 
        
    }
    
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getTurkishWord() {
        return turkishWord;
    }

    public void setTurkishWord(String turkishWord) {
        this.turkishWord = turkishWord;
    }

}
