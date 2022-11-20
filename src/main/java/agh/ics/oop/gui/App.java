package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    private GridPane gridMap;
    private GrassField map;
    private int height = 50;
    private int width = 50;


    public void init() {
        try{
            String[] params = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionParser().parse(params);
            this.map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(0,0)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            Animal animal = new Animal(map, new Vector2d(2, 2));
            Animal animal1 = new Animal(map, new Vector2d(2, 2));
            engine.run();
            System.out.println(map);
            this.gridMap = new GridPane();
            draw();
            System.out.println(gridMap);
        }
        catch (IllegalArgumentException ex){
            System.out.println("Caught an exception:" + ex);
        }


    }

    public void start(Stage primaryStage){
        Label label = new Label("Zwierzak");



        Scene scene = new Scene(gridMap, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void draw(){
        this.gridMap.setGridLinesVisible(true);
        int right = this.map.getDrawUpperRight().x;
        int upper = this.map.getDrawUpperRight().y;
        int left = this.map.getDrawLowerLeft().x;
        int lower = this.map.getDrawLowerLeft().y;
        int cols = right - left + 2;
        int rows = upper - lower + 2;
        this.gridMap.add(new Label("y/x"), 0, 0, 1, 1);
        this.gridMap.getColumnConstraints().add(new ColumnConstraints(this.width));
        this.gridMap.getRowConstraints().add(new RowConstraints(this.height));
        for (int i = 1; i < cols; i++){
            Label label = new Label("" + left);
            left++;
            this.gridMap.add(label, i, 0, 1, 1);
            this.gridMap.getColumnConstraints().add(new ColumnConstraints(this.width));
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (int i = 1; i < rows; i++){
            Label label = new Label("" + (upper - lower));
            lower++;
            this.gridMap.add(label, 0, i, 1, 1);
            this.gridMap.getRowConstraints().add(new RowConstraints(this.height));
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (int i = 1; i < cols; i++){
            for (int j = 1; j < rows; j++){
                Label label = new Label("");
                this.gridMap.add(label, i, j, 1, 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }

        left = this.map.getDrawLowerLeft().x;
        for (Grass grass: map.grassList){
            System.out.println(grass.getPosition());
            Label label = new Label(grass.toString());
            label.setFont(new Font(30));
            this.gridMap.add(label, grass.getPosition().x - left + 1, (upper - grass.getPosition().y + 1), 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);

        }
    }

}
