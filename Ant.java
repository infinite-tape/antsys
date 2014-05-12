/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.LinkedList;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Ant
/*     */ {
/*     */   static final int noop = 0;
/*     */   static final int leftTurn = 1;
/*     */   static final int rightTurn = 2;
/*     */   static final int forward = 3;
/*     */   static final int north = 0;
/*     */   static final int south = 1;
/*     */   static final int west = 2;
/*     */   static final int east = 3;
/*     */   private int currentState;
/*     */   private int currentDirection;
/*     */   private int startState;
/*     */   private int posX;
/*     */   private int posY;
/*     */   private String lastAction;
/*     */   private boolean[] bitstring;
/*     */   private LinkedList delta;
/*     */   private int envBoundsX;
/*     */   private int envBoundsY;
/*     */ 
/*     */   Ant(String paramString, int paramInt1, int paramInt2)
/*     */     throws IOException
/*     */   {
/*  24 */     Istream localIstream = new Istream(paramString);
/*  25 */     this.delta = new LinkedList();
/*  26 */     this.envBoundsX = paramInt1;
/*  27 */     this.envBoundsY = paramInt2;
/*  28 */     this.posX = 0; this.posY = 0;
/*     */ 
/*  30 */     this.bitstring = new boolean[453];
/*  31 */     int i = 0;
/*  32 */     while ((!localIstream.eof()) && (i < 453)) {
/*  33 */       j = localIstream.read_char();
/*  34 */       if (j == 48)
/*  35 */         this.bitstring[i] = false;
/*  36 */       else this.bitstring[i] = true;
/*  37 */       i++;
/*     */     }
/*     */ 
/*  40 */     int j = 0;
/*  41 */     this.startState = chomp_n_bits(j, 5);
/*  42 */     j += 5;
/*  43 */     for (int k = 0; k < 32; k++) {
/*  44 */       int m = chomp_n_bits(j, 5);
/*  45 */       j += 5;
/*  46 */       int n = chomp_n_bits(j, 2);
/*  47 */       j += 2;
/*  48 */       this.delta.add(new stateElement(k, false, m, n));
/*     */ 
/*  50 */       m = chomp_n_bits(j, 5);
/*  51 */       j += 5;
/*  52 */       n = chomp_n_bits(j, 2);
/*  53 */       j += 2;
/*  54 */       this.delta.add(new stateElement(k, true, m, n));
/*     */     }
/*  56 */     this.currentState = this.startState;
/*  57 */     this.currentDirection = 3;
/*     */   }
/*     */ 
/*     */   Ant(int paramInt1, int paramInt2) {
/*  61 */     Random localRandom = new Random();
/*  62 */     this.delta = new LinkedList();
/*  63 */     this.envBoundsX = paramInt1;
/*  64 */     this.envBoundsY = paramInt2;
/*  65 */     this.posX = 0; this.posY = 0;
/*     */ 
/*  67 */     this.bitstring = new boolean[453];
/*  68 */     int i = 0;
/*  69 */     while (i < 453) {
/*  70 */       j = localRandom.nextBoolean();
/*  71 */       if (j != 0)
/*  72 */         this.bitstring[i] = true;
/*  73 */       else this.bitstring[i] = false;
/*  74 */       i++;
/*     */     }
/*     */ 
/*  77 */     int j = 0;
/*  78 */     this.startState = chomp_n_bits(j, 5);
/*     */     int k;
/*  79 */     j += 5;
/*  80 */     for (int m = 0; m < 32; m++) {
/*  81 */       int n = chomp_n_bits(k, 5);
/*  82 */       k += 5;
/*  83 */       int i1 = chomp_n_bits(k, 2);
/*  84 */       k += 2;
/*  85 */       this.delta.add(new stateElement(m, false, n, i1));
/*     */ 
/*  87 */       n = chomp_n_bits(k, 5);
/*  88 */       k += 5;
/*  89 */       i1 = chomp_n_bits(k, 2);
/*  90 */       k += 2;
/*  91 */       this.delta.add(new stateElement(m, true, n, i1));
/*     */     }
/*  93 */     this.currentState = this.startState;
/*  94 */     this.currentDirection = 3;
/*     */   }
/*     */ 
/*     */   public void printDelta() {
/*  98 */     ListIterator localListIterator = this.delta.listIterator();
/*  99 */     while (localListIterator.hasNext()) {
/* 100 */       stateElement localstateElement = (stateElement)localListIterator.next();
/* 101 */       System.out.println("(" + localstateElement.getStateNumber() + ", " + localstateElement.getStateInput() + ") -> " + localstateElement.getNextState() + " >> " + localstateElement.getStateOutput());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void automaton(boolean paramBoolean)
/*     */   {
/* 107 */     ListIterator localListIterator = this.delta.listIterator();
/* 108 */     while (localListIterator.hasNext()) {
/* 109 */       stateElement localstateElement = (stateElement)localListIterator.next();
/* 110 */       int i = localstateElement.getStateNumber();
/* 111 */       boolean bool = localstateElement.getStateInput();
/* 112 */       if ((this.currentState == i) && (paramBoolean == bool))
/*     */       {
/* 114 */         this.currentState = localstateElement.getNextState();
/* 115 */         int j = localstateElement.getStateOutput();
/*     */ 
/* 117 */         switch (j) { case 0:
/* 118 */           this.lastAction = "NOOP"; break;
/*     */         case 2:
/* 119 */           this.lastAction = "RGHT"; antTurnRight(); break;
/*     */         case 1:
/* 120 */           this.lastAction = "LEFT"; antTurnLeft(); break;
/*     */         case 3:
/* 121 */           this.lastAction = "MOVE"; antMoveForward();
/*     */         }
/* 123 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void antTurnRight() {
/* 129 */     switch (this.currentDirection) { case 0:
/* 130 */       this.currentDirection = 3; break;
/*     */     case 1:
/* 131 */       this.currentDirection = 2; break;
/*     */     case 2:
/* 132 */       this.currentDirection = 0; break;
/*     */     case 3:
/* 133 */       this.currentDirection = 1; }
/*     */   }
/*     */ 
/*     */   public void antTurnLeft() {
/* 137 */     switch (this.currentDirection) { case 0:
/* 138 */       this.currentDirection = 2; break;
/*     */     case 1:
/* 139 */       this.currentDirection = 3; break;
/*     */     case 2:
/* 140 */       this.currentDirection = 1; break;
/*     */     case 3:
/* 141 */       this.currentDirection = 0; }
/*     */   }
/*     */ 
/*     */   public void antMoveForward()
/*     */   {
/* 146 */     switch (this.currentDirection) {
/*     */     case 0:
/* 148 */       if (this.posY - 1 >= 0)
/* 149 */         this.posY -= 1;
/*     */       else {
/* 151 */         this.posY = this.envBoundsY;
/*     */       }
/* 153 */       break;
/*     */     case 1:
/* 155 */       if (this.posY + 1 <= this.envBoundsY)
/* 156 */         this.posY += 1;
/*     */       else {
/* 158 */         this.posY = 0;
/*     */       }
/* 160 */       break;
/*     */     case 2:
/* 162 */       if (this.posX - 1 >= 0)
/* 163 */         this.posX -= 1;
/*     */       else {
/* 165 */         this.posX = this.envBoundsX;
/*     */       }
/* 167 */       break;
/*     */     case 3:
/* 169 */       if (this.posX + 1 <= this.envBoundsX)
/* 170 */         this.posX += 1;
/*     */       else
/* 172 */         this.posX = 0;
/*     */       break;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int chomp_n_bits(int paramInt1, int paramInt2)
/*     */   {
/* 179 */     int i = 0; int j = 1; int k = 0;
/* 180 */     for (int m = paramInt1 + (paramInt2 - 1); m >= paramInt1; m--) {
/* 181 */       if (this.bitstring[m] == 1)
/* 182 */         k = 1;
/* 183 */       else k = 0;
/* 184 */       i += k * j;
/* 185 */       j *= 2;
/*     */     }
/* 187 */     return i;
/*     */   }
/*     */ 
/*     */   public int getPosX() {
/* 191 */     return this.posX;
/*     */   }
/*     */   public int getPosY() {
/* 194 */     return this.posY;
/*     */   }
/*     */   public String getLastAction() {
/* 197 */     return this.lastAction;
/*     */   }
/*     */   public boolean[] getBitstring() {
/* 200 */     return this.bitstring;
/*     */   }
/*     */   public int getSensoryPosX() {
/* 203 */     switch (this.currentDirection) {
/*     */     case 2:
/* 205 */       if (this.posX - 1 >= 0) {
/* 206 */         return this.posX - 1;
/*     */       }
/* 208 */       return this.envBoundsX;
/*     */     case 3:
/* 211 */       if (this.posX + 1 <= this.envBoundsX) {
/* 212 */         return this.posX + 1;
/*     */       }
/* 214 */       return 0;
/*     */     case 0:
/*     */     case 1:
/* 218 */       return this.posX;
/*     */     }
/* 220 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getSensoryPosY() {
/* 224 */     switch (this.currentDirection) {
/*     */     case 2:
/*     */     case 3:
/* 227 */       return this.posY;
/*     */     case 0:
/* 229 */       if (this.posY - 1 >= 0) {
/* 230 */         return this.posY - 1;
/*     */       }
/* 232 */       return this.envBoundsY;
/*     */     case 1:
/* 235 */       if (this.posY + 1 <= this.envBoundsY) {
/* 236 */         return this.posY + 1;
/*     */       }
/* 238 */       return 0;
/*     */     }
/*     */ 
/* 241 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getDirection() {
/* 245 */     return this.currentDirection;
/*     */   }
/*     */ 
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/* 249 */     Ant localAnt = new Ant("/home/jesse/src/geneml/ants.txt", 31, 31);
/*     */   }
/*     */ }

/* Location:           /Users/jesse/tmp/antsys/antsys/AntSys.jar
 * Qualified Name:     Ant
 * JD-Core Version:    0.6.2
 */