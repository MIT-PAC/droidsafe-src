package java.lang;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public final
class Class<T> 
    //implements java.io.Serializable,
    //           java.lang.reflect.GenericDeclaration,
    //           java.lang.reflect.Type,
    //           java.lang.reflect.AnnotatedElement 
{
	public DSTaintObject dsTaint = new DSTaintObject();

	private static final long serialVersionUID = 1L;
	
	@DSModeled(DSC.BAN)
	public Class() { //Was private
        // Prevent this class to be instantiated, instance
        // should be created by JVM only
    }

	@DSModeled(DSC.SAFE)
	public String getSimpleName() {
		return dsTaint.getTaintString();
	}
	
	@DSModeled(DSC.SAFE)
	public String getName() {
		return dsTaint.getTaintString();
    }
	
	@DSModeled(DSC.SAFE)
	public Class<?> getComponentType() {
		return (Class<?>)dsTaint.getTaint();
	}
}
