package java.util.logging;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import libcore.util.Objects;
import dalvik.system.VMStack;

public class Level implements Serializable {

    /**
     * Parses a level name into a {@code Level} object.
     *
     * @param name
     *            the name of the desired {@code level}, which cannot be
     *            {@code null}.
     * @return the level with the specified name.
     * @throws NullPointerException
     *             if {@code name} is {@code null}.
     * @throws IllegalArgumentException
     *             if {@code name} is not valid.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.617 -0500", hash_original_method = "B522AEDC8C75E1BBD9453A71CF2D6695", hash_generated_method = "FD598772B9D86AE223E3CFCC6AF6E842")
    
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
                /*
                 * Loop through levels a second time, so that the returned
                 * instance will be passed on the order of construction.
                 */
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.589 -0500", hash_original_field = "4E1718917C44931E02E5D2CF6F9A5FAF", hash_generated_field = "D33AC5439F5BB9E615F192463618D9E3")

    private static final long serialVersionUID = -8176160795706313070L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.591 -0500", hash_original_field = "1FC4A542D0E5293588F58550387070F6", hash_generated_field = "5545112DFF5AE761BF55D4BFDB05CF99")

    private static final List<Level> levels = new ArrayList<Level>(9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.594 -0500", hash_original_field = "6AA1449FCEFAEE395608E659A0D31188", hash_generated_field = "7D4FE1BCF9F743133D4A933C0D2E6229")

    public static final Level OFF = new Level("OFF", Integer.MAX_VALUE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.596 -0500", hash_original_field = "35AE8BA34AA91E10A4A5EEF067120878", hash_generated_field = "4E601095036636FC5637E144C84926F9")

    public static final Level SEVERE = new Level("SEVERE", 1000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.599 -0500", hash_original_field = "5E5F8FB68D351F5A0DEDEAA5B1A88A4A", hash_generated_field = "75B160565D9E8B7BAAAAEBB0EB411DCE")

    public static final Level WARNING = new Level("WARNING", 900);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.601 -0500", hash_original_field = "A5621B808718F5712D4966BBA9695504", hash_generated_field = "268DFBD0EE059C15C2D32B20BC6D11FD")

    public static final Level INFO = new Level("INFO", 800);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.605 -0500", hash_original_field = "1F087806312562D4982929B0C839D494", hash_generated_field = "566FF1B651D340629CC4A97442061FBB")

    public static final Level CONFIG = new Level("CONFIG", 700);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.607 -0500", hash_original_field = "73F7CE828771BAA136164CB175232EEC", hash_generated_field = "AE5992FAEA9E073263D8DEC10FE933BC")

    public static final Level FINE = new Level("FINE", 500);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.610 -0500", hash_original_field = "1F969DFE592CFCDA42720A42C6B22A1B", hash_generated_field = "4B170E8B3034DDA19FAC260F54AECC50")

    public static final Level FINER = new Level("FINER", 400);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.612 -0500", hash_original_field = "385BADD5891ED293EFED9CD1E22974C1", hash_generated_field = "9EFCE8FEA6DBE72770E62DEF2AFF1BF2")

    public static final Level FINEST = new Level("FINEST", 300);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.614 -0500", hash_original_field = "2C8A769D965745E96B4E0E20A6F99806", hash_generated_field = "F56ECB9CF27A97D320EEC5079D9727A9")

    public static final Level ALL = new Level("ALL", Integer.MIN_VALUE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.620 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.623 -0500", hash_original_field = "2A5EA2B60261C751D318C2CB32BF7CEC", hash_generated_field = "810C3DA5CE7DA1BA423D6BE76816E5C9")

    private  int value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.625 -0500", hash_original_field = "35CC6187306CFB2B68FF26D1B6A58A2F", hash_generated_field = "4BDB4C6F49EE0D4ED40E32BE56CE6580")

    private  String resourceBundleName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.628 -0500", hash_original_field = "913BB31457DB0E26778958CD08525E01", hash_generated_field = "A47C9414E01189F2E30143A3854D6AFC")

    private transient ResourceBundle rb;

    /**
     * Constructs an instance of {@code Level} taking the supplied name and
     * level value.
     *
     * @param name
     *            the name of the level.
     * @param level
     *            an integer value indicating the level.
     * @throws NullPointerException
     *             if {@code name} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.630 -0500", hash_original_method = "BA2D7DFC8FDB62519DA8B21DD64373B1", hash_generated_method = "A0540D1B7C8728695592E68DDC6B6543")
    
protected Level(String name, int level) {
        this(name, level, null);
    }

    /**
     * Constructs an instance of {@code Level} taking the supplied name, level
     * value and resource bundle name.
     *
     * @param name
     *            the name of the level.
     * @param level
     *            an integer value indicating the level.
     * @param resourceBundleName
     *            the name of the resource bundle to use.
     * @throws NullPointerException
     *             if {@code name} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.633 -0500", hash_original_method = "53B5A8F24D3D39AE441B077329C71771", hash_generated_method = "58FB46748A3B0D03F6D22447095E48BE")
    
protected Level(String name, int level, String resourceBundleName) {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        this.name = name;
        this.value = level;
        this.resourceBundleName = resourceBundleName;
        if (resourceBundleName != null) {
            try {
                rb = ResourceBundle.getBundle(resourceBundleName,
                        Locale.getDefault(), VMStack.getCallingClassLoader());
            } catch (MissingResourceException e) {
                rb = null;
            }
        }
        synchronized (levels) {
            levels.add(this);
        }
    }

    /**
     * Gets the name of this level.
     *
     * @return this level's name.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.636 -0500", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "10AFD575EA26BE807F18801FAC02C531")
    
public String getName() {
        return this.name;
    }

    /**
     * Gets the name of the resource bundle associated with this level.
     *
     * @return the name of this level's resource bundle.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.638 -0500", hash_original_method = "6DEDF515FC3DFB06F00973FF806B7B79", hash_generated_method = "795ECC4106B798264DC061D44D617BDB")
    
public String getResourceBundleName() {
        return this.resourceBundleName;
    }

    /**
     * Gets the integer value indicating this level.
     *
     * @return this level's integer value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.640 -0500", hash_original_method = "8914B55F694F31BD669F4AB78F5D8E0B", hash_generated_method = "722E199462D7D6C816EA7F52782180C2")
    
public final int intValue() {
        return this.value;
    }

    /**
     * Serialization helper method to maintain singletons and add any new
     * levels.
     *
     * @return the resolved instance.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.643 -0500", hash_original_method = "68F6CB700CD961C98FAD85DDC5107742", hash_generated_method = "DF1F5C1E9236855CC6A3ED494BE08945")
    
private Object readResolve() {
        synchronized (levels) {
            for (Level level : levels) {
                if (value != level.value) {
                    continue;
                }
                if (!name.equals(level.name)) {
                    continue;
                }
                if (Objects.equal(resourceBundleName, level.resourceBundleName)) {
                    return level;
                }
            }
            // This is a new value, so add it.
            levels.add(this);
            return this;
        }
    }

    /**
     * Serialization helper to setup transient resource bundle instance.
     *
     * @param in
     *            the input stream to read the instance data from.
     * @throws IOException
     *             if an IO error occurs.
     * @throws ClassNotFoundException
     *             if a class is not found.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.645 -0500", hash_original_method = "267F1EA9E96531D86D40818D686262D8", hash_generated_method = "5288DA0CB42918DD18AA147B00D6674B")
    
private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        if (resourceBundleName != null) {
            try {
                rb = ResourceBundle.getBundle(resourceBundleName);
            } catch (MissingResourceException e) {
                rb = null;
            }
        }
    }

    /**
     * Gets the localized name of this level. The default locale is used. If no
     * resource bundle is associated with this level then the original level
     * name is returned.
     *
     * @return the localized name of this level.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.648 -0500", hash_original_method = "DEC78AA3502D783DBE391483E644D523", hash_generated_method = "17B331D2A9D24EC6EB750C5F9F54597A")
    
public String getLocalizedName() {
        if (rb == null) {
            return name;
        }

        try {
            return rb.getString(name);
        } catch (MissingResourceException e) {
            return name;
        }
    }

    /**
     * Compares two {@code Level} objects for equality. They are considered to
     * be equal if they have the same level value.
     *
     * @param o
     *            the other object to compare this level to.
     * @return {@code true} if this object equals to the supplied object,
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.651 -0500", hash_original_method = "B7F9927C4C2FEE34F933446CD9D546A4", hash_generated_method = "B130B68E3F411670DB14ADA9AA9A22AD")
    
@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Level)) {
            return false;
        }

        return ((Level) o).intValue() == this.value;
    }

    /**
     * Returns the hash code of this {@code Level} object.
     *
     * @return this level's hash code.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.653 -0500", hash_original_method = "B2C871D8CEAC47C4CD40779F84B10431", hash_generated_method = "F423F80DC97919734AF46D1780DF4AF2")
    
@Override
    public int hashCode() {
        return this.value;
    }

    /**
     * Returns the string representation of this {@code Level} object. In
     * this case, it is the level's name.
     *
     * @return the string representation of this level.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.656 -0500", hash_original_method = "1304E162466F7C6D399933DD8CDA12C4", hash_generated_method = "2C7423C5B42F1AAB29BE1C2C0841EC2B")
    
@Override
    public final String toString() {
        return this.name;
    }
}

