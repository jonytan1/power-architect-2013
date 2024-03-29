/*
 * Copyright (c) 2008, SQL Power Group Inc.
 *
 * This file is part of Power*Architect.
 *
 * Power*Architect is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * Power*Architect is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 */
package ca.sqlpower.architect;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

public abstract class AbstractUserSetting implements UserSettings {
    private static Logger logger = Logger.getLogger(AbstractUserSetting.class);

    protected Map settings;

    public AbstractUserSetting() {
        super();
        settings = new HashMap();
    }

    /**
     * Gets the named property from the settings map.  If the value in
     * the map is a Number, the value is obtained by calling
     * <code>intValue()</code> on it.  If it is a String, it is
     * converted with <code>Integer.parseInt()</code>. Otherwise, the
     * default value is returned a warning is logged using
     * <code>logger</code>.  If there is no such value in the map,
     * the default is returned without logging a warning.
     */
    public int getInt(String propName, int defaultValue) {
        Object result = settings.get(propName);
        if (result == null) {
            return defaultValue;
        } else if (result instanceof Number) {
            return ((Number) result).intValue();
        } else if (result instanceof String) {
            try {
                return Integer.parseInt((String) result);
            } catch (NumberFormatException e) {
                logger.warn("Couldn't parse value '"+result
                            +"' as integer for property '"+propName+"'");
            }
        }
        logger.warn("Using default value for integer property '"+propName+"' because of unknown data type for existing value");
        return defaultValue;
    }

    public void setInt(String propName, int value) {
        settings.put(propName, new Integer(value));
    }

    /**
     * Gets the named property from the settings map.  If the value in
     * the map is a Boolean, the value is obtained by calling
     * <code>booleanValue()</code> on it.  If it is a String, it is
     * converted with <code>Boolean.parseBoolean()</code>. Otherwise, the
     * default value is returned and a warning is logged using
     * <code>logger</code>.  If there is no such value in the map,
     * the default is returned without logging a warning.
     */
    public boolean getBoolean(String propName, boolean defaultValue) {
        Object result = settings.get(propName);
        if (result == null) {
            return defaultValue;
        } else if (result instanceof Boolean) {
            return ((Boolean) result).booleanValue();
        } else if (result instanceof String) {
            return Boolean.valueOf((String) result).booleanValue();
        }
        logger.warn("Using default value for boolean property '"+propName+"' because of unknown data type for existing value");
        return defaultValue;
    }

    public void setBoolean(String propName, boolean value) {
        settings.put(propName,  Boolean.valueOf(value));
    }

    public void setObject(String propName, Object value) {
        settings.put(propName, value);
    }

    /**
     * Adds a new setting or updates the value of an existing setting.  This
     * method is meant to be used by the ConfigFile read method: The set&lt;Type&gt;
     * methods are an easier interface to the same thing.
     *
     * @param propName The name of the property to add or update.
     * @param propClassName The class name of the property's value. Currently,
     * "java.lang.Integer" and "java.lang.Boolean" are supported.
     * @param propValue A string representation of the property's value.
     */
    public void putSetting(String propName, String propClassName, String propValue) {
        Object prop = null;
        if (propClassName.equals("java.lang.Integer")) {
            try {
                prop = Integer.valueOf(propValue);
            } catch (NumberFormatException e) {
                logger.warn("Invalid integer setting "+propName+"="+propValue);
                return;
            }
        } else if (propClassName.equals("java.lang.Boolean")) {
            prop = Boolean.valueOf(propValue);
        } else {
            logger.warn("Unknown property class "+propClassName);
            return;
        }
        settings.put(propName, prop);
    }

    public String getString(String propName, String defaultValue) {
        Object result = settings.get(propName);
        if (result == null) {
            return defaultValue;
        } else {
            return result.toString();
        }
    }

    public void setString(String propName, String value) {
        settings.put(propName,value);
    }

    public Object getObject(String propName, Object defaultValue) {
        Object result = settings.get(propName);
        if (result == null) {
            return defaultValue;
        } else {
            return result;
        }
    }

    /**
     * Returns the names of all settings currently held by this
     * SwingUserSettings object.  They will all be Strings.
     */
    public Set getSettingNames() {
        return settings.keySet();
    }
}
