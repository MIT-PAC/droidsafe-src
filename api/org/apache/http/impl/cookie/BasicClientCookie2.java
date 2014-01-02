package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Date;

import org.apache.http.cookie.SetCookie2;






public class BasicClientCookie2 extends BasicClientCookie implements SetCookie2 {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.972 -0500", hash_original_field = "3BBF3F64A34794B64FB53E371BD4F422", hash_generated_field = "6A2B50CEA40AC67F646E005F8BAEDBCB")


    private String commentURL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.974 -0500", hash_original_field = "6A977495C0D45A68547DA6ADBCA73444", hash_generated_field = "10C002323FE5D85E96EB29FD69E0FF2A")

    private int[] ports;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.976 -0500", hash_original_field = "C9E6907B1738BEE284DA1A383B85D7D1", hash_generated_field = "33439C2B9FDD0CF9B54F1993B130A7B9")

    private boolean discard;
    
    /**
     * Default Constructor taking a name and a value. The value may be null.
     * 
     * @param name The name.
     * @param value The value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.979 -0500", hash_original_method = "B06BAED2E07D7F9218D98A385CC362B8", hash_generated_method = "2DBCAF0A6645DABF367AE91E1FB739A6")
    
public BasicClientCookie2(final String name, final String value) {
        super(name, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.981 -0500", hash_original_method = "95D16F8D855E74509F3FC69A633DD645", hash_generated_method = "63803F162F0479AC6022D4C6E49F6D5A")
    
@Override
    public int[] getPorts() {
        return this.ports;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.983 -0500", hash_original_method = "764909B3E1563DDB6A65C5637CB4CC25", hash_generated_method = "6CA7E6FDB4FD96375B4EE73E32DA2BFD")
    
public void setPorts(final int[] ports) {
        this.ports = ports;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.985 -0500", hash_original_method = "601AD280A8E13C6CCEB794F77493867D", hash_generated_method = "6C0EAF59492C09642AEFB7F5F645C901")
    
@Override
    public String getCommentURL() {
        return this.commentURL;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.988 -0500", hash_original_method = "D3350C04B38359935C8E8B49E5A32164", hash_generated_method = "DE976EDC63D3A707982DB4232003D817")
    
public void setCommentURL(final String commentURL) {
        this.commentURL = commentURL;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.990 -0500", hash_original_method = "9446CEDD4455A1D30E4774BBDD3B750C", hash_generated_method = "8D6D7D1EF3AEBEAFC8809B6895343AE5")
    
public void setDiscard(boolean discard) {
        this.discard = discard;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.992 -0500", hash_original_method = "417FDF5C1FC11A52F2E0DFC4D001D3E3", hash_generated_method = "692E8B0AFD250CD4F91AD4653F731B6D")
    
@Override
    public boolean isPersistent() {
        return !this.discard && super.isPersistent();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.996 -0500", hash_original_method = "D5A8F73F69F1E942ED94DA98E7190BDB", hash_generated_method = "81E828135EE33B995DDD1DE73DA20908")
    
@Override
    public boolean isExpired(final Date date) {
        return this.discard || super.isExpired(date);
    }
 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.998 -0500", hash_original_method = "A1E29AF284BD9497DEE668CED1078224", hash_generated_method = "FB4BC060942698DD2C38881BD794513C")
    
@Override
    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie2 clone = (BasicClientCookie2) super.clone();
        clone.ports = this.ports.clone();
        return clone;
    }

    
}

