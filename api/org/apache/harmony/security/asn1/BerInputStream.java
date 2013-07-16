package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class BerInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.828 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.828 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "FBA3E90E1AEF84B9DE40F7F93AE8B84B")

    protected byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.828 -0400", hash_original_field = "F13C8B3640CBC13657DAF750F9C8A763", hash_generated_field = "47DA870F49698AFE94AB5C1004A17787")

    protected int offset = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.828 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

    public int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.828 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "01D45192EF478C4B8895FC65CF51D2EB")

    protected int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.828 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "57FED7E8E8FF2184EEF7EFF7F0B770B6")

    public Object content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.828 -0400", hash_original_field = "0FE9238E05A1761544B80900699E2D71", hash_generated_field = "1C9B4A7A1F753F59487D78BA9637D2A9")

    protected int tagOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.828 -0400", hash_original_field = "C6CE8DFCFDDF69BCD2C379016D9218BA", hash_generated_field = "EC588CCB12D3A88BA3D161DCA8D8918C")

    protected int contentOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.828 -0400", hash_original_field = "83218587972461405B9AE8CC9B3DB6F7", hash_generated_field = "0BFC4C9F195DE6B4C0280180D67D78C2")

    public int choiceIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.829 -0400", hash_original_field = "F2B798F672D4B42C0359CED11D4F10CD", hash_generated_field = "13DDA1F04AC379B354F578F22425463A")

    public int[] times;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.829 -0400", hash_original_field = "83AC5317DA0C5AED8B38371E24E0E858", hash_generated_field = "022E0C44AE6A598FC1C18F39EC6A5FAB")

    public int oidElement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.829 -0400", hash_original_field = "BE94DE0DE4D9890F5D1C703A2ED7090A", hash_generated_field = "FEA45D225F5AF2828047CBD2A607E879")

    protected boolean isVerify;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.829 -0400", hash_original_field = "4BB7747F74E36AE6A0B38A70A077C2C7", hash_generated_field = "00FF4B69234D0AC263E1AA84F9B79338")

    protected boolean isIndefinedLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.829 -0400", hash_original_field = "B10A8C0BEDE9EB4EA771B04DB3149F28", hash_generated_field = "052E31DFE5C2BAB4284743C186914165")

    private Object[][] pool;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.829 -0400", hash_original_method = "879F2FC8DE697B067D571C3BF31ADD98", hash_generated_method = "D463D36C1F029E44BAE5AEAD9B64564C")
    public  BerInputStream(byte[] encoded) throws IOException {
        this(encoded, 0, encoded.length);
        addTaint(encoded[0]);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.830 -0400", hash_original_method = "FB2C80FA06C3B0FD8EA5024440AD49C3", hash_generated_method = "A0DC1E3B84D9387A24BFD9FECFEB7490")
    public  BerInputStream(byte[] encoded, int offset, int expectedLength) throws IOException {
        addTaint(expectedLength);
        this.in = null;
        this.buffer = encoded;
        this.offset = offset;
        next();
    if(length != INDEFINIT_LENGTH
                && (offset + expectedLength) != (this.offset + this.length))        
        {
            ASN1Exception varB0F890C2A356BB480ED367F285F64F08_1379166194 = new ASN1Exception("Wrong content length");
            varB0F890C2A356BB480ED367F285F64F08_1379166194.addTaint(taint);
            throw varB0F890C2A356BB480ED367F285F64F08_1379166194;
        } //End block
        // ---------- Original Method ----------
        //this.in = null;
        //this.buffer = encoded;
        //this.offset = offset;
        //next();
        //if (length != INDEFINIT_LENGTH
                //&& (offset + expectedLength) != (this.offset + this.length)) {
            //throw new ASN1Exception("Wrong content length");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.830 -0400", hash_original_method = "43063225C34584E29FE6185CE8AAB05D", hash_generated_method = "3A90B6A336723BC11B1F963E14757334")
    public  BerInputStream(InputStream in) throws IOException {
        this(in, BUF_INCREASE_SIZE);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.831 -0400", hash_original_method = "ED7F15B5071BF063BB4017E313468A57", hash_generated_method = "2BC13F22EB120F0C2C0BE206B1D95E06")
    public  BerInputStream(InputStream in, int initialSize) throws IOException {
        this.in = in;
        buffer = new byte[initialSize];
        next();
    if(length != INDEFINIT_LENGTH)        
        {
    if(buffer.length < (length + offset))            
            {
                byte[] newBuffer = new byte[length + offset];
                System.arraycopy(buffer, 0, newBuffer, 0, offset);
                buffer = newBuffer;
            } //End block
        } //End block
        else
        {
            isIndefinedLength = true;
            ASN1Exception var54A4D56CBDC0B40731B7A58FAD9A8196_211779606 = new ASN1Exception("Decoding indefinite length encoding is not supported");
            var54A4D56CBDC0B40731B7A58FAD9A8196_211779606.addTaint(taint);
            throw var54A4D56CBDC0B40731B7A58FAD9A8196_211779606;
        } //End block
        // ---------- Original Method ----------
        //this.in = in;
        //buffer = new byte[initialSize];
        //next();
        //if (length != INDEFINIT_LENGTH) {
            //if (buffer.length < (length + offset)) {
                //byte[] newBuffer = new byte[length + offset];
                //System.arraycopy(buffer, 0, newBuffer, 0, offset);
                //buffer = newBuffer;
            //}
        //} else {
            //isIndefinedLength = true;
            //throw new ASN1Exception("Decoding indefinite length encoding is not supported");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.832 -0400", hash_original_method = "4CCBB4621387969DDD8BDCB7ADDE8473", hash_generated_method = "5C19B2C85550850E24C9B051962F85BD")
    public final void reset(byte[] encoded) throws IOException {
        buffer = encoded;
        next();
        // ---------- Original Method ----------
        //buffer = encoded;
        //next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.833 -0400", hash_original_method = "E21A3F5A1E5C42E0733DFCD7E2B1A37B", hash_generated_method = "D3AE23F24D9B580BC40FB352327D52F6")
    public int next() throws IOException {
        tagOffset = offset;
        tag = read();
        length = read();
    if(length != 0x80)        
        {
    if((length & 0x80) != 0)            
            {
                int numOctets = length & 0x7F;
    if(numOctets > 5)                
                {
                    ASN1Exception varBD1890F5E4E062EC3A4E0B1B48CB4C8F_1275487928 = new ASN1Exception("Too long encoding at [" + tagOffset + "]");
                    varBD1890F5E4E062EC3A4E0B1B48CB4C8F_1275487928.addTaint(taint);
                    throw varBD1890F5E4E062EC3A4E0B1B48CB4C8F_1275487928;
                } //End block
                length = read();
for(int i = 1;i < numOctets;i++)
                {
                    int ch = read();
                    length = (length << 8) + ch;
                } //End block
    if(length > 0xFFFFFF)                
                {
                    ASN1Exception varBD1890F5E4E062EC3A4E0B1B48CB4C8F_698398828 = new ASN1Exception("Too long encoding at [" + tagOffset + "]");
                    varBD1890F5E4E062EC3A4E0B1B48CB4C8F_698398828.addTaint(taint);
                    throw varBD1890F5E4E062EC3A4E0B1B48CB4C8F_698398828;
                } //End block
            } //End block
        } //End block
        else
        {
            length = INDEFINIT_LENGTH;
        } //End block
        contentOffset = offset;
        int varE4D23E841D8E8804190027BCE3180FA5_1275595902 = (tag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593917062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593917062;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
    public static int getLength(byte[] encoding) {
        int length = encoding[1] & 0xFF;
        int numOctets = 0;
        if ((length & 0x80) != 0) { 
            numOctets = length & 0x7F;
            length = encoding[2] & 0xFF;
            for (int i = 3; i < numOctets + 2; i++) {
                length = (length << 8) + (encoding[i] & 0xFF);
            }
        }
        return 1 + 1 + numOctets + length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.839 -0400", hash_original_method = "A15B72AB03BE363B2B31FA8E7C1F64A3", hash_generated_method = "EE8E36DA1F86B943084B5346AAAEE051")
    public void readBitString() throws IOException {
    if(tag == ASN1Constants.TAG_BITSTRING)        
        {
    if(length == 0)            
            {
                ASN1Exception var81E1F886748BDC34D8A4553AC8005463_1161903742 = new ASN1Exception("ASN.1 Bitstring: wrong length. Tag at [" + tagOffset + "]");
                var81E1F886748BDC34D8A4553AC8005463_1161903742.addTaint(taint);
                throw var81E1F886748BDC34D8A4553AC8005463_1161903742;
            } //End block
            readContent();
    if(buffer[contentOffset] > 7)            
            {
                ASN1Exception var5F450A67A5944F6D81916FC2548CC078_220290507 = new ASN1Exception("ASN.1 Bitstring: wrong content at [" + contentOffset
                        + "]. A number of unused bits MUST be in range 0 to 7");
                var5F450A67A5944F6D81916FC2548CC078_220290507.addTaint(taint);
                throw var5F450A67A5944F6D81916FC2548CC078_220290507;
            } //End block
    if(length == 1 && buffer[contentOffset] != 0)            
            {
                ASN1Exception var05777D5E8FFAACB333195FFC499F725A_1973691611 = new ASN1Exception("ASN.1 Bitstring: wrong content at [" + contentOffset
                        + "]. For empty string unused bits MUST be 0");
                var05777D5E8FFAACB333195FFC499F725A_1973691611.addTaint(taint);
                throw var05777D5E8FFAACB333195FFC499F725A_1973691611;
            } //End block
        } //End block
        else
    if(tag == ASN1Constants.TAG_C_BITSTRING)        
        {
            ASN1Exception varC43382E12489F4CD5C2C424238ACA629_2003880365 = new ASN1Exception("Decoding constructed ASN.1 bitstring  type is not provided");
            varC43382E12489F4CD5C2C424238ACA629_2003880365.addTaint(taint);
            throw varC43382E12489F4CD5C2C424238ACA629_2003880365;
        } //End block
        else
        {
            org.apache.harmony.security.asn1.ASN1Exception varE48E3968ACB5C0CAFBC4EF0127FAD6B0_440350253 = expected("bitstring");
            varE48E3968ACB5C0CAFBC4EF0127FAD6B0_440350253.addTaint(taint);
            throw varE48E3968ACB5C0CAFBC4EF0127FAD6B0_440350253;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.846 -0400", hash_original_method = "70271B544C5D122FB5ABE2DE9A460926", hash_generated_method = "F7EE3DC502F8F75AFC225709FFCEA134")
    public void readEnumerated() throws IOException {
    if(tag != ASN1Constants.TAG_ENUM)        
        {
            org.apache.harmony.security.asn1.ASN1Exception var6CEFDC196090BEB9B130DF3C4C24118B_1251239586 = expected("enumerated");
            var6CEFDC196090BEB9B130DF3C4C24118B_1251239586.addTaint(taint);
            throw var6CEFDC196090BEB9B130DF3C4C24118B_1251239586;
        } //End block
    if(length == 0)        
        {
            ASN1Exception var0B16AFB0E027FB2FF710F6F4E3438F3C_36853818 = new ASN1Exception("ASN.1 enumerated: wrong length for identifier at ["
                    + tagOffset + "]");
            var0B16AFB0E027FB2FF710F6F4E3438F3C_36853818.addTaint(taint);
            throw var0B16AFB0E027FB2FF710F6F4E3438F3C_36853818;
        } //End block
        readContent();
    if(length > 1)        
        {
            int bits = buffer[contentOffset] & 0xFF;
    if(buffer[contentOffset + 1] < 0)            
            {
                bits += 0x100;
            } //End block
    if(bits == 0 || bits == 0x1FF)            
            {
                ASN1Exception var06ED68E8CF9D538BC278D8903A085A1C_2089535492 = new ASN1Exception("ASN.1 enumerated: wrong content at [" + contentOffset
                        + "]. An integer MUST be encoded in minimum number of octets");
                var06ED68E8CF9D538BC278D8903A085A1C_2089535492.addTaint(taint);
                throw var06ED68E8CF9D538BC278D8903A085A1C_2089535492;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_ENUM) {
            //throw expected("enumerated");
        //}
        //if (length == 0) {
            //throw new ASN1Exception("ASN.1 enumerated: wrong length for identifier at ["
                    //+ tagOffset + "]");
        //}
        //readContent();
        //if (length > 1) {
            //int bits = buffer[contentOffset] & 0xFF;
            //if (buffer[contentOffset + 1] < 0) {
                //bits += 0x100;
            //}
            //if (bits == 0 || bits == 0x1FF) {
                //throw new ASN1Exception("ASN.1 enumerated: wrong content at [" + contentOffset
                        //+ "]. An integer MUST be encoded in minimum number of octets");
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.850 -0400", hash_original_method = "13F2651D91961A81EAE79BEA9D5230AF", hash_generated_method = "22DD234259086F819B1478BAD390D8FE")
    public void readBoolean() throws IOException {
    if(tag != ASN1Constants.TAG_BOOLEAN)        
        {
            org.apache.harmony.security.asn1.ASN1Exception varEFA3EF36A0C476961B46A4D8ABA7D265_1723687222 = expected("boolean");
            varEFA3EF36A0C476961B46A4D8ABA7D265_1723687222.addTaint(taint);
            throw varEFA3EF36A0C476961B46A4D8ABA7D265_1723687222;
        } //End block
    if(length != 1)        
        {
            ASN1Exception var43A07363A82AF3BEE58F953C3D9038BF_788282269 = new ASN1Exception("Wrong length for ASN.1 boolean at [" + tagOffset + "]");
            var43A07363A82AF3BEE58F953C3D9038BF_788282269.addTaint(taint);
            throw var43A07363A82AF3BEE58F953C3D9038BF_788282269;
        } //End block
        readContent();
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_BOOLEAN) {
            //throw expected("boolean");
        //}
        //if (length != 1) {
            //throw new ASN1Exception("Wrong length for ASN.1 boolean at [" + tagOffset + "]");
        //}
        //readContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.863 -0400", hash_original_method = "1A3161CCB7646B7891B929A5396BF673", hash_generated_method = "ED67C4B12ED37E7E3F0362DBC1157BBA")
    public void readGeneralizedTime() throws IOException {
    if(tag == ASN1Constants.TAG_GENERALIZEDTIME)        
        {
            readContent();
    if(buffer[offset - 1] != 'Z')            
            {
                ASN1Exception varA29B31F0C543B27C5A273FEFE7372CC8_1257292672 = new ASN1Exception("ASN.1 GeneralizedTime: encoded format is not implemented");
                varA29B31F0C543B27C5A273FEFE7372CC8_1257292672.addTaint(taint);
                throw varA29B31F0C543B27C5A273FEFE7372CC8_1257292672;
            } //End block
    if(length != 15 && (length < 17 || length > 19))            
            {
                ASN1Exception var5D220EA44DF236695BC180CC7D7493F1_716331586 = new ASN1Exception("ASN.1 GeneralizedTime wrongly encoded at ["
                        + contentOffset + "]");
                var5D220EA44DF236695BC180CC7D7493F1_716331586.addTaint(taint);
                throw var5D220EA44DF236695BC180CC7D7493F1_716331586;
            } //End block
    if(length > 16)            
            {
                byte char14 = buffer[contentOffset + 14];
    if(char14 != '.' && char14 != ',')                
                {
                    ASN1Exception var5D220EA44DF236695BC180CC7D7493F1_1489171067 = new ASN1Exception("ASN.1 GeneralizedTime wrongly encoded at ["
                            + contentOffset + "]");
                    var5D220EA44DF236695BC180CC7D7493F1_1489171067.addTaint(taint);
                    throw var5D220EA44DF236695BC180CC7D7493F1_1489171067;
                } //End block
            } //End block
    if(times == null)            
            {
                times = new int[7];
            } //End block
            times[0] = strToInt(contentOffset, 4);
            times[1] = strToInt(contentOffset + 4, 2);
            times[2] = strToInt(contentOffset + 6, 2);
            times[3] = strToInt(contentOffset + 8, 2);
            times[4] = strToInt(contentOffset + 10, 2);
            times[5] = strToInt(contentOffset + 12, 2);
    if(length > 16)            
            {
                times[6] = strToInt(contentOffset + 15, length - 16);
    if(length == 17)                
                {
                    times[6] = times[6] * 100;
                } //End block
                else
    if(length == 18)                
                {
                    times[6] = times[6] * 10;
                } //End block
            } //End block
        } //End block
        else
    if(tag == ASN1Constants.TAG_C_GENERALIZEDTIME)        
        {
            ASN1Exception varB7227F8A5F29C5D1F6D9C6C5A75B2208_1930815525 = new ASN1Exception("Decoding constructed ASN.1 GeneralizedTime type is not supported");
            varB7227F8A5F29C5D1F6D9C6C5A75B2208_1930815525.addTaint(taint);
            throw varB7227F8A5F29C5D1F6D9C6C5A75B2208_1930815525;
        } //End block
        else
        {
            org.apache.harmony.security.asn1.ASN1Exception varED979873169C54EE1A261A2790B3D61B_1830906150 = expected("GeneralizedTime");
            varED979873169C54EE1A261A2790B3D61B_1830906150.addTaint(taint);
            throw varED979873169C54EE1A261A2790B3D61B_1830906150;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.878 -0400", hash_original_method = "D1E9408574A13A490CB1D3EF3A359E97", hash_generated_method = "AB43CBCB89525011E059A8CF5B271BD9")
    public void readUTCTime() throws IOException {
    if(tag == ASN1Constants.TAG_UTCTIME)        
        {
switch(length){
            case ASN1UTCTime.UTC_HM:
            case ASN1UTCTime.UTC_HMS:
            break;
            case ASN1UTCTime.UTC_LOCAL_HM:
            case ASN1UTCTime.UTC_LOCAL_HMS:
            ASN1Exception var6CE1AFB51D276F0889B5C9867D2A5B21_1996737216 = new ASN1Exception("ASN.1 UTCTime: local time format is not supported");
            var6CE1AFB51D276F0889B5C9867D2A5B21_1996737216.addTaint(taint);
            throw var6CE1AFB51D276F0889B5C9867D2A5B21_1996737216;
            default:
            ASN1Exception varB742E3D9B66DED292C05CAF832A6D21B_305321470 = new ASN1Exception("ASN.1 UTCTime: wrong length, identifier at " + tagOffset);
            varB742E3D9B66DED292C05CAF832A6D21B_305321470.addTaint(taint);
            throw varB742E3D9B66DED292C05CAF832A6D21B_305321470;
}            readContent();
    if(buffer[offset - 1] != 'Z')            
            {
                ASN1Exception var03C7C95A390DD4D9B5B64CABA9914274_790122861 = new ASN1Exception("ASN.1 UTCTime wrongly encoded at ["
                        + contentOffset + ']');
                var03C7C95A390DD4D9B5B64CABA9914274_790122861.addTaint(taint);
                throw var03C7C95A390DD4D9B5B64CABA9914274_790122861;
            } //End block
    if(times == null)            
            {
                times = new int[7];
            } //End block
            times[0] = strToInt(contentOffset, 2);
    if(times[0] > 49)            
            {
                times[0] += 1900;
            } //End block
            else
            {
                times[0] += 2000;
            } //End block
            times[1] = strToInt(contentOffset + 2, 2);
            times[2] = strToInt(contentOffset + 4, 2);
            times[3] = strToInt(contentOffset + 6, 2);
            times[4] = strToInt(contentOffset + 8, 2);
    if(length == ASN1UTCTime.UTC_HMS)            
            {
                times[5] = strToInt(contentOffset + 10, 2);
            } //End block
        } //End block
        else
    if(tag == ASN1Constants.TAG_C_UTCTIME)        
        {
            ASN1Exception var793FDDEB95F2FB061E2D85B4A4E2A88E_1277572401 = new ASN1Exception("Decoding constructed ASN.1 UTCTime type is not supported");
            var793FDDEB95F2FB061E2D85B4A4E2A88E_1277572401.addTaint(taint);
            throw var793FDDEB95F2FB061E2D85B4A4E2A88E_1277572401;
        } //End block
        else
        {
            org.apache.harmony.security.asn1.ASN1Exception varF60ADDA30580DDCE55211C2F5C6A3A64_524492035 = expected("UTCTime");
            varF60ADDA30580DDCE55211C2F5C6A3A64_524492035.addTaint(taint);
            throw varF60ADDA30580DDCE55211C2F5C6A3A64_524492035;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.880 -0400", hash_original_method = "7B8FBAB80C5ADD7C25B56AA6C7A7A7A0", hash_generated_method = "28CE92BBB0D69CE0EE35830E235C1AAA")
    private int strToInt(int off, int count) throws ASN1Exception {
        addTaint(count);
        addTaint(off);
        int result = 0;
for(int i = off, end = off + count;i < end;i++)
        {
            int c = buffer[i] - 48;
    if(c < 0 || c > 9)            
            {
                ASN1Exception varBCF34CC252A41A843DCCDC7999C8E955_1710372398 = new ASN1Exception("Time encoding has invalid char");
                varBCF34CC252A41A843DCCDC7999C8E955_1710372398.addTaint(taint);
                throw varBCF34CC252A41A843DCCDC7999C8E955_1710372398;
            } //End block
            result = result * 10 + c;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_165958204 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414515865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414515865;
        // ---------- Original Method ----------
        //int result = 0;
        //for (int i = off, end = off + count; i < end; i++) {
            //int c = buffer[i] - 48;
            //if (c < 0 || c > 9) {
                //throw new ASN1Exception("Time encoding has invalid char");
            //}
            //result = result * 10 + c;
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.887 -0400", hash_original_method = "8E0BB334F5FA3F917B6C3297724E29A6", hash_generated_method = "7F013936907CCE39752A3133DACF1721")
    public void readInteger() throws IOException {
    if(tag != ASN1Constants.TAG_INTEGER)        
        {
            org.apache.harmony.security.asn1.ASN1Exception var86AA29E38FF5A6A302EE7C158E0F212E_1523424263 = expected("integer");
            var86AA29E38FF5A6A302EE7C158E0F212E_1523424263.addTaint(taint);
            throw var86AA29E38FF5A6A302EE7C158E0F212E_1523424263;
        } //End block
    if(length < 1)        
        {
            ASN1Exception var09AF55CB6530112CAB26F3DB8D600C9B_1088014259 = new ASN1Exception("Wrong length for ASN.1 integer at [" + tagOffset + "]");
            var09AF55CB6530112CAB26F3DB8D600C9B_1088014259.addTaint(taint);
            throw var09AF55CB6530112CAB26F3DB8D600C9B_1088014259;
        } //End block
        readContent();
    if(length > 1)        
        {
            byte firstByte = buffer[offset - length];
            byte secondByte = (byte) (buffer[offset - length + 1] & 0x80);
    if(firstByte == 0 && secondByte == 0 || firstByte == (byte) 0xFF
                    && secondByte == (byte) 0x80)            
            {
                ASN1Exception varAD452B9FB9D82CA8DD1C4BC4D5970DBD_795392136 = new ASN1Exception("Wrong content for ASN.1 integer at [" + (offset - length) + "]. An integer MUST be encoded in minimum number of octets");
                varAD452B9FB9D82CA8DD1C4BC4D5970DBD_795392136.addTaint(taint);
                throw varAD452B9FB9D82CA8DD1C4BC4D5970DBD_795392136;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_INTEGER) {
            //throw expected("integer");
        //}
        //if (length < 1) {
            //throw new ASN1Exception("Wrong length for ASN.1 integer at [" + tagOffset + "]");
        //}
        //readContent();
        //if (length > 1) {
            //byte firstByte = buffer[offset - length];
            //byte secondByte = (byte) (buffer[offset - length + 1] & 0x80);
            //if (firstByte == 0 && secondByte == 0 || firstByte == (byte) 0xFF
                    //&& secondByte == (byte) 0x80) {
                //throw new ASN1Exception("Wrong content for ASN.1 integer at [" + (offset - length) + "]. An integer MUST be encoded in minimum number of octets");
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.890 -0400", hash_original_method = "FF10597CCF521EBE62B89D95947AA842", hash_generated_method = "2B14660A19AC379C2A797EFF6BD91371")
    public void readOctetString() throws IOException {
    if(tag == ASN1Constants.TAG_OCTETSTRING)        
        {
            readContent();
        } //End block
        else
    if(tag == ASN1Constants.TAG_C_OCTETSTRING)        
        {
            ASN1Exception var6E9A683485519CEBE2064A48B15A3331_947538254 = new ASN1Exception("Decoding constructed ASN.1 octet string type is not supported");
            var6E9A683485519CEBE2064A48B15A3331_947538254.addTaint(taint);
            throw var6E9A683485519CEBE2064A48B15A3331_947538254;
        } //End block
        else
        {
            org.apache.harmony.security.asn1.ASN1Exception var71AACD0964BFC3FA26CC63EE2E887D15_1785467330 = expected("octetstring");
            var71AACD0964BFC3FA26CC63EE2E887D15_1785467330.addTaint(taint);
            throw var71AACD0964BFC3FA26CC63EE2E887D15_1785467330;
        } //End block
        // ---------- Original Method ----------
        //if (tag == ASN1Constants.TAG_OCTETSTRING) {
            //readContent();
        //} else if (tag == ASN1Constants.TAG_C_OCTETSTRING) {
            //throw new ASN1Exception("Decoding constructed ASN.1 octet string type is not supported");
        //} else {
            //throw expected("octetstring");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.891 -0400", hash_original_method = "31EAA277FAF0612B23F88A136EEA2499", hash_generated_method = "95F8349A55ACF7071C5FC92AFAC815A9")
    private ASN1Exception expected(String what) throws ASN1Exception {
        addTaint(what.getTaint());
        ASN1Exception varD41BC60AA1F934B444D0C89980E02BA2_377262732 = new ASN1Exception("ASN.1 " + what + " identifier expected at [" + tagOffset + "], got " + Integer.toHexString(tag));
        varD41BC60AA1F934B444D0C89980E02BA2_377262732.addTaint(taint);
        throw varD41BC60AA1F934B444D0C89980E02BA2_377262732;
        // ---------- Original Method ----------
        //throw new ASN1Exception("ASN.1 " + what + " identifier expected at [" + tagOffset + "], got " + Integer.toHexString(tag));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.898 -0400", hash_original_method = "1DFB0A727BF9534907B350DDA9E1A15B", hash_generated_method = "6C14754EFE7CE6B8147CE4D4B4C59B2B")
    public void readOID() throws IOException {
    if(tag != ASN1Constants.TAG_OID)        
        {
            org.apache.harmony.security.asn1.ASN1Exception var40F298E39089338C810B48C45E81F938_629037430 = expected("OID");
            var40F298E39089338C810B48C45E81F938_629037430.addTaint(taint);
            throw var40F298E39089338C810B48C45E81F938_629037430;
        } //End block
    if(length < 1)        
        {
            ASN1Exception var414FA454F66DB3BBC07828876058D547_1964243792 = new ASN1Exception("Wrong length for ASN.1 object identifier at [" + tagOffset + "]");
            var414FA454F66DB3BBC07828876058D547_1964243792.addTaint(taint);
            throw var414FA454F66DB3BBC07828876058D547_1964243792;
        } //End block
        readContent();
    if((buffer[offset - 1] & 0x80) != 0)        
        {
            ASN1Exception var7AABC3456FDE31D3386BE1D2A6939D6E_1239116082 = new ASN1Exception("Wrong encoding at [" + (offset - 1) + "]");
            var7AABC3456FDE31D3386BE1D2A6939D6E_1239116082.addTaint(taint);
            throw var7AABC3456FDE31D3386BE1D2A6939D6E_1239116082;
        } //End block
        oidElement = 1;
for(int i = 0;i < length;i++,++oidElement)
        {
            while
((buffer[contentOffset + i] & 0x80) == 0x80)            
            {
                i++;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_OID) {
            //throw expected("OID");
        //}
        //if (length < 1) {
            //throw new ASN1Exception("Wrong length for ASN.1 object identifier at [" + tagOffset + "]");
        //}
        //readContent();
        //if ((buffer[offset - 1] & 0x80) != 0) {
            //throw new ASN1Exception("Wrong encoding at [" + (offset - 1) + "]");
        //}
        //oidElement = 1;
        //for (int i = 0; i < length; i++, ++oidElement) {
            //while ((buffer[contentOffset + i] & 0x80) == 0x80) {
                //i++;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.916 -0400", hash_original_method = "97688987A014CB8C0C54BAB32FA72A4F", hash_generated_method = "9EAABC5E5AB79236264C91A85401988A")
    public void readSequence(ASN1Sequence sequence) throws IOException {
        addTaint(sequence.getTaint());
    if(tag != ASN1Constants.TAG_C_SEQUENCE)        
        {
            org.apache.harmony.security.asn1.ASN1Exception var589AB7506A8FD2C98815356FBAFE6068_573886426 = expected("sequence");
            var589AB7506A8FD2C98815356FBAFE6068_573886426.addTaint(taint);
            throw var589AB7506A8FD2C98815356FBAFE6068_573886426;
        } //End block
        int begOffset = offset;
        int endOffset = begOffset + length;
        ASN1Type[] type = sequence.type;
        int i = 0;
    if(isVerify)        
        {
for(;(offset < endOffset) && (i < type.length);i++)
            {
                next();
                while
(!type[i].checkTag(tag))                
                {
    if(!sequence.OPTIONAL[i] || (i == type.length - 1))                    
                    {
                        ASN1Exception var3C7E2304E8760621EDA869C0E1FEFBA0_1400999427 = new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                        var3C7E2304E8760621EDA869C0E1FEFBA0_1400999427.addTaint(taint);
                        throw var3C7E2304E8760621EDA869C0E1FEFBA0_1400999427;
                    } //End block
                    i++;
                } //End block
                type[i].decode(this);
            } //End block
for(;i < type.length;i++)
            {
    if(!sequence.OPTIONAL[i])                
                {
                    ASN1Exception var3C7E2304E8760621EDA869C0E1FEFBA0_1651844770 = new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                    var3C7E2304E8760621EDA869C0E1FEFBA0_1651844770.addTaint(taint);
                    throw var3C7E2304E8760621EDA869C0E1FEFBA0_1651844770;
                } //End block
            } //End block
        } //End block
        else
        {
            int seqTagOffset = tagOffset;
            Object[] values = new Object[type.length];
for(;(offset < endOffset) && (i < type.length);i++)
            {
                next();
                while
(!type[i].checkTag(tag))                
                {
    if(!sequence.OPTIONAL[i] || (i == type.length - 1))                    
                    {
                        ASN1Exception var3C7E2304E8760621EDA869C0E1FEFBA0_442298485 = new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                        var3C7E2304E8760621EDA869C0E1FEFBA0_442298485.addTaint(taint);
                        throw var3C7E2304E8760621EDA869C0E1FEFBA0_442298485;
                    } //End block
    if(sequence.DEFAULT[i] != null)                    
                    {
                        values[i] = sequence.DEFAULT[i];
                    } //End block
                    i++;
                } //End block
                values[i] = type[i].decode(this);
            } //End block
for(;i < type.length;i++)
            {
    if(!sequence.OPTIONAL[i])                
                {
                    ASN1Exception var3C7E2304E8760621EDA869C0E1FEFBA0_316592213 = new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                    var3C7E2304E8760621EDA869C0E1FEFBA0_316592213.addTaint(taint);
                    throw var3C7E2304E8760621EDA869C0E1FEFBA0_316592213;
                } //End block
    if(sequence.DEFAULT[i] != null)                
                {
                    values[i] = sequence.DEFAULT[i];
                } //End block
            } //End block
            content = values;
            tagOffset = seqTagOffset;
        } //End block
    if(offset != endOffset)        
        {
            ASN1Exception var12B767C9FC2DBAD178BC1E0EA0AB862F_1040027855 = new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
            var12B767C9FC2DBAD178BC1E0EA0AB862F_1040027855.addTaint(taint);
            throw var12B767C9FC2DBAD178BC1E0EA0AB862F_1040027855;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.920 -0400", hash_original_method = "48BA5600C2E0D1ED619B576E3555D97D", hash_generated_method = "A1E5763EE86D23678C78BCD725925CDC")
    public void readSequenceOf(ASN1SequenceOf sequenceOf) throws IOException {
        addTaint(sequenceOf.getTaint());
    if(tag != ASN1Constants.TAG_C_SEQUENCEOF)        
        {
            org.apache.harmony.security.asn1.ASN1Exception varACB2B980E7A602ECF098FBC22121049F_419005953 = expected("sequenceOf");
            varACB2B980E7A602ECF098FBC22121049F_419005953.addTaint(taint);
            throw varACB2B980E7A602ECF098FBC22121049F_419005953;
        } //End block
        decodeValueCollection(sequenceOf);
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_C_SEQUENCEOF) {
            //throw expected("sequenceOf");
        //}
        //decodeValueCollection(sequenceOf);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.924 -0400", hash_original_method = "51B09D41A46E89A1CD0754E5C1F0D1B8", hash_generated_method = "0BB94E81636AA63158B4D8CC4BF2ADF6")
    public void readSet(ASN1Set set) throws IOException {
        addTaint(set.getTaint());
    if(tag != ASN1Constants.TAG_C_SET)        
        {
            org.apache.harmony.security.asn1.ASN1Exception varAE40295708C87BB87863360F3C87DB01_127620940 = expected("set");
            varAE40295708C87BB87863360F3C87DB01_127620940.addTaint(taint);
            throw varAE40295708C87BB87863360F3C87DB01_127620940;
        } //End block
        ASN1Exception var2FD3D3C38B3CBAECC82CB8F1D8DEC1C4_1300707359 = new ASN1Exception("Decoding ASN.1 Set type is not supported");
        var2FD3D3C38B3CBAECC82CB8F1D8DEC1C4_1300707359.addTaint(taint);
        throw var2FD3D3C38B3CBAECC82CB8F1D8DEC1C4_1300707359;
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_C_SET) {
            //throw expected("set");
        //}
        //throw new ASN1Exception("Decoding ASN.1 Set type is not supported");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.927 -0400", hash_original_method = "8593963787440F0A1F5CC05E2CC3EB6D", hash_generated_method = "917A2B570FEA7D871DF92B722C105CC5")
    public void readSetOf(ASN1SetOf setOf) throws IOException {
        addTaint(setOf.getTaint());
    if(tag != ASN1Constants.TAG_C_SETOF)        
        {
            org.apache.harmony.security.asn1.ASN1Exception var5D26E8F56B4F9D46AEF15E951BCA4AF6_979709213 = expected("setOf");
            var5D26E8F56B4F9D46AEF15E951BCA4AF6_979709213.addTaint(taint);
            throw var5D26E8F56B4F9D46AEF15E951BCA4AF6_979709213;
        } //End block
        decodeValueCollection(setOf);
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_C_SETOF) {
            //throw expected("setOf");
        //}
        //decodeValueCollection(setOf);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.928 -0400", hash_original_method = "A1B2FAB02C0A9A6283AF8F291FFC1121", hash_generated_method = "EFE3732592E5529A2231D7500C6313BF")
    private void decodeValueCollection(ASN1ValueCollection collection) throws IOException {
        addTaint(collection.getTaint());
        int begOffset = offset;
        int endOffset = begOffset + length;
        ASN1Type type = collection.type;
    if(isVerify)        
        {
            while
(endOffset > offset)            
            {
                next();
                type.decode(this);
            } //End block
        } //End block
        else
        {
            int seqTagOffset = tagOffset;
            ArrayList<Object> values = new ArrayList<Object>();
            while
(endOffset > offset)            
            {
                next();
                values.add(type.decode(this));
            } //End block
            values.trimToSize();
            content = values;
            tagOffset = seqTagOffset;
        } //End block
    if(offset != endOffset)        
        {
            ASN1Exception var12B767C9FC2DBAD178BC1E0EA0AB862F_1214500363 = new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
            var12B767C9FC2DBAD178BC1E0EA0AB862F_1214500363.addTaint(taint);
            throw var12B767C9FC2DBAD178BC1E0EA0AB862F_1214500363;
        } //End block
        // ---------- Original Method ----------
        //int begOffset = offset;
        //int endOffset = begOffset + length;
        //ASN1Type type = collection.type;
        //if (isVerify) {
            //while (endOffset > offset) {
                //next();
                //type.decode(this);
            //}
        //} else {
            //int seqTagOffset = tagOffset; 
            //ArrayList<Object> values = new ArrayList<Object>();
            //while (endOffset > offset) {
                //next();
                //values.add(type.decode(this));
            //}
            //values.trimToSize();
            //content = values;
            //tagOffset = seqTagOffset; 
        //}
        //if (offset != endOffset) {
            //throw new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.933 -0400", hash_original_method = "2E006816EDCCACEA53589D73DD63B701", hash_generated_method = "DEC4F319A9F35E058C4C2053FE5B12CE")
    public void readString(ASN1StringType type) throws IOException {
        addTaint(type.getTaint());
    if(tag == type.id)        
        {
            readContent();
        } //End block
        else
    if(tag == type.constrId)        
        {
            ASN1Exception varA5300DA95960E60A237A165C0604DBC4_965824230 = new ASN1Exception("Decoding constructed ASN.1 string type is not provided");
            varA5300DA95960E60A237A165C0604DBC4_965824230.addTaint(taint);
            throw varA5300DA95960E60A237A165C0604DBC4_965824230;
        } //End block
        else
        {
            org.apache.harmony.security.asn1.ASN1Exception varFA27DDBF3A90727D3293AB180606DF22_2104681181 = expected("string");
            varFA27DDBF3A90727D3293AB180606DF22_2104681181.addTaint(taint);
            throw varFA27DDBF3A90727D3293AB180606DF22_2104681181;
        } //End block
        // ---------- Original Method ----------
        //if (tag == type.id) {
            //readContent();
        //} else if (tag == type.constrId) {
            //throw new ASN1Exception("Decoding constructed ASN.1 string type is not provided");
        //} else {
            //throw expected("string");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.933 -0400", hash_original_method = "34E54E473055277C13E19CBB4B194845", hash_generated_method = "63F6455E04D11C3E03D4289EC3FBC05D")
    public byte[] getEncoded() {
        byte[] encoded = new byte[offset - tagOffset];
        System.arraycopy(buffer, tagOffset, encoded, 0, encoded.length);
        byte[] var4B719ACEE4A1D5E30577F59E80D06205_1461383401 = (encoded);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2064643398 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2064643398;
        // ---------- Original Method ----------
        //byte[] encoded = new byte[offset - tagOffset];
        //System.arraycopy(buffer, tagOffset, encoded, 0, encoded.length);
        //return encoded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.934 -0400", hash_original_method = "6B125A4F0D6B27C0C7AD41FB42F4DE53", hash_generated_method = "E2842E7001322BC03B5B716A8CC0EDEF")
    public final byte[] getBuffer() {
        byte[] var7F2DB423A49B305459147332FB01CF87_950844557 = (buffer);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1030318883 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1030318883;
        // ---------- Original Method ----------
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.934 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "6B55DED5A86431CE9DE6F862E5007167")
    public final int getLength() {
        int var2FA47F7C65FEC19CC163B195725E3844_566253833 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241849572 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241849572;
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.934 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "FA56AB6FD7E67B51E52DDD2821187C92")
    public final int getOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_810723956 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_323514783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_323514783;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.934 -0400", hash_original_method = "1367D9753B97C5C3A102B7D6550881B9", hash_generated_method = "9BBF0548DD3F99A7D640046B5AB592F8")
    public final int getEndOffset() {
        int var8F6516B482CCBEE9DDA86D5558C78891_1024670878 = (offset + length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1203109868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1203109868;
        // ---------- Original Method ----------
        //return offset + length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.935 -0400", hash_original_method = "1FDDE163F1BBA6CDA778E0FD08E430DE", hash_generated_method = "CE96F063D85540B9E5281418F3CBAE6E")
    public final int getTagOffset() {
        int var0FE9238E05A1761544B80900699E2D71_2048091684 = (tagOffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1320408726 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1320408726;
        // ---------- Original Method ----------
        //return tagOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.935 -0400", hash_original_method = "E5C1E507EA76A704FAE5F4AC771876E5", hash_generated_method = "38A0FA5CCBFAD28A394824D8D2033CBB")
    public final void setVerify() {
        isVerify = true;
        // ---------- Original Method ----------
        //isVerify = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.936 -0400", hash_original_method = "BBFB621282CA0716A19F3267ACDEEE7E", hash_generated_method = "F982AFECE3173308946B4FA9325526D9")
    protected int read() throws IOException {
    if(offset == buffer.length)        
        {
            ASN1Exception var26B82ADCA4A481B99A8295458E5FD024_1799508906 = new ASN1Exception("Unexpected end of encoding");
            var26B82ADCA4A481B99A8295458E5FD024_1799508906.addTaint(taint);
            throw var26B82ADCA4A481B99A8295458E5FD024_1799508906;
        } //End block
    if(in == null)        
        {
            int var793E73D2A95F5BD3DFB82DCD9580B725_1542106075 = (buffer[offset++] & 0xFF);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537187180 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537187180;
        } //End block
        else
        {
            int octet = in.read();
    if(octet == -1)            
            {
                ASN1Exception var26B82ADCA4A481B99A8295458E5FD024_711564847 = new ASN1Exception("Unexpected end of encoding");
                var26B82ADCA4A481B99A8295458E5FD024_711564847.addTaint(taint);
                throw var26B82ADCA4A481B99A8295458E5FD024_711564847;
            } //End block
            buffer[offset++] = (byte) octet;
            int varE7E4B902CD921DDFF17C1D06E34FD67C_623431546 = (octet);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859924828 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859924828;
        } //End block
        // ---------- Original Method ----------
        //if (offset == buffer.length) {
            //throw new ASN1Exception("Unexpected end of encoding");
        //}
        //if (in == null) {
            //return buffer[offset++] & 0xFF;
        //} else {
            //int octet = in.read();
            //if (octet == -1) {
                //throw new ASN1Exception("Unexpected end of encoding");
            //}
            //buffer[offset++] = (byte) octet;
            //return octet;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.937 -0400", hash_original_method = "73ADE766083E21B57FB910CFDB1C7433", hash_generated_method = "C2296F450A1F0DBF18CB6D91079CB9D5")
    public void readContent() throws IOException {
    if(offset + length > buffer.length)        
        {
            ASN1Exception var26B82ADCA4A481B99A8295458E5FD024_267926457 = new ASN1Exception("Unexpected end of encoding");
            var26B82ADCA4A481B99A8295458E5FD024_267926457.addTaint(taint);
            throw var26B82ADCA4A481B99A8295458E5FD024_267926457;
        } //End block
    if(in == null)        
        {
            offset += length;
        } //End block
        else
        {
            int bytesRead = in.read(buffer, offset, length);
    if(bytesRead != length)            
            {
                int c = bytesRead;
                do {
                    {
    if(c < 1 || bytesRead > length)                        
                        {
                            ASN1Exception var2F62A2C4E37AA4576FB221343C553893_494727406 = new ASN1Exception("Failed to read encoded content");
                            var2F62A2C4E37AA4576FB221343C553893_494727406.addTaint(taint);
                            throw var2F62A2C4E37AA4576FB221343C553893_494727406;
                        } //End block
                        c = in.read(buffer, offset + bytesRead, length - bytesRead);
                        bytesRead += c;
                    } //End block
} while (bytesRead != length);
            } //End block
            offset += length;
        } //End block
        // ---------- Original Method ----------
        //if (offset + length > buffer.length) {
            //throw new ASN1Exception("Unexpected end of encoding");
        //}
        //if (in == null) {
            //offset += length;
        //} else {
            //int bytesRead = in.read(buffer, offset, length);
            //if (bytesRead != length) {
                //int c = bytesRead;
                //do {
                    //if (c < 1 || bytesRead > length) {
                        //throw new ASN1Exception("Failed to read encoded content");
                    //}
                    //c = in.read(buffer, offset + bytesRead, length - bytesRead);
                    //bytesRead += c;
                //} while (bytesRead != length);
            //}
            //offset += length;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.938 -0400", hash_original_method = "DCB4E4732715D068A4BB6AF51135E41B", hash_generated_method = "709E101088D93A2846ABEE2FDCFC7BFD")
    public void compactBuffer() {
    if(offset != buffer.length)        
        {
            byte[] newBuffer = new byte[offset];
            System.arraycopy(buffer, 0, newBuffer, 0, offset);
            buffer = newBuffer;
        } //End block
        // ---------- Original Method ----------
        //if (offset != buffer.length) {
            //byte[] newBuffer = new byte[offset];
            //System.arraycopy(buffer, 0, newBuffer, 0, offset);
            //buffer = newBuffer;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.939 -0400", hash_original_method = "AFFB1C62116A7F4F1AC3586F8D79C157", hash_generated_method = "2769815BC7DD3B7E2CFA10CEBAE35832")
    public void put(Object key, Object entry) {
    if(pool == null)        
        {
            pool = new Object[2][10];
        } //End block
        int i = 0;
for(;i < pool[0].length && pool[0][i] != null;i++)
        {
    if(pool[0][i] == key)            
            {
                pool[1][i] = entry;
                return;
            } //End block
        } //End block
    if(i == pool[0].length)        
        {
            Object[][] newPool = new Object[pool[0].length * 2][2];
            System.arraycopy(pool[0], 0, newPool[0], 0, pool[0].length);
            System.arraycopy(pool[1], 0, newPool[1], 0, pool[0].length);
            pool = newPool;
        } //End block
        else
        {
            pool[0][i] = key;
            pool[1][i] = entry;
        } //End block
        // ---------- Original Method ----------
        //if (pool == null) {
            //pool = new Object[2][10];
        //}
        //int i = 0;
        //for (; i < pool[0].length && pool[0][i] != null; i++) {
            //if (pool[0][i] == key) {
                //pool[1][i] = entry;
                //return;
            //}
        //}
        //if (i == pool[0].length) {
            //Object[][] newPool = new Object[pool[0].length * 2][2];
            //System.arraycopy(pool[0], 0, newPool[0], 0, pool[0].length);
            //System.arraycopy(pool[1], 0, newPool[1], 0, pool[0].length);
            //pool = newPool;
        //} else {
            //pool[0][i] = key;
            //pool[1][i] = entry;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.939 -0400", hash_original_method = "5B069BEEA06FE3B546FE9A5858249664", hash_generated_method = "D9CF83BABE567FFCE009A8242FBFABB6")
    public Object get(Object key) {
        addTaint(key.getTaint());
    if(pool == null)        
        {
Object var540C13E9E156B687226421B24F2DF178_579018636 =             null;
            var540C13E9E156B687226421B24F2DF178_579018636.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_579018636;
        } //End block
for(int i = 0;i < pool[0].length;i++)
        {
    if(pool[0][i] == key)            
            {
Object var17C0E2951280DB92AB4C4872C23A923E_1922343965 =                 pool[1][i];
                var17C0E2951280DB92AB4C4872C23A923E_1922343965.addTaint(taint);
                return var17C0E2951280DB92AB4C4872C23A923E_1922343965;
            } //End block
        } //End block
Object var540C13E9E156B687226421B24F2DF178_2125205525 =         null;
        var540C13E9E156B687226421B24F2DF178_2125205525.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2125205525;
        // ---------- Original Method ----------
        //if (pool == null) {
            //return null;
        //}
        //for (int i = 0; i < pool[0].length; i++) {
            //if (pool[0][i] == key) {
                //return pool[1][i];
            //}
        //}
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.940 -0400", hash_original_field = "F1EFF4BE8D15EBEF9A90A83AF1B73C89", hash_generated_field = "15AEBAF204B1E1628DA9A9D8B78EB825")

    private static final int BUF_INCREASE_SIZE = 1024 * 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.940 -0400", hash_original_field = "9BAABEE9C3348ECF21AE95935BDB009B", hash_generated_field = "12A8A7878E72ADED3FB919DC5D266C92")

    protected static final int INDEFINIT_LENGTH = -1;
}

