public class World {
  
  private Cell cellArr[][];
  public World(int colNm, int rowNm){
    cellArr = new Cell[colNm][rowNm];
    for(int y = 0; y < rowNm; y++){
      for(int x = 0; x < colNm; x++){

        int speciesChoser = RandomGenerator.nextNumber(100);
        cellArr[x][y] = new Cell(speciesChoser);
      }
    }
  }

  public boolean[] spaces(int x, int y){
    boolean spacesArray[] = {true, true, true, true, true, true, true, true, true};
    return spacesArray;
  }

  

}
