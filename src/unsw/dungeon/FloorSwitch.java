package unsw.dungeon;

public class FloorSwitch extends Entity {

    private boolean triggered;

    public FloorSwitch(int x, int y) {
        super(x, y);
        triggered = false; // Initially not triggered
    }

    public boolean isTriggered() {
        return triggered;
    }

    public void setTriggered(boolean triggered) {
        this.triggered = triggered;
    }

}