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
import ca.sqlpower.architect.swingui.PlayPen;
import ca.sqlpower.object.ObjectDependentException;
import ca.sqlpower.sqlobject.SQLDatabase;
import ca.sqlpower.sqlobject.SQLObject;
import ca.sqlpower.sqlobject.SQLSchema;
import ca.sqlpower.swingui.SPSUtils;

/**
 * Action for deleting schema(s) include their children in playPen.
 * @since version 1.0.8
 * @author jianjun.tan
 */
public class DeletePlayPenSchemaAction extends AbstractArchitectAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -226629687559644967L;
	private static final Logger logger = Logger.getLogger(DeletePlayPenSchemaAction.class);
	private final static String icon_name = "delete";
	
	// The default name of a table when it is initially created.
	// private static final String NEW_TABLE_NAME = "New_Table";

	public DeletePlayPenSchemaAction(ArchitectFrame frame) {
        super(frame,
                Messages.getString("DeletePlayPenSchemaAction.name"), //$NON-NLS-1$
                Messages.getString("DeletePlayPenSchemaAction.description"), //$NON-NLS-1$
                icon_name); //$NON-NLS-1$
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
	}

	public void actionPerformed(ActionEvent evt) {
        logger.debug("delete playPen schema(s) action detected!"); //$NON-NLS-1$
        logger.debug("ACTION COMMAND: " + evt.getActionCommand()); //$NON-NLS-1$

        if (evt.getActionCommand().equals(DBTree.ACTION_COMMAND_SRC_DBTREE)){
			TreePath [] selections = getSession().getDBTree().getSelectionPaths();
	        for ( int i = 0; i < selections.length; i++){
	        	SQLObject so = (SQLObject) selections[i].getLastPathComponent();
	        	if ( so instanceof SQLSchema ) {
	        		SQLObject parent = ( ( SQLSchema ) so).getParent();
	        		if ( parent == null || !( parent instanceof SQLDatabase ) || !( ( SQLDatabase )parent).isPlayPenDatabase() ) {
	                	JOptionPane.showMessageDialog(frame, 
	        					Messages.getString("PlayPenSchemaAction.notPlayPenDatabase"), 
	        					Messages.getString("Action.errorMessageDialogTitle"), 
	        					JOptionPane.ERROR_MESSAGE);
	                	return;
	        		}
	        	} else {
	            	JOptionPane.showMessageDialog(frame, 
	    					Messages.getString("PlayPenSchemaAction.selectedNotSchema"), 
	    					Messages.getString("Action.errorMessageDialogTitle"), 
	    					JOptionPane.ERROR_MESSAGE);
	            	return;
	        	}
	        }
	        PlayPen playPen = getPlaypen();
	        playPen.getContentPane().begin("Delete");
	        playPen.startCompoundEdit("Delete"); 
	        
	        // prevent tree selection during delete
	        playPen.setIgnoreTreeSelection(true);
	        
	        try {
		        for ( int i = 0; i < selections.length; i++){
		        	SQLObject so = (SQLSchema) selections[i].getLastPathComponent();
		        	for ( SQLObject child : so.getChildren() ){
						so.removeChild( child );
		        	}
		        	so.getParent().removeChild(so);
		        }
		        playPen.getContentPane().commit();
	        } catch (IllegalArgumentException e) {
	        	playPen.getContentPane().rollback(e.toString());
			} catch (ObjectDependentException e) {
	        	playPen.getContentPane().rollback(e.toString());
			} finally {
				playPen.endCompoundEdit("Ending multi-select"); //$NON-NLS-1$
				playPen.setIgnoreTreeSelection(false);
			}
		}
	}

}
