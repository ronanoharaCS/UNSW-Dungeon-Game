package unsw.dungeon;

import java.util.ArrayList; 
public class GoalCompositeOR implements Goal {
    
    private ArrayList<Goal> subGoals; 

    public GoalCompositeOR(){
        subGoals = new ArrayList<Goal>();
    }

    @Override
    public void addSubGoals(ArrayList<Goal> goals){
        subGoals = goals;
    }

    @Override
    public boolean isComplete(){
        for(Goal currGoal : subGoals){
            if(currGoal.isComplete()){
                return true;
            }
        }
        return false;
    }



}