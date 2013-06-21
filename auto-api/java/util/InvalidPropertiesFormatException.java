package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InvalidPropertiesFormatException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.493 -0400", hash_original_method = "00EAAF64B023AA3E2882C7003D2FFD8D", hash_generated_method = "1D7F91A6EC7216C15397F5DD961FC6DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidPropertiesFormatException(String m) {
        super(m);
        dsTaint.addTaint(m);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.493 -0400", hash_original_method = "9AA9838C1FE2F17D83D4EAE179EF6104", hash_generated_method = "4C56173CD9EF98A8A7885654E89D9C35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidPropertiesFormatException(Throwable c) {
        dsTaint.addTaint(c.dsTaint);
        initCause(c);
        // ---------- Original Method ----------
        //initCause(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.493 -0400", hash_original_method = "D501A96831B009EDE0E99C982A162728", hash_generated_method = "9641599CF94EF725F431E4B3ED534E42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws NotSerializableException {
        dsTaint.addTaint(out.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NotSerializableException();
        // ---------- Original Method ----------
        //throw new NotSerializableException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.493 -0400", hash_original_method = "B2CAB4BC3D811DD242C577EA7CF7F980", hash_generated_method = "4307DEDFCC4956A69A9B2AE1A757EB1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws NotSerializableException {
        dsTaint.addTaint(in.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NotSerializableException();
        // ---------- Original Method ----------
        //throw new NotSerializableException();
    }

    
    private static final long serialVersionUID = 7763056076009360219L;
}

