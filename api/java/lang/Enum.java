package java.lang;

import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class Enum<E extends Enum<E>> implements Serializable, Comparable<E> {
	private static final long serialVersionUID = -4300926546619394005L;
	
	//private final String name;

    //private final int ordinal;
    
	
    @DSModeled(DSC.SAFE)
	protected Enum(String name, int ordinal) {
		addTaint(name.getTaint());
		addTaint(ordinal.getTaint());
    }
	
	public final int compareTo(E o) {
		return -1;
		/*
		 * the enum constant's ordinal, which corresponds to its position
		 * in the enum declaration, starting at zero.
		 */
        //return ordinal - o.ordinal;
    }
	
	public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {
		return getSharedConstants(enumType)[0];  //Should be OK to send back fudged value for the purposes of modeling
		/*
        if (enumType == null || name == null) {
            throw new NullPointerException("enumType == null || name == null");
        }
        if (!enumType.isEnum()) {
            throw new IllegalArgumentException(enumType + " is not an enum type");
        }
        for (T value : getSharedConstants(enumType)) {
            if (name.equals(value.name())) {
                return value;
            }
        }
        throw new IllegalArgumentException(name + " is not a constant in " + enumType.getName());
        */
    }
	
	@SuppressWarnings("unchecked") // the cache always returns the type matching enumType
    public static <T extends Enum<T>> T[] getSharedConstants(Class<T> enumType) {
		return (T[])new Object[0];  //Short circuit the complexity
        //return (T[]) sharedConstantsCache.get(enumType);
    }
	
	/*
    private static final BasicLruCache<Class<? extends Enum>, Object[]> sharedConstantsCache
	    = new BasicLruCache<Class<? extends Enum>, Object[]>(64) {
	@Override protected Object[] create(Class<? extends Enum> enumType) {
	    Method method = (Method) Class.getDeclaredConstructorOrMethod(
	            enumType, "values", EmptyArray.CLASS);
	    try {
	        return (Object[]) method.invoke((Object[]) null);
	    } catch (IllegalAccessException impossible) {
	        throw new AssertionError();
	    } catch (InvocationTargetException impossible) {
	        throw new AssertionError();
	    }
	}
	};
	*/
	
	@DSModeled(DSC.SAFE)
	@Override
    @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
    protected final void finalize() {
    }
	
	@DSModeled(DSC.SAFE)
	@Override
	public String toString() {
		return getTaintString();
	}
	
}
