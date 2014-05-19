package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class TimerTask implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.655 -0500", hash_original_field = "DA2A3FDBCC0B9B91674644DF55F373AF", hash_generated_field = "444D55F7E87A46DB2BC47514D8909813")

    final Object lock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.657 -0500", hash_original_field = "FE3EA34D60211B160636288AB9105E56", hash_generated_field = "FE3EA34D60211B160636288AB9105E56")

    boolean cancelled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.660 -0500", hash_original_field = "4E7289569777021C55877266ACAD1845", hash_generated_field = "4E7289569777021C55877266ACAD1845")

    long when;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.662 -0500", hash_original_field = "21C6B258F031958D40A6DAC5279E0EE8", hash_generated_field = "21C6B258F031958D40A6DAC5279E0EE8")

    long period;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.664 -0500", hash_original_field = "28408F90702CEE9413B76824113C0001", hash_generated_field = "28408F90702CEE9413B76824113C0001")

    boolean fixedRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.666 -0500", hash_original_field = "9BE5C059A85499BE0D59A5BA2926A280", hash_generated_field = "2A084075C1B0C69D6880285CCF039DBD")

    private long scheduledTime;

    /**
     * Creates a new {@code TimerTask}.
     */
    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.676 -0500", hash_original_method = "41AFEAE31E9AFC51442EB32F1B803F09", hash_generated_method = "878D1D0189BFD255ECF89AA7A788F34D")
    
protected TimerTask() {
    }

    /*
     * Method called from the Timer for synchronized getting of when field.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.669 -0500", hash_original_method = "61DD03075FF1927377D7CEC2AE97ED1A", hash_generated_method = "61DD03075FF1927377D7CEC2AE97ED1A")
    
long getWhen() {
        synchronized (lock) {
            return when;
        }
    }

    /*
     * Method called from the Timer object when scheduling an event @param time
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.671 -0500", hash_original_method = "AE139E2AB369CB1B1C48D00C62C96DCB", hash_generated_method = "AE139E2AB369CB1B1C48D00C62C96DCB")
    
void setScheduledTime(long time) {
        synchronized (lock) {
            scheduledTime = time;
        }
    }

    /*
     * Is TimerTask scheduled into any timer?
     *
     * @return {@code true} if the timer task is scheduled, {@code false}
     * otherwise.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.673 -0500", hash_original_method = "0BC3D740AEEAEAE472C572E03A1906A5", hash_generated_method = "0BC3D740AEEAEAE472C572E03A1906A5")
    
boolean isScheduled() {
        synchronized (lock) {
            return when > 0 || scheduledTime > 0;
        }
    }

    /**
     * Cancels the {@code TimerTask} and removes it from the {@code Timer}'s queue. Generally, it
     * returns {@code false} if the call did not prevent a {@code TimerTask} from running at
     * least once. Subsequent calls have no effect.
     *
     * @return {@code true} if the call prevented a scheduled execution
     *         from taking place, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.678 -0500", hash_original_method = "1700D6DAFB7BC2815E6FE0B3C1768102", hash_generated_method = "757563EDEEEE91142A694518B64A4DEE")
    
public boolean cancel() {
        synchronized (lock) {
            boolean willRun = !cancelled && when > 0;
            cancelled = true;
            return willRun;
        }
    }

    /**
     * Returns the scheduled execution time. If the task execution is in
     * progress it returns the execution time of the ongoing task. Tasks which
     * have not yet run return an undefined value.
     *
     * @return the most recent execution time.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.681 -0500", hash_original_method = "BAEF9B11043548CD5E25A5F175F23300", hash_generated_method = "41489AE038F8D803A78678372C87C147")
    
public long scheduledExecutionTime() {
        synchronized (lock) {
            return scheduledTime;
        }
    }

    /**
     * The task to run should be specified in the implementation of the {@code run()}
     * method.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.EXEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.683 -0500", hash_original_method = "2C6A443C83148E86AAD705D9EE784F75", hash_generated_method = "5BBE1BCB74D1FAFBB58FE7F038D48F66")
    
public abstract void run();
    
}

