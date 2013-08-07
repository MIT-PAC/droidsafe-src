package android.speech.tts;

// Droidsafe Imports
import droidsafe.annotations.*;




public abstract class UtteranceProgressListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.584 -0400", hash_original_method = "D96B1FA74926A4581FA2AC04698293D6", hash_generated_method = "D96B1FA74926A4581FA2AC04698293D6")
    public UtteranceProgressListener ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract void onStart(String utteranceId);

    
    @DSModeled(DSC.SAFE)
    public abstract void onDone(String utteranceId);

    
    @DSModeled(DSC.SAFE)
    public abstract void onError(String utteranceId);

    
    static UtteranceProgressListener from(
            final TextToSpeech.OnUtteranceCompletedListener listener) {
        return new UtteranceProgressListener() {
            @DSModeled(DSC.SAFE)
    @Override
            public synchronized void onDone(String utteranceId) {
                listener.onUtteranceCompleted(utteranceId);
            }
            @DSModeled(DSC.SAFE)
    @Override
            public void onError(String utteranceId) {
                listener.onUtteranceCompleted(utteranceId);
            }
            @DSModeled(DSC.SAFE)
    @Override
            public void onStart(String utteranceId) {
            }
        };
    }

    
}

