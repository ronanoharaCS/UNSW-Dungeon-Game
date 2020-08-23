package unsw.dungeon;

import java.util.ArrayList;

public class GoalExit implements Goal {
    
    private Dungeon dungeon;

    public GoalExit(Dungeon d){
        dungeon = d;
    }

    @Override
    public boolean isComplete(){
        return dungeon.isPlayerOnExit();
    }

    @Override
    public void addSubGoals(ArrayList<Goal> subGoals) {
        throw new UnsupportedOperationException();
    }



}