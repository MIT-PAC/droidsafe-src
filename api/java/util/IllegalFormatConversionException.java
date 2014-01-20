package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public class IllegalFormatConversionException extends IllegalFormatException implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.418 -0500", hash_original_field = "1BB64411CE2C82F526EDC7EC1A02E1CC", hash_generated_field = "25B9B9FD75AC3506217DC397F5D20733")

    private static final long serialVersionUID = 17000126L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.420 -0500", hash_original_field = "7DEFA5881D592344AB5D4C2684DE1F7D", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private  char c;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.424 -0500", hash_original_field = "B3DDF44BEA90EBB229C8217DB24F6E20", hash_generated_field = "2ECA6A70BD4E757E3F8651900978568C")

    private  Class<?> arg;

    /**
     * Constructs a new {@code IllegalFormatConversionException} with the class
     * of the mismatched conversion and corresponding parameter.
     *
     * @param c
     *           the class of the mismatched conversion.
     * @param arg
     *           the corresponding parameter.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.426 -0500", hash_original_method = "0438EEFB69B3388326CD0DDEA30A5038", hash_generated_method = "7C2405B3E2DB77423CC05BE2D30DEE47")
    
public IllegalFormatConversionException(char c, Class<?> arg) {
        this.c = c;
        if (arg == null) {
            throw new NullPointerException();
        }
        this.arg = arg;
    }

    /**
     * Returns the class of the mismatched parameter.
     *
     * @return the class of the mismatched parameter.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.429 -0500", hash_original_method = "F6AB4FB57CDBF80A2EA14BA003E8B6E3", hash_generated_method = "86946FDB0EF9612D985BF1B5238E7B31")
    
public Class<?> getArgumentClass() {
        return arg;
    }

    /**
     * Returns the incompatible conversion.
     *
     * @return the incompatible conversion.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.431 -0500", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "A01009E7FAC2235AB14D99D1342E319D")
    
public char getConversion() {
        return c;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.433 -0500", hash_original_method = "F4CE0F8EC3805161966118C119A25B11", hash_generated_method = "A115DD607857A62D4CFD586C57126BA6")
    
@Override
    public String getMessage() {
        return "%" + c + " can't format " + arg.getName() + " arguments";
    }
}

