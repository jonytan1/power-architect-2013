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

import ca.sqlpower.dao.SPPersistenceException;
import ca.sqlpower.dao.SPPersister;
import ca.sqlpower.dao.SPPersister.DataType;
import ca.sqlpower.dao.session.SessionPersisterSuperConverter;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.object.generated.AbstractSPObjectPersisterHelper;
import ca.sqlpower.sqlobject.SQLObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SQLObjectPersisterHelper<T extends SQLObject> extends AbstractSPObjectPersisterHelper<T> {

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		T castedObject = (T) o;
		if (propertyName.equals("physicalName")) {
			castedObject.setPhysicalName((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("populated")) {
			castedObject.setPopulated((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		T castedObject = (T) o;
		if (propertyName.equals("physicalName")) {
			return converter.convertToBasicType(castedObject.getPhysicalName());
		} else if (propertyName.equals("populated")) {
			return converter.convertToBasicType(castedObject.isPopulated());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		T castedObject = (T) o;
		try {
			if (!preProcessedProps.contains("physicalName")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "physicalName", dataType, converter.convertToBasicType(castedObject.getPhysicalName()));
				preProcessedProps.add("physicalName");
			}
			if (!preProcessedProps.contains("populated")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "populated", dataType, converter.convertToBasicType(castedObject.isPopulated()));
				preProcessedProps.add("populated");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"physicalName",
			"populated"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
