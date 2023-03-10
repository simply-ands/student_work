package za.co.wethinkcode.toyrobot;

import java.util.Collections;
import java.util.List;

public class ReplayCommand extends Command{

    public ReplayCommand(String argument) {
        super("replay", argument);
    }

    public ReplayCommand(){
        super("replay");
    }

    @Override
    public boolean execute(Robot target) {
        String[] replayArguments = getArgument().split(" ");
        boolean reverse = getArgument().contains("reversed");
        int start  = 0;
        int end = 0;

        if(replayArguments.length > 0){
            String numberFromReplayArguments = getNumberFromReplayArguments(replayArguments);
            if(isANumber(numberFromReplayArguments)){
                end = Integer.parseInt(numberFromReplayArguments);
            }else if(numberFromReplayArguments.contains("-")){
                String[] numbers = numberFromReplayArguments.split("-");
                start = Integer.parseInt(numbers[0]);
                end= Integer.parseInt(numbers[1]);
            }

        }
        List<Command> commandsToReplay = target.getHistoryCommand(start, end);
        Collections.reverse(commandsToReplay);

        if(reverse){
            Collections.reverse(commandsToReplay);
        }

        for(Command command:commandsToReplay){
            command.execute(target);
            System.out.println(target);
        }
        target.setStatus("replayed "+commandsToReplay.size()+" commands.");
        return true;

    }

    private String getNumberFromReplayArguments(String[] arguments){
        if(arguments.length == 1 && arguments[0].equalsIgnoreCase("reversed")){
            return arguments[0];
        }else if(arguments[0].equalsIgnoreCase("reversed")){
            return arguments[1];
        }else{
            return arguments[0];
        }
    }

    private boolean isANumber(String argument){
        try{
            Integer.parseInt(argument);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
