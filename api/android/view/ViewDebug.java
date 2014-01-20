package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

public class ViewDebug {

    /**
     * Returns the number of instanciated Views.
     *
     * @return The number of Views instanciated in the current process.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.607 -0500", hash_original_method = "CCEE31E4C5D51FDD46E34DBD2A6B75D9", hash_generated_method = "0B1C13CA86AF922803546494A9B1F0CE")
    
public static long getViewInstanceCount() {
        return Debug.countInstancesOfClass(View.class);
    }

    /**
     * Returns the number of instanciated ViewAncestors.
     *
     * @return The number of ViewAncestors instanciated in the current process.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.609 -0500", hash_original_method = "C636D1AA1C9C73737089BE8BB62EDBEC", hash_generated_method = "B270B1B674743876C74554C6FEE6F70B")
    
public static long getViewRootImplCount() {
        return Debug.countInstancesOfClass(ViewRootImpl.class);
    }

    /**
     * Starts profiling the looper associated with the current thread.
     * You must call {@link #stopLooperProfiling} to end profiling
     * and obtain the traces. Both methods must be invoked on the
     * same thread.
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.612 -0500", hash_original_method = "EF2A89919039C059591C707BFA388818", hash_generated_method = "03D9C4A9A2994154D08B794E525661AE")
    
public static void startLooperProfiling(String path, FileDescriptor fileDescriptor) {
        if (sLooperProfilerStorage.get() == null) {
            LooperProfiler profiler = new LooperProfiler(path, fileDescriptor);
            sLooperProfilerStorage.set(profiler);
            Looper.myLooper().setMessageLogging(profiler);
        }
    }

    /**
     * Stops profiling the looper associated with the current thread.
     * 
     * @see #startLooperProfiling(String, java.io.FileDescriptor) 
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.614 -0500", hash_original_method = "B599040D5B8FC90AA7B29D3CCB6AB179", hash_generated_method = "09E38150DD01F21E96CB1FFC65FDAD51")
    
public static void stopLooperProfiling() {
        LooperProfiler profiler = sLooperProfilerStorage.get();
        if (profiler != null) {
            sLooperProfilerStorage.remove();
            Looper.myLooper().setMessageLogging(null);
            profiler.save();
        }
    }

    /**
     * Outputs a trace to the currently opened recycler traces. The trace records the type of
     * recycler action performed on the supplied view as well as a number of parameters.
     *
     * @param view the view to trace
     * @param type the type of the trace
     * @param parameters parameters depending on the type of the trace
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.707 -0500", hash_original_method = "9FB603FC61BD2E2F993FED5B311CF194", hash_generated_method = "BEC868AACCB7B8E08C9A6DD3BD322D10")
    
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

    /**
     * Starts tracing the view recycler of the specified view. The trace is identified by a prefix,
     * used to build the traces files names: <code>/EXTERNAL/view-recycler/PREFIX.traces</code> and
     * <code>/EXTERNAL/view-recycler/PREFIX.recycler</code>.
     *
     * Only one view recycler can be traced at the same time. After calling this method, any
     * other invocation will result in a <code>IllegalStateException</code> unless
     * {@link #stopRecyclerTracing()} is invoked before.
     *
     * Traces files are created only after {@link #stopRecyclerTracing()} is invoked.
     *
     * This method will return immediately if TRACE_RECYCLER is false.
     *
     * @param prefix the traces files name prefix
     * @param view the view whose recycler must be traced
     *
     * @see #stopRecyclerTracing()
     * @see #trace(View, android.view.ViewDebug.RecyclerTraceType, int[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.710 -0500", hash_original_method = "A97F2647E45111D7E82EA9F0820CF7DC", hash_generated_method = "D5479F73F00E81983B5E48E309E8D21E")
    
public static void startRecyclerTracing(String prefix, View view) {
        //noinspection PointlessBooleanExpression,ConstantConditions
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

    /**
     * Stops the current view recycer tracing.
     *
     * Calling this method creates the file <code>/EXTERNAL/view-recycler/PREFIX.traces</code>
     * containing all the traces (or method calls) relative to the specified view's recycler.
     *
     * Calling this method creates the file <code>/EXTERNAL/view-recycler/PREFIX.recycler</code>
     * containing all of the views used by the recycler of the view supplied to
     * {@link #startRecyclerTracing(String, View)}.
     *
     * This method will return immediately if TRACE_RECYCLER is false.
     *
     * @see #startRecyclerTracing(String, View)
     * @see #trace(View, android.view.ViewDebug.RecyclerTraceType, int[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.713 -0500", hash_original_method = "6A5ECEFFFC71FF3D06FE75037F54C9D8", hash_generated_method = "1E9F1CB9BCE4268382C193FC4DD17A0A")
    
public static void stopRecyclerTracing() {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (!TRACE_RECYCLER) {
            return;
        }

        if (sRecyclerOwnerView == null || sRecyclerViews == null) {
            throw new IllegalStateException("You must call startRecyclerTracing() before" +
                " stopRecyclerTracing()!");
        }

        File recyclerDump = new File(Environment.getExternalStorageDirectory(), "view-recycler/");
        //noinspection ResultOfMethodCallIgnored
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
                //noinspection ResultOfMethodCallIgnored
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

    /**
     * Outputs a trace to the currently opened traces file. The trace contains the class name
     * and instance's hashcode of the specified view as well as the supplied trace type.
     *
     * @param view the view to trace
     * @param type the type of the trace
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.716 -0500", hash_original_method = "A4A7588B59209B328B6730A5C3959508", hash_generated_method = "63A92CD43C3BEED908631B9323570E0F")
    
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

    /**
     * Starts tracing the view hierarchy of the specified view. The trace is identified by a prefix,
     * used to build the traces files names: <code>/EXTERNAL/view-hierarchy/PREFIX.traces</code> and
     * <code>/EXTERNAL/view-hierarchy/PREFIX.tree</code>.
     *
     * Only one view hierarchy can be traced at the same time. After calling this method, any
     * other invocation will result in a <code>IllegalStateException</code> unless
     * {@link #stopHierarchyTracing()} is invoked before.
     *
     * Calling this method creates the file <code>/EXTERNAL/view-hierarchy/PREFIX.traces</code>
     * containing all the traces (or method calls) relative to the specified view's hierarchy.
     *
     * This method will return immediately if TRACE_HIERARCHY is false.
     *
     * @param prefix the traces files name prefix
     * @param view the view whose hierarchy must be traced
     *
     * @see #stopHierarchyTracing()
     * @see #trace(View, android.view.ViewDebug.HierarchyTraceType)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.719 -0500", hash_original_method = "6D01B685939D5CC18EA0CD73C471B3BF", hash_generated_method = "C32F65133426349CAF8C95959162EDD3")
    
public static void startHierarchyTracing(String prefix, View view) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (!TRACE_HIERARCHY) {
            return;
        }

        if (sHierarhcyRoot != null) {
            throw new IllegalStateException("You must call stopHierarchyTracing() before running" +
                " a new trace!");
        }

        File hierarchyDump = new File(Environment.getExternalStorageDirectory(), "view-hierarchy/");
        //noinspection ResultOfMethodCallIgnored
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

    /**
     * Stops the current view hierarchy tracing. This method closes the file
     * <code>/EXTERNAL/view-hierarchy/PREFIX.traces</code>.
     *
     * Calling this method creates the file <code>/EXTERNAL/view-hierarchy/PREFIX.tree</code>
     * containing the view hierarchy of the view supplied to
     * {@link #startHierarchyTracing(String, View)}.
     *
     * This method will return immediately if TRACE_HIERARCHY is false.
     *
     * @see #startHierarchyTracing(String, View)
     * @see #trace(View, android.view.ViewDebug.HierarchyTraceType)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.722 -0500", hash_original_method = "A9B61ADDC99B501812E388E1C7DE321B", hash_generated_method = "EBCFC7F1A261D06096A284CE91A688F1")
    
public static void stopHierarchyTracing() {
        //noinspection PointlessBooleanExpression,ConstantConditions
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
        //noinspection ResultOfMethodCallIgnored
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

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.725 -0500", hash_original_method = "8AD232DF2BF806FA5443AE736277CC43", hash_generated_method = "33C9D1D66835AC0B098B971E6D082DAF")
    
static void dispatchCommand(View view, String command, String parameters,
            OutputStream clientStream) throws IOException {

        // Paranoid but safe...
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.728 -0500", hash_original_method = "E7AA1AA0F5F3D46BF2196FEAFC7C37E8", hash_generated_method = "95474F79119DE35319CDF7CA4591800E")
    
private static View findView(View root, String parameter) {
        // Look by type/hashcode
        if (parameter.indexOf('@') != -1) {
            final String[] ids = parameter.split("@");
            final String className = ids[0];
            final int hashCode = (int) Long.parseLong(ids[1], 16);

            View view = root.getRootView();
            if (view instanceof ViewGroup) {
                return findView((ViewGroup) view, className, hashCode);
            }
        } else {
            // Look by id
            final int id = root.getResources().getIdentifier(parameter, null, null);
            return root.getRootView().findViewById(id);
        }

        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.731 -0500", hash_original_method = "BDF07495D49506A0278A7A607DDE349D", hash_generated_method = "43C7718534665A73D78F0B8DD5D31E06")
    
private static void invalidate(View root, String parameter) {
        final View view = findView(root, parameter);
        if (view != null) {
            view.postInvalidate();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.737 -0500", hash_original_method = "87EF2D5214EE0EA9F700768E799A7935", hash_generated_method = "812311D8246BFDC28512970A2890A732")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.740 -0500", hash_original_method = "99E7503B140035CB3F5FB600D6940FA3", hash_generated_method = "C77A165820A546A2CE3858F07922A0E0")
    
private static void profile(View root, OutputStream clientStream, String parameter)
            throws IOException {

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.742 -0500", hash_original_method = "86262C0779C950C480BCEAAE522536AB", hash_generated_method = "CA5033671F6D088F5626A372CCAB075B")
    
private static void profileViewAndChildren(final View view, BufferedWriter out)
            throws IOException {
        profileViewAndChildren(view, out, true);
    }
    
    private static void profileViewAndChildren(final View view, BufferedWriter out, boolean root) throws IOException {
        long durationMeasure =
                (root || (view.mPrivateFlags & View.MEASURED_DIMENSION_SET) != 0) ? profileViewOperation(
                        view, new ViewOperation<Void>() {
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.745 -0500", hash_original_method = "7BE3F9203EABDCBF8DACB6E8C5AEDCF9", hash_generated_method = "5BF13CC06AF448E8308DC62B7E510FFC")
            
public Void[] pre() {
                                forceLayout(view);
                                return null;
                            }

                            @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.749 -0500", hash_original_method = "4A21A3C59CED96F8D51A1FA9FDD7BAE0", hash_generated_method = "13026B6C2BAE548CE0661B4E35CFB0B2")
            
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

                            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.752 -0500", hash_original_method = "6013704228982E97FB973F82736F42CE", hash_generated_method = "F9CEB5979EACB91CCE193A24D09FF00D")
            
public void run(Void... data) {
                                view.measure(view.mOldWidthMeasureSpec, view.mOldHeightMeasureSpec);
                            }

                            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.763 -0500", hash_original_method = "19C732406AC2F64BF228A6F49B309D98", hash_generated_method = "D3D301531CA9F2BE37623F87DC249B10")
            
public void post(Void... data) {
                            }
                        })
                        : 0;
        long durationLayout =
                (root || (view.mPrivateFlags & View.LAYOUT_REQUIRED) != 0) ? profileViewOperation(
                        view, new ViewOperation<Void>() {
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.757 -0500", hash_original_method = "9D7A6EC9081F2A3206C22A27DAF8B0BE", hash_generated_method = "39B95AE6A4CDE3185642FFE8E012EE38")
            
public Void[] pre() {
                                return null;
                            }

                            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.760 -0500", hash_original_method = "3F730000C209EBEB5C668B2A65DB883B", hash_generated_method = "ABB4769E4A2DACEE0FAAB3EE9FC33C7D")
            
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
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.767 -0500", hash_original_method = "AE60A3A50BEE9927A1EF0B757BB11139", hash_generated_method = "B1433473DFE5A5CED7DA71FF3BC34074")
            
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

                            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.770 -0500", hash_original_method = "8269B73C7B71CAAD31596C30088BDAC6", hash_generated_method = "F329E3B8A56A19B11F249E9ED96DAB61")
            
public void run(Object... data) {
                                if (data[1] != null) {
                                    view.draw((Canvas) data[1]);
                                }
                            }

                            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.773 -0500", hash_original_method = "64AD3C6CD58686EA855383754443A206", hash_generated_method = "83511501FBC3A4264566C00C6B4696CC")
            
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
    
    private static <T> long profileViewOperation(View view, final ViewOperation<T> operation) {
        final CountDownLatch latch = new CountDownLatch(1);
        final long[] duration = new long[1];
        view.post(new Runnable() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.782 -0500", hash_original_method = "288ADD315909186063EB07E77583ADE2", hash_generated_method = "74764E748370F80D838A7371BF5A1AD7")
            
public void run() {
                try {
                    T[] data = operation.pre();
                    long start = Debug.threadCpuTimeNanos();
                    //noinspection unchecked
                    operation.run(data);
                    duration[0] = Debug.threadCpuTimeNanos() - start;
                    //noinspection unchecked
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.787 -0500", hash_original_method = "D93CAC5EB5297F4337ACFC64A6E530F1", hash_generated_method = "E4D466846E11B235E705F51980106360")
    
private static void captureLayers(View root, final DataOutputStream clientStream)
            throws IOException {

        try {
            Rect outRect = new Rect();
            try {
                root.mAttachInfo.mSession.getDisplayFrame(root.mAttachInfo.mWindow, outRect);
            } catch (RemoteException e) {
                // Ignore
            }
    
            clientStream.writeInt(outRect.width());
            clientStream.writeInt(outRect.height());
    
            captureViewLayer(root, clientStream, true);
            
            clientStream.write(2);
        } finally {
            clientStream.close();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.791 -0500", hash_original_method = "39E4687AEC0DFE57B6041298B9A06FA7", hash_generated_method = "8176D68E0C5BD54CA07606596428F328")
    
private static void captureViewLayer(View view, DataOutputStream clientStream, boolean visible)
            throws IOException {

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
            // XXX: Should happen on the UI thread
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.794 -0500", hash_original_method = "50C6ECE900AC13BE000E66CA433DF6CB", hash_generated_method = "F8FB69A5968C85FA97BB5670485A3A4C")
    
private static void outputDisplayList(View root, String parameter) throws IOException {
        final View view = findView(root, parameter);
        view.getViewRootImpl().outputDisplayList(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.797 -0500", hash_original_method = "E4E94A0B923CC4129DB34454045BA112", hash_generated_method = "991D81AE6518E93C1CA34F5A33E0850F")
    
private static void capture(View root, final OutputStream clientStream, String parameter)
            throws IOException {

        final View captureView = findView(root, parameter);
        Bitmap b = performViewCapture(captureView, false);

        if (b == null) {
            Log.w("View", "Failed to create capture bitmap!");
            // Send an empty one so that it doesn't get stuck waiting for
            // something.
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.803 -0500", hash_original_method = "4A1042000584F6AE08665276166265A9", hash_generated_method = "67DEB65E63F80556F970FE8551471666")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.805 -0500", hash_original_method = "F61162F3CABBD02821B784FB69394317", hash_generated_method = "CCE1AE04DF35DB854AD7CBFA40B0F455")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.808 -0500", hash_original_method = "5833D78630A0ABEF24425617A800E52C", hash_generated_method = "413904C6AA110C0AE8BE90235E87B3EE")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.811 -0500", hash_original_method = "6C30A5CCC0CF82FA550A697812F2D8AC", hash_generated_method = "12D70F8FAEA6DEE0BB6478FD1D95C69B")
    
private static boolean isRequestedView(View view, String className, int hashCode) {
        return view.getClass().getName().equals(className) && view.hashCode() == hashCode;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.814 -0500", hash_original_method = "5477E7361E0198F52F4739FAE13D1748", hash_generated_method = "50EE2420BF0B26544444127159CE6215")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.817 -0500", hash_original_method = "A1D47394B3DD77835A07F9275FAED40E", hash_generated_method = "DB6679FD3383EF9E6055FD47B7B3C08D")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.820 -0500", hash_original_method = "096C849E8C18A39942244A8C79B40CB5", hash_generated_method = "8B80C1A11D4E04C892D17BBCE9BE3C92")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.824 -0500", hash_original_method = "ED3508DD2DBB4E6ACB6B0001C73AF024", hash_generated_method = "399A8AB9A99FD5F31C02002C0913058D")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.826 -0500", hash_original_method = "40CE639F8706808D9F15554E44131B8F", hash_generated_method = "B8629DCE341C48FAE52277ED1BC33E89")
    
private static void dumpViewProperties(Context context, Object view,
            BufferedWriter out) throws IOException {

        dumpViewProperties(context, view, out, "");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.829 -0500", hash_original_method = "7BB17C895A68D99A44294B984761FB55", hash_generated_method = "29BC5A36792F5A122B8F501257EE43D4")
    
private static void dumpViewProperties(Context context, Object view,
            BufferedWriter out, String prefix) throws IOException {

        Class<?> klass = view.getClass();

        do {
            exportFields(context, view, out, klass, prefix);
            exportMethods(context, view, out, klass, prefix);
            klass = klass.getSuperclass();
        } while (klass != Object.class);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.833 -0500", hash_original_method = "B03A838660ADA490E1042D45D00ECCAF", hash_generated_method = "ED479D837200EA7BB9F6E4B04392E6F2")
    
private static void exportMethods(Context context, Object view, BufferedWriter out,
            Class<?> klass, String prefix) throws IOException {

        final Method[] methods = getExportedPropertyMethods(klass);

        int count = methods.length;
        for (int i = 0; i < count; i++) {
            final Method method = methods[i];
            //noinspection EmptyCatchBlock
            try {
                // TODO: This should happen on the UI thread
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

                    // Probably want to return here, same as for fields.
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.837 -0500", hash_original_method = "3A18E6E106473CB28FC5E1DDECF06C31", hash_generated_method = "688185751DD7B5CF578D69E9D5A30983")
    
private static void exportFields(Context context, Object view, BufferedWriter out,
            Class<?> klass, String prefix) throws IOException {

        final Field[] fields = getExportedPropertyFields(klass);

        int count = fields.length;
        for (int i = 0; i < count; i++) {
            final Field field = fields[i];

            //noinspection EmptyCatchBlock
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

                    // We exit here!
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.840 -0500", hash_original_method = "B7098ACB062DBE88371A117C8201E088", hash_generated_method = "6FE9FE758E446071750999C24203E6FD")
    
private static void writeEntry(BufferedWriter out, String prefix, String name,
            String suffix, Object value) throws IOException {

        out.write(prefix);
        out.write(name);
        out.write(suffix);
        out.write("=");
        writeValue(out, value);
        out.write(' ');
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.843 -0500", hash_original_method = "FEFEFF09280E6256D889B8A78014AFA9", hash_generated_method = "A8B8B1E23B574D309E0C779FAED8B58A")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.846 -0500", hash_original_method = "F6826B26A33871866C71D95A8BAFF3DE", hash_generated_method = "FC6F4948C554B8F31EC10B30E584CE86")
    
private static void exportUnrolledArray(Context context, BufferedWriter out,
            ExportedProperty property, int[] array, String prefix, String suffix)
            throws IOException {

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

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.849 -0500", hash_original_method = "5FE8610E444A8A1DD826B34556733550", hash_generated_method = "38B8C1C22BADCBEAA730B0774A5762C8")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.851 -0500", hash_original_method = "7AD2EE6006BF39FAA79DC0A5665EF851", hash_generated_method = "CB65942F17F8702C1E1004DD32EE8D8F")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.854 -0500", hash_original_method = "661A6662CA258B0107AEBC63F4E81CD9", hash_generated_method = "10C484D2FFC60F49F85705C42F09FF71")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.857 -0500", hash_original_method = "FF15F5FE1007358DFF706EB6B3D4C8A8", hash_generated_method = "AA76F32E1682C7F4568C019E99836646")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.860 -0500", hash_original_method = "AD4DEB44C21E866C8545DD91154B3A1A", hash_generated_method = "D809222B30973DF68A512A024A4D274A")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.863 -0500", hash_original_method = "5A29577CBC3FDAB090889A379D23E802", hash_generated_method = "5454DF1003FC9819721D2BC7171DCE3A")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.866 -0500", hash_original_method = "CBB1B3DBF4AD07FDDC99DFD405205658", hash_generated_method = "2A343B01109474429B581F4E114A4169")
    
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
                    //we are interested in the second level data only
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
                  //Exception IllegalAccess, it is OK here
                  //we simply ignore this method
              } catch (InvocationTargetException e) {
                  //Exception InvocationTarget, it is OK here
                  //we simply ignore this method
              }
        }
        return sb.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.869 -0500", hash_original_method = "F6A503DBD2DFB21E8B5B9BC29E887828", hash_generated_method = "5195FE8E30501E25A69C911695521DCA")
    
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
                //Exception IllegalAccess, it is OK here
                //we simply ignore this field
            }
        }
        return sb.toString();
    }

    /**
     * Dump view info for id based instrument test generation
     * (and possibly further data analysis). The results are dumped
     * to the log.
     * @param tag for log
     * @param view for dump
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.873 -0500", hash_original_method = "6F03A5FA77D585185CEEB4D6B5BD49D6", hash_generated_method = "D2F370546D81579323BCC88D10E48A0C")
    
public static void dumpCapturedView(String tag, Object view) {
        Class<?> klass = view.getClass();
        StringBuilder sb = new StringBuilder(klass.getName() + ": ");
        sb.append(capturedViewExportFields(view, klass, ""));
        sb.append(capturedViewExportMethods(view, klass, ""));
        Log.d(tag, sb.toString());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.503 -0500", hash_original_field = "E0F8EECB7803DD9B254D198BAE9FE948", hash_generated_field = "86781DCF86035685DDB38D2649CD3D04")

    public static final String CONSISTENCY_LOG_TAG = "ViewConsistency";
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.583 -0500", hash_original_field = "4B0F9FA9FEA20A2DC0BDB6BF9AE10F0A", hash_generated_field = "ED83C2F54CE383C7D62E29BD1035B9D3")

        public int view;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.585 -0500", hash_original_field = "F132822391B0D03BB5F9CC06F37B9974", hash_generated_field = "7C6E79B6BBCCD9A22B2D56B1BBC23A93")

        public RecyclerTraceType type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.588 -0500", hash_original_field = "92D7808EB8CD548A137230400384C6DC", hash_generated_field = "B2F6CC92E86B46C8537E13B7CC7F6689")

        public int position;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.590 -0500", hash_original_field = "C3A890C60F8EAC09FC1E94775E7696DE", hash_generated_field = "ADBFEEFE9BCE8AF6F80B6F5B9949565A")

        public int indexOnScreen;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_method = "ED320AF13EB079D56E1BB2CD418F0F12", hash_generated_method = "ED320AF13EB079D56E1BB2CD418F0F12")
        public RecyclerTrace ()
        {
            //Synthesized constructor
        }

    }
    
    private static class LooperProfiler implements Looper.Profiler, Printer {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.671 -0500", hash_original_method = "6DB53493054EB653FCC57744E10A37C3", hash_generated_method = "146DD2434506C60576E0586CA9849E67")
        
private static void writeTraces(FileOutputStream out, long offset, long wallStart,
                long threadStart, ArrayList<Entry> entries) throws IOException {
    
            FileChannel channel = out.getChannel();
    
            // Header
            ByteBuffer buffer = ByteBuffer.allocateDirect(HEADER_SIZE);
            buffer.put(HEADER_MAGIC.getBytes());
            buffer = buffer.order(ByteOrder.LITTLE_ENDIAN);
            buffer.putShort((short) TRACE_VERSION_NUMBER);    // version
            buffer.putShort((short) HEADER_SIZE);             // offset to data
            buffer.putLong(wallStart);                        // start time in usec
            buffer.putShort(HEADER_RECORD_SIZE);              // size of a record in bytes
            // padding to 32 bytes
            for (int i = 0; i < HEADER_SIZE - 18; i++) {
                buffer.put((byte) 0);
            }
    
            buffer.flip();
            channel.position(offset).write(buffer);
            
            buffer = ByteBuffer.allocateDirect(14).order(ByteOrder.LITTLE_ENDIAN);
            for (Entry entry : entries) {
                buffer.putShort((short) 1);   // we simulate only one thread
                buffer.putInt(entry.traceId); // entering method
                buffer.putInt((int) (entry.threadStart - threadStart));
                buffer.putInt((int) (entry.wallStart - wallStart));
    
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
    
                buffer.putShort((short) 1);
                buffer.putInt(entry.traceId | ACTION_EXIT_METHOD); // exiting method
                buffer.putInt((int) (entry.threadStart + entry.threadTime - threadStart));
                buffer.putInt((int) (entry.wallStart + entry.wallTime - wallStart));
    
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
            }
    
            channel.close();
        }
    
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.676 -0500", hash_original_method = "20D97EEE98DFBFB333B9F1C6A8DB2C13", hash_generated_method = "1FFCB9187F284F5428F273980FFA3938")
        
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
    
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.678 -0500", hash_original_method = "C843E445BEC77FA6E6B28EFEC888FAD6", hash_generated_method = "F58880A23485C5F4A4C69BFDF8D9B196")
        
private static void addMethods(HashMap<String, Integer> names, DataOutputStream out)
                throws IOException {
    
            for (Map.Entry<String, Integer> name : names.entrySet()) {
                out.writeBytes(String.format("0x%08x\tEventQueue\t%s\t()V\tLooper\t-2\n",
                        name.getValue(), name.getKey()));
            }
        }
    
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.681 -0500", hash_original_method = "3C4BD9177EE9F60FD531F61C4A7D2CF3", hash_generated_method = "BC51CAAD89A42C590E0E4F20FC3C1D12")
        
private static void addThreadId(int id, String name, DataOutputStream out)
                throws IOException {

            out.writeBytes(Integer.toString(id) + '\t' + name + '\n');
        }
    
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.684 -0500", hash_original_method = "B920499BB087E24AC6B54AC1CF0ED8BD", hash_generated_method = "A174DD553BEB6A1FDB365C4F5AD9BF0E")
        
private static void addValue(String name, String value, DataOutputStream out)
                throws IOException {
    
            if (name != null) {
                out.writeBytes(name + "=");
            }
            out.writeBytes(value + '\n');
        }
    
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.686 -0500", hash_original_method = "F61DA6CBDE4E83116359AD4099969BDE", hash_generated_method = "453931FDD018CB766721284D6FC65F28")
        
private static void startSection(String name, DataOutputStream out) throws IOException {
            out.writeBytes("*" + name + '\n');
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.618 -0500", hash_original_field = "B8FE124EF8C8C9A7F66FD1D1B93F1EC3", hash_generated_field = "C69277D3A6C0A47CB55912A466260D08")

        private static final String LOG_TAG = "LooperProfiler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.620 -0500", hash_original_field = "7F34A9105007E9D8F5B158EB905C7928", hash_generated_field = "871E2F94CCC725B7827319EDDC137722")

        private static final int TRACE_VERSION_NUMBER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.623 -0500", hash_original_field = "961FB5BA3D2D3C556EAE74C36D7F7D0B", hash_generated_field = "A1F6BAEF2E989EE3FA0925E45A3CFD13")

        private static final int ACTION_EXIT_METHOD = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.625 -0500", hash_original_field = "B8F485D4BC3CB09B22A17252691681CB", hash_generated_field = "76F366AD6EB46B3BF9F1D9821E0B8FE5")

        private static final int HEADER_SIZE = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.628 -0500", hash_original_field = "A61901A8ECB2AF664A3408534A6BF512", hash_generated_field = "4E0FAF61A961141628DFC7DB4534A7E1")

        private static final String HEADER_MAGIC = "SLOW";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.631 -0500", hash_original_field = "908775AEBF5AFF1F83D3FC8BA65FE187", hash_generated_field = "0B85C641B9DE54964CCC1A129A9C40F1")

        private static final short HEADER_RECORD_SIZE = (short) 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.633 -0500", hash_original_field = "A1B1BA0FFBBD3E622916C83AF99DD880", hash_generated_field = "907124E57E6B072BDF3C9759E9F1A9DD")

        private  long mTraceWallStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.636 -0500", hash_original_field = "DD6CF0B4DED058FC0C10C17DA0C798D0", hash_generated_field = "9A8A7790571BC817117ED4A4028799A7")

        private  long mTraceThreadStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.638 -0500", hash_original_field = "0EBBF3DB14DE2D367789C49DCF36DE5A", hash_generated_field = "D18A086A815A6770FBDC3F49B10DB707")
        
        private final ArrayList<Entry> mTraces = new ArrayList<Entry>(512);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.641 -0500", hash_original_field = "A12626BB825790082957D44B5022B42F", hash_generated_field = "DE94B5ABFDFE10D1547A66120C45E13B")

        private final HashMap<String, Integer> mTraceNames = new HashMap<String, Integer>(32);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.643 -0500", hash_original_field = "006441F191C20752C0B905F5AF3E94DB", hash_generated_field = "DA1910C6BCE975350BE95871C9917550")

        private int mTraceId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.646 -0500", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

        private  String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.648 -0500", hash_original_field = "E57966AB286B8F6F75FB7E135DD8912B", hash_generated_field = "2EB80060CD9954C0E91A29E7A228F077")

        private ParcelFileDescriptor mFileDescriptor;
        
        static class Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.689 -0500", hash_original_field = "C68363F70ADCAFF99F59BB383A8DC09F", hash_generated_field = "C68363F70ADCAFF99F59BB383A8DC09F")

            int traceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.691 -0500", hash_original_field = "CD3765D68DA5A5B9F5CE82D9DB609164", hash_generated_field = "CD3765D68DA5A5B9F5CE82D9DB609164")

            long wallStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.694 -0500", hash_original_field = "4AF1E1CB2BFA789E16B71B0DCB178EDB", hash_generated_field = "4AF1E1CB2BFA789E16B71B0DCB178EDB")

            long wallTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.696 -0500", hash_original_field = "2BBAC33AD2B483C35BB689E384478A82", hash_generated_field = "2BBAC33AD2B483C35BB689E384478A82")

            long threadStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.698 -0500", hash_original_field = "C322CE8D67E78FB4B046F4C7179E5580", hash_generated_field = "C322CE8D67E78FB4B046F4C7179E5580")

            long threadTime;
            
            @DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_method = "629F4A8E90A91F8ECA92C26A9EB219B2", hash_generated_method = "629F4A8E90A91F8ECA92C26A9EB219B2")
            public Entry ()
            {
                //Synthesized constructor
            }

        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.652 -0500", hash_original_method = "837FBF9717038E47AC8A60A9DD4D19D4", hash_generated_method = "837FBF9717038E47AC8A60A9DD4D19D4")
        
LooperProfiler(String path, FileDescriptor fileDescriptor) {
            mPath = path;
            try {
                mFileDescriptor = ParcelFileDescriptor.dup(fileDescriptor);
            } catch (IOException e) {
                Log.e(LOG_TAG, "Could not write trace file " + mPath, e);
                throw new RuntimeException(e);
            }
            mTraceWallStart = SystemClock.currentTimeMicro();
            mTraceThreadStart = SystemClock.currentThreadTimeMicro();            
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.654 -0500", hash_original_method = "154FC169BABA0D9841DA90FB18C972FB", hash_generated_method = "331B0F270AE3299C7ECC417121293F98")
        
@Override
        public void println(String x) {
            // Ignore messages
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.657 -0500", hash_original_method = "CBC3F19E284786CED14CDBC43ACD7A30", hash_generated_method = "1E8E54C9A4BD0A004585E9F92D54009E")
        
@Override
        public void profile(Message message, long wallStart, long wallTime,
                long threadStart, long threadTime) {
            Entry entry = new Entry();
            entry.traceId = getTraceId(message);
            entry.wallStart = wallStart;
            entry.wallTime = wallTime;
            entry.threadStart = threadStart;
            entry.threadTime = threadTime;

            mTraces.add(entry);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.660 -0500", hash_original_method = "A4E97683E16A36EF6068E097213C1038", hash_generated_method = "37607AC9D622458A484DC439E16CA770")
        
private int getTraceId(Message message) {
            String name = message.getTarget().getMessageName(message);
            Integer traceId = mTraceNames.get(name);
            if (traceId == null) {
                traceId = mTraceId++ << 4;
                mTraceNames.put(name, traceId);
            }
            return traceId;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.665 -0500", hash_original_method = "BBA2F80D690B10E11CCE7370554710C3", hash_generated_method = "90F83B572DE9F07644F26F2FD249A94A")
        
void save() {
            // Don't block the UI thread
            new Thread(new Runnable() {
                @Override
                public void run() {
                    saveTraces();
                }
            }, "LooperProfiler[" + mPath + "]").start();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.668 -0500", hash_original_method = "B1053AAB109E078FB60D54B6D9E37ED4", hash_generated_method = "69C0075C2E96408311C21E4C84229F11")
        
private void saveTraces() {
            FileOutputStream fos = new FileOutputStream(mFileDescriptor.getFileDescriptor());
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(fos));

            try {
                writeHeader(out, mTraceWallStart, mTraceNames, mTraces);
                out.flush();

                writeTraces(fos, out.size(), mTraceWallStart, mTraceThreadStart, mTraces);

                Log.d(LOG_TAG, "Looper traces ready: " + mPath);
            } catch (IOException e) {
                Log.e(LOG_TAG, "Could not write trace file " + mPath, e);
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    Log.e(LOG_TAG, "Could not write trace file " + mPath, e);
                }
                try {
                    mFileDescriptor.close();
                } catch (IOException e) {
                    Log.e(LOG_TAG, "Could not write trace file " + mPath, e);
                }
            }
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.506 -0500", hash_original_field = "47571E059F5D32EC7487DF4B83C42941", hash_generated_field = "D9BFBAE0C25DC40F4D9BB455F91F6D0A")

    public static final int CONSISTENCY_LAYOUT = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.508 -0500", hash_original_field = "EAFAEB2EE820B1127E03B09FA1A16076", hash_generated_field = "8E3E44DD5019328562D473EF23ABD41A")

    public static final int CONSISTENCY_DRAWING = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.511 -0500", hash_original_field = "19F64FDBA46F869E7C8AC43019C04B46", hash_generated_field = "C045360CEDFF189A88AFA4EE8D202DDE")

    public static final boolean TRACE_HIERARCHY = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.514 -0500", hash_original_field = "C1FFD7F74218CD4B02FE2EB68F424353", hash_generated_field = "1A5D3591701CB592F2723D2D1DA3E49E")

    public static final boolean TRACE_RECYCLER = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.516 -0500", hash_original_field = "A240621A6FE886D0DF2417B192F3DA8E", hash_generated_field = "1DC50F8D4E55F1408444042AE0225479")

    public static final boolean DEBUG_PROFILE_DRAWING = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.519 -0500", hash_original_field = "C962547D7DA319172A34D50015190C9D", hash_generated_field = "7BA93C1DFD06077908429783FE30421E")

    public static final boolean DEBUG_PROFILE_LAYOUT = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.521 -0500", hash_original_field = "F6D3A6B901CA5F1498022DE6A1553631", hash_generated_field = "7E6AC0E1C78577CC135F12F385D191DC")

    public static final boolean DEBUG_DRAG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.524 -0500", hash_original_field = "BE57DD4D71F8CF8C1F8FDBDED110CBA1", hash_generated_field = "C436896058FD7FAB45FF8504727A307B")

    public static final boolean DEBUG_LATENCY = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.527 -0500", hash_original_field = "194BC60584B5A1AA24CCCF0CE35CF059", hash_generated_field = "7D1DFC7A96C3DC5260465A4E2AFF73BC")

    @Debug.DebugProperty
    public static boolean consistencyCheckEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.539 -0500", hash_original_field = "B78D7B92E0FFF1F493BFAB8DD20239AA", hash_generated_field = "FCDC3479819F1A0FA21DD7CF7F282FA5")

    private static HashMap<Class<?>, Method[]> mCapturedViewMethodsForClasses = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.542 -0500", hash_original_field = "214827A00EFCD02B5C6496D3C38EC27E", hash_generated_field = "38EEBA983D87300AC01AE0B6BEB32865")

    private static HashMap<Class<?>, Field[]> mCapturedViewFieldsForClasses = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.544 -0500", hash_original_field = "4D0F83E4C12398123D33EBF9C1265F10", hash_generated_field = "EEBCE2DFBBA5939704DCB7EA7757895B")

    private static final int CAPTURE_TIMEOUT = 4000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.547 -0500", hash_original_field = "6BE18B186AD3C45391818965ADA3F639", hash_generated_field = "657ACDB64251CC9C5F5560318566FA83")

    private static final String REMOTE_COMMAND_CAPTURE = "CAPTURE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.549 -0500", hash_original_field = "EEB633F6AC583AB46EDFE7FE0183B06F", hash_generated_field = "E4ABFC964C0C91DA46FEC266E2489143")

    private static final String REMOTE_COMMAND_DUMP = "DUMP";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.552 -0500", hash_original_field = "98D1ABE2A56E1BFD165DDC1EBA6ED090", hash_generated_field = "1603E1D088235440D677B101140595D0")

    private static final String REMOTE_COMMAND_INVALIDATE = "INVALIDATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.554 -0500", hash_original_field = "90707BD74AA73AA1A923A236EB7983E1", hash_generated_field = "3AF7FAF90036557B0EC21263F7AECC7C")

    private static final String REMOTE_COMMAND_REQUEST_LAYOUT = "REQUEST_LAYOUT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.557 -0500", hash_original_field = "78BE9647BC4E0AD0B1E7C0392C312D53", hash_generated_field = "980F6A2777237FD1E1F767C07D103822")

    private static final String REMOTE_PROFILE = "PROFILE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.559 -0500", hash_original_field = "BED28F5CE82F6A9614D80F020881C23F", hash_generated_field = "825BF5137B87DFA820A18794D927B6C9")

    private static final String REMOTE_COMMAND_CAPTURE_LAYERS = "CAPTURE_LAYERS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.562 -0500", hash_original_field = "47DB1EE12E37BB15B7133DF696F1E32E", hash_generated_field = "29D5BE016108CD614B95A1F8D2CA4B48")

    private static final String REMOTE_COMMAND_OUTPUT_DISPLAYLIST = "OUTPUT_DISPLAYLIST";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.564 -0500", hash_original_field = "90244F6B265B81D9B87ECC0E60F60010", hash_generated_field = "381B34CC38C521D55D8B29707BF77CF1")

    private static HashMap<Class<?>, Field[]> sFieldsForClasses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.567 -0500", hash_original_field = "E06DC899D5EC6C09A8B33392387AF1FE", hash_generated_field = "FDF3063B8421F5EF4C9F31EF9C7D1386")

    private static HashMap<Class<?>, Method[]> sMethodsForClasses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.569 -0500", hash_original_field = "1F6E21CBCC9A9433703169A9FDF5BC1A", hash_generated_field = "12967F08A6F1E730898691D5C3FCAE06")

    private static HashMap<AccessibleObject, ExportedProperty> sAnnotations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.573 -0500", hash_original_field = "09F8E575983F8CB8B08B3B2F489D6E79", hash_generated_field = "3DAFD8507B12D2E4DBAAF387421DFD6D")

    private static BufferedWriter sHierarchyTraces;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.576 -0500", hash_original_field = "2AC307A03BE397A4FB457E3BDFB5C463", hash_generated_field = "0947A593046A3A68DF32E94CC1CCF03B")

    private static ViewRootImpl sHierarhcyRoot;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.578 -0500", hash_original_field = "44E6E033FF02398D75DBBF5B43D60000", hash_generated_field = "B8C9F8C71D79A1296B9FDBA6098214E8")

    private static String sHierarchyTracePrefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.594 -0500", hash_original_field = "E4505399391D75884332FEC226A91972", hash_generated_field = "87511F78472767C36F509F6D81A67344")

    private static View sRecyclerOwnerView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.596 -0500", hash_original_field = "9CE9AA4855CAE8D30C7BA11711151D60", hash_generated_field = "C046D203CE4AB5C299FBF2864E9A2CB9")

    private static List<View> sRecyclerViews;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.600 -0500", hash_original_field = "3562E7E421E2EEE8CD6DC1DA9ED73DD3", hash_generated_field = "D119B20D320A23766CBB36F6AAD8A64B")

    private static List<RecyclerTrace> sRecyclerTraces;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.602 -0500", hash_original_field = "1C2FB206FFA6A1B023EE3BEBBD1D3988", hash_generated_field = "2512B7C223A4418693E10B26A4513416")

    private static String sRecyclerTracePrefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:08.605 -0500", hash_original_field = "419B0C15698E313BD38E6CF5F93C4F0B", hash_generated_field = "92F7912ACE2DEBF639BEDECEBAF815D3")

    private static final ThreadLocal<LooperProfiler> sLooperProfilerStorage =
            new ThreadLocal<LooperProfiler>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.264 -0400", hash_original_method = "F785FDC015B150C7B28C32B4894B3E15", hash_generated_method = "F785FDC015B150C7B28C32B4894B3E15")
    public ViewDebug ()
    {
        //Synthesized constructor
    }
}

