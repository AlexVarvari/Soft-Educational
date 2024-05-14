package org.example.ViewModel.Commands;

import org.example.ViewModel.CanvasViewModel;

import javax.swing.*;
import java.awt.*;

public class PrismItem implements ICommand{
    private CanvasViewModel canvasViewModel;
    public PrismItem(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }
    @Override
    public void execute() {
        this.canvasViewModel.setRadieraClicked(false);
        this.canvasViewModel.setCreionClicked(false);
        this.canvasViewModel.setCubClicked(false);
        this.canvasViewModel.setParalelipipedClicked(false);
        this.canvasViewModel.setPrismClicked(true);
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
                double prismLength = Double.parseDouble(lengthField.getText());
                double prismWidth = Double.parseDouble(widthField.getText());
                double prismHeight = Double.parseDouble(heightField.getText());

                // Calculate the area of the prism (assuming a rectangular base)
                double ariaLaterala = 2 * (prismLength * prismHeight + prismWidth * prismHeight);
                double ariaBazei = prismLength * prismWidth;
                double ariaTotala = ariaLaterala + 2*ariaBazei;
                double volum = prismLength * prismWidth * prismHeight;

                // Display the calculated area
                JOptionPane.showMessageDialog(null, "Aria laterala a prismei este: " + ariaLaterala + "\nAria bazei prismei este: " + ariaBazei
                                +"\nAria totala a prismei este: " + ariaTotala + "\nVolumul prismei este: " +volum,
                        "Aria", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
