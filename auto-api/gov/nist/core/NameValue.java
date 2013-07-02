package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Map.Entry;

public class NameValue extends GenericObject implements Entry<String,String> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.747 -0400", hash_original_field = "BAAFE7850E70D939EC1652577DB1CFB2", hash_generated_field = "03D21DED07B953DE189DA542ACCA4795")

    protected boolean isQuotedString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.747 -0400", hash_original_field = "378E6ECDF38ECF4A1FDB5B0F06543016", hash_generated_field = "2074D0C8EACF17C06B998CAD345872CC")

    protected boolean isFlagParameter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.747 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.747 -0400", hash_original_field = "2150FD65034A9BCDB357943B3900A918", hash_generated_field = "2D87AB9C19BCCC29C070C92F351ED60D")

    private String quotes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.747 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.747 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")

    private Object value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.747 -0400", hash_original_method = "673B7BD3BE99F15EF906052B0E031E5B", hash_generated_method = "22606C6D179EA13EE251F2CB102498B8")
    public  NameValue() {
        name = null;
        value = "";
        separator = Separators.EQUALS;
        this.quotes = "";
        this.isFlagParameter = false;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.747 -0400", hash_original_method = "02C18CFA06711D9F4F613D5380036A37", hash_generated_method = "909BFE9476639352818418B9719A67A7")
    public  NameValue(String n, Object v, boolean isFlag) {
        name = n;
        value = v;
        separator = Separators.EQUALS;
        quotes = "";
        this.isFlagParameter = isFlag;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.748 -0400", hash_original_method = "2B84565E65A85C087167BA7C90B69F9F", hash_generated_method = "5E04EB49AA9DB251D69EBAEC8BC166D4")
    public  NameValue(String n, Object v) {
        this(n, v, false);
        addTaint(n.getTaint());
        addTaint(v.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.748 -0400", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "BE8D7A91CF35C3CE4342E681E66ABB40")
    public void setSeparator(String sep) {
        separator = sep;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.748 -0400", hash_original_method = "095AA0DB24FB99A12A6684BCE39B9F89", hash_generated_method = "E00E549B3C808990AAB42C9F832CF539")
    public void setQuotedValue() {
        isQuotedString = true;
        this.quotes = Separators.DOUBLE_QUOTE;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.748 -0400", hash_original_method = "D2172C6C42893F443ABBD625D7655BA2", hash_generated_method = "9EFBB36EAE9300F3916CB56D8FA74C85")
    public boolean isValueQuoted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89517211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_89517211;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.750 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "A1CE8F2FB60E9F84AE15F6A51142DD61")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1130876933 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1130876933 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1130876933.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1130876933;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.751 -0400", hash_original_method = "1D746EB97F79FD095C35B4AB5FADFB51", hash_generated_method = "5D9F97B15F39FF77C0BBB15CBF582DFA")
    public Object getValueAsObject() {
        Object varB4EAC82CA7396A68D541C85D26508E83_407361101 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_407361101 = isFlagParameter ? "" : value;
        varB4EAC82CA7396A68D541C85D26508E83_407361101.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_407361101;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.752 -0400", hash_original_method = "48E6CC9DD98BCA4A1A1FF2D370B346E5", hash_generated_method = "EC3A808F65912EC4B397A06DEEEA4586")
    public void setName(String n) {
        name = n;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.752 -0400", hash_original_method = "976564EFAA66565638B090B0BED90464", hash_generated_method = "C63631628A71855211E03B08E189AF38")
    public void setValueAsObject(Object v) {
        value = v;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.752 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "BCFB05D3BDB85ADD47D48BFCA1E9205B")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_505385076 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_505385076 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_505385076.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_505385076;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.754 -0400", hash_original_method = "8C352692671CA7B4091AFB32E24F1EAA", hash_generated_method = "2CCC98518B3CC91C1FB937F4F4769EFC")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_704205402 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1414548356 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1623410446 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1291164334 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_506939667 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_553669687 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_462917497 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_644888247 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_871063510 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1739666903 = null; 
        {
            {
                boolean varC2ABC197C0C7733C94AAD5E3C992B5CF_143312645 = (GenericObject.isMySubclass(value.getClass()));
                {
                    GenericObject gv = (GenericObject) value;
                    buffer.append(name).append(separator).append(quotes);
                    gv.encode(buffer);
                    buffer.append(quotes);
                    varB4EAC82CA7396A68D541C85D26508E83_704205402 = buffer;
                } 
                {
                    boolean varCEFDF212BAC6C330014C218E51576BCC_1291497029 = (GenericObjectList.isMySubclass(value.getClass()));
                    {
                        GenericObjectList gvlist = (GenericObjectList) value;
                        buffer.append(name).append(separator).append(gvlist.encode());
                        varB4EAC82CA7396A68D541C85D26508E83_1414548356 = buffer;
                    } 
                    {
                        boolean varC465A6F66CC83A3EC6A7E6E849292D8A_801458198 = (value.toString().length() == 0);
                        {
                            {
                                buffer.append(name).append(separator).append(quotes).append(quotes);
                                varB4EAC82CA7396A68D541C85D26508E83_1623410446 = buffer;
                            } 
                            {
                                buffer.append(name).append(separator);
                                varB4EAC82CA7396A68D541C85D26508E83_1291164334 = buffer;
                            } 
                        } 
                        {
                            buffer.append(name).append(separator).append(quotes).append(value.toString()).append(quotes);
                            varB4EAC82CA7396A68D541C85D26508E83_506939667 = buffer;
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                boolean varC2ABC197C0C7733C94AAD5E3C992B5CF_1421170101 = (GenericObject.isMySubclass(value.getClass()));
                {
                    GenericObject gv = (GenericObject) value;
                    gv.encode(buffer);
                    varB4EAC82CA7396A68D541C85D26508E83_553669687 = buffer;
                } 
                {
                    boolean varCEFDF212BAC6C330014C218E51576BCC_1473704997 = (GenericObjectList.isMySubclass(value.getClass()));
                    {
                        GenericObjectList gvlist = (GenericObjectList) value;
                        buffer.append(gvlist.encode());
                        varB4EAC82CA7396A68D541C85D26508E83_462917497 = buffer;
                    } 
                    {
                        buffer.append(quotes).append(value.toString()).append(quotes);
                        varB4EAC82CA7396A68D541C85D26508E83_644888247 = buffer;
                    } 
                } 
            } 
        } 
        {
            buffer.append(name);
            varB4EAC82CA7396A68D541C85D26508E83_871063510 = buffer;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1739666903 = buffer;
        } 
        addTaint(buffer.getTaint());
        StringBuffer varA7E53CE21691AB073D9660D615818899_463437589; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_463437589 = varB4EAC82CA7396A68D541C85D26508E83_704205402;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_463437589 = varB4EAC82CA7396A68D541C85D26508E83_1414548356;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_463437589 = varB4EAC82CA7396A68D541C85D26508E83_1623410446;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_463437589 = varB4EAC82CA7396A68D541C85D26508E83_1291164334;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_463437589 = varB4EAC82CA7396A68D541C85D26508E83_506939667;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_463437589 = varB4EAC82CA7396A68D541C85D26508E83_553669687;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_463437589 = varB4EAC82CA7396A68D541C85D26508E83_462917497;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_463437589 = varB4EAC82CA7396A68D541C85D26508E83_644888247;
                break;
            case 9: 
                varA7E53CE21691AB073D9660D615818899_463437589 = varB4EAC82CA7396A68D541C85D26508E83_871063510;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_463437589 = varB4EAC82CA7396A68D541C85D26508E83_1739666903;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_463437589.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_463437589;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.755 -0400", hash_original_method = "AFA5C2A13F94EAF8D89E1398D2146232", hash_generated_method = "BEAFEF11349E4BFC9EC9975D75DD8A99")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1527461087 = null; 
        NameValue retval = (NameValue) super.clone();
        retval.value = makeClone(value);
        varB4EAC82CA7396A68D541C85D26508E83_1527461087 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1527461087.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1527461087;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.756 -0400", hash_original_method = "C7D1B39DFE3B0192F0BEF83FC7C40106", hash_generated_method = "4F5EED75D0B91B4B89BE818907A0E651")
    public boolean equals(Object other) {
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_898358579 = (!other.getClass().equals(this.getClass()));
        } 
        NameValue that = (NameValue) other;
        {
            boolean var692132EB30A37C894BF5193829D9DA63_533084208 = (this.name != null && that.name != null
                && this.name.compareToIgnoreCase(that.name) != 0);
        } 
        {
            boolean var935CB035CB1512694C8E94A5D5826A4D_1827051544 = (this.value.equals(that.value));
            String val = (String) this.value;
            String val1 = (String) that.value;
            boolean var694EC846995B9082EDD0C6681276EDF3_537252947 = (val.compareToIgnoreCase(val1) == 0);
        } 
        boolean var303D4B38E18B72FB9D40494DA11A631C_1402516887 = (this.value.equals(that.value));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2147352968 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2147352968;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.756 -0400", hash_original_method = "2F0EB2DB361DE1F8D28986094D857BA0", hash_generated_method = "062BD4C5AB79A01D6BBF9F4FBC8FB18E")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_990254074 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_990254074 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_990254074.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_990254074;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.756 -0400", hash_original_method = "4618674F7CF871F15A32C0791ACD2466", hash_generated_method = "DC3CBA04F1BDDAC80CAB9095EBD58E30")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1487104947 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1487104947 = value == null ? null : this.value.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1487104947.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1487104947;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.757 -0400", hash_original_method = "34CFBA77959CE5FB40B94FB25C9241AB", hash_generated_method = "804FDD958FCF3D185BBA180BAD80564D")
    public String setValue(String value) {
        String varB4EAC82CA7396A68D541C85D26508E83_719542919 = null; 
        String retval;
        retval = null;
        retval = value;
        this.value = value;
        varB4EAC82CA7396A68D541C85D26508E83_719542919 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_719542919.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_719542919;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.757 -0400", hash_original_method = "65B8B320E0D14FEF2FD57F3B89A2B17F", hash_generated_method = "373018DF53C5487DBA80D172278356AE")
    @Override
    public int hashCode() {
        int varE7FF42DC0134C7520F1E52867D63D800_706029377 = (this.encode().toLowerCase().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952091174 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952091174;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.757 -0400", hash_original_field = "B4F1F4CEA79E2E813F8321547B3C6829", hash_generated_field = "01B78AA1575EDF3A89DB226DD6F71B77")

    private static final long serialVersionUID = -1857729012596437950L;
}

