package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;

import java.util.ArrayList;
import java.util.List;

public class EmptyMaze extends AbstractMaze{
    String name = "Emptymaze";
    boolean drawBorder;
    List<Obstacle> emptyMaze = new ArrayList<>();

    public EmptyMaze(){
        drawBorder=true;
        super.name= this.name;
        super.obstacles=emptyMaze;}

    public List<Obstacle> getObstacles() {
        return this.emptyMaze;}


    @Override
    public boolean blocksPath(Position a, Position b) {
        for(Obstacle obs : emptyMaze){
            if(obs.blocksPath(a,b)) return true;
        }
        return false;
    }


}


