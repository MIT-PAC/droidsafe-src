package android.util;

// Droidsafe Imports

public interface PoolableManager<T extends Poolable<T>> {
    T newInstance();

    void onAcquired(T element);
    void onReleased(T element);
}
