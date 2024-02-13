public class Plant extends Creature implements herbivoreEdible {

    private boolean isEdible;

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
