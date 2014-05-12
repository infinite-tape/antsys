/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class SingleAntTrail extends Trail
/*    */ {
/*    */   private Ant theAnt;
/*    */   private int antScore;
/*    */   private int timeSteps;
/*    */ 
/*    */   SingleAntTrail(String paramString)
/*    */     throws IOException
/*    */   {
/*  9 */     super(paramString);
/* 10 */     this.theAnt = new Ant(this.jdField_gridX_of_type_Int - 1, this.jdField_gridY_of_type_Int - 1);
/* 11 */     this.antScore = 0;
/* 12 */     this.timeSteps = 0;
/*    */   }
/*    */ 
/*    */   SingleAntTrail(String paramString1, String paramString2) throws IOException {
/* 16 */     super(paramString1);
/* 17 */     this.theAnt = new Ant(paramString2, this.jdField_gridX_of_type_Int - 1, this.jdField_gridY_of_type_Int - 1);
/* 18 */     this.antScore = 0;
/* 19 */     this.timeSteps = 0;
/*    */   }
/*    */ 
/*    */   public void timeStepByOne() {
/* 23 */     boolean bool = getTrailSquareByXY(this.theAnt.getSensoryPosX(), this.theAnt.getSensoryPosY());
/*    */ 
/* 25 */     this.theAnt.automaton(bool);
/* 26 */     if (getTrailSquareByXY(getAntPosX(), getAntPosY())) {
/* 27 */       this.antScore += 1;
/* 28 */       setTrailSquareByXY(getAntPosX(), getAntPosY(), false);
/*    */     }
/* 30 */     this.timeSteps += 1;
/*    */   }
/*    */   public int getAntScore() {
/* 33 */     return this.antScore;
/*    */   }
/*    */   public int getTimeSteps() {
/* 36 */     return this.timeSteps;
/*    */   }
/*    */   public int getAntDirection() {
/* 39 */     return this.theAnt.getDirection();
/*    */   }
/*    */   public String getLastAction() {
/* 42 */     return this.theAnt.getLastAction();
/*    */   }
/*    */   public boolean antAtPos(int paramInt1, int paramInt2) {
/* 45 */     if ((getAntPosX() == paramInt1) && (getAntPosY() == paramInt2))
/* 46 */       return true;
/* 47 */     return false;
/*    */   }
/* 49 */   public int getAntPosX() { return this.theAnt.getPosX(); } 
/* 50 */   public int getAntPosY() { return this.theAnt.getPosY(); }
/*    */ 
/*    */   public String getAntBitString() {
/* 53 */     String str = "";
/* 54 */     boolean[] arrayOfBoolean = this.theAnt.getBitstring();
/* 55 */     for (int i = 0; i < arrayOfBoolean.length; i++) {
/* 56 */       if (arrayOfBoolean[i] == 1)
/* 57 */         str = str + "1";
/* 58 */       else str = str + "0";
/*    */     }
/* 60 */     return str;
/*    */   }
/*    */ 
/*    */   public static void main(String[] paramArrayOfString) throws IOException {
/* 64 */     SingleAntTrail localSingleAntTrail = new SingleAntTrail("muir.txt");
/* 65 */     for (int i = 0; i < 200; i++) {
/* 66 */       localSingleAntTrail.timeStepByOne();
/*    */     }
/* 68 */     System.out.println("Ant scores: " + localSingleAntTrail.getAntScore());
/*    */   }
/*    */ }

/* Location:           /Users/jesse/tmp/antsys/antsys/AntSys.jar
 * Qualified Name:     SingleAntTrail
 * JD-Core Version:    0.6.2
 */