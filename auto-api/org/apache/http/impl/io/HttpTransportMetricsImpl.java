package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.io.HttpTransportMetrics;

public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.835 -0400", hash_original_field = "C80D0D5AF96F865383EEA49D602AB4B0", hash_generated_field = "758177ECF64D712D2723B646394F959F")

    private long bytesTransferred = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.836 -0400", hash_original_method = "7D2D78BCCD20A0F0768C108C18222508", hash_generated_method = "9D344AA50CEBAD051F5FDD8939154F67")
    public  HttpTransportMetricsImpl() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.836 -0400", hash_original_method = "7E49696C17D36DF48010DE39377AB681", hash_generated_method = "589F26013B89B8A5B5FACFE29105CD82")
    public long getBytesTransferred() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_222239133 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_222239133;
        // ---------- Original Method ----------
        //return this.bytesTransferred;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.836 -0400", hash_original_method = "7CF98125B8F87A2FD19C70088B288B78", hash_generated_method = "B5449F175BF9820DC474D49437D8D9CA")
    public void setBytesTransferred(long count) {
        this.bytesTransferred = count;
        // ---------- Original Method ----------
        //this.bytesTransferred = count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.837 -0400", hash_original_method = "5BC15BEBDBF96C2B4749F7E80B21C1AA", hash_generated_method = "E273073A4939F9C970DA3A9120498FFC")
    public void incrementBytesTransferred(long count) {
        this.bytesTransferred += count;
        // ---------- Original Method ----------
        //this.bytesTransferred += count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.837 -0400", hash_original_method = "57609043FFD34118E5E2ADA78EDAAD37", hash_generated_method = "09659E599DDF8A9241FB68801CC9E8DF")
    public void reset() {
        this.bytesTransferred = 0;
        // ---------- Original Method ----------
        //this.bytesTransferred = 0;
    }

    
}

