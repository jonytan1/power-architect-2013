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
import ca.sqlpower.sqlobject.SQLTypePhysicalProperties;
import ca.sqlpower.sqlobject.SQLTypePhysicalPropertiesProvider.BasicSQLType;
import ca.sqlpower.sqlobject.UserDefinedSQLType;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDefinedSQLTypePersisterHelper extends SQLObjectPersisterHelper<UserDefinedSQLType> {

	public UserDefinedSQLType commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		String name = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "name", persistedProperties), String.class);
		Integer myNullability = (Integer) converter.convertToComplexType(findPropertyAndRemove(uuid, "myNullability", persistedProperties), Integer.class);
		Boolean myAutoIncrement = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "myAutoIncrement", persistedProperties), Boolean.class);
		BasicSQLType basicType = (BasicSQLType) converter.convertToComplexType(findPropertyAndRemove(uuid, "basicType", persistedProperties), BasicSQLType.class);
		UserDefinedSQLType upstreamType = (UserDefinedSQLType) converter.convertToComplexType(findPropertyAndRemove(uuid, "upstreamType", persistedProperties), UserDefinedSQLType.class);
		String defaultPhysicalPropertiesUUID = (String) findPropertyAndRemove(uuid, "defaultPhysicalProperties", persistedProperties);
		PersistedSPObject defaultPhysicalPropertiesPSO = findPersistedSPObject(uuid, defaultPhysicalPropertiesUUID, persistedObjects);
		Class<? extends SPObject> classToLoad;
		try {
			classToLoad = (Class<? extends SPObject>) UserDefinedSQLType.class.getClassLoader().loadClass(defaultPhysicalPropertiesPSO.getType());
		} catch (ClassNotFoundException e) {
			throw new SPPersistenceException(null, e);
		}
		SPPersisterHelper<? extends SPObject> defaultPhysicalPropertiesHelper;
		try {
			defaultPhysicalPropertiesHelper = PersisterHelperFinder.findPersister(classToLoad);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		SQLTypePhysicalProperties defaultPhysicalProperties = (SQLTypePhysicalProperties) defaultPhysicalPropertiesHelper.commitObject(defaultPhysicalPropertiesPSO, persistedProperties, persistedObjects, converter);

		UserDefinedSQLType o;
		try {
			o = new UserDefinedSQLType(name, myNullability, myAutoIncrement, basicType, upstreamType, defaultPhysicalProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		UserDefinedSQLType castedObject = (UserDefinedSQLType) o;
		if (propertyName.equals("upstreamType")) {
			castedObject.setUpstreamType((UserDefinedSQLType) converter.convertToComplexType(newValue, UserDefinedSQLType.class));
		} else if (propertyName.equals("myAutoIncrement")) {
			castedObject.setMyAutoIncrement((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else if (propertyName.equals("type")) {
			castedObject.setType((Integer) converter.convertToComplexType(newValue, Integer.class));
		} else if (propertyName.equals("basicType")) {
			castedObject.setBasicType((BasicSQLType) converter.convertToComplexType(newValue, BasicSQLType.class));
		} else if (propertyName.equals("myNullability")) {
			castedObject.setMyNullability((Integer) converter.convertToComplexType(newValue, Integer.class));
		} else if (propertyName.equals("name")) {
			castedObject.setName((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("myDescription")) {
			castedObject.setMyDescription((String) converter.convertToComplexType(newValue, String.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		UserDefinedSQLType castedObject = (UserDefinedSQLType) o;
		if (propertyName.equals("myDescription")) {
			return converter.convertToBasicType(castedObject.getMyDescription());
		} else if (propertyName.equals("type")) {
			return converter.convertToBasicType(castedObject.getType());
		} else if (propertyName.equals("myAutoIncrement")) {
			return converter.convertToBasicType(castedObject.getMyAutoIncrement());
		} else if (propertyName.equals("upstreamType")) {
			return converter.convertToBasicType(castedObject.getUpstreamType());
		} else if (propertyName.equals("myNullability")) {
			return converter.convertToBasicType(castedObject.getMyNullability());
		} else if (propertyName.equals("basicType")) {
			return converter.convertToBasicType(castedObject.getBasicType());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		UserDefinedSQLType castedObject = (UserDefinedSQLType) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.UserDefinedSQLType", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "name", dataType, converter.convertToBasicType(castedObject.getName()));
			preProcessedProperties.add("name");
			dataType = DataType.INTEGER;
			persister.persistProperty(uuid, "myNullability", dataType, converter.convertToBasicType(castedObject.getMyNullability()));
			preProcessedProperties.add("myNullability");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "myAutoIncrement", dataType, converter.convertToBasicType(castedObject.getMyAutoIncrement()));
			preProcessedProperties.add("myAutoIncrement");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "basicType", dataType, converter.convertToBasicType(castedObject.getBasicType()));
			preProcessedProperties.add("basicType");
			dataType = DataType.REFERENCE;
			persister.persistProperty(uuid, "upstreamType", dataType, converter.convertToBasicType(castedObject.getUpstreamType()));
			preProcessedProperties.add("upstreamType");
			dataType = DataType.REFERENCE;
			persister.persistProperty(uuid, "defaultPhysicalProperties", dataType, converter.convertToBasicType(castedObject.getDefaultPhysicalProperties()));
			preProcessedProperties.add("defaultPhysicalProperties");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		UserDefinedSQLType castedObject = (UserDefinedSQLType) o;
		try {
			if (!preProcessedProps.contains("myDescription")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "myDescription", dataType, converter.convertToBasicType(castedObject.getMyDescription()));
				preProcessedProps.add("myDescription");
			}
			if (!preProcessedProps.contains("type")) {
				DataType dataType;
				dataType = DataType.INTEGER;
				persister.persistProperty(uuid, "type", dataType, converter.convertToBasicType(castedObject.getType()));
				preProcessedProps.add("type");
			}
			if (!preProcessedProps.contains("myAutoIncrement")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "myAutoIncrement", dataType, converter.convertToBasicType(castedObject.getMyAutoIncrement()));
				preProcessedProps.add("myAutoIncrement");
			}
			if (!preProcessedProps.contains("upstreamType")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "upstreamType", dataType, converter.convertToBasicType(castedObject.getUpstreamType()));
				preProcessedProps.add("upstreamType");
			}
			if (!preProcessedProps.contains("myNullability")) {
				DataType dataType;
				dataType = DataType.INTEGER;
				persister.persistProperty(uuid, "myNullability", dataType, converter.convertToBasicType(castedObject.getMyNullability()));
				preProcessedProps.add("myNullability");
			}
			if (!preProcessedProps.contains("basicType")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "basicType", dataType, converter.convertToBasicType(castedObject.getBasicType()));
				preProcessedProps.add("basicType");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"upstreamType",
			"myAutoIncrement",
			"type",
			"basicType",
			"myNullability",
			"name",
			"myDescription"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
