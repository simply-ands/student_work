package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMaze extends AbstractMaze {
    public List<Obstacle> getObstacles() {
        return this.randomMaze;
    }

    String name = "random maze";
    List<Obstacle> randomMaze = new ArrayList<>();
    boolean drawBorder;
    public RandomMaze() {
        drawBorder=true;
        createObstacles();
    }

    @Override
    public boolean blocksPath(Position e, Position l) {
        for (Obstacle obs : randomMaze){
            if(obs.blocksPath(e,l)) return true;
        }
        return false;
    }

    public void createObstacles() {
        Random rand = new Random();
        int numberOfObstacles = rand.nextInt(11);

        for (int i = 0; i < numberOfObstacles; i++) {

            boolean xValueBoolean = rand.nextBoolean();
            int xValue = (xValueBoolean ? -1 * rand.nextInt(100) : rand.nextInt(100));

            boolean yValueBoolean = rand.nextBoolean();
            int yValue = (yValueBoolean ? -1 * rand.nextInt(200) : rand.nextInt(200));

            this.randomMaze.add(new SquareObstacle(xValue, yValue));
        }

    }
}


