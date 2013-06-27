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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.100 -0400", hash_original_method = "00EAAF64B023AA3E2882C7003D2FFD8D", hash_generated_method = "EBA1C1CF9DDCDAB8AD09C608F35943B1")
    public  InvalidPropertiesFormatException(String m) {
        super(m);
        addTaint(m.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.101 -0400", hash_original_method = "9AA9838C1FE2F17D83D4EAE179EF6104", hash_generated_method = "7E4CC95A0C3E10453592AD342098569F")
    public  InvalidPropertiesFormatException(Throwable c) {
        initCause(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //initCause(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.101 -0400", hash_original_method = "D501A96831B009EDE0E99C982A162728", hash_generated_method = "1FA2FA59A0AB409DED5CB9B001CCF5FA")
    private void writeObject(ObjectOutputStream out) throws NotSerializableException {
        if (DroidSafeAndroidRuntime.control) throw new NotSerializableException();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //throw new NotSerializableException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.101 -0400", hash_original_method = "B2CAB4BC3D811DD242C577EA7CF7F980", hash_generated_method = "E5B9AB5EEC4D816A6EF1C2B3FCAB0E7C")
    private void readObject(ObjectInputStream in) throws NotSerializableException {
        if (DroidSafeAndroidRuntime.control) throw new NotSerializableException();
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //throw new NotSerializableException();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.101 -0400", hash_original_field = "1FD7AC3D2CBAF873F8F983A2BAC82DA8", hash_generated_field = "E2C8D6C1424BBB141D80914144B3CE6F")

    private static long serialVersionUID = 7763056076009360219L;
}

