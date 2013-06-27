package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class StringTokenizer implements Enumeration<Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.480 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.480 -0400", hash_original_field = "6224CFB24529078F1D494850B1D43AB6", hash_generated_field = "08557D348CBDF8CC7B00F6CD8CA91B61")

    private String delimiters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.480 -0400", hash_original_field = "2CD1CFC752EE7A25879F065A713D4409", hash_generated_field = "641E06957176D04FBFF2F11AEC2A6EC3")

    private boolean returnDelimiters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.480 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.481 -0400", hash_original_method = "B454FB9D24CB40B920B0F26A1DEB0F99", hash_generated_method = "EB61119094E6FDDB7986B6AC19E9A0E5")
    public  StringTokenizer(String string) {
        this(string, " \t\n\r\f", false);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.481 -0400", hash_original_method = "19F75AB88247B84D1EA58EB13E75D4B3", hash_generated_method = "EC36DB7F7600BD90A9F91787A93C08FE")
    public  StringTokenizer(String string, String delimiters) {
        this(string, delimiters, false);
        addTaint(string.getTaint());
        addTaint(delimiters.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.489 -0400", hash_original_method = "8522BA3F0D65BC6302678F3FDA0BEB48", hash_generated_method = "3ADE024AECD79929D8260A4FD4A5DDD6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.490 -0400", hash_original_method = "F396A87D2BE9368C37D12C0E764C04A1", hash_generated_method = "9FFECB2417C3C12833DD51F7FAC7836B")
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
                    boolean varF959624410E37AE8E04F3D6629840E93_368052821 = (delimiters.indexOf(string.charAt(i), 0) >= 0);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755139678 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755139678;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.490 -0400", hash_original_method = "8165B2FDF405707BFEA9EF223873FBB9", hash_generated_method = "D716C9268CDF87C61988C36C5E024E4E")
    public boolean hasMoreElements() {
        boolean varD6DD5EDA7437B9905500CFBE29944506_530981845 = (hasMoreTokens());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555620472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_555620472;
        // ---------- Original Method ----------
        //return hasMoreTokens();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.491 -0400", hash_original_method = "15C5B981D98A46AC76B0A556FC01F2CE", hash_generated_method = "9F1A5191A12A5B17578B511165A7B96A")
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
                    boolean var51C04FE3BD64EB66A94B1ADE79981D5D_1189908147 = (delimiters.indexOf(string.charAt(i), 0) == -1);
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_818731890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_818731890;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.491 -0400", hash_original_method = "0727048C65431FDBB400A5F8931A38E2", hash_generated_method = "CD8037BC37D99EDC8AF4F1A9D66D51F6")
    public Object nextElement() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1235194271 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1235194271 = nextToken();
        varB4EAC82CA7396A68D541C85D26508E83_1235194271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1235194271;
        // ---------- Original Method ----------
        //return nextToken();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.504 -0400", hash_original_method = "195590523F66664753FCC18930183C87", hash_generated_method = "AC77FE86810425C7078F3871D6376F9B")
    public String nextToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_1817558209 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_860528286 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_707275036 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1312794947 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_537812910 = null; //Variable for return #5
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
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1532405727 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    varB4EAC82CA7396A68D541C85D26508E83_1817558209 = String.valueOf(string.charAt(position++));
                } //End collapsed parenthetic
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_473841243 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    varB4EAC82CA7396A68D541C85D26508E83_860528286 = string.substring(i, position);
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_707275036 = string.substring(i);
            } //End block
            {
                boolean var64D6C26CDC470C826C7D5C1E99C29036_32609981 = (i < length && delimiters.indexOf(string.charAt(i), 0) >= 0);
            } //End collapsed parenthetic
            position = i;
            {
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1956315400 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    varB4EAC82CA7396A68D541C85D26508E83_1312794947 = string.substring(i, position);
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_537812910 = string.substring(i);
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        String varA7E53CE21691AB073D9660D615818899_886722777; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_886722777 = varB4EAC82CA7396A68D541C85D26508E83_1817558209;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_886722777 = varB4EAC82CA7396A68D541C85D26508E83_860528286;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_886722777 = varB4EAC82CA7396A68D541C85D26508E83_707275036;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_886722777 = varB4EAC82CA7396A68D541C85D26508E83_1312794947;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_886722777 = varB4EAC82CA7396A68D541C85D26508E83_537812910;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_886722777.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_886722777;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.505 -0400", hash_original_method = "A244E208DF1B5D62AF8E286FEDEE9DEC", hash_generated_method = "8316BB4A92AB5D407E91F338BFF0E276")
    public String nextToken(String delims) {
        String varB4EAC82CA7396A68D541C85D26508E83_25339198 = null; //Variable for return #1
        this.delimiters = delims;
        varB4EAC82CA7396A68D541C85D26508E83_25339198 = nextToken();
        varB4EAC82CA7396A68D541C85D26508E83_25339198.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_25339198;
        // ---------- Original Method ----------
        //this.delimiters = delims;
        //return nextToken();
    }

    
}

