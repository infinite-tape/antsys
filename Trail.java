/*    */ import java.io.IOException;
/*    */ 
/*    */ public class Trail
/*    */ {
/*    */   private Square[] theTrail;
/*    */   protected int gridSize;
/*    */   protected int gridX;
/*    */   protected int gridY;
/*    */ 
/*    */   public void loadTrailFromFile(String paramString)
/*    */     throws IOException
/*    */   {
/*  9 */     Istream localIstream = new Istream(paramString);
/*    */ 
/* 11 */     this.gridX = localIstream.read_int();
/* 12 */     this.gridY = localIstream.read_int();
/* 13 */     this.gridSize = (this.gridX * this.gridY);
/*    */ 
/* 16 */     this.theTrail = new Square[this.gridSize];
/* 17 */     int i = 0;
/* 18 */     while ((!localIstream.eof()) && (i < this.gridSize)) {
/* 19 */       int j = localIstream.read_char();
/*    */ 
/* 21 */       if (j == 48)
/* 22 */         this.theTrail[i] = new Square(false);
/*    */       else {
/* 24 */         this.theTrail[i] = new Square(true);
/*    */       }
/* 26 */       i++;
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getGridX()
/*    */   {
/* 39 */     return this.gridX; } 
/* 40 */   public int getGridY() { return this.gridY; } 
/* 41 */   public int getGridSize() { return this.gridSize; }
/*    */ 
/*    */   public boolean getTrailSquareByXY(int paramInt1, int paramInt2)
/*    */   {
/* 45 */     return this.theTrail[(paramInt1 + paramInt2 * this.gridX)].getTrailStatus();
/*    */   }
/*    */   public void setTrailSquareByXY(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 48 */     this.theTrail[(paramInt1 + paramInt2 * this.gridX)].setTrailStatus(paramBoolean);
/*    */   }
/*    */ 
/*    */   public Trail(String paramString) throws IOException {
/* 52 */     loadTrailFromFile(paramString);
/*    */   }
/*    */ }

/* Location:           /Users/jesse/tmp/antsys/antsys/AntSys.jar
 * Qualified Name:     Trail
 * JD-Core Version:    0.6.2
 */