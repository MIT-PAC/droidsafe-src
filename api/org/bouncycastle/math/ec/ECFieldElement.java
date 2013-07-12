package org.bouncycastle.math.ec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.util.Random;

public abstract class ECFieldElement implements ECConstants {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.947 -0400", hash_original_method = "18B929116CB81747CE726807F2C6A2C0", hash_generated_method = "18B929116CB81747CE726807F2C6A2C0")
    public ECFieldElement ()
    {
        
    }


    public abstract BigInteger     toBigInteger();

    
    public abstract String         getFieldName();

    
    public abstract int            getFieldSize();

    
    public abstract ECFieldElement add(ECFieldElement b);

    
    public abstract ECFieldElement subtract(ECFieldElement b);

    
    public abstract ECFieldElement multiply(ECFieldElement b);

    
    public abstract ECFieldElement divide(ECFieldElement b);

    
    public abstract ECFieldElement negate();

    
    public abstract ECFieldElement square();

    
    public abstract ECFieldElement invert();

    
    public abstract ECFieldElement sqrt();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.948 -0400", hash_original_method = "0A600F50B2D3858965A3E5F0EE37FE95", hash_generated_method = "00A0B2A108F4F6C32E9C74BC40EC4D9A")
    public String toString() {
String var9B750EC2909B6FC9C2DCE0545795AB11_1579914439 =         this.toBigInteger().toString(2);
        var9B750EC2909B6FC9C2DCE0545795AB11_1579914439.addTaint(taint);
        return var9B750EC2909B6FC9C2DCE0545795AB11_1579914439;
        
        
    }

    
    public static class Fp extends ECFieldElement {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.948 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "8A69D3B9CF67CA1128DF293842071E77")

