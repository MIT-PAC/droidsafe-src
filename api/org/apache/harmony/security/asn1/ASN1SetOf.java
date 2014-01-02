package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;





public class ASN1SetOf extends ASN1ValueCollection {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.794 -0500", hash_original_method = "49B473C463A20ED93456B0E252B9BBF0", hash_generated_method = "27EC557B543879A8060897015DF120E2")
    
public ASN1SetOf(ASN1Type type) {
        super(TAG_SETOF, type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.796 -0500", hash_original_method = "F57C1115BE0470F5CDF9CC2B3F700EBD", hash_generated_method = "B8EC7B4AD768A636B4D2ADBE2FCBAA14")
    
public Object decode(BerInputStream in) throws IOException {
        in.readSetOf(this);

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.798 -0500", hash_original_method = "4C2F70C283FCFB9FEA82A949984FC67E", hash_generated_method = "5730048EE6F6C9380CCF1262C905377F")
    
public final void encodeContent(BerOutputStream out) {
        out.encodeSetOf(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.801 -0500", hash_original_method = "0CA5076CBF895038CB7C559B8AB50108", hash_generated_method = "FAC6A4B55096B66377F72C9E45AD2DE4")
    
public final void setEncodingContent(BerOutputStream out) {
        out.getSetOfLength(this);
    }

    
}

