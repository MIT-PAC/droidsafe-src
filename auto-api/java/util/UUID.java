package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.648 -0400", hash_original_field = "6D865F6ED4C841DE5F4163617E9ED5E0", hash_generated_field = "E05311E58F38272D7C9B90EC864288E6")

    private long mostSigBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.648 -0400", hash_original_field = "9DE6B31C686396DBA9E6DF04BA663491", hash_generated_field = "76D70F6EAB49CBC32F6DF9DF520746D2")

    private long leastSigBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.648 -0400", hash_original_field = "AA7AC8CD5E0A6993A177746279CC00D2", hash_generated_field = "ED6112CF1FA2DA1876E57F9A6D2E2836")

    private transient int variant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.649 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "BAD42B86A408081FE78996E122739899")

    private transient int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.649 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "C23704E529A178DBBDAFF49586FA6DE5")

    private transient long timestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.649 -0400", hash_original_field = "E508CBF4FB96E4F7675B06F84B12443F", hash_generated_field = "40191C6E13CEA31DB65CE03BDD6C6CBD")

    private transient int clockSequence;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.649 -0400", hash_original_field = "36C4536996CA5615DCF9911F068786DC", hash_generated_field = "65A72028038C4267F57DA36CF8BC58D6")

    private transient long node;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.649 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.649 -0400", hash_original_method = "ED635EB76A78F00DCB10AED73CFEDC4B", hash_generated_method = "02EBCE8ECE4A121E0D4A5FC929F94543")
    public  UUID(long mostSigBits, long leastSigBits) {
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
        init();
        // ---------- Original Method ----------
        //this.mostSigBits = mostSigBits;
        //this.leastSigBits = leastSigBits;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.650 -0400", hash_original_method = "F8E8987A89D640EB2120FADDC9242C3F", hash_generated_method = "EA34B5FC32C0E91FAFEA789585BCD21B")
    private void init() {
        int msbHash = (int) (mostSigBits ^ (mostSigBits >>> 32));
        int lsbHash = (int) (leastSigBits ^ (leastSigBits >>> 32));
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
        long timeLow = (mostSigBits & 0xFFFFFFFF00000000L) >>> 32;
        long timeMid = (mostSigBits & 0x00000000FFFF0000L) << 16;
        long timeHigh = (mostSigBits & 0x0000000000000FFFL) << 48;
        timestamp = timeLow | timeMid | timeHigh;
        clockSequence = (int) ((leastSigBits & 0x3FFF000000000000L) >>> 48);
        node = (leastSigBits & 0x0000FFFFFFFFFFFFL);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    private static UUID makeUuid(byte[] hash, int version) {
        long msb = Memory.peekLong(hash, 0, ByteOrder.BIG_ENDIAN);
        long lsb = Memory.peekLong(hash, 8, ByteOrder.BIG_ENDIAN);
        msb &= ~(0xfL << 12);
        msb |= ((long) version) << 12;
        lsb &= ~(0x3L << 62);
        lsb |= 2L << 62;
        return new UUID(msb, lsb);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.651 -0400", hash_original_method = "A0E7F1AB7FAB66E1A72A040241F18680", hash_generated_method = "FD77E7D8105EBE2C657A864E861363AE")
    public long getLeastSignificantBits() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1560314480 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1560314480;
        // ---------- Original Method ----------
        //return leastSigBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.651 -0400", hash_original_method = "6EF0A7C64F608CC6275528428E67572B", hash_generated_method = "5553977392AC76F36849E5D675AFD529")
    public long getMostSignificantBits() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_803654449 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_803654449;
        // ---------- Original Method ----------
        //return mostSigBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.651 -0400", hash_original_method = "33CA23C03592D558650D6881FB39BD17", hash_generated_method = "FD015E6CA3684776FE9817DC5AAA2219")
    public int version() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206058045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206058045;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.652 -0400", hash_original_method = "F3E55A7ADD1B924C0020F2B2D27D2CBA", hash_generated_method = "FFA4D9857780F3B10559A06AEFCADA38")
    public int variant() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468216556 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468216556;
        // ---------- Original Method ----------
        //return variant;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.652 -0400", hash_original_method = "BC9161978762C6E74741C357EC2A66B7", hash_generated_method = "E38979C9008D9DFB8D2E448728FE1B67")
    public long timestamp() {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_541438873 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_541438873;
        // ---------- Original Method ----------
        //if (version != 1) {
            //throw new UnsupportedOperationException();
        //}
        //return timestamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.653 -0400", hash_original_method = "22D2FA35D30B9562E8F9B8FBAC9604FC", hash_generated_method = "3C3F9F890C37D15921331471401422D1")
    public int clockSequence() {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857606341 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857606341;
        // ---------- Original Method ----------
        //if (version != 1) {
            //throw new UnsupportedOperationException();
        //}
        //return clockSequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.653 -0400", hash_original_method = "F570F6113919571E2190BC663D44A8A0", hash_generated_method = "7ECB2B8211820878389CC82D7663CB24")
    public long node() {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_177972922 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_177972922;
        // ---------- Original Method ----------
        //if (version != 1) {
            //throw new UnsupportedOperationException();
        //}
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.654 -0400", hash_original_method = "BF37BBD9CA2A2DE01ED617F2C2EA69AA", hash_generated_method = "2441502DD742CD31A59DA8B64E78DFC8")
    public int compareTo(UUID uuid) {
        {
            boolean var41101EA63603ABEDB7BF7C67E4022EB4_1814373757 = (uuid == this);
        } //End collapsed parenthetic
        addTaint(uuid.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713233267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713233267;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.655 -0400", hash_original_method = "A38435ECE2C3D40D1AE6B3B8E9BB77AD", hash_generated_method = "B2D9CC3B800ACA8613CE46209D92E641")
    @Override
    public boolean equals(Object object) {
        UUID that = (UUID) object;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1511895203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1511895203;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.655 -0400", hash_original_method = "2C05F06EE2A592A2D5972AF8C500920F", hash_generated_method = "96527A99F4BEBE4849005DD54F3298FD")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876917468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876917468;
        // ---------- Original Method ----------
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.656 -0400", hash_original_method = "2C7CA3FB1758723F3B30AD693E280579", hash_generated_method = "C0596250CE645B8892EA613C511A1095")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1379549969 = null; //Variable for return #1
        StringBuilder builder = new StringBuilder(36);
        String msbStr = Long.toHexString(mostSigBits);
        {
            boolean var404F8B878AF4B8346E377FCFEFA38B82_984465459 = (msbStr.length() < 16);
            {
                int diff = 16 - msbStr.length();
                {
                    int i = 0;
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
        String lsbStr = Long.toHexString(leastSigBits);
        {
            boolean var4C96DEF0B78DABE502F2FB5838C0EB04_691730712 = (lsbStr.length() < 16);
            {
                int diff = 16 - lsbStr.length();
                {
                    int i = 0;
                    {
                        builder.append('0');
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        builder.append(lsbStr);
        builder.insert(23, '-');
        varB4EAC82CA7396A68D541C85D26508E83_1379549969 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1379549969.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1379549969;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.657 -0400", hash_original_method = "2009CB8B2416921986707AD76596B398", hash_generated_method = "1C5081E512225E62582548411F226601")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        init();
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //init();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.657 -0400", hash_original_field = "ABCAC3ACFDD1F84ED574C5FF928C04D7", hash_generated_field = "091C22832E79DC74DEA4ADB3F391327C")

    private static final long serialVersionUID = -4856846361193249489L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.657 -0400", hash_original_field = "D2D9CE665F66AE49556B47436A514C0F", hash_generated_field = "A9867F7F1BA5EDFF98FD827A1CEF8FD3")

    private static SecureRandom rng;
}

