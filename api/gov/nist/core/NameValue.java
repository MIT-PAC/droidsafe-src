package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Map.Entry;

public class NameValue extends GenericObject implements Entry<String,String> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.652 -0400", hash_original_field = "BAAFE7850E70D939EC1652577DB1CFB2", hash_generated_field = "03D21DED07B953DE189DA542ACCA4795")

    protected boolean isQuotedString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.653 -0400", hash_original_field = "378E6ECDF38ECF4A1FDB5B0F06543016", hash_generated_field = "2074D0C8EACF17C06B998CAD345872CC")

    protected boolean isFlagParameter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.653 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.653 -0400", hash_original_field = "2150FD65034A9BCDB357943B3900A918", hash_generated_field = "2D87AB9C19BCCC29C070C92F351ED60D")

    private String quotes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.653 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.653 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")

    private Object value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.654 -0400", hash_original_method = "673B7BD3BE99F15EF906052B0E031E5B", hash_generated_method = "22606C6D179EA13EE251F2CB102498B8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.654 -0400", hash_original_method = "02C18CFA06711D9F4F613D5380036A37", hash_generated_method = "909BFE9476639352818418B9719A67A7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.655 -0400", hash_original_method = "2B84565E65A85C087167BA7C90B69F9F", hash_generated_method = "FD4F72848B1B5443110848234E64A90B")
    public  NameValue(String n, Object v) {
        this(n, v, false);
        addTaint(v.getTaint());
        addTaint(n.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.655 -0400", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "BE8D7A91CF35C3CE4342E681E66ABB40")
    public void setSeparator(String sep) {
        separator = sep;
        // ---------- Original Method ----------
        //separator = sep;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.656 -0400", hash_original_method = "095AA0DB24FB99A12A6684BCE39B9F89", hash_generated_method = "E00E549B3C808990AAB42C9F832CF539")
    public void setQuotedValue() {
        isQuotedString = true;
        this.quotes = Separators.DOUBLE_QUOTE;
        // ---------- Original Method ----------
        //isQuotedString = true;
        //this.quotes = Separators.DOUBLE_QUOTE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.656 -0400", hash_original_method = "D2172C6C42893F443ABBD625D7655BA2", hash_generated_method = "4E3651EAFF6120090FB98224BC209B4B")
    public boolean isValueQuoted() {
        boolean varBAAFE7850E70D939EC1652577DB1CFB2_1917127853 = (isQuotedString);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1287703297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1287703297;
        // ---------- Original Method ----------
        //return isQuotedString;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.657 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "DCD6AD436F7A53444A91AEA9EA92CCFE")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1824617405 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1824617405.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1824617405;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.657 -0400", hash_original_method = "1D746EB97F79FD095C35B4AB5FADFB51", hash_generated_method = "B2B0679A105FC35A81BBABC5AAE6D1D6")
    public Object getValueAsObject() {
Object var51674C9B3053ECEEFFA7BB6C9E2F189C_1469457564 =         isFlagParameter ? "" : value;
        var51674C9B3053ECEEFFA7BB6C9E2F189C_1469457564.addTaint(taint);
        return var51674C9B3053ECEEFFA7BB6C9E2F189C_1469457564;
        // ---------- Original Method ----------
        //return isFlagParameter ? "" : value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.658 -0400", hash_original_method = "48E6CC9DD98BCA4A1A1FF2D370B346E5", hash_generated_method = "EC3A808F65912EC4B397A06DEEEA4586")
    public void setName(String n) {
        name = n;
        // ---------- Original Method ----------
        //name = n;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.659 -0400", hash_original_method = "976564EFAA66565638B090B0BED90464", hash_generated_method = "C63631628A71855211E03B08E189AF38")
    public void setValueAsObject(Object v) {
        value = v;
        // ---------- Original Method ----------
        //value = v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.659 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "8F261518BC81713E3AABC30C0C370B4B")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1479044004 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1479044004.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1479044004;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.661 -0400", hash_original_method = "8C352692671CA7B4091AFB32E24F1EAA", hash_generated_method = "28EF61EA0D3D5FBB296D9F0FB451FB1D")
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
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_723828784 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_723828784.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_723828784;
            } //End block
            else
    if(GenericObjectList.isMySubclass(value.getClass()))            
            {
                GenericObjectList gvlist = (GenericObjectList) value;
                buffer.append(name).append(separator).append(gvlist.encode());
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_247145108 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_247145108.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_247145108;
            } //End block
            else
    if(value.toString().length() == 0)            
            {
    if(this.isQuotedString)                
                {
                    buffer.append(name).append(separator).append(quotes).append(quotes);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1021603531 =                     buffer;
                    varE75BCB56CC6A0BCEED51BE38E1BB3F38_1021603531.addTaint(taint);
                    return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1021603531;
                } //End block
                else
                {
                    buffer.append(name).append(separator);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1942913688 =                     buffer;
                    varE75BCB56CC6A0BCEED51BE38E1BB3F38_1942913688.addTaint(taint);
                    return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1942913688;
                } //End block
            } //End block
            else
            {
                buffer.append(name).append(separator).append(quotes).append(value.toString()).append(quotes);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_289704947 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_289704947.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_289704947;
            } //End block
        } //End block
        else
    if(name == null && value != null)        
        {
    if(GenericObject.isMySubclass(value.getClass()))            
            {
                GenericObject gv = (GenericObject) value;
                gv.encode(buffer);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_2051312432 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_2051312432.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_2051312432;
            } //End block
            else
    if(GenericObjectList.isMySubclass(value.getClass()))            
            {
                GenericObjectList gvlist = (GenericObjectList) value;
                buffer.append(gvlist.encode());
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_479743287 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_479743287.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_479743287;
            } //End block
            else
            {
                buffer.append(quotes).append(value.toString()).append(quotes);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1355409054 =                 buffer;
                varE75BCB56CC6A0BCEED51BE38E1BB3F38_1355409054.addTaint(taint);
                return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1355409054;
            } //End block
        } //End block
        else
    if(name != null && (value == null || isFlagParameter))        
        {
            buffer.append(name);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1653846938 =             buffer;
            varE75BCB56CC6A0BCEED51BE38E1BB3F38_1653846938.addTaint(taint);
            return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1653846938;
        } //End block
        else
        {
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_110451557 =             buffer;
            varE75BCB56CC6A0BCEED51BE38E1BB3F38_110451557.addTaint(taint);
            return varE75BCB56CC6A0BCEED51BE38E1BB3F38_110451557;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.663 -0400", hash_original_method = "AFA5C2A13F94EAF8D89E1398D2146232", hash_generated_method = "A816F07C57DA17201180D7F047F55F21")
    public Object clone() {
        NameValue retval = (NameValue) super.clone();
    if(value != null)        
        retval.value = makeClone(value);
Object varF9E19AD6135C970F387F77C6F3DE4477_927588770 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_927588770.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_927588770;
        // ---------- Original Method ----------
        //NameValue retval = (NameValue) super.clone();
        //if (value != null)
            //retval.value = makeClone(value);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.664 -0400", hash_original_method = "C7D1B39DFE3B0192F0BEF83FC7C40106", hash_generated_method = "8BD4BB7916C83DD8CC325AE2B2412EB1")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1719237239 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689973590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_689973590;
        }
    if(!other.getClass().equals(this.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_872746308 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1766416108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1766416108;
        }
        NameValue that = (NameValue) other;
    if(this == that)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_670865180 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_925703125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_925703125;
        }
    if(this.name == null && that.name != null || this.name != null
                && that.name == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1249196203 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972654198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_972654198;
        }
    if(this.name != null && that.name != null
                && this.name.compareToIgnoreCase(that.name) != 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1431569910 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1445449929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1445449929;
        }
    if(this.value != null && that.value == null || this.value == null
                && that.value != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_437723435 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97037350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_97037350;
        }
    if(this.value == that.value)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1522519832 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335638232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335638232;
        }
    if(value instanceof String)        
        {
    if(isQuotedString)            
            {
            boolean var002C2EFAECBC0CE1ABC19CDEC790A2C1_935864964 = (this.value.equals(that.value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_477624182 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_477624182;
            }
            String val = (String) this.value;
            String val1 = (String) that.value;
            boolean var2094A36EE46BE55A950292ADEF1A828C_1423971763 = (val.compareToIgnoreCase(val1) == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400791711 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400791711;
        } //End block
        else
        {
        boolean var002C2EFAECBC0CE1ABC19CDEC790A2C1_979472295 = (this.value.equals(that.value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567378990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_567378990;
        }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.664 -0400", hash_original_method = "2F0EB2DB361DE1F8D28986094D857BA0", hash_generated_method = "49C053D45F52B66FB444D68AF89BD097")
    public String getKey() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_2100290581 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_2100290581.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_2100290581;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.665 -0400", hash_original_method = "4618674F7CF871F15A32C0791ACD2466", hash_generated_method = "653D662544DD4DF3B9535117D446201D")
    public String getValue() {
String var92A1FFC6B177D883E210D7CDB9C12881_1584381411 =         value == null ? null : this.value.toString();
        var92A1FFC6B177D883E210D7CDB9C12881_1584381411.addTaint(taint);
        return var92A1FFC6B177D883E210D7CDB9C12881_1584381411;
        // ---------- Original Method ----------
        //return  value == null ? null : this.value.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.666 -0400", hash_original_method = "34CFBA77959CE5FB40B94FB25C9241AB", hash_generated_method = "79347FD0D17B6B69772FB7F7DCE63086")
    public String setValue(String value) {
        String retval = this.value == null ? null : value;
        this.value = value;
String varF9E19AD6135C970F387F77C6F3DE4477_729695014 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_729695014.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_729695014;
        // ---------- Original Method ----------
        //String retval = this.value == null ? null : value;
        //this.value = value;
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.666 -0400", hash_original_method = "65B8B320E0D14FEF2FD57F3B89A2B17F", hash_generated_method = "9AD97133CE759103553A1941ACF87286")
    @Override
    public int hashCode() {
        int varC1842B56F11397EBFCEB22DFBE803B55_1949631983 = (this.encode().toLowerCase().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563280122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563280122;
        // ---------- Original Method ----------
        //return this.encode().toLowerCase().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.667 -0400", hash_original_field = "B4F1F4CEA79E2E813F8321547B3C6829", hash_generated_field = "01B78AA1575EDF3A89DB226DD6F71B77")

    private static final long serialVersionUID = -1857729012596437950L;
}

