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
import ca.sqlpower.sqlobject.SQLCheckConstraint;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLCheckConstraintPersisterHelper extends SQLObjectPersisterHelper<SQLCheckConstraint> {

	public SQLCheckConstraint commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		String name = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "name", persistedProperties), String.class);
		String constraint = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "constraint", persistedProperties), String.class);

		SQLCheckConstraint o;
		try {
			o = new SQLCheckConstraint(name, constraint);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLCheckConstraint castedObject = (SQLCheckConstraint) o;
		if (propertyName.equals("parent")) {
			castedObject.setParent((SPObject) converter.convertToComplexType(newValue, SPObject.class));
		} else if (propertyName.equals("constraint")) {
			castedObject.setConstraint((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("name")) {
			castedObject.setName((String) converter.convertToComplexType(newValue, String.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLCheckConstraint castedObject = (SQLCheckConstraint) o;
		if (propertyName.equals("constraint")) {
			return converter.convertToBasicType(castedObject.getConstraint());
		} else if (propertyName.equals("parent")) {
			return converter.convertToBasicType(castedObject.getParent());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLCheckConstraint castedObject = (SQLCheckConstraint) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.SQLCheckConstraint", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "name", dataType, converter.convertToBasicType(castedObject.getName()));
			preProcessedProperties.add("name");
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "constraint", dataType, converter.convertToBasicType(castedObject.getConstraint()));
			preProcessedProperties.add("constraint");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		SQLCheckConstraint castedObject = (SQLCheckConstraint) o;
		try {
			if (!preProcessedProps.contains("constraint")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "constraint", dataType, converter.convertToBasicType(castedObject.getConstraint()));
				preProcessedProps.add("constraint");
			}
			if (!preProcessedProps.contains("parent")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "parent", dataType, converter.convertToBasicType(castedObject.getParent()));
				preProcessedProps.add("parent");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"parent",
			"constraint",
			"name"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
