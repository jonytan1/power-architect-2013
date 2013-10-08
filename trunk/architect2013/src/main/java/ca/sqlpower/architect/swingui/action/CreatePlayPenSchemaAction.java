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
package ca.sqlpower.architect.swingui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import org.apache.log4j.Logger;

import ca.sqlpower.architect.swingui.ArchitectFrame;
import ca.sqlpower.architect.swingui.ArchitectSwingSessionContext;
import ca.sqlpower.sqlobject.SQLDatabase;
import ca.sqlpower.sqlobject.SQLSchema;
import ca.sqlpower.swingui.SPSUtils;

/**
 * Action for deleting a schema in playPen.
 * @since version 1.0.8
 * @author jianjun.tan
 */
public class CreatePlayPenSchemaAction extends AbstractArchitectAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1889164890940578250L;

	private static final Logger logger = Logger.getLogger(CreatePlayPenSchemaAction.class);
	
	private final static String icon_name = "new_schema";
	
	private boolean success;

	public CreatePlayPenSchemaAction(ArchitectFrame frame) {
        super(frame,
                Messages.getString("CreatePlayPenSchemaAction.name"), //$NON-NLS-1$
                Messages.getString("CreatePlayPenSchemaAction.description"), //$NON-NLS-1$
                icon_name); //$NON-NLS-1$
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_M,0));
	}

	public void actionPerformed(ActionEvent evt) {
	    SQLDatabase db = getSession().getTargetDatabase();
	    db.begin("Create a schema");
        singleActionPerformed(evt);
        if (success) {
            db.commit();
        } else {
            db.rollback("No input for schema name.");
        }
	}
	
	public void singleActionPerformed(ActionEvent evt) {
	
        logger.debug("create playPen schema action detected!"); //$NON-NLS-1$
        logger.debug("ACTION COMMAND: " + evt.getActionCommand()); //$NON-NLS-1$

        success = false;
        SQLDatabase db = getSession().getTargetDatabase();
        String schemaName = SQLDatabase.defaultSchemaName;
        ImageIcon icon = SPSUtils.createIcon(icon_name, Messages.getString("CreatePlayPenSchemaAction.name"), ArchitectSwingSessionContext.ICON_SIZE);
        if ( !db.isPlayPenDatabase() ){
        	JOptionPane.showMessageDialog(frame, 
					Messages.getString("PlayPenSchemaAction.notPlayPenDatabase"), 
					Messages.getString("Action.errorMessageDialogTitle"), 
					JOptionPane.ERROR_MESSAGE);
        	return;
        }
        boolean input = true;
        while( input ){
	        schemaName = (String) JOptionPane.showInputDialog(frame, 
	        		Messages.getString("PlayPenSchemaAction.label"),
	        		Messages.getString("PlayPenSchemaAction.schemaDialogTitle"), 
	        		JOptionPane.PLAIN_MESSAGE,
	        		icon,
	        		null, schemaName);
	        if ( schemaName != null ){
	        	schemaName = schemaName.trim();
		        if (  !"".equals(schemaName) ){
		    		if ( db.getChildByNameIgnoreCase(schemaName, SQLSchema.class) != null ){
		    			JOptionPane.showMessageDialog(frame, 
		    					Messages.getString("PlayPenSchemaAction.doubleName", schemaName ), 
		    					Messages.getString("Action.errorMessageDialogTitle"), 
		    					JOptionPane.ERROR_MESSAGE);
		    		} else {
		    			input = (db.getPlayPenSchema(schemaName) == null);
		    			success = true;
		    		}
		        }
	        } else {
	        	input = false;
	        	success = false;
	        }
        }

	}
	
}
