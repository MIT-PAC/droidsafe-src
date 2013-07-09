package org.bouncycastle.math.ec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;
import java.util.Random;

public abstract class ECCurve {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.376 -0400", hash_original_field = "0CC175B9C0F1B6A831C399E269772661", hash_generated_field = "16F3809D308EE3B5C0D90855C77B94DD")

    ECFieldElement a;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.376 -0400", hash_original_field = "92EB5FFEE6AE2FEC3AD71C777531578F", hash_generated_field = "2E1C114DB6D3D5AFAFE6B5C7A24A4397")

    ECFieldElement b;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.376 -0400", hash_original_method = "3ADB63016220614BC8D776351AA4CC0A", hash_generated_method = "3ADB63016220614BC8D776351AA4CC0A")
    public ECCurve ()
    {
        
    }


    public abstract int getFieldSize();

    
    public abstract ECFieldElement fromBigInteger(BigInteger x);

    
    public abstract ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression);

    
    public abstract ECPoint decodePoint(byte[] encoded);

    
    public abstract ECPoint getInfinity();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.378 -0400", hash_original_method = "E518DFD3A1B52E4C2FA641AF9C8BD0EA", hash_generated_method = "5BC65537E066A1BA82DECA88629348B5")
    public ECFieldElement getA() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1565236589 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1565236589 = a;
        varB4EAC82CA7396A68D541C85D26508E83_1565236589.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1565236589;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.378 -0400", hash_original_method = "E3D5F4BB1EEF47030E7E58DC1A7D0CBC", hash_generated_method = "F037F9DB289B067114A86D5C521E685C")
    public ECFieldElement getB() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1496616872 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1496616872 = b;
        varB4EAC82CA7396A68D541C85D26508E83_1496616872.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1496616872;
        
        
    }

    
    public static class Fp extends ECCurve {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.378 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "F819999E3B2036A19089F4FD0B5D94F4")

        BigInteger q;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.378 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "69A238B6B16C69E09404578CE64545C8")

        ECPoint.Fp infinity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.379 -0400", hash_original_method = "22B1E0FEEF98DB62B3F95091656AE119", hash_generated_method = "C63CCCEBA39E46BA85FB153D6F663EFC")
        public  Fp(BigInteger q, BigInteger a, BigInteger b) {
            this.q = q;
            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.infinity = new ECPoint.Fp(this, null, null);
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.380 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "448B033B1B8C5473F5F1EA40948BBE9D")
        public BigInteger getQ() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_1617504673 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1617504673 = q;
            varB4EAC82CA7396A68D541C85D26508E83_1617504673.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1617504673;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.380 -0400", hash_original_method = "B586F82D19D11BCE8142121499961CE9", hash_generated_method = "6C1C02BD4C353D0B4A4B0EB5D9890F52")
        public int getFieldSize() {
            int varA151D78D1E2C09447CC56EDC4DA68901_52618806 = (q.bitLength());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288654312 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288654312;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.381 -0400", hash_original_method = "717FAD51B8C0866C7878DF981123AAA4", hash_generated_method = "718B09DBD2E3E24C3F655E27E0863617")
        public ECFieldElement fromBigInteger(BigInteger x) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_553373425 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_553373425 = new ECFieldElement.Fp(this.q, x);
            addTaint(x.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_553373425.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_553373425;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.382 -0400", hash_original_method = "E2F0508F86D70ECB95714B920D7ED166", hash_generated_method = "7257D69E68E13629584AE5EFBA592F12")
        public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1521133388 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1521133388 = new ECPoint.Fp(this, fromBigInteger(x), fromBigInteger(y), withCompression);
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            addTaint(withCompression);
            varB4EAC82CA7396A68D541C85D26508E83_1521133388.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1521133388;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.383 -0400", hash_original_method = "1737D5EF0BE777F7A805235738F1CA68", hash_generated_method = "639B2EA26B58B9992F2305470D3FF169")
        public ECPoint decodePoint(byte[] encoded) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_689918247 = null; 
            ECPoint p = null;
            
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point encoding");
            } 
            
            
            p = getInfinity();
            
            
            int ytilde = encoded[0] & 1;
            
            
            byte[] i = new byte[encoded.length - 1];
            
            
            System.arraycopy(encoded, 1, i, 0, i.length);
            
            
            ECFieldElement x = new ECFieldElement.Fp(this.q, new BigInteger(1, i));
            
            
            ECFieldElement alpha = x.multiply(x.square().add(a)).add(b);
            
            
            ECFieldElement beta = alpha.sqrt();
            
            
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point compression");
            } 
            
            
            int bit0 = (beta.toBigInteger().testBit(0) ? 1 : 0);
            
            
            {
                p = new ECPoint.Fp(this, x, beta, true);
            } 
            {
                p = new ECPoint.Fp(this, x,
                        new ECFieldElement.Fp(this.q, q.subtract(beta.toBigInteger())), true);
            } 
            
            
            byte[] xEnc = new byte[(encoded.length - 1) / 2];
            
            
            byte[] yEnc = new byte[(encoded.length - 1) / 2];
            
            
            System.arraycopy(encoded, 1, xEnc, 0, xEnc.length);
            
            
            System.arraycopy(encoded, xEnc.length + 1, yEnc, 0, yEnc.length);
            
            
            p = new ECPoint.Fp(this,
                        new ECFieldElement.Fp(this.q, new BigInteger(1, xEnc)),
                        new ECFieldElement.Fp(this.q, new BigInteger(1, yEnc)));
            
            
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(encoded[0], 16));
            
            varB4EAC82CA7396A68D541C85D26508E83_689918247 = p;
            addTaint(encoded[0]);
            varB4EAC82CA7396A68D541C85D26508E83_689918247.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_689918247;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.384 -0400", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "D325BA48C8822FD2C44633CE29BD35DB")
        public ECPoint getInfinity() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_701975355 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_701975355 = infinity;
            varB4EAC82CA7396A68D541C85D26508E83_701975355.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_701975355;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.384 -0400", hash_original_method = "937E7F8C7D7C20805F9F2153639BF5E3", hash_generated_method = "305B7A8AFAE41DFD8048FC0275186F7B")
        public boolean equals(
            Object anObject) {
            {
                boolean varDDF650371899A44735E1E943193361F5_1652522422 = (anObject == this);
            } 
            ECCurve.Fp other = (ECCurve.Fp) anObject;
            boolean varA05429A3F1E17A3F73EAEAFC61009686_564751814 = (this.q.equals(other.q) 
                    && a.equals(other.a) && b.equals(other.b));
            addTaint(anObject.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1480431241 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1480431241;
            
            
            
                
            
            
            
                
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_method = "0595BFE04038932B73D34C7D5BF16F78", hash_generated_method = "3FD5A15EABA7C6C687E00AFCD849758D")
        public int hashCode() {
            int varE700A94E94A70FE59B4AEED0B662AD32_1205321678 = (a.hashCode() ^ b.hashCode() ^ q.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544627558 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544627558;
            
            
        }

        
    }


    
    public static class F2m extends ECCurve {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

        private int m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_field = "B637B17AF08ACED8850C18CCCDE915DA", hash_generated_field = "82BC5D885288BEA8F058C8200E42732B")

        private int k1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_field = "61620957A1443C946A143CF99A7D24FA", hash_generated_field = "9A9BABB98FA71DB4E862A96C38A0DEB5")

        private int k2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_field = "F7AB469D1DC79166FC874DADCC0DD854", hash_generated_field = "B93297072479995D07A6DAC48610EF09")

        private int k3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "28997BC83DA18A620109895922F10617")

        private BigInteger n;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

        private BigInteger h;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "3F0371905D46A3DF93ACA58D05B01E9C")

        private ECPoint.F2m infinity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_field = "5C77EC7DAADCE22A1213046881A54B40", hash_generated_field = "FF1108A0424E980F296A774C118EF5E8")

        private byte mu = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_field = "9A98A235BB28BA556F2A8960F7A384A8", hash_generated_field = "4DD43C8E43FDD8E564AAA02789FAC70C")

        private BigInteger[] si = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.385 -0400", hash_original_method = "DEC52BA66274A72254EB3F42E643013D", hash_generated_method = "6984139A7A57FF50A2A61A86AD94648F")
        public  F2m(
            int m,
            int k,
            BigInteger a,
            BigInteger b) {
            this(m, k, 0, 0, a, b, null, null);
            addTaint(m);
            addTaint(k);
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.386 -0400", hash_original_method = "F2139B4AB6C86388E7E3C9323DB40384", hash_generated_method = "DCC36A83DB40CAA11C9DBFA7709D179D")
        public  F2m(
            int m, 
            int k, 
            BigInteger a, 
            BigInteger b,
            BigInteger n,
            BigInteger h) {
            this(m, k, 0, 0, a, b, n, h);
            addTaint(m);
            addTaint(k);
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            addTaint(n.getTaint());
            addTaint(h.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.386 -0400", hash_original_method = "5E11630AFDD86B3E6F25DD938FDF4713", hash_generated_method = "DA963AC6EE1FFE2B8DA76B3B5A2F8648")
        public  F2m(
            int m,
            int k1,
            int k2,
            int k3,
            BigInteger a,
            BigInteger b) {
            this(m, k1, k2, k3, a, b, null, null);
            addTaint(m);
            addTaint(k1);
            addTaint(k2);
            addTaint(k3);
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.387 -0400", hash_original_method = "DFE62FA9A40BB48176925A509A87D7E7", hash_generated_method = "B1C41978F7997A7962EB33450E4544D4")
        public  F2m(
            int m, 
            int k1, 
            int k2, 
            int k3,
            BigInteger a, 
            BigInteger b,
            BigInteger n,
            BigInteger h) {
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            this.n = n;
            this.h = h;
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("k1 must be > 0");
            } 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                } 
            } 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("k2 must be > k1");
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("k3 must be > k2");
                } 
            } 
            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.infinity = new ECPoint.F2m(this, null, null);
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.387 -0400", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "194B4408D7ECA25FED597B398306DE7B")
        public int getFieldSize() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168566227 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168566227;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.387 -0400", hash_original_method = "7AF48CB12A1921AAC7C154231A16AA21", hash_generated_method = "B591814FA6216FC3109A59EAC52756C7")
        public ECFieldElement fromBigInteger(BigInteger x) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1498887990 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1498887990 = new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
            addTaint(x.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1498887990.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1498887990;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.388 -0400", hash_original_method = "166EA7512C9A204978606C53F7DDDB4A", hash_generated_method = "5274B1179465A6FCE4A7516D64375CCE")
        public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_399141532 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_399141532 = new ECPoint.F2m(this, fromBigInteger(x), fromBigInteger(y), withCompression);
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            addTaint(withCompression);
            varB4EAC82CA7396A68D541C85D26508E83_399141532.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_399141532;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.389 -0400", hash_original_method = "3A440A2E6AC052FD5047F5B01472DA22", hash_generated_method = "18A028716B4D8B36DB54D45B233130DF")
        public ECPoint decodePoint(byte[] encoded) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1952732287 = null; 
            ECPoint p = null;
            
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point encoding");
            } 
            
            
            p = getInfinity();
            
            
            byte[] enc = new byte[encoded.length - 1];
            
            
            System.arraycopy(encoded, 1, enc, 0, enc.length);
            
            
            {
                p = decompressPoint(enc, 0);
            } 
            {
                p = decompressPoint(enc, 1);
            } 
            
            
            byte[] xEnc = new byte[(encoded.length - 1) / 2];
            
            
            byte[] yEnc = new byte[(encoded.length - 1) / 2];
            
            
            System.arraycopy(encoded, 1, xEnc, 0, xEnc.length);
            
            
            System.arraycopy(encoded, xEnc.length + 1, yEnc, 0, yEnc.length);
            
            
            p = new ECPoint.F2m(this,
                    new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3,
                        new BigInteger(1, xEnc)),
                    new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3,
                        new BigInteger(1, yEnc)), false);
            
            
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(encoded[0], 16));
            
            varB4EAC82CA7396A68D541C85D26508E83_1952732287 = p;
            addTaint(encoded[0]);
            varB4EAC82CA7396A68D541C85D26508E83_1952732287.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1952732287;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.390 -0400", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "CA3FD604B741B35193BC454DC83FBECD")
        public ECPoint getInfinity() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1549850925 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1549850925 = infinity;
            varB4EAC82CA7396A68D541C85D26508E83_1549850925.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1549850925;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.391 -0400", hash_original_method = "0873B9ADE54853DB8C371F01782A1B9E", hash_generated_method = "AB48F714CE8DEAC5C50E1FB35CB4E831")
        public boolean isKoblitz() {
            boolean var7A6C9BC264E548EC56E3F73CB401F2AE_1836710764 = (((n != null) && (h != null) &&
                    ((a.toBigInteger().equals(ECConstants.ZERO)) ||
                    (a.toBigInteger().equals(ECConstants.ONE))) &&
                    (b.toBigInteger().equals(ECConstants.ONE))));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1414260212 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1414260212;
            
            
                    
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.392 -0400", hash_original_method = "6A47B833A38B2C51AF1636CDFCEB3B55", hash_generated_method = "CC9F81969AE8A29C3377267213FDB063")
        synchronized byte getMu() {
            {
                mu = Tnaf.getMu(this);
            } 
            byte var40EA57D3EE3C07BF1C102B466E1C3091_1170288358 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_1170288358;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.393 -0400", hash_original_method = "C02001236D393BDCA3D2D65CC0F3FCD6", hash_generated_method = "39398BA8DD5A834916E9216F27A1BE5B")
        synchronized BigInteger[] getSi() {
            BigInteger[] varB4EAC82CA7396A68D541C85D26508E83_647664918 = null; 
            {
                si = Tnaf.getSi(this);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_647664918 = si;
            varB4EAC82CA7396A68D541C85D26508E83_647664918.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_647664918;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.396 -0400", hash_original_method = "ABCDD5682443273B6E9EF7110AFEAA10", hash_generated_method = "E8BBCD35E43CE0D1EDC4D81107BDA656")
        private ECPoint decompressPoint(
            byte[] xEnc, 
            int ypBit) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_661506339 = null; 
            ECFieldElement xp = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, new BigInteger(1, xEnc));
            ECFieldElement yp = null;
            {
                boolean varC072E047DAA030A92F785F9995B84EFE_1601925829 = (xp.toBigInteger().equals(ECConstants.ZERO));
                {
                    yp = (ECFieldElement.F2m)b;
                    {
                        int i = 0;
                        {
                            yp = yp.square();
                        } 
                    } 
                } 
                {
                    ECFieldElement beta = xp.add(a).add(
                        b.multiply(xp.square().invert()));
                    ECFieldElement z = solveQuadradicEquation(beta);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point compression");
                    } 
                    int zBit = 0;
                    {
                        boolean var584500F14C5C32181BBFF11166A2781E_1957272221 = (z.toBigInteger().testBit(0));
                        {
                            zBit = 1;
                        } 
                    } 
                    {
                        z = z.add(new ECFieldElement.F2m(this.m, this.k1, this.k2,
                            this.k3, ECConstants.ONE));
                    } 
                    yp = xp.multiply(z);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_661506339 = new ECPoint.F2m(this, xp, yp);
            addTaint(xEnc[0]);
            addTaint(ypBit);
            varB4EAC82CA7396A68D541C85D26508E83_661506339.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_661506339;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.397 -0400", hash_original_method = "25ED10C579C6ED4884A834D5A2CEB482", hash_generated_method = "D4893CEA8C3C15490E11189EE8473E6E")
        private ECFieldElement solveQuadradicEquation(ECFieldElement beta) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1698764210 = null; 
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1114776911 = null; 
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1354979031 = null; 
            ECFieldElement zeroElement = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, ECConstants.ZERO);
            {
                boolean var8E624E2CB7B76E196F1A3B3E4E14BFB1_353346998 = (beta.toBigInteger().equals(ECConstants.ZERO));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1698764210 = zeroElement;
                } 
            } 
            ECFieldElement z = null;
            ECFieldElement gamma = zeroElement;
            Random rand = new Random();
            {
                ECFieldElement t = new ECFieldElement.F2m(this.m, this.k1,
                        this.k2, this.k3, new BigInteger(m, rand));
                z = zeroElement;
                ECFieldElement w = beta;
                {
                    int i = 1;
                    {
                        ECFieldElement w2 = w.square();
                        z = z.square().add(w2.multiply(t));
                        w = w2.add(beta);
                    } 
                } 
                {
                    boolean var1F5A575FD8B96856949BBB9072892017_101961527 = (!w.toBigInteger().equals(ECConstants.ZERO));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1114776911 = null;
                    } 
                } 
                gamma = z.square().add(z);
            } 
            {
                boolean var3737DC55BBBC931D31E5C79A85F192CA_1979918599 = (gamma.toBigInteger().equals(ECConstants.ZERO));
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1354979031 = z;
            addTaint(beta.getTaint());
            ECFieldElement varA7E53CE21691AB073D9660D615818899_755226179; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_755226179 = varB4EAC82CA7396A68D541C85D26508E83_1698764210;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_755226179 = varB4EAC82CA7396A68D541C85D26508E83_1114776911;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_755226179 = varB4EAC82CA7396A68D541C85D26508E83_1354979031;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_755226179.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_755226179;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.398 -0400", hash_original_method = "5F33BE6BAAB2ADDEB5EF1D1748825E7B", hash_generated_method = "F342C301CFD74FF8DE37D60FE820C28C")
        public boolean equals(
            Object anObject) {
            {
                boolean varDDF650371899A44735E1E943193361F5_959307415 = (anObject == this);
            } 
            ECCurve.F2m other = (ECCurve.F2m)anObject;
            boolean varDF9613A8AC9951FE2881D381E8399C1A_1160623152 = ((this.m == other.m) && (this.k1 == other.k1)
                && (this.k2 == other.k2) && (this.k3 == other.k3)
                && a.equals(other.a) && b.equals(other.b));
            addTaint(anObject.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_902911396 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_902911396;
            
            
            
                
            
            
            
                
            
            
            
                
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.399 -0400", hash_original_method = "E92144A56D15AF334E01FB92437AD76B", hash_generated_method = "4DE811C4A0EC5A74033ECC3E69F048F0")
        public int hashCode() {
            int varCEDF45682C77802F189E014D3E26DA89_1206416528 = (this.a.hashCode() ^ this.b.hashCode() ^ m ^ k1 ^ k2 ^ k3);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073931016 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073931016;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.401 -0400", hash_original_method = "2FA087881284515E1CE9CA954B1F01D0", hash_generated_method = "5A8D1AAF3406E3D2E83251CFD621F043")
        public int getM() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391640237 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391640237;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.402 -0400", hash_original_method = "0A21FBE14C3CF35BF18E601EA9469DB4", hash_generated_method = "9378F190832B36583357CAD1576E0FE3")
        public boolean isTrinomial() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918184983 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918184983;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.403 -0400", hash_original_method = "6F5E01D9EB3F8F69F3EDFAB71A89E9BA", hash_generated_method = "1A4A01F3A76EBA673098C8748EB8FEF3")
        public int getK1() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428432301 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428432301;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.404 -0400", hash_original_method = "39AC234DC3848032A728401BC68DF439", hash_generated_method = "B6F618E5C348783D2DAB3566994878B7")
        public int getK2() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110368189 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110368189;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.405 -0400", hash_original_method = "A40D42566F753B213E5F7F205217D7F1", hash_generated_method = "B223CF3280B4E5F3203283825D780640")
        public int getK3() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015900358 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015900358;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.408 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "838935F59543267FF45DB1FC360D0F4B")
        public BigInteger getN() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_140182911 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_140182911 = n;
            varB4EAC82CA7396A68D541C85D26508E83_140182911.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_140182911;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.408 -0400", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "6CF972CA258D7D030944383F6286B067")
        public BigInteger getH() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_729485439 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_729485439 = h;
            varB4EAC82CA7396A68D541C85D26508E83_729485439.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_729485439;
            
            
        }

        
    }


    
}

