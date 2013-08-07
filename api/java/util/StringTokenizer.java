package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;





public class StringTokenizer implements Enumeration<Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.622 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.622 -0400", hash_original_field = "6224CFB24529078F1D494850B1D43AB6", hash_generated_field = "08557D348CBDF8CC7B00F6CD8CA91B61")

    private String delimiters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.622 -0400", hash_original_field = "2CD1CFC752EE7A25879F065A713D4409", hash_generated_field = "641E06957176D04FBFF2F11AEC2A6EC3")

    private boolean returnDelimiters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.622 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

    private int position;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.622 -0400", hash_original_method = "B454FB9D24CB40B920B0F26A1DEB0F99", hash_generated_method = "EB61119094E6FDDB7986B6AC19E9A0E5")
    public  StringTokenizer(String string) {
        this(string, " \t\n\r\f", false);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.623 -0400", hash_original_method = "19F75AB88247B84D1EA58EB13E75D4B3", hash_generated_method = "AD660F0D83D59036DF028A02B99004EE")
    public  StringTokenizer(String string, String delimiters) {
        this(string, delimiters, false);
        addTaint(delimiters.getTaint());
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.624 -0400", hash_original_method = "8522BA3F0D65BC6302678F3FDA0BEB48", hash_generated_method = "7749C36EB4CAA366BAC596929700FEC8")
    public  StringTokenizer(String string, String delimiters,
            boolean returnDelimiters) {
        if(string != null)        
        {
            this.string = string;
            this.delimiters = delimiters;
            this.returnDelimiters = returnDelimiters;
            this.position = 0;
        } //End block
        else
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1097627999 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1097627999.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1097627999;
        }
        // ---------- Original Method ----------
        //if (string != null) {
            //this.string = string;
            //this.delimiters = delimiters;
            //this.returnDelimiters = returnDelimiters;
            //this.position = 0;
        //} else
            //throw new NullPointerException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.625 -0400", hash_original_method = "F396A87D2BE9368C37D12C0E764C04A1", hash_generated_method = "E6B893300E59D7EDC94F207FC3665A1C")
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
                } //End block
            } //End block
            else
            {
                inToken = true;
            } //End block
        } //End block
        if(inToken)        
        count++;
        int varE2942A04780E223B215EB8B663CF5353_1579201007 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330575673 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330575673;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.625 -0400", hash_original_method = "8165B2FDF405707BFEA9EF223873FBB9", hash_generated_method = "D74CC26159773F6A13B6CE2307B3ACED")
    public boolean hasMoreElements() {
        boolean var9F4E475B63003C851520033472409ACA_1773838482 = (hasMoreTokens());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349313055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349313055;
        // ---------- Original Method ----------
        //return hasMoreTokens();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.626 -0400", hash_original_method = "15C5B981D98A46AC76B0A556FC01F2CE", hash_generated_method = "C5B81A6DF69D7D9DA8A941ED96FE024B")
    public boolean hasMoreTokens() {
        if(delimiters == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1726038942 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1726038942.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1726038942;
        } //End block
        int length = string.length();
        if(position < length)        
        {
            if(returnDelimiters)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1677743495 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1639781109 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1639781109;
            }
for(int i = position;i < length;i++)
            if(delimiters.indexOf(string.charAt(i), 0) == -1)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1562266768 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_851118695 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_851118695;
            }
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_235039807 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128845552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128845552;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.627 -0400", hash_original_method = "0727048C65431FDBB400A5F8931A38E2", hash_generated_method = "51393D8A22CC33AEBC158BC90A8DE589")
    public Object nextElement() {
Object var1E85D5DD28517B6F091CC30DA1235BD1_139251882 =         nextToken();
        var1E85D5DD28517B6F091CC30DA1235BD1_139251882.addTaint(taint);
        return var1E85D5DD28517B6F091CC30DA1235BD1_139251882;
        // ---------- Original Method ----------
        //return nextToken();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.628 -0400", hash_original_method = "195590523F66664753FCC18930183C87", hash_generated_method = "842F67DEE3734D1EFC28971F26BD6599")
    public String nextToken() {
        if(delimiters == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1761787308 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1761787308.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1761787308;
        } //End block
        int i = position;
        int length = string.length();
        if(i < length)        
        {
            if(returnDelimiters)            
            {
                if(delimiters.indexOf(string.charAt(position), 0) >= 0)                
                {
String varC80AD727259EBF2841DDFEBEB4BBFFA5_1476468028 =                 String.valueOf(string.charAt(position++));
                varC80AD727259EBF2841DDFEBEB4BBFFA5_1476468028.addTaint(taint);
                return varC80AD727259EBF2841DDFEBEB4BBFFA5_1476468028;
                }
for(position++;position < length;position++)
                if(delimiters.indexOf(string.charAt(position), 0) >= 0)                
                {
String var2E994505C69E38C75ABA3D94A33C89BE_623480663 =                 string.substring(i, position);
                var2E994505C69E38C75ABA3D94A33C89BE_623480663.addTaint(taint);
                return var2E994505C69E38C75ABA3D94A33C89BE_623480663;
                }
String var62F48227EB0C9AD4B78CE3F1FCA71075_1912899805 =                 string.substring(i);
                var62F48227EB0C9AD4B78CE3F1FCA71075_1912899805.addTaint(taint);
                return var62F48227EB0C9AD4B78CE3F1FCA71075_1912899805;
            } //End block
            while
(i < length && delimiters.indexOf(string.charAt(i), 0) >= 0)            
            i++;
            position = i;
            if(i < length)            
            {
for(position++;position < length;position++)
                if(delimiters.indexOf(string.charAt(position), 0) >= 0)                
                {
String var2E994505C69E38C75ABA3D94A33C89BE_704312214 =                 string.substring(i, position);
                var2E994505C69E38C75ABA3D94A33C89BE_704312214.addTaint(taint);
                return var2E994505C69E38C75ABA3D94A33C89BE_704312214;
                }
String var62F48227EB0C9AD4B78CE3F1FCA71075_2130239576 =                 string.substring(i);
                var62F48227EB0C9AD4B78CE3F1FCA71075_2130239576.addTaint(taint);
                return var62F48227EB0C9AD4B78CE3F1FCA71075_2130239576;
            } //End block
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1119046771 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1119046771.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1119046771;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.630 -0400", hash_original_method = "A244E208DF1B5D62AF8E286FEDEE9DEC", hash_generated_method = "71ED25CD33E9D1CB0F8DECC34C484B15")
    public String nextToken(String delims) {
        this.delimiters = delims;
String var1E85D5DD28517B6F091CC30DA1235BD1_1740247086 =         nextToken();
        var1E85D5DD28517B6F091CC30DA1235BD1_1740247086.addTaint(taint);
        return var1E85D5DD28517B6F091CC30DA1235BD1_1740247086;
        // ---------- Original Method ----------
        //this.delimiters = delims;
        //return nextToken();
    }

    
}

