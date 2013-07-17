package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.AlgNameMapper;

public final class AlgorithmIdentifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.785 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.785 -0400", hash_original_field = "D74BA757D8516B995BEF66ADBC091A9F", hash_generated_field = "4A61F6719BEAA78381132679E3C29E60")

    private String algorithmName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.785 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "BDB7CE72F1F070C790060F407EE69616")

    private byte[] parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.785 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.786 -0400", hash_original_method = "2A12FAF842ACAA2DBD4904F8F0273D03", hash_generated_method = "2EBF08AB7CEC761BB58F4F2AC8E07597")
    public  AlgorithmIdentifier(String algorithm) {
        this(algorithm, null, null);
        addTaint(algorithm.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.786 -0400", hash_original_method = "3A9ADFAB73D31AB7E50DF2B242FDEB53", hash_generated_method = "12A74528D275DAB41B9C77B0333CD230")
    public  AlgorithmIdentifier(String algorithm, byte[] parameters) {
        this(algorithm, parameters, null);
        addTaint(parameters[0]);
        addTaint(algorithm.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.787 -0400", hash_original_method = "D2431539DF2ECCEF9FBA946BEDC34F61", hash_generated_method = "B03A559CDDF8734F7178FAD091F38793")
    private  AlgorithmIdentifier(String algorithm, byte[] parameters, byte[] encoding) {
        this.algorithm = algorithm;
        this.parameters = parameters;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
        //this.parameters = parameters;
        //this.encoding = encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.788 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "E430BF9AC3B914429AB8074C93B1DDDA")
    public String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_925138110 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_925138110.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_925138110;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.788 -0400", hash_original_method = "EFA02412B3D98573C0B83612EF561CD2", hash_generated_method = "7C2783F8861A8B06C1DC4EB5D3C8DCDB")
    public String getAlgorithmName() {
        if(algorithmName == null)        
        {
            algorithmName = AlgNameMapper.map2AlgName(algorithm);
            if(algorithmName == null)            
            {
                algorithmName = algorithm;
            } //End block
        } //End block
String var2F10FAEB775F4B5DF3001375F37870C3_762411297 =         algorithmName;
        var2F10FAEB775F4B5DF3001375F37870C3_762411297.addTaint(taint);
        return var2F10FAEB775F4B5DF3001375F37870C3_762411297;
        // ---------- Original Method ----------
        //if (algorithmName == null) {
            //algorithmName = AlgNameMapper.map2AlgName(algorithm);
            //if (algorithmName == null) {
                //algorithmName = algorithm;
            //}
        //}
        //return algorithmName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.789 -0400", hash_original_method = "360B58AAED509D402161560B83FBF1AD", hash_generated_method = "D64BE671877B9D3037AED7A02A2F5FF1")
    public byte[] getParameters() {
        byte[] var166E64F6C3677D0C513901242A3E702D_89799497 = (parameters);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_703168000 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_703168000;
        // ---------- Original Method ----------
        //return parameters;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.789 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "E64BDA7C7D0D23AA177578963E65805C")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_59398775 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_166829527 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_166829527;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.790 -0400", hash_original_method = "CF4BFB68A01F84A2E157841F7FC296C6", hash_generated_method = "69F4BF891D9BA5D427EFB5FDEAF01B74")
    @Override
    public boolean equals(Object ai) {
        addTaint(ai.getTaint());
        if(!(ai instanceof AlgorithmIdentifier))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2028586726 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_631508267 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_631508267;
        } //End block
        AlgorithmIdentifier algid = (AlgorithmIdentifier) ai;
        boolean var685CF0CB3386C3A710FD03431FA58B76_634721640 = ((algorithm.equals(algid.algorithm))
            && ((parameters == null)
                    ? algid.parameters == null
                    : Arrays.equals(parameters, algid.parameters)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194187942 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194187942;
        // ---------- Original Method ----------
        //if (!(ai instanceof AlgorithmIdentifier)) {
            //return false;
        //}
        //AlgorithmIdentifier algid = (AlgorithmIdentifier) ai;
        //return (algorithm.equals(algid.algorithm))
            //&& ((parameters == null)
                    //? algid.parameters == null
                    //: Arrays.equals(parameters, algid.parameters));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.791 -0400", hash_original_method = "E65C54FCC20A7D2FAC5D39EC6758FF2C", hash_generated_method = "3E62AFAC90EED385B206EB74D946FE6D")
    @Override
    public int hashCode() {
        int var1FA5D2E5DE5434E7F76D626DE91EE834_897518337 = (algorithm.hashCode() * 37 + (parameters != null ? Arrays.hashCode(parameters) : 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_563022303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_563022303;
        // ---------- Original Method ----------
        //return algorithm.hashCode() * 37 + (parameters != null ? Arrays.hashCode(parameters) : 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.792 -0400", hash_original_method = "BB3CE84D97D9ED23CA58D78F5AD0AB33", hash_generated_method = "ED9C4B999F2E0516BDA8743856A6566D")
    public void dumpValue(StringBuilder sb) {
        addTaint(sb.getTaint());
        sb.append(getAlgorithmName());
        if(parameters == null)        
        {
            sb.append(", no params, ");
        } //End block
        else
        {
            sb.append(", params unparsed, ");
        } //End block
        sb.append("OID = ");
        sb.append(getAlgorithm());
        // ---------- Original Method ----------
        //sb.append(getAlgorithmName());
        //if (parameters == null) {
            //sb.append(", no params, ");
        //} else {
            //sb.append(", params unparsed, ");
        //}
        //sb.append("OID = ");
        //sb.append(getAlgorithm());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.792 -0400", hash_original_field = "0379B40A69260257BE6FAF87FE8921A2", hash_generated_field = "D57B6C9D256FA01BB83ACCC1550296AC")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(), ASN1Any.getInstance() }) {
        {
            setOptional(1); 
        }

        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new AlgorithmIdentifier(ObjectIdentifier
                    .toString((int[]) values[0]), (byte[]) values[1]);
        }

        @Override protected void getValues(Object object, Object[] values) {

            AlgorithmIdentifier aID = (AlgorithmIdentifier) object;

            values[0] = ObjectIdentifier.toIntArray(aID.getAlgorithm());
            values[1] = aID.getParameters();
        }
    };
}

