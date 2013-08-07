package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;






public class ASN1StreamParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.850 -0400", hash_original_field = "678DB741D1B48B4477A490AEDCFD1EC9", hash_generated_field = "AD9BC78DBAEEEA7F3095C3D4235D31E3")

    private InputStream _in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.850 -0400", hash_original_field = "21B59360B06F124AC143A9061C12E7FA", hash_generated_field = "CC1F761CCB044A54710FD1E5F22ED61A")

    private int _limit;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.850 -0400", hash_original_method = "DBA5BC9F59C3649B70C3A3387D909190", hash_generated_method = "4C60CF1DD9390047E8E1B385E4B3C5B1")
    public  ASN1StreamParser(
        InputStream in) {
        this(in, ASN1InputStream.findLimit(in));
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.851 -0400", hash_original_method = "6581181C0F10BA1424D0E617E42FF352", hash_generated_method = "64954578D1894591237E0A60FB444999")
    public  ASN1StreamParser(
        InputStream in,
        int         limit) {
        this._in = in;
        this._limit = limit;
        // ---------- Original Method ----------
        //this._in = in;
        //this._limit = limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.851 -0400", hash_original_method = "2384F9E8B7C9F8CABF70D53041DA5305", hash_generated_method = "D2F54DB8D0B7CB649116C7728344D0A5")
    public  ASN1StreamParser(
        byte[] encoding) {
        this(new ByteArrayInputStream(encoding), encoding.length);
        addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.852 -0400", hash_original_method = "C3E0BE0AC09DBB98B8E162DDEE686364", hash_generated_method = "E4A403D4CBCB1FFD91B99DDD0A5BFA84")
     DEREncodable readIndef(int tagValue) throws IOException {
        addTaint(tagValue);
switch(tagValue){
        case DERTags.EXTERNAL:
DEREncodable var1D4E6EB38EDC9BFC78BCA57BEEE300C6_1558736128 =         new DERExternalParser(this);
        var1D4E6EB38EDC9BFC78BCA57BEEE300C6_1558736128.addTaint(taint);
        return var1D4E6EB38EDC9BFC78BCA57BEEE300C6_1558736128;
        case DERTags.OCTET_STRING:
DEREncodable var671F4D920F601CC0BA0FCDA468430A91_141950925 =         new BEROctetStringParser(this);
        var671F4D920F601CC0BA0FCDA468430A91_141950925.addTaint(taint);
        return var671F4D920F601CC0BA0FCDA468430A91_141950925;
        case DERTags.SEQUENCE:
DEREncodable varCCBBEFB56EE641A5B3956793B0A6B96B_318202258 =         new BERSequenceParser(this);
        varCCBBEFB56EE641A5B3956793B0A6B96B_318202258.addTaint(taint);
        return varCCBBEFB56EE641A5B3956793B0A6B96B_318202258;
        case DERTags.SET:
DEREncodable varE346071D9A7CD17D4B60913654A94C97_1324974968 =         new BERSetParser(this);
        varE346071D9A7CD17D4B60913654A94C97_1324974968.addTaint(taint);
        return varE346071D9A7CD17D4B60913654A94C97_1324974968;
        default:
        ASN1Exception varCAF52D6298D280BBB4771634F44A2C0F_955671188 = new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(tagValue));
        varCAF52D6298D280BBB4771634F44A2C0F_955671188.addTaint(taint);
        throw varCAF52D6298D280BBB4771634F44A2C0F_955671188;
}
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.853 -0400", hash_original_method = "CAB584B2B56E52E14F26B47F81A64976", hash_generated_method = "FAFC3B12EA68E22BA1727442E4CBD0E0")
     DEREncodable readImplicit(boolean constructed, int tag) throws IOException {
        addTaint(tag);
        addTaint(constructed);
        if(_in instanceof IndefiniteLengthInputStream)        
        {
            if(!constructed)            
            {
                IOException var0055B29725078D64828DFE2C61240180_1529516882 = new IOException("indefinite length primitive encoding encountered");
                var0055B29725078D64828DFE2C61240180_1529516882.addTaint(taint);
                throw var0055B29725078D64828DFE2C61240180_1529516882;
            } //End block
DEREncodable var77EDF699AE31BF30764DFA44A005E4C0_1094463568 =             readIndef(tag);
            var77EDF699AE31BF30764DFA44A005E4C0_1094463568.addTaint(taint);
            return var77EDF699AE31BF30764DFA44A005E4C0_1094463568;
        } //End block
        if(constructed)        
        {
switch(tag){
            case DERTags.SET:
DEREncodable var22F42FB615D84EC4C182518AB01A30C1_805279662 =             new DERSetParser(this);
            var22F42FB615D84EC4C182518AB01A30C1_805279662.addTaint(taint);
            return var22F42FB615D84EC4C182518AB01A30C1_805279662;
            case DERTags.SEQUENCE:
DEREncodable var5565804631FCA79E3EFA6DC7084D7558_517000485 =             new DERSequenceParser(this);
            var5565804631FCA79E3EFA6DC7084D7558_517000485.addTaint(taint);
            return var5565804631FCA79E3EFA6DC7084D7558_517000485;
            case DERTags.OCTET_STRING:
DEREncodable var671F4D920F601CC0BA0FCDA468430A91_16724693 =             new BEROctetStringParser(this);
            var671F4D920F601CC0BA0FCDA468430A91_16724693.addTaint(taint);
            return var671F4D920F601CC0BA0FCDA468430A91_16724693;
}
        } //End block
        else
        {
switch(tag){
            case DERTags.SET:
            ASN1Exception var27D2F8B75FACA3B971F48C169908899E_531943636 = new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
            var27D2F8B75FACA3B971F48C169908899E_531943636.addTaint(taint);
            throw var27D2F8B75FACA3B971F48C169908899E_531943636;
            case DERTags.SEQUENCE:
            ASN1Exception var543D1EC6A1924AB5C01653E335549EF7_1751445011 = new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
            var543D1EC6A1924AB5C01653E335549EF7_1751445011.addTaint(taint);
            throw var543D1EC6A1924AB5C01653E335549EF7_1751445011;
            case DERTags.OCTET_STRING:
DEREncodable varF1EF7B02C1CEA24C1BADBFEE8E8EE4E1_1567359493 =             new DEROctetStringParser((DefiniteLengthInputStream)_in);
            varF1EF7B02C1CEA24C1BADBFEE8E8EE4E1_1567359493.addTaint(taint);
            return varF1EF7B02C1CEA24C1BADBFEE8E8EE4E1_1567359493;
}
        } //End block
        RuntimeException var03C1D0D807EF8DD6888BC794B5698198_1269008782 = new RuntimeException("implicit tagging not implemented");
        var03C1D0D807EF8DD6888BC794B5698198_1269008782.addTaint(taint);
        throw var03C1D0D807EF8DD6888BC794B5698198_1269008782;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.854 -0400", hash_original_method = "52179F915187689C742CC095EFF2DB0F", hash_generated_method = "748FAA118E8F81903E4CD7958EE8C5BC")
     DERObject readTaggedObject(boolean constructed, int tag) throws IOException {
        addTaint(tag);
        addTaint(constructed);
        if(!constructed)        
        {
            DefiniteLengthInputStream defIn = (DefiniteLengthInputStream)_in;
DERObject var853BC5EA4168A60BF0F7A8C1E61B802A_180471564 =             new DERTaggedObject(false, tag, new DEROctetString(defIn.toByteArray()));
            var853BC5EA4168A60BF0F7A8C1E61B802A_180471564.addTaint(taint);
            return var853BC5EA4168A60BF0F7A8C1E61B802A_180471564;
        } //End block
        ASN1EncodableVector v = readVector();
        if(_in instanceof IndefiniteLengthInputStream)        
        {
DERObject varC07ACA78BFC88AF6278E6A4455DBEB23_1516596840 =             v.size() == 1
                ?   new BERTaggedObject(true, tag, v.get(0))
                :   new BERTaggedObject(false, tag, BERFactory.createSequence(v));
            varC07ACA78BFC88AF6278E6A4455DBEB23_1516596840.addTaint(taint);
            return varC07ACA78BFC88AF6278E6A4455DBEB23_1516596840;
        } //End block
DERObject var1D06EA7540ADBA3F4001D24F22BE44FD_485202309 =         v.size() == 1
            ?   new DERTaggedObject(true, tag, v.get(0))
            :   new DERTaggedObject(false, tag, DERFactory.createSequence(v));
        var1D06EA7540ADBA3F4001D24F22BE44FD_485202309.addTaint(taint);
        return var1D06EA7540ADBA3F4001D24F22BE44FD_485202309;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.855 -0400", hash_original_method = "8294A0F9B070E477A3BFFFBCF1187D7F", hash_generated_method = "5E246C2DD37F39DC5250B203C2779D01")
    public DEREncodable readObject() throws IOException {
        int tag = _in.read();
        if(tag == -1)        
        {
DEREncodable var540C13E9E156B687226421B24F2DF178_440182148 =             null;
            var540C13E9E156B687226421B24F2DF178_440182148.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_440182148;
        } //End block
        set00Check(false);
        int tagNo = ASN1InputStream.readTagNumber(_in, tag);
        boolean isConstructed = (tag & DERTags.CONSTRUCTED) != 0;
        int length = ASN1InputStream.readLength(_in, _limit);
        if(length < 0)        
        {
            if(!isConstructed)            
            {
                IOException var0055B29725078D64828DFE2C61240180_468456271 = new IOException("indefinite length primitive encoding encountered");
                var0055B29725078D64828DFE2C61240180_468456271.addTaint(taint);
                throw var0055B29725078D64828DFE2C61240180_468456271;
            } //End block
            IndefiniteLengthInputStream indIn = new IndefiniteLengthInputStream(_in, _limit);
            ASN1StreamParser sp = new ASN1StreamParser(indIn, _limit);
            if((tag & DERTags.APPLICATION) != 0)            
            {
DEREncodable var11ED764D242250CD7F8796812C709662_626230490 =                 new BERApplicationSpecificParser(tagNo, sp);
                var11ED764D242250CD7F8796812C709662_626230490.addTaint(taint);
                return var11ED764D242250CD7F8796812C709662_626230490;
            } //End block
            if((tag & DERTags.TAGGED) != 0)            
            {
DEREncodable varC2894F79D4C623555CCB74DE12AE955C_58551344 =                 new BERTaggedObjectParser(true, tagNo, sp);
                varC2894F79D4C623555CCB74DE12AE955C_58551344.addTaint(taint);
                return varC2894F79D4C623555CCB74DE12AE955C_58551344;
            } //End block
DEREncodable var46F2CE50264694A30A6F430C496E99D2_1620902715 =             sp.readIndef(tagNo);
            var46F2CE50264694A30A6F430C496E99D2_1620902715.addTaint(taint);
            return var46F2CE50264694A30A6F430C496E99D2_1620902715;
        } //End block
        else
        {
            DefiniteLengthInputStream defIn = new DefiniteLengthInputStream(_in, length);
            if((tag & DERTags.APPLICATION) != 0)            
            {
DEREncodable varE34C51A9354A8B1A118F6CDDBBAC7679_1032872482 =                 new DERApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
                varE34C51A9354A8B1A118F6CDDBBAC7679_1032872482.addTaint(taint);
                return varE34C51A9354A8B1A118F6CDDBBAC7679_1032872482;
            } //End block
            if((tag & DERTags.TAGGED) != 0)            
            {
DEREncodable var3F7CFA2B5670FDD716D37A008015C64C_1435608107 =                 new BERTaggedObjectParser(isConstructed, tagNo, new ASN1StreamParser(defIn));
                var3F7CFA2B5670FDD716D37A008015C64C_1435608107.addTaint(taint);
                return var3F7CFA2B5670FDD716D37A008015C64C_1435608107;
            } //End block
            if(isConstructed)            
            {
switch(tagNo){
                case DERTags.OCTET_STRING:
DEREncodable var293467A9B5E183F19734AAA557191C58_372863686 =                 new BEROctetStringParser(new ASN1StreamParser(defIn));
                var293467A9B5E183F19734AAA557191C58_372863686.addTaint(taint);
                return var293467A9B5E183F19734AAA557191C58_372863686;
                case DERTags.SEQUENCE:
DEREncodable varDE608D6EEF3B29360518C0EEDD47BD39_1250537314 =                 new DERSequenceParser(new ASN1StreamParser(defIn));
                varDE608D6EEF3B29360518C0EEDD47BD39_1250537314.addTaint(taint);
                return varDE608D6EEF3B29360518C0EEDD47BD39_1250537314;
                case DERTags.SET:
DEREncodable var6F2B2C00A12131343DF8ED21FD471FF1_500191134 =                 new DERSetParser(new ASN1StreamParser(defIn));
                var6F2B2C00A12131343DF8ED21FD471FF1_500191134.addTaint(taint);
                return var6F2B2C00A12131343DF8ED21FD471FF1_500191134;
                case DERTags.EXTERNAL:
DEREncodable var489DFE957303AABCED158DB4BFEC92B9_1409120413 =                 new DERExternalParser(new ASN1StreamParser(defIn));
                var489DFE957303AABCED158DB4BFEC92B9_1409120413.addTaint(taint);
                return var489DFE957303AABCED158DB4BFEC92B9_1409120413;
                default:
DEREncodable varD10C2E8D563A110A48696C7D62447036_1638201382 =                 new DERUnknownTag(true, tagNo, defIn.toByteArray());
                varD10C2E8D563A110A48696C7D62447036_1638201382.addTaint(taint);
                return varD10C2E8D563A110A48696C7D62447036_1638201382;
}
            } //End block
switch(tagNo){
            case DERTags.OCTET_STRING:
DEREncodable var6987EF6B6D8E5EBDFB82EBF5A7D03817_483887003 =             new DEROctetStringParser(defIn);
            var6987EF6B6D8E5EBDFB82EBF5A7D03817_483887003.addTaint(taint);
            return var6987EF6B6D8E5EBDFB82EBF5A7D03817_483887003;
}            try 
            {
DEREncodable var645D42AEC1170006BF2760866022159D_118839665 =                 ASN1InputStream.createPrimitiveDERObject(tagNo, defIn.toByteArray());
                var645D42AEC1170006BF2760866022159D_118839665.addTaint(taint);
                return var645D42AEC1170006BF2760866022159D_118839665;
            } //End block
            catch (IllegalArgumentException e)
            {
                ASN1Exception var30FC1394D6DD5B9F39A6694742A3F039_993999645 = new ASN1Exception("corrupted stream detected", e);
                var30FC1394D6DD5B9F39A6694742A3F039_993999645.addTaint(taint);
                throw var30FC1394D6DD5B9F39A6694742A3F039_993999645;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.857 -0400", hash_original_method = "4F333A451CCAA8C49D86BC8C0430A606", hash_generated_method = "E70C09FFF2F6AA5D68125DB92827308D")
    private void set00Check(boolean enabled) {
        addTaint(enabled);
        if(_in instanceof IndefiniteLengthInputStream)        
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(enabled);
        } //End block
        // ---------- Original Method ----------
        //if (_in instanceof IndefiniteLengthInputStream)
        //{
            //((IndefiniteLengthInputStream)_in).setEofOn00(enabled);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.858 -0400", hash_original_method = "0431F63F80CE6652BCE08CECE2E42AA0", hash_generated_method = "1B577303096E0736A69B4BBC660C482F")
     ASN1EncodableVector readVector() throws IOException {
        ASN1EncodableVector v = new ASN1EncodableVector();
        DEREncodable obj;
        while
((obj = readObject()) != null)        
        {
            if(obj instanceof InMemoryRepresentable)            
            {
                v.add(((InMemoryRepresentable)obj).getLoadedObject());
            } //End block
            else
            {
                v.add(obj.getDERObject());
            } //End block
        } //End block
ASN1EncodableVector var6DC76BC51820DD65E8396280E884AA78_639897785 =         v;
        var6DC76BC51820DD65E8396280E884AA78_639897785.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_639897785;
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

