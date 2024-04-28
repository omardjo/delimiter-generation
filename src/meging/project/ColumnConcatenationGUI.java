import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColumnConcatenationGUI extends JFrame {

    private JTextArea column1TextArea;
    private JTextArea column2TextArea;
    private JButton mergeButton;
    private JTextArea outputTextArea;

    public ColumnConcatenationGUI() {
        setTitle("Column Concatenation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        column1TextArea = new JTextArea();
        column2TextArea = new JTextArea();
        mergeButton = new JButton("Merge");
        outputTextArea = new JTextArea();

        mergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mergeColumns();
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(1, 2));
        inputPanel.add(new JScrollPane(column1TextArea));
        inputPanel.add(new JScrollPane(column2TextArea));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(mergeButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(new JScrollPane(outputTextArea), BorderLayout.EAST);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mergeColumns() {
        String column1 = column1TextArea.getText();
        String column2 = column2TextArea.getText();

        String[] column1Values = column1.split("\n");
        String[] column2Values = column2.split("\n");

        StringBuilder outputBuilder = new StringBuilder();

        int rowCount = Math.min(column1Values.length, column2Values.length);

        for (int i = 0; i < rowCount; i++) {
            outputBuilder.append(column1Values[i]).append(" = ").append(column2Values[i]).append("\n");
        }

        String output = outputBuilder.toString();
        outputTextArea.setText(output);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ColumnConcatenationGUI();
            }
        });
    }
}
