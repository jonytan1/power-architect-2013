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
import ca.sqlpower.enterprise.client.Grant;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.object.generated.AbstractSPObjectPersisterHelper;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrantPersisterHelper extends AbstractSPObjectPersisterHelper<Grant> {

	public Grant commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		String subject = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "subject", persistedProperties), String.class);
		String type = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "type", persistedProperties), String.class);
		Boolean createPrivilege = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "createPrivilege", persistedProperties), Boolean.class);
		Boolean modifyPrivilege = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "modifyPrivilege", persistedProperties), Boolean.class);
		Boolean deletePrivilege = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "deletePrivilege", persistedProperties), Boolean.class);
		Boolean executePrivilege = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "executePrivilege", persistedProperties), Boolean.class);
		Boolean grantPrivilege = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "grantPrivilege", persistedProperties), Boolean.class);

		Grant o;
		try {
			o = new Grant(subject, type, createPrivilege, modifyPrivilege, deletePrivilege, executePrivilege, grantPrivilege);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		Grant castedObject = (Grant) o;
		if (propertyName.equals("name")) {
			castedObject.setName((String) converter.convertToComplexType(newValue, String.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		Grant castedObject = (Grant) o;
		if (propertyName.equals("modifyPrivilege")) {
			return converter.convertToBasicType(castedObject.isModifyPrivilege());
		} else if (propertyName.equals("type")) {
			return converter.convertToBasicType(castedObject.getType());
		} else if (propertyName.equals("createPrivilege")) {
			return converter.convertToBasicType(castedObject.isCreatePrivilege());
		} else if (propertyName.equals("name")) {
			return converter.convertToBasicType(castedObject.getName());
		} else if (propertyName.equals("subject")) {
			return converter.convertToBasicType(castedObject.getSubject());
		} else if (propertyName.equals("grantPrivilege")) {
			return converter.convertToBasicType(castedObject.isGrantPrivilege());
		} else if (propertyName.equals("deletePrivilege")) {
			return converter.convertToBasicType(castedObject.isDeletePrivilege());
		} else if (propertyName.equals("executePrivilege")) {
			return converter.convertToBasicType(castedObject.isExecutePrivilege());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		Grant castedObject = (Grant) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.enterprise.client.Grant", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "subject", dataType, converter.convertToBasicType(castedObject.getSubject()));
			preProcessedProperties.add("subject");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "type", dataType, converter.convertToBasicType(castedObject.getType()));
			preProcessedProperties.add("type");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "createPrivilege", dataType, converter.convertToBasicType(castedObject.isCreatePrivilege()));
			preProcessedProperties.add("createPrivilege");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "modifyPrivilege", dataType, converter.convertToBasicType(castedObject.isModifyPrivilege()));
			preProcessedProperties.add("modifyPrivilege");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "deletePrivilege", dataType, converter.convertToBasicType(castedObject.isDeletePrivilege()));
			preProcessedProperties.add("deletePrivilege");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "executePrivilege", dataType, converter.convertToBasicType(castedObject.isExecutePrivilege()));
			preProcessedProperties.add("executePrivilege");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "grantPrivilege", dataType, converter.convertToBasicType(castedObject.isGrantPrivilege()));
			preProcessedProperties.add("grantPrivilege");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		Grant castedObject = (Grant) o;
		try {
			if (!preProcessedProps.contains("name")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "name", dataType, converter.convertToBasicType(castedObject.getName()));
				preProcessedProps.add("name");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"name"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
