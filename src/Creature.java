abstract class Creature {

    protected int daysSinceEating;
    protected int aliveFor;
    public abstract boolean Eat(Creature creature);

    public abstract int Move(boolean[] moves);

    public abstract boolean reproduce();

    public abstract boolean die();
}
