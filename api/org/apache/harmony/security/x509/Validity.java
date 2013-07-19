package org.apache.harmony.security.x509;

// Droidsafe Imports
import java.util.Date;

import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class Validity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.961 -0400", hash_original_field = "CF2C84750B842AAA309ECBA4D79FF935", hash_generated_field = "E3E827D7CD2761B5AB55619FED686D61")

    private Date notBefore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.962 -0400", hash_original_field = "21F1BA3A4A4A624D712B87C23B2FD95A", hash_generated_field = "9EC5214487C0E45ED3A209D46FF5E8A8")

    private Date notAfter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.962 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.963 -0400", hash_original_method = "F8867A5D4F27966CF2038460A4C147B6", hash_generated_method = "3695B438AEFDA2C428F57F58CBFD712B")
    public  Validity(Date notBefore, Date notAfter) {
        this.notBefore = notBefore;
        this.notAfter = notAfter;
        // ---------- Original Method ----------
        //this.notBefore = notBefore;
        //this.notAfter = notAfter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.963 -0400", hash_original_method = "CB2A2B3C356F1AD47950BB2253ACA4BD", hash_generated_method = "19EB30D97334D79B412E3E16DB01D52C")
    public Date getNotBefore() {
Date varA538B0CD17616FA44CA9B918B38CAEAC_1267624718 =         notBefore;
        varA538B0CD17616FA44CA9B918B38CAEAC_1267624718.addTaint(taint);
        return varA538B0CD17616FA44CA9B918B38CAEAC_1267624718;
        // ---------- Original Method ----------
        //return notBefore;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.964 -0400", hash_original_method = "9EADF7E1E76408811693CE379F621727", hash_generated_method = "734587180A88403D6DDA8D572F18030C")
    public Date getNotAfter() {
Date varE84253AB2AD08AA2E1E3A8582D622350_1851212332 =         notAfter;
        varE84253AB2AD08AA2E1E3A8582D622350_1851212332.addTaint(taint);
        return varE84253AB2AD08AA2E1E3A8582D622350_1851212332;
        // ---------- Original Method ----------
        //return notAfter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.964 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "40DA029A5493E251E04E88036CCC9651")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_301398562 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2000996889 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2000996889;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.964 -0400", hash_original_field = "A6DF2012EFBA1C423892102016009D73", hash_generated_field = "07FA11BFB5637FC4281B8963015521E1")

    public static final ASN1Sequence ASN1
        = new ASN1Sequence(new ASN1Type[] {Time.ASN1, Time.ASN1 }) {

		@DSModeled(DSC.SAFE)
        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new Validity((Date) values[0], (Date) values[1]);
        }

		@DSModeled(DSC.SAFE)
        @Override protected void getValues(Object object, Object[] values) {
            Validity validity = (Validity) object;
            values[0] = validity.notBefore;
            values[1] = validity.notAfter;
        }
    };
}

