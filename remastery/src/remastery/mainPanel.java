/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remastery;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author RobinaAnne
 */
public class mainPanel extends JPanel implements ActionListener{
    JButton btnCon = new JButton("Import");
    JButton btnRem = new JButton("Remaster");
    File selectedFile;
    File file;
    int frames = 0;
    public mainPanel(){
        display();
    }
    public void display(){
        setVisible(true);
        setLayout(null);
        setSize(800,600);
        setBackground(Color.GRAY);
        setBounds(0,0, 800,600);
        
        
        btnCon.setBounds(20,20, 100, 25);
        btnCon.addActionListener(this);
        add(btnCon);
        
        btnRem.setBounds(60,60,100,25);
        btnRem.addActionListener(this);
        add(btnRem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnCon){        
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Media Files", "mp4", "flv", "mkv", "avi", "mov");
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION){
                selectedFile = fileChooser.getSelectedFile();
                file  = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\MATLAB\\" + selectedFile.getName());
                if(!file.exists()){
                    if(file.mkdirs()){
                       System.out.println("Directory is created!");
                       createScript cs = new createScript();
                       cs.script(selectedFile.getPath(), file.getPath(), selectedFile.getName());
                       frames = new File(file.getPath()).listFiles().length -2;
                    }
                    else
                       System.out.println("Failed");
                }
            }
        }
        else if(e.getSource()==btnRem){
            
            for(int i=1; i<=frames; i++){
                System.out.println(i);
                frames = new File(file.getPath()).listFiles().length -3;
                createScript cs = new createScript();
                cs.conv(file.getPath(), file.getPath() + "\\" + i +".jpg", file.getPath() + "\\col.jpg");
            }
        }
    }
}
