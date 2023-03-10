package za.co.wethinkcode.toyrobot.world;

import java.util.List;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.maze.Maze;

public abstract class AbstractWorld implements IWorld {
    Position position;
    private Direction currentDirection;
    private final Maze maze;

    public AbstractWorld(Maze maze){
        this.position = CENTRE;
        this.currentDirection = Direction.UP;
        this.maze = maze;
    }

    @Override
    public UpdateResponse updatePosition(int nrSteps){
        int newX = position.getX();
        int newY = position.getY();

        if (Direction.UP.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }else if (Direction.DOWN.equals(this.currentDirection)) {
            newY = newY - nrSteps;
        }else if (Direction.RIGHT.equals(this.currentDirection)) {
            newX = newX + nrSteps;
        }else if (Direction.LEFT.equals(this.currentDirection)) {
            newX = newX - nrSteps;
        }
        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            position = newPosition;
            return UpdateResponse.SUCCESS;
        }
        return UpdateResponse.FAILED_OUTSIDE_WORLD;
    }

    @Override
    public void updateDirection(boolean turnRight) {
    if(turnRight){
        switch (currentDirection){
            case UP:
                setCurrentDirection(Direction.RIGHT);
                break;
            case DOWN:
                setCurrentDirection(Direction.LEFT);
                break;
            case RIGHT:
                setCurrentDirection(Direction.DOWN);
                break;
            case LEFT:
                setCurrentDirection(Direction.UP);
                break;
        }
    }else{
        switch (currentDirection){
            case UP:
                setCurrentDirection(Direction.LEFT);
                break;
            case DOWN:
                setCurrentDirection(Direction.RIGHT);
                break;
            case RIGHT:
                setCurrentDirection(Direction.UP);
                break;
            case LEFT:
                setCurrentDirection(Direction.DOWN);
                break;
        }
    }
    }

    @Override
    public Position getPosition() {
        return position;
    }
    @Override
    public boolean isNewPositionAllowed(Position position) {
        return position.isIn(TOP_LEFT, BOTTOM_RIGHT);
    }

    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

    @Override
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    @Override
    public boolean isAtEdge() {
        return position.getY() == 200;
    }

    @Override
    public void reset() {
        this.position = CENTRE;
        this.currentDirection = Direction.UP;

    }

    public boolean isPositionAllowed(Position currentPosition, Position newPosition){
        for(Obstacle obstacle:getObstacles()){
            if(obstacle.blocksPosition(newPosition)){
                return true;
            }else if(obstacle.blocksPath(currentPosition, newPosition)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Obstacle> getObstacles() {
        return maze.getObstacles();
    }

    @Override
    public void showObstacles() {

    }
}
