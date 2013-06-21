package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public final class AlternativeName extends ExtensionValue {
    private boolean which;
    private GeneralNames alternativeNames;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.536 -0400", hash_original_method = "1E01F580CB089394F15961B5A9E514F5", hash_generated_method = "86372DE5444D580836D857CE23E78400")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AlternativeName(boolean which, byte[] encoding) throws IOException {
        super(encoding);
        dsTaint.addTaint(which);
        dsTaint.addTaint(encoding[0]);
        this.alternativeNames = (GeneralNames) GeneralNames.ASN1.decode(encoding);
        // ---------- Original Method ----------
        //this.which = which;
        //this.alternativeNames = (GeneralNames) GeneralNames.ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.536 -0400", hash_original_method = "A70D2DB25ABF0E0F1A8BC79C0C161D91", hash_generated_method = "DA996E58F78BD7C6E564CE2F9BAE1282")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = GeneralNames.ASN1.encode(alternativeNames);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = GeneralNames.ASN1.encode(alternativeNames);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.536 -0400", hash_original_method = "62E9965B6B09CF0D2F916BAB455CC9AA", hash_generated_method = "A86E712CE4C2D4880FF4451DD2F5AC9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append((which) ? "Subject" : "Issuer").append(" Alternative Names [\n");
        alternativeNames.dumpValue(sb, prefix + "  ");
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append((which) ? "Subject" : "Issuer").append(" Alternative Names [\n");
        //alternativeNames.dumpValue(sb, prefix + "  ");
        //sb.append(prefix).append("]\n");
    }

    
    public static final boolean ISSUER = false;
    public static final boolean SUBJECT = true;
}

