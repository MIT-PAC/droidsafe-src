package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Date;
import org.apache.http.cookie.SetCookie2;

public class BasicClientCookie2 extends BasicClientCookie implements SetCookie2 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.180 -0400", hash_original_field = "809FFB37A1E25E47BFCCD448CD9CFC3D", hash_generated_field = "6A2B50CEA40AC67F646E005F8BAEDBCB")

    private String commentURL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.180 -0400", hash_original_field = "47F06098D3034F593871B524CE4F7965", hash_generated_field = "10C002323FE5D85E96EB29FD69E0FF2A")

    private int[] ports;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.180 -0400", hash_original_field = "70F68BB2F748B85DE6526BFE236EA1E9", hash_generated_field = "33439C2B9FDD0CF9B54F1993B130A7B9")

    private boolean discard;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.181 -0400", hash_original_method = "B06BAED2E07D7F9218D98A385CC362B8", hash_generated_method = "8568B32E9F92EA8135C34B32CA128696")
    public  BasicClientCookie2(final String name, final String value) {
        super(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.181 -0400", hash_original_method = "95D16F8D855E74509F3FC69A633DD645", hash_generated_method = "DFFBA357F27A301E6E2C5B2AB8FF26FE")
    @Override
    public int[] getPorts() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1525532630 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1525532630;
        // ---------- Original Method ----------
        //return this.ports;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.181 -0400", hash_original_method = "764909B3E1563DDB6A65C5637CB4CC25", hash_generated_method = "C9B871E54B4C065A0B7E18343F865239")
    public void setPorts(final int[] ports) {
        this.ports = ports;
        // ---------- Original Method ----------
        //this.ports = ports;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.182 -0400", hash_original_method = "601AD280A8E13C6CCEB794F77493867D", hash_generated_method = "0EA6227742CD4110EC29FDB16D8CE1E5")
    @Override
    public String getCommentURL() {
        String varB4EAC82CA7396A68D541C85D26508E83_1993752777 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1993752777 = this.commentURL;
        varB4EAC82CA7396A68D541C85D26508E83_1993752777.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1993752777;
        // ---------- Original Method ----------
        //return this.commentURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.182 -0400", hash_original_method = "D3350C04B38359935C8E8B49E5A32164", hash_generated_method = "0459F7D7F51F9287B0A6EC8A909F9C50")
    public void setCommentURL(final String commentURL) {
        this.commentURL = commentURL;
        // ---------- Original Method ----------
        //this.commentURL = commentURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.182 -0400", hash_original_method = "9446CEDD4455A1D30E4774BBDD3B750C", hash_generated_method = "E6CDF344C6C1B9923E6E003A3B1B943D")
    public void setDiscard(boolean discard) {
        this.discard = discard;
        // ---------- Original Method ----------
        //this.discard = discard;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.186 -0400", hash_original_method = "417FDF5C1FC11A52F2E0DFC4D001D3E3", hash_generated_method = "AB518AFCC268781DD2F1EC46C4A01CF7")
    @Override
    public boolean isPersistent() {
        boolean var8894A75FFDDE4B7033639E14D54C822E_1222701136 = (!this.discard && super.isPersistent());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1966967272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1966967272;
        // ---------- Original Method ----------
        //return !this.discard && super.isPersistent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.192 -0400", hash_original_method = "D5A8F73F69F1E942ED94DA98E7190BDB", hash_generated_method = "827DEDCEEEA2893E9C9A6A232804CBF9")
    @Override
    public boolean isExpired(final Date date) {
        boolean var621414755AA498F27D3D764BF6C36F4D_240558960 = (this.discard || super.isExpired(date));
        addTaint(date.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7047854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7047854;
        // ---------- Original Method ----------
        //return this.discard || super.isExpired(date);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.211 -0400", hash_original_method = "A1E29AF284BD9497DEE668CED1078224", hash_generated_method = "C21A802801523F5DBF68F26385A0C98F")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1982871591 = null; //Variable for return #1
        BasicClientCookie2 clone;
        clone = (BasicClientCookie2) super.clone();
        clone.ports = this.ports.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1982871591 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1982871591.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1982871591;
        // ---------- Original Method ----------
        //BasicClientCookie2 clone = (BasicClientCookie2) super.clone();
        //clone.ports = this.ports.clone();
        //return clone;
    }

    
}

