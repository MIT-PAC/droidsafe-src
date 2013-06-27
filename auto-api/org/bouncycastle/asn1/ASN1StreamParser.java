package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.741 -0400", hash_original_field = "678DB741D1B48B4477A490AEDCFD1EC9", hash_generated_field = "AD9BC78DBAEEEA7F3095C3D4235D31E3")

    private InputStream _in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.741 -0400", hash_original_field = "21B59360B06F124AC143A9061C12E7FA", hash_generated_field = "CC1F761CCB044A54710FD1E5F22ED61A")

    private int _limit;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.751 -0400", hash_original_method = "DBA5BC9F59C3649B70C3A3387D909190", hash_generated_method = "4C60CF1DD9390047E8E1B385E4B3C5B1")
    public  ASN1StreamParser(
        InputStream in) {
        this(in, ASN1InputStream.findLimit(in));
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.752 -0400", hash_original_method = "6581181C0F10BA1424D0E617E42FF352", hash_generated_method = "64954578D1894591237E0A60FB444999")
    public  ASN1StreamParser(
        InputStream in,
        int         limit) {
        this._in = in;
        this._limit = limit;
        // ---------- Original Method ----------
        //this._in = in;
        //this._limit = limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.752 -0400", hash_original_method = "2384F9E8B7C9F8CABF70D53041DA5305", hash_generated_method = "D2F54DB8D0B7CB649116C7728344D0A5")
    public  ASN1StreamParser(
        byte[] encoding) {
        this(new ByteArrayInputStream(encoding), encoding.length);
        addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.755 -0400", hash_original_method = "C3E0BE0AC09DBB98B8E162DDEE686364", hash_generated_method = "0801366AE8FD8A66740B50D7835C84E4")
     DEREncodable readIndef(int tagValue) throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1003988618 = null; //Variable for return #1
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_618325357 = null; //Variable for return #2
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_400096714 = null; //Variable for return #3
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1901859504 = null; //Variable for return #4
        //Begin case DERTags.EXTERNAL 
        varB4EAC82CA7396A68D541C85D26508E83_1003988618 = new DERExternalParser(this);
        //End case DERTags.EXTERNAL 
        //Begin case DERTags.OCTET_STRING 
        varB4EAC82CA7396A68D541C85D26508E83_618325357 = new BEROctetStringParser(this);
        //End case DERTags.OCTET_STRING 
        //Begin case DERTags.SEQUENCE 
        varB4EAC82CA7396A68D541C85D26508E83_400096714 = new BERSequenceParser(this);
        //End case DERTags.SEQUENCE 
        //Begin case DERTags.SET 
        varB4EAC82CA7396A68D541C85D26508E83_1901859504 = new BERSetParser(this);
        //End case DERTags.SET 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(tagValue));
        //End case default 
        addTaint(tagValue);
        DEREncodable varA7E53CE21691AB073D9660D615818899_1290543994; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1290543994 = varB4EAC82CA7396A68D541C85D26508E83_1003988618;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1290543994 = varB4EAC82CA7396A68D541C85D26508E83_618325357;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1290543994 = varB4EAC82CA7396A68D541C85D26508E83_400096714;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1290543994 = varB4EAC82CA7396A68D541C85D26508E83_1901859504;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1290543994.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1290543994;
        // ---------- Original Method ----------
        //switch (tagValue)
        //{
            //case DERTags.EXTERNAL:
                //return new DERExternalParser(this);
            //case DERTags.OCTET_STRING:
                //return new BEROctetStringParser(this);
            //case DERTags.SEQUENCE:
                //return new BERSequenceParser(this);
            //case DERTags.SET:
                //return new BERSetParser(this);
            //default:
                //throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(tagValue));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.771 -0400", hash_original_method = "CAB584B2B56E52E14F26B47F81A64976", hash_generated_method = "0E8F4FD07E77B8EB8B61508A99144926")
     DEREncodable readImplicit(boolean constructed, int tag) throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_877897934 = null; //Variable for return #1
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1716928575 = null; //Variable for return #2
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1320648387 = null; //Variable for return #3
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1673124231 = null; //Variable for return #4
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1146547200 = null; //Variable for return #5
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("indefinite length primitive encoding encountered");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_877897934 = readIndef(tag);
        } //End block
        {
            //Begin case DERTags.SET 
            varB4EAC82CA7396A68D541C85D26508E83_1716928575 = new DERSetParser(this);
            //End case DERTags.SET 
            //Begin case DERTags.SEQUENCE 
            varB4EAC82CA7396A68D541C85D26508E83_1320648387 = new DERSequenceParser(this);
            //End case DERTags.SEQUENCE 
            //Begin case DERTags.OCTET_STRING 
            varB4EAC82CA7396A68D541C85D26508E83_1673124231 = new BEROctetStringParser(this);
            //End case DERTags.OCTET_STRING 
        } //End block
        {
            //Begin case DERTags.SET 
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
            //End case DERTags.SET 
            //Begin case DERTags.SEQUENCE 
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
            //End case DERTags.SEQUENCE 
            //Begin case DERTags.OCTET_STRING 
            varB4EAC82CA7396A68D541C85D26508E83_1146547200 = new DEROctetStringParser((DefiniteLengthInputStream)_in);
            //End case DERTags.OCTET_STRING 
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("implicit tagging not implemented");
        addTaint(constructed);
        addTaint(tag);
        DEREncodable varA7E53CE21691AB073D9660D615818899_556450235; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_556450235 = varB4EAC82CA7396A68D541C85D26508E83_877897934;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_556450235 = varB4EAC82CA7396A68D541C85D26508E83_1716928575;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_556450235 = varB4EAC82CA7396A68D541C85D26508E83_1320648387;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_556450235 = varB4EAC82CA7396A68D541C85D26508E83_1673124231;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_556450235 = varB4EAC82CA7396A68D541C85D26508E83_1146547200;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_556450235.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_556450235;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.777 -0400", hash_original_method = "52179F915187689C742CC095EFF2DB0F", hash_generated_method = "3CE93C76CAD5EAB583924ADB4454E86B")
     DERObject readTaggedObject(boolean constructed, int tag) throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_906749183 = null; //Variable for return #1
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1288149639 = null; //Variable for return #2
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1859046895 = null; //Variable for return #3
        {
            DefiniteLengthInputStream defIn;
            defIn = (DefiniteLengthInputStream)_in;
            varB4EAC82CA7396A68D541C85D26508E83_906749183 = new DERTaggedObject(false, tag, new DEROctetString(defIn.toByteArray()));
        } //End block
        ASN1EncodableVector v;
        v = readVector();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1288149639 = v.size() == 1
                ?   new BERTaggedObject(true, tag, v.get(0))
                :   new BERTaggedObject(false, tag, BERFactory.createSequence(v));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1859046895 = v.size() == 1
            ?   new DERTaggedObject(true, tag, v.get(0))
            :   new DERTaggedObject(false, tag, DERFactory.createSequence(v));
        addTaint(constructed);
        addTaint(tag);
        DERObject varA7E53CE21691AB073D9660D615818899_2077336940; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2077336940 = varB4EAC82CA7396A68D541C85D26508E83_906749183;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2077336940 = varB4EAC82CA7396A68D541C85D26508E83_1288149639;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2077336940 = varB4EAC82CA7396A68D541C85D26508E83_1859046895;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2077336940.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2077336940;
        // ---------- Original Method ----------
        //if (!constructed)
        //{
            //DefiniteLengthInputStream defIn = (DefiniteLengthInputStream)_in;
            //return new DERTaggedObject(false, tag, new DEROctetString(defIn.toByteArray()));
        //}
        //ASN1EncodableVector v = readVector();
        //if (_in instanceof IndefiniteLengthInputStream)
        //{
            //return v.size() == 1
                //?   new BERTaggedObject(true, tag, v.get(0))
                //:   new BERTaggedObject(false, tag, BERFactory.createSequence(v));
        //}
        //return v.size() == 1
            //?   new DERTaggedObject(true, tag, v.get(0))
            //:   new DERTaggedObject(false, tag, DERFactory.createSequence(v));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.782 -0400", hash_original_method = "8294A0F9B070E477A3BFFFBCF1187D7F", hash_generated_method = "D086C353A046FCB5ED0EE9345A1C7598")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_2119265175 = null; //Variable for return #1
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1847139591 = null; //Variable for return #2
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1496470104 = null; //Variable for return #3
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_33497663 = null; //Variable for return #4
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1624412364 = null; //Variable for return #5
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_970694511 = null; //Variable for return #6
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1234528517 = null; //Variable for return #7
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1686828987 = null; //Variable for return #8
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_402325803 = null; //Variable for return #9
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1774336851 = null; //Variable for return #10
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_995800418 = null; //Variable for return #11
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1133347042 = null; //Variable for return #12
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1549832034 = null; //Variable for return #13
        int tag;
        tag = _in.read();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2119265175 = null;
        } //End block
        set00Check(false);
        int tagNo;
        tagNo = ASN1InputStream.readTagNumber(_in, tag);
        boolean isConstructed;
        isConstructed = (tag & DERTags.CONSTRUCTED) != 0;
        int length;
        length = ASN1InputStream.readLength(_in, _limit);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("indefinite length primitive encoding encountered");
            } //End block
            IndefiniteLengthInputStream indIn;
            indIn = new IndefiniteLengthInputStream(_in, _limit);
            ASN1StreamParser sp;
            sp = new ASN1StreamParser(indIn, _limit);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1847139591 = new BERApplicationSpecificParser(tagNo, sp);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1496470104 = new BERTaggedObjectParser(true, tagNo, sp);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_33497663 = sp.readIndef(tagNo);
        } //End block
        {
            DefiniteLengthInputStream defIn;
            defIn = new DefiniteLengthInputStream(_in, length);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1624412364 = new DERApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_970694511 = new BERTaggedObjectParser(isConstructed, tagNo, new ASN1StreamParser(defIn));
            } //End block
            {
                //Begin case DERTags.OCTET_STRING 
                varB4EAC82CA7396A68D541C85D26508E83_1234528517 = new BEROctetStringParser(new ASN1StreamParser(defIn));
                //End case DERTags.OCTET_STRING 
                //Begin case DERTags.SEQUENCE 
                varB4EAC82CA7396A68D541C85D26508E83_1686828987 = new DERSequenceParser(new ASN1StreamParser(defIn));
                //End case DERTags.SEQUENCE 
                //Begin case DERTags.SET 
                varB4EAC82CA7396A68D541C85D26508E83_402325803 = new DERSetParser(new ASN1StreamParser(defIn));
                //End case DERTags.SET 
                //Begin case DERTags.EXTERNAL 
                varB4EAC82CA7396A68D541C85D26508E83_1774336851 = new DERExternalParser(new ASN1StreamParser(defIn));
                //End case DERTags.EXTERNAL 
                //Begin case default 
                varB4EAC82CA7396A68D541C85D26508E83_995800418 = new DERUnknownTag(true, tagNo, defIn.toByteArray());
                //End case default 
            } //End block
            //Begin case DERTags.OCTET_STRING 
            varB4EAC82CA7396A68D541C85D26508E83_1133347042 = new DEROctetStringParser(defIn);
            //End case DERTags.OCTET_STRING 
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1549832034 = ASN1InputStream.createPrimitiveDERObject(tagNo, defIn.toByteArray());
            } //End block
            catch (IllegalArgumentException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("corrupted stream detected", e);
            } //End block
        } //End block
        DEREncodable varA7E53CE21691AB073D9660D615818899_1689397788; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_2119265175;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_1847139591;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_1496470104;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_33497663;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_1624412364;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_970694511;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_1234528517;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_1686828987;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_402325803;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_1774336851;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_995800418;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_1133347042;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1689397788 = varB4EAC82CA7396A68D541C85D26508E83_1549832034;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1689397788.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1689397788;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.783 -0400", hash_original_method = "4F333A451CCAA8C49D86BC8C0430A606", hash_generated_method = "261978FA3A6DEBCABEAF44688A47CEF2")
    private void set00Check(boolean enabled) {
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(enabled);
        } //End block
        addTaint(enabled);
        // ---------- Original Method ----------
        //if (_in instanceof IndefiniteLengthInputStream)
        //{
            //((IndefiniteLengthInputStream)_in).setEofOn00(enabled);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.785 -0400", hash_original_method = "0431F63F80CE6652BCE08CECE2E42AA0", hash_generated_method = "C2EC451281217F46FF65B04099F046A2")
     ASN1EncodableVector readVector() throws IOException {
        ASN1EncodableVector varB4EAC82CA7396A68D541C85D26508E83_1366923999 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        DEREncodable obj;
        {
            boolean varA0256CA68052EEA4DD8B32EB503395E2_1972275655 = ((obj = readObject()) != null);
            {
                {
                    v.add(((InMemoryRepresentable)obj).getLoadedObject());
                } //End block
                {
                    v.add(obj.getDERObject());
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1366923999 = v;
        varB4EAC82CA7396A68D541C85D26508E83_1366923999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1366923999;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //DEREncodable obj;
        //while ((obj = readObject()) != null)
        //{
            //if (obj instanceof InMemoryRepresentable)
            //{
                //v.add(((InMemoryRepresentable)obj).getLoadedObject());
            //}
            //else
            //{
                //v.add(obj.getDERObject());
            //}
        //}
        //return v;
    }

    
}

