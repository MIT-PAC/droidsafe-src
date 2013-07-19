package java.util;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import libcore.io.Memory;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class UUID implements Serializable, Comparable<UUID> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.653 -0400", hash_original_field = "6D865F6ED4C841DE5F4163617E9ED5E0", hash_generated_field = "E05311E58F38272D7C9B90EC864288E6")

    private long mostSigBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.653 -0400", hash_original_field = "9DE6B31C686396DBA9E6DF04BA663491", hash_generated_field = "76D70F6EAB49CBC32F6DF9DF520746D2")

    private long leastSigBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.653 -0400", hash_original_field = "AA7AC8CD5E0A6993A177746279CC00D2", hash_generated_field = "ED6112CF1FA2DA1876E57F9A6D2E2836")

    private transient int variant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.653 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "BAD42B86A408081FE78996E122739899")

    private transient int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.654 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "C23704E529A178DBBDAFF49586FA6DE5")

    private transient long timestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.654 -0400", hash_original_field = "E508CBF4FB96E4F7675B06F84B12443F", hash_generated_field = "40191C6E13CEA31DB65CE03BDD6C6CBD")

    private transient int clockSequence;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.654 -0400", hash_original_field = "36C4536996CA5615DCF9911F068786DC", hash_generated_field = "65A72028038C4267F57DA36CF8BC58D6")

    private transient long node;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.654 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.654 -0400", hash_original_method = "ED635EB76A78F00DCB10AED73CFEDC4B", hash_generated_method = "02EBCE8ECE4A121E0D4A5FC929F94543")
    public  UUID(long mostSigBits, long leastSigBits) {
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
        init();
        // ---------- Original Method ----------
        //this.mostSigBits = mostSigBits;
        //this.leastSigBits = leastSigBits;
        //init();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.656 -0400", hash_original_method = "F8E8987A89D640EB2120FADDC9242C3F", hash_generated_method = "4165E6205ECBE08F0A147C73A4BC69BE")
    private void init() {
        int msbHash = (int) (mostSigBits ^ (mostSigBits >>> 32));
        int lsbHash = (int) (leastSigBits ^ (leastSigBits >>> 32));
        hash = msbHash ^ lsbHash;
        if((leastSigBits & 0x8000000000000000L) == 0)        
        {
            variant = 0;
        } //End block
        else
        if((leastSigBits & 0x4000000000000000L) != 0)        
        {
            variant = (int) ((leastSigBits & 0xE000000000000000L) >>> 61);
        } //End block
        else
        {
            variant = 2;
        } //End block
        version = (int) ((mostSigBits & 0x000000000000F000) >>> 12);
        if(variant != 2 && version != 1)        
        {
            return;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.657 -0400", hash_original_method = "A0E7F1AB7FAB66E1A72A040241F18680", hash_generated_method = "30963A7B027B2EA42B7169F865906E20")
    public long getLeastSignificantBits() {
        long var9DE6B31C686396DBA9E6DF04BA663491_584442794 = (leastSigBits);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1065504857 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1065504857;
        // ---------- Original Method ----------
        //return leastSigBits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.657 -0400", hash_original_method = "6EF0A7C64F608CC6275528428E67572B", hash_generated_method = "AE8E654E8E9BCDB873CDB07F02D7BA73")
    public long getMostSignificantBits() {
        long var6D865F6ED4C841DE5F4163617E9ED5E0_597107031 = (mostSigBits);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1072404075 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1072404075;
        // ---------- Original Method ----------
        //return mostSigBits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.658 -0400", hash_original_method = "33CA23C03592D558650D6881FB39BD17", hash_generated_method = "8A39326626DA035F3C68543590B662EE")
    public int version() {
        int var2AF72F100C356273D46284F6FD1DFC08_723061142 = (version);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_172187864 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_172187864;
        // ---------- Original Method ----------
        //return version;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.658 -0400", hash_original_method = "F3E55A7ADD1B924C0020F2B2D27D2CBA", hash_generated_method = "7D982EAD6A793EB681869CAD6BF679B8")
    public int variant() {
        int varAA7AC8CD5E0A6993A177746279CC00D2_181620638 = (variant);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655872260 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655872260;
        // ---------- Original Method ----------
        //return variant;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.658 -0400", hash_original_method = "BC9161978762C6E74741C357EC2A66B7", hash_generated_method = "7AC90A90786A50DBBD3A4F20DCFD4A61")
    public long timestamp() {
        if(version != 1)        
        {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1905305442 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1905305442.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1905305442;
        } //End block
        long varD7E6D55BA379A13D08C25D15FAF2A23B_1666930919 = (timestamp);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1153868959 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1153868959;
        // ---------- Original Method ----------
        //if (version != 1) {
            //throw new UnsupportedOperationException();
        //}
        //return timestamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.659 -0400", hash_original_method = "22D2FA35D30B9562E8F9B8FBAC9604FC", hash_generated_method = "2F26C6E7104945F0F68256E48621D7AF")
    public int clockSequence() {
        if(version != 1)        
        {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_95215574 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_95215574.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_95215574;
        } //End block
        int varE508CBF4FB96E4F7675B06F84B12443F_705559167 = (clockSequence);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_162079196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_162079196;
        // ---------- Original Method ----------
        //if (version != 1) {
            //throw new UnsupportedOperationException();
        //}
        //return clockSequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.659 -0400", hash_original_method = "F570F6113919571E2190BC663D44A8A0", hash_generated_method = "7D7D3314D503A0714D19EB7D669C88E0")
    public long node() {
        if(version != 1)        
        {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1276055433 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1276055433.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1276055433;
        } //End block
        long var36C4536996CA5615DCF9911F068786DC_616110561 = (node);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1502205876 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1502205876;
        // ---------- Original Method ----------
        //if (version != 1) {
            //throw new UnsupportedOperationException();
        //}
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.659 -0400", hash_original_method = "BF37BBD9CA2A2DE01ED617F2C2EA69AA", hash_generated_method = "E2217DEFA80E0D6483E193B21815082A")
    public int compareTo(UUID uuid) {
        addTaint(uuid.getTaint());
        if(uuid == this)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1998908277 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_569625329 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_569625329;
        } //End block
        if(this.mostSigBits != uuid.mostSigBits)        
        {
            int var67C1EDA559C3C798D6B4F77A7FC9F3D4_1360452789 = (this.mostSigBits < uuid.mostSigBits ? -1 : 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350968485 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350968485;
        } //End block
        if(this.leastSigBits != uuid.leastSigBits)        
        {
            int var7EEEA79B384FDCBA52EA20EC524A0202_1408062975 = (this.leastSigBits < uuid.leastSigBits ? -1 : 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734977143 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734977143;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1408799338 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_15850819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_15850819;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.660 -0400", hash_original_method = "A38435ECE2C3D40D1AE6B3B8E9BB77AD", hash_generated_method = "83918628C1BCF9D06537C5CAC6CB7A81")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(object == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_477028726 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052594331 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052594331;
        } //End block
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1213722891 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443876941 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_443876941;
        } //End block
        if(!(object instanceof UUID))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1367937593 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394296699 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394296699;
        } //End block
        UUID that = (UUID) object;
        boolean varCFCF99E6670BE96D85DBF729A89A73B4_1114725834 = ((this.leastSigBits == that.leastSigBits)
                && (this.mostSigBits == that.mostSigBits));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1444643126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1444643126;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.660 -0400", hash_original_method = "2C05F06EE2A592A2D5972AF8C500920F", hash_generated_method = "DF5F9FF3B19EBAEA420E99FC5D0EFE70")
    @Override
    public int hashCode() {
        int var0800FC577294C34E0B28AD2839435945_940497639 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1810900025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1810900025;
        // ---------- Original Method ----------
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.660 -0400", hash_original_method = "2C7CA3FB1758723F3B30AD693E280579", hash_generated_method = "AC6162C8C4441D55E1BCE3BD7C298C4C")
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(36);
        String msbStr = Long.toHexString(mostSigBits);
        if(msbStr.length() < 16)        
        {
            int diff = 16 - msbStr.length();
for(int i = 0;i < diff;i++)
            {
                builder.append('0');
            } //End block
        } //End block
        builder.append(msbStr);
        builder.insert(8, '-');
        builder.insert(13, '-');
        builder.append('-');
        String lsbStr = Long.toHexString(leastSigBits);
        if(lsbStr.length() < 16)        
        {
            int diff = 16 - lsbStr.length();
for(int i = 0;i < diff;i++)
            {
                builder.append('0');
            } //End block
        } //End block
        builder.append(lsbStr);
        builder.insert(23, '-');
String varF4CF030572656354ACFDF83FEE21D7A6_1985289829 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_1985289829.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_1985289829;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.661 -0400", hash_original_method = "2009CB8B2416921986707AD76596B398", hash_generated_method = "9B727D193306F40CE5A6C46DD735C1D4")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        init();
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //init();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.661 -0400", hash_original_field = "ABCAC3ACFDD1F84ED574C5FF928C04D7", hash_generated_field = "091C22832E79DC74DEA4ADB3F391327C")

    private static final long serialVersionUID = -4856846361193249489L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.661 -0400", hash_original_field = "D2D9CE665F66AE49556B47436A514C0F", hash_generated_field = "A9867F7F1BA5EDFF98FD827A1CEF8FD3")

    private static SecureRandom rng;
}

