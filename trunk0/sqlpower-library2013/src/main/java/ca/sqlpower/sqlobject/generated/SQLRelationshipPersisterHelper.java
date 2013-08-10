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
import ca.sqlpower.sqlobject.SQLObjectException;
import ca.sqlpower.sqlobject.SQLRelationship;
import ca.sqlpower.sqlobject.SQLRelationship.Deferrability;
import ca.sqlpower.sqlobject.SQLRelationship.UpdateDeleteRule;
import ca.sqlpower.sqlobject.SQLTable;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLRelationshipPersisterHelper extends SQLObjectPersisterHelper<SQLRelationship> {

	public SQLRelationship commitObject(PersistedSPObject pso, Multimap<String, PersistedSPOProperty> persistedProperties, List<PersistedSPObject> persistedObjects, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		String uuid = pso.getUUID();
		SQLTable parent = (SQLTable) converter.convertToComplexType(findPropertyAndRemove(uuid, "parent", persistedProperties), SQLTable.class);

		SQLRelationship o;
		try {
			o = new SQLRelationship(parent);
		} catch (Exception e) {
			throw new SPPersistenceException(null, e);
		}
		o.setUUID(uuid);
		pso.setLoaded(true);
		return o;
	}

	public void commitProperty(SPObject o, String propertyName, Object newValue, DataType dataType, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLRelationship castedObject = (SQLRelationship) o;
		if (propertyName.equals("pkCardinality")) {
			castedObject.setPkCardinality((Integer) converter.convertToComplexType(newValue, Integer.class));
		} else if (propertyName.equals("fkCardinality")) {
			castedObject.setFkCardinality((Integer) converter.convertToComplexType(newValue, Integer.class));
		} else if (propertyName.equals("parent")) {
			castedObject.setParent((SQLTable) converter.convertToComplexType(newValue, SQLTable.class));
		} else if (propertyName.equals("textForParentLabel")) {
			castedObject.setTextForParentLabel((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("name")) {
			castedObject.setName((String) converter.convertToComplexType(newValue, String.class));
		} else if (propertyName.equals("deferrability")) {
			castedObject.setDeferrability((Deferrability) converter.convertToComplexType(newValue, Deferrability.class));
		} else if (propertyName.equals("deleteRule")) {
			castedObject.setDeleteRule((UpdateDeleteRule) converter.convertToComplexType(newValue, UpdateDeleteRule.class));
		} else if (propertyName.equals("pkTable")) {
			castedObject.setPkTable((SQLTable) converter.convertToComplexType(newValue, SQLTable.class));
		} else if (propertyName.equals("identifying")) {
			try {
				castedObject.setIdentifying((Boolean) converter.convertToComplexType(newValue, Boolean.class));
			} catch (SQLObjectException e) {
				throw new SPPersistenceException(castedObject.getUUID(), createSPPersistenceExceptionMessage(castedObject, propertyName), e);
			}
		} else if (propertyName.equals("updateRule")) {
			castedObject.setUpdateRule((UpdateDeleteRule) converter.convertToComplexType(newValue, UpdateDeleteRule.class));
		} else if (propertyName.equals("textForChildLabel")) {
			castedObject.setTextForChildLabel((String) converter.convertToComplexType(newValue, String.class));
		} else {
			super.commitProperty(o, propertyName, newValue, dataType, converter);
		}
	}

	public Object findProperty(SPObject o, String propertyName, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLRelationship castedObject = (SQLRelationship) o;
		if (propertyName.equals("deferrability")) {
			return converter.convertToBasicType(castedObject.getDeferrability());
		} else if (propertyName.equals("deleteRule")) {
			return converter.convertToBasicType(castedObject.getDeleteRule());
		} else if (propertyName.equals("fkCardinality")) {
			return converter.convertToBasicType(castedObject.getFkCardinality());
		} else if (propertyName.equals("parent")) {
			return converter.convertToBasicType(castedObject.getParent());
		} else if (propertyName.equals("textForParentLabel")) {
			return converter.convertToBasicType(castedObject.getTextForParentLabel());
		} else if (propertyName.equals("updateRule")) {
			return converter.convertToBasicType(castedObject.getUpdateRule());
		} else if (propertyName.equals("pkCardinality")) {
			return converter.convertToBasicType(castedObject.getPkCardinality());
		} else if (propertyName.equals("pkTable")) {
			return converter.convertToBasicType(castedObject.getPkTable());
		} else if (propertyName.equals("identifying")) {
			return converter.convertToBasicType(castedObject.isIdentifying());
		} else if (propertyName.equals("textForChildLabel")) {
			return converter.convertToBasicType(castedObject.getTextForChildLabel());
		} else {
			return super.findProperty(o, propertyName, converter);
		}
	}

	public void persistObject(SPObject o, int index, SPPersister persister, SessionPersisterSuperConverter converter) throws SPPersistenceException {
		SQLRelationship castedObject = (SQLRelationship) o;
		final String uuid = castedObject.getUUID();
		String parentUUID = null;
		if (castedObject.getParent() != null) {
			parentUUID = castedObject.getParent().getUUID();
		}

		persister.persistObject(parentUUID, "ca.sqlpower.sqlobject.SQLRelationship", uuid, index);
		List<String> preProcessedProperties = new ArrayList<String>();
		try {
			// Constructor arguments
			DataType dataType;
			dataType = DataType.REFERENCE;
			persister.persistProperty(uuid, "parent", dataType, converter.convertToBasicType(castedObject.getParent()));
			preProcessedProperties.add("parent");

			persistObjectProperties(o, persister, converter, preProcessedProperties);
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
	}

	public void persistObjectProperties(SPObject o, SPPersister persister, SessionPersisterSuperConverter converter, List<String> staticPreProcessedProps) throws SPPersistenceException {
		final List<String> preProcessedProps = new ArrayList<String>(staticPreProcessedProps);
		final String uuid = o.getUUID();

		SQLRelationship castedObject = (SQLRelationship) o;
		try {
			if (!preProcessedProps.contains("deferrability")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "deferrability", dataType, converter.convertToBasicType(castedObject.getDeferrability()));
				preProcessedProps.add("deferrability");
			}
			if (!preProcessedProps.contains("deleteRule")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "deleteRule", dataType, converter.convertToBasicType(castedObject.getDeleteRule()));
				preProcessedProps.add("deleteRule");
			}
			if (!preProcessedProps.contains("fkCardinality")) {
				DataType dataType;
				dataType = DataType.INTEGER;
				persister.persistProperty(uuid, "fkCardinality", dataType, converter.convertToBasicType(castedObject.getFkCardinality()));
				preProcessedProps.add("fkCardinality");
			}
			if (!preProcessedProps.contains("parent")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "parent", dataType, converter.convertToBasicType(castedObject.getParent()));
				preProcessedProps.add("parent");
			}
			if (!preProcessedProps.contains("textForParentLabel")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "textForParentLabel", dataType, converter.convertToBasicType(castedObject.getTextForParentLabel()));
				preProcessedProps.add("textForParentLabel");
			}
			if (!preProcessedProps.contains("updateRule")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "updateRule", dataType, converter.convertToBasicType(castedObject.getUpdateRule()));
				preProcessedProps.add("updateRule");
			}
			if (!preProcessedProps.contains("pkCardinality")) {
				DataType dataType;
				dataType = DataType.INTEGER;
				persister.persistProperty(uuid, "pkCardinality", dataType, converter.convertToBasicType(castedObject.getPkCardinality()));
				preProcessedProps.add("pkCardinality");
			}
			if (!preProcessedProps.contains("pkTable")) {
				DataType dataType;
				dataType = DataType.REFERENCE;
				persister.persistProperty(uuid, "pkTable", dataType, converter.convertToBasicType(castedObject.getPkTable()));
				preProcessedProps.add("pkTable");
			}
			if (!preProcessedProps.contains("identifying")) {
				DataType dataType;
				dataType = DataType.BOOLEAN;
				persister.persistProperty(uuid, "identifying", dataType, converter.convertToBasicType(castedObject.isIdentifying()));
				preProcessedProps.add("identifying");
			}
			if (!preProcessedProps.contains("textForChildLabel")) {
				DataType dataType;
				dataType = DataType.STRING;
				persister.persistProperty(uuid, "textForChildLabel", dataType, converter.convertToBasicType(castedObject.getTextForChildLabel()));
				preProcessedProps.add("textForChildLabel");
			}
		} catch (Exception e) {
			throw new SPPersistenceException(uuid, e);
		}
		super.persistObjectProperties(o, persister, converter, preProcessedProps);
	}

	public List<String> getPersistedProperties() throws SPPersistenceException {
		String[] persistedPropertiesArray = {
			"pkCardinality",
			"fkCardinality",
			"parent",
			"textForParentLabel",
			"name",
			"deferrability",
			"deleteRule",
			"pkTable",
			"identifying",
			"updateRule",
			"textForChildLabel"
		};
		List<String> persistedPropertiesList = new ArrayList<String>(Arrays.asList(persistedPropertiesArray));
		persistedPropertiesList.addAll(super.getPersistedProperties());
		return persistedPropertiesList;
	}

}
