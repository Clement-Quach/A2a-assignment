public class Plant extends Creature implements herbivoreEdible {

    private boolean isEdible;

    private int RGB[] = {255,255,0};

    public int[] getRGB(){
        return RGB;
    }

    public boolean Eat(Creature creature) {
        return false;
    }

    public int Move(boolean[] moves) {
        return -1;
    }

    public boolean reproduce() {
        return aliveFor > 3;
    }

    public boolean die() {
        return false;
    }

    public boolean isEdible() {
        return isEdible;
    }
}
