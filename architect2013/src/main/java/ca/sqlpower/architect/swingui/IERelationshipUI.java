/*
 * Copyright (c) 2008, SQL Power Group Inc.
 *
 * This file is part of Power*Architect.
 *
 * Power*Architect is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * Power*Architect is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 */
package ca.sqlpower.architect.swingui;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

import org.apache.log4j.Logger;

import ca.sqlpower.sqlobject.SQLRelationship;

public class IERelationshipUI extends BasicRelationshipUI {
	private static Logger logger = Logger.getLogger(IERelationshipUI.class);

	public static PlayPenComponentUI createUI(PlayPenComponent c) {
		logger.debug("Creating new IERelationshipUI for "+c);
        return new IERelationshipUI();
    }
	
	/**
	 * Paints relationship line terminations based on the IE diagram
	 * language.
	 */
	protected void paintTerminations(Graphics2D g2, Point parent, Point child, int orientation) {
		int pkc = relationship.getModel().getPkCardinality();
		int length = getTerminationLength();
		if ( (orientation & PARENT_FACES_LEFT) != 0) {
			g2.drawLine(parent.x, parent.y, parent.x-length, parent.y);
			if ( (pkc & SQLRelationship.MANY) != 0) {
				g2.drawLine(parent.x - 10, parent.y, parent.x, parent.y + 5);
				g2.drawLine(parent.x - 10, parent.y, parent.x, parent.y - 5);
			}
			if ( (pkc & SQLRelationship.ONE) != 0) {
				g2.drawLine(parent.x - 10, parent.y - 5, parent.x - 10, parent.y + 5);
			}
			if ( (pkc & SQLRelationship.ZERO) != 0) {
				g2.drawOval(parent.x - 16, parent.y - 3, 6, 6);
			}
		} else if ( (orientation & PARENT_FACES_RIGHT) != 0) {
			g2.drawLine(parent.x, parent.y, parent.x+length, parent.y);
			if ( (pkc & SQLRelationship.MANY) != 0) {
				g2.drawLine(parent.x + 10, parent.y, parent.x, parent.y + 5);
				g2.drawLine(parent.x + 10, parent.y, parent.x, parent.y - 5);
			}
			if ( (pkc & SQLRelationship.ONE) != 0) {
				g2.drawLine(parent.x + 10, parent.y - 5, parent.x + 10, parent.y + 5);
			}
			if ( (pkc & SQLRelationship.ZERO) != 0) {
				g2.drawOval(parent.x + 10, parent.y - 3, 6, 6);
			}
		} else if ( (orientation & PARENT_FACES_TOP) != 0) {
			g2.drawLine(parent.x, parent.y, parent.x, parent.y-length);
			if ( (pkc & SQLRelationship.MANY) != 0) {
				g2.drawLine(parent.x - 5, parent.y, parent.x, parent.y - 10);
				g2.drawLine(parent.x + 5, parent.y, parent.x, parent.y - 10);
			}
			if ( (pkc & SQLRelationship.ONE) != 0) {
				g2.drawLine(parent.x - 5, parent.y - 10, parent.x + 5, parent.y - 10);
			}
			if ( (pkc & SQLRelationship.ZERO) != 0) {
				g2.drawOval(parent.x - 3, parent.y - 16, 6, 6);
			}
		} else if ( (orientation & PARENT_FACES_BOTTOM) != 0) {
			g2.drawLine(parent.x, parent.y, parent.x, parent.y+length);
			if ( (pkc & SQLRelationship.MANY) != 0) {
				g2.drawLine(parent.x - 5, parent.y, parent.x, parent.y + 10);
				g2.drawLine(parent.x + 5, parent.y, parent.x, parent.y + 10);
			}
			if ( (pkc & SQLRelationship.ONE) != 0) {
				g2.drawLine(parent.x - 5, parent.y + 10, parent.x + 5, parent.y + 10);
			}
			if ( (pkc & SQLRelationship.ZERO) != 0) {
				g2.drawOval(parent.x - 3, parent.y + 10, 6, 6);
			}
		} else {
			logger.error(String.format(
					"Unknown orientation for parent (orientation=%08x)." +
					"  Not painting termination.", orientation));
		}

		int fkc = relationship.getModel().getFkCardinality();
		if ( (orientation & CHILD_FACES_LEFT) != 0) {
			g2.drawLine(child.x, child.y, child.x-length, child.y);
			if ( (fkc & SQLRelationship.MANY) != 0) {
				g2.drawLine(child.x - 10, child.y, child.x, child.y + 5);
				g2.drawLine(child.x - 10, child.y, child.x, child.y - 5);
			}
			if ( (fkc & SQLRelationship.ONE) != 0) {
				g2.drawLine(child.x - 10, child.y - 5, child.x - 10, child.y + 5);
			}
			if ( (fkc & SQLRelationship.ZERO) != 0) {
				g2.drawOval(child.x - 16, child.y - 3, 6, 6);
			}
		} else if ( (orientation & CHILD_FACES_RIGHT) != 0) {
			g2.drawLine(child.x, child.y, child.x+length, child.y);
			if ( (fkc & SQLRelationship.MANY) != 0) {
				g2.drawLine(child.x + 10, child.y, child.x, child.y + 5);
				g2.drawLine(child.x + 10, child.y, child.x, child.y - 5);
			}
			if ( (fkc & SQLRelationship.ONE) != 0) {
				g2.drawLine(child.x + 10, child.y - 5, child.x + 10, child.y + 5);
			}
			if ( (fkc & SQLRelationship.ZERO) != 0) {
				g2.drawOval(child.x + 10, child.y - 3, 6, 6);
			}
		} else if ( (orientation & CHILD_FACES_TOP) != 0) {
			g2.drawLine(child.x, child.y, child.x, child.y-length);
			if ( (fkc & SQLRelationship.MANY) != 0) {
				g2.drawLine(child.x - 5, child.y, child.x, child.y - 10);
				g2.drawLine(child.x + 5, child.y, child.x, child.y - 10);
			}
			if ( (fkc & SQLRelationship.ONE) != 0) {
				g2.drawLine(child.x - 5, child.y - 10, child.x + 5, child.y - 10);
			}
			if ( (fkc & SQLRelationship.ZERO) != 0) {
				g2.drawOval(child.x - 3, child.y - 16, 6, 6);
			}
		} else if ( (orientation & CHILD_FACES_BOTTOM) != 0) {
			g2.drawLine(child.x, child.y, child.x, child.y+length);
			if ( (fkc & SQLRelationship.MANY) != 0) {
				g2.drawLine(child.x - 5, child.y, child.x, child.y + 10);
				g2.drawLine(child.x + 5, child.y, child.x, child.y + 10);
			}
			if ( (fkc & SQLRelationship.ONE) != 0) {
				g2.drawLine(child.x - 5, child.y + 10, child.x + 5, child.y + 10);
			}
			if ( (fkc & SQLRelationship.ZERO) != 0) {
				g2.drawOval(child.x - 3, child.y + 10, 6, 6);
			}
		} else {
			logger.error(String.format(
					"Unknown orientation for child (orientation=%08x)." +
					"  Not painting termination.", orientation));
		}
	}

	public int getTerminationLength() {
		return 20;
	}

	public int getTerminationWidth() {
		return 10;
	}

	public Stroke getIdentifyingStroke() {
	    return new BasicStroke(getStrokeWidth());
	}

	public Stroke getNonIdentifyingStroke() {
	    return new BasicStroke(
	            getStrokeWidth(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
	            1.0f, new float[] {15.0f, 4.0f}, 0.0f);
	}
}
