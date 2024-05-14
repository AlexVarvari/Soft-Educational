package org.example.ViewModel;

import org.example.Model.Shapes.Shapes;
import org.example.View.CanvasView;
import org.example.ViewModel.Commands.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CanvasViewModel {
    private boolean isCreionClicked = false;
    private boolean isRadieraClicked = false;
    private boolean isCubClicked = false;
    private boolean isParalelipipedClicked = false;
    private boolean isPrismClicked = false;
    private boolean isPyramidClicked = false;
    private boolean isPyramidTrunkClicked = false;
    private boolean isTetrahedronClicked = false;
    private Color currentColor = Color.RED;
    public CanvasView view;
    public List<Shapes> shapes;
    public ICommand creionItem;
    public ICommand radieraItem;
    public ICommand blankItem;
    public ICommand cubItem;
    public ICommand paralelipipedItem;
    public ICommand prismItem;
    public ICommand piramidaItem;
    public ICommand tetrItem;
    public ICommand trunchiItem;
    public ICommand homeItem;
    public ICommandMouse mouseMove;
    public ICommandMouse mouseClick;
    public ICommand export;
    public ICommand importShapes;

    public CanvasViewModel(CanvasView view){
        this.view = view;
        shapes = new ArrayList<>();
        creionItem = new CreionItem(this);
        radieraItem = new RadieraItem(this);
        blankItem = new BlankItemClick(this);
        cubItem = new CubItem(this);
        paralelipipedItem = new ParalelipipedItem(this);
        prismItem = new PrismItem(this);
        piramidaItem = new PiramidaItem(this);
        tetrItem = new TetraedruItem(this);
        trunchiItem = new TrunchiItem(this);
        homeItem = new HomeItem(this);
        mouseMove = new HandleMouseMoved(this);
        mouseClick = new HandleMouseClick(this);
        export = new ExportCommand(this);
        importShapes = new ImportCommand(this);

    }
    public boolean isCreionClicked() {
        return isCreionClicked;
    }

    public void setCreionClicked(boolean creionClicked) {
        isCreionClicked = creionClicked;
    }

    public boolean isRadieraClicked() {
        return isRadieraClicked;
    }

    public void setRadieraClicked(boolean radieraClicked) {
        isRadieraClicked = radieraClicked;
    }

    public boolean isCubClicked() {
        return isCubClicked;
    }

    public void setCubClicked(boolean cubClicked) {
        isCubClicked = cubClicked;
    }

    public boolean isParalelipipedClicked() {
        return isParalelipipedClicked;
    }

    public void setParalelipipedClicked(boolean paralelipipedClicked) {
        isParalelipipedClicked = paralelipipedClicked;
    }

    public boolean isPrismClicked() {
        return isPrismClicked;
    }

    public void setPrismClicked(boolean prismClicked) {
        isPrismClicked = prismClicked;
    }

    public boolean isPyramidClicked() {
        return isPyramidClicked;
    }

    public void setPyramidClicked(boolean pyramidClicked) {
        isPyramidClicked = pyramidClicked;
    }

    public boolean isPyramidTrunkClicked() {
        return isPyramidTrunkClicked;
    }

    public void setPyramidTrunkClicked(boolean pyramidTrunkClicked) {
        isPyramidTrunkClicked = pyramidTrunkClicked;
    }

    public boolean isTetrahedronClicked() {
        return isTetrahedronClicked;
    }

    public void setTetrahedronClicked(boolean tetrahedronClicked) {
        isTetrahedronClicked = tetrahedronClicked;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }


}
