package entity;

import math.Vector2i;

public abstract class Entity {
    protected String name;
    private Vector2i position;
    private int id;
    private static int GLOBAL_ID = 0;

    public Entity(String name, Vector2i position) {
        this.name = name;
        this.position = position;
        GLOBAL_ID++;
        id = GLOBAL_ID;
    }

    public String toString() {
        return name;
    }

    public Vector2i translate(int dx, int dy) {
        position.translate(dx, dy);

        return position;
    }

    public Vector2i getPosition() {
        return position;
    }

    protected void setPosition(Vector2i vector2i) {
        this.position = vector2i;
    }


}
