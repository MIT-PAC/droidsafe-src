package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.DragEvent;
import android.view.IWindow;
import android.view.IWindowSession;

public class BaseIWindow extends IWindow.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.151 -0400", hash_original_field = "585864B1433B33593F88424BEC9E09EF", hash_generated_field = "223A16F1854300B80614F0CB3E74795C")

    private IWindowSession mSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.151 -0400", hash_original_field = "61A42A5C5A78D6632BB173F2CD44E374", hash_generated_field = "FF1C2ACF522E25E367200C0572BE8DA1")

    public int mSeq;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.151 -0400", hash_original_method = "FC9DB18371C1F1F6390E84279F9FE89A", hash_generated_method = "FC9DB18371C1F1F6390E84279F9FE89A")
    public BaseIWindow ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.151 -0400", hash_original_method = "DDDF8BE863F51F4784FBED4F44364C1D", hash_generated_method = "5C18C6F8866A52B959AE5703CF9BE0CA")
    public void setSession(IWindowSession session) {
        mSession = session;
        // ---------- Original Method ----------
        //mSession = session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.152 -0400", hash_original_method = "B78D43805956C22534D670D6CA75C80F", hash_generated_method = "B168783B5E02CD3C227BAB70CFA88C70")
    public void resized(int w, int h, Rect coveredInsets,
            Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
        {
            try 
            {
                mSession.finishDrawing(this);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(w);
        addTaint(h);
        addTaint(coveredInsets.getTaint());
        addTaint(visibleInsets.getTaint());
        addTaint(reportDraw);
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        //if (reportDraw) {
            //try {
                //mSession.finishDrawing(this);
            //} catch (RemoteException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.152 -0400", hash_original_method = "BE0716F4AD0CF82E07CDF7A02946EA01", hash_generated_method = "8DFBCE56B7B4A7917AC4BEE9870F8E58")
    public void dispatchAppVisibility(boolean visible) {
        addTaint(visible);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.152 -0400", hash_original_method = "772CEEEC7D5AEF0AF70740664444DBC4", hash_generated_method = "DFC4B13DC642E23ADDFEF747CDDDFBCC")
    public void dispatchGetNewSurface() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.152 -0400", hash_original_method = "D905966528548D16DAB92D4F551B9EC2", hash_generated_method = "E7E6E5729CF2AEADF9A696DAA3942486")
    public void windowFocusChanged(boolean hasFocus, boolean touchEnabled) {
        addTaint(hasFocus);
        addTaint(touchEnabled);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.160 -0400", hash_original_method = "FFE9D2CBC83B323644FA8C6DFE6F40CA", hash_generated_method = "2DA19C290949804107091EF7511AD672")
    public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
        addTaint(command.getTaint());
        addTaint(parameters.getTaint());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.161 -0400", hash_original_method = "829D6830743782B159BBDA8D0B21AA05", hash_generated_method = "C351D757C39B19E87F3410EB56CC398B")
    public void closeSystemDialogs(String reason) {
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.161 -0400", hash_original_method = "5012B02F4729E57505C4DA5AF3CD3EF7", hash_generated_method = "A80B0924500FD83C5263941E3C493AB1")
    public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep, boolean sync) {
        {
            try 
            {
                mSession.wallpaperOffsetsComplete(asBinder());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(x);
        addTaint(y);
        addTaint(xStep);
        addTaint(yStep);
        addTaint(sync);
        // ---------- Original Method ----------
        //if (sync) {
            //try {
                //mSession.wallpaperOffsetsComplete(asBinder());
            //} catch (RemoteException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.162 -0400", hash_original_method = "3961AB29F0B7DEEA47B4CBEA679C2606", hash_generated_method = "C6A1E92761703C898F3F7552B458E17F")
    public void dispatchDragEvent(DragEvent event) {
        addTaint(event.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.162 -0400", hash_original_method = "0828E805F96F67CD22A73377A61D4574", hash_generated_method = "87F05D610A6CAE918555EF7B86391FA4")
    public void dispatchSystemUiVisibilityChanged(int seq, int globalUi,
            int localValue, int localChanges) {
        mSeq = seq;
        addTaint(globalUi);
        addTaint(localValue);
        addTaint(localChanges);
        // ---------- Original Method ----------
        //mSeq = seq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.162 -0400", hash_original_method = "CCCF2ED340559A471760B73050C6F938", hash_generated_method = "E5ECD94AF67BA2E08E0E83D3B09FB576")
    public void dispatchWallpaperCommand(String action, int x, int y,
            int z, Bundle extras, boolean sync) {
        {
            try 
            {
                mSession.wallpaperCommandComplete(asBinder(), null);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(action.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(z);
        addTaint(extras.getTaint());
        addTaint(sync);
        // ---------- Original Method ----------
        //if (sync) {
            //try {
                //mSession.wallpaperCommandComplete(asBinder(), null);
            //} catch (RemoteException e) {
            //}
        //}
    }

    
}

