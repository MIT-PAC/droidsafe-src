package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;

public class Gravity {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.407 -0400", hash_original_method = "C8FD8F8974FEA261C49D0525477D6D45", hash_generated_method = "C8FD8F8974FEA261C49D0525477D6D45")
    public Gravity ()
    {
        //Synthesized constructor
    }


    public static void apply(int gravity, int w, int h, Rect container, Rect outRect) {
        apply(gravity, w, h, container, 0, 0, outRect);
    }

    
    public static void apply(int gravity, int w, int h, Rect container,
            Rect outRect, int layoutDirection) {
        int absGravity = getAbsoluteGravity(gravity, layoutDirection);
        apply(absGravity, w, h, container, 0, 0, outRect);
    }

    
    @DSModeled(DSC.SAFE)
    public static void apply(int gravity, int w, int h, Rect container,
            int xAdj, int yAdj, Rect outRect) {
        switch (gravity&((AXIS_PULL_BEFORE|AXIS_PULL_AFTER)<<AXIS_X_SHIFT)) {
            case 0:
                outRect.left = container.left
                        + ((container.right - container.left - w)/2) + xAdj;
                outRect.right = outRect.left + w;
                if ((gravity&(AXIS_CLIP<<AXIS_X_SHIFT))
                        == (AXIS_CLIP<<AXIS_X_SHIFT)) {
                    if (outRect.left < container.left) {
                        outRect.left = container.left;
                    }
                    if (outRect.right > container.right) {
                        outRect.right = container.right;
                    }
                }
                break;
            case AXIS_PULL_BEFORE<<AXIS_X_SHIFT:
                outRect.left = container.left + xAdj;
                outRect.right = outRect.left + w;
                if ((gravity&(AXIS_CLIP<<AXIS_X_SHIFT))
                        == (AXIS_CLIP<<AXIS_X_SHIFT)) {
                    if (outRect.right > container.right) {
                        outRect.right = container.right;
                    }
                }
                break;
            case AXIS_PULL_AFTER<<AXIS_X_SHIFT:
                outRect.right = container.right - xAdj;
                outRect.left = outRect.right - w;
                if ((gravity&(AXIS_CLIP<<AXIS_X_SHIFT))
                        == (AXIS_CLIP<<AXIS_X_SHIFT)) {
                    if (outRect.left < container.left) {
                        outRect.left = container.left;
                    }
                }
                break;
            default:
                outRect.left = container.left + xAdj;
                outRect.right = container.right + xAdj;
                break;
        }
        switch (gravity&((AXIS_PULL_BEFORE|AXIS_PULL_AFTER)<<AXIS_Y_SHIFT)) {
            case 0:
                outRect.top = container.top
                        + ((container.bottom - container.top - h)/2) + yAdj;
                outRect.bottom = outRect.top + h;
                if ((gravity&(AXIS_CLIP<<AXIS_Y_SHIFT))
                        == (AXIS_CLIP<<AXIS_Y_SHIFT)) {
                    if (outRect.top < container.top) {
                        outRect.top = container.top;
                    }
                    if (outRect.bottom > container.bottom) {
                        outRect.bottom = container.bottom;
                    }
                }
                break;
            case AXIS_PULL_BEFORE<<AXIS_Y_SHIFT:
                outRect.top = container.top + yAdj;
                outRect.bottom = outRect.top + h;
                if ((gravity&(AXIS_CLIP<<AXIS_Y_SHIFT))
                        == (AXIS_CLIP<<AXIS_Y_SHIFT)) {
                    if (outRect.bottom > container.bottom) {
                        outRect.bottom = container.bottom;
                    }
                }
                break;
            case AXIS_PULL_AFTER<<AXIS_Y_SHIFT:
                outRect.bottom = container.bottom - yAdj;
                outRect.top = outRect.bottom - h;
                if ((gravity&(AXIS_CLIP<<AXIS_Y_SHIFT))
                        == (AXIS_CLIP<<AXIS_Y_SHIFT)) {
                    if (outRect.top < container.top) {
                        outRect.top = container.top;
                    }
                }
                break;
            default:
                outRect.top = container.top + yAdj;
                outRect.bottom = container.bottom + yAdj;
                break;
        }
    }

    
    public static void applyDisplay(int gravity, Rect display, Rect inoutObj) {
        if ((gravity&DISPLAY_CLIP_VERTICAL) != 0) {
            if (inoutObj.top < display.top) inoutObj.top = display.top;
            if (inoutObj.bottom > display.bottom) inoutObj.bottom = display.bottom;
        } else {
            int off = 0;
            if (inoutObj.top < display.top) off = display.top-inoutObj.top;
            else if (inoutObj.bottom > display.bottom) off = display.bottom-inoutObj.bottom;
            if (off != 0) {
                if (inoutObj.height() > (display.bottom-display.top)) {
                    inoutObj.top = display.top;
                    inoutObj.bottom = display.bottom;
                } else {
                    inoutObj.top += off;
                    inoutObj.bottom += off;
                }
            }
        }
        if ((gravity&DISPLAY_CLIP_HORIZONTAL) != 0) {
            if (inoutObj.left < display.left) inoutObj.left = display.left;
            if (inoutObj.right > display.right) inoutObj.right = display.right;
        } else {
            int off = 0;
            if (inoutObj.left < display.left) off = display.left-inoutObj.left;
            else if (inoutObj.right > display.right) off = display.right-inoutObj.right;
            if (off != 0) {
                if (inoutObj.width() > (display.right-display.left)) {
                    inoutObj.left = display.left;
                    inoutObj.right = display.right;
                } else {
                    inoutObj.left += off;
                    inoutObj.right += off;
                }
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isVertical(int gravity) {
        return gravity > 0 && (gravity & VERTICAL_GRAVITY_MASK) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isHorizontal(int gravity) {
        return gravity > 0 && (gravity & RELATIVE_HORIZONTAL_GRAVITY_MASK) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getAbsoluteGravity(int gravity, int layoutDirection) {
        int result = gravity;
        if ((result & RELATIVE_LAYOUT_DIRECTION) > 0) {
            if ((result & Gravity.START) == Gravity.START) {
                result &= ~START;
                if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                    result |= RIGHT;
                } else {
                    result |= LEFT;
                }
            } else if ((result & Gravity.END) == Gravity.END) {
                result &= ~END;
                if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                    result |= LEFT;
                } else {
                    result |= RIGHT;
                }
            }
            result &= ~RELATIVE_LAYOUT_DIRECTION;
        }
        return result;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "6346F2F32BD4A8398CEDA03386C67613", hash_generated_field = "390CB23372FC422A26F70D8CAA3787AE")

    public static final int NO_GRAVITY = 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "97CD3802575D29C43E1552FA06FF9934", hash_generated_field = "8978B1B8922D9D459B4196E16A71EB1A")

    public static final int AXIS_SPECIFIED = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "AFBECA4DF271D4C00C0409A6BE6651F1", hash_generated_field = "CE35F444D19571BBF6AF333D2602B8F0")

    public static final int AXIS_PULL_BEFORE = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "C08D9986767919A6E2DAB860197935F1", hash_generated_field = "F522FAD8644313F78DCC58FF24E0BBF9")

