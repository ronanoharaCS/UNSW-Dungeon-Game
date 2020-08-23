package unsw.dungeon;

import java.util.ArrayList;

public interface Goal {
    public void addSubGoals(ArrayList<Goal> subGoals);
    public boolean isComplete();
}
