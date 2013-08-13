package ca.sqlpower.swingui.dbtree;

import ca.sqlpower.swingui.dbtree.DBTreeNodeRender.RenderType;

public class DBTreeNodeRenderUtils {
	public static RenderType getRenderType(boolean isUsingLogicalNames){
		if (isUsingLogicalNames) return RenderType.LogicalName;
        return RenderType.PhysicalName;
	}
}
