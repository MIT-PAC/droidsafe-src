package android.nfc.tech;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Closeable;
import java.io.IOException;

import android.nfc.Tag;

public interface TagTechnology extends Closeable {
    
    public static final int NFC_A = 1;

    
    public static final int NFC_B = 2;

    
    public static final int ISO_DEP = 3;

    
    public static final int NFC_F = 4;

    
    public static final int NFC_V = 5;

    
    public static final int NDEF = 6;

    
    public static final int NDEF_FORMATABLE = 7;

    
    public static final int MIFARE_CLASSIC = 8;

    
    public static final int MIFARE_ULTRALIGHT = 9;

    
    public Tag getTag();

    
    public void connect() throws IOException;

    
    public void reconnect() throws IOException;

    
    public void close() throws IOException;

    
    public boolean isConnected();
}
