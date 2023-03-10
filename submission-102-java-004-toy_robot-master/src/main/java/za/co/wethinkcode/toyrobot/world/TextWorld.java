package za.co.wethinkcode.toyrobot.world;


import za.co.wethinkcode.toyrobot.maze.Maze;

public class TextWorld extends AbstractWorld{

    public TextWorld(Maze maze){
        super(maze);
    }

    @Override
    public void showObstacles() {
        System.out.println("There are some obstacles: ");
        for(Obstacle obstacle:getObstacles()){
            int x =obstacle.getBottomLeftX();
            int y = obstacle.getBottomLeftY();
            System.out.println("- At position "+x+","+y+" (to "+(x+4)+","+(y+4)+")");
        }
    }

}
