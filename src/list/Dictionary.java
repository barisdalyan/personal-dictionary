package list;

import entity.Word;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.StringJoiner;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import utility.CrudUtil;
import utility.HibernateUtil;

/**
 *
 * @author Barış Dalyan Emre
 */
public class Dictionary extends javax.swing.JFrame {
    
    private DefaultListModel<String> jlistModel; // Unfortunately, there isn't a method which returns selected row object in list,
    private CrudUtil crudUtil;                   // this made hard to works.                
    private List<Word> wordList; // It contains word objects.
    private StringJoiner stringJoiner;
    
    public Dictionary() {
        initComponents();
        this.setLocationRelativeTo(this); // Set frame location to window center.
        try {
            // setImg() method is used to add image to panel (through ImagePanel.jar).
            tbGoogle.setImg(ImageIO.read(getClass().getResource("/iconimg/googletranslate.png")));
            tbSesliSozluk.setImg(ImageIO.read(getClass().getResource("/iconimg/seslisozluk.png")));
            
        } catch (IOException exception) {
            System.out.println("Image IOException Error: " + exception.toString());
        }
        jlistModel = new DefaultListModel<>(); // JList model is created
        jlistWords.setModel(jlistModel); // and jlistWords formatted to jlistModel.

    }

    /**
     * Paste initComponents() with Annotation: @SuppressWarnings("unchecked")
     * here. This method is called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code.
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel1 = new ImagePanel.TabPanel();
        jpBackground = new javax.swing.JPanel();
        jpControl = new javax.swing.JPanel();
        tfEnglish = new javax.swing.JTextField();
        tfTurkish = new javax.swing.JTextField();
        lblEnglish = new javax.swing.JLabel();
        lblTurkish = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();
        checkFilter = new javax.swing.JCheckBox();
        jpList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistWords = new javax.swing.JList<>();
        lblTranslate = new javax.swing.JLabel();
        lblInfoType = new javax.swing.JLabel();
        lblDatabaseInfo = new javax.swing.JLabel();
        lblSesliSozluk = new javax.swing.JLabel();
        tbGoogle = new ImagePanel.TabPanel();
        tbSesliSozluk = new ImagePanel.TabPanel();

        javax.swing.GroupLayout tabPanel1Layout = new javax.swing.GroupLayout(tabPanel1);
        tabPanel1.setLayout(tabPanel1Layout);
        tabPanel1Layout.setHorizontalGroup(
            tabPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        tabPanel1Layout.setVerticalGroup(
            tabPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dictionary");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Dictionary.class.getResource("/iconimg/book.png")));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jpControl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tfEnglish.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tfEnglish.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tfEnglish.setMargin(new java.awt.Insets(4, 4, 4, 4));
        tfEnglish.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfEnglishKeyReleased(evt);
            }
        });

        tfTurkish.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tfTurkish.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tfTurkish.setMargin(new java.awt.Insets(4, 4, 4, 4));

        lblEnglish.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        lblEnglish.setText("English:");

        lblTurkish.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        lblTurkish.setText("Turkish:");

        btnSave.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblWarning.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblWarning.setForeground(new java.awt.Color(102, 0, 0));

        checkFilter.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        checkFilter.setText("Filter");
        checkFilter.setFocusable(false);

        javax.swing.GroupLayout jpControlLayout = new javax.swing.GroupLayout(jpControl);
        jpControl.setLayout(jpControlLayout);
        jpControlLayout.setHorizontalGroup(
            jpControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpControlLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpControlLayout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpControlLayout.createSequentialGroup()
                        .addComponent(lblEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tfEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTurkish, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTurkish, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpControlLayout.createSequentialGroup()
                        .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        jpControlLayout.setVerticalGroup(
            jpControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpControlLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jpControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTurkish, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnglish)
                    .addComponent(lblTurkish))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkFilter))
                .addGap(14, 14, 14))
        );

        jpList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jScrollPane2.setColumnHeaderView(null);

        jlistWords.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jlistWords.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jlistWords.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "familiarity", "collide", "hence", "congress", "convetion", "watertight", "whereas", "corrupt", "just after", "fundamentally", "newbie", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jlistWords.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlistWords.setFocusable(false);
        jlistWords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistWordsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jlistWords);

        javax.swing.GroupLayout jpListLayout = new javax.swing.GroupLayout(jpList);
        jpList.setLayout(jpListLayout);
        jpListLayout.setHorizontalGroup(
            jpListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
        jpListLayout.setVerticalGroup(
            jpListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblTranslate.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        lblTranslate.setText("  Google Translate");
        lblTranslate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTranslate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTranslateMouseClicked(evt);
            }
        });

        lblInfoType.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        lblInfoType.setForeground(new java.awt.Color(102, 51, 0));
        lblInfoType.setText("Operation:");

        lblDatabaseInfo.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        lblDatabaseInfo.setText("Connecting...");

        lblSesliSozluk.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        lblSesliSozluk.setText("  Sesli Sozluk");
        lblSesliSozluk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSesliSozluk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSesliSozlukMouseClicked(evt);
            }
        });

        tbGoogle.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout tbGoogleLayout = new javax.swing.GroupLayout(tbGoogle);
        tbGoogle.setLayout(tbGoogleLayout);
        tbGoogleLayout.setHorizontalGroup(
            tbGoogleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        tbGoogleLayout.setVerticalGroup(
            tbGoogleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        tbSesliSozluk.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout tbSesliSozlukLayout = new javax.swing.GroupLayout(tbSesliSozluk);
        tbSesliSozluk.setLayout(tbSesliSozlukLayout);
        tbSesliSozlukLayout.setHorizontalGroup(
            tbSesliSozlukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        tbSesliSozlukLayout.setVerticalGroup(
            tbSesliSozlukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpBackgroundLayout = new javax.swing.GroupLayout(jpBackground);
        jpBackground.setLayout(jpBackgroundLayout);
        jpBackgroundLayout.setHorizontalGroup(
            jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addComponent(jpList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBackgroundLayout.createSequentialGroup()
                                .addComponent(lblInfoType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDatabaseInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpBackgroundLayout.createSequentialGroup()
                                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbGoogle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbSesliSozluk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTranslate)
                                    .addComponent(lblSesliSozluk))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpBackgroundLayout.setVerticalGroup(
            jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTranslate)
                            .addComponent(tbGoogle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSesliSozluk)
                            .addComponent(tbSesliSozluk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInfoType)
                            .addComponent(lblDatabaseInfo)))
                    .addComponent(jpList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getWordList(); // When frame is initialed first time, it gets word list from database.

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        System.gc();  // JVM returns unused objects in order to recycle to RAM.
        HibernateUtil.getSessionFactory().close(); // Program ends we have to close SessionFactory. 


    }//GEN-LAST:event_formWindowClosing

    private void lblSesliSozlukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSesliSozlukMouseClicked
        int control = jlistWords.getSelectedIndex();
        String[] selectedWord;

        Desktop desktop = Desktop.getDesktop();

        try {
            if (control != -1) {
                lblWarning.setText("");
                if (stringInjection() == true) {

                    desktop.browse(new URI("https://www.seslisozluk.net/en/what-is-the-meaning-of-" + stringJoiner + "/"));
                } else {
                    selectedWord = jlistWords.getSelectedValue().trim().split(":");
                    desktop.browse(new URI("https://www.seslisozluk.net/en/what-is-the-meaning-of-" + selectedWord[1].trim() + "/"));
                }
            } else {
                lblWarning.setText("Warning: Please select a word to search!");
            }
        } catch (URISyntaxException exception) {
            System.out.println("Error: ");
            exception.printStackTrace();
        } catch (IOException exception) {
            System.out.println("Error: ");
            exception.printStackTrace();
        }
    }//GEN-LAST:event_lblSesliSozlukMouseClicked

    private void lblTranslateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTranslateMouseClicked
        int control = jlistWords.getSelectedIndex();
        String[] selectedWord;

        Desktop desktop = Desktop.getDesktop(); // Taken permission from Desktop.

        try {
            if (control != -1) { // Check, list is selected or not.
                lblWarning.setText("");
                if (stringInjection() == true) { // If there is any space between words, use stringJoiner.

                    desktop.browse(new URI("https://translate.google.com/#view=home&op=translate&sl=en&tl=tr&text=" + stringJoiner));
                    // Method browse() runs URI on your default browser.

                } else {
                    selectedWord = jlistWords.getSelectedValue().trim().split(":");
                    // Selected jList row has id and word string, this is why we splitted it to String array to reach english word.

                    desktop.browse(new URI("https://translate.google.com/#view=home&op=translate&sl=en&tl=tr&text=" + selectedWord[1].trim()));
                }

            } else {
                lblWarning.setText("Warning: Please select a word to search!");
            }
        } catch (URISyntaxException exception) {
            System.out.println("Error: ");
            exception.printStackTrace();
        } catch (IOException exception) {
            System.out.println("Error: ");
            exception.printStackTrace();
        }
    }//GEN-LAST:event_lblTranslateMouseClicked

    private void jlistWordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistWordsMouseClicked

        // This method is used to set selected english word,
        // which fetched from database, to text fields (its turkish meaning through method getSpecificValue() as well).
        if (jlistModel.isEmpty() == false) { // Check, list is empty or not.
            lblWarning.setText("");
            String[] splitedWordString = jlistWords.getSelectedValue().split(":");
            String turkishString = crudUtil.getSpecificValue(Integer.parseInt(splitedWordString[0].trim()));
            tfEnglish.setText(splitedWordString[1].trim());
            tfTurkish.setText(turkishString);
        } else {
            lblWarning.setText("Warning: List is empty caused by filter currently.");
        }
    }//GEN-LAST:event_jlistWordsMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (jlistWords.getSelectedIndex() != -1) {
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Are you sure to delete?", "Warning", 0)) {
                String[] selectedWord = jlistWords.getSelectedValue().trim().split(":"); // Split selected row to id and word
                crudUtil = new CrudUtil();
                crudUtil.deleteWord(Integer.parseInt(selectedWord[0].trim())); // then send word id for deletion.
                jlistModel.removeAllElements(); // Clear all words in list
                getWordList(); // and refresh it.
                clearFields();
                lblWarning.setText("Info: Deletion is successful.");
            }
        } else {
            lblWarning.setText("Warning: Please select a word to delete!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (jlistWords.getSelectedIndex() != -1) {
            String[] selectedWord = jlistWords.getSelectedValue().trim().split(":"); // Split selected row to id and word
            crudUtil = new CrudUtil();  // then send word id with text fields for updating.
            crudUtil.updateWord(Integer.parseInt(selectedWord[0].trim()), tfEnglish.getText().trim(), tfTurkish.getText().trim());
            jlistModel.removeAllElements();
            getWordList();

            lblWarning.setText("Info: Update is successful.");
        } else {
            lblWarning.setText("Warning: Please select a word to update!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!tfEnglish.getText().equals("") && !tfTurkish.getText().equals("")) {

            if (binarySearchForSave(tfEnglish.getText()) == false) { // Check, the word is existed or not.
                crudUtil = new CrudUtil();
                crudUtil.saveWord(tfEnglish.getText(), tfTurkish.getText()); // New word is saved to database.
                jlistModel.removeAllElements(); // Clear all words in list
                getWordList(); // and refetch word list from database to show new word.

                lblWarning.setText("Info: Registration is successful.");
            } else {
                lblWarning.setText("Warning: The word exists in list already.");
            }

        } else {
            lblWarning.setText("Warning: Please fill in blanks for recording!");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tfEnglishKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEnglishKeyReleased

        // This method is a key listener.
        if (tfEnglish.getText().equals("")) { // It clears turkish text field when tfEnglish is empty.
            tfTurkish.setText("");
            lblWarning.setText("");
        }
        if (checkFilter.isSelected() == true) { // If filter mode is selected, run the method (filter()).
            jlistModel.removeAllElements();
            filter(tfEnglish.getText());
        }
    }//GEN-LAST:event_tfEnglishKeyReleased
    
    private void filter(String word) { // Filter the list to word and count it.
        int number = 0;
        for (Word list : wordList) {
            if (list.getEnglishWord().toLowerCase().contains(word.toLowerCase())) {
                jlistModel.addElement(list.getId() + " : " + list.getEnglishWord());
                number++;
            }
        }
        
        if (jlistModel.isEmpty() == true) {
            lblWarning.setText("Info: This word isn't in the list, but you can add it with 'save' button.");
        } else {
            lblWarning.setText("Info: Total number of words is " + number + ".");
        }
    }
    
    private void getWordList() { // This method adds words from database to wordList and then fills to the jlist.  
        int number = 0;
        crudUtil = new CrudUtil();
        wordList = crudUtil.selectWords();
        lblDatabaseInfo.setText("Connected to Database");
        
        for (Word list : wordList) {
            jlistModel.addElement(list.getId() + " : " + list.getEnglishWord());
            number++;
        }
        lblWarning.setText("Info: Total number of words is " + number + ".");
    }
    
    private boolean binarySearchForSave(String word) { // Check, the word is existed or not.

        int lastElementIndex = wordList.size() - 1;
        int firstElementIndex = 0;
        int middleElementIndex;
        
        while (firstElementIndex <= lastElementIndex) {
            middleElementIndex = (int) (firstElementIndex + lastElementIndex) / 2;
            String middleElementString = wordList.get(middleElementIndex).getEnglishWord().trim();
            
            if (middleElementString.compareTo(word.trim()) > 0) { // If middle element string is greater than the word.
                lastElementIndex = middleElementIndex - 1;
            } else if (middleElementString.trim().equals(word.trim()) == true) {
                return true;
            } else {
                firstElementIndex = middleElementIndex + 1;
            }
            
        }
        return false; // The word is not in list, so you can save it.
    }
    
    private boolean stringInjection() {
        
        int countSpace = 0;
        for (int i = 0; i < jlistWords.getSelectedValue().length(); i++) {
            if (jlistWords.getSelectedValue().charAt(i) == ' ') { // Check, how many space is in selected row..
                countSpace++;
            }
        }
        
        if (countSpace > 2) { // For instance: '3 : jast after' has one space (between words), we insert "%20" to space using StringJoiner.

            stringJoiner = new StringJoiner("%20"); // For insertion to URI.

            String[] selectedWord = jlistWords.getSelectedValue().trim().split(":");
            String[] splittedSelectedWord = selectedWord[1].split(" ");
            
            for (int i = 0; i < splittedSelectedWord.length; i++) {
                stringJoiner.add(splittedSelectedWord[i]);
                
            }
            return true;
            
        } else {
            return false;
        }
        
    }
    
    private void clearFields() {
        tfEnglish.setText("");
        tfTurkish.setText("");    
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox checkFilter;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jlistWords;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JPanel jpControl;
    private javax.swing.JPanel jpList;
    private javax.swing.JLabel lblDatabaseInfo;
    private javax.swing.JLabel lblEnglish;
    private javax.swing.JLabel lblInfoType;
    private javax.swing.JLabel lblSesliSozluk;
    private javax.swing.JLabel lblTranslate;
    private javax.swing.JLabel lblTurkish;
    private javax.swing.JLabel lblWarning;
    private ImagePanel.TabPanel tabPanel1;
    private ImagePanel.TabPanel tbGoogle;
    private ImagePanel.TabPanel tbSesliSozluk;
    private javax.swing.JTextField tfEnglish;
    private javax.swing.JTextField tfTurkish;
    // End of variables declaration//GEN-END:variables
}
