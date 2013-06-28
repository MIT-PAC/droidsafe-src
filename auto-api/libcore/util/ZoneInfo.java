package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

public final class ZoneInfo extends TimeZone {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.080 -0400", hash_original_field = "25533336D3CA3E874C41CD80205EFA67", hash_generated_field = "060566AE9D04406A02A61A31328950F2")

    private int mRawOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.080 -0400", hash_original_field = "B4BFFBC0BD12D4825C0DAFC91CE85747", hash_generated_field = "35AB18A3BDD75B1565BCF1FBB4FD4AC9")

    private int mEarliestRawOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.080 -0400", hash_original_field = "63FA859BF150B7311C562769D64669EC", hash_generated_field = "2949F8E2C658E0F9BB6150829DB0F1FB")

    private int[] mTransitions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.080 -0400", hash_original_field = "B15C1D4EC7E997E0BBC5999C3706A3B1", hash_generated_field = "A77170E4D59B7DEF7933F555FC87B6C7")

    private int[] mOffsets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.080 -0400", hash_original_field = "EA5AD045B4413F706AC3BC8F429DD15B", hash_generated_field = "284A583171EC8AE6481011AB384C8390")

    private byte[] mTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.080 -0400", hash_original_field = "965AB2D74A70F0A4F6ED607153EAA220", hash_generated_field = "65AF6E20C269E9E4FFFD83D02D26CACC")

    private byte[] mIsDsts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.080 -0400", hash_original_field = "A8906AE3405550F41E9C3AAAC7750368", hash_generated_field = "6095C0BF9C908D345DF50444B88487B4")

