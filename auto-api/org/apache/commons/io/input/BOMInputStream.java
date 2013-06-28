package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.ByteOrderMark;

public class BOMInputStream extends ProxyInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.042 -0400", hash_original_field = "D436EB0FD9DE10B54A828CE6435F7E81", hash_generated_field = "4732FB9EC479592E31D18C2E147CCEF5")

    private boolean include;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.042 -0400", hash_original_field = "A85152755FFAE5360E50247CC5BF7DAC", hash_generated_field = "128232CF18F0059B4006C941DC9C3CB4")

    private List<ByteOrderMark> boms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.042 -0400", hash_original_field = "6538F2920F0BF19507F6651D731360E8", hash_generated_field = "CA401115BEBAB5CC1A6F32D4C988E25E")

    private ByteOrderMark byteOrderMark;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.042 -0400", hash_original_field = "7886B5087C3D0CFEA254D8521892F371", hash_generated_field = "B668286A56203F4EBCDE7FCB958045E0")

    private int[] firstBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.043 -0400", hash_original_field = "9AD340F7D48BB097C3E27529AC4A562A", hash_generated_field = "EF5803530CF2C32C70962EA47FFF686F")

    private int fbLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.043 -0400", hash_original_field = "D01EFE9E5C823D149E739489B2072AAA", hash_generated_field = "BB2CC2EBE7EE3208501861C1CDCACC96")

    private int fbIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.043 -0400", hash_original_field = "5218D280AB3F12D2D4605AF19C34144C", hash_generated_field = "F7971AC97BF92BCF248BAF9A7C60C771")

    private int markFbIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.043 -0400", hash_original_field = "152589062DD54E9129D13387A2C3B1C0", hash_generated_field = "EFD3ECCEB5CCD8383331794060B0D974")

    private boolean markedAtStart;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.043 -0400", hash_original_method = "8F5EED53C398BBC974E14B6354247605", hash_generated_method = "457833DE06CFCE5720C8F273BCEC0AE8")
    public  BOMInputStream(InputStream delegate) {
        this(delegate, false, ByteOrderMark.UTF_8);
        addTaint(delegate.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.043 -0400", hash_original_method = "09BCCCE0FE56EF006EB9ED7A73FB1600", hash_generated_method = "0533264F4584B4457B42A8AE7C68C203")
    public  BOMInputStream(InputStream delegate, boolean include) {
        this(delegate, include, ByteOrderMark.UTF_8);
        addTaint(delegate.getTaint());
        addTaint(include);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.043 -0400", hash_original_method = "3EE76FAAD44E7D402237FB87195A0164", hash_generated_method = "C005EE466BA420FF6D0C95737DE63C76")
    public  BOMInputStream(InputStream delegate, ByteOrderMark... boms) {
        this(delegate, false, boms);
        addTaint(delegate.getTaint());
        addTaint(boms[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.044 -0400", hash_original_method = "0CFB1A71152A30E9C19BA043AD8B50FF", hash_generated_method = "A37E99371FDD912ACBF1832729D63FA4")
    public  BOMInputStream(InputStream delegate, boolean include, ByteOrderMark... boms) {
        super(delegate);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No BOMs specified");
        } //End block
        this.include = include;
        Arrays.sort(boms, ByteOrderMarkLengthComparator);
        this.boms = Arrays.asList(boms);
        addTaint(delegate.getTaint());
        // ---------- Original Method ----------
        //if (boms == null || boms.length == 0) {
            //throw new IllegalArgumentException("No BOMs specified");
        //}
        //this.include = include;
        //Arrays.sort(boms, ByteOrderMarkLengthComparator);
        //this.boms = Arrays.asList(boms);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.044 -0400", hash_original_method = "B6BA1F8A511F86D4BD07A400290A4051", hash_generated_method = "515455ADD85A0A9FCD71C7938D2A7355")
    public boolean hasBOM() throws IOException {
        boolean var19746509102538112D88245CD6ABC551_1035983302 = (getBOM() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601571400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_601571400;
        // ---------- Original Method ----------
        //return getBOM() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.044 -0400", hash_original_method = "76FEA3BC51FC08A39946D800AEA6E194", hash_generated_method = "4C7739E60C9FC01F59AEE5E44423D5E9")
    public boolean hasBOM(ByteOrderMark bom) throws IOException {
        {
            boolean varCBD112A2D960B9D89A1E00235F835672_1628412203 = (!boms.contains(bom));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Stream not configure to detect " + bom);
            } //End block
        } //End collapsed parenthetic
        boolean var711E57C9273D6BADF35FB409A433B60E_1357445765 = (byteOrderMark != null && getBOM().equals(bom));
        addTaint(bom.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572733738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572733738;
        // ---------- Original Method ----------
        //if (!boms.contains(bom)) {
            //throw new IllegalArgumentException("Stream not configure to detect " + bom);
        //}
        //return byteOrderMark != null && getBOM().equals(bom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.045 -0400", hash_original_method = "18EFB02AF45D2A482B99C0D271762E17", hash_generated_method = "9040871291505F956559EEB86E11C92C")
    public ByteOrderMark getBOM() throws IOException {
        ByteOrderMark varB4EAC82CA7396A68D541C85D26508E83_1382311422 = null; //Variable for return #1
        {
            fbLength = 0;
            final int maxBomSize = boms.get(0).length();
            firstBytes = new int[maxBomSize];
            {
                int i = 0;
                {
                    firstBytes[i] = in.read();
                } //End block
            } //End collapsed parenthetic
            byteOrderMark = find();
            {
                {
                    {
                        boolean var9BE78313ED7280FEA12460BDD5E042C0_1335765283 = (byteOrderMark.length() < firstBytes.length);
                        {
                            fbIndex = byteOrderMark.length();
                        } //End block
                        {
                            fbLength = 0;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1382311422 = byteOrderMark;
        varB4EAC82CA7396A68D541C85D26508E83_1382311422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1382311422;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.046 -0400", hash_original_method = "147F0F142DF712D035A23C7A58DC3617", hash_generated_method = "17EE8E417F1A6EF410C2376DE20FBFB6")
    public String getBOMCharsetName() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_773129841 = null; //Variable for return #1
        getBOM();
        varB4EAC82CA7396A68D541C85D26508E83_773129841 = byteOrderMark == null ? null : byteOrderMark.getCharsetName();
        varB4EAC82CA7396A68D541C85D26508E83_773129841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_773129841;
        // ---------- Original Method ----------
        //getBOM();
        //return byteOrderMark == null ? null : byteOrderMark.getCharsetName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.047 -0400", hash_original_method = "08EB96B3976F162AB99C66BBE24B1EE1", hash_generated_method = "CDAD734E0DAC26CF800AEF89D6F50BDD")
    private int readFirstBytes() throws IOException {
        getBOM();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656582981 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656582981;
        // ---------- Original Method ----------
        //getBOM();
        //return fbIndex < fbLength ? firstBytes[fbIndex++] : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.049 -0400", hash_original_method = "4400B3E15A2A28E8125FDEC9DF38B771", hash_generated_method = "1BA6093E9CAD5CAD47B5E812DD33EC66")
    private ByteOrderMark find() {
        ByteOrderMark varB4EAC82CA7396A68D541C85D26508E83_593539190 = null; //Variable for return #1
        ByteOrderMark varB4EAC82CA7396A68D541C85D26508E83_851056240 = null; //Variable for return #2
        {
            Iterator<ByteOrderMark> var7EDA7250A00BEEC504691643B6782D1F_755947396 = (boms).iterator();
            var7EDA7250A00BEEC504691643B6782D1F_755947396.hasNext();
            ByteOrderMark bom = var7EDA7250A00BEEC504691643B6782D1F_755947396.next();
            {
                {
                    boolean var8C68E51117B32CED81E53B0FD740D601_130218914 = (matches(bom));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_593539190 = bom;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_851056240 = null;
        ByteOrderMark varA7E53CE21691AB073D9660D615818899_2007269240; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2007269240 = varB4EAC82CA7396A68D541C85D26508E83_593539190;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2007269240 = varB4EAC82CA7396A68D541C85D26508E83_851056240;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2007269240.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2007269240;
        // ---------- Original Method ----------
        //for (ByteOrderMark bom : boms) {
            //if (matches(bom)) {
                //return bom;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.049 -0400", hash_original_method = "64D36B57D71FC274E4DB32E2B8B74584", hash_generated_method = "99398774392274FAAD448809BBEB5AC4")
    private boolean matches(ByteOrderMark bom) {
        {
            int i = 0;
            boolean var22D28CD4C2816F49129017AF09064E0A_1108318685 = (i < bom.length());
            {
                {
                    boolean var13FF4B8C868170FEB2E0B6449C26A1CD_102691351 = (bom.get(i) != firstBytes[i]);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(bom.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534335108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_534335108;
        // ---------- Original Method ----------
        //for (int i = 0; i < bom.length(); i++) {
            //if (bom.get(i) != firstBytes[i]) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.050 -0400", hash_original_method = "F5B14E56E9F55893C6E73E7F84E5B216", hash_generated_method = "B1762D49AC658BFE799C69A0B1313A1F")
    @Override
    public int read() throws IOException {
        int b = readFirstBytes();
        {
            Object varDAF10C977F6298D4B794A37C0307BFC8_1612987736 = (in.read());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991210061 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991210061;
        // ---------- Original Method ----------
        //int b = readFirstBytes();
        //return b >= 0 ? b : in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.050 -0400", hash_original_method = "98E223E86C4C3137EA234A101C3EBA8B", hash_generated_method = "16CF1A58737AC99772098D2FE0B80440")
    @Override
    public int read(byte[] buf, int off, int len) throws IOException {
        int firstCount = 0;
        int b = 0;
        {
            b = readFirstBytes();
            {
                buf[off++] = (byte) (b & 0xFF);
            } //End block
        } //End block
        int secondCount = in.read(buf, off, len);
        addTaint(buf[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944592655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944592655;
        // ---------- Original Method ----------
        //int firstCount = 0;
        //int b = 0;
        //while (len > 0 && b >= 0) {
            //b = readFirstBytes();
            //if (b >= 0) {
                //buf[off++] = (byte) (b & 0xFF);
                //len--;
                //firstCount++;
            //}
        //}
        //int secondCount = in.read(buf, off, len);
        //return secondCount < 0 ? firstCount > 0 ? firstCount : -1 : firstCount + secondCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.051 -0400", hash_original_method = "2F668D010292F41F8534D9B42F402EB1", hash_generated_method = "1A00CBB9CE87B2692FF764C77D014CBB")
    @Override
    public int read(byte[] buf) throws IOException {
        int varCC1AB894CEDAC6AF53B5291411180A42_1849834152 = (read(buf, 0, buf.length));
        addTaint(buf[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486196330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486196330;
        // ---------- Original Method ----------
        //return read(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.051 -0400", hash_original_method = "6F22E04E6B2233AB267E29E6FFA8C482", hash_generated_method = "89DB6C25A46550D23BFD70D510276DC6")
    @Override
    public synchronized void mark(int readlimit) {
        markFbIndex = fbIndex;
        markedAtStart = firstBytes == null;
        in.mark(readlimit);
        addTaint(readlimit);
        // ---------- Original Method ----------
        //markFbIndex = fbIndex;
        //markedAtStart = firstBytes == null;
        //in.mark(readlimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.052 -0400", hash_original_method = "707E3CF4FCF7B50ABDC5BD8089A4C948", hash_generated_method = "2C05317C6B3698AAD4CE6D8B9DAD6F89")
    @Override
    public synchronized void reset() throws IOException {
        fbIndex = markFbIndex;
        {
            firstBytes = null;
        } //End block
        in.reset();
        // ---------- Original Method ----------
        //fbIndex = markFbIndex;
        //if (markedAtStart) {
            //firstBytes = null;
        //}
        //in.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.053 -0400", hash_original_method = "56B6CF5404852C2E1FA523B4DDC1E2FF", hash_generated_method = "2D9BFA6909661EAA54E68E570FE514AA")
    @Override
    public long skip(long n) throws IOException {
        {
            boolean var4FAC8CDEA6B4D071E8D862BA72D57110_1438391417 = (n > 0 && readFirstBytes() >= 0);
        } //End collapsed parenthetic
        long varF9BE9D216586B234023E3BB1A686480E_148940672 = (in.skip(n));
        addTaint(n);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1844120099 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1844120099;
        // ---------- Original Method ----------
        //while (n > 0 && readFirstBytes() >= 0) {
            //n--;
        //}
        //return in.skip(n);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.053 -0400", hash_original_field = "A08F23916B807CBDF49886F53DFB6504", hash_generated_field = "F3C382100FCF926C632CA477AC0F5EB1")

    private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new Comparator<ByteOrderMark>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.053 -0400", hash_original_method = "23015441CD663EC5B064081F8A920C05", hash_generated_method = "69689856795D2DD58097E5CD0CF20CAE")
        public int compare(ByteOrderMark bom1, ByteOrderMark bom2) {
            int len1 = bom1.length();
            int len2 = bom2.length();
            addTaint(bom1.getTaint());
            addTaint(bom2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881345496 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881345496;
            // ---------- Original Method ----------
            //int len1 = bom1.length();
            //int len2 = bom2.length();
            //if (len1 > len2) {
                //return -1;
            //}
            //if (len2 > len1) {
                //return 1;
            //}
            //return 0;
        }

        
};
}

