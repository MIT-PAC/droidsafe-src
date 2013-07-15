package org.bouncycastle.asn1.x500.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

public class BCStyle implements X500NameStyle {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.806 -0400", hash_original_method = "0ABD618DA1E5963140699C4BF03983EF", hash_generated_method = "62EA560CCC47607A51180F5CADA7A74F")
    protected  BCStyle() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.807 -0400", hash_original_method = "BD2E63080765E1C5F0301383BAEA0055", hash_generated_method = "4403B85FA7F94133CFB5568EFBC0B5EC")
    public ASN1Encodable stringToValue(ASN1ObjectIdentifier oid, String value) {
        addTaint(value.getTaint());
        addTaint(oid.getTaint());
    if(value.length() != 0 && value.charAt(0) == '#')        
        {
            try 
            {
ASN1Encodable var6C07062AE2FFDCB89429828B339426A8_770419768 =                 IETFUtils.valueFromHexString(value, 1);
                var6C07062AE2FFDCB89429828B339426A8_770419768.addTaint(taint);
                return var6C07062AE2FFDCB89429828B339426A8_770419768;
            } //End block
            catch (IOException e)
            {
                RuntimeException var6DFFBB33DC6D67FE3709FD741BFDC9CF_1202466938 = new RuntimeException("can't recode value for oid " + oid.getId());
                var6DFFBB33DC6D67FE3709FD741BFDC9CF_1202466938.addTaint(taint);
                throw var6DFFBB33DC6D67FE3709FD741BFDC9CF_1202466938;
            } //End block
        } //End block
        else
        {
    if(value.length() != 0 && value.charAt(0) == '\\')            
            {
                value = value.substring(1);
            } //End block
    if(oid.equals(EmailAddress) || oid.equals(DC))            
            {
ASN1Encodable var33DE795DC3C6B2B339D412A48CEFF243_1359573284 =                 new DERIA5String(value);
                var33DE795DC3C6B2B339D412A48CEFF243_1359573284.addTaint(taint);
                return var33DE795DC3C6B2B339D412A48CEFF243_1359573284;
            } //End block
            else
    if(oid.equals(DATE_OF_BIRTH))            
            {
ASN1Encodable varA0E9AA915FE5B2238A1C04164293600B_915164755 =                 new DERGeneralizedTime(value);
                varA0E9AA915FE5B2238A1C04164293600B_915164755.addTaint(taint);
                return varA0E9AA915FE5B2238A1C04164293600B_915164755;
            } //End block
            else
    if(oid.equals(C) || oid.equals(SN) || oid.equals(DN_QUALIFIER)
                || oid.equals(TELEPHONE_NUMBER))            
            {
ASN1Encodable varE4B9BE1D4E9D486AB677DC69399C8BDE_68538108 =                 new DERPrintableString(value);
                varE4B9BE1D4E9D486AB677DC69399C8BDE_68538108.addTaint(taint);
                return varE4B9BE1D4E9D486AB677DC69399C8BDE_68538108;
            } //End block
        } //End block
ASN1Encodable var2B1683A8AF4155B42EB4E966D550EB40_8070860 =         new DERUTF8String(value);
        var2B1683A8AF4155B42EB4E966D550EB40_8070860.addTaint(taint);
        return var2B1683A8AF4155B42EB4E966D550EB40_8070860;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.808 -0400", hash_original_method = "9484E4F8104F6AF4F123D2A5FD97E1FE", hash_generated_method = "75E8619C475C47EFBAC6746C5941CBBA")
    public ASN1ObjectIdentifier attrNameToOID(String attrName) {
        addTaint(attrName.getTaint());
ASN1ObjectIdentifier var36DEFB4E7CCF4A65D077415213D06BF0_54270478 =         IETFUtils.decodeAttrName(attrName, DefaultLookUp);
        var36DEFB4E7CCF4A65D077415213D06BF0_54270478.addTaint(taint);
        return var36DEFB4E7CCF4A65D077415213D06BF0_54270478;
        // ---------- Original Method ----------
        //return IETFUtils.decodeAttrName(attrName, DefaultLookUp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.809 -0400", hash_original_method = "3E0470485E902738E6BF6ED5F1A7F39D", hash_generated_method = "EAD382C97C17AB0507AE76B94AD7D5DC")
    public boolean areEqual(X500Name name1, X500Name name2) {
        addTaint(name2.getTaint());
        addTaint(name1.getTaint());
        RDN[] rdns1 = name1.getRDNs();
        RDN[] rdns2 = name2.getRDNs();
    if(rdns1.length != rdns2.length)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1336992526 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418532019 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418532019;
        } //End block
        boolean reverse = false;
    if(rdns1[0].getFirst() != null && rdns2[0].getFirst() != null)        
        {
            reverse = !rdns1[0].getFirst().getType().equals(rdns2[0].getFirst().getType());
        } //End block
for(int i = 0;i != rdns1.length;i++)
        {
    if(!foundMatch(reverse, rdns1[i], rdns2))            
            {
                boolean var68934A3E9455FA72420237EB05902327_351656575 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1031236113 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1031236113;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_926621616 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942736474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_942736474;
        // ---------- Original Method ----------
        //RDN[] rdns1 = name1.getRDNs();
        //RDN[] rdns2 = name2.getRDNs();
        //if (rdns1.length != rdns2.length)
        //{
            //return false;
        //}
        //boolean reverse = false;
        //if (rdns1[0].getFirst() != null && rdns2[0].getFirst() != null)
        //{
            //reverse = !rdns1[0].getFirst().getType().equals(rdns2[0].getFirst().getType());  
        //}
        //for (int i = 0; i != rdns1.length; i++)
        //{
            //if (!foundMatch(reverse, rdns1[i], rdns2))
            //{
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.811 -0400", hash_original_method = "54A0483298F3DFD022315937FBAF5933", hash_generated_method = "7A2E484F19D0DBDA3CD6BF47C9D83420")
    private boolean foundMatch(boolean reverse, RDN rdn, RDN[] possRDNs) {
        addTaint(possRDNs[0].getTaint());
        addTaint(rdn.getTaint());
        addTaint(reverse);
    if(reverse)        
        {
for(int i = possRDNs.length - 1;i >= 0;i--)
            {
    if(possRDNs[i] != null && rdnAreEqual(rdn, possRDNs[i]))                
                {
                    possRDNs[i] = null;
                    boolean varB326B5062B2F0E69046810717534CB09_1368429993 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956659550 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956659550;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = 0;i != possRDNs.length;i++)
            {
    if(possRDNs[i] != null && rdnAreEqual(rdn, possRDNs[i]))                
                {
                    possRDNs[i] = null;
                    boolean varB326B5062B2F0E69046810717534CB09_1721933056 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130374850 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130374850;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_258667157 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_970940453 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_970940453;
        // ---------- Original Method ----------
        //if (reverse)
        //{
            //for (int i = possRDNs.length - 1; i >= 0; i--)
            //{
                //if (possRDNs[i] != null && rdnAreEqual(rdn, possRDNs[i]))
                //{
                    //possRDNs[i] = null;
                    //return true;
                //}
            //}
        //}
        //else
        //{
            //for (int i = 0; i != possRDNs.length; i++)
            //{
                //if (possRDNs[i] != null && rdnAreEqual(rdn, possRDNs[i]))
                //{
                    //possRDNs[i] = null;
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.812 -0400", hash_original_method = "D45006114E7131F95F9CCEC1C09C1466", hash_generated_method = "17DC5B232956F8FB86F2FB69D1277464")
    protected boolean rdnAreEqual(RDN rdn1, RDN rdn2) {
        addTaint(rdn2.getTaint());
        addTaint(rdn1.getTaint());
    if(rdn1.isMultiValued())        
        {
    if(rdn2.isMultiValued())            
            {
                AttributeTypeAndValue[] atvs1 = rdn1.getTypesAndValues();
                AttributeTypeAndValue[] atvs2 = rdn2.getTypesAndValues();
    if(atvs1.length != atvs2.length)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_581463106 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335424525 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335424525;
                } //End block
for(int i = 0;i != atvs1.length;i++)
                {
    if(!atvAreEqual(atvs1[i], atvs2[i]))                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1273852403 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1088905823 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1088905823;
                    } //End block
                } //End block
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_1987175675 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_925332275 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_925332275;
            } //End block
        } //End block
        else
        {
    if(!rdn2.isMultiValued())            
            {
                boolean var1403ECC56C5738062A4CCD1AD18F3BFA_196148660 = (atvAreEqual(rdn1.getFirst(), rdn2.getFirst()));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1243411773 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1243411773;
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_1323170168 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_596133120 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_596133120;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1028165621 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105293618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105293618;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.813 -0400", hash_original_method = "9BB2C53F6636F1E7BA3066DC2FBD5F40", hash_generated_method = "011423E0D34FABBB9B11C10261612C66")
    private boolean atvAreEqual(AttributeTypeAndValue atv1, AttributeTypeAndValue atv2) {
        addTaint(atv2.getTaint());
        addTaint(atv1.getTaint());
    if(atv1 == atv2)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1905227845 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974305608 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_974305608;
        } //End block
    if(atv1 == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1759159211 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737146733 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737146733;
        } //End block
    if(atv2 == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1705621978 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1440813821 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1440813821;
        } //End block
        ASN1ObjectIdentifier o1 = atv1.getType();
        ASN1ObjectIdentifier o2 = atv2.getType();
    if(!o1.equals(o2))        
        {
            boolean var68934A3E9455FA72420237EB05902327_757454326 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211705866 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_211705866;
        } //End block
        String v1 = IETFUtils.canonicalize(IETFUtils.valueToString(atv1.getValue()));
        String v2 = IETFUtils.canonicalize(IETFUtils.valueToString(atv2.getValue()));
    if(!v1.equals(v2))        
        {
            boolean var68934A3E9455FA72420237EB05902327_156104970 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324330766 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324330766;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1263867148 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_33477119 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_33477119;
        // ---------- Original Method ----------
        //if (atv1 == atv2)
        //{
            //return true;
        //}
        //if (atv1 == null)
        //{
            //return false;
        //}
        //if (atv2 == null)
        //{
            //return false;
        //}
        //ASN1ObjectIdentifier o1 = atv1.getType();
        //ASN1ObjectIdentifier o2 = atv2.getType();
        //if (!o1.equals(o2))
        //{
            //return false;
        //}
        //String v1 = IETFUtils.canonicalize(IETFUtils.valueToString(atv1.getValue()));
        //String v2 = IETFUtils.canonicalize(IETFUtils.valueToString(atv2.getValue()));
        //if (!v1.equals(v2))
        //{
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.814 -0400", hash_original_method = "A9463F881D57C8D610E0B84E4769BF0F", hash_generated_method = "891B73DF1CC6991C47E2BBF82B04E477")
    public RDN[] fromString(String dirName) {
        addTaint(dirName.getTaint());
RDN[] varB4707AA258BA2978AA365DCAAA9F4D7C_1797998652 =         IETFUtils.rDNsFromString(dirName, this);
        varB4707AA258BA2978AA365DCAAA9F4D7C_1797998652.addTaint(taint);
        return varB4707AA258BA2978AA365DCAAA9F4D7C_1797998652;
        // ---------- Original Method ----------
        //return IETFUtils.rDNsFromString(dirName, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.815 -0400", hash_original_method = "EA77324623CE6D0B04D0F275B161435F", hash_generated_method = "C2DE4A464758E5F26092C9EA9571D6FB")
    public int calculateHashCode(X500Name name) {
        addTaint(name.getTaint());
        int hashCodeValue = 0;
        RDN[] rdns = name.getRDNs();
for(int i = 0;i != rdns.length;i++)
        {
    if(rdns[i].isMultiValued())            
            {
                AttributeTypeAndValue[] atv = rdns[i].getTypesAndValues();
for(int j = 0;j != atv.length;j++)
                {
                    hashCodeValue ^= atv[j].getType().hashCode();
                    hashCodeValue ^= calcHashCode(atv[j].getValue());
                } //End block
            } //End block
            else
            {
                hashCodeValue ^= rdns[i].getFirst().getType().hashCode();
                hashCodeValue ^= calcHashCode(rdns[i].getFirst().getValue());
            } //End block
        } //End block
        int var4D002D69417019F289C8061B82207DD2_639557835 = (hashCodeValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434125451 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434125451;
        // ---------- Original Method ----------
        //int hashCodeValue = 0;
        //RDN[] rdns = name.getRDNs();
        //for (int i = 0; i != rdns.length; i++)
        //{
            //if (rdns[i].isMultiValued())
            //{
                //AttributeTypeAndValue[] atv = rdns[i].getTypesAndValues();
                //for (int j = 0; j != atv.length; j++)
                //{
                    //hashCodeValue ^= atv[j].getType().hashCode();
                    //hashCodeValue ^= calcHashCode(atv[j].getValue());
                //}
            //}
            //else
            //{
                //hashCodeValue ^= rdns[i].getFirst().getType().hashCode();
                //hashCodeValue ^= calcHashCode(rdns[i].getFirst().getValue());
            //}
        //}
        //return hashCodeValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.815 -0400", hash_original_method = "D9D0265B1123594600F423F1ABB5E8A9", hash_generated_method = "16AA98396B80E7310969A687AECE55EC")
    private int calcHashCode(ASN1Encodable enc) {
        addTaint(enc.getTaint());
        String value = IETFUtils.valueToString(enc);
        value = IETFUtils.canonicalize(value);
        int varB074603E1AD45DDD8A09B63727AC1669_874571812 = (value.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500181051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500181051;
        // ---------- Original Method ----------
        //String value = IETFUtils.valueToString(enc);
        //value = IETFUtils.canonicalize(value);
        //return value.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.816 -0400", hash_original_method = "C53C9B056BF6D42B40010FA6E5F8B1BD", hash_generated_method = "1F2B056F366ACFDA739032F406F6D321")
    public String toString(X500Name name) {
        addTaint(name.getTaint());
        StringBuffer buf = new StringBuffer();
        boolean first = true;
        RDN[] rdns = name.getRDNs();
for(int i = 0;i < rdns.length;i++)
        {
    if(first)            
            {
                first = false;
            } //End block
            else
            {
                buf.append(',');
            } //End block
    if(rdns[i].isMultiValued())            
            {
                AttributeTypeAndValue[] atv = rdns[i].getTypesAndValues();
                boolean firstAtv = true;
for(int j = 0;j != atv.length;j++)
                {
    if(firstAtv)                    
                    {
                        firstAtv = false;
                    } //End block
                    else
                    {
                        buf.append('+');
                    } //End block
                    IETFUtils.appendTypeAndValue(buf, atv[j], DefaultSymbols);
                } //End block
            } //End block
            else
            {
                IETFUtils.appendTypeAndValue(buf, rdns[i].getFirst(), DefaultSymbols);
            } //End block
        } //End block
String var4FC680801218E6372BC708D6FA44AE60_2089171851 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_2089171851.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_2089171851;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.816 -0400", hash_original_field = "609838652B93D33DFCC6212D95B98870", hash_generated_field = "C060850A5B8A43A9641AC7C3AC19DAD7")

    public static final X500NameStyle INSTANCE = new BCStyle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "DF3D2B0EC08A46678E8095714F7CB96F", hash_generated_field = "6B28731F0BA377BA3BC00D3B29680EC1")

    public static final ASN1ObjectIdentifier C = new ASN1ObjectIdentifier("2.5.4.6");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "31A9CF9ED94ED5D10BB38126E0719632", hash_generated_field = "DCD93051F670D07A94A163A4BE5E36EF")

    public static final ASN1ObjectIdentifier O = new ASN1ObjectIdentifier("2.5.4.10");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "1061F50D1A3154175B8ABDEFB137C6EB", hash_generated_field = "9AB62218CD4C726913D30E0BBEBC7C7C")

    public static final ASN1ObjectIdentifier OU = new ASN1ObjectIdentifier("2.5.4.11");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "A9DA33F4ADC4BDADCFEB9FD123953FF2", hash_generated_field = "0EDFBC5765D192124E2D2BB3B3E17741")

    public static final ASN1ObjectIdentifier T = new ASN1ObjectIdentifier("2.5.4.12");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "D52FC34D7A68DCC325308F0AE7FA9585", hash_generated_field = "E4A6683D7D329DBD320CF3D2B2EA169C")

    public static final ASN1ObjectIdentifier CN = new ASN1ObjectIdentifier("2.5.4.3");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "9CD0DA9786EC16AE81A57F71B047B6C2", hash_generated_field = "DD2BAC4A277DDB3FD10FF9B797FE9F9F")

    public static final ASN1ObjectIdentifier SN = new ASN1ObjectIdentifier("2.5.4.5");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "956EE34F5FB5D025EC6E32028169AAE9", hash_generated_field = "DCCEE879790C242119D271A476CBFC2A")

    public static final ASN1ObjectIdentifier STREET = new ASN1ObjectIdentifier("2.5.4.9");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "5AC9323E3AB7013AFF904A3D9E7AE793", hash_generated_field = "8799CCA7411F87A17F66029334CEB2B0")

    public static final ASN1ObjectIdentifier SERIALNUMBER = SN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "6FEA45110D81391C49D122A3CA74C615", hash_generated_field = "DB4DE5AFB6B9EB71ACB9A4701CAFDAAB")

    public static final ASN1ObjectIdentifier L = new ASN1ObjectIdentifier("2.5.4.7");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "E2F77EB33506346479BA61D1D5524D60", hash_generated_field = "251E35276C1DCFF2938FEEBD4AD8B644")

    public static final ASN1ObjectIdentifier ST = new ASN1ObjectIdentifier("2.5.4.8");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "867A66A6368603CB753E96F4EC558839", hash_generated_field = "3695E4F72DE11638D74469831AF5929C")

    public static final ASN1ObjectIdentifier SURNAME = new ASN1ObjectIdentifier("2.5.4.4");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "DDEEFF957FD44C0D21D24CDEB121A7B6", hash_generated_field = "77FD96683E323E771BCC50C906DF9C79")

    public static final ASN1ObjectIdentifier GIVENNAME = new ASN1ObjectIdentifier("2.5.4.42");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "DCE46911988A24C925244DC77A040906", hash_generated_field = "DA98051E334D0DD7CDFE685451ADD496")

    public static final ASN1ObjectIdentifier INITIALS = new ASN1ObjectIdentifier("2.5.4.43");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "083211F5F6E5431627E043AD65A77474", hash_generated_field = "5737E3ABFD2D4040805F7878259AF508")

    public static final ASN1ObjectIdentifier GENERATION = new ASN1ObjectIdentifier("2.5.4.44");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "A0CFE66590582041EBCAABB1E4355E9F", hash_generated_field = "893B9D2C6C1C3B3A18AF963C8C678081")

    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER = new ASN1ObjectIdentifier("2.5.4.45");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "0DF519CBFF057BCF8779AD58088BE8D5", hash_generated_field = "F3121166E0BE18E9CA551FF6E105E14F")

    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY = new ASN1ObjectIdentifier(
        "2.5.4.15");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.817 -0400", hash_original_field = "6D1D752DD529691FCFD4231BD3EE7718", hash_generated_field = "D0103C15BA15D290911D36A6E8B05BEF")

    public static final ASN1ObjectIdentifier POSTAL_CODE = new ASN1ObjectIdentifier(
        "2.5.4.17");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "A42579AD143735A05DC8A288AC188960", hash_generated_field = "A6604F09378F02C3F9F7E14C925545A4")

