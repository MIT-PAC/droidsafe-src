package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public final class ASN1Any extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.906 -0400", hash_original_method = "DC9940F4B091FD322F1F3A80DE5DA9F7", hash_generated_method = "4BC9F36E0DA8D5C47FBAC49DEA0BD42A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Any() {
        super(TAG_ANY);
        // ---------- Original Method ----------
    }

    
        public static ASN1Any getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.907 -0400", hash_original_method = "0A9787140DA63C802B73071FD0FF80EC", hash_generated_method = "0872EF548B94F8F0C983E77330666F77")
    @DSModeled(DSC.SAFE)
    public final boolean checkTag(int identifier) {
        dsTaint.addTaint(identifier);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.907 -0400", hash_original_method = "F8B6556748DA568C4BCDCD3BC4853721", hash_generated_method = "D090296F40F279FA0CB7B90175C04028")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readContent();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_2069686819 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readContent();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.907 -0400", hash_original_method = "7A8EAE0B0D15C25D8FE798817C72F0C1", hash_generated_method = "EBF426B5D2BD2A9F29DF06ACF1F70DD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        byte[] bytesEncoded;
        bytesEncoded = new byte[in.offset - in.tagOffset];
        System.arraycopy(in.buffer, in.tagOffset, bytesEncoded, 0,
                bytesEncoded.length);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byte[] bytesEncoded = new byte[in.offset - in.tagOffset];
        //System.arraycopy(in.buffer, in.tagOffset, bytesEncoded, 0,
                //bytesEncoded.length);
        //return bytesEncoded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.907 -0400", hash_original_method = "7511C9B0E36E939B1775FC9EA0F02F20", hash_generated_method = "A376AE291E53AFF5CA3930E5A31657BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeASN(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeANY();
        // ---------- Original Method ----------
        //out.encodeANY();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.907 -0400", hash_original_method = "E4481BCA62553D7934DD52F370937ED4", hash_generated_method = "D5CB55DD49737A2476087A3BAB91D4D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeANY();
        // ---------- Original Method ----------
        //out.encodeANY();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.908 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "5880804059FB3DAF2086019E77E60A22")
    @DSModeled(DSC.SAFE)
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.908 -0400", hash_original_method = "4E35D9A00930BDC0DD7D3944E7329986", hash_generated_method = "319582D34A53102EAAE151F9132AC982")
    @DSModeled(DSC.SAFE)
    public int getEncodedLength(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return out.length;
    }

    
    private static final ASN1Any ASN1= new ASN1Any();
}

