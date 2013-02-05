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
import ca.sqlpower.sqlobject.SQLRelationship;
import ca.sqlpower.sqlobject.SQLRelationship.ColumnMapping;
import ca.sqlpower.sqlobject.SQLTable;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumnMappingPersisterHelper extends SQLObjectPersisterHelper<ColumnMapping> {

	public ColumnMapping commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		SQLColumn pkColumn = (SQLColumn) converter.convertToComplexType(findPropertyAndRemove(uuid, "pkColumn", persistedProperties), SQLColumn.class);

		ColumnMapping o;
		try {
			o = new ColumnMapping(pkColumn);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		ColumnMapping castedObject = (ColumnMapping) o;
		if (propertyName.equals("fkColName")) {
			castedObject.setFkColName((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("pkColumn")) {
			castedObject.setPkColumn((SQLColumn) converter.convertToComplexType(newValue, SQLColumn.class));
		} else if (propertyName.equals("parent")) {
			castedObject.setParent((SQLRelationship) converter.convertToComplexType(newValue, SQLRelationship.class));
		} else if (propertyName.equals("fkTable")) {
			castedObject.setFkTable((SQLTable) converter.convertToComplexType(newValue, SQLTable.class));
		} else if (propertyName.equals("fkColumn")) {
			castedObject.setFkColumn((SQLColumn) converter.convertToComplexType(newValue, SQLColumn.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		ColumnMapping castedObject = (ColumnMapping) o;
		if (propertyName.equals("fkColumn")) {
			return converter.convertToBasicType(castedObject.getFkColumn());
		} else if (propertyName.equals("pkColumn")) {
			return converter.convertToBasicType(castedObject.getPkColumn());
		} else if (propertyName.equals("parent")) {
			return converter.convertToBasicType(castedObject.getParent());
		} else if (propertyName.equals("fkTable")) {
			return converter.convertToBasicType(castedObject.getFkTable());
		} else if (propertyName.equals("fkColName")) {
			return converter.convertToBasicType(castedObject.getFkColName());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		ColumnMapping castedObject = (ColumnMapping) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.SQLRelationship$ColumnMapping", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.REFERENCE;
			persister.persistProperty(uuid, "pkColumn", dataType, converter.convertToBasicType(castedObject.getPkColumn()));
			preProcessedProperties.add("pkColumn");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		ColumnMapping castedObject = (ColumnMapping) o;
		try {
			if (!preProcessedProps.contains("fkColumn")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "fkColumn", dataType, converter.convertToBasicType(castedObject.getFkColumn()));
				preProcessedProps.add("fkColumn");
			}
			if (!preProcessedProps.contains("pkColumn")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "pkColumn", dataType, converter.convertToBasicType(castedObject.getPkColumn()));
				preProcessedProps.add("pkColumn");
			}
			if (!preProcessedProps.contains("parent")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "parent", dataType, converter.convertToBasicType(castedObject.getParent()));
				preProcessedProps.add("parent");
			}
			if (!preProcessedProps.contains("fkTable")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "fkTable", dataType, converter.convertToBasicType(castedObject.getFkTable()));
				preProcessedProps.add("fkTable");
			}
			if (!preProcessedProps.contains("fkColName")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "fkColName", dataType, converter.convertToBasicType(castedObject.getFkColName()));
				preProcessedProps.add("fkColName");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"fkColName",
			"pkColumn",
			"parent",
			"fkTable",
			"fkColumn"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
