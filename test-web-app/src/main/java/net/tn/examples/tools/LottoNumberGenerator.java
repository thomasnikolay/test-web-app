package net.tn.tools;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tnikolay
 */
public class LottoNumberGenerator {

    public static void main(String[] args) {
        double allCombinations = 139838160;
        double counter = 1;
        try {
            File file = new File("c:\\zahlen.txt");
            PrintWriter pw = new PrintWriter(file);

            pw.println("Alle möglichen Lottozahlen");

            for (int i = 1; i <= 49; i++) {
                for (int j = 1; j <= 49; j++) {
                    for (int k = 1; k <= 49; k++) {
                        for (int l = 1; l <= 49; l++) {
                            for (int m = 1; m <= 49; m++) {
                                for (int n = 1; n <= 49; n++) {
                                    for (int o = 1; o <= 10; o++) {
                                        if (i != 0
                                                && i < j
                                                && j < k
                                                && k < l
                                                && l < m
                                                && m < n
                                                && i != j
                                                && i != k
                                                && i != l
                                                && i != m
                                                && i != n
                                                && j != k
                                                && j != l
                                                && j != m
                                                && j != n
                                                && k != l
                                                && k != m
                                                && k != n
                                                && l != m
                                                && l != n
                                                && m != n) {
                                            pw.println(i + " " + j + " " + k + " " + l + " " + m + " " + n + "  " + o);
                                            counter++;
                                        }
                                    }
                                }
                            }
                            NumberFormat nf = NumberFormat.getPercentInstance();
                            double percent = (counter / allCombinations);
                            System.out.println(counter + " of " + allCombinations + " created (" + nf.format(percent) + ")");
                        }
                    }
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
