package fr.exalow.main.environment.species;

import fr.exalow.main.entities.Entity;
import fr.exalow.main.environment.World;
import fr.exalow.main.environment.area.Point;

import java.util.Random;

public class Fox implements Entity, Animal {

    private World world;
    private Point location;

    public Fox(World world, Point location) {
        this.world = world;
        this.setLocation(location);
    }

    public Fox(World world) {
        this.world = world;
    }

    @Override
    public void setLocation(Point location) {
        if (location == null) {
            this.world.getCell(new Point(location.getX(), location.getY())).addAnimal(this);
            this.location = location;
            return;
        }
        world.getCell(new Point(this.location.getX(), this.location.getY())).removeAnimal(this);
        world.getCell(new Point(location.getX(), location.getY())).addAnimal(this);
        this.location = location;
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public boolean canReproduceWith(Animal animal) {
        return animal instanceof Fox;
    }

    @Override
    public boolean canEat(Animal animal) {
        return animal instanceof Chicken;
    }

    @Override
    public void eat(Animal animal) {
        this.world.getEntityManager().removeEntity(animal);
    }

    @Override
    public void reproduce() {
        this.world.getEntityManager().addEntity(new Fox(world));
    }

    @Override
    public void move() {

        final Random r = new Random();

        if (location == null) {
            this.world.getEntityManager().addEntity(this);
            this.setLocation(new Point(r.nextInt(world.getBorderX()), r.nextInt(world.getBorderY())));
            return;
        }

        do {

            int xMove = r.nextInt(1);
            int yMove = r.nextInt(1);

            xMove = r.nextBoolean() ? xMove : -xMove;
            yMove = r.nextBoolean() ? yMove : -yMove;

            location = new Point(location.getX() + xMove, location.getY() + yMove);

        } while (location.getX() > world.getBorderX() || location.getY() > world.getBorderY());

        this.setLocation(location);
    }
}
