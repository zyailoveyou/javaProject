package implement;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

 import java.awt.Color;
 import java.awt.Component;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.Insets;
 import java.awt.RenderingHints;
 
 import javax.swing.border.Border;

 public class RoundBorder implements Border {
    
	private Color color;
    private int arcH = 15;
    private int arcW = 15;

    public RoundBorder() {
         this(Color.gray);
    }

     public RoundBorder(Color color) {
         this.color = color;
    }
 
     public Insets getBorderInsets(Component c) {
 
        // top:可以调节光标与边枉的距离, 间接影响高度
        // left:可以调节光标与边枉的距离
         // bottom:可以调节光标与边枉的距离, 间接影响高度
         // right:可以调节光标与边枉的距离
         return new Insets(5, 10, 5, 15);
     }
 
     public boolean isBorderOpaque() {
         return false;
     }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        //        g.setColor(color);
        //        g.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, arcH, arcW);

      Graphics2D g2d = (Graphics2D) g.create();

         g2d.setColor(color);
         g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         g2d.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, arcH, arcW);
 
         g2d.dispose();
     }
 }