package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.AlgNameMapper;

public final class AlgorithmIdentifier {
    private String algorithm;
    private String algorithmName;
    private byte[] parameters;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.530 -0400", hash_original_method = "2A12FAF842ACAA2DBD4904F8F0273D03", hash_generated_method = "C6BD7A1735281DA05340229A2EAFABC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AlgorithmIdentifier(String algorithm) {
        this(algorithm, null, null);
        dsTaint.addTaint(algorithm);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.530 -0400", hash_original_method = "3A9ADFAB73D31AB7E50DF2B242FDEB53", hash_generated_method = "5857A90BAFA5291D91039800BEDD5778")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AlgorithmIdentifier(String algorithm, byte[] parameters) {
        this(algorithm, parameters, null);
        dsTaint.addTaint(parameters[0]);
        dsTaint.addTaint(algorithm);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.530 -0400", hash_original_method = "D2431539DF2ECCEF9FBA946BEDC34F61", hash_generated_method = "40AA68C04F93D88E0389353A6D475C02")
    @DSModeled(DSC.SAFE)
    private AlgorithmIdentifier(String algorithm, byte[] parameters, byte[] encoding) {
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(parameters[0]);
        dsTaint.addTaint(algorithm);
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
        //this.parameters = parameters;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.530 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "AB6B64DEEAE2006CFA3127C5F18A75FB")
    @DSModeled(DSC.SAFE)
    public String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.531 -0400", hash_original_method = "EFA02412B3D98573C0B83612EF561CD2", hash_generated_method = "ABB876090570CEC279F4995356C9891D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAlgorithmName() {
        {
            algorithmName = AlgNameMapper.map2AlgName(algorithm);
            {
                algorithmName = algorithm;
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (algorithmName == null) {
            //algorithmName = AlgNameMapper.map2AlgName(algorithm);
            //if (algorithmName == null) {
                //algorithmName = algorithm;
            //}
        //}
        //return algorithmName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.531 -0400", hash_original_method = "360B58AAED509D402161560B83FBF1AD", hash_generated_method = "03158335FE4218019B49C8C7A72789F1")
    @DSModeled(DSC.SAFE)
    public byte[] getParameters() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.531 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.531 -0400", hash_original_method = "CF4BFB68A01F84A2E157841F7FC296C6", hash_generated_method = "188363CB135753C4C2C70C807A8F92E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object ai) {
        dsTaint.addTaint(ai.dsTaint);
        AlgorithmIdentifier algid;
        algid = (AlgorithmIdentifier) ai;
        boolean varFF1C3FA168E06CAC42B1D1728A51F2BD_132755687 = ((algorithm.equals(algid.algorithm))
            && ((parameters == null)
                    ? algid.parameters == null
                    : Arrays.equals(parameters, algid.parameters))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.531 -0400", hash_original_method = "E65C54FCC20A7D2FAC5D39EC6758FF2C", hash_generated_method = "F5E0F2E0AE14FBBD2E286256C1A0FF90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var00D3F6CF5AE875535D0485512E3CCCA7_581223180 = (algorithm.hashCode() * 37 + (parameters != null ? Arrays.hashCode(parameters) : 0)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return algorithm.hashCode() * 37 + (parameters != null ? Arrays.hashCode(parameters) : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.532 -0400", hash_original_method = "BB3CE84D97D9ED23CA58D78F5AD0AB33", hash_generated_method = "1064D8D2E10E91A969EA092561FCFCE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb) {
        dsTaint.addTaint(sb.dsTaint);
        sb.append(getAlgorithmName());
        {
            sb.append(", no params, ");
        } //End block
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

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(), ASN1Any.getInstance() }) {        {
            setOptional(1); 
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.532 -0400", hash_original_method = "E5864BBB3AEA6202E3F7EB2686660296", hash_generated_method = "A6A82616D9ED41D2BE05C9F9B683E7E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object varDF760C65211293124018E9F6363911CC_1372305957 = (new AlgorithmIdentifier(ObjectIdentifier
                    .toString((int[]) values[0]), (byte[]) values[1]));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new AlgorithmIdentifier(ObjectIdentifier
                    //.toString((int[]) values[0]), (byte[]) values[1]);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.532 -0400", hash_original_method = "EDE1554E6577A894B2989F0DB9001552", hash_generated_method = "1F42215520B64EB1FA003C33FF75B906")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            AlgorithmIdentifier aID;
            aID = (AlgorithmIdentifier) object;
            values[0] = ObjectIdentifier.toIntArray(aID.getAlgorithm());
            values[1] = aID.getParameters();
            // ---------- Original Method ----------
            //AlgorithmIdentifier aID = (AlgorithmIdentifier) object;
            //values[0] = ObjectIdentifier.toIntArray(aID.getAlgorithm());
            //values[1] = aID.getParameters();
        }

        
}; //Transformed anonymous class
}

