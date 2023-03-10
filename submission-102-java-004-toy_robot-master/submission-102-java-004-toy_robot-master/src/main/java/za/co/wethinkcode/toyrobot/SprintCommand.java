package za.co.wethinkcode.toyrobot;

public class SprintCommand extends Command{
    
    public SprintCommand(String argument) {
        super("sprint", argument);
    }

    @Override
    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());
        for(int i = nrSteps;i>0;i--){
            Command forward = Command.create("forward "+i);
            forward.execute(target);
            if (i>1){
                System.out.println(target.toString());
            }
        }
        return true;
    }
}
