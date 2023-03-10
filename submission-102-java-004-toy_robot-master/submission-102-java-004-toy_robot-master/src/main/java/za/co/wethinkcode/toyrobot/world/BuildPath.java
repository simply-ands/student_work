package za.co.wethinkcode.toyrobot.world;

public class BuildPath {
    private int x;
    private int y;

    public BuildPath setX(int x) {
        this.x = x;
        return this;
    }

    public BuildPath setY(int y) {
        this.y = y;
        return this;
    }

    public SquarePath createSquarePath() {
        return new SquarePath(x, y);
    }
}