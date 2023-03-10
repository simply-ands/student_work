package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;

import java.util.ArrayList;
import java.util.List;

public class SquareObstacle implements Obstacle{
    private final int x;
    private final int y;

    
    public SquareObstacle(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public int getBottomLeftY() {return this.y;}

    @Override
    public int getBottomLeftX() {
        return this.x;
    }

    @Override
    public boolean blocksPosition(Position position) {

        List<Integer>  rangeX = Range(this.x, this.x+4+1,1);
        List<Integer>  rangeY = Range(this.y, this.y+4+1, 1);
        return rangeX.contains(position.getX()) && rangeY.contains(position.getY());
        
    }
    @Override
    public boolean blocksPath(Position e, Position l) {

        int imp;
        int y1 = e.getY();
        int x1 = e.getX();

        if (e.getX() == l.getX()) {
            if ((l.getY() - e.getY()) < 0) {
                imp = -1;
            } else {
                imp = 1;
            }
            int size = l.getY() - e.getY();
            for (int ignored : Range(0, Math.abs(size),1 )) {
                y1 += imp;
                if (blocksPosition(new Position(x1, y1))) {
                    return true;
                }
            }
        } else if (e.getY() == l.getY()) {
            int size;
            if ((l.getX()-e.getX()) < 0) {
                imp = -1;
            } else {
                imp = 1;
            }
            size = l.getX() - e.getX();
            for (int ignored : Range(0, Math.abs(size),1 )) {
                x1 +=imp;
                if (blocksPosition(new Position(x1, y1))) {
                    return true;
                }
            }
        }
        return false;
    } 
    public List<Integer> Range(int include , int exclude , int number){

        number =  number <= 0 ? 1 : number;
        List<Integer> range  = new ArrayList<>();
        for (int i = include; i < exclude;){
            range.add(i);
            i+= number;
        }
        return range;
    }







}
