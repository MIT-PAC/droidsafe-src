package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Map.Entry;

public class NameValue extends GenericObject implements Entry<String,String> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.781 -0400", hash_original_field = "BAAFE7850E70D939EC1652577DB1CFB2", hash_generated_field = "03D21DED07B953DE189DA542ACCA4795")

    protected boolean isQuotedString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.781 -0400", hash_original_field = "378E6ECDF38ECF4A1FDB5B0F06543016", hash_generated_field = "2074D0C8EACF17C06B998CAD345872CC")

    protected boolean isFlagParameter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.781 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.781 -0400", hash_original_field = "2150FD65034A9BCDB357943B3900A918", hash_generated_field = "2D87AB9C19BCCC29C070C92F351ED60D")

    private String quotes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.782 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.782 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")

    private Object value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.782 -0400", hash_original_method = "673B7BD3BE99F15EF906052B0E031E5B", hash_generated_method = "22606C6D179EA13EE251F2CB102498B8")
    public  NameValue() {
        name = null;
        value = "";
        separator = Separators.EQUALS;
        this.quotes = "";
        this.isFlagParameter = false;
        // ---------- Original Method ----------
        //name = null;
        //value = "";
        //separator = Separators.EQUALS;
        //this.quotes = "";
        //this.isFlagParameter = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.782 -0400", hash_original_method = "02C18CFA06711D9F4F613D5380036A37", hash_generated_method = "909BFE9476639352818418B9719A67A7")
    public  NameValue(String n, Object v, boolean isFlag) {
        name = n;
        value = v;
        separator = Separators.EQUALS;
        quotes = "";
        this.isFlagParameter = isFlag;
        // ---------- Original Method ----------
        //name = n;
        //value = v;
        //separator = Separators.EQUALS;
        //quotes = "";
        //this.isFlagParameter = isFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.789 -0400", hash_original_method = "2B84565E65A85C087167BA7C90B69F9F", hash_generated_method = "5E04EB49AA9DB251D69EBAEC8BC166D4")
    public  NameValue(String n, Object v) {
        this(n, v, false);
        addTaint(n.getTaint());
        addTaint(v.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.790 -0400", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "BE8D7A91CF35C3CE4342E681E66ABB40")
    public void setSeparator(String sep) {
        separator = sep;
        // ---------- Original Method ----------
        //separator = sep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.792 -0400", hash_original_method = "095AA0DB24FB99A12A6684BCE39B9F89", hash_generated_method = "E00E549B3C808990AAB42C9F832CF539")
    public void setQuotedValue() {
        isQuotedString = true;
        this.quotes = Separators.DOUBLE_QUOTE;
        // ---------- Original Method ----------
        //isQuotedString = true;
        //this.quotes = Separators.DOUBLE_QUOTE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.792 -0400", hash_original_method = "D2172C6C42893F443ABBD625D7655BA2", hash_generated_method = "CF4F0D61D01A455AF072EAB12D41E96C")
    public boolean isValueQuoted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1927447215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1927447215;
        // ---------- Original Method ----------
        //return isQuotedString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.800 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "6D0B1AA356C11C9B199A4FDB1557EC5F")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1526572888 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1526572888 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1526572888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1526572888;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.801 -0400", hash_original_method = "1D746EB97F79FD095C35B4AB5FADFB51", hash_generated_method = "5A983EE6492707B55A75D411901D0E4E")
    public Object getValueAsObject() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1490204041 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1490204041 = isFlagParameter ? "" : value;
        varB4EAC82CA7396A68D541C85D26508E83_1490204041.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1490204041;
        // ---------- Original Method ----------
        //return isFlagParameter ? "" : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.806 -0400", hash_original_method = "48E6CC9DD98BCA4A1A1FF2D370B346E5", hash_generated_method = "EC3A808F65912EC4B397A06DEEEA4586")
    public void setName(String n) {
        name = n;
        // ---------- Original Method ----------
        //name = n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.806 -0400", hash_original_method = "976564EFAA66565638B090B0BED90464", hash_generated_method = "C63631628A71855211E03B08E189AF38")
    public void setValueAsObject(Object v) {
        value = v;
        // ---------- Original Method ----------
        //value = v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.807 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3D50192E909E42F92C59A7AD006679DC")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1318023046 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1318023046 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1318023046.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1318023046;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.810 -0400", hash_original_method = "8C352692671CA7B4091AFB32E24F1EAA", hash_generated_method = "D02336E1FDD4233367A30D013DBE9C36")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_300238702 = null; //Variable for return #1
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_118919713 = null; //Variable for return #2
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_161993054 = null; //Variable for return #3
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_2044997884 = null; //Variable for return #4
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_612034671 = null; //Variable for return #5
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1309263044 = null; //Variable for return #6
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1696975718 = null; //Variable for return #7
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_547689297 = null; //Variable for return #8
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1706916260 = null; //Variable for return #9
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1275381026 = null; //Variable for return #10
        {
            {
                boolean varC2ABC197C0C7733C94AAD5E3C992B5CF_596971292 = (GenericObject.isMySubclass(value.getClass()));
                {
                    GenericObject gv;
                    gv = (GenericObject) value;
                    buffer.append(name).append(separator).append(quotes);
                    gv.encode(buffer);
                    buffer.append(quotes);
                    varB4EAC82CA7396A68D541C85D26508E83_300238702 = buffer;
                } //End block
                {
                    boolean varCEFDF212BAC6C330014C218E51576BCC_1621627097 = (GenericObjectList.isMySubclass(value.getClass()));
                    {
                        GenericObjectList gvlist;
                        gvlist = (GenericObjectList) value;
                        buffer.append(name).append(separator).append(gvlist.encode());
                        varB4EAC82CA7396A68D541C85D26508E83_118919713 = buffer;
                    } //End block
                    {
                        boolean varC465A6F66CC83A3EC6A7E6E849292D8A_1639947868 = (value.toString().length() == 0);
                        {
                            {
                                buffer.append(name).append(separator).append(quotes).append(quotes);
                                varB4EAC82CA7396A68D541C85D26508E83_161993054 = buffer;
                            } //End block
                            {
                                buffer.append(name).append(separator);
                                varB4EAC82CA7396A68D541C85D26508E83_2044997884 = buffer;
                            } //End block
                        } //End block
                        {
                            buffer.append(name).append(separator).append(quotes).append(value.toString()).append(quotes);
                            varB4EAC82CA7396A68D541C85D26508E83_612034671 = buffer;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varC2ABC197C0C7733C94AAD5E3C992B5CF_1347596648 = (GenericObject.isMySubclass(value.getClass()));
                {
                    GenericObject gv;
                    gv = (GenericObject) value;
                    gv.encode(buffer);
                    varB4EAC82CA7396A68D541C85D26508E83_1309263044 = buffer;
                } //End block
                {
                    boolean varCEFDF212BAC6C330014C218E51576BCC_1904194689 = (GenericObjectList.isMySubclass(value.getClass()));
                    {
                        GenericObjectList gvlist;
                        gvlist = (GenericObjectList) value;
                        buffer.append(gvlist.encode());
                        varB4EAC82CA7396A68D541C85D26508E83_1696975718 = buffer;
                    } //End block
                    {
                        buffer.append(quotes).append(value.toString()).append(quotes);
                        varB4EAC82CA7396A68D541C85D26508E83_547689297 = buffer;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            buffer.append(name);
            varB4EAC82CA7396A68D541C85D26508E83_1706916260 = buffer;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1275381026 = buffer;
        } //End block
        addTaint(buffer.getTaint());
        StringBuffer varA7E53CE21691AB073D9660D615818899_1235102114; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1235102114 = varB4EAC82CA7396A68D541C85D26508E83_300238702;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1235102114 = varB4EAC82CA7396A68D541C85D26508E83_118919713;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1235102114 = varB4EAC82CA7396A68D541C85D26508E83_161993054;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1235102114 = varB4EAC82CA7396A68D541C85D26508E83_2044997884;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1235102114 = varB4EAC82CA7396A68D541C85D26508E83_612034671;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1235102114 = varB4EAC82CA7396A68D541C85D26508E83_1309263044;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1235102114 = varB4EAC82CA7396A68D541C85D26508E83_1696975718;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1235102114 = varB4EAC82CA7396A68D541C85D26508E83_547689297;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1235102114 = varB4EAC82CA7396A68D541C85D26508E83_1706916260;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1235102114 = varB4EAC82CA7396A68D541C85D26508E83_1275381026;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1235102114.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1235102114;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.823 -0400", hash_original_method = "AFA5C2A13F94EAF8D89E1398D2146232", hash_generated_method = "3BA128DAA06D2DA425812E24C4CEAE46")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_228694111 = null; //Variable for return #1
        NameValue retval;
        retval = (NameValue) super.clone();
        retval.value = makeClone(value);
        varB4EAC82CA7396A68D541C85D26508E83_228694111 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_228694111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_228694111;
        // ---------- Original Method ----------
        //NameValue retval = (NameValue) super.clone();
        //if (value != null)
            //retval.value = makeClone(value);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.827 -0400", hash_original_method = "C7D1B39DFE3B0192F0BEF83FC7C40106", hash_generated_method = "494C6FA6E8608FCA7007CB1694931A08")
    public boolean equals(Object other) {
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_1441324886 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        NameValue that;
        that = (NameValue) other;
        {
            boolean var692132EB30A37C894BF5193829D9DA63_386368067 = (this.name != null && that.name != null
                && this.name.compareToIgnoreCase(that.name) != 0);
        } //End collapsed parenthetic
        {
            boolean var935CB035CB1512694C8E94A5D5826A4D_1655499632 = (this.value.equals(that.value));
            String val;
            val = (String) this.value;
            String val1;
            val1 = (String) that.value;
            boolean var694EC846995B9082EDD0C6681276EDF3_1067976357 = (val.compareToIgnoreCase(val1) == 0);
        } //End block
        boolean var303D4B38E18B72FB9D40494DA11A631C_451830507 = (this.value.equals(that.value));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2012341243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2012341243;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.831 -0400", hash_original_method = "2F0EB2DB361DE1F8D28986094D857BA0", hash_generated_method = "1F9F283992FF70ACF02D41A04FB3215C")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_530381065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_530381065 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_530381065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_530381065;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.832 -0400", hash_original_method = "4618674F7CF871F15A32C0791ACD2466", hash_generated_method = "D60317855C2BBC178C35D3D444372922")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1334858918 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1334858918 = value == null ? null : this.value.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1334858918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1334858918;
        // ---------- Original Method ----------
        //return  value == null ? null : this.value.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.832 -0400", hash_original_method = "34CFBA77959CE5FB40B94FB25C9241AB", hash_generated_method = "9ECAE46CBD8AE4B5EBB46147199CA146")
    public String setValue(String value) {
        String varB4EAC82CA7396A68D541C85D26508E83_573884890 = null; //Variable for return #1
        String retval;
        retval = null;
        retval = value;
        this.value = value;
        varB4EAC82CA7396A68D541C85D26508E83_573884890 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_573884890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_573884890;
        // ---------- Original Method ----------
        //String retval = this.value == null ? null : value;
        //this.value = value;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.839 -0400", hash_original_method = "65B8B320E0D14FEF2FD57F3B89A2B17F", hash_generated_method = "BDF73053EB39C19B4B89AAF4C091632A")
    @Override
    public int hashCode() {
        int varE7FF42DC0134C7520F1E52867D63D800_1841802521 = (this.encode().toLowerCase().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1236540765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1236540765;
        // ---------- Original Method ----------
        //return this.encode().toLowerCase().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.840 -0400", hash_original_field = "B4F1F4CEA79E2E813F8321547B3C6829", hash_generated_field = "A8000F7FB9A222BFCC5F3BFA17E16C95")

    private static long serialVersionUID = -1857729012596437950L;
}

