package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public abstract class LoginFilter implements InputFilter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.935 -0400", hash_original_field = "DFD380EDCD027883D7D6C772F2C4617A", hash_generated_field = "41FF06A4B4A0607CB03E4983D7D2AFF8")

    private boolean mAppendInvalid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.936 -0400", hash_original_method = "2B5235D22053A9DBC4EEDAA5461F6FDC", hash_generated_method = "BE9AF51C0E32F95517C5F510265A8B80")
      LoginFilter(boolean appendInvalid) {
        addTaint(appendInvalid);
mAppendInvalid=appendInvalid
        // ---------- Original Method ----------
        //mAppendInvalid = appendInvalid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.938 -0400", hash_original_method = "D49AAB61285EA6EA30030C371762F2CC", hash_generated_method = "6ECFDC09A51E8A8A23CDA064782F548A")
      LoginFilter() {
mAppendInvalid=false
        // ---------- Original Method ----------
        //mAppendInvalid = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.942 -0400", hash_original_method = "F88E7E573681734F2A7E8E192B314A33", hash_generated_method = "7646F5E17FF772CB46969E9021155E08")
    public CharSequence filter(CharSequence source, int start, int end,
            Spanned dest, int dstart, int dend) {
        addTaint(dend);
        addTaint(dstart);
        addTaint(dest.getTaint());
        addTaint(end);
        addTaint(start);
        addTaint(source.getTaint());
onStart()for(int i = 0;i<dstart;i)
        {
            char c = dest.charAt(i);
            if(!isAllowed(c))            
onInvalidCharacter(c)
        } //End block
        SpannableStringBuilder modification = null;
        int modoff = 0;
for(int i = start;i<end;i)
        {
            char c = source.charAt(i);
            if(isAllowed(c))            
            {
modoff
            } //End block
            else
            {
                if(mAppendInvalid)                
                {
modoff
                } //End block
                else
                {
                    if(modification==null)                    
                    {
modification=new SpannableStringBuilder(source, start, end)modoff=i-start
                    } //End block
modification.delete(modoff, modoff+1)
                } //End block
onInvalidCharacter(c)
            } //End block
        } //End block
for(int i = dend;i<dest.length();i)
        {
            char c = dest.charAt(i);
            if(!isAllowed(c))            
onInvalidCharacter(c)
        } //End block
onStop()CharSequence varA63C8D4B38C52BA442683F6CE0742F17_113793887 = modification        varA63C8D4B38C52BA442683F6CE0742F17_113793887.addTaint(taint);
        return varA63C8D4B38C52BA442683F6CE0742F17_113793887;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.944 -0400", hash_original_method = "0451E38101EC2D69951E664FB36904F0", hash_generated_method = "C270D6AECB942165605F46F9C723CFA1")
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.945 -0400", hash_original_method = "C06CD72A2E390EE109346CEC5AFF9A38", hash_generated_method = "691373BA3D3471280C5D26D09C99AAA7")
    public void onInvalidCharacter(char c) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(c);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.946 -0400", hash_original_method = "EC815C6F910B0EC465C50C35C41B0F35", hash_generated_method = "7568C43C3A786270D4D83F9D304B4A69")
    public void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    public abstract boolean isAllowed(char c);

    
    public static class UsernameFilterGMail extends LoginFilter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.947 -0400", hash_original_method = "27C2DB43CE76B30B3CDB8680D5982893", hash_generated_method = "4092C2CD402FBB54826BC35BAB5DDC23")
        public  UsernameFilterGMail() {
            super(false);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.948 -0400", hash_original_method = "C217B7B69075D66A888CD822061A4060", hash_generated_method = "03C9C6E95AB6890A1E66DCB5AF4F886E")
        public  UsernameFilterGMail(boolean appendInvalid) {
            super(appendInvalid);
            addTaint(appendInvalid);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.950 -0400", hash_original_method = "EA090255411EA799BF70BDA91FFB60AD", hash_generated_method = "FB8BFB628AAEFD856FBEF1EA5C350196")
        @Override
        public boolean isAllowed(char c) {
            addTaint(c);
            if('0'<=c&&c<='9')            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1652234319 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1364020111 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1364020111;
            }
            if('a'<=c&&c<='z')            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1882681746 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1610726735 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1610726735;
            }
            if('A'<=c&&c<='Z')            
            {
            boolean varB326B5062B2F0E69046810717534CB09_2069793688 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236591637 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236591637;
            }
            if('.'==c)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_43753208 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_163828509 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_163828509;
            }
            boolean var68934A3E9455FA72420237EB05902327_1480442194 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101951208 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_101951208;
            // ---------- Original Method ----------
            //if ('0' <= c && c <= '9')
                //return true;
            //if ('a' <= c && c <= 'z')
                //return true;
            //if ('A' <= c && c <= 'Z')
                //return true;
            //if ('.' == c)
                //return true;
            //return false;
        }

        
    }


    
    public static class UsernameFilterGeneric extends LoginFilter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.952 -0400", hash_original_method = "3EF9D0B79368B0CAD969F082FA9E5349", hash_generated_method = "56190FE9E55E1EBD2C27EC77704BC043")
        public  UsernameFilterGeneric() {
            super(false);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.953 -0400", hash_original_method = "FF170888A57F50F2D0008FD8A0147333", hash_generated_method = "ADC8959AD98FC6DF4F0FD0F8142D7E3A")
        public  UsernameFilterGeneric(boolean appendInvalid) {
            super(appendInvalid);
            addTaint(appendInvalid);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.956 -0400", hash_original_method = "EC6C424D378438448B4A8A5E7AB18032", hash_generated_method = "AC3D61AE1EBDC655E9B05AA5191DA3BD")
        @Override
        public boolean isAllowed(char c) {
            addTaint(c);
            if('0'<=c&&c<='9')            
            {
            boolean varB326B5062B2F0E69046810717534CB09_975626773 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383949833 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383949833;
            }
            if('a'<=c&&c<='z')            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1742166001 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1581615291 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1581615291;
            }
            if('A'<=c&&c<='Z')            
            {
            boolean varB326B5062B2F0E69046810717534CB09_232727373 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274644066 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_274644066;
            }
            if(mAllowed.indexOf(c)!=-1)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_381992208 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002514400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002514400;
            }
            boolean var68934A3E9455FA72420237EB05902327_714367990 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2072231539 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2072231539;
            // ---------- Original Method ----------
            //if ('0' <= c && c <= '9')
                //return true;
            //if ('a' <= c && c <= 'z')
                //return true;
            //if ('A' <= c && c <= 'Z')
                //return true;
            //if (mAllowed.indexOf(c) != -1)
                //return true;
            //return false;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.957 -0400", hash_original_field = "5B63E8F7EAB756EDBD3509FF86FB7C2A", hash_generated_field = "5EE276D814B8B8C02C67FFEB9EEDEC88")

        private static final String mAllowed = "@_-+.";
    }


    
    public static class PasswordFilterGMail extends LoginFilter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.958 -0400", hash_original_method = "7ED5290185A875249860FBE4726E3C6E", hash_generated_method = "505F6B7FC55A40F29FDBA2B0B44897DF")
        public  PasswordFilterGMail() {
            super(false);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.959 -0400", hash_original_method = "8321E14D7817F1BAC42CF87FDC96FDDB", hash_generated_method = "5600A81BBFDB6A976394DF0F52FA7BF6")
        public  PasswordFilterGMail(boolean appendInvalid) {
            super(appendInvalid);
            addTaint(appendInvalid);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.962 -0400", hash_original_method = "4412114A37452D89F30E32A2FFDB0CCD", hash_generated_method = "9C3614227680DDC788B2C58A68FDEA38")
        @Override
        public boolean isAllowed(char c) {
            addTaint(c);
            if(32<=c&&c<=127)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1844779397 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1762111037 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1762111037;
            }
            if(160<=c&&c<=255)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_820012040 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161063329 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_161063329;
            }
            boolean var68934A3E9455FA72420237EB05902327_178869601 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1993493911 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1993493911;
            // ---------- Original Method ----------
            //if (32 <= c && c <= 127)
                //return true;
            //if (160 <= c && c <= 255)
                //return true;
            //return false;
        }

        
    }


    
}

