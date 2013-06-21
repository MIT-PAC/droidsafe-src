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
    private int mRawOffset;
    private int mEarliestRawOffset;
    private int[] mTransitions;
    private int[] mOffsets;
    private byte[] mTypes;
    private byte[] mIsDsts;
    private boolean mUseDst;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.748 -0400", hash_original_method = "7B585FDC58F35CED01D1FBB089EE95E4", hash_generated_method = "5F2318BE4595B5CB2FBC2DF6BF5EB8FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ZoneInfo(String name, int[] transitions, byte[] type, int[] gmtOffsets, byte[] isDsts) {
        dsTaint.addTaint(gmtOffsets[0]);
        dsTaint.addTaint(transitions[0]);
        dsTaint.addTaint(name);
        dsTaint.addTaint(isDsts[0]);
        dsTaint.addTaint(type[0]);
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
        int firstStd;
        firstStd = -1;
        {
            int i;
            i = 0;
            {
                {
                    firstStd = i;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int earliestRawOffset;
        earliestRawOffset = gmtOffsets[mTypes[firstStd] & 0xff];
        earliestRawOffset = mRawOffset;
        {
            int i;
            i = 0;
            {
                mOffsets[i] -= mRawOffset;
            } //End block
        } //End collapsed parenthetic
        boolean usesDst;
        usesDst = false;
        long currentUnixTime;
        currentUnixTime = System.currentTimeMillis() / 1000;
        {
            long latestScheduleTime;
            latestScheduleTime = ((long) mTransitions[mTransitions.length - 1]) & 0xffffffff;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.749 -0400", hash_original_method = "F24BAF6EEBE3E0E7B99D03D590A46295", hash_generated_method = "ABF687A555B3D889F89298E1BE08DE71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int millis) {
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(era);
        dsTaint.addTaint(day);
        dsTaint.addTaint(millis);
        dsTaint.addTaint(dayOfWeek);
        long calc;
        calc = (year / 400) * MILLISECONDS_PER_400_YEARS;
        year %= 400;
        calc += year * (365 * MILLISECONDS_PER_DAY);
        calc += ((year + 3) / 4) * MILLISECONDS_PER_DAY;
        {
            calc -= ((year - 1) / 100) * MILLISECONDS_PER_DAY;
        } //End block
        boolean isLeap;
        isLeap = (year == 0 || (year % 4 == 0 && year % 100 != 0));
        int[] mlen;
        mlen = LEAP;
        mlen = NORMAL;
        calc += mlen[month] * MILLISECONDS_PER_DAY;
        calc += (day - 1) * MILLISECONDS_PER_DAY;
        calc += millis;
        calc -= mRawOffset;
        calc -= UNIX_OFFSET;
        int varAE0670D203351E4EE09EDD4ECADDEAE6_176267982 = (getOffset(calc));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.750 -0400", hash_original_method = "1DD2E67C6E4C7148C355A1BA56BEEEAB", hash_generated_method = "D78996452A1B8C76790C8E90B49F0D66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOffset(long when) {
        dsTaint.addTaint(when);
        int unix;
        unix = (int) (when / 1000);
        int transition;
        transition = Arrays.binarySearch(mTransitions, unix);
        {
            transition = ~transition - 1;
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.750 -0400", hash_original_method = "B2B7B20D9A81D2665491427CA669DC48", hash_generated_method = "06495225510E539C9BF3C3E18BEE6DF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean inDaylightTime(Date time) {
        dsTaint.addTaint(time.dsTaint);
        long when;
        when = time.getTime();
        int unix;
        unix = (int) (when / 1000);
        int transition;
        transition = Arrays.binarySearch(mTransitions, unix);
        {
            transition = ~transition - 1;
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.750 -0400", hash_original_method = "87352764C6114566CFCD3A7F913CA653", hash_generated_method = "3C2420FEF0DC68C1AD727C1F351EAF26")
    @DSModeled(DSC.SAFE)
    @Override
    public int getRawOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRawOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.751 -0400", hash_original_method = "AE2A1B68EBE1FCF14F7860BA64C34CCE", hash_generated_method = "472B7805F18D068B478B6FF60F66BC5A")
    @DSModeled(DSC.SAFE)
    @Override
    public void setRawOffset(int off) {
        dsTaint.addTaint(off);
        // ---------- Original Method ----------
        //mRawOffset = off;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.751 -0400", hash_original_method = "81F7D5AE987C5D23D9D894C0567E3722", hash_generated_method = "81F2875715EE97A6B2778CBDA6BE2B90")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean useDaylightTime() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUseDst;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.751 -0400", hash_original_method = "73AAAC31DDE42029904964FC44B684BD", hash_generated_method = "EB3F53962333BDC99CA7ACAD2102E8B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasSameRules(TimeZone timeZone) {
        dsTaint.addTaint(timeZone.dsTaint);
        ZoneInfo other;
        other = (ZoneInfo) timeZone;
        boolean var2ECDD241578EF91B7836E587448151E5_14769716 = (mRawOffset == other.mRawOffset
                && Arrays.equals(mOffsets, other.mOffsets)
                && Arrays.equals(mIsDsts, other.mIsDsts)
                && Arrays.equals(mTypes, other.mTypes)
                && Arrays.equals(mTransitions, other.mTransitions));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.751 -0400", hash_original_method = "ECC5255AD9E8EF75737AB68867396FFB", hash_generated_method = "87F3D9AE5F365E054390180B070A2459")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        ZoneInfo other;
        other = (ZoneInfo) obj;
        boolean var5D7D92B6E7D37855EB5D85FA96ADA527_268767144 = (getID().equals(other.getID()) && hasSameRules(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(obj instanceof ZoneInfo)) {
            //return false;
        //}
        //ZoneInfo other = (ZoneInfo) obj;
        //return getID().equals(other.getID()) && hasSameRules(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.752 -0400", hash_original_method = "8C2336163065486F5E05E5E7E360E4D3", hash_generated_method = "6CC98EF67EAB5F6DD2D9D2E7D05C1E93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int prime;
        prime = 31;
        int result;
        result = 1;
        result = prime * result + getID().hashCode();
        result = prime * result + Arrays.hashCode(mOffsets);
        result = prime * result + Arrays.hashCode(mIsDsts);
        result = prime * result + mRawOffset;
        result = prime * result + Arrays.hashCode(mTransitions);
        result = prime * result + Arrays.hashCode(mTypes);
        result = prime * result + (mUseDst ? 1231 : 1237);
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.752 -0400", hash_original_method = "0C13B49DB3B5709653F75D972BEB7E8A", hash_generated_method = "1E64DE54E8E3613F39DEAFE6F9363216")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(getClass().getName() + "[" + getID() + ",mRawOffset=" + mRawOffset +
                ",mUseDst=" + mUseDst + "]");
        sb.append("\n");
        Formatter f;
        f = new Formatter(sb);
        {
            int i;
            i = 0;
            {
                int type;
                type = mTypes[i] & 0xff;
                String utcTime;
                utcTime = formatTime(mTransitions[i], TimeZone.getTimeZone("UTC"));
                String localTime;
                localTime = formatTime(mTransitions[i], this);
                int offset;
                offset = mOffsets[type];
                int gmtOffset;
                gmtOffset = mRawOffset/1000 + offset;
                f.format("%4d : time=%11d %s = %s isDst=%d offset=%5d gmtOffset=%d\n",
                    i, mTransitions[i], utcTime, localTime, mIsDsts[type], offset, gmtOffset);
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_2128086992 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    private static final long MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000;
    private static final long MILLISECONDS_PER_400_YEARS =
            MILLISECONDS_PER_DAY * (400 * 365 + 100 - 3);
    private static final long UNIX_OFFSET = 62167219200000L;
    private static final int[] NORMAL = new int[] {
        0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334,
    };
    private static final int[] LEAP = new int[] {
        0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335,
    };
}

