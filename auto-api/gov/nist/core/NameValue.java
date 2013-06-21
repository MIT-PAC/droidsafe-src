package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Map.Entry;

public class NameValue extends GenericObject implements Entry<String,String> {
    protected boolean isQuotedString;
    protected boolean isFlagParameter;
    private String separator;
    private String quotes;
    private String name;
    private Object value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.718 -0400", hash_original_method = "673B7BD3BE99F15EF906052B0E031E5B", hash_generated_method = "22606C6D179EA13EE251F2CB102498B8")
    @DSModeled(DSC.SAFE)
    public NameValue() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.719 -0400", hash_original_method = "02C18CFA06711D9F4F613D5380036A37", hash_generated_method = "B4E722D84C445F524A8207E887CB53A9")
    @DSModeled(DSC.SAFE)
    public NameValue(String n, Object v, boolean isFlag) {
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(isFlag);
        dsTaint.addTaint(n);
        separator = Separators.EQUALS;
        quotes = "";
        // ---------- Original Method ----------
        //name = n;
        //value = v;
        //separator = Separators.EQUALS;
        //quotes = "";
        //this.isFlagParameter = isFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.723 -0400", hash_original_method = "2B84565E65A85C087167BA7C90B69F9F", hash_generated_method = "8D40E0BD59D4E63846F728403F099526")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValue(String n, Object v) {
        this(n, v, false);
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(n);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.723 -0400", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "D862496356B3061AD2F8154E98D5F9E9")
    @DSModeled(DSC.SAFE)
    public void setSeparator(String sep) {
        dsTaint.addTaint(sep);
        // ---------- Original Method ----------
        //separator = sep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.724 -0400", hash_original_method = "095AA0DB24FB99A12A6684BCE39B9F89", hash_generated_method = "E00E549B3C808990AAB42C9F832CF539")
    @DSModeled(DSC.SAFE)
    public void setQuotedValue() {
        isQuotedString = true;
        this.quotes = Separators.DOUBLE_QUOTE;
        // ---------- Original Method ----------
        //isQuotedString = true;
        //this.quotes = Separators.DOUBLE_QUOTE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.724 -0400", hash_original_method = "D2172C6C42893F443ABBD625D7655BA2", hash_generated_method = "E8592D9C1C92887FA4651EE5D882FDE5")
    @DSModeled(DSC.SAFE)
    public boolean isValueQuoted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isQuotedString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.724 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.724 -0400", hash_original_method = "1D746EB97F79FD095C35B4AB5FADFB51", hash_generated_method = "7FA1E9B71A4E63C67CA54DC011F10254")
    @DSModeled(DSC.SAFE)
    public Object getValueAsObject() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return isFlagParameter ? "" : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.725 -0400", hash_original_method = "48E6CC9DD98BCA4A1A1FF2D370B346E5", hash_generated_method = "BD990C58067FB0EDB9529E99B92F69A0")
    @DSModeled(DSC.SAFE)
    public void setName(String n) {
        dsTaint.addTaint(n);
        // ---------- Original Method ----------
        //name = n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.725 -0400", hash_original_method = "976564EFAA66565638B090B0BED90464", hash_generated_method = "0009741DC03E45627E7209F6E0585A91")
    @DSModeled(DSC.SAFE)
    public void setValueAsObject(Object v) {
        dsTaint.addTaint(v.dsTaint);
        // ---------- Original Method ----------
        //value = v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.725 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "F730789D6045B172161EF49238F37070")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_257932013 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.726 -0400", hash_original_method = "8C352692671CA7B4091AFB32E24F1EAA", hash_generated_method = "0ACF92F5124BE76120A1820E9A2EE9CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            {
                boolean varC2ABC197C0C7733C94AAD5E3C992B5CF_1423211953 = (GenericObject.isMySubclass(value.getClass()));
                {
                    GenericObject gv;
                    gv = (GenericObject) value;
                    buffer.append(name).append(separator).append(quotes);
                    gv.encode(buffer);
                    buffer.append(quotes);
                } //End block
                {
                    boolean varCEFDF212BAC6C330014C218E51576BCC_2029797771 = (GenericObjectList.isMySubclass(value.getClass()));
                    {
                        GenericObjectList gvlist;
                        gvlist = (GenericObjectList) value;
                        buffer.append(name).append(separator).append(gvlist.encode());
                    } //End block
                    {
                        boolean varC465A6F66CC83A3EC6A7E6E849292D8A_594087522 = (value.toString().length() == 0);
                        {
                            {
                                buffer.append(name).append(separator).append(quotes).append(quotes);
                            } //End block
                            {
                                buffer.append(name).append(separator);
                            } //End block
                        } //End block
                        {
                            buffer.append(name).append(separator).append(quotes).append(value.toString()).append(quotes);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varC2ABC197C0C7733C94AAD5E3C992B5CF_805926809 = (GenericObject.isMySubclass(value.getClass()));
                {
                    GenericObject gv;
                    gv = (GenericObject) value;
                    gv.encode(buffer);
                } //End block
                {
                    boolean varCEFDF212BAC6C330014C218E51576BCC_315625663 = (GenericObjectList.isMySubclass(value.getClass()));
                    {
                        GenericObjectList gvlist;
                        gvlist = (GenericObjectList) value;
                        buffer.append(gvlist.encode());
                    } //End block
                    {
                        buffer.append(quotes).append(value.toString()).append(quotes);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            buffer.append(name);
        } //End block
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.726 -0400", hash_original_method = "AFA5C2A13F94EAF8D89E1398D2146232", hash_generated_method = "8FFED978F8D25E5EAC968BFB622DD614")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        NameValue retval;
        retval = (NameValue) super.clone();
        retval.value = makeClone(value);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //NameValue retval = (NameValue) super.clone();
        //if (value != null)
            //retval.value = makeClone(value);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.727 -0400", hash_original_method = "C7D1B39DFE3B0192F0BEF83FC7C40106", hash_generated_method = "AF9F84D77EE4310064289F8E70A529E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_723304126 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        NameValue that;
        that = (NameValue) other;
        {
            boolean var692132EB30A37C894BF5193829D9DA63_1731392101 = (this.name != null && that.name != null
                && this.name.compareToIgnoreCase(that.name) != 0);
        } //End collapsed parenthetic
        {
            boolean var935CB035CB1512694C8E94A5D5826A4D_1320552746 = (this.value.equals(that.value));
            String val;
            val = (String) this.value;
            String val1;
            val1 = (String) that.value;
            boolean var694EC846995B9082EDD0C6681276EDF3_1548870020 = (val.compareToIgnoreCase(val1) == 0);
        } //End block
        boolean var303D4B38E18B72FB9D40494DA11A631C_1251184854 = (this.value.equals(that.value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.727 -0400", hash_original_method = "2F0EB2DB361DE1F8D28986094D857BA0", hash_generated_method = "964734C41577DC4F0156F523F6B4CEBB")
    @DSModeled(DSC.SAFE)
    public String getKey() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.728 -0400", hash_original_method = "4618674F7CF871F15A32C0791ACD2466", hash_generated_method = "D2B3B558FD8EE8763B5060D2041FFD6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue() {
        {
            Object var15804D720211FA17BEB463CBD534110F_1508631915 = (this.value.toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return  value == null ? null : this.value.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.728 -0400", hash_original_method = "34CFBA77959CE5FB40B94FB25C9241AB", hash_generated_method = "FD685153F3DFB71D0C8F50B7A110419F")
    @DSModeled(DSC.SAFE)
    public String setValue(String value) {
        dsTaint.addTaint(value);
        String retval;
        retval = null;
        retval = value;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String retval = this.value == null ? null : value;
        //this.value = value;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.728 -0400", hash_original_method = "65B8B320E0D14FEF2FD57F3B89A2B17F", hash_generated_method = "AD6373FE207FF843A13D26DD38F5767A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE7FF42DC0134C7520F1E52867D63D800_706978468 = (this.encode().toLowerCase().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.encode().toLowerCase().hashCode();
    }

    
    private static final long serialVersionUID = -1857729012596437950L;
}

