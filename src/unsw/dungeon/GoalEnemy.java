package unsw.dungeon;

import java.util.ArrayList;

public class GoalEnemy implements Goal {
        private Dungeon dungeon;
    
        public GoalEnemy(Dungeon d) {
            this.dungeon = d;
        }
        
        @Override
        public boolean isComplete(){
            return dungeon.getEnemies().isEmpty();
        }
    
        @Override
        public void addSubGoals(ArrayList<Goal> subGoals) {
            throw new UnsupportedOperationException();
        }
}