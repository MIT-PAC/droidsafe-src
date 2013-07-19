package gov.nist.core;

// Droidsafe Imports
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class GenericObjectList extends LinkedList<GenericObject> implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.271 -0400", hash_original_field = "449072E30B43D04B744F22522A880818", hash_generated_field = "3BB4EF50B1D217FA88F0841635612381")

    protected int indentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.271 -0400", hash_original_field = "E1C39316D16E130F949719C63453172F", hash_generated_field = "DD964F0DE507D319881A894372709801")

    protected String listName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.271 -0400", hash_original_field = "486A6191A59171CAF7B24C9D7EEF82B2", hash_generated_field = "B16F5FE53C476D2E6CEFB884C718A580")

    private ListIterator<? extends GenericObject> myListIterator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.271 -0400", hash_original_field = "40419C36198E2BF68491607F3BBDC619", hash_generated_field = "A7CB93AD593788A74C76D77C24510B38")

    private String stringRep;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.271 -0400", hash_original_field = "D0509468108F68C610DFF430648FE029", hash_generated_field = "2318E7DEB97DCC58ED55C9B3D6EA868C")

    protected Class<?> myClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.271 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "05ABC643E14669ABD06E074989E55128")

    protected String separator;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.272 -0400", hash_original_method = "B4C0906D853ADC385414EECD7EA637D1", hash_generated_method = "4A8976BAB43057C94B303DF0AF3F3720")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.272 -0400", hash_original_method = "8E04C29D2DF262A7362105153E637B6F", hash_generated_method = "8CCE918BF37E1EBCCE0CDCFB3626393F")
    protected  GenericObjectList(String lname) {
        this();
        listName = lname;
        // ---------- Original Method ----------
        //listName = lname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.273 -0400", hash_original_method = "F5DC2C4EC43CFECAAD740ADD55431DC9", hash_generated_method = "FF7DB5FE015212A4B1AFAD154023E8E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.273 -0400", hash_original_method = "4BFA114444B30544264252F06586D600", hash_generated_method = "223A8F81BB04AC4E5F8C5732970E7C9A")
    protected  GenericObjectList(String lname, Class objclass) {
        this(lname);
        addTaint(lname.getTaint());
        myClass = objclass;
        // ---------- Original Method ----------
        //myClass = objclass;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.274 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "2B8CCB30336A04E57198988A134D5EEE")
    protected String getIndentation() {
        char[] chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
String var300818D7D4F603E5F4346D4E090224B6_599495615 =         new String(chars);
        var300818D7D4F603E5F4346D4E090224B6_599495615.addTaint(taint);
        return var300818D7D4F603E5F4346D4E090224B6_599495615;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.275 -0400", hash_original_method = "6368B146C50DA8D7E84E7623E4D72233", hash_generated_method = "DF9AC0247F1E0AE4E293078B3DF074A0")
    public Object clone() {
        GenericObjectList retval = (GenericObjectList) super.clone();
for(ListIterator<GenericObject> iter = retval.listIterator();iter.hasNext();)
        {
            GenericObject obj = (GenericObject) ((GenericObject) iter.next())
                    .clone();
            iter.set(obj);
        } //End block
Object varF9E19AD6135C970F387F77C6F3DE4477_465424222 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_465424222.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_465424222;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.275 -0400", hash_original_method = "D0155A1FF97450AAAC485CBFCA9B9151", hash_generated_method = "CD555D9A7A572ADB1416682B5064D9A7")
    public void setMyClass(Class cl) {
        myClass = cl;
        // ---------- Original Method ----------
        //myClass = cl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.275 -0400", hash_original_method = "04D90EEE60FDC73EE04A6B692FFCF48F", hash_generated_method = "9E3A0053677D3BB243C0D45294CAAA77")
    protected GenericObject next(ListIterator iterator) {
        addTaint(iterator.getTaint());
        try 
        {
GenericObject varF8A4C5F00CE0EF2DDC27545CDFF28D4C_2080944339 =             (GenericObject) iterator.next();
            varF8A4C5F00CE0EF2DDC27545CDFF28D4C_2080944339.addTaint(taint);
            return varF8A4C5F00CE0EF2DDC27545CDFF28D4C_2080944339;
        } //End block
        catch (NoSuchElementException ex)
        {
GenericObject var540C13E9E156B687226421B24F2DF178_1395028041 =             null;
            var540C13E9E156B687226421B24F2DF178_1395028041.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1395028041;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return (GenericObject) iterator.next();
        //} catch (NoSuchElementException ex) {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.276 -0400", hash_original_method = "0C810F8EA313238CAFFD85BD22D89FC5", hash_generated_method = "4D5F894AFE8FDE8F627AD7DC20950838")
    protected GenericObject first() {
        myListIterator = this.listIterator(0);
        try 
        {
GenericObject varE2756AEC1430DA89A0100343889C2F3D_1499078390 =             (GenericObject) myListIterator.next();
            varE2756AEC1430DA89A0100343889C2F3D_1499078390.addTaint(taint);
            return varE2756AEC1430DA89A0100343889C2F3D_1499078390;
        } //End block
        catch (NoSuchElementException ex)
        {
GenericObject var540C13E9E156B687226421B24F2DF178_1896249372 =             null;
            var540C13E9E156B687226421B24F2DF178_1896249372.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1896249372;
        } //End block
        // ---------- Original Method ----------
        //myListIterator = this.listIterator(0);
        //try {
            //return (GenericObject) myListIterator.next();
        //} catch (NoSuchElementException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.277 -0400", hash_original_method = "F8FE3E2E9328224EF7348B82C4E16D5E", hash_generated_method = "25EE412368F145BF31988AD2BB899B75")
    protected GenericObject next() {
        if(myListIterator == null)        
        {
            myListIterator = this.listIterator(0);
        } //End block
        try 
        {
GenericObject varE2756AEC1430DA89A0100343889C2F3D_728781126 =             (GenericObject) myListIterator.next();
            varE2756AEC1430DA89A0100343889C2F3D_728781126.addTaint(taint);
            return varE2756AEC1430DA89A0100343889C2F3D_728781126;
        } //End block
        catch (NoSuchElementException ex)
        {
            myListIterator = null;
GenericObject var540C13E9E156B687226421B24F2DF178_5020271 =             null;
            var540C13E9E156B687226421B24F2DF178_5020271.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_5020271;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.277 -0400", hash_original_method = "36818B2036C6B7283455BB1B552EEC9B", hash_generated_method = "FCC7E5A99898758986689978099EE69C")
    protected void concatenate(GenericObjectList objList) {
        addTaint(objList.getTaint());
        concatenate(objList, false);
        // ---------- Original Method ----------
        //concatenate(objList, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.277 -0400", hash_original_method = "08F2996E575B7D53E4C32324607C70EA", hash_generated_method = "FCF72AEAFD495426B393C6C128B6AE22")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.279 -0400", hash_original_method = "ECC7081A6DE8800C166F28F2C3CCF64F", hash_generated_method = "3761CEDEEDE8B8C61A2B8BEEEE74C3EB")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.279 -0400", hash_original_method = "373CBEDF2A2DC4BB05F4307048ABF6D6", hash_generated_method = "D115AF6B7C3EA77E7490358E49178E98")
    public String debugDump() {
        stringRep = "";
        Object obj = this.first();
        if(obj == null)        
        {
String var8277B846C0FEC64C0D7C6AE63630090D_992366676 =         "<null>";
        var8277B846C0FEC64C0D7C6AE63630090D_992366676.addTaint(taint);
        return var8277B846C0FEC64C0D7C6AE63630090D_992366676;
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
String varBB173740B3F06857085CC2C58DFBA675_829248291 =         stringRep;
        varBB173740B3F06857085CC2C58DFBA675_829248291.addTaint(taint);
        return varBB173740B3F06857085CC2C58DFBA675_829248291;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.280 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "6FA31ACE33C1515F301A61D6CB901EDE")
    public String debugDump(int indent) {
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
String varF9E19AD6135C970F387F77C6F3DE4477_1769518276 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1769518276.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1769518276;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.280 -0400", hash_original_method = "8D0C02EDD4F71C5F926965BFB69DF22C", hash_generated_method = "382CDBE7B59CE5A40C34003CF9834C55")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.280 -0400", hash_original_method = "FBFEF7110940F0EF7EB32E6578ACD520", hash_generated_method = "7057AD0848DEFF7A4D67DE3383568A65")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.281 -0400", hash_original_method = "CDD824836834585D009706CA2D2AF418", hash_generated_method = "E2E98443C2C0F6FC189FBBAD8F5424CA")
    public String encode() {
        if(this.isEmpty())        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1878302309 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1878302309.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1878302309;
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
String varD48A745DC29A29C7851286E6A426D0D0_1915939066 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_1915939066.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_1915939066;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.281 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "80DC3A8964A219B07BC97E4F3A81F51C")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_1214164051 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_1214164051.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_1214164051;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.281 -0400", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "BE8D7A91CF35C3CE4342E681E66ABB40")
    public void setSeparator(String sep) {
        separator = sep;
        // ---------- Original Method ----------
        //separator = sep;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.281 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "51132B5AA4E4804C1F7FF6B11AFCE9B9")
    public int hashCode() {
        int varA1D0C6E83F027327D8461063F4AC58A6_1151274725 = (42);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083302836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083302836;
        // ---------- Original Method ----------
        //return 42;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.282 -0400", hash_original_method = "DCC9B19E3EEEE0A135F8C5BB2CAD40B2", hash_generated_method = "EEEE5E9D3EE612D152E8A99762D24A3C")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1906319663 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_795600668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_795600668;
        }
        if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1441052194 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182811265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182811265;
        }
        GenericObjectList that = (GenericObjectList) other;
        if(this.size() != that.size())        
        {
        boolean var68934A3E9455FA72420237EB05902327_816149785 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1023114128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1023114128;
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
                boolean var68934A3E9455FA72420237EB05902327_1668259829 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715649912 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_715649912;
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
                boolean var68934A3E9455FA72420237EB05902327_1315982212 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1262510757 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1262510757;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_796747159 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128920903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128920903;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.283 -0400", hash_original_method = "28715ED51BABD0145D8C6E4EC8A7426B", hash_generated_method = "F8B68E696FC9228B6B478E6180582DBE")
    public boolean match(Object other) {
        addTaint(other.getTaint());
        if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_514657535 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_528510407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_528510407;
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
            boolean var68934A3E9455FA72420237EB05902327_2134524995 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898011480 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_898011480;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1520047077 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_880507815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_880507815;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.283 -0400", hash_original_field = "D1190824E35A683C05589F1C776EEB98", hash_generated_field = "02EC968BA435084EE7ADC81279AB56D8")

    protected static final String SEMICOLON = Separators.SEMICOLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.283 -0400", hash_original_field = "02A534AF21A6F783F08D86D26579E890", hash_generated_field = "6B6A3C0E5AAA12BC4230EF790A3C2476")

    protected static final String COLON = Separators.COLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.283 -0400", hash_original_field = "6C852D8F8039F1F9747489612DAC3C3C", hash_generated_field = "2C4A8D03DDB954D51E978CD8F8E2DEA4")

    protected static final String COMMA = Separators.COMMA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.283 -0400", hash_original_field = "04C5392343613D1101130F746A81D0F3", hash_generated_field = "8A50D691E37AC9254B7ED2ABCE4AC6D2")

    protected static final String SLASH = Separators.SLASH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.283 -0400", hash_original_field = "D8EE4E7D0F1EAB2E2745753B5AD2FE8D", hash_generated_field = "0CF03E9FD9212362B2D202A36124051A")

    protected static final String SP = Separators.SP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "3C7C6B82B012EBDA39975B1F72983C28", hash_generated_field = "AD22F298E6FF482BE0BD697358901610")

    protected static final String EQUALS = Separators.EQUALS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "B9D394806A580E8DE8984E11AC02BDE2", hash_generated_field = "2A5C8D44567A1C68D53F48B0CD1AF72E")

    protected static final String STAR = Separators.STAR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "4B65D6BACAFDD7AB302810256C42CCB9", hash_generated_field = "99D8C532EFD2EC03350A98B152CEDB7F")

    protected static final String NEWLINE = Separators.NEWLINE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "4E25B108371C30F889E1B6E8C1046FAB", hash_generated_field = "5E44FE20A9580182CC4CE4836B87D2F2")

    protected static final String RETURN = Separators.RETURN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "7E16A38DE053150CC3BF00FEBC32CBB3", hash_generated_field = "03472463E2EA98D819ECAC54647D9EEB")

    protected static final String LESS_THAN = Separators.LESS_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "CBC3FB6A2E3BC245B189168F8F698149", hash_generated_field = "EADC9D4C7F8A41AC9253B4399DD9CC22")

    protected static final String GREATER_THAN = Separators.GREATER_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "72EE65D27F762C3B2FB94C3FA334B5E4", hash_generated_field = "94E22BF70767B9E5F90C8BEFB48DFB31")

    protected static final String AT = Separators.AT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "3ACE38B8B42CCCDC519BBD9065EB1D1A", hash_generated_field = "C68E946646D329E00948C391567E8245")

    protected static final String DOT = Separators.DOT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "B2A15792014FB9077E86DD721A8EFBA4", hash_generated_field = "C6F6498E0BEB8E9B929D5FF0691C60C5")

    protected static final String QUESTION = Separators.QUESTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "096D0F7D4D4C7B4283D714ECD7F549C3", hash_generated_field = "3931FF01A0452F4B915432DFE1D8342B")

    protected static final String POUND = Separators.POUND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "705C7DB0DE742246702AC85CCAA66A2B", hash_generated_field = "A7C8E60A9ACCF4FC95E42A6FE3CBE98A")

    protected static final String AND = Separators.AND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "B7554C14B11FFE96B375109E44C62935", hash_generated_field = "96B1BA6A04896DF507DBF5F6007D53FF")

    protected static final String LPAREN = Separators.LPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "ED8913C274C5CDFEFC62F7A7FE2688CB", hash_generated_field = "04E1EDA33DBBA7B9CD0B5320DA6E2B15")

    protected static final String RPAREN = Separators.RPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "CD4D1E68FDC871F3D1A212D438F276AF", hash_generated_field = "60970C4DF02E2922FFB2BB3FCBF1CC4C")

    protected static final String DOUBLE_QUOTE = Separators.DOUBLE_QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "1084586CDB13332FA26836F7CE2B3817", hash_generated_field = "36D2B8942300A11E9A202D488BEEC708")

    protected static final String QUOTE = Separators.QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "58E3D5E258B17E5D6D1BDF83FE976FD6", hash_generated_field = "EE0F746E0ADCCF78C293F0BC27A024C1")

    protected static final String HT = Separators.HT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.284 -0400", hash_original_field = "4AEF06B345694E240504FA11CF16C815", hash_generated_field = "E525B1F947054DAAB71F0D7018A0312F")

    protected static final String PERCENT = Separators.PERCENT;
}

