package ca.sqlpower.architect.swingui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.beans.PropertyChangeEvent;
import java.util.Iterator;

import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import ca.sqlpower.swingui.SPSUtils;
import ca.sqlpower.swingui.dbtree.DBTreeNodeRender.RenderType;

/**
 * The UI to display component AcrossedSchemaPane.
 * @author jianjun.tan
 *
 */
public class AcrossedSchemaPaneUI extends ContainerPaneUI {

    private static Logger logger = Logger.getLogger(AcrossedSchemaPaneUI.class);
    
    /**
     * 
     */
    private static final long serialVersionUID = -3362267544450328779L;
    
    private static ImageIcon icon = SPSUtils.createIcon("new_schema", "Schema", 16);
    
    /**
     * The AcrossedSchemaPane component that this UI delegate works for.
     */
    private AcrossedSchemaPane acrossedSchemaPane;
    
    /**
     * Dashed and normal strokes for different line styles on tables.
     */
    private static final BasicStroke DASHED_STROKE = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, new float[] {15.0f, 4.0f}, 0.0f);
    private static final BasicStroke NORMAL_STROKE = new BasicStroke(1.0f);

    /**
     * Colour of the text background for selected columns.
     */
    protected final Color selectedColor = new Color(204, 204, 255);

    /**
     * Thickness (in Java2D units) of the surrounding box.
     */
    public static final int BOX_LINE_THICKNESS = 1;
    
    /**
     * Amount of space left between the surrounding box and the text it contains.
     */
    public static final int GAP = 1;
    
    /**
     * Amount of space left between the schema icon and the text of acrossed schema.
     */
    public static final int GAP_SCHEMA = 4;
    
    /**
     * Amount of space left between the last column's row and the buttom of this pane.
     */
    public static final int GAP_BUTTOM = 5;
    
    /**
     * The width and height of the arc for a rounded rectangle table. 
     */
    private static final int ARC_LENGTH = 7;

    public static PlayPenComponentUI createUI(PlayPenComponent c) {
        return new AcrossedSchemaPaneUI();
    }

    @Override
    public void installUI(PlayPenComponent c) {
        acrossedSchemaPane = (AcrossedSchemaPane)c;
        acrossedSchemaPane.addSPListener(this);
    }

    @Override
    public void uninstallUI(PlayPenComponent c) {
        acrossedSchemaPane = (AcrossedSchemaPane)c;
        acrossedSchemaPane.removeSPListener(this);
    }

    @Override
    public boolean contains(Point p) {
        return acrossedSchemaPane.getBounds().contains(p);
    }

    public int getIconHeight() {
        return (icon == null ? 0 : icon.getIconHeight());
    }
    
    @Override
    public void propertyChanged(PropertyChangeEvent evt) {
        /*logger.debug("AcrossedSchemaPaneUI notices change of "+evt.getPropertyName() //$NON-NLS-1$
                +" from "+evt.getOldValue()+" to "+evt.getNewValue()+" on "+evt.getSource()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
       if (evt.getPropertyName().equals("UI")) {
           return; //$NON-NLS-1$
       } else if (evt.getPropertyName().equals("preferredSize")) {
           return; //$NON-NLS-1$
       } else if (evt.getPropertyName().equals("insertionPoint")) {
           return; //$NON-NLS-1$
       //} else if (evt.getPropertyName().equals("model.tableName")) { //$NON-NLS-1$
           // we will get this event again from the model itself
           //return;
       } 
       acrossedSchemaPane.revalidate();*/
    }
    
    @Override
    public void paint(Graphics2D g2) {
        paint(g2, acrossedSchemaPane);
    }
    
    public void paint(Graphics g, AcrossedSchemaPane asp) {
        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();
        
        if (asp.isDashed()) {
            g2.setStroke(DASHED_STROKE);
        } else {
            g2.setStroke(NORMAL_STROKE);
        }
        
        if (logger.isDebugEnabled()) {
            Rectangle clip = g2.getClipBounds();
            if (clip != null) {
                g2.setColor(Color.red);
                clip.width--;
                clip.height--;
                g2.draw(clip);
                g2.setColor(asp.getForegroundColor());
                logger.debug("Clipping region: "+g2.getClip()); //$NON-NLS-1$
            } else {
                logger.debug("Null clipping region"); //$NON-NLS-1$
            }
        }

        //  We don't want to paint inside the insets or borders.
        Insets insets = asp.getInsets();
        
        //builds a little buffer to reduce the clipping problem
        //this only seams to work at a non-zoomed level. This could 
        //use a little work (better fix)
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, asp.getWidth(), asp.getHeight());
        
        g.translate(insets.left, insets.top);

        int width = asp.getWidth() - insets.left - insets.right;
        int height = asp.getHeight() - insets.top - insets.bottom;

        Font font = asp.getFont();
        if (font == null) {
            // This happens when the table exists but has no visible ancestor.
            // Don't ask me why it's being asked to paint under those circumstances!
            logger.error("paint(): Null font in AcrossedSchemaPane: "+asp);
            return;
        }
        FontMetrics metrics = asp.getFontMetrics(font);
        int fontHeight = metrics.getHeight();
        int titleHeight = (icon == null ? fontHeight : Math.max(fontHeight, icon.getIconHeight() + GAP));
        
        int ascent = metrics.getAscent();
        //int maxDescent = metrics.getMaxDescent();
        int y = 0;
        
        g2.setColor(asp.getPlayPen().getBackground());
        g2.fillRect(0, 0, width, height);
        // no need to reset to foreground: next operation always changes the colour

        // highlight title if table is selected
        if (asp.selected == true) {
            g2.setColor(asp.getBackgroundColor().darker());
        } else {
            g2.setColor(asp.getBackgroundColor());
        }
        
        if (asp.isRounded()) {
            g2.fillRoundRect(0, 0, asp.getWidth(), titleHeight, ARC_LENGTH, ARC_LENGTH);
        } else {
            g2.fillRect(0, 0, asp.getWidth(), titleHeight);
        }
        
        // also darken title text if table is selected
        if (asp.selected){
            g2.setColor(asp.getForegroundColor().darker());
        } else {
            g2.setColor(asp.getForegroundColor());
        }

        // print table name
        if (icon != null) {
            g2.drawImage(icon.getImage(), GAP, y + GAP, icon.getIconWidth(), icon.getIconHeight(), null);
            g2.drawString(getTitleString(this.acrossedSchemaPane), icon.getIconWidth() + GAP_SCHEMA, y += ascent);
            y = Math.max(y, icon.getIconHeight() + GAP);
        } else {
            g2.drawString(getTitleString(this.acrossedSchemaPane), GAP, y += ascent);
        }
        
        g2.setColor(Color.BLACK);
        if (fontHeight < 0) {
            throw new IllegalStateException("FontHeight is negative"); //$NON-NLS-1$
        }
        
        y += GAP + BOX_LINE_THICKNESS + asp.getMargin().top;
        
        // print the instead column info for relationships
        Iterator<ItemOfAcrossedSchemaPane> insteadItemIt = acrossedSchemaPane.getItems().iterator();
        Color currentColor = null;
        RenderType type = asp.getRenderType();
        logger.debug("insteadItemIt.hasNext()=" + insteadItemIt.hasNext());
        while (insteadItemIt.hasNext()) {
            ItemOfAcrossedSchemaPane item = insteadItemIt.next();
            currentColor = item.getRelationshipHighlight();
            g2.setColor(currentColor == null ? Color.BLACK : currentColor);
            logger.debug("item getTableSpace=" + item.getTableSpace());
            boolean firstColumn = true;
            for (String colName : item.getColumnsList(type)) {
                String colTitle = (firstColumn ? item.getTableTitle(type) + "." + colName : colName);
                int colX = (firstColumn ? BOX_LINE_THICKNESS+asp.getMargin().left 
                        : BOX_LINE_THICKNESS+item.getTableSpace()+asp.getMargin().left);
                logger.debug("column title=" + colTitle + " at x=" + colX);
                g2.drawString(colTitle, colX, y += fontHeight);
                if (firstColumn){
                    firstColumn = false;
                }
            }
            
        }
        
        // draw box around columns
        g2.setColor(Color.BLACK);
        if (asp.isRounded()) {
            g2.drawRoundRect(0, titleHeight+GAP, width-BOX_LINE_THICKNESS, 
                    height-(titleHeight+GAP+BOX_LINE_THICKNESS), ARC_LENGTH, ARC_LENGTH);
        } else {
            g2.drawRect(0, titleHeight+GAP, width-BOX_LINE_THICKNESS, 
                    height-(titleHeight+GAP+BOX_LINE_THICKNESS));
        }
        
        g2.setStroke(oldStroke);
        g.translate(-insets.left, -insets.top);
    }

    private String getTitleString(AcrossedSchemaPane asp) {
        return asp.getAcrossedSchema().getName();
    }

    @Override
    public void revalidate() {
    }

    @Override
    public Dimension getPreferredSize() {
        return getPreferredSize(this.acrossedSchemaPane);
    }

    private Dimension getPreferredSize(AcrossedSchemaPane asp) {
        int height = 0;
        int width = 0;

        Insets insets = asp.getInsets();
        Font font = asp.getFont();
        if (font == null) {
            logger.error("getPreferredSize(): AcrossedSchemaPane is missing font."); //$NON-NLS-1$
            return null;
        }
        FontRenderContext frc = asp.getFontRenderContext();
        FontMetrics metrics = asp.getFontMetrics(font);
        int fontHeight = metrics.getHeight();
        int titleHeight = (icon == null ? fontHeight : Math.max(fontHeight, icon.getIconHeight() + GAP));
        width = metrics.stringWidth(asp.getAcrossedSchema().getName());
        width = (icon == null ? width : width + icon.getIconWidth() + GAP_SCHEMA)  + GAP;
        width = Math.max(width, asp.getMinimumSize().width);

        int rowCount = 0;
        RenderType type = asp.getRenderType();
        int tableTitleWidth = 0;
        for (ItemOfAcrossedSchemaPane item : asp.getItems()) {
            if (frc == null) {
                tableTitleWidth = metrics.stringWidth(item.getTableTitle(type) + ".");
            } else {
                tableTitleWidth = (int) font.getStringBounds(item.getTableTitle(type) + ".", frc).getWidth();
            }
            item.setTableSpace(tableTitleWidth);
            for (String colName : item.getColumnsList(type)) {
                rowCount ++;
                if (colName == null) colName = "(null!?)"; //$NON-NLS-1$
                if (frc == null) {
                    width = Math.max(width, tableTitleWidth + metrics.stringWidth(colName));
                } else {
                    width = Math.max(width, tableTitleWidth + ((int) font.getStringBounds(colName, frc).getWidth()));
                }
                logger.debug("new width is: " + width); //$NON-NLS-1$
            }
        }
        
        height = insets.top + titleHeight + GAP + GAP_BUTTOM + asp.getMargin().top + rowCount*fontHeight 
                + BOX_LINE_THICKNESS*2 + asp.getMargin().bottom + insets.bottom;
        height = Math.max(height, asp.getMinimumSize().height);
        logger.debug("starting width is: " + width); //$NON-NLS-1$

        width += insets.left + asp.getMargin().left + BOX_LINE_THICKNESS*2 + asp.getMargin().right + insets.right;
        logger.debug("returned height = " + height + "; width = " + width); //$NON-NLS-1$
        return new Dimension(width, height);
    }
    
    @Override
    public Point getPointForModelObject(Object modelObject) {
        return this.acrossedSchemaPane.getLocation();
    }

    @Override
    public int pointToItemIndex(Point p) {
        return ContainerPane.ITEM_INDEX_TITLE;
    }

}
