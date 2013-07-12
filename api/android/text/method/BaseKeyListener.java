package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.KeyEvent;
import android.view.View;
import android.text.*;
import android.text.method.TextKeyListener.Capitalize;
import android.widget.TextView;

public abstract class BaseKeyListener extends MetaKeyKeyListener implements KeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.334 -0400", hash_original_method = "457D2BEC00B20336593EA76F83128980", hash_generated_method = "457D2BEC00B20336593EA76F83128980")
    public BaseKeyListener ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.335 -0400", hash_original_method = "C743EFD1D596571F6949DCD9BEFE98FE", hash_generated_method = "3CF245821B784A58BF17DCB8811A7CE5")
    public boolean backspace(View view, Editable content, int keyCode, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        boolean var4FB884506044A099219D84656CE1EA96_1418558667 = (backspaceOrForwardDelete(view, content, keyCode, event, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2147415087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2147415087;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.335 -0400", hash_original_method = "44D414C093A103E2D46C2C9EBFB633B7", hash_generated_method = "588E450185E2EEF1281B80C4B85DECA3")
    public boolean forwardDelete(View view, Editable content, int keyCode, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        boolean var5B5A139D3657A639756C091F15F52ABA_710286140 = (backspaceOrForwardDelete(view, content, keyCode, event, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_201390407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_201390407;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.336 -0400", hash_original_method = "070DF95C0353A773EEB24BBDC2D8297C", hash_generated_method = "C425B4149CDFB6184579DBC9D5FEB85D")
    private boolean backspaceOrForwardDelete(View view, Editable content, int keyCode,
            KeyEvent event, boolean isForwardDelete) {
        addTaint(isForwardDelete);
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
    if(!KeyEvent.metaStateHasNoModifiers(event.getMetaState()
                & ~(KeyEvent.META_SHIFT_MASK | KeyEvent.META_ALT_MASK)))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1801798689 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584621408 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_584621408;
        } 
    if(deleteSelection(view, content))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_805082801 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1008869247 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1008869247;
        } 
    if(event.isAltPressed() || getMetaState(content, META_ALT_ON) == 1)        
        {
    if(deleteLine(view, content))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_663858443 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1184677871 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1184677871;
            } 
        } 
        final int start = Selection.getSelectionEnd(content);
        int end;
    if(isForwardDelete || event.isShiftPressed()
                || getMetaState(content, META_SHIFT_ON) == 1)        
        {
            end = TextUtils.getOffsetAfter(content, start);
        } 
        else
        {
            end = TextUtils.getOffsetBefore(content, start);
        } 
    if(start != end)        
        {
            content.delete(Math.min(start, end), Math.max(start, end));
            boolean varB326B5062B2F0E69046810717534CB09_1912852830 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369615726 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369615726;
        } 
        boolean var68934A3E9455FA72420237EB05902327_411227181 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748030038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748030038;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.337 -0400", hash_original_method = "2C36007D0B232577504AED53A81D7DC4", hash_generated_method = "2153E3237345E644D1D44FF4E4AD298B")
    private boolean deleteSelection(View view, Editable content) {
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        int selectionStart = Selection.getSelectionStart(content);
        int selectionEnd = Selection.getSelectionEnd(content);
    if(selectionEnd < selectionStart)        
        {
            int temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        } 
    if(selectionStart != selectionEnd)        
        {
            content.delete(selectionStart, selectionEnd);
            boolean varB326B5062B2F0E69046810717534CB09_135608156 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_460823389 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_460823389;
        } 
        boolean var68934A3E9455FA72420237EB05902327_827964282 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_634122276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_634122276;
        
        
        
        
            
            
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.338 -0400", hash_original_method = "AAA6731DEEEC720845223B285BF37660", hash_generated_method = "CB05633C6C3235CADACA048274277528")
    private boolean deleteLine(View view, Editable content) {
        addTaint(content.getTaint());
        addTaint(view.getTaint());
    if(view instanceof TextView)        
        {
            final Layout layout = ((TextView) view).getLayout();
    if(layout != null)            
            {
                final int line = layout.getLineForOffset(Selection.getSelectionStart(content));
                final int start = layout.getLineStart(line);
                final int end = layout.getLineEnd(line);
    if(end != start)                
                {
                    content.delete(start, end);
                    boolean varB326B5062B2F0E69046810717534CB09_95304990 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_964593971 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_964593971;
                } 
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1239194838 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656488575 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656488575;
        
        
            
            
                
                
                
                
                    
                    
                
            
        
        
    }

    
        @DSModeled(DSC.SAFE)
    static int makeTextContentType(Capitalize caps, boolean autoText) {
        int contentType = InputType.TYPE_CLASS_TEXT;
        switch (caps) {
            case CHARACTERS:
                contentType |= InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
                break;
            case WORDS:
                contentType |= InputType.TYPE_TEXT_FLAG_CAP_WORDS;
                break;
            case SENTENCES:
                contentType |= InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
                break;
        }
        if (autoText) {
            contentType |= InputType.TYPE_TEXT_FLAG_AUTO_CORRECT;
        }
        return contentType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.340 -0400", hash_original_method = "60BF1BEA0D6A99B2655081BEC42DA13C", hash_generated_method = "C2793D00C6637F419A661941B1B8A085")
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        boolean handled;
switch(keyCode){
        case KeyEvent.KEYCODE_DEL:
        handled = backspace(view, content, keyCode, event);
        break;
        case KeyEvent.KEYCODE_FORWARD_DEL:
        handled = forwardDelete(view, content, keyCode, event);
        break;
        default:
        handled = false;
        break;
}    if(handled)        
        {
            adjustMetaAfterKeypress(content);
        } 
        boolean var5F21C6842D9E32D23C5A1CD0B3EB473F_1908598581 = (super.onKeyDown(view, content, keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2109880754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2109880754;
        
        
        
            
                
                
            
                
                
            
                
                
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.341 -0400", hash_original_method = "D291AC92E2A4746C8F1BADA03A5CE619", hash_generated_method = "87626ED1620C54864E4A82C148121A55")
    public boolean onKeyOther(View view, Editable content, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(content.getTaint());
        addTaint(view.getTaint());
    if(event.getAction() != KeyEvent.ACTION_MULTIPLE
                || event.getKeyCode() != KeyEvent.KEYCODE_UNKNOWN)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1876768702 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345522076 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_345522076;
        } 
        int selectionStart = Selection.getSelectionStart(content);
        int selectionEnd = Selection.getSelectionEnd(content);
    if(selectionEnd < selectionStart)        
        {
            int temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        } 
        CharSequence text = event.getCharacters();
    if(text == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_461928941 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_586914558 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_586914558;
        } 
        content.replace(selectionStart, selectionEnd, text);
        boolean varB326B5062B2F0E69046810717534CB09_828493197 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097188196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097188196;
        
        
                
            
        
        
        
        
            
            
            
        
        
        
            
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.341 -0400", hash_original_field = "57D022DD9BDED0985347A59F06980BAE", hash_generated_field = "E30A96E800BF4F5D9EAF5982A378A4AE")

    static final Object OLD_SEL_START = new NoCopySpan.Concrete();
}

