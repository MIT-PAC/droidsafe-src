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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.906 -0400", hash_original_field = "D436EB0FD9DE10B54A828CE6435F7E81", hash_generated_field = "4732FB9EC479592E31D18C2E147CCEF5")

    private boolean include;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.906 -0400", hash_original_field = "A85152755FFAE5360E50247CC5BF7DAC", hash_generated_field = "128232CF18F0059B4006C941DC9C3CB4")

    private List<ByteOrderMark> boms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.906 -0400", hash_original_field = "6538F2920F0BF19507F6651D731360E8", hash_generated_field = "CA401115BEBAB5CC1A6F32D4C988E25E")

    private ByteOrderMark byteOrderMark;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.906 -0400", hash_original_field = "7886B5087C3D0CFEA254D8521892F371", hash_generated_field = "B668286A56203F4EBCDE7FCB958045E0")

    private int[] firstBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.906 -0400", hash_original_field = "9AD340F7D48BB097C3E27529AC4A562A", hash_generated_field = "EF5803530CF2C32C70962EA47FFF686F")

    private int fbLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.906 -0400", hash_original_field = "D01EFE9E5C823D149E739489B2072AAA", hash_generated_field = "BB2CC2EBE7EE3208501861C1CDCACC96")

    private int fbIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.906 -0400", hash_original_field = "5218D280AB3F12D2D4605AF19C34144C", hash_generated_field = "F7971AC97BF92BCF248BAF9A7C60C771")

    private int markFbIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.906 -0400", hash_original_field = "152589062DD54E9129D13387A2C3B1C0", hash_generated_field = "EFD3ECCEB5CCD8383331794060B0D974")

    private boolean markedAtStart;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.906 -0400", hash_original_method = "8F5EED53C398BBC974E14B6354247605", hash_generated_method = "457833DE06CFCE5720C8F273BCEC0AE8")
    public  BOMInputStream(InputStream delegate) {
        this(delegate, false, ByteOrderMark.UTF_8);
        addTaint(delegate.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.942 -0400", hash_original_method = "09BCCCE0FE56EF006EB9ED7A73FB1600", hash_generated_method = "0533264F4584B4457B42A8AE7C68C203")
    public  BOMInputStream(InputStream delegate, boolean include) {
        this(delegate, include, ByteOrderMark.UTF_8);
        addTaint(delegate.getTaint());
        addTaint(include);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.942 -0400", hash_original_method = "3EE76FAAD44E7D402237FB87195A0164", hash_generated_method = "C005EE466BA420FF6D0C95737DE63C76")
    public  BOMInputStream(InputStream delegate, ByteOrderMark... boms) {
        this(delegate, false, boms);
        addTaint(delegate.getTaint());
        addTaint(boms[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.943 -0400", hash_original_method = "0CFB1A71152A30E9C19BA043AD8B50FF", hash_generated_method = "A37E99371FDD912ACBF1832729D63FA4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.943 -0400", hash_original_method = "B6BA1F8A511F86D4BD07A400290A4051", hash_generated_method = "D400FD8CC6951456142109E7134CD125")
    public boolean hasBOM() throws IOException {
        boolean var19746509102538112D88245CD6ABC551_717080936 = (getBOM() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_957808536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_957808536;
        // ---------- Original Method ----------
        //return getBOM() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.943 -0400", hash_original_method = "76FEA3BC51FC08A39946D800AEA6E194", hash_generated_method = "9C7DC60616AA616496A26BACDCA6AB9D")
    public boolean hasBOM(ByteOrderMark bom) throws IOException {
        {
            boolean varCBD112A2D960B9D89A1E00235F835672_1976859489 = (!boms.contains(bom));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Stream not configure to detect " + bom);
            } //End block
        } //End collapsed parenthetic
        boolean var711E57C9273D6BADF35FB409A433B60E_958854989 = (byteOrderMark != null && getBOM().equals(bom));
        addTaint(bom.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789690767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789690767;
        // ---------- Original Method ----------
        //if (!boms.contains(bom)) {
            //throw new IllegalArgumentException("Stream not configure to detect " + bom);
        //}
        //return byteOrderMark != null && getBOM().equals(bom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.948 -0400", hash_original_method = "18EFB02AF45D2A482B99C0D271762E17", hash_generated_method = "D16B5622456FF434FBB3330C87D09364")
    public ByteOrderMark getBOM() throws IOException {
        ByteOrderMark varB4EAC82CA7396A68D541C85D26508E83_1917616288 = null; //Variable for return #1
        {
            fbLength = 0;
            int maxBomSize;
            maxBomSize = boms.get(0).length();
            firstBytes = new int[maxBomSize];
            {
                int i;
                i = 0;
                {
                    firstBytes[i] = in.read();
                } //End block
            } //End collapsed parenthetic
            byteOrderMark = find();
            {
                {
                    {
                        boolean var9BE78313ED7280FEA12460BDD5E042C0_298687201 = (byteOrderMark.length() < firstBytes.length);
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
        varB4EAC82CA7396A68D541C85D26508E83_1917616288 = byteOrderMark;
        varB4EAC82CA7396A68D541C85D26508E83_1917616288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1917616288;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.949 -0400", hash_original_method = "147F0F142DF712D035A23C7A58DC3617", hash_generated_method = "D561AF1D543A450D3E2D6503DC50489F")
    public String getBOMCharsetName() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_76119637 = null; //Variable for return #1
        getBOM();
        varB4EAC82CA7396A68D541C85D26508E83_76119637 = byteOrderMark == null ? null : byteOrderMark.getCharsetName();
        varB4EAC82CA7396A68D541C85D26508E83_76119637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_76119637;
        // ---------- Original Method ----------
        //getBOM();
        //return byteOrderMark == null ? null : byteOrderMark.getCharsetName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.949 -0400", hash_original_method = "08EB96B3976F162AB99C66BBE24B1EE1", hash_generated_method = "6A453FAAF16DCE0416DAF6F8AB3E0FFA")
    private int readFirstBytes() throws IOException {
        getBOM();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84522537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84522537;
        // ---------- Original Method ----------
        //getBOM();
        //return fbIndex < fbLength ? firstBytes[fbIndex++] : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.966 -0400", hash_original_method = "4400B3E15A2A28E8125FDEC9DF38B771", hash_generated_method = "3662DB9B20466D481AB11B1BB1D2166D")
    private ByteOrderMark find() {
        ByteOrderMark varB4EAC82CA7396A68D541C85D26508E83_2018551897 = null; //Variable for return #1
        ByteOrderMark varB4EAC82CA7396A68D541C85D26508E83_1988240602 = null; //Variable for return #2
        {
            Iterator<ByteOrderMark> var7EDA7250A00BEEC504691643B6782D1F_1268614442 = (boms).iterator();
            var7EDA7250A00BEEC504691643B6782D1F_1268614442.hasNext();
            ByteOrderMark bom = var7EDA7250A00BEEC504691643B6782D1F_1268614442.next();
            {
                {
                    boolean var8C68E51117B32CED81E53B0FD740D601_1942495117 = (matches(bom));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2018551897 = bom;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1988240602 = null;
        ByteOrderMark varA7E53CE21691AB073D9660D615818899_2125221498; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2125221498 = varB4EAC82CA7396A68D541C85D26508E83_2018551897;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2125221498 = varB4EAC82CA7396A68D541C85D26508E83_1988240602;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2125221498.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2125221498;
        // ---------- Original Method ----------
        //for (ByteOrderMark bom : boms) {
            //if (matches(bom)) {
                //return bom;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.968 -0400", hash_original_method = "64D36B57D71FC274E4DB32E2B8B74584", hash_generated_method = "AC686C0E63E92D04EE32D368336452F7")
    private boolean matches(ByteOrderMark bom) {
        {
            int i;
            i = 0;
            boolean var22D28CD4C2816F49129017AF09064E0A_1087079290 = (i < bom.length());
            {
                {
                    boolean var13FF4B8C868170FEB2E0B6449C26A1CD_1539782331 = (bom.get(i) != firstBytes[i]);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(bom.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666924350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666924350;
        // ---------- Original Method ----------
        //for (int i = 0; i < bom.length(); i++) {
            //if (bom.get(i) != firstBytes[i]) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.970 -0400", hash_original_method = "F5B14E56E9F55893C6E73E7F84E5B216", hash_generated_method = "3593F202E4494600E7F4C648F71EA1BB")
    @Override
    public int read() throws IOException {
        int b;
        b = readFirstBytes();
        {
            Object varDAF10C977F6298D4B794A37C0307BFC8_993068544 = (in.read());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882135591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882135591;
        // ---------- Original Method ----------
        //int b = readFirstBytes();
        //return b >= 0 ? b : in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.981 -0400", hash_original_method = "98E223E86C4C3137EA234A101C3EBA8B", hash_generated_method = "E45A423DBA657BDF6E56E87D5245837D")
    @Override
    public int read(byte[] buf, int off, int len) throws IOException {
        int firstCount;
        firstCount = 0;
        int b;
        b = 0;
        {
            b = readFirstBytes();
            {
                buf[off++] = (byte) (b & 0xFF);
            } //End block
        } //End block
        int secondCount;
        secondCount = in.read(buf, off, len);
        addTaint(buf[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022375002 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022375002;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.981 -0400", hash_original_method = "2F668D010292F41F8534D9B42F402EB1", hash_generated_method = "9630F53DC53AD6E52250EBDA80165D9B")
    @Override
    public int read(byte[] buf) throws IOException {
        int varCC1AB894CEDAC6AF53B5291411180A42_882379246 = (read(buf, 0, buf.length));
        addTaint(buf[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694969851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694969851;
        // ---------- Original Method ----------
        //return read(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.982 -0400", hash_original_method = "6F22E04E6B2233AB267E29E6FFA8C482", hash_generated_method = "89DB6C25A46550D23BFD70D510276DC6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.984 -0400", hash_original_method = "707E3CF4FCF7B50ABDC5BD8089A4C948", hash_generated_method = "2C05317C6B3698AAD4CE6D8B9DAD6F89")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.984 -0400", hash_original_method = "56B6CF5404852C2E1FA523B4DDC1E2FF", hash_generated_method = "38CF1FD9F13EBA4EAE76791647530EE7")
    @Override
    public long skip(long n) throws IOException {
        {
            boolean var4FAC8CDEA6B4D071E8D862BA72D57110_1953691284 = (n > 0 && readFirstBytes() >= 0);
        } //End collapsed parenthetic
        long varF9BE9D216586B234023E3BB1A686480E_908170902 = (in.skip(n));
        addTaint(n);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_20750069 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_20750069;
        // ---------- Original Method ----------
        //while (n > 0 && readFirstBytes() >= 0) {
            //n--;
        //}
        //return in.skip(n);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.988 -0400", hash_original_field = "A08F23916B807CBDF49886F53DFB6504", hash_generated_field = "DE761E5FDBCF8AA13EF0BE9C13B522B6")

    private static Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new Comparator<ByteOrderMark>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.988 -0400", hash_original_method = "23015441CD663EC5B064081F8A920C05", hash_generated_method = "0F8CD5931A709F6CDF8ADBB1066CE33D")
        public int compare(ByteOrderMark bom1, ByteOrderMark bom2) {
            int len1;
            len1 = bom1.length();
            int len2;
            len2 = bom2.length();
            addTaint(bom1.getTaint());
            addTaint(bom2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181662393 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181662393;
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

