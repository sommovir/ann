/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.istc.test;

import it.cnr.istc.ann.Trainer;
import it.cnr.istc.datasets.Dataset;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class TrainerTester {

    public static void main(String[] args) {
        System.out.println("ANN Tester");
        //1 = red
        //-1 = other

        Dataset data1 = new Dataset(new float[]{240, 4, 1}, 1);
        Dataset data2 = new Dataset(new float[]{130, 89, 31}, -1);
        Dataset data3 = new Dataset(new float[]{68, 196, 58}, -1);
        Dataset data4 = new Dataset(new float[]{31, 36, 31}, -1);
        Dataset data5 = new Dataset(new float[]{137, 105, 219}, -1);
        Dataset data6 = new Dataset(new float[]{156, 30, 8}, 1);
        Dataset data7 = new Dataset(new float[]{199, 4, 43}, 1);
        Dataset data8 = new Dataset(new float[]{207, 204, 124}, -1);
        Dataset data9 = new Dataset(new float[]{38, 46, 163}, -1);
        Dataset data10 = new Dataset(new float[]{18, 186, 141}, -1);
        Dataset data11 = new Dataset(new float[]{245, 71, 37}, 1);
        Dataset data12 = new Dataset(new float[]{247, 161, 143}, -1);
        Dataset data13 = new Dataset(new float[]{220, 98, 224}, -1);
        Dataset data14 = new Dataset(new float[]{38, 25, 38}, -1);
        Dataset data15 = new Dataset(new float[]{87, 245, 30}, -1);
        Dataset data16 = new Dataset(new float[]{26, 0, 51}, -1);
        Dataset data17 = new Dataset(new float[]{0, 0, 26}, -1);
        Dataset data18 = new Dataset(new float[]{0, 0, 179}, -1);
        Dataset data19 = new Dataset(new float[]{225, 230, 230}, -1);
        Dataset data20 = new Dataset(new float[]{5, 20, 5}, -1);
        Dataset data21 = new Dataset(new float[]{76, 46, 0}, -1);
        Dataset data22 = new Dataset(new float[]{230, 230, 0}, -1);
        Dataset data23 = new Dataset(new float[]{230, 230, 0}, -1);
        Dataset data24 = new Dataset(new float[]{153, 0, 0}, 1);

        Trainer trainer = new Trainer(3);
        trainer.addTrainingData(data1);
        trainer.addTrainingData(data2);
        trainer.addTrainingData(data3);
        trainer.addTrainingData(data4);
        trainer.addTrainingData(data5);
        trainer.addTrainingData(data6);
        trainer.addTrainingData(data7);
        trainer.addTrainingData(data8);
        trainer.addTrainingData(data9);
        trainer.addTrainingData(data10);
        trainer.addTrainingData(data11);
        trainer.addTrainingData(data12);
        trainer.addTrainingData(data13);
        trainer.addTrainingData(data14);
        trainer.addTrainingData(data15);
        trainer.addTrainingData(data16);
        trainer.addTrainingData(data17);
        trainer.addTrainingData(data18);
        trainer.addTrainingData(data19);
        trainer.addTrainingData(data20);
        trainer.addTrainingData(data21);
        trainer.addTrainingData(data22);
        trainer.addTrainingData(data23);
        trainer.addTrainingData(data24);

        trainer.train();

        ColorPerceptronTester frame = new ColorPerceptronTester();
        frame.setPerceptron(trainer.getPerceptron());
        frame.setVisible(true);

    }

}
