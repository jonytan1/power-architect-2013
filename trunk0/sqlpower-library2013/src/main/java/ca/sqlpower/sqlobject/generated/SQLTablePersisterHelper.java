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
import ca.sqlpower.sqlobject.SQLIndex;
import ca.sqlpower.sqlobject.SQLObject;
import ca.sqlpower.sqlobject.SQLTable;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLTablePersisterHelper extends SQLObjectPersisterHelper<SQLTable> {

	public SQLTable commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		SQLObject parent = (SQLObject) converter.convertToComplexType(findPropertyAndRemove(uuid, "parent", persistedProperties), SQLObject.class);
		String name = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "name", persistedProperties), String.class);
		String remarks = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "remarks", persistedProperties), String.class);
		String objectType = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "objectType", persistedProperties), String.class);
		Boolean populated = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "populated", persistedProperties), Boolean.class);
		String primaryKeyIndexUUID = (String) findPropertyAndRemove(uuid, "primaryKeyIndex", persistedProperties);
		PersistedSPObject primaryKeyIndexPSO = findPersistedSPObject(uuid, primaryKeyIndexUUID, persistedObjects);
		Class<? extends SPObject> classToLoad;
		try {
			classToLoad = (Class<? extends SPObject>) SQLTable.class.getClassLoader().loadClass(primaryKeyIndexPSO.getType());
		} catch (ClassNotFoundException e) {
			throw new SPPersistenceException(null, e);
		}
		SPPersisterHelper<? extends SPObject> primaryKeyIndexHelper;
		try {
			primaryKeyIndexHelper = PersisterHelperFinder.findPersister(classToLoad);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		SQLIndex primaryKeyIndex = (SQLIndex) primaryKeyIndexHelper.commitObject(primaryKeyIndexPSO, persistedProperties, persistedObjects, converter);
		Boolean columnsPopulated = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "columnsPopulated", persistedProperties), Boolean.class);
		Boolean indicesPopulated = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "indicesPopulated", persistedProperties), Boolean.class);
		Boolean exportedKeysPopulated = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "exportedKeysPopulated", persistedProperties), Boolean.class);
		Boolean importedKeysPopulated = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "importedKeysPopulated", persistedProperties), Boolean.class);

		SQLTable o;
		try {
			o = new SQLTable(parent, name, remarks, objectType, populated, primaryKeyIndex, columnsPopulated, indicesPopulated, exportedKeysPopulated, importedKeysPopulated);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLTable castedObject = (SQLTable) o;
		if (propertyName.equals("remarks")) {
			castedObject.setRemarks((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("objectType")) {
			castedObject.setObjectType((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("parent")) {
			castedObject.setParent((SQLObject) converter.convertToComplexType(newValue, SQLObject.class));
		} else if (propertyName.equals("importedKeysPopulated")) {
			castedObject.setImportedKeysPopulated((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else if (propertyName.equals("exportedKeysPopulated")) {
			castedObject.setExportedKeysPopulated((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else if (propertyName.equals("physicalName")) {
			castedObject.setPhysicalName((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("name")) {
			castedObject.setName((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("columnsPopulated")) {
			castedObject.setColumnsPopulated((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else if (propertyName.equals("indicesPopulated")) {
			castedObject.setIndicesPopulated((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else if (propertyName.equals("populated")) {
			castedObject.setPopulated((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLTable castedObject = (SQLTable) o;
		if (propertyName.equals("indicesPopulated")) {
			return converter.convertToBasicType(castedObject.isIndicesPopulated());
		} else if (propertyName.equals("populated")) {
			return converter.convertToBasicType(castedObject.isPopulated());
		} else if (propertyName.equals("objectType")) {
			return converter.convertToBasicType(castedObject.getObjectType());
		} else if (propertyName.equals("remarks")) {
			return converter.convertToBasicType(castedObject.getRemarks());
		} else if (propertyName.equals("parent")) {
			return converter.convertToBasicType(castedObject.getParent());
		} else if (propertyName.equals("columnsPopulated")) {
			return converter.convertToBasicType(castedObject.isColumnsPopulated());
		} else if (propertyName.equals("importedKeysPopulated")) {
			return converter.convertToBasicType(castedObject.isImportedKeysPopulated());
		} else if (propertyName.equals("exportedKeysPopulated")) {
			return converter.convertToBasicType(castedObject.isExportedKeysPopulated());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLTable castedObject = (SQLTable) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.SQLTable", uuid, index);
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
			persister.persistProperty(uuid, "remarks", dataType, converter.convertToBasicType(castedObject.getRemarks()));
			preProcessedProperties.add("remarks");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "objectType", dataType, converter.convertToBasicType(castedObject.getObjectType()));
			preProcessedProperties.add("objectType");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "populated", dataType, converter.convertToBasicType(castedObject.isPopulated()));
			preProcessedProperties.add("populated");
			dataType = DataType.REFERENCE;
			persister.persistProperty(uuid, "primaryKeyIndex", dataType, converter.convertToBasicType(castedObject.getPrimaryKeyIndex()));
			preProcessedProperties.add("primaryKeyIndex");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "columnsPopulated", dataType, converter.convertToBasicType(castedObject.isColumnsPopulated()));
			preProcessedProperties.add("columnsPopulated");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "indicesPopulated", dataType, converter.convertToBasicType(castedObject.isIndicesPopulated()));
			preProcessedProperties.add("indicesPopulated");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "exportedKeysPopulated", dataType, converter.convertToBasicType(castedObject.isExportedKeysPopulated()));
			preProcessedProperties.add("exportedKeysPopulated");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "importedKeysPopulated", dataType, converter.convertToBasicType(castedObject.isImportedKeysPopulated()));
			preProcessedProperties.add("importedKeysPopulated");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		SQLTable castedObject = (SQLTable) o;
		try {
			if (!preProcessedProps.contains("indicesPopulated")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "indicesPopulated", dataType, converter.convertToBasicType(castedObject.isIndicesPopulated()));
				preProcessedProps.add("indicesPopulated");
			}
			if (!preProcessedProps.contains("populated")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "populated", dataType, converter.convertToBasicType(castedObject.isPopulated()));
				preProcessedProps.add("populated");
			}
			if (!preProcessedProps.contains("objectType")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "objectType", dataType, converter.convertToBasicType(castedObject.getObjectType()));
				preProcessedProps.add("objectType");
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
			if (!preProcessedProps.contains("columnsPopulated")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "columnsPopulated", dataType, converter.convertToBasicType(castedObject.isColumnsPopulated()));
				preProcessedProps.add("columnsPopulated");
			}
			if (!preProcessedProps.contains("importedKeysPopulated")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "importedKeysPopulated", dataType, converter.convertToBasicType(castedObject.isImportedKeysPopulated()));
				preProcessedProps.add("importedKeysPopulated");
			}
			if (!preProcessedProps.contains("exportedKeysPopulated")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "exportedKeysPopulated", dataType, converter.convertToBasicType(castedObject.isExportedKeysPopulated()));
				preProcessedProps.add("exportedKeysPopulated");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"remarks",
			"objectType",
			"parent",
			"importedKeysPopulated",
			"exportedKeysPopulated",
			"physicalName",
			"name",
			"columnsPopulated",
			"indicesPopulated",
			"populated"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
