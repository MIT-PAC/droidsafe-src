package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.util.Random;

public abstract class ECCurve {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.798 -0400", hash_original_field = "0CC175B9C0F1B6A831C399E269772661", hash_generated_field = "16F3809D308EE3B5C0D90855C77B94DD")

    ECFieldElement a;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.798 -0400", hash_original_field = "92EB5FFEE6AE2FEC3AD71C777531578F", hash_generated_field = "2E1C114DB6D3D5AFAFE6B5C7A24A4397")

    ECFieldElement b;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.798 -0400", hash_original_method = "3ADB63016220614BC8D776351AA4CC0A", hash_generated_method = "3ADB63016220614BC8D776351AA4CC0A")
    public ECCurve ()
    {
        //Synthesized constructor
    }


    public abstract int getFieldSize();

    
    public abstract ECFieldElement fromBigInteger(BigInteger x);

    
    public abstract ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression);

    
    public abstract ECPoint decodePoint(byte[] encoded);

    
    public abstract ECPoint getInfinity();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.800 -0400", hash_original_method = "E518DFD3A1B52E4C2FA641AF9C8BD0EA", hash_generated_method = "800C2321D0E8804E76AC0893DAD851D2")
    public ECFieldElement getA() {
ECFieldElement var3F5343BF1D849954A73F0BB303805FFD_376623100 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_376623100.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_376623100;
        // ---------- Original Method ----------
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.800 -0400", hash_original_method = "E3D5F4BB1EEF47030E7E58DC1A7D0CBC", hash_generated_method = "EB65D60617DA7FAF3152D543C4A86FDC")
    public ECFieldElement getB() {
ECFieldElement var73F89FAC8F369DF0913D10C37C1E0EA1_677114218 =         b;
        var73F89FAC8F369DF0913D10C37C1E0EA1_677114218.addTaint(taint);
        return var73F89FAC8F369DF0913D10C37C1E0EA1_677114218;
        // ---------- Original Method ----------
        //return b;
    }

    
    public static class Fp extends ECCurve {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.800 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "F819999E3B2036A19089F4FD0B5D94F4")

        BigInteger q;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.800 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "69A238B6B16C69E09404578CE64545C8")

        ECPoint.Fp infinity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.801 -0400", hash_original_method = "22B1E0FEEF98DB62B3F95091656AE119", hash_generated_method = "7846805D72ADC3FA3F6A4C0B21318F69")
        public  Fp(BigInteger q, BigInteger a, BigInteger b) {
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            this.q = q;
            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.infinity = new ECPoint.Fp(this, null, null);
            // ---------- Original Method ----------
            //this.q = q;
            //this.a = fromBigInteger(a);
            //this.b = fromBigInteger(b);
            //this.infinity = new ECPoint.Fp(this, null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.801 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "0036EDD4E205E9B93338B3A0EC1A3A8C")
        public BigInteger getQ() {
BigInteger varBEF1B7662E10AF6D5747729987514CB6_1187626092 =             q;
            varBEF1B7662E10AF6D5747729987514CB6_1187626092.addTaint(taint);
            return varBEF1B7662E10AF6D5747729987514CB6_1187626092;
            // ---------- Original Method ----------
            //return q;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.802 -0400", hash_original_method = "B586F82D19D11BCE8142121499961CE9", hash_generated_method = "B35FBAC6E86F2DDD921F1AA80BFFF9B5")
        public int getFieldSize() {
            int var0769037565AC374C9291621AA66E8145_2098927123 = (q.bitLength());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482692003 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482692003;
            // ---------- Original Method ----------
            //return q.bitLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.802 -0400", hash_original_method = "717FAD51B8C0866C7878DF981123AAA4", hash_generated_method = "FACF65AA930D1EDEFD315F2A8894D043")
        public ECFieldElement fromBigInteger(BigInteger x) {
            addTaint(x.getTaint());
ECFieldElement var9002094E05CF56420543DC9EAEAEF109_1629544581 =             new ECFieldElement.Fp(this.q, x);
            var9002094E05CF56420543DC9EAEAEF109_1629544581.addTaint(taint);
            return var9002094E05CF56420543DC9EAEAEF109_1629544581;
            // ---------- Original Method ----------
            //return new ECFieldElement.Fp(this.q, x);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.802 -0400", hash_original_method = "E2F0508F86D70ECB95714B920D7ED166", hash_generated_method = "A342B08554F76ABB7E96548CC8085FE3")
        public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
            addTaint(withCompression);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
ECPoint var6A2F883B690EF7F35DBD24DC6932AC49_1778243529 =             new ECPoint.Fp(this, fromBigInteger(x), fromBigInteger(y), withCompression);
            var6A2F883B690EF7F35DBD24DC6932AC49_1778243529.addTaint(taint);
            return var6A2F883B690EF7F35DBD24DC6932AC49_1778243529;
            // ---------- Original Method ----------
            //return new ECPoint.Fp(this, fromBigInteger(x), fromBigInteger(y), withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.804 -0400", hash_original_method = "1737D5EF0BE777F7A805235738F1CA68", hash_generated_method = "3AE8A925F187E86A7A54D99EAD3869BA")
        public ECPoint decodePoint(byte[] encoded) {
            addTaint(encoded[0]);
            ECPoint p = null;
switch(encoded[0]){
            case 0x00:
    if(encoded.length > 1)            
            {
                RuntimeException varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_1662370380 = new RuntimeException("Invalid point encoding");
                varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_1662370380.addTaint(taint);
                throw varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_1662370380;
            } //End block
            p = getInfinity();
            break;
            case 0x02:
            case 0x03:
            int ytilde = encoded[0] & 1;
            byte[] i = new byte[encoded.length - 1];
            System.arraycopy(encoded, 1, i, 0, i.length);
            ECFieldElement x = new ECFieldElement.Fp(this.q, new BigInteger(1, i));
            ECFieldElement alpha = x.multiply(x.square().add(a)).add(b);
            ECFieldElement beta = alpha.sqrt();
    if(beta == null)            
            {
                RuntimeException var073123230BDDEAB03F8CC2D1C501D87E_1822651454 = new RuntimeException("Invalid point compression");
                var073123230BDDEAB03F8CC2D1C501D87E_1822651454.addTaint(taint);
                throw var073123230BDDEAB03F8CC2D1C501D87E_1822651454;
            } //End block
            int bit0 = (beta.toBigInteger().testBit(0) ? 1 : 0);
    if(bit0 == ytilde)            
            {
                p = new ECPoint.Fp(this, x, beta, true);
            } //End block
            else
            {
                p = new ECPoint.Fp(this, x,
                        new ECFieldElement.Fp(this.q, q.subtract(beta.toBigInteger())), true);
            } //End block
            break;
            case 0x04:
            case 0x06:
            case 0x07:
            byte[] xEnc = new byte[(encoded.length - 1) / 2];
            byte[] yEnc = new byte[(encoded.length - 1) / 2];
            System.arraycopy(encoded, 1, xEnc, 0, xEnc.length);
            System.arraycopy(encoded, xEnc.length + 1, yEnc, 0, yEnc.length);
            p = new ECPoint.Fp(this,
                        new ECFieldElement.Fp(this.q, new BigInteger(1, xEnc)),
                        new ECFieldElement.Fp(this.q, new BigInteger(1, yEnc)));
            break;
            default:
            RuntimeException var6B576F84820FD10EFF078D43E27E2D72_888993324 = new RuntimeException("Invalid point encoding 0x" + Integer.toString(encoded[0], 16));
            var6B576F84820FD10EFF078D43E27E2D72_888993324.addTaint(taint);
            throw var6B576F84820FD10EFF078D43E27E2D72_888993324;
}ECPoint var74E4690D9F2A026504928C017944E149_582344203 =             p;
            var74E4690D9F2A026504928C017944E149_582344203.addTaint(taint);
            return var74E4690D9F2A026504928C017944E149_582344203;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.804 -0400", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "6D3A33E617A6432448D43330A418D33B")
        public ECPoint getInfinity() {
ECPoint varD826F01678C0988122ADB8C93417E177_1001255834 =             infinity;
            varD826F01678C0988122ADB8C93417E177_1001255834.addTaint(taint);
            return varD826F01678C0988122ADB8C93417E177_1001255834;
            // ---------- Original Method ----------
            //return infinity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.805 -0400", hash_original_method = "937E7F8C7D7C20805F9F2153639BF5E3", hash_generated_method = "568C64EE61EC3268B620D180D74B531A")
        public boolean equals(
            Object anObject) {
            addTaint(anObject.getTaint());
    if(anObject == this)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_2066445670 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894661078 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_894661078;
            } //End block
    if(!(anObject instanceof ECCurve.Fp))            
            {
                boolean var68934A3E9455FA72420237EB05902327_842652448 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789839283 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789839283;
            } //End block
            ECCurve.Fp other = (ECCurve.Fp) anObject;
            boolean varBCEFD00147463359556F9E3D2B186D57_919633843 = (this.q.equals(other.q) 
                    && a.equals(other.a) && b.equals(other.b));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_614199206 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_614199206;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.805 -0400", hash_original_method = "0595BFE04038932B73D34C7D5BF16F78", hash_generated_method = "E790EE4FE99AA8DEDA3FB004A5B628B8")
        public int hashCode() {
            int var0FD32793CB23B5AFDB05A870AAB833C7_752731403 = (a.hashCode() ^ b.hashCode() ^ q.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663704960 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663704960;
            // ---------- Original Method ----------
            //return a.hashCode() ^ b.hashCode() ^ q.hashCode();
        }

        
    }


    
    public static class F2m extends ECCurve {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.806 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

        private int m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.806 -0400", hash_original_field = "B637B17AF08ACED8850C18CCCDE915DA", hash_generated_field = "82BC5D885288BEA8F058C8200E42732B")

        private int k1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.806 -0400", hash_original_field = "61620957A1443C946A143CF99A7D24FA", hash_generated_field = "9A9BABB98FA71DB4E862A96C38A0DEB5")

        private int k2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.806 -0400", hash_original_field = "F7AB469D1DC79166FC874DADCC0DD854", hash_generated_field = "B93297072479995D07A6DAC48610EF09")

        private int k3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.806 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "28997BC83DA18A620109895922F10617")

        private BigInteger n;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.806 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

        private BigInteger h;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.806 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "3F0371905D46A3DF93ACA58D05B01E9C")

        private ECPoint.F2m infinity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.806 -0400", hash_original_field = "5C77EC7DAADCE22A1213046881A54B40", hash_generated_field = "FF1108A0424E980F296A774C118EF5E8")

        private byte mu = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.806 -0400", hash_original_field = "9A98A235BB28BA556F2A8960F7A384A8", hash_generated_field = "4DD43C8E43FDD8E564AAA02789FAC70C")

        private BigInteger[] si = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.806 -0400", hash_original_method = "DEC52BA66274A72254EB3F42E643013D", hash_generated_method = "D0986C1D732EC363393DF80C8862B1D1")
        public  F2m(
            int m,
            int k,
            BigInteger a,
            BigInteger b) {
            this(m, k, 0, 0, a, b, null, null);
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            addTaint(k);
            addTaint(m);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.807 -0400", hash_original_method = "F2139B4AB6C86388E7E3C9323DB40384", hash_generated_method = "8099BBA63F992C4F8A19596D2E64CCF7")
        public  F2m(
            int m, 
            int k, 
            BigInteger a, 
            BigInteger b,
            BigInteger n,
            BigInteger h) {
            this(m, k, 0, 0, a, b, n, h);
            addTaint(h.getTaint());
            addTaint(n.getTaint());
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            addTaint(k);
            addTaint(m);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.807 -0400", hash_original_method = "5E11630AFDD86B3E6F25DD938FDF4713", hash_generated_method = "42C4937A5C138EF07EEA09F0D15B42F9")
        public  F2m(
            int m,
            int k1,
            int k2,
            int k3,
            BigInteger a,
            BigInteger b) {
            this(m, k1, k2, k3, a, b, null, null);
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            addTaint(k3);
            addTaint(k2);
            addTaint(k1);
            addTaint(m);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.809 -0400", hash_original_method = "DFE62FA9A40BB48176925A509A87D7E7", hash_generated_method = "57B64AAC63C297C47774ACDBE7CF1DE3")
        public  F2m(
            int m, 
            int k1, 
            int k2, 
            int k3,
            BigInteger a, 
            BigInteger b,
            BigInteger n,
            BigInteger h) {
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            this.n = n;
            this.h = h;
    if(k1 == 0)            
            {
                IllegalArgumentException varC61641897B87AEAE255E76A9677C9C6C_38417314 = new IllegalArgumentException("k1 must be > 0");
                varC61641897B87AEAE255E76A9677C9C6C_38417314.addTaint(taint);
                throw varC61641897B87AEAE255E76A9677C9C6C_38417314;
            } //End block
    if(k2 == 0)            
            {
    if(k3 != 0)                
                {
                    IllegalArgumentException var450989A420B395AA4EE14FF066EE37CA_1214887657 = new IllegalArgumentException("k3 must be 0 if k2 == 0");
                    var450989A420B395AA4EE14FF066EE37CA_1214887657.addTaint(taint);
                    throw var450989A420B395AA4EE14FF066EE37CA_1214887657;
                } //End block
            } //End block
            else
            {
    if(k2 <= k1)                
                {
                    IllegalArgumentException var0EB121ECA88543D465A3EBFCD9122EA1_1624768810 = new IllegalArgumentException("k2 must be > k1");
                    var0EB121ECA88543D465A3EBFCD9122EA1_1624768810.addTaint(taint);
                    throw var0EB121ECA88543D465A3EBFCD9122EA1_1624768810;
                } //End block
    if(k3 <= k2)                
                {
                    IllegalArgumentException var0BA2B8A105297223AF1B1D2E7E312C4F_1667564492 = new IllegalArgumentException("k3 must be > k2");
                    var0BA2B8A105297223AF1B1D2E7E312C4F_1667564492.addTaint(taint);
                    throw var0BA2B8A105297223AF1B1D2E7E312C4F_1667564492;
                } //End block
            } //End block
            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.infinity = new ECPoint.F2m(this, null, null);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.810 -0400", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "E67593FFB3757D28AC260ECEBF8A03FE")
        public int getFieldSize() {
            int var6F8F57715090DA2632453988D9A1501B_209209212 = (m);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923031870 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923031870;
            // ---------- Original Method ----------
            //return m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.810 -0400", hash_original_method = "7AF48CB12A1921AAC7C154231A16AA21", hash_generated_method = "E3B4841FC6E695073C23BDCC075C5E60")
        public ECFieldElement fromBigInteger(BigInteger x) {
            addTaint(x.getTaint());
ECFieldElement var2192A5A60ACD6C969D10D16EBF531997_1754814450 =             new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
            var2192A5A60ACD6C969D10D16EBF531997_1754814450.addTaint(taint);
            return var2192A5A60ACD6C969D10D16EBF531997_1754814450;
            // ---------- Original Method ----------
            //return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.810 -0400", hash_original_method = "166EA7512C9A204978606C53F7DDDB4A", hash_generated_method = "9A3BEB1B5D8F9114BEE201D4BAE48753")
        public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
            addTaint(withCompression);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
ECPoint var03FF0EF84700327CC816AF0C0D978C53_152143008 =             new ECPoint.F2m(this, fromBigInteger(x), fromBigInteger(y), withCompression);
            var03FF0EF84700327CC816AF0C0D978C53_152143008.addTaint(taint);
            return var03FF0EF84700327CC816AF0C0D978C53_152143008;
            // ---------- Original Method ----------
            //return new ECPoint.F2m(this, fromBigInteger(x), fromBigInteger(y), withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.811 -0400", hash_original_method = "3A440A2E6AC052FD5047F5B01472DA22", hash_generated_method = "810DC1FB463ECE5DE9ED81B7B2F14C61")
        public ECPoint decodePoint(byte[] encoded) {
            addTaint(encoded[0]);
            ECPoint p = null;
switch(encoded[0]){
            case 0x00:
    if(encoded.length > 1)            
            {
                RuntimeException varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_1358171157 = new RuntimeException("Invalid point encoding");
                varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_1358171157.addTaint(taint);
                throw varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_1358171157;
            } //End block
            p = getInfinity();
            break;
            case 0x02:
            case 0x03:
            byte[] enc = new byte[encoded.length - 1];
            System.arraycopy(encoded, 1, enc, 0, enc.length);
    if(encoded[0] == 0x02)            
            {
                p = decompressPoint(enc, 0);
            } //End block
            else
            {
                p = decompressPoint(enc, 1);
            } //End block
            break;
            case 0x04:
            case 0x06:
            case 0x07:
            byte[] xEnc = new byte[(encoded.length - 1) / 2];
            byte[] yEnc = new byte[(encoded.length - 1) / 2];
            System.arraycopy(encoded, 1, xEnc, 0, xEnc.length);
            System.arraycopy(encoded, xEnc.length + 1, yEnc, 0, yEnc.length);
            p = new ECPoint.F2m(this,
                    new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3,
                        new BigInteger(1, xEnc)),
                    new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3,
                        new BigInteger(1, yEnc)), false);
            break;
            default:
            RuntimeException var6B576F84820FD10EFF078D43E27E2D72_211717907 = new RuntimeException("Invalid point encoding 0x" + Integer.toString(encoded[0], 16));
            var6B576F84820FD10EFF078D43E27E2D72_211717907.addTaint(taint);
            throw var6B576F84820FD10EFF078D43E27E2D72_211717907;
}ECPoint var74E4690D9F2A026504928C017944E149_157133598 =             p;
            var74E4690D9F2A026504928C017944E149_157133598.addTaint(taint);
            return var74E4690D9F2A026504928C017944E149_157133598;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.812 -0400", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "01A2B0EB9989271FDA84428D28F0F615")
        public ECPoint getInfinity() {
ECPoint varD826F01678C0988122ADB8C93417E177_1609910212 =             infinity;
            varD826F01678C0988122ADB8C93417E177_1609910212.addTaint(taint);
            return varD826F01678C0988122ADB8C93417E177_1609910212;
            // ---------- Original Method ----------
            //return infinity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.812 -0400", hash_original_method = "0873B9ADE54853DB8C371F01782A1B9E", hash_generated_method = "41343067AE535ECA9089801FE846FFF6")
        public boolean isKoblitz() {
            boolean var3A159A0BE54692E8571216DB24FAD4EB_172552649 = (((n != null) && (h != null) &&
                    ((a.toBigInteger().equals(ECConstants.ZERO)) ||
                    (a.toBigInteger().equals(ECConstants.ONE))) &&
                    (b.toBigInteger().equals(ECConstants.ONE))));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335004374 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335004374;
            // ---------- Original Method ----------
            //return ((n != null) && (h != null) &&
                    //((a.toBigInteger().equals(ECConstants.ZERO)) ||
                    //(a.toBigInteger().equals(ECConstants.ONE))) &&
                    //(b.toBigInteger().equals(ECConstants.ONE)));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.812 -0400", hash_original_method = "6A47B833A38B2C51AF1636CDFCEB3B55", hash_generated_method = "D62D8CCEF0734278F691AD82E185E17F")
        synchronized byte getMu() {
    if(mu == 0)            
            {
                mu = Tnaf.getMu(this);
            } //End block
            byte var89AA4B196B48C8A13A6549BB1EAEBD80_2080192490 = (mu);
                        byte var40EA57D3EE3C07BF1C102B466E1C3091_1912238168 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_1912238168;
            // ---------- Original Method ----------
            //if (mu == 0)
            //{
                //mu = Tnaf.getMu(this);
            //}
            //return mu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.813 -0400", hash_original_method = "C02001236D393BDCA3D2D65CC0F3FCD6", hash_generated_method = "B59F01CEA30383F65740FF70C6698C42")
        synchronized BigInteger[] getSi() {
    if(si == null)            
            {
                si = Tnaf.getSi(this);
            } //End block
BigInteger[] var316474D4DA67FD8479E170FE8E19F283_1079959863 =             si;
            var316474D4DA67FD8479E170FE8E19F283_1079959863.addTaint(taint);
            return var316474D4DA67FD8479E170FE8E19F283_1079959863;
            // ---------- Original Method ----------
            //if (si == null)
            //{
                //si = Tnaf.getSi(this);
            //}
            //return si;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.814 -0400", hash_original_method = "ABCDD5682443273B6E9EF7110AFEAA10", hash_generated_method = "CDE79A605A4669F8B7C6B04ED3898ED6")
        private ECPoint decompressPoint(
            byte[] xEnc, 
            int ypBit) {
            addTaint(ypBit);
            addTaint(xEnc[0]);
            ECFieldElement xp = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, new BigInteger(1, xEnc));
            ECFieldElement yp = null;
    if(xp.toBigInteger().equals(ECConstants.ZERO))            
            {
                yp = (ECFieldElement.F2m)b;
for(int i = 0;i < m - 1;i++)
                {
                    yp = yp.square();
                } //End block
            } //End block
            else
            {
                ECFieldElement beta = xp.add(a).add(
                        b.multiply(xp.square().invert()));
                ECFieldElement z = solveQuadradicEquation(beta);
    if(z == null)                
                {
                    RuntimeException var073123230BDDEAB03F8CC2D1C501D87E_1562807396 = new RuntimeException("Invalid point compression");
                    var073123230BDDEAB03F8CC2D1C501D87E_1562807396.addTaint(taint);
                    throw var073123230BDDEAB03F8CC2D1C501D87E_1562807396;
                } //End block
                int zBit = 0;
    if(z.toBigInteger().testBit(0))                
                {
                    zBit = 1;
                } //End block
    if(zBit != ypBit)                
                {
                    z = z.add(new ECFieldElement.F2m(this.m, this.k1, this.k2,
                            this.k3, ECConstants.ONE));
                } //End block
                yp = xp.multiply(z);
            } //End block
ECPoint varD903BA7B856E5972E8BD7D9E7940A611_1217492304 =             new ECPoint.F2m(this, xp, yp);
            varD903BA7B856E5972E8BD7D9E7940A611_1217492304.addTaint(taint);
            return varD903BA7B856E5972E8BD7D9E7940A611_1217492304;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.815 -0400", hash_original_method = "25ED10C579C6ED4884A834D5A2CEB482", hash_generated_method = "8D1F12AC8F6166D7BC994A4B7856C163")
        private ECFieldElement solveQuadradicEquation(ECFieldElement beta) {
            addTaint(beta.getTaint());
            ECFieldElement zeroElement = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, ECConstants.ZERO);
    if(beta.toBigInteger().equals(ECConstants.ZERO))            
            {
ECFieldElement var99B607BA1DEFDB54F96AED6A216D9277_903397523 =                 zeroElement;
                var99B607BA1DEFDB54F96AED6A216D9277_903397523.addTaint(taint);
                return var99B607BA1DEFDB54F96AED6A216D9277_903397523;
            } //End block
            ECFieldElement z = null;
            ECFieldElement gamma = zeroElement;
            Random rand = new Random();
            do {
                {
                    ECFieldElement t = new ECFieldElement.F2m(this.m, this.k1,
                        this.k2, this.k3, new BigInteger(m, rand));
                    z = zeroElement;
                    ECFieldElement w = beta;
for(int i = 1;i <= m - 1;i++)
                    {
                        ECFieldElement w2 = w.square();
                        z = z.square().add(w2.multiply(t));
                        w = w2.add(beta);
                    } //End block
    if(!w.toBigInteger().equals(ECConstants.ZERO))                    
                    {
ECFieldElement var540C13E9E156B687226421B24F2DF178_1489494976 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1489494976.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1489494976;
                    } //End block
                    gamma = z.square().add(z);
                } //End block
} while (gamma.toBigInteger().equals(ECConstants.ZERO));
ECFieldElement var07014B16947C3ECA078D6A03A18D6101_1253364650 =             z;
            var07014B16947C3ECA078D6A03A18D6101_1253364650.addTaint(taint);
            return var07014B16947C3ECA078D6A03A18D6101_1253364650;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.816 -0400", hash_original_method = "5F33BE6BAAB2ADDEB5EF1D1748825E7B", hash_generated_method = "DF4C72B1318D0AD3C1E641E65748256E")
        public boolean equals(
            Object anObject) {
            addTaint(anObject.getTaint());
    if(anObject == this)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_212044207 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_123354210 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_123354210;
            } //End block
    if(!(anObject instanceof ECCurve.F2m))            
            {
                boolean var68934A3E9455FA72420237EB05902327_381573054 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1339801022 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1339801022;
            } //End block
            ECCurve.F2m other = (ECCurve.F2m)anObject;
            boolean varE4B05A1198E46519975331865A8C8EA5_547029328 = ((this.m == other.m) && (this.k1 == other.k1)
                && (this.k2 == other.k2) && (this.k3 == other.k3)
                && a.equals(other.a) && b.equals(other.b));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239272501 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239272501;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.816 -0400", hash_original_method = "E92144A56D15AF334E01FB92437AD76B", hash_generated_method = "006996DC4094A8BDDA8EB396201C7683")
        public int hashCode() {
            int var094CC37330A541EC50C4AE279DAFABD8_826758011 = (this.a.hashCode() ^ this.b.hashCode() ^ m ^ k1 ^ k2 ^ k3);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310035805 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310035805;
            // ---------- Original Method ----------
            //return this.a.hashCode() ^ this.b.hashCode() ^ m ^ k1 ^ k2 ^ k3;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.817 -0400", hash_original_method = "2FA087881284515E1CE9CA954B1F01D0", hash_generated_method = "962F3277696642F70EB2E5EC65FB10E3")
        public int getM() {
            int var6F8F57715090DA2632453988D9A1501B_370772656 = (m);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1616542040 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1616542040;
            // ---------- Original Method ----------
            //return m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.817 -0400", hash_original_method = "0A21FBE14C3CF35BF18E601EA9469DB4", hash_generated_method = "EFFE2C5E67804C773B458E808CF3057E")
        public boolean isTrinomial() {
            boolean varF61B4889BFF262902FBF9BAA3E934E2B_424370715 = (k2 == 0 && k3 == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819996749 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_819996749;
            // ---------- Original Method ----------
            //return k2 == 0 && k3 == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.817 -0400", hash_original_method = "6F5E01D9EB3F8F69F3EDFAB71A89E9BA", hash_generated_method = "DD1CBDF15D49CE4904DE3DCF4531FAA5")
        public int getK1() {
            int varB637B17AF08ACED8850C18CCCDE915DA_1283448757 = (k1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885289070 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885289070;
            // ---------- Original Method ----------
            //return k1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.817 -0400", hash_original_method = "39AC234DC3848032A728401BC68DF439", hash_generated_method = "97860CD4FA668B9814DFDFD1501DFDDD")
        public int getK2() {
            int var61620957A1443C946A143CF99A7D24FA_362690378 = (k2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616565976 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616565976;
            // ---------- Original Method ----------
            //return k2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.818 -0400", hash_original_method = "A40D42566F753B213E5F7F205217D7F1", hash_generated_method = "C60D8139E47785CCF2D265A8078901EB")
        public int getK3() {
            int varF7AB469D1DC79166FC874DADCC0DD854_1551271633 = (k3);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548693762 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548693762;
            // ---------- Original Method ----------
            //return k3;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.818 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "BDE4DC071FD761694B232001D55F1F33")
        public BigInteger getN() {
BigInteger var041154653C812B0D1663EC287BE4C757_1201554438 =             n;
            var041154653C812B0D1663EC287BE4C757_1201554438.addTaint(taint);
            return var041154653C812B0D1663EC287BE4C757_1201554438;
            // ---------- Original Method ----------
            //return n;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.818 -0400", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "5CBC92E33B439447C4BE6B90EDC65240")
        public BigInteger getH() {
BigInteger var81CECAAA363C2B26C476DE4A79F58961_1887533590 =             h;
            var81CECAAA363C2B26C476DE4A79F58961_1887533590.addTaint(taint);
            return var81CECAAA363C2B26C476DE4A79F58961_1887533590;
            // ---------- Original Method ----------
            //return h;
        }

        
    }


    
}

