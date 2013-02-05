/*
 * This is a GENERATED class based on hand made annotations in SPObject classes
 * and should NOT be modified here. If you need to change this class, modify
 * SPAnnotationProcessor instead.
 */

/*
 * Copyright (c) 2010, SQL Power Group Inc.
 *
 * This file is part of SQL Power Library.
 *
 * SQL Power Library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * SQL Power Library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 */

package ca.sqlpower.object.generated;

import ca.sqlpower.dao.SPPersistenceException;
import ca.sqlpower.dao.SPPersister;
import ca.sqlpower.dao.SPPersister.DataType;
import ca.sqlpower.dao.session.SessionPersisterSuperConverter;
import ca.sqlpower.object.HorizontalAlignment;
import ca.sqlpower.object.SPLabel;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.object.VerticalAlignment;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SPLabelPersisterHelper<T extends SPLabel> extends AbstractSPObjectPersisterHelper<T> {

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		T castedObject = (T) o;
		if (propertyName.equals("foregroundColour")) {
			castedObject.setForegroundColour((Color) converter.convertToComplexType(newValue, Color.class));
		} else if (propertyName.equals("padding")) {
			castedObject.setPadding((Dimension) converter.convertToComplexType(newValue, Dimension.class));
		} else if (propertyName.equals("font")) {
			castedObject.setFont((Font) converter.convertToComplexType(newValue, Font.class));
		} else if (propertyName.equals("verticalAlignment")) {
			castedObject.setVerticalAlignment((VerticalAlignment) converter.convertToComplexType(newValue, VerticalAlignment.class));
		} else if (propertyName.equals("text")) {
			castedObject.setText((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("backgroundColour")) {
			castedObject.setBackgroundColour((Color) converter.convertToComplexType(newValue, Color.class));
		} else if (propertyName.equals("horizontalAlignment")) {
			castedObject.setHorizontalAlignment((HorizontalAlignment) converter.convertToComplexType(newValue, HorizontalAlignment.class));
		} else if (propertyName.equals("borderColour")) {
			castedObject.setBorderColour((Color) converter.convertToComplexType(newValue, Color.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		T castedObject = (T) o;
		if (propertyName.equals("text")) {
			return converter.convertToBasicType(castedObject.getText());
		} else if (propertyName.equals("foregroundColour")) {
			return converter.convertToBasicType(castedObject.getForegroundColour());
		} else if (propertyName.equals("padding")) {
			return converter.convertToBasicType(castedObject.getPadding());
		} else if (propertyName.equals("font")) {
			return converter.convertToBasicType(castedObject.getFont());
		} else if (propertyName.equals("verticalAlignment")) {
			return converter.convertToBasicType(castedObject.getVerticalAlignment());
		} else if (propertyName.equals("horizontalAlignment")) {
			return converter.convertToBasicType(castedObject.getHorizontalAlignment());
		} else if (propertyName.equals("borderColour")) {
			return converter.convertToBasicType(castedObject.getBorderColour());
		} else if (propertyName.equals("backgroundColour")) {
			return converter.convertToBasicType(castedObject.getBackgroundColour());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		T castedObject = (T) o;
		try {
			if (!preProcessedProps.contains("text")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "text", dataType, converter.convertToBasicType(castedObject.getText()));
				preProcessedProps.add("text");
			}
			if (!preProcessedProps.contains("foregroundColour")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "foregroundColour", dataType, converter.convertToBasicType(castedObject.getForegroundColour()));
				preProcessedProps.add("foregroundColour");
			}
			if (!preProcessedProps.contains("padding")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "padding", dataType, converter.convertToBasicType(castedObject.getPadding()));
				preProcessedProps.add("padding");
			}
			if (!preProcessedProps.contains("font")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "font", dataType, converter.convertToBasicType(castedObject.getFont()));
				preProcessedProps.add("font");
			}
			if (!preProcessedProps.contains("verticalAlignment")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "verticalAlignment", dataType, converter.convertToBasicType(castedObject.getVerticalAlignment()));
				preProcessedProps.add("verticalAlignment");
			}
			if (!preProcessedProps.contains("horizontalAlignment")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "horizontalAlignment", dataType, converter.convertToBasicType(castedObject.getHorizontalAlignment()));
				preProcessedProps.add("horizontalAlignment");
			}
			if (!preProcessedProps.contains("borderColour")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "borderColour", dataType, converter.convertToBasicType(castedObject.getBorderColour()));
				preProcessedProps.add("borderColour");
			}
			if (!preProcessedProps.contains("backgroundColour")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "backgroundColour", dataType, converter.convertToBasicType(castedObject.getBackgroundColour()));
				preProcessedProps.add("backgroundColour");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"foregroundColour",
			"padding",
			"font",
			"verticalAlignment",
			"text",
			"backgroundColour",
			"horizontalAlignment",
			"borderColour"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
