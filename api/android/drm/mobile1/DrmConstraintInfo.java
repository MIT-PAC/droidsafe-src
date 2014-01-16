package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Date;

public class DrmConstraintInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.040 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.043 -0500", hash_original_field = "2A053A5B64928AF2EEE297FDDCC581EE", hash_generated_field = "06B1C308557811937D11804124198C4C")

    private long startDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.045 -0500", hash_original_field = "76C698AA2DEDDD233ACDCF077E9DAA8A", hash_generated_field = "007E58F684D95FF371B0E147049B4F3F")

    private long endDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.048 -0500", hash_original_field = "848F9DFF1502BD12C449CA1D6F930427", hash_generated_field = "A187678ED22D20A3185A905AC22BB781")

    private long interval;

    /**
     * Construct the DrmConstraint.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.050 -0500", hash_original_method = "9EDFB4E9C7052BBC86DC69FD90E3B91B", hash_generated_method = "9EDFB4E9C7052BBC86DC69FD90E3B91B")
    
DrmConstraintInfo() {
        count = -1;
        startDate = -1;
        endDate = -1;
        interval = -1;
    }

    /**
     * Get the count constraint.
     *
     * @return the count or -1 if no limit.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.052 -0500", hash_original_method = "992035D2E84A01D01ECB6C67BA762BA7", hash_generated_method = "9A86852F51AAE1FC1A5D83AF3E4A7264")
    
public int getCount() {
        return count;
    }

    /**
     * Get the start date constraint.
     *
     * @return the start date or null if no limit.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.055 -0500", hash_original_method = "EF2100393B586A67476383923E9A11D6", hash_generated_method = "0A15BEC513001629FBF5AB27F966C299")
    
public Date getStartDate() {
        if (startDate == -1)
            return null;

        return new Date(startDate);
    }

    /**
     * Get the end date constraint.
     *
     * @return the end date or null if no limit.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.057 -0500", hash_original_method = "53A3C4742E83A3AEE0A9A0D2D307AB00", hash_generated_method = "90778F21B5C9E2BEB4AC328DB57625C8")
    
public Date getEndDate() {
        if (endDate == -1)
            return null;

        return new Date(endDate);
    }

    /**
     * Get the Interval constraint.
     *
     * @return the interval or -1 if no limit.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.059 -0500", hash_original_method = "8CAC42DB459590AAD476B56FC6D4D691", hash_generated_method = "E67FF152803801BFA2AB41BED284C3F8")
    
public long getInterval() {
        return interval;
    }
    
}

