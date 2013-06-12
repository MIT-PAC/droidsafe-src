package java.util.prefs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charsets;
import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import libcore.io.Base64;
import libcore.util.EmptyArray;

public abstract class AbstractPreferences extends Preferences {
    private static List<EventObject> events = new LinkedList<EventObject>();
    private static EventDispatcher dispatcher = new EventDispatcher("Preference Event Dispatcher");
    boolean userNode;
    protected Object lock;
    protected boolean newNode;
    private Map<String, AbstractPreferences> cachedNode;
    private List<EventListener> nodeChangeListeners;
    private List<EventListener> preferenceChangeListeners;
    private String nodeName;
    private AbstractPreferences parentPref;
    private boolean isRemoved;
    private AbstractPreferences root;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:17.955 -0400", hash_original_method = "0807678F2729AF86B80791A672B3F67B", hash_generated_method = "39F6009160F7943B78EF82549C0C3CD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AbstractPreferences(AbstractPreferences parent, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(parent.dsTaint);
        {
            boolean varB67F0092223B9760D02A153DC786A1B5_1652769529 = ((parent == null ^ name.length() == 0) || name.indexOf("/") >= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        root = (parent == null) ? this : parent.root;
        nodeChangeListeners = new LinkedList<EventListener>();
        preferenceChangeListeners = new LinkedList<EventListener>();
        isRemoved = false;
        cachedNode = new HashMap<String, AbstractPreferences>();
        lock = new Object();
        userNode = root.userNode;
        // ---------- Original Method ----------
        //if ((parent == null ^ name.length() == 0) || name.indexOf("/") >= 0) {
            //throw new IllegalArgumentException();
        //}
        //root = (parent == null) ? this : parent.root;
        //nodeChangeListeners = new LinkedList<EventListener>();
        //preferenceChangeListeners = new LinkedList<EventListener>();
        //isRemoved = false;
        //cachedNode = new HashMap<String, AbstractPreferences>();
        //nodeName = name;
        //parentPref = parent;
        //lock = new Object();
        //userNode = root.userNode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:17.995 -0400", hash_original_method = "1525D0DC0F6073566820EAD4A6162E60", hash_generated_method = "3BAA17ED03EA1606E8231C376E564916")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final AbstractPreferences[] cachedChildren() {
        AbstractPreferences[] varEC6180BC503B8932ABA755D6BC698890_2128283459 = (cachedNode.values().toArray(new AbstractPreferences[cachedNode.size()]));
        return (AbstractPreferences[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cachedNode.values().toArray(new AbstractPreferences[cachedNode.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.024 -0400", hash_original_method = "2DB2CB908F4C4DE64C6EB092C8C44315", hash_generated_method = "D12B606DD23FC547AE69D4103C0D7F7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AbstractPreferences getChild(String name) throws BackingStoreException {
        dsTaint.addTaint(name);
        {
            checkState();
            AbstractPreferences result;
            result = null;
            String[] childrenNames;
            childrenNames = childrenNames();
            {
                String childrenName = childrenNames[0];
                {
                    {
                        boolean var06881D7F530BE9A126837C9B39968101_728830470 = (childrenName.equals(name));
                        {
                            result = childSpi(name);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (AbstractPreferences)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkState();
            //AbstractPreferences result = null;
            //String[] childrenNames = childrenNames();
            //for (String childrenName : childrenNames) {
                //if (childrenName.equals(name)) {
                    //result = childSpi(name);
                    //break;
                //}
            //}
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.062 -0400", hash_original_method = "576E6472508CF5DA519F254384E47534", hash_generated_method = "FF860ABA8308DACFDE6E89D7B3BD2D43")
    @DSModeled(DSC.SAFE)
    protected boolean isRemoved() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return isRemoved;
        //}
    }

    
    protected abstract void flushSpi() throws BackingStoreException;

    
    protected abstract String[] childrenNamesSpi() throws BackingStoreException;

    
    protected abstract AbstractPreferences childSpi(String name);

    
    protected abstract void putSpi(String name, String value);

    
    protected abstract String getSpi(String key);

    
    protected abstract String[] keysSpi() throws BackingStoreException;

    
    protected abstract void removeNodeSpi() throws BackingStoreException;

    
    protected abstract void removeSpi(String key);

    
    protected abstract void syncSpi() throws BackingStoreException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.142 -0400", hash_original_method = "FBA8C196DBDC4C4821569F7F0738DA11", hash_generated_method = "FBEDB0C9DB7D0CA20EFEC6A573669F57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String absolutePath() {
        String varE12F0D92EB1F6A3D20140F086D674F91_468315793 = (parentPref.absolutePath() + "/" + nodeName);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (parentPref == null) {
            //return "/";
        //} else if (parentPref == root) {
            //return "/" + nodeName;
        //}
        //return parentPref.absolutePath() + "/" + nodeName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.186 -0400", hash_original_method = "D129EF35AD8B246686EC0C036E528D1B", hash_generated_method = "EE4727351BC6F876872BC2AEAA24AA73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] childrenNames() throws BackingStoreException {
        {
            checkState();
            TreeSet<String> result;
            result = new TreeSet<String>(cachedNode.keySet());
            String[] names;
            names = childrenNamesSpi();
            {
                int i;
                i = 0;
                {
                    result.add(names[i]);
                } //End block
            } //End collapsed parenthetic
            String[] varA08870A5009052C592DEA5A65FAFE437_1891255211 = (result.toArray(new String[result.size()]));
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkState();
            //TreeSet<String> result = new TreeSet<String>(cachedNode.keySet());
            //String[] names = childrenNamesSpi();
            //for (int i = 0; i < names.length; i++) {
                //result.add(names[i]);
            //}
            //return result.toArray(new String[result.size()]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.220 -0400", hash_original_method = "C0D051A8F0EDD17482AE35C7C2C7F85F", hash_generated_method = "24B55D9322493563941D081155C85699")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clear() throws BackingStoreException {
        {
            {
                String key = keys()[0];
                {
                    remove(key);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //for (String key : keys()) {
                //remove(key);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.248 -0400", hash_original_method = "A8A194DED4DCEA318B2FA22B3B72595F", hash_generated_method = "63D9EA029255D6FD51C1477A4B3A0A65")
    @DSModeled(DSC.SAFE)
    @Override
    public void exportNode(OutputStream ostream) throws IOException, BackingStoreException {
        dsTaint.addTaint(ostream.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Stream is null");
        } //End block
        checkState();
        XMLParser.exportPrefs(this, ostream, false);
        // ---------- Original Method ----------
        //if (ostream == null) {
            //throw new NullPointerException("Stream is null");
        //}
        //checkState();
        //XMLParser.exportPrefs(this, ostream, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.283 -0400", hash_original_method = "B1222588FF07365EB0FDC930C37958BA", hash_generated_method = "5C4A8DB3CD768754A515207C95AD4AA6")
    @DSModeled(DSC.SAFE)
    @Override
    public void exportSubtree(OutputStream ostream) throws IOException, BackingStoreException {
        dsTaint.addTaint(ostream.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Stream is null");
        } //End block
        checkState();
        XMLParser.exportPrefs(this, ostream, true);
        // ---------- Original Method ----------
        //if (ostream == null) {
            //throw new NullPointerException("Stream is null");
        //}
        //checkState();
        //XMLParser.exportPrefs(this, ostream, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.309 -0400", hash_original_method = "09DA7A8C138DCF5F841D1FA25C63AD01", hash_generated_method = "5AFDC79F557D49F144DB822C17748935")
    @DSModeled(DSC.SAFE)
    @Override
    public void flush() throws BackingStoreException {
        {
            flushSpi();
        } //End block
        AbstractPreferences[] cc;
        cc = cachedChildren();
        int i;
        {
            i = 0;
            {
                cc[i].flush();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //synchronized (lock) {
            //flushSpi();
        //}
        //AbstractPreferences[] cc = cachedChildren();
        //int i;
        //for (i = 0; i < cc.length; i++) {
            //cc[i].flush();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.342 -0400", hash_original_method = "4AB4A28DDA50E98DEA4E0C5FCB8F1662", hash_generated_method = "42971D9E3167B88D106D9995EAAF1BF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String get(String key, String deflt) {
        dsTaint.addTaint(deflt);
        dsTaint.addTaint(key);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        String result;
        result = null;
        {
            checkState();
            try 
            {
                result = getSpi(key);
            } //End block
            catch (Exception e)
            { }
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //String result = null;
        //synchronized (lock) {
            //checkState();
            //try {
                //result = getSpi(key);
            //} catch (Exception e) {
            //}
        //}
        //return (result == null ? deflt : result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.368 -0400", hash_original_method = "639DF37CDA0AB7A4938611339DB542FA", hash_generated_method = "072920910E0DE817D1F70F2EE5AEC836")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getBoolean(String key, boolean deflt) {
        dsTaint.addTaint(deflt);
        dsTaint.addTaint(key);
        String result;
        result = get(key, null);
        {
            boolean varCDA01298C93A827AC46D24CFC3F425C8_2058937608 = ("true".equalsIgnoreCase(result));
            {
                boolean varB8A8BBEEA32C9C132A6230C9A691851C_778204729 = ("false".equalsIgnoreCase(result));
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String result = get(key, null);
        //if (result == null) {
            //return deflt;
        //}
        //if ("true".equalsIgnoreCase(result)) {
            //return true;
        //} else if ("false".equalsIgnoreCase(result)) {
            //return false;
        //} else {
            //return deflt;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.408 -0400", hash_original_method = "AE2FC565FED7A0480547BE7D1BB4A4AF", hash_generated_method = "A6108E3CD450EBF7A7B77054D9D6F1C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getByteArray(String key, byte[] deflt) {
        dsTaint.addTaint(deflt[0]);
        dsTaint.addTaint(key);
        String svalue;
        svalue = get(key, null);
        {
            boolean varA2A8B6C11F4CBDFD6BDD8BB18BA4D586_281804414 = (svalue.length() == 0);
        } //End collapsed parenthetic
        try 
        {
            byte[] bavalue;
            bavalue = svalue.getBytes(Charsets.US_ASCII);
            byte[] var6BAE2AC363DC3CA5F0B3A0CF270FD46C_361531287 = (Base64.decode(bavalue));
        } //End block
        catch (Exception e)
        { }
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //String svalue = get(key, null);
        //if (svalue == null) {
            //return deflt;
        //}
        //if (svalue.length() == 0) {
            //return EmptyArray.BYTE;
        //}
        //try {
            //byte[] bavalue = svalue.getBytes(Charsets.US_ASCII);
            //if (bavalue.length % 4 != 0) {
                //return deflt;
            //}
            //return Base64.decode(bavalue);
        //} catch (Exception e) {
            //return deflt;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.431 -0400", hash_original_method = "109E1C00F8D7E70022B4C7414F30B872", hash_generated_method = "1C2319B4D45FE344363BB646AF301D5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double getDouble(String key, double deflt) {
        dsTaint.addTaint(deflt);
        dsTaint.addTaint(key);
        String result;
        result = get(key, null);
        try 
        {
            double var75D8F17E1A634CC3E166AD8C6F2EB903_1208767855 = (Double.parseDouble(result));
        } //End block
        catch (NumberFormatException e)
        { }
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //String result = get(key, null);
        //if (result == null) {
            //return deflt;
        //}
        //try {
            //return Double.parseDouble(result);
        //} catch (NumberFormatException e) {
            //return deflt;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.454 -0400", hash_original_method = "9036785226A7D289AFD12282534D27B8", hash_generated_method = "733F2BAA1B583A1040C5945D1138CF3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float getFloat(String key, float deflt) {
        dsTaint.addTaint(deflt);
        dsTaint.addTaint(key);
        String result;
        result = get(key, null);
        try 
        {
            float varB88F42532415D5F6C901DAC25B5680F1_1850511056 = (Float.parseFloat(result));
        } //End block
        catch (NumberFormatException e)
        { }
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //String result = get(key, null);
        //if (result == null) {
            //return deflt;
        //}
        //try {
            //return Float.parseFloat(result);
        //} catch (NumberFormatException e) {
            //return deflt;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.477 -0400", hash_original_method = "471461DDFBFCB22BAA1CB33E8F37483B", hash_generated_method = "9888A91A115DEFC5AD8148C0BB1DA0AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getInt(String key, int deflt) {
        dsTaint.addTaint(deflt);
        dsTaint.addTaint(key);
        String result;
        result = get(key, null);
        try 
        {
            int varBFB6BF2BA9D0523BD53FBE723F94CC0C_2087476427 = (Integer.parseInt(result));
        } //End block
        catch (NumberFormatException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //String result = get(key, null);
        //if (result == null) {
            //return deflt;
        //}
        //try {
            //return Integer.parseInt(result);
        //} catch (NumberFormatException e) {
            //return deflt;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.498 -0400", hash_original_method = "BB689AECBDEF7F62A8A185A04695B6FA", hash_generated_method = "17F2F9DA97CC9DCF0AC1931009782ED7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getLong(String key, long deflt) {
        dsTaint.addTaint(deflt);
        dsTaint.addTaint(key);
        String result;
        result = get(key, null);
        try 
        {
            long varF17803878EDA2C51487D503E968AD33B_1308536051 = (Long.parseLong(result));
        } //End block
        catch (NumberFormatException e)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //String result = get(key, null);
        //if (result == null) {
            //return deflt;
        //}
        //try {
            //return Long.parseLong(result);
        //} catch (NumberFormatException e) {
            //return deflt;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.517 -0400", hash_original_method = "D97680DCE50F144AB0A3E9FE153F9E33", hash_generated_method = "03F1BE22F3EA89F07EF4E6DF09DA5B02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isUserNode() {
        boolean var4C97465D8C81E3772DA564FA837A19B2_1020591494 = (root == Preferences.userRoot());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return root == Preferences.userRoot();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.530 -0400", hash_original_method = "B0B15A1AE0BD860B1A20048A2563F5C1", hash_generated_method = "4B1DCE871B1C20A797EF415C2547E61B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] keys() throws BackingStoreException {
        {
            checkState();
            String[] var6ED33CBD63D27DB5B09E975F397434D5_739712083 = (keysSpi());
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkState();
            //return keysSpi();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.537 -0400", hash_original_method = "70A62793D56028D18CD0BECCF1959386", hash_generated_method = "33C6B104FD5A34E26F707B40B5D97D30")
    @DSModeled(DSC.SAFE)
    @Override
    public String name() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return nodeName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.560 -0400", hash_original_method = "B0B054E2ED8B73BE7E06ADFD1A1D1D4C", hash_generated_method = "938055B5DAB4BC1A83844321854FBE63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Preferences node(String name) {
        dsTaint.addTaint(name);
        AbstractPreferences startNode;
        startNode = null;
        {
            checkState();
            validateName(name);
            {
                boolean varC45442D5CAC21BA5127C6B3BB3F7C12C_2119797275 = (name.isEmpty());
                {
                    boolean varE37D3F1DF1BEB151F5AF4B2F8AE82185_1844355344 = ("/".equals(name));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                boolean var409A81790F03658AEEB308211BAF1C65_1474552365 = (name.startsWith("/"));
                {
                    startNode = root;
                    name = name.substring(1);
                } //End block
                {
                    startNode = this;
                } //End block
            } //End collapsed parenthetic
        } //End block
        try 
        {
            Preferences var701B042B0DAB41226BFF4F79F5068FF0_1321491843 = (startNode.nodeImpl(name, true));
        } //End block
        catch (BackingStoreException e)
        { }
        return (Preferences)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AbstractPreferences startNode = null;
        //synchronized (lock) {
            //checkState();
            //validateName(name);
            //if (name.isEmpty()) {
                //return this;
            //} else if ("/".equals(name)) {
                //return root;
            //}
            //if (name.startsWith("/")) {
                //startNode = root;
                //name = name.substring(1);
            //} else {
                //startNode = this;
            //}
        //}
        //try {
            //return startNode.nodeImpl(name, true);
        //} catch (BackingStoreException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.572 -0400", hash_original_method = "3AAB0E94D70724E9897CA4DE9F4177C7", hash_generated_method = "5F5DA437D0CA985C0633E2A42CE36F66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void validateName(String name) {
        dsTaint.addTaint(name);
        {
            boolean varA002731C196432A82F2295A198743EF7_1766556626 = (name.endsWith("/") && name.length() > 1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name cannot end with '/'");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var70E30666E146723E3CD4835E99CF25FD_1214111163 = (name.indexOf("//") >= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name cannot contain consecutive '/' characters");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (name.endsWith("/") && name.length() > 1) {
            //throw new IllegalArgumentException("Name cannot end with '/'");
        //}
        //if (name.indexOf("//") >= 0) {
            //throw new IllegalArgumentException("Name cannot contain consecutive '/' characters");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.584 -0400", hash_original_method = "C40BCF68871D14D0C22569A2DF32D9E0", hash_generated_method = "2D14A14E945AF40C74F80904C3E476FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AbstractPreferences nodeImpl(String path, boolean createNew) throws BackingStoreException {
        dsTaint.addTaint(path);
        dsTaint.addTaint(createNew);
        String[] names;
        names = path.split("/");
        AbstractPreferences currentNode;
        currentNode = this;
        AbstractPreferences temp;
        {
            String name = names[0];
            {
                {
                    temp = currentNode.cachedNode.get(name);
                    {
                        temp = getNodeFromBackend(createNew, currentNode, name);
                    } //End block
                } //End block
                currentNode = temp;
            } //End block
        } //End collapsed parenthetic
        return (AbstractPreferences)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String[] names = path.split("/");
        //AbstractPreferences currentNode = this;
        //AbstractPreferences temp;
        //for (String name : names) {
            //synchronized (currentNode.lock) {
                //temp = currentNode.cachedNode.get(name);
                //if (temp == null) {
                    //temp = getNodeFromBackend(createNew, currentNode, name);
                //}
            //}
            //currentNode = temp;
            //if (currentNode == null) {
                //break;
            //}
        //}
        //return currentNode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.601 -0400", hash_original_method = "2975F341D9852102A0A02FD901434075", hash_generated_method = "4EA1268E9700AB6483A153B6B708ECB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AbstractPreferences getNodeFromBackend(boolean createNew,
            AbstractPreferences currentNode, String name) throws BackingStoreException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(currentNode.dsTaint);
        dsTaint.addTaint(createNew);
        {
            boolean var70515DD6312E49591C2CCBA813E338ED_419513647 = (name.length() > MAX_NAME_LENGTH);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name '" + name + "' too long");
            } //End block
        } //End collapsed parenthetic
        AbstractPreferences temp;
        {
            temp = currentNode.childSpi(name);
            currentNode.cachedNode.put(name, temp);
            {
                boolean var452D016B5633E65EED7A1F92E64EA074_1657577569 = (temp.newNode && currentNode.nodeChangeListeners.size() > 0);
                {
                    currentNode.notifyChildAdded(temp);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            temp = currentNode.getChild(name);
        } //End block
        return (AbstractPreferences)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name.length() > MAX_NAME_LENGTH) {
            //throw new IllegalArgumentException("Name '" + name + "' too long");
        //}
        //AbstractPreferences temp;
        //if (createNew) {
            //temp = currentNode.childSpi(name);
            //currentNode.cachedNode.put(name, temp);
            //if (temp.newNode && currentNode.nodeChangeListeners.size() > 0) {
                //currentNode.notifyChildAdded(temp);
            //}
        //} else {
            //temp = currentNode.getChild(name);
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.640 -0400", hash_original_method = "4BBE4C74129DCB53F08914B623213860", hash_generated_method = "9C70E0D2204AB6A37D9505455202C5A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean nodeExists(String name) throws BackingStoreException {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        AbstractPreferences startNode;
        startNode = null;
        {
            {
                boolean var7249A5401D063BA1B5FDF5FDB85FAF50_729629710 = (isRemoved());
                {
                    {
                        boolean var58F596688B5793D7084830575CDAC93D_1409326663 = (name.isEmpty());
                    } //End collapsed parenthetic
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("This node has been removed");
                } //End block
            } //End collapsed parenthetic
            validateName(name);
            {
                boolean var9C15F81C8C2DF7FE0D604EA18C56F51E_859123890 = (name.isEmpty() || "/".equals(name));
            } //End collapsed parenthetic
            {
                boolean var409A81790F03658AEEB308211BAF1C65_1364838044 = (name.startsWith("/"));
                {
                    startNode = root;
                    name = name.substring(1);
                } //End block
                {
                    startNode = this;
                } //End block
            } //End collapsed parenthetic
        } //End block
        try 
        {
            Preferences result;
            result = startNode.nodeImpl(name, false);
        } //End block
        catch (IllegalArgumentException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.646 -0400", hash_original_method = "9DFA8F53CA82403F384A5DD89B5BDD9B", hash_generated_method = "CA409B0B7A5A54CCF2623FED0A7E3C27")
    @DSModeled(DSC.SAFE)
    @Override
    public Preferences parent() {
        checkState();
        return (Preferences)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkState();
        //return parentPref;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.652 -0400", hash_original_method = "F461E6CA4DE34BEFDFD8AC6C2C0583FC", hash_generated_method = "F3CEF06391858D63B345C6BC44970292")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkState() {
        {
            boolean varCE41AFA9A573A1111A6EC8BBCC43A6C3_243124448 = (isRemoved());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("This node has been removed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isRemoved()) {
            //throw new IllegalStateException("This node has been removed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.669 -0400", hash_original_method = "92761A4250BB325B67DA5DC49E2EA380", hash_generated_method = "01FDB51BB0D68647978AAA7C63AFAE4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void put(String key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var8C2A68C88F33C965B88B167D7CAC639D_1763552387 = (key.length() > MAX_KEY_LENGTH || value.length() > MAX_VALUE_LENGTH);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            checkState();
            putSpi(key, value);
        } //End block
        notifyPreferenceChange(key, value);
        // ---------- Original Method ----------
        //if (key == null || value == null) {
            //throw new NullPointerException();
        //}
        //if (key.length() > MAX_KEY_LENGTH || value.length() > MAX_VALUE_LENGTH) {
            //throw new IllegalArgumentException();
        //}
        //synchronized (lock) {
            //checkState();
            //putSpi(key, value);
        //}
        //notifyPreferenceChange(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.681 -0400", hash_original_method = "9FE1F120DB162000B2D2A52EDFA1B7C6", hash_generated_method = "B6ED86F7BC8E7F71A332CECE38F1B98A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void putBoolean(String key, boolean value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        put(key, String.valueOf(value));
        // ---------- Original Method ----------
        //put(key, String.valueOf(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.692 -0400", hash_original_method = "7AE77D468DC57040978F0BF60975CB80", hash_generated_method = "D9CEC7BF349FA313F69DFF6EB6DC287C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void putByteArray(String key, byte[] value) {
        dsTaint.addTaint(value[0]);
        dsTaint.addTaint(key);
        put(key, Base64.encode(value));
        // ---------- Original Method ----------
        //put(key, Base64.encode(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.702 -0400", hash_original_method = "D807E7AAFF1189D688AFBB37EC5AEE5D", hash_generated_method = "F3FA6F0063564A5BDE557AA1C7D32119")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void putDouble(String key, double value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        put(key, Double.toString(value));
        // ---------- Original Method ----------
        //put(key, Double.toString(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.709 -0400", hash_original_method = "78A15A7EB7210871258D355D3953315E", hash_generated_method = "EE03F5483C7E46BB319B839FC14E3DF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void putFloat(String key, float value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        put(key, Float.toString(value));
        // ---------- Original Method ----------
        //put(key, Float.toString(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.714 -0400", hash_original_method = "AE2431E7B109634FBF2EF5BD3DC2AEFB", hash_generated_method = "3352D843E2A977089668929D3B31171C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void putInt(String key, int value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        put(key, Integer.toString(value));
        // ---------- Original Method ----------
        //put(key, Integer.toString(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.719 -0400", hash_original_method = "71B32FB95B59E74CEDAE989D53D5BCD2", hash_generated_method = "FCDE3AA4509F9B2385207381639FAA95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void putLong(String key, long value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        put(key, Long.toString(value));
        // ---------- Original Method ----------
        //put(key, Long.toString(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.725 -0400", hash_original_method = "46648D24F35C727E94D531D8621F1E1E", hash_generated_method = "2274D7BA738EF0905FA5B55338CFFD9F")
    @DSModeled(DSC.SAFE)
    @Override
    public void remove(String key) {
        dsTaint.addTaint(key);
        {
            checkState();
            removeSpi(key);
        } //End block
        notifyPreferenceChange(key, null);
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkState();
            //removeSpi(key);
        //}
        //notifyPreferenceChange(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.733 -0400", hash_original_method = "39F5CA47E4BCDFE80745F0E3F00C0D5E", hash_generated_method = "27F0D3898F8C67D5FD68F33133BF31C6")
    @DSModeled(DSC.SAFE)
    @Override
    public void removeNode() throws BackingStoreException {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Cannot remove root node");
        } //End block
        {
            removeNodeImpl();
        } //End block
        // ---------- Original Method ----------
        //if (root == this) {
            //throw new UnsupportedOperationException("Cannot remove root node");
        //}
        //synchronized (parentPref.lock) {
            //removeNodeImpl();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.756 -0400", hash_original_method = "78CB6306E0BC01AAC2459F3D8E528FB4", hash_generated_method = "E199CD1253B84DB9A82A3B0ADC52BAB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeNodeImpl() throws BackingStoreException {
        {
            checkState();
            String[] childrenNames;
            childrenNames = childrenNamesSpi();
            {
                String childrenName = childrenNames[0];
                {
                    {
                        boolean var9E1BA25D1399F3F54325052D280F67AD_2028950836 = (cachedNode.get(childrenName) == null);
                        {
                            AbstractPreferences child;
                            child = childSpi(childrenName);
                            cachedNode.put(childrenName, child);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            Collection<AbstractPreferences> values;
            values = cachedNode.values();
            AbstractPreferences[] children;
            children = values.toArray(new AbstractPreferences[values.size()]);
            {
                AbstractPreferences child = children[0];
                {
                    child.removeNodeImpl();
                } //End block
            } //End collapsed parenthetic
            removeNodeSpi();
            isRemoved = true;
            parentPref.cachedNode.remove(nodeName);
        } //End block
        {
            boolean var655D14E58B19DADD428DEBDD8B8A71D8_627812588 = (parentPref.nodeChangeListeners.size() > 0);
            {
                parentPref.notifyChildRemoved(this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.762 -0400", hash_original_method = "A59D0E71288FBD15CE58D3D04702543C", hash_generated_method = "5C63F1468BAFF70058580B715150099B")
    @DSModeled(DSC.SAFE)
    @Override
    public void addNodeChangeListener(NodeChangeListener ncl) {
        dsTaint.addTaint(ncl.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        checkState();
        {
            nodeChangeListeners.add(ncl);
        } //End block
        // ---------- Original Method ----------
        //if (ncl == null) {
            //throw new NullPointerException();
        //}
        //checkState();
        //synchronized (nodeChangeListeners) {
            //nodeChangeListeners.add(ncl);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.766 -0400", hash_original_method = "CD082698638C73E90A9D4A6800CE760D", hash_generated_method = "298F0109B698155B9F07CB7E96760D4B")
    @DSModeled(DSC.SAFE)
    @Override
    public void addPreferenceChangeListener(PreferenceChangeListener pcl) {
        dsTaint.addTaint(pcl.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        checkState();
        {
            preferenceChangeListeners.add(pcl);
        } //End block
        // ---------- Original Method ----------
        //if (pcl == null) {
            //throw new NullPointerException();
        //}
        //checkState();
        //synchronized (preferenceChangeListeners) {
            //preferenceChangeListeners.add(pcl);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.787 -0400", hash_original_method = "951CA38CFD6B14E3191E6B7B20317326", hash_generated_method = "4035D054884D7190D95D7A4F1B42D39C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeNodeChangeListener(NodeChangeListener ncl) {
        dsTaint.addTaint(ncl.dsTaint);
        checkState();
        {
            int pos;
            {
                boolean varABD2A5651166953BB7F08CB03AF4C15E_1618412696 = ((pos = nodeChangeListeners.indexOf(ncl)) == -1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } //End block
            } //End collapsed parenthetic
            nodeChangeListeners.remove(pos);
        } //End block
        // ---------- Original Method ----------
        //checkState();
        //synchronized (nodeChangeListeners) {
            //int pos;
            //if ((pos = nodeChangeListeners.indexOf(ncl)) == -1) {
                //throw new IllegalArgumentException();
            //}
            //nodeChangeListeners.remove(pos);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.801 -0400", hash_original_method = "C1E9427CB5B4BE882168803C3DEA0C75", hash_generated_method = "08C349D9DE557DDC6935CCB70CDD3FB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removePreferenceChangeListener(PreferenceChangeListener pcl) {
        dsTaint.addTaint(pcl.dsTaint);
        checkState();
        {
            int pos;
            {
                boolean varF5C60B0C99C0E76A96F9DA83E91791BE_1398606734 = ((pos = preferenceChangeListeners.indexOf(pcl)) == -1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } //End block
            } //End collapsed parenthetic
            preferenceChangeListeners.remove(pos);
        } //End block
        // ---------- Original Method ----------
        //checkState();
        //synchronized (preferenceChangeListeners) {
            //int pos;
            //if ((pos = preferenceChangeListeners.indexOf(pcl)) == -1) {
                //throw new IllegalArgumentException();
            //}
            //preferenceChangeListeners.remove(pos);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.816 -0400", hash_original_method = "8D078FAB1746AA61D755CBE918F17B12", hash_generated_method = "036E7DA8D7C3ED432BD76AF82630DDC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void sync() throws BackingStoreException {
        {
            checkState();
            syncSpi();
        } //End block
        {
            AbstractPreferences child = cachedChildren()[0];
            {
                child.sync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkState();
            //syncSpi();
        //}
        //for (AbstractPreferences child : cachedChildren()) {
            //child.sync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.828 -0400", hash_original_method = "DC2DEE4C60A3DE38C649D2B8F6B4E410", hash_generated_method = "3B28B32ADA5508116D385E7C32E46891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varBDC4A50CAABA804F887ADFF36217A64C_415268172 = ((isUserNode() ? "User" : "System") + " Preference Node: " + absolutePath()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (isUserNode() ? "User" : "System") + " Preference Node: " + absolutePath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.835 -0400", hash_original_method = "65AD46C2EB753C71EA56F7D39A48DF3D", hash_generated_method = "8C54AFF328D306A022ADBD13BF72CD9A")
    @DSModeled(DSC.SAFE)
    private void notifyChildAdded(Preferences child) {
        dsTaint.addTaint(child.dsTaint);
        NodeChangeEvent nce;
        nce = new NodeAddEvent(this, child);
        {
            events.add(nce);
            events.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //NodeChangeEvent nce = new NodeAddEvent(this, child);
        //synchronized (events) {
            //events.add(nce);
            //events.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.845 -0400", hash_original_method = "39847A372326885BCE41D06964B72A3B", hash_generated_method = "5CD74C3CE964268A0C2C69023941C5A0")
    @DSModeled(DSC.SAFE)
    private void notifyChildRemoved(Preferences child) {
        dsTaint.addTaint(child.dsTaint);
        NodeChangeEvent nce;
        nce = new NodeRemoveEvent(this, child);
        {
            events.add(nce);
            events.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //NodeChangeEvent nce = new NodeRemoveEvent(this, child);
        //synchronized (events) {
            //events.add(nce);
            //events.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.849 -0400", hash_original_method = "28045A459F68F6FC999733F430D0C2E0", hash_generated_method = "B51C36D11E8F29D6CFF802246C937FE1")
    @DSModeled(DSC.SAFE)
    private void notifyPreferenceChange(String key, String newValue) {
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(key);
        PreferenceChangeEvent pce;
        pce = new PreferenceChangeEvent(this, key, newValue);
        {
            events.add(pce);
            events.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //PreferenceChangeEvent pce = new PreferenceChangeEvent(this, key, newValue);
        //synchronized (events) {
            //events.add(pce);
            //events.notifyAll();
        //}
    }

    
    private static class EventDispatcher extends Thread {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.870 -0400", hash_original_method = "491662CDBB464C35B9003C04ACE1C3EE", hash_generated_method = "7D7434F942B179BC6A5D419BFF05A00B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         EventDispatcher(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.878 -0400", hash_original_method = "536021F1E13E81D3927E4466D90AFCE8", hash_generated_method = "8C523F9D9BA783D35A4CE86282623F17")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            {
                EventObject event = null;
                try 
                {
                    event = getEventObject();
                } //End block
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                } //End block
                AbstractPreferences pref;
                pref = (AbstractPreferences) event.getSource();
                {
                    dispatchNodeAdd((NodeChangeEvent) event,
                            pref.nodeChangeListeners);
                } //End block
                {
                    dispatchNodeRemove((NodeChangeEvent) event,
                            pref.nodeChangeListeners);
                } //End block
                {
                    dispatchPrefChange((PreferenceChangeEvent) event,
                            pref.preferenceChangeListeners);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.883 -0400", hash_original_method = "D6A2F83156833BE876E527D6701B8805", hash_generated_method = "76322A933E52019A378364CBCED4F568")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private EventObject getEventObject() throws InterruptedException {
            {
                {
                    boolean varC995DBC7615674CEFE3BD518E36D8032_486349363 = (events.isEmpty());
                    {
                        events.wait();
                    } //End block
                } //End collapsed parenthetic
                EventObject event;
                event = events.get(0);
                events.remove(0);
            } //End block
            return (EventObject)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (events) {
                //if (events.isEmpty()) {
                    //events.wait();
                //}
                //EventObject event = events.get(0);
                //events.remove(0);
                //return event;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.887 -0400", hash_original_method = "D70FEE84D37143DCFA5B50B9E14A8BBC", hash_generated_method = "87EA4B8FD543B103924938A32724B80E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void dispatchPrefChange(PreferenceChangeEvent event,
                List<EventListener> preferenceChangeListeners) {
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(preferenceChangeListeners.dsTaint);
            {
                {
                    Iterator<EventListener> varF2210952C1D94D305797BA6FAE860A38_1816287483 = preferenceChangeListeners.iterator();
                    varF2210952C1D94D305797BA6FAE860A38_1816287483.hasNext();
                    EventListener preferenceChangeListener = varF2210952C1D94D305797BA6FAE860A38_1816287483.next();
                    {
                        ((PreferenceChangeListener) preferenceChangeListener).preferenceChange(event);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //synchronized (preferenceChangeListeners) {
                //for (EventListener preferenceChangeListener : preferenceChangeListeners) {
                    //((PreferenceChangeListener) preferenceChangeListener).preferenceChange(event);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.893 -0400", hash_original_method = "8D92F8D15D776264ED01259C91584FEF", hash_generated_method = "C2AC83A1DAF3862156B74E4538539586")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void dispatchNodeRemove(NodeChangeEvent event,
                List<EventListener> nodeChangeListeners) {
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(nodeChangeListeners.dsTaint);
            {
                {
                    Iterator<EventListener> varB4A35B512373DACC7B494002AE852851_206434832 = nodeChangeListeners.iterator();
                    varB4A35B512373DACC7B494002AE852851_206434832.hasNext();
                    EventListener nodeChangeListener = varB4A35B512373DACC7B494002AE852851_206434832.next();
                    {
                        ((NodeChangeListener) nodeChangeListener).childRemoved(event);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //synchronized (nodeChangeListeners) {
                //for (EventListener nodeChangeListener : nodeChangeListeners) {
                    //((NodeChangeListener) nodeChangeListener).childRemoved(event);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.898 -0400", hash_original_method = "4B5D9693FA2131BCEF122B28CB3F2A2C", hash_generated_method = "C7D38212D3313CE95E60514CC6DDFB0E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void dispatchNodeAdd(NodeChangeEvent event,
                List<EventListener> nodeChangeListeners) {
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(nodeChangeListeners.dsTaint);
            {
                {
                    Iterator<EventListener> varB4A35B512373DACC7B494002AE852851_151732654 = nodeChangeListeners.iterator();
                    varB4A35B512373DACC7B494002AE852851_151732654.hasNext();
                    EventListener nodeChangeListener = varB4A35B512373DACC7B494002AE852851_151732654.next();
                    {
                        NodeChangeListener ncl;
                        ncl = (NodeChangeListener) nodeChangeListener;
                        ncl.childAdded(event);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //synchronized (nodeChangeListeners) {
                //for (EventListener nodeChangeListener : nodeChangeListeners) {
                    //NodeChangeListener ncl = (NodeChangeListener) nodeChangeListener;
                    //ncl.childAdded(event);
                //}
            //}
        }

        
    }


    
    private static class NodeAddEvent extends NodeChangeEvent {
        private static long serialVersionUID = 1L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.912 -0400", hash_original_method = "802F28B42B0D53C63BCBB7878B78F66E", hash_generated_method = "465A31A35DB2AD1CDEAFD7A5CB1D1539")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NodeAddEvent(Preferences p, Preferences c) {
            super(p, c);
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(p.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class NodeRemoveEvent extends NodeChangeEvent {
        private static long serialVersionUID = 1L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:07:18.915 -0400", hash_original_method = "36B4F2AA31ED24B2FFEB21CB60261720", hash_generated_method = "5F0BF30353CDB7D7E36334F252D35889")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NodeRemoveEvent(Preferences p, Preferences c) {
            super(p, c);
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(p.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    static {
        dispatcher.setDaemon(true);
        dispatcher.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                Preferences uroot = Preferences.userRoot();
                Preferences sroot = Preferences.systemRoot();
                try {
                    uroot.flush();
                } catch (BackingStoreException e) {
                }
                try {
                    sroot.flush();
                } catch (BackingStoreException e) {
                }
            }
        });
    }
    
}


