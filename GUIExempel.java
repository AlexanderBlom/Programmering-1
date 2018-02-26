import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class GUIExempel {
    private JPanel rotPanel;
    private JTextArea textArea;
    private JButton sparaButton;
    private JButton nyFilButton;
    private JButton öppnaButton;
    private JFileChooser fileChooser;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIExempel");
        frame.setContentPane(new GUIExempel().rotPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 1000);
        frame.setResizable(false);
    }


    public GUIExempel() {
        sparaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton sparaButton = new JButton();
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new java.io.File("c:/Users/blal16/Desktop/"));
                fc.setDialogTitle("Fil hanterare");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

                if (fc.showSaveDialog(sparaButton) == JFileChooser.APPROVE_OPTION) {
                    try {
                        PrintWriter utström = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                                "c:\\Users\\blal16\\Desktop\\" + fc.getSelectedFile().getName()))));
                            utström.println(textArea.getText());
                            utström.close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        nyFilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        öppnaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton öppnaButton = new JButton();
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new java.io.File("c:/Users/blal16/Desktop/"));
                fc.setDialogTitle("Fil hanterare");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fc.showOpenDialog(öppnaButton) == JFileChooser.APPROVE_OPTION) {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("c:\\Users\\blal16\\Desktop\\" + fc.getSelectedFile().getName()));
                        String line;
                        textArea.setText("");
                        try{
                            while((line = br.readLine()) != null){
                                textArea.append(line + "\n");
                            }

                    } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}
