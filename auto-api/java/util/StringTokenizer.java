package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class StringTokenizer implements Enumeration<Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.736 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.736 -0400", hash_original_field = "6224CFB24529078F1D494850B1D43AB6", hash_generated_field = "08557D348CBDF8CC7B00F6CD8CA91B61")

    private String delimiters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.736 -0400", hash_original_field = "2CD1CFC752EE7A25879F065A713D4409", hash_generated_field = "641E06957176D04FBFF2F11AEC2A6EC3")

    private boolean returnDelimiters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.736 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.737 -0400", hash_original_method = "B454FB9D24CB40B920B0F26A1DEB0F99", hash_generated_method = "EB61119094E6FDDB7986B6AC19E9A0E5")
    public  StringTokenizer(String string) {
        this(string, " \t\n\r\f", false);
        addTaint(string.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.737 -0400", hash_original_method = "19F75AB88247B84D1EA58EB13E75D4B3", hash_generated_method = "EC36DB7F7600BD90A9F91787A93C08FE")
    public  StringTokenizer(String string, String delimiters) {
        this(string, delimiters, false);
        addTaint(string.getTaint());
        addTaint(delimiters.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.738 -0400", hash_original_method = "8522BA3F0D65BC6302678F3FDA0BEB48", hash_generated_method = "3ADE024AECD79929D8260A4FD4A5DDD6")
    public  StringTokenizer(String string, String delimiters,
            boolean returnDelimiters) {
        {
            this.string = string;
            this.delimiters = delimiters;
            this.returnDelimiters = returnDelimiters;
            this.position = 0;
        } 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        
        
            
            
            
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.739 -0400", hash_original_method = "F396A87D2BE9368C37D12C0E764C04A1", hash_generated_method = "AB4285116E20E8C649268ADF4520AABD")
    public int countTokens() {
        int count = 0;
        boolean inToken = false;
        {
            int i = position;
            int length = string.length();
            {
                {
                    boolean varF959624410E37AE8E04F3D6629840E93_474112698 = (delimiters.indexOf(string.charAt(i), 0) >= 0);
                    {
                        {
                            inToken = false;
                        } 
                    } 
                    {
                        inToken = true;
                    } 
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1203744623 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1203744623;
        
        
        
        
            
                
                    
                
                    
                    
                
            
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.739 -0400", hash_original_method = "8165B2FDF405707BFEA9EF223873FBB9", hash_generated_method = "400350817CBF2C426891F389F582CBFA")
    public boolean hasMoreElements() {
        boolean varD6DD5EDA7437B9905500CFBE29944506_22219082 = (hasMoreTokens());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785448961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785448961;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.740 -0400", hash_original_method = "15C5B981D98A46AC76B0A556FC01F2CE", hash_generated_method = "A122A4944F825827DCBDC31467D434F0")
    public boolean hasMoreTokens() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        int length = string.length();
        {
            {
                int i = position;
                {
                    boolean var51C04FE3BD64EB66A94B1ADE79981D5D_1275820328 = (delimiters.indexOf(string.charAt(i), 0) == -1);
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795149161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795149161;
        
        
            
        
        
        
            
                
            
                
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.740 -0400", hash_original_method = "0727048C65431FDBB400A5F8931A38E2", hash_generated_method = "AA5C9A6E00C34DCA9EE57D19108E915F")
    public Object nextElement() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1452859604 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1452859604 = nextToken();
        varB4EAC82CA7396A68D541C85D26508E83_1452859604.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1452859604;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.741 -0400", hash_original_method = "195590523F66664753FCC18930183C87", hash_generated_method = "E3D4274266AA2F69AA432E714DC2B1C7")
    public String nextToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_739429749 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_236256589 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2058388916 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2072716560 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_36340894 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        int i = position;
        int length = string.length();
        {
            {
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_122747180 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    varB4EAC82CA7396A68D541C85D26508E83_739429749 = String.valueOf(string.charAt(position++));
                } 
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1391477337 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    varB4EAC82CA7396A68D541C85D26508E83_236256589 = string.substring(i, position);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_2058388916 = string.substring(i);
            } 
            {
                boolean var64D6C26CDC470C826C7D5C1E99C29036_29276919 = (i < length && delimiters.indexOf(string.charAt(i), 0) >= 0);
            } 
            position = i;
            {
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1081873045 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    varB4EAC82CA7396A68D541C85D26508E83_2072716560 = string.substring(i, position);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_36340894 = string.substring(i);
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        String varA7E53CE21691AB073D9660D615818899_64930186; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_64930186 = varB4EAC82CA7396A68D541C85D26508E83_739429749;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_64930186 = varB4EAC82CA7396A68D541C85D26508E83_236256589;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_64930186 = varB4EAC82CA7396A68D541C85D26508E83_2058388916;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_64930186 = varB4EAC82CA7396A68D541C85D26508E83_2072716560;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_64930186 = varB4EAC82CA7396A68D541C85D26508E83_36340894;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_64930186.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_64930186;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.742 -0400", hash_original_method = "A244E208DF1B5D62AF8E286FEDEE9DEC", hash_generated_method = "4F49AA4213FE8E452A1FB0A2D3379B59")
    public String nextToken(String delims) {
        String varB4EAC82CA7396A68D541C85D26508E83_1522749866 = null; 
        this.delimiters = delims;
        varB4EAC82CA7396A68D541C85D26508E83_1522749866 = nextToken();
        varB4EAC82CA7396A68D541C85D26508E83_1522749866.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1522749866;
        
        
        
    }

    
}

