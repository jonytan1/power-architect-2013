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
import ca.sqlpower.sql.JDBCDataSource;
import ca.sqlpower.sqlobject.SQLDatabase;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLDatabasePersisterHelper extends SQLObjectPersisterHelper<SQLDatabase> {

	public SQLDatabase commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		JDBCDataSource dataSource = (JDBCDataSource) converter.convertToComplexType(findPropertyAndRemove(uuid, "dataSource", persistedProperties), JDBCDataSource.class);

		SQLDatabase o;
		try {
			o = new SQLDatabase(dataSource);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLDatabase castedObject = (SQLDatabase) o;
		if (propertyName.equals("playPenDatabase")) {
			castedObject.setPlayPenDatabase((Boolean) converter.convertToComplexType(newValue, Boolean.class));
		} else if (propertyName.equals("name")) {
			castedObject.setName((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("dataSource")) {
			castedObject.setDataSource((JDBCDataSource) converter.convertToComplexType(newValue, JDBCDataSource.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLDatabase castedObject = (SQLDatabase) o;
		if (propertyName.equals("dataSource")) {
			return converter.convertToBasicType(castedObject.getDataSource());
		} else if (propertyName.equals("name")) {
			return converter.convertToBasicType(castedObject.getName());
		} else if (propertyName.equals("playPenDatabase")) {
			return converter.convertToBasicType(castedObject.isPlayPenDatabase());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLDatabase castedObject = (SQLDatabase) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.SQLDatabase", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "dataSource", dataType, converter.convertToBasicType(castedObject.getDataSource()));
			preProcessedProperties.add("dataSource");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		SQLDatabase castedObject = (SQLDatabase) o;
		try {
			if (!preProcessedProps.contains("dataSource")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "dataSource", dataType, converter.convertToBasicType(castedObject.getDataSource()));
				preProcessedProps.add("dataSource");
			}
			if (!preProcessedProps.contains("name")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "name", dataType, converter.convertToBasicType(castedObject.getName()));
				preProcessedProps.add("name");
			}
			if (!preProcessedProps.contains("playPenDatabase")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "playPenDatabase", dataType, converter.convertToBasicType(castedObject.isPlayPenDatabase()));
				preProcessedProps.add("playPenDatabase");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"playPenDatabase",
			"name",
			"dataSource"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
