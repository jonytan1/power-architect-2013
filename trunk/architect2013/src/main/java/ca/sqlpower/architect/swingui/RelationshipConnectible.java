package ca.sqlpower.architect.swingui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * The interface that lines of relationship can be connected.<br>
 * 
 * @author jianjun.tan
 *
 */
public interface RelationshipConnectible {

    public Rectangle getBounds();
    
    public Point getLocation();
    
    public int getWidth();
    
    public int getHeight();
    
    public int getX();
    
    public int getY();
    
    public Dimension getSize();
    
    public void setSelected(boolean isSelected, int multiSelectType);
}
