package org.apache.http.impl.io;

// Droidsafe Imports
import org.apache.http.io.HttpTransportMetrics;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.596 -0400", hash_original_field = "C80D0D5AF96F865383EEA49D602AB4B0", hash_generated_field = "758177ECF64D712D2723B646394F959F")

    private long bytesTransferred = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.597 -0400", hash_original_method = "7D2D78BCCD20A0F0768C108C18222508", hash_generated_method = "9D344AA50CEBAD051F5FDD8939154F67")
    public  HttpTransportMetricsImpl() {
        super();
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.597 -0400", hash_original_method = "7E49696C17D36DF48010DE39377AB681", hash_generated_method = "F2D8D8A1C515DA69A8AF8C05584B62AB")
    public long getBytesTransferred() {
        long var9227AA73D15265B9E3F4726608650434_1224358887 = (this.bytesTransferred);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1292437039 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1292437039;
        // ---------- Original Method ----------
        //return this.bytesTransferred;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.598 -0400", hash_original_method = "7CF98125B8F87A2FD19C70088B288B78", hash_generated_method = "B5449F175BF9820DC474D49437D8D9CA")
    public void setBytesTransferred(long count) {
        this.bytesTransferred = count;
        // ---------- Original Method ----------
        //this.bytesTransferred = count;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.599 -0400", hash_original_method = "5BC15BEBDBF96C2B4749F7E80B21C1AA", hash_generated_method = "E273073A4939F9C970DA3A9120498FFC")
    public void incrementBytesTransferred(long count) {
        this.bytesTransferred += count;
        // ---------- Original Method ----------
        //this.bytesTransferred += count;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.599 -0400", hash_original_method = "57609043FFD34118E5E2ADA78EDAAD37", hash_generated_method = "09659E599DDF8A9241FB68801CC9E8DF")
    public void reset() {
        this.bytesTransferred = 0;
        // ---------- Original Method ----------
        //this.bytesTransferred = 0;
    }

    
}

