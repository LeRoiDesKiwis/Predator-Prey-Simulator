package fr.exalow.main.environment;

import fr.exalow.main.environment.area.Cell;
import fr.exalow.main.environment.area.Point;
import fr.exalow.main.manager.EntityManager;

public class World {

    private EntityManager manager = new EntityManager();

    private Cell[][] map;
    private int borderX;
    private int borderY;

    public World(int x, int y) {
        this.map = new Cell[x][y];
    }

    public void initialize() {

    }

    public int getBorderX() {
        return borderX;
    }

    public int getBorderY() {
        return borderY;
    }

    public Cell getCell(Point location) {
        return map[location.getX()][location.getY()];
    }

    public Cell[][] getMap() {
        return map;
    }

    public EntityManager getEntityManager() {
        return manager;
    }
}
