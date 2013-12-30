package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.DragEvent;
import android.view.IWindow;
import android.view.IWindowSession;





public class BaseIWindow extends IWindow.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.371 -0500", hash_original_field = "380F2E6581760A76AE57EA2F3E243A67", hash_generated_field = "223A16F1854300B80614F0CB3E74795C")

    private IWindowSession mSession;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.373 -0500", hash_original_field = "8913F44A11D4302ED7B203F0CF0BA11B", hash_generated_field = "FF1C2ACF522E25E367200C0572BE8DA1")

    public int mSeq;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "FC9DB18371C1F1F6390E84279F9FE89A", hash_generated_method = "FC9DB18371C1F1F6390E84279F9FE89A")
    public BaseIWindow ()
    {
        //Synthesized constructor
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.375 -0500", hash_original_method = "DDDF8BE863F51F4784FBED4F44364C1D", hash_generated_method = "FC5608BF9649B95794B6CB4D86CACA9E")
    
public void setSession(IWindowSession session) {
        mSession = session;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.378 -0500", hash_original_method = "B78D43805956C22534D670D6CA75C80F", hash_generated_method = "05629CD3EF4013B08D0E1D8113A101D9")
    
public void resized(int w, int h, Rect coveredInsets,
            Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
        if (reportDraw) {
            try {
                mSession.finishDrawing(this);
            } catch (RemoteException e) {
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.380 -0500", hash_original_method = "BE0716F4AD0CF82E07CDF7A02946EA01", hash_generated_method = "BA4100E40CE17026F52C39C8640512C9")
    
public void dispatchAppVisibility(boolean visible) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.382 -0500", hash_original_method = "772CEEEC7D5AEF0AF70740664444DBC4", hash_generated_method = "21248AB5EE21A53F3FAB025EA9F3A312")
    
public void dispatchGetNewSurface() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.384 -0500", hash_original_method = "D905966528548D16DAB92D4F551B9EC2", hash_generated_method = "E2F4D6B8D71452D905ECB6DEB92CD3C2")
    
public void windowFocusChanged(boolean hasFocus, boolean touchEnabled) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.387 -0500", hash_original_method = "FFE9D2CBC83B323644FA8C6DFE6F40CA", hash_generated_method = "7EBEC9D17C27061D1FB56967BC4F83EC")
    
public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.389 -0500", hash_original_method = "829D6830743782B159BBDA8D0B21AA05", hash_generated_method = "4FA0207847B94B1E960F6577058D8594")
    
public void closeSystemDialogs(String reason) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.391 -0500", hash_original_method = "5012B02F4729E57505C4DA5AF3CD3EF7", hash_generated_method = "90245B23926936E681288F123BF79586")
    
public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep, boolean sync) {
        if (sync) {
            try {
                mSession.wallpaperOffsetsComplete(asBinder());
            } catch (RemoteException e) {
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.394 -0500", hash_original_method = "3961AB29F0B7DEEA47B4CBEA679C2606", hash_generated_method = "0DC960F0986569123D021DF803CA6795")
    
public void dispatchDragEvent(DragEvent event) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.396 -0500", hash_original_method = "0828E805F96F67CD22A73377A61D4574", hash_generated_method = "96192035C84A088388223A2C5221B05A")
    
public void dispatchSystemUiVisibilityChanged(int seq, int globalUi,
            int localValue, int localChanges) {
        mSeq = seq;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.399 -0500", hash_original_method = "CCCF2ED340559A471760B73050C6F938", hash_generated_method = "0CE14FED93FBC5C805CC9D0EA70DB142")
    
public void dispatchWallpaperCommand(String action, int x, int y,
            int z, Bundle extras, boolean sync) {
        if (sync) {
            try {
                mSession.wallpaperCommandComplete(asBinder(), null);
            } catch (RemoteException e) {
            }
        }
    }

    
}

