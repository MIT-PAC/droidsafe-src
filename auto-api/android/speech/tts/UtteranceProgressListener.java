package android.speech.tts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class UtteranceProgressListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.464 -0400", hash_original_method = "D96B1FA74926A4581FA2AC04698293D6", hash_generated_method = "D96B1FA74926A4581FA2AC04698293D6")
    public UtteranceProgressListener ()
    {
        
    }

            public abstract void onStart(String utteranceId);

            public abstract void onDone(String utteranceId);

            public abstract void onError(String utteranceId);

    
    static UtteranceProgressListener from(
            final TextToSpeech.OnUtteranceCompletedListener listener) {
        return new UtteranceProgressListener() {
            @Override
            public synchronized void onDone(String utteranceId) {
                listener.onUtteranceCompleted(utteranceId);
            }
            @Override
            public void onError(String utteranceId) {
                listener.onUtteranceCompleted(utteranceId);
            }
            @Override
            public void onStart(String utteranceId) {
            }
        };
    }

    
}

