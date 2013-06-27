package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import java.util.Random;

public abstract class ECCurve {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.215 -0400", hash_original_field = "0CC175B9C0F1B6A831C399E269772661", hash_generated_field = "16F3809D308EE3B5C0D90855C77B94DD")

    ECFieldElement a;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.215 -0400", hash_original_field = "92EB5FFEE6AE2FEC3AD71C777531578F", hash_generated_field = "2E1C114DB6D3D5AFAFE6B5C7A24A4397")

    ECFieldElement b;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.215 -0400", hash_original_method = "3ADB63016220614BC8D776351AA4CC0A", hash_generated_method = "3ADB63016220614BC8D776351AA4CC0A")
    public ECCurve ()
    {
        //Synthesized constructor
    }


    public abstract int getFieldSize();

    
    public abstract ECFieldElement fromBigInteger(BigInteger x);

    
    public abstract ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression);

    
    public abstract ECPoint decodePoint(byte[] encoded);

    
    public abstract ECPoint getInfinity();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.217 -0400", hash_original_method = "E518DFD3A1B52E4C2FA641AF9C8BD0EA", hash_generated_method = "B3FB8BD5983DAD42B32F4681E58BB2D7")
    public ECFieldElement getA() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1231416745 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1231416745 = a;
        varB4EAC82CA7396A68D541C85D26508E83_1231416745.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1231416745;
        // ---------- Original Method ----------
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.217 -0400", hash_original_method = "E3D5F4BB1EEF47030E7E58DC1A7D0CBC", hash_generated_method = "899C3C3CE40BBD03C8CFCDE417D4CE89")
    public ECFieldElement getB() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1352156818 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1352156818 = b;
        varB4EAC82CA7396A68D541C85D26508E83_1352156818.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1352156818;
        // ---------- Original Method ----------
        //return b;
    }

    
    public static class Fp extends ECCurve {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.217 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "F819999E3B2036A19089F4FD0B5D94F4")

        BigInteger q;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.218 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "69A238B6B16C69E09404578CE64545C8")

        ECPoint.Fp infinity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.225 -0400", hash_original_method = "22B1E0FEEF98DB62B3F95091656AE119", hash_generated_method = "C63CCCEBA39E46BA85FB153D6F663EFC")
        public  Fp(BigInteger q, BigInteger a, BigInteger b) {
            this.q = q;
            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.infinity = new ECPoint.Fp(this, null, null);
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            // ---------- Original Method ----------
            //this.q = q;
            //this.a = fromBigInteger(a);
            //this.b = fromBigInteger(b);
            //this.infinity = new ECPoint.Fp(this, null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.226 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "3769B2122C8C9E7622701EAC55BDE2C7")
        public BigInteger getQ() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_1189630908 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1189630908 = q;
            varB4EAC82CA7396A68D541C85D26508E83_1189630908.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1189630908;
            // ---------- Original Method ----------
            //return q;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.226 -0400", hash_original_method = "B586F82D19D11BCE8142121499961CE9", hash_generated_method = "5E9110CA08BDCD6B1A29788982A567C7")
        public int getFieldSize() {
            int varA151D78D1E2C09447CC56EDC4DA68901_292623304 = (q.bitLength());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69281344 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69281344;
            // ---------- Original Method ----------
            //return q.bitLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.234 -0400", hash_original_method = "717FAD51B8C0866C7878DF981123AAA4", hash_generated_method = "0481DDFC8F91C86730D94A75D788763E")
        public ECFieldElement fromBigInteger(BigInteger x) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_2097892412 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2097892412 = new ECFieldElement.Fp(this.q, x);
            addTaint(x.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2097892412.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2097892412;
            // ---------- Original Method ----------
            //return new ECFieldElement.Fp(this.q, x);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.234 -0400", hash_original_method = "E2F0508F86D70ECB95714B920D7ED166", hash_generated_method = "AA6A739FF70DEE1EB01C1E26709D4458")
        public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1652181231 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1652181231 = new ECPoint.Fp(this, fromBigInteger(x), fromBigInteger(y), withCompression);
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            addTaint(withCompression);
            varB4EAC82CA7396A68D541C85D26508E83_1652181231.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1652181231;
            // ---------- Original Method ----------
            //return new ECPoint.Fp(this, fromBigInteger(x), fromBigInteger(y), withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.238 -0400", hash_original_method = "1737D5EF0BE777F7A805235738F1CA68", hash_generated_method = "6BB747822BEC0A35E2C14BCD9A496B20")
        public ECPoint decodePoint(byte[] encoded) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_279237327 = null; //Variable for return #1
            ECPoint p;
            p = null;
            //Begin case 0x00 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point encoding");
            } //End block
            //End case 0x00 
            //Begin case 0x00 
            p = getInfinity();
            //End case 0x00 
            //Begin case 0x02 0x03 
            int ytilde;
            ytilde = encoded[0] & 1;
            //End case 0x02 0x03 
            //Begin case 0x02 0x03 
            byte[] i;
            i = new byte[encoded.length - 1];
            //End case 0x02 0x03 
            //Begin case 0x02 0x03 
            System.arraycopy(encoded, 1, i, 0, i.length);
            //End case 0x02 0x03 
            //Begin case 0x02 0x03 
            ECFieldElement x;
            x = new ECFieldElement.Fp(this.q, new BigInteger(1, i));
            //End case 0x02 0x03 
            //Begin case 0x02 0x03 
            ECFieldElement alpha;
            alpha = x.multiply(x.square().add(a)).add(b);
            //End case 0x02 0x03 
            //Begin case 0x02 0x03 
            ECFieldElement beta;
            beta = alpha.sqrt();
            //End case 0x02 0x03 
            //Begin case 0x02 0x03 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point compression");
            } //End block
            //End case 0x02 0x03 
            //Begin case 0x02 0x03 
            int bit0;
            bit0 = (beta.toBigInteger().testBit(0) ? 1 : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
            //End case 0x02 0x03 
            //Begin case 0x02 0x03 
            {
                p = new ECPoint.Fp(this, x, beta, true);
            } //End block
            {
                p = new ECPoint.Fp(this, x,
                        new ECFieldElement.Fp(this.q, q.subtract(beta.toBigInteger())), true);
            } //End block
            //End case 0x02 0x03 
            //Begin case 0x04 0x06 0x07 
            byte[] xEnc;
            xEnc = new byte[(encoded.length - 1) / 2];
            //End case 0x04 0x06 0x07 
            //Begin case 0x04 0x06 0x07 
            byte[] yEnc;
            yEnc = new byte[(encoded.length - 1) / 2];
            //End case 0x04 0x06 0x07 
            //Begin case 0x04 0x06 0x07 
            System.arraycopy(encoded, 1, xEnc, 0, xEnc.length);
            //End case 0x04 0x06 0x07 
            //Begin case 0x04 0x06 0x07 
            System.arraycopy(encoded, xEnc.length + 1, yEnc, 0, yEnc.length);
            //End case 0x04 0x06 0x07 
            //Begin case 0x04 0x06 0x07 
            p = new ECPoint.Fp(this,
                        new ECFieldElement.Fp(this.q, new BigInteger(1, xEnc)),
                        new ECFieldElement.Fp(this.q, new BigInteger(1, yEnc)));
            //End case 0x04 0x06 0x07 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(encoded[0], 16));
            //End case default 
            varB4EAC82CA7396A68D541C85D26508E83_279237327 = p;
            addTaint(encoded[0]);
            varB4EAC82CA7396A68D541C85D26508E83_279237327.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_279237327;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.238 -0400", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "4779CA78608C2BD9A98FED2AB5912D2E")
        public ECPoint getInfinity() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_430498573 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_430498573 = infinity;
            varB4EAC82CA7396A68D541C85D26508E83_430498573.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_430498573;
            // ---------- Original Method ----------
            //return infinity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.239 -0400", hash_original_method = "937E7F8C7D7C20805F9F2153639BF5E3", hash_generated_method = "D3658F4CC6FA7FE52D6D5BAE1B7638C9")
        public boolean equals(
            Object anObject) {
            {
                boolean varDDF650371899A44735E1E943193361F5_1866841884 = (anObject == this);
            } //End collapsed parenthetic
            ECCurve.Fp other;
            other = (ECCurve.Fp) anObject;
            boolean varA05429A3F1E17A3F73EAEAFC61009686_1076697576 = (this.q.equals(other.q) 
                    && a.equals(other.a) && b.equals(other.b));
            addTaint(anObject.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_927919936 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_927919936;
            // ---------- Original Method ----------
            //if (anObject == this) 
            //{
                //return true;
            //}
            //if (!(anObject instanceof ECCurve.Fp)) 
            //{
                //return false;
            //}
            //ECCurve.Fp other = (ECCurve.Fp) anObject;
            //return this.q.equals(other.q) 
                    //&& a.equals(other.a) && b.equals(other.b);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.242 -0400", hash_original_method = "0595BFE04038932B73D34C7D5BF16F78", hash_generated_method = "AFD5E596E2DBE4E35F37FBEB26ABAA0A")
        public int hashCode() {
            int varE700A94E94A70FE59B4AEED0B662AD32_1336777305 = (a.hashCode() ^ b.hashCode() ^ q.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1957199684 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1957199684;
            // ---------- Original Method ----------
            //return a.hashCode() ^ b.hashCode() ^ q.hashCode();
        }

        
    }


    
    public static class F2m extends ECCurve {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.242 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

        private int m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.242 -0400", hash_original_field = "B637B17AF08ACED8850C18CCCDE915DA", hash_generated_field = "82BC5D885288BEA8F058C8200E42732B")

        private int k1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.242 -0400", hash_original_field = "61620957A1443C946A143CF99A7D24FA", hash_generated_field = "9A9BABB98FA71DB4E862A96C38A0DEB5")

        private int k2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.242 -0400", hash_original_field = "F7AB469D1DC79166FC874DADCC0DD854", hash_generated_field = "B93297072479995D07A6DAC48610EF09")

        private int k3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.242 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "28997BC83DA18A620109895922F10617")

        private BigInteger n;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.242 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

        private BigInteger h;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.242 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "3F0371905D46A3DF93ACA58D05B01E9C")

        private ECPoint.F2m infinity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.242 -0400", hash_original_field = "5C77EC7DAADCE22A1213046881A54B40", hash_generated_field = "FF1108A0424E980F296A774C118EF5E8")

        private byte mu = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.242 -0400", hash_original_field = "9A98A235BB28BA556F2A8960F7A384A8", hash_generated_field = "4DD43C8E43FDD8E564AAA02789FAC70C")

        private BigInteger[] si = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.243 -0400", hash_original_method = "DEC52BA66274A72254EB3F42E643013D", hash_generated_method = "6984139A7A57FF50A2A61A86AD94648F")
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
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.251 -0400", hash_original_method = "F2139B4AB6C86388E7E3C9323DB40384", hash_generated_method = "DCC36A83DB40CAA11C9DBFA7709D179D")
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
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.251 -0400", hash_original_method = "5E11630AFDD86B3E6F25DD938FDF4713", hash_generated_method = "DA963AC6EE1FFE2B8DA76B3B5A2F8648")
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
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.257 -0400", hash_original_method = "DFE62FA9A40BB48176925A509A87D7E7", hash_generated_method = "B1C41978F7997A7962EB33450E4544D4")
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
            } //End block
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                } //End block
            } //End block
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("k2 must be > k1");
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("k3 must be > k2");
                } //End block
            } //End block
            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.infinity = new ECPoint.F2m(this, null, null);
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.258 -0400", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "989BDAD56B76E5F074221D21731A0C8B")
        public int getFieldSize() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1716679971 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1716679971;
            // ---------- Original Method ----------
            //return m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.263 -0400", hash_original_method = "7AF48CB12A1921AAC7C154231A16AA21", hash_generated_method = "439BD640FB80C6870882E1946C242F8E")
        public ECFieldElement fromBigInteger(BigInteger x) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1903654763 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1903654763 = new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
            addTaint(x.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1903654763.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1903654763;
            // ---------- Original Method ----------
            //return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.264 -0400", hash_original_method = "166EA7512C9A204978606C53F7DDDB4A", hash_generated_method = "6638E5D54395A2BAB1415DB6019493B0")
        public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1089819741 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1089819741 = new ECPoint.F2m(this, fromBigInteger(x), fromBigInteger(y), withCompression);
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            addTaint(withCompression);
            varB4EAC82CA7396A68D541C85D26508E83_1089819741.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1089819741;
            // ---------- Original Method ----------
            //return new ECPoint.F2m(this, fromBigInteger(x), fromBigInteger(y), withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.270 -0400", hash_original_method = "3A440A2E6AC052FD5047F5B01472DA22", hash_generated_method = "E0600D6B2253A2F9BEA89C6C92343E99")
        public ECPoint decodePoint(byte[] encoded) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1075214947 = null; //Variable for return #1
            ECPoint p;
            p = null;
            //Begin case 0x00 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point encoding");
            } //End block
            //End case 0x00 
            //Begin case 0x00 
            p = getInfinity();
            //End case 0x00 
            //Begin case 0x02 0x03 
            byte[] enc;
            enc = new byte[encoded.length - 1];
            //End case 0x02 0x03 
            //Begin case 0x02 0x03 
            System.arraycopy(encoded, 1, enc, 0, enc.length);
            //End case 0x02 0x03 
            //Begin case 0x02 0x03 
            {
                p = decompressPoint(enc, 0);
            } //End block
            {
                p = decompressPoint(enc, 1);
            } //End block
            //End case 0x02 0x03 
            //Begin case 0x04 0x06 0x07 
            byte[] xEnc;
            xEnc = new byte[(encoded.length - 1) / 2];
            //End case 0x04 0x06 0x07 
            //Begin case 0x04 0x06 0x07 
            byte[] yEnc;
            yEnc = new byte[(encoded.length - 1) / 2];
            //End case 0x04 0x06 0x07 
            //Begin case 0x04 0x06 0x07 
            System.arraycopy(encoded, 1, xEnc, 0, xEnc.length);
            //End case 0x04 0x06 0x07 
            //Begin case 0x04 0x06 0x07 
            System.arraycopy(encoded, xEnc.length + 1, yEnc, 0, yEnc.length);
            //End case 0x04 0x06 0x07 
            //Begin case 0x04 0x06 0x07 
            p = new ECPoint.F2m(this,
                    new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3,
                        new BigInteger(1, xEnc)),
                    new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3,
                        new BigInteger(1, yEnc)), false);
            //End case 0x04 0x06 0x07 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(encoded[0], 16));
            //End case default 
            varB4EAC82CA7396A68D541C85D26508E83_1075214947 = p;
            addTaint(encoded[0]);
            varB4EAC82CA7396A68D541C85D26508E83_1075214947.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1075214947;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.271 -0400", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "3D7232519E7E7593B1A791E9F7CED238")
        public ECPoint getInfinity() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1064687754 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1064687754 = infinity;
            varB4EAC82CA7396A68D541C85D26508E83_1064687754.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1064687754;
            // ---------- Original Method ----------
            //return infinity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.276 -0400", hash_original_method = "0873B9ADE54853DB8C371F01782A1B9E", hash_generated_method = "219B1DBFAF47801078121A9CF9435A6F")
        public boolean isKoblitz() {
            boolean var7A6C9BC264E548EC56E3F73CB401F2AE_2075585333 = (((n != null) && (h != null) &&
                    ((a.toBigInteger().equals(ECConstants.ZERO)) ||
                    (a.toBigInteger().equals(ECConstants.ONE))) &&
                    (b.toBigInteger().equals(ECConstants.ONE))));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1894976605 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1894976605;
            // ---------- Original Method ----------
            //return ((n != null) && (h != null) &&
                    //((a.toBigInteger().equals(ECConstants.ZERO)) ||
                    //(a.toBigInteger().equals(ECConstants.ONE))) &&
                    //(b.toBigInteger().equals(ECConstants.ONE)));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.276 -0400", hash_original_method = "6A47B833A38B2C51AF1636CDFCEB3B55", hash_generated_method = "C757D8135F4CFE3A5535586AFB6DA82B")
        synchronized byte getMu() {
            {
                mu = Tnaf.getMu(this);
            } //End block
            byte var40EA57D3EE3C07BF1C102B466E1C3091_60773571 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_60773571;
            // ---------- Original Method ----------
            //if (mu == 0)
            //{
                //mu = Tnaf.getMu(this);
            //}
            //return mu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.277 -0400", hash_original_method = "C02001236D393BDCA3D2D65CC0F3FCD6", hash_generated_method = "48CFCE335C70F120F4B42A32B8A047C4")
        synchronized BigInteger[] getSi() {
            BigInteger[] varB4EAC82CA7396A68D541C85D26508E83_1414647741 = null; //Variable for return #1
            {
                si = Tnaf.getSi(this);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1414647741 = si;
            varB4EAC82CA7396A68D541C85D26508E83_1414647741.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1414647741;
            // ---------- Original Method ----------
            //if (si == null)
            //{
                //si = Tnaf.getSi(this);
            //}
            //return si;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.279 -0400", hash_original_method = "ABCDD5682443273B6E9EF7110AFEAA10", hash_generated_method = "1316BC1FD53F02560290A020252A9938")
        private ECPoint decompressPoint(
            byte[] xEnc, 
            int ypBit) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_2049187721 = null; //Variable for return #1
            ECFieldElement xp;
            xp = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, new BigInteger(1, xEnc));
            ECFieldElement yp;
            yp = null;
            {
                boolean varC072E047DAA030A92F785F9995B84EFE_1285951096 = (xp.toBigInteger().equals(ECConstants.ZERO));
                {
                    yp = (ECFieldElement.F2m)b;
                    {
                        int i;
                        i = 0;
                        {
                            yp = yp.square();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    ECFieldElement beta;
                    beta = xp.add(a).add(
                        b.multiply(xp.square().invert()));
                    ECFieldElement z;
                    z = solveQuadradicEquation(beta);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid point compression");
                    } //End block
                    int zBit;
                    zBit = 0;
                    {
                        boolean var584500F14C5C32181BBFF11166A2781E_1695292364 = (z.toBigInteger().testBit(0));
                        {
                            zBit = 1;
                        } //End block
                    } //End collapsed parenthetic
                    {
                        z = z.add(new ECFieldElement.F2m(this.m, this.k1, this.k2,
                            this.k3, ECConstants.ONE));
                    } //End block
                    yp = xp.multiply(z);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_2049187721 = new ECPoint.F2m(this, xp, yp);
            addTaint(xEnc[0]);
            addTaint(ypBit);
            varB4EAC82CA7396A68D541C85D26508E83_2049187721.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2049187721;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.280 -0400", hash_original_method = "25ED10C579C6ED4884A834D5A2CEB482", hash_generated_method = "FC8A52829F5379E8E24E5ED5C9EB6314")
        private ECFieldElement solveQuadradicEquation(ECFieldElement beta) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_2087489999 = null; //Variable for return #1
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1937473711 = null; //Variable for return #2
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1615183665 = null; //Variable for return #3
            ECFieldElement zeroElement;
            zeroElement = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, ECConstants.ZERO);
            {
                boolean var8E624E2CB7B76E196F1A3B3E4E14BFB1_1054958765 = (beta.toBigInteger().equals(ECConstants.ZERO));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2087489999 = zeroElement;
                } //End block
            } //End collapsed parenthetic
            ECFieldElement z;
            z = null;
            ECFieldElement gamma;
            gamma = zeroElement;
            Random rand;
            rand = new Random();
            {
                ECFieldElement t;
                t = new ECFieldElement.F2m(this.m, this.k1,
                        this.k2, this.k3, new BigInteger(m, rand));
                z = zeroElement;
                ECFieldElement w;
                w = beta;
                {
                    int i;
                    i = 1;
                    {
                        ECFieldElement w2;
                        w2 = w.square();
                        z = z.square().add(w2.multiply(t));
                        w = w2.add(beta);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var1F5A575FD8B96856949BBB9072892017_1904880599 = (!w.toBigInteger().equals(ECConstants.ZERO));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1937473711 = null;
                    } //End block
                } //End collapsed parenthetic
                gamma = z.square().add(z);
            } //End block
            {
                boolean var3737DC55BBBC931D31E5C79A85F192CA_1337483571 = (gamma.toBigInteger().equals(ECConstants.ZERO));
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1615183665 = z;
            addTaint(beta.getTaint());
            ECFieldElement varA7E53CE21691AB073D9660D615818899_1334364059; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1334364059 = varB4EAC82CA7396A68D541C85D26508E83_2087489999;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1334364059 = varB4EAC82CA7396A68D541C85D26508E83_1937473711;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1334364059 = varB4EAC82CA7396A68D541C85D26508E83_1615183665;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1334364059.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1334364059;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.289 -0400", hash_original_method = "5F33BE6BAAB2ADDEB5EF1D1748825E7B", hash_generated_method = "FB6CE222C21FC4FD841D67EBAED02002")
        public boolean equals(
            Object anObject) {
            {
                boolean varDDF650371899A44735E1E943193361F5_431505842 = (anObject == this);
            } //End collapsed parenthetic
            ECCurve.F2m other;
            other = (ECCurve.F2m)anObject;
            boolean varDF9613A8AC9951FE2881D381E8399C1A_1242012699 = ((this.m == other.m) && (this.k1 == other.k1)
                && (this.k2 == other.k2) && (this.k3 == other.k3)
                && a.equals(other.a) && b.equals(other.b));
            addTaint(anObject.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467822951 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467822951;
            // ---------- Original Method ----------
            //if (anObject == this) 
            //{
                //return true;
            //}
            //if (!(anObject instanceof ECCurve.F2m)) 
            //{
                //return false;
            //}
            //ECCurve.F2m other = (ECCurve.F2m)anObject;
            //return (this.m == other.m) && (this.k1 == other.k1)
                //&& (this.k2 == other.k2) && (this.k3 == other.k3)
                //&& a.equals(other.a) && b.equals(other.b);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.290 -0400", hash_original_method = "E92144A56D15AF334E01FB92437AD76B", hash_generated_method = "552D21FA25812F8CF4980ABBEB42DCE3")
        public int hashCode() {
            int varCEDF45682C77802F189E014D3E26DA89_241377499 = (this.a.hashCode() ^ this.b.hashCode() ^ m ^ k1 ^ k2 ^ k3);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886475260 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886475260;
            // ---------- Original Method ----------
            //return this.a.hashCode() ^ this.b.hashCode() ^ m ^ k1 ^ k2 ^ k3;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.290 -0400", hash_original_method = "2FA087881284515E1CE9CA954B1F01D0", hash_generated_method = "E6E4C2C76A3CE0A670AE7652F2BBFC81")
        public int getM() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107201192 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107201192;
            // ---------- Original Method ----------
            //return m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.291 -0400", hash_original_method = "0A21FBE14C3CF35BF18E601EA9469DB4", hash_generated_method = "1AA2FDD35DB1DB519C04F66A7F9C11D7")
        public boolean isTrinomial() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691608578 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691608578;
            // ---------- Original Method ----------
            //return k2 == 0 && k3 == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.291 -0400", hash_original_method = "6F5E01D9EB3F8F69F3EDFAB71A89E9BA", hash_generated_method = "810298E47FE5433FDDD1F148D491F9A9")
        public int getK1() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515632691 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515632691;
            // ---------- Original Method ----------
            //return k1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.291 -0400", hash_original_method = "39AC234DC3848032A728401BC68DF439", hash_generated_method = "D8232AB5DD89DFA963658FAE4712DF06")
        public int getK2() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222204998 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222204998;
            // ---------- Original Method ----------
            //return k2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.291 -0400", hash_original_method = "A40D42566F753B213E5F7F205217D7F1", hash_generated_method = "C372ECAB909990B123112ED0F64B6482")
        public int getK3() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_729974207 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_729974207;
            // ---------- Original Method ----------
            //return k3;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.297 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "9E0FFBC9C1410CC173C8D11DB3AF7826")
        public BigInteger getN() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_477120192 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_477120192 = n;
            varB4EAC82CA7396A68D541C85D26508E83_477120192.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_477120192;
            // ---------- Original Method ----------
            //return n;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.297 -0400", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "0E118CA56FFF8599C4DECCC01ED26E2D")
        public BigInteger getH() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_339459888 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_339459888 = h;
            varB4EAC82CA7396A68D541C85D26508E83_339459888.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_339459888;
            // ---------- Original Method ----------
            //return h;
        }

        
    }


    
}

