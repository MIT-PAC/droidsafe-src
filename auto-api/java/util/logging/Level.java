package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import dalvik.system.VMStack;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import libcore.util.Objects;

public class Level implements Serializable {
    private static final long serialVersionUID = -8176160795706313070L;
    private static final List<Level> levels = new ArrayList<Level>(9);
    public static final Level OFF = new Level("OFF", Integer.MAX_VALUE);
    public static final Level SEVERE = new Level("SEVERE", 1000);
    public static final Level WARNING = new Level("WARNING", 900);
    public static final Level INFO = new Level("INFO", 800);
    public static final Level CONFIG = new Level("CONFIG", 700);
    public static final Level FINE = new Level("FINE", 500);
    public static final Level FINER = new Level("FINER", 400);
    public static final Level FINEST = new Level("FINEST", 300);
    public static final Level ALL = new Level("ALL", Integer.MIN_VALUE);
    private final String name;
    private final int value;
    private final String resourceBundleName;
    private transient ResourceBundle rb;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.733 -0400", hash_original_method = "BA2D7DFC8FDB62519DA8B21DD64373B1", hash_generated_method = "A7CD1928120475282513498565E45F17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Level(String name, int level) {
        this(name, level, null);
        dsTaint.addTaint(level);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.733 -0400", hash_original_method = "53B5A8F24D3D39AE441B077329C71771", hash_generated_method = "E9F8F3E9BBE146BFB75D020F93AC9D30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Level(String name, int level, String resourceBundleName) {
        dsTaint.addTaint(level);
        dsTaint.addTaint(name);
        dsTaint.addTaint(resourceBundleName);
        {
            throw new NullPointerException("name == null");
        } //End block
        {
            try 
            {
                rb = ResourceBundle.getBundle(resourceBundleName,
                        Locale.getDefault(), VMStack.getCallingClassLoader());
            } //End block
            catch (MissingResourceException e)
            {
                rb = null;
            } //End block
        } //End block
        {
            levels.add(this);
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //this.name = name;
        //this.value = level;
        //this.resourceBundleName = resourceBundleName;
        //if (resourceBundleName != null) {
            //try {
                //rb = ResourceBundle.getBundle(resourceBundleName,
                        //Locale.getDefault(), VMStack.getCallingClassLoader());
            //} catch (MissingResourceException e) {
                //rb = null;
            //}
        //}
        //synchronized (levels) {
            //levels.add(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.733 -0400", hash_original_method = "B522AEDC8C75E1BBD9453A71CF2D6695", hash_generated_method = "572E8C09CF1F437BFF4740775DC9DD8F")
    public static Level parse(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        boolean isNameAnInt;
        int nameAsInt;
        try {
            nameAsInt = Integer.parseInt(name);
            isNameAnInt = true;
        } catch (NumberFormatException e) {
            nameAsInt = 0;
            isNameAnInt = false;
        }
        synchronized (levels) {
            for (Level level : levels) {
                if (name.equals(level.getName())) {
                    return level;
                }
            }
            if (isNameAnInt) {
                for (Level level : levels) {
                    if (nameAsInt == level.intValue()) {
                        return level;
                    }
                }
            }
        }
        if (!isNameAnInt) {
            throw new IllegalArgumentException("Cannot parse name '" + name + "'");
        }
        return new Level(name, nameAsInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.733 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "EF43AF6ECA190C096749521B6824B37F")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.733 -0400", hash_original_method = "6DEDF515FC3DFB06F00973FF806B7B79", hash_generated_method = "CE5B7275BC807D2AF266823600A91FBE")
    @DSModeled(DSC.SAFE)
    public String getResourceBundleName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.733 -0400", hash_original_method = "8914B55F694F31BD669F4AB78F5D8E0B", hash_generated_method = "7690ECB32DDD703794DCF67008D73909")
    @DSModeled(DSC.SAFE)
    public final int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.733 -0400", hash_original_method = "68F6CB700CD961C98FAD85DDC5107742", hash_generated_method = "ADE4A3EE6D03AEAC798C26A265764691")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readResolve() {
        {
            {
                Iterator<Level> seatecAstronomy42 = levels.iterator();
                seatecAstronomy42.hasNext();
                Level level = seatecAstronomy42.next();
                {
                    {
                        boolean var729584BCC66FA55B097FFBF4EF8251E3_1075087017 = (!name.equals(level.name));
                    } //End collapsed parenthetic
                    {
                        boolean var4BF223D7D3821EB4754EA4BE4641285B_3957677 = (Objects.equal(resourceBundleName, level.resourceBundleName));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            levels.add(this);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (levels) {
            //for (Level level : levels) {
                //if (value != level.value) {
                    //continue;
                //}
                //if (!name.equals(level.name)) {
                    //continue;
                //}
                //if (Objects.equal(resourceBundleName, level.resourceBundleName)) {
                    //return level;
                //}
            //}
            //levels.add(this);
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.734 -0400", hash_original_method = "267F1EA9E96531D86D40818D686262D8", hash_generated_method = "88AFA88CDC9B9ABCC366537175175A1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        in.defaultReadObject();
        {
            try 
            {
                rb = ResourceBundle.getBundle(resourceBundleName);
            } //End block
            catch (MissingResourceException e)
            {
                rb = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //if (resourceBundleName != null) {
            //try {
                //rb = ResourceBundle.getBundle(resourceBundleName);
            //} catch (MissingResourceException e) {
                //rb = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.734 -0400", hash_original_method = "DEC78AA3502D783DBE391483E644D523", hash_generated_method = "687BDC970075EBC36D1CDDBCA5E23B49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLocalizedName() {
        try 
        {
            String var5DF72997D905295B4558AF574A9944AC_382923266 = (rb.getString(name));
        } //End block
        catch (MissingResourceException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (rb == null) {
            //return name;
        //}
        //try {
            //return rb.getString(name);
        //} catch (MissingResourceException e) {
            //return name;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.734 -0400", hash_original_method = "B7F9927C4C2FEE34F933446CD9D546A4", hash_generated_method = "8EF9CCAE0153223A5ECBB259C05F290C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var826F12C192C9625CB0288CDC69F40611_435737042 = (((Level) o).intValue() == this.value);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (!(o instanceof Level)) {
            //return false;
        //}
        //return ((Level) o).intValue() == this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.734 -0400", hash_original_method = "B2C871D8CEAC47C4CD40779F84B10431", hash_generated_method = "F1773F491878703E2C7688976A4F234A")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.734 -0400", hash_original_method = "1304E162466F7C6D399933DD8CDA12C4", hash_generated_method = "EB2E74B4AD86C16289EBF2CCFC6283E9")
    @DSModeled(DSC.SAFE)
    @Override
    public final String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.name;
    }

    
}


