package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.io.Serializable;

public abstract class GenericObjectList extends LinkedList<GenericObject> implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.248 -0400", hash_original_field = "449072E30B43D04B744F22522A880818", hash_generated_field = "3BB4EF50B1D217FA88F0841635612381")

    protected int indentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.249 -0400", hash_original_field = "E1C39316D16E130F949719C63453172F", hash_generated_field = "DD964F0DE507D319881A894372709801")

    protected String listName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.249 -0400", hash_original_field = "486A6191A59171CAF7B24C9D7EEF82B2", hash_generated_field = "B16F5FE53C476D2E6CEFB884C718A580")

    private ListIterator<? extends GenericObject> myListIterator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.249 -0400", hash_original_field = "40419C36198E2BF68491607F3BBDC619", hash_generated_field = "A7CB93AD593788A74C76D77C24510B38")

    private String stringRep;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.249 -0400", hash_original_field = "D0509468108F68C610DFF430648FE029", hash_generated_field = "2318E7DEB97DCC58ED55C9B3D6EA868C")

    protected Class<?> myClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.249 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "05ABC643E14669ABD06E074989E55128")

    protected String separator;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.249 -0400", hash_original_method = "B4C0906D853ADC385414EECD7EA637D1", hash_generated_method = "4A8976BAB43057C94B303DF0AF3F3720")
    protected  GenericObjectList() {
        super();
        listName = null;
        stringRep = "";
        separator = ";";
        // ---------- Original Method ----------
        //listName = null;
        //stringRep = "";
        //separator = ";";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.250 -0400", hash_original_method = "8E04C29D2DF262A7362105153E637B6F", hash_generated_method = "8CCE918BF37E1EBCCE0CDCFB3626393F")
    protected  GenericObjectList(String lname) {
        this();
        listName = lname;
        // ---------- Original Method ----------
        //listName = lname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.250 -0400", hash_original_method = "F5DC2C4EC43CFECAAD740ADD55431DC9", hash_generated_method = "FF7DB5FE015212A4B1AFAD154023E8E6")
    protected  GenericObjectList(String lname, String classname) {
        this(lname);
        addTaint(lname.getTaint());
        try 
        {
            myClass = Class.forName(classname);
        } //End block
        catch (ClassNotFoundException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        // ---------- Original Method ----------
        //try {
            //myClass = Class.forName(classname);
        //} catch (ClassNotFoundException ex) {
            //InternalErrorHandler.handleException(ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.251 -0400", hash_original_method = "4BFA114444B30544264252F06586D600", hash_generated_method = "223A8F81BB04AC4E5F8C5732970E7C9A")
    protected  GenericObjectList(String lname, Class objclass) {
        this(lname);
        addTaint(lname.getTaint());
        myClass = objclass;
        // ---------- Original Method ----------
        //myClass = objclass;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.251 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "46E6B77F197313587BFC095D09FA5111")
    protected String getIndentation() {
        char[] chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
String var300818D7D4F603E5F4346D4E090224B6_479965771 =         new String(chars);
        var300818D7D4F603E5F4346D4E090224B6_479965771.addTaint(taint);
        return var300818D7D4F603E5F4346D4E090224B6_479965771;
        // ---------- Original Method ----------
        //char[] chars = new char[indentation];
        //java.util.Arrays.fill(chars, ' ');
        //return new String(chars);
    }

    
        @DSModeled(DSC.SAFE)
    protected static boolean isCloneable(Object obj) {
        return obj instanceof Cloneable;
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean isMySubclass(Class<?> other) {
        return GenericObjectList.class.isAssignableFrom(other);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.252 -0400", hash_original_method = "6368B146C50DA8D7E84E7623E4D72233", hash_generated_method = "80389B1283EDA0FF09AB76925EF3E5A0")
    public Object clone() {
        GenericObjectList retval = (GenericObjectList) super.clone();
for(ListIterator<GenericObject> iter = retval.listIterator();iter.hasNext();)
        {
            GenericObject obj = (GenericObject) ((GenericObject) iter.next())
                    .clone();
            iter.set(obj);
        } //End block
Object varF9E19AD6135C970F387F77C6F3DE4477_782499885 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_782499885.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_782499885;
        // ---------- Original Method ----------
        //GenericObjectList retval = (GenericObjectList) super.clone();
        //for (ListIterator<GenericObject> iter = retval.listIterator(); iter.hasNext();) {
            //GenericObject obj = (GenericObject) ((GenericObject) iter.next())
                    //.clone();
            //iter.set(obj);
        //}
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.252 -0400", hash_original_method = "D0155A1FF97450AAAC485CBFCA9B9151", hash_generated_method = "CD555D9A7A572ADB1416682B5064D9A7")
    public void setMyClass(Class cl) {
        myClass = cl;
        // ---------- Original Method ----------
        //myClass = cl;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.252 -0400", hash_original_method = "04D90EEE60FDC73EE04A6B692FFCF48F", hash_generated_method = "0EC2295E3D316A6129CF91B3D1058E20")
    protected GenericObject next(ListIterator iterator) {
        addTaint(iterator.getTaint());
        try 
        {
GenericObject varF8A4C5F00CE0EF2DDC27545CDFF28D4C_994685075 =             (GenericObject) iterator.next();
            varF8A4C5F00CE0EF2DDC27545CDFF28D4C_994685075.addTaint(taint);
            return varF8A4C5F00CE0EF2DDC27545CDFF28D4C_994685075;
        } //End block
        catch (NoSuchElementException ex)
        {
GenericObject var540C13E9E156B687226421B24F2DF178_1911378215 =             null;
            var540C13E9E156B687226421B24F2DF178_1911378215.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1911378215;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return (GenericObject) iterator.next();
        //} catch (NoSuchElementException ex) {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.253 -0400", hash_original_method = "0C810F8EA313238CAFFD85BD22D89FC5", hash_generated_method = "839302873DDFF53B7740E4621B4BA58C")
    protected GenericObject first() {
        myListIterator = this.listIterator(0);
        try 
        {
GenericObject varE2756AEC1430DA89A0100343889C2F3D_1151632070 =             (GenericObject) myListIterator.next();
            varE2756AEC1430DA89A0100343889C2F3D_1151632070.addTaint(taint);
            return varE2756AEC1430DA89A0100343889C2F3D_1151632070;
        } //End block
        catch (NoSuchElementException ex)
        {
GenericObject var540C13E9E156B687226421B24F2DF178_2124571326 =             null;
            var540C13E9E156B687226421B24F2DF178_2124571326.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2124571326;
        } //End block
        // ---------- Original Method ----------
        //myListIterator = this.listIterator(0);
        //try {
            //return (GenericObject) myListIterator.next();
        //} catch (NoSuchElementException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.253 -0400", hash_original_method = "F8FE3E2E9328224EF7348B82C4E16D5E", hash_generated_method = "34309169A1AB346308F5F5053B9432F4")
    protected GenericObject next() {
    if(myListIterator == null)        
        {
            myListIterator = this.listIterator(0);
        } //End block
        try 
        {
GenericObject varE2756AEC1430DA89A0100343889C2F3D_184440654 =             (GenericObject) myListIterator.next();
            varE2756AEC1430DA89A0100343889C2F3D_184440654.addTaint(taint);
            return varE2756AEC1430DA89A0100343889C2F3D_184440654;
        } //End block
        catch (NoSuchElementException ex)
        {
            myListIterator = null;
GenericObject var540C13E9E156B687226421B24F2DF178_1575801893 =             null;
            var540C13E9E156B687226421B24F2DF178_1575801893.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1575801893;
        } //End block
        // ---------- Original Method ----------
        //if (myListIterator == null) {
            //myListIterator = this.listIterator(0);
        //}
        //try {
            //return (GenericObject) myListIterator.next();
        //} catch (NoSuchElementException ex) {
            //myListIterator = null;
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.254 -0400", hash_original_method = "36818B2036C6B7283455BB1B552EEC9B", hash_generated_method = "FCC7E5A99898758986689978099EE69C")
    protected void concatenate(GenericObjectList objList) {
        addTaint(objList.getTaint());
        concatenate(objList, false);
        // ---------- Original Method ----------
        //concatenate(objList, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.254 -0400", hash_original_method = "08F2996E575B7D53E4C32324607C70EA", hash_generated_method = "FCF72AEAFD495426B393C6C128B6AE22")
    protected void concatenate(GenericObjectList objList, boolean topFlag) {
        addTaint(topFlag);
        addTaint(objList.getTaint());
    if(!topFlag)        
        {
            this.addAll(objList);
        } //End block
        else
        {
            this.addAll(0, objList);
        } //End block
        // ---------- Original Method ----------
        //if (!topFlag) {
            //this.addAll(objList);
        //} else {
            //this.addAll(0, objList);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.255 -0400", hash_original_method = "ECC7081A6DE8800C166F28F2C3CCF64F", hash_generated_method = "3761CEDEEDE8B8C61A2B8BEEEE74C3EB")
    private void sprint(String s) {
    if(s == null)        
        {
            stringRep += getIndentation();
            stringRep += "<null>\n";
            return;
        } //End block
    if(s.compareTo("}") == 0 || s.compareTo("]") == 0)        
        {
            indentation--;
        } //End block
        stringRep += getIndentation();
        stringRep += s;
        stringRep += "\n";
    if(s.compareTo("{") == 0 || s.compareTo("[") == 0)        
        {
            indentation++;
        } //End block
        // ---------- Original Method ----------
        //if (s == null) {
            //stringRep += getIndentation();
            //stringRep += "<null>\n";
            //return;
        //}
        //if (s.compareTo("}") == 0 || s.compareTo("]") == 0) {
            //indentation--;
        //}
        //stringRep += getIndentation();
        //stringRep += s;
        //stringRep += "\n";
        //if (s.compareTo("{") == 0 || s.compareTo("[") == 0) {
            //indentation++;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.256 -0400", hash_original_method = "373CBEDF2A2DC4BB05F4307048ABF6D6", hash_generated_method = "ADBEB176173463819CCA116DA77CC051")
    public String debugDump() {
        stringRep = "";
        Object obj = this.first();
    if(obj == null)        
        {
String var8277B846C0FEC64C0D7C6AE63630090D_1343504207 =         "<null>";
        var8277B846C0FEC64C0D7C6AE63630090D_1343504207.addTaint(taint);
        return var8277B846C0FEC64C0D7C6AE63630090D_1343504207;
        }
        sprint("listName:");
        sprint(listName);
        sprint("{");
        while
(obj != null)        
        {
            sprint("[");
            sprint(((GenericObject) obj).debugDump(this.indentation));
            obj = next();
            sprint("]");
        } //End block
        sprint("}");
String varBB173740B3F06857085CC2C58DFBA675_1191413896 =         stringRep;
        varBB173740B3F06857085CC2C58DFBA675_1191413896.addTaint(taint);
        return varBB173740B3F06857085CC2C58DFBA675_1191413896;
        // ---------- Original Method ----------
        //stringRep = "";
        //Object obj = this.first();
        //if (obj == null)
            //return "<null>";
        //sprint("listName:");
        //sprint(listName);
        //sprint("{");
        //while (obj != null) {
            //sprint("[");
            //sprint(((GenericObject) obj).debugDump(this.indentation));
            //obj = next();
            //sprint("]");
        //}
        //sprint("}");
        //return stringRep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.257 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "B8BFB1C9C1699ED7D04382AACBBF3F97")
    public String debugDump(int indent) {
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
String varF9E19AD6135C970F387F77C6F3DE4477_1591904100 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1591904100.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1591904100;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.258 -0400", hash_original_method = "8D0C02EDD4F71C5F926965BFB69DF22C", hash_generated_method = "382CDBE7B59CE5A40C34003CF9834C55")
    public void addFirst(GenericObject objToAdd) {
    if(myClass == null)        
        {
            myClass = objToAdd.getClass();
        } //End block
        else
        {
            super.addFirst(objToAdd);
        } //End block
        // ---------- Original Method ----------
        //if (myClass == null) {
            //myClass = objToAdd.getClass();
        //} else {
            //super.addFirst(objToAdd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.258 -0400", hash_original_method = "FBFEF7110940F0EF7EB32E6578ACD520", hash_generated_method = "7057AD0848DEFF7A4D67DE3383568A65")
    public void mergeObjects(GenericObjectList mergeList) {
        addTaint(mergeList.getTaint());
    if(mergeList == null)        
        return;
        Iterator it1 = this.listIterator();
        Iterator it2 = mergeList.listIterator();
        while
(it1.hasNext())        
        {
            GenericObject outerObj = (GenericObject) it1.next();
            while
(it2.hasNext())            
            {
                Object innerObj = it2.next();
                outerObj.merge(innerObj);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mergeList == null)
            //return;
        //Iterator it1 = this.listIterator();
        //Iterator it2 = mergeList.listIterator();
        //while (it1.hasNext()) {
            //GenericObject outerObj = (GenericObject) it1.next();
            //while (it2.hasNext()) {
                //Object innerObj = it2.next();
                //outerObj.merge(innerObj);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.258 -0400", hash_original_method = "CDD824836834585D009706CA2D2AF418", hash_generated_method = "78D00AC6CB7E6F5F0730FE7016E460C7")
    public String encode() {
    if(this.isEmpty())        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1175219126 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1175219126.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1175219126;
        }
        StringBuffer encoding = new StringBuffer();
        ListIterator iterator = this.listIterator();
    if(iterator.hasNext())        
        {
            while
(true)            
            {
                Object obj = iterator.next();
    if(obj instanceof GenericObject)                
                {
                    GenericObject gobj = (GenericObject) obj;
                    encoding.append(gobj.encode());
                } //End block
                else
                {
                    encoding.append(obj.toString());
                } //End block
    if(iterator.hasNext())                
                encoding.append(separator);
                else
                break;
            } //End block
        } //End block
String varD48A745DC29A29C7851286E6A426D0D0_1582057543 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_1582057543.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_1582057543;
        // ---------- Original Method ----------
        //if (this.isEmpty())
            //return "";
        //StringBuffer encoding = new StringBuffer();
        //ListIterator iterator = this.listIterator();
        //if (iterator.hasNext()) {
            //while (true) {
                //Object obj = iterator.next();
                //if (obj instanceof GenericObject) {
                    //GenericObject gobj = (GenericObject) obj;
                    //encoding.append(gobj.encode());
                //} else {
                    //encoding.append(obj.toString());
                //}
                //if (iterator.hasNext())
                    //encoding.append(separator);
                //else
                    //break;
            //}
        //}
        //return encoding.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.259 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "0AAB838ECCE4348A0F84C523C34828F5")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_1513441414 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_1513441414.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_1513441414;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.259 -0400", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "BE8D7A91CF35C3CE4342E681E66ABB40")
    public void setSeparator(String sep) {
        separator = sep;
        // ---------- Original Method ----------
        //separator = sep;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.260 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "762DA5970B0C4592019664F21FBE388D")
    public int hashCode() {
        int varA1D0C6E83F027327D8461063F4AC58A6_801829064 = (42);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920746586 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920746586;
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.260 -0400", hash_original_method = "DCC9B19E3EEEE0A135F8C5BB2CAD40B2", hash_generated_method = "3083866FE0B14B967FC2822097BC828B")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_851928371 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101021334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101021334;
        }
    if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_381134849 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1702823515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1702823515;
        }
        GenericObjectList that = (GenericObjectList) other;
    if(this.size() != that.size())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1882681968 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1176290360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1176290360;
        }
        ListIterator myIterator = this.listIterator();
        while
(myIterator.hasNext())        
        {
            Object myobj = myIterator.next();
            ListIterator hisIterator = that.listIterator();
            try 
            {
                while
(true)                
                {
                    Object hisobj = hisIterator.next();
    if(myobj.equals(hisobj))                    
                    break;
                } //End block
            } //End block
            catch (NoSuchElementException ex)
            {
                boolean var68934A3E9455FA72420237EB05902327_1272728034 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2076422298 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2076422298;
            } //End block
        } //End block
        ListIterator hisIterator = that.listIterator();
        while
(hisIterator.hasNext())        
        {
            Object hisobj = hisIterator.next();
            myIterator = this.listIterator();
            try 
            {
                while
(true)                
                {
                    Object myobj = myIterator.next();
    if(hisobj.equals(myobj))                    
                    break;
                } //End block
            } //End block
            catch (NoSuchElementException ex)
            {
                boolean var68934A3E9455FA72420237EB05902327_881834021 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731881370 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_731881370;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_408977301 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1184686864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1184686864;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.261 -0400", hash_original_method = "28715ED51BABD0145D8C6E4EC8A7426B", hash_generated_method = "DBC6E8DE41905A0FCA0ABAAF6825148E")
    public boolean match(Object other) {
        addTaint(other.getTaint());
    if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1778484545 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018773258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018773258;
        }
        GenericObjectList that = (GenericObjectList) other;
        ListIterator hisIterator = that.listIterator();
    outer        :
        while
(hisIterator.hasNext())        
        {
            Object hisobj = hisIterator.next();
            Object myobj = null;
            ListIterator myIterator = this.listIterator();
            while
(myIterator.hasNext())            
            {
                myobj = myIterator.next();
    if(myobj instanceof GenericObject)                
                System.out.println("Trying to match  = "
                            + ((GenericObject) myobj).encode());
    if(GenericObject.isMySubclass(myobj.getClass())
                        && ((GenericObject) myobj).match(hisobj))                
                break outer;
                else
    if(GenericObjectList.isMySubclass(myobj.getClass())
                        && ((GenericObjectList) myobj).match(hisobj))                
                break outer;
            } //End block
            System.out.println(((GenericObject) hisobj).encode());
            boolean var68934A3E9455FA72420237EB05902327_1901904674 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526930916 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526930916;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1004523797 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_27422645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_27422645;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.262 -0400", hash_original_field = "D1190824E35A683C05589F1C776EEB98", hash_generated_field = "02EC968BA435084EE7ADC81279AB56D8")

    protected static final String SEMICOLON = Separators.SEMICOLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.262 -0400", hash_original_field = "02A534AF21A6F783F08D86D26579E890", hash_generated_field = "6B6A3C0E5AAA12BC4230EF790A3C2476")

    protected static final String COLON = Separators.COLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.262 -0400", hash_original_field = "6C852D8F8039F1F9747489612DAC3C3C", hash_generated_field = "2C4A8D03DDB954D51E978CD8F8E2DEA4")

    protected static final String COMMA = Separators.COMMA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.262 -0400", hash_original_field = "04C5392343613D1101130F746A81D0F3", hash_generated_field = "8A50D691E37AC9254B7ED2ABCE4AC6D2")

    protected static final String SLASH = Separators.SLASH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.262 -0400", hash_original_field = "D8EE4E7D0F1EAB2E2745753B5AD2FE8D", hash_generated_field = "0CF03E9FD9212362B2D202A36124051A")

    protected static final String SP = Separators.SP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.262 -0400", hash_original_field = "3C7C6B82B012EBDA39975B1F72983C28", hash_generated_field = "AD22F298E6FF482BE0BD697358901610")

    protected static final String EQUALS = Separators.EQUALS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.262 -0400", hash_original_field = "B9D394806A580E8DE8984E11AC02BDE2", hash_generated_field = "2A5C8D44567A1C68D53F48B0CD1AF72E")

    protected static final String STAR = Separators.STAR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.262 -0400", hash_original_field = "4B65D6BACAFDD7AB302810256C42CCB9", hash_generated_field = "99D8C532EFD2EC03350A98B152CEDB7F")

    protected static final String NEWLINE = Separators.NEWLINE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.262 -0400", hash_original_field = "4E25B108371C30F889E1B6E8C1046FAB", hash_generated_field = "5E44FE20A9580182CC4CE4836B87D2F2")

    protected static final String RETURN = Separators.RETURN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.263 -0400", hash_original_field = "7E16A38DE053150CC3BF00FEBC32CBB3", hash_generated_field = "03472463E2EA98D819ECAC54647D9EEB")

    protected static final String LESS_THAN = Separators.LESS_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.263 -0400", hash_original_field = "CBC3FB6A2E3BC245B189168F8F698149", hash_generated_field = "EADC9D4C7F8A41AC9253B4399DD9CC22")

    protected static final String GREATER_THAN = Separators.GREATER_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.263 -0400", hash_original_field = "72EE65D27F762C3B2FB94C3FA334B5E4", hash_generated_field = "94E22BF70767B9E5F90C8BEFB48DFB31")

    protected static final String AT = Separators.AT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.263 -0400", hash_original_field = "3ACE38B8B42CCCDC519BBD9065EB1D1A", hash_generated_field = "C68E946646D329E00948C391567E8245")

    protected static final String DOT = Separators.DOT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.263 -0400", hash_original_field = "B2A15792014FB9077E86DD721A8EFBA4", hash_generated_field = "C6F6498E0BEB8E9B929D5FF0691C60C5")

    protected static final String QUESTION = Separators.QUESTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.263 -0400", hash_original_field = "096D0F7D4D4C7B4283D714ECD7F549C3", hash_generated_field = "3931FF01A0452F4B915432DFE1D8342B")

    protected static final String POUND = Separators.POUND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.263 -0400", hash_original_field = "705C7DB0DE742246702AC85CCAA66A2B", hash_generated_field = "A7C8E60A9ACCF4FC95E42A6FE3CBE98A")

    protected static final String AND = Separators.AND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.263 -0400", hash_original_field = "B7554C14B11FFE96B375109E44C62935", hash_generated_field = "96B1BA6A04896DF507DBF5F6007D53FF")

    protected static final String LPAREN = Separators.LPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.263 -0400", hash_original_field = "ED8913C274C5CDFEFC62F7A7FE2688CB", hash_generated_field = "04E1EDA33DBBA7B9CD0B5320DA6E2B15")

    protected static final String RPAREN = Separators.RPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.263 -0400", hash_original_field = "CD4D1E68FDC871F3D1A212D438F276AF", hash_generated_field = "60970C4DF02E2922FFB2BB3FCBF1CC4C")

    protected static final String DOUBLE_QUOTE = Separators.DOUBLE_QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.264 -0400", hash_original_field = "1084586CDB13332FA26836F7CE2B3817", hash_generated_field = "36D2B8942300A11E9A202D488BEEC708")

    protected static final String QUOTE = Separators.QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.264 -0400", hash_original_field = "58E3D5E258B17E5D6D1BDF83FE976FD6", hash_generated_field = "EE0F746E0ADCCF78C293F0BC27A024C1")

    protected static final String HT = Separators.HT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.264 -0400", hash_original_field = "4AEF06B345694E240504FA11CF16C815", hash_generated_field = "E525B1F947054DAAB71F0D7018A0312F")

    protected static final String PERCENT = Separators.PERCENT;
}

