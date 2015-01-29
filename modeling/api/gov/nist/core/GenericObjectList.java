package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public abstract class GenericObjectList extends LinkedList<GenericObject> implements Serializable, Cloneable {

    /**
     * Return true if this supports reflection based cloning.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.254 -0500", hash_original_method = "CFA8E7173C316A6185A16AC0AD3BD82D", hash_generated_method = "982BEC399A623C2171E6862AD67A8EC5")
    
protected static boolean isCloneable(Object obj) {
        return obj instanceof Cloneable;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.257 -0500", hash_original_method = "E0D5710BB1ED9BA8C800995C0FB6C90F", hash_generated_method = "E01669296DC952C242F4AFF5B12AB742")
    
public static boolean isMySubclass(Class<?> other) {
        return GenericObjectList.class.isAssignableFrom(other);

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.179 -0500", hash_original_field = "E9205B48E353C2B1F4B96A83A943F3A0", hash_generated_field = "02EC968BA435084EE7ADC81279AB56D8")

    protected static final String SEMICOLON = Separators.SEMICOLON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.182 -0500", hash_original_field = "D77BD2C56F0ED05DF3619D69EC5649F2", hash_generated_field = "6B6A3C0E5AAA12BC4230EF790A3C2476")

    protected static final String COLON = Separators.COLON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.185 -0500", hash_original_field = "5201C3D18F11737A5DD3460775E883ED", hash_generated_field = "2C4A8D03DDB954D51E978CD8F8E2DEA4")

    protected static final String COMMA = Separators.COMMA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.188 -0500", hash_original_field = "0C18FFF75A726C363F0DB6D598A8E1AD", hash_generated_field = "8A50D691E37AC9254B7ED2ABCE4AC6D2")

    protected static final String SLASH = Separators.SLASH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.191 -0500", hash_original_field = "0F465C1A1C5914A9212A6C1DC851E9B7", hash_generated_field = "0CF03E9FD9212362B2D202A36124051A")

    protected static final String SP = Separators.SP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.193 -0500", hash_original_field = "2DB7282116447C711C852E29F65C28C9", hash_generated_field = "AD22F298E6FF482BE0BD697358901610")

    protected static final String EQUALS = Separators.EQUALS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.196 -0500", hash_original_field = "16A0EB1F3341F8778CCE9E8B90D6DDE3", hash_generated_field = "2A5C8D44567A1C68D53F48B0CD1AF72E")

    protected static final String STAR = Separators.STAR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.199 -0500", hash_original_field = "535F896CBCDC67C062AECC6B8D97F82B", hash_generated_field = "99D8C532EFD2EC03350A98B152CEDB7F")

    protected static final String NEWLINE = Separators.NEWLINE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.201 -0500", hash_original_field = "CE823ACDDD84129449B4E21BF2FF83A6", hash_generated_field = "5E44FE20A9580182CC4CE4836B87D2F2")

    protected static final String RETURN = Separators.RETURN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.203 -0500", hash_original_field = "D15F62FC9A8937755EA0BA75161B9A7F", hash_generated_field = "03472463E2EA98D819ECAC54647D9EEB")

    protected static final String LESS_THAN = Separators.LESS_THAN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.206 -0500", hash_original_field = "3D37A32BEC186FF520FFD38791BDF5EF", hash_generated_field = "EADC9D4C7F8A41AC9253B4399DD9CC22")

    protected static final String GREATER_THAN = Separators.GREATER_THAN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.208 -0500", hash_original_field = "DAEDC9E484E5315814F455409686FE3F", hash_generated_field = "94E22BF70767B9E5F90C8BEFB48DFB31")

    protected static final String AT = Separators.AT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.211 -0500", hash_original_field = "09B222C8B655C77BFC9278CC42ED844D", hash_generated_field = "C68E946646D329E00948C391567E8245")

    protected static final String DOT = Separators.DOT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.214 -0500", hash_original_field = "E6FD69D5C38CE5CD44E0697BF8DED97D", hash_generated_field = "C6F6498E0BEB8E9B929D5FF0691C60C5")

    protected static final String QUESTION = Separators.QUESTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.216 -0500", hash_original_field = "6CCD01656CADA37CEC29F4F620E7B103", hash_generated_field = "3931FF01A0452F4B915432DFE1D8342B")

    protected static final String POUND = Separators.POUND;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.219 -0500", hash_original_field = "3BD4DCA47A0CF037479AC0875C12BF09", hash_generated_field = "A7C8E60A9ACCF4FC95E42A6FE3CBE98A")

    protected static final String AND = Separators.AND;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.222 -0500", hash_original_field = "C0F5D3F991B86901594C17F73AE21724", hash_generated_field = "96B1BA6A04896DF507DBF5F6007D53FF")

    protected static final String LPAREN = Separators.LPAREN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.224 -0500", hash_original_field = "EBA28B5ABEF9F9C40189523E5809ACE7", hash_generated_field = "04E1EDA33DBBA7B9CD0B5320DA6E2B15")

    protected static final String RPAREN = Separators.RPAREN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.227 -0500", hash_original_field = "A3D0DB312B6F76C52BC72B77300EB77C", hash_generated_field = "60970C4DF02E2922FFB2BB3FCBF1CC4C")

    protected static final String DOUBLE_QUOTE = Separators.DOUBLE_QUOTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.229 -0500", hash_original_field = "A012C2C89C3BC94350D794BCFAA61AC6", hash_generated_field = "36D2B8942300A11E9A202D488BEEC708")

    protected static final String QUOTE = Separators.QUOTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.233 -0500", hash_original_field = "46C5ABFAF9FA93391F615FBAF29CAF5D", hash_generated_field = "EE0F746E0ADCCF78C293F0BC27A024C1")

    protected static final String HT = Separators.HT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.235 -0500", hash_original_field = "CFBF7772290813FB9E7FE633CE7D8D3B", hash_generated_field = "E525B1F947054DAAB71F0D7018A0312F")

    protected static final String PERCENT = Separators.PERCENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.238 -0500", hash_original_field = "286452610CAD998336F0009181E4D242", hash_generated_field = "3BB4EF50B1D217FA88F0841635612381")

    protected int indentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.240 -0500", hash_original_field = "D297A5BE89C59BA85D80C2C4FEA0872D", hash_generated_field = "DD964F0DE507D319881A894372709801")

    protected String listName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.242 -0500", hash_original_field = "4CE552E89796E653DFEF03D5B5F8A2E4", hash_generated_field = "B16F5FE53C476D2E6CEFB884C718A580")

    private ListIterator<? extends GenericObject> myListIterator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.245 -0500", hash_original_field = "E3930F4F4617B35851A6540EEE3F9D12", hash_generated_field = "A7CB93AD593788A74C76D77C24510B38")

    private String stringRep;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.247 -0500", hash_original_field = "C5E8A5EA76A2850F600B14EA78D9A124", hash_generated_field = "2318E7DEB97DCC58ED55C9B3D6EA868C")

    protected Class<?> myClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.250 -0500", hash_original_field = "9B5B4672FF037607BB8CCE0F5B6469A8", hash_generated_field = "05ABC643E14669ABD06E074989E55128")

    protected String separator;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.265 -0500", hash_original_method = "B4C0906D853ADC385414EECD7EA637D1", hash_generated_method = "98933C3BD03DC1FC95EBBE8EE8A04F02")
    
protected GenericObjectList() {
        super();
        listName = null;
        stringRep = "";
        separator = ";";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.268 -0500", hash_original_method = "8E04C29D2DF262A7362105153E637B6F", hash_generated_method = "AAC923BB4F493C520062444776C6A860")
    
protected GenericObjectList(String lname) {
        this();
        listName = lname;
    }

    /**
     * A Constructor which takes a list name and a class name (for assertion
     * checking).
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.270 -0500", hash_original_method = "F5DC2C4EC43CFECAAD740ADD55431DC9", hash_generated_method = "8D8F80B72BA8E731BDBF89001ED6833D")
    
protected GenericObjectList(String lname, String classname) {
        this(lname);
        try {
            myClass = Class.forName(classname);
        } catch (ClassNotFoundException ex) {
            InternalErrorHandler.handleException(ex);
        }

    }

    /**
     * A Constructor which takes a list name and a class (for assertion
     * checking).
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.273 -0500", hash_original_method = "4BFA114444B30544264252F06586D600", hash_generated_method = "C4BC92C768C5E2AB7E36223341CC5243")
    
protected GenericObjectList(String lname, Class objclass) {
        this(lname);
        myClass = objclass;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.252 -0500", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "BDD6C135FB07D8AC261FA4D2B4D2AE55")
    
protected String getIndentation() {
        char[] chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
        return new String(chars);
    }

    /**
     * Makes a deep clone of this list.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.260 -0500", hash_original_method = "6368B146C50DA8D7E84E7623E4D72233", hash_generated_method = "B7D1CA39FA0521F03A0F238F949058BF")
    
public Object clone() {
        GenericObjectList retval = (GenericObjectList) super.clone();
        for (ListIterator<GenericObject> iter = retval.listIterator(); iter.hasNext();) {
            GenericObject obj = (GenericObject) ((GenericObject) iter.next())
                    .clone();
            iter.set(obj);
        }
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.262 -0500", hash_original_method = "D0155A1FF97450AAAC485CBFCA9B9151", hash_generated_method = "A11BD1437B6BC8AABD9C2F09BD1E0F63")
    
public void setMyClass(Class cl) {
        myClass = cl;
    }

    /**
     * Traverse the list given a list iterator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.275 -0500", hash_original_method = "04D90EEE60FDC73EE04A6B692FFCF48F", hash_generated_method = "250E2660CAE3575A411DFE433B4B88BA")
    
protected GenericObject next(ListIterator iterator) {
        try {
            return (GenericObject) iterator.next();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    /**
     * This is the default list iterator.This will not handle nested list
     * traversal.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.278 -0500", hash_original_method = "0C810F8EA313238CAFFD85BD22D89FC5", hash_generated_method = "AFD6F572F23AF378CFA4C5B1328320AA")
    
protected GenericObject first() {
        myListIterator = this.listIterator(0);
        try {
            return (GenericObject) myListIterator.next();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    /**
     * Fetch the next object from the list based on the default list iterator
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.280 -0500", hash_original_method = "F8FE3E2E9328224EF7348B82C4E16D5E", hash_generated_method = "AFAE8ADCD6DB00463035671A4D87ECE4")
    
protected GenericObject next() {
        if (myListIterator == null) {
            myListIterator = this.listIterator(0);
        }
        try {
            return (GenericObject) myListIterator.next();
        } catch (NoSuchElementException ex) {
            myListIterator = null;
            return null;
        }
    }

    /**
     * Concatenate two compatible header lists, adding the argument to the tail
     * end of this list.
     *
     * @param <var>
     *            topFlag </var> set to true to add items to top of list
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.284 -0500", hash_original_method = "36818B2036C6B7283455BB1B552EEC9B", hash_generated_method = "CE4DDF68E4EED0FB90561C93A6EDF765")
    
protected void concatenate(GenericObjectList objList) {
        concatenate(objList, false);
    }

    /**
     * Concatenate two compatible header lists, adding the argument either to
     * the beginning or the tail end of this list. A type check is done before
     * concatenation.
     *
     * @param <var>
     *            topFlag </var> set to true to add items to top of list else
     *            add them to the tail end of the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.286 -0500", hash_original_method = "08F2996E575B7D53E4C32324607C70EA", hash_generated_method = "128457AC2502CFA879226F57DFFA3530")
    
protected void concatenate(GenericObjectList objList, boolean topFlag) {
        if (!topFlag) {
            this.addAll(objList);
        } else {
            // add given items to the top end of the list.
            this.addAll(0, objList);
        }
    }

    /**
     * string formatting function.
     */

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.289 -0500", hash_original_method = "ECC7081A6DE8800C166F28F2C3CCF64F", hash_generated_method = "E94C817CC8C9F29453DBE88B124726A3")
    
private void sprint(String s) {
        if (s == null) {
            stringRep += getIndentation();
            stringRep += "<null>\n";
            return;
        }

        if (s.compareTo("}") == 0 || s.compareTo("]") == 0) {
            indentation--;
        }
        stringRep += getIndentation();
        stringRep += s;
        stringRep += "\n";
        if (s.compareTo("{") == 0 || s.compareTo("[") == 0) {
            indentation++;
        }
    }

    /**
     * Convert this list of headers to a formatted string.
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.291 -0500", hash_original_method = "373CBEDF2A2DC4BB05F4307048ABF6D6", hash_generated_method = "5BD5F6C67C2B829D72164C4552A43708")
    
public String debugDump() {
        stringRep = "";
        Object obj = this.first();
        if (obj == null)
            return "<null>";
        sprint("listName:");
        sprint(listName);
        sprint("{");
        while (obj != null) {
            sprint("[");
            sprint(((GenericObject) obj).debugDump(this.indentation));
            obj = next();
            sprint("]");
        }
        sprint("}");
        return stringRep;
    }

    /**
     * Convert this list of headers to a string (for printing) with an
     * indentation given.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.293 -0500", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "17B15A15CB497DC07A940E8E9144F966")
    
public String debugDump(int indent) {
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
        return retval;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.296 -0500", hash_original_method = "8D0C02EDD4F71C5F926965BFB69DF22C", hash_generated_method = "46F773468751215CA4E460621B9F4670")
    
public void addFirst(GenericObject objToAdd) {
        if (myClass == null) {
            myClass = objToAdd.getClass();
        } else {
            super.addFirst(objToAdd);
        }
    }

    /**
     * Do a merge of the GenericObjects contained in this list with the
     * GenericObjects in the mergeList. Note that this does an inplace
     * modification of the given list. This does an object by object merge of
     * the given objects.
     *
     * @param mergeList
     *            is the list of Generic objects that we want to do an object by
     *            object merge with. Note that no new objects are added to this
     *            list.
     *
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.298 -0500", hash_original_method = "FBFEF7110940F0EF7EB32E6578ACD520", hash_generated_method = "A050AFE5094C9C9796FE3C7FF3EBCFED")
    
public void mergeObjects(GenericObjectList mergeList) {

        if (mergeList == null)
            return;
        Iterator it1 = this.listIterator();
        Iterator it2 = mergeList.listIterator();
        while (it1.hasNext()) {
            GenericObject outerObj = (GenericObject) it1.next();
            while (it2.hasNext()) {
                Object innerObj = it2.next();
                outerObj.merge(innerObj);
            }
        }
    }

    /**
     * Encode the list in semicolon separated form.
     *
     * @return an encoded string containing the objects in this list.
     * @since v1.0
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.301 -0500", hash_original_method = "CDD824836834585D009706CA2D2AF418", hash_generated_method = "6D4D32194769A9F3D2B691D031B40991")
    
public String encode() {
        if (this.isEmpty())
            return "";
        StringBuffer encoding = new StringBuffer();
        ListIterator iterator = this.listIterator();
        if (iterator.hasNext()) {
            while (true) {
                Object obj = iterator.next();
                if (obj instanceof GenericObject) {
                    GenericObject gobj = (GenericObject) obj;
                    encoding.append(gobj.encode());
                } else {
                    encoding.append(obj.toString());
                }
                if (iterator.hasNext())
                    encoding.append(separator);
                else
                    break;
            }
        }
        return encoding.toString();
    }

    /**
     * Alias for the encode function above.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.304 -0500", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "0E38B803B5F7EA7FC3B7A952B8C48B78")
    
public String toString() {
        return this.encode();
    }

    /**
     * Set the separator (for encoding the list)
     *
     * @since v1.0
     * @param sep
     *            is the new seperator (default is semicolon)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.306 -0500", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "D87967DCDD8E0E00119098F0EC7FFAEC")
    
public void setSeparator(String sep) {
        separator = sep;
    }
    
    /**
     * Hash code. We never expect to put this in a hash table so return a constant.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.308 -0500", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "89015D45CAD68D7E33CD395D18D709AD")
    
public int hashCode() { return 42; }

    /**
     * Equality checking predicate.
     *
     * @param other
     *            is the object to compare ourselves to.
     * @return true if the objects are equal.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.311 -0500", hash_original_method = "DCC9B19E3EEEE0A135F8C5BB2CAD40B2", hash_generated_method = "9D51ADDE99D51277AE98584BD2113C3D")
    
public boolean equals(Object other) {
        if (other == null ) return false;
        if (!this.getClass().equals(other.getClass()))
            return false;
        GenericObjectList that = (GenericObjectList) other;
        if (this.size() != that.size())
            return false;
        ListIterator myIterator = this.listIterator();
        while (myIterator.hasNext()) {
            Object myobj = myIterator.next();
            ListIterator hisIterator = that.listIterator();
            try {
                while (true) {
                    Object hisobj = hisIterator.next();
                    if (myobj.equals(hisobj))
                        break;
                }
            } catch (NoSuchElementException ex) {
                return false;
            }
        }
        ListIterator hisIterator = that.listIterator();
        while (hisIterator.hasNext()) {
            Object hisobj = hisIterator.next();
            myIterator = this.listIterator();
            try {
                while (true) {
                    Object myobj = myIterator.next();
                    if (hisobj.equals(myobj))
                        break;
                }
            } catch (NoSuchElementException ex) {
                return false;
            }
        }
        return true;
    }

    /**
     * Match with a template (return true if we have a superset of the given
     * template. This can be used for partial match (template matching of SIP
     * objects). Note -- this implementation is not unnecessarily efficient :-)
     *
     * @param other
     *            template object to compare against.
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.314 -0500", hash_original_method = "28715ED51BABD0145D8C6E4EC8A7426B", hash_generated_method = "A5AEC7C9FB9724C8F7496171A4624E6F")
    
public boolean match(Object other) {
        if (!this.getClass().equals(other.getClass()))
            return false;
        GenericObjectList that = (GenericObjectList) other;
        ListIterator hisIterator = that.listIterator();
        outer: while (hisIterator.hasNext()) {
            Object hisobj = hisIterator.next();
            Object myobj = null;
            ListIterator myIterator = this.listIterator();
            while (myIterator.hasNext()) {
                myobj = myIterator.next();
                if (myobj instanceof GenericObject)
                    System.out.println("Trying to match  = "
                            + ((GenericObject) myobj).encode());
                if (GenericObject.isMySubclass(myobj.getClass())
                        && ((GenericObject) myobj).match(hisobj))
                    break outer;
                else if (GenericObjectList.isMySubclass(myobj.getClass())
                        && ((GenericObjectList) myobj).match(hisobj))
                    break outer;
            }
            System.out.println(((GenericObject) hisobj).encode());
            return false;
        }
        return true;
    }
}

