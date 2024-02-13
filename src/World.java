public class World {
  
  private Cell cellArr[][];

  public World(int colNm, int rowNm) {
    cellArr = new Cell[colNm][rowNm];
    for (int y = 0; y < rowNm; y++) {
      for (int x = 0; x < colNm; x++) {

        int speciesChoser = RandomGenerator.nextNumber(100);
        cellArr[x][y] = new Cell(speciesChoser);
      }
    }
  }


  public int[][][] getCellArr(){
    int rgbArray[][][] = new int[cellArr.length][cellArr[0].length][3];
    for(int y = 0; y < cellArr[0].length; y++){
      for(int x = 0; x < cellArr.length; x++){
        if(cellArr[x][y].getCreature() == null){
          rgbArray[x][y][0] = 255;
          rgbArray[x][y][1] = 255;
          rgbArray[x][y][2] = 255;
        } else {
        rgbArray[x][y][0] = cellArr[x][y].getCreature().getRGB()[0];        
        rgbArray[x][y][1] = cellArr[x][y].getCreature().getRGB()[1];
        rgbArray[x][y][2] = cellArr[x][y].getCreature().getRGB()[2];
      }
    }
    }
    return rgbArray;
  }

  public boolean[] spaces(int x, int y) {
    boolean spacesArray[] = { true, true, true, true, true, true, true, true, true };
    return spacesArray;
  }

  public int[] convertCords(int dest) {
    int towards[] = new int[2];
    switch (dest) {
      case (0):
        towards[0] = -1;
        towards[1] = -1;
        break;
      case (1):
        towards[0] = 0;
        towards[1] = -1;
        break;
      case (2):
        towards[0] = 0;
        towards[1] = -1;
        break;
    }
    // continue for all cases from 0-8. have 5 be do nothing.
    return towards;
  }

  public void Day() {
    for (int y = 0; y < cellArr[0].length; y++) {
      for (int x = 0; x < cellArr.length; x++) {
        int desitnation = cellArr[x][y].callToMove();
        int destCov[] = convertCords(desitnation);
        if (cellArr[x][y].wantToEat(cellArr[x + destCov[0]][y + destCov[1]].getCreature())) {
          this.Move(x + destCov[0], y + destCov[1], x, y);
        }
        if (cellArr[x][y].callReproduce()) {
          int repoDest = RandomGenerator.nextNumber(9);
          destCov = convertCords(repoDest);
          createCreature(destCov, x, y);
        }

      }
    }
  }

  public void Move(int x, int y, int fX, int fY) {
    this.cellArr[x][y] = this.cellArr[fX][fY];
  }

  public void createCreature(int dest[], int x, int y) {
    if (this.cellArr[x + dest[0]][y + dest[1]] == null) {
      this.cellArr[x + dest[0]][y + dest[1]].addCreature(this.cellArr[x][y].getCreature());
    }
  }
}
