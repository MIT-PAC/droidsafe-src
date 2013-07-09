package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Date;
import org.apache.http.cookie.SetCookie2;

public class BasicClientCookie2 extends BasicClientCookie implements SetCookie2 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.899 -0400", hash_original_field = "809FFB37A1E25E47BFCCD448CD9CFC3D", hash_generated_field = "6A2B50CEA40AC67F646E005F8BAEDBCB")

    private String commentURL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.899 -0400", hash_original_field = "47F06098D3034F593871B524CE4F7965", hash_generated_field = "10C002323FE5D85E96EB29FD69E0FF2A")

    private int[] ports;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.900 -0400", hash_original_field = "70F68BB2F748B85DE6526BFE236EA1E9", hash_generated_field = "33439C2B9FDD0CF9B54F1993B130A7B9")

    private boolean discard;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.900 -0400", hash_original_method = "B06BAED2E07D7F9218D98A385CC362B8", hash_generated_method = "8568B32E9F92EA8135C34B32CA128696")
    public  BasicClientCookie2(final String name, final String value) {
        super(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.901 -0400", hash_original_method = "95D16F8D855E74509F3FC69A633DD645", hash_generated_method = "FCF2E4A884A646574106250AC65BF74C")
    @Override
    public int[] getPorts() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1136750745 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1136750745;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.902 -0400", hash_original_method = "764909B3E1563DDB6A65C5637CB4CC25", hash_generated_method = "C9B871E54B4C065A0B7E18343F865239")
    public void setPorts(final int[] ports) {
        this.ports = ports;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.903 -0400", hash_original_method = "601AD280A8E13C6CCEB794F77493867D", hash_generated_method = "C524B67ABA989F721C799F0F8750F895")
    @Override
    public String getCommentURL() {
        String varB4EAC82CA7396A68D541C85D26508E83_275415307 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_275415307 = this.commentURL;
        varB4EAC82CA7396A68D541C85D26508E83_275415307.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_275415307;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.903 -0400", hash_original_method = "D3350C04B38359935C8E8B49E5A32164", hash_generated_method = "0459F7D7F51F9287B0A6EC8A909F9C50")
    public void setCommentURL(final String commentURL) {
        this.commentURL = commentURL;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.903 -0400", hash_original_method = "9446CEDD4455A1D30E4774BBDD3B750C", hash_generated_method = "E6CDF344C6C1B9923E6E003A3B1B943D")
    public void setDiscard(boolean discard) {
        this.discard = discard;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.904 -0400", hash_original_method = "417FDF5C1FC11A52F2E0DFC4D001D3E3", hash_generated_method = "013C861572A6B8BE9F839BF159A2ED88")
    @Override
    public boolean isPersistent() {
        boolean var8894A75FFDDE4B7033639E14D54C822E_1726033689 = (!this.discard && super.isPersistent());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127842147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127842147;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.905 -0400", hash_original_method = "D5A8F73F69F1E942ED94DA98E7190BDB", hash_generated_method = "5D3DC13B726AAD6E64F9E0203BC0C09B")
    @Override
    public boolean isExpired(final Date date) {
        boolean var621414755AA498F27D3D764BF6C36F4D_168213421 = (this.discard || super.isExpired(date));
        addTaint(date.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1523419802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1523419802;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.906 -0400", hash_original_method = "A1E29AF284BD9497DEE668CED1078224", hash_generated_method = "B29F23B763E457CD40CDDB391729BF3A")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1465947852 = null; 
        BasicClientCookie2 clone = (BasicClientCookie2) super.clone();
        clone.ports = this.ports.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1465947852 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1465947852.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1465947852;
        
        
        
        
    }

    
}

