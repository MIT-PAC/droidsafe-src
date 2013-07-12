package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InvalidPropertiesFormatException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.642 -0400", hash_original_method = "00EAAF64B023AA3E2882C7003D2FFD8D", hash_generated_method = "EBA1C1CF9DDCDAB8AD09C608F35943B1")
    public  InvalidPropertiesFormatException(String m) {
        super(m);
        addTaint(m.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.642 -0400", hash_original_method = "9AA9838C1FE2F17D83D4EAE179EF6104", hash_generated_method = "ED8E0D12448B7E488E7C5F63D27144A7")
    public  InvalidPropertiesFormatException(Throwable c) {
        addTaint(c.getTaint());
        initCause(c);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.642 -0400", hash_original_method = "D501A96831B009EDE0E99C982A162728", hash_generated_method = "AFA903063A9618F0DF2BF49FE7FAD389")
    private void writeObject(ObjectOutputStream out) throws NotSerializableException {
        addTaint(out.getTaint());
        NotSerializableException varAF70E0AC33443FC02B659F47A78A88BA_465234860 = new NotSerializableException();
        varAF70E0AC33443FC02B659F47A78A88BA_465234860.addTaint(taint);
        throw varAF70E0AC33443FC02B659F47A78A88BA_465234860;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.643 -0400", hash_original_method = "B2CAB4BC3D811DD242C577EA7CF7F980", hash_generated_method = "9BBEB7B3510F8C516A202EFA8CBE96D4")
    private void readObject(ObjectInputStream in) throws NotSerializableException {
        addTaint(in.getTaint());
        NotSerializableException varAF70E0AC33443FC02B659F47A78A88BA_1884141876 = new NotSerializableException();
        varAF70E0AC33443FC02B659F47A78A88BA_1884141876.addTaint(taint);
        throw varAF70E0AC33443FC02B659F47A78A88BA_1884141876;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.643 -0400", hash_original_field = "1FD7AC3D2CBAF873F8F983A2BAC82DA8", hash_generated_field = "93913771B2FCBA3B43BB2EE292214671")

    private static final long serialVersionUID = 7763056076009360219L;
}

