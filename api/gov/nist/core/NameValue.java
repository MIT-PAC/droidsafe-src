package gov.nist.core;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Map.Entry;






public class NameValue extends GenericObject implements Entry<String,String> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.603 -0400", hash_original_field = "BAAFE7850E70D939EC1652577DB1CFB2", hash_generated_field = "03D21DED07B953DE189DA542ACCA4795")

    protected boolean isQuotedString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.603 -0400", hash_original_field = "378E6ECDF38ECF4A1FDB5B0F06543016", hash_generated_field = "2074D0C8EACF17C06B998CAD345872CC")

    protected boolean isFlagParameter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.603 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.603 -0400", hash_original_field = "2150FD65034A9BCDB357943B3900A918", hash_generated_field = "2D87AB9C19BCCC29C070C92F351ED60D")

    private String quotes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.603 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.603 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")

    private Object value;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.604 -0400", hash_original_method = "673B7BD3BE99F15EF906052B0E031E5B", hash_generated_method = "22606C6D179EA13EE251F2CB102498B8")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.605 -0400", hash_original_method = "02C18CFA06711D9F4F613D5380036A37", hash_generated_method = "909BFE9476639352818418B9719A67A7")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.606 -0400", hash_original_method = "2B84565E65A85C087167BA7C90B69F9F", hash_generated_method = "FD4F72848B1B5443110848234E64A90B")
    public  NameValue(String n, Object v) {
        this(n, v, false);
        addTaint(v.getTaint());
        addTaint(n.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.606 -0400", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "BE8D7A91CF35C3CE4342E681E66ABB40")
    public void setSeparator(String sep) {
        separator = sep;
        // ---------- Original Method ----------
        //separator = sep;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.607 -0400", hash_original_method = "095AA0DB24FB99A12A6684BCE39B9F89", hash_generated_method = "E00E549B3C808990AAB42C9F832CF539")
    public void setQuotedValue() {
        isQuotedString = true;
        this.quotes = Separators.DOUBLE_QUOTE;
        // ---------- Original Method ----------
        //isQuotedString = true;
        //this.quotes = Separators.DOUBLE_QUOTE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.609 -0400", hash_original_method = "D2172C6C42893F443ABBD625D7655BA2", hash_generated_method = "90FB33575EE01FF5F20036A802E5E338")
    public boolean isValueQuoted() {
        boolean varBAAFE7850E70D939EC1652577DB1CFB2_1981508882 = (isQuotedString);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291162857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291162857;
        // ---------- Original Method ----------
        //return isQuotedString;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.609 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3F05F50F2E30AAD1768C83085089BA5C")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_996076563 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_996076563.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_996076563;
        // ---------- Original Method ----------
        //return name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.610 -0400", hash_original_method = "1D746EB97F79FD095C35B4AB5FADFB51", hash_generated_method = "3B7CB51CE88472C03D313C8E309FFA74")
    public Object getValueAsObject() {
Object var51674C9B3053ECEEFFA7BB6C9E2F189C_554351654 =         isFlagParameter ? "" : value;
        var51674C9B3053ECEEFFA7BB6C9E2F189C_554351654.addTaint(taint);
        return var51674C9B3053ECEEFFA7BB6C9E2F189C_554351654;
        // ---------- Original Method ----------
        //return isFlagParameter ? "" : value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.611 -0400", hash_original_method = "48E6CC9DD98BCA4A1A1FF2D370B346E5", hash_generated_method = "EC3A808F65912EC4B397A06DEEEA4586")
    public void setName(String n) {
        name = n;
        // ---------- Original Method ----------
        //name = n;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.612 -0400", hash_original_method = "976564EFAA66565638B090B0BED90464", hash_generated_method = "C63631628A71855211E03B08E189AF38")
    public void setValueAsObject(Object v) {
        value = v;
        // ---------- Original Method ----------
        //value = v;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.612 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "2C52D7024420C2FBE514DF59E2D21D2B")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_2114848630 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_2114848630.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_2114848630;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.613 -0400", hash_original_method = "8C352692671CA7B4091AFB32E24F1EAA", hash_generated_method = "A2326B0C3CDD6B968B7671E4F04EC996")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(name != null && value != null && !isFlagParameter)        
        {
            if(GenericObject.isMySubclass(value.getClass()))            
            {
                GenericObject gv = (GenericObject) value;
                buffer.append(name).append(separator).append(quotes);
                gv.encode(buffer);
                buffer.append(quotes);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_2005521459 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_2005521459.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_2005521459;
            } //End block
            else
            if(GenericObjectList.isMySubclass(value.getClass()))            
            {
                GenericObjectList gvlist = (GenericObjectList) value;
                buffer.append(name).append(separator).append(gvlist.encode());
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1369358326 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_1369358326.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1369358326;
            } //End block
            else
            if(value.toString().length() == 0)            
            {
                if(this.isQuotedString)                
                {
                    buffer.append(name).append(separator).append(quotes).append(quotes);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1180387222 =                     buffer;
                    varE75BCB56CC6A0BCEED51BE38E1BB3F38_1180387222.addTaint(taint);
                    return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1180387222;
                } //End block
                else
                {
                    buffer.append(name).append(separator);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_290313085 =                     buffer;
                    varE75BCB56CC6A0BCEED51BE38E1BB3F38_290313085.addTaint(taint);
                    return varE75BCB56CC6A0BCEED51BE38E1BB3F38_290313085;
                } //End block
            } //End block
            else
            {
                buffer.append(name).append(separator).append(quotes).append(value.toString()).append(quotes);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_2054742809 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_2054742809.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_2054742809;
            } //End block
        } //End block
        else
        if(name == null && value != null)        
        {
            if(GenericObject.isMySubclass(value.getClass()))            
            {
                GenericObject gv = (GenericObject) value;
                gv.encode(buffer);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1708877234 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_1708877234.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1708877234;
            } //End block
            else
            if(GenericObjectList.isMySubclass(value.getClass()))            
            {
                GenericObjectList gvlist = (GenericObjectList) value;
                buffer.append(gvlist.encode());
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_684175319 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_684175319.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_684175319;
            } //End block
            else
            {
                buffer.append(quotes).append(value.toString()).append(quotes);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1709820525 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_1709820525.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1709820525;
            } //End block
        } //End block
        else
        if(name != null && (value == null || isFlagParameter))        
        {
            buffer.append(name);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1925095812 =             buffer;
            varE75BCB56CC6A0BCEED51BE38E1BB3F38_1925095812.addTaint(taint);
            return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1925095812;
        } //End block
        else
        {
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_332116082 =             buffer;
            varE75BCB56CC6A0BCEED51BE38E1BB3F38_332116082.addTaint(taint);
            return varE75BCB56CC6A0BCEED51BE38E1BB3F38_332116082;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.615 -0400", hash_original_method = "AFA5C2A13F94EAF8D89E1398D2146232", hash_generated_method = "0B433219B389DB007EC5309032E175C3")
    public Object clone() {
        NameValue retval = (NameValue) super.clone();
        if(value != null)        
        retval.value = makeClone(value);
Object varF9E19AD6135C970F387F77C6F3DE4477_1487211851 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1487211851.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1487211851;
        // ---------- Original Method ----------
        //NameValue retval = (NameValue) super.clone();
        //if (value != null)
            //retval.value = makeClone(value);
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.616 -0400", hash_original_method = "C7D1B39DFE3B0192F0BEF83FC7C40106", hash_generated_method = "2E18F8830CEB8D089A43E1923D186446")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_498644011 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873731147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_873731147;
        }
        if(!other.getClass().equals(this.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1272464585 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453194019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_453194019;
        }
        NameValue that = (NameValue) other;
        if(this == that)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1330430648 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213623821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213623821;
        }
        if(this.name == null && that.name != null || this.name != null
                && that.name == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1863830701 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222849200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222849200;
        }
        if(this.name != null && that.name != null
                && this.name.compareToIgnoreCase(that.name) != 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1491889242 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942971148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_942971148;
        }
        if(this.value != null && that.value == null || this.value == null
                && that.value != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_582614360 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295180198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_295180198;
        }
        if(this.value == that.value)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1849591563 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499365083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499365083;
        }
        if(value instanceof String)        
        {
            if(isQuotedString)            
            {
            boolean var002C2EFAECBC0CE1ABC19CDEC790A2C1_2062802059 = (this.value.equals(that.value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667116835 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_667116835;
            }
            String val = (String) this.value;
            String val1 = (String) that.value;
            boolean var2094A36EE46BE55A950292ADEF1A828C_955946994 = (val.compareToIgnoreCase(val1) == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2049337930 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2049337930;
        } //End block
        else
        {
        boolean var002C2EFAECBC0CE1ABC19CDEC790A2C1_13312142 = (this.value.equals(that.value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1419595260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1419595260;
        }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.617 -0400", hash_original_method = "2F0EB2DB361DE1F8D28986094D857BA0", hash_generated_method = "63326D0E1AC0150EB1073C2EA11A4CBA")
    public String getKey() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_1217302175 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_1217302175.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_1217302175;
        // ---------- Original Method ----------
        //return this.name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.617 -0400", hash_original_method = "4618674F7CF871F15A32C0791ACD2466", hash_generated_method = "87919455D5B24D8D750C411D69316989")
    public String getValue() {
String var92A1FFC6B177D883E210D7CDB9C12881_94932053 =         value == null ? null : this.value.toString();
        var92A1FFC6B177D883E210D7CDB9C12881_94932053.addTaint(taint);
        return var92A1FFC6B177D883E210D7CDB9C12881_94932053;
        // ---------- Original Method ----------
        //return  value == null ? null : this.value.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.617 -0400", hash_original_method = "34CFBA77959CE5FB40B94FB25C9241AB", hash_generated_method = "107602E6DB088493C5DA155058794E44")
    public String setValue(String value) {
        String retval = this.value == null ? null : value;
        this.value = value;
String varF9E19AD6135C970F387F77C6F3DE4477_417590495 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_417590495.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_417590495;
        // ---------- Original Method ----------
        //String retval = this.value == null ? null : value;
        //this.value = value;
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.618 -0400", hash_original_method = "65B8B320E0D14FEF2FD57F3B89A2B17F", hash_generated_method = "4A404B358ED4DEAEB2095DAD7D6C55E2")
    @Override
    public int hashCode() {
        int varC1842B56F11397EBFCEB22DFBE803B55_1782128771 = (this.encode().toLowerCase().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1600348984 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1600348984;
        // ---------- Original Method ----------
        //return this.encode().toLowerCase().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.618 -0400", hash_original_field = "B4F1F4CEA79E2E813F8321547B3C6829", hash_generated_field = "01B78AA1575EDF3A89DB226DD6F71B77")

    private static final long serialVersionUID = -1857729012596437950L;
}

