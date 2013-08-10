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
import ca.sqlpower.object.generated.SystemSPObjectSnapshotPersisterHelper;
import ca.sqlpower.sqlobject.UserDefinedSQLType;
import ca.sqlpower.sqlobject.UserDefinedSQLTypeSnapshot;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDefinedSQLTypeSnapshotPersisterHelper extends SystemSPObjectSnapshotPersisterHelper<UserDefinedSQLTypeSnapshot> {

	public UserDefinedSQLTypeSnapshot commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		UserDefinedSQLType spObject = (UserDefinedSQLType) converter.convertToComplexType(findPropertyAndRemove(uuid, "spObject", persistedProperties), UserDefinedSQLType.class);
		String originalUUID = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "originalUUID", persistedProperties), String.class);
		Boolean domainSnapshot = (Boolean) converter.convertToComplexType(findPropertyAndRemove(uuid, "domainSnapshot", persistedProperties), Boolean.class);

		UserDefinedSQLTypeSnapshot o;
		try {
			o = new UserDefinedSQLTypeSnapshot(spObject, originalUUID, domainSnapshot);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		UserDefinedSQLTypeSnapshot castedObject = (UserDefinedSQLTypeSnapshot) o;
		if (propertyName.equals("snapshotUseCount")) {
			castedObject.setSnapshotUseCount((Integer) converter.convertToComplexType(newValue, Integer.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		UserDefinedSQLTypeSnapshot castedObject = (UserDefinedSQLTypeSnapshot) o;
		if (propertyName.equals("snapshotUseCount")) {
			return converter.convertToBasicType(castedObject.getSnapshotUseCount());
		} else if (propertyName.equals("sPObject")) {
			return converter.convertToBasicType(castedObject.getSPObject());
		} else if (propertyName.equals("domainSnapshot")) {
			return converter.convertToBasicType(castedObject.isDomainSnapshot());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		UserDefinedSQLTypeSnapshot castedObject = (UserDefinedSQLTypeSnapshot) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.UserDefinedSQLTypeSnapshot", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.REFERENCE;
			persister.persistProperty(uuid, "spObject", dataType, converter.convertToBasicType(castedObject.getSPObject()));
			preProcessedProperties.add("spObject");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "originalUUID", dataType, converter.convertToBasicType(castedObject.getOriginalUUID()));
			preProcessedProperties.add("originalUUID");
			dataType = DataType.BOOLEAN;
			persister.persistProperty(uuid, "domainSnapshot", dataType, converter.convertToBasicType(castedObject.isDomainSnapshot()));
			preProcessedProperties.add("domainSnapshot");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		UserDefinedSQLTypeSnapshot castedObject = (UserDefinedSQLTypeSnapshot) o;
		try {
			if (!preProcessedProps.contains("snapshotUseCount")) {
				DataType dataType;
				dataType = DataType.INTEGER;
				persister.persistProperty(uuid, "snapshotUseCount", dataType, converter.convertToBasicType(castedObject.getSnapshotUseCount()));
				preProcessedProps.add("snapshotUseCount");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"snapshotUseCount"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
