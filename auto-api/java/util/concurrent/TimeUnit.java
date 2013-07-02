package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public enum TimeUnit {
    NANOSECONDS {
        @DSModeled(DSC.SAFE)
    public long toNanos(long d)   { return d; }
        @DSModeled(DSC.SAFE)
    public long toMicros(long d)  { return d/(C1/C0); }
        @DSModeled(DSC.SAFE)
    public long toMillis(long d)  { return d/(C2/C0); }
        @DSModeled(DSC.SAFE)
    public long toSeconds(long d) { return d/(C3/C0); }
        @DSModeled(DSC.SAFE)
    public long toMinutes(long d) { return d/(C4/C0); }
        @DSModeled(DSC.SAFE)
    public long toHours(long d)   { return d/(C5/C0); }
        @DSModeled(DSC.SAFE)
    public long toDays(long d)    { return d/(C6/C0); }
        @DSModeled(DSC.SAFE)
    public long convert(long d, TimeUnit u) { return u.toNanos(d); }
        int excessNanos(long d, long m) { return (int)(d - (m*C2)); }
    },
    MICROSECONDS {
        @DSModeled(DSC.SAFE)
    public long toNanos(long d)   { return x(d, C1/C0, MAX/(C1/C0)); }
        @DSModeled(DSC.SAFE)
    public long toMicros(long d)  { return d; }
        @DSModeled(DSC.SAFE)
    public long toMillis(long d)  { return d/(C2/C1); }
        @DSModeled(DSC.SAFE)
    public long toSeconds(long d) { return d/(C3/C1); }
        @DSModeled(DSC.SAFE)
    public long toMinutes(long d) { return d/(C4/C1); }
        @DSModeled(DSC.SAFE)
    public long toHours(long d)   { return d/(C5/C1); }
        @DSModeled(DSC.SAFE)
    public long toDays(long d)    { return d/(C6/C1); }
        @DSModeled(DSC.SAFE)
    public long convert(long d, TimeUnit u) { return u.toMicros(d); }
        int excessNanos(long d, long m) { return (int)((d*C1) - (m*C2)); }
    },
    MILLISECONDS {
        @DSModeled(DSC.SAFE)
    public long toNanos(long d)   { return x(d, C2/C0, MAX/(C2/C0)); }
        @DSModeled(DSC.SAFE)
    public long toMicros(long d)  { return x(d, C2/C1, MAX/(C2/C1)); }
        @DSModeled(DSC.SAFE)
    public long toMillis(long d)  { return d; }
        @DSModeled(DSC.SAFE)
    public long toSeconds(long d) { return d/(C3/C2); }
        @DSModeled(DSC.SAFE)
    public long toMinutes(long d) { return d/(C4/C2); }
        @DSModeled(DSC.SAFE)
    public long toHours(long d)   { return d/(C5/C2); }
        @DSModeled(DSC.SAFE)
    public long toDays(long d)    { return d/(C6/C2); }
        @DSModeled(DSC.SAFE)
    public long convert(long d, TimeUnit u) { return u.toMillis(d); }
        int excessNanos(long d, long m) { return 0; }
    },
    SECONDS {
        @DSModeled(DSC.SAFE)
    public long toNanos(long d)   { return x(d, C3/C0, MAX/(C3/C0)); }
        @DSModeled(DSC.SAFE)
    public long toMicros(long d)  { return x(d, C3/C1, MAX/(C3/C1)); }
        @DSModeled(DSC.SAFE)
    public long toMillis(long d)  { return x(d, C3/C2, MAX/(C3/C2)); }
        @DSModeled(DSC.SAFE)
    public long toSeconds(long d) { return d; }
        @DSModeled(DSC.SAFE)
    public long toMinutes(long d) { return d/(C4/C3); }
        @DSModeled(DSC.SAFE)
    public long toHours(long d)   { return d/(C5/C3); }
        @DSModeled(DSC.SAFE)
    public long toDays(long d)    { return d/(C6/C3); }
        @DSModeled(DSC.SAFE)
    public long convert(long d, TimeUnit u) { return u.toSeconds(d); }
        int excessNanos(long d, long m) { return 0; }
    },
    MINUTES {
        @DSModeled(DSC.SAFE)
    public long toNanos(long d)   { return x(d, C4/C0, MAX/(C4/C0)); }
        @DSModeled(DSC.SAFE)
    public long toMicros(long d)  { return x(d, C4/C1, MAX/(C4/C1)); }
        @DSModeled(DSC.SAFE)
    public long toMillis(long d)  { return x(d, C4/C2, MAX/(C4/C2)); }
        @DSModeled(DSC.SAFE)
    public long toSeconds(long d) { return x(d, C4/C3, MAX/(C4/C3)); }
        @DSModeled(DSC.SAFE)
    public long toMinutes(long d) { return d; }
        @DSModeled(DSC.SAFE)
    public long toHours(long d)   { return d/(C5/C4); }
        @DSModeled(DSC.SAFE)
    public long toDays(long d)    { return d/(C6/C4); }
        @DSModeled(DSC.SAFE)
    public long convert(long d, TimeUnit u) { return u.toMinutes(d); }
        int excessNanos(long d, long m) { return 0; }
    },
    HOURS {
        @DSModeled(DSC.SAFE)
    public long toNanos(long d)   { return x(d, C5/C0, MAX/(C5/C0)); }
        @DSModeled(DSC.SAFE)
    public long toMicros(long d)  { return x(d, C5/C1, MAX/(C5/C1)); }
        @DSModeled(DSC.SAFE)
    public long toMillis(long d)  { return x(d, C5/C2, MAX/(C5/C2)); }
        @DSModeled(DSC.SAFE)
    public long toSeconds(long d) { return x(d, C5/C3, MAX/(C5/C3)); }
        @DSModeled(DSC.SAFE)
    public long toMinutes(long d) { return x(d, C5/C4, MAX/(C5/C4)); }
        @DSModeled(DSC.SAFE)
    public long toHours(long d)   { return d; }
        @DSModeled(DSC.SAFE)
    public long toDays(long d)    { return d/(C6/C5); }
        @DSModeled(DSC.SAFE)
    public long convert(long d, TimeUnit u) { return u.toHours(d); }
        int excessNanos(long d, long m) { return 0; }
    },
    DAYS {
        @DSModeled(DSC.SAFE)
    public long toNanos(long d)   { return x(d, C6/C0, MAX/(C6/C0)); }
        @DSModeled(DSC.SAFE)
    public long toMicros(long d)  { return x(d, C6/C1, MAX/(C6/C1)); }
        @DSModeled(DSC.SAFE)
    public long toMillis(long d)  { return x(d, C6/C2, MAX/(C6/C2)); }
        @DSModeled(DSC.SAFE)
    public long toSeconds(long d) { return x(d, C6/C3, MAX/(C6/C3)); }
        @DSModeled(DSC.SAFE)
    public long toMinutes(long d) { return x(d, C6/C4, MAX/(C6/C4)); }
        @DSModeled(DSC.SAFE)
    public long toHours(long d)   { return x(d, C6/C5, MAX/(C6/C5)); }
        @DSModeled(DSC.SAFE)
    public long toDays(long d)    { return d; }
        @DSModeled(DSC.SAFE)
    public long convert(long d, TimeUnit u) { return u.toDays(d); }
        int excessNanos(long d, long m) { return 0; }
    };
    static final long C0 = 1L;
    static final long C1 = C0 * 1000L;
    static final long C2 = C1 * 1000L;
    static final long C3 = C2 * 1000L;
    static final long C4 = C3 * 60L;
    static final long C5 = C4 * 60L;
    static final long C6 = C5 * 24L;
    static final long MAX = Long.MAX_VALUE;
    static long x(long d, long m, long over) {
        if (d >  over) return Long.MAX_VALUE;
        if (d < -over) return Long.MIN_VALUE;
        return d * m;
    }
    @DSModeled(DSC.SAFE)
    public long convert(long sourceDuration, TimeUnit sourceUnit) {
        throw new AbstractMethodError();
    }
    @DSModeled(DSC.SAFE)
    public long toNanos(long duration) {
        throw new AbstractMethodError();
    }
    @DSModeled(DSC.SAFE)
    public long toMicros(long duration) {
        throw new AbstractMethodError();
    }
    @DSModeled(DSC.SAFE)
    public long toMillis(long duration) {
        throw new AbstractMethodError();
    }
    @DSModeled(DSC.SAFE)
    public long toSeconds(long duration) {
        throw new AbstractMethodError();
    }
    @DSModeled(DSC.SAFE)
    public long toMinutes(long duration) {
        throw new AbstractMethodError();
    }
    @DSModeled(DSC.SAFE)
    public long toHours(long duration) {
        throw new AbstractMethodError();
    }
    @DSModeled(DSC.SAFE)
    public long toDays(long duration) {
        throw new AbstractMethodError();
    }
    abstract int excessNanos(long d, long m);
    @DSModeled(DSC.SAFE)
    public void timedWait(Object obj, long timeout)
            throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            obj.wait(ms, ns);
        }
    }
    @DSModeled(DSC.SAFE)
    public void timedJoin(Thread thread, long timeout)
            throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            thread.join(ms, ns);
        }
    }
    @DSModeled(DSC.SAFE)
    public void sleep(long timeout) throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            Thread.sleep(ms, ns);
        }
    }
}
