package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import libcore.io.Memory;

public final class UUID implements Serializable, Comparable<UUID> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.645 -0400", hash_original_field = "6D865F6ED4C841DE5F4163617E9ED5E0", hash_generated_field = "E05311E58F38272D7C9B90EC864288E6")

    private long mostSigBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.645 -0400", hash_original_field = "9DE6B31C686396DBA9E6DF04BA663491", hash_generated_field = "76D70F6EAB49CBC32F6DF9DF520746D2")

    private long leastSigBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.645 -0400", hash_original_field = "AA7AC8CD5E0A6993A177746279CC00D2", hash_generated_field = "ED6112CF1FA2DA1876E57F9A6D2E2836")

    private transient int variant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.645 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "BAD42B86A408081FE78996E122739899")

    private transient int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.645 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "C23704E529A178DBBDAFF49586FA6DE5")

    private transient long timestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.645 -0400", hash_original_field = "E508CBF4FB96E4F7675B06F84B12443F", hash_generated_field = "40191C6E13CEA31DB65CE03BDD6C6CBD")

    private transient int clockSequence;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.646 -0400", hash_original_field = "36C4536996CA5615DCF9911F068786DC", hash_generated_field = "65A72028038C4267F57DA36CF8BC58D6")

    private transient long node;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.646 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.646 -0400", hash_original_method = "ED635EB76A78F00DCB10AED73CFEDC4B", hash_generated_method = "02EBCE8ECE4A121E0D4A5FC929F94543")
    public  UUID(long mostSigBits, long leastSigBits) {
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
        init();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.647 -0400", hash_original_method = "F8E8987A89D640EB2120FADDC9242C3F", hash_generated_method = "4165E6205ECBE08F0A147C73A4BC69BE")
    private void init() {
        int msbHash = (int) (mostSigBits ^ (mostSigBits >>> 32));
        int lsbHash = (int) (leastSigBits ^ (leastSigBits >>> 32));
        hash = msbHash ^ lsbHash;
    if((leastSigBits & 0x8000000000000000L) == 0)        
        {
            variant = 0;
        } 
        else
    if((leastSigBits & 0x4000000000000000L) != 0)        
        {
            variant = (int) ((leastSigBits & 0xE000000000000000L) >>> 61);
        } 
        else
        {
            variant = 2;
        } 
        version = (int) ((mostSigBits & 0x000000000000F000) >>> 12);
    if(variant != 2 && version != 1)        
        {
            return;
        } 
        long timeLow = (mostSigBits & 0xFFFFFFFF00000000L) >>> 32;
        long timeMid = (mostSigBits & 0x00000000FFFF0000L) << 16;
        long timeHigh = (mostSigBits & 0x0000000000000FFFL) << 48;
        timestamp = timeLow | timeMid | timeHigh;
        clockSequence = (int) ((leastSigBits & 0x3FFF000000000000L) >>> 48);
        node = (leastSigBits & 0x0000FFFFFFFFFFFFL);
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.649 -0400", hash_original_method = "A0E7F1AB7FAB66E1A72A040241F18680", hash_generated_method = "5C71CC9CA1D9BA744CDFE5AB4FA6EB87")
    public long getLeastSignificantBits() {
        long var9DE6B31C686396DBA9E6DF04BA663491_433631091 = (leastSigBits);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1373793667 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1373793667;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.649 -0400", hash_original_method = "6EF0A7C64F608CC6275528428E67572B", hash_generated_method = "0F89ABB164DDBEC42E7F7D50BE928618")
    public long getMostSignificantBits() {
        long var6D865F6ED4C841DE5F4163617E9ED5E0_492743686 = (mostSigBits);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1998723662 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1998723662;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.649 -0400", hash_original_method = "33CA23C03592D558650D6881FB39BD17", hash_generated_method = "07A1B626481A6B3A28C02BAF51821065")
    public int version() {
        int var2AF72F100C356273D46284F6FD1DFC08_833793835 = (version);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166977876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166977876;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.650 -0400", hash_original_method = "F3E55A7ADD1B924C0020F2B2D27D2CBA", hash_generated_method = "B948141CE926BCA5BC2C3C32D1633400")
    public int variant() {
        int varAA7AC8CD5E0A6993A177746279CC00D2_635174934 = (variant);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164305589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164305589;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.650 -0400", hash_original_method = "BC9161978762C6E74741C357EC2A66B7", hash_generated_method = "50C81756D6443A31ECAB39E633D4AAC3")
    public long timestamp() {
    if(version != 1)        
        {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_15512172 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_15512172.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_15512172;
        } 
        long varD7E6D55BA379A13D08C25D15FAF2A23B_760669989 = (timestamp);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1749775323 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1749775323;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.650 -0400", hash_original_method = "22D2FA35D30B9562E8F9B8FBAC9604FC", hash_generated_method = "06A937D9C91CA49B6032FB5A2D1B3C67")
    public int clockSequence() {
    if(version != 1)        
        {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_698131018 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_698131018.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_698131018;
        } 
        int varE508CBF4FB96E4F7675B06F84B12443F_1912875899 = (clockSequence);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699816817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699816817;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.651 -0400", hash_original_method = "F570F6113919571E2190BC663D44A8A0", hash_generated_method = "9AF8FE220E0B715686970F2A14894000")
    public long node() {
    if(version != 1)        
        {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2138840716 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_2138840716.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_2138840716;
        } 
        long var36C4536996CA5615DCF9911F068786DC_221914887 = (node);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_602659811 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_602659811;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.651 -0400", hash_original_method = "BF37BBD9CA2A2DE01ED617F2C2EA69AA", hash_generated_method = "4D48FBA686DCACACE42140284780E4FA")
    public int compareTo(UUID uuid) {
        addTaint(uuid.getTaint());
    if(uuid == this)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_506371467 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994217035 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994217035;
        } 
    if(this.mostSigBits != uuid.mostSigBits)        
        {
            int var67C1EDA559C3C798D6B4F77A7FC9F3D4_2123040111 = (this.mostSigBits < uuid.mostSigBits ? -1 : 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806580044 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806580044;
        } 
    if(this.leastSigBits != uuid.leastSigBits)        
        {
            int var7EEEA79B384FDCBA52EA20EC524A0202_759637273 = (this.leastSigBits < uuid.leastSigBits ? -1 : 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340211370 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340211370;
        } 
        int varCFCD208495D565EF66E7DFF9F98764DA_402487359 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247913990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247913990;
        
        
            
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.652 -0400", hash_original_method = "A38435ECE2C3D40D1AE6B3B8E9BB77AD", hash_generated_method = "C807A6EA808563CD587093292D34FCB8")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(object == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_115269045 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691966411 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691966411;
        } 
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_830212629 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682721802 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_682721802;
        } 
    if(!(object instanceof UUID))        
        {
            boolean var68934A3E9455FA72420237EB05902327_309936742 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836384620 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836384620;
        } 
        UUID that = (UUID) object;
        boolean varCFCF99E6670BE96D85DBF729A89A73B4_1729400256 = ((this.leastSigBits == that.leastSigBits)
                && (this.mostSigBits == that.mostSigBits));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619892901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619892901;
        
        
            
        
        
            
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.652 -0400", hash_original_method = "2C05F06EE2A592A2D5972AF8C500920F", hash_generated_method = "BA127E4FF32DBE01C135E2FEF658F765")
    @Override
    public int hashCode() {
        int var0800FC577294C34E0B28AD2839435945_1985290897 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628859874 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628859874;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.652 -0400", hash_original_method = "2C7CA3FB1758723F3B30AD693E280579", hash_generated_method = "3259AFA64A465C4D0083B86ECB32A660")
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
            } 
        } 
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
            } 
        } 
        builder.append(lsbStr);
        builder.insert(23, '-');
String varF4CF030572656354ACFDF83FEE21D7A6_1172206412 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_1172206412.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_1172206412;
        
        
        
        
            
            
                
            
        
        
        
        
        
        
        
            
            
                
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.653 -0400", hash_original_method = "2009CB8B2416921986707AD76596B398", hash_generated_method = "9B727D193306F40CE5A6C46DD735C1D4")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        init();
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.653 -0400", hash_original_field = "ABCAC3ACFDD1F84ED574C5FF928C04D7", hash_generated_field = "091C22832E79DC74DEA4ADB3F391327C")

    private static final long serialVersionUID = -4856846361193249489L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:14.653 -0400", hash_original_field = "D2D9CE665F66AE49556B47436A514C0F", hash_generated_field = "A9867F7F1BA5EDFF98FD827A1CEF8FD3")

    private static SecureRandom rng;
}

