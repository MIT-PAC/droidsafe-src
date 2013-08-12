package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;






public final class GeneralSubtree {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.367 -0400", hash_original_field = "593616DE15330C0FB2D55E55410BF994", hash_generated_field = "D4C59288F044029ACC216DF9F428B5A5")

    private GeneralName base;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.367 -0400", hash_original_field = "E383234C8C5C6CF7EB44A3208E26D50F", hash_generated_field = "DF1194E902CF1427179A6F866A8E882A")

    private int minimum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.368 -0400", hash_original_field = "65B0E2883C997F2BEA5DD11C923B94CF", hash_generated_field = "200D32EAFEBE33D0C2D225E12493D6CC")

    private int maximum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.368 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.369 -0400", hash_original_method = "438D69377D52986D40A8B5F5E96E3A6B", hash_generated_method = "33C4C368992CAD0DD88C217B1E59C1D3")
    public  GeneralSubtree(GeneralName base, int minimum, int maximum) {
        this.base = base;
        this.minimum = minimum;
        this.maximum = maximum;
        // ---------- Original Method ----------
        //this.base = base;
        //this.minimum = minimum;
        //this.maximum = maximum;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.369 -0400", hash_original_method = "FBC8A3DE80F48DE1891C2D6208F82433", hash_generated_method = "D461F635EB8A7022C3B95CD0298B4EB5")
    public GeneralName getBase() {
GeneralName var530A7BC087253E083043013B3EB0C6E6_1266456447 =         base;
        var530A7BC087253E083043013B3EB0C6E6_1266456447.addTaint(taint);
        return var530A7BC087253E083043013B3EB0C6E6_1266456447;
        // ---------- Original Method ----------
        //return base;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.370 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "649BB30045490594A992E635B2BAB0E7")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1821286709 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_507094716 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_507094716;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.371 -0400", hash_original_method = "EBC343B993E4A537A05E52D600D1ECC2", hash_generated_method = "A2E3B8EE54F98950D43AE6AAB65594AC")
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("General Subtree: [\n");
        sb.append(prefix).append("  base: ").append(base).append('\n');
        sb.append(prefix).append("  minimum: ").append(minimum).append('\n');
        if(maximum >= 0)        
        {
            sb.append(prefix).append("  maximum: ").append(maximum).append('\n');
        } //End block
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("General Subtree: [\n");
        //sb.append(prefix).append("  base: ").append(base).append('\n');
        //sb.append(prefix).append("  minimum: ").append(minimum).append('\n');
        //if (maximum >= 0) {
            //sb.append(prefix).append("  maximum: ").append(maximum).append('\n');
        //}
        //sb.append(prefix).append("]\n");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.372 -0400", hash_original_field = "A4A9244C70C9136A6603EBC7858DB58B", hash_generated_field = "94DF6DD1FA4D2001319C2DBA7E60AB56")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            GeneralName.ASN1,
            new ASN1Implicit(0, ASN1Integer.getInstance()),
            new ASN1Implicit(1, ASN1Integer.getInstance()) }) {
        {
            setDefault(new byte[] {0}, 1);  
            setOptional(2);                 
        }

        @DSModeled(DSC.BAN)
        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            int maximum = -1; 
            if (values[2] != null) {
                maximum = ASN1Integer.toIntValue(values[2]); 
            }
            return new GeneralSubtree((GeneralName) values[0],
                    ASN1Integer.toIntValue(values[1]),
                    maximum);
        }

        @Override protected void getValues(Object object, Object[] values) {
            GeneralSubtree gs = (GeneralSubtree) object;
            values[0] = gs.base;
            values[1] = ASN1Integer.fromIntValue(gs.minimum);
            if (gs.maximum > -1) {
                values[2] = ASN1Integer.fromIntValue(gs.maximum);
            }
        }
    };
}

