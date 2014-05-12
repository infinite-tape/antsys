/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.Timer;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class AntSys extends JPanel
/*     */   implements ActionListener
/*     */ {
/*     */   JPanel mainPane;
/*     */   TrailPanel trailPanel;
/*     */   ToolsPanel toolsPanel;
/*     */   JFileChooser fc;
/*     */   JButton openAntButton;
/*     */   JButton runSimButton;
/*     */   JButton stepButton;
/*     */   JButton randomButton;
/*     */   boolean simRunning;
/*     */   JLabel antFileLabel;
/*     */   JLabel bitsLabel;
/*     */   String trailFileName;
/*     */   String antFileName;
/*     */   Timer timer;
/*     */ 
/*     */   public AntSys()
/*     */     throws IOException
/*     */   {
/*  21 */     this.trailFileName = "muir.txt";
/*  22 */     this.antFileName = "ants.txt";
/*  23 */     this.simRunning = false;
/*     */ 
/*  25 */     this.trailPanel = new TrailPanel(this.trailFileName, this.antFileName);
/*  26 */     this.toolsPanel = new ToolsPanel();
/*  27 */     this.toolsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("AntSys Status"), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
/*     */ 
/*  31 */     JPanel local1 = new JPanel() {
/*     */       public Dimension getPreferredSize() {
/*  33 */         return new Dimension(200, 100);
/*     */       }
/*     */       public Dimension getMinimumSize() {
/*  36 */         return new Dimension(200, 100);
/*     */       }
/*     */       public Dimension getMaximumSize() {
/*  39 */         return new Dimension(200, 100);
/*     */       }
/*     */     };
/*  42 */     JPanel local2 = new JPanel() {
/*     */       public Dimension getPreferredSize() {
/*  44 */         return new Dimension(200, 150);
/*     */       }
/*     */       public Dimension getMinimumSize() {
/*  47 */         return new Dimension(200, 150);
/*     */       }
/*     */       public Dimension getMaximumSize() {
/*  50 */         return new Dimension(200, 150);
/*     */       }
/*     */     };
/*  54 */     this.fc = new JFileChooser();
/*     */ 
/*  56 */     this.openAntButton = new JButton("Load Ant");
/*  57 */     this.openAntButton.addActionListener(this);
/*  58 */     this.openAntButton.setToolTipText("Click to load a new ant.");
/*     */ 
/*  60 */     this.runSimButton = new JButton("Simulate");
/*  61 */     this.runSimButton.addActionListener(this);
/*  62 */     this.runSimButton.setToolTipText("Click to start ant simulation.");
/*     */ 
/*  64 */     this.stepButton = new JButton("One Step");
/*  65 */     this.stepButton.addActionListener(this);
/*  66 */     this.stepButton.setToolTipText("Click to advance one time step.");
/*     */ 
/*  68 */     this.randomButton = new JButton("Randomize");
/*  69 */     this.randomButton.addActionListener(this);
/*  70 */     this.randomButton.setToolTipText("Click to generate a random ant.");
/*     */ 
/*  72 */     local1.add(this.openAntButton);
/*  73 */     local1.add(this.runSimButton);
/*  74 */     local1.add(this.stepButton);
/*  75 */     local1.add(this.randomButton);
/*  76 */     local1.add(this.toolsPanel);
/*     */ 
/*  79 */     this.bitsLabel = new JLabel(this.trailPanel.getHtmlAntBitstring()) {
/*     */       public Dimension getMaximumSize() {
/*  81 */         return new Dimension(50, 175);
/*     */       }
/*     */     };
/*  84 */     this.antFileLabel = new JLabel(this.antFileName);
/*  85 */     local2.add(this.antFileLabel);
/*  86 */     local2.add(this.bitsLabel);
/*     */ 
/*  88 */     this.mainPane = new JPanel();
/*  89 */     this.mainPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
/*  90 */     this.mainPane.setLayout(new BorderLayout());
/*  91 */     this.mainPane.add(this.trailPanel, "West");
/*  92 */     this.mainPane.add(local1, "East");
/*  93 */     this.mainPane.add(local2, "South");
/*     */ 
/*  95 */     this.timer = new Timer(250, this);
/*  96 */     this.timer.setInitialDelay(0);
/*  97 */     this.timer.setCoalesce(true);
/*     */   }
/*     */ 
/*     */   public void startSim() {
/* 101 */     this.timer.start();
/*     */   }
/*     */   public void stopSim() {
/* 104 */     this.timer.stop();
/*     */   }
/*     */   public void resetSim() {
/* 107 */     this.trailPanel.reset(this.trailFileName, this.antFileName);
/* 108 */     this.toolsPanel.reset();
/* 109 */     this.bitsLabel.setText(this.trailPanel.getHtmlAntBitstring());
/* 110 */     this.antFileLabel.setText(this.antFileName);
/* 111 */     startSim();
/*     */   }
/*     */ 
/*     */   public void resetRandomSim() {
/* 115 */     this.trailPanel.randomReset(this.trailFileName);
/* 116 */     this.toolsPanel.reset();
/* 117 */     this.bitsLabel.setText(this.trailPanel.getHtmlAntBitstring());
/* 118 */     this.antFileLabel.setText(this.antFileName);
/* 119 */     startSim();
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent paramActionEvent) {
/* 123 */     if (paramActionEvent.getSource() == this.openAntButton) {
/* 124 */       stopSim();
/* 125 */       int i = this.fc.showOpenDialog(this);
/*     */ 
/* 127 */       File localFile1 = this.fc.getCurrentDirectory();
/* 128 */       System.out.println(localFile1);
/* 129 */       if (i == 0) {
/* 130 */         File localFile2 = this.fc.getSelectedFile();
/* 131 */         this.antFileName = localFile2.getName();
/* 132 */         resetSim();
/* 133 */         this.trailPanel.repaint();
/* 134 */         this.toolsPanel.repaint();
/*     */       } else {
/* 136 */         startSim();
/*     */       }
/* 138 */     } else if (paramActionEvent.getSource() == this.runSimButton) {
/* 139 */       if (this.simRunning) {
/* 140 */         this.simRunning = false;
/* 141 */         this.runSimButton.setText("Simulate");
/* 142 */         this.runSimButton.setToolTipText("Click to start ant simulation.");
/*     */       } else {
/* 144 */         this.simRunning = true;
/* 145 */         this.runSimButton.setText("Stop!");
/* 146 */         this.runSimButton.setToolTipText("Click to stop the ant simulation.");
/*     */       }
/*     */     }
/* 149 */     else if (paramActionEvent.getSource() == this.stepButton) {
/* 150 */       if (!this.simRunning) {
/* 151 */         this.trailPanel.update();
/* 152 */         this.toolsPanel.updateAction(this.trailPanel.getLastAction());
/* 153 */         this.toolsPanel.updateScore(this.trailPanel.getAntScore());
/* 154 */         this.toolsPanel.updateTimeSteps(this.trailPanel.getTimeSteps());
/* 155 */         this.toolsPanel.update();
/* 156 */         this.trailPanel.repaint();
/* 157 */         this.toolsPanel.repaint();
/*     */       }
/*     */     }
/* 160 */     else if (paramActionEvent.getSource() == this.randomButton) {
/* 161 */       this.antFileName = "RANDOM";
/* 162 */       stopSim();
/* 163 */       resetRandomSim();
/* 164 */       this.trailPanel.repaint();
/* 165 */       this.toolsPanel.repaint();
/* 166 */       startSim();
/*     */     }
/* 168 */     else if (this.simRunning) {
/* 169 */       this.trailPanel.update();
/* 170 */       this.toolsPanel.updateAction(this.trailPanel.getLastAction());
/* 171 */       this.toolsPanel.updateScore(this.trailPanel.getAntScore());
/* 172 */       this.toolsPanel.updateTimeSteps(this.trailPanel.getTimeSteps());
/* 173 */       this.toolsPanel.update();
/* 174 */       this.trailPanel.repaint();
/* 175 */       this.toolsPanel.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/*     */     try {
/* 181 */       UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
/*     */     } catch (Exception localException) {
/*     */     }
/* 184 */     AntSys localAntSys = new AntSys();
/* 185 */     JFrame localJFrame = new JFrame("AntSys: Artificial Life Simulator");
/*     */ 
/* 187 */     localJFrame.addWindowListener(new WindowAdapter() {
/*     */       public void windowClosing(WindowEvent paramAnonymousWindowEvent) {
/* 189 */         System.exit(0);
/*     */       }
/*     */     });
/* 192 */     localJFrame.setContentPane(localAntSys.mainPane);
/* 193 */     localJFrame.pack();
/* 194 */     localJFrame.setVisible(true);
/* 195 */     localAntSys.startSim();
/*     */   }
/*     */ }

/* Location:           /Users/jesse/tmp/antsys/antsys/AntSys.jar
 * Qualified Name:     AntSys
 * JD-Core Version:    0.6.2
 */