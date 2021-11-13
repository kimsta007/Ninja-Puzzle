/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ninjase.controller;

import java.awt.Color;
import java.util.List;
import ninjase.model.Model;
import ninjase.model.Obstacle;
import ninjase.view.App;

/**
 *
 * @author proak
 */
public class Controller {
    public MoveController moveController;
    public App app;
    public Model model;
    private final int DEFAULT_LEVEL = 1;
   
    public Controller(Model model, App app){
        this.app = app;
        this.model = model;        
        moveController = new MoveController(app, model);
        this.processLevel(this.DEFAULT_LEVEL);
    }
    
    public int[] getLevel(){
        return this.model.getLevel().values();
    }

    public String getNinja(){
        return this.model.getNinja().getNinjaUrl();
    }
    
    public int[] getNinjaData(){
        return this.model.getNinja().values();
    }
    
    //This is where you create objects in your puzzle
    public final void processLevel(int level) {
        switch (level){
            case 1:this.model.getLevel().setLevel(4, 5, level); //(numRows, numCols, level)
                   this.model.getNinja().setPos(100, 100, 80, 80);
                   this.model.resetPuzzle();
                   this.model.createObstacle(300, 0, 80, 80, Color.YELLOW); //adds obstacle (xpos,ypos,width, height)
                   this.model.createObstacle(200, 200, 80, 80, Color.YELLOW); //adds obstacle (xpos, ypos, width, height)
                   app.repaint();
                   break;
            case 2:this.model.getLevel().setLevel(3, 7, level);
                   this.model.getNinja().setPos(100, 0, 80, 80);  
                   this.model.resetPuzzle();
                   this.model.createObstacle(200, 0, 80, 80, Color.YELLOW);  
                   this.model.createObstacle(300, 100, 80, 80, Color.YELLOW);
                   this.model.createObstacle(0, 100, 80, 80, Color.RED); 
                   this.model.createObstacle(200, 100, 80, 80, Color.RED);
                   this.model.createObstacle(600, 0, 80, 80, Color.GREEN);  
                   this.model.createObstacle(600, 100, 80, 80, Color.GREEN);
                   this.model.createObstacle(100, 100, 80, 80, Color.BLUE);  
                   this.model.createObstacle(600, 200, 80, 80, Color.BLUE);               
                   app.repaint();
                   break;
            case 3: this.model.getNinja().setPos(600, 600, 80, 80);
                   this.model.getLevel().setLevel(7, 7, level);
                   this.model.resetPuzzle();
                   this.model.createObstacle(100, 300, 80, 80, Color.YELLOW);  
                   this.model.createObstacle(400, 500, 80, 80, Color.YELLOW);
                   this.model.createObstacle(600, 500, 80, 80, Color.RED);  
                   this.model.createObstacle(200, 300, 80, 80, Color.RED);
                   this.model.createObstacle(500, 600, 80, 80, Color.GREEN);  
                   this.model.createObstacle(200, 200, 80, 80, Color.GREEN);
                   this.model.createObstacle(100, 400, 80, 80, Color.BLUE);  
                   this.model.createObstacle(500, 500, 80, 80, Color.BLUE);
                   this.model.createObstacle(100, 200, 80, 80, Color.CYAN);  
                   this.model.createObstacle(300, 300, 80, 80, Color.CYAN);
                   this.model.createObstacle(500, 100, 80, 80, Color.MAGENTA);  
                   this.model.createObstacle(0, 300, 80, 80, Color.MAGENTA);                   
                   app.repaint();
                   break;
        }
    }

    public List<Obstacle> getObstacles() {
        return this.model.getObstacleList();
    }
    

}
