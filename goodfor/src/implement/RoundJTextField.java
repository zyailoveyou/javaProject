package implement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

public class RoundJTextField extends JTextField { 
    private Shape shape;
    int roundsize;
    public RoundJTextField(int size) { 
     super(); 
     roundsize = size;
     setOpaque(false); // As suggested by @AVD in comment. 
    } 
    protected void paintComponent(Graphics g) { 
     g.setColor(getBackground()); 
     g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, roundsize, roundsize); 
     super.paintComponent(g); 
    } 
    protected void paintBorder(Graphics g) { 
     g.setColor(Color.gray); 
     g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, roundsize, roundsize); 
    } 
    public boolean contains(int x, int y) { 
     if (shape == null || !shape.getBounds().equals(getBounds())) { 
      shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, roundsize, roundsize); 
     } 
     return shape.contains(x, y); 
    } 
} 