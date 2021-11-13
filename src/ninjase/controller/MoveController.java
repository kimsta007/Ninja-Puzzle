package ninjase.controller;

import ninjase.model.Model;
import ninjase.model.Obstacle;
import ninjase.view.App;

public class MoveController {
	
	App app;
	Model model;
        int xMax, yMax;
        boolean isEmptySpace; 
        Obstacle currentObstacle;
	
	public MoveController(App app, Model model) {
		this.app = app;
		this.model = model;
	}
	
        private boolean checkSpace(int x, int y){
            isEmptySpace = true;
            model.getObstacleList().forEach((obstacle) -> {
                if (obstacle.values()[0] == x && obstacle.values()[1] == y)
                    isEmptySpace = false;
            });
            return isEmptySpace;
        }
        
        private Obstacle findObstacle(int x, int y){
            currentObstacle = null;
             model.getObstacleList().forEach((obstacle) -> {
                if (obstacle.values()[0] == x && obstacle.values()[1] == y)
                    currentObstacle = obstacle;
            });
            return currentObstacle;
        }
        
	public void process(int direction) {            
            int[] ninjaLocation = model.getNinja().values();
            int newPos = 0;
            xMax = (model.getLevel().values()[1] - 1) * 100;
            yMax = (model.getLevel().values()[0] - 1) * 100;
            switch (direction){
                case 1: if (findObstacle(ninjaLocation[0], ninjaLocation[1] - 100) == null){
                            newPos = ((ninjaLocation[1] - 100) >= 0) ? (ninjaLocation[1] - 100) : ninjaLocation[1];
                            model.getNinja().setPos(ninjaLocation[0], newPos, ninjaLocation[2], ninjaLocation[3]);
                            if (newPos != 0){
                                model.incrementMoves();
                                app.setMoveCount(String.valueOf(model.getMoves()));
                            }
                        } else {
                            newPos = ((ninjaLocation[1] - 200) >= 0) ? (ninjaLocation[1] - 100) : ninjaLocation[1];
                            if (checkSpace(ninjaLocation[0], newPos)) {
                                model.getNinja().setPos(ninjaLocation[0], newPos, ninjaLocation[2], ninjaLocation[3]);
                            } else { //remove obstacle
                                 if (findObstacle(ninjaLocation[0], newPos - 100) != null) {
                                      if (findObstacle(ninjaLocation[0], newPos - 100).getObstacleColor() == findObstacle(ninjaLocation[0], newPos).getObstacleColor()){
                                            //remove obstacles
                                            model.getNinja().setPos(ninjaLocation[0], newPos, ninjaLocation[2], ninjaLocation[3]);
                                            model.incrementMoves();
                                            app.setMoveCount(String.valueOf(model.getMoves()));
                                            //move obstacle
                                            if ((newPos - 100) >= 0)
                                                findObstacle(ninjaLocation[0], newPos).move(ninjaLocation[0], newPos - 100); 
                                            if (model.removeObstacles(ninjaLocation[0], newPos - 100)){
                                                app.repaint();
                                                app.showMessage();
                                            }
                                      }} else {
                                            model.getNinja().setPos(ninjaLocation[0], newPos, ninjaLocation[2], ninjaLocation[3]);
                                            model.incrementMoves();
                                            app.setMoveCount(String.valueOf(model.getMoves()));
                                            //move obstacle
                                            if ((newPos - 100) >= 0)
                                                findObstacle(ninjaLocation[0], newPos).move(ninjaLocation[0], newPos - 100);
                                      }}
                            }                        
                        app.repaint(); //Up
                        break;
                case 2: if (findObstacle(ninjaLocation[0] - 100, ninjaLocation[1]) == null) { //move ninja to the end
                                newPos = ((ninjaLocation[0] - 100) >= 0) ? (ninjaLocation[0] - 100) : ninjaLocation[0];
                                model.getNinja().setPos(newPos, ninjaLocation[1], ninjaLocation[2], ninjaLocation[3]);
                                if (newPos != 0) {
                                    model.incrementMoves();
                                    app.setMoveCount(String.valueOf(model.getMoves()));
                                }
                        } else {
                            newPos = ((ninjaLocation[0] - 200) >= 0) ? (ninjaLocation[0] - 100) : ninjaLocation[0];
                            if (checkSpace(newPos, ninjaLocation[1])){
                                model.getNinja().setPos(newPos, ninjaLocation[1], ninjaLocation[2], ninjaLocation[3]);
                            } else { //remove obstacle
                                    if (findObstacle(newPos - 100, ninjaLocation[1]) != null) {
                                      if (findObstacle(newPos - 100, ninjaLocation[1]).getObstacleColor() == findObstacle(newPos, ninjaLocation[1]).getObstacleColor()){
                                            //remove obstacles   
                                            model.getNinja().setPos(newPos, ninjaLocation[1], ninjaLocation[2], ninjaLocation[3]);
                                            model.incrementMoves();
                                            app.setMoveCount(String.valueOf(model.getMoves()));
                                            //move obstacle
                                            if ((newPos - 100) >= 0)
                                                findObstacle(newPos, ninjaLocation[1]).move(newPos - 100, ninjaLocation[1]); 
                                            if (model.removeObstacles(newPos - 100, ninjaLocation[1])){
                                                app.repaint();
                                                app.showMessage();
                                            }
                                       }} else {
                                            model.getNinja().setPos(newPos, ninjaLocation[1], ninjaLocation[2], ninjaLocation[3]);
                                            model.incrementMoves();
                                            app.setMoveCount(String.valueOf(model.getMoves()));
                                            //move obstacle
                                            if ((newPos - 100) >= 0)
                                                findObstacle(newPos, ninjaLocation[1]).move(newPos - 100, ninjaLocation[1]); 
                                      }
                                    }                                    
                            }                        
                        app.repaint(); //Left
                        break;
                case 3: if (findObstacle(ninjaLocation[0] + 100, ninjaLocation[1]) == null) { //move the ninja to the end
                            newPos = ((ninjaLocation[0] + 100) <= xMax) ? (ninjaLocation[0] + 100) : ninjaLocation[0]; 
                            model.getNinja().setPos(newPos, ninjaLocation[1], ninjaLocation[2], ninjaLocation[3]);
                            if (newPos != xMax){
                                model.incrementMoves();
                                app.setMoveCount(String.valueOf(model.getMoves()));
                            }
                        } else {
                            newPos = ((ninjaLocation[0] + 100) <= (xMax - 100)) ? (ninjaLocation[0] + 100) : ninjaLocation[0]; //checks 
                            if (checkSpace(newPos, ninjaLocation[1])){
                                model.getNinja().setPos(newPos, ninjaLocation[1], ninjaLocation[2], ninjaLocation[3]);
                            } else { //remove obstacle   
                                if (findObstacle(newPos + 100, ninjaLocation[1]) != null) {
                                      if (findObstacle(newPos + 100, ninjaLocation[1]).getObstacleColor() == findObstacle(newPos, ninjaLocation[1]).getObstacleColor()){
                                            //remove obstacles 
                                            model.getNinja().setPos(newPos, ninjaLocation[1], ninjaLocation[2], ninjaLocation[3]);                            
                                            model.incrementMoves();
                                            app.setMoveCount(String.valueOf(model.getMoves()));
                                            //move obstacle
                                            if ((newPos + 100) <= xMax)
                                                findObstacle(newPos, ninjaLocation[1]).move(newPos + 100, ninjaLocation[1]); 
                                            if (model.removeObstacles(newPos + 100, ninjaLocation[1])){
                                                app.repaint();
                                                app.showMessage();
                                            }
                                      }} else {
                                          model.getNinja().setPos(newPos, ninjaLocation[1], ninjaLocation[2], ninjaLocation[3]);                            
                                          model.incrementMoves();
                                          app.setMoveCount(String.valueOf(model.getMoves()));
                                          //move obstacle
                                          if ((newPos + 100) <= xMax)
                                            findObstacle(newPos, ninjaLocation[1]).move(newPos + 100, ninjaLocation[1]); 
                                }
                                }
                            }                                        
                        app.repaint(); //Right
                        break;
                case 4: if (findObstacle(ninjaLocation[0], (ninjaLocation[1] + 100)) == null){ //move the ninja to the end
                            newPos = ((ninjaLocation[1] + 100) <= yMax) ? (ninjaLocation[1] + 100) : ninjaLocation[1];                               
                            model.getNinja().setPos(ninjaLocation[0], newPos, ninjaLocation[2], ninjaLocation[3]);
                            if (newPos != yMax){
                                model.incrementMoves();
                                app.setMoveCount(String.valueOf(model.getMoves()));
                            }
                         } else {  
                            newPos = ((ninjaLocation[1] + 100) <= (yMax - 100)) ? (ninjaLocation[1] + 100) : ninjaLocation[1];                        
                            if (checkSpace(ninjaLocation[0], newPos)){
                                   model.getNinja().setPos(ninjaLocation[0], newPos, ninjaLocation[2], ninjaLocation[3]);
                            } else {
                                  //check for obstacle ahead 
                                  if (findObstacle(ninjaLocation[0], newPos + 100) != null) {
                                      if (findObstacle(ninjaLocation[0], newPos + 100).getObstacleColor() == findObstacle(ninjaLocation[0], newPos).getObstacleColor()){
                                            //remove obstacles                                         
                                            model.getNinja().setPos(ninjaLocation[0], newPos, ninjaLocation[2], ninjaLocation[3]);
                                            model.incrementMoves();
                                            app.setMoveCount(String.valueOf(model.getMoves()));                      
                                            if ((newPos + 100) <= yMax)
                                                findObstacle(ninjaLocation[0], newPos).move(ninjaLocation[0], newPos + 100);      
                                            if (model.removeObstacles(ninjaLocation[0], newPos + 100)){
                                                app.repaint();
                                                app.showMessage();
                                            }
                                      }
                                  } else {
                                            model.getNinja().setPos(ninjaLocation[0], newPos, ninjaLocation[2], ninjaLocation[3]);
                                            model.incrementMoves();
                                            app.setMoveCount(String.valueOf(model.getMoves()));                      
                                            if ((newPos + 100) <= yMax)
                                                findObstacle(ninjaLocation[0], newPos).move(ninjaLocation[0], newPos + 100);      
                                  }
                            }
                         }
                        app.repaint(); //Down
                        break;
            }
	}
}
