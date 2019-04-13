package gui.file_selector;

import gui.main_frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileSelector extends JFrame {

    private Container container = getContentPane();

    private JLabel prompt = new JLabel("Please select the database file");

    private JButton button = new JButton("Browse");

    private JTextField textField = new JTextField(25);

    private JFileChooser fileChooser;

    public FileSelector(String title){
        super(title);

        setLayout(new FlowLayout());

        button.addActionListener(e -> {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.showOpenDialog(this);
            try{
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                if(textField.getText().endsWith(".db")){
                    dispose();
                    openMainFrame(textField.getText());
                } else {
                    JOptionPane.showMessageDialog(container, "Please Choose A Database");
                }
            } catch (NullPointerException ex){
                JOptionPane.showInternalMessageDialog(container, "File Not Selected");
            }
        });

        container.add(prompt);
        container.add(textField);
        container.add(button);

    }

    private void openMainFrame(String pathToDatabase){
        JFrame frame = new MainFrame("House Trends Application", pathToDatabase);
        frame.setSize(new Dimension(1000, 1000));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public JFileChooser getFileChooser() {
        return this.fileChooser;
    }

}
