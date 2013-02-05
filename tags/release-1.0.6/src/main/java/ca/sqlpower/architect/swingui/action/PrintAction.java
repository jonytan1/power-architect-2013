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

import javax.swing.JDialog;

import org.apache.log4j.Logger;

import ca.sqlpower.architect.swingui.ArchitectFrame;
import ca.sqlpower.architect.swingui.PrintPanel;
import ca.sqlpower.swingui.DataEntryPanelBuilder;

public class PrintAction extends AbstractArchitectAction {
	private static final Logger logger = Logger.getLogger(PrintAction.class);

	public PrintAction(ArchitectFrame frame) {
		super(frame, Messages.getString("PrintAction.name"), Messages.getString("PrintAction.description"), "printer"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public void actionPerformed(ActionEvent evt) {
		logger.debug(getValue(SHORT_DESCRIPTION) + ": started"); //$NON-NLS-1$
		
		final PrintPanel printPanel = new PrintPanel(getSession());
		
		final JDialog d = DataEntryPanelBuilder.createDataEntryPanelDialog(
				printPanel, 
				frame,
				Messages.getString("PrintAction.dialogTitle"), Messages.getString("PrintAction.printOption")); //$NON-NLS-1$ //$NON-NLS-2$
		
		d.pack();
		d.setLocationRelativeTo(frame);
		d.setVisible(true);
	}
}
