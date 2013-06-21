package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class GeneralSubtrees {
    private List<GeneralSubtree> generalSubtrees;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.798 -0400", hash_original_method = "2635B7CAB7F4197126741D8B5E9A6725", hash_generated_method = "B29C86203CC1BAA49411AB30B2B83EAB")
    @DSModeled(DSC.SAFE)
    public GeneralSubtrees(List<GeneralSubtree> generalSubtrees) {
        dsTaint.addTaint(generalSubtrees.dsTaint);
        // ---------- Original Method ----------
        //this.generalSubtrees = generalSubtrees;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.798 -0400", hash_original_method = "B39087273D015207EFED9684375F7A9C", hash_generated_method = "8E1FF0903DBE86F2ABF12EDC2D763447")
    @DSModeled(DSC.SAFE)
    public List<GeneralSubtree> getSubtrees() {
        return (List<GeneralSubtree>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return generalSubtrees;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.798 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    public static final ASN1Type ASN1 = new ASN1SequenceOf(GeneralSubtree.ASN1) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.798 -0400", hash_original_method = "2D9DF534E99C5FC68E76E143BAF9A37A", hash_generated_method = "1AC1B267F9EE369DF6469DEDE1772A06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object var934C96467631C6BEB2709DDE0E371C5D_1438832728 = (new GeneralSubtrees((List<GeneralSubtree>) in.content));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new GeneralSubtrees((List<GeneralSubtree>) in.content);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.798 -0400", hash_original_method = "2D1C7EBFAAEEE93820419C378A46DB40", hash_generated_method = "D6F83F858AA1582481606122F91F759F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection getValues(Object object) {
            dsTaint.addTaint(object.dsTaint);
            GeneralSubtrees gss;
            gss = (GeneralSubtrees) object;
            {
                Object varE90405DCA4136A80E794662F1CC6CC99_1093543407 = (new ArrayList<GeneralSubtree>());
            } //End flattened ternary
            return (Collection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //GeneralSubtrees gss = (GeneralSubtrees) object;
            //return (gss.generalSubtrees == null)
                    //? new ArrayList<GeneralSubtree>()
                    //: gss.generalSubtrees;
        }

        
}; //Transformed anonymous class
}

