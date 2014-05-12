/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.Toolkit;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class TrailPanel extends JPanel
/*    */ {
/*    */   SingleAntTrail trail;
/*    */   int trailSizeX;
/*    */   int trailSizeY;
/*    */   int squareSizeX;
/*    */   int squareSizeY;
/*    */   Dimension preferredSize;
/*    */   JLabel label;
/*    */   private Image trailImg;
/*    */   private Image notrailImg;
/*    */   private Image trailAntImgN;
/*    */   private Image trailAntImgS;
/*    */   private Image trailAntImgW;
/*    */   private Image trailAntImgE;
/*    */   private Image notrailAntImgN;
/*    */   private Image notrailAntImgS;
/*    */   private Image notrailAntImgW;
/*    */   private Image notrailAntImgE;
/*    */ 
/*    */   public TrailPanel(String paramString1, String paramString2)
/*    */     throws IOException
/*    */   {
/* 16 */     this.trail = new SingleAntTrail(paramString1, paramString2);
/* 17 */     this.trailSizeX = this.trail.getGridX();
/* 18 */     this.trailSizeY = this.trail.getGridY();
/* 19 */     this.squareSizeX = 15;
/* 20 */     this.squareSizeY = 15;
/* 21 */     this.preferredSize = new Dimension(this.trailSizeX * this.squareSizeX, this.trailSizeY * this.squareSizeY);
/*    */ 
/* 23 */     this.notrailImg = Toolkit.getDefaultToolkit().getImage("notrail.jpg");
/* 24 */     this.trailImg = Toolkit.getDefaultToolkit().getImage("trail.jpg");
/*    */ 
/* 26 */     this.trailAntImgE = Toolkit.getDefaultToolkit().getImage("trail-ant.jpg");
/* 27 */     this.trailAntImgN = Toolkit.getDefaultToolkit().getImage("trail-ant-north.jpg");
/* 28 */     this.trailAntImgS = Toolkit.getDefaultToolkit().getImage("trail-ant-south.jpg");
/* 29 */     this.trailAntImgW = Toolkit.getDefaultToolkit().getImage("trail-ant-west.jpg");
/* 30 */     this.notrailAntImgE = Toolkit.getDefaultToolkit().getImage("notrail-ant.jpg");
/* 31 */     this.notrailAntImgN = Toolkit.getDefaultToolkit().getImage("notrail-ant-north.jpg");
/* 32 */     this.notrailAntImgS = Toolkit.getDefaultToolkit().getImage("notrail-ant-south.jpg");
/* 33 */     this.notrailAntImgW = Toolkit.getDefaultToolkit().getImage("notrail-ant-west.jpg");
/*    */   }
/*    */ 
/*    */   public Dimension getPreferredSize()
/*    */   {
/* 39 */     return this.preferredSize;
/*    */   }
/*    */ 
/*    */   public void update() {
/* 43 */     if (this.trail.getTimeSteps() < 200)
/* 44 */       this.trail.timeStepByOne();
/*    */   }
/*    */ 
/*    */   public int getTimeSteps()
/*    */   {
/* 49 */     return this.trail.getTimeSteps();
/*    */   }
/*    */   public int getAntScore() {
/* 52 */     return this.trail.getAntScore();
/*    */   }
/*    */   public String getLastAction() {
/* 55 */     return this.trail.getLastAction();
/*    */   }
/*    */ 
/*    */   public void reset(String paramString1, String paramString2) {
/*    */     try {
/* 60 */       this.trail = new SingleAntTrail(paramString1, paramString2);
/* 61 */       this.trailSizeX = this.trail.getGridX();
/* 62 */       this.trailSizeY = this.trail.getGridY(); } catch (Exception localException) {
/* 63 */       System.out.println(localException);
/*    */     }
/*    */   }
/*    */   public void randomReset(String paramString) {
/*    */     try { this.trail = new SingleAntTrail(paramString);
/* 68 */       this.trailSizeX = this.trail.getGridX();
/* 69 */       this.trailSizeY = this.trail.getGridY(); } catch (Exception localException) {
/* 70 */       System.out.println(localException);
/*    */     }
/*    */   }
/* 73 */   public String getHtmlAntBitstring() { String str1 = this.trail.getAntBitString();
/* 74 */     String str2 = "<html>\n<p>\n";
/* 75 */     for (int i = 0; i < str1.length(); i++) {
/* 76 */       if ((i % 80 == 0) && (i != 0))
/* 77 */         str2 = str2 + "<br>\n";
/* 78 */       str2 = str2 + str1.charAt(i);
/*    */     }
/* 80 */     return str2; }
/*    */ 
/*    */   public void paintComponent(Graphics paramGraphics)
/*    */   {
/* 84 */     super.paintComponent(paramGraphics);
/*    */ 
/* 86 */     for (int i = 0; i < this.trailSizeX; i++)
/* 87 */       for (int j = 0; j < this.trailSizeY; j++) {
/* 88 */         int k = i * this.squareSizeX;
/* 89 */         int m = j * this.squareSizeY;
/* 90 */         paramGraphics.setColor(Color.black);
/* 91 */         paramGraphics.drawRect(k, m, k + this.squareSizeX + 1, m + this.squareSizeY + 1);
/*    */ 
/* 93 */         if (this.trail.getTrailSquareByXY(i, j)) {
/* 94 */           if (this.trail.antAtPos(i, j)) {
/* 95 */             switch (this.trail.getAntDirection()) {
/*    */             case 0:
/* 97 */               paramGraphics.drawImage(this.trailAntImgN, k + 1, m + 1, this.squareSizeX, this.squareSizeY, this);
/* 98 */               break;
/*    */             case 1:
/* 100 */               paramGraphics.drawImage(this.trailAntImgS, k + 1, m + 1, this.squareSizeX, this.squareSizeY, this);
/* 101 */               break;
/*    */             case 2:
/* 103 */               paramGraphics.drawImage(this.trailAntImgW, k + 1, m + 1, this.squareSizeX, this.squareSizeY, this);
/* 104 */               break;
/*    */             case 3:
/* 106 */               paramGraphics.drawImage(this.trailAntImgE, k + 1, m + 1, this.squareSizeX, this.squareSizeY, this);
/*    */             }
/*    */           }
/*    */           else {
/* 110 */             paramGraphics.drawImage(this.trailImg, k + 1, m + 1, this.squareSizeX, this.squareSizeY, this);
/*    */           }
/*    */         }
/* 113 */         else if (this.trail.antAtPos(i, j)) {
/* 114 */           switch (this.trail.getAntDirection()) {
/*    */           case 0:
/* 116 */             paramGraphics.drawImage(this.notrailAntImgN, k + 1, m + 1, this.squareSizeX, this.squareSizeY, this);
/* 117 */             break;
/*    */           case 1:
/* 119 */             paramGraphics.drawImage(this.notrailAntImgS, k + 1, m + 1, this.squareSizeX, this.squareSizeY, this);
/* 120 */             break;
/*    */           case 2:
/* 122 */             paramGraphics.drawImage(this.notrailAntImgW, k + 1, m + 1, this.squareSizeX, this.squareSizeY, this);
/* 123 */             break;
/*    */           case 3:
/* 125 */             paramGraphics.drawImage(this.notrailAntImgE, k + 1, m + 1, this.squareSizeX, this.squareSizeY, this);
/*    */           }
/*    */         }
/*    */         else
/* 129 */           paramGraphics.drawImage(this.notrailImg, k + 1, m + 1, this.squareSizeX, this.squareSizeY, this);
/*    */       }
/*    */   }
/*    */ }

/* Location:           /Users/jesse/tmp/antsys/antsys/AntSys.jar
 * Qualified Name:     TrailPanel
 * JD-Core Version:    0.6.2
 */