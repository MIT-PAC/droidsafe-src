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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DSModeled(DSC.SAFE)
	public String getSimpleName() {
		return new String();
	}
	
	@DSModeled(DSC.SAFE)
	public String getName() {
		return new String();
    }
	

}
