package javax.crypto;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.127 -0400", hash_original_field = "CDE54E566F514F637B77F1C0B5BA9798", hash_generated_field = "660D008EA392E932E9C27E468BE1012B")

    private String algName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.127 -0400", hash_original_field = "7C84309AC8E9D8F6A788665EE8BFA306", hash_generated_field = "F067F90327B8A01DE7755B4FD06CC969")

    private AlgorithmParameters algParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.127 -0400", hash_original_field = "FD9F143D24DD0F6855EAA19A35811499", hash_generated_field = "B29484238F58CF38DC30E0B9CE6E09D3")

    private byte[] encryptedData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.127 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "D745B114B0A51171DAD36F87C0CC38B4")

    private String oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.127 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "30CBCFF31EBF02BAF8CCE8746893E2BE")

    private volatile byte[] encoded;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.128 -0400", hash_original_method = "5968D7DC318FA4818B0D7FF4BA782716", hash_generated_method = "F9DC98C2370ACFAD81E7ABE081069519")
    public  EncryptedPrivateKeyInfo(byte[] encoded) throws IOException {
    if(encoded == null)        
        {
            NullPointerException varF215BBBAFF3B22123B6E74A3B33D768B_1627676774 = new NullPointerException("encoded == null");
            varF215BBBAFF3B22123B6E74A3B33D768B_1627676774.addTaint(taint);
            throw varF215BBBAFF3B22123B6E74A3B33D768B_1627676774;
        } 
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
                } 
            } 
            catch (NoSuchAlgorithmException e)
            {
            } 
        } 
        algParameters = aParams;
        encryptedData = (byte[]) values[1];
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.130 -0400", hash_original_method = "C009D0E8F0D5EB33E14FDFB24A942703", hash_generated_method = "2CD6BCECAA8A5ECB95888841C1C1DDFE")
    public  EncryptedPrivateKeyInfo(String encrAlgName, byte[] encryptedData) throws NoSuchAlgorithmException {
    if(encrAlgName == null)        
        {
            NullPointerException var40EA0D6626268DAB57CC8B921E71592D_2106317018 = new NullPointerException("the algName parameter is null");
            var40EA0D6626268DAB57CC8B921E71592D_2106317018.addTaint(taint);
            throw var40EA0D6626268DAB57CC8B921E71592D_2106317018;
        } 
        this.algName = encrAlgName;
    if(!mapAlgName())        
        {
            NoSuchAlgorithmException var12BBD33B192D793F4E3FDBF9C38549C1_2072461289 = new NoSuchAlgorithmException("Unsupported algorithm: " + this.algName);
            var12BBD33B192D793F4E3FDBF9C38549C1_2072461289.addTaint(taint);
            throw var12BBD33B192D793F4E3FDBF9C38549C1_2072461289;
        } 
    if(encryptedData == null)        
        {
            NullPointerException var399146B293373E9C584B69D8F28976CF_1173375007 = new NullPointerException("encryptedData == null");
            var399146B293373E9C584B69D8F28976CF_1173375007.addTaint(taint);
            throw var399146B293373E9C584B69D8F28976CF_1173375007;
        } 
    if(encryptedData.length == 0)        
        {
            IllegalArgumentException varF35971D54A9625AB80D211A6F849BA56_556682315 = new IllegalArgumentException("encryptedData.length == 0");
            varF35971D54A9625AB80D211A6F849BA56_556682315.addTaint(taint);
            throw varF35971D54A9625AB80D211A6F849BA56_556682315;
        } 
        this.encryptedData = new byte[encryptedData.length];
        System.arraycopy(encryptedData, 0,
                this.encryptedData, 0, encryptedData.length);
        this.algParameters = null;
        
        
            
        
        
        
            
        
        
            
        
        
            
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.131 -0400", hash_original_method = "5A4FF1B4B6EE8C8ABD405D2DD33761E1", hash_generated_method = "750567E9D725AA4AE632DA7804F3C7D4")
    public  EncryptedPrivateKeyInfo(AlgorithmParameters algParams, byte[] encryptedData) throws NoSuchAlgorithmException {
    if(algParams == null)        
        {
            NullPointerException varA153525986867739EB7A00966E51D0C2_1087298113 = new NullPointerException("algParams == null");
            varA153525986867739EB7A00966E51D0C2_1087298113.addTaint(taint);
            throw varA153525986867739EB7A00966E51D0C2_1087298113;
        } 
        this.algParameters = algParams;
    if(encryptedData == null)        
        {
            NullPointerException var399146B293373E9C584B69D8F28976CF_359218810 = new NullPointerException("encryptedData == null");
            var399146B293373E9C584B69D8F28976CF_359218810.addTaint(taint);
            throw var399146B293373E9C584B69D8F28976CF_359218810;
        } 
    if(encryptedData.length == 0)        
        {
            IllegalArgumentException varF35971D54A9625AB80D211A6F849BA56_1647268502 = new IllegalArgumentException("encryptedData.length == 0");
            varF35971D54A9625AB80D211A6F849BA56_1647268502.addTaint(taint);
            throw varF35971D54A9625AB80D211A6F849BA56_1647268502;
        } 
        this.encryptedData = new byte[encryptedData.length];
        System.arraycopy(encryptedData, 0,
                this.encryptedData, 0, encryptedData.length);
        this.algName = this.algParameters.getAlgorithm();
    if(!mapAlgName())        
        {
            NoSuchAlgorithmException var12BBD33B192D793F4E3FDBF9C38549C1_1280622202 = new NoSuchAlgorithmException("Unsupported algorithm: " + this.algName);
            var12BBD33B192D793F4E3FDBF9C38549C1_1280622202.addTaint(taint);
            throw var12BBD33B192D793F4E3FDBF9C38549C1_1280622202;
        } 
        
        
            
        
        
        
            
        
        
            
        
        
        
                
        
        
            
        
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean isNullValue(byte[] toCheck) {
        return toCheck[0] == 5 && toCheck[1] == 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.132 -0400", hash_original_method = "099B16E0CAD27366561935338A7E9D49", hash_generated_method = "D7F10DC269DDDC06E45BBE998A24E93D")
    public String getAlgName() {
String var519B4DA5D12B38800F4F5DBB6B79043D_1922266275 =         algName;
        var519B4DA5D12B38800F4F5DBB6B79043D_1922266275.addTaint(taint);
        return var519B4DA5D12B38800F4F5DBB6B79043D_1922266275;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.132 -0400", hash_original_method = "E53778AACD7278B4FF9EA916DFF39F89", hash_generated_method = "4E7CF39CEA198A3C9B19A11E33A6AAD6")
    public AlgorithmParameters getAlgParameters() {
AlgorithmParameters var7FA38C5FF35ACD628F2BF4AA12BE3376_1312749342 =         algParameters;
        var7FA38C5FF35ACD628F2BF4AA12BE3376_1312749342.addTaint(taint);
        return var7FA38C5FF35ACD628F2BF4AA12BE3376_1312749342;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.132 -0400", hash_original_method = "953A1BC97C4FC2CA6B0BC7CB45B78971", hash_generated_method = "5306C79BDBC7BC39F9386B75ABD5B840")
    public byte[] getEncryptedData() {
        byte[] ret = new byte[encryptedData.length];
        System.arraycopy(encryptedData, 0, ret, 0, encryptedData.length);
        byte[] var2CB9DF9898E55FD0AD829DC202DDBD1C_1848077626 = (ret);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1557779423 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1557779423;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.133 -0400", hash_original_method = "5E7E74DFC3F27253F408C7A3D7CB1593", hash_generated_method = "583C9E5E77A53D695EA2353FAC47E757")
    public PKCS8EncodedKeySpec getKeySpec(Cipher cipher) throws InvalidKeySpecException {
        addTaint(cipher.getTaint());
    if(cipher == null)        
        {
            NullPointerException var5462C0B463A6B343F81D444EF806FE06_2113813096 = new NullPointerException("cipher == null");
            var5462C0B463A6B343F81D444EF806FE06_2113813096.addTaint(taint);
            throw var5462C0B463A6B343F81D444EF806FE06_2113813096;
        } 
        try 
        {
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try 
            {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } 
            catch (IOException e1)
            {
                InvalidKeySpecException varF9DDC305B41705A7314EA0DC86840BE6_819354092 = new InvalidKeySpecException("Decrypted data does not represent valid PKCS#8 PrivateKeyInfo");
                varF9DDC305B41705A7314EA0DC86840BE6_819354092.addTaint(taint);
                throw varF9DDC305B41705A7314EA0DC86840BE6_819354092;
            } 
PKCS8EncodedKeySpec var257F2893BD2E1A5430A153E3F5D4DD31_1664723374 =             new PKCS8EncodedKeySpec(decryptedData);
            var257F2893BD2E1A5430A153E3F5D4DD31_1664723374.addTaint(taint);
            return var257F2893BD2E1A5430A153E3F5D4DD31_1664723374;
        } 
        catch (IllegalStateException e)
        {
            InvalidKeySpecException var04706F3A4E57FF6D873A7C34FD2A26F0_695406318 = new InvalidKeySpecException(e.getMessage());
            var04706F3A4E57FF6D873A7C34FD2A26F0_695406318.addTaint(taint);
            throw var04706F3A4E57FF6D873A7C34FD2A26F0_695406318;
        } 
        catch (IllegalBlockSizeException e)
        {
            InvalidKeySpecException var04706F3A4E57FF6D873A7C34FD2A26F0_1418145344 = new InvalidKeySpecException(e.getMessage());
            var04706F3A4E57FF6D873A7C34FD2A26F0_1418145344.addTaint(taint);
            throw var04706F3A4E57FF6D873A7C34FD2A26F0_1418145344;
        } 
        catch (BadPaddingException e)
        {
            InvalidKeySpecException var04706F3A4E57FF6D873A7C34FD2A26F0_1151644024 = new InvalidKeySpecException(e.getMessage());
            var04706F3A4E57FF6D873A7C34FD2A26F0_1151644024.addTaint(taint);
            throw var04706F3A4E57FF6D873A7C34FD2A26F0_1151644024;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.163 -0400", hash_original_method = "E86A0445ED0DCCD02C804E7FA87DE046", hash_generated_method = "F2BD85C5E599BA7ACB7D1A4E4C39D317")
    public PKCS8EncodedKeySpec getKeySpec(Key decryptKey) throws NoSuchAlgorithmException,
               InvalidKeyException {
        addTaint(decryptKey.getTaint());
    if(decryptKey == null)        
        {
            NullPointerException var5891ACF6470AC015DA4F66FD42139803_1968593918 = new NullPointerException("decryptKey == null");
            var5891ACF6470AC015DA4F66FD42139803_1968593918.addTaint(taint);
            throw var5891ACF6470AC015DA4F66FD42139803_1968593918;
        } 
        try 
        {
            Cipher cipher = Cipher.getInstance(algName);
    if(algParameters == null)            
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey);
            } 
            else
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey, algParameters);
            } 
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try 
            {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } 
            catch (IOException e1)
            {
                java.security.InvalidKeyException var834709554883F625E20CDB39EFD63D42_1242126437 = invalidKey();
                var834709554883F625E20CDB39EFD63D42_1242126437.addTaint(taint);
                throw var834709554883F625E20CDB39EFD63D42_1242126437;
            } 
PKCS8EncodedKeySpec var257F2893BD2E1A5430A153E3F5D4DD31_1513638301 =             new PKCS8EncodedKeySpec(decryptedData);
            var257F2893BD2E1A5430A153E3F5D4DD31_1513638301.addTaint(taint);
            return var257F2893BD2E1A5430A153E3F5D4DD31_1513638301;
        } 
        catch (NoSuchPaddingException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_829415414 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_829415414.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_829415414;
        } 
        catch (InvalidAlgorithmParameterException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_1313150403 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_1313150403.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_1313150403;
        } 
        catch (IllegalStateException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_96244909 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_96244909.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_96244909;
        } 
        catch (IllegalBlockSizeException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_1605454381 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_1605454381.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_1605454381;
        } 
        catch (BadPaddingException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_2023873017 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_2023873017.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_2023873017;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.194 -0400", hash_original_method = "B712B7178E60AED4791DB32F07137FE5", hash_generated_method = "7EFEDE58AC49B12CCE0EF9C8FF4EE9DF")
    public PKCS8EncodedKeySpec getKeySpec(Key decryptKey, String providerName) throws NoSuchProviderException,
               NoSuchAlgorithmException,
               InvalidKeyException {
        addTaint(providerName.getTaint());
        addTaint(decryptKey.getTaint());
    if(decryptKey == null)        
        {
            NullPointerException var5891ACF6470AC015DA4F66FD42139803_1910354502 = new NullPointerException("decryptKey == null");
            var5891ACF6470AC015DA4F66FD42139803_1910354502.addTaint(taint);
            throw var5891ACF6470AC015DA4F66FD42139803_1910354502;
        } 
    if(providerName == null)        
        {
            NullPointerException varDBFC90318C4520101EAD3D6C0F16E457_1745175761 = new NullPointerException("providerName == null");
            varDBFC90318C4520101EAD3D6C0F16E457_1745175761.addTaint(taint);
            throw varDBFC90318C4520101EAD3D6C0F16E457_1745175761;
        } 
        try 
        {
            Cipher cipher = Cipher.getInstance(algName, providerName);
    if(algParameters == null)            
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey);
            } 
            else
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey, algParameters);
            } 
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try 
            {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } 
            catch (IOException e1)
            {
                java.security.InvalidKeyException var834709554883F625E20CDB39EFD63D42_234116608 = invalidKey();
                var834709554883F625E20CDB39EFD63D42_234116608.addTaint(taint);
                throw var834709554883F625E20CDB39EFD63D42_234116608;
            } 
PKCS8EncodedKeySpec var257F2893BD2E1A5430A153E3F5D4DD31_1427033793 =             new PKCS8EncodedKeySpec(decryptedData);
            var257F2893BD2E1A5430A153E3F5D4DD31_1427033793.addTaint(taint);
            return var257F2893BD2E1A5430A153E3F5D4DD31_1427033793;
        } 
        catch (NoSuchPaddingException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_724819287 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_724819287.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_724819287;
        } 
        catch (InvalidAlgorithmParameterException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_791178220 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_791178220.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_791178220;
        } 
        catch (IllegalStateException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_1899658022 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_1899658022.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_1899658022;
        } 
        catch (IllegalBlockSizeException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_1979401802 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_1979401802.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_1979401802;
        } 
        catch (BadPaddingException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_835224113 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_835224113.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_835224113;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.222 -0400", hash_original_method = "90A968B6E2258355BD8D757E8E7A32BF", hash_generated_method = "E392E7C8391145C9FDAE166BEB0BAA03")
    public PKCS8EncodedKeySpec getKeySpec(Key decryptKey, Provider provider) throws NoSuchAlgorithmException,
               InvalidKeyException {
        addTaint(provider.getTaint());
        addTaint(decryptKey.getTaint());
    if(decryptKey == null)        
        {
            NullPointerException var5891ACF6470AC015DA4F66FD42139803_1218614494 = new NullPointerException("decryptKey == null");
            var5891ACF6470AC015DA4F66FD42139803_1218614494.addTaint(taint);
            throw var5891ACF6470AC015DA4F66FD42139803_1218614494;
        } 
    if(provider == null)        
        {
            NullPointerException var4CD3912908FC8E41F08E5C91F8B14110_949880214 = new NullPointerException("provider == null");
            var4CD3912908FC8E41F08E5C91F8B14110_949880214.addTaint(taint);
            throw var4CD3912908FC8E41F08E5C91F8B14110_949880214;
        } 
        try 
        {
            Cipher cipher = Cipher.getInstance(algName, provider);
    if(algParameters == null)            
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey);
            } 
            else
            {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey, algParameters);
            } 
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try 
            {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } 
            catch (IOException e1)
            {
                java.security.InvalidKeyException var834709554883F625E20CDB39EFD63D42_1652264432 = invalidKey();
                var834709554883F625E20CDB39EFD63D42_1652264432.addTaint(taint);
                throw var834709554883F625E20CDB39EFD63D42_1652264432;
            } 
PKCS8EncodedKeySpec var257F2893BD2E1A5430A153E3F5D4DD31_213783041 =             new PKCS8EncodedKeySpec(decryptedData);
            var257F2893BD2E1A5430A153E3F5D4DD31_213783041.addTaint(taint);
            return var257F2893BD2E1A5430A153E3F5D4DD31_213783041;
        } 
        catch (NoSuchPaddingException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_1914886693 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_1914886693.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_1914886693;
        } 
        catch (InvalidAlgorithmParameterException e)
        {
            NoSuchAlgorithmException var953D3C7B019DBC323626D6C459595541_445001904 = new NoSuchAlgorithmException(e.getMessage());
            var953D3C7B019DBC323626D6C459595541_445001904.addTaint(taint);
            throw var953D3C7B019DBC323626D6C459595541_445001904;
        } 
        catch (IllegalStateException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_2136849765 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_2136849765.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_2136849765;
        } 
        catch (IllegalBlockSizeException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_405083810 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_405083810.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_405083810;
        } 
        catch (BadPaddingException e)
        {
            InvalidKeyException var424E73DD072FDBD96F0A28FC7414F89B_1802348061 = new InvalidKeyException(e.getMessage());
            var424E73DD072FDBD96F0A28FC7414F89B_1802348061.addTaint(taint);
            throw var424E73DD072FDBD96F0A28FC7414F89B_1802348061;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.224 -0400", hash_original_method = "F2C8E0AE199C63E108D40A2C42D8E5F5", hash_generated_method = "D5C63AA6DA446F7B8CF8463A0C61BC6B")
    private InvalidKeyException invalidKey() throws InvalidKeyException {
        InvalidKeyException varB88FC85BF2AB94E1CB7ED53A5595DB16_777326906 = new InvalidKeyException("Decrypted data does not represent valid PKCS#8 PrivateKeyInfo");
        varB88FC85BF2AB94E1CB7ED53A5595DB16_777326906.addTaint(taint);
        throw varB88FC85BF2AB94E1CB7ED53A5595DB16_777326906;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.225 -0400", hash_original_method = "64506A3A148BFB8614C90465965B2E22", hash_generated_method = "F5AA5E3CA409264FE03E820D20177D36")
    public byte[] getEncoded() throws IOException {
    if(encoded == null)        
        {
            encoded = asn1.encode(this);
        } 
        byte[] ret = new byte[encoded.length];
        System.arraycopy(encoded, 0, ret, 0, encoded.length);
        byte[] var2CB9DF9898E55FD0AD829DC202DDBD1C_1010432400 = (ret);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1528170929 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1528170929;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.226 -0400", hash_original_method = "BB96A16B2E5B8AF0DEB9007883ABA8DF", hash_generated_method = "71333B6F9D9794C46FC3FA33020B52AB")
    private boolean mapAlgName() {
    if(AlgNameMapper.isOID(this.algName))        
        {
            this.oid = AlgNameMapper.normalize(this.algName);
            this.algName = AlgNameMapper.map2AlgName(this.oid);
    if(this.algName == null)            
            {
                this.algName = this.oid;
            } 
        } 
        else
        {
            String stdName = AlgNameMapper.getStandardName(this.algName);
            this.oid = AlgNameMapper.map2OID(this.algName);
    if(this.oid == null)            
            {
    if(stdName == null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_2144401894 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1859413880 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1859413880;
                } 
                this.oid = AlgNameMapper.map2OID(stdName);
    if(this.oid == null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_2023535077 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1375615039 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1375615039;
                } 
                this.algName = stdName;
            } 
            else
    if(stdName != null)            
            {
                this.algName = stdName;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_276569685 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815448285 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815448285;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.227 -0400", hash_original_field = "6AA04665C95BAC4F8B2726709C882614", hash_generated_field = "3A2EA36C19E988E0FC8D93DEFFFC7188")

    private static final byte[] nullParam = new byte[] { 5, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.228 -0400", hash_original_field = "3915FFC8629FD83CE2C58F175000FC30", hash_generated_field = "EE440CD25937F7CB2C430915ECB06D37")

    private static final ASN1Sequence asn1 = new ASN1Sequence(new ASN1Type[] {
            AlgorithmIdentifier.ASN1, ASN1OctetString.getInstance() }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.228 -0400", hash_original_method = "C7B48C01EA9BD54A7C386B9C416EAF20", hash_generated_method = "3F8D62B50AC33BFCA5AB734B08078167")
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
            } 
            catch (IOException e)
            {
                RuntimeException varA6D199C19CBE64AA2A19B34C68199308_1109700630 = new RuntimeException(e.getMessage());
                varA6D199C19CBE64AA2A19B34C68199308_1109700630.addTaint(taint);
                throw varA6D199C19CBE64AA2A19B34C68199308_1109700630;
            } 
            
            
            
                        
                                
                        
                        
                    
                        
                    
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.228 -0400", hash_original_field = "322955F150D3A21F5C610454F488686A", hash_generated_field = "3DFCA1D232BF5550494DE371B7E7671D")

    private static final ASN1SetOf ASN1Attributes = new ASN1SetOf(ASN1Any.getInstance());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.229 -0400", hash_original_field = "3248A567E2B98D0A32398D43BF6B9F11", hash_generated_field = "65FF448CE0D4A9AB522AE9C1871BCFA3")

    private static final ASN1Sequence ASN1PrivateKeyInfo = new ASN1Sequence(
            new ASN1Type[] { ASN1Integer.getInstance(), AlgorithmIdentifier.ASN1,
                    ASN1OctetString.getInstance(),
                    new ASN1Implicit(0, ASN1Attributes) }) {        {
            setOptional(3); 
        }
        
        
};
}

