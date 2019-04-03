/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.test.divisorepiano;

import it.cnr.istc.UtilsANN;
import it.cnr.istc.datasets.Dataset;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class LinePanel extends javax.swing.JPanel {

    public List<PointTest> points = new ArrayList<>();

    /**
     * Creates new form LinePanel
     */
    public LinePanel() {
        initComponents();
//        for (int i = 0; i < 200; i++) {
//            int x = UtilsANN.generateRandomInRange(0, 800);
//            int y = UtilsANN.generateRandomInRange(0, 800);
//            
//            drawPoint(x, y, x-y>0 ? true : false);
//        }
        

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawLine(0, 0, this.getWidth(), this.getHeight());

        System.out.println("POINT SIZE: "+points.size());
        for (PointTest point : points) {
            if (point.isOk()) {
                g2d.setPaint(new Color(0, 255, 0));
            }else{
                g2d.setPaint(new Color(255, 0, 0));
            }
            g2d.fillOval(point.getX() - 4, point.getY() - 4, 8, 8);
        }
    }

    public void drawPoint(int x, int y, boolean ok) {
        this.points.add(new PointTest(x, y, ok));

    }

    public void clearPoints() {
        this.points.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new Color(255, 255, 255));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
