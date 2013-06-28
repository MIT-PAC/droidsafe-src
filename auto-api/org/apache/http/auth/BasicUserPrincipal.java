package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Principal;
import org.apache.http.util.LangUtils;

public final class BasicUserPrincipal implements Principal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.646 -0400", hash_original_field = "14C4B06B824EC593239362517F538B29", hash_generated_field = "E7582A281BF492F7D35360548F0218CD")

    private String username;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.647 -0400", hash_original_method = "E9F4A83469279A4A12C48F4EEC0817B3", hash_generated_method = "EAAC5E7F816506E5CB9FECD99991D180")
    public  BasicUserPrincipal(final String username) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("User name may not be null");
        } //End block
        this.username = username;
        // ---------- Original Method ----------
        //if (username == null) {
            //throw new IllegalArgumentException("User name may not be null");
        //}
        //this.username = username;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.648 -0400", hash_original_method = "C98891613636EF2965B8BFD539D89D43", hash_generated_method = "53B941DF0818E187B6561256FAA119E3")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1495857450 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1495857450 = this.username;
        varB4EAC82CA7396A68D541C85D26508E83_1495857450.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1495857450;
        // ---------- Original Method ----------
        //return this.username;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.648 -0400", hash_original_method = "00146F6E979B31F3ADD0C335BB09FECD", hash_generated_method = "130E8FF442699E883A94F228996D55D6")
    @Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.username);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915979321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915979321;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.username);
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.649 -0400", hash_original_method = "0828205FE5941175F133283554EC0DB0", hash_generated_method = "F81A084B518640EC41E852900C9703F6")
    @Override
    public boolean equals(Object o) {
        {
            BasicUserPrincipal that = (BasicUserPrincipal) o;
            {
                boolean varF92F658304E2DA5C37A69EDBE220FE21_1707029327 = (LangUtils.equals(this.username, that.username));
            } //End collapsed parenthetic
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1232870372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1232870372;
        // ---------- Original Method ----------
        //if (o == null) return false;
        //if (this == o) return true;
        //if (o instanceof BasicUserPrincipal) {
            //BasicUserPrincipal that = (BasicUserPrincipal) o;
            //if (LangUtils.equals(this.username, that.username)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.649 -0400", hash_original_method = "7E163E1A4FB07693AC35A1158CCAD841", hash_generated_method = "DA2CF3BC1A7883CD2A12300AF39481B7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_179458528 = null; //Variable for return #1
        StringBuilder buffer = new StringBuilder();
        buffer.append("[principal: ");
        buffer.append(this.username);
        buffer.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_179458528 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_179458528.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_179458528;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //buffer.append("[principal: ");
        //buffer.append(this.username);
        //buffer.append("]");
        //return buffer.toString();
    }

    
}

