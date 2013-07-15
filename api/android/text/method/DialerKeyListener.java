package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.KeyEvent;
import android.view.KeyCharacterMap.KeyData;
import android.text.InputType;
import android.text.Spannable;

public class DialerKeyListener extends NumberKeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.473 -0400", hash_original_method = "DB0B81FF92CA7DAE82B6AED220522587", hash_generated_method = "DB0B81FF92CA7DAE82B6AED220522587")
    public DialerKeyListener ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.474 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "0F4BB330C5179234091BB5915CDDF94A")
    @Override
    protected char[] getAcceptedChars() {
        char[] varDC0FB426D37848B5E7EB694843212E7A_102105507 = (CHARACTERS);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_150396803 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_150396803;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
        @DSModeled(DSC.SAFE)
    public static DialerKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DialerKeyListener();
        return sInstance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.474 -0400", hash_original_method = "CF04961F3F1B69C39A5779241DF2A6D8", hash_generated_method = "CFCCE80AB0EC045B62D177B200ACB3D1")
    public int getInputType() {
        int var496F5AAB1C8490E5B3C2F05773D96B87_1954744601 = (InputType.TYPE_CLASS_PHONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848252141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848252141;
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_PHONE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.475 -0400", hash_original_method = "660AADB0BB44A0CB147F8CE16CBE33CA", hash_generated_method = "CF94C2F1C90EE6FA914A6057F84FBCE1")
    protected int lookup(KeyEvent event, Spannable content) {
        addTaint(content.getTaint());
        addTaint(event.getTaint());
        int meta = event.getMetaState() | getMetaState(content);
        int number = event.getNumber();
    if((meta & (MetaKeyKeyListener.META_ALT_ON | MetaKeyKeyListener.META_SHIFT_ON)) == 0)        
        {
    if(number != 0)            
            {
                int varB1BC248A7FF2B2E95569F56DE68615DF_570129939 = (number);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693263961 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693263961;
            } //End block
        } //End block
        int match = super.lookup(event, content);
    if(match != 0)        
        {
            int varE3CC92C14A5E6DD1A7D94B6FF634D7FC_1323827927 = (match);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38029322 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38029322;
        } //End block
        else
        {
    if(meta != 0)            
            {
                KeyData kd = new KeyData();
                char[] accepted = getAcceptedChars();
    if(event.getKeyData(kd))                
                {
for(int i = 1;i < kd.meta.length;i++)
                    {
    if(ok(accepted, kd.meta[i]))                        
                        {
                            int varD401398DE384C419D6B5D7E879BE8017_1181720901 = (kd.meta[i]);
                                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_448940267 = getTaintInt();
                            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_448940267;
                        } //End block
                    } //End block
                } //End block
            } //End block
            int varB1BC248A7FF2B2E95569F56DE68615DF_2093833291 = (number);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781743151 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781743151;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.475 -0400", hash_original_field = "88EFBAD36DBE586BF632B31FDD27DD01", hash_generated_field = "4EF1E1883C2FEAA834D956A6C02634B3")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '#', '*',
            '+', '-', '(', ')', ',', '/', 'N', '.', ' ', ';'
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.475 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "056A87FCF20D35A01976664357B66FF4")

    private static DialerKeyListener sInstance;
}

