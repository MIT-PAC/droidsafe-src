package javax.crypto;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.utils.AlgNameMapper;
import org.apache.harmony.security.x509.AlgorithmIdentifier;






public class EncryptedPrivateKeyInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.103 -0400", hash_original_field = "CDE54E566F514F637B77F1C0B5BA9798", hash_generated_field = "660D008EA392E932E9C27E468BE1012B")

    private String algName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.103 -0400", hash_original_field = "7C84309AC8E9D8F6A788665EE8BFA306", hash_generated_field = "F067F90327B8A01DE7755B4FD06CC969")

    private AlgorithmParameters algParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.103 -0400", hash_original_field = "FD9F143D24DD0F6855EAA19A35811499", hash_generated_field = "B29484238F58CF38DC30E0B9CE6E09D3")

    private byte[] encryptedData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.103 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "D745B114B0A51171DAD36F87C0CC38B4")

    private String oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.103 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "30CBCFF31EBF02BAF8CCE8746893E2BE")

    private volatile byte[] encoded;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.105 -0400", hash_original_method = "5968D7DC318FA4818B0D7FF4BA782716", hash_generated_method = "0637BF5FB441996002D6004F0787946E")
    public  EncryptedPrivateKeyInfo(byte[] encoded) throws IOException {
        if(encoded == null)        
        {
            NullPointerException varF215BBBAFF3B22123B6E74A3B33D768B_2122259890 = new NullPointerException("encoded == null");
            varF215BBBAFF3B22123B6E74A3B33D768B_2122259890.addTaint(taint);
            throw varF215BBBAFF3B22123B6E74A3B33D768B_2122259890;
        } //End block
        this.encoded = new byte[encoded.length];
        System.arraycopy(encoded, 0, this.encoded, 0, encoded.length);
        Object[] values;
        values = (Object[])asn1.decode(encoded);
        AlgorithmIdentifier aId = (AlgorithmIdentifier) values[0];
        algName = aId.getAlgorithm();
        boolean mappingExists = mapAlgName();
        AlgorithmParameters aParams = null;
        byte[] params = aId.getParameters();
        if(params != null && !isNullValue(params))        
        {
            try 
            {
                aParams = AlgorithmParameters.getInstance(algName);
                aParams.init(aId.getParameters());
                if(!mappingExists)                
                {
                    algName = aParams.getAlgorithm();
                } //End block
            } //End block
            catch (NoSuchAlgorithmException e)
            {
            } //End block
        } //End block
        algParameters = aParams;
        encryptedData = (byte[]) values[1];
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.107 -0400", hash_original_method = "C009D0E8F0D5EB33E14FDFB24A942703", hash_generated_method = "CFCE54FD7871608BF94103CCE398F36F")
    public  EncryptedPrivateKeyInfo(String encrAlgName, byte[] encryptedData) throws NoSuchAlgorithmException {
        if(encrAlgName == null)        
        {
            NullPointerException var40EA0D6626268DAB57CC8B921E71592D_1049891173 = new NullPointerException("the algName parameter is null");
            var40EA0D6626268DAB57CC8B921E71592D_1049891173.addTaint(taint);
            throw var40EA0D6626268DAB57CC8B921E71592D_1049891173;
        } //End block
        this.algName = encrAlgName;
        if(!mapAlgName())        
        {
            NoSuchAlgorithmException var12BBD33B192D793F4E3FDBF9C38549C1_1605031398 = new NoSuchAlgorithmException("Unsupported algorithm: " + this.algName);
            var12BBD33B192D793F4E3FDBF9C38549C1_1605031398.addTaint(taint);
            throw var12BBD33B192D793F4E3FDBF9C38549C1_1605031398;
        } //End block
        if(encryptedData == null)        
        {
            NullPointerException var399146B293373E9C584B69D8F28976CF_1535072721 = new NullPointerException("encryptedData == null");
            var399146B293373E9C584B69D8F28976CF_1535072721.addTaint(taint);
            throw var399146B293373E9C584B69D8F28976CF_1535072721;
        } //End block
        if(encryptedData.length == 0)        
        {
            IllegalArgumentException varF35971D54A9625AB80D211A6F849BA56_1327384091 = new IllegalArgumentException("encryptedData.length == 0");
            varF35971D54A9625AB80D211A6F849BA56_1327384091.addTaint(taint);
            throw varF35971D54A9625AB80D211A6F849BA56_1327384091;
        } //End block
        this.encryptedData = new byte[encryptedData.length];
        System.arraycopy(encryptedData, 0,
                this.encryptedData, 0, encryptedData.length);
        this.algParameters = null;
        // ---------- Original Method ----------
        //if (encrAlgName == null) {
            //throw new NullPointerException("the algName parameter is null");
        //}
        //this.algName = encrAlgName;
        //if (!mapAlgName()) {
            //throw new NoSuchAlgorithmException("Unsupported algorithm: " + this.algName);
        //}
        //if (encryptedData == null) {
            //throw new NullPointerException("encryptedData == null");
        //}
        //if (encryptedData.length == 0) {
            //throw new IllegalArgumentException("encryptedData.length == 0");
        //}
        //this.encryptedData = new byte[encryptedData.length];
        //System.arraycopy(encryptedData, 0,
                //this.encryptedData, 0, encryptedData.length);
        //this.algParameters = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.109 -0400", hash_original_method = "5A4FF1B4B6EE8C8ABD405D2DD33761E1", hash_generated_method = "518CCACE5B8E0C2184D34F896CF0A7BF")
    public  EncryptedPrivateKeyInfo(AlgorithmParameters algParams, byte[] encryptedData) throws NoSuchAlgorithmException {
        if(algParams == null)        
        {
            NullPointerException varA153525986867739EB7A00966E51D0C2_740357814 = new NullPointerException("algParams == null");
            varA153525986867739EB7A00966E51D0C2_740357814.addTaint(taint);
            throw varA153525986867739EB7A00966E51D0C2_740357814;
        } //End block
        this.algParameters = algParams;
        if(encryptedData == null)        
        {
            NullPointerException var399146B293373E9C584B69D8F28976CF_776845494 = new NullPointerException("encryptedData == null");
            var399146B293373E9C584B69D8F28976CF_776845494.addTaint(taint);
            throw var399146B293373E9C584B69D8F28976CF_776845494;
        } //End block
        if(encryptedData.length == 0)        
        {
            IllegalArgumentException varF35971D54A9625AB80D211A6F849BA56_1071780059 = new IllegalArgumentException("encryptedData.length == 0");
            varF35971D54A9625AB80D211A6F849BA56_1071780059.addTaint(taint);
            throw varF35971D54A9625AB80D211A6F849BA56_1071780059;
        } //End block
        this.encryptedData = new byte[encryptedData.length];
        System.arraycopy(encryptedData, 0,
                this.encryptedData, 0, encryptedData.length);
        this.algName = this.algParameters.getAlgorithm();
        if(!mapAlgName())        
        {
            NoSuchAlgorithmException var12BBD33B192D793F4E3FDBF9C38549C1_969473334 = new NoSuchAlgorithmException("Unsupported algorithm: " + this.algName);
            var12BBD33B192D793F4E3FDBF9C38549C1_969473334.addTaint(taint);
            throw var12BBD33B192D793F4E3FDBF9C38549C1_969473334;
        } //End block
        // ---------- Original Method ----------
        //if (algParams == null) {
            //throw new NullPointerException("algParams == null");
        //}
        //this.algParameters = algParams;
        //if (encryptedData == null) {
            //throw new NullPointerException("encryptedData == null");
        //}
        //if (encryptedData.length == 0) {
            //throw new IllegalArgumentException("encryptedData.length == 0");
        //}
        //this.encryptedData = new byte[encryptedData.length];
        //System.arraycopy(encryptedData, 0,
                //this.encryptedData, 0, encryptedData.length);
        //this.algName = this.algParameters.getAlgorithm();
        //if (!mapAlgName()) {
            //throw new NoSuchAlgorithmException("Unsupported algorithm: " + this.algName);
        //}
    }

    
    @DSModeled(DSC.BAN)
    private static boolean isNullValue(byte[] toCheck) {
        return toCheck[0] == 5 && toCheck[1] == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.110 -0400", hash_original_method = "099B16E0CAD27366561935338A7E9D49", hash_generated_method = "99935109597E12FE52D4A84EF4B0A7ED")
    public String getAlgName() {
String var519B4DA5D12B38800F4F5DBB6B79043D_1570416719 =         algName;
        var519B4DA5D12B38800F4F5DBB6B79043D_1570416719.addTaint(taint);
        return var519B4DA5D12B38800F4F5DBB6B79043D_1570416719;
        // ---------- Original Method ----------
        //return algName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.111 -0400", hash_original_method = "E53778AACD7278B4FF9EA916DFF39F89", hash_generated_method = "2D3F0D23266DD7DACF96145613EBD457")
    public AlgorithmParameters getAlgParameters() {
AlgorithmParameters var7FA38C5FF35ACD628F2BF4AA12BE3376_1384042003 =         algParameters;
        var7FA38C5FF35ACD628F2BF4AA12BE3376_1384042003.addTaint(taint);
        return var7FA38C5FF35ACD628F2BF4AA12BE3376_1384042003;
        // ---------- Original Method ----------
        //return algParameters;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.111 -0400", hash_original_method = "953A1BC97C4FC2CA6B0BC7CB45B78971", hash_generated_method = "8B8F5E5EE5054B5A10FBED2169C2A5F0")
    public byte[] getEncryptedData() {
        byte[] ret = new byte[encryptedData.length];
        System.arraycopy(encryptedData, 0, ret, 0, encryptedData.length);
        byte[] var2CB9DF9898E55FD0AD829DC202DDBD1C_1022591169 = (ret);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_40113102 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_40113102;
        // ---------- Original Method ----------
        //byte[] ret = new byte[encryptedData.length];
        //System.arraycopy(encryptedData, 0, ret, 0, encryptedData.length);
        //return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.112 -0400", hash_original_method = "5E7E74DFC3F27253F408C7A3D7CB1593", hash_generated_method = "E3374C5488045E3C7BECC7E52C6BD845")
    public PKCS8EncodedKeySpec getKeySpec(Cipher cipher) throws InvalidKeySpecException {
        addTaint(cipher.getTaint());
        if(cipher == null)        
        {
            NullPointerException var5462C0B463A6B343F81D444EF806FE06_658668863 = new NullPointerException("cipher == null");
            var5462C0B463A6B343F81D444EF806FE06_658668863.addTaint(taint);
            throw var5462C0B463A6B343F81D444EF806FE06_658668863;
        } //End block
        try 
        {
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try 
            {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } //End block
            catch (IOException e1)
            {
                InvalidKeySpecException varF9DDC305B41705A7314EA0DC86840BE6_269759521 = new InvalidKeySpecException("Decrypted data does not represent valid PKCS#8 PrivateKeyInfo");
                varF9DDC305B41705A7314EA0DC86840BE6_269759521.addTaint(taint);
                throw varF9DDC305B41705A7314EA0DC86840BE6_269759521;
            } //End block
PKCS8EncodedKeySpec var257F2893BD2E1A5430A153E3F5D4DD31_410462408 =             new PKCS8EncodedKeySpec(decryptedData);
            var257F2893BD2E1A5430A153E3F5D4DD31_410462408.addTaint(taint);
            return var257F2893BD2E1A5430A153E3F5D4DD31_410462408;
        } //End block
        catch (IllegalStateException e)
        {
            InvalidKeySpecException var04706F3A4E57FF6D873A7C34FD2A26F0_626833416 = new InvalidKeySpecException(e.getMessage());
            var04706F3A4E57FF6D873A7C34FD2A26F0_626833416.addTaint(taint);
            throw var04706F3A4E57FF6D873A7C34FD2A26F0_626833416;
        } //End block
        catch (IllegalBlockSizeException e)
        {
            InvalidKeySpecException var04706F3A4E57FF6D873A7C34FD2A26F0_689759149 = new InvalidKeySpecException(e.getMessage());
            var04706F3A4E57FF6D873A7C34FD2A26F0_689759149.addTaint(taint);
            throw var04706F3A4E57FF6D873A7C34FD2A26F0_689759149;
        } //End block
        catch (BadPaddingException e)
        {
            InvalidKeySpecException var04706F3A4E57FF6D873A7C34FD2A26F0_1434484544 = new InvalidKeySpecException(e.getMessage());
            var04706F3A4E57FF6D873A7C34FD2A26F0_1434484544.addTaint(taint);
            throw var04706F3A4E57FF6D873A7C34FD2A26F0_1434484544;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.139 -0400", hash_original_method = "E86A0445ED0DCCD02C804E7FA87DE046", hash_generated_method = "3A227065BCAE4EF208555AF2B9F1C773")
    public PKCS8EncodedKeySpec getKeySpec(Key decryptKey) throws NoSuchAlgorithmException,
               InvalidKeyException {
        addTaint(decryptKey.getTaint());
        if(decryptKey == null)        
        {
            NullPointerException var5891ACF6470AC015DA4F66FD42139803_188957476 = new NullPointerException("decryptKey == null");
            var5891ACF6470AC015DA4F66FD42139803_188957476.addTaint(taint);
            throw var5891ACF6470AC015DA4F66FD42139803_188957476;
        } //End block
        try 
        {
            Cipher cipher = Cipher.getInstance(algName);
            if(algParameters == null)            
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey);
            } //End block
            else
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey, algParameters);
            } //End block
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try 
            {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } //End block
            catch (IOException e1)
            {
                java.security.InvalidKeyException var834709554883F625E20CDB39EFD63D42_1580236873 = invalidKey();
                var834709554883F625E20CDB39EFD63D42_1580236873.addTaint(taint);
                throw var834709554883F625E20CDB39EFD63D42_1580236873;
            } //End block
PKCS8EncodedKeySpec var257F2893BD2E1A5430A153E3F5D4DD31_1502893277 =             new PKCS8EncodedKeySpec(decryptedData);
            var257F2893BD2E1A5430A153E3F5D4DD31_1502893277.addTaint(taint);
            return var257F2893BD2E1A5430A153E3F5D4DD31_1502893277;
        } //End block
        catch (NoSuchPaddingException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_832906113 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_832906113.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_832906113;
        } //End block
        catch (InvalidAlgorithmParameterException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_2099489792 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_2099489792.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_2099489792;
        } //End block
        catch (IllegalStateException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_1473794584 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_1473794584.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_1473794584;
        } //End block
        catch (IllegalBlockSizeException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_258290399 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_258290399.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_258290399;
        } //End block
        catch (BadPaddingException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_615594229 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_615594229.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_615594229;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.168 -0400", hash_original_method = "B712B7178E60AED4791DB32F07137FE5", hash_generated_method = "D294784F6CAF0422FE587530E1F9813D")
    public PKCS8EncodedKeySpec getKeySpec(Key decryptKey, String providerName) throws NoSuchProviderException,
               NoSuchAlgorithmException,
               InvalidKeyException {
        addTaint(providerName.getTaint());
        addTaint(decryptKey.getTaint());
        if(decryptKey == null)        
        {
            NullPointerException var5891ACF6470AC015DA4F66FD42139803_1044114342 = new NullPointerException("decryptKey == null");
            var5891ACF6470AC015DA4F66FD42139803_1044114342.addTaint(taint);
            throw var5891ACF6470AC015DA4F66FD42139803_1044114342;
        } //End block
        if(providerName == null)        
        {
            NullPointerException varDBFC90318C4520101EAD3D6C0F16E457_471826870 = new NullPointerException("providerName == null");
            varDBFC90318C4520101EAD3D6C0F16E457_471826870.addTaint(taint);
            throw varDBFC90318C4520101EAD3D6C0F16E457_471826870;
        } //End block
        try 
        {
            Cipher cipher = Cipher.getInstance(algName, providerName);
            if(algParameters == null)            
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey);
            } //End block
            else
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey, algParameters);
            } //End block
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try 
            {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } //End block
            catch (IOException e1)
            {
                java.security.InvalidKeyException var834709554883F625E20CDB39EFD63D42_11248363 = invalidKey();
                var834709554883F625E20CDB39EFD63D42_11248363.addTaint(taint);
                throw var834709554883F625E20CDB39EFD63D42_11248363;
            } //End block
PKCS8EncodedKeySpec var257F2893BD2E1A5430A153E3F5D4DD31_1118771816 =             new PKCS8EncodedKeySpec(decryptedData);
            var257F2893BD2E1A5430A153E3F5D4DD31_1118771816.addTaint(taint);
            return var257F2893BD2E1A5430A153E3F5D4DD31_1118771816;
        } //End block
        catch (NoSuchPaddingException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_2134022459 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_2134022459.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_2134022459;
        } //End block
        catch (InvalidAlgorithmParameterException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_1901732659 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_1901732659.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_1901732659;
        } //End block
        catch (IllegalStateException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_1746308266 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_1746308266.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_1746308266;
        } //End block
        catch (IllegalBlockSizeException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_974104488 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_974104488.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_974104488;
        } //End block
        catch (BadPaddingException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_954414428 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_954414428.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_954414428;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.190 -0400", hash_original_method = "90A968B6E2258355BD8D757E8E7A32BF", hash_generated_method = "41A41B1CE4C0894F3B59CF9CA7927E78")
    public PKCS8EncodedKeySpec getKeySpec(Key decryptKey, Provider provider) throws NoSuchAlgorithmException,
               InvalidKeyException {
        addTaint(provider.getTaint());
        addTaint(decryptKey.getTaint());
        if(decryptKey == null)        
        {
            NullPointerException var5891ACF6470AC015DA4F66FD42139803_2112058319 = new NullPointerException("decryptKey == null");
            var5891ACF6470AC015DA4F66FD42139803_2112058319.addTaint(taint);
            throw var5891ACF6470AC015DA4F66FD42139803_2112058319;
        } //End block
        if(provider == null)        
        {
            NullPointerException var4CD3912908FC8E41F08E5C91F8B14110_297913062 = new NullPointerException("provider == null");
            var4CD3912908FC8E41F08E5C91F8B14110_297913062.addTaint(taint);
            throw var4CD3912908FC8E41F08E5C91F8B14110_297913062;
        } //End block
        try 
        {
            Cipher cipher = Cipher.getInstance(algName, provider);
            if(algParameters == null)            
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey);
            } //End block
            else
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey, algParameters);
            } //End block
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try 
            {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } //End block
            catch (IOException e1)
            {
                java.security.InvalidKeyException var834709554883F625E20CDB39EFD63D42_1809651627 = invalidKey();
                var834709554883F625E20CDB39EFD63D42_1809651627.addTaint(taint);
                throw var834709554883F625E20CDB39EFD63D42_1809651627;
            } //End block
PKCS8EncodedKeySpec var257F2893BD2E1A5430A153E3F5D4DD31_2093323626 =             new PKCS8EncodedKeySpec(decryptedData);
            var257F2893BD2E1A5430A153E3F5D4DD31_2093323626.addTaint(taint);
            return var257F2893BD2E1A5430A153E3F5D4DD31_2093323626;
        } //End block
        catch (NoSuchPaddingException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_961011072 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_961011072.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_961011072;
        } //End block
        catch (InvalidAlgorithmParameterException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_1870702560 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_1870702560.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_1870702560;
        } //End block
        catch (IllegalStateException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_1223078374 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_1223078374.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_1223078374;
        } //End block
        catch (IllegalBlockSizeException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_1018070725 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_1018070725.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_1018070725;
        } //End block
        catch (BadPaddingException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_277347482 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_277347482.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_277347482;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.190 -0400", hash_original_method = "F2C8E0AE199C63E108D40A2C42D8E5F5", hash_generated_method = "9D071966545943DF1C6EC0E035663AD2")
    private InvalidKeyException invalidKey() throws InvalidKeyException {
        InvalidKeyException varB88FC85BF2AB94E1CB7ED53A5595DB16_1975010713 = new InvalidKeyException("Decrypted data does not represent valid PKCS#8 PrivateKeyInfo");
        varB88FC85BF2AB94E1CB7ED53A5595DB16_1975010713.addTaint(taint);
        throw varB88FC85BF2AB94E1CB7ED53A5595DB16_1975010713;
        // ---------- Original Method ----------
        //throw new InvalidKeyException("Decrypted data does not represent valid PKCS#8 PrivateKeyInfo");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.191 -0400", hash_original_method = "64506A3A148BFB8614C90465965B2E22", hash_generated_method = "1DDEC8C4319A7ABB507656835A476D8D")
    public byte[] getEncoded() throws IOException {
        if(encoded == null)        
        {
            encoded = asn1.encode(this);
        } //End block
        byte[] ret = new byte[encoded.length];
        System.arraycopy(encoded, 0, ret, 0, encoded.length);
        byte[] var2CB9DF9898E55FD0AD829DC202DDBD1C_1597068751 = (ret);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1015539331 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1015539331;
        // ---------- Original Method ----------
        //if (encoded == null) {
            //encoded = asn1.encode(this);
        //}
        //byte[] ret = new byte[encoded.length];
        //System.arraycopy(encoded, 0, ret, 0, encoded.length);
        //return ret;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.192 -0400", hash_original_method = "BB96A16B2E5B8AF0DEB9007883ABA8DF", hash_generated_method = "08E7CB67140B65B45072E8447AF87A89")
    private boolean mapAlgName() {
        if(AlgNameMapper.isOID(this.algName))        
        {
            this.oid = AlgNameMapper.normalize(this.algName);
            this.algName = AlgNameMapper.map2AlgName(this.oid);
            if(this.algName == null)            
            {
                this.algName = this.oid;
            } //End block
        } //End block
        else
        {
            String stdName = AlgNameMapper.getStandardName(this.algName);
            this.oid = AlgNameMapper.map2OID(this.algName);
            if(this.oid == null)            
            {
                if(stdName == null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1219448913 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_901436090 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_901436090;
                } //End block
                this.oid = AlgNameMapper.map2OID(stdName);
                if(this.oid == null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_29302673 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_501349562 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_501349562;
                } //End block
                this.algName = stdName;
            } //End block
            else
            if(stdName != null)            
            {
                this.algName = stdName;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1500156323 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_462371295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_462371295;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.193 -0400", hash_original_field = "6AA04665C95BAC4F8B2726709C882614", hash_generated_field = "3A2EA36C19E988E0FC8D93DEFFFC7188")

    private static final byte[] nullParam = new byte[] { 5, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.195 -0400", hash_original_field = "3915FFC8629FD83CE2C58F175000FC30", hash_generated_field = "60288359336523FE1C59A5FB75AA0AE8")

    private static final ASN1Sequence asn1 = new ASN1Sequence(new ASN1Type[] {
            AlgorithmIdentifier.ASN1, ASN1OctetString.getInstance() }) {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.194 -0400", hash_original_method = "C7B48C01EA9BD54A7C386B9C416EAF20", hash_generated_method = "08F72077AAEF1EB6834FA5F016975C20")
        @Override
        protected void getValues(Object object, Object[] values) {
            addTaint(values[0].getTaint());
            addTaint(object.getTaint());
            EncryptedPrivateKeyInfo epki = (EncryptedPrivateKeyInfo) object;
            try 
            {
                byte[] algParmsEncoded = (epki.algParameters == null) ? nullParam
                                : epki.algParameters.getEncoded();
                values[0] = new AlgorithmIdentifier(epki.oid, algParmsEncoded);
                values[1] = epki.encryptedData;
            } //End block
            catch (IOException e)
            {
                RuntimeException varA6D199C19CBE64AA2A19B34C68199308_12159957 = new RuntimeException(e.getMessage());
                varA6D199C19CBE64AA2A19B34C68199308_12159957.addTaint(taint);
                throw varA6D199C19CBE64AA2A19B34C68199308_12159957;
            } //End block
            // ---------- Original Method ----------
            //EncryptedPrivateKeyInfo epki = (EncryptedPrivateKeyInfo) object;
            //try {
                        //byte[] algParmsEncoded = (epki.algParameters == null) ? nullParam
                                //: epki.algParameters.getEncoded();
                        //values[0] = new AlgorithmIdentifier(epki.oid, algParmsEncoded);
                        //values[1] = epki.encryptedData;
                    //} catch (IOException e) {
                        //throw new RuntimeException(e.getMessage());
                    //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.195 -0400", hash_original_field = "322955F150D3A21F5C610454F488686A", hash_generated_field = "3DFCA1D232BF5550494DE371B7E7671D")

    private static final ASN1SetOf ASN1Attributes = new ASN1SetOf(ASN1Any.getInstance());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.195 -0400", hash_original_field = "3248A567E2B98D0A32398D43BF6B9F11", hash_generated_field = "65FF448CE0D4A9AB522AE9C1871BCFA3")

    private static final ASN1Sequence ASN1PrivateKeyInfo = new ASN1Sequence(
            new ASN1Type[] { ASN1Integer.getInstance(), AlgorithmIdentifier.ASN1,
                    ASN1OctetString.getInstance(),
                    new ASN1Implicit(0, ASN1Attributes) }) {        {
            setOptional(3); 
        }
        
        
};
}

