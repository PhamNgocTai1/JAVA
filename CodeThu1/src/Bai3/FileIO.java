package Bai3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class FileIO extends Frame implements ActionListener{
    private Label lbl;
    private JTextArea txt;
    private Button btnOpen, btnSave, btnExit;
    private JScrollPane scroll;
    public FileIO() {
        this.lbl = new Label("Noi dung file");
        lbl.setForeground(Color.BLUE);
        lbl.setBounds(120, 30, 100, 50);    
        this.txt = new JTextArea();
        scroll = new JScrollPane (txt);
        scroll.setBounds(10, 80, 280, 270);
        this.btnOpen = new Button("Open file");
        btnOpen.setBounds(50, 360, 60, 20);
        this.btnSave = new Button("Save file");
        btnSave.setBounds(120, 360, 60, 20);
        this.btnExit = new Button("Exit");
        btnExit.setBounds(190, 360, 50, 20);
        btnOpen.addActionListener(this);
        btnSave.addActionListener(this);
        btnExit.addActionListener(this);
        add(lbl);
        add(scroll);
        add(btnOpen);
        add(btnSave);
        add(btnExit);
        setSize(300,400);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnExit){
            System.exit(0);
        }
        else if(e.getSource()==btnOpen){
            JFileChooser openFile = new JFileChooser();
            openFile.showOpenDialog(null);
            File f = openFile.getSelectedFile();
            String filename = f.getAbsolutePath();
				
            try {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);

                txt.read(br, null);
                br.close();
                txt.requestFocus();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        else if(e.getSource()==btnSave){
            JFileChooser fc = new JFileChooser();				
            fc.showSaveDialog(null);
            File f = fc.getSelectedFile();

            try 
            {
                FileWriter fw = new FileWriter(f);
                String text = txt.getText();
                fw.write(text);
                fw.close();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        new FileIO();
    }
}
