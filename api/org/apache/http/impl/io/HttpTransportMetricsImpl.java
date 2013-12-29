package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.io.HttpTransportMetrics;






public class HttpTransportMetricsImpl implements HttpTransportMetrics {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.555 -0500", hash_original_field = "E8E208568B2733C138CF9FA3514C2C0C", hash_generated_field = "758177ECF64D712D2723B646394F959F")


    private long bytesTransferred = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.556 -0500", hash_original_method = "7D2D78BCCD20A0F0768C108C18222508", hash_generated_method = "5F095FB2C9B4C0EB13FBD76A4AF11235")
    public HttpTransportMetricsImpl() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.557 -0500", hash_original_method = "7E49696C17D36DF48010DE39377AB681", hash_generated_method = "D9CEDD25462C13008374B8527E38B9BA")
    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.558 -0500", hash_original_method = "7CF98125B8F87A2FD19C70088B288B78", hash_generated_method = "5E63A6C3617F7CF3B345D74E6FF08CC7")
    public void setBytesTransferred(long count) {
        this.bytesTransferred = count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.558 -0500", hash_original_method = "5BC15BEBDBF96C2B4749F7E80B21C1AA", hash_generated_method = "4723DE3147D4F65073D54E85943C21AB")
    public void incrementBytesTransferred(long count) {
        this.bytesTransferred += count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.559 -0500", hash_original_method = "57609043FFD34118E5E2ADA78EDAAD37", hash_generated_method = "3EA0F70FC746AD3D01FF340A7B890209")
    public void reset() {
        this.bytesTransferred = 0;
    }

    
}

