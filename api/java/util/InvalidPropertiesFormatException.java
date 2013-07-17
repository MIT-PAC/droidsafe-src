package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InvalidPropertiesFormatException extends IOException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.535 -0400", hash_original_method = "00EAAF64B023AA3E2882C7003D2FFD8D", hash_generated_method = "EBA1C1CF9DDCDAB8AD09C608F35943B1")
    public  InvalidPropertiesFormatException(String m) {
        super(m);
        addTaint(m.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.535 -0400", hash_original_method = "9AA9838C1FE2F17D83D4EAE179EF6104", hash_generated_method = "ED8E0D12448B7E488E7C5F63D27144A7")
    public  InvalidPropertiesFormatException(Throwable c) {
        addTaint(c.getTaint());
        initCause(c);
        // ---------- Original Method ----------
        //initCause(c);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.536 -0400", hash_original_method = "D501A96831B009EDE0E99C982A162728", hash_generated_method = "6EBD3200C2B8D4C3FAFE47ED14DE4C83")
    private void writeObject(ObjectOutputStream out) throws NotSerializableException {
        addTaint(out.getTaint());
        NotSerializableException varAF70E0AC33443FC02B659F47A78A88BA_1528390357 = new NotSerializableException();
        varAF70E0AC33443FC02B659F47A78A88BA_1528390357.addTaint(taint);
        throw varAF70E0AC33443FC02B659F47A78A88BA_1528390357;
        // ---------- Original Method ----------
        //throw new NotSerializableException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.536 -0400", hash_original_method = "B2CAB4BC3D811DD242C577EA7CF7F980", hash_generated_method = "054882D28F3AC9041C470B8D243A686F")
    private void readObject(ObjectInputStream in) throws NotSerializableException {
        addTaint(in.getTaint());
        NotSerializableException varAF70E0AC33443FC02B659F47A78A88BA_1626785593 = new NotSerializableException();
        varAF70E0AC33443FC02B659F47A78A88BA_1626785593.addTaint(taint);
        throw varAF70E0AC33443FC02B659F47A78A88BA_1626785593;
        // ---------- Original Method ----------
        //throw new NotSerializableException();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.536 -0400", hash_original_field = "1FD7AC3D2CBAF873F8F983A2BAC82DA8", hash_generated_field = "93913771B2FCBA3B43BB2EE292214671")

    private static final long serialVersionUID = 7763056076009360219L;
}

