/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remastery;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author RobinaAnne
 */
public class remaster extends JFrame{
    public static void main(String [] args){
        mainPanel mp = new mainPanel();
        
        JFrame jf = new JFrame();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        jf.setVisible(true);
        jf.setSize(800,600);
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(mp);
    }
}
