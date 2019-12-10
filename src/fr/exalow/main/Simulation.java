package fr.exalow.main;

import fr.exalow.main.environment.World;
import fr.exalow.main.environment.species.Animal;

public class Simulation {

    private World world = new World(10, 10);

    public void start() {
        while (true) {
            for (Animal animal : world.getEntityManager().getEntities()) {
                animal.move();
            }
        }
    }
}
