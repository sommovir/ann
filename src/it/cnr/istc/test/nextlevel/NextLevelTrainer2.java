/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package it.cnr.istc.test.nextlevel;

import it.cnr.istc.PerceptronTEST;
import it.cnr.istc.UtilsANN;
import it.cnr.istc.ann.Trainer;
import it.cnr.istc.ann.events.TrainingEventManager;
import it.cnr.istc.ann.events.TrainingListener;
import it.cnr.istc.datasets.DataBucket;
import it.cnr.istc.datasets.Dataset;
import it.cnr.istc.icv.exceptions.TypeDataMismatchException;
import it.cnr.istc.icv.test.TimeValueSupporterClass;
import it.cnr.istc.test.QuadranteTester;
import it.cnr.istc.test.divisorepiano.DivisoreFrame2;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Luca
 */
public class NextLevelTrainer2 extends javax.swing.JFrame implements TrainingListener {

    PerceptronTEST2 perceptron = new PerceptronTEST2(10);
    int currentNextLevel = 1;

    /**
     * Creates new form NextLevelTrainer
     */
    public NextLevelTrainer2() {
        initComponents();
        try {
            DataBucket generateDataset = generateDataset();
            for (Dataset dataset : generateDataset.getDatasets()) {

                perceptron.setInputs(dataset.getInputs());
                currentNextLevel = perceptron.activate();
                if (currentNextLevel == dataset.getDesiredAnswer()) {
                    this.jLabel_response.setText("VALID");
                } else {
                    this.jLabel_response.setText("INVALID");
                    perceptron.adjust(dataset.getDesiredAnswer());
                    
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(NextLevelTrainer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private DataBucket generateDataset() {

        DataBucket db = new DataBucket(2);
        db.addDataset(new Dataset(new float[]{Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), 0f, 0f, 1f, 1f, 1f}, 2));
        db.addDataset(new Dataset(new float[]{Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), 0f, 0f, 1f, 1f, 0f}, 1));
        db.addDataset(new Dataset(new float[]{Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), 0f, 1f, 1f, 1f, 1f}, 2));
        db.addDataset(new Dataset(new float[]{Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), 1f, 1f, 1f, 0f, 0f}, 1));
        db.addDataset(new Dataset(new float[]{Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), 0f, 0f, 0f, 0f, 1f}, 1));
        db.addDataset(new Dataset(new float[]{Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), 0f, 0f, 1f, 1f, 1f}, 2));
        db.addDataset(new Dataset(new float[]{Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), 0f, 0f, 1f, 1f, 1f}, 3));
        db.addDataset(new Dataset(new float[]{Level.EASY.getWeight(), Level.EASY.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), 1f, 0f, 0f, 0f, 0f}, 1));
        db.addDataset(new Dataset(new float[]{Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), 0f, 0f, 1f, 1f, 1f}, 2));
        db.addDataset(new Dataset(new float[]{Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), 0f, 1f, 1f, 1f, 1f}, 2));
        db.addDataset(new Dataset(new float[]{Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), Level.EASY.getWeight(), 0f, 1f, 0f, 0f, 0f}, 1));
        db.addDataset(new Dataset(new float[]{Level.HARD.getWeight(), Level.HARD.getWeight(), Level.HARD.getWeight(), Level.HARD.getWeight(), Level.HARD.getWeight(), 0f, 0f, 1f, 1f, 1f}, 3));
        db.addDataset(new Dataset(new float[]{Level.HARD.getWeight(), Level.HARD.getWeight(), Level.HARD.getWeight(), Level.HARD.getWeight(), Level.HARD.getWeight(), 1f, 0f, 1f, 0f, 0f}, 2));
        db.addDataset(new Dataset(new float[]{Level.HARD.getWeight(), Level.HARD.getWeight(), Level.HARD.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), 1f, 0f, 0f, 0f, 0f}, 2));
        db.addDataset(new Dataset(new float[]{Level.HARD.getWeight(), Level.HARD.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), 0f, 0f, 0f, 0f, 0f}, 1));
        db.addDataset(new Dataset(new float[]{Level.HARD.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), Level.MEDIUM.getWeight(), 0f, 0f, 1f, 1f, 0f}, 2));

        return db;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jLabel_LR = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jLabel_Tries = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel_response = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setText("Train");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(filler2);

        jLabel_LR.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_LR.setForeground(new java.awt.Color(51, 102, 255));
        jLabel_LR.setText("jLabel4");
        jToolBar1.add(jLabel_LR);
        jToolBar1.add(filler1);

        jLabel_Tries.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Tries.setForeground(new java.awt.Color(51, 102, 255));
        jLabel_Tries.setText("jLabel4");
        jToolBar1.add(jLabel_Tries);
        jToolBar1.add(filler3);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Test Input");

        jButton2.setText("Test");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Response:");

        jLabel_response.setText("response");

        jButton3.setText("Wrong");

        jButton4.setText("Correct");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addComponent(jLabel_response, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel_response))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private float[] translateInput(String input) throws Exception {
        if (!input.matches("((E|M|H)[10],){4}(E|M|H)[10]")) {
            throw new Exception("DEFORME");
        }
        float[] finput = new float[10];
        String[] split = input.split(",");
        int index = 0;
        for (String singleValue : split) {
            char level = singleValue.charAt(0);
            finput[index] = switch (level) {
                case 'E' ->
                    Level.EASY.getWeight();
                case 'M' ->
                    Level.MEDIUM.getWeight();
                case 'H' ->
                    Level.HARD.getWeight();
                default ->
                    throw new Exception("DEFORME");
            };
            finput[5 + index] = singleValue.charAt(1) == '0' ? 0f : 1f;
            index++;
        }
        for (float f : finput) {
            System.out.print(f + ", ");
        }
        System.out.println("");
        return finput;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("Training.. ");
        Trainer.getInstance().init(10);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Trainer.getInstance().getPerceptron().setLearningRate(0.25f);
                jLabel_LR.setText("" + Trainer.getInstance().getPerceptron().getLearningRate());
                for (int j = 0; j < 40000; j++) {
                    jLabel_Tries.setText("" + j);
                    if (j % 5000 == 0 && j != 0) {
                        System.out.println("\t\t\t\tDECREASEEEE");
                        Trainer.getInstance().getPerceptron().decreaseLearningRate(0.04f);
                        jLabel_LR.setText("" + Trainer.getInstance().getPerceptron().getLearningRate());

//                        JOptionPane.showMessageDialog(null, "LR = "+Trainer.getInstance().getPerceptron().getLearningRate());
                    }
                    try {
                        Trainer.getInstance().clearTrainingData();
                        DataBucket db = generateDataset();

                        Trainer.getInstance().addTrainingData(db);

                        Trainer.getInstance().train();
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DivisoreFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Trained");
                float w[] = Trainer.getInstance().getPerceptron().getWeights();
                for (float f : w) {
                    System.out.println("W = " + f);
                }
            }
        });

        t.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String text = this.jTextField1.getText();
        try {
            float[] translateInput = this.translateInput(text);
            this.perceptron.setInputs(translateInput);
            int value = this.perceptron.activate();
            this.jLabel_response.setText("" + value);
//        try {
//            int value = Trainer.getInstance().getPerceptron().test(new float[]{Level.EASY.getWeight(),Level.EASY.getWeight(),Level.EASY.getWeight(),Level.EASY.getWeight(),Level.EASY.getWeight(),0f,0f,0f,0f,0f});
//            this.jLabel_response.setText(""+value);
//            
//        } catch (Exception ex) {
//            Logger.getLogger(NextLevelTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        } catch (Exception ex) {
            Logger.getLogger(NextLevelTrainer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NextLevelTrainer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NextLevelTrainer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NextLevelTrainer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NextLevelTrainer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NextLevelTrainer2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_LR;
    private javax.swing.JLabel jLabel_Tries;
    private javax.swing.JLabel jLabel_response;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void bucketDone(DataBucket bucket, boolean descent) {

        float errorDeviationStandard = bucket.getErrorDeviationStandard();
        System.out.println("errore: " + errorDeviationStandard);
        for (Dataset dataset : bucket.getDatasets()) {
//            System.out.println("Dataset: "+dataset);
//            System.out.println("Given Answer:  "+dataset.getGivenAnswer());
//            System.out.println("Given Desired: "+dataset.getDesiredAnswer());
//            System.out.println("Error: "+dataset.getError());
//            System.out.println("==========");
        }

    }
}
