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

package ca.sqlpower.sqlobject.generated;

import ca.sqlpower.dao.PersistedSPOProperty;
import ca.sqlpower.dao.PersistedSPObject;
import ca.sqlpower.dao.SPPersistenceException;
import ca.sqlpower.dao.SPPersister;
import ca.sqlpower.dao.SPPersister.DataType;
import ca.sqlpower.dao.session.SessionPersisterSuperConverter;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.sqlobject.SQLColumn;
import ca.sqlpower.sqlobject.SQLIndex;
import ca.sqlpower.sqlobject.SQLIndex.AscendDescend;
import ca.sqlpower.sqlobject.SQLIndex.Column;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumnPersisterHelper extends SQLObjectPersisterHelper<Column> {

	public Column commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		String name = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "name", persistedProperties), String.class);
		SQLColumn column = (SQLColumn) converter.convertToComplexType(findPropertyAndRemove(uuid, "column", persistedProperties), SQLColumn.class);
		AscendDescend ascendingOrDescending = (AscendDescend) converter.convertToComplexType(findPropertyAndRemove(uuid, "ascendingOrDescending", persistedProperties), AscendDescend.class);

		Column o;
		try {
			o = new Column(name, column, ascendingOrDescending);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		Column castedObject = (Column) o;
		if (propertyName.equals("descending")) {
			castedObject.setDescending((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else if (propertyName.equals("parent")) {
			castedObject.setParent((SQLIndex) converter.convertToComplexType(newValue, SQLIndex.class));
		} else if (propertyName.equals("ascendingOrDescending")) {
			castedObject.setAscendingOrDescending((AscendDescend) converter.convertToComplexType(newValue, AscendDescend.class));
		} else if (propertyName.equals("ascending")) {
			castedObject.setAscending((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else if (propertyName.equals("column")) {
			castedObject.setColumn((SQLColumn) converter.convertToComplexType(newValue, SQLColumn.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		Column castedObject = (Column) o;
		if (propertyName.equals("parent")) {
			return converter.convertToBasicType(castedObject.getParent());
		} else if (propertyName.equals("column")) {
			return converter.convertToBasicType(castedObject.getColumn());
		} else if (propertyName.equals("ascendingOrDescending")) {
			return converter.convertToBasicType(castedObject.getAscendingOrDescending());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		Column castedObject = (Column) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.SQLIndex$Column", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "name", dataType, converter.convertToBasicType(castedObject.getName()));
			preProcessedProperties.add("name");
			dataType = DataType.REFERENCE;
			persister.persistProperty(uuid, "column", dataType, converter.convertToBasicType(castedObject.getColumn()));
			preProcessedProperties.add("column");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "ascendingOrDescending", dataType, converter.convertToBasicType(castedObject.getAscendingOrDescending()));
			preProcessedProperties.add("ascendingOrDescending");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		Column castedObject = (Column) o;
		try {
			if (!preProcessedProps.contains("parent")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "parent", dataType, converter.convertToBasicType(castedObject.getParent()));
				preProcessedProps.add("parent");
			}
			if (!preProcessedProps.contains("column")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "column", dataType, converter.convertToBasicType(castedObject.getColumn()));
				preProcessedProps.add("column");
			}
			if (!preProcessedProps.contains("ascendingOrDescending")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "ascendingOrDescending", dataType, converter.convertToBasicType(castedObject.getAscendingOrDescending()));
				preProcessedProps.add("ascendingOrDescending");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"descending",
			"parent",
			"ascendingOrDescending",
			"ascending",
			"column"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
