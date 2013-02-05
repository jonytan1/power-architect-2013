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

package ca.sqlpower.object.generated;

import ca.sqlpower.dao.SPPersistenceException;
import ca.sqlpower.dao.SPPersister;
import ca.sqlpower.dao.SPPersister.DataType;
import ca.sqlpower.dao.helper.AbstractSPPersisterHelper;
import ca.sqlpower.dao.session.SessionPersisterSuperConverter;
import ca.sqlpower.object.AbstractSPObject;
import ca.sqlpower.object.SPObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractSPObjectPersisterHelper<T extends AbstractSPObject> extends AbstractSPPersisterHelper<T> {

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		T castedObject = (T) o;
		if (propertyName.equals("parent")) {
			castedObject.setParent((SPObject) converter.convertToComplexType(newValue, SPObject.class));
		} else if (propertyName.equals("name")) {
			castedObject.setName((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("UUID")) {
			castedObject.setUUID((String) converter.convertToComplexType(newValue, String.class));
		} else {
			throw new SPPersistenceException(castedObject.getUUID(), createSPPersistenceExceptionMessage(castedObject, propertyName));
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		T castedObject = (T) o;
		if (propertyName.equals("parent")) {
			return converter.convertToBasicType(castedObject.getParent());
		} else if (propertyName.equals("name")) {
			return converter.convertToBasicType(castedObject.getName());
		} else if (propertyName.equals("UUID")) {
			return converter.convertToBasicType(castedObject.getUUID());
		} else {
			throw new SPPersistenceException(castedObject.getUUID(), createSPPersistenceExceptionMessage(castedObject, propertyName));
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		T castedObject = (T) o;
		try {
			if (!preProcessedProps.contains("parent")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "parent", dataType, converter.convertToBasicType(castedObject.getParent()));
				preProcessedProps.add("parent");
			}
			if (!preProcessedProps.contains("name")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "name", dataType, converter.convertToBasicType(castedObject.getName()));
				preProcessedProps.add("name");
			}
			if (!preProcessedProps.contains("UUID")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "UUID", dataType, converter.convertToBasicType(castedObject.getUUID()));
				preProcessedProps.add("UUID");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"parent",
			"name",
			"UUID"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		return persistedPropertiesList;
	}

}
