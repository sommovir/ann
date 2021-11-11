/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.test.divisorepiano;

import it.cnr.istc.UtilsANN;
import it.cnr.istc.ann.Trainer;
import it.cnr.istc.ann.events.TrainingEventManager;
import it.cnr.istc.ann.events.TrainingListener;
import it.cnr.istc.datasets.DataBucket;
import it.cnr.istc.datasets.Dataset;
import it.cnr.istc.icv.engine.MixedDataPanel;
import it.cnr.istc.icv.engine.MyJLayer;
import it.cnr.istc.icv.engine.MyLayer;
import it.cnr.istc.icv.engine.ZoomLabeledLayer;
import it.cnr.istc.icv.engine.listeners.CoordinateListener;
import it.cnr.istc.icv.engine.listeners.PopupMenuTriggerListener;
import it.cnr.istc.icv.exceptions.TypeDataMismatchException;
import it.cnr.istc.icv.logic.ICVAnnotation;
import it.cnr.istc.icv.test.LinearDataSupporter;
import it.cnr.istc.icv.test.TimeValueSupporterClass;
import it.cnr.istc.test.QuadranteTester;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class DivisoreFrame2 extends javax.swing.JFrame implements TrainingListener, CoordinateListener, PopupMenuTriggerListener {

    final static MixedDataPanel panel = new MixedDataPanel();
    private int step = 5;
    int wait = 40;
    int bucketCount = 50;
    int megaStep = 5;
    int totFails = 0;
    float megaMedia = 0;

    LinearDataSupporter s = new LinearDataSupporter("Media Errori");
    LinearDataSupporter s2 = new LinearDataSupporter("Numero Fails");

    float min = 200;

    int numberOfBuckets = 2000;
    int numberOfMacroIteration = 3;
    int numberOfChunks = 10;
    float base_lr = 0.25f;
    int whenToDecrease = 350;
    float amountToDecrease = 0.045f;
    DataBucket db = null;

    /**
     * Creates new form DivisoreFrame
     */
    public DivisoreFrame2() {
        initComponents();

        if (Beans.isDesignTime()) {
            return;
        }

        this.linePanel1.setStartLinePoint(new PointTest(0, 200, rootPaneCheckingEnabled));
        this.linePanel1.setEndLinePoint(new PointTest(700, 700, rootPaneCheckingEnabled));
        TrainingEventManager.getInstance().addTrainingListener(this);

        panel.addCoordinateListener(this);
        panel.addPopupMenuTriggerListener(this);

        panel.setStartRange(0);
        panel.setEndRange(10000);

        panel.setShowDate(false);
        panel.setBackground(Color.WHITE);
        panel.setZoomEnable(true);

//        s.setOrder(1);
        s.setDiscret(false);
        s.setMaxValueToShow(10);
        s.setMinValueToShow(0);
        s.setMaxThresholdPaintable(true);
        s.setMaximumThreshold(50);
        s.setMinThresholdPaintable(true);
        s.setMinimumThreshold(min);

//        s.setOrder(1);
        s2.setDiscret(false);
        s2.setMaxValueToShow(10);
        s2.setMinValueToShow(0);
        s2.setMaxThresholdPaintable(true);
        s2.setMaximumThreshold(3);
        s2.setMinThresholdPaintable(true);
        s2.setMinimumThreshold(0);

        panel.addDataBar(s);
        panel.addDataBar(s2);
        MyLayer<JPanel> layerUI = new ZoomLabeledLayer(panel);
        JPanel containerP = new JPanel();
        containerP.setLayout(new GridLayout(0, 1));
        containerP.add(panel);

        MyJLayer<JPanel> jlayer = new MyJLayer<JPanel>(panel, layerUI);
        containerP.add(jlayer);
        this.jScrollPane1.setViewportView(containerP);
        Trainer.getInstance().init(3);

        List<DataBucket> buckets = new ArrayList<>();

        //creating dataset: 
        for (int i = 0; i < numberOfBuckets; i++) {
            db = new DataBucket(numberOfChunks);
            for (int j = 0; j < numberOfChunks; j++) {
                int x = UtilsANN.generateRandomInRange(0, 700);
                int y = UtilsANN.generateRandomInRange(0, 700);
                int lineY = (int) ((5f / 7f) * (float) x + 200);
                db.addDataset(new Dataset(new float[]{x, y, 1}, y > lineY ? 1 : -1));
            }
            buckets.add(db);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        linePanel1 = new LinePanel();
        jToolBar1 = new JToolBar();
        jButton1 = new JButton();
        jButton3 = new JButton();
        jButton2 = new JButton();
        jScrollPane1 = new JScrollPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel_LR = new JLabel();
        jLabel2 = new JLabel();
        jLabel_Tries = new JLabel();
        jLabel3 = new JLabel();
        jLabel_Tries_w0 = new JLabel();
        jLabel4 = new JLabel();
        jLabel_Tries_w1 = new JLabel();
        jLabel5 = new JLabel();
        jLabel_Tries_w2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        linePanel1.setPreferredSize(new Dimension(800, 800));

        GroupLayout linePanel1Layout = new GroupLayout(linePanel1);
        linePanel1.setLayout(linePanel1Layout);
        linePanel1Layout.setHorizontalGroup(linePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        linePanel1Layout.setVerticalGroup(linePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setText("Train");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(SwingConstants.BOTTOM);
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton3.setText("Train LR");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(SwingConstants.BOTTOM);
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton2.setText("Test Function");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(SwingConstants.BOTTOM);
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jPanel1.setBackground(new Color(204, 255, 204));

        jLabel1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Learning Rate:");

        jLabel_LR.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel_LR.setForeground(new Color(255, 0, 0));
        jLabel_LR.setText("0.15");

        jLabel2.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tries:");

        jLabel_Tries.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Tries.setForeground(new Color(255, 0, 0));
        jLabel_Tries.setText("0.15");

        jLabel3.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("w0:");

        jLabel_Tries_w0.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Tries_w0.setForeground(new Color(255, 0, 0));
        jLabel_Tries_w0.setText("0.15");

        jLabel4.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("w1:");

        jLabel_Tries_w1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Tries_w1.setForeground(new Color(255, 0, 0));
        jLabel_Tries_w1.setText("0.15");

        jLabel5.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("w2:");

        jLabel_Tries_w2.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Tries_w2.setForeground(new Color(255, 0, 0));
        jLabel_Tries_w2.setText("0.15");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_LR)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Tries)
                .addGap(66, 66, 66)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Tries_w0)
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Tries_w1)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Tries_w2)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel_Tries_w2))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel_Tries_w1))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel_Tries_w0))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel_Tries))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel_LR)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(linePanel1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(linePanel1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

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
                        linePanel1.clearPoints();
                        DataBucket db = new DataBucket(2);
                        for (int i = 0; i < 600; i++) {
                            int x = UtilsANN.generateRandomInRange(0, 700);
                            int y = UtilsANN.generateRandomInRange(0, 700);
                            int lineY = (int) ((5f / 7f) * (float) x + 200);
                            db.addDataset(new Dataset(new float[]{x, y, 1}, y > lineY ? 1 : -1));
//                            db.addDataset(new Dataset(new float[]{x, y, 1}, y - ((5/7) *x) -200 > 0 ? 1 : -1));
//                            db.addDataset(new Dataset(new float[]{x, y}, x-y > 0 ? 1 : -1));
                        }
//                        System.out.println("db dataset size: > " + db.getDatasets().size());
                        Trainer.getInstance().addTrainingData(db);

                        Trainer.getInstance().train();
                        Thread.sleep(3);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DivisoreFrame2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

        t.start();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (int i = 0; i < 1; i++) {
            int x = UtilsANN.generateRandomInRange(0, 700);
            int y = UtilsANN.generateRandomInRange(0, 700);
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            int lineY = (int) ((5f / 7f) * (float) x + 200);
            System.out.println("lineY = " + lineY);
            this.linePanel1.drawPoint(x, y, y > lineY);
            this.linePanel1.invalidate();
            this.linePanel1.repaint();
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //end creating dataset;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 40000; j++) {
                    try {
                        jLabel_Tries.setText("" + j);
                        if (j % 5000 == 0 && j != 0) {
                            System.out.println("\t\t\t\tDECREASEEEE");
                            Trainer.getInstance().getPerceptron().decreaseLearningRate(0.04f);
                            jLabel_LR.setText("" + Trainer.getInstance().getPerceptron().getLearningRate());

//                        JOptionPane.showMessageDialog(null, "LR = "+Trainer.getInstance().getPerceptron().getLearningRate());
                        }
                        Trainer.getInstance().getPerceptron().setLearningRate(base_lr);

                        Trainer.getInstance().getPerceptronDescent().train(db);
                        TrainingEventManager.getInstance().bucketDone(db, true);
                        Thread.sleep(3);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DivisoreFrame2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

        t.start();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(DivisoreFrame2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DivisoreFrame2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DivisoreFrame2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DivisoreFrame2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DivisoreFrame2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel_LR;
    private JLabel jLabel_Tries;
    private JLabel jLabel_Tries_w0;
    private JLabel jLabel_Tries_w1;
    private JLabel jLabel_Tries_w2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JToolBar jToolBar1;
    private LinePanel linePanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void bucketDone(DataBucket bucket, boolean descent) {
//        if (!descent) {
//            return;
//        }
//        bucketCount++;
//        System.out.println("bucket = "+bucketCount);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                synchronized (this) {
                    
                    if (wait > 0) {
                        wait--;
                        return;
                    } else {
                        wait = 40;
                        bucketCount--;
//                        System.out.println("buckkake = " + bucketCount);
                    }

                    float[] weights = Trainer.getInstance().getPerceptron().getWeights();
                    jLabel_Tries_w0.setText("" + weights[0]);
                    jLabel_Tries_w1.setText("" + weights[1]);
                    jLabel_Tries_w2.setText("" + weights[2]);
                    
                    for (Dataset dataset : bucket.getDatasets()) {
                        float[] inputs = dataset.getInputs();
                        int x = (int) inputs[0];
                        int y = (int) inputs[1];
                        linePanel1.drawPoint(x, y, dataset.getGivenAnswer() == 1);
//                        linePanel1.drawPoint(x, y, Trainer.getInstance().getPerceptronDescent().activate(inputs) > 0.99 && Trainer.getInstance().getPerceptronDescent().activate(inputs) < 1.01);

                    }
                    linePanel1.revalidate();
                    linePanel1.repaint();

                    int fails = 0;
                    for (Dataset dataset : bucket.getDatasets()) {
                        if (dataset.getError() != 0) {
                            fails++;
                        }
                    }
                    totFails += fails;
//                    System.out.println("buckk =" + bucketCount);
                    try {

                        float mediaErrori = (float) totFails / 20f;
                        System.out.println("media errori = " + mediaErrori);
                        megaMedia += mediaErrori;
                        if (bucketCount == 0) {
                            System.out.println("ECCOMI");
                            float value = megaMedia / 50;
                            if (value < min) {
                                min = value;
                            }
                            s.setMinimumThreshold(min);
                            TimeValueSupporterClass ds1 = new TimeValueSupporterClass(value, "SQM", new Date(megaStep));
                            System.out.println(" ---------------------->>>>> MEDIA ERRORI: " + mediaErrori);
                            panel.addLinearData("Media Errori", ds1, false);
                            totFails = 0;
                            bucketCount = 50;
                            megaStep += 200;
                            megaMedia = 0f;
                        }

                        TimeValueSupporterClass ds2 = new TimeValueSupporterClass(fails, "#", new Date(step));
                        panel.addLinearData("Numero Fails", ds2, false);

                        step += 10;

                        panel.invalidate();
                        panel.repaint();

                    } catch (TypeDataMismatchException ex) {
                        Logger.getLogger(QuadranteTester.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

    }

    @Override
    public void currentDate(Date date) {
    }

    @Override
    public void currentValue(Object o) {
    }

    @Override
    public void showTooltip(String string, int i, int i1) {
    }

    @Override
    public void forceFromTo(boolean bln) {
    }

    @Override
    public void rightClickTriggered(String string, Date date, int i, int i1) {
    }

    @Override
    public void rightClickAreaTriggered(String string, ICVAnnotation icva, Date date, int i, int i1) {
    }
}
