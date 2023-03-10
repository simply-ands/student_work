package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import java.util.List;

public abstract class AbstractMaze implements Maze{
    List<Obstacle> obstacles;

    List<Position> mazePath;
    String name;

    public static AbstractMaze DeclareMaze(String mazeType){

        switch (mazeType.toLowerCase()){
            case "emptymaze":
                return new EmptyMaze();
            case "randommaze":
                return new RandomMaze();
            case "simplemaze":
                return new SimpleMaze();
            // case "designedmaze":
            //     return new AbstractMaze();

            default:
                throw new IllegalArgumentException("invalid maze entered");
        }
    }

    public static String LoadedMaze(String maze){
        return "Loaded "+maze+".";
    }

    public List<Position> getPath() {
        return this.mazePath;
    }

}