    public static final int AXIS_PULL_AFTER = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "CA00F029E502ED71080A5407EB547C60", hash_generated_field = "93F6D549C98ECD2D78B9ED26DCC83C5F")

    public static final int AXIS_CLIP = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "97AAB6C550EAADC94405648985D38282", hash_generated_field = "6842EB52A3DD780729DC815D258B02C3")

    public static final int AXIS_X_SHIFT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "C0611F0EE07235C3760AC10F6C50C1A9", hash_generated_field = "E2A70E5A0ED91CEBE7E165584A1CFAC9")

    public static final int AXIS_Y_SHIFT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "41DD61C6D520216E0F3BC0A57E0B6E15", hash_generated_field = "4543CF1E6C1998A4DC4212D7AA76F4E5")

    public static final int TOP = (AXIS_PULL_BEFORE|AXIS_SPECIFIED)<<AXIS_Y_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "76DA4661FFE9E354EC9D1D43630BDA76", hash_generated_field = "6482F45E29957FD4A1BAAA262B4A0224")

    public static final int BOTTOM = (AXIS_PULL_AFTER|AXIS_SPECIFIED)<<AXIS_Y_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "0FDCD614555A988348040453CD7AB215", hash_generated_field = "94FA706DC7C7F16A4EEF7E1D96B66CFC")

    public static final int LEFT = (AXIS_PULL_BEFORE|AXIS_SPECIFIED)<<AXIS_X_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "3FDBA15CA17C836FFFF3BB85F8A68C79", hash_generated_field = "55F9F16F230137BA797030C6549658A0")

    public static final int RIGHT = (AXIS_PULL_AFTER|AXIS_SPECIFIED)<<AXIS_X_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "66B772B1841C1DD2B38FDDE66F479653", hash_generated_field = "DC249D4AF2F5F57172D9BBCDB08ADB70")

    public static final int CENTER_VERTICAL = AXIS_SPECIFIED<<AXIS_Y_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "9A61DDDBBBC75C17A732754CF4CB2803", hash_generated_field = "68CED1E5D4862B20B89F5265817A81FC")

    public static final int FILL_VERTICAL = TOP|BOTTOM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.409 -0400", hash_original_field = "F4B1471727B65C61FB4FFA07B1E6E89C", hash_generated_field = "5DCBC025165DD0ADD592A9825770EA09")

    public static final int CENTER_HORIZONTAL = AXIS_SPECIFIED<<AXIS_X_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "2F80FF2D7CB2FCFF5CAFDF8E36C70933", hash_generated_field = "2F3A963F3BBC49447711EB2AB15492D2")

    public static final int FILL_HORIZONTAL = LEFT|RIGHT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "1A2576E653B2EB20D06FCD378F0640F5", hash_generated_field = "1EA247B4FBEEDBF774D1F9E6BC25FE7B")

    public static final int CENTER = CENTER_VERTICAL|CENTER_HORIZONTAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "19BCC4201AD7D691A4B8EE11BF0D647A", hash_generated_field = "624E4ECF6AF63A78B4AAC5C10141CE60")

    public static final int FILL = FILL_VERTICAL|FILL_HORIZONTAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "127680891F36800366B9CE7CB4D7323F", hash_generated_field = "6D2EA4D67AE0F464C066B7C53E70822C")

    public static final int CLIP_VERTICAL = AXIS_CLIP<<AXIS_Y_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "6DA8BE7926E72832FC34E38495024EBF", hash_generated_field = "7A169A7667F3BA5C61B2181C9B881A80")

    public static final int CLIP_HORIZONTAL = AXIS_CLIP<<AXIS_X_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "B1D498B1B83BD850955482245E997782", hash_generated_field = "244F6F66FA77B1BA261012A1DB3B883F")

    public static final int RELATIVE_LAYOUT_DIRECTION = 0x00800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "BE25A7BE4C55F2E8812B429FF944D080", hash_generated_field = "1C56FBD8CA95A9E98FCA4FF47C24D04F")

    public static final int HORIZONTAL_GRAVITY_MASK = (AXIS_SPECIFIED |
            AXIS_PULL_BEFORE | AXIS_PULL_AFTER) << AXIS_X_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "B3A83C9B327D95AF1CD841F8FD764BE2", hash_generated_field = "44998F3F040B027230058CC6F3114A95")

    public static final int VERTICAL_GRAVITY_MASK = (AXIS_SPECIFIED |
            AXIS_PULL_BEFORE | AXIS_PULL_AFTER) << AXIS_Y_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "A58A69978B0EAE604BC0D497DD02FB36", hash_generated_field = "DEC6074C673D2089C0B0FB2418871762")

    public static final int DISPLAY_CLIP_VERTICAL = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "E60F57B1B6F61E78A514CB3971160D89", hash_generated_field = "CD222F7DEC3C187C417094586EC9F381")

    public static final int DISPLAY_CLIP_HORIZONTAL = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "8B4885F41F0233ADBF985CF1284B5B8F", hash_generated_field = "29F1BD0637D8F7679C75FF7412266658")

    public static final int START = RELATIVE_LAYOUT_DIRECTION | LEFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "C33642C68A296E4C3B611C75A3EE5E13", hash_generated_field = "37E79D6AC565BF5673CD41E5C4943161")

    public static final int END = RELATIVE_LAYOUT_DIRECTION | RIGHT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.410 -0400", hash_original_field = "6F10ED0D9CAC3033F5CB1B681EF9448A", hash_generated_field = "8FE6AB1D802BBC04FC5F75B277F16533")

    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = START | END;
}

