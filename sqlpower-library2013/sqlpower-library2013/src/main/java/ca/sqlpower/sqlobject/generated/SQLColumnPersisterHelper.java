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
import ca.sqlpower.dao.helper.PersisterHelperFinder;
import ca.sqlpower.dao.helper.SPPersisterHelper;
import ca.sqlpower.dao.session.SessionPersisterSuperConverter;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.sqlobject.SQLColumn;
import ca.sqlpower.sqlobject.SQLTable;
import ca.sqlpower.sqlobject.UserDefinedSQLType;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLColumnPersisterHelper extends SQLObjectPersisterHelper<SQLColumn> {

	public SQLColumn commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		SQLTable parent = (SQLTable) converter.convertToComplexType(findPropertyAndRemove(uuid, "parent", persistedProperties), SQLTable.class);
		String name = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "name", persistedProperties), String.class);
		String sourceDataTypeName = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "sourceDataTypeName", persistedProperties), String.class);
		String remarks = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "remarks", persistedProperties), String.class);
		String userDefinedSQLTypeUUID = (String) findPropertyAndRemove(uuid, "userDefinedSQLType", persistedProperties);
		PersistedSPObject userDefinedSQLTypePSO = findPersistedSPObject(uuid, userDefinedSQLTypeUUID, persistedObjects);
		Class<? extends SPObject> classToLoad;
		try {
			classToLoad = (Class<? extends SPObject>) SQLColumn.class.getClassLoader().loadClass(userDefinedSQLTypePSO.getType());
		} catch (ClassNotFoundException e) {
			throw new SPPersistenceException(null, e);
		}
		SPPersisterHelper<? extends SPObject> userDefinedSQLTypeHelper;
		try {
			userDefinedSQLTypeHelper = PersisterHelperFinder.findPersister(classToLoad);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		UserDefinedSQLType userDefinedSQLType = (UserDefinedSQLType) userDefinedSQLTypeHelper.commitObject(userDefinedSQLTypePSO, persistedProperties, persistedObjects, converter);

		SQLColumn o;
		try {
			o = new SQLColumn(parent, name, sourceDataTypeName, remarks, userDefinedSQLType);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLColumn castedObject = (SQLColumn) o;
		if (propertyName.equals("remarks")) {
			castedObject.setRemarks((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("platform")) {
			castedObject.setPlatform((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("etlNotes")) {
			castedObject.setEtlNotes((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("parent")) {
			castedObject.setParent((SQLTable) converter.convertToComplexType(newValue, SQLTable.class));
		} else if (propertyName.equals("etlTransformationLogic")) {
			castedObject.setEtlTransformationLogic((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("etlAuditable")) {
			castedObject.setEtlAuditable((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else if (propertyName.equals("sourceColumn")) {
			castedObject.setSourceColumn((SQLColumn) converter.convertToComplexType(newValue, SQLColumn.class));
		} else if (propertyName.equals("etlDefaultValue")) {
			castedObject.setEtlDefaultValue((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("autoIncrementSequenceName")) {
			castedObject.setAutoIncrementSequenceName((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("name")) {
			castedObject.setName((String) converter.convertToComplexType(newValue, String.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLColumn castedObject = (SQLColumn) o;
		if (propertyName.equals("etlNotes")) {
			return converter.convertToBasicType(castedObject.getEtlNotes());
		} else if (propertyName.equals("etlDefaultValue")) {
			return converter.convertToBasicType(castedObject.getEtlDefaultValue());
		} else if (propertyName.equals("etlTransformationLogic")) {
			return converter.convertToBasicType(castedObject.getEtlTransformationLogic());
		} else if (propertyName.equals("remarks")) {
			return converter.convertToBasicType(castedObject.getRemarks());
		} else if (propertyName.equals("parent")) {
			return converter.convertToBasicType(castedObject.getParent());
		} else if (propertyName.equals("sourceColumn")) {
			return converter.convertToBasicType(castedObject.getSourceColumn());
		} else if (propertyName.equals("platform")) {
			return converter.convertToBasicType(castedObject.getPlatform());
		} else if (propertyName.equals("userDefinedSQLType")) {
			return converter.convertToBasicType(castedObject.getUserDefinedSQLType());
		} else if (propertyName.equals("autoIncrementSequenceName")) {
			return converter.convertToBasicType(castedObject.getAutoIncrementSequenceName());
		} else if (propertyName.equals("etlAuditable")) {
			return converter.convertToBasicType(castedObject.getEtlAuditable());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLColumn castedObject = (SQLColumn) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.SQLColumn", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.REFERENCE;
			persister.persistProperty(uuid, "parent", dataType, converter.convertToBasicType(castedObject.getParent()));
			preProcessedProperties.add("parent");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "name", dataType, converter.convertToBasicType(castedObject.getName()));
			preProcessedProperties.add("name");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "sourceDataTypeName", dataType, converter.convertToBasicType(castedObject.getSourceDataTypeName()));
			preProcessedProperties.add("sourceDataTypeName");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "remarks", dataType, converter.convertToBasicType(castedObject.getRemarks()));
			preProcessedProperties.add("remarks");
			dataType = DataType.REFERENCE;
			persister.persistProperty(uuid, "userDefinedSQLType", dataType, converter.convertToBasicType(castedObject.getUserDefinedSQLType()));
			preProcessedProperties.add("userDefinedSQLType");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		SQLColumn castedObject = (SQLColumn) o;
		try {
			if (!preProcessedProps.contains("etlNotes")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "etlNotes", dataType, converter.convertToBasicType(castedObject.getEtlNotes()));
				preProcessedProps.add("etlNotes");
			}
			if (!preProcessedProps.contains("etlDefaultValue")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "etlDefaultValue", dataType, converter.convertToBasicType(castedObject.getEtlDefaultValue()));
				preProcessedProps.add("etlDefaultValue");
			}
			if (!preProcessedProps.contains("etlTransformationLogic")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "etlTransformationLogic", dataType, converter.convertToBasicType(castedObject.getEtlTransformationLogic()));
				preProcessedProps.add("etlTransformationLogic");
			}
			if (!preProcessedProps.contains("remarks")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "remarks", dataType, converter.convertToBasicType(castedObject.getRemarks()));
				preProcessedProps.add("remarks");
			}
			if (!preProcessedProps.contains("parent")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "parent", dataType, converter.convertToBasicType(castedObject.getParent()));
				preProcessedProps.add("parent");
			}
			if (!preProcessedProps.contains("sourceColumn")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "sourceColumn", dataType, converter.convertToBasicType(castedObject.getSourceColumn()));
				preProcessedProps.add("sourceColumn");
			}
			if (!preProcessedProps.contains("platform")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "platform", dataType, converter.convertToBasicType(castedObject.getPlatform()));
				preProcessedProps.add("platform");
			}
			if (!preProcessedProps.contains("autoIncrementSequenceName")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "autoIncrementSequenceName", dataType, converter.convertToBasicType(castedObject.getAutoIncrementSequenceName()));
				preProcessedProps.add("autoIncrementSequenceName");
			}
			if (!preProcessedProps.contains("etlAuditable")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "etlAuditable", dataType, converter.convertToBasicType(castedObject.getEtlAuditable()));
				preProcessedProps.add("etlAuditable");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"remarks",
			"platform",
			"etlNotes",
			"parent",
			"etlTransformationLogic",
			"etlAuditable",
			"sourceColumn",
			"etlDefaultValue",
			"autoIncrementSequenceName",
			"name"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
