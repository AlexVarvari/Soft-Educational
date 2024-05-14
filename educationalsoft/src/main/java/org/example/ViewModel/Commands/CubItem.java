package org.example.ViewModel.Commands;

import org.example.ViewModel.CanvasViewModel;

import javax.swing.*;

public class CubItem implements ICommand{
    private CanvasViewModel canvasViewModel;
    public CubItem(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }
    @Override
    public void execute() {
        this.canvasViewModel.setRadieraClicked(false);
        this.canvasViewModel.setCreionClicked(false);
        this.canvasViewModel.setCubClicked(true);
        this.canvasViewModel.setParalelipipedClicked(false);
        this.canvasViewModel.setPrismClicked(false);
        JTextField lengthField = new JTextField(10);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Length:"));
        inputPanel.add(lengthField);


        int result = JOptionPane.showConfirmDialog(null, inputPanel,
                "Enter Cub Dimensions", JOptionPane.OK_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                double cubLength = Double.parseDouble(lengthField.getText());

                // Calculate the area of the prism (assuming a rectangular base)
                double ariaLaterala = 4 * cubLength * cubLength;
                double ariaTotala = 6 * cubLength * cubLength;
                double volum = cubLength * cubLength * cubLength;

                // Display the calculated area
                JOptionPane.showMessageDialog(null, "Aria laterala a cubului este: " + ariaLaterala
                                +"\nAria totala a cubului este: " + ariaTotala + "\nVolumul cubului este: " +volum,
                        "Aria", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
