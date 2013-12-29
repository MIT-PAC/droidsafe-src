package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;






public final class GeneralSubtree {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.372 -0400", hash_original_field = "A4A9244C70C9136A6603EBC7858DB58B", hash_generated_field = "94DF6DD1FA4D2001319C2DBA7E60AB56")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            GeneralName.ASN1,
            new ASN1Implicit(0, ASN1Integer.getInstance()),
            new ASN1Implicit(1, ASN1Integer.getInstance()) }) {
        {
            setDefault(new byte[] {0}, 1);  
            setOptional(2);                 
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.466 -0500", hash_original_method = "2A7F97C8A163408D03702038DFF11AD2", hash_generated_method = "038ADCFF15EEB48B6D7956977B848C28")
        @Override
protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            int maximum = -1; // is optional maximum missing?
            if (values[2] != null) {
                maximum = ASN1Integer.toIntValue(values[2]); // no!
            }
            return new GeneralSubtree((GeneralName) values[0],
                    ASN1Integer.toIntValue(values[1]),
                    maximum);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.467 -0500", hash_original_method = "ACDF1910F99EABBA7FBE75C880969DB4", hash_generated_method = "E859720157F2138D88810BEE440DD4EF")
        @Override
protected void getValues(Object object, Object[] values) {
            GeneralSubtree gs = (GeneralSubtree) object;
            values[0] = gs.base;
            values[1] = ASN1Integer.fromIntValue(gs.minimum);
            if (gs.maximum > -1) {
                values[2] = ASN1Integer.fromIntValue(gs.maximum);
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.458 -0500", hash_original_field = "4473A5B703C9A75A045844AF26A457F3", hash_generated_field = "D4C59288F044029ACC216DF9F428B5A5")

    private  GeneralName base;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.459 -0500", hash_original_field = "1766D4DE71334BDF790BCFBB6158CB69", hash_generated_field = "DF1194E902CF1427179A6F866A8E882A")

    private  int minimum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.460 -0500", hash_original_field = "C8F5D4F0C667CD971F1EB0FDA004ADC5", hash_generated_field = "200D32EAFEBE33D0C2D225E12493D6CC")

    private  int maximum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.461 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.462 -0500", hash_original_method = "438D69377D52986D40A8B5F5E96E3A6B", hash_generated_method = "33AB9559EC0212CB153B9E4D5CFB440F")
    public GeneralSubtree(GeneralName base, int minimum, int maximum) {
        this.base = base;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    /**
     * Returns the value of base field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.463 -0500", hash_original_method = "FBC8A3DE80F48DE1891C2D6208F82433", hash_generated_method = "D43912BB46053FFED3C902B7F059B477")
    public GeneralName getBase() {
        return base;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 GeneralSubtree value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.463 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.464 -0500", hash_original_method = "EBC343B993E4A537A05E52D600D1ECC2", hash_generated_method = "F00528971D68569CE57D312D14770E2D")
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("General Subtree: [\n");
        sb.append(prefix).append("  base: ").append(base).append('\n');
        sb.append(prefix).append("  minimum: ").append(minimum).append('\n');
        if (maximum >= 0) {
            sb.append(prefix).append("  maximum: ").append(maximum).append('\n');
        }
        sb.append(prefix).append("]\n");
    }
}

