package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

public final class ZoneInfo extends TimeZone {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.176 -0400", hash_original_field = "25533336D3CA3E874C41CD80205EFA67", hash_generated_field = "060566AE9D04406A02A61A31328950F2")

    private int mRawOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.176 -0400", hash_original_field = "B4BFFBC0BD12D4825C0DAFC91CE85747", hash_generated_field = "35AB18A3BDD75B1565BCF1FBB4FD4AC9")

    private int mEarliestRawOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.176 -0400", hash_original_field = "63FA859BF150B7311C562769D64669EC", hash_generated_field = "2949F8E2C658E0F9BB6150829DB0F1FB")

    private int[] mTransitions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.176 -0400", hash_original_field = "B15C1D4EC7E997E0BBC5999C3706A3B1", hash_generated_field = "A77170E4D59B7DEF7933F555FC87B6C7")

    private int[] mOffsets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.177 -0400", hash_original_field = "EA5AD045B4413F706AC3BC8F429DD15B", hash_generated_field = "284A583171EC8AE6481011AB384C8390")

    private byte[] mTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.177 -0400", hash_original_field = "965AB2D74A70F0A4F6ED607153EAA220", hash_generated_field = "65AF6E20C269E9E4FFFD83D02D26CACC")

    private byte[] mIsDsts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.177 -0400", hash_original_field = "A8906AE3405550F41E9C3AAAC7750368", hash_generated_field = "6095C0BF9C908D345DF50444B88487B4")

