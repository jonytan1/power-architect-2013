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
import ca.sqlpower.sqlobject.SQLIndex;
import ca.sqlpower.sqlobject.SQLTable;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLIndexPersisterHelper extends SQLObjectPersisterHelper<SQLIndex> {

	public SQLIndex commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		String name = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "name", persistedProperties), String.class);
		Boolean unique = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "unique", persistedProperties), Boolean.class);
		String qualifier = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "qualifier", persistedProperties), String.class);
		String type = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "type", persistedProperties), String.class);
		String filterCondition = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "filterCondition", persistedProperties), String.class);

		SQLIndex o;
		try {
			o = new SQLIndex(name, unique, qualifier, type, filterCondition);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLIndex castedObject = (SQLIndex) o;
		if (propertyName.equals("unique")) {
			castedObject.setUnique((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else if (propertyName.equals("parent")) {
			castedObject.setParent((SQLTable) converter.convertToComplexType(newValue, SQLTable.class));
		} else if (propertyName.equals("type")) {
			castedObject.setType((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("filterCondition")) {
			castedObject.setFilterCondition((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("qualifier")) {
			castedObject.setQualifier((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("clustered")) {
			castedObject.setClustered((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLIndex castedObject = (SQLIndex) o;
		if (propertyName.equals("type")) {
			return converter.convertToBasicType(castedObject.getType());
		} else if (propertyName.equals("unique")) {
			return converter.convertToBasicType(castedObject.isUnique());
		} else if (propertyName.equals("filterCondition")) {
			return converter.convertToBasicType(castedObject.getFilterCondition());
		} else if (propertyName.equals("qualifier")) {
			return converter.convertToBasicType(castedObject.getQualifier());
		} else if (propertyName.equals("clustered")) {
			return converter.convertToBasicType(castedObject.isClustered());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLIndex castedObject = (SQLIndex) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.SQLIndex", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "name", dataType, converter.convertToBasicType(castedObject.getName()));
			preProcessedProperties.add("name");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "unique", dataType, converter.convertToBasicType(castedObject.isUnique()));
			preProcessedProperties.add("unique");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "qualifier", dataType, converter.convertToBasicType(castedObject.getQualifier()));
			preProcessedProperties.add("qualifier");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "type", dataType, converter.convertToBasicType(castedObject.getType()));
			preProcessedProperties.add("type");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "filterCondition", dataType, converter.convertToBasicType(castedObject.getFilterCondition()));
			preProcessedProperties.add("filterCondition");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		SQLIndex castedObject = (SQLIndex) o;
		try {
			if (!preProcessedProps.contains("type")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "type", dataType, converter.convertToBasicType(castedObject.getType()));
				preProcessedProps.add("type");
			}
			if (!preProcessedProps.contains("unique")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "unique", dataType, converter.convertToBasicType(castedObject.isUnique()));
				preProcessedProps.add("unique");
			}
			if (!preProcessedProps.contains("filterCondition")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "filterCondition", dataType, converter.convertToBasicType(castedObject.getFilterCondition()));
				preProcessedProps.add("filterCondition");
			}
			if (!preProcessedProps.contains("qualifier")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "qualifier", dataType, converter.convertToBasicType(castedObject.getQualifier()));
				preProcessedProps.add("qualifier");
			}
			if (!preProcessedProps.contains("clustered")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "clustered", dataType, converter.convertToBasicType(castedObject.isClustered()));
				preProcessedProps.add("clustered");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"unique",
			"parent",
			"type",
			"filterCondition",
			"qualifier",
			"clustered"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
