package ninjase.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Model {
	Level level;
        Ninja ninja;
        int ninjaMoves;
	List <Obstacle> puzzle;
        
	public Model () {
            this.level = new Level (4, 6, 1);
            this.ninja = new Ninja(0, 0, 80, 80);
            this.puzzle = new ArrayList();
            this.ninjaMoves = 0;
	}
        
        public Ninja getNinja(){
            return this.ninja;
        }
        
        public int getMoves(){
            return this.ninjaMoves;
        }
        
        public void incrementMoves(){
            this.ninjaMoves += 1;
        }
        
        public void createObstacle(int x, int y, int w, int h, Color color){
            Obstacle obstacle = new Obstacle(x, y, w, h, color);
            this.puzzle.add(obstacle);
        }
        
        public boolean removeObstacles(int x, int y){
            boolean levelCompleted = false;
            int size  = puzzle.size();
            List <Obstacle> obstacles = new ArrayList<>();
            for (int index = 0; index < size; index++){
                if ((puzzle.get(index).x == x) && (puzzle.get(index).y == y)) {
                    obstacles.add(puzzle.get(index));                 
                }
            }
            puzzle.removeAll(obstacles);
            if (puzzle.isEmpty())
                levelCompleted = true;
            return levelCompleted;
        }
        
        public List<Obstacle> getObstacleList(){
            return this.puzzle;
        }
        
        public Level getLevel(){
            return this.level;
        }

        public void resetPuzzle(){
            this.puzzle.clear();
        }
}
