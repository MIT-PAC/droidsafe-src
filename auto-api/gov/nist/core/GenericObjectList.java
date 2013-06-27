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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.091 -0400", hash_original_field = "449072E30B43D04B744F22522A880818", hash_generated_field = "3BB4EF50B1D217FA88F0841635612381")

    protected int indentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.091 -0400", hash_original_field = "E1C39316D16E130F949719C63453172F", hash_generated_field = "DD964F0DE507D319881A894372709801")

    protected String listName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.091 -0400", hash_original_field = "486A6191A59171CAF7B24C9D7EEF82B2", hash_generated_field = "B16F5FE53C476D2E6CEFB884C718A580")

    private ListIterator<? extends GenericObject> myListIterator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.091 -0400", hash_original_field = "40419C36198E2BF68491607F3BBDC619", hash_generated_field = "A7CB93AD593788A74C76D77C24510B38")

    private String stringRep;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.091 -0400", hash_original_field = "D0509468108F68C610DFF430648FE029", hash_generated_field = "2318E7DEB97DCC58ED55C9B3D6EA868C")

    protected Class<?> myClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.091 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "05ABC643E14669ABD06E074989E55128")

    protected String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.091 -0400", hash_original_method = "B4C0906D853ADC385414EECD7EA637D1", hash_generated_method = "4A8976BAB43057C94B303DF0AF3F3720")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.092 -0400", hash_original_method = "8E04C29D2DF262A7362105153E637B6F", hash_generated_method = "8CCE918BF37E1EBCCE0CDCFB3626393F")
    protected  GenericObjectList(String lname) {
        this();
        listName = lname;
        // ---------- Original Method ----------
        //listName = lname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.092 -0400", hash_original_method = "F5DC2C4EC43CFECAAD740ADD55431DC9", hash_generated_method = "173A72EFABD3A90552E8969377480523")
    protected  GenericObjectList(String lname, String classname) {
        this(lname);
        try 
        {
            myClass = Class.forName(classname);
        } //End block
        catch (ClassNotFoundException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        addTaint(lname.getTaint());
        // ---------- Original Method ----------
        //try {
            //myClass = Class.forName(classname);
        //} catch (ClassNotFoundException ex) {
            //InternalErrorHandler.handleException(ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.092 -0400", hash_original_method = "4BFA114444B30544264252F06586D600", hash_generated_method = "E7613D355DEBA02F1873D7850A3AAE84")
    protected  GenericObjectList(String lname, Class objclass) {
        this(lname);
        myClass = objclass;
        addTaint(lname.getTaint());
        // ---------- Original Method ----------
        //myClass = objclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.093 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "D12DDCFC4ABC8572CB5217620B638B7F")
    protected String getIndentation() {
        String varB4EAC82CA7396A68D541C85D26508E83_1413582666 = null; //Variable for return #1
        char[] chars;
        chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
        varB4EAC82CA7396A68D541C85D26508E83_1413582666 = new String(chars);
        varB4EAC82CA7396A68D541C85D26508E83_1413582666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1413582666;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.094 -0400", hash_original_method = "6368B146C50DA8D7E84E7623E4D72233", hash_generated_method = "9ADE60A5BDA210CBCCC3B6E798AA53D8")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_794812490 = null; //Variable for return #1
        GenericObjectList retval;
        retval = (GenericObjectList) super.clone();
        {
            ListIterator<GenericObject> iter;
            iter = retval.listIterator();
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1035709856 = (iter.hasNext());
            {
                GenericObject obj;
                obj = (GenericObject) ((GenericObject) iter.next())
                    .clone();
                iter.set(obj);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_794812490 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_794812490.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_794812490;
        // ---------- Original Method ----------
        //GenericObjectList retval = (GenericObjectList) super.clone();
        //for (ListIterator<GenericObject> iter = retval.listIterator(); iter.hasNext();) {
            //GenericObject obj = (GenericObject) ((GenericObject) iter.next())
                    //.clone();
            //iter.set(obj);
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.094 -0400", hash_original_method = "D0155A1FF97450AAAC485CBFCA9B9151", hash_generated_method = "CD555D9A7A572ADB1416682B5064D9A7")
    public void setMyClass(Class cl) {
        myClass = cl;
        // ---------- Original Method ----------
        //myClass = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.106 -0400", hash_original_method = "04D90EEE60FDC73EE04A6B692FFCF48F", hash_generated_method = "7BD487AC0E3E90ED41C3484F272AF966")
    protected GenericObject next(ListIterator iterator) {
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_1604323115 = null; //Variable for return #1
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_1327167731 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1604323115 = (GenericObject) iterator.next();
        } //End block
        catch (NoSuchElementException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1327167731 = null;
        } //End block
        addTaint(iterator.getTaint());
        GenericObject varA7E53CE21691AB073D9660D615818899_35069320; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_35069320 = varB4EAC82CA7396A68D541C85D26508E83_1604323115;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_35069320 = varB4EAC82CA7396A68D541C85D26508E83_1327167731;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_35069320.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_35069320;
        // ---------- Original Method ----------
        //try {
            //return (GenericObject) iterator.next();
        //} catch (NoSuchElementException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.108 -0400", hash_original_method = "0C810F8EA313238CAFFD85BD22D89FC5", hash_generated_method = "0E055A9C944834F8B481D85D087F7EE5")
    protected GenericObject first() {
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_26480084 = null; //Variable for return #1
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_99679846 = null; //Variable for return #2
        myListIterator = this.listIterator(0);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_26480084 = (GenericObject) myListIterator.next();
        } //End block
        catch (NoSuchElementException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_99679846 = null;
        } //End block
        GenericObject varA7E53CE21691AB073D9660D615818899_1761640252; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1761640252 = varB4EAC82CA7396A68D541C85D26508E83_26480084;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1761640252 = varB4EAC82CA7396A68D541C85D26508E83_99679846;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1761640252.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1761640252;
        // ---------- Original Method ----------
        //myListIterator = this.listIterator(0);
        //try {
            //return (GenericObject) myListIterator.next();
        //} catch (NoSuchElementException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.108 -0400", hash_original_method = "F8FE3E2E9328224EF7348B82C4E16D5E", hash_generated_method = "BD18E215D7C31BBC0251637FA409855A")
    protected GenericObject next() {
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_1372211082 = null; //Variable for return #1
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_1633246286 = null; //Variable for return #2
        {
            myListIterator = this.listIterator(0);
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1372211082 = (GenericObject) myListIterator.next();
        } //End block
        catch (NoSuchElementException ex)
        {
            myListIterator = null;
            varB4EAC82CA7396A68D541C85D26508E83_1633246286 = null;
        } //End block
        GenericObject varA7E53CE21691AB073D9660D615818899_745755243; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_745755243 = varB4EAC82CA7396A68D541C85D26508E83_1372211082;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_745755243 = varB4EAC82CA7396A68D541C85D26508E83_1633246286;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_745755243.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_745755243;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.124 -0400", hash_original_method = "36818B2036C6B7283455BB1B552EEC9B", hash_generated_method = "FAD4864A88E7110A131923F8207E0DF9")
    protected void concatenate(GenericObjectList objList) {
        concatenate(objList, false);
        addTaint(objList.getTaint());
        // ---------- Original Method ----------
        //concatenate(objList, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.135 -0400", hash_original_method = "08F2996E575B7D53E4C32324607C70EA", hash_generated_method = "41F5BFAFBA3A45ED24FC29D80EF8EE24")
    protected void concatenate(GenericObjectList objList, boolean topFlag) {
        {
            this.addAll(objList);
        } //End block
        {
            this.addAll(0, objList);
        } //End block
        addTaint(objList.getTaint());
        addTaint(topFlag);
        // ---------- Original Method ----------
        //if (!topFlag) {
            //this.addAll(objList);
        //} else {
            //this.addAll(0, objList);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.135 -0400", hash_original_method = "ECC7081A6DE8800C166F28F2C3CCF64F", hash_generated_method = "105B1779E92431DF9D386B25558D402A")
    private void sprint(String s) {
        {
            stringRep += getIndentation();
            stringRep += "<null>\n";
        } //End block
        {
            boolean varA6F9A9C7F2A0D695BD6817517FAC5713_1364147871 = (s.compareTo("}") == 0 || s.compareTo("]") == 0);
        } //End collapsed parenthetic
        stringRep += getIndentation();
        stringRep += s;
        stringRep += "\n";
        {
            boolean varE8A8307BD18B90A33CD1A32B530393A9_1747956974 = (s.compareTo("{") == 0 || s.compareTo("[") == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.136 -0400", hash_original_method = "373CBEDF2A2DC4BB05F4307048ABF6D6", hash_generated_method = "DC4A0EED16DEECC3FF47937E2E5A7199")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_364077895 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1043716956 = null; //Variable for return #2
        stringRep = "";
        Object obj;
        obj = this.first();
        varB4EAC82CA7396A68D541C85D26508E83_364077895 = "<null>";
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
        varB4EAC82CA7396A68D541C85D26508E83_1043716956 = stringRep;
        String varA7E53CE21691AB073D9660D615818899_774749501; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_774749501 = varB4EAC82CA7396A68D541C85D26508E83_364077895;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_774749501 = varB4EAC82CA7396A68D541C85D26508E83_1043716956;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_774749501.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_774749501;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.139 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "10B8F77940632803D8D8E574A705B2F9")
    public String debugDump(int indent) {
        String varB4EAC82CA7396A68D541C85D26508E83_2002918868 = null; //Variable for return #1
        int save;
        save = indentation;
        indentation = indent;
        String retval;
        retval = this.debugDump();
        indentation = save;
        varB4EAC82CA7396A68D541C85D26508E83_2002918868 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2002918868.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2002918868;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.139 -0400", hash_original_method = "8D0C02EDD4F71C5F926965BFB69DF22C", hash_generated_method = "5748DCF8BF3EE9052F8033B002B9570E")
    public void addFirst(GenericObject objToAdd) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.140 -0400", hash_original_method = "FBFEF7110940F0EF7EB32E6578ACD520", hash_generated_method = "B0FBB1FFF4DC92A53B1EFBBAA1907A16")
    public void mergeObjects(GenericObjectList mergeList) {
        Iterator it1;
        it1 = this.listIterator();
        Iterator it2;
        it2 = mergeList.listIterator();
        {
            boolean var67770E0E57A782FE24004C8EDF43E6C4_1915208371 = (it1.hasNext());
            {
                GenericObject outerObj;
                outerObj = (GenericObject) it1.next();
                {
                    boolean var9C6A988161E59916E4098A1BF51C47F9_1621713946 = (it2.hasNext());
                    {
                        Object innerObj;
                        innerObj = it2.next();
                        outerObj.merge(innerObj);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(mergeList.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.140 -0400", hash_original_method = "CDD824836834585D009706CA2D2AF418", hash_generated_method = "FBE6CB83128300B46D3AEBA739BEEC58")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_868856559 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1344893127 = null; //Variable for return #2
        {
            boolean var1D7F719072B8014BED2A17093F1A158E_1238192657 = (this.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_868856559 = "";
        } //End collapsed parenthetic
        StringBuffer encoding;
        encoding = new StringBuffer();
        ListIterator iterator;
        iterator = this.listIterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_2070021378 = (iterator.hasNext());
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
                        boolean var084ACAAA0951413540CCF629674B7133_1541503522 = (iterator.hasNext());
                        encoding.append(separator);
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1344893127 = encoding.toString();
        String varA7E53CE21691AB073D9660D615818899_895080903; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_895080903 = varB4EAC82CA7396A68D541C85D26508E83_868856559;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_895080903 = varB4EAC82CA7396A68D541C85D26508E83_1344893127;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_895080903.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_895080903;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.141 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "4FBBA78AB7FA251D8615ACAD53468E3D")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_484717428 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_484717428 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_484717428.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_484717428;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.141 -0400", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "BE8D7A91CF35C3CE4342E681E66ABB40")
    public void setSeparator(String sep) {
        separator = sep;
        // ---------- Original Method ----------
        //separator = sep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.141 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "77F7B30E635389FB8D274FD44C8B8D87")
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363878649 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363878649;
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.142 -0400", hash_original_method = "DCC9B19E3EEEE0A135F8C5BB2CAD40B2", hash_generated_method = "3ABDEE209D86692A69C8E30FF64C40A5")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1815220148 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        GenericObjectList that;
        that = (GenericObjectList) other;
        {
            boolean varC5F003D93400649B46ACEC0E9A45D583_145351563 = (this.size() != that.size());
        } //End collapsed parenthetic
        ListIterator myIterator;
        myIterator = this.listIterator();
        {
            boolean varFB6DFDDCD7C700577DEE9179A940D983_72952736 = (myIterator.hasNext());
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
                            boolean var31EF35700475AAC69F106301C55DB767_314732131 = (myobj.equals(hisobj));
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
            boolean var14744BA6BE00121ED4F7CCB430169829_50432330 = (hisIterator.hasNext());
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
                            boolean varBF165D56AEE6C0E267789322B360FF5A_1154545319 = (hisobj.equals(myobj));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                catch (NoSuchElementException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556568391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556568391;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_method = "28715ED51BABD0145D8C6E4EC8A7426B", hash_generated_method = "F7D2F4DAA3BC845CCCF8F1C6A570152F")
    public boolean match(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_483287483 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        GenericObjectList that;
        that = (GenericObjectList) other;
        ListIterator hisIterator;
        hisIterator = that.listIterator();
        {
            boolean var14744BA6BE00121ED4F7CCB430169829_849031742 = (hisIterator.hasNext());
            {
                Object hisobj;
                hisobj = hisIterator.next();
                Object myobj;
                myobj = null;
                ListIterator myIterator;
                myIterator = this.listIterator();
                {
                    boolean varD5E6DF5633A3114BE24A99A74BF474A6_198614173 = (myIterator.hasNext());
                    {
                        myobj = myIterator.next();
                        System.out.println("Trying to match  = "
                            + ((GenericObject) myobj).encode());
                        {
                            boolean var516BE30BFC9F252D4E729F8E323E27C0_1491898721 = (GenericObject.isMySubclass(myobj.getClass())
                        && ((GenericObject) myobj).match(hisobj));
                            {
                                boolean var33EFDB01AD39D43E10E7BCABA3F356FC_1558601974 = (GenericObjectList.isMySubclass(myobj.getClass())
                        && ((GenericObjectList) myobj).match(hisobj));
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                System.out.println(((GenericObject) hisobj).encode());
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260594378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260594378;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_field = "D1190824E35A683C05589F1C776EEB98", hash_generated_field = "4B8890FBD872BF70D8F8C7F44DA52EF3")

    protected static String SEMICOLON = Separators.SEMICOLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_field = "02A534AF21A6F783F08D86D26579E890", hash_generated_field = "5BBD6AD412C5B75598187A2486B26E8A")

    protected static String COLON = Separators.COLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_field = "6C852D8F8039F1F9747489612DAC3C3C", hash_generated_field = "785D4BB980AC2C0D57607CEF4CACF0C0")

    protected static String COMMA = Separators.COMMA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_field = "04C5392343613D1101130F746A81D0F3", hash_generated_field = "966CA9FD4E3DF03CAB57666E2072AC14")

    protected static String SLASH = Separators.SLASH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_field = "D8EE4E7D0F1EAB2E2745753B5AD2FE8D", hash_generated_field = "A402605784E67C68F1024E7173E45B1B")

    protected static String SP = Separators.SP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_field = "3C7C6B82B012EBDA39975B1F72983C28", hash_generated_field = "1544A19534612AF3A94C823834760C09")

    protected static String EQUALS = Separators.EQUALS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_field = "B9D394806A580E8DE8984E11AC02BDE2", hash_generated_field = "DBB60C4C8B4DF7C5BCBF7A183A799ACB")

    protected static String STAR = Separators.STAR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_field = "4B65D6BACAFDD7AB302810256C42CCB9", hash_generated_field = "29424A3535D892C1F61E917DF2BD1016")

    protected static String NEWLINE = Separators.NEWLINE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_field = "4E25B108371C30F889E1B6E8C1046FAB", hash_generated_field = "2C3A924D81FD472B8F727FE6FF2FF522")

    protected static String RETURN = Separators.RETURN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.154 -0400", hash_original_field = "7E16A38DE053150CC3BF00FEBC32CBB3", hash_generated_field = "C71AA757DB9E1D524F2CD1751C3280BC")

    protected static String LESS_THAN = Separators.LESS_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.155 -0400", hash_original_field = "CBC3FB6A2E3BC245B189168F8F698149", hash_generated_field = "2370BD505EDC4CD3493015CD0065760D")

    protected static String GREATER_THAN = Separators.GREATER_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.155 -0400", hash_original_field = "72EE65D27F762C3B2FB94C3FA334B5E4", hash_generated_field = "0FBF28DB29147F4018595211B916920D")

    protected static String AT = Separators.AT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.155 -0400", hash_original_field = "3ACE38B8B42CCCDC519BBD9065EB1D1A", hash_generated_field = "3025CBFFD153EFAB9AE6AACDA714FF72")

    protected static String DOT = Separators.DOT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.162 -0400", hash_original_field = "B2A15792014FB9077E86DD721A8EFBA4", hash_generated_field = "D7A90F6E7785E12E4DFF4AC1D1D8875A")

    protected static String QUESTION = Separators.QUESTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.163 -0400", hash_original_field = "096D0F7D4D4C7B4283D714ECD7F549C3", hash_generated_field = "84D39FE9CC6EA2F087DAFCAAD5A16707")

    protected static String POUND = Separators.POUND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.163 -0400", hash_original_field = "705C7DB0DE742246702AC85CCAA66A2B", hash_generated_field = "2FB9D6B5E4755F98893B3E3F410DFDEE")

    protected static String AND = Separators.AND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.163 -0400", hash_original_field = "B7554C14B11FFE96B375109E44C62935", hash_generated_field = "3212B3E63C9FC51A4D07C7EC73385FF4")

    protected static String LPAREN = Separators.LPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.163 -0400", hash_original_field = "ED8913C274C5CDFEFC62F7A7FE2688CB", hash_generated_field = "EEE245D25868C238D5ADCC7FE3AC60BB")

    protected static String RPAREN = Separators.RPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.163 -0400", hash_original_field = "CD4D1E68FDC871F3D1A212D438F276AF", hash_generated_field = "3601DBFC2F02C2359E6881574222AEA7")

    protected static String DOUBLE_QUOTE = Separators.DOUBLE_QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.163 -0400", hash_original_field = "1084586CDB13332FA26836F7CE2B3817", hash_generated_field = "9467DA16C509432ABB454D6BF78F198A")

    protected static String QUOTE = Separators.QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.163 -0400", hash_original_field = "58E3D5E258B17E5D6D1BDF83FE976FD6", hash_generated_field = "254F51181EE51F41E8F8B36EA27FC73D")

    protected static String HT = Separators.HT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.163 -0400", hash_original_field = "4AEF06B345694E240504FA11CF16C815", hash_generated_field = "3E81D01A700B23F69979D20F8CEE223A")

    protected static String PERCENT = Separators.PERCENT;
}

