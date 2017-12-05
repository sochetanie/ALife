package AAALife;

import java.util.ArrayList;

public class Land {
    private final static int EMPTY = 0;
    private final static int PLANT = 1;
    private final static int HERBIVORE = 2;
    private final static int CARNIVORE = 3;

    private ArrayList<Carnivore> carnivores;
    private ArrayList<Herbivore> herbivores;
    private ArrayList<Plan> plans;
    private int[][] locations;
    private int width = 30;
    private int heigth = 30;

    public Land() {
        carnivores = new ArrayList<>();
        herbivores = new ArrayList<>();
        plans = new ArrayList<>();
        locations = new int[heigth][width];
    }

    public void cycle() {
        for (int i = 0; i < carnivores.size(); i++) {
            int[] around = checkAround(carnivores.get(i).getX(),carnivores.get(i).getY());
            carnivores.get(i).observe(around);

            carnivores.get(i).act();

            replaceHerbivore(carnivores.get(i).getX(),carnivores.get(i).getY());

            carnivores.get(i).reproduce();

            carnivores.get(i).increaseAge();
            if(!carnivores.get(i).isAlive()) {
                carnivores.remove(i);
            }
        }

        for (int i = 0; i < herbivores.size(); i++) {
            int[] around = checkAround(herbivores.get(i).getX(),herbivores.get(i).getY());
            herbivores.get(i).observe(around);
            herbivores.get(i).increaseAge();

            herbivores.get(i).act();

            replacePlant(herbivores.get(i).getX(),herbivores.get(i).getY());

            herbivores.get(i).reproduce();

            if(!herbivores.get(i).isAlive()) {
                herbivores.remove(i);
            }
        }

        for (int i = 0; i < plans.size(); i++) {
            plans.get(i).increaseAge();
            if(!plans.get(i).isAlive()) {
                plans.remove(i);
            }
        }

    }

    private void removeHerbivore(int x, int y) {
        if(locations[x][y] == HERBIVORE) {
            for (int i = 0; i < herbivores.size(); i++) {
                if(herbivores.get(i).getX() == x && herbivores.get(i).getY() == y) {
                    herbivores.remove(i);
                    locations[x][y] = CARNIVORE;
                    break;
                }
            }
        }
    }

    public void replacePlant(int x, int y) {
        removePlant(x,y);
        locations[x][y] = HERBIVORE;
    }

    public void replaceHerbivore(int x, int y) {
        removeHerbivore(x,y);
        locations[x][y] = CARNIVORE;
    }

    private void removePlant(int x, int y) {
        if(locations[x][y] == PLANT) {
            for (int i = 0; i < plans.size(); i++) {
                if(plans.get(i).getX() == x && plans.get(i).getY() == y) {
                    plans.remove(i);
                    locations[x][y] = EMPTY;
                    break;
                }
            }
        }
    }

    public void populatePlants() {
//        need to do something here
    }

    private int[] checkAround(int x, int y) {
        int[] around = new int[]{-1,-1,-1,-1};
        if(y-1 >= 0) {
            around[0] = locations[y-1][x];
        }
        if(x+1 < width) {
            around[x+1] = locations[y][x+1];
        }
        if(y+1 < heigth) {
            around[y+1] = locations[y+1][x];
        }
        if(x-1 >= 0) {
            around[0] = locations[y][x-1];
        }
        return around;
    }


}

