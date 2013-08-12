package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;






public final class AlternativeName extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.801 -0400", hash_original_field = "8B7AF514F25F1F9456DCD10D2337F753", hash_generated_field = "146204F60619F6B5AD05FE88D008D17D")

    private boolean which;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.801 -0400", hash_original_field = "C624E704B24EB318F9C13835671F0EA2", hash_generated_field = "2EF7A1335D6CE946FADF8342BE852EA9")

    private GeneralNames alternativeNames;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.802 -0400", hash_original_method = "1E01F580CB089394F15961B5A9E514F5", hash_generated_method = "32210F953BEB66A9F259D9B8FC9AD15D")
    public  AlternativeName(boolean which, byte[] encoding) throws IOException {
        super(encoding);
        this.which = which;
        this.alternativeNames = (GeneralNames) GeneralNames.ASN1.decode(encoding);
        // ---------- Original Method ----------
        //this.which = which;
        //this.alternativeNames = (GeneralNames) GeneralNames.ASN1.decode(encoding);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.802 -0400", hash_original_method = "A70D2DB25ABF0E0F1A8BC79C0C161D91", hash_generated_method = "8B9FCC07E57F688FE9E0C7B58463D3C2")
    @Override
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = GeneralNames.ASN1.encode(alternativeNames);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1901806701 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1283328169 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1283328169;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = GeneralNames.ASN1.encode(alternativeNames);
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.802 -0400", hash_original_method = "62E9965B6B09CF0D2F916BAB455CC9AA", hash_generated_method = "DB1DABD5F91C43129AC61B45A3862F60")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append((which) ? "Subject" : "Issuer").append(" Alternative Names [\n");
        alternativeNames.dumpValue(sb, prefix + "  ");
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append((which) ? "Subject" : "Issuer").append(" Alternative Names [\n");
        //alternativeNames.dumpValue(sb, prefix + "  ");
        //sb.append(prefix).append("]\n");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.803 -0400", hash_original_field = "2E739D027BF1A99E55E7EB8D5A278D39", hash_generated_field = "239492A34C7B952C5A00DBFA1A39F33F")

    public static final boolean ISSUER = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.803 -0400", hash_original_field = "65B5F086A740391A32E21DFC2EEE9DBD", hash_generated_field = "936E14E3BE58C80A27331B11D5D14123")

    public static final boolean SUBJECT = true;
}

