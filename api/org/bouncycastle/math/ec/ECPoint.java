package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.asn1.x9.X9IntegerConverter;






public abstract class ECPoint {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.638 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "704A3581F062D90BBFC67E94998B89B2")

    ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.638 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "4962267CB3409346474982F669EDC96A")

    ECFieldElement x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.638 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "8FD25F34A4263F01B1FBD2F22B2F99BF")

    ECFieldElement y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.638 -0400", hash_original_field = "A04A91040E7D1CAA0270269A913F52BB", hash_generated_field = "7FD389F38A41EB1BAE8714CB05D998E3")

    protected boolean withCompression;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.638 -0400", hash_original_field = "73DABD82B9E2DA8B72224DD8528740A4", hash_generated_field = "C1F508A0F6FEA833DEEAC7A7B323D761")

    protected ECMultiplier multiplier = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.638 -0400", hash_original_field = "14172E23074FE3D1020FA12A5CEFEB04", hash_generated_field = "84CF639EBFFD87F3AC15C9EF1E1AAF42")

    protected PreCompInfo preCompInfo = null;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.639 -0400", hash_original_method = "5BA77B5B0277E538D25ED5D9A027BA25", hash_generated_method = "847A130CB97DB4D071D636D195FCCE97")
    protected  ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y) {
        this.curve = curve;
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.x = x;
        //this.y = y;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.639 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "DCEEBF03F2FA03255F7D9F859FE25044")
    public ECCurve getCurve() {
ECCurve varCB08C04A7A1DB77E60E6F93B4C766067_1910442812 =         curve;
        varCB08C04A7A1DB77E60E6F93B4C766067_1910442812.addTaint(taint);
        return varCB08C04A7A1DB77E60E6F93B4C766067_1910442812;
        // ---------- Original Method ----------
        //return curve;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.640 -0400", hash_original_method = "C7C8D965D2F53EB7BBE8F50406AF2883", hash_generated_method = "CE0680C5E0CDF7CC5AA6253424FEAD59")
    public ECFieldElement getX() {
ECFieldElement varEA5659DA512DECF23E6D37EE8060D074_906482025 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_906482025.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_906482025;
        // ---------- Original Method ----------
        //return x;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.640 -0400", hash_original_method = "B5FEFF99DC806D61F0BCF9BC7ACEB9BA", hash_generated_method = "25BDE995E577CA94470B1AFF23943523")
    public ECFieldElement getY() {
ECFieldElement var01417B0442ECD521584E2B7EFB9FC218_946597247 =         y;
        var01417B0442ECD521584E2B7EFB9FC218_946597247.addTaint(taint);
        return var01417B0442ECD521584E2B7EFB9FC218_946597247;
        // ---------- Original Method ----------
        //return y;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.640 -0400", hash_original_method = "B09C1F46CE24A0176C4C3F4348C76697", hash_generated_method = "A38F6E2004D7E531D7E4C1F40B51775E")
    public boolean isInfinity() {
        boolean var14C2CA2A32591652557E17643BF90D2B_617722981 = (x == null && y == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335152382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335152382;
        // ---------- Original Method ----------
        //return x == null && y == null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.640 -0400", hash_original_method = "47BFB55B0C4A3BF2B8623783D9C43540", hash_generated_method = "FC10BD00FE796C3B3CF52F27D7866FB8")
    public boolean isCompressed() {
        boolean varA04A91040E7D1CAA0270269A913F52BB_537100082 = (withCompression);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118205118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118205118;
        // ---------- Original Method ----------
        //return withCompression;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.641 -0400", hash_original_method = "8BF915B7848C2883598F0B5C0E5B1EC3", hash_generated_method = "F471E055423C434C5A4C423E784FA082")
    public boolean equals(
        Object  other) {
        addTaint(other.getTaint());
        if(other == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_263683110 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583265426 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_583265426;
        } //End block
        if(!(other instanceof ECPoint))        
        {
            boolean var68934A3E9455FA72420237EB05902327_718916451 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495148428 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495148428;
        } //End block
        ECPoint o = (ECPoint)other;
        if(this.isInfinity())        
        {
            boolean varC58E891FC6B5B1E3EB6CFC9DC6B61390_881157926 = (o.isInfinity());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1881393673 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1881393673;
        } //End block
        boolean var086F44B0CAEFE7D90300A0DCD6B25BBE_2008978374 = (x.equals(o.x) && y.equals(o.y));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274438604 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_274438604;
        // ---------- Original Method ----------
        //if (other == this)
        //{
            //return true;
        //}
        //if (!(other instanceof ECPoint))
        //{
            //return false;
        //}
        //ECPoint o = (ECPoint)other;
        //if (this.isInfinity())
        //{
            //return o.isInfinity();
        //}
        //return x.equals(o.x) && y.equals(o.y);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.641 -0400", hash_original_method = "50EB0D4EE4BADC10EDE9CC4D5C9244FF", hash_generated_method = "FAC7E36F28B1C1C2AD05C70860F414DF")
    public int hashCode() {
        if(this.isInfinity())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1752349683 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047408133 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047408133;
        } //End block
        int var033927572431881CD2056EB9785CDCB3_247709386 = (x.hashCode() ^ y.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144617135 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144617135;
        // ---------- Original Method ----------
        //if (this.isInfinity())
        //{
            //return 0;
        //}
        //return x.hashCode() ^ y.hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.642 -0400", hash_original_method = "3CED2898CE1D9F7EEE71D4F4E6298B52", hash_generated_method = "7B74A03DE78F3C307128B0AF3CA7A466")
     void setPreCompInfo(PreCompInfo preCompInfo) {
        this.preCompInfo = preCompInfo;
        // ---------- Original Method ----------
        //this.preCompInfo = preCompInfo;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract byte[] getEncoded();

    
    @DSModeled(DSC.SAFE)
    public abstract ECPoint add(ECPoint b);

    
    @DSModeled(DSC.SAFE)
    public abstract ECPoint subtract(ECPoint b);

    
    @DSModeled(DSC.SAFE)
    public abstract ECPoint negate();

    
    @DSModeled(DSC.SAFE)
    public abstract ECPoint twice();

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.643 -0400", hash_original_method = "CFD8CCAA4A8EFD7B41616F74559C84F4", hash_generated_method = "97CE43AE98DB7914C02173153BE78DF3")
    synchronized void assertECMultiplier() {
        if(this.multiplier == null)        
        {
            this.multiplier = new FpNafMultiplier();
        } //End block
        // ---------- Original Method ----------
        //if (this.multiplier == null)
        //{
            //this.multiplier = new FpNafMultiplier();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.643 -0400", hash_original_method = "0A712A2425F19F0711671167931DA051", hash_generated_method = "2DC86573C241126D2B7529B6F33079C5")
    public ECPoint multiply(BigInteger k) {
        addTaint(k.getTaint());
        if(k.signum() < 0)        
        {
            IllegalArgumentException var37EB9B843EF3D3A5C3587E22337ED9D2_487640566 = new IllegalArgumentException("The multiplicator cannot be negative");
            var37EB9B843EF3D3A5C3587E22337ED9D2_487640566.addTaint(taint);
            throw var37EB9B843EF3D3A5C3587E22337ED9D2_487640566;
        } //End block
        if(this.isInfinity())        
        {
ECPoint var72A74007B2BE62B849F475C7BDA4658B_461534923 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_461534923.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_461534923;
        } //End block
        if(k.signum() == 0)        
        {
ECPoint varCDE459757F662B12E92627818EA576E9_348592481 =             this.curve.getInfinity();
            varCDE459757F662B12E92627818EA576E9_348592481.addTaint(taint);
            return varCDE459757F662B12E92627818EA576E9_348592481;
        } //End block
        assertECMultiplier();
ECPoint varE79EE08445955BDA41CB74C2C47AC61F_1719194488 =         this.multiplier.multiply(this, k, preCompInfo);
        varE79EE08445955BDA41CB74C2C47AC61F_1719194488.addTaint(taint);
        return varE79EE08445955BDA41CB74C2C47AC61F_1719194488;
        // ---------- Original Method ----------
        //if (k.signum() < 0)
        //{
            //throw new IllegalArgumentException("The multiplicator cannot be negative");
        //}
        //if (this.isInfinity())
        //{
            //return this;
        //}
        //if (k.signum() == 0)
        //{
            //return this.curve.getInfinity();
        //}
        //assertECMultiplier();
        //return this.multiplier.multiply(this, k, preCompInfo);
    }

    
    public static class Fp extends ECPoint {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.644 -0400", hash_original_method = "C218E406154D6A68AEA278E34615CF99", hash_generated_method = "7264FC0871D150CAC2992ADBB6DA179F")
        public  Fp(ECCurve curve, ECFieldElement x, ECFieldElement y) {
            this(curve, x, y, false);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
            addTaint(curve.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.645 -0400", hash_original_method = "DA43573652764E89DCD825DB3FC87547", hash_generated_method = "28D6B134A609B371925EF9CCC49D1D66")
        public  Fp(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression) {
            super(curve, x, y);
            addTaint(withCompression);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
            addTaint(curve.getTaint());
            if((x != null && y == null) || (x == null && y != null))            
            {
                IllegalArgumentException var0966596FA1E8BAEEA9450EFD05161B24_267746438 = new IllegalArgumentException("Exactly one of the field elements is null");
                var0966596FA1E8BAEEA9450EFD05161B24_267746438.addTaint(taint);
                throw var0966596FA1E8BAEEA9450EFD05161B24_267746438;
            } //End block
            this.withCompression = withCompression;
            // ---------- Original Method ----------
            //if ((x != null && y == null) || (x == null && y != null))
            //{
                //throw new IllegalArgumentException("Exactly one of the field elements is null");
            //}
            //this.withCompression = withCompression;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.646 -0400", hash_original_method = "122C86DAB9B6EC00B00943741F6C7C43", hash_generated_method = "D1CEAD1CBFBD7635B386782E02AA9C6E")
        public byte[] getEncoded() {
            if(this.isInfinity())            
            {
                byte[] varE60031EAA71A2FC01277A55510734340_1770501052 = (new byte[1]);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1024113215 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_1024113215;
            } //End block
            int qLength = converter.getByteLength(x);
            if(withCompression)            
            {
                byte PC;
                if(this.getY().toBigInteger().testBit(0))                
                {
                    PC = 0x03;
                } //End block
                else
                {
                    PC = 0x02;
                } //End block
                byte[] X = converter.integerToBytes(this.getX().toBigInteger(), qLength);
                byte[] PO = new byte[X.length + 1];
                PO[0] = PC;
                System.arraycopy(X, 0, PO, 1, X.length);
                byte[] varB3918665EE674080BF505E1B2D862187_854257742 = (PO);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_258177198 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_258177198;
            } //End block
            else
            {
                byte[] X = converter.integerToBytes(this.getX().toBigInteger(), qLength);
                byte[] Y = converter.integerToBytes(this.getY().toBigInteger(), qLength);
                byte[] PO = new byte[X.length + Y.length + 1];
                PO[0] = 0x04;
                System.arraycopy(X, 0, PO, 1, X.length);
                System.arraycopy(Y, 0, PO, X.length + 1, Y.length);
                byte[] varB3918665EE674080BF505E1B2D862187_1120848246 = (PO);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1070034406 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_1070034406;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.647 -0400", hash_original_method = "95E059CAF9907A74F8544551FF4AF334", hash_generated_method = "CD6BAC4661A223D1D50D8707557DE393")
        public ECPoint add(ECPoint b) {
            addTaint(b.getTaint());
            if(this.isInfinity())            
            {
ECPoint var73F89FAC8F369DF0913D10C37C1E0EA1_1069004095 =                 b;
                var73F89FAC8F369DF0913D10C37C1E0EA1_1069004095.addTaint(taint);
                return var73F89FAC8F369DF0913D10C37C1E0EA1_1069004095;
            } //End block
            if(b.isInfinity())            
            {
ECPoint var72A74007B2BE62B849F475C7BDA4658B_84343344 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_84343344.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_84343344;
            } //End block
            if(this.x.equals(b.x))            
            {
                if(this.y.equals(b.y))                
                {
ECPoint varF3D495AFF337D27ED1AD381C51A4CAF8_1690891802 =                     this.twice();
                    varF3D495AFF337D27ED1AD381C51A4CAF8_1690891802.addTaint(taint);
                    return varF3D495AFF337D27ED1AD381C51A4CAF8_1690891802;
                } //End block
ECPoint varCDE459757F662B12E92627818EA576E9_2145679447 =                 this.curve.getInfinity();
                varCDE459757F662B12E92627818EA576E9_2145679447.addTaint(taint);
                return varCDE459757F662B12E92627818EA576E9_2145679447;
            } //End block
            ECFieldElement gamma = b.y.subtract(this.y).divide(b.x.subtract(this.x));
            ECFieldElement x3 = gamma.square().subtract(this.x).subtract(b.x);
            ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
ECPoint var071BB455154747F7E03561EA2C39CC7F_896493837 =             new ECPoint.Fp(curve, x3, y3);
            var071BB455154747F7E03561EA2C39CC7F_896493837.addTaint(taint);
            return var071BB455154747F7E03561EA2C39CC7F_896493837;
            // ---------- Original Method ----------
            //if (this.isInfinity())
            //{
                //return b;
            //}
            //if (b.isInfinity())
            //{
                //return this;
            //}
            //if (this.x.equals(b.x))
            //{
                //if (this.y.equals(b.y))
                //{
                    //return this.twice();
                //}
                //return this.curve.getInfinity();
            //}
            //ECFieldElement gamma = b.y.subtract(this.y).divide(b.x.subtract(this.x));
            //ECFieldElement x3 = gamma.square().subtract(this.x).subtract(b.x);
            //ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
            //return new ECPoint.Fp(curve, x3, y3);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.647 -0400", hash_original_method = "814EC5F0BAC3EF42CB4061AB2E0CCD5F", hash_generated_method = "59CDA8EB72EE011E5F63577706674B9A")
        public ECPoint twice() {
            if(this.isInfinity())            
            {
ECPoint var72A74007B2BE62B849F475C7BDA4658B_238955277 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_238955277.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_238955277;
            } //End block
            if(this.y.toBigInteger().signum() == 0)            
            {
ECPoint varCDE459757F662B12E92627818EA576E9_45022817 =                 this.curve.getInfinity();
                varCDE459757F662B12E92627818EA576E9_45022817.addTaint(taint);
                return varCDE459757F662B12E92627818EA576E9_45022817;
            } //End block
            ECFieldElement TWO = this.curve.fromBigInteger(BigInteger.valueOf(2));
            ECFieldElement THREE = this.curve.fromBigInteger(BigInteger.valueOf(3));
            ECFieldElement gamma = this.x.square().multiply(THREE).add(curve.a).divide(y.multiply(TWO));
            ECFieldElement x3 = gamma.square().subtract(this.x.multiply(TWO));
            ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
ECPoint var3A3B53403FE81238561C7DFE7EBB0574_164262050 =             new ECPoint.Fp(curve, x3, y3, this.withCompression);
            var3A3B53403FE81238561C7DFE7EBB0574_164262050.addTaint(taint);
            return var3A3B53403FE81238561C7DFE7EBB0574_164262050;
            // ---------- Original Method ----------
            //if (this.isInfinity())
            //{
                //return this;
            //}
            //if (this.y.toBigInteger().signum() == 0) 
            //{
                //return this.curve.getInfinity();
            //}
            //ECFieldElement TWO = this.curve.fromBigInteger(BigInteger.valueOf(2));
            //ECFieldElement THREE = this.curve.fromBigInteger(BigInteger.valueOf(3));
            //ECFieldElement gamma = this.x.square().multiply(THREE).add(curve.a).divide(y.multiply(TWO));
            //ECFieldElement x3 = gamma.square().subtract(this.x.multiply(TWO));
            //ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
            //return new ECPoint.Fp(curve, x3, y3, this.withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.648 -0400", hash_original_method = "6CF29EA69F961CE922C32B4E8E2284E5", hash_generated_method = "14594E3304A5F2CD2B626E18380DCD07")
        public ECPoint subtract(ECPoint b) {
            addTaint(b.getTaint());
            if(b.isInfinity())            
            {
ECPoint var72A74007B2BE62B849F475C7BDA4658B_235597559 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_235597559.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_235597559;
            } //End block
ECPoint var32038E816FAB690831584DAC6FED51A3_1573572299 =             add(b.negate());
            var32038E816FAB690831584DAC6FED51A3_1573572299.addTaint(taint);
            return var32038E816FAB690831584DAC6FED51A3_1573572299;
            // ---------- Original Method ----------
            //if (b.isInfinity())
            //{
                //return this;
            //}
            //return add(b.negate());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.648 -0400", hash_original_method = "18C2403460E252970B56CE0DE1D343AC", hash_generated_method = "2E602737C2D2FEDE8C277158C2142752")
        public ECPoint negate() {
ECPoint var35D308A124E50E56D68F906961B3437A_1246016497 =             new ECPoint.Fp(curve, this.x, this.y.negate(), this.withCompression);
            var35D308A124E50E56D68F906961B3437A_1246016497.addTaint(taint);
            return var35D308A124E50E56D68F906961B3437A_1246016497;
            // ---------- Original Method ----------
            //return new ECPoint.Fp(curve, this.x, this.y.negate(), this.withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.652 -0400", hash_original_method = "8EF68E9821BB7A65A39BDB5C806DAEDA", hash_generated_method = "A84F5AA9EF7CF3DA1FBD1EFDFDB204F7")
        synchronized void assertECMultiplier() {
            if(this.multiplier == null)            
            {
                this.multiplier = new WNafMultiplier();
            } //End block
            // ---------- Original Method ----------
            //if (this.multiplier == null)
            //{
                //this.multiplier = new WNafMultiplier();
            //}
        }

        
    }


    
    public static class F2m extends ECPoint {
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.653 -0400", hash_original_method = "73BD63756191E5AAFB19346FBE556EB3", hash_generated_method = "85DC6EED2BC08775B318F74ACB17C246")
        public  F2m(ECCurve curve, ECFieldElement x, ECFieldElement y) {
            this(curve, x, y, false);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
            addTaint(curve.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.653 -0400", hash_original_method = "4610FCAEB1DDBBF845E95D34129A59A7", hash_generated_method = "236DD0981DF54CF145B13EB29798D651")
        public  F2m(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression) {
            super(curve, x, y);
            addTaint(withCompression);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
            addTaint(curve.getTaint());
            if((x != null && y == null) || (x == null && y != null))            
            {
                IllegalArgumentException var0966596FA1E8BAEEA9450EFD05161B24_1299136004 = new IllegalArgumentException("Exactly one of the field elements is null");
                var0966596FA1E8BAEEA9450EFD05161B24_1299136004.addTaint(taint);
                throw var0966596FA1E8BAEEA9450EFD05161B24_1299136004;
            } //End block
            if(x != null)            
            {
                ECFieldElement.F2m.checkFieldElements(this.x, this.y);
                if(curve != null)                
                {
                    ECFieldElement.F2m.checkFieldElements(this.x, this.curve.getA());
                } //End block
            } //End block
            this.withCompression = withCompression;
            // ---------- Original Method ----------
            //if ((x != null && y == null) || (x == null && y != null))
            //{
                //throw new IllegalArgumentException("Exactly one of the field elements is null");
            //}
            //if (x != null)
            //{
                //ECFieldElement.F2m.checkFieldElements(this.x, this.y);
                //if (curve != null)
                //{
                    //ECFieldElement.F2m.checkFieldElements(this.x, this.curve.getA());
                //}
            //}
            //this.withCompression = withCompression;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.655 -0400", hash_original_method = "91DE6710B35AB1954917AAE97889BD70", hash_generated_method = "4077BB1CF0EFD7CFF6ABE9642795FD96")
        public byte[] getEncoded() {
            if(this.isInfinity())            
            {
                byte[] varE60031EAA71A2FC01277A55510734340_274306238 = (new byte[1]);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2103534664 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_2103534664;
            } //End block
            int byteCount = converter.getByteLength(this.x);
            byte[] X = converter.integerToBytes(this.getX().toBigInteger(), byteCount);
            byte[] PO;
            if(withCompression)            
            {
                PO = new byte[byteCount + 1];
                PO[0] = 0x02;
                if(!(this.getX().toBigInteger().equals(ECConstants.ZERO)))                
                {
                    if(this.getY().multiply(this.getX().invert())
                            .toBigInteger().testBit(0))                    
                    {
                        PO[0] = 0x03;
                    } //End block
                } //End block
                System.arraycopy(X, 0, PO, 1, byteCount);
            } //End block
            else
            {
                byte[] Y = converter.integerToBytes(this.getY().toBigInteger(), byteCount);
                PO = new byte[byteCount + byteCount + 1];
                PO[0] = 0x04;
                System.arraycopy(X, 0, PO, 1, byteCount);
                System.arraycopy(Y, 0, PO, byteCount + 1, byteCount);
            } //End block
            byte[] varB3918665EE674080BF505E1B2D862187_2107835770 = (PO);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_208849003 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_208849003;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        private static void checkPoints(ECPoint a, ECPoint b) {
            if (!(a.curve.equals(b.curve)))
            {
                throw new IllegalArgumentException("Only points on the same "
                        + "curve can be added or subtracted");
            }
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.656 -0400", hash_original_method = "CE1FEB0E79091A4CCB0243E0EA7A28CB", hash_generated_method = "97714EFC1A744E87E64EE24F909E6DBF")
        public ECPoint add(ECPoint b) {
            addTaint(b.getTaint());
            checkPoints(this, b);
ECPoint var6E12BF01C43F8636C37FF895272EA727_1149906744 =             addSimple((ECPoint.F2m)b);
            var6E12BF01C43F8636C37FF895272EA727_1149906744.addTaint(taint);
            return var6E12BF01C43F8636C37FF895272EA727_1149906744;
            // ---------- Original Method ----------
            //checkPoints(this, b);
            //return addSimple((ECPoint.F2m)b);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.656 -0400", hash_original_method = "230992766041FE2E7B78B40F0E0C1144", hash_generated_method = "AC4423AB2D1126069E03BA675D746589")
        public ECPoint.F2m addSimple(ECPoint.F2m b) {
            addTaint(b.getTaint());
            ECPoint.F2m other = b;
            if(this.isInfinity())            
            {
ECPoint.F2m var4E21B9EBDCBB8C692A7FDE6A282BDC6C_1337089011 =                 other;
                var4E21B9EBDCBB8C692A7FDE6A282BDC6C_1337089011.addTaint(taint);
                return var4E21B9EBDCBB8C692A7FDE6A282BDC6C_1337089011;
            } //End block
            if(other.isInfinity())            
            {
ECPoint.F2m var72A74007B2BE62B849F475C7BDA4658B_809303883 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_809303883.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_809303883;
            } //End block
            ECFieldElement.F2m x2 = (ECFieldElement.F2m)other.getX();
            ECFieldElement.F2m y2 = (ECFieldElement.F2m)other.getY();
            if(this.x.equals(x2))            
            {
                if(this.y.equals(y2))                
                {
ECPoint.F2m var1919DF098077FD20F1EAB39A6C86E871_2017808177 =                     (ECPoint.F2m)this.twice();
                    var1919DF098077FD20F1EAB39A6C86E871_2017808177.addTaint(taint);
                    return var1919DF098077FD20F1EAB39A6C86E871_2017808177;
                } //End block
ECPoint.F2m varCEF30124D84DA9F1B4850269BC04DF84_1980657510 =                 (ECPoint.F2m)this.curve.getInfinity();
                varCEF30124D84DA9F1B4850269BC04DF84_1980657510.addTaint(taint);
                return varCEF30124D84DA9F1B4850269BC04DF84_1980657510;
            } //End block
            ECFieldElement.F2m lambda = (ECFieldElement.F2m)(this.y.add(y2)).divide(this.x.add(x2));
            ECFieldElement.F2m x3 = (ECFieldElement.F2m)lambda.square().add(lambda).add(this.x).add(x2).add(this.curve.getA());
            ECFieldElement.F2m y3 = (ECFieldElement.F2m)lambda.multiply(this.x.add(x3)).add(x3).add(this.y);
ECPoint.F2m varE29EE30F858B45227C50CD4435ABFBEA_891580089 =             new ECPoint.F2m(curve, x3, y3, withCompression);
            varE29EE30F858B45227C50CD4435ABFBEA_891580089.addTaint(taint);
            return varE29EE30F858B45227C50CD4435ABFBEA_891580089;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.656 -0400", hash_original_method = "E180EBB5B66B4130D071F14F4EE083E4", hash_generated_method = "807E0E74C6B6BF1BF2235AD7D9E6A31F")
        public ECPoint subtract(ECPoint b) {
            addTaint(b.getTaint());
            checkPoints(this, b);
ECPoint varF77FD5A0FB078C7218024671CA30605E_932002819 =             subtractSimple((ECPoint.F2m)b);
            varF77FD5A0FB078C7218024671CA30605E_932002819.addTaint(taint);
            return varF77FD5A0FB078C7218024671CA30605E_932002819;
            // ---------- Original Method ----------
            //checkPoints(this, b);
            //return subtractSimple((ECPoint.F2m)b);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.656 -0400", hash_original_method = "FE873BC192C2EB55E75185601239ED06", hash_generated_method = "EC6DC828A255F5A0126714E6F6924608")
        public ECPoint.F2m subtractSimple(ECPoint.F2m b) {
            addTaint(b.getTaint());
            if(b.isInfinity())            
            {
ECPoint.F2m var72A74007B2BE62B849F475C7BDA4658B_1302233302 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1302233302.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1302233302;
            } //End block
ECPoint.F2m var3E163E68CA57B99B76674064815F739F_2050454295 =             addSimple((ECPoint.F2m)b.negate());
            var3E163E68CA57B99B76674064815F739F_2050454295.addTaint(taint);
            return var3E163E68CA57B99B76674064815F739F_2050454295;
            // ---------- Original Method ----------
            //if (b.isInfinity())
            //{
                //return this;
            //}
            //return addSimple((ECPoint.F2m)b.negate());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.657 -0400", hash_original_method = "45BA33A6C8448ED0A2617484FF5E8003", hash_generated_method = "96547D3817453EFEC231C0315313281E")
        public ECPoint twice() {
            if(this.isInfinity())            
            {
ECPoint var72A74007B2BE62B849F475C7BDA4658B_1187259866 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1187259866.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1187259866;
            } //End block
            if(this.x.toBigInteger().signum() == 0)            
            {
ECPoint varCDE459757F662B12E92627818EA576E9_1020971593 =                 this.curve.getInfinity();
                varCDE459757F662B12E92627818EA576E9_1020971593.addTaint(taint);
                return varCDE459757F662B12E92627818EA576E9_1020971593;
            } //End block
            ECFieldElement.F2m lambda = (ECFieldElement.F2m)this.x.add(this.y.divide(this.x));
            ECFieldElement.F2m x3 = (ECFieldElement.F2m)lambda.square().add(lambda).
                    add(this.curve.getA());
            ECFieldElement ONE = this.curve.fromBigInteger(ECConstants.ONE);
            ECFieldElement.F2m y3 = (ECFieldElement.F2m)this.x.square().add(
                    x3.multiply(lambda.add(ONE)));
ECPoint varD40A7246E4D1D01EF654FCE8BF0FE2B3_1124132527 =             new ECPoint.F2m(this.curve, x3, y3, withCompression);
            varD40A7246E4D1D01EF654FCE8BF0FE2B3_1124132527.addTaint(taint);
            return varD40A7246E4D1D01EF654FCE8BF0FE2B3_1124132527;
            // ---------- Original Method ----------
            //if (this.isInfinity()) 
            //{
                //return this;
            //}
            //if (this.x.toBigInteger().signum() == 0) 
            //{
                //return this.curve.getInfinity();
            //}
            //ECFieldElement.F2m lambda
                //= (ECFieldElement.F2m)this.x.add(this.y.divide(this.x));
            //ECFieldElement.F2m x3
                //= (ECFieldElement.F2m)lambda.square().add(lambda).
                    //add(this.curve.getA());
            //ECFieldElement ONE = this.curve.fromBigInteger(ECConstants.ONE);
            //ECFieldElement.F2m y3
                //= (ECFieldElement.F2m)this.x.square().add(
                    //x3.multiply(lambda.add(ONE)));
            //return new ECPoint.F2m(this.curve, x3, y3, withCompression);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.657 -0400", hash_original_method = "55BA3FB66363791B05BA3007051689C2", hash_generated_method = "049EC0C8E7FE59BF1C10FFCB2BDC312E")
        public ECPoint negate() {
ECPoint var8A5D491956EA8C03A91531C071EF48DE_401336950 =             new ECPoint.F2m(curve, this.getX(), this.getY().add(this.getX()), withCompression);
            var8A5D491956EA8C03A91531C071EF48DE_401336950.addTaint(taint);
            return var8A5D491956EA8C03A91531C071EF48DE_401336950;
            // ---------- Original Method ----------
            //return new ECPoint.F2m(curve, this.getX(), this.getY().add(this.getX()), withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.658 -0400", hash_original_method = "B01B67DF3607CCDD35FFA0674C4BFE3B", hash_generated_method = "E45A76D24BF9B5ABAC62E018DF1E5D4F")
        synchronized void assertECMultiplier() {
            if(this.multiplier == null)            
            {
                if(((ECCurve.F2m)this.curve).isKoblitz())                
                {
                    this.multiplier = new WTauNafMultiplier();
                } //End block
                else
                {
                    this.multiplier = new WNafMultiplier();
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (this.multiplier == null)
            //{
                //if (((ECCurve.F2m)this.curve).isKoblitz())
                //{
                    //this.multiplier = new WTauNafMultiplier();
                //}
                //else
                //{
                    //this.multiplier = new WNafMultiplier();
                //}
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.658 -0400", hash_original_field = "61707B662C0781EC16F82DBF410266B9", hash_generated_field = "F6B8D48C5F5A761E5DB11D930C790FFE")

    private static X9IntegerConverter converter = new X9IntegerConverter();
}

