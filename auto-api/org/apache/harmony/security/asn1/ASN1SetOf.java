package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ASN1SetOf extends ASN1ValueCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.999 -0400", hash_original_method = "49B473C463A20ED93456B0E252B9BBF0", hash_generated_method = "1CB3D5EAEFED0E033B8968ECF0C5E42B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1SetOf(ASN1Type type) {
        super(TAG_SETOF, type);
        dsTaint.addTaint(type.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.999 -0400", hash_original_method = "F57C1115BE0470F5CDF9CC2B3F700EBD", hash_generated_method = "41894AE7381AA6F81E09070B205C934B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readSetOf(this);
        Object var883E4A51D9FE1FCA5622395E00C94DE9_1899578138 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readSetOf(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.999 -0400", hash_original_method = "4C2F70C283FCFB9FEA82A949984FC67E", hash_generated_method = "BA88158216FF568A377EC30B4B581D07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeSetOf(this);
        // ---------- Original Method ----------
        //out.encodeSetOf(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.999 -0400", hash_original_method = "0CA5076CBF895038CB7C559B8AB50108", hash_generated_method = "C07F3B935DB938A620F416E99775D69D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.getSetOfLength(this);
        // ---------- Original Method ----------
        //out.getSetOfLength(this);
    }

    
}

