package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class ASN1SetOf extends ASN1ValueCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.686 -0400", hash_original_method = "49B473C463A20ED93456B0E252B9BBF0", hash_generated_method = "010E6CB1BA97B161E8C9420B580E2B49")
    public  ASN1SetOf(ASN1Type type) {
        super(TAG_SETOF, type);
        addTaint(type.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.687 -0400", hash_original_method = "F57C1115BE0470F5CDF9CC2B3F700EBD", hash_generated_method = "C235DED4668E88F4C1BE79E8EFE24848")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readSetOf(this);
    if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_1184401685 =             null;
            var540C13E9E156B687226421B24F2DF178_1184401685.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1184401685;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_1780058769 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_1780058769.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_1780058769;
        // ---------- Original Method ----------
        //in.readSetOf(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.687 -0400", hash_original_method = "4C2F70C283FCFB9FEA82A949984FC67E", hash_generated_method = "0827019D7A2255E28CF9AFFA00193EDC")
    public final void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeSetOf(this);
        // ---------- Original Method ----------
        //out.encodeSetOf(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.687 -0400", hash_original_method = "0CA5076CBF895038CB7C559B8AB50108", hash_generated_method = "B531A45ED0551EC508FC67E901F2C395")
    public final void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.getSetOfLength(this);
        // ---------- Original Method ----------
        //out.getSetOfLength(this);
    }

    
}

