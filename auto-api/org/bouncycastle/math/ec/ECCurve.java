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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.115 -0400", hash_original_field = "0CC175B9C0F1B6A831C399E269772661", hash_generated_field = "16F3809D308EE3B5C0D90855C77B94DD")

    ECFieldElement a;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.115 -0400", hash_original_field = "92EB5FFEE6AE2FEC3AD71C777531578F", hash_generated_field = "2E1C114DB6D3D5AFAFE6B5C7A24A4397")

    ECFieldElement b;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.115 -0400", hash_original_method = "3ADB63016220614BC8D776351AA4CC0A", hash_generated_method = "3ADB63016220614BC8D776351AA4CC0A")
    public ECCurve ()
    {
        //Synthesized constructor
    }


    public abstract int getFieldSize();

    
    public abstract ECFieldElement fromBigInteger(BigInteger x);

    
    public abstract ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression);

    
    public abstract ECPoint decodePoint(byte[] encoded);

    
    public abstract ECPoint getInfinity();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.117 -0400", hash_original_method = "E518DFD3A1B52E4C2FA641AF9C8BD0EA", hash_generated_method = "FF69E70F0197014DD8791FFE9BBD9BA6")
    public ECFieldElement getA() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1977833567 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1977833567 = a;
        varB4EAC82CA7396A68D541C85D26508E83_1977833567.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1977833567;
        // ---------- Original Method ----------
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.117 -0400", hash_original_method = "E3D5F4BB1EEF47030E7E58DC1A7D0CBC", hash_generated_method = "C114FF4D3ACA0FCA55F95C693DE3EED4")
    public ECFieldElement getB() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1011692998 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1011692998 = b;
        varB4EAC82CA7396A68D541C85D26508E83_1011692998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1011692998;
        // ---------- Original Method ----------
        //return b;
    }

    
    public static class Fp extends ECCurve {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.117 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "F819999E3B2036A19089F4FD0B5D94F4")

        BigInteger q;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.117 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "69A238B6B16C69E09404578CE64545C8")

        ECPoint.Fp infinity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.125 -0400", hash_original_method = "22B1E0FEEF98DB62B3F95091656AE119", hash_generated_method = "C63CCCEBA39E46BA85FB153D6F663EFC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.125 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "445DE3AD8D477EE7CB91855AB4647448")
        public BigInteger getQ() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_275234251 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_275234251 = q;
            varB4EAC82CA7396A68D541C85D26508E83_275234251.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_275234251;
            // ---------- Original Method ----------
            //return q;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.183 -0400", hash_original_method = "B586F82D19D11BCE8142121499961CE9", hash_generated_method = "C720111D87CA0EA0432E4095A710A5C3")
        public int getFieldSize() {
            int varA151D78D1E2C09447CC56EDC4DA68901_1441630613 = (q.bitLength());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643878684 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643878684;
            // ---------- Original Method ----------
            //return q.bitLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.183 -0400", hash_original_method = "717FAD51B8C0866C7878DF981123AAA4", hash_generated_method = "9C0F171CF6CD50186F1556A20585CB8E")
        public ECFieldElement fromBigInteger(BigInteger x) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1196870336 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1196870336 = new ECFieldElement.Fp(this.q, x);
            addTaint(x.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1196870336.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1196870336;
            // ---------- Original Method ----------
            //return new ECFieldElement.Fp(this.q, x);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.184 -0400", hash_original_method = "E2F0508F86D70ECB95714B920D7ED166", hash_generated_method = "48ED37A46E88035E294D001EDD526BBA")
        public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1408983815 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1408983815 = new ECPoint.Fp(this, fromBigInteger(x), fromBigInteger(y), withCompression);
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            addTaint(withCompression);
            varB4EAC82CA7396A68D541C85D26508E83_1408983815.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1408983815;
            // ---------- Original Method ----------
            //return new ECPoint.Fp(this, fromBigInteger(x), fromBigInteger(y), withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.186 -0400", hash_original_method = "1737D5EF0BE777F7A805235738F1CA68", hash_generated_method = "CD8EF5B7A6CC9A233DB4EC53B44BBCEA")
        public ECPoint decodePoint(byte[] encoded) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_755305790 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_755305790 = p;
            addTaint(encoded[0]);
            varB4EAC82CA7396A68D541C85D26508E83_755305790.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_755305790;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.186 -0400", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "759E612D19C9C4EFCB5544A826D79994")
        public ECPoint getInfinity() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1622080124 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1622080124 = infinity;
            varB4EAC82CA7396A68D541C85D26508E83_1622080124.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1622080124;
            // ---------- Original Method ----------
            //return infinity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.187 -0400", hash_original_method = "937E7F8C7D7C20805F9F2153639BF5E3", hash_generated_method = "B6F1F8E4CE97F638E25B262B2CE944AA")
        public boolean equals(
            Object anObject) {
            {
                boolean varDDF650371899A44735E1E943193361F5_894640481 = (anObject == this);
            } //End collapsed parenthetic
            ECCurve.Fp other;
            other = (ECCurve.Fp) anObject;
            boolean varA05429A3F1E17A3F73EAEAFC61009686_239386715 = (this.q.equals(other.q) 
                    && a.equals(other.a) && b.equals(other.b));
            addTaint(anObject.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199540080 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_199540080;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.187 -0400", hash_original_method = "0595BFE04038932B73D34C7D5BF16F78", hash_generated_method = "F3CD3068FDB69299B674D13EA8BE49EF")
        public int hashCode() {
            int varE700A94E94A70FE59B4AEED0B662AD32_1011253806 = (a.hashCode() ^ b.hashCode() ^ q.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694029576 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694029576;
            // ---------- Original Method ----------
            //return a.hashCode() ^ b.hashCode() ^ q.hashCode();
        }

        
    }


    
    public static class F2m extends ECCurve {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.187 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

        private int m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.192 -0400", hash_original_field = "B637B17AF08ACED8850C18CCCDE915DA", hash_generated_field = "82BC5D885288BEA8F058C8200E42732B")

        private int k1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.193 -0400", hash_original_field = "61620957A1443C946A143CF99A7D24FA", hash_generated_field = "9A9BABB98FA71DB4E862A96C38A0DEB5")

        private int k2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.193 -0400", hash_original_field = "F7AB469D1DC79166FC874DADCC0DD854", hash_generated_field = "B93297072479995D07A6DAC48610EF09")

        private int k3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.193 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "28997BC83DA18A620109895922F10617")

        private BigInteger n;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.193 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

        private BigInteger h;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.193 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "3F0371905D46A3DF93ACA58D05B01E9C")

        private ECPoint.F2m infinity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.193 -0400", hash_original_field = "5C77EC7DAADCE22A1213046881A54B40", hash_generated_field = "FF1108A0424E980F296A774C118EF5E8")

        private byte mu = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.193 -0400", hash_original_field = "9A98A235BB28BA556F2A8960F7A384A8", hash_generated_field = "4DD43C8E43FDD8E564AAA02789FAC70C")

        private BigInteger[] si = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.193 -0400", hash_original_method = "DEC52BA66274A72254EB3F42E643013D", hash_generated_method = "6984139A7A57FF50A2A61A86AD94648F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.193 -0400", hash_original_method = "F2139B4AB6C86388E7E3C9323DB40384", hash_generated_method = "DCC36A83DB40CAA11C9DBFA7709D179D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.194 -0400", hash_original_method = "5E11630AFDD86B3E6F25DD938FDF4713", hash_generated_method = "DA963AC6EE1FFE2B8DA76B3B5A2F8648")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.195 -0400", hash_original_method = "DFE62FA9A40BB48176925A509A87D7E7", hash_generated_method = "B1C41978F7997A7962EB33450E4544D4")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.195 -0400", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "B279EB80E8BB9F653D24C8636D534266")
        public int getFieldSize() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089231058 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089231058;
            // ---------- Original Method ----------
            //return m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.196 -0400", hash_original_method = "7AF48CB12A1921AAC7C154231A16AA21", hash_generated_method = "21FD9853396F227EF6199D3236A9D4AE")
        public ECFieldElement fromBigInteger(BigInteger x) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1862833983 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1862833983 = new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
            addTaint(x.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1862833983.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1862833983;
            // ---------- Original Method ----------
            //return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.196 -0400", hash_original_method = "166EA7512C9A204978606C53F7DDDB4A", hash_generated_method = "A4CC56E0F0625D48106FBA2043FECED0")
        public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1871895373 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1871895373 = new ECPoint.F2m(this, fromBigInteger(x), fromBigInteger(y), withCompression);
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            addTaint(withCompression);
            varB4EAC82CA7396A68D541C85D26508E83_1871895373.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1871895373;
            // ---------- Original Method ----------
            //return new ECPoint.F2m(this, fromBigInteger(x), fromBigInteger(y), withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.201 -0400", hash_original_method = "3A440A2E6AC052FD5047F5B01472DA22", hash_generated_method = "9290C292B1E3EC788521FBD88D700A22")
        public ECPoint decodePoint(byte[] encoded) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_785066608 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_785066608 = p;
            addTaint(encoded[0]);
            varB4EAC82CA7396A68D541C85D26508E83_785066608.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_785066608;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.208 -0400", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "22A64ED6A9F2C3717F8B7470532F1989")
        public ECPoint getInfinity() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_83689339 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_83689339 = infinity;
            varB4EAC82CA7396A68D541C85D26508E83_83689339.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_83689339;
            // ---------- Original Method ----------
            //return infinity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.208 -0400", hash_original_method = "0873B9ADE54853DB8C371F01782A1B9E", hash_generated_method = "CEC86E350641A03CAD277E1BE0922021")
        public boolean isKoblitz() {
            boolean var7A6C9BC264E548EC56E3F73CB401F2AE_170594749 = (((n != null) && (h != null) &&
                    ((a.toBigInteger().equals(ECConstants.ZERO)) ||
                    (a.toBigInteger().equals(ECConstants.ONE))) &&
                    (b.toBigInteger().equals(ECConstants.ONE))));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1237582560 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1237582560;
            // ---------- Original Method ----------
            //return ((n != null) && (h != null) &&
                    //((a.toBigInteger().equals(ECConstants.ZERO)) ||
                    //(a.toBigInteger().equals(ECConstants.ONE))) &&
                    //(b.toBigInteger().equals(ECConstants.ONE)));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.209 -0400", hash_original_method = "6A47B833A38B2C51AF1636CDFCEB3B55", hash_generated_method = "FD012BFD311669B80FE1E915D71FE70E")
        synchronized byte getMu() {
            {
                mu = Tnaf.getMu(this);
            } //End block
            byte var40EA57D3EE3C07BF1C102B466E1C3091_832588280 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_832588280;
            // ---------- Original Method ----------
            //if (mu == 0)
            //{
                //mu = Tnaf.getMu(this);
            //}
            //return mu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.209 -0400", hash_original_method = "C02001236D393BDCA3D2D65CC0F3FCD6", hash_generated_method = "4F5A574C4172A97D50FC192C516349C1")
        synchronized BigInteger[] getSi() {
            BigInteger[] varB4EAC82CA7396A68D541C85D26508E83_1540058856 = null; //Variable for return #1
            {
                si = Tnaf.getSi(this);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1540058856 = si;
            varB4EAC82CA7396A68D541C85D26508E83_1540058856.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1540058856;
            // ---------- Original Method ----------
            //if (si == null)
            //{
                //si = Tnaf.getSi(this);
            //}
            //return si;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.226 -0400", hash_original_method = "ABCDD5682443273B6E9EF7110AFEAA10", hash_generated_method = "8A928961F2547EA3F28E4E3CC0EFD6F9")
        private ECPoint decompressPoint(
            byte[] xEnc, 
            int ypBit) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_71180562 = null; //Variable for return #1
            ECFieldElement xp;
            xp = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, new BigInteger(1, xEnc));
            ECFieldElement yp;
            yp = null;
            {
                boolean varC072E047DAA030A92F785F9995B84EFE_1621772369 = (xp.toBigInteger().equals(ECConstants.ZERO));
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
                        boolean var584500F14C5C32181BBFF11166A2781E_1573221675 = (z.toBigInteger().testBit(0));
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
            varB4EAC82CA7396A68D541C85D26508E83_71180562 = new ECPoint.F2m(this, xp, yp);
            addTaint(xEnc[0]);
            addTaint(ypBit);
            varB4EAC82CA7396A68D541C85D26508E83_71180562.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_71180562;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.228 -0400", hash_original_method = "25ED10C579C6ED4884A834D5A2CEB482", hash_generated_method = "60C590582F614679B8F033BC6EA52C54")
        private ECFieldElement solveQuadradicEquation(ECFieldElement beta) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1272584755 = null; //Variable for return #1
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_464377372 = null; //Variable for return #2
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1512929979 = null; //Variable for return #3
            ECFieldElement zeroElement;
            zeroElement = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, ECConstants.ZERO);
            {
                boolean var8E624E2CB7B76E196F1A3B3E4E14BFB1_679794979 = (beta.toBigInteger().equals(ECConstants.ZERO));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1272584755 = zeroElement;
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
                    boolean var1F5A575FD8B96856949BBB9072892017_1449858012 = (!w.toBigInteger().equals(ECConstants.ZERO));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_464377372 = null;
                    } //End block
                } //End collapsed parenthetic
                gamma = z.square().add(z);
            } //End block
            {
                boolean var3737DC55BBBC931D31E5C79A85F192CA_1630724536 = (gamma.toBigInteger().equals(ECConstants.ZERO));
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1512929979 = z;
            addTaint(beta.getTaint());
            ECFieldElement varA7E53CE21691AB073D9660D615818899_1134596079; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1134596079 = varB4EAC82CA7396A68D541C85D26508E83_1272584755;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1134596079 = varB4EAC82CA7396A68D541C85D26508E83_464377372;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1134596079 = varB4EAC82CA7396A68D541C85D26508E83_1512929979;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1134596079.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1134596079;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.233 -0400", hash_original_method = "5F33BE6BAAB2ADDEB5EF1D1748825E7B", hash_generated_method = "74B2E1B5F4D1A5218FCFEDA2E138B0BE")
        public boolean equals(
            Object anObject) {
            {
                boolean varDDF650371899A44735E1E943193361F5_424140495 = (anObject == this);
            } //End collapsed parenthetic
            ECCurve.F2m other;
            other = (ECCurve.F2m)anObject;
            boolean varDF9613A8AC9951FE2881D381E8399C1A_1365037467 = ((this.m == other.m) && (this.k1 == other.k1)
                && (this.k2 == other.k2) && (this.k3 == other.k3)
                && a.equals(other.a) && b.equals(other.b));
            addTaint(anObject.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2003640724 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2003640724;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.233 -0400", hash_original_method = "E92144A56D15AF334E01FB92437AD76B", hash_generated_method = "D3759B28622303C1C835FDAEB1461212")
        public int hashCode() {
            int varCEDF45682C77802F189E014D3E26DA89_1760392554 = (this.a.hashCode() ^ this.b.hashCode() ^ m ^ k1 ^ k2 ^ k3);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798438142 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798438142;
            // ---------- Original Method ----------
            //return this.a.hashCode() ^ this.b.hashCode() ^ m ^ k1 ^ k2 ^ k3;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.233 -0400", hash_original_method = "2FA087881284515E1CE9CA954B1F01D0", hash_generated_method = "D429736D52F67D7824F8276653D5C738")
        public int getM() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712795291 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712795291;
            // ---------- Original Method ----------
            //return m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.246 -0400", hash_original_method = "0A21FBE14C3CF35BF18E601EA9469DB4", hash_generated_method = "1F5A72766E9A6A73F5CD995141BA36C4")
        public boolean isTrinomial() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1969244172 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1969244172;
            // ---------- Original Method ----------
            //return k2 == 0 && k3 == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.247 -0400", hash_original_method = "6F5E01D9EB3F8F69F3EDFAB71A89E9BA", hash_generated_method = "B8B778381F3B7B8615AFCCD2D7C5CE7E")
        public int getK1() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500553723 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500553723;
            // ---------- Original Method ----------
            //return k1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.247 -0400", hash_original_method = "39AC234DC3848032A728401BC68DF439", hash_generated_method = "94B82AFCECCDCBFCA9D2282D4DFCD17B")
        public int getK2() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475188324 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475188324;
            // ---------- Original Method ----------
            //return k2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.247 -0400", hash_original_method = "A40D42566F753B213E5F7F205217D7F1", hash_generated_method = "03B927C925BE04C5181F1E603B8AE138")
        public int getK3() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051043498 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051043498;
            // ---------- Original Method ----------
            //return k3;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.248 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "1FA68BA46C1075B05F06902202E3D91C")
        public BigInteger getN() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_68994502 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_68994502 = n;
            varB4EAC82CA7396A68D541C85D26508E83_68994502.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_68994502;
            // ---------- Original Method ----------
            //return n;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.248 -0400", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "DA7AFB5DD081EC12B3DA92FBCA40603E")
        public BigInteger getH() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_1831218617 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1831218617 = h;
            varB4EAC82CA7396A68D541C85D26508E83_1831218617.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1831218617;
            // ---------- Original Method ----------
            //return h;
        }

        
    }


    
}

