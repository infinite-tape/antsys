/*     */ class stateElement
/*     */ {
/*     */   private int stateNumber;
/*     */   private boolean stateInput;
/*     */   private int nextState;
/*     */   private int stateOutput;
/*     */ 
/*     */   stateElement(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
/*     */   {
/* 261 */     this.stateNumber = paramInt1;
/*     */ 
/* 263 */     if (paramBoolean)
/* 264 */       this.stateInput = true;
/* 265 */     else this.stateInput = false;
/* 266 */     this.nextState = paramInt2;
/* 267 */     this.stateOutput = paramInt3;
/*     */   }
/*     */   public int getStateNumber() {
/* 270 */     return this.stateNumber; } 
/* 271 */   public boolean getStateInput() { return this.stateInput; } 
/* 272 */   public int getNextState() { return this.nextState; } 
/* 273 */   public int getStateOutput() { return this.stateOutput; }
/*     */ 
/*     */ }

/* Location:           /Users/jesse/tmp/antsys/antsys/AntSys.jar
 * Qualified Name:     stateElement
 * JD-Core Version:    0.6.2
 */