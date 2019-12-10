package fr.exalow.main.environment.species;

import fr.exalow.main.entities.Entity;
import fr.exalow.main.environment.World;
import fr.exalow.main.environment.area.Point;

public class Chicken implements Entity, Animal {

    private World world;

    public Chicken(World world) {
        this.world = world;
    }

    @Override
    public void setLocation(Point location) {

    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public boolean canReproduceWith(Animal animal) {
        return animal instanceof Chicken;
    }

    @Override
    public boolean canEat(Animal animal) {
        return animal instanceof Viper;
    }

    @Override
    public void eat(Animal animal) {
        if (canEat(animal)) {
            this.world.getEntityManager().removeEntity(animal);
        }
    }

    @Override
    public void reproduce() {
        this.world.getEntityManager().addEntity(new Chicken(world));
    }

    @Override
    public void move() {

    }
}
