/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class Istream extends BufferedInputStream
/*     */ {
/*     */   private boolean EndOfFile;
/*     */ 
/*     */   private boolean IsWhite(char paramChar)
/*     */   {
/*  19 */     return paramChar <= ' ';
/*     */   }
/*     */ 
/*     */   public Istream()
/*     */     throws IOException
/*     */   {
/*  25 */     super(System.in);
/*  26 */     this.EndOfFile = false;
/*     */   }
/*     */ 
/*     */   public Istream(String paramString)
/*     */     throws IOException
/*     */   {
/*  32 */     super(new FileInputStream(paramString));
/*  33 */     this.EndOfFile = false;
/*     */   }
/*     */ 
/*     */   public boolean eof()
/*     */   {
/*  39 */     return this.EndOfFile;
/*     */   }
/*     */ 
/*     */   public char getc()
/*     */     throws IOException
/*     */   {
/*  45 */     int i = read();
/*     */ 
/*  47 */     if (i == -1) this.EndOfFile = true;
/*  48 */     return (char)i;
/*     */   }
/*     */ 
/*     */   public char read_char()
/*     */     throws IOException
/*     */   {
/*     */     char c;
/*     */     do
/*     */     {
/*  60 */       int i = read();
/*  61 */       if (i == -1) this.EndOfFile = true;
/*  62 */       c = (char)i;
/*  63 */     }while (IsWhite(c));
/*     */ 
/*  65 */     return c;
/*     */   }
/*     */ 
/*     */   public String read_String()
/*     */     throws IOException
/*     */   {
/*  71 */     StringBuffer localStringBuffer = new StringBuffer();
/*     */     int i;
/*     */     char c;
/*     */     do
/*     */     {
/*  79 */       i = read();
/*  80 */       if (i == -1) this.EndOfFile = true;
/*  81 */       c = (char)i;
/*  82 */       if (!IsWhite(c)) break;  } while (!this.EndOfFile);
/*     */ 
/*  87 */     while ((!IsWhite(c)) && (!this.EndOfFile))
/*     */     {
/*  89 */       localStringBuffer.append(c);
/*  90 */       i = read();
/*  91 */       if (i == -1) this.EndOfFile = true;
/*  92 */       c = (char)i;
/*     */     }
/*     */ 
/*  95 */     String str = localStringBuffer.toString();
/*     */ 
/*  97 */     return str;
/*     */   }
/*     */ 
/*     */   public float read_float()
/*     */     throws IOException
/*     */   {
/* 103 */     String str = read_String();
/* 104 */     Float localFloat = new Float(str);
/*     */ 
/* 106 */     return localFloat.floatValue();
/*     */   }
/*     */ 
/*     */   public int read_int()
/*     */     throws IOException
/*     */   {
/* 112 */     String str = read_String();
/* 113 */     Integer localInteger = new Integer(str);
/*     */ 
/* 115 */     return localInteger.intValue();
/*     */   }
/*     */ }

/* Location:           /Users/jesse/tmp/antsys/antsys/AntSys.jar
 * Qualified Name:     Istream
 * JD-Core Version:    0.6.2
 */