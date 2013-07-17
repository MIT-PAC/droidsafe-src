package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class GeneralSubtrees {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.382 -0400", hash_original_field = "E53F856F6B113AD6085151AAADA65843", hash_generated_field = "C2874F586CC3974C74476D82AF1EF2DD")

    private List<GeneralSubtree> generalSubtrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.382 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.383 -0400", hash_original_method = "2635B7CAB7F4197126741D8B5E9A6725", hash_generated_method = "C3A2A15D403107D1B4897DD6AE5129D3")
    public  GeneralSubtrees(List<GeneralSubtree> generalSubtrees) {
        this.generalSubtrees = generalSubtrees;
        // ---------- Original Method ----------
        //this.generalSubtrees = generalSubtrees;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.384 -0400", hash_original_method = "B39087273D015207EFED9684375F7A9C", hash_generated_method = "0D504157073CD1283ACEBF4FF6231883")
    public List<GeneralSubtree> getSubtrees() {
List<GeneralSubtree> var3E5BAD48CE158B3B7A2AD7B7425D5701_873292195 =         generalSubtrees;
        var3E5BAD48CE158B3B7A2AD7B7425D5701_873292195.addTaint(taint);
        return var3E5BAD48CE158B3B7A2AD7B7425D5701_873292195;
        // ---------- Original Method ----------
        //return generalSubtrees;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.385 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "987DEBDB3DAB4E906C00F526F7AD40F6")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_2134553649 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_998107618 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_998107618;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.385 -0400", hash_original_field = "0799060D53393B92181BE0F337148C10", hash_generated_field = "E8931CE4F0A844140DFFB6382D546C0B")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(GeneralSubtree.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) {
            return new GeneralSubtrees((List<GeneralSubtree>) in.content);
        }

        @Override public Collection getValues(Object object) {
            GeneralSubtrees gss = (GeneralSubtrees) object;
            return (gss.generalSubtrees == null)
                    ? new ArrayList<GeneralSubtree>()
                    : gss.generalSubtrees;
        }
    };
}

