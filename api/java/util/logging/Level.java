package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.117 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.117 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "810C3DA5CE7DA1BA423D6BE76816E5C9")

    private int value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.117 -0400", hash_original_field = "9623BCEF06C4EDCE06D889B615841D11", hash_generated_field = "4BDB4C6F49EE0D4ED40E32BE56CE6580")

    private String resourceBundleName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.117 -0400", hash_original_field = "9E3F4F69757D07F6A0D2AF4F1F2A1103", hash_generated_field = "A47C9414E01189F2E30143A3854D6AFC")

    private transient ResourceBundle rb;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.130 -0400", hash_original_method = "BA2D7DFC8FDB62519DA8B21DD64373B1", hash_generated_method = "5D13951DD8E87306CD7F4B33BD4FE6EE")
    protected  Level(String name, int level) {
        this(name, level, null);
        addTaint(level);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.131 -0400", hash_original_method = "53B5A8F24D3D39AE441B077329C71771", hash_generated_method = "F06404053DF4A029E748BBBA6D0CAFD2")
    protected  Level(String name, int level, String resourceBundleName) {
    if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_1563169533 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_1563169533.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_1563169533;
        } //End block
        this.name = name;
        this.value = level;
        this.resourceBundleName = resourceBundleName;
    if(resourceBundleName != null)        
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
        synchronized
(levels)        {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.131 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "3BEF42198E661EC93A8C50F88DB67979")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_134512706 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_134512706.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_134512706;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.131 -0400", hash_original_method = "6DEDF515FC3DFB06F00973FF806B7B79", hash_generated_method = "48E4B45AAD8B19A3C35C89753559DDC2")
    public String getResourceBundleName() {
String var7214CEE3997909E522736F52DB465A8B_1979387927 =         this.resourceBundleName;
        var7214CEE3997909E522736F52DB465A8B_1979387927.addTaint(taint);
        return var7214CEE3997909E522736F52DB465A8B_1979387927;
        // ---------- Original Method ----------
        //return this.resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.132 -0400", hash_original_method = "8914B55F694F31BD669F4AB78F5D8E0B", hash_generated_method = "68A7B75AF5499ADD8EB9F6779E204A80")
    public final int intValue() {
        int varBA12F6D323945424B7A4EAC0C07E7B2C_54918238 = (this.value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621470185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621470185;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.132 -0400", hash_original_method = "68F6CB700CD961C98FAD85DDC5107742", hash_generated_method = "BEB4199B76B1E5F634051E7524A1A16D")
    private Object readResolve() {
        synchronized
(levels)        {
for(Level level : levels)
            {
    if(value != level.value)                
                {
                    continue;
                } //End block
    if(!name.equals(level.name))                
                {
                    continue;
                } //End block
    if(Objects.equal(resourceBundleName, level.resourceBundleName))                
                {
Object varBBB01F92FFE3DDEF2182A71AE5793430_1047735431 =                     level;
                    varBBB01F92FFE3DDEF2182A71AE5793430_1047735431.addTaint(taint);
                    return varBBB01F92FFE3DDEF2182A71AE5793430_1047735431;
                } //End block
            } //End block
            levels.add(this);
Object var72A74007B2BE62B849F475C7BDA4658B_789188822 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_789188822.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_789188822;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.132 -0400", hash_original_method = "267F1EA9E96531D86D40818D686262D8", hash_generated_method = "C1A531C66B9B2D21B1427DEC27AAFD80")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
    if(resourceBundleName != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.132 -0400", hash_original_method = "DEC78AA3502D783DBE391483E644D523", hash_generated_method = "4F13428D3346A2AE6194F2356462E041")
    public String getLocalizedName() {
    if(rb == null)        
        {
String varB017984728AC60AD1F0BF8734F33F15C_1370654155 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_1370654155.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_1370654155;
        } //End block
        try 
        {
String var86A4BBDA5786BD31861538F8C8D35F6F_1225164354 =             rb.getString(name);
            var86A4BBDA5786BD31861538F8C8D35F6F_1225164354.addTaint(taint);
            return var86A4BBDA5786BD31861538F8C8D35F6F_1225164354;
        } //End block
        catch (MissingResourceException e)
        {
String varB017984728AC60AD1F0BF8734F33F15C_1037259034 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_1037259034.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_1037259034;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.132 -0400", hash_original_method = "B7F9927C4C2FEE34F933446CD9D546A4", hash_generated_method = "81DF9F82D0439A9D65DE87DB3923F18B")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1146853510 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748515753 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748515753;
        } //End block
    if(!(o instanceof Level))        
        {
            boolean var68934A3E9455FA72420237EB05902327_512219023 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32060762 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_32060762;
        } //End block
        boolean varDBD9BE81A7ABD64EC5DC68DCE54E527C_1132496885 = (((Level) o).intValue() == this.value);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565226803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_565226803;
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (!(o instanceof Level)) {
            //return false;
        //}
        //return ((Level) o).intValue() == this.value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_method = "B2C871D8CEAC47C4CD40779F84B10431", hash_generated_method = "7BCF5ED14CCE007101E7EC52DA988063")
    @Override
    public int hashCode() {
        int varBA12F6D323945424B7A4EAC0C07E7B2C_1844849985 = (this.value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968208934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968208934;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_method = "1304E162466F7C6D399933DD8CDA12C4", hash_generated_method = "758B60A9EB4F61B55A793B26D39130F6")
    @Override
    public final String toString() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_509768712 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_509768712.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_509768712;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "A510FBD61CF6433DC1B175D364070D99", hash_generated_field = "D33AC5439F5BB9E615F192463618D9E3")

    private static final long serialVersionUID = -8176160795706313070L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "9846B94D1E5D63529397134055FC8E44", hash_generated_field = "5545112DFF5AE761BF55D4BFDB05CF99")

    private static final List<Level> levels = new ArrayList<Level>(9);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "E42B3E38E962DC772837339B0AE785F5", hash_generated_field = "7D4FE1BCF9F743133D4A933C0D2E6229")

    public static final Level OFF = new Level("OFF", Integer.MAX_VALUE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "F90365F1504FEC505378D81DAE49D65F", hash_generated_field = "4E601095036636FC5637E144C84926F9")

    public static final Level SEVERE = new Level("SEVERE", 1000);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "BB7D329893836B6F2DC449A77E110B41", hash_generated_field = "75B160565D9E8B7BAAAAEBB0EB411DCE")

    public static final Level WARNING = new Level("WARNING", 900);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "273EE4426F2F5988F2F2A2E4F284BD76", hash_generated_field = "268DFBD0EE059C15C2D32B20BC6D11FD")

    public static final Level INFO = new Level("INFO", 800);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "F8A0F12AFB6FA4CF9286E87716E40E3F", hash_generated_field = "566FF1B651D340629CC4A97442061FBB")

    public static final Level CONFIG = new Level("CONFIG", 700);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "B97D2D99EEDF7FDFC8CDD1B32EBF9790", hash_generated_field = "AE5992FAEA9E073263D8DEC10FE933BC")

    public static final Level FINE = new Level("FINE", 500);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "737487473CC170234068CE91617C150E", hash_generated_field = "4B170E8B3034DDA19FAC260F54AECC50")

    public static final Level FINER = new Level("FINER", 400);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "F491ADAF22E215C62AEA59F697BB579B", hash_generated_field = "9EFCE8FEA6DBE72770E62DEF2AFF1BF2")

    public static final Level FINEST = new Level("FINEST", 300);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.133 -0400", hash_original_field = "6934F2D5E54432A13EAD330A1F0E862F", hash_generated_field = "F56ECB9CF27A97D320EEC5079D9727A9")

    public static final Level ALL = new Level("ALL", Integer.MIN_VALUE);
}

