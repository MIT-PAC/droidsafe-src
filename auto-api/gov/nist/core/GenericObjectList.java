package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import java.io.Serializable;

public abstract class GenericObjectList extends LinkedList<GenericObject> implements Serializable, Cloneable {
    protected int indentation;
    protected String listName;
    private ListIterator<? extends GenericObject> myListIterator;
    private String stringRep;
    protected Class<?> myClass;
    protected String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.566 -0400", hash_original_method = "B4C0906D853ADC385414EECD7EA637D1", hash_generated_method = "4A8976BAB43057C94B303DF0AF3F3720")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected GenericObjectList() {
        super();
        listName = null;
        stringRep = "";
        separator = ";";
        // ---------- Original Method ----------
        //listName = null;
        //stringRep = "";
        //separator = ";";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.566 -0400", hash_original_method = "8E04C29D2DF262A7362105153E637B6F", hash_generated_method = "A9912DBDEA244902566684BFC0215810")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected GenericObjectList(String lname) {
        this();
        dsTaint.addTaint(lname);
        // ---------- Original Method ----------
        //listName = lname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.566 -0400", hash_original_method = "F5DC2C4EC43CFECAAD740ADD55431DC9", hash_generated_method = "0AA8BF58A3AAFAE64F6823927365333E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected GenericObjectList(String lname, String classname) {
        this(lname);
        dsTaint.addTaint(lname);
        dsTaint.addTaint(classname);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.566 -0400", hash_original_method = "4BFA114444B30544264252F06586D600", hash_generated_method = "4FFF324FBAD44ED475D26DF428CB7DE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected GenericObjectList(String lname, Class objclass) {
        this(lname);
        dsTaint.addTaint(objclass.dsTaint);
        dsTaint.addTaint(lname);
        // ---------- Original Method ----------
        //myClass = objclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.567 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "17B8D1415256D5A9053C61EA2A811177")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String getIndentation() {
        char[] chars;
        chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
        String var9B6664B2DE21520412F0E1A2ECF4D0EC_1334725084 = (new String(chars));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //char[] chars = new char[indentation];
        //java.util.Arrays.fill(chars, ' ');
        //return new String(chars);
    }

    
        protected static boolean isCloneable(Object obj) {
        return obj instanceof Cloneable;
    }

    
        public static boolean isMySubclass(Class<?> other) {
        return GenericObjectList.class.isAssignableFrom(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.567 -0400", hash_original_method = "6368B146C50DA8D7E84E7623E4D72233", hash_generated_method = "35C8E08AB5ED1D5F544FA38CDD8BF8A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        GenericObjectList retval;
        retval = (GenericObjectList) super.clone();
        {
            ListIterator<GenericObject> iter;
            iter = retval.listIterator();
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_518824388 = (iter.hasNext());
            {
                GenericObject obj;
                obj = (GenericObject) ((GenericObject) iter.next())
                    .clone();
                iter.set(obj);
            } //End block
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //GenericObjectList retval = (GenericObjectList) super.clone();
        //for (ListIterator<GenericObject> iter = retval.listIterator(); iter.hasNext();) {
            //GenericObject obj = (GenericObject) ((GenericObject) iter.next())
                    //.clone();
            //iter.set(obj);
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.567 -0400", hash_original_method = "D0155A1FF97450AAAC485CBFCA9B9151", hash_generated_method = "7527EB35D1A8083DC047E2118875899C")
    @DSModeled(DSC.SAFE)
    public void setMyClass(Class cl) {
        dsTaint.addTaint(cl.dsTaint);
        // ---------- Original Method ----------
        //myClass = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.568 -0400", hash_original_method = "04D90EEE60FDC73EE04A6B692FFCF48F", hash_generated_method = "11D81DB402999F90D6A3D7A07492C723")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected GenericObject next(ListIterator iterator) {
        dsTaint.addTaint(iterator.dsTaint);
        try 
        {
            GenericObject var3B8059584924EF6858997A0946108405_1888343984 = ((GenericObject) iterator.next());
        } //End block
        catch (NoSuchElementException ex)
        { }
        return (GenericObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return (GenericObject) iterator.next();
        //} catch (NoSuchElementException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.568 -0400", hash_original_method = "0C810F8EA313238CAFFD85BD22D89FC5", hash_generated_method = "218E4CE34B2155BA51A57C8EB1FEA9A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected GenericObject first() {
        myListIterator = this.listIterator(0);
        try 
        {
            GenericObject var71F27CE489B2856F4D88762816CB583B_713778260 = ((GenericObject) myListIterator.next());
        } //End block
        catch (NoSuchElementException ex)
        { }
        return (GenericObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //myListIterator = this.listIterator(0);
        //try {
            //return (GenericObject) myListIterator.next();
        //} catch (NoSuchElementException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.568 -0400", hash_original_method = "F8FE3E2E9328224EF7348B82C4E16D5E", hash_generated_method = "DA95B59F5A71F637A17F698B869B2ECE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected GenericObject next() {
        {
            myListIterator = this.listIterator(0);
        } //End block
        try 
        {
            GenericObject var71F27CE489B2856F4D88762816CB583B_1911209174 = ((GenericObject) myListIterator.next());
        } //End block
        catch (NoSuchElementException ex)
        {
            myListIterator = null;
        } //End block
        return (GenericObject)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.568 -0400", hash_original_method = "36818B2036C6B7283455BB1B552EEC9B", hash_generated_method = "5D756FBA902FC886817C2F2A923085E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void concatenate(GenericObjectList objList) {
        dsTaint.addTaint(objList.dsTaint);
        concatenate(objList, false);
        // ---------- Original Method ----------
        //concatenate(objList, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.568 -0400", hash_original_method = "08F2996E575B7D53E4C32324607C70EA", hash_generated_method = "287DECF976DEE7CF0868297F18AE9CBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void concatenate(GenericObjectList objList, boolean topFlag) {
        dsTaint.addTaint(topFlag);
        dsTaint.addTaint(objList.dsTaint);
        {
            this.addAll(objList);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.569 -0400", hash_original_method = "ECC7081A6DE8800C166F28F2C3CCF64F", hash_generated_method = "241C6A7E2517B638870BE9E6B5D0EDD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sprint(String s) {
        dsTaint.addTaint(s);
        {
            stringRep += getIndentation();
            stringRep += "<null>\n";
        } //End block
        {
            boolean varA6F9A9C7F2A0D695BD6817517FAC5713_38562047 = (s.compareTo("}") == 0 || s.compareTo("]") == 0);
        } //End collapsed parenthetic
        stringRep += getIndentation();
        stringRep += "\n";
        {
            boolean varE8A8307BD18B90A33CD1A32B530393A9_299512244 = (s.compareTo("{") == 0 || s.compareTo("[") == 0);
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.569 -0400", hash_original_method = "373CBEDF2A2DC4BB05F4307048ABF6D6", hash_generated_method = "8C52A0DC8E22848687156C2AC7141399")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump() {
        stringRep = "";
        Object obj;
        obj = this.first();
        sprint("listName:");
        sprint(listName);
        sprint("{");
        {
            sprint("[");
            sprint(((GenericObject) obj).debugDump(this.indentation));
            obj = next();
            sprint("]");
        } //End block
        sprint("}");
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.569 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "84EF9D5A997FA453D2ECA5ACFC3ACB0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump(int indent) {
        dsTaint.addTaint(indent);
        int save;
        save = indentation;
        String retval;
        retval = this.debugDump();
        indentation = save;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.569 -0400", hash_original_method = "8D0C02EDD4F71C5F926965BFB69DF22C", hash_generated_method = "48C291D19ED34865A4B34A1EF9290E3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFirst(GenericObject objToAdd) {
        dsTaint.addTaint(objToAdd.dsTaint);
        {
            myClass = objToAdd.getClass();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.570 -0400", hash_original_method = "FBFEF7110940F0EF7EB32E6578ACD520", hash_generated_method = "19167A33BACFADB3CA1F43CF36C63066")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mergeObjects(GenericObjectList mergeList) {
        dsTaint.addTaint(mergeList.dsTaint);
        Iterator it1;
        it1 = this.listIterator();
        Iterator it2;
        it2 = mergeList.listIterator();
        {
            boolean var67770E0E57A782FE24004C8EDF43E6C4_1235675014 = (it1.hasNext());
            {
                GenericObject outerObj;
                outerObj = (GenericObject) it1.next();
                {
                    boolean var9C6A988161E59916E4098A1BF51C47F9_274063276 = (it2.hasNext());
                    {
                        Object innerObj;
                        innerObj = it2.next();
                        outerObj.merge(innerObj);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.570 -0400", hash_original_method = "CDD824836834585D009706CA2D2AF418", hash_generated_method = "8D3DFC7F6D791383C18A73C74B7E4296")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        {
            boolean var1D7F719072B8014BED2A17093F1A158E_568259158 = (this.isEmpty());
        } //End collapsed parenthetic
        StringBuffer encoding;
        encoding = new StringBuffer();
        ListIterator iterator;
        iterator = this.listIterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_1934352374 = (iterator.hasNext());
            {
                {
                    Object obj;
                    obj = iterator.next();
                    {
                        GenericObject gobj;
                        gobj = (GenericObject) obj;
                        encoding.append(gobj.encode());
                    } //End block
                    {
                        encoding.append(obj.toString());
                    } //End block
                    {
                        boolean var084ACAAA0951413540CCF629674B7133_12245764 = (iterator.hasNext());
                        encoding.append(separator);
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        String varB81683B37658DAABB0D3F9E81B4869CA_2036508270 = (encoding.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.570 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "E30704FB6A5CB856F426416810715EFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var002E8E97D996E9DD2E7B0E1B0BD6187C_1858363085 = (this.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.570 -0400", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "D862496356B3061AD2F8154E98D5F9E9")
    @DSModeled(DSC.SAFE)
    public void setSeparator(String sep) {
        dsTaint.addTaint(sep);
        // ---------- Original Method ----------
        //separator = sep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.570 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "185EDAC5AB20B1FD6242011A86768FC4")
    @DSModeled(DSC.SAFE)
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.571 -0400", hash_original_method = "DCC9B19E3EEEE0A135F8C5BB2CAD40B2", hash_generated_method = "1EC171FA3E702C54458C4D0AF4496D05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1685324802 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        GenericObjectList that;
        that = (GenericObjectList) other;
        {
            boolean varC5F003D93400649B46ACEC0E9A45D583_1202050467 = (this.size() != that.size());
        } //End collapsed parenthetic
        ListIterator myIterator;
        myIterator = this.listIterator();
        {
            boolean varFB6DFDDCD7C700577DEE9179A940D983_27056038 = (myIterator.hasNext());
            {
                Object myobj;
                myobj = myIterator.next();
                ListIterator hisIterator;
                hisIterator = that.listIterator();
                try 
                {
                    {
                        Object hisobj;
                        hisobj = hisIterator.next();
                        {
                            boolean var31EF35700475AAC69F106301C55DB767_111491572 = (myobj.equals(hisobj));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                catch (NoSuchElementException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        ListIterator hisIterator;
        hisIterator = that.listIterator();
        {
            boolean var14744BA6BE00121ED4F7CCB430169829_1510087258 = (hisIterator.hasNext());
            {
                Object hisobj;
                hisobj = hisIterator.next();
                myIterator = this.listIterator();
                try 
                {
                    {
                        Object myobj;
                        myobj = myIterator.next();
                        {
                            boolean varBF165D56AEE6C0E267789322B360FF5A_1535407329 = (hisobj.equals(myobj));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                catch (NoSuchElementException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.571 -0400", hash_original_method = "28715ED51BABD0145D8C6E4EC8A7426B", hash_generated_method = "0A86C33D73C73BC39F175155513388C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1361297342 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        GenericObjectList that;
        that = (GenericObjectList) other;
        ListIterator hisIterator;
        hisIterator = that.listIterator();
        {
            boolean var14744BA6BE00121ED4F7CCB430169829_873010033 = (hisIterator.hasNext());
            {
                Object hisobj;
                hisobj = hisIterator.next();
                Object myobj;
                myobj = null;
                ListIterator myIterator;
                myIterator = this.listIterator();
                {
                    boolean varD5E6DF5633A3114BE24A99A74BF474A6_972098631 = (myIterator.hasNext());
                    {
                        myobj = myIterator.next();
                        System.out.println("Trying to match  = "
                            + ((GenericObject) myobj).encode());
                        {
                            boolean var516BE30BFC9F252D4E729F8E323E27C0_222549349 = (GenericObject.isMySubclass(myobj.getClass())
                        && ((GenericObject) myobj).match(hisobj));
                            {
                                boolean var33EFDB01AD39D43E10E7BCABA3F356FC_2001524555 = (GenericObjectList.isMySubclass(myobj.getClass())
                        && ((GenericObjectList) myobj).match(hisobj));
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                System.out.println(((GenericObject) hisobj).encode());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected static final String SEMICOLON = Separators.SEMICOLON;
    protected static final String COLON = Separators.COLON;
    protected static final String COMMA = Separators.COMMA;
    protected static final String SLASH = Separators.SLASH;
    protected static final String SP = Separators.SP;
    protected static final String EQUALS = Separators.EQUALS;
    protected static final String STAR = Separators.STAR;
    protected static final String NEWLINE = Separators.NEWLINE;
    protected static final String RETURN = Separators.RETURN;
    protected static final String LESS_THAN = Separators.LESS_THAN;
    protected static final String GREATER_THAN = Separators.GREATER_THAN;
    protected static final String AT = Separators.AT;
    protected static final String DOT = Separators.DOT;
    protected static final String QUESTION = Separators.QUESTION;
    protected static final String POUND = Separators.POUND;
    protected static final String AND = Separators.AND;
    protected static final String LPAREN = Separators.LPAREN;
    protected static final String RPAREN = Separators.RPAREN;
    protected static final String DOUBLE_QUOTE = Separators.DOUBLE_QUOTE;
    protected static final String QUOTE = Separators.QUOTE;
    protected static final String HT = Separators.HT;
    protected static final String PERCENT = Separators.PERCENT;
}