    private boolean mUseDst;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.081 -0400", hash_original_method = "7B585FDC58F35CED01D1FBB089EE95E4", hash_generated_method = "4F477DA289C2D2897796B4F16F3FEA1C")
      ZoneInfo(String name, int[] transitions, byte[] type, int[] gmtOffsets, byte[] isDsts) {
        mTransitions = transitions;
        mTypes = type;
        mIsDsts = isDsts;
        setID(name);
        int lastStd;
        {
            lastStd = mTransitions.length - 1;
        } //End collapsed parenthetic
        {
            lastStd = 0;
        } //End block
        {
            mRawOffset = gmtOffsets[0];
        } //End block
        {
            mRawOffset = gmtOffsets[mTypes[lastStd] & 0xff];
        } //End block
        int firstStd = -1;
        {
            int i = 0;
            {
                {
                    firstStd = i;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int earliestRawOffset;
        earliestRawOffset = gmtOffsets[mTypes[firstStd] & 0xff];
        earliestRawOffset = mRawOffset;
        mOffsets = gmtOffsets;
        {
            int i = 0;
            {
                mOffsets[i] -= mRawOffset;
            } //End block
        } //End collapsed parenthetic
        boolean usesDst = false;
        long currentUnixTime = System.currentTimeMillis() / 1000;
        {
            long latestScheduleTime = ((long) mTransitions[mTransitions.length - 1]) & 0xffffffff;
            {
                usesDst = true;
            } //End block
        } //End block
        mUseDst = usesDst;
        mRawOffset *= 1000;
        mEarliestRawOffset = earliestRawOffset * 1000;
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.081 -0400", hash_original_method = "F24BAF6EEBE3E0E7B99D03D590A46295", hash_generated_method = "25B09CFFC3B1599AF5C8CC404D9B884A")
    @Override
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int millis) {
        long calc = (year / 400) * MILLISECONDS_PER_400_YEARS;
        year %= 400;
        calc += year * (365 * MILLISECONDS_PER_DAY);
        calc += ((year + 3) / 4) * MILLISECONDS_PER_DAY;
        {
            calc -= ((year - 1) / 100) * MILLISECONDS_PER_DAY;
        } //End block
        boolean isLeap = (year == 0 || (year % 4 == 0 && year % 100 != 0));
        int[] mlen;
        mlen = LEAP;
        mlen = NORMAL;
        calc += mlen[month] * MILLISECONDS_PER_DAY;
        calc += (day - 1) * MILLISECONDS_PER_DAY;
        calc += millis;
        calc -= mRawOffset;
        calc -= UNIX_OFFSET;
        int varAE0670D203351E4EE09EDD4ECADDEAE6_258921835 = (getOffset(calc));
        addTaint(era);
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(dayOfWeek);
        addTaint(millis);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915025518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915025518;
        // ---------- Original Method ----------
        //long calc = (year / 400) * MILLISECONDS_PER_400_YEARS;
        //year %= 400;
        //calc += year * (365 * MILLISECONDS_PER_DAY);
        //calc += ((year + 3) / 4) * MILLISECONDS_PER_DAY;
        //if (year > 0) {
            //calc -= ((year - 1) / 100) * MILLISECONDS_PER_DAY;
        //}
        //boolean isLeap = (year == 0 || (year % 4 == 0 && year % 100 != 0));
        //int[] mlen = isLeap ? LEAP : NORMAL;
        //calc += mlen[month] * MILLISECONDS_PER_DAY;
        //calc += (day - 1) * MILLISECONDS_PER_DAY;
        //calc += millis;
        //calc -= mRawOffset;
        //calc -= UNIX_OFFSET;
        //return getOffset(calc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.082 -0400", hash_original_method = "1DD2E67C6E4C7148C355A1BA56BEEEAB", hash_generated_method = "0EF95901BC340D299EF4A73680AA8EE8")
    @Override
    public int getOffset(long when) {
        int unix = (int) (when / 1000);
        int transition = Arrays.binarySearch(mTransitions, unix);
        {
            transition = ~transition - 1;
        } //End block
        addTaint(when);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1774084689 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1774084689;
        // ---------- Original Method ----------
        //int unix = (int) (when / 1000);
        //int transition = Arrays.binarySearch(mTransitions, unix);
        //if (transition < 0) {
            //transition = ~transition - 1;
            //if (transition < 0) {
                //return mEarliestRawOffset;
            //}
        //}
        //return mRawOffset + mOffsets[mTypes[transition] & 0xff] * 1000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.082 -0400", hash_original_method = "B2B7B20D9A81D2665491427CA669DC48", hash_generated_method = "4CF343D4061346C1E0F0C2A9D5D1FD8C")
    @Override
    public boolean inDaylightTime(Date time) {
        long when = time.getTime();
        int unix = (int) (when / 1000);
        int transition = Arrays.binarySearch(mTransitions, unix);
        {
            transition = ~transition - 1;
        } //End block
        addTaint(time.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527914435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527914435;
        // ---------- Original Method ----------
        //long when = time.getTime();
        //int unix = (int) (when / 1000);
        //int transition = Arrays.binarySearch(mTransitions, unix);
        //if (transition < 0) {
            //transition = ~transition - 1;
            //if (transition < 0) {
                //return false;
            //}
        //}
        //return mIsDsts[mTypes[transition] & 0xff] == 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.083 -0400", hash_original_method = "87352764C6114566CFCD3A7F913CA653", hash_generated_method = "C7B46BCA3500119E38139351E9202A5A")
    @Override
    public int getRawOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706223316 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706223316;
        // ---------- Original Method ----------
        //return mRawOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.083 -0400", hash_original_method = "AE2A1B68EBE1FCF14F7860BA64C34CCE", hash_generated_method = "079E0D8D6A4EFB8E0B2D948CAED07A5E")
    @Override
    public void setRawOffset(int off) {
        mRawOffset = off;
        // ---------- Original Method ----------
        //mRawOffset = off;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.084 -0400", hash_original_method = "81F7D5AE987C5D23D9D894C0567E3722", hash_generated_method = "88263B1578C238E90FBAF96DB96C6E6D")
    @Override
    public boolean useDaylightTime() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1508182913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1508182913;
        // ---------- Original Method ----------
        //return mUseDst;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.085 -0400", hash_original_method = "73AAAC31DDE42029904964FC44B684BD", hash_generated_method = "D5E677E6DFB85B3EB7D5CBD8A5FC2DAC")
    @Override
    public boolean hasSameRules(TimeZone timeZone) {
        ZoneInfo other = (ZoneInfo) timeZone;
        boolean var2ECDD241578EF91B7836E587448151E5_1088713206 = (mRawOffset == other.mRawOffset
                && Arrays.equals(mOffsets, other.mOffsets)
                && Arrays.equals(mIsDsts, other.mIsDsts)
                && Arrays.equals(mTypes, other.mTypes)
                && Arrays.equals(mTransitions, other.mTransitions));
        addTaint(timeZone.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_881886677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_881886677;
        // ---------- Original Method ----------
        //if (!(timeZone instanceof ZoneInfo)) {
            //return false;
        //}
        //ZoneInfo other = (ZoneInfo) timeZone;
        //if (mUseDst != other.mUseDst) {
            //return false;
        //}
        //if (!mUseDst) {
            //return mRawOffset == other.mRawOffset;
        //}
        //return mRawOffset == other.mRawOffset
                //&& Arrays.equals(mOffsets, other.mOffsets)
                //&& Arrays.equals(mIsDsts, other.mIsDsts)
                //&& Arrays.equals(mTypes, other.mTypes)
                //&& Arrays.equals(mTransitions, other.mTransitions);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.085 -0400", hash_original_method = "ECC5255AD9E8EF75737AB68867396FFB", hash_generated_method = "7451D80991AF947D2F5F58B751B5422E")
    @Override
    public boolean equals(Object obj) {
        ZoneInfo other = (ZoneInfo) obj;
        boolean var5D7D92B6E7D37855EB5D85FA96ADA527_688816340 = (getID().equals(other.getID()) && hasSameRules(other));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771044118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771044118;
        // ---------- Original Method ----------
        //if (!(obj instanceof ZoneInfo)) {
            //return false;
        //}
        //ZoneInfo other = (ZoneInfo) obj;
        //return getID().equals(other.getID()) && hasSameRules(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.086 -0400", hash_original_method = "8C2336163065486F5E05E5E7E360E4D3", hash_generated_method = "B32F7B2CB857373498898DE38A27BC32")
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getID().hashCode();
        result = prime * result + Arrays.hashCode(mOffsets);
        result = prime * result + Arrays.hashCode(mIsDsts);
        result = prime * result + mRawOffset;
        result = prime * result + Arrays.hashCode(mTransitions);
        result = prime * result + Arrays.hashCode(mTypes);
        result = prime * result + (mUseDst ? 1231 : 1237);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681906078 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681906078;
        // ---------- Original Method ----------
        //final int prime = 31;
        //int result = 1;
        //result = prime * result + getID().hashCode();
        //result = prime * result + Arrays.hashCode(mOffsets);
        //result = prime * result + Arrays.hashCode(mIsDsts);
        //result = prime * result + mRawOffset;
        //result = prime * result + Arrays.hashCode(mTransitions);
        //result = prime * result + Arrays.hashCode(mTypes);
        //result = prime * result + (mUseDst ? 1231 : 1237);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.086 -0400", hash_original_method = "0C13B49DB3B5709653F75D972BEB7E8A", hash_generated_method = "4A702E1A1D73DD1C8F96C2834F058456")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_106248968 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName() + "[" + getID() + ",mRawOffset=" + mRawOffset +
                ",mUseDst=" + mUseDst + "]");
        sb.append("\n");
        Formatter f = new Formatter(sb);
        {
            int i = 0;
            {
                int type = mTypes[i] & 0xff;
                String utcTime = formatTime(mTransitions[i], TimeZone.getTimeZone("UTC"));
                String localTime = formatTime(mTransitions[i], this);
                int offset = mOffsets[type];
                int gmtOffset = mRawOffset/1000 + offset;
                f.format("%4d : time=%11d %s = %s isDst=%d offset=%5d gmtOffset=%d\n",
                    i, mTransitions[i], utcTime, localTime, mIsDsts[type], offset, gmtOffset);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_106248968 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_106248968.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_106248968;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append(getClass().getName() + "[" + getID() + ",mRawOffset=" + mRawOffset +
                //",mUseDst=" + mUseDst + "]");
        //sb.append("\n");
        //Formatter f = new Formatter(sb);
        //for (int i = 0; i < mTransitions.length; ++i) {
            //int type = mTypes[i] & 0xff;
            //String utcTime = formatTime(mTransitions[i], TimeZone.getTimeZone("UTC"));
            //String localTime = formatTime(mTransitions[i], this);
            //int offset = mOffsets[type];
            //int gmtOffset = mRawOffset/1000 + offset;
            //f.format("%4d : time=%11d %s = %s isDst=%d offset=%5d gmtOffset=%d\n",
                    //i, mTransitions[i], utcTime, localTime, mIsDsts[type], offset, gmtOffset);
        //}
        //return sb.toString();
    }

    
    private static String formatTime(int s, TimeZone tz) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy zzz");
        sdf.setTimeZone(tz);
        long ms = ((long) s) * 1000L;
        return sdf.format(new Date(ms));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.087 -0400", hash_original_field = "4E37F5EF96F5FB5DC2D379BE76154EBD", hash_generated_field = "F90447479CBDC64DF2FB7D5461FD8925")

    private static final long MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.087 -0400", hash_original_field = "EE48681854129595789FA4BFEAF5AE09", hash_generated_field = "E3952B721A9A2B891A46AA950E0D275D")

    private static final long MILLISECONDS_PER_400_YEARS = MILLISECONDS_PER_DAY * (400 * 365 + 100 - 3);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.087 -0400", hash_original_field = "215A8274816B56DD5475C83DCB58931C", hash_generated_field = "D229D7317C365A16CE1D72D8769A5141")

    private static final long UNIX_OFFSET = 62167219200000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.087 -0400", hash_original_field = "2067C9577E3E7D0B0E123862C1BBDBD4", hash_generated_field = "22BEEDA8661AC3FEFCC2DD0FB611C6E4")

    private static final int[] NORMAL = new int[] {
        0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334,
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.087 -0400", hash_original_field = "2F6AE912A2D47DF4C13CFDE63FA63311", hash_generated_field = "B12F84DFBC4C3EA8E5351AA3B43B9A98")

    private static final int[] LEAP = new int[] {
        0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335,
    };
}

