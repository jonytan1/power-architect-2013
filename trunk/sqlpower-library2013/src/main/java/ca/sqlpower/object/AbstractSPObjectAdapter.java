package ca.sqlpower.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ca.sqlpower.sqlobject.SQLObjectException;

public abstract class AbstractSPObjectAdapter extends AbstractSPObject {
    private static Logger logger = Logger.getLogger(AbstractSPObjectAdapter.class);
    
    public static List<Class<? extends SPObject>> allowedChildTypes =
            Collections.<Class<? extends SPObject>>singletonList(SPObjectChildAdapter.class);
    
    private Class<? extends Object> childClass;
    private Map<Object, SPObjectChildAdapter> children;
    
    public AbstractSPObjectAdapter(Class<? extends Object> childClass) {
        this.childClass = childClass;
        children = new HashMap<Object, SPObjectChildAdapter>();
    }
    
    public void addChildWithAdapter(Object source) throws IllegalArgumentException{
        if (source == null) return;
        if (!childClass.isAssignableFrom(source.getClass())) {
            throw new IllegalArgumentException(
                    "Please to check the class of source(" + source.getClass() + 
                    ") is or is subclass of " + childClass.getName());
        }
        
        SPObjectChildAdapter child = children.get(source);
        if (child != null) return;
        child = new SPObjectChildAdapter(source);
        addChild(child);
    }
    
    public void removeChildWithAdapter(Object source) throws IllegalArgumentException {
        if (source == null) return;
        if (!childClass.isAssignableFrom(source.getClass())) {
            throw new IllegalArgumentException(
                    "Please to check the class of source(" + source.getClass() + 
                    ") is (or is a subclass of) " + childClass.getName());
        }
        
        SPObjectChildAdapter child = children.get(source);
        if (child == null) return;
        try {
            removeChild(child);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ObjectDependentException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<SPObjectChildAdapter> getChildren() {
        return new ArrayList<SPObjectChildAdapter>(children.values());
    }

    @Override
    public void removeDependency(SPObject dependency) {}

    @Override
    public List<? extends SPObject> getDependencies() {
        return Collections.emptyList();
    }

    @Override
    public List<Class<? extends SPObject>> getAllowedChildTypes() {
        return allowedChildTypes;
    }

    @Override
    protected final void addChildImpl(SPObject child, int index) {
        if (child != null && child instanceof SPObjectChildAdapter) {
            try {
                SPObjectChildAdapter ca = (SPObjectChildAdapter)child;
                addChildAdapter(ca.getSource());
                children.put(ca.getSource(), ca);
                this.fireChildAdded(SPObjectChildAdapter.class, child, 0);
            } catch (SQLObjectException e) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Error occur : " + e.toString());
                }
            }
        }
    }
    
    protected void addChildAdapter(Object child) throws SQLObjectException {}
    
    @Override
    protected boolean removeChildImpl(SPObject child) {
        if (child != null && child instanceof SPObjectChildAdapter) {
            SPObjectChildAdapter ca = (SPObjectChildAdapter)child;
            try {
                removeChildAdapter(ca.getSource());
                children.remove(child);
                fireChildRemoved(SPObjectChildAdapter.class, child, 0);
                return true;
            } catch (SQLObjectException e) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Error occur : " + e.toString());
                }
            } catch (ObjectDependentException e) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Error occur : " + e.toString());
                }
            }
        }
        return false;
    }
    
    protected void removeChildAdapter(Object child) throws ObjectDependentException, SQLObjectException{}
    
    public String toString() {
        return "AbstractSPObjectAdapter";
    }
}
