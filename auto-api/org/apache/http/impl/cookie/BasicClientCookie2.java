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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.090 -0400", hash_original_field = "809FFB37A1E25E47BFCCD448CD9CFC3D", hash_generated_field = "6A2B50CEA40AC67F646E005F8BAEDBCB")

    private String commentURL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.091 -0400", hash_original_field = "47F06098D3034F593871B524CE4F7965", hash_generated_field = "10C002323FE5D85E96EB29FD69E0FF2A")

    private int[] ports;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.091 -0400", hash_original_field = "70F68BB2F748B85DE6526BFE236EA1E9", hash_generated_field = "33439C2B9FDD0CF9B54F1993B130A7B9")

    private boolean discard;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.092 -0400", hash_original_method = "B06BAED2E07D7F9218D98A385CC362B8", hash_generated_method = "8568B32E9F92EA8135C34B32CA128696")
    public  BasicClientCookie2(final String name, final String value) {
        super(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.093 -0400", hash_original_method = "95D16F8D855E74509F3FC69A633DD645", hash_generated_method = "D61126837E5FC430842465F1198FEBF5")
    @Override
    public int[] getPorts() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_225033955 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_225033955;
        // ---------- Original Method ----------
        //return this.ports;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.093 -0400", hash_original_method = "764909B3E1563DDB6A65C5637CB4CC25", hash_generated_method = "C9B871E54B4C065A0B7E18343F865239")
    public void setPorts(final int[] ports) {
        this.ports = ports;
        // ---------- Original Method ----------
        //this.ports = ports;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.110 -0400", hash_original_method = "601AD280A8E13C6CCEB794F77493867D", hash_generated_method = "C286AE4E9D80FB3740100E62D0DD6D39")
    @Override
    public String getCommentURL() {
        String varB4EAC82CA7396A68D541C85D26508E83_378199929 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_378199929 = this.commentURL;
        varB4EAC82CA7396A68D541C85D26508E83_378199929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_378199929;
        // ---------- Original Method ----------
        //return this.commentURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.110 -0400", hash_original_method = "D3350C04B38359935C8E8B49E5A32164", hash_generated_method = "0459F7D7F51F9287B0A6EC8A909F9C50")
    public void setCommentURL(final String commentURL) {
        this.commentURL = commentURL;
        // ---------- Original Method ----------
        //this.commentURL = commentURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.110 -0400", hash_original_method = "9446CEDD4455A1D30E4774BBDD3B750C", hash_generated_method = "E6CDF344C6C1B9923E6E003A3B1B943D")
    public void setDiscard(boolean discard) {
        this.discard = discard;
        // ---------- Original Method ----------
        //this.discard = discard;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.110 -0400", hash_original_method = "417FDF5C1FC11A52F2E0DFC4D001D3E3", hash_generated_method = "10D702950D636E27B8338962F5B987D7")
    @Override
    public boolean isPersistent() {
        boolean var8894A75FFDDE4B7033639E14D54C822E_495060664 = (!this.discard && super.isPersistent());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833822369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_833822369;
        // ---------- Original Method ----------
        //return !this.discard && super.isPersistent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.111 -0400", hash_original_method = "D5A8F73F69F1E942ED94DA98E7190BDB", hash_generated_method = "CF58EE7AC37E2B28096F4D539E7AF907")
    @Override
    public boolean isExpired(final Date date) {
        boolean var621414755AA498F27D3D764BF6C36F4D_2090329293 = (this.discard || super.isExpired(date));
        addTaint(date.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309742663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309742663;
        // ---------- Original Method ----------
        //return this.discard || super.isExpired(date);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.111 -0400", hash_original_method = "A1E29AF284BD9497DEE668CED1078224", hash_generated_method = "0A049AB23D84921223B706B6C31A7B2A")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_228283410 = null; //Variable for return #1
        BasicClientCookie2 clone;
        clone = (BasicClientCookie2) super.clone();
        clone.ports = this.ports.clone();
        varB4EAC82CA7396A68D541C85D26508E83_228283410 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_228283410.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_228283410;
        // ---------- Original Method ----------
        //BasicClientCookie2 clone = (BasicClientCookie2) super.clone();
        //clone.ports = this.ports.clone();
        //return clone;
    }

    
}

