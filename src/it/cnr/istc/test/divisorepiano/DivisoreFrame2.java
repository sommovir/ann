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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
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
    int wait = 20;

    /**
     * Creates new form DivisoreFrame
     */
    public DivisoreFrame2() {
        initComponents();

        this.linePanel1.setStartLinePoint(new PointTest(0, 200, rootPaneCheckingEnabled));
        this.linePanel1.setEndLinePoint(new PointTest(700, 700, rootPaneCheckingEnabled));
        TrainingEventManager.getInstance().addTrainingListener(this);

        panel.addCoordinateListener(this);
        panel.addPopupMenuTriggerListener(this);

        panel.setStartRange(0);
        panel.setEndRange(5500);

        panel.setShowDate(false);
        panel.setBackground(Color.WHITE);
        panel.setZoomEnable(true);

        LinearDataSupporter s = new LinearDataSupporter("Deviazione Standard");
//        s.setOrder(1);
        s.setDiscret(false);
        s.setMaxValueToShow(10);
        s.setMinValueToShow(0);
        s.setMaxThresholdPaintable(true);
        s.setMaximumThreshold(50);
        s.setMinThresholdPaintable(true);
        s.setMinimumThreshold(15);

        LinearDataSupporter s2 = new LinearDataSupporter("Numero Fails");
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
        jButton2 = new JButton();
        jScrollPane1 = new JScrollPane();

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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(linePanel1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(linePanel1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 20000; j++) {
                    try {
                        Trainer.getInstance().clearTrainingData();
                        linePanel1.clearPoints();
                        DataBucket db = new DataBucket(2);
                        for (int i = 0; i < 600; i++) {
                            int x = UtilsANN.generateRandomInRange(0, 700);
                            int y = UtilsANN.generateRandomInRange(0, 700);
                            int lineY = (int)((5f / 7f) * (float)x + 200);
                            db.addDataset(new Dataset(new float[]{x, y, 1}, y > lineY ? 1 : -1));
//                            db.addDataset(new Dataset(new float[]{x, y, 1}, y - ((5/7) *x) -200 > 0 ? 1 : -1));
//                            db.addDataset(new Dataset(new float[]{x, y}, x-y > 0 ? 1 : -1));
                        }
//                        System.out.println("db dataset size: > " + db.getDatasets().size());
                        Trainer.getInstance().addTrainingData(db);

                        Trainer.getInstance().train();
                        Thread.sleep(10);
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
            System.out.println("x = "+x);
            System.out.println("y = "+y);
            int lineY = (int)((5f / 7f) * (float)x + 200);
            System.out.println("lineY = "+lineY);
            this.linePanel1.drawPoint(x, y, y>lineY );
            this.linePanel1.invalidate();
            this.linePanel1.repaint();
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
    private JScrollPane jScrollPane1;
    private JToolBar jToolBar1;
    private LinePanel linePanel1;
    // End of variables declaration//GEN-END:variables

    @Override
        public void bucketDone(DataBucket bucket) {
        if (wait > 0) {
            wait--;
            return;
        } else {
            wait = 20;
        }

        for (Dataset dataset : bucket.getDatasets()) {
            float[] inputs = dataset.getInputs();
            int x = (int) inputs[0];
            int y = (int) inputs[1];

            this.linePanel1.drawPoint(x, y, dataset.getGivenAnswer() == 1);

        }
        this.linePanel1.revalidate();
        this.linePanel1.repaint();

        int fails = 0;
        for (Dataset dataset : bucket.getDatasets()) {
            if (dataset.getError() != 0) {
                fails++;
            }
        }

        System.out.println(" ---------------------->>>>> ERRORE: " + bucket.getErrorDeviationStandard());
        try {
            TimeValueSupporterClass ds1 = new TimeValueSupporterClass(bucket.getErrorDeviationStandard(), "SQM", new Date(this.step));
            panel.addLinearData("Deviazione Standard", ds1, false);

            TimeValueSupporterClass ds2 = new TimeValueSupporterClass(fails, "#", new Date(this.step));
            panel.addLinearData("Numero Fails", ds2, false);

            step += 5;

            panel.invalidate();
            panel.repaint();
        

} catch (TypeDataMismatchException ex) {
            Logger.getLogger(QuadranteTester.class
.getName()).log(Level.SEVERE, null, ex);
        }

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
