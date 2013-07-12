package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class StringTokenizer implements Enumeration<Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.110 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.110 -0400", hash_original_field = "6224CFB24529078F1D494850B1D43AB6", hash_generated_field = "08557D348CBDF8CC7B00F6CD8CA91B61")

    private String delimiters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.110 -0400", hash_original_field = "2CD1CFC752EE7A25879F065A713D4409", hash_generated_field = "641E06957176D04FBFF2F11AEC2A6EC3")

    private boolean returnDelimiters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.110 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.110 -0400", hash_original_method = "B454FB9D24CB40B920B0F26A1DEB0F99", hash_generated_method = "EB61119094E6FDDB7986B6AC19E9A0E5")
    public  StringTokenizer(String string) {
        this(string, " \t\n\r\f", false);
        addTaint(string.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.111 -0400", hash_original_method = "19F75AB88247B84D1EA58EB13E75D4B3", hash_generated_method = "AD660F0D83D59036DF028A02B99004EE")
    public  StringTokenizer(String string, String delimiters) {
        this(string, delimiters, false);
        addTaint(delimiters.getTaint());
        addTaint(string.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.112 -0400", hash_original_method = "8522BA3F0D65BC6302678F3FDA0BEB48", hash_generated_method = "217A499D0B05A457D6B337B91FEED69F")
    public  StringTokenizer(String string, String delimiters,
            boolean returnDelimiters) {
    if(string != null)        
        {
            this.string = string;
            this.delimiters = delimiters;
            this.returnDelimiters = returnDelimiters;
            this.position = 0;
        } 
        else
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_131130041 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_131130041.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_131130041;
        }
        
        
            
            
            
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.112 -0400", hash_original_method = "F396A87D2BE9368C37D12C0E764C04A1", hash_generated_method = "B9E4A1ACC2DDC785D6AB9AEAF95D19F1")
    public int countTokens() {
        int count = 0;
        boolean inToken = false;
for(int i = position, length = string.length();i < length;i++)
        {
    if(delimiters.indexOf(string.charAt(i), 0) >= 0)            
            {
    if(returnDelimiters)                
                count++;
    if(inToken)                
                {
                    count++;
                    inToken = false;
                } 
            } 
            else
            {
                inToken = true;
            } 
        } 
    if(inToken)        
        count++;
        int varE2942A04780E223B215EB8B663CF5353_640096262 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209166013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209166013;
        
        
        
        
            
                
                    
                
                    
                    
                
            
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.113 -0400", hash_original_method = "8165B2FDF405707BFEA9EF223873FBB9", hash_generated_method = "DDC967E22F449E5C632F174D48490BFC")
    public boolean hasMoreElements() {
        boolean var9F4E475B63003C851520033472409ACA_1508531969 = (hasMoreTokens());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1085557007 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1085557007;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.113 -0400", hash_original_method = "15C5B981D98A46AC76B0A556FC01F2CE", hash_generated_method = "4BFCA8F62D0B6759E41EC6C582017D0C")
    public boolean hasMoreTokens() {
    if(delimiters == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1058547950 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1058547950.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1058547950;
        } 
        int length = string.length();
    if(position < length)        
        {
    if(returnDelimiters)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_71306245 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_650966295 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_650966295;
            }
for(int i = position;i < length;i++)
    if(delimiters.indexOf(string.charAt(i), 0) == -1)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1466323049 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21013179 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_21013179;
            }
        } 
        boolean var68934A3E9455FA72420237EB05902327_693579407 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337256181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337256181;
        
        
            
        
        
        
            
                
            
                
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.114 -0400", hash_original_method = "0727048C65431FDBB400A5F8931A38E2", hash_generated_method = "430C866981E42F57FE6C19A5F8ABCA1A")
    public Object nextElement() {
Object var1E85D5DD28517B6F091CC30DA1235BD1_1807422213 =         nextToken();
        var1E85D5DD28517B6F091CC30DA1235BD1_1807422213.addTaint(taint);
        return var1E85D5DD28517B6F091CC30DA1235BD1_1807422213;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.115 -0400", hash_original_method = "195590523F66664753FCC18930183C87", hash_generated_method = "4CE56FB0FB839A60DE487733526DC352")
    public String nextToken() {
    if(delimiters == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1082656139 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1082656139.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1082656139;
        } 
        int i = position;
        int length = string.length();
    if(i < length)        
        {
    if(returnDelimiters)            
            {
    if(delimiters.indexOf(string.charAt(position), 0) >= 0)                
                {
String varC80AD727259EBF2841DDFEBEB4BBFFA5_2015426866 =                 String.valueOf(string.charAt(position++));
                varC80AD727259EBF2841DDFEBEB4BBFFA5_2015426866.addTaint(taint);
                return varC80AD727259EBF2841DDFEBEB4BBFFA5_2015426866;
                }
for(position++;position < length;position++)
    if(delimiters.indexOf(string.charAt(position), 0) >= 0)                
                {
String var2E994505C69E38C75ABA3D94A33C89BE_918492784 =                 string.substring(i, position);
                var2E994505C69E38C75ABA3D94A33C89BE_918492784.addTaint(taint);
                return var2E994505C69E38C75ABA3D94A33C89BE_918492784;
                }
String var62F48227EB0C9AD4B78CE3F1FCA71075_408536584 =                 string.substring(i);
                var62F48227EB0C9AD4B78CE3F1FCA71075_408536584.addTaint(taint);
                return var62F48227EB0C9AD4B78CE3F1FCA71075_408536584;
            } 
            while
(i < length && delimiters.indexOf(string.charAt(i), 0) >= 0)            
            i++;
            position = i;
    if(i < length)            
            {
for(position++;position < length;position++)
    if(delimiters.indexOf(string.charAt(position), 0) >= 0)                
                {
String var2E994505C69E38C75ABA3D94A33C89BE_814159782 =                 string.substring(i, position);
                var2E994505C69E38C75ABA3D94A33C89BE_814159782.addTaint(taint);
                return var2E994505C69E38C75ABA3D94A33C89BE_814159782;
                }
String var62F48227EB0C9AD4B78CE3F1FCA71075_315307280 =                 string.substring(i);
                var62F48227EB0C9AD4B78CE3F1FCA71075_315307280.addTaint(taint);
                return var62F48227EB0C9AD4B78CE3F1FCA71075_315307280;
            } 
        } 
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1528956636 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1528956636.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1528956636;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.116 -0400", hash_original_method = "A244E208DF1B5D62AF8E286FEDEE9DEC", hash_generated_method = "F1DF1EAA4E704BCA2C9929BA71970F02")
    public String nextToken(String delims) {
        this.delimiters = delims;
String var1E85D5DD28517B6F091CC30DA1235BD1_609071204 =         nextToken();
        var1E85D5DD28517B6F091CC30DA1235BD1_609071204.addTaint(taint);
        return var1E85D5DD28517B6F091CC30DA1235BD1_609071204;
        
        
        
    }

    
}

