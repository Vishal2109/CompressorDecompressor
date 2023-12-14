import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MyFrame implements ActionListener {
    JFrame frame;
    JButton compressButton, deCompressButton;
    JToolBar toolBar;
    Compress compress = new Compress();
    Decompress decompress = new Decompress();


    MyFrame(){
//        create frame
        frame = new JFrame("CompressorDecompressor");
        frame.setSize(600, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        create toolbar
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        frame.add(toolBar);

//        create button
        compressButton = new JButton("Select file to Compress");
        compressButton.setFocusable(false);
        compressButton.addActionListener(this::actionPerformed);

        deCompressButton = new JButton("Select file to Decompress");
        deCompressButton.setFocusable(false);
        deCompressButton.addActionListener(this::actionPerformed);

//        add buttons to toolbar
        toolBar.addSeparator(new Dimension(100, 100));
        toolBar.add(compressButton);
        toolBar.addSeparator(new Dimension(50, 100));
        toolBar.add(deCompressButton);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        if event is from source button
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
//                get files path
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
//                    pass it compress
                    compress.method(file);
                }catch(Exception ee){
//                    shows error
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }

//        if event is from decompress button
        if(e.getSource()==deCompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
//                gets file path
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
//                    pass file to decompress method
                    decompress.method(file);
                }catch(Exception ee){
//                    shows error
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
