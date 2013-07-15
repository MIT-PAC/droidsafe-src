package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.046 -0400", hash_original_field = "678DB741D1B48B4477A490AEDCFD1EC9", hash_generated_field = "AD9BC78DBAEEEA7F3095C3D4235D31E3")

    private InputStream _in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.046 -0400", hash_original_field = "21B59360B06F124AC143A9061C12E7FA", hash_generated_field = "CC1F761CCB044A54710FD1E5F22ED61A")

    private int _limit;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.047 -0400", hash_original_method = "DBA5BC9F59C3649B70C3A3387D909190", hash_generated_method = "4C60CF1DD9390047E8E1B385E4B3C5B1")
    public  ASN1StreamParser(
        InputStream in) {
        this(in, ASN1InputStream.findLimit(in));
        addTaint(in.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.047 -0400", hash_original_method = "6581181C0F10BA1424D0E617E42FF352", hash_generated_method = "64954578D1894591237E0A60FB444999")
    public  ASN1StreamParser(
        InputStream in,
        int         limit) {
        this._in = in;
        this._limit = limit;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.047 -0400", hash_original_method = "2384F9E8B7C9F8CABF70D53041DA5305", hash_generated_method = "D2F54DB8D0B7CB649116C7728344D0A5")
    public  ASN1StreamParser(
        byte[] encoding) {
        this(new ByteArrayInputStream(encoding), encoding.length);
        addTaint(encoding[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.048 -0400", hash_original_method = "C3E0BE0AC09DBB98B8E162DDEE686364", hash_generated_method = "24D8BC3F188511B10805A9EBEB0DAF61")
     DEREncodable readIndef(int tagValue) throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1774651521 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1170292240 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1266174822 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1019021959 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_1774651521 = new DERExternalParser(this);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1170292240 = new BEROctetStringParser(this);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1266174822 = new BERSequenceParser(this);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1019021959 = new BERSetParser(this);
        
        
        if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(tagValue));
        
        addTaint(tagValue);
        DEREncodable varA7E53CE21691AB073D9660D615818899_1498922961; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1498922961 = varB4EAC82CA7396A68D541C85D26508E83_1774651521;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1498922961 = varB4EAC82CA7396A68D541C85D26508E83_1170292240;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1498922961 = varB4EAC82CA7396A68D541C85D26508E83_1266174822;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1498922961 = varB4EAC82CA7396A68D541C85D26508E83_1019021959;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1498922961.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1498922961;
        
        
        
            
                
            
                
            
                
            
                
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.049 -0400", hash_original_method = "CAB584B2B56E52E14F26B47F81A64976", hash_generated_method = "5377751BDE91283C575C3FE0038295EE")
     DEREncodable readImplicit(boolean constructed, int tag) throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_421413095 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1968155581 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1208041621 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_327344061 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_891014417 = null; 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("indefinite length primitive encoding encountered");
            } 
            varB4EAC82CA7396A68D541C85D26508E83_421413095 = readIndef(tag);
        } 
        {
            
            varB4EAC82CA7396A68D541C85D26508E83_1968155581 = new DERSetParser(this);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1208041621 = new DERSequenceParser(this);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_327344061 = new BEROctetStringParser(this);
            
        } 
        {
            
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
            
            
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
            
            
            varB4EAC82CA7396A68D541C85D26508E83_891014417 = new DEROctetStringParser((DefiniteLengthInputStream)_in);
            
        } 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("implicit tagging not implemented");
        addTaint(constructed);
        addTaint(tag);
        DEREncodable varA7E53CE21691AB073D9660D615818899_716684840; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_716684840 = varB4EAC82CA7396A68D541C85D26508E83_421413095;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_716684840 = varB4EAC82CA7396A68D541C85D26508E83_1968155581;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_716684840 = varB4EAC82CA7396A68D541C85D26508E83_1208041621;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_716684840 = varB4EAC82CA7396A68D541C85D26508E83_327344061;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_716684840 = varB4EAC82CA7396A68D541C85D26508E83_891014417;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_716684840.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_716684840;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.050 -0400", hash_original_method = "52179F915187689C742CC095EFF2DB0F", hash_generated_method = "3054CEA10A08219D1B27FFE13C76A81C")
     DERObject readTaggedObject(boolean constructed, int tag) throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1529327149 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1116394184 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_307808160 = null; 
        {
            DefiniteLengthInputStream defIn = (DefiniteLengthInputStream)_in;
            varB4EAC82CA7396A68D541C85D26508E83_1529327149 = new DERTaggedObject(false, tag, new DEROctetString(defIn.toByteArray()));
        } 
        ASN1EncodableVector v = readVector();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1116394184 = v.size() == 1
                ?   new BERTaggedObject(true, tag, v.get(0))
                :   new BERTaggedObject(false, tag, BERFactory.createSequence(v));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_307808160 = v.size() == 1
            ?   new DERTaggedObject(true, tag, v.get(0))
            :   new DERTaggedObject(false, tag, DERFactory.createSequence(v));
        addTaint(constructed);
        addTaint(tag);
        DERObject varA7E53CE21691AB073D9660D615818899_1951081406; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1951081406 = varB4EAC82CA7396A68D541C85D26508E83_1529327149;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1951081406 = varB4EAC82CA7396A68D541C85D26508E83_1116394184;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1951081406 = varB4EAC82CA7396A68D541C85D26508E83_307808160;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1951081406.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1951081406;
        
        
        
            
            
        
        
        
        
            
                
                
        
        
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.052 -0400", hash_original_method = "8294A0F9B070E477A3BFFFBCF1187D7F", hash_generated_method = "B19E02CA6D0A6463F4D59BF435B6794D")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1309014814 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1794133933 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1585624559 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_633570246 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1512219640 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_511207610 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_919192742 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1441292494 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1098442307 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_804907951 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_107265099 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_878780723 = null; 
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_585782870 = null; 
        int tag = _in.read();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1309014814 = null;
        } 
        set00Check(false);
        int tagNo = ASN1InputStream.readTagNumber(_in, tag);
        boolean isConstructed = (tag & DERTags.CONSTRUCTED) != 0;
        int length = ASN1InputStream.readLength(_in, _limit);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("indefinite length primitive encoding encountered");
            } 
            IndefiniteLengthInputStream indIn = new IndefiniteLengthInputStream(_in, _limit);
            ASN1StreamParser sp = new ASN1StreamParser(indIn, _limit);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1794133933 = new BERApplicationSpecificParser(tagNo, sp);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1585624559 = new BERTaggedObjectParser(true, tagNo, sp);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_633570246 = sp.readIndef(tagNo);
        } 
        {
            DefiniteLengthInputStream defIn = new DefiniteLengthInputStream(_in, length);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1512219640 = new DERApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_511207610 = new BERTaggedObjectParser(isConstructed, tagNo, new ASN1StreamParser(defIn));
            } 
            {
                
                varB4EAC82CA7396A68D541C85D26508E83_919192742 = new BEROctetStringParser(new ASN1StreamParser(defIn));
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1441292494 = new DERSequenceParser(new ASN1StreamParser(defIn));
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1098442307 = new DERSetParser(new ASN1StreamParser(defIn));
                
                
                varB4EAC82CA7396A68D541C85D26508E83_804907951 = new DERExternalParser(new ASN1StreamParser(defIn));
                
                
                varB4EAC82CA7396A68D541C85D26508E83_107265099 = new DERUnknownTag(true, tagNo, defIn.toByteArray());
                
            } 
            
            varB4EAC82CA7396A68D541C85D26508E83_878780723 = new DEROctetStringParser(defIn);
            
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_585782870 = ASN1InputStream.createPrimitiveDERObject(tagNo, defIn.toByteArray());
            } 
            catch (IllegalArgumentException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("corrupted stream detected", e);
            } 
        } 
        DEREncodable varA7E53CE21691AB073D9660D615818899_1444147397; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_1309014814;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_1794133933;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_1585624559;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_633570246;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_1512219640;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_511207610;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_919192742;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_1441292494;
                break;
            case 9: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_1098442307;
                break;
            case 10: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_804907951;
                break;
            case 11: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_107265099;
                break;
            case 12: 
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_878780723;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1444147397 = varB4EAC82CA7396A68D541C85D26508E83_585782870;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1444147397.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1444147397;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.053 -0400", hash_original_method = "4F333A451CCAA8C49D86BC8C0430A606", hash_generated_method = "261978FA3A6DEBCABEAF44688A47CEF2")
    private void set00Check(boolean enabled) {
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(enabled);
        } 
        addTaint(enabled);
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.054 -0400", hash_original_method = "0431F63F80CE6652BCE08CECE2E42AA0", hash_generated_method = "9503B229FAF42A4632C950D4BEB20D6C")
     ASN1EncodableVector readVector() throws IOException {
        ASN1EncodableVector varB4EAC82CA7396A68D541C85D26508E83_1561673295 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        DEREncodable obj;
        {
            boolean varA0256CA68052EEA4DD8B32EB503395E2_525514873 = ((obj = readObject()) != null);
            {
                {
                    v.add(((InMemoryRepresentable)obj).getLoadedObject());
                } 
                {
                    v.add(obj.getDERObject());
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1561673295 = v;
        varB4EAC82CA7396A68D541C85D26508E83_1561673295.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1561673295;
        
        
        
        
        
            
            
                
            
            
            
                
            
        
        
    }

    
}

