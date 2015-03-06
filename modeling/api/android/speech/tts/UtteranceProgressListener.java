/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.speech.tts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class UtteranceProgressListener {
    
    static UtteranceProgressListener from(
            final TextToSpeech.OnUtteranceCompletedListener listener) {
        return new UtteranceProgressListener() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.313 -0500", hash_original_method = "3F2D59FF03EC4B4B608FDD3E4DB90E0E", hash_generated_method = "CDF6AB67D1551C9510FD4ADC4F635C8E")
            
@Override
@DSVerified
@DSSafe(DSCat.ANDROID_CALLBACK)
            public synchronized void onDone(String utteranceId) {
                listener.onUtteranceCompleted(utteranceId);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.315 -0500", hash_original_method = "AC081657B9F9ED7B22DC9AE489D875D0", hash_generated_method = "FB287A5C8E6291B40012E8E9A6DBC6BD")
            
@Override
    
@DSVerified
@DSSafe(DSCat.ANDROID_CALLBACK)
            public void onError(String utteranceId) {
                listener.onUtteranceCompleted(utteranceId);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.318 -0500", hash_original_method = "2A033D132A2F59FA4570A621A6A54819", hash_generated_method = "4FDCB152B1D124DF1B18099983F4F5F2")
            
@DSVerified
@DSSpec(DSCat.ANDROID_CALLBACK)
@Override
            public void onStart(String utteranceId) {
                // Left unimplemented, has no equivalent in the old
                // API.
            }
        };
    }

    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.584 -0400", hash_original_method = "D96B1FA74926A4581FA2AC04698293D6", hash_generated_method = "D96B1FA74926A4581FA2AC04698293D6")
    public UtteranceProgressListener ()
    {
        //Synthesized constructor
    }
    /**
     * Called when an utterance "starts" as perceived by the caller. This will
     * be soon before audio is played back in the case of a {@link TextToSpeech#speak}
     * or before the first bytes of a file are written to storage in the case
     * of {@link TextToSpeech#synthesizeToFile}.
     *
     * @param utteranceId the utterance ID of the utterance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.305 -0500", hash_original_method = "FFE6BB9781067F74360DC2FAF20BAAD4", hash_generated_method = "DB2874D7322015463928183D4FBFE979")
    
public abstract void onStart(String utteranceId);

    /**
     * Called when an utterance has successfully completed processing.
     * All audio will have been played back by this point for audible output, and all
     * output will have been written to disk for file synthesis requests.
     *
     * This request is guaranteed to be called after {@link #onStart(String)}.
     *
     * @param utteranceId the utterance ID of the utterance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.307 -0500", hash_original_method = "48716F662DF6D18F3D98A179CB01ECD6", hash_generated_method = "3180F5A99418CD7817DE8C77D3B83701")
    
public abstract void onDone(String utteranceId);

    /**
     * Called when an error has occurred during processing. This can be called
     * at any point in the synthesis process. Note that there might be calls
     * to {@link #onStart(String)} for specified utteranceId but there will never
     * be a call to both {@link #onDone(String)} and {@link #onError(String)} for
     * the same utterance.
     *
     * @param utteranceId the utterance ID of the utterance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.309 -0500", hash_original_method = "B478909748E14FD8A516D3C92795C8CC", hash_generated_method = "605DC1C1145DE80DDE09A8BDBDACC33A")
    
public abstract void onError(String utteranceId);
    
}

