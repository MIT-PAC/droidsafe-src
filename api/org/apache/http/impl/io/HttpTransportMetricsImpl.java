package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.io.HttpTransportMetrics;

public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.213 -0400", hash_original_field = "C80D0D5AF96F865383EEA49D602AB4B0", hash_generated_field = "758177ECF64D712D2723B646394F959F")

    private long bytesTransferred = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.214 -0400", hash_original_method = "7D2D78BCCD20A0F0768C108C18222508", hash_generated_method = "9D344AA50CEBAD051F5FDD8939154F67")
    public  HttpTransportMetricsImpl() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.214 -0400", hash_original_method = "7E49696C17D36DF48010DE39377AB681", hash_generated_method = "C4CF6C75448597B1EF98D6447D80A117")
    public long getBytesTransferred() {
        long var9227AA73D15265B9E3F4726608650434_1443827955 = (this.bytesTransferred);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2104842875 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2104842875;
        // ---------- Original Method ----------
        //return this.bytesTransferred;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.215 -0400", hash_original_method = "7CF98125B8F87A2FD19C70088B288B78", hash_generated_method = "B5449F175BF9820DC474D49437D8D9CA")
    public void setBytesTransferred(long count) {
        this.bytesTransferred = count;
        // ---------- Original Method ----------
        //this.bytesTransferred = count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.215 -0400", hash_original_method = "5BC15BEBDBF96C2B4749F7E80B21C1AA", hash_generated_method = "E273073A4939F9C970DA3A9120498FFC")
    public void incrementBytesTransferred(long count) {
        this.bytesTransferred += count;
        // ---------- Original Method ----------
        //this.bytesTransferred += count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.215 -0400", hash_original_method = "57609043FFD34118E5E2ADA78EDAAD37", hash_generated_method = "09659E599DDF8A9241FB68801CC9E8DF")
    public void reset() {
        this.bytesTransferred = 0;
        // ---------- Original Method ----------
        //this.bytesTransferred = 0;
    }

    
}

