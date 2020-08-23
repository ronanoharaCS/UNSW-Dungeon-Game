package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.util.ArrayList;

/**
 * Loads a dungeon from a .json file.
 *
 * By extending this class, a subclass can hook into entity creation. This is
 * useful for creating UI elements with corresponding entities.
 *
 * @author Robert Clifton-Everest
 *
 */
public abstract class DungeonLoader {

    private JSONObject json;

    public DungeonLoader(String filename) throws FileNotFoundException {
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public Dungeon load() {
        // initialize dungeon
        int width = json.getInt("width");
        int height = json.getInt("height");
        Dungeon dungeon = new Dungeon(width, height);

        // Load entities
        JSONArray jsonEntities = json.getJSONArray("entities");
        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }
 
        // Load goals
        Goal goal = goalsFromObject(dungeon, json.getJSONObject("goal-condition"));
        dungeon.addGoals(goal);

        return dungeon;
    }

    private void loadEntity(Dungeon dungeon, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");

        Entity entity = null;
        switch (type) {
        case "player":
            Player player = new Player(dungeon, x, y);
            dungeon.setPlayer(player);
            onLoad(player);
            entity = player;
            break;
        case "wall":
            Wall wall = new Wall(x, y);
            onLoad(wall);
            entity = wall;
            break;
        case "boulder":
            Boulder boulder = new Boulder(x, y);
            onLoad(boulder);
            entity = boulder;
            break;
        case "exit":
            Exit exit = new Exit(x, y);
            onLoad(exit);
            entity = exit;
            break;
        case "switch":
            FloorSwitch fSwitch = new FloorSwitch(x, y);
            onLoad(fSwitch);
            entity = fSwitch;
            break;
        case "treasure":
            Treasure treasure = new Treasure(x, y);
            onLoad(treasure);
            entity = treasure;
            break;
        case "door":
            Door door = new Door(x, y);
            int id = json.getInt("id");
            door.setId(id);
            onLoad(door);
            entity = door;
            break;
        case "invincibility":
            InvincibilityPotion iPotion = new InvincibilityPotion(x, y);
            onLoad(iPotion);
            entity = iPotion;
            break;
        case "enemy":
            Enemy enemy = new Enemy(x, y);
            enemy.setDungeon(dungeon);
            onLoad(enemy);
            entity = enemy;
            break;
        case "sword":
            Sword sword = new Sword(x,y);
            onLoad(sword);
            entity = sword;
            break;
        case "key":
            Key key = new Key(x,y);
            int id2 = json.getInt("id");
            key.setId(id2);
            onLoad(key);
            entity = key;
            break;
        case "portal":
            Portal portal = new Portal(x,y);
            int id3 = json.getInt("id");
            portal.setId(id3);
            //System.out.print("PORTAL ID "+id);//remove
            onLoad(portal);
            entity = portal;
            break;
        }
        dungeon.addEntity(entity);
    }

    private Goal goalsFromObject(Dungeon d, JSONObject json) {
        String goalName = json.getString("goal");
        
        Goal goal = null;

        // determine what object goal you are dealing with and handle
        if (goalName.equals("AND")){
            GoalCompositeAND goal1 = new GoalCompositeAND();
            ArrayList<Goal> subGoals1 = goalsFromArray(d, json.getJSONArray("subgoals"));
            goal1.addSubGoals(subGoals1);
            return goal1;
        } else if (goalName.equals("OR")){
            GoalCompositeOR goal2 = new GoalCompositeOR();
            ArrayList<Goal> subGoals2 = goalsFromArray(d, json.getJSONArray("subgoals"));
            goal2.addSubGoals(subGoals2);
            return goal2;
        } else if (goalName.equals("exit")){
            GoalExit goal3 = new GoalExit(d);
            return goal3;
        } else if (goalName.equals("enemies")){
            GoalEnemy goal4 = new GoalEnemy(d);
            return goal4;
        } else if (goalName.equals("boulders")){
            GoalBoulder goal5 = new GoalBoulder(d);
            return goal5;
        } else if (goalName.equals("treasure")){ 
            GoalTreasure goal6 = new GoalTreasure(d);
            return goal6;
        }

        return goal;
        
        /*
        switch (goalName) {
            case "AND":
                GoalCompositeAND goal1 = new GoalCompositeAND();
                ArrayList<Goal> subGoals1 = goalsFromArray(d, json.getJSONArray("subgoals"));
                goal1.addSubGoals(subGoals1);
                return goal1;
            case "OR":
                GoalCompositeOR goal2 = new GoalCompositeOR();
                ArrayList<Goal> subGoals2 = goalsFromArray(d, json.getJSONArray("subgoals"));
                goal2.addSubGoals(subGoals2);
                return goal2;
            case "exit":
                GoalExit goal3 = new GoalExit(d);
                return goal3;
            case "enemies":
                GoalEnemy goal4 = new GoalEnemy(d);
                return goal4;
            case "boulders":
                GoalBoulder goal5 = new GoalBoulder(d);
                return goal5;
            case "treasure":
                GoalTreasure goal6 = new GoalTreasure(d);
                return goal6;
        }
        */
    }

    private ArrayList<Goal> goalsFromArray(Dungeon d, JSONArray subGoals){
        ArrayList<Goal> goals = new ArrayList<Goal>();

        // process each goal in the JSONArray and add to the
        // composite goal's array
        for (int i = 0; i < subGoals.length(); i++) {
            goals.add(goalsFromObject(d, subGoals.getJSONObject(i)));
            
        }
        return goals;
    } 

    public abstract void onLoad(Entity player);

    public abstract void onLoad(Wall wall);
    
    // TODO Create additional abstract methods for the other entities
    public abstract void onLoad(Boulder boulder);
    public abstract void onLoad(Exit exit);
    public abstract void onLoad(FloorSwitch fSwitch);
    public abstract void onLoad(Treasure treasure);
    public abstract void onLoad(Door door);
    public abstract void onLoad(InvincibilityPotion iPotion);
    public abstract void onLoad(Enemy enemy);
    public abstract void onLoad(Sword sword);
    public abstract void onLoad(Key key);
    public abstract void onLoad(Portal portal);
}
