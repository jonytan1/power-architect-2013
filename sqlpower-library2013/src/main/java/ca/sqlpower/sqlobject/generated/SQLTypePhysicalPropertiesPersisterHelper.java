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
import ca.sqlpower.sqlobject.SQLTypePhysicalProperties;
import ca.sqlpower.sqlobject.SQLTypePhysicalProperties.SQLTypeConstraint;
import ca.sqlpower.sqlobject.SQLTypePhysicalPropertiesProvider.PropertyType;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLTypePhysicalPropertiesPersisterHelper extends SQLObjectPersisterHelper<SQLTypePhysicalProperties> {

	public SQLTypePhysicalProperties commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		String platform = (String) converter.convertToComplexType(findPropertyAndRemove(uuid, "platform", persistedProperties), String.class);

		SQLTypePhysicalProperties o;
		try {
			o = new SQLTypePhysicalProperties(platform);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLTypePhysicalProperties castedObject = (SQLTypePhysicalProperties) o;
		if (propertyName.equals("defaultValue")) {
			castedObject.setDefaultValue((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("scale")) {
			castedObject.setScale((Integer) converter.convertToComplexType(newValue, Integer.class));
		} else if (propertyName.equals("precisionType")) {
			castedObject.setPrecisionType((PropertyType) converter.convertToComplexType(newValue, PropertyType.class));
		} else if (propertyName.equals("precision")) {
			castedObject.setPrecision((Integer) converter.convertToComplexType(newValue, Integer.class));
		} else if (propertyName.equals("constraintType")) {
			castedObject.setConstraintType((SQLTypeConstraint) converter.convertToComplexType(newValue, SQLTypeConstraint.class));
		} else if (propertyName.equals("scaleType")) {
			castedObject.setScaleType((PropertyType) converter.convertToComplexType(newValue, PropertyType.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLTypePhysicalProperties castedObject = (SQLTypePhysicalProperties) o;
		if (propertyName.equals("precision")) {
			return converter.convertToBasicType(castedObject.getPrecision());
		} else if (propertyName.equals("defaultValue")) {
			return converter.convertToBasicType(castedObject.getDefaultValue());
		} else if (propertyName.equals("scale")) {
			return converter.convertToBasicType(castedObject.getScale());
		} else if (propertyName.equals("scaleType")) {
			return converter.convertToBasicType(castedObject.getScaleType());
		} else if (propertyName.equals("precisionType")) {
			return converter.convertToBasicType(castedObject.getPrecisionType());
		} else if (propertyName.equals("constraintType")) {
			return converter.convertToBasicType(castedObject.getConstraintType());
		} else if (propertyName.equals("platform")) {
			return converter.convertToBasicType(castedObject.getPlatform());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLTypePhysicalProperties castedObject = (SQLTypePhysicalProperties) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.SQLTypePhysicalProperties", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.STRING;
			persister.persistProperty(uuid, "platform", dataType, converter.convertToBasicType(castedObject.getPlatform()));
			preProcessedProperties.add("platform");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		SQLTypePhysicalProperties castedObject = (SQLTypePhysicalProperties) o;
		try {
			if (!preProcessedProps.contains("precision")) {
				DataType dataType;
				dataType = DataType.INTEGER;
				persister.persistProperty(uuid, "precision", dataType, converter.convertToBasicType(castedObject.getPrecision()));
				preProcessedProps.add("precision");
			}
			if (!preProcessedProps.contains("defaultValue")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "defaultValue", dataType, converter.convertToBasicType(castedObject.getDefaultValue()));
				preProcessedProps.add("defaultValue");
			}
			if (!preProcessedProps.contains("scale")) {
				DataType dataType;
				dataType = DataType.INTEGER;
				persister.persistProperty(uuid, "scale", dataType, converter.convertToBasicType(castedObject.getScale()));
				preProcessedProps.add("scale");
			}
			if (!preProcessedProps.contains("scaleType")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "scaleType", dataType, converter.convertToBasicType(castedObject.getScaleType()));
				preProcessedProps.add("scaleType");
			}
			if (!preProcessedProps.contains("precisionType")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "precisionType", dataType, converter.convertToBasicType(castedObject.getPrecisionType()));
				preProcessedProps.add("precisionType");
			}
			if (!preProcessedProps.contains("constraintType")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "constraintType", dataType, converter.convertToBasicType(castedObject.getConstraintType()));
				preProcessedProps.add("constraintType");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"defaultValue",
			"scale",
			"precisionType",
			"precision",
			"constraintType",
			"scaleType"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
