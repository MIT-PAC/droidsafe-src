package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.util.Random;

public abstract class ECCurve {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.434 -0400", hash_original_field = "0CC175B9C0F1B6A831C399E269772661", hash_generated_field = "16F3809D308EE3B5C0D90855C77B94DD")

    ECFieldElement a;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.434 -0400", hash_original_field = "92EB5FFEE6AE2FEC3AD71C777531578F", hash_generated_field = "2E1C114DB6D3D5AFAFE6B5C7A24A4397")

    ECFieldElement b;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.434 -0400", hash_original_method = "3ADB63016220614BC8D776351AA4CC0A", hash_generated_method = "3ADB63016220614BC8D776351AA4CC0A")
    public ECCurve ()
    {
        //Synthesized constructor
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.356 -0500", hash_original_method = "049FE0DFDB7700333EFC0A96FA9B412C", hash_generated_method = "3844C5B4D6AA3EBAD6B265D6EEF27356")
    
public abstract int getFieldSize();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.359 -0500", hash_original_method = "3D6D3EF0744DE46C1F9ACFF7BCF6B56A", hash_generated_method = "5F95358FEE194DDE6AEF8A74C3098A2C")
    
public abstract ECFieldElement fromBigInteger(BigInteger x);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.361 -0500", hash_original_method = "54455430F471E362D58EF538D2206349", hash_generated_method = "9F87C4DF9826A02E10F1D66108A25E64")
    
public abstract ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.363 -0500", hash_original_method = "1E3378C62F91145B97F5D9E85D7CEA2B", hash_generated_method = "8CA4F841079681A56DD72F303AC60C54")
    
public abstract ECPoint decodePoint(byte[] encoded);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.365 -0500", hash_original_method = "615D49EF5F12A586033279BE94C6DFFE", hash_generated_method = "17AE2F5C1FB783CE7E47897BB2CD5A30")
    
public abstract ECPoint getInfinity();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.368 -0500", hash_original_method = "E518DFD3A1B52E4C2FA641AF9C8BD0EA", hash_generated_method = "74BF6B3FC562C02CF6BD7E7005270454")
    
public ECFieldElement getA()
    {
        return a;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.370 -0500", hash_original_method = "E3D5F4BB1EEF47030E7E58DC1A7D0CBC", hash_generated_method = "D4E19A84BCBE57FE16AD1A2EF62BF137")
    
public ECFieldElement getB()
    {
        return b;
    }
    
    public static class Fp extends ECCurve {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.373 -0500", hash_original_field = "F819999E3B2036A19089F4FD0B5D94F4", hash_generated_field = "F819999E3B2036A19089F4FD0B5D94F4")

        BigInteger q;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.375 -0500", hash_original_field = "69A238B6B16C69E09404578CE64545C8", hash_generated_field = "69A238B6B16C69E09404578CE64545C8")

        ECPoint.Fp infinity;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.378 -0500", hash_original_method = "22B1E0FEEF98DB62B3F95091656AE119", hash_generated_method = "6DDDED542CC2D9C77B723F446C597753")
        
public Fp(BigInteger q, BigInteger a, BigInteger b)
        {
            this.q = q;
            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.infinity = new ECPoint.Fp(this, null, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.380 -0500", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "5A6F1A696B2A6370C598909B1A9A2601")
        
public BigInteger getQ()
        {
            return q;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.382 -0500", hash_original_method = "B586F82D19D11BCE8142121499961CE9", hash_generated_method = "BE36EEF9E25071934284DA64A6AF711B")
        
public int getFieldSize()
        {
            return q.bitLength();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.384 -0500", hash_original_method = "717FAD51B8C0866C7878DF981123AAA4", hash_generated_method = "2D6212D9D32D62AE180EA47511B16289")
        
public ECFieldElement fromBigInteger(BigInteger x)
        {
            return new ECFieldElement.Fp(this.q, x);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.387 -0500", hash_original_method = "E2F0508F86D70ECB95714B920D7ED166", hash_generated_method = "B2DBD1296617EB1265BC30516D210F8B")
        
public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression)
        {
            return new ECPoint.Fp(this, fromBigInteger(x), fromBigInteger(y), withCompression);
        }

        /**
         * Decode a point on this curve from its ASN.1 encoding. The different
         * encodings are taken account of, including point compression for
         * <code>F<sub>p</sub></code> (X9.62 s 4.2.1 pg 17).
         * @return The decoded point.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.390 -0500", hash_original_method = "1737D5EF0BE777F7A805235738F1CA68", hash_generated_method = "530826C663E8C4C5C338891159671691")
        
public ECPoint decodePoint(byte[] encoded)
        {
            ECPoint p = null;

            switch (encoded[0])
            {
                // infinity
            case 0x00:
                if (encoded.length > 1)
                {
                    throw new RuntimeException("Invalid point encoding");
                }
                p = getInfinity();
                break;
                // compressed
            case 0x02:
            case 0x03:
                int ytilde = encoded[0] & 1;
                byte[]  i = new byte[encoded.length - 1];

                System.arraycopy(encoded, 1, i, 0, i.length);

                ECFieldElement x = new ECFieldElement.Fp(this.q, new BigInteger(1, i));
                ECFieldElement alpha = x.multiply(x.square().add(a)).add(b);
                ECFieldElement beta = alpha.sqrt();

                //
                // if we can't find a sqrt we haven't got a point on the
                // curve - run!
                //
                if (beta == null)
                {
                    throw new RuntimeException("Invalid point compression");
                }

                int bit0 = (beta.toBigInteger().testBit(0) ? 1 : 0);

                if (bit0 == ytilde)
                {
                    p = new ECPoint.Fp(this, x, beta, true);
                }
                else
                {
                    p = new ECPoint.Fp(this, x,
                        new ECFieldElement.Fp(this.q, q.subtract(beta.toBigInteger())), true);
                }
                break;
                // uncompressed
            case 0x04:
                // hybrid
            case 0x06:
            case 0x07:
                byte[]  xEnc = new byte[(encoded.length - 1) / 2];
                byte[]  yEnc = new byte[(encoded.length - 1) / 2];

                System.arraycopy(encoded, 1, xEnc, 0, xEnc.length);
                System.arraycopy(encoded, xEnc.length + 1, yEnc, 0, yEnc.length);

                p = new ECPoint.Fp(this,
                        new ECFieldElement.Fp(this.q, new BigInteger(1, xEnc)),
                        new ECFieldElement.Fp(this.q, new BigInteger(1, yEnc)));
                break;
            default:
                throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(encoded[0], 16));
            }

            return p;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.393 -0500", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "68999FA4D910D8C84056051E09CFF4FF")
        
public ECPoint getInfinity()
        {
            return infinity;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.395 -0500", hash_original_method = "937E7F8C7D7C20805F9F2153639BF5E3", hash_generated_method = "45D94D1D50FECC14941481469A03DA13")
        
public boolean equals(
            Object anObject) 
        {
            if (anObject == this) 
            {
                return true;
            }

            if (!(anObject instanceof ECCurve.Fp)) 
            {
                return false;
            }

            ECCurve.Fp other = (ECCurve.Fp) anObject;

            return this.q.equals(other.q) 
                    && a.equals(other.a) && b.equals(other.b);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.398 -0500", hash_original_method = "0595BFE04038932B73D34C7D5BF16F78", hash_generated_method = "31A4878ACD6F34DAB83FC535F7DA5760")
        
public int hashCode() 
        {
            return a.hashCode() ^ b.hashCode() ^ q.hashCode();
        }
        
    }
    
    public static class F2m extends ECCurve {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.403 -0500", hash_original_field = "2E6007DAD305AA160976D52F2273ECD5", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

        private int m;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.405 -0500", hash_original_field = "B4EEC5F223717033A283932A5AD23EED", hash_generated_field = "8A92C5A989925989FFD9F1E441F94F46")

        /**
         * TPB: The integer <code>k</code> where <code>x<sup>m</sup> +
         * x<sup>k</sup> + 1</code> represents the reduction polynomial
         * <code>f(z)</code>.<br>
         * PPB: The integer <code>k1</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.<br>
         */
        private int k1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.408 -0500", hash_original_field = "65F94392BC495DE78362F9AE43CD3627", hash_generated_field = "5FC8E9E4C17F1B615F13D4FBD274B4F2")

        /**
         * TPB: Always set to <code>0</code><br>
         * PPB: The integer <code>k2</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.<br>
         */
        private int k2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.411 -0500", hash_original_field = "5B3915949FC034D039892BB72C0B7484", hash_generated_field = "DCE0BF3CAA63AC2524F01CEA5F451A43")

        /**
         * TPB: Always set to <code>0</code><br>
         * PPB: The integer <code>k3</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.<br>
         */
        private int k3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.413 -0500", hash_original_field = "C5269AA669EF1E6636D1450EA530C9C5", hash_generated_field = "2DB749C7BBBB3CA6E91E42B798C94290")

        /**
         * The order of the base point of the curve.
         */
        private BigInteger n;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.415 -0500", hash_original_field = "FF6F1CE798488519FE43D7992CD2DB11", hash_generated_field = "6CD99B033C857377AC6C9952895E94C9")

        /**
         * The cofactor of the curve.
         */
        private BigInteger h;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.418 -0500", hash_original_field = "9D4FAA2FAC4ABAFE5278E9D062EC35AA", hash_generated_field = "6949032778AE4DCC756003D649733B4D")
        
         /**
         * The point at infinity on this curve.
         */
        private ECPoint.F2m infinity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.420 -0500", hash_original_field = "3B2C0E3179A3064695AEEFBCE72954B0", hash_generated_field = "F6D0D8ADD41706658B0F08459A38394C")

        /**
         * The parameter <code>&mu;</code> of the elliptic curve if this is
         * a Koblitz curve.
         */
        private byte mu = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.422 -0500", hash_original_field = "EFB68F8F96DE066893FC7C238683F056", hash_generated_field = "4DD43C8E43FDD8E564AAA02789FAC70C")

        private BigInteger[] si = null;

        /**
         * Constructor for Trinomial Polynomial Basis (TPB).
         * @param m  The exponent <code>m</code> of
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param k The integer <code>k</code> where <code>x<sup>m</sup> +
         * x<sup>k</sup> + 1</code> represents the reduction
         * polynomial <code>f(z)</code>.
         * @param a The coefficient <code>a</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param b The coefficient <code>b</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.425 -0500", hash_original_method = "DEC52BA66274A72254EB3F42E643013D", hash_generated_method = "09B1ABFDD4878DB79A03AA94D271AE33")
        
public F2m(
            int m,
            int k,
            BigInteger a,
            BigInteger b)
        {
            this(m, k, 0, 0, a, b, null, null);
        }

        /**
         * Constructor for Trinomial Polynomial Basis (TPB).
         * @param m  The exponent <code>m</code> of
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param k The integer <code>k</code> where <code>x<sup>m</sup> +
         * x<sup>k</sup> + 1</code> represents the reduction
         * polynomial <code>f(z)</code>.
         * @param a The coefficient <code>a</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param b The coefficient <code>b</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param n The order of the main subgroup of the elliptic curve.
         * @param h The cofactor of the elliptic curve, i.e.
         * <code>#E<sub>a</sub>(F<sub>2<sup>m</sup></sub>) = h * n</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.428 -0500", hash_original_method = "F2139B4AB6C86388E7E3C9323DB40384", hash_generated_method = "6679E777C8F4BAAECC5C8C04FAF3F85D")
        
public F2m(
            int m, 
            int k, 
            BigInteger a, 
            BigInteger b,
            BigInteger n,
            BigInteger h)
        {
            this(m, k, 0, 0, a, b, n, h);
        }

        /**
         * Constructor for Pentanomial Polynomial Basis (PPB).
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
         * @param a The coefficient <code>a</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param b The coefficient <code>b</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.431 -0500", hash_original_method = "5E11630AFDD86B3E6F25DD938FDF4713", hash_generated_method = "510F722B25A3DB3325E1CA2AAE94080D")
        
public F2m(
            int m,
            int k1,
            int k2,
            int k3,
            BigInteger a,
            BigInteger b)
        {
            this(m, k1, k2, k3, a, b, null, null);
        }

        /**
         * Constructor for Pentanomial Polynomial Basis (PPB).
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
         * @param a The coefficient <code>a</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param b The coefficient <code>b</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param n The order of the main subgroup of the elliptic curve.
         * @param h The cofactor of the elliptic curve, i.e.
         * <code>#E<sub>a</sub>(F<sub>2<sup>m</sup></sub>) = h * n</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.434 -0500", hash_original_method = "DFE62FA9A40BB48176925A509A87D7E7", hash_generated_method = "409B9A801E526E447BFFC4CD697DF019")
        
public F2m(
            int m, 
            int k1, 
            int k2, 
            int k3,
            BigInteger a, 
            BigInteger b,
            BigInteger n,
            BigInteger h)
        {
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            this.n = n;
            this.h = h;

            if (k1 == 0)
            {
                throw new IllegalArgumentException("k1 must be > 0");
            }

            if (k2 == 0)
            {
                if (k3 != 0)
                {
                    throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                }
            }
            else
            {
                if (k2 <= k1)
                {
                    throw new IllegalArgumentException("k2 must be > k1");
                }

                if (k3 <= k2)
                {
                    throw new IllegalArgumentException("k3 must be > k2");
                }
            }

            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.infinity = new ECPoint.F2m(this, null, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.436 -0500", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "EAD5E6876F72339E90584D56D39C2570")
        
public int getFieldSize()
        {
            return m;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.438 -0500", hash_original_method = "7AF48CB12A1921AAC7C154231A16AA21", hash_generated_method = "0BE868ED994674991767FE3FA5D2802A")
        
public ECFieldElement fromBigInteger(BigInteger x)
        {
            return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.441 -0500", hash_original_method = "166EA7512C9A204978606C53F7DDDB4A", hash_generated_method = "44AC1A4EEBB82DEF87EAB6928EC12839")
        
public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression)
        {
            return new ECPoint.F2m(this, fromBigInteger(x), fromBigInteger(y), withCompression);
        }

        /* (non-Javadoc)
         * @see org.bouncycastle.math.ec.ECCurve#decodePoint(byte[])
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.445 -0500", hash_original_method = "3A440A2E6AC052FD5047F5B01472DA22", hash_generated_method = "3741DC96CDB95ED161F5DB81B5A91540")
        
public ECPoint decodePoint(byte[] encoded)
        {
            ECPoint p = null;

            switch (encoded[0])
            {
                // infinity
            case 0x00:
                if (encoded.length > 1)
                {
                    throw new RuntimeException("Invalid point encoding");
                }
                p = getInfinity();
                break;
                // compressed
            case 0x02:
            case 0x03:
                byte[] enc = new byte[encoded.length - 1];
                System.arraycopy(encoded, 1, enc, 0, enc.length);
                if (encoded[0] == 0x02) 
                {
                        p = decompressPoint(enc, 0);
                }
                else 
                {
                        p = decompressPoint(enc, 1);
                }
                break;
                // uncompressed
            case 0x04:
                // hybrid
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
                throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(encoded[0], 16));
            }

            return p;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.447 -0500", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "68999FA4D910D8C84056051E09CFF4FF")
        
public ECPoint getInfinity()
        {
            return infinity;
        }

        /**
         * Returns true if this is a Koblitz curve (ABC curve).
         * @return true if this is a Koblitz curve (ABC curve), false otherwise
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.449 -0500", hash_original_method = "0873B9ADE54853DB8C371F01782A1B9E", hash_generated_method = "4BF166CD60276AD0B28BD749F682EB81")
        
public boolean isKoblitz()
        {
            return ((n != null) && (h != null) &&
                    ((a.toBigInteger().equals(ECConstants.ZERO)) ||
                    (a.toBigInteger().equals(ECConstants.ONE))) &&
                    (b.toBigInteger().equals(ECConstants.ONE)));
        }

        /**
         * Returns the parameter <code>&mu;</code> of the elliptic curve.
         * @return <code>&mu;</code> of the elliptic curve.
         * @throws IllegalArgumentException if the given ECCurve is not a
         * Koblitz curve.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.452 -0500", hash_original_method = "6A47B833A38B2C51AF1636CDFCEB3B55", hash_generated_method = "9C64ED0EC23F71E258420F0344699D43")
        
synchronized byte getMu()
        {
            if (mu == 0)
            {
                mu = Tnaf.getMu(this);
            }
            return mu;
        }

        /**
         * @return the auxiliary values <code>s<sub>0</sub></code> and
         * <code>s<sub>1</sub></code> used for partial modular reduction for
         * Koblitz curves.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.454 -0500", hash_original_method = "C02001236D393BDCA3D2D65CC0F3FCD6", hash_generated_method = "EA370A7804DD6A8C5A4ABDF51A9B5E9C")
        
synchronized BigInteger[] getSi()
        {
            if (si == null)
            {
                si = Tnaf.getSi(this);
            }
            return si;
        }

        /**
         * Decompresses a compressed point P = (xp, yp) (X9.62 s 4.2.2).
         * 
         * @param xEnc
         *            The encoding of field element xp.
         * @param ypBit
         *            ~yp, an indication bit for the decompression of yp.
         * @return the decompressed point.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.457 -0500", hash_original_method = "ABCDD5682443273B6E9EF7110AFEAA10", hash_generated_method = "9D126CDE8B79B9847DD3A385BC9EECF9")
        
private ECPoint decompressPoint(
            byte[] xEnc, 
            int ypBit)
        {
            ECFieldElement xp = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, new BigInteger(1, xEnc));
            ECFieldElement yp = null;
            if (xp.toBigInteger().equals(ECConstants.ZERO))
            {
                yp = (ECFieldElement.F2m)b;
                for (int i = 0; i < m - 1; i++)
                {
                    yp = yp.square();
                }
            }
            else
            {
                ECFieldElement beta = xp.add(a).add(
                        b.multiply(xp.square().invert()));
                ECFieldElement z = solveQuadradicEquation(beta);
                if (z == null)
                {
                    throw new RuntimeException("Invalid point compression");
                }
                int zBit = 0;
                if (z.toBigInteger().testBit(0))
                {
                    zBit = 1;
                }
                if (zBit != ypBit)
                {
                    z = z.add(new ECFieldElement.F2m(this.m, this.k1, this.k2,
                            this.k3, ECConstants.ONE));
                }
                yp = xp.multiply(z);
            }
            
            return new ECPoint.F2m(this, xp, yp);
        }
        
        /**
         * Solves a quadratic equation <code>z<sup>2</sup> + z = beta</code>(X9.62
         * D.1.6) The other solution is <code>z + 1</code>.
         * 
         * @param beta
         *            The value to solve the qradratic equation for.
         * @return the solution for <code>z<sup>2</sup> + z = beta</code> or
         *         <code>null</code> if no solution exists.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.460 -0500", hash_original_method = "25ED10C579C6ED4884A834D5A2CEB482", hash_generated_method = "57B6CF984EE509422F95DD0E3190E1EA")
        
private ECFieldElement solveQuadradicEquation(ECFieldElement beta)
        {
            ECFieldElement zeroElement = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, ECConstants.ZERO);

            if (beta.toBigInteger().equals(ECConstants.ZERO))
            {
                return zeroElement;
            }

            ECFieldElement z = null;
            ECFieldElement gamma = zeroElement;

            Random rand = new Random();
            do
            {
                ECFieldElement t = new ECFieldElement.F2m(this.m, this.k1,
                        this.k2, this.k3, new BigInteger(m, rand));
                z = zeroElement;
                ECFieldElement w = beta;
                for (int i = 1; i <= m - 1; i++)
                {
                    ECFieldElement w2 = w.square();
                    z = z.square().add(w2.multiply(t));
                    w = w2.add(beta);
                }
                if (!w.toBigInteger().equals(ECConstants.ZERO))
                {
                    return null;
                }
                gamma = z.square().add(z);
            }
            while (gamma.toBigInteger().equals(ECConstants.ZERO));

            return z;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.463 -0500", hash_original_method = "5F33BE6BAAB2ADDEB5EF1D1748825E7B", hash_generated_method = "89142AA3E602F1ACDC942BE955E3EE52")
        
public boolean equals(
            Object anObject)
        {
            if (anObject == this) 
            {
                return true;
            }

            if (!(anObject instanceof ECCurve.F2m)) 
            {
                return false;
            }

            ECCurve.F2m other = (ECCurve.F2m)anObject;
            
            return (this.m == other.m) && (this.k1 == other.k1)
                && (this.k2 == other.k2) && (this.k3 == other.k3)
                && a.equals(other.a) && b.equals(other.b);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.465 -0500", hash_original_method = "E92144A56D15AF334E01FB92437AD76B", hash_generated_method = "2441426CE40B68EFC2358B746BE0070E")
        
public int hashCode()
        {
            return this.a.hashCode() ^ this.b.hashCode() ^ m ^ k1 ^ k2 ^ k3;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.468 -0500", hash_original_method = "2FA087881284515E1CE9CA954B1F01D0", hash_generated_method = "54631342792286325FB6F9E68ECD4809")
        
public int getM()
        {
            return m;
        }

        /**
         * Return true if curve uses a Trinomial basis.
         * 
         * @return true if curve Trinomial, false otherwise.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.470 -0500", hash_original_method = "0A21FBE14C3CF35BF18E601EA9469DB4", hash_generated_method = "3EB50AF513DA175C301E39EB0EC5D176")
        
public boolean isTrinomial()
        {
            return k2 == 0 && k3 == 0;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.472 -0500", hash_original_method = "6F5E01D9EB3F8F69F3EDFAB71A89E9BA", hash_generated_method = "76F2F23EA66869BB85580C635B619DBB")
        
public int getK1()
        {
            return k1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.474 -0500", hash_original_method = "39AC234DC3848032A728401BC68DF439", hash_generated_method = "7D0F35C55A30AD82644C510AA425D8B8")
        
public int getK2()
        {
            return k2;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.477 -0500", hash_original_method = "A40D42566F753B213E5F7F205217D7F1", hash_generated_method = "CBD0FC597D2A2429B00C4620C7B9F8FF")
        
public int getK3()
        {
            return k3;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.480 -0500", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "02928BD4257B76FF9B6C6F96BB0BD425")
        
public BigInteger getN()
        {
            return n;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.482 -0500", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "B8364F7A0487534C88342679DF56B12F")
        
public BigInteger getH()
        {
            return h;
        }
        
    }
    
}

