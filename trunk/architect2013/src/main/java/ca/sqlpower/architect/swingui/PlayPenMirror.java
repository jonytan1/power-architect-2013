package ca.sqlpower.architect.swingui;

import java.util.Collections;
import java.util.List;

import ca.sqlpower.object.AbstractSPObjectAdapter;
import ca.sqlpower.object.ObjectDependentException;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.object.SPObjectChildAdapter;
import ca.sqlpower.sqlobject.SQLObjectException;
import ca.sqlpower.sqlobject.SQLSchema;

public class PlayPenMirror extends AbstractSPObjectAdapter {
    private final PlayPen playPen;
    public static List<Class<? extends SPObject>> allowedChildTypes =
            Collections.<Class<? extends SPObject>>singletonList(SPObjectChildAdapter.class);

    public PlayPenMirror() {
        this(null);
    }
    
    public PlayPenMirror(PlayPen playPen) {
        super(SQLSchema.class);
        this.playPen = playPen;
    }
    
    public void addChildAdapter(Object child) throws SQLObjectException {
        if (playPen == null) {
            throw new SQLObjectException("PlayPen should be not null.");
        }
        playPen.addTabbedSchema((SQLSchema)child);
    }
    
    public void removeChildAdapter(Object child)
            throws ObjectDependentException, SQLObjectException {
        if (playPen == null) {
            throw new SQLObjectException("PlayPen should be not null.");
        }
        playPen.removeTabbedSchema((SQLSchema)child);
    }
    
    public String toString() {
        return "PlayPenMirror(" + playPen + ")";
    }
}
