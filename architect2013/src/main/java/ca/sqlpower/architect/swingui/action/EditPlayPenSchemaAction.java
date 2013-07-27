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
import javax.swing.tree.TreePath;

import org.apache.log4j.Logger;

import ca.sqlpower.architect.swingui.ArchitectFrame;
import ca.sqlpower.architect.swingui.ArchitectSwingSessionContext;
import ca.sqlpower.architect.swingui.DBTree;
import ca.sqlpower.sqlobject.SQLDatabase;
import ca.sqlpower.sqlobject.SQLObject;
import ca.sqlpower.sqlobject.SQLSchema;
import ca.sqlpower.swingui.SPSUtils;

/**
 * Action for deleting a schema in playPen.
 * @since version 1.0.8
 * @author jianjun.tan
 */
public class EditPlayPenSchemaAction extends AbstractArchitectAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3760755686757296121L;

	private static final Logger logger = Logger.getLogger(EditPlayPenSchemaAction.class);
	
	private final static String icon_name = "edit_schema";
	
	public EditPlayPenSchemaAction(ArchitectFrame frame) {
        super(frame,
                Messages.getString("EditPlayPenSchemaAction.name"), //$NON-NLS-1$
                Messages.getString("EditPlayPenSchemaAction.description"), //$NON-NLS-1$
                icon_name); //$NON-NLS-1$
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_M,0));
	}

	public void actionPerformed(ActionEvent evt) {
        logger.debug("edit a schema action detected!"); //$NON-NLS-1$
        logger.debug("ACTION COMMAND: " + evt.getActionCommand()); //$NON-NLS-1$

        if (evt.getActionCommand().equals(DBTree.ACTION_COMMAND_SRC_DBTREE)){
			TreePath [] selections = getSession().getDBTree().getSelectionPaths();
	        ImageIcon icon = SPSUtils.createIcon(icon_name, Messages.getString("EditPlayPenSchemaAction.name"), ArchitectSwingSessionContext.ICON_SIZE);
			if ( selections.length > 1 ) {
				JOptionPane.showMessageDialog(frame, 
						Messages.getString("EditPlayPenSchemaAction.multipleSchemasSelected"), 
						Messages.getString("Action.errorMessageDialogTitle"), 
						JOptionPane.ERROR_MESSAGE);
			} else if ( selections.length < 1 ){
				JOptionPane.showMessageDialog(frame, 
						Messages.getString("EditPlayPenSchemaAction.noSchemasSelected"), 
						Messages.getString("Action.errorMessageDialogTitle"), 
						JOptionPane.ERROR_MESSAGE);
			} else {
				SQLObject so = (SQLObject) selections[0].getLastPathComponent();
				if ( so instanceof SQLSchema ){
					editSchema( (SQLSchema) so );
				} else {
					JOptionPane.showMessageDialog(frame, 
							Messages.getString("PlayPenSchemaAction.selectedNotSchema"), 
							Messages.getString("Action.errorMessageDialogTitle"), 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	private void editSchema( SQLSchema schema ){
        SQLDatabase db = getSession().getTargetDatabase();
        String schemaName = schema.getName();
        ImageIcon icon = SPSUtils.createIcon(icon_name, Messages.getString("EditPlayPenSchemaAction.name"), ArchitectSwingSessionContext.ICON_SIZE);
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
	        		Messages.getString("Action.schemaDialogTitle"), 
	        		JOptionPane.PLAIN_MESSAGE,
	        		icon,
	        		null, schemaName);
	        if ( schemaName != null ){
	        	schemaName = schemaName.trim();
		        if (  !"".equals(schemaName) ){
		        	SQLSchema newSchema = db.getChildByNameIgnoreCase(schemaName, SQLSchema.class);
		    		if ( newSchema != null ){
		    			if ( newSchema != schema ){
			    			JOptionPane.showMessageDialog(frame, 
			    					Messages.getString("PlayPenSchemaAction.doubleName", schemaName ), 
			    					Messages.getString("Action.errorMessageDialogTitle"), 
			    					JOptionPane.ERROR_MESSAGE);
		    			} else {
		    				input = false;
		    			}
		    		} else {
		    			schema.setName(schemaName);
		    			schema.setLogicalName(schemaName);
		    			input = ( db.getPlayPenSchema(schemaName) == null );
		    		}
		        }
	        } else {
	        	input = false;
	        }
        }		
	}
}
