/*    */ import java.awt.Dimension;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class ToolsPanel extends JPanel
/*    */ {
/*    */   JLabel infoLabel;
/*    */   int scoreInfo;
/*    */   int timeInfo;
/*    */   String actionInfo;
/*    */ 
/*    */   public ToolsPanel()
/*    */   {
/* 13 */     String str = "<html>\nTime steps: 000<br>\nScore: 000<br>\nJust did: NOOP<br>\n";
/*    */ 
/* 17 */     this.infoLabel = new JLabel(str);
/* 18 */     add(this.infoLabel);
/* 19 */     this.scoreInfo = 0;
/* 20 */     this.timeInfo = 0;
/* 21 */     this.actionInfo = "NOOP";
/*    */   }
/*    */ 
/*    */   public Dimension getMinimumSize() {
/* 25 */     return new Dimension(150, 100);
/*    */   }
/*    */   public Dimension getMaximumSize() {
/* 28 */     return new Dimension(150, 100);
/*    */   }
/*    */   public Dimension getPreferredSize() {
/* 31 */     return new Dimension(150, 100);
/*    */   }
/*    */ 
/*    */   public void update() {
/* 35 */     String str = "<html>\nTime steps: " + this.timeInfo + "<br>\n" + "Score: " + this.scoreInfo + "<br>\n" + "Just did: " + this.actionInfo + "<br>\n";
/*    */ 
/* 39 */     this.infoLabel.setText(str);
/*    */   }
/*    */   public void reset() {
/* 42 */     this.timeInfo = 0;
/* 43 */     this.scoreInfo = 0;
/* 44 */     this.actionInfo = "NOOP";
/* 45 */     String str = "<html>\nTime steps: " + this.timeInfo + "<br>\n" + "Score: " + this.scoreInfo + "<br>\n" + "Just did: " + this.actionInfo + "<br>\n";
/*    */ 
/* 49 */     this.infoLabel.setText(str);
/*    */   }
/*    */   public void updateScore(int paramInt) {
/* 52 */     this.scoreInfo = paramInt;
/*    */   }
/*    */   public void updateTimeSteps(int paramInt) {
/* 55 */     this.timeInfo = paramInt;
/*    */   }
/*    */   public void updateAction(String paramString) {
/* 58 */     this.actionInfo = paramString;
/*    */   }
/*    */ }

/* Location:           /Users/jesse/tmp/antsys/antsys/AntSys.jar
 * Qualified Name:     ToolsPanel
 * JD-Core Version:    0.6.2
 */