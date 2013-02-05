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

package ca.sqlpower.enterprise.client.generated;

import ca.sqlpower.dao.PersistedSPOProperty;
import ca.sqlpower.dao.PersistedSPObject;
import ca.sqlpower.dao.SPPersistenceException;
import ca.sqlpower.dao.SPPersister;
import ca.sqlpower.dao.SPPersister.DataType;
import ca.sqlpower.dao.session.SessionPersisterSuperConverter;
import ca.sqlpower.enterprise.client.User;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.object.generated.AbstractSPObjectPersisterHelper;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserPersisterHelper extends AbstractSPObjectPersisterHelper<User> {

	public User commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		String name = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "name", persistedProperties), String.class);
		String password = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "password", persistedProperties), String.class);

		User o;
		try {
			o = new User(name, password);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		User castedObject = (User) o;
		if (propertyName.equals("email")) {
			castedObject.setEmail((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("fullName")) {
			castedObject.setFullName((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("password")) {
			castedObject.setPassword((String) converter.convertToComplexType(newValue, String.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		User castedObject = (User) o;
		if (propertyName.equals("fullName")) {
			return converter.convertToBasicType(castedObject.getFullName());
		} else if (propertyName.equals("password")) {
			return converter.convertToBasicType(castedObject.getPassword());
		} else if (propertyName.equals("email")) {
			return converter.convertToBasicType(castedObject.getEmail());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		User castedObject = (User) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.enterprise.client.User", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "name", dataType, converter.convertToBasicType(castedObject.getName()));
			preProcessedProperties.add("name");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "password", dataType, converter.convertToBasicType(castedObject.getPassword()));
			preProcessedProperties.add("password");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		User castedObject = (User) o;
		try {
			if (!preProcessedProps.contains("fullName")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "fullName", dataType, converter.convertToBasicType(castedObject.getFullName()));
				preProcessedProps.add("fullName");
			}
			if (!preProcessedProps.contains("password")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "password", dataType, converter.convertToBasicType(castedObject.getPassword()));
				preProcessedProps.add("password");
			}
			if (!preProcessedProps.contains("email")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "email", dataType, converter.convertToBasicType(castedObject.getEmail()));
				preProcessedProps.add("email");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"email",
			"fullName",
			"password"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
