package libcore.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

public final class ZoneInfo extends TimeZone {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.474 -0500", hash_original_method = "8870473B0F5D9FAFDE3FAA6E00691882", hash_generated_method = "724284E4D54CC069B48EAD49A7CB88A9")
    
private static String formatTime(int s, TimeZone tz) {
/*        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy zzz");
        sdf.setTimeZone(tz);
        long ms = ((long) s) * 1000L;
        return sdf.format(new Date(ms));*/
        
        String str = new String();
        str.addTaint(s + tz.getTaintInt());
        return str;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.414 -0500", hash_original_field = "894BF769F550782D8734EEEE182490C9", hash_generated_field = "F90447479CBDC64DF2FB7D5461FD8925")

    private static final long MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.416 -0500", hash_original_field = "D275345B5DBA4357F97B58F8A190C5E3", hash_generated_field = "E3952B721A9A2B891A46AA950E0D275D")

    private static final long MILLISECONDS_PER_400_YEARS =
            MILLISECONDS_PER_DAY * (400 * 365 + 100 - 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.419 -0500", hash_original_field = "250C18EEBBFE5F3201D3213271C04184", hash_generated_field = "D229D7317C365A16CE1D72D8769A5141")

    private static final long UNIX_OFFSET = 62167219200000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.422 -0500", hash_original_field = "A76D40A738D4783D216A16ABEEDD633E", hash_generated_field = "22BEEDA8661AC3FEFCC2DD0FB611C6E4")

    private static final int[] NORMAL = new int[] {
        0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.424 -0500", hash_original_field = "D46C758281F422324C6296A9A3248420", hash_generated_field = "B12F84DFBC4C3EA8E5351AA3B43B9A98")

    private static final int[] LEAP = new int[] {
        0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.427 -0500", hash_original_field = "7603B6DD0497D2F7D1E30E40E4EDEBE2", hash_generated_field = "060566AE9D04406A02A61A31328950F2")

    private int mRawOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.429 -0500", hash_original_field = "CD047A63A42662BED002563DA8336949", hash_generated_field = "35AB18A3BDD75B1565BCF1FBB4FD4AC9")

    private  int mEarliestRawOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.431 -0500", hash_original_field = "2685FF7F8B5474CF1A49F123DC2507C7", hash_generated_field = "2949F8E2C658E0F9BB6150829DB0F1FB")

    private  int[] mTransitions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.433 -0500", hash_original_field = "BF45E09BFDBC088479B878A666455A43", hash_generated_field = "A77170E4D59B7DEF7933F555FC87B6C7")

    private  int[] mOffsets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.436 -0500", hash_original_field = "BD8ACF3D95C057750E53265D1FF8FCF0", hash_generated_field = "284A583171EC8AE6481011AB384C8390")

    private  byte[] mTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.439 -0500", hash_original_field = "0CBF300B456FCCF425225E2C13E889CD", hash_generated_field = "65AF6E20C269E9E4FFFD83D02D26CACC")

    private  byte[] mIsDsts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.441 -0500", hash_original_field = "40657F02E5A2ECC4C0B4290AC8A5E644", hash_generated_field = "6095C0BF9C908D345DF50444B88487B4")

    private  boolean mUseDst;

    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public ZoneInfo(DSOnlyType dontcare){
        
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.445 -0500", hash_original_method = "7B585FDC58F35CED01D1FBB089EE95E4", hash_generated_method = "D677FA1F79FBEA978D270DD51A2C60F2")
    
ZoneInfo(String name, int[] transitions, byte[] type, int[] gmtOffsets, byte[] isDsts) {
        addTaint(name.getTaintInt() +
                transitions[0] + 
                type[0] +
                gmtOffsets[0] +
                isDsts[0]);
       /* mTransitions = transitions;
        mTypes = type;
        mIsDsts = isDsts;
        setID(name);

        // Use the latest non-daylight offset (if any) as the raw offset.
        int lastStd;
        for (lastStd = mTransitions.length - 1; lastStd >= 0; lastStd--) {
            if (mIsDsts[mTypes[lastStd] & 0xff] == 0) {
                break;
            }
        }
        if (lastStd < 0) {
            lastStd = 0;
        }
        if (lastStd >= mTypes.length) {
            mRawOffset = gmtOffsets[0];
        } else {
            mRawOffset = gmtOffsets[mTypes[lastStd] & 0xff];
        }

        // Cache the oldest known raw offset, in case we're asked about times that predate our
        // transition data.
        int firstStd = -1;
        for (int i = 0; i < mTransitions.length; ++i) {
            if (mIsDsts[mTypes[i] & 0xff] == 0) {
                firstStd = i;
                break;
            }
        }
        int earliestRawOffset = (firstStd != -1) ? gmtOffsets[mTypes[firstStd] & 0xff] : mRawOffset;

        // Rather than keep offsets from UTC, we use offsets from local time, so the raw offset
        // can be changed and automatically affect all the offsets.
        mOffsets = gmtOffsets;
        for (int i = 0; i < mOffsets.length; i++) {
            mOffsets[i] -= mRawOffset;
        }

        // Is this zone still observing DST?
        // We don't care if they've historically used it: most places have at least once.
        // We want to know whether the last "schedule info" (the unix times in the mTransitions
        // array) is in the future. If it is, DST is still relevant.
        // See http://code.google.com/p/android/issues/detail?id=877.
        // This test means that for somewhere like Morocco, which tried DST in 2009 but has
        // no future plans (and thus no future schedule info) will report "true" from
        // useDaylightTime at the start of 2009 but "false" at the end. This seems appropriate.
        boolean usesDst = false;
        long currentUnixTime = System.currentTimeMillis() / 1000;
        if (mTransitions.length > 0) {
            // (We're really dealing with uint32_t values, so long is most convenient in Java.)
            long latestScheduleTime = ((long) mTransitions[mTransitions.length - 1]) & 0xffffffff;
            if (currentUnixTime < latestScheduleTime) {
                usesDst = true;
            }
        }
        mUseDst = usesDst;

        mRawOffset *= 1000;
        mEarliestRawOffset = earliestRawOffset * 1000;*/
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.448 -0500", hash_original_method = "F24BAF6EEBE3E0E7B99D03D590A46295", hash_generated_method = "31D5D32B9F1208D7E5F4AB696CE56957")
    
@Override
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int millis) {
        return (getTaintInt() + era + year + month + day + dayOfWeek + millis);
      /*  // XXX This assumes Gregorian always; Calendar switches from
        // Julian to Gregorian in 1582.  What calendar system are the
        // arguments supposed to come from?

        long calc = (year / 400) * MILLISECONDS_PER_400_YEARS;
        year %= 400;

        calc += year * (365 * MILLISECONDS_PER_DAY);
        calc += ((year + 3) / 4) * MILLISECONDS_PER_DAY;

        if (year > 0) {
            calc -= ((year - 1) / 100) * MILLISECONDS_PER_DAY;
        }

        boolean isLeap = (year == 0 || (year % 4 == 0 && year % 100 != 0));
        int[] mlen = isLeap ? LEAP : NORMAL;

        calc += mlen[month] * MILLISECONDS_PER_DAY;
        calc += (day - 1) * MILLISECONDS_PER_DAY;
        calc += millis;

        calc -= mRawOffset;
        calc -= UNIX_OFFSET;

        return getOffset(calc);*/
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.450 -0500", hash_original_method = "1DD2E67C6E4C7148C355A1BA56BEEEAB", hash_generated_method = "3CD43BB900A7738114584B5B55E3F658")
    
@Override
    public int getOffset(long when) {
        return (int)(when + getTaintInt());
       /* int unix = (int) (when / 1000);
        int transition = Arrays.binarySearch(mTransitions, unix);
        if (transition < 0) {
            transition = ~transition - 1;
            if (transition < 0) {
                // Assume that all times before our first transition correspond to the
                // oldest-known non-daylight offset. The obvious alternative would be to
                // use the current raw offset, but that seems like a greater leap of faith.
                return mEarliestRawOffset;
            }
        }
        return mRawOffset + mOffsets[mTypes[transition] & 0xff] * 1000;*/
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.453 -0500", hash_original_method = "B2B7B20D9A81D2665491427CA669DC48", hash_generated_method = "FDA7F3F3F70CC070FC719E68A65BF66A")
    
@Override public boolean inDaylightTime(Date time) {
        return toTaintBoolean(time.getHours() + getTaintInt());
       /* long when = time.getTime();
        int unix = (int) (when / 1000);
        int transition = Arrays.binarySearch(mTransitions, unix);
        if (transition < 0) {
            transition = ~transition - 1;
            if (transition < 0) {
                // Assume that all times before our first transition are non-daylight.
                // Transition data tends to start with a transition to daylight, so just
                // copying the first transition would assume the opposite.
                // http://code.google.com/p/android/issues/detail?id=14395
                return false;
            }
        }
        return mIsDsts[mTypes[transition] & 0xff] == 1;*/
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.455 -0500", hash_original_method = "87352764C6114566CFCD3A7F913CA653", hash_generated_method = "0BE2EC6C07866D6560B4FEC30DFB59A8")
    
@Override public int getRawOffset() {
        return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.458 -0500", hash_original_method = "AE2A1B68EBE1FCF14F7860BA64C34CCE", hash_generated_method = "6290A6F7084233AE5F747A41F23FBDD3")
    
@Override public void setRawOffset(int off) {
        addTaint(off);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.460 -0500", hash_original_method = "81F7D5AE987C5D23D9D894C0567E3722", hash_generated_method = "DD86F760425679822A9B0195140AE811")
    
@Override public boolean useDaylightTime() {
        return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.463 -0500", hash_original_method = "73AAAC31DDE42029904964FC44B684BD", hash_generated_method = "A0C350257820BABA84EDFA3574B394D3")
    
@Override public boolean hasSameRules(TimeZone timeZone) {
        if (!(timeZone instanceof ZoneInfo)) {
            return false;
        }
        ZoneInfo other = (ZoneInfo) timeZone;
        if (mUseDst != other.mUseDst) {
            return false;
        }
        return toTaintBoolean(getTaintInt() + other.getTaintInt());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.466 -0500", hash_original_method = "ECC5255AD9E8EF75737AB68867396FFB", hash_generated_method = "E5D81ACFE1B7D26D686272EC1051E97E")
    
@Override public boolean equals(Object obj) {
        if (!(obj instanceof ZoneInfo)) {
            return false;
        }
        ZoneInfo other = (ZoneInfo) obj;
        return getID().equals(other.getID()) && hasSameRules(other);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.469 -0500", hash_original_method = "8C2336163065486F5E05E5E7E360E4D3", hash_generated_method = "F618048EAF6247574AC657DC14E00112")
    
@Override
    public int hashCode() {
        return getTaintInt();
       /* final int prime = 31;
        int result = 1;
        result = prime * result + getID().hashCode();
        result = prime * result + Arrays.hashCode(mOffsets);
        result = prime * result + Arrays.hashCode(mIsDsts);
        result = prime * result + mRawOffset;
        result = prime * result + Arrays.hashCode(mTransitions);
        result = prime * result + Arrays.hashCode(mTypes);
        result = prime * result + (mUseDst ? 1231 : 1237);
        return result;*/
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.471 -0500", hash_original_method = "0C13B49DB3B5709653F75D972BEB7E8A", hash_generated_method = "50A1DCBE916F412686F7B0C03CABB98E")
    
@Override
    public String toString() {
        String s = new String();
        s.addTaint(getTaint());
        return s;
       /* StringBuilder sb = new StringBuilder();
        // First the basics...
        sb.append(getClass().getName() + "[" + getID() + ",mRawOffset=" + mRawOffset +
                ",mUseDst=" + mUseDst + "]");
        // ...followed by a zdump(1)-like description of all our transition data.
        sb.append("\n");
        Formatter f = new Formatter(sb);
        for (int i = 0; i < mTransitions.length; ++i) {
            int type = mTypes[i] & 0xff;
            String utcTime = formatTime(mTransitions[i], TimeZone.getTimeZone("UTC"));
            String localTime = formatTime(mTransitions[i], this);
            int offset = mOffsets[type];
            int gmtOffset = mRawOffset/1000 + offset;
            f.format("%4d : time=%11d %s = %s isDst=%d offset=%5d gmtOffset=%d\n",
                    i, mTransitions[i], utcTime, localTime, mIsDsts[type], offset, gmtOffset);
        }
        return sb.toString();*/
    }
}

