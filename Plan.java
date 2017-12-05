package AAALife;

public class Plan {
    public static final int MAX_AGE = 5;


    private int age;
    private int energy;
    private int x;
    private int y;
    private boolean alive;

    public Plan(int x, int y) {
        this.x = x;
        this.y = y;
        alive = true;
    }

    public void increaseAge() { age++; }

    public int getAge() {
        return age;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void die() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }



}
