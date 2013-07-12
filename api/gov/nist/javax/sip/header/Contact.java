package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.address.AddressImpl;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ContactHeader;
import java.text.ParseException;

public final class Contact extends AddressParametersHeader implements javax.sip.header.ContactHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.202 -0400", hash_original_field = "2C04975BEEFBAA5B93021155A216F16C", hash_generated_field = "F8D42AD524689A7075829FDA71AD2B65")

    private ContactList contactList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.202 -0400", hash_original_field = "2B693317E0EDEF07068B2C8EBF6F79C5", hash_generated_field = "59B10415DC4BAEC3C3C191C79EC370BD")

    protected boolean wildCardFlag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.202 -0400", hash_original_method = "91EC1BE71FCEDDA82A3A1E5DD0E8F369", hash_generated_method = "2C3BCCEE45586F853C3FCDA950D37478")
    public  Contact() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.203 -0400", hash_original_method = "610F5F9F0EA9EBC7B3CD81D4F6E695C1", hash_generated_method = "12D552FAC3F9B1C8E0AF7C22B41B5B70")
    public void setParameter(String name, String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nv = parameters.getNameValue(name);
    if(nv != null)        
        {
            nv.setValueAsObject(value);
        } 
        else
        {
            nv = new NameValue(name, value);
    if(name.equalsIgnoreCase("methods"))            
            nv.setQuotedValue();
            this.parameters.set(nv);
        } 
        
        
        
            
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.204 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "1879FF756CA27046FA6D149096838EF6")
    protected String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_955023612 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_955023612.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_955023612;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.205 -0400", hash_original_method = "E69C365FF0754FE9819DC42713FEDDD9", hash_generated_method = "B9266971CF3C18B08639E65CBDBE7345")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(wildCardFlag)        
        {
            buffer.append('*');
        } 
        else
        {
    if(address.getAddressType() == AddressImpl.NAME_ADDR)            
            {
                address.encode(buffer);
            } 
            else
            {
                buffer.append('<');
                address.encode(buffer);
                buffer.append('>');
            } 
    if(!parameters.isEmpty())            
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } 
        } 
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1607930100 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1607930100.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1607930100;
        
        
            
        
        
            
                
            
                
                
                
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.207 -0400", hash_original_method = "1B424E93D6F15660DA959554DF30A2C0", hash_generated_method = "7F07364DB40EA644480C13D92D823141")
    public ContactList getContactList() {
ContactList var9DC40F36BF1EF5EBE44715EDBA836495_332427747 =         contactList;
        var9DC40F36BF1EF5EBE44715EDBA836495_332427747.addTaint(taint);
        return var9DC40F36BF1EF5EBE44715EDBA836495_332427747;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.207 -0400", hash_original_method = "B792A1C78C2262E486AC16BC668CCB6D", hash_generated_method = "89C15ACBF3A0E51F5029B47D08C01554")
    public boolean getWildCardFlag() {
        boolean var2B693317E0EDEF07068B2C8EBF6F79C5_1488164081 = (wildCardFlag);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062551734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062551734;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.207 -0400", hash_original_method = "569FFD65B001A83BF27BFBDAD6B4F486", hash_generated_method = "32DCC38BE6918A7C1BCDDE4381D797D2")
    public javax.sip.address.Address getAddress() {
javax.sip.address.Address var814577DDD37BAFB17E08CBEFDB411BAE_1274061887 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_1274061887.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_1274061887;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.208 -0400", hash_original_method = "4240C3A651BA1AB39E9A42DB8D1F003A", hash_generated_method = "A655C4DE80A8D00599732D1C3E8816C6")
    public NameValueList getContactParms() {
NameValueList var3CB0A38B794BDEDADB1F50256E0AE35B_1568912814 =         parameters;
        var3CB0A38B794BDEDADB1F50256E0AE35B_1568912814.addTaint(taint);
        return var3CB0A38B794BDEDADB1F50256E0AE35B_1568912814;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.208 -0400", hash_original_method = "96E910216AC02ADF852A54B56C70C152", hash_generated_method = "FBBD9DAD09CC6A1E634571C3FC8FFBC2")
    public int getExpires() {
        int var209A9C88A9108DB64D96C841F2204F24_1848552889 = (getParameterAsInt(EXPIRES));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881587641 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881587641;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.209 -0400", hash_original_method = "C2F655E77754B7E4118A4EC585DCE004", hash_generated_method = "8187D189A03B2B1C4A3399FBD84255A2")
    public void setExpires(int expiryDeltaSeconds) {
        addTaint(expiryDeltaSeconds);
        Integer deltaSeconds = Integer.valueOf(expiryDeltaSeconds);
        this.parameters.set(EXPIRES, deltaSeconds);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.209 -0400", hash_original_method = "99DBCB27F8E3FF6C21E31F78BC4B32FC", hash_generated_method = "5D53AE37D0D4396383DE70C7E34D3738")
    public float getQValue() {
        float var404D17BD4166DAEB5C7CF5FDFBA83642_1996920505 = (getParameterAsFloat(Q));
                float var546ADE640B6EDFBC8A086EF31347E768_1645966210 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1645966210;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.209 -0400", hash_original_method = "395F7CDC4269F17B37AD1CEF3C00E158", hash_generated_method = "F406E6A3D3ADCD0A3AC23AB6EA1E1A36")
    public void setContactList(ContactList cl) {
        contactList = cl;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.210 -0400", hash_original_method = "967084D665F0048759202AF27AE04FCB", hash_generated_method = "DAC3B7C2C6A30EA27552317EEA0BBC5C")
    public void setWildCardFlag(boolean w) {
        addTaint(w);
        this.wildCardFlag = true;
        this.address = new AddressImpl();
        this.address.setWildCardFlag();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.210 -0400", hash_original_method = "8D515165C9CEE70CC9BAE834218A7BF9", hash_generated_method = "C8484BBF2A47CAF2F24CD2FAC98EBB38")
    public void setAddress(javax.sip.address.Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException var3DC5AE26648CEFA4BB39A1606DD56EB1_772348047 = new NullPointerException("null address");
        var3DC5AE26648CEFA4BB39A1606DD56EB1_772348047.addTaint(taint);
        throw var3DC5AE26648CEFA4BB39A1606DD56EB1_772348047;
        }
        this.address = (AddressImpl) address;
        this.wildCardFlag = false;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.210 -0400", hash_original_method = "BB23584FB6F9D8E00697707A3889A96F", hash_generated_method = "6C8E15BC0CDBD659A2B4CCBBBA984776")
    public void setQValue(float qValue) throws InvalidArgumentException {
        addTaint(qValue);
    if(qValue != -1 && (qValue < 0 || qValue > 1))        
        {
        InvalidArgumentException var718476DBF59FE6C6BBED7EC2F63E4509_691400182 = new InvalidArgumentException(
                "JAIN-SIP Exception, Contact, setQValue(), "
                    + "the qValue is not between 0 and 1");
        var718476DBF59FE6C6BBED7EC2F63E4509_691400182.addTaint(taint);
        throw var718476DBF59FE6C6BBED7EC2F63E4509_691400182;
        }
        this.parameters.set(Q, Float.valueOf(qValue));
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.211 -0400", hash_original_method = "286D385E6B16CCC7A8923BBB55E45ED9", hash_generated_method = "1C531CB9BD796627D2A6BEDCA44F3397")
    public Object clone() {
        Contact retval = (Contact) super.clone();
    if(this.contactList != null)        
        retval.contactList = (ContactList) this.contactList.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_432413770 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_432413770.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_432413770;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.211 -0400", hash_original_method = "1E8417DABA85DBF8E3B8DCC75DF6036F", hash_generated_method = "BD71C9D7F2E71AD98661C4BC21983493")
    public void setWildCard() {
        this.setWildCardFlag(true);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.211 -0400", hash_original_method = "BD70FF709E52160B451422333F6894A9", hash_generated_method = "57CD313E00DDAA0C7C4B50E9A0E7FF21")
    public boolean isWildCard() {
        boolean var7ED659C02E6D5D00C228848AF236F648_1678227563 = (this.address.isWildcard());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700682597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700682597;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.212 -0400", hash_original_method = "BA2F3C2ED46538A7D01836631FBE38C7", hash_generated_method = "32AD8F7EA1EF9B739850839232C3C757")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean varF68DD3AFFC6AD118BE0DFBC512F5AA11_466849891 = ((other instanceof ContactHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1883683897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1883683897;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.212 -0400", hash_original_method = "D8F26C6BEBC4025EE87D6A90A29B455D", hash_generated_method = "313E1D1DECA7B5B401FA936C75FEB16C")
    public void removeSipInstanceParam() {
    if(parameters != null)        
        parameters.delete(ParameterNames.SIP_INSTANCE);
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.212 -0400", hash_original_method = "EA50318741E259995DB1E983FC6CAFD1", hash_generated_method = "21858D74190E613B6DCE2A3C808FF378")
    public String getSipInstanceParam() {
String var7DFD8D696E764496452DB12725EA3695_1823998722 =         (String) parameters.getValue(ParameterNames.SIP_INSTANCE);
        var7DFD8D696E764496452DB12725EA3695_1823998722.addTaint(taint);
        return var7DFD8D696E764496452DB12725EA3695_1823998722;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.213 -0400", hash_original_method = "B439361A999D0B73C2E9828E38E26B04", hash_generated_method = "02E51CD24573BE0406A830BEE6A067F8")
    public void setSipInstanceParam(String value) {
        addTaint(value.getTaint());
        this.parameters.set(ParameterNames.SIP_INSTANCE, value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.213 -0400", hash_original_method = "8AD6127ED19B3CFA328D7ED80A755AFB", hash_generated_method = "643CAA66D34789620BF3FB8564A3FCB3")
    public void removePubGruuParam() {
    if(parameters != null)        
        parameters.delete(ParameterNames.PUB_GRUU);
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.213 -0400", hash_original_method = "3B3B357FD219B3690182EE4F60CD3DC6", hash_generated_method = "6E00736F9BF336BAC26596445329ABDA")
    public String getPubGruuParam() {
String var2B53C1FB9CE24A0A29C31B5A2CC414D4_1050353257 =         (String) parameters.getValue(ParameterNames.PUB_GRUU);
        var2B53C1FB9CE24A0A29C31B5A2CC414D4_1050353257.addTaint(taint);
        return var2B53C1FB9CE24A0A29C31B5A2CC414D4_1050353257;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.213 -0400", hash_original_method = "E6BD4CB1D1049F858BE017703EF776B9", hash_generated_method = "F820B083A6602B4D023AE5B62FD8EF33")
    public void setPubGruuParam(String value) {
        addTaint(value.getTaint());
        this.parameters.set(ParameterNames.PUB_GRUU, value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.213 -0400", hash_original_method = "493973B7C3E0E7D72E4F9CB95002E20E", hash_generated_method = "A2E23EE73F72F75AC637C41B2CD2080A")
    public void removeTempGruuParam() {
    if(parameters != null)        
        parameters.delete(ParameterNames.TEMP_GRUU);
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.214 -0400", hash_original_method = "19861AEE803C91FE7A0A9CDBD1C78B9E", hash_generated_method = "E09CFF66B5C774E72EBA7A4288F54CE8")
    public String getTempGruuParam() {
String var8E06E5B3DEF200BEFDEB7AD4D5D7BCA5_1428465169 =         (String) parameters.getValue(ParameterNames.TEMP_GRUU);
        var8E06E5B3DEF200BEFDEB7AD4D5D7BCA5_1428465169.addTaint(taint);
        return var8E06E5B3DEF200BEFDEB7AD4D5D7BCA5_1428465169;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.214 -0400", hash_original_method = "64FD1572329B063AD4EC10A23207E509", hash_generated_method = "C9F9D3E2E9E4C023361CB2C1FDEA479C")
    public void setTempGruuParam(String value) {
        addTaint(value.getTaint());
        this.parameters.set(ParameterNames.TEMP_GRUU, value);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.214 -0400", hash_original_field = "5AFC9165F4F13161D6E81B7A52284790", hash_generated_field = "D5EF41A2EAE5A5CDE5AE467B71E69779")

    private static final long serialVersionUID = 1677294871695706288L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.214 -0400", hash_original_field = "5273C05B8C162F0DB818C1AB4FDFA2C6", hash_generated_field = "625B8D92ECBBC935F308044A15203C68")

    public static final String ACTION = ParameterNames.ACTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.214 -0400", hash_original_field = "C2AD9A521A1D1921C119673CB9B1F68D", hash_generated_field = "E03817F60405358048E53FECF5415E6C")

    public static final String PROXY = ParameterNames.PROXY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.214 -0400", hash_original_field = "E6426B79DCBB46AAF1038F671A23F80C", hash_generated_field = "6F331C4088ABB38593B6B56E77FD3DE2")

    public static final String REDIRECT = ParameterNames.REDIRECT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.214 -0400", hash_original_field = "8206C7AE7A741E76A468E0365AAB524A", hash_generated_field = "2F624D23D3BCA37A8CA767DF354E972D")

    public static final String EXPIRES = ParameterNames.EXPIRES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.215 -0400", hash_original_field = "C499215B945D2E6EF56503E60F1557DE", hash_generated_field = "FF045AAD7F2A2328EB43131E44B9ED97")

    public static final String Q = ParameterNames.Q;
}