    private boolean mUseDst;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.179 -0400", hash_original_method = "7B585FDC58F35CED01D1FBB089EE95E4", hash_generated_method = "727133FC28FC441C8D650224D389BFC8")
      ZoneInfo(String name, int[] transitions, byte[] type, int[] gmtOffsets, byte[] isDsts) {
        addTaint(name.getTaint());
        mTransitions = transitions;
        mTypes = type;
        mIsDsts = isDsts;
        setID(name);
        int lastStd;
for(lastStd = mTransitions.length - 1;lastStd >= 0;lastStd--)
        {
    if(mIsDsts[mTypes[lastStd] & 0xff] == 0)            
            {
                break;
            } //End block
        } //End block
    if(lastStd < 0)        
        {
            lastStd = 0;
        } //End block
    if(lastStd >= mTypes.length)        
        {
            mRawOffset = gmtOffsets[0];
        } //End block
        else
        {
            mRawOffset = gmtOffsets[mTypes[lastStd] & 0xff];
        } //End block
        int firstStd = -1;
for(int i = 0;i < mTransitions.length;++i)
        {
    if(mIsDsts[mTypes[i] & 0xff] == 0)            
            {
                firstStd = i;
                break;
            } //End block
        } //End block
        int earliestRawOffset = (firstStd != -1) ? gmtOffsets[mTypes[firstStd] & 0xff] : mRawOffset;
        mOffsets = gmtOffsets;
for(int i = 0;i < mOffsets.length;i++)
        {
            mOffsets[i] -= mRawOffset;
        } //End block
        boolean usesDst = false;
        long currentUnixTime = System.currentTimeMillis() / 1000;
    if(mTransitions.length > 0)        
        {
            long latestScheduleTime = ((long) mTransitions[mTransitions.length - 1]) & 0xffffffff;
    if(currentUnixTime < latestScheduleTime)            
            {
                usesDst = true;
            } //End block
        } //End block
        mUseDst = usesDst;
        mRawOffset *= 1000;
        mEarliestRawOffset = earliestRawOffset * 1000;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.181 -0400", hash_original_method = "F24BAF6EEBE3E0E7B99D03D590A46295", hash_generated_method = "7330207AE2E30F2D9CE1257423857FBF")
    @Override
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int millis) {
        addTaint(millis);
        addTaint(dayOfWeek);
        addTaint(day);
        addTaint(month);
        addTaint(year);
        addTaint(era);
        long calc = (year / 400) * MILLISECONDS_PER_400_YEARS;
        year %= 400;
        calc += year * (365 * MILLISECONDS_PER_DAY);
        calc += ((year + 3) / 4) * MILLISECONDS_PER_DAY;
    if(year > 0)        
        {
            calc -= ((year - 1) / 100) * MILLISECONDS_PER_DAY;
        } //End block
        boolean isLeap = (year == 0 || (year % 4 == 0 && year % 100 != 0));
        int[] mlen = isLeap ? LEAP : NORMAL;
        calc += mlen[month] * MILLISECONDS_PER_DAY;
        calc += (day - 1) * MILLISECONDS_PER_DAY;
        calc += millis;
        calc -= mRawOffset;
        calc -= UNIX_OFFSET;
        int var77AC55A80D74BA2DABC8752D59C53FC8_1022466825 = (getOffset(calc));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887137551 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887137551;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.181 -0400", hash_original_method = "1DD2E67C6E4C7148C355A1BA56BEEEAB", hash_generated_method = "6EBB7AA29B698A90AEF3581AD34EF899")
    @Override
    public int getOffset(long when) {
        addTaint(when);
        int unix = (int) (when / 1000);
        int transition = Arrays.binarySearch(mTransitions, unix);
    if(transition < 0)        
        {
            transition = ~transition - 1;
    if(transition < 0)            
            {
                int varB4BFFBC0BD12D4825C0DAFC91CE85747_925808404 = (mEarliestRawOffset);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008324380 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008324380;
            } //End block
        } //End block
        int var1556019C7102B2245374710708528934_177749916 = (mRawOffset + mOffsets[mTypes[transition] & 0xff] * 1000);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701699881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701699881;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.182 -0400", hash_original_method = "B2B7B20D9A81D2665491427CA669DC48", hash_generated_method = "8DF6546E68E7F165925FE6F89C647F15")
    @Override
    public boolean inDaylightTime(Date time) {
        addTaint(time.getTaint());
        long when = time.getTime();
        int unix = (int) (when / 1000);
        int transition = Arrays.binarySearch(mTransitions, unix);
    if(transition < 0)        
        {
            transition = ~transition - 1;
    if(transition < 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1260270888 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_189138835 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_189138835;
            } //End block
        } //End block
        boolean varE59751AC6B823001D24AA365DDAF03E7_1866210782 = (mIsDsts[mTypes[transition] & 0xff] == 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033121493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033121493;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.183 -0400", hash_original_method = "87352764C6114566CFCD3A7F913CA653", hash_generated_method = "793A288307EBBACB6B82F968AF260698")
    @Override
    public int getRawOffset() {
        int var25533336D3CA3E874C41CD80205EFA67_591565042 = (mRawOffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006372262 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006372262;
        // ---------- Original Method ----------
        //return mRawOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.183 -0400", hash_original_method = "AE2A1B68EBE1FCF14F7860BA64C34CCE", hash_generated_method = "079E0D8D6A4EFB8E0B2D948CAED07A5E")
    @Override
    public void setRawOffset(int off) {
        mRawOffset = off;
        // ---------- Original Method ----------
        //mRawOffset = off;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.183 -0400", hash_original_method = "81F7D5AE987C5D23D9D894C0567E3722", hash_generated_method = "66D359DAB89553F9C15DFCEA24D27AA2")
    @Override
    public boolean useDaylightTime() {
        boolean varA8906AE3405550F41E9C3AAAC7750368_2007946873 = (mUseDst);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1602027707 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1602027707;
        // ---------- Original Method ----------
        //return mUseDst;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.184 -0400", hash_original_method = "73AAAC31DDE42029904964FC44B684BD", hash_generated_method = "16A2F4F9B7CFFF60F75D438AC33A32F0")
    @Override
    public boolean hasSameRules(TimeZone timeZone) {
        addTaint(timeZone.getTaint());
    if(!(timeZone instanceof ZoneInfo))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1123512840 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_709706841 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_709706841;
        } //End block
        ZoneInfo other = (ZoneInfo) timeZone;
    if(mUseDst != other.mUseDst)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1213970683 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2062221309 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2062221309;
        } //End block
    if(!mUseDst)        
        {
            boolean varE790F3138881CFC4593B92237141714D_1346215956 = (mRawOffset == other.mRawOffset);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619894783 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619894783;
        } //End block
        boolean var57B18B391688B2FAE9EB0ABD9BECEED9_2064045174 = (mRawOffset == other.mRawOffset
                && Arrays.equals(mOffsets, other.mOffsets)
                && Arrays.equals(mIsDsts, other.mIsDsts)
                && Arrays.equals(mTypes, other.mTypes)
                && Arrays.equals(mTransitions, other.mTransitions));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718144727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_718144727;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.185 -0400", hash_original_method = "ECC5255AD9E8EF75737AB68867396FFB", hash_generated_method = "5FCC2293AE0E583EFA748B7604DB4837")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(!(obj instanceof ZoneInfo))        
        {
            boolean var68934A3E9455FA72420237EB05902327_330052195 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_171846972 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_171846972;
        } //End block
        ZoneInfo other = (ZoneInfo) obj;
        boolean varAC81AD85115E032C172D6CA8BDF2D25B_230692773 = (getID().equals(other.getID()) && hasSameRules(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070681601 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070681601;
        // ---------- Original Method ----------
        //if (!(obj instanceof ZoneInfo)) {
            //return false;
        //}
        //ZoneInfo other = (ZoneInfo) obj;
        //return getID().equals(other.getID()) && hasSameRules(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.186 -0400", hash_original_method = "8C2336163065486F5E05E5E7E360E4D3", hash_generated_method = "5D2A54E06390F9E11373C1C7E110FD61")
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
        int varB4A88417B3D0170D754C647C30B7216A_958588672 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1787469802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1787469802;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.186 -0400", hash_original_method = "0C13B49DB3B5709653F75D972BEB7E8A", hash_generated_method = "AFCE5774A4A34CF334B5140E5D4A8D05")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName() + "[" + getID() + ",mRawOffset=" + mRawOffset +
                ",mUseDst=" + mUseDst + "]");
        sb.append("\n");
        Formatter f = new Formatter(sb);
for(int i = 0;i < mTransitions.length;++i)
        {
            int type = mTypes[i] & 0xff;
            String utcTime = formatTime(mTransitions[i], TimeZone.getTimeZone("UTC"));
            String localTime = formatTime(mTransitions[i], this);
            int offset = mOffsets[type];
            int gmtOffset = mRawOffset/1000 + offset;
            f.format("%4d : time=%11d %s = %s isDst=%d offset=%5d gmtOffset=%d\n",
                    i, mTransitions[i], utcTime, localTime, mIsDsts[type], offset, gmtOffset);
        } //End block
String var2460B846747F8B22185AD8BE722266A5_1748440814 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1748440814.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1748440814;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.187 -0400", hash_original_field = "4E37F5EF96F5FB5DC2D379BE76154EBD", hash_generated_field = "F90447479CBDC64DF2FB7D5461FD8925")

    private static final long MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.187 -0400", hash_original_field = "EE48681854129595789FA4BFEAF5AE09", hash_generated_field = "E3952B721A9A2B891A46AA950E0D275D")

    private static final long MILLISECONDS_PER_400_YEARS = MILLISECONDS_PER_DAY * (400 * 365 + 100 - 3);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.187 -0400", hash_original_field = "215A8274816B56DD5475C83DCB58931C", hash_generated_field = "D229D7317C365A16CE1D72D8769A5141")

    private static final long UNIX_OFFSET = 62167219200000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.187 -0400", hash_original_field = "2067C9577E3E7D0B0E123862C1BBDBD4", hash_generated_field = "22BEEDA8661AC3FEFCC2DD0FB611C6E4")

    private static final int[] NORMAL = new int[] {
        0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334,
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.187 -0400", hash_original_field = "2F6AE912A2D47DF4C13CFDE63FA63311", hash_generated_field = "B12F84DFBC4C3EA8E5351AA3B43B9A98")

    private static final int[] LEAP = new int[] {
        0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335,
    };
}

