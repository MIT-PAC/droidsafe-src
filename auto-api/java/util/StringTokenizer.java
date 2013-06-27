package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class StringTokenizer implements Enumeration<Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.522 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.522 -0400", hash_original_field = "6224CFB24529078F1D494850B1D43AB6", hash_generated_field = "08557D348CBDF8CC7B00F6CD8CA91B61")

    private String delimiters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.522 -0400", hash_original_field = "2CD1CFC752EE7A25879F065A713D4409", hash_generated_field = "641E06957176D04FBFF2F11AEC2A6EC3")

    private boolean returnDelimiters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.522 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.523 -0400", hash_original_method = "B454FB9D24CB40B920B0F26A1DEB0F99", hash_generated_method = "EB61119094E6FDDB7986B6AC19E9A0E5")
    public  StringTokenizer(String string) {
        this(string, " \t\n\r\f", false);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.523 -0400", hash_original_method = "19F75AB88247B84D1EA58EB13E75D4B3", hash_generated_method = "EC36DB7F7600BD90A9F91787A93C08FE")
    public  StringTokenizer(String string, String delimiters) {
        this(string, delimiters, false);
        addTaint(string.getTaint());
        addTaint(delimiters.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.524 -0400", hash_original_method = "8522BA3F0D65BC6302678F3FDA0BEB48", hash_generated_method = "3ADE024AECD79929D8260A4FD4A5DDD6")
    public  StringTokenizer(String string, String delimiters,
            boolean returnDelimiters) {
        {
            this.string = string;
            this.delimiters = delimiters;
            this.returnDelimiters = returnDelimiters;
            this.position = 0;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        // ---------- Original Method ----------
        //if (string != null) {
            //this.string = string;
            //this.delimiters = delimiters;
            //this.returnDelimiters = returnDelimiters;
            //this.position = 0;
        //} else
            //throw new NullPointerException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.525 -0400", hash_original_method = "F396A87D2BE9368C37D12C0E764C04A1", hash_generated_method = "47B3A235D629044BA9748398E34D7970")
    public int countTokens() {
        int count;
        count = 0;
        boolean inToken;
        inToken = false;
        {
            int i, length;
            i = position;
            length = string.length();
            {
                {
                    boolean varF959624410E37AE8E04F3D6629840E93_1401848160 = (delimiters.indexOf(string.charAt(i), 0) >= 0);
                    {
                        {
                            inToken = false;
                        } //End block
                    } //End block
                    {
                        inToken = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132477876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132477876;
        // ---------- Original Method ----------
        //int count = 0;
        //boolean inToken = false;
        //for (int i = position, length = string.length(); i < length; i++) {
            //if (delimiters.indexOf(string.charAt(i), 0) >= 0) {
                //if (returnDelimiters)
                    //count++;
                //if (inToken) {
                    //count++;
                    //inToken = false;
                //}
            //} else {
                //inToken = true;
            //}
        //}
        //if (inToken)
            //count++;
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.525 -0400", hash_original_method = "8165B2FDF405707BFEA9EF223873FBB9", hash_generated_method = "C60C1553969E54C540FC869D36AA6C9D")
    public boolean hasMoreElements() {
        boolean varD6DD5EDA7437B9905500CFBE29944506_288733952 = (hasMoreTokens());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355929669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_355929669;
        // ---------- Original Method ----------
        //return hasMoreTokens();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.526 -0400", hash_original_method = "15C5B981D98A46AC76B0A556FC01F2CE", hash_generated_method = "449458B88B722D2EBEEC0392445F5C29")
    public boolean hasMoreTokens() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int length;
        length = string.length();
        {
            {
                int i;
                i = position;
                {
                    boolean var51C04FE3BD64EB66A94B1ADE79981D5D_23079583 = (delimiters.indexOf(string.charAt(i), 0) == -1);
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412434694 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412434694;
        // ---------- Original Method ----------
        //if (delimiters == null) {
            //throw new NullPointerException();
        //}
        //int length = string.length();
        //if (position < length) {
            //if (returnDelimiters)
                //return true; 
            //for (int i = position; i < length; i++)
                //if (delimiters.indexOf(string.charAt(i), 0) == -1)
                    //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.533 -0400", hash_original_method = "0727048C65431FDBB400A5F8931A38E2", hash_generated_method = "EA3E325EDB58C03E941875EFA6CCB5DB")
    public Object nextElement() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1422231516 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1422231516 = nextToken();
        varB4EAC82CA7396A68D541C85D26508E83_1422231516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1422231516;
        // ---------- Original Method ----------
        //return nextToken();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.548 -0400", hash_original_method = "195590523F66664753FCC18930183C87", hash_generated_method = "3E39A3DD00D6D4F8ECF04D054C8A59EB")
    public String nextToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_1976303742 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1893851073 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_554765195 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1301673600 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1655651404 = null; //Variable for return #5
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int i;
        i = position;
        int length;
        length = string.length();
        {
            {
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1389068480 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    varB4EAC82CA7396A68D541C85D26508E83_1976303742 = String.valueOf(string.charAt(position++));
                } //End collapsed parenthetic
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1946128421 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    varB4EAC82CA7396A68D541C85D26508E83_1893851073 = string.substring(i, position);
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_554765195 = string.substring(i);
            } //End block
            {
                boolean var64D6C26CDC470C826C7D5C1E99C29036_1664908769 = (i < length && delimiters.indexOf(string.charAt(i), 0) >= 0);
            } //End collapsed parenthetic
            position = i;
            {
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1841213353 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    varB4EAC82CA7396A68D541C85D26508E83_1301673600 = string.substring(i, position);
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1655651404 = string.substring(i);
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        String varA7E53CE21691AB073D9660D615818899_1629075591; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1629075591 = varB4EAC82CA7396A68D541C85D26508E83_1976303742;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1629075591 = varB4EAC82CA7396A68D541C85D26508E83_1893851073;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1629075591 = varB4EAC82CA7396A68D541C85D26508E83_554765195;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1629075591 = varB4EAC82CA7396A68D541C85D26508E83_1301673600;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1629075591 = varB4EAC82CA7396A68D541C85D26508E83_1655651404;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1629075591.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1629075591;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.549 -0400", hash_original_method = "A244E208DF1B5D62AF8E286FEDEE9DEC", hash_generated_method = "56EB874F0D84AF9F932B8D4432ACF316")
    public String nextToken(String delims) {
        String varB4EAC82CA7396A68D541C85D26508E83_2097802364 = null; //Variable for return #1
        this.delimiters = delims;
        varB4EAC82CA7396A68D541C85D26508E83_2097802364 = nextToken();
        varB4EAC82CA7396A68D541C85D26508E83_2097802364.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2097802364;
        // ---------- Original Method ----------
        //this.delimiters = delims;
        //return nextToken();
    }

    
}

