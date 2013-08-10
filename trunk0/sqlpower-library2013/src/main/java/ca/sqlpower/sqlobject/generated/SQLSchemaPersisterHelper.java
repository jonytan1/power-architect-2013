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
import ca.sqlpower.sqlobject.SQLObject;
import ca.sqlpower.sqlobject.SQLSchema;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLSchemaPersisterHelper extends SQLObjectPersisterHelper<SQLSchema> {

	public SQLSchema commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		SQLObject parent = (SQLObject) converter.convertToComplexType(findPropertyAndRemove(uuid, "parent", persistedProperties), SQLObject.class);
		String name = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "name", persistedProperties), String.class);
		Boolean populated = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "populated", persistedProperties), Boolean.class);

		SQLSchema o;
		try {
			o = new SQLSchema(parent, name, populated);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLSchema castedObject = (SQLSchema) o;
		if (propertyName.equals("parent")) {
			castedObject.setParent((SQLObject) converter.convertToComplexType(newValue, SQLObject.class));
		} else if (propertyName.equals("nativeTerm")) {
			castedObject.setNativeTerm((String) converter.convertToComplexType(newValue, String.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLSchema castedObject = (SQLSchema) o;
		if (propertyName.equals("parent")) {
			return converter.convertToBasicType(castedObject.getParent());
		} else if (propertyName.equals("nativeTerm")) {
			return converter.convertToBasicType(castedObject.getNativeTerm());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLSchema castedObject = (SQLSchema) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.SQLSchema", uuid, index);
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
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "populated", dataType, converter.convertToBasicType(castedObject.isPopulated()));
			preProcessedProperties.add("populated");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		SQLSchema castedObject = (SQLSchema) o;
		try {
			if (!preProcessedProps.contains("parent")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "parent", dataType, converter.convertToBasicType(castedObject.getParent()));
				preProcessedProps.add("parent");
			}
			if (!preProcessedProps.contains("nativeTerm")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "nativeTerm", dataType, converter.convertToBasicType(castedObject.getNativeTerm()));
				preProcessedProps.add("nativeTerm");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"parent",
			"nativeTerm"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
