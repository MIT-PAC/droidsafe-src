package droidsafe.speclang;

import soot.Type;

/**
 * Class to represented arguments that have been resolved by the JSA analysis
 * into Regular Expressions.
 * 
 * @author mgordon
 *
 */
public class JSAValue extends StringValue {
    /**
     * Create a new JSAValue with the given underlying type, could be
     * String or StringBuilder or CharSequence, etc.
     */
    public JSAValue(String re) {
        super(re);
    }
    
    public String toString() {
        return "JSA-RE: \"" + value + "\"";
    }
    
    @Override
    public String toStringValue() {
        return "JSA-RE: " + value;
    }
}
