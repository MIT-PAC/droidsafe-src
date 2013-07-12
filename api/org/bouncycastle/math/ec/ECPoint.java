package org.bouncycastle.math.ec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import org.bouncycastle.asn1.x9.X9IntegerConverter;

public abstract class ECPoint {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.030 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "704A3581F062D90BBFC67E94998B89B2")

    ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.030 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "4962267CB3409346474982F669EDC96A")

    ECFieldElement x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.031 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "8FD25F34A4263F01B1FBD2F22B2F99BF")

    ECFieldElement y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.031 -0400", hash_original_field = "A04A91040E7D1CAA0270269A913F52BB", hash_generated_field = "7FD389F38A41EB1BAE8714CB05D998E3")

    protected boolean withCompression;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.031 -0400", hash_original_field = "73DABD82B9E2DA8B72224DD8528740A4", hash_generated_field = "C1F508A0F6FEA833DEEAC7A7B323D761")

    protected ECMultiplier multiplier = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.031 -0400", hash_original_field = "14172E23074FE3D1020FA12A5CEFEB04", hash_generated_field = "84CF639EBFFD87F3AC15C9EF1E1AAF42")

    protected PreCompInfo preCompInfo = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.032 -0400", hash_original_method = "5BA77B5B0277E538D25ED5D9A027BA25", hash_generated_method = "847A130CB97DB4D071D636D195FCCE97")
    protected  ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y) {
        this.curve = curve;
        this.x = x;
        this.y = y;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.032 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "DDA0B15304294C9DA61A3DC556D13740")
    public ECCurve getCurve() {
ECCurve varCB08C04A7A1DB77E60E6F93B4C766067_823125907 =         curve;
        varCB08C04A7A1DB77E60E6F93B4C766067_823125907.addTaint(taint);
        return varCB08C04A7A1DB77E60E6F93B4C766067_823125907;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.032 -0400", hash_original_method = "C7C8D965D2F53EB7BBE8F50406AF2883", hash_generated_method = "3DD82864535861A65D4B8E41DE6E5973")
    public ECFieldElement getX() {
ECFieldElement varEA5659DA512DECF23E6D37EE8060D074_69228245 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_69228245.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_69228245;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.033 -0400", hash_original_method = "B5FEFF99DC806D61F0BCF9BC7ACEB9BA", hash_generated_method = "69EABDE87FCFFD75A295D5CFB06AF7F5")
    public ECFieldElement getY() {
ECFieldElement var01417B0442ECD521584E2B7EFB9FC218_278008415 =         y;
        var01417B0442ECD521584E2B7EFB9FC218_278008415.addTaint(taint);
        return var01417B0442ECD521584E2B7EFB9FC218_278008415;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.033 -0400", hash_original_method = "B09C1F46CE24A0176C4C3F4348C76697", hash_generated_method = "39B38EAAB81955C678F688FA3B68643D")
    public boolean isInfinity() {
        boolean var14C2CA2A32591652557E17643BF90D2B_471133131 = (x == null && y == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1433282099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1433282099;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.034 -0400", hash_original_method = "47BFB55B0C4A3BF2B8623783D9C43540", hash_generated_method = "AA54C8B471A2EF3E7D8D80D4D3CC5E5D")
    public boolean isCompressed() {
        boolean varA04A91040E7D1CAA0270269A913F52BB_201544331 = (withCompression);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365253670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365253670;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.034 -0400", hash_original_method = "8BF915B7848C2883598F0B5C0E5B1EC3", hash_generated_method = "53F966FC49DEBDB3031B1A1491F2D87C")
    public boolean equals(
        Object  other) {
        addTaint(other.getTaint());
    if(other == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1058178361 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79251436 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_79251436;
        } 
    if(!(other instanceof ECPoint))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1417149889 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1834409820 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1834409820;
        } 
        ECPoint o = (ECPoint)other;
    if(this.isInfinity())        
        {
            boolean varC58E891FC6B5B1E3EB6CFC9DC6B61390_504435620 = (o.isInfinity());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000072238 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000072238;
        } 
        boolean var086F44B0CAEFE7D90300A0DCD6B25BBE_22804515 = (x.equals(o.x) && y.equals(o.y));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1051344836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1051344836;
        
        
        
            
        
        
        
            
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.035 -0400", hash_original_method = "50EB0D4EE4BADC10EDE9CC4D5C9244FF", hash_generated_method = "47F85655367BEEF7513A866C975B472D")
    public int hashCode() {
    if(this.isInfinity())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_2083397384 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333204821 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333204821;
        } 
        int var033927572431881CD2056EB9785CDCB3_1096428122 = (x.hashCode() ^ y.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_592684493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_592684493;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.035 -0400", hash_original_method = "3CED2898CE1D9F7EEE71D4F4E6298B52", hash_generated_method = "7B74A03DE78F3C307128B0AF3CA7A466")
     void setPreCompInfo(PreCompInfo preCompInfo) {
        this.preCompInfo = preCompInfo;
        
        
    }

    
    public abstract byte[] getEncoded();

    
    public abstract ECPoint add(ECPoint b);

    
    public abstract ECPoint subtract(ECPoint b);

    
    public abstract ECPoint negate();

    
    public abstract ECPoint twice();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.036 -0400", hash_original_method = "CFD8CCAA4A8EFD7B41616F74559C84F4", hash_generated_method = "97CE43AE98DB7914C02173153BE78DF3")
    synchronized void assertECMultiplier() {
    if(this.multiplier == null)        
        {
            this.multiplier = new FpNafMultiplier();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.037 -0400", hash_original_method = "0A712A2425F19F0711671167931DA051", hash_generated_method = "0D852FCBAC1AF8B8B798C56AAA041785")
    public ECPoint multiply(BigInteger k) {
        addTaint(k.getTaint());
    if(k.signum() < 0)        
        {
            IllegalArgumentException var37EB9B843EF3D3A5C3587E22337ED9D2_58643769 = new IllegalArgumentException("The multiplicator cannot be negative");
            var37EB9B843EF3D3A5C3587E22337ED9D2_58643769.addTaint(taint);
            throw var37EB9B843EF3D3A5C3587E22337ED9D2_58643769;
        } 
    if(this.isInfinity())        
        {
ECPoint var72A74007B2BE62B849F475C7BDA4658B_1858670110 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1858670110.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1858670110;
        } 
    if(k.signum() == 0)        
        {
ECPoint varCDE459757F662B12E92627818EA576E9_1940431869 =             this.curve.getInfinity();
            varCDE459757F662B12E92627818EA576E9_1940431869.addTaint(taint);
            return varCDE459757F662B12E92627818EA576E9_1940431869;
        } 
        assertECMultiplier();
ECPoint varE79EE08445955BDA41CB74C2C47AC61F_1810750821 =         this.multiplier.multiply(this, k, preCompInfo);
        varE79EE08445955BDA41CB74C2C47AC61F_1810750821.addTaint(taint);
        return varE79EE08445955BDA41CB74C2C47AC61F_1810750821;
        
        
        
            
        
        
        
            
        
        
        
            
        
        
        
    }

    
    public static class Fp extends ECPoint {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.037 -0400", hash_original_method = "C218E406154D6A68AEA278E34615CF99", hash_generated_method = "7264FC0871D150CAC2992ADBB6DA179F")
        public  Fp(ECCurve curve, ECFieldElement x, ECFieldElement y) {
            this(curve, x, y, false);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
            addTaint(curve.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.037 -0400", hash_original_method = "DA43573652764E89DCD825DB3FC87547", hash_generated_method = "624E022CF3119ADD3109D7703061A449")
        public  Fp(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression) {
            super(curve, x, y);
            addTaint(withCompression);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
            addTaint(curve.getTaint());
    if((x != null && y == null) || (x == null && y != null))            
            {
                IllegalArgumentException var0966596FA1E8BAEEA9450EFD05161B24_358584929 = new IllegalArgumentException("Exactly one of the field elements is null");
                var0966596FA1E8BAEEA9450EFD05161B24_358584929.addTaint(taint);
                throw var0966596FA1E8BAEEA9450EFD05161B24_358584929;
            } 
            this.withCompression = withCompression;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.038 -0400", hash_original_method = "122C86DAB9B6EC00B00943741F6C7C43", hash_generated_method = "4911DDC02583A9F16ECEBCD8F2BE17E7")
        public byte[] getEncoded() {
    if(this.isInfinity())            
            {
                byte[] varE60031EAA71A2FC01277A55510734340_553317892 = (new byte[1]);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1299084051 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_1299084051;
            } 
            int qLength = converter.getByteLength(x);
    if(withCompression)            
            {
                byte PC;
    if(this.getY().toBigInteger().testBit(0))                
                {
                    PC = 0x03;
                } 
                else
                {
                    PC = 0x02;
                } 
                byte[] X = converter.integerToBytes(this.getX().toBigInteger(), qLength);
                byte[] PO = new byte[X.length + 1];
                PO[0] = PC;
                System.arraycopy(X, 0, PO, 1, X.length);
                byte[] varB3918665EE674080BF505E1B2D862187_1130485086 = (PO);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_107104642 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_107104642;
            } 
            else
            {
                byte[] X = converter.integerToBytes(this.getX().toBigInteger(), qLength);
                byte[] Y = converter.integerToBytes(this.getY().toBigInteger(), qLength);
                byte[] PO = new byte[X.length + Y.length + 1];
                PO[0] = 0x04;
                System.arraycopy(X, 0, PO, 1, X.length);
                System.arraycopy(Y, 0, PO, X.length + 1, Y.length);
                byte[] varB3918665EE674080BF505E1B2D862187_358350498 = (PO);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1481504842 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_1481504842;
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.038 -0400", hash_original_method = "95E059CAF9907A74F8544551FF4AF334", hash_generated_method = "B6792A383BBB9509C147BED89BDCD456")
        public ECPoint add(ECPoint b) {
            addTaint(b.getTaint());
    if(this.isInfinity())            
            {
ECPoint var73F89FAC8F369DF0913D10C37C1E0EA1_1294453224 =                 b;
                var73F89FAC8F369DF0913D10C37C1E0EA1_1294453224.addTaint(taint);
                return var73F89FAC8F369DF0913D10C37C1E0EA1_1294453224;
            } 
    if(b.isInfinity())            
            {
ECPoint var72A74007B2BE62B849F475C7BDA4658B_1750438214 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1750438214.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1750438214;
            } 
    if(this.x.equals(b.x))            
            {
    if(this.y.equals(b.y))                
                {
ECPoint varF3D495AFF337D27ED1AD381C51A4CAF8_1608454859 =                     this.twice();
                    varF3D495AFF337D27ED1AD381C51A4CAF8_1608454859.addTaint(taint);
                    return varF3D495AFF337D27ED1AD381C51A4CAF8_1608454859;
                } 
ECPoint varCDE459757F662B12E92627818EA576E9_1315324652 =                 this.curve.getInfinity();
                varCDE459757F662B12E92627818EA576E9_1315324652.addTaint(taint);
                return varCDE459757F662B12E92627818EA576E9_1315324652;
            } 
            ECFieldElement gamma = b.y.subtract(this.y).divide(b.x.subtract(this.x));
            ECFieldElement x3 = gamma.square().subtract(this.x).subtract(b.x);
            ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
ECPoint var071BB455154747F7E03561EA2C39CC7F_1566328108 =             new ECPoint.Fp(curve, x3, y3);
            var071BB455154747F7E03561EA2C39CC7F_1566328108.addTaint(taint);
            return var071BB455154747F7E03561EA2C39CC7F_1566328108;
            
            
            
                
            
            
            
                
            
            
            
                
                
                    
                
                
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.038 -0400", hash_original_method = "814EC5F0BAC3EF42CB4061AB2E0CCD5F", hash_generated_method = "33949B5E86D1C145AADF3A0750CBFAA0")
        public ECPoint twice() {
    if(this.isInfinity())            
            {
ECPoint var72A74007B2BE62B849F475C7BDA4658B_481053748 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_481053748.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_481053748;
            } 
    if(this.y.toBigInteger().signum() == 0)            
            {
ECPoint varCDE459757F662B12E92627818EA576E9_1138958054 =                 this.curve.getInfinity();
                varCDE459757F662B12E92627818EA576E9_1138958054.addTaint(taint);
                return varCDE459757F662B12E92627818EA576E9_1138958054;
            } 
            ECFieldElement TWO = this.curve.fromBigInteger(BigInteger.valueOf(2));
            ECFieldElement THREE = this.curve.fromBigInteger(BigInteger.valueOf(3));
            ECFieldElement gamma = this.x.square().multiply(THREE).add(curve.a).divide(y.multiply(TWO));
            ECFieldElement x3 = gamma.square().subtract(this.x.multiply(TWO));
            ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
ECPoint var3A3B53403FE81238561C7DFE7EBB0574_407339122 =             new ECPoint.Fp(curve, x3, y3, this.withCompression);
            var3A3B53403FE81238561C7DFE7EBB0574_407339122.addTaint(taint);
            return var3A3B53403FE81238561C7DFE7EBB0574_407339122;
            
            
            
                
            
            
            
                
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.038 -0400", hash_original_method = "6CF29EA69F961CE922C32B4E8E2284E5", hash_generated_method = "13CA0BCB4916A19E4CAC8DF9322E49C7")
        public ECPoint subtract(ECPoint b) {
            addTaint(b.getTaint());
    if(b.isInfinity())            
            {
ECPoint var72A74007B2BE62B849F475C7BDA4658B_564597927 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_564597927.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_564597927;
            } 
ECPoint var32038E816FAB690831584DAC6FED51A3_154466517 =             add(b.negate());
            var32038E816FAB690831584DAC6FED51A3_154466517.addTaint(taint);
            return var32038E816FAB690831584DAC6FED51A3_154466517;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.039 -0400", hash_original_method = "18C2403460E252970B56CE0DE1D343AC", hash_generated_method = "67EC5EFAFA42390ACF8C7CEB40269A50")
        public ECPoint negate() {
ECPoint var35D308A124E50E56D68F906961B3437A_1065451652 =             new ECPoint.Fp(curve, this.x, this.y.negate(), this.withCompression);
            var35D308A124E50E56D68F906961B3437A_1065451652.addTaint(taint);
            return var35D308A124E50E56D68F906961B3437A_1065451652;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.039 -0400", hash_original_method = "8EF68E9821BB7A65A39BDB5C806DAEDA", hash_generated_method = "A84F5AA9EF7CF3DA1FBD1EFDFDB204F7")
        synchronized void assertECMultiplier() {
    if(this.multiplier == null)            
            {
                this.multiplier = new WNafMultiplier();
            } 
            
            
            
                
            
        }

        
    }


    
    public static class F2m extends ECPoint {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.039 -0400", hash_original_method = "73BD63756191E5AAFB19346FBE556EB3", hash_generated_method = "85DC6EED2BC08775B318F74ACB17C246")
        public  F2m(ECCurve curve, ECFieldElement x, ECFieldElement y) {
            this(curve, x, y, false);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
            addTaint(curve.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.039 -0400", hash_original_method = "4610FCAEB1DDBBF845E95D34129A59A7", hash_generated_method = "ED42BBA91D620AA0B04E470248F950E4")
        public  F2m(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression) {
            super(curve, x, y);
            addTaint(withCompression);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
            addTaint(curve.getTaint());
    if((x != null && y == null) || (x == null && y != null))            
            {
                IllegalArgumentException var0966596FA1E8BAEEA9450EFD05161B24_2047670718 = new IllegalArgumentException("Exactly one of the field elements is null");
                var0966596FA1E8BAEEA9450EFD05161B24_2047670718.addTaint(taint);
                throw var0966596FA1E8BAEEA9450EFD05161B24_2047670718;
            } 
    if(x != null)            
            {
                ECFieldElement.F2m.checkFieldElements(this.x, this.y);
    if(curve != null)                
                {
                    ECFieldElement.F2m.checkFieldElements(this.x, this.curve.getA());
                } 
            } 
            this.withCompression = withCompression;
            
            
            
                
            
            
            
                
                
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.040 -0400", hash_original_method = "91DE6710B35AB1954917AAE97889BD70", hash_generated_method = "55D3596B01A11DFF0B1B65D49EA3C990")
        public byte[] getEncoded() {
    if(this.isInfinity())            
            {
                byte[] varE60031EAA71A2FC01277A55510734340_1513734247 = (new byte[1]);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_694698143 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_694698143;
            } 
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
                    } 
                } 
                System.arraycopy(X, 0, PO, 1, byteCount);
            } 
            else
            {
                byte[] Y = converter.integerToBytes(this.getY().toBigInteger(), byteCount);
                PO = new byte[byteCount + byteCount + 1];
                PO[0] = 0x04;
                System.arraycopy(X, 0, PO, 1, byteCount);
                System.arraycopy(Y, 0, PO, byteCount + 1, byteCount);
            } 
            byte[] varB3918665EE674080BF505E1B2D862187_540266293 = (PO);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_624976001 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_624976001;
            
            
        }

        
                private static void checkPoints(ECPoint a, ECPoint b) {
            if (!(a.curve.equals(b.curve)))
            {
                throw new IllegalArgumentException("Only points on the same "
                        + "curve can be added or subtracted");
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.040 -0400", hash_original_method = "CE1FEB0E79091A4CCB0243E0EA7A28CB", hash_generated_method = "5D0D61E54F58F6B4967949205807A6B6")
        public ECPoint add(ECPoint b) {
            addTaint(b.getTaint());
            checkPoints(this, b);
ECPoint var6E12BF01C43F8636C37FF895272EA727_453548242 =             addSimple((ECPoint.F2m)b);
            var6E12BF01C43F8636C37FF895272EA727_453548242.addTaint(taint);
            return var6E12BF01C43F8636C37FF895272EA727_453548242;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.041 -0400", hash_original_method = "230992766041FE2E7B78B40F0E0C1144", hash_generated_method = "F3C9BE3CDCF27EE21E5C172866E3AF6E")
        public ECPoint.F2m addSimple(ECPoint.F2m b) {
            addTaint(b.getTaint());
            ECPoint.F2m other = b;
    if(this.isInfinity())            
            {
ECPoint.F2m var4E21B9EBDCBB8C692A7FDE6A282BDC6C_70584383 =                 other;
                var4E21B9EBDCBB8C692A7FDE6A282BDC6C_70584383.addTaint(taint);
                return var4E21B9EBDCBB8C692A7FDE6A282BDC6C_70584383;
            } 
    if(other.isInfinity())            
            {
ECPoint.F2m var72A74007B2BE62B849F475C7BDA4658B_1170343860 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1170343860.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1170343860;
            } 
            ECFieldElement.F2m x2 = (ECFieldElement.F2m)other.getX();
            ECFieldElement.F2m y2 = (ECFieldElement.F2m)other.getY();
    if(this.x.equals(x2))            
            {
    if(this.y.equals(y2))                
                {
ECPoint.F2m var1919DF098077FD20F1EAB39A6C86E871_1961251887 =                     (ECPoint.F2m)this.twice();
                    var1919DF098077FD20F1EAB39A6C86E871_1961251887.addTaint(taint);
                    return var1919DF098077FD20F1EAB39A6C86E871_1961251887;
                } 
ECPoint.F2m varCEF30124D84DA9F1B4850269BC04DF84_1990412942 =                 (ECPoint.F2m)this.curve.getInfinity();
                varCEF30124D84DA9F1B4850269BC04DF84_1990412942.addTaint(taint);
                return varCEF30124D84DA9F1B4850269BC04DF84_1990412942;
            } 
            ECFieldElement.F2m lambda = (ECFieldElement.F2m)(this.y.add(y2)).divide(this.x.add(x2));
            ECFieldElement.F2m x3 = (ECFieldElement.F2m)lambda.square().add(lambda).add(this.x).add(x2).add(this.curve.getA());
            ECFieldElement.F2m y3 = (ECFieldElement.F2m)lambda.multiply(this.x.add(x3)).add(x3).add(this.y);
ECPoint.F2m varE29EE30F858B45227C50CD4435ABFBEA_1138579208 =             new ECPoint.F2m(curve, x3, y3, withCompression);
            varE29EE30F858B45227C50CD4435ABFBEA_1138579208.addTaint(taint);
            return varE29EE30F858B45227C50CD4435ABFBEA_1138579208;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.041 -0400", hash_original_method = "E180EBB5B66B4130D071F14F4EE083E4", hash_generated_method = "04CAB91488D5AEEFA9E0A6FE44073ECD")
        public ECPoint subtract(ECPoint b) {
            addTaint(b.getTaint());
            checkPoints(this, b);
ECPoint varF77FD5A0FB078C7218024671CA30605E_1310721092 =             subtractSimple((ECPoint.F2m)b);
            varF77FD5A0FB078C7218024671CA30605E_1310721092.addTaint(taint);
            return varF77FD5A0FB078C7218024671CA30605E_1310721092;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.041 -0400", hash_original_method = "FE873BC192C2EB55E75185601239ED06", hash_generated_method = "1F328D532C55FFF033BCC4560D18ADE9")
        public ECPoint.F2m subtractSimple(ECPoint.F2m b) {
            addTaint(b.getTaint());
    if(b.isInfinity())            
            {
ECPoint.F2m var72A74007B2BE62B849F475C7BDA4658B_967861696 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_967861696.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_967861696;
            } 
ECPoint.F2m var3E163E68CA57B99B76674064815F739F_1337768081 =             addSimple((ECPoint.F2m)b.negate());
            var3E163E68CA57B99B76674064815F739F_1337768081.addTaint(taint);
            return var3E163E68CA57B99B76674064815F739F_1337768081;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.042 -0400", hash_original_method = "45BA33A6C8448ED0A2617484FF5E8003", hash_generated_method = "C4788AC043EBD08C5B9A9A8DF283245B")
        public ECPoint twice() {
    if(this.isInfinity())            
            {
ECPoint var72A74007B2BE62B849F475C7BDA4658B_796191535 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_796191535.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_796191535;
            } 
    if(this.x.toBigInteger().signum() == 0)            
            {
ECPoint varCDE459757F662B12E92627818EA576E9_1320932493 =                 this.curve.getInfinity();
                varCDE459757F662B12E92627818EA576E9_1320932493.addTaint(taint);
                return varCDE459757F662B12E92627818EA576E9_1320932493;
            } 
            ECFieldElement.F2m lambda = (ECFieldElement.F2m)this.x.add(this.y.divide(this.x));
            ECFieldElement.F2m x3 = (ECFieldElement.F2m)lambda.square().add(lambda).
                    add(this.curve.getA());
            ECFieldElement ONE = this.curve.fromBigInteger(ECConstants.ONE);
            ECFieldElement.F2m y3 = (ECFieldElement.F2m)this.x.square().add(
                    x3.multiply(lambda.add(ONE)));
ECPoint varD40A7246E4D1D01EF654FCE8BF0FE2B3_1721620865 =             new ECPoint.F2m(this.curve, x3, y3, withCompression);
            varD40A7246E4D1D01EF654FCE8BF0FE2B3_1721620865.addTaint(taint);
            return varD40A7246E4D1D01EF654FCE8BF0FE2B3_1721620865;
            
            
            
                
            
            
            
                
            
            
                
            
                
                    
            
            
                
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.042 -0400", hash_original_method = "55BA3FB66363791B05BA3007051689C2", hash_generated_method = "E26BC956C66DEB0711576DC7D3104C76")
        public ECPoint negate() {
ECPoint var8A5D491956EA8C03A91531C071EF48DE_810204297 =             new ECPoint.F2m(curve, this.getX(), this.getY().add(this.getX()), withCompression);
            var8A5D491956EA8C03A91531C071EF48DE_810204297.addTaint(taint);
            return var8A5D491956EA8C03A91531C071EF48DE_810204297;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.042 -0400", hash_original_method = "B01B67DF3607CCDD35FFA0674C4BFE3B", hash_generated_method = "E45A76D24BF9B5ABAC62E018DF1E5D4F")
        synchronized void assertECMultiplier() {
    if(this.multiplier == null)            
            {
    if(((ECCurve.F2m)this.curve).isKoblitz())                
                {
                    this.multiplier = new WTauNafMultiplier();
                } 
                else
                {
                    this.multiplier = new WNafMultiplier();
                } 
            } 
            
            
            
                
                
                    
                
                
                
                    
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.042 -0400", hash_original_field = "61707B662C0781EC16F82DBF410266B9", hash_generated_field = "F6B8D48C5F5A761E5DB11D930C790FFE")

    private static X9IntegerConverter converter = new X9IntegerConverter();
}