    public static final ASN1ObjectIdentifier DN_QUALIFIER = new ASN1ObjectIdentifier(
        "2.5.4.46");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "6AE9356966130F78A044D4F7F907C42D", hash_generated_field = "BBE741739A39F87431005A9211781950")

    public static final ASN1ObjectIdentifier PSEUDONYM = new ASN1ObjectIdentifier(
        "2.5.4.65");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "A8A9CB649FC40032F86A9B42A256DF07", hash_generated_field = "3919D8BC4E0752B5A5D4B9A2777A6C49")

    public static final ASN1ObjectIdentifier DATE_OF_BIRTH = new ASN1ObjectIdentifier(
        "1.3.6.1.5.5.7.9.1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "A83072DAE8684E811DA118D4F5625E6C", hash_generated_field = "FC9C0DA941FD49257DA639F087D05445")

    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH = new ASN1ObjectIdentifier(
        "1.3.6.1.5.5.7.9.2");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "E53D79361F36EDD49E45F2517D996744", hash_generated_field = "930968633593A298F6B31E8852A0BE7E")

    public static final ASN1ObjectIdentifier GENDER = new ASN1ObjectIdentifier(
        "1.3.6.1.5.5.7.9.3");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "AE9ECF549D5A6110AC29148FA47ED4B6", hash_generated_field = "3B8A2BCCC5E177AFADF12BDA6D520BB3")

    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP = new ASN1ObjectIdentifier(
        "1.3.6.1.5.5.7.9.4");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "C75D274F9E63D1B32F84849C86B1749E", hash_generated_field = "2B0839E58743B99E48859FB6D192EFAE")

    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE = new ASN1ObjectIdentifier(
        "1.3.6.1.5.5.7.9.5");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "635FC53C082AC210BE11DD6FCD162FF0", hash_generated_field = "7AE5C39091A4CDDC2D9AF0B1D718DB07")

    public static final ASN1ObjectIdentifier NAME_AT_BIRTH = new ASN1ObjectIdentifier("1.3.36.8.3.14");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "CC20CE30D6B5A2410D47FF817CC706C6", hash_generated_field = "D1C997078495D2FD99EEF9EA6A41DD23")

    public static final ASN1ObjectIdentifier POSTAL_ADDRESS = new ASN1ObjectIdentifier("2.5.4.16");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "251EBFE49AA8EFAB4C363293A97CC881", hash_generated_field = "A260837E3A196A3A66F3FD05B823BE27")

    public static final ASN1ObjectIdentifier DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "ABCD051D2584EDF4C7DAC45C2213D37A", hash_generated_field = "6D0BA46185F6A42217195304B2C48E58")

    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER = X509ObjectIdentifiers.id_at_telephoneNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "E931C7B03A64786863967F0BC14890C6", hash_generated_field = "78046C0D514B11059FCF6140B23BD69F")

    public static final ASN1ObjectIdentifier NAME = X509ObjectIdentifiers.id_at_name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "AB5376EA36F8610FEC8AE6621D7491D9", hash_generated_field = "94768FD0A0AB3FD788AA8DF7729248B3")

    public static final ASN1ObjectIdentifier EmailAddress = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "CCCA67DADCF824B36D120A0A0E7847F2", hash_generated_field = "4D93C13CEDC0C534265A556FB79EF3F2")

    public static final ASN1ObjectIdentifier UnstructuredName = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "A1069D8572967482B49C98AED67A215B", hash_generated_field = "63E5E1B58595E52C940179E3469A4EDB")

    public static final ASN1ObjectIdentifier UnstructuredAddress = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "05C9073B7E40A1D4E6C8466E0DDA9A6F", hash_generated_field = "86CB254127BC8C87A86C3CFB8F5D1BA7")

    public static final ASN1ObjectIdentifier E = EmailAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.818 -0400", hash_original_field = "778990712ED8236CAAB99CE587843C51", hash_generated_field = "62065CBD2CB2E1E03C54078E6D100D7F")

    public static final ASN1ObjectIdentifier DC = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.819 -0400", hash_original_field = "1BAC2D627C6B0F1399FF322F3CC8D859", hash_generated_field = "6696F260EEF01FB0CFC05225B4A9E9B4")

    public static final ASN1ObjectIdentifier UID = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.819 -0400", hash_original_field = "F5684916D3BA1C14EACDDDD00DA1C309", hash_generated_field = "DA9A8DC7E5E394013019E7145DE74EC2")

    private static final Hashtable DefaultSymbols = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.819 -0400", hash_original_field = "80F42D6B53063097AA147CC39ED38975", hash_generated_field = "CFA0F3F94E79998418B90A094C11CB18")

    private static final Hashtable DefaultLookUp = new Hashtable();
    static {
        DefaultSymbols.put(C, "C");
        DefaultSymbols.put(O, "O");
        DefaultSymbols.put(T, "T");
        DefaultSymbols.put(OU, "OU");
        DefaultSymbols.put(CN, "CN");
        DefaultSymbols.put(L, "L");
        DefaultSymbols.put(ST, "ST");
        DefaultSymbols.put(SN, "SERIALNUMBER");
        DefaultSymbols.put(EmailAddress, "E");
        DefaultSymbols.put(DC, "DC");
        DefaultSymbols.put(UID, "UID");
        DefaultSymbols.put(STREET, "STREET");
        DefaultSymbols.put(SURNAME, "SURNAME");
        DefaultSymbols.put(GIVENNAME, "GIVENNAME");
        DefaultSymbols.put(INITIALS, "INITIALS");
        DefaultSymbols.put(GENERATION, "GENERATION");
        DefaultSymbols.put(UnstructuredAddress, "unstructuredAddress");
        DefaultSymbols.put(UnstructuredName, "unstructuredName");
        DefaultSymbols.put(UNIQUE_IDENTIFIER, "UniqueIdentifier");
        DefaultSymbols.put(DN_QUALIFIER, "DN");
        DefaultSymbols.put(PSEUDONYM, "Pseudonym");
        DefaultSymbols.put(POSTAL_ADDRESS, "PostalAddress");
        DefaultSymbols.put(NAME_AT_BIRTH, "NameAtBirth");
        DefaultSymbols.put(COUNTRY_OF_CITIZENSHIP, "CountryOfCitizenship");
        DefaultSymbols.put(COUNTRY_OF_RESIDENCE, "CountryOfResidence");
        DefaultSymbols.put(GENDER, "Gender");
        DefaultSymbols.put(PLACE_OF_BIRTH, "PlaceOfBirth");
        DefaultSymbols.put(DATE_OF_BIRTH, "DateOfBirth");
        DefaultSymbols.put(POSTAL_CODE, "PostalCode");
        DefaultSymbols.put(BUSINESS_CATEGORY, "BusinessCategory");
        DefaultSymbols.put(TELEPHONE_NUMBER, "TelephoneNumber");
        DefaultSymbols.put(NAME, "Name");
        DefaultLookUp.put("c", C);
        DefaultLookUp.put("o", O);
        DefaultLookUp.put("t", T);
        DefaultLookUp.put("ou", OU);
        DefaultLookUp.put("cn", CN);
        DefaultLookUp.put("l", L);
        DefaultLookUp.put("st", ST);
        DefaultLookUp.put("sn", SN);
        DefaultLookUp.put("serialnumber", SN);
        DefaultLookUp.put("street", STREET);
        DefaultLookUp.put("emailaddress", E);
        DefaultLookUp.put("dc", DC);
        DefaultLookUp.put("e", E);
        DefaultLookUp.put("uid", UID);
        DefaultLookUp.put("surname", SURNAME);
        DefaultLookUp.put("givenname", GIVENNAME);
        DefaultLookUp.put("initials", INITIALS);
        DefaultLookUp.put("generation", GENERATION);
        DefaultLookUp.put("unstructuredaddress", UnstructuredAddress);
        DefaultLookUp.put("unstructuredname", UnstructuredName);
        DefaultLookUp.put("uniqueidentifier", UNIQUE_IDENTIFIER);
        DefaultLookUp.put("dn", DN_QUALIFIER);
        DefaultLookUp.put("pseudonym", PSEUDONYM);
        DefaultLookUp.put("postaladdress", POSTAL_ADDRESS);
        DefaultLookUp.put("nameofbirth", NAME_AT_BIRTH);
        DefaultLookUp.put("countryofcitizenship", COUNTRY_OF_CITIZENSHIP);
        DefaultLookUp.put("countryofresidence", COUNTRY_OF_RESIDENCE);
        DefaultLookUp.put("gender", GENDER);
        DefaultLookUp.put("placeofbirth", PLACE_OF_BIRTH);
        DefaultLookUp.put("dateofbirth", DATE_OF_BIRTH);
        DefaultLookUp.put("postalcode", POSTAL_CODE);
        DefaultLookUp.put("businesscategory", BUSINESS_CATEGORY);
        DefaultLookUp.put("telephonenumber", TELEPHONE_NUMBER);
        DefaultLookUp.put("name", NAME);
    }
    
}

