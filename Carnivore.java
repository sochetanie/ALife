package AAALife;

public class Carnivore {
    public static final int MAX_ENERGY = 100;
    public static final int MAX_AGE = 100;


    private int[] observedLocations;
    private int energy;
    private int age;
    private int x;
    private int y;
    private boolean alive;

    public Carnivore(int x, int y) {
        this.x = x;
        this.y = y;
        energy = MAX_ENERGY/2;
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

    public void die() {
        alive = false;
    }

    public void observe(int[] locations) {
        observedLocations = locations;
    }

    public void act() {
        eat();
        move();
    }
}
