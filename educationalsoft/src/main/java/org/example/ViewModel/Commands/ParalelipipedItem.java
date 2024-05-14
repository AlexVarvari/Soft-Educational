package org.example.ViewModel.Commands;

import org.example.ViewModel.CanvasViewModel;

import javax.swing.*;
import java.awt.*;

public class ParalelipipedItem implements ICommand{
    private CanvasViewModel canvasViewModel;
    public ParalelipipedItem(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }
    @Override
    public void execute() {
        this.canvasViewModel.setRadieraClicked(false);
        this.canvasViewModel.setCreionClicked(false);
        this.canvasViewModel.setCubClicked(false);
        this.canvasViewModel.setParalelipipedClicked(true);
        this.canvasViewModel.setPrismClicked(false);
        JTextField lengthField = new JTextField();
        JTextField widthField = new JTextField();
        JTextField heightField = new JTextField();

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Length:"));
        inputPanel.add(lengthField);
        inputPanel.add(new JLabel("Width:"));
        inputPanel.add(widthField);
        inputPanel.add(new JLabel("Height:"));
        inputPanel.add(heightField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel,
                "Enter Paralelipiped Dimensions", JOptionPane.OK_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                double paralelipipedLength = Double.parseDouble(lengthField.getText());
                double paralelipipedWidth = Double.parseDouble(widthField.getText());
                double paralelipipedHeight = Double.parseDouble(heightField.getText());

                // Calculate the area of the prism (assuming a rectangular base)
                double ariaLaterala = 2 * (paralelipipedLength * paralelipipedHeight + paralelipipedWidth * paralelipipedHeight);
                double ariaTotala = ariaLaterala + 2*(paralelipipedLength * paralelipipedWidth);
                double volum = paralelipipedLength * paralelipipedWidth * paralelipipedHeight;

                // Display the calculated area
                JOptionPane.showMessageDialog(null, "Aria laterala a paralelipipedului este: " + ariaLaterala +"\nAria totala a paralelipipedului este: " + ariaTotala + "\nVolumul paralelipipedului este: " +volum,
                        "Aria", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
