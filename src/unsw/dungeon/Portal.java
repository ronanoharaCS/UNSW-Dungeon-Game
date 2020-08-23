package unsw.dungeon;

public class Portal extends Entity {

	private int id;
	private Portal link;

	public Portal(int x, int y) {
		super(x, y);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Portal getLink() {
		return link;
	}

	public void setLink(Portal link) {
		this.link = link;
	}

	public int getDestX() {
		return link.getX();
	}

	public int getDestY() {
		return link.getY();
	}



	@Override
	public boolean collide(Entity entity) {
		Boulder b = new Boulder(0, 0);
		// Boulder cannot collide w/ Portal
		if (entity.getClass() == b.getClass())
			return false;
		else
			return true; // MAY CHANGE IF ENEMY

	}

	@Override
	public void interactWith(Player player) {
		//System.out.println("teleport player");//remove
		int x = getDestX();
		int y = getDestY();
		player.x().set(x);
		player.y().set(y);
	}

	@Override
    public boolean step(Enemy enemy) {
        return false;
    }
	
	

}