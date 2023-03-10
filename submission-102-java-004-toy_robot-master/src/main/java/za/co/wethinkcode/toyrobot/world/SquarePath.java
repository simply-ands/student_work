package za.co.wethinkcode.toyrobot.world;

 public  class SquarePath {

    private final int x;
    private final int y;

    public SquarePath(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getBottomLeftX() {
        return this.x;
    }

    public int getBottomLeftY() {
        return this.y;
    }


}
