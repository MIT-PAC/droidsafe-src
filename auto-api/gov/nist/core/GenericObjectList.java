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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.412 -0400", hash_original_field = "449072E30B43D04B744F22522A880818", hash_generated_field = "3BB4EF50B1D217FA88F0841635612381")

    protected int indentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.412 -0400", hash_original_field = "E1C39316D16E130F949719C63453172F", hash_generated_field = "DD964F0DE507D319881A894372709801")

    protected String listName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.412 -0400", hash_original_field = "486A6191A59171CAF7B24C9D7EEF82B2", hash_generated_field = "B16F5FE53C476D2E6CEFB884C718A580")

    private ListIterator<? extends GenericObject> myListIterator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.413 -0400", hash_original_field = "40419C36198E2BF68491607F3BBDC619", hash_generated_field = "A7CB93AD593788A74C76D77C24510B38")

    private String stringRep;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.413 -0400", hash_original_field = "D0509468108F68C610DFF430648FE029", hash_generated_field = "2318E7DEB97DCC58ED55C9B3D6EA868C")

    protected Class<?> myClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.413 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "05ABC643E14669ABD06E074989E55128")

    protected String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.413 -0400", hash_original_method = "B4C0906D853ADC385414EECD7EA637D1", hash_generated_method = "4A8976BAB43057C94B303DF0AF3F3720")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.413 -0400", hash_original_method = "8E04C29D2DF262A7362105153E637B6F", hash_generated_method = "8CCE918BF37E1EBCCE0CDCFB3626393F")
    protected  GenericObjectList(String lname) {
        this();
        listName = lname;
        // ---------- Original Method ----------
        //listName = lname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.414 -0400", hash_original_method = "F5DC2C4EC43CFECAAD740ADD55431DC9", hash_generated_method = "173A72EFABD3A90552E8969377480523")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.414 -0400", hash_original_method = "4BFA114444B30544264252F06586D600", hash_generated_method = "E7613D355DEBA02F1873D7850A3AAE84")
    protected  GenericObjectList(String lname, Class objclass) {
        this(lname);
        myClass = objclass;
        addTaint(lname.getTaint());
        // ---------- Original Method ----------
        //myClass = objclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.415 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "3F09348B57C9AAD1025F63F6DADF33D2")
    protected String getIndentation() {
        String varB4EAC82CA7396A68D541C85D26508E83_1448586972 = null; //Variable for return #1
        char[] chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
        varB4EAC82CA7396A68D541C85D26508E83_1448586972 = new String(chars);
        varB4EAC82CA7396A68D541C85D26508E83_1448586972.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1448586972;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.416 -0400", hash_original_method = "6368B146C50DA8D7E84E7623E4D72233", hash_generated_method = "D2CDFC4551397CB00892AE6951073B17")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1714357277 = null; //Variable for return #1
        GenericObjectList retval = (GenericObjectList) super.clone();
        {
            ListIterator<GenericObject> iter = retval.listIterator();
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1841479468 = (iter.hasNext());
            {
                GenericObject obj = (GenericObject) ((GenericObject) iter.next())
                    .clone();
                iter.set(obj);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1714357277 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1714357277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1714357277;
        // ---------- Original Method ----------
        //GenericObjectList retval = (GenericObjectList) super.clone();
        //for (ListIterator<GenericObject> iter = retval.listIterator(); iter.hasNext();) {
            //GenericObject obj = (GenericObject) ((GenericObject) iter.next())
                    //.clone();
            //iter.set(obj);
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.416 -0400", hash_original_method = "D0155A1FF97450AAAC485CBFCA9B9151", hash_generated_method = "CD555D9A7A572ADB1416682B5064D9A7")
    public void setMyClass(Class cl) {
        myClass = cl;
        // ---------- Original Method ----------
        //myClass = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.417 -0400", hash_original_method = "04D90EEE60FDC73EE04A6B692FFCF48F", hash_generated_method = "B365845FB8EB4126793CCDD4836CCA8B")
    protected GenericObject next(ListIterator iterator) {
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_997651163 = null; //Variable for return #1
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_1855921489 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_997651163 = (GenericObject) iterator.next();
        } //End block
        catch (NoSuchElementException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1855921489 = null;
        } //End block
        addTaint(iterator.getTaint());
        GenericObject varA7E53CE21691AB073D9660D615818899_1914060107; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1914060107 = varB4EAC82CA7396A68D541C85D26508E83_997651163;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1914060107 = varB4EAC82CA7396A68D541C85D26508E83_1855921489;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1914060107.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1914060107;
        // ---------- Original Method ----------
        //try {
            //return (GenericObject) iterator.next();
        //} catch (NoSuchElementException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.418 -0400", hash_original_method = "0C810F8EA313238CAFFD85BD22D89FC5", hash_generated_method = "1009601FCE0AB2ADB2F2184F4309415D")
    protected GenericObject first() {
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_1926718647 = null; //Variable for return #1
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_1761765298 = null; //Variable for return #2
        myListIterator = this.listIterator(0);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1926718647 = (GenericObject) myListIterator.next();
        } //End block
        catch (NoSuchElementException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1761765298 = null;
        } //End block
        GenericObject varA7E53CE21691AB073D9660D615818899_647480139; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_647480139 = varB4EAC82CA7396A68D541C85D26508E83_1926718647;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_647480139 = varB4EAC82CA7396A68D541C85D26508E83_1761765298;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_647480139.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_647480139;
        // ---------- Original Method ----------
        //myListIterator = this.listIterator(0);
        //try {
            //return (GenericObject) myListIterator.next();
        //} catch (NoSuchElementException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.419 -0400", hash_original_method = "F8FE3E2E9328224EF7348B82C4E16D5E", hash_generated_method = "46C097EB5F6A68B5DE30116074CF7A51")
    protected GenericObject next() {
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_57723205 = null; //Variable for return #1
        GenericObject varB4EAC82CA7396A68D541C85D26508E83_607372599 = null; //Variable for return #2
        {
            myListIterator = this.listIterator(0);
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_57723205 = (GenericObject) myListIterator.next();
        } //End block
        catch (NoSuchElementException ex)
        {
            myListIterator = null;
            varB4EAC82CA7396A68D541C85D26508E83_607372599 = null;
        } //End block
        GenericObject varA7E53CE21691AB073D9660D615818899_1050603363; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1050603363 = varB4EAC82CA7396A68D541C85D26508E83_57723205;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1050603363 = varB4EAC82CA7396A68D541C85D26508E83_607372599;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1050603363.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1050603363;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.419 -0400", hash_original_method = "36818B2036C6B7283455BB1B552EEC9B", hash_generated_method = "FAD4864A88E7110A131923F8207E0DF9")
    protected void concatenate(GenericObjectList objList) {
        concatenate(objList, false);
        addTaint(objList.getTaint());
        // ---------- Original Method ----------
        //concatenate(objList, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.420 -0400", hash_original_method = "08F2996E575B7D53E4C32324607C70EA", hash_generated_method = "41F5BFAFBA3A45ED24FC29D80EF8EE24")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.420 -0400", hash_original_method = "ECC7081A6DE8800C166F28F2C3CCF64F", hash_generated_method = "6D8118768011FEF3BC121DD338F348DD")
    private void sprint(String s) {
        {
            stringRep += getIndentation();
            stringRep += "<null>\n";
        } //End block
        {
            boolean varA6F9A9C7F2A0D695BD6817517FAC5713_1966298734 = (s.compareTo("}") == 0 || s.compareTo("]") == 0);
        } //End collapsed parenthetic
        stringRep += getIndentation();
        stringRep += s;
        stringRep += "\n";
        {
            boolean varE8A8307BD18B90A33CD1A32B530393A9_2109106961 = (s.compareTo("{") == 0 || s.compareTo("[") == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.421 -0400", hash_original_method = "373CBEDF2A2DC4BB05F4307048ABF6D6", hash_generated_method = "05F61DBF5770353D11F3D3F026BA7C0E")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_95221678 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1368681339 = null; //Variable for return #2
        stringRep = "";
        Object obj = this.first();
        varB4EAC82CA7396A68D541C85D26508E83_95221678 = "<null>";
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
        varB4EAC82CA7396A68D541C85D26508E83_1368681339 = stringRep;
        String varA7E53CE21691AB073D9660D615818899_357320951; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_357320951 = varB4EAC82CA7396A68D541C85D26508E83_95221678;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_357320951 = varB4EAC82CA7396A68D541C85D26508E83_1368681339;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_357320951.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_357320951;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.422 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "4064B900B2179EBD03C1110EF00EB092")
    public String debugDump(int indent) {
        String varB4EAC82CA7396A68D541C85D26508E83_422931188 = null; //Variable for return #1
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
        varB4EAC82CA7396A68D541C85D26508E83_422931188 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_422931188.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_422931188;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.422 -0400", hash_original_method = "8D0C02EDD4F71C5F926965BFB69DF22C", hash_generated_method = "5748DCF8BF3EE9052F8033B002B9570E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.422 -0400", hash_original_method = "FBFEF7110940F0EF7EB32E6578ACD520", hash_generated_method = "7CF416E6EDD798001DD78A1A55645421")
    public void mergeObjects(GenericObjectList mergeList) {
        Iterator it1 = this.listIterator();
        Iterator it2 = mergeList.listIterator();
        {
            boolean var67770E0E57A782FE24004C8EDF43E6C4_816282884 = (it1.hasNext());
            {
                GenericObject outerObj = (GenericObject) it1.next();
                {
                    boolean var9C6A988161E59916E4098A1BF51C47F9_275892560 = (it2.hasNext());
                    {
                        Object innerObj = it2.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.423 -0400", hash_original_method = "CDD824836834585D009706CA2D2AF418", hash_generated_method = "7F744E259AD2A9EFD438830853CB6798")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1706600280 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_632433842 = null; //Variable for return #2
        {
            boolean var1D7F719072B8014BED2A17093F1A158E_976874536 = (this.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_1706600280 = "";
        } //End collapsed parenthetic
        StringBuffer encoding = new StringBuffer();
        ListIterator iterator = this.listIterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_2027855104 = (iterator.hasNext());
            {
                {
                    Object obj = iterator.next();
                    {
                        GenericObject gobj = (GenericObject) obj;
                        encoding.append(gobj.encode());
                    } //End block
                    {
                        encoding.append(obj.toString());
                    } //End block
                    {
                        boolean var084ACAAA0951413540CCF629674B7133_1121326637 = (iterator.hasNext());
                        encoding.append(separator);
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_632433842 = encoding.toString();
        String varA7E53CE21691AB073D9660D615818899_857809004; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_857809004 = varB4EAC82CA7396A68D541C85D26508E83_1706600280;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_857809004 = varB4EAC82CA7396A68D541C85D26508E83_632433842;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_857809004.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_857809004;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.424 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "35634E6C135980CB1B9DF7632E2C6A41")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1595625755 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1595625755 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1595625755.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1595625755;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.424 -0400", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "BE8D7A91CF35C3CE4342E681E66ABB40")
    public void setSeparator(String sep) {
        separator = sep;
        // ---------- Original Method ----------
        //separator = sep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.424 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "4DF3C94B625EEA4826D24114596B0BBC")
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489088411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489088411;
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.425 -0400", hash_original_method = "DCC9B19E3EEEE0A135F8C5BB2CAD40B2", hash_generated_method = "D3A5D0B276CE4FBD8EF8766097DAF5DA")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_632505181 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        GenericObjectList that = (GenericObjectList) other;
        {
            boolean varC5F003D93400649B46ACEC0E9A45D583_976097273 = (this.size() != that.size());
        } //End collapsed parenthetic
        ListIterator myIterator = this.listIterator();
        {
            boolean varFB6DFDDCD7C700577DEE9179A940D983_660381376 = (myIterator.hasNext());
            {
                Object myobj = myIterator.next();
                ListIterator hisIterator = that.listIterator();
                try 
                {
                    {
                        Object hisobj = hisIterator.next();
                        {
                            boolean var31EF35700475AAC69F106301C55DB767_1039500322 = (myobj.equals(hisobj));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                catch (NoSuchElementException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        ListIterator hisIterator = that.listIterator();
        {
            boolean var14744BA6BE00121ED4F7CCB430169829_523218497 = (hisIterator.hasNext());
            {
                Object hisobj = hisIterator.next();
                myIterator = this.listIterator();
                try 
                {
                    {
                        Object myobj = myIterator.next();
                        {
                            boolean varBF165D56AEE6C0E267789322B360FF5A_671859366 = (hisobj.equals(myobj));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                catch (NoSuchElementException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1331537788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1331537788;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_method = "28715ED51BABD0145D8C6E4EC8A7426B", hash_generated_method = "9514BC1A9BFD4125E6F3A77C3D22CC59")
    public boolean match(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1381553129 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        GenericObjectList that = (GenericObjectList) other;
        ListIterator hisIterator = that.listIterator();
        {
            boolean var14744BA6BE00121ED4F7CCB430169829_939377998 = (hisIterator.hasNext());
            {
                Object hisobj = hisIterator.next();
                Object myobj = null;
                ListIterator myIterator = this.listIterator();
                {
                    boolean varD5E6DF5633A3114BE24A99A74BF474A6_2027467589 = (myIterator.hasNext());
                    {
                        myobj = myIterator.next();
                        System.out.println("Trying to match  = "
                            + ((GenericObject) myobj).encode());
                        {
                            boolean var516BE30BFC9F252D4E729F8E323E27C0_1960048210 = (GenericObject.isMySubclass(myobj.getClass())
                        && ((GenericObject) myobj).match(hisobj));
                            {
                                boolean var33EFDB01AD39D43E10E7BCABA3F356FC_1968636759 = (GenericObjectList.isMySubclass(myobj.getClass())
                        && ((GenericObjectList) myobj).match(hisobj));
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                System.out.println(((GenericObject) hisobj).encode());
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_812679040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_812679040;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "D1190824E35A683C05589F1C776EEB98", hash_generated_field = "02EC968BA435084EE7ADC81279AB56D8")

    protected static final String SEMICOLON = Separators.SEMICOLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "02A534AF21A6F783F08D86D26579E890", hash_generated_field = "6B6A3C0E5AAA12BC4230EF790A3C2476")

    protected static final String COLON = Separators.COLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "6C852D8F8039F1F9747489612DAC3C3C", hash_generated_field = "2C4A8D03DDB954D51E978CD8F8E2DEA4")

    protected static final String COMMA = Separators.COMMA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "04C5392343613D1101130F746A81D0F3", hash_generated_field = "8A50D691E37AC9254B7ED2ABCE4AC6D2")

    protected static final String SLASH = Separators.SLASH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "D8EE4E7D0F1EAB2E2745753B5AD2FE8D", hash_generated_field = "0CF03E9FD9212362B2D202A36124051A")

    protected static final String SP = Separators.SP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "3C7C6B82B012EBDA39975B1F72983C28", hash_generated_field = "AD22F298E6FF482BE0BD697358901610")

    protected static final String EQUALS = Separators.EQUALS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "B9D394806A580E8DE8984E11AC02BDE2", hash_generated_field = "2A5C8D44567A1C68D53F48B0CD1AF72E")

    protected static final String STAR = Separators.STAR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "4B65D6BACAFDD7AB302810256C42CCB9", hash_generated_field = "99D8C532EFD2EC03350A98B152CEDB7F")

    protected static final String NEWLINE = Separators.NEWLINE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "4E25B108371C30F889E1B6E8C1046FAB", hash_generated_field = "5E44FE20A9580182CC4CE4836B87D2F2")

    protected static final String RETURN = Separators.RETURN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "7E16A38DE053150CC3BF00FEBC32CBB3", hash_generated_field = "03472463E2EA98D819ECAC54647D9EEB")

    protected static final String LESS_THAN = Separators.LESS_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "CBC3FB6A2E3BC245B189168F8F698149", hash_generated_field = "EADC9D4C7F8A41AC9253B4399DD9CC22")

    protected static final String GREATER_THAN = Separators.GREATER_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "72EE65D27F762C3B2FB94C3FA334B5E4", hash_generated_field = "94E22BF70767B9E5F90C8BEFB48DFB31")

    protected static final String AT = Separators.AT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "3ACE38B8B42CCCDC519BBD9065EB1D1A", hash_generated_field = "C68E946646D329E00948C391567E8245")

    protected static final String DOT = Separators.DOT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "B2A15792014FB9077E86DD721A8EFBA4", hash_generated_field = "C6F6498E0BEB8E9B929D5FF0691C60C5")

    protected static final String QUESTION = Separators.QUESTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "096D0F7D4D4C7B4283D714ECD7F549C3", hash_generated_field = "3931FF01A0452F4B915432DFE1D8342B")

    protected static final String POUND = Separators.POUND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "705C7DB0DE742246702AC85CCAA66A2B", hash_generated_field = "A7C8E60A9ACCF4FC95E42A6FE3CBE98A")

    protected static final String AND = Separators.AND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "B7554C14B11FFE96B375109E44C62935", hash_generated_field = "96B1BA6A04896DF507DBF5F6007D53FF")

    protected static final String LPAREN = Separators.LPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "ED8913C274C5CDFEFC62F7A7FE2688CB", hash_generated_field = "04E1EDA33DBBA7B9CD0B5320DA6E2B15")

    protected static final String RPAREN = Separators.RPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "CD4D1E68FDC871F3D1A212D438F276AF", hash_generated_field = "60970C4DF02E2922FFB2BB3FCBF1CC4C")

    protected static final String DOUBLE_QUOTE = Separators.DOUBLE_QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "1084586CDB13332FA26836F7CE2B3817", hash_generated_field = "36D2B8942300A11E9A202D488BEEC708")

    protected static final String QUOTE = Separators.QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.426 -0400", hash_original_field = "58E3D5E258B17E5D6D1BDF83FE976FD6", hash_generated_field = "EE0F746E0ADCCF78C293F0BC27A024C1")

    protected static final String HT = Separators.HT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.427 -0400", hash_original_field = "4AEF06B345694E240504FA11CF16C815", hash_generated_field = "E525B1F947054DAAB71F0D7018A0312F")

    protected static final String PERCENT = Separators.PERCENT;
}

