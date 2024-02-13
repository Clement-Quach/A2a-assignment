public class Herbivore extends Creature{

    private int RGB[] = {0,255,0};

    public int[] getRGB(){
        return RGB;
    }

    public boolean Eat(Creature creature) {
        if (creature instanceof herbivoreEdible) {
            this.daysSinceEating = 0;
            return true;
        }
        return false;
    }

    public int Move(boolean[] moves) {
        for (int i = 0; i < moves.length; i++) {
            //stuff in here
        }
        return 1;
    }

    public boolean reproduce() {
        return false;
    }

    public boolean die() {
        return daysSinceEating > 5;
    }
}
