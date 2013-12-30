package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;






public class InvalidPropertiesFormatException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.406 -0500", hash_original_field = "362039E2C09E51A13B3A3C4A67C1B751", hash_generated_field = "93913771B2FCBA3B43BB2EE292214671")


    private static final long serialVersionUID = 7763056076009360219L;

    /**
     * Constructs a new {@code InvalidPropertiesFormatException} with the
     * current stack trace and message filled in.
     *
     * @param m
     *           the detail message for the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.409 -0500", hash_original_method = "00EAAF64B023AA3E2882C7003D2FFD8D", hash_generated_method = "2FB795669C0D2802E0D2036FBFAD9A1D")
    
public InvalidPropertiesFormatException(String m) {
        super(m);
    }

    /**
     * Constructs a new {@code InvalidPropertiesFormatException} with the cause
     * for the Exception.
     *
     * @param c
     *           the cause for the Exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.411 -0500", hash_original_method = "9AA9838C1FE2F17D83D4EAE179EF6104", hash_generated_method = "06080380A5A8481E0B23FB5794C23A34")
    
public InvalidPropertiesFormatException(Throwable c) {
        initCause(c);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.413 -0500", hash_original_method = "D501A96831B009EDE0E99C982A162728", hash_generated_method = "E0E51ABDC4A1C83A34A44CAB91BCD4DF")
    
private void writeObject(ObjectOutputStream out)
            throws NotSerializableException{
        throw new NotSerializableException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.416 -0500", hash_original_method = "B2CAB4BC3D811DD242C577EA7CF7F980", hash_generated_method = "6DA2B5814233900D0C9799A9B75FF106")
    
private void readObject(ObjectInputStream in)
            throws NotSerializableException{
        throw new NotSerializableException();
    }
}

