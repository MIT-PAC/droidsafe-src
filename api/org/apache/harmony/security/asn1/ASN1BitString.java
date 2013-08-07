package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import libcore.util.EmptyArray;





public class ASN1BitString extends ASN1StringType {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.181 -0400", hash_original_method = "AD601F3532730C1588B10C0B2F4700C0", hash_generated_method = "2D61DE183F5D6ABAA7F4E57F92D94159")
    public  ASN1BitString() {
        super(TAG_BITSTRING);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static ASN1BitString getInstance() {
        return ASN1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.183 -0400", hash_original_method = "BF14955802A2C4E7FA1CD34E2A56A014", hash_generated_method = "276333004FC602B679726F07DE6D4ACC")
    @Override
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readBitString();
        if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_1576143151 =             null;
            var540C13E9E156B687226421B24F2DF178_1576143151.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1576143151;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_155734361 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_155734361.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_155734361;
        // ---------- Original Method ----------
        //in.readBitString();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.183 -0400", hash_original_method = "E5B2C829F55FF77DE885EB0182CA875F", hash_generated_method = "059CBB4254FC02049B8EB9ED99210FFF")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        byte[] bytes = new byte[in.length - 1];
        System.arraycopy(in.buffer, in.contentOffset + 1, bytes, 0,
                in.length - 1);
Object var319298E0BC136FD97EF3662F4EA645DF_1945353672 =         new BitString(bytes, in.buffer[in.contentOffset]);
        var319298E0BC136FD97EF3662F4EA645DF_1945353672.addTaint(taint);
        return var319298E0BC136FD97EF3662F4EA645DF_1945353672;
        // ---------- Original Method ----------
        //byte[] bytes = new byte[in.length - 1];
        //System.arraycopy(in.buffer, in.contentOffset + 1, bytes, 0,
                //in.length - 1);
        //return new BitString(bytes, in.buffer[in.contentOffset]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.184 -0400", hash_original_method = "F26C5493E5849E857C2B791290EA66B7", hash_generated_method = "4E63298DD2601D30B9698DB4C23CF061")
    @Override
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeBitString();
        // ---------- Original Method ----------
        //out.encodeBitString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.185 -0400", hash_original_method = "FF34851DE63579E10DEA6E02E8081017", hash_generated_method = "994CBA66B49762BED89C8A1F0B242D76")
    @Override
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.length = ((BitString) out.content).bytes.length + 1;
        // ---------- Original Method ----------
        //out.length = ((BitString) out.content).bytes.length + 1;
    }

    
    public static class ASN1NamedBitList extends ASN1BitString {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.185 -0400", hash_original_field = "E9B5EF3115749AC18666D4BF999B0F5A", hash_generated_field = "2B48B9A1899DE822AC4EC2D83505C6F1")

        private int minBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.185 -0400", hash_original_field = "2EE20D4233C27F4EBE5662A79A1E53A3", hash_generated_field = "BECE67D662A881E5FD42CD7CE3FA03FC")

        private int maxBits;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.186 -0400", hash_original_method = "C4F695AEADF70B93944D050F01760534", hash_generated_method = "549A43448CDE686297D3DDCA79456ED8")
        public  ASN1NamedBitList(int minBits) {
            this.minBits = minBits;
            this.maxBits = INDEFINITE_SIZE;
            // ---------- Original Method ----------
            //this.minBits = minBits;
            //this.maxBits = INDEFINITE_SIZE;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.188 -0400", hash_original_method = "039CEFCC208866EAEA17CE6A32A74892", hash_generated_method = "AC2E62F29FE4508D44E42E0FCBDF9DBF")
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            addTaint(in.getTaint());
            boolean[] value;
            int unusedBits = in.buffer[in.contentOffset];
            int bitsNumber = (in.length - 1) * 8 - unusedBits;
            if(maxBits == INDEFINITE_SIZE)            
            {
                if(minBits == INDEFINITE_SIZE)                
                {
                    value = new boolean[bitsNumber];
                } //End block
                else
                {
                    if(bitsNumber > minBits)                    
                    {
                        value = new boolean[bitsNumber];
                    } //End block
                    else
                    {
                        value = new boolean[minBits];
                    } //End block
                } //End block
            } //End block
            else
            {
                if(bitsNumber > maxBits)                
                {
                    ASN1Exception varA6917ABFFDD74F8348C9C8DBD0112C64_1630402234 = new ASN1Exception("ASN.1 Named Bitstring: size constraints");
                    varA6917ABFFDD74F8348C9C8DBD0112C64_1630402234.addTaint(taint);
                    throw varA6917ABFFDD74F8348C9C8DBD0112C64_1630402234;
                } //End block
                value = new boolean[maxBits];
            } //End block
            if(bitsNumber == 0)            
            {
Object varAF280DA2BC37D8BE783D8499160168DE_1226509881 =                 value;
                varAF280DA2BC37D8BE783D8499160168DE_1226509881.addTaint(taint);
                return varAF280DA2BC37D8BE783D8499160168DE_1226509881;
            } //End block
            int i = 1;
            int j = 0;
            byte octet = in.buffer[in.contentOffset + i];
for(int size = in.length - 1;i < size;i++)
            {
for(int k = 0;k < 8;k++,j++)
                {
                    value[j] = (SET_MASK[k] & octet) != 0;
                } //End block
                i++;
                octet = in.buffer[in.contentOffset + i];
            } //End block
for(int k = 0;k < (8 - unusedBits);k++,j++)
            {
                value[j] = (SET_MASK[k] & octet) != 0;
            } //End block
Object varAF280DA2BC37D8BE783D8499160168DE_1060091801 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_1060091801.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_1060091801;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.190 -0400", hash_original_method = "41EEFA120EBBC70AD57105C61092B6CF", hash_generated_method = "6A34C427B370540B0C27B459E710A5AA")
        @Override
        public void setEncodingContent(BerOutputStream out) {
            addTaint(out.getTaint());
            boolean[] toEncode = (boolean[]) out.content;
            int index = toEncode.length - 1;
            while
(index > -1 && !toEncode[index])            
            {
                index--;
            } //End block
            if(index == -1)            
            {
                out.content = emptyString;
                out.length = 1;
            } //End block
            else
            {
                int unusedBits = 7 - index % 8;
                byte[] bytes = new byte[index / 8 + 1];
                int j = 0;
                index = bytes.length - 1;
for(int i = 0;i < index;i++)
                {
for(int k = 0;k < 8;k++,j++)
                    {
                        if(toEncode[j])                        
                        {
                            bytes[i] = (byte) (bytes[i] | SET_MASK[k]);
                        } //End block
                    } //End block
                } //End block
for(int k = 0;k < (8 - unusedBits);k++,j++)
                {
                    if(toEncode[j])                    
                    {
                        bytes[index] = (byte) (bytes[index] | SET_MASK[k]);
                    } //End block
                } //End block
                out.content = new BitString(bytes, unusedBits);
                out.length = bytes.length + 1;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.191 -0400", hash_original_field = "82B8116D8A84475E2750CC92DE9DE1EE", hash_generated_field = "AEC1F0C6EBA822C84ED8236810752976")

        private static final byte[] SET_MASK = { (byte) 128, 64, 32, 16, 8, 4, 2, 1};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.191 -0400", hash_original_field = "C87CDD30AF6746725900E8C27C13F470", hash_generated_field = "618353E6E65D10C1AA220A91BE6C2EFB")

        private static final BitString emptyString = new BitString(EmptyArray.BYTE, 0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.191 -0400", hash_original_field = "ED285F119BD307DA94B8580FF2D7A2B6", hash_generated_field = "9178A989C8AB2E04888B17468392B3D6")

        private static final int INDEFINITE_SIZE = -1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.192 -0400", hash_original_field = "527079CC22747EFD81E648BF044EFFD1", hash_generated_field = "59CFED8D9DCC36D46CA45472623CE9C2")

    private static final ASN1BitString ASN1 = new ASN1BitString();
}

