package ninjase.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JPanel;
import ninjase.controller.Controller;
import ninjase.model.Obstacle;

public class PuzzleViewer extends JPanel {

	Controller controller; 
        Image image;
	/**
	 * Create the panel.
     * @param controller
	 */
	public PuzzleViewer(Controller controller) {
            this.controller = controller; 
            image = Toolkit.getDefaultToolkit().getImage(controller.getNinja());
	}

	@Override
	public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int[] level = controller.getLevel();
            List<Obstacle> obstacles = controller.getObstacles();
            for (int r = 0; r < level[0]; r++) {
			for (int c = 0; c < level[1]; c++) {
                                    g.drawRect(100*c, 100*r, 80, 80);
			}
	    }
            drawNinja(g, controller.getNinjaData());
            drawObstacles(g, obstacles);
        }
        
        public void drawNinja(Graphics g, int[] ninjaLocation){
             Graphics2D g2d = (Graphics2D)g;
             g2d.drawImage(image, ninjaLocation[0], ninjaLocation[1], ninjaLocation[2], ninjaLocation[3], this);
        }
        
        public void drawObstacles(Graphics g, List<Obstacle> obstacles){
          obstacles.forEach((obstacle) -> {
               g.setColor(obstacle.getObstacleColor());
               g.fillRect(obstacle.values()[0], obstacle.values()[1], obstacle.values()[2], obstacle.values()[3]);                
          });
        }
}
