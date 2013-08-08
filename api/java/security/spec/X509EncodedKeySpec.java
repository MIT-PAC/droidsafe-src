package java.security.spec;

// Droidsafe Imports
import droidsafe.annotations.*;




public class X509EncodedKeySpec extends EncodedKeySpec {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.127 -0400", hash_original_method = "653C2DD285722882E5BF9CD68F7E16B1", hash_generated_method = "ECC9E13798F16EAF312A2831A733D588")
    public  X509EncodedKeySpec(byte[] encodedKey) {
        super(encodedKey);
        addTaint(encodedKey[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.127 -0400", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "C745A2AE0A1863CD0370B772982D3631")
    public byte[] getEncoded() {
        byte[] varE852F609BBA3F241A4F96363DE8BC6BE_1927365275 = (super.getEncoded());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2061868378 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2061868378;
        // ---------- Original Method ----------
        //return super.getEncoded();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.128 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "CF15A3B32D9350E5EF66516339D99475")
    public final String getFormat() {
String varF820115C876B7F160DE375988A3E1CA1_678351272 =         "X.509";
        varF820115C876B7F160DE375988A3E1CA1_678351272.addTaint(taint);
        return varF820115C876B7F160DE375988A3E1CA1_678351272;
        // ---------- Original Method ----------
        //return "X.509";
    }

    
}

