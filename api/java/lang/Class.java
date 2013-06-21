package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public final
class Class<T> 
    //implements java.io.Serializable,
    //           java.lang.reflect.GenericDeclaration,
    //           java.lang.reflect.Type,
    //           java.lang.reflect.AnnotatedElement 
{

	private static final long serialVersionUID = 1L;
	
	@DSModeled(DSC.BAN)
	public Class() { //Was private
        // Prevent this class to be instantiated, instance
        // should be created by JVM only
    }

	@DSModeled(DSC.SAFE)
	public String getSimpleName() {
		return getTaintString();
	}
	
	@DSModeled(DSC.SAFE)
	public String getName() {
		return getTaintString();
    }
	
	@DSModeled(DSC.SAFE)
	public Class<?> getComponentType() {
		return (Class<?>)getTaint();
	}
}
