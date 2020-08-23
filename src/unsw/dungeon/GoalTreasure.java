package unsw.dungeon;

import java.util.ArrayList;

public class GoalTreasure implements Goal {
    private Dungeon dungeon;
    
    public GoalTreasure(Dungeon d) {
        this.dungeon = d;
    }
    
    @Override
    public boolean isComplete(){
        return dungeon.getTreasure().isEmpty();
    }

    @Override
    public void addSubGoals(ArrayList<Goal> subGoals) {
        throw new UnsupportedOperationException();
    }
}