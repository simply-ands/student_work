package za.co.wethinkcode.toyrobot.world;

import java.util.List;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.maze.Maze;
import za.co.wethinkcode.toyrobot.turtlelibrary.Turtle;
public class TurtleWorld extends AbstractWorld{
    Turtle turtle;
    boolean drawborder;
    private final List<Obstacle> ObstacleList ;
    private final Maze maze;
    public TurtleWorld (Maze maze){
        super(maze);
        turtle = new Turtle();
        turtle.home();
        turtle.face(90);
        this.maze= maze;
        this.ObstacleList = this.maze.getObstacles();
        turtle.worldCoordinates(-110,-210,110,210);
        drawsBorder();
        turtle.down();
        showObstacles();
        turtle.speed(1);

    }
    @Override
    public void updateDirection(boolean turnRight){

        if(turnRight){
            if (this.getCurrentDirection().equals(Direction.UP)){
                setDirection(Direction.RIGHT);
                turtle.right(90);

            }
            else if(getCurrentDirection().equals(Direction.RIGHT)){
                setDirection(Direction.DOWN);
                turtle.right(90);}

            else if(getCurrentDirection().equals(Direction.DOWN)){
                setDirection(Direction.LEFT);
                turtle.right(90);}

            else if(getCurrentDirection().equals(Direction.LEFT)){
                setDirection(Direction.UP);
                turtle.right(90);}

        }
        else{
            if(getCurrentDirection().equals(Direction.UP)){
                setDirection(Direction.LEFT);
                turtle.left(90);}

            else if(getCurrentDirection().equals(Direction.LEFT)){
                setDirection(Direction.DOWN);
                turtle.left(90);}

            else if(getCurrentDirection().equals(Direction.DOWN)){
                setDirection(Direction.RIGHT);
                turtle.left(90);}

            else if(getCurrentDirection().equals(Direction.RIGHT)){
                setDirection(Direction.UP);
                turtle.left(90);}
        }
    }

    private void setDirection(Direction ignoredRight) {

    }
    @Override
    public UpdateResponse updatePosition(int nrSteps){
        int newX = this.position.getX();
        int newY = this.position.getY();
        turtle.down();

        if (Direction.UP.equals(this.getCurrentDirection())) {

            newY = newY + nrSteps;
        }

        else if(Direction.DOWN.equals(this.getCurrentDirection())){

            newY = newY - nrSteps;}

        else if (Direction.RIGHT.equals(this.getCurrentDirection())){

            newX = newX + nrSteps;}

        else if (Direction.LEFT.equals(this.getCurrentDirection())){

            newX = newX - nrSteps;}

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            if (this.maze.blocksPath(this.position, newPosition)){
                return UpdateResponse.FAILED_OBSTRUCTED;
            }else{
                this.position = newPosition;
                new Position(newX,newY);
                turtle.forward(nrSteps);
                return UpdateResponse.SUCCESS;
            }
        }
        return UpdateResponse.FAILED_OUTSIDE_WORLD;
    }
    @Override
    public List<Obstacle> getObstacles(){return this.ObstacleList;}

    @Override
    public void showObstacles(){
        if(!this.ObstacleList.isEmpty()){
            turtle.penColor("blue");
            System.out.println("There's some obstacles:");
            for(Obstacle obstacles: this.ObstacleList){
                turtle.up();
                turtle.goTo(obstacles.getBottomLeftX(), obstacles.getBottomLeftY());
                turtle.down();
                turtle.speed(1);
                turtle.face(270);
                for (int i = 0; i < 4; i++) {

                turtle.forward(5);
                turtle.left(90);}
                turtle.up();
                turtle.home();
                turtle.face(90);
                turtle.down();
                System.out.println("-At ("+obstacles.getBottomLeftX()+","+obstacles.getBottomLeftY()+") " +
                        "to ("+ Math.addExact(obstacles.getBottomLeftX(),5)+","+Math.addExact(obstacles.getBottomLeftY(),5)+")");
            }
        }
    }

    public boolean checkPath(Position a , Position b){
        List<Obstacle> obsList = getObstacles();
        for (Obstacle obs : obsList){
            if(obs.blocksPath(a,b)) return true;
        }
        return false;
    }
    public Object drawsBorder(){
        turtle.up();
    turtle.goTo(-100,200);
    turtle.down();
        for (int i = 0; i < 2; i++) {
            turtle.right(90);
            turtle.forward(200);
            turtle.right(90);
            turtle.forward(400);
        }
        turtle.up();
        turtle.face(90);
        turtle.home();
        return null;
    }
}
