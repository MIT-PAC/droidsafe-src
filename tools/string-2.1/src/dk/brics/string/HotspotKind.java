package dk.brics.string;

/**
 * There are two kinds of hotspots, originating from two different runtime methods.
 */
public enum HotspotKind {
    /**
     * <code>ANALYZE</code> hotspots originate from
     * {@link dk.brics.string.runtime.Strings#analyze Strings.analyze} calls.
     */
    ANALYZE,

    /**
     * <code>CHECK</code> hotspots originate from
     * {@link dk.brics.string.runtime.Strings#check Strings.check} calls.
     */
    CHECK
};
