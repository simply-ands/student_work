package za.co.wethinkcode.toyrobot;

import za.co.wethinkcode.toyrobot.world.AbstractWorld;
import za.co.wethinkcode.toyrobot.maze.SimpleMaze;
import za.co.wethinkcode.toyrobot.world.TextWorld;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Robot {
    public static final Position CENTRE = new Position(0, 0);
    private String status;
    private final String name;
    private final ArrayList<Command> history = new ArrayList<>();
    private final AbstractWorld world;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.world = new TextWorld(new SimpleMaze());
    }

    public String getStatus() {
        return this.status;
    }

    private void addCommandToHistory(Command command) {
        List<String> moves = List.of("forward", "back", "right", "left", "sprint");
        if (moves.contains(command.getName())) {
            history.add(command);
        }
    }

    public List<Command> getHistoryCommand(int start, int end) {
        Collections.reverse(history);
        if (start == 0 && end == 0) {
            return history;
        } else if (start == 0) {
            return history.subList(0, end);
        } else {
            return history.subList(end, start);
        }
    }

    public boolean handleCommand(Command command) {
        addCommandToHistory(command);
        return command.execute(this);
    }

    public AbstractWorld getWorld() {
        return world;
    }

    @Override
    public String toString() {
        return "[" + world.getPosition().getX() + "," + world.getPosition().getY() + "] "
                + this.name + "> " + this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

}