package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class Annotation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.203 -0500", hash_original_field = "01495BEB834F5098BB0B06183674C819", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")


    private Object value;

    /**
     * Constructs a new {@code Annotation}.
     *
     * @param attribute the attribute attached to this annotation. This may be
     *        {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.206 -0500", hash_original_method = "B1453DDFF141446D32AF844E0A6591E8", hash_generated_method = "EBD06A8BDEC772879149679DA40D14EC")
    
public Annotation(Object attribute) {
        value = attribute;
    }

    /**
     * Returns the value of this annotation. The value may be {@code null}.
     *
     * @return the value of this annotation or {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.208 -0500", hash_original_method = "B4F085CF9776332A868AEA05C2B06886", hash_generated_method = "8F1C34090E292F1C2F621B605A6DF10D")
    
public Object getValue() {
        return value;
    }

    /**
     * Returns this annotation in string representation.
     *
     * @return the string representation of this annotation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.211 -0500", hash_original_method = "439CE19804D9002003DD6A4835AE4496", hash_generated_method = "629F14B051FCA1573294076D9E1BC448")
    
@Override
    public String toString() {
        return getClass().getName() + "[value=" + value + ']';
    }

    
}

