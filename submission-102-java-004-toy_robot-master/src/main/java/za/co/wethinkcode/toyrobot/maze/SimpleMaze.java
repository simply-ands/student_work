package za.co.wethinkcode.toyrobot.maze;

import java.util.ArrayList;
import java.util.List;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

public class SimpleMaze extends AbstractMaze{
    List<Obstacle> SingleObstacle = new ArrayList<>();
    boolean drawBorder;
    public SimpleMaze(){

        drawBorder=true;
        createObstacles();
    }
    public List<Obstacle> getObstacles(){return this.SingleObstacle;}

    @Override
    public boolean blocksPath(Position a, Position b) {
        for(Obstacle s : SingleObstacle){
            if(s.blocksPath(a,b)) return true;
        }
        return false;
    }

    public void createObstacles(){
        SingleObstacle.add(new SquareObstacle(1,1));
    }

}