        BigInteger x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.948 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "F819999E3B2036A19089F4FD0B5D94F4")

        BigInteger q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.948 -0400", hash_original_method = "2CEE87D2C14E1CA252587D4A1EA48723", hash_generated_method = "49DCC4E1B76C14B326C6161A612DA79C")
        public  Fp(BigInteger q, BigInteger x) {
            this.x = x;
    if(x.compareTo(q) >= 0)            
            {
                IllegalArgumentException varB3CB45172D3A94C252A8E0B24738EE73_1724286470 = new IllegalArgumentException("x value too large in field element");
                varB3CB45172D3A94C252A8E0B24738EE73_1724286470.addTaint(taint);
                throw varB3CB45172D3A94C252A8E0B24738EE73_1724286470;
            } 
            this.q = q;
            
            
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.949 -0400", hash_original_method = "980758C44AA9D55BE8845E0F1627D066", hash_generated_method = "32711BD0877FAA1477290E44585BBFE1")
        public BigInteger toBigInteger() {
BigInteger varEA5659DA512DECF23E6D37EE8060D074_1784042991 =             x;
            varEA5659DA512DECF23E6D37EE8060D074_1784042991.addTaint(taint);
            return varEA5659DA512DECF23E6D37EE8060D074_1784042991;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.949 -0400", hash_original_method = "0E8B7E675C6828F2CC0DC48F96E6F8E3", hash_generated_method = "D8A603DDD4EA7510E3B54E801895B9C0")
        public String getFieldName() {
String varEA74BFECD01ADB646158482B0707242D_1014447931 =             "Fp";
            varEA74BFECD01ADB646158482B0707242D_1014447931.addTaint(taint);
            return varEA74BFECD01ADB646158482B0707242D_1014447931;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.949 -0400", hash_original_method = "B586F82D19D11BCE8142121499961CE9", hash_generated_method = "F2FD95CC285CFAAE7AF3877093013E73")
        public int getFieldSize() {
            int var0769037565AC374C9291621AA66E8145_874503195 = (q.bitLength());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208185500 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208185500;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.949 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "1BF9A744BF4ABE3878FD1FEA3AC60C94")
        public BigInteger getQ() {
BigInteger varBEF1B7662E10AF6D5747729987514CB6_394177084 =             q;
            varBEF1B7662E10AF6D5747729987514CB6_394177084.addTaint(taint);
            return varBEF1B7662E10AF6D5747729987514CB6_394177084;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.949 -0400", hash_original_method = "81C2635B1C8BBF0D98329C00DDA86CBF", hash_generated_method = "34CC4E2B21B1D358E46CE0B48A267B91")
        public ECFieldElement add(ECFieldElement b) {
            addTaint(b.getTaint());
ECFieldElement var95CD65D7E9E9B30879AC7D6DC02DEBD6_1797057661 =             new Fp(q, x.add(b.toBigInteger()).mod(q));
            var95CD65D7E9E9B30879AC7D6DC02DEBD6_1797057661.addTaint(taint);
            return var95CD65D7E9E9B30879AC7D6DC02DEBD6_1797057661;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.949 -0400", hash_original_method = "CC55B0F5614FEECA03D2E059411B5A62", hash_generated_method = "E8B3EB06B74A34056F367C601F86481A")
        public ECFieldElement subtract(ECFieldElement b) {
            addTaint(b.getTaint());
ECFieldElement varD8B8420F07FA66AA2D7A0248ABEB3539_202969065 =             new Fp(q, x.subtract(b.toBigInteger()).mod(q));
            varD8B8420F07FA66AA2D7A0248ABEB3539_202969065.addTaint(taint);
            return varD8B8420F07FA66AA2D7A0248ABEB3539_202969065;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.949 -0400", hash_original_method = "8FDF6CC967FA6FBF2AB862654F18B35A", hash_generated_method = "0E93D021034CC8801CC2D356C0832762")
        public ECFieldElement multiply(ECFieldElement b) {
            addTaint(b.getTaint());
ECFieldElement var721CE09C12047DA4DC97E558E685713B_456846975 =             new Fp(q, x.multiply(b.toBigInteger()).mod(q));
            var721CE09C12047DA4DC97E558E685713B_456846975.addTaint(taint);
            return var721CE09C12047DA4DC97E558E685713B_456846975;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.950 -0400", hash_original_method = "273EB04F445D1E8BD427B46F09A750C8", hash_generated_method = "C8EF5E58D9B4C34204021BBF34A277C6")
        public ECFieldElement divide(ECFieldElement b) {
            addTaint(b.getTaint());
ECFieldElement var91340398E306B41FC40D6A74F045FBCF_1217219003 =             new Fp(q, x.multiply(b.toBigInteger().modInverse(q)).mod(q));
            var91340398E306B41FC40D6A74F045FBCF_1217219003.addTaint(taint);
            return var91340398E306B41FC40D6A74F045FBCF_1217219003;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.950 -0400", hash_original_method = "9EF54D69A52E7076272AA6C8111B6A31", hash_generated_method = "07C261EA008C939D43EEB9E09522EE1D")
        public ECFieldElement negate() {
ECFieldElement varAF04B96EA998AE163274400B0D7DE06F_1157086059 =             new Fp(q, x.negate().mod(q));
            varAF04B96EA998AE163274400B0D7DE06F_1157086059.addTaint(taint);
            return varAF04B96EA998AE163274400B0D7DE06F_1157086059;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.950 -0400", hash_original_method = "1F15D9F4F3F7C45F6D78B4A8A149E9FC", hash_generated_method = "3412F8620E6C09D717ED6724ECFD00A5")
        public ECFieldElement square() {
ECFieldElement var093D94E671FE87C574D7FD482BCC127A_315648689 =             new Fp(q, x.multiply(x).mod(q));
            var093D94E671FE87C574D7FD482BCC127A_315648689.addTaint(taint);
            return var093D94E671FE87C574D7FD482BCC127A_315648689;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.950 -0400", hash_original_method = "87CD41222C6FB4EC59F31E743CC1D431", hash_generated_method = "3D86077BF604EF2EC439752E5D0CAA7C")
        public ECFieldElement invert() {
ECFieldElement varFEF24BB86BC223E29D9B2D72028A527B_646495622 =             new Fp(q, x.modInverse(q));
            varFEF24BB86BC223E29D9B2D72028A527B_646495622.addTaint(taint);
            return varFEF24BB86BC223E29D9B2D72028A527B_646495622;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.951 -0400", hash_original_method = "27B2154E50FF6039CAEE06398FCA6C60", hash_generated_method = "8D6DD6F73A8651BAB3270DF59DA20149")
        public ECFieldElement sqrt() {
    if(!q.testBit(0))            
            {
                RuntimeException varDC49C9CCC8D464733337D79D36F9AAD1_2034126819 = new RuntimeException("not done yet");
                varDC49C9CCC8D464733337D79D36F9AAD1_2034126819.addTaint(taint);
                throw varDC49C9CCC8D464733337D79D36F9AAD1_2034126819;
            } 
    if(q.testBit(1))            
            {
                ECFieldElement z = new Fp(q, x.modPow(q.shiftRight(2).add(ECConstants.ONE), q));
ECFieldElement var3E43DBDF6B8E8414F8E5F926A23338D3_158350470 =                 z.square().equals(this) ? z : null;
                var3E43DBDF6B8E8414F8E5F926A23338D3_158350470.addTaint(taint);
                return var3E43DBDF6B8E8414F8E5F926A23338D3_158350470;
            } 
            BigInteger qMinusOne = q.subtract(ECConstants.ONE);
            BigInteger legendreExponent = qMinusOne.shiftRight(1);
    if(!(x.modPow(legendreExponent, q).equals(ECConstants.ONE)))            
            {
ECFieldElement var540C13E9E156B687226421B24F2DF178_2109290992 =                 null;
                var540C13E9E156B687226421B24F2DF178_2109290992.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_2109290992;
            } 
            BigInteger u = qMinusOne.shiftRight(2);
            BigInteger k = u.shiftLeft(1).add(ECConstants.ONE);
            BigInteger Q = this.x;
            BigInteger fourQ = Q.shiftLeft(2).mod(q);
            BigInteger U;
            BigInteger V;
            Random rand = new Random();
            do {
                {
                    BigInteger P;
                    do {
                        {
                            P = new BigInteger(q.bitLength(), rand);
                        } 
} while (P.compareTo(q) >= 0
                    || !(P.multiply(P).subtract(fourQ).modPow(legendreExponent, q).equals(qMinusOne)));
                    BigInteger[] result = lucasSequence(q, P, Q, k);
                    U = result[0];
                    V = result[1];
    if(V.multiply(V).mod(q).equals(fourQ))                    
                    {
    if(V.testBit(0))                        
                        {
                            V = V.add(q);
                        } 
                        V = V.shiftRight(1);
ECFieldElement var4BF768B78687B548C85E5A6267B2FC18_894058992 =                         new ECFieldElement.Fp(q, V);
                        var4BF768B78687B548C85E5A6267B2FC18_894058992.addTaint(taint);
                        return var4BF768B78687B548C85E5A6267B2FC18_894058992;
                    } 
                } 
} while (U.equals(ECConstants.ONE) || U.equals(qMinusOne));
ECFieldElement var540C13E9E156B687226421B24F2DF178_1720048691 =             null;
            var540C13E9E156B687226421B24F2DF178_1720048691.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1720048691;
            
            
        }

        
                private static BigInteger[] lucasSequence(
            BigInteger  p,
            BigInteger  P,
            BigInteger  Q,
            BigInteger  k) {
            int n = k.bitLength();
            int s = k.getLowestSetBit();
            BigInteger Uh = ECConstants.ONE;
            BigInteger Vl = ECConstants.TWO;
            BigInteger Vh = P;
            BigInteger Ql = ECConstants.ONE;
            BigInteger Qh = ECConstants.ONE;
            for (int j = n - 1; j >= s + 1; --j)
            {
                Ql = Ql.multiply(Qh).mod(p);
                if (k.testBit(j))
                {
                    Qh = Ql.multiply(Q).mod(p);
                    Uh = Uh.multiply(Vh).mod(p);
                    Vl = Vh.multiply(Vl).subtract(P.multiply(Ql)).mod(p);
                    Vh = Vh.multiply(Vh).subtract(Qh.shiftLeft(1)).mod(p);
                }
                else
                {
                    Qh = Ql;
                    Uh = Uh.multiply(Vl).subtract(Ql).mod(p);
                    Vh = Vh.multiply(Vl).subtract(P.multiply(Ql)).mod(p);
                    Vl = Vl.multiply(Vl).subtract(Ql.shiftLeft(1)).mod(p);
                }
            }
            Ql = Ql.multiply(Qh).mod(p);
            Qh = Ql.multiply(Q).mod(p);
            Uh = Uh.multiply(Vl).subtract(Ql).mod(p);
            Vl = Vh.multiply(Vl).subtract(P.multiply(Ql)).mod(p);
            Ql = Ql.multiply(Qh).mod(p);
            for (int j = 1; j <= s; ++j)
            {
                Uh = Uh.multiply(Vl).mod(p);
                Vl = Vl.multiply(Vl).subtract(Ql.shiftLeft(1)).mod(p);
                Ql = Ql.multiply(Ql).mod(p);
            }
            return new BigInteger[]{ Uh, Vl };
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.951 -0400", hash_original_method = "F275DE81E4C5BCC7A64CB08B0E3C6B94", hash_generated_method = "60D7FBDE658849CF1F315270E05A0F2B")
        public boolean equals(Object other) {
            addTaint(other.getTaint());
    if(other == this)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_317076095 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_596721899 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_596721899;
            } 
    if(!(other instanceof ECFieldElement.Fp))            
            {
                boolean var68934A3E9455FA72420237EB05902327_639648830 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425725592 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425725592;
            } 
            ECFieldElement.Fp o = (ECFieldElement.Fp)other;
            boolean var761CEA50B135B830D797A5C431CF642B_1204152672 = (q.equals(o.q) && x.equals(o.x));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_637297593 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_637297593;
            
            
            
                
            
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.951 -0400", hash_original_method = "61E77154098D5712686019259E83DC28", hash_generated_method = "5C56155C311AD9D887D71D6A26089A34")
        public int hashCode() {
            int var47CAD9BD55BDFC41A1191D6715C04270_90692438 = (q.hashCode() ^ x.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797127700 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797127700;
            
            
        }

        
    }


    
    public static class F2m extends ECFieldElement {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.952 -0400", hash_original_field = "EE16755AF8C89D0C26540DAF7A0FE1B3", hash_generated_field = "05684F2BDAA8EE0BD6A4A6166AA30FB6")

        private int representation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.952 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

        private int m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.952 -0400", hash_original_field = "B637B17AF08ACED8850C18CCCDE915DA", hash_generated_field = "82BC5D885288BEA8F058C8200E42732B")

        private int k1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.952 -0400", hash_original_field = "61620957A1443C946A143CF99A7D24FA", hash_generated_field = "9A9BABB98FA71DB4E862A96C38A0DEB5")

        private int k2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.952 -0400", hash_original_field = "F7AB469D1DC79166FC874DADCC0DD854", hash_generated_field = "B93297072479995D07A6DAC48610EF09")

        private int k3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.952 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "8009D56CC2C16E6B1ECA88AD9DDD4454")

        private IntArray x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.952 -0400", hash_original_field = "E358EFA489F58062F10DD7316B65649E", hash_generated_field = "C6BE2DA2DF5011CA37BB619361E1CF67")

        private int t;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.952 -0400", hash_original_method = "30B70FEF02DF1B2128C82CD1FCC1318F", hash_generated_method = "BA54B02B17A1BDCC0BAEA51C19EE788D")
        public  F2m(
            int m, 
            int k1, 
            int k2, 
            int k3,
            BigInteger x) {
            t = (m + 31) >> 5;
            this.x = new IntArray(x, t);
    if((k2 == 0) && (k3 == 0))            
            {
                this.representation = TPB;
            } 
            else
            {
    if(k2 >= k3)                
                {
                    IllegalArgumentException var047CAF9799C59B2CC26D28A401C7EA9F_251423730 = new IllegalArgumentException(
                            "k2 must be smaller than k3");
                    var047CAF9799C59B2CC26D28A401C7EA9F_251423730.addTaint(taint);
                    throw var047CAF9799C59B2CC26D28A401C7EA9F_251423730;
                } 
    if(k2 <= 0)                
                {
                    IllegalArgumentException varBFB69105FAC554536930812AACB69C4D_74697545 = new IllegalArgumentException(
                            "k2 must be larger than 0");
                    varBFB69105FAC554536930812AACB69C4D_74697545.addTaint(taint);
                    throw varBFB69105FAC554536930812AACB69C4D_74697545;
                } 
                this.representation = PPB;
            } 
    if(x.signum() < 0)            
            {
                IllegalArgumentException var6CCA8111E0BEC017E77440F342CC24CF_1966355185 = new IllegalArgumentException("x value cannot be negative");
                var6CCA8111E0BEC017E77440F342CC24CF_1966355185.addTaint(taint);
                throw var6CCA8111E0BEC017E77440F342CC24CF_1966355185;
            } 
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.952 -0400", hash_original_method = "769D94FCBFF8D8B7B44421BAE1CCBF10", hash_generated_method = "B02FE738288DDE8CD2C1FAA705C99AB9")
        public  F2m(int m, int k, BigInteger x) {
            this(m, k, 0, 0, x);
            addTaint(x.getTaint());
            addTaint(k);
            addTaint(m);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.953 -0400", hash_original_method = "E37831F6788FECA0B3C28407A9D117A4", hash_generated_method = "0A25AF3D31E3563872BEF9704D2BA9E8")
        private  F2m(int m, int k1, int k2, int k3, IntArray x) {
            t = (m + 31) >> 5;
            this.x = x;
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
    if((k2 == 0) && (k3 == 0))            
            {
                this.representation = TPB;
            } 
            else
            {
                this.representation = PPB;
            } 
            
            
            
            
            
            
            
            
            
                
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.953 -0400", hash_original_method = "D9240AE462D2FCFCBEB9680DA07047D8", hash_generated_method = "B8073F107152873811D1F43DC0853E23")
        public BigInteger toBigInteger() {
BigInteger varA5CABE31C940B93287B41AAF30CBBD9D_2047201472 =             x.toBigInteger();
            varA5CABE31C940B93287B41AAF30CBBD9D_2047201472.addTaint(taint);
            return varA5CABE31C940B93287B41AAF30CBBD9D_2047201472;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.953 -0400", hash_original_method = "69EE8C1832EFB43BF906E0C4BE94B23A", hash_generated_method = "9059E6E96C825E215E6A8B9425D67ADB")
        public String getFieldName() {
String var09AD38A4C279366F522630A4F3F38326_742127302 =             "F2m";
            var09AD38A4C279366F522630A4F3F38326_742127302.addTaint(taint);
            return var09AD38A4C279366F522630A4F3F38326_742127302;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.953 -0400", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "5BA496AE24CCC2CDDE0D7AFA9349C1B1")
        public int getFieldSize() {
            int var6F8F57715090DA2632453988D9A1501B_1738503419 = (m);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62997576 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62997576;
            
            
        }

        
                public static void checkFieldElements(
            ECFieldElement a,
            ECFieldElement b) {
            if ((!(a instanceof F2m)) || (!(b instanceof F2m)))
            {
                throw new IllegalArgumentException("Field elements are not "
                        + "both instances of ECFieldElement.F2m");
            }
            ECFieldElement.F2m aF2m = (ECFieldElement.F2m)a;
            ECFieldElement.F2m bF2m = (ECFieldElement.F2m)b;
            if ((aF2m.m != bF2m.m) || (aF2m.k1 != bF2m.k1)
                    || (aF2m.k2 != bF2m.k2) || (aF2m.k3 != bF2m.k3))
            {
                throw new IllegalArgumentException("Field elements are not "
                        + "elements of the same field F2m");
            }
            if (aF2m.representation != bF2m.representation)
            {
                throw new IllegalArgumentException(
                        "One of the field "
                                + "elements are not elements has incorrect representation");
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.953 -0400", hash_original_method = "1771E6C8DC949344BED4A1E6536DC20F", hash_generated_method = "4A9D608BF2C7E68CDF63FB539F1FF498")
        public ECFieldElement add(final ECFieldElement b) {
            addTaint(b.getTaint());
            IntArray iarrClone = (IntArray)this.x.clone();
            F2m bF2m = (F2m)b;
            iarrClone.addShifted(bF2m.x, 0);
ECFieldElement var05CCF13E4F1E050A83D5CD6B3B4844DB_585020506 =             new F2m(m, k1, k2, k3, iarrClone);
            var05CCF13E4F1E050A83D5CD6B3B4844DB_585020506.addTaint(taint);
            return var05CCF13E4F1E050A83D5CD6B3B4844DB_585020506;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.954 -0400", hash_original_method = "DED14713A83018FDD63888AD3FB6A659", hash_generated_method = "CE6476D72EB149BD76316E0B786363CB")
        public ECFieldElement subtract(final ECFieldElement b) {
            addTaint(b.getTaint());
ECFieldElement var9DB025919878C446BA442101E8E28F74_1514308189 =             add(b);
            var9DB025919878C446BA442101E8E28F74_1514308189.addTaint(taint);
            return var9DB025919878C446BA442101E8E28F74_1514308189;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.954 -0400", hash_original_method = "CFFAAAAE4FA7236DDDBD1DC710F4AF58", hash_generated_method = "041375785802C207DDFB632AB79A28D0")
        public ECFieldElement multiply(final ECFieldElement b) {
            addTaint(b.getTaint());
            F2m bF2m = (F2m)b;
            IntArray mult = x.multiply(bF2m.x, m);
            mult.reduce(m, new int[]{k1, k2, k3});
ECFieldElement var607E4A0964B00B8064FAFC5C09036C82_2100503010 =             new F2m(m, k1, k2, k3, mult);
            var607E4A0964B00B8064FAFC5C09036C82_2100503010.addTaint(taint);
            return var607E4A0964B00B8064FAFC5C09036C82_2100503010;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.954 -0400", hash_original_method = "69832D94122014C087767F6408988886", hash_generated_method = "A8B949C37F8C677FA7524A79B6F207B1")
        public ECFieldElement divide(final ECFieldElement b) {
            addTaint(b.getTaint());
            ECFieldElement bInv = b.invert();
ECFieldElement var59F8A028BD520BE6E99E368FC9AFB90A_159941033 =             multiply(bInv);
            var59F8A028BD520BE6E99E368FC9AFB90A_159941033.addTaint(taint);
            return var59F8A028BD520BE6E99E368FC9AFB90A_159941033;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.954 -0400", hash_original_method = "3796F7BD0BD7CB77DE18BFC002B0C069", hash_generated_method = "10F91E2D6B9E72E111818B9D5A067193")
        public ECFieldElement negate() {
ECFieldElement var72A74007B2BE62B849F475C7BDA4658B_591888896 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_591888896.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_591888896;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.954 -0400", hash_original_method = "C7941F6A7028361E62B5AB4ECF6F47B0", hash_generated_method = "7804F45FFB380312A17F1F967714422C")
        public ECFieldElement square() {
            IntArray squared = x.square(m);
            squared.reduce(m, new int[]{k1, k2, k3});
ECFieldElement var974601C2E38A39842811A3629969E27D_1604657184 =             new F2m(m, k1, k2, k3, squared);
            var974601C2E38A39842811A3629969E27D_1604657184.addTaint(taint);
            return var974601C2E38A39842811A3629969E27D_1604657184;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.955 -0400", hash_original_method = "1700F54C0CA191DF0B1880FDDD97556A", hash_generated_method = "6A253DD5BE089FB0F5ECF6CD2C6BF7E5")
        public ECFieldElement invert() {
            IntArray uz = (IntArray)this.x.clone();
            IntArray vz = new IntArray(t);
            vz.setBit(m);
            vz.setBit(0);
            vz.setBit(this.k1);
    if(this.representation == PPB)            
            {
                vz.setBit(this.k2);
                vz.setBit(this.k3);
            } 
            IntArray g1z = new IntArray(t);
            g1z.setBit(0);
            IntArray g2z = new IntArray(t);
            while
(!uz.isZero())            
            {
                int j = uz.bitLength() - vz.bitLength();
    if(j < 0)                
                {
                    final IntArray uzCopy = uz;
                    uz = vz;
                    vz = uzCopy;
                    final IntArray g1zCopy = g1z;
                    g1z = g2z;
                    g2z = g1zCopy;
                    j = -j;
                } 
                int jInt = j >> 5;
                int jBit = j & 0x1F;
                IntArray vzShift = vz.shiftLeft(jBit);
                uz.addShifted(vzShift, jInt);
                IntArray g2zShift = g2z.shiftLeft(jBit);
                g1z.addShifted(g2zShift, jInt);
            } 
ECFieldElement varDA978903C722F906B630B871248C94CE_371376885 =             new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, g2z);
            varDA978903C722F906B630B871248C94CE_371376885.addTaint(taint);
            return varDA978903C722F906B630B871248C94CE_371376885;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.955 -0400", hash_original_method = "3F2FB8B8358C44CE763B294C61568C61", hash_generated_method = "B7AE3598836DCD616F9ADDD1C4CF2967")
        public ECFieldElement sqrt() {
            RuntimeException varECF25F51942B946710F937BB139F9A1F_232930192 = new RuntimeException("Not implemented");
            varECF25F51942B946710F937BB139F9A1F_232930192.addTaint(taint);
            throw varECF25F51942B946710F937BB139F9A1F_232930192;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.955 -0400", hash_original_method = "F44EC09A2F605B64D128CF1FD080E96F", hash_generated_method = "BC0C304326BE5C4C0E2FBB6F0AE4970C")
        public int getRepresentation() {
            int var0D93DB0C2F85BACA29F992F68B556671_856096375 = (this.representation);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915477908 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915477908;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.955 -0400", hash_original_method = "16D4D66DBFDF91ECDD28D772829DE89A", hash_generated_method = "144C8B3984C51B202FEA2F9996629F3B")
        public int getM() {
            int varE232824FC708DC9890A445C590D5EF7B_35172350 = (this.m);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973394582 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973394582;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.955 -0400", hash_original_method = "788DAA97D92752E8BB2DDD2E9F6BC21F", hash_generated_method = "E27003F390E7B38F7EEDCD4DEE489C3B")
        public int getK1() {
            int var4D98D917A246DCDB89729CDA9C120415_1602758714 = (this.k1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806761141 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806761141;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.955 -0400", hash_original_method = "F79890B1EB0EE6C2416B5951B6A3A0C5", hash_generated_method = "1BABC8BB7E6035DE289A409AAAD01B43")
        public int getK2() {
            int varFA3D3267307EA8828AD1C37F5BAACCCD_812121527 = (this.k2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184109323 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184109323;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.956 -0400", hash_original_method = "1D65CE2828E295283E79F47AB831B6A0", hash_generated_method = "ACA63DD12A65C726A7F6811637765B90")
        public int getK3() {
            int var1E5396ECC021351D2F4DD73E5E502D13_785550655 = (this.k3);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33404445 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33404445;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.956 -0400", hash_original_method = "3D5105255A9EFAC151D1697019D15B93", hash_generated_method = "BE4DCE36D8D54FE2C23AB554A6E20AB0")
        public boolean equals(Object anObject) {
            addTaint(anObject.getTaint());
    if(anObject == this)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_126598188 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1990870745 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1990870745;
            } 
    if(!(anObject instanceof ECFieldElement.F2m))            
            {
                boolean var68934A3E9455FA72420237EB05902327_48190399 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182584152 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182584152;
            } 
            ECFieldElement.F2m b = (ECFieldElement.F2m)anObject;
            boolean var45C74E10B2A26CE15CD2929040B64F12_1958367507 = (((this.m == b.m) && (this.k1 == b.k1) && (this.k2 == b.k2)
                && (this.k3 == b.k3)
                && (this.representation == b.representation)
                && (this.x.equals(b.x))));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_405353834 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_405353834;
            
            
            
                
            
            
            
                
            
            
            
                
                
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.956 -0400", hash_original_method = "A8D83F5F73395A245F39934AB1D46428", hash_generated_method = "5E69A45A9DB411FF28B83924448BA847")
        public int hashCode() {
            int varC8F32407834A0DEC4D476D4A528031C7_908818996 = (x.hashCode() ^ m ^ k1 ^ k2 ^ k3);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024933196 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024933196;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.956 -0400", hash_original_field = "E8B41906FE7C3E4F22325A5FFD12E34F", hash_generated_field = "1EF437C47631F0C3F3BB2EA100DFE875")

        public static final int GNB = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.956 -0400", hash_original_field = "B8232562CF38D3B220C5996492FFB291", hash_generated_field = "37EF4BAB1D77E666E3DAF9CFE4014569")

        public static final int TPB = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.956 -0400", hash_original_field = "EB22FE82A7FB60D3261A608321D0EB45", hash_generated_field = "895352A09857F9070F0E8B8F7FB4EE8F")

        public static final int PPB = 3;
    }


    
}

