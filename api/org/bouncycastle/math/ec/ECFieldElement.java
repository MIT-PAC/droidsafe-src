package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.util.Random;






public abstract class ECFieldElement implements ECConstants {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.559 -0400", hash_original_method = "18B929116CB81747CE726807F2C6A2C0", hash_generated_method = "18B929116CB81747CE726807F2C6A2C0")
    public ECFieldElement ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.096 -0500", hash_original_method = "9E64A0384813C139C8C18942EDABD461", hash_generated_method = "D019B0AC7A8E81D32509DFDB9D8F8B1A")
    public abstract BigInteger     toBigInteger();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.097 -0500", hash_original_method = "41F7C7FADBD9EE43B16E448C99FA24E8", hash_generated_method = "970B73DD1B610F8DEB3601DBDCE110C6")
    public abstract String         getFieldName();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.097 -0500", hash_original_method = "049FE0DFDB7700333EFC0A96FA9B412C", hash_generated_method = "3844C5B4D6AA3EBAD6B265D6EEF27356")
    public abstract int            getFieldSize();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.098 -0500", hash_original_method = "FE7B548CCAEFD218D5A78826C5919A75", hash_generated_method = "2CFEBC4236BDD897199025E0545F7134")
    public abstract ECFieldElement add(ECFieldElement b);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.099 -0500", hash_original_method = "B19CF8FF2C3438D63E73CD809F752C16", hash_generated_method = "9DE26FC9A3938F11B3CE84223C3840E4")
    public abstract ECFieldElement subtract(ECFieldElement b);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.100 -0500", hash_original_method = "685EA3BE2F341D8641A4511F0DB3B370", hash_generated_method = "4210053576BC21241BA818E79C8B6527")
    public abstract ECFieldElement multiply(ECFieldElement b);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.101 -0500", hash_original_method = "60CD11732881C97747F463FB17944C57", hash_generated_method = "2C70415E9E79F21F9F5A8C124D8E4F72")
    public abstract ECFieldElement divide(ECFieldElement b);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.101 -0500", hash_original_method = "AF79AB5B6AA69D39E95B0C317656FB1D", hash_generated_method = "94CBC5C627AAB21CF070F4FBE1F31CD2")
    public abstract ECFieldElement negate();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.102 -0500", hash_original_method = "2A7EC7F73312E0B70E4512A1A74B027F", hash_generated_method = "29FE87CC60A039660C95C3545403E18E")
    public abstract ECFieldElement square();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.103 -0500", hash_original_method = "E51652288AFA3A5841DE5E91510D9072", hash_generated_method = "01A5C4144B75C55A0412A9B3E269DFE4")
    public abstract ECFieldElement invert();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.104 -0500", hash_original_method = "11C516C66C5B0E5F8E69FBD1637FC5C1", hash_generated_method = "4FDC64545114C53F4883902C32A74A5B")
    public abstract ECFieldElement sqrt();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.105 -0500", hash_original_method = "0A600F50B2D3858965A3E5F0EE37FE95", hash_generated_method = "AAF64298068B399683E7AB08A7A9CD52")
    public String toString()
    {
        return this.toBigInteger().toString(2);
    }

    
    public static class Fp extends ECFieldElement {

//        private static BigInteger W(BigInteger n, BigInteger wOne, BigInteger p)
//        {
//            if (n.equals(ECConstants.ONE))
//            {
//                return wOne;
//            }
//            boolean isEven = !n.testBit(0);
//            n = n.shiftRight(1);//divide(ECConstants.TWO);
//            if (isEven)
//            {
//                BigInteger w = W(n, wOne, p);
//                return w.multiply(w).subtract(ECConstants.TWO).mod(p);
//            }
//            BigInteger w1 = W(n.add(ECConstants.ONE), wOne, p);
//            BigInteger w2 = W(n, wOne, p);
//            return w1.multiply(w2).subtract(wOne).mod(p);
//        }
//
//        private BigInteger WOne(BigInteger r, BigInteger x, BigInteger p)
//        {
//            return r.multiply(r).multiply(x.modPow(q.subtract(ECConstants.TWO), q)).subtract(ECConstants.TWO).mod(p);
//        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.120 -0500", hash_original_method = "DEDA72BB3BC7F2527613E85E73782946", hash_generated_method = "C5E7A4839B36FAA5E820775C713A22AC")
        private static BigInteger[] lucasSequence(
            BigInteger  p,
            BigInteger  P,
            BigInteger  Q,
            BigInteger  k)
        {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.106 -0500", hash_original_field = "8A69D3B9CF67CA1128DF293842071E77", hash_generated_field = "8A69D3B9CF67CA1128DF293842071E77")

        BigInteger x;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.107 -0500", hash_original_field = "F819999E3B2036A19089F4FD0B5D94F4", hash_generated_field = "F819999E3B2036A19089F4FD0B5D94F4")


        BigInteger q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.108 -0500", hash_original_method = "2CEE87D2C14E1CA252587D4A1EA48723", hash_generated_method = "77745575E488D95CB146132B51A50135")
        public Fp(BigInteger q, BigInteger x)
        {
            this.x = x;
            
            if (x.compareTo(q) >= 0)
            {
                throw new IllegalArgumentException("x value too large in field element");
            }

            this.q = q;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.109 -0500", hash_original_method = "980758C44AA9D55BE8845E0F1627D066", hash_generated_method = "508A260C0585F9637F42BF65C303454A")
        public BigInteger toBigInteger()
        {
            return x;
        }

        /**
         * return the field name for this field.
         *
         * @return the string "Fp".
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.109 -0500", hash_original_method = "0E8B7E675C6828F2CC0DC48F96E6F8E3", hash_generated_method = "4562F25F0FB7AC60AA9B6809DD02431C")
        public String getFieldName()
        {
            return "Fp";
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.111 -0500", hash_original_method = "B586F82D19D11BCE8142121499961CE9", hash_generated_method = "BE36EEF9E25071934284DA64A6AF711B")
        public int getFieldSize()
        {
            return q.bitLength();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.111 -0500", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "5A6F1A696B2A6370C598909B1A9A2601")
        public BigInteger getQ()
        {
            return q;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.112 -0500", hash_original_method = "81C2635B1C8BBF0D98329C00DDA86CBF", hash_generated_method = "EAF5DB3EF67DB5C2950C7A529A0B52F1")
        public ECFieldElement add(ECFieldElement b)
        {
            return new Fp(q, x.add(b.toBigInteger()).mod(q));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.113 -0500", hash_original_method = "CC55B0F5614FEECA03D2E059411B5A62", hash_generated_method = "B41B14911A7F052341AB66D9827E725D")
        public ECFieldElement subtract(ECFieldElement b)
        {
            return new Fp(q, x.subtract(b.toBigInteger()).mod(q));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.114 -0500", hash_original_method = "8FDF6CC967FA6FBF2AB862654F18B35A", hash_generated_method = "E664CB7B5F8251617C0A4754AB886A06")
        public ECFieldElement multiply(ECFieldElement b)
        {
            return new Fp(q, x.multiply(b.toBigInteger()).mod(q));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.115 -0500", hash_original_method = "273EB04F445D1E8BD427B46F09A750C8", hash_generated_method = "09F5549DF7B9BCB88E86DA9B58FF7F3A")
        public ECFieldElement divide(ECFieldElement b)
        {
            return new Fp(q, x.multiply(b.toBigInteger().modInverse(q)).mod(q));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.115 -0500", hash_original_method = "9EF54D69A52E7076272AA6C8111B6A31", hash_generated_method = "4A50A70213BF4C9DE49AE89AF6AFCA7B")
        public ECFieldElement negate()
        {
            return new Fp(q, x.negate().mod(q));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.116 -0500", hash_original_method = "1F15D9F4F3F7C45F6D78B4A8A149E9FC", hash_generated_method = "B3DE3C77C68C57DCC0264E432C9A261A")
        public ECFieldElement square()
        {
            return new Fp(q, x.multiply(x).mod(q));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.117 -0500", hash_original_method = "87CD41222C6FB4EC59F31E743CC1D431", hash_generated_method = "5CC079EBF440556E2A07180750A49910")
        public ECFieldElement invert()
        {
            return new Fp(q, x.modInverse(q));
        }

        // D.1.4 91
        /**
         * return a sqrt root - the routine verifies that the calculation
         * returns the right value - if none exists it returns null.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.118 -0500", hash_original_method = "27B2154E50FF6039CAEE06398FCA6C60", hash_generated_method = "706CFAEF4A41C8B9F02B38A3F1F473D3")
        public ECFieldElement sqrt()
        {
            if (!q.testBit(0))
            {
                throw new RuntimeException("not done yet");
            }

            // note: even though this class implements ECConstants don't be tempted to
            // remove the explicit declaration, some J2ME environments don't cope.
            // p mod 4 == 3
            if (q.testBit(1))
            {
                // z = g^(u+1) + p, p = 4u + 3
                ECFieldElement z = new Fp(q, x.modPow(q.shiftRight(2).add(ECConstants.ONE), q));

                return z.square().equals(this) ? z : null;
            }

            // p mod 4 == 1
            BigInteger qMinusOne = q.subtract(ECConstants.ONE);

            BigInteger legendreExponent = qMinusOne.shiftRight(1);
            if (!(x.modPow(legendreExponent, q).equals(ECConstants.ONE)))
            {
                return null;
            }

            BigInteger u = qMinusOne.shiftRight(2);
            BigInteger k = u.shiftLeft(1).add(ECConstants.ONE);

            BigInteger Q = this.x;
            BigInteger fourQ = Q.shiftLeft(2).mod(q);

            BigInteger U, V;
            Random rand = new Random();
            do
            {
                BigInteger P;
                do
                {
                    P = new BigInteger(q.bitLength(), rand);
                }
                while (P.compareTo(q) >= 0
                    || !(P.multiply(P).subtract(fourQ).modPow(legendreExponent, q).equals(qMinusOne)));

                BigInteger[] result = lucasSequence(q, P, Q, k);
                U = result[0];
                V = result[1];

                if (V.multiply(V).mod(q).equals(fourQ))
                {
                    // Integer division by 2, mod q
                    if (V.testBit(0))
                    {
                        V = V.add(q);
                    }

                    V = V.shiftRight(1);

                    //assert V.multiply(V).mod(q).equals(x);

                    return new ECFieldElement.Fp(q, V);
                }
            }
            while (U.equals(ECConstants.ONE) || U.equals(qMinusOne));

            return null;

//            BigInteger qMinusOne = q.subtract(ECConstants.ONE);
//            BigInteger legendreExponent = qMinusOne.shiftRight(1); //divide(ECConstants.TWO);
//            if (!(x.modPow(legendreExponent, q).equals(ECConstants.ONE)))
//            {
//                return null;
//            }
//
//            Random rand = new Random();
//            BigInteger fourX = x.shiftLeft(2);
//
//            BigInteger r;
//            do
//            {
//                r = new BigInteger(q.bitLength(), rand);
//            }
//            while (r.compareTo(q) >= 0
//                || !(r.multiply(r).subtract(fourX).modPow(legendreExponent, q).equals(qMinusOne)));
//
//            BigInteger n1 = qMinusOne.shiftRight(2); //.divide(ECConstants.FOUR);
//            BigInteger n2 = n1.add(ECConstants.ONE); //q.add(ECConstants.THREE).divide(ECConstants.FOUR);
//
//            BigInteger wOne = WOne(r, x, q);
//            BigInteger wSum = W(n1, wOne, q).add(W(n2, wOne, q)).mod(q);
//            BigInteger twoR = r.shiftLeft(1); //ECConstants.TWO.multiply(r);
//
//            BigInteger root = twoR.modPow(q.subtract(ECConstants.TWO), q)
//                .multiply(x).mod(q)
//                .multiply(wSum).mod(q);
//
//            return new Fp(q, root);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.121 -0500", hash_original_method = "F275DE81E4C5BCC7A64CB08B0E3C6B94", hash_generated_method = "1F34429F5D6DFE5D5051FFD921BEAC80")
        public boolean equals(Object other)
        {
            if (other == this)
            {
                return true;
            }

            if (!(other instanceof ECFieldElement.Fp))
            {
                return false;
            }
            
            ECFieldElement.Fp o = (ECFieldElement.Fp)other;
            return q.equals(o.q) && x.equals(o.x);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.121 -0500", hash_original_method = "61E77154098D5712686019259E83DC28", hash_generated_method = "D3534BB2ACB8A289C0DB7F908018F0E4")
        public int hashCode()
        {
            return q.hashCode() ^ x.hashCode();
        }

        
    }


    
    public static class F2m extends ECFieldElement {

        /**
         * Checks, if the ECFieldElements <code>a</code> and <code>b</code>
         * are elements of the same field <code>F<sub>2<sup>m</sup></sub></code>
         * (having the same representation).
         * @param a field element.
         * @param b field element to be compared.
         * @throws IllegalArgumentException if <code>a</code> and <code>b</code>
         * are not elements of the same field
         * <code>F<sub>2<sup>m</sup></sub></code> (having the same
         * representation). 
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.139 -0500", hash_original_method = "EFD2C262AFB594800501832A2DE2EA78", hash_generated_method = "1AD0D5E39A95787E7D77A065A81E30BD")
        public static void checkFieldElements(
            ECFieldElement a,
            ECFieldElement b)
        {
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
                // Should never occur
                throw new IllegalArgumentException(
                        "One of the field "
                                + "elements are not elements has incorrect representation");
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.124 -0500", hash_original_field = "9EB0EFF3B62C52F7E0C7FB8422D39504", hash_generated_field = "1EF437C47631F0C3F3BB2EA100DFE875")

        public static final int GNB = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.125 -0500", hash_original_field = "4343F651FF1731A71ACB3E5C431098E6", hash_generated_field = "37EF4BAB1D77E666E3DAF9CFE4014569")

        public static final int TPB = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.126 -0500", hash_original_field = "7619B853EFC86C61B0D0D65AB44A72D7", hash_generated_field = "895352A09857F9070F0E8B8F7FB4EE8F")

        public static final int PPB = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.127 -0500", hash_original_field = "E6903185F6AC4CCD8D38CAD924839585", hash_generated_field = "05684F2BDAA8EE0BD6A4A6166AA30FB6")

        private int representation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.128 -0500", hash_original_field = "2E6007DAD305AA160976D52F2273ECD5", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

        private int m;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.129 -0500", hash_original_field = "B4EEC5F223717033A283932A5AD23EED", hash_generated_field = "82BC5D885288BEA8F058C8200E42732B")

        private int k1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.130 -0500", hash_original_field = "65F94392BC495DE78362F9AE43CD3627", hash_generated_field = "9A9BABB98FA71DB4E862A96C38A0DEB5")

        private int k2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.130 -0500", hash_original_field = "5B3915949FC034D039892BB72C0B7484", hash_generated_field = "B93297072479995D07A6DAC48610EF09")

        private int k3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.131 -0500", hash_original_field = "CCFF463AC196FE3F9D705CD3632EA1A7", hash_generated_field = "8009D56CC2C16E6B1ECA88AD9DDD4454")

        private IntArray x;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.132 -0500", hash_original_field = "8BD9148C438167020AAE77322F624897", hash_generated_field = "C6BE2DA2DF5011CA37BB619361E1CF67")

        private int t;

        /**
         * Constructor for PPB.
         * @param m  The exponent <code>m</code> of
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param k1 The integer <code>k1</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.
         * @param k2 The integer <code>k2</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.
         * @param k3 The integer <code>k3</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.
         * @param x The BigInteger representing the value of the field element.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.133 -0500", hash_original_method = "30B70FEF02DF1B2128C82CD1FCC1318F", hash_generated_method = "947EF545C9B7CFA62D93BA764DF29AF1")
        public F2m(
            int m, 
            int k1, 
            int k2, 
            int k3,
            BigInteger x)
        {
            // t = m / 32 rounded up to the next integer
            t = (m + 31) >> 5;
            this.x = new IntArray(x, t);

            if ((k2 == 0) && (k3 == 0))
            {
                this.representation = TPB;
            }
            else
            {
                if (k2 >= k3)
                {
                    throw new IllegalArgumentException(
                            "k2 must be smaller than k3");
                }
                if (k2 <= 0)
                {
                    throw new IllegalArgumentException(
                            "k2 must be larger than 0");
                }
                this.representation = PPB;
            }

            if (x.signum() < 0)
            {
                throw new IllegalArgumentException("x value cannot be negative");
            }

            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
        }

        /**
         * Constructor for TPB.
         * @param m  The exponent <code>m</code> of
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param k The integer <code>k</code> where <code>x<sup>m</sup> +
         * x<sup>k</sup> + 1</code> represents the reduction
         * polynomial <code>f(z)</code>.
         * @param x The BigInteger representing the value of the field element.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.134 -0500", hash_original_method = "769D94FCBFF8D8B7B44421BAE1CCBF10", hash_generated_method = "3C4D7F308895AC4E3F9D01C63E71A96D")
        public F2m(int m, int k, BigInteger x)
        {
            // Set k1 to k, and set k2 and k3 to 0
            this(m, k, 0, 0, x);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.136 -0500", hash_original_method = "E37831F6788FECA0B3C28407A9D117A4", hash_generated_method = "0FD2A434CAB8A27EC3DFFFCDFEB4672C")
        private F2m(int m, int k1, int k2, int k3, IntArray x)
        {
            t = (m + 31) >> 5;
            this.x = x;
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;

            if ((k2 == 0) && (k3 == 0))
            {
                this.representation = TPB;
            }
            else
            {
                this.representation = PPB;
            }

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.136 -0500", hash_original_method = "D9240AE462D2FCFCBEB9680DA07047D8", hash_generated_method = "A5CA982AA3200F146BA78A1E76E8D8FA")
        public BigInteger toBigInteger()
        {
            return x.toBigInteger();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.137 -0500", hash_original_method = "69EE8C1832EFB43BF906E0C4BE94B23A", hash_generated_method = "F179C8D2C271A87EFD38B16312BA8369")
        public String getFieldName()
        {
            return "F2m";
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.138 -0500", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "EAD5E6876F72339E90584D56D39C2570")
        public int getFieldSize()
        {
            return m;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.140 -0500", hash_original_method = "1771E6C8DC949344BED4A1E6536DC20F", hash_generated_method = "CE2938A9EDB9F4FBFA6824F689E2D694")
        public ECFieldElement add(final ECFieldElement b)
        {
            // No check performed here for performance reasons. Instead the
            // elements involved are checked in ECPoint.F2m
            // checkFieldElements(this, b);
            IntArray iarrClone = (IntArray)this.x.clone();
            F2m bF2m = (F2m)b;
            iarrClone.addShifted(bF2m.x, 0);
            return new F2m(m, k1, k2, k3, iarrClone);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.141 -0500", hash_original_method = "DED14713A83018FDD63888AD3FB6A659", hash_generated_method = "27611E855CF96F4D7A3075F9F942623E")
        public ECFieldElement subtract(final ECFieldElement b)
        {
            // Addition and subtraction are the same in F2m
            return add(b);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.142 -0500", hash_original_method = "CFFAAAAE4FA7236DDDBD1DC710F4AF58", hash_generated_method = "B9A8E4782A10FF14CFD19E586D59A9A9")
        public ECFieldElement multiply(final ECFieldElement b)
        {
            // Right-to-left comb multiplication in the IntArray
            // Input: Binary polynomials a(z) and b(z) of degree at most m-1
            // Output: c(z) = a(z) * b(z) mod f(z)

            // No check performed here for performance reasons. Instead the
            // elements involved are checked in ECPoint.F2m
            // checkFieldElements(this, b);
            F2m bF2m = (F2m)b;
            IntArray mult = x.multiply(bF2m.x, m);
            mult.reduce(m, new int[]{k1, k2, k3});
            return new F2m(m, k1, k2, k3, mult);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.143 -0500", hash_original_method = "69832D94122014C087767F6408988886", hash_generated_method = "DB1BADF37B0D582D59450B2147B08434")
        public ECFieldElement divide(final ECFieldElement b)
        {
            // There may be more efficient implementations
            ECFieldElement bInv = b.invert();
            return multiply(bInv);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.144 -0500", hash_original_method = "3796F7BD0BD7CB77DE18BFC002B0C069", hash_generated_method = "C340B0CC8F1204F8D045B4A8E7B936D4")
        public ECFieldElement negate()
        {
            // -x == x holds for all x in F2m
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.145 -0500", hash_original_method = "C7941F6A7028361E62B5AB4ECF6F47B0", hash_generated_method = "588629B31CB984D711A00770B43E5DCA")
        public ECFieldElement square()
        {
            IntArray squared = x.square(m);
            squared.reduce(m, new int[]{k1, k2, k3});
            return new F2m(m, k1, k2, k3, squared);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.146 -0500", hash_original_method = "1700F54C0CA191DF0B1880FDDD97556A", hash_generated_method = "5A9DF09BBD4B02075EE4FE9FBE27A95C")
        public ECFieldElement invert()
        {
            // Inversion in F2m using the extended Euclidean algorithm
            // Input: A nonzero polynomial a(z) of degree at most m-1
            // Output: a(z)^(-1) mod f(z)

            // u(z) := a(z)
            IntArray uz = (IntArray)this.x.clone();

            // v(z) := f(z)
            IntArray vz = new IntArray(t);
            vz.setBit(m);
            vz.setBit(0);
            vz.setBit(this.k1);
            if (this.representation == PPB) 
            {
                vz.setBit(this.k2);
                vz.setBit(this.k3);
            }

            // g1(z) := 1, g2(z) := 0
            IntArray g1z = new IntArray(t);
            g1z.setBit(0);
            IntArray g2z = new IntArray(t);

            // while u != 0
            while (!uz.isZero())
//            while (uz.getUsedLength() > 0)
//            while (uz.bitLength() > 1)
            {
                // j := deg(u(z)) - deg(v(z))
                int j = uz.bitLength() - vz.bitLength();

                // If j < 0 then: u(z) <-> v(z), g1(z) <-> g2(z), j := -j
                if (j < 0) 
                {
                    final IntArray uzCopy = uz;
                    uz = vz;
                    vz = uzCopy;

                    final IntArray g1zCopy = g1z;
                    g1z = g2z;
                    g2z = g1zCopy;

                    j = -j;
                }

                // u(z) := u(z) + z^j * v(z)
                // Note, that no reduction modulo f(z) is required, because
                // deg(u(z) + z^j * v(z)) <= max(deg(u(z)), j + deg(v(z)))
                // = max(deg(u(z)), deg(u(z)) - deg(v(z)) + deg(v(z))
                // = deg(u(z))
                // uz = uz.xor(vz.shiftLeft(j));
                // jInt = n / 32
                int jInt = j >> 5;
                // jInt = n % 32
                int jBit = j & 0x1F;
                IntArray vzShift = vz.shiftLeft(jBit);
                uz.addShifted(vzShift, jInt);

                // g1(z) := g1(z) + z^j * g2(z)
//                g1z = g1z.xor(g2z.shiftLeft(j));
                IntArray g2zShift = g2z.shiftLeft(jBit);
                g1z.addShifted(g2zShift, jInt);
                
            }
            return new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, g2z);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.147 -0500", hash_original_method = "3F2FB8B8358C44CE763B294C61568C61", hash_generated_method = "3B007276603815E3CCBBFE5278D9F639")
        public ECFieldElement sqrt()
        {
            throw new RuntimeException("Not implemented");
        }

        /**
         * @return the representation of the field
         * <code>F<sub>2<sup>m</sup></sub></code>, either of
         * TPB (trinomial
         * basis representation) or
         * PPB (pentanomial
         * basis representation).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.147 -0500", hash_original_method = "F44EC09A2F605B64D128CF1FD080E96F", hash_generated_method = "48427575190664C4FBAFD169FF89F5C0")
        public int getRepresentation()
        {
            return this.representation;
        }

        /**
         * @return the degree <code>m</code> of the reduction polynomial
         * <code>f(z)</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.148 -0500", hash_original_method = "16D4D66DBFDF91ECDD28D772829DE89A", hash_generated_method = "46962CFADF33F6910E2D99DC4DE1CF0C")
        public int getM()
        {
            return this.m;
        }

        /**
         * @return TPB: The integer <code>k</code> where <code>x<sup>m</sup> +
         * x<sup>k</sup> + 1</code> represents the reduction polynomial
         * <code>f(z)</code>.<br>
         * PPB: The integer <code>k1</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.<br>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.149 -0500", hash_original_method = "788DAA97D92752E8BB2DDD2E9F6BC21F", hash_generated_method = "DDB42BBAB8664FDA2032DAEDE89BB192")
        public int getK1()
        {
            return this.k1;
        }

        /**
         * @return TPB: Always returns <code>0</code><br>
         * PPB: The integer <code>k2</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.<br>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.150 -0500", hash_original_method = "F79890B1EB0EE6C2416B5951B6A3A0C5", hash_generated_method = "B9BB47CF12275848BE18DAA95CD80C8F")
        public int getK2()
        {
            return this.k2;
        }

        /**
         * @return TPB: Always set to <code>0</code><br>
         * PPB: The integer <code>k3</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.<br>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.151 -0500", hash_original_method = "1D65CE2828E295283E79F47AB831B6A0", hash_generated_method = "06C36E3CA6395ABA9C9AF3F70B48A434")
        public int getK3()
        {
            return this.k3;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.152 -0500", hash_original_method = "3D5105255A9EFAC151D1697019D15B93", hash_generated_method = "A7EF6F2ED25B2D3AA8D469F9CDBE00F9")
        public boolean equals(Object anObject)
        {
            if (anObject == this) 
            {
                return true;
            }

            if (!(anObject instanceof ECFieldElement.F2m)) 
            {
                return false;
            }

            ECFieldElement.F2m b = (ECFieldElement.F2m)anObject;
            
            return ((this.m == b.m) && (this.k1 == b.k1) && (this.k2 == b.k2)
                && (this.k3 == b.k3)
                && (this.representation == b.representation)
                && (this.x.equals(b.x)));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.153 -0500", hash_original_method = "A8D83F5F73395A245F39934AB1D46428", hash_generated_method = "FDF27C5EF3AEE3C3A9BC32AD796AF681")
        public int hashCode()
        {
            return x.hashCode() ^ m ^ k1 ^ k2 ^ k3;
        }
    }


    
}

