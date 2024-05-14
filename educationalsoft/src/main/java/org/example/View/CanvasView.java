package org.example.View;

import org.example.Model.Repository.Repository;
import org.example.Model.Repository.UserRepository;
import org.example.ViewModel.CanvasViewModel;
import org.example.ViewModel.UserViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanvasView extends JFrame implements MouseListener, MouseMotionListener {
    public CanvasViewModel canvasViewModel;
    public JPanel contentPane;
    public CanvasView() {
        super("Canvas");
        canvasViewModel = new CanvasViewModel(this);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.repaint();
        JMenuBar menuBar = new JMenuBar();
        JMenu shapesMenu = new JMenu("Shapes");
        JMenu instrumentsMenu = new JMenu("Instruments");

        JMenuItem prismaItem = new JMenuItem("Prism");
        JMenuItem paralelipipedItem = new JMenuItem("Parallelepiped");
        JMenuItem cubItem = new JMenuItem("Cube");
        JMenuItem piramidaItem = new JMenuItem("Pyramid");
        JMenuItem tetraedruItem = new JMenuItem("Tetrahedron");
        JMenuItem trunchiItem = new JMenuItem("Pyramid Trunk");

        JMenuItem creionItem = new JMenuItem("Pencil");
        JMenuItem radieraItem = new JMenuItem("Eraser");
        JMenuItem blankItem = new JMenuItem("Clear");

        JMenuItem homeItem = new JMenuItem("Home page");
        JMenuItem exportItem = new JMenuItem("Export Shapes");
        JMenuItem importItem = new JMenuItem("Import Shapes");
        JMenuItem colorItem = new JMenuItem("Choose Color");

        shapesMenu.add(prismaItem);
        shapesMenu.add(paralelipipedItem);
        shapesMenu.add(cubItem);
        shapesMenu.add(piramidaItem);
        shapesMenu.add(tetraedruItem); // Add Tetrahedron menu item
        shapesMenu.add(trunchiItem); // Add Pyramid Trunk menu item

        instrumentsMenu.add(creionItem);
        instrumentsMenu.add(radieraItem);
        instrumentsMenu.add(blankItem);

        menuBar.add(shapesMenu);
        menuBar.add(instrumentsMenu);
        menuBar.add(homeItem);
        menuBar.add(exportItem);
        menuBar.add(importItem);
        setJMenuBar(menuBar);

        setSize(800, 600);
        setVisible(true);

        creionItem.addActionListener(e -> this.canvasViewModel.creionItem.execute());
        radieraItem.addActionListener(e -> this.canvasViewModel.radieraItem.execute());
        blankItem.addActionListener(e -> this.canvasViewModel.blankItem.execute());
        cubItem.addActionListener(e -> this.canvasViewModel.cubItem.execute());
        paralelipipedItem.addActionListener(e -> this.canvasViewModel.paralelipipedItem.execute());
        prismaItem.addActionListener(e -> this.canvasViewModel.prismItem.execute());
        piramidaItem.addActionListener(e -> this.canvasViewModel.piramidaItem.execute());
        tetraedruItem.addActionListener(e -> this.canvasViewModel.tetrItem.execute());
        trunchiItem.addActionListener(e -> this.canvasViewModel.trunchiItem.execute());
        homeItem.addActionListener(e -> this.canvasViewModel.homeItem.execute());
        exportItem.addActionListener(e -> this.canvasViewModel.export.execute());
        importItem.addActionListener(e -> this.canvasViewModel.importShapes.execute());

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.canvasViewModel.mouseClick.execute(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        canvasViewModel.mouseMove.execute(e);
    }

public static void main(String[] args) {
    Repository repository = new Repository(); // Assuming Repository has a parameterless constructor
    UserRepository userRepository = new UserRepository(repository); // Pass the repository here

    UserViewModel userViewModel = new UserViewModel(userRepository);
    javax.swing.SwingUtilities.invokeLater(() -> {
        CanvasView view = new CanvasView();
        view.setVisible(true);
    });
}
}

