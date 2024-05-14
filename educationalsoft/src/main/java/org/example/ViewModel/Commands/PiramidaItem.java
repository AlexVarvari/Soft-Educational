package org.example.ViewModel.Commands;

import org.example.ViewModel.CanvasViewModel;

import javax.swing.*;
import java.awt.*;

public class PiramidaItem implements ICommand{
    private CanvasViewModel canvasViewModel;
    public PiramidaItem(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }
    @Override
    public void execute() {
        this.canvasViewModel.setRadieraClicked(false);
        this.canvasViewModel.setCreionClicked(false);
        this.canvasViewModel.setCubClicked(false);
        this.canvasViewModel.setParalelipipedClicked(false);
        this.canvasViewModel.setPrismClicked(false);
        this.canvasViewModel.setPyramidClicked(true); // Set pyramid clicked flag
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
                "Enter Prism Dimensions", JOptionPane.OK_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                double pyramidLength = Double.parseDouble(lengthField.getText());
                double pyramidWidth = Double.parseDouble(widthField.getText());
                double pyramidHeight = Double.parseDouble(heightField.getText());

                // Calculate the area of the prism (assuming a rectangular base)
                double slantHeight = Math.sqrt(Math.pow(pyramidWidth / 2, 2) + Math.pow(pyramidHeight, 2));
                double ariaLaterala = 4 * pyramidLength * slantHeight / 2;
                double ariaBazei = pyramidLength * pyramidWidth;
                double ariaTotala = ariaLaterala + ariaBazei;
                double volum = ariaBazei * pyramidHeight / 3;

                // Display the calculated area
                JOptionPane.showMessageDialog(null, "Aria laterala a piramidei este: " + ariaLaterala
                                + "\nAria bazei piramidei este: " + ariaBazei + "\nAria totala a piramidei este " + ariaTotala + "\nVolumul piramidei este: " +volum,
                        "Aria", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
