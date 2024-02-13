public class Cell {
  private Creature creature;
  private int chooseNumber;

  public Cell(int index) {
    addCreature(index);

  }
  
  public int callToMove(){
    return 5;
  }
  
  public boolean callReproduce() {
    return true;
  }
  
  public boolean wantToEat(Creature c) {
    return true;
  }
  
  public void addCreature(Creature c){
    this.creature = c;
  }

  public void addCreature(int index) {
    
    if(index > 80){
    creature = new Plant();
    
    } else if (index > 65){
      creature = new Herbivore();
      
    }
  }

  public Creature getCreature() {
    return this.creature;
  }

  public void clear() {

  }

  public void die() {

  }



}
