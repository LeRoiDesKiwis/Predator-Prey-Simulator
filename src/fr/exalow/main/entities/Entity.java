package fr.exalow.main.entities;

import fr.exalow.main.environment.area.Point;

public interface Entity {

    void setLocation(Point location);

    Point getLocation();

}
