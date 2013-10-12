package ca.sqlpower.object;

import java.util.Collections;
import java.util.List;

/**
 * This is an adapter class for the child of sub class of AbstractSPObjectAdapter.
 * The child may be an any-object.
 * 
 * @author jianjun.tan
 *
 */
public class SPObjectChildAdapter extends AbstractSPObject{

    public final List<Class<? extends SPObject>> allowedChildTypes = Collections.emptyList();

    private final Object child;
    
    public SPObjectChildAdapter() {
        this(null);
    }
    
    public SPObjectChildAdapter(Object child) {
        this.child = child;
    }
    
    public final Object getSource() {
        return child;
    }
    
    public String toString() {
        return "SPObjectChildAdapter(" + child + ")";
    }
    
    @Override
    public List<? extends SPObject> getChildren() {
        return Collections.emptyList();
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
    protected final void addChildImpl(SPObject child, int index) throws IllegalArgumentException{
        throw new IllegalArgumentException("Now only support one level.");
    }
    
    @Override
    protected final boolean removeChildImpl(SPObject child) 
            throws IllegalArgumentException {
        throw new IllegalArgumentException("Now only support one level.");
    }
    
}
