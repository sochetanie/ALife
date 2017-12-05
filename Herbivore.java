package AAALife;

public class Herbivore {
    public static final int MAX_ENERGY = 130;
    public static final int MAX_AGE = 25;

    private int[] observedLocations;
    private int energy;
    private int age;
    private int x;
    private int y;
    private boolean alive;

    public Herbivore(int x, int y) {
        this.x = x;
        this.y = y;
        energy = MAX_ENERGY;
        alive = true;
    }

    public void increaseAge() {
        if(age == MAX_AGE) {
            die();
        } else {
            age++;
        }
    }

    public int getAge() {
        return age;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public int increaaseEnergy(int amount) {
        if (energy + amount > MAX_ENERGY) {
            energy = MAX_ENERGY;
        } else {
            this.energy += amount;
        }
        return amount;
    }

    public void decreaseEnergy(int amount) {
        if (energy < amount) {
            die();
        } else {
            this.energy =-energy;
        }
    }

    public void observe(int[] locations) {
        observedLocations = locations;
    }

    public void act() {
        move();
        eat();
    }
}
