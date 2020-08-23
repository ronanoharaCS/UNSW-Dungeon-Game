package unsw.dungeon;

import java.util.ArrayList;

public class GoalBoulder implements Goal{
        // the entity observed by this goal
        private Dungeon dungeon;
    
        public GoalBoulder(Dungeon d) {
            this.dungeon = d;
        }
        
        @Override
        public boolean isComplete(){
            
            for(FloorSwitch fs: dungeon.getFloorSwitches()){
                if(!fs.isTriggered()){
                    return false;
                }
            }
            return true;
        }
    
        @Override
        public void addSubGoals(ArrayList<Goal> subGoals) {
            throw new UnsupportedOperationException();
        }
    
    
}