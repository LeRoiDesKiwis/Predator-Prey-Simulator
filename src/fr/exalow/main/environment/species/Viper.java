package fr.exalow.main.environment.species;

import fr.exalow.main.entities.Entity;
import fr.exalow.main.environment.World;
import fr.exalow.main.environment.area.Point;

public class Viper implements Entity, Animal {

    private World world;

    public Viper(World world) {
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
        return animal instanceof Viper;
    }

    @Override
    public boolean canEat(Animal animal) {
        return animal instanceof Fox;
    }

    @Override
    public void eat(Animal animal) {
        if (canEat(animal)) {
            this.world.getEntityManager().removeEntity(animal);
        }
    }

    @Override
    public void reproduce() {
        this.world.getEntityManager().addEntity(new Viper(world));
    }

    @Override
    public void move() {

    }
}
