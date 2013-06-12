package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import libcore.io.Memory;

public final class UUID implements Serializable, Comparable<UUID> {
    private static final long serialVersionUID = -4856846361193249489L;
    private static SecureRandom rng;
    private long mostSigBits;
    private long leastSigBits;
    private transient int variant;
    private transient int version;
    private transient long timestamp;
    private transient int clockSequence;
    private transient long node;
    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.342 -0400", hash_original_method = "ED635EB76A78F00DCB10AED73CFEDC4B", hash_generated_method = "B5EFD22DB78C1E075C9FCF528CE6A0C8")
    @DSModeled(DSC.SAFE)
    public UUID(long mostSigBits, long leastSigBits) {
        dsTaint.addTaint(mostSigBits);
        dsTaint.addTaint(leastSigBits);
        init();
        // ---------- Original Method ----------
        //this.mostSigBits = mostSigBits;
        //this.leastSigBits = leastSigBits;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "F8E8987A89D640EB2120FADDC9242C3F", hash_generated_method = "1D16084D330021EA662780E8FDD3AB2D")
    @DSModeled(DSC.SAFE)
    private void init() {
        int msbHash;
        msbHash = (int) (mostSigBits ^ (mostSigBits >>> 32));
        int lsbHash;
        lsbHash = (int) (leastSigBits ^ (leastSigBits >>> 32));
        hash = msbHash ^ lsbHash;
        {
            variant = 0;
        } //End block
        {
            variant = (int) ((leastSigBits & 0xE000000000000000L) >>> 61);
        } //End block
        {
            variant = 2;
        } //End block
        version = (int) ((mostSigBits & 0x000000000000F000) >>> 12);
        long timeLow;
        timeLow = (mostSigBits & 0xFFFFFFFF00000000L) >>> 32;
        long timeMid;
        timeMid = (mostSigBits & 0x00000000FFFF0000L) << 16;
        long timeHigh;
        timeHigh = (mostSigBits & 0x0000000000000FFFL) << 48;
        timestamp = timeLow | timeMid | timeHigh;
        clockSequence = (int) ((leastSigBits & 0x3FFF000000000000L) >>> 48);
        node = (leastSigBits & 0x0000FFFFFFFFFFFFL);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "062E55715164230436BF863A3994A273", hash_generated_method = "A06D065A528661A579BCD3445903BCEB")
    public static UUID randomUUID() {
        byte[] data = new byte[16];
        synchronized (UUID.class) {
            if (rng == null) {
                rng = new SecureRandom();
            }
        }
        rng.nextBytes(data);
        return makeUuid(data, 4);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "ADE744546D5EDC5F1118EE072B40943A", hash_generated_method = "F912BC9FD1D619B64EE1F4B0C6A632F3")
    public static UUID nameUUIDFromBytes(byte[] name) {
        if (name == null) {
            throw new NullPointerException();
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return makeUuid(md.digest(name), 3);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "9E98E00BE8824DAD14A3C091F30213C3", hash_generated_method = "5E041E09D95B1BC9CCF115AA655F1E6F")
    private static UUID makeUuid(byte[] hash, int version) {
        long msb = Memory.peekLong(hash, 0, ByteOrder.BIG_ENDIAN);
        long lsb = Memory.peekLong(hash, 8, ByteOrder.BIG_ENDIAN);
        msb &= ~(0xfL << 12);
        msb |= ((long) version) << 12;
        lsb &= ~(0x3L << 62);
        lsb |= 2L << 62;
        return new UUID(msb, lsb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "91976DDD0DF6E7445909995B535A77C8", hash_generated_method = "AF868514DFFB8D35A85CA22217F6C7AA")
    public static UUID fromString(String uuid) {
        if (uuid == null) {
            throw new NullPointerException();
        }
        int[] position = new int[5];
        int lastPosition = 1;
        int startPosition = 0;
        int i = 0;
        for (; i < position.length && lastPosition > 0; i++) {
            position[i] = uuid.indexOf("-", startPosition);
            lastPosition = position[i];
            startPosition = position[i] + 1;
        }
        if (i != position.length || lastPosition != -1) {
            throw new IllegalArgumentException("Invalid UUID: " + uuid);
        }
        long m1 = Long.parseLong(uuid.substring(0, position[0]), 16);
        long m2 = Long.parseLong(uuid.substring(position[0] + 1, position[1]), 16);
        long m3 = Long.parseLong(uuid.substring(position[1] + 1, position[2]), 16);
        long lsb1 = Long.parseLong(uuid.substring(position[2] + 1, position[3]), 16);
        long lsb2 = Long.parseLong(uuid.substring(position[3] + 1), 16);
        long msb = (m1 << 32) | (m2 << 16) | m3;
        long lsb = (lsb1 << 48) | lsb2;
        return new UUID(msb, lsb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "A0E7F1AB7FAB66E1A72A040241F18680", hash_generated_method = "1D2A7D3FC73221C217E3261F560E8B1A")
    @DSModeled(DSC.SAFE)
    public long getLeastSignificantBits() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return leastSigBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "6EF0A7C64F608CC6275528428E67572B", hash_generated_method = "BD9BCB9387B90FCECDAFB6A24A588713")
    @DSModeled(DSC.SAFE)
    public long getMostSignificantBits() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mostSigBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "33CA23C03592D558650D6881FB39BD17", hash_generated_method = "2061A23F45940FA2910FBA2AF7601CEE")
    @DSModeled(DSC.SAFE)
    public int version() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "F3E55A7ADD1B924C0020F2B2D27D2CBA", hash_generated_method = "C1DCFD3C92D802571050BE8967BDCE53")
    @DSModeled(DSC.SAFE)
    public int variant() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return variant;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "BC9161978762C6E74741C357EC2A66B7", hash_generated_method = "34E2114800AE5EF67B153C5D72D7C0D8")
    @DSModeled(DSC.SAFE)
    public long timestamp() {
        if (DroidSafeAndroidRuntime.control) {
            throw new UnsupportedOperationException();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (version != 1) {
            //throw new UnsupportedOperationException();
        //}
        //return timestamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "22D2FA35D30B9562E8F9B8FBAC9604FC", hash_generated_method = "1419012C62C6467976E28459F3A02BD5")
    @DSModeled(DSC.SAFE)
    public int clockSequence() {
        if (DroidSafeAndroidRuntime.control) {
            throw new UnsupportedOperationException();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (version != 1) {
            //throw new UnsupportedOperationException();
        //}
        //return clockSequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "F570F6113919571E2190BC663D44A8A0", hash_generated_method = "E10B516DF3010F6EC8623209B1A3705B")
    @DSModeled(DSC.SAFE)
    public long node() {
        if (DroidSafeAndroidRuntime.control) {
            throw new UnsupportedOperationException();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (version != 1) {
            //throw new UnsupportedOperationException();
        //}
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "BF37BBD9CA2A2DE01ED617F2C2EA69AA", hash_generated_method = "2081BFDBEFF101252A460AB729ED216C")
    @DSModeled(DSC.SAFE)
    public int compareTo(UUID uuid) {
        dsTaint.addTaint(uuid.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (uuid == this) {
            //return 0;
        //}
        //if (this.mostSigBits != uuid.mostSigBits) {
            //return this.mostSigBits < uuid.mostSigBits ? -1 : 1;
        //}
        //assert this.mostSigBits == uuid.mostSigBits;
        //if (this.leastSigBits != uuid.leastSigBits) {
            //return this.leastSigBits < uuid.leastSigBits ? -1 : 1;
        //}
        //assert this.leastSigBits == uuid.leastSigBits;
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "A38435ECE2C3D40D1AE6B3B8E9BB77AD", hash_generated_method = "C00CE2D9A51186DA5565BC3A9D6FEE77")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        UUID that;
        that = (UUID) object;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (object == null) {
            //return false;
        //}
        //if (this == object) {
            //return true;
        //}
        //if (!(object instanceof UUID)) {
            //return false;
        //}
        //UUID that = (UUID) object;
        //return (this.leastSigBits == that.leastSigBits)
                //&& (this.mostSigBits == that.mostSigBits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.343 -0400", hash_original_method = "2C05F06EE2A592A2D5972AF8C500920F", hash_generated_method = "D7A3C5FD2B74FE24AADC1F677B262964")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.344 -0400", hash_original_method = "2C7CA3FB1758723F3B30AD693E280579", hash_generated_method = "B958ED3B5396E64B91722ABBDAD3D887")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder builder;
        builder = new StringBuilder(36);
        String msbStr;
        msbStr = Long.toHexString(mostSigBits);
        {
            boolean var404F8B878AF4B8346E377FCFEFA38B82_186552985 = (msbStr.length() < 16);
            {
                int diff;
                diff = 16 - msbStr.length();
                {
                    int i;
                    i = 0;
                    {
                        builder.append('0');
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        builder.append(msbStr);
        builder.insert(8, '-');
        builder.insert(13, '-');
        builder.append('-');
        String lsbStr;
        lsbStr = Long.toHexString(leastSigBits);
        {
            boolean var4C96DEF0B78DABE502F2FB5838C0EB04_58751307 = (lsbStr.length() < 16);
            {
                int diff;
                diff = 16 - lsbStr.length();
                {
                    int i;
                    i = 0;
                    {
                        builder.append('0');
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        builder.append(lsbStr);
        builder.insert(23, '-');
        String var687AAF24B90629C9BFCFE9608FDCE6E7_1597874494 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder(36);
        //String msbStr = Long.toHexString(mostSigBits);
        //if (msbStr.length() < 16) {
            //int diff = 16 - msbStr.length();
            //for (int i = 0; i < diff; i++) {
                //builder.append('0');
            //}
        //}
        //builder.append(msbStr);
        //builder.insert(8, '-');
        //builder.insert(13, '-');
        //builder.append('-');
        //String lsbStr = Long.toHexString(leastSigBits);
        //if (lsbStr.length() < 16) {
            //int diff = 16 - lsbStr.length();
            //for (int i = 0; i < diff; i++) {
                //builder.append('0');
            //}
        //}
        //builder.append(lsbStr);
        //builder.insert(23, '-');
        //return builder.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.344 -0400", hash_original_method = "2009CB8B2416921986707AD76596B398", hash_generated_method = "3318D581298408A89FAD6022C0405AE9")
    @DSModeled(DSC.SAFE)
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        in.defaultReadObject();
        init();
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //init();
    }

    
}


