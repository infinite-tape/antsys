/*    */ class Square
/*    */ {
/*    */   private boolean trailStatus;
/*    */ 
/*    */   public char getTrailChar()
/*    */   {
/* 60 */     if (this.trailStatus) return '1';
/* 61 */     return '0';
/*    */   }
/*    */ 
/*    */   public boolean getTrailStatus() {
/* 65 */     return this.trailStatus;
/*    */   }
/*    */   public void setTrailStatus(boolean paramBoolean) {
/* 68 */     this.trailStatus = paramBoolean;
/*    */   }
/*    */ 
/*    */   public Square(boolean paramBoolean) {
/* 72 */     if (paramBoolean)
/* 73 */       this.trailStatus = paramBoolean;
/*    */     else
/* 75 */       this.trailStatus = paramBoolean;
/*    */   }
/*    */ }

/* Location:           /Users/jesse/tmp/antsys/antsys/AntSys.jar
 * Qualified Name:     Square
 * JD-Core Version:    0.6.2
 */