package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Debug;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Printer;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ViewDebug {
    public static final String CONSISTENCY_LOG_TAG = "ViewConsistency";
    public static final int CONSISTENCY_LAYOUT = 0x1;
    public static final int CONSISTENCY_DRAWING = 0x2;
    public static final boolean TRACE_HIERARCHY = false;
    public static final boolean TRACE_RECYCLER = false;
    public static final boolean DEBUG_PROFILE_DRAWING = false;
    public static final boolean DEBUG_PROFILE_LAYOUT = false;
    public static final boolean DEBUG_DRAG = false;
    public static final boolean DEBUG_LATENCY = false;
    @Debug.DebugProperty
    public static boolean consistencyCheckEnabled = false;
    private static HashMap<Class<?>, Method[]> mCapturedViewMethodsForClasses = null;
    private static HashMap<Class<?>, Field[]> mCapturedViewFieldsForClasses = null;
    private static final int CAPTURE_TIMEOUT = 4000;
    private static final String REMOTE_COMMAND_CAPTURE = "CAPTURE";
    private static final String REMOTE_COMMAND_DUMP = "DUMP";
    private static final String REMOTE_COMMAND_INVALIDATE = "INVALIDATE";
    private static final String REMOTE_COMMAND_REQUEST_LAYOUT = "REQUEST_LAYOUT";
    private static final String REMOTE_PROFILE = "PROFILE";
    private static final String REMOTE_COMMAND_CAPTURE_LAYERS = "CAPTURE_LAYERS";
    private static final String REMOTE_COMMAND_OUTPUT_DISPLAYLIST = "OUTPUT_DISPLAYLIST";
    private static HashMap<Class<?>, Field[]> sFieldsForClasses;
    private static HashMap<Class<?>, Method[]> sMethodsForClasses;
    private static HashMap<AccessibleObject, ExportedProperty> sAnnotations;
    private static BufferedWriter sHierarchyTraces;
    private static ViewRootImpl sHierarhcyRoot;
    private static String sHierarchyTracePrefix;
    private static View sRecyclerOwnerView;
    private static List<View> sRecyclerViews;
    private static List<RecyclerTrace> sRecyclerTraces;
    private static String sRecyclerTracePrefix;
    private static final ThreadLocal<LooperProfiler> sLooperProfilerStorage =
            new ThreadLocal<LooperProfiler>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.111 -0400", hash_original_method = "CCEE31E4C5D51FDD46E34DBD2A6B75D9", hash_generated_method = "0B1C13CA86AF922803546494A9B1F0CE")
    public static long getViewInstanceCount() {
        return Debug.countInstancesOfClass(View.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.111 -0400", hash_original_method = "C636D1AA1C9C73737089BE8BB62EDBEC", hash_generated_method = "B270B1B674743876C74554C6FEE6F70B")
    public static long getViewRootImplCount() {
        return Debug.countInstancesOfClass(ViewRootImpl.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.111 -0400", hash_original_method = "EF2A89919039C059591C707BFA388818", hash_generated_method = "03D9C4A9A2994154D08B794E525661AE")
    public static void startLooperProfiling(String path, FileDescriptor fileDescriptor) {
        if (sLooperProfilerStorage.get() == null) {
            LooperProfiler profiler = new LooperProfiler(path, fileDescriptor);
            sLooperProfilerStorage.set(profiler);
            Looper.myLooper().setMessageLogging(profiler);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.112 -0400", hash_original_method = "B599040D5B8FC90AA7B29D3CCB6AB179", hash_generated_method = "09E38150DD01F21E96CB1FFC65FDAD51")
    public static void stopLooperProfiling() {
        LooperProfiler profiler = sLooperProfilerStorage.get();
        if (profiler != null) {
            sLooperProfilerStorage.remove();
            Looper.myLooper().setMessageLogging(null);
            profiler.save();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.112 -0400", hash_original_method = "9FB603FC61BD2E2F993FED5B311CF194", hash_generated_method = "BEC868AACCB7B8E08C9A6DD3BD322D10")
    public static void trace(View view, RecyclerTraceType type, int... parameters) {
        if (sRecyclerOwnerView == null || sRecyclerViews == null) {
            return;
        }
        if (!sRecyclerViews.contains(view)) {
            sRecyclerViews.add(view);
        }
        final int index = sRecyclerViews.indexOf(view);
        RecyclerTrace trace = new RecyclerTrace();
        trace.view = index;
        trace.type = type;
        trace.position = parameters[0];
        trace.indexOnScreen = parameters[1];
        sRecyclerTraces.add(trace);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.112 -0400", hash_original_method = "A97F2647E45111D7E82EA9F0820CF7DC", hash_generated_method = "61C5ABB3A268A2BF66AA55ECA89F7F16")
    public static void startRecyclerTracing(String prefix, View view) {
        if (!TRACE_RECYCLER) {
            return;
        }
        if (sRecyclerOwnerView != null) {
            throw new IllegalStateException("You must call stopRecyclerTracing() before running" +
                " a new trace!");
        }
        sRecyclerTracePrefix = prefix;
        sRecyclerOwnerView = view;
        sRecyclerViews = new ArrayList<View>();
        sRecyclerTraces = new LinkedList<RecyclerTrace>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.112 -0400", hash_original_method = "6A5ECEFFFC71FF3D06FE75037F54C9D8", hash_generated_method = "706C7FDF2840CCA3E101EA1E8728F452")
    public static void stopRecyclerTracing() {
        if (!TRACE_RECYCLER) {
            return;
        }
        if (sRecyclerOwnerView == null || sRecyclerViews == null) {
            throw new IllegalStateException("You must call startRecyclerTracing() before" +
                " stopRecyclerTracing()!");
        }
        File recyclerDump = new File(Environment.getExternalStorageDirectory(), "view-recycler/");
        recyclerDump.mkdirs();
        recyclerDump = new File(recyclerDump, sRecyclerTracePrefix + ".recycler");
        try {
            final BufferedWriter out = new BufferedWriter(new FileWriter(recyclerDump), 8 * 1024);
            for (View view : sRecyclerViews) {
                final String name = view.getClass().getName();
                out.write(name);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            Log.e("View", "Could not dump recycler content");
            return;
        }
        recyclerDump = new File(Environment.getExternalStorageDirectory(), "view-recycler/");
        recyclerDump = new File(recyclerDump, sRecyclerTracePrefix + ".traces");
        try {
            if (recyclerDump.exists()) {
                recyclerDump.delete();
            }
            final FileOutputStream file = new FileOutputStream(recyclerDump);
            final DataOutputStream out = new DataOutputStream(file);
            for (RecyclerTrace trace : sRecyclerTraces) {
                out.writeInt(trace.view);
                out.writeInt(trace.type.ordinal());
                out.writeInt(trace.position);
                out.writeInt(trace.indexOnScreen);
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            Log.e("View", "Could not dump recycler traces");
            return;
        }
        sRecyclerViews.clear();
        sRecyclerViews = null;
        sRecyclerTraces.clear();
        sRecyclerTraces = null;
        sRecyclerOwnerView = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.112 -0400", hash_original_method = "A4A7588B59209B328B6730A5C3959508", hash_generated_method = "63A92CD43C3BEED908631B9323570E0F")
    public static void trace(View view, HierarchyTraceType type) {
        if (sHierarchyTraces == null) {
            return;
        }
        try {
            sHierarchyTraces.write(type.name());
            sHierarchyTraces.write(' ');
            sHierarchyTraces.write(view.getClass().getName());
            sHierarchyTraces.write('@');
            sHierarchyTraces.write(Integer.toHexString(view.hashCode()));
            sHierarchyTraces.newLine();
        } catch (IOException e) {
            Log.w("View", "Error while dumping trace of type " + type + " for view " + view);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.112 -0400", hash_original_method = "6D01B685939D5CC18EA0CD73C471B3BF", hash_generated_method = "D8FFB78FC50C38321FFDB52A6DEA52EF")
    public static void startHierarchyTracing(String prefix, View view) {
        if (!TRACE_HIERARCHY) {
            return;
        }
        if (sHierarhcyRoot != null) {
            throw new IllegalStateException("You must call stopHierarchyTracing() before running" +
                " a new trace!");
        }
        File hierarchyDump = new File(Environment.getExternalStorageDirectory(), "view-hierarchy/");
        hierarchyDump.mkdirs();
        hierarchyDump = new File(hierarchyDump, prefix + ".traces");
        sHierarchyTracePrefix = prefix;
        try {
            sHierarchyTraces = new BufferedWriter(new FileWriter(hierarchyDump), 8 * 1024);
        } catch (IOException e) {
            Log.e("View", "Could not dump view hierarchy");
            return;
        }
        sHierarhcyRoot = (ViewRootImpl) view.getRootView().getParent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.112 -0400", hash_original_method = "A9B61ADDC99B501812E388E1C7DE321B", hash_generated_method = "E6BFC4380D28F7FD3F3FD1FBC778417F")
    public static void stopHierarchyTracing() {
        if (!TRACE_HIERARCHY) {
            return;
        }
        if (sHierarhcyRoot == null || sHierarchyTraces == null) {
            throw new IllegalStateException("You must call startHierarchyTracing() before" +
                " stopHierarchyTracing()!");
        }
        try {
            sHierarchyTraces.close();
        } catch (IOException e) {
            Log.e("View", "Could not write view traces");
        }
        sHierarchyTraces = null;
        File hierarchyDump = new File(Environment.getExternalStorageDirectory(), "view-hierarchy/");
        hierarchyDump.mkdirs();
        hierarchyDump = new File(hierarchyDump, sHierarchyTracePrefix + ".tree");
        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter(hierarchyDump), 8 * 1024);
        } catch (IOException e) {
            Log.e("View", "Could not dump view hierarchy");
            return;
        }
        View view = sHierarhcyRoot.getView();
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            dumpViewHierarchy(group, out, 0);
            try {
                out.close();
            } catch (IOException e) {
                Log.e("View", "Could not dump view hierarchy");
            }
        }
        sHierarhcyRoot = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.112 -0400", hash_original_method = "8AD232DF2BF806FA5443AE736277CC43", hash_generated_method = "9ACF55F4753D5C630C5A5A36E03A040F")
    static void dispatchCommand(View view, String command, String parameters,
            OutputStream clientStream) throws IOException {
        view = view.getRootView();
        if (REMOTE_COMMAND_DUMP.equalsIgnoreCase(command)) {
            dump(view, clientStream);
        } else if (REMOTE_COMMAND_CAPTURE_LAYERS.equalsIgnoreCase(command)) {
            captureLayers(view, new DataOutputStream(clientStream));
        } else {
            final String[] params = parameters.split(" ");
            if (REMOTE_COMMAND_CAPTURE.equalsIgnoreCase(command)) {
                capture(view, clientStream, params[0]);
            } else if (REMOTE_COMMAND_OUTPUT_DISPLAYLIST.equalsIgnoreCase(command)) {
                outputDisplayList(view, params[0]);
            } else if (REMOTE_COMMAND_INVALIDATE.equalsIgnoreCase(command)) {
                invalidate(view, params[0]);
            } else if (REMOTE_COMMAND_REQUEST_LAYOUT.equalsIgnoreCase(command)) {
                requestLayout(view, params[0]);
            } else if (REMOTE_PROFILE.equalsIgnoreCase(command)) {
                profile(view, clientStream, params[0]);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.113 -0400", hash_original_method = "E7AA1AA0F5F3D46BF2196FEAFC7C37E8", hash_generated_method = "4DA2F0247E477AC2233DE33CA9A8E876")
    private static View findView(View root, String parameter) {
        if (parameter.indexOf('@') != -1) {
            final String[] ids = parameter.split("@");
            final String className = ids[0];
            final int hashCode = (int) Long.parseLong(ids[1], 16);
            View view = root.getRootView();
            if (view instanceof ViewGroup) {
                return findView((ViewGroup) view, className, hashCode);
            }
        } else {
            final int id = root.getResources().getIdentifier(parameter, null, null);
            return root.getRootView().findViewById(id);
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.113 -0400", hash_original_method = "BDF07495D49506A0278A7A607DDE349D", hash_generated_method = "43C7718534665A73D78F0B8DD5D31E06")
    private static void invalidate(View root, String parameter) {
        final View view = findView(root, parameter);
        if (view != null) {
            view.postInvalidate();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.113 -0400", hash_original_method = "87EF2D5214EE0EA9F700768E799A7935", hash_generated_method = "812311D8246BFDC28512970A2890A732")
    private static void requestLayout(View root, String parameter) {
        final View view = findView(root, parameter);
        if (view != null) {
            root.post(new Runnable() {
                public void run() {
                    view.requestLayout();
                }
            });
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.113 -0400", hash_original_method = "99E7503B140035CB3F5FB600D6940FA3", hash_generated_method = "C77A165820A546A2CE3858F07922A0E0")
    private static void profile(View root, OutputStream clientStream, String parameter) throws IOException {
        final View view = findView(root, parameter);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(clientStream), 32 * 1024);
            if (view != null) {
                profileViewAndChildren(view, out);
            } else {
                out.write("-1 -1 -1");
                out.newLine();
            }
            out.write("DONE.");
            out.newLine();
        } catch (Exception e) {
            android.util.Log.w("View", "Problem profiling the view:", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.113 -0400", hash_original_method = "86262C0779C950C480BCEAAE522536AB", hash_generated_method = "CA5033671F6D088F5626A372CCAB075B")
    private static void profileViewAndChildren(final View view, BufferedWriter out) throws IOException {
        profileViewAndChildren(view, out, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.113 -0400", hash_original_method = "328955C722C2EE755255819A7EBFB697", hash_generated_method = "20D1360454D4B76ED3E0DA1AEBE87F3E")
    private static void profileViewAndChildren(final View view, BufferedWriter out, boolean root) throws IOException {
        long durationMeasure =
                (root || (view.mPrivateFlags & View.MEASURED_DIMENSION_SET) != 0) ? profileViewOperation(
                        view, new ViewOperation<Void>() {
                            public Void[] pre() {
                                forceLayout(view);
                                return null;
                            }
                            private void forceLayout(View view) {
                                view.forceLayout();
                                if (view instanceof ViewGroup) {
                                    ViewGroup group = (ViewGroup) view;
                                    final int count = group.getChildCount();
                                    for (int i = 0; i < count; i++) {
                                        forceLayout(group.getChildAt(i));
                                    }
                                }
                            }
                            public void run(Void... data) {
                                view.measure(view.mOldWidthMeasureSpec, view.mOldHeightMeasureSpec);
                            }
                            public void post(Void... data) {
                            }
                        })
                        : 0;
        long durationLayout =
                (root || (view.mPrivateFlags & View.LAYOUT_REQUIRED) != 0) ? profileViewOperation(
                        view, new ViewOperation<Void>() {
                            public Void[] pre() {
                                return null;
                            }
                            public void run(Void... data) {
                                view.layout(view.mLeft, view.mTop, view.mRight, view.mBottom);
                            }
                            public void post(Void... data) {
                            }
                        }) : 0;
        long durationDraw =
                (root || !view.willNotDraw() || (view.mPrivateFlags & View.DRAWN) != 0) ? profileViewOperation(
                        view,
                        new ViewOperation<Object>() {
                            public Object[] pre() {
                                final DisplayMetrics metrics =
                                        (view != null && view.getResources() != null) ?
                                                view.getResources().getDisplayMetrics() : null;
                                final Bitmap bitmap = metrics != null ?
                                        Bitmap.createBitmap(metrics.widthPixels,
                                                metrics.heightPixels, Bitmap.Config.RGB_565) : null;
                                final Canvas canvas = bitmap != null ? new Canvas(bitmap) : null;
                                return new Object[] {
                                        bitmap, canvas
                                };
                            }
                            public void run(Object... data) {
                                if (data[1] != null) {
                                    view.draw((Canvas) data[1]);
                                }
                            }
                            public void post(Object... data) {
                                if (data[1] != null) {
                                    ((Canvas) data[1]).setBitmap(null);
                                }
                                if (data[0] != null) {
                                    ((Bitmap) data[0]).recycle();
                                }
                            }
                        }) : 0;
        out.write(String.valueOf(durationMeasure));
        out.write(' ');
        out.write(String.valueOf(durationLayout));
        out.write(' ');
        out.write(String.valueOf(durationDraw));
        out.newLine();
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            final int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                profileViewAndChildren(group.getChildAt(i), out, false);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.113 -0400", hash_original_method = "308103675670C12786E7BB6D11CB6102", hash_generated_method = "2CF7B91C3E6226539AF66FFB9D3298EB")
    private static <T> long profileViewOperation(View view, final ViewOperation<T> operation) {
        final CountDownLatch latch = new CountDownLatch(1);
        final long[] duration = new long[1];
        view.post(new Runnable() {
            public void run() {
                try {
                    T[] data = operation.pre();
                    long start = Debug.threadCpuTimeNanos();
                    operation.run(data);
                    duration[0] = Debug.threadCpuTimeNanos() - start;
                    operation.post(data);
                } finally {
                    latch.countDown();
                }
            }
        });
        try {
            if (!latch.await(CAPTURE_TIMEOUT, TimeUnit.MILLISECONDS)) {
                Log.w("View", "Could not complete the profiling of the view " + view);
                return -1;
            }
        } catch (InterruptedException e) {
            Log.w("View", "Could not complete the profiling of the view " + view);
            Thread.currentThread().interrupt();
            return -1;
        }
        return duration[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.113 -0400", hash_original_method = "D93CAC5EB5297F4337ACFC64A6E530F1", hash_generated_method = "D2FD9428E7E92A3B1C5A374062041598")
    private static void captureLayers(View root, final DataOutputStream clientStream) throws IOException {
        try {
            Rect outRect = new Rect();
            try {
                root.mAttachInfo.mSession.getDisplayFrame(root.mAttachInfo.mWindow, outRect);
            } catch (RemoteException e) {
            }
            clientStream.writeInt(outRect.width());
            clientStream.writeInt(outRect.height());
            captureViewLayer(root, clientStream, true);
            clientStream.write(2);
        } finally {
            clientStream.close();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.114 -0400", hash_original_method = "39E4687AEC0DFE57B6041298B9A06FA7", hash_generated_method = "0CD042E01FD531C34022B0269F964B7D")
    private static void captureViewLayer(View view, DataOutputStream clientStream, boolean visible) throws IOException {
        final boolean localVisible = view.getVisibility() == View.VISIBLE && visible;
        if ((view.mPrivateFlags & View.SKIP_DRAW) != View.SKIP_DRAW) {
            final int id = view.getId();
            String name = view.getClass().getSimpleName();
            if (id != View.NO_ID) {
                name = resolveId(view.getContext(), id).toString();
            }
            clientStream.write(1);
            clientStream.writeUTF(name);
            clientStream.writeByte(localVisible ? 1 : 0);
            int[] position = new int[2];
            view.getLocationInWindow(position);
            clientStream.writeInt(position[0]);
            clientStream.writeInt(position[1]);
            clientStream.flush();
            Bitmap b = performViewCapture(view, true);
            if (b != null) {
                ByteArrayOutputStream arrayOut = new ByteArrayOutputStream(b.getWidth() *
                        b.getHeight() * 2);
                b.compress(Bitmap.CompressFormat.PNG, 100, arrayOut);
                clientStream.writeInt(arrayOut.size());
                arrayOut.writeTo(clientStream);
            }
            clientStream.flush();
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                captureViewLayer(group.getChildAt(i), clientStream, localVisible);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.114 -0400", hash_original_method = "50C6ECE900AC13BE000E66CA433DF6CB", hash_generated_method = "F8FB69A5968C85FA97BB5670485A3A4C")
    private static void outputDisplayList(View root, String parameter) throws IOException {
        final View view = findView(root, parameter);
        view.getViewRootImpl().outputDisplayList(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.114 -0400", hash_original_method = "E4E94A0B923CC4129DB34454045BA112", hash_generated_method = "0C218572C522E770C8C5E113082D5AF1")
    private static void capture(View root, final OutputStream clientStream, String parameter) throws IOException {
        final View captureView = findView(root, parameter);
        Bitmap b = performViewCapture(captureView, false);
        if (b == null) {
            Log.w("View", "Failed to create capture bitmap!");
            b = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(clientStream, 32 * 1024);
            b.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
            b.recycle();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.114 -0400", hash_original_method = "4A1042000584F6AE08665276166265A9", hash_generated_method = "67DEB65E63F80556F970FE8551471666")
    private static Bitmap performViewCapture(final View captureView, final boolean skpiChildren) {
        if (captureView != null) {
            final CountDownLatch latch = new CountDownLatch(1);
            final Bitmap[] cache = new Bitmap[1];
            captureView.post(new Runnable() {
                public void run() {
                    try {
                        cache[0] = captureView.createSnapshot(
                                Bitmap.Config.ARGB_8888, 0, skpiChildren);
                    } catch (OutOfMemoryError e) {
                        Log.w("View", "Out of memory for bitmap");
                    } finally {
                        latch.countDown();
                    }
                }
            });
            try {
                latch.await(CAPTURE_TIMEOUT, TimeUnit.MILLISECONDS);
                return cache[0];
            } catch (InterruptedException e) {
                Log.w("View", "Could not complete the capture of the view " + captureView);
                Thread.currentThread().interrupt();
            }
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.114 -0400", hash_original_method = "F61162F3CABBD02821B784FB69394317", hash_generated_method = "CCE1AE04DF35DB854AD7CBFA40B0F455")
    private static void dump(View root, OutputStream clientStream) throws IOException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(clientStream, "utf-8"), 32 * 1024);
            View view = root.getRootView();
            if (view instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) view;
                dumpViewHierarchyWithProperties(group.getContext(), group, out, 0);
            }
            out.write("DONE.");
            out.newLine();
        } catch (Exception e) {
            android.util.Log.w("View", "Problem dumping the view:", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.114 -0400", hash_original_method = "5833D78630A0ABEF24425617A800E52C", hash_generated_method = "413904C6AA110C0AE8BE90235E87B3EE")
    private static View findView(ViewGroup group, String className, int hashCode) {
        if (isRequestedView(group, className, hashCode)) {
            return group;
        }
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            if (view instanceof ViewGroup) {
                final View found = findView((ViewGroup) view, className, hashCode);
                if (found != null) {
                    return found;
                }
            } else if (isRequestedView(view, className, hashCode)) {
                return view;
            }
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.114 -0400", hash_original_method = "6C30A5CCC0CF82FA550A697812F2D8AC", hash_generated_method = "12D70F8FAEA6DEE0BB6478FD1D95C69B")
    private static boolean isRequestedView(View view, String className, int hashCode) {
        return view.getClass().getName().equals(className) && view.hashCode() == hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.114 -0400", hash_original_method = "5477E7361E0198F52F4739FAE13D1748", hash_generated_method = "50EE2420BF0B26544444127159CE6215")
    private static void dumpViewHierarchyWithProperties(Context context, ViewGroup group,
            BufferedWriter out, int level) {
        if (!dumpViewWithProperties(context, group, out, level)) {
            return;
        }
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            if (view instanceof ViewGroup) {
                dumpViewHierarchyWithProperties(context, (ViewGroup) view, out, level + 1);
            } else {
                dumpViewWithProperties(context, view, out, level + 1);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.114 -0400", hash_original_method = "A1D47394B3DD77835A07F9275FAED40E", hash_generated_method = "DB6679FD3383EF9E6055FD47B7B3C08D")
    private static boolean dumpViewWithProperties(Context context, View view,
            BufferedWriter out, int level) {
        try {
            for (int i = 0; i < level; i++) {
                out.write(' ');
            }
            out.write(view.getClass().getName());
            out.write('@');
            out.write(Integer.toHexString(view.hashCode()));
            out.write(' ');
            dumpViewProperties(context, view, out);
            out.newLine();
        } catch (IOException e) {
            Log.w("View", "Error while dumping hierarchy tree");
            return false;
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.114 -0400", hash_original_method = "096C849E8C18A39942244A8C79B40CB5", hash_generated_method = "8B80C1A11D4E04C892D17BBCE9BE3C92")
    private static Field[] getExportedPropertyFields(Class<?> klass) {
        if (sFieldsForClasses == null) {
            sFieldsForClasses = new HashMap<Class<?>, Field[]>();
        }
        if (sAnnotations == null) {
            sAnnotations = new HashMap<AccessibleObject, ExportedProperty>(512);
        }
        final HashMap<Class<?>, Field[]> map = sFieldsForClasses;
        Field[] fields = map.get(klass);
        if (fields != null) {
            return fields;
        }
        final ArrayList<Field> foundFields = new ArrayList<Field>();
        fields = klass.getDeclaredFields();
        int count = fields.length;
        for (int i = 0; i < count; i++) {
            final Field field = fields[i];
            if (field.isAnnotationPresent(ExportedProperty.class)) {
                field.setAccessible(true);
                foundFields.add(field);
                sAnnotations.put(field, field.getAnnotation(ExportedProperty.class));
            }
        }
        fields = foundFields.toArray(new Field[foundFields.size()]);
        map.put(klass, fields);
        return fields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.115 -0400", hash_original_method = "ED3508DD2DBB4E6ACB6B0001C73AF024", hash_generated_method = "399A8AB9A99FD5F31C02002C0913058D")
    private static Method[] getExportedPropertyMethods(Class<?> klass) {
        if (sMethodsForClasses == null) {
            sMethodsForClasses = new HashMap<Class<?>, Method[]>(100);
        }
        if (sAnnotations == null) {
            sAnnotations = new HashMap<AccessibleObject, ExportedProperty>(512);
        }
        final HashMap<Class<?>, Method[]> map = sMethodsForClasses;
        Method[] methods = map.get(klass);
        if (methods != null) {
            return methods;
        }
        final ArrayList<Method> foundMethods = new ArrayList<Method>();
        methods = klass.getDeclaredMethods();
        int count = methods.length;
        for (int i = 0; i < count; i++) {
            final Method method = methods[i];
            if (method.getParameterTypes().length == 0 &&
                    method.isAnnotationPresent(ExportedProperty.class) &&
                    method.getReturnType() != Void.class) {
                method.setAccessible(true);
                foundMethods.add(method);
                sAnnotations.put(method, method.getAnnotation(ExportedProperty.class));
            }
        }
        methods = foundMethods.toArray(new Method[foundMethods.size()]);
        map.put(klass, methods);
        return methods;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.115 -0400", hash_original_method = "40CE639F8706808D9F15554E44131B8F", hash_generated_method = "B8629DCE341C48FAE52277ED1BC33E89")
    private static void dumpViewProperties(Context context, Object view,
            BufferedWriter out) throws IOException {
        dumpViewProperties(context, view, out, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.115 -0400", hash_original_method = "7BB17C895A68D99A44294B984761FB55", hash_generated_method = "29BC5A36792F5A122B8F501257EE43D4")
    private static void dumpViewProperties(Context context, Object view,
            BufferedWriter out, String prefix) throws IOException {
        Class<?> klass = view.getClass();
        do {
            exportFields(context, view, out, klass, prefix);
            exportMethods(context, view, out, klass, prefix);
            klass = klass.getSuperclass();
        } while (klass != Object.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.115 -0400", hash_original_method = "B03A838660ADA490E1042D45D00ECCAF", hash_generated_method = "464EB195934906CE1054FB9416058425")
    private static void exportMethods(Context context, Object view, BufferedWriter out,
            Class<?> klass, String prefix) throws IOException {
        final Method[] methods = getExportedPropertyMethods(klass);
        int count = methods.length;
        for (int i = 0; i < count; i++) {
            final Method method = methods[i];
            try {
                Object methodValue = method.invoke(view, (Object[]) null);
                final Class<?> returnType = method.getReturnType();
                final ExportedProperty property = sAnnotations.get(method);
                String categoryPrefix =
                        property.category().length() != 0 ? property.category() + ":" : "";
                if (returnType == int.class) {
                    if (property.resolveId() && context != null) {
                        final int id = (Integer) methodValue;
                        methodValue = resolveId(context, id);
                    } else {
                        final FlagToString[] flagsMapping = property.flagMapping();
                        if (flagsMapping.length > 0) {
                            final int intValue = (Integer) methodValue;
                            final String valuePrefix =
                                    categoryPrefix + prefix + method.getName() + '_';
                            exportUnrolledFlags(out, flagsMapping, intValue, valuePrefix);
                        }
                        final IntToString[] mapping = property.mapping();
                        if (mapping.length > 0) {
                            final int intValue = (Integer) methodValue;
                            boolean mapped = false;
                            int mappingCount = mapping.length;
                            for (int j = 0; j < mappingCount; j++) {
                                final IntToString mapper = mapping[j];
                                if (mapper.from() == intValue) {
                                    methodValue = mapper.to();
                                    mapped = true;
                                    break;
                                }
                            }
                            if (!mapped) {
                                methodValue = intValue;
                            }
                        }
                    }
                } else if (returnType == int[].class) {
                    final int[] array = (int[]) methodValue;
                    final String valuePrefix = categoryPrefix + prefix + method.getName() + '_';
                    final String suffix = "()";
                    exportUnrolledArray(context, out, property, array, valuePrefix, suffix);
                    return;
                } else if (!returnType.isPrimitive()) {
                    if (property.deepExport()) {
                        dumpViewProperties(context, methodValue, out, prefix + property.prefix());
                        continue;
                    }
                }
                writeEntry(out, categoryPrefix + prefix, method.getName(), "()", methodValue);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.115 -0400", hash_original_method = "3A18E6E106473CB28FC5E1DDECF06C31", hash_generated_method = "605B1EB6037E0A103FD9E2EF9F49F14C")
    private static void exportFields(Context context, Object view, BufferedWriter out,
            Class<?> klass, String prefix) throws IOException {
        final Field[] fields = getExportedPropertyFields(klass);
        int count = fields.length;
        for (int i = 0; i < count; i++) {
            final Field field = fields[i];
            try {
                Object fieldValue = null;
                final Class<?> type = field.getType();
                final ExportedProperty property = sAnnotations.get(field);
                String categoryPrefix =
                        property.category().length() != 0 ? property.category() + ":" : "";
                if (type == int.class) {
                    if (property.resolveId() && context != null) {
                        final int id = field.getInt(view);
                        fieldValue = resolveId(context, id);
                    } else {
                        final FlagToString[] flagsMapping = property.flagMapping();
                        if (flagsMapping.length > 0) {
                            final int intValue = field.getInt(view);
                            final String valuePrefix =
                                    categoryPrefix + prefix + field.getName() + '_';
                            exportUnrolledFlags(out, flagsMapping, intValue, valuePrefix);
                        }
                        final IntToString[] mapping = property.mapping();
                        if (mapping.length > 0) {
                            final int intValue = field.getInt(view);
                            int mappingCount = mapping.length;
                            for (int j = 0; j < mappingCount; j++) {
                                final IntToString mapped = mapping[j];
                                if (mapped.from() == intValue) {
                                    fieldValue = mapped.to();
                                    break;
                                }
                            }
                            if (fieldValue == null) {
                                fieldValue = intValue;
                            }
                        }
                    }
                } else if (type == int[].class) {
                    final int[] array = (int[]) field.get(view);
                    final String valuePrefix = categoryPrefix + prefix + field.getName() + '_';
                    final String suffix = "";
                    exportUnrolledArray(context, out, property, array, valuePrefix, suffix);
                    return;
                } else if (!type.isPrimitive()) {
                    if (property.deepExport()) {
                        dumpViewProperties(context, field.get(view), out, prefix
                                + property.prefix());
                        continue;
                    }
                }
                if (fieldValue == null) {
                    fieldValue = field.get(view);
                }
                writeEntry(out, categoryPrefix + prefix, field.getName(), "", fieldValue);
            } catch (IllegalAccessException e) {
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.115 -0400", hash_original_method = "B7098ACB062DBE88371A117C8201E088", hash_generated_method = "6FE9FE758E446071750999C24203E6FD")
    private static void writeEntry(BufferedWriter out, String prefix, String name,
            String suffix, Object value) throws IOException {
        out.write(prefix);
        out.write(name);
        out.write(suffix);
        out.write("=");
        writeValue(out, value);
        out.write(' ');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.116 -0400", hash_original_method = "FEFEFF09280E6256D889B8A78014AFA9", hash_generated_method = "A8B8B1E23B574D309E0C779FAED8B58A")
    private static void exportUnrolledFlags(BufferedWriter out, FlagToString[] mapping,
            int intValue, String prefix) throws IOException {
        final int count = mapping.length;
        for (int j = 0; j < count; j++) {
            final FlagToString flagMapping = mapping[j];
            final boolean ifTrue = flagMapping.outputIf();
            final int maskResult = intValue & flagMapping.mask();
            final boolean test = maskResult == flagMapping.equals();
            if ((test && ifTrue) || (!test && !ifTrue)) {
                final String name = flagMapping.name();
                final String value = "0x" + Integer.toHexString(maskResult);
                writeEntry(out, prefix, name, "", value);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.116 -0400", hash_original_method = "F6826B26A33871866C71D95A8BAFF3DE", hash_generated_method = "FC6F4948C554B8F31EC10B30E584CE86")
    private static void exportUnrolledArray(Context context, BufferedWriter out,
            ExportedProperty property, int[] array, String prefix, String suffix) throws IOException {
        final IntToString[] indexMapping = property.indexMapping();
        final boolean hasIndexMapping = indexMapping.length > 0;
        final IntToString[] mapping = property.mapping();
        final boolean hasMapping = mapping.length > 0;
        final boolean resolveId = property.resolveId() && context != null;
        final int valuesCount = array.length;
        for (int j = 0; j < valuesCount; j++) {
            String name;
            String value = null;
            final int intValue = array[j];
            name = String.valueOf(j);
            if (hasIndexMapping) {
                int mappingCount = indexMapping.length;
                for (int k = 0; k < mappingCount; k++) {
                    final IntToString mapped = indexMapping[k];
                    if (mapped.from() == j) {
                        name = mapped.to();
                        break;
                    }
                }
            }
            if (hasMapping) {
                int mappingCount = mapping.length;
                for (int k = 0; k < mappingCount; k++) {
                    final IntToString mapped = mapping[k];
                    if (mapped.from() == intValue) {
                        value = mapped.to();
                        break;
                    }
                }
            }
            if (resolveId) {
                if (value == null) value = (String) resolveId(context, intValue);
            } else {
                value = String.valueOf(intValue);
            }
            writeEntry(out, prefix, name, suffix, value);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.116 -0400", hash_original_method = "5FE8610E444A8A1DD826B34556733550", hash_generated_method = "38B8C1C22BADCBEAA730B0774A5762C8")
    static Object resolveId(Context context, int id) {
        Object fieldValue;
        final Resources resources = context.getResources();
        if (id >= 0) {
            try {
                fieldValue = resources.getResourceTypeName(id) + '/' +
                        resources.getResourceEntryName(id);
            } catch (Resources.NotFoundException e) {
                fieldValue = "id/0x" + Integer.toHexString(id);
            }
        } else {
            fieldValue = "NO_ID";
        }
        return fieldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.116 -0400", hash_original_method = "7AD2EE6006BF39FAA79DC0A5665EF851", hash_generated_method = "CB65942F17F8702C1E1004DD32EE8D8F")
    private static void writeValue(BufferedWriter out, Object value) throws IOException {
        if (value != null) {
            String output = value.toString().replace("\n", "\\n");
            out.write(String.valueOf(output.length()));
            out.write(",");
            out.write(output);
        } else {
            out.write("4,null");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.116 -0400", hash_original_method = "661A6662CA258B0107AEBC63F4E81CD9", hash_generated_method = "10C484D2FFC60F49F85705C42F09FF71")
    private static void dumpViewHierarchy(ViewGroup group, BufferedWriter out, int level) {
        if (!dumpView(group, out, level)) {
            return;
        }
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            if (view instanceof ViewGroup) {
                dumpViewHierarchy((ViewGroup) view, out, level + 1);
            } else {
                dumpView(view, out, level + 1);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.116 -0400", hash_original_method = "FF15F5FE1007358DFF706EB6B3D4C8A8", hash_generated_method = "AA76F32E1682C7F4568C019E99836646")
    private static boolean dumpView(Object view, BufferedWriter out, int level) {
        try {
            for (int i = 0; i < level; i++) {
                out.write(' ');
            }
            out.write(view.getClass().getName());
            out.write('@');
            out.write(Integer.toHexString(view.hashCode()));
            out.newLine();
        } catch (IOException e) {
            Log.w("View", "Error while dumping hierarchy tree");
            return false;
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.116 -0400", hash_original_method = "AD4DEB44C21E866C8545DD91154B3A1A", hash_generated_method = "D809222B30973DF68A512A024A4D274A")
    private static Field[] capturedViewGetPropertyFields(Class<?> klass) {
        if (mCapturedViewFieldsForClasses == null) {
            mCapturedViewFieldsForClasses = new HashMap<Class<?>, Field[]>();
        }
        final HashMap<Class<?>, Field[]> map = mCapturedViewFieldsForClasses;
        Field[] fields = map.get(klass);
        if (fields != null) {
            return fields;
        }
        final ArrayList<Field> foundFields = new ArrayList<Field>();
        fields = klass.getFields();
        int count = fields.length;
        for (int i = 0; i < count; i++) {
            final Field field = fields[i];
            if (field.isAnnotationPresent(CapturedViewProperty.class)) {
                field.setAccessible(true);
                foundFields.add(field);
            }
        }
        fields = foundFields.toArray(new Field[foundFields.size()]);
        map.put(klass, fields);
        return fields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.116 -0400", hash_original_method = "5A29577CBC3FDAB090889A379D23E802", hash_generated_method = "5454DF1003FC9819721D2BC7171DCE3A")
    private static Method[] capturedViewGetPropertyMethods(Class<?> klass) {
        if (mCapturedViewMethodsForClasses == null) {
            mCapturedViewMethodsForClasses = new HashMap<Class<?>, Method[]>();
        }
        final HashMap<Class<?>, Method[]> map = mCapturedViewMethodsForClasses;
        Method[] methods = map.get(klass);
        if (methods != null) {
            return methods;
        }
        final ArrayList<Method> foundMethods = new ArrayList<Method>();
        methods = klass.getMethods();
        int count = methods.length;
        for (int i = 0; i < count; i++) {
            final Method method = methods[i];
            if (method.getParameterTypes().length == 0 &&
                    method.isAnnotationPresent(CapturedViewProperty.class) &&
                    method.getReturnType() != Void.class) {
                method.setAccessible(true);
                foundMethods.add(method);
            }
        }
        methods = foundMethods.toArray(new Method[foundMethods.size()]);
        map.put(klass, methods);
        return methods;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.117 -0400", hash_original_method = "CBB1B3DBF4AD07FDDC99DFD405205658", hash_generated_method = "6EFD33431FB20EE7D43F9B50A8AE908A")
    private static String capturedViewExportMethods(Object obj, Class<?> klass,
            String prefix) {
        if (obj == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        final Method[] methods = capturedViewGetPropertyMethods(klass);
        int count = methods.length;
        for (int i = 0; i < count; i++) {
            final Method method = methods[i];
            try {
                Object methodValue = method.invoke(obj, (Object[]) null);
                final Class<?> returnType = method.getReturnType();
                CapturedViewProperty property = method.getAnnotation(CapturedViewProperty.class);
                if (property.retrieveReturn()) {
                    sb.append(capturedViewExportMethods(methodValue, returnType, method.getName() + "#"));
                } else {
                    sb.append(prefix);
                    sb.append(method.getName());
                    sb.append("()=");
                    if (methodValue != null) {
                        final String value = methodValue.toString().replace("\n", "\\n");
                        sb.append(value);
                    } else {
                        sb.append("null");
                    }
                    sb.append("; ");
                }
              } catch (IllegalAccessException e) {
              } catch (InvocationTargetException e) {
              }
        }
        return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.117 -0400", hash_original_method = "F6A503DBD2DFB21E8B5B9BC29E887828", hash_generated_method = "9791D79841B4B7E102F2B6844F797F43")
    private static String capturedViewExportFields(Object obj, Class<?> klass, String prefix) {
        if (obj == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        final Field[] fields = capturedViewGetPropertyFields(klass);
        int count = fields.length;
        for (int i = 0; i < count; i++) {
            final Field field = fields[i];
            try {
                Object fieldValue = field.get(obj);
                sb.append(prefix);
                sb.append(field.getName());
                sb.append("=");
                if (fieldValue != null) {
                    final String value = fieldValue.toString().replace("\n", "\\n");
                    sb.append(value);
                } else {
                    sb.append("null");
                }
                sb.append(' ');
            } catch (IllegalAccessException e) {
            }
        }
        return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.117 -0400", hash_original_method = "6F03A5FA77D585185CEEB4D6B5BD49D6", hash_generated_method = "D2F370546D81579323BCC88D10E48A0C")
    public static void dumpCapturedView(String tag, Object view) {
        Class<?> klass = view.getClass();
        StringBuilder sb = new StringBuilder(klass.getName() + ": ");
        sb.append(capturedViewExportFields(view, klass, ""));
        sb.append(capturedViewExportMethods(view, klass, ""));
        Log.d(tag, sb.toString());
    }

    
    public enum HierarchyTraceType {
        INVALIDATE,
        INVALIDATE_CHILD,
        INVALIDATE_CHILD_IN_PARENT,
        REQUEST_LAYOUT,
        ON_LAYOUT,
        ON_MEASURE,
        DRAW,
        BUILD_CACHE
    }

    
    public enum RecyclerTraceType {
        NEW_VIEW,
        BIND_VIEW,
        RECYCLE_FROM_ACTIVE_HEAP,
        RECYCLE_FROM_SCRAP_HEAP,
        MOVE_TO_SCRAP_HEAP,
        MOVE_FROM_ACTIVE_TO_SCRAP_HEAP
    }

    
    private static class RecyclerTrace {
        public int view;
        public RecyclerTraceType type;
        public int position;
        public int indexOnScreen;
        
    }


    
    private static class LooperProfiler implements Looper.Profiler, Printer {
        private static final String LOG_TAG = "LooperProfiler";
        private static final int TRACE_VERSION_NUMBER = 3;
        private static final int ACTION_EXIT_METHOD = 0x1;
        private static final int HEADER_SIZE = 32;
        private static final String HEADER_MAGIC = "SLOW";
        private static final short HEADER_RECORD_SIZE = (short) 14;
        private final long mTraceWallStart;
        private final long mTraceThreadStart;
        private final ArrayList<Entry> mTraces = new ArrayList<Entry>(512);
        private final HashMap<String, Integer> mTraceNames = new HashMap<String, Integer>(32);
        private int mTraceId = 0;
        private final String mPath;
        private ParcelFileDescriptor mFileDescriptor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.117 -0400", hash_original_method = "837FBF9717038E47AC8A60A9DD4D19D4", hash_generated_method = "0853A6D1332C8346903321CF852B8EBB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         LooperProfiler(String path, FileDescriptor fileDescriptor) {
            dsTaint.addTaint(path);
            dsTaint.addTaint(fileDescriptor.dsTaint);
            try 
            {
                mFileDescriptor = ParcelFileDescriptor.dup(fileDescriptor);
            } //End block
            catch (IOException e)
            {
                throw new RuntimeException(e);
            } //End block
            mTraceWallStart = SystemClock.currentTimeMicro();
            mTraceThreadStart = SystemClock.currentThreadTimeMicro();
            // ---------- Original Method ----------
            //mPath = path;
            //try {
                //mFileDescriptor = ParcelFileDescriptor.dup(fileDescriptor);
            //} catch (IOException e) {
                //Log.e(LOG_TAG, "Could not write trace file " + mPath, e);
                //throw new RuntimeException(e);
            //}
            //mTraceWallStart = SystemClock.currentTimeMicro();
            //mTraceThreadStart = SystemClock.currentThreadTimeMicro();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.117 -0400", hash_original_method = "154FC169BABA0D9841DA90FB18C972FB", hash_generated_method = "918FDEC0BA3F8E5F368C08B69FA04391")
        @DSModeled(DSC.SAFE)
        @Override
        public void println(String x) {
            dsTaint.addTaint(x);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.117 -0400", hash_original_method = "CBC3F19E284786CED14CDBC43ACD7A30", hash_generated_method = "93A6565474525EDCA0425C3E226CE1BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void profile(Message message, long wallStart, long wallTime,
                long threadStart, long threadTime) {
            dsTaint.addTaint(message.dsTaint);
            dsTaint.addTaint(threadStart);
            dsTaint.addTaint(threadTime);
            dsTaint.addTaint(wallStart);
            dsTaint.addTaint(wallTime);
            Entry entry;
            entry = new Entry();
            entry.traceId = getTraceId(message);
            entry.wallStart = wallStart;
            entry.wallTime = wallTime;
            entry.threadStart = threadStart;
            entry.threadTime = threadTime;
            mTraces.add(entry);
            // ---------- Original Method ----------
            //Entry entry = new Entry();
            //entry.traceId = getTraceId(message);
            //entry.wallStart = wallStart;
            //entry.wallTime = wallTime;
            //entry.threadStart = threadStart;
            //entry.threadTime = threadTime;
            //mTraces.add(entry);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.117 -0400", hash_original_method = "A4E97683E16A36EF6068E097213C1038", hash_generated_method = "3A52202085609BCD5B8CAD088A16DDD0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int getTraceId(Message message) {
            dsTaint.addTaint(message.dsTaint);
            String name;
            name = message.getTarget().getMessageName(message);
            Integer traceId;
            traceId = mTraceNames.get(name);
            {
                traceId = mTraceId++ << 4;
                mTraceNames.put(name, traceId);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //String name = message.getTarget().getMessageName(message);
            //Integer traceId = mTraceNames.get(name);
            //if (traceId == null) {
                //traceId = mTraceId++ << 4;
                //mTraceNames.put(name, traceId);
            //}
            //return traceId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.118 -0400", hash_original_method = "BBA2F80D690B10E11CCE7370554710C3", hash_generated_method = "A95AD2E3EDEF5CEB1F01130859161D07")
        @DSModeled(DSC.SAFE)
         void save() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    saveTraces();
                }
            }, "LooperProfiler[" + mPath + "]").start();
            // ---------- Original Method ----------
            //new Thread(new Runnable() {
                //@Override
                //public void run() {
                    //saveTraces();
                //}
            //}, "LooperProfiler[" + mPath + "]").start();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.118 -0400", hash_original_method = "B1053AAB109E078FB60D54B6D9E37ED4", hash_generated_method = "DFEB8CA73B2C2A12F9B6E43B05303701")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void saveTraces() {
            FileOutputStream fos;
            fos = new FileOutputStream(mFileDescriptor.getFileDescriptor());
            DataOutputStream out;
            out = new DataOutputStream(new BufferedOutputStream(fos));
            try 
            {
                writeHeader(out, mTraceWallStart, mTraceNames, mTraces);
                out.flush();
                writeTraces(fos, out.size(), mTraceWallStart, mTraceThreadStart, mTraces);
                Log.d(LOG_TAG, "Looper traces ready: " + mPath);
            } //End block
            catch (IOException e)
            { }
            finally 
            {
                try 
                {
                    out.close();
                } //End block
                catch (IOException e)
                { }
                try 
                {
                    mFileDescriptor.close();
                } //End block
                catch (IOException e)
                { }
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.118 -0400", hash_original_method = "6DB53493054EB653FCC57744E10A37C3", hash_generated_method = "3EA9F3FD78D83830D6725350408491B1")
        private static void writeTraces(FileOutputStream out, long offset, long wallStart,
                long threadStart, ArrayList<Entry> entries) throws IOException {
            FileChannel channel = out.getChannel();
            ByteBuffer buffer = ByteBuffer.allocateDirect(HEADER_SIZE);
            buffer.put(HEADER_MAGIC.getBytes());
            buffer = buffer.order(ByteOrder.LITTLE_ENDIAN);
            buffer.putShort((short) TRACE_VERSION_NUMBER);
            buffer.putShort((short) HEADER_SIZE);
            buffer.putLong(wallStart);
            buffer.putShort(HEADER_RECORD_SIZE);
            for (int i = 0; i < HEADER_SIZE - 18; i++) {
                buffer.put((byte) 0);
            }
            buffer.flip();
            channel.position(offset).write(buffer);
            buffer = ByteBuffer.allocateDirect(14).order(ByteOrder.LITTLE_ENDIAN);
            for (Entry entry : entries) {
                buffer.putShort((short) 1);   
                buffer.putInt(entry.traceId); 
                buffer.putInt((int) (entry.threadStart - threadStart));
                buffer.putInt((int) (entry.wallStart - wallStart));
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
                buffer.putShort((short) 1);
                buffer.putInt(entry.traceId | ACTION_EXIT_METHOD); 
                buffer.putInt((int) (entry.threadStart + entry.threadTime - threadStart));
                buffer.putInt((int) (entry.wallStart + entry.wallTime - wallStart));
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
            }
            channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.118 -0400", hash_original_method = "20D97EEE98DFBFB333B9F1C6A8DB2C13", hash_generated_method = "1FFCB9187F284F5428F273980FFA3938")
        private static void writeHeader(DataOutputStream out, long start,
                HashMap<String, Integer> names, ArrayList<Entry> entries) throws IOException {
            Entry last = entries.get(entries.size() - 1);
            long wallTotal = (last.wallStart + last.wallTime) - start;
            startSection("version", out);
            addValue(null, Integer.toString(TRACE_VERSION_NUMBER), out);
            addValue("data-file-overflow", "false", out);
            addValue("clock", "dual", out);
            addValue("elapsed-time-usec", Long.toString(wallTotal), out);
            addValue("num-method-calls", Integer.toString(entries.size()), out);
            addValue("clock-call-overhead-nsec", "1", out);
            addValue("vm", "dalvik", out);
            startSection("threads", out);
            addThreadId(1, "main", out);
            startSection("methods", out);
            addMethods(names, out);
            startSection("end", out);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.118 -0400", hash_original_method = "C843E445BEC77FA6E6B28EFEC888FAD6", hash_generated_method = "F58880A23485C5F4A4C69BFDF8D9B196")
        private static void addMethods(HashMap<String, Integer> names, DataOutputStream out) throws IOException {
            for (Map.Entry<String, Integer> name : names.entrySet()) {
                out.writeBytes(String.format("0x%08x\tEventQueue\t%s\t()V\tLooper\t-2\n",
                        name.getValue(), name.getKey()));
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.118 -0400", hash_original_method = "3C4BD9177EE9F60FD531F61C4A7D2CF3", hash_generated_method = "BC51CAAD89A42C590E0E4F20FC3C1D12")
        private static void addThreadId(int id, String name, DataOutputStream out) throws IOException {
            out.writeBytes(Integer.toString(id) + '\t' + name + '\n');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.118 -0400", hash_original_method = "B920499BB087E24AC6B54AC1CF0ED8BD", hash_generated_method = "A174DD553BEB6A1FDB365C4F5AD9BF0E")
        private static void addValue(String name, String value, DataOutputStream out) throws IOException {
            if (name != null) {
                out.writeBytes(name + "=");
            }
            out.writeBytes(value + '\n');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.118 -0400", hash_original_method = "F61DA6CBDE4E83116359AD4099969BDE", hash_generated_method = "453931FDD018CB766721284D6FC65F28")
        private static void startSection(String name, DataOutputStream out) throws IOException {
            out.writeBytes("*" + name + '\n');
        }

        
        static class Entry {
            int traceId;
            long wallStart;
            long wallTime;
            long threadStart;
            long threadTime;
            
        }


        
    }


    
    @Target({ ElementType.FIELD, ElementType.METHOD }) @Retention(RetentionPolicy.RUNTIME) public @interface ExportedProperty {
        
        boolean resolveId() default false;

        
        IntToString[] mapping() default { };

        
        IntToString[] indexMapping() default { };

        
        FlagToString[] flagMapping() default { };

        
        boolean deepExport() default false;

        
        String prefix() default "";

        
        String category() default "";
    }
    
    @Target({ ElementType.TYPE }) @Retention(RetentionPolicy.RUNTIME) public @interface IntToString {
        
        int from();

        
        String to();
    }
    
    @Target({ ElementType.TYPE }) @Retention(RetentionPolicy.RUNTIME) public @interface FlagToString {
        
        int mask();

        
        int equals();

        
        String name();

        
        boolean outputIf() default true;
    }
    
    @Target({ ElementType.FIELD, ElementType.METHOD }) @Retention(RetentionPolicy.RUNTIME) public @interface CapturedViewProperty {
        
        boolean retrieveReturn() default false;
    }
    
    interface ViewOperation<T> {
        T[] pre();
        void run(T... data);
        void post(T... data);
    }
    
}


