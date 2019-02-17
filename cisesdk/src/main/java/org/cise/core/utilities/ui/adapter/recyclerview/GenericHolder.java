package org.cise.core.utilities.ui.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by user on 23/11/2017.
 */

public abstract class GenericHolder<T> extends RecyclerView.ViewHolder {

    private static final String TAG = "GAdapterHolder";
    protected Context context;
    private int overrideCount = 0;
    private Listener listener;
    private AdapterCallback adapterCallback;


    public GenericHolder(View view) {
        super(view);
        this.context = view.getContext();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setAdapterCallback(AdapterCallback adapterCallback) {
        this.adapterCallback = adapterCallback;
    }

    protected AdapterCallback getAdapterCallback() {
        return adapterCallback;
    }

    public void setSelectedPosition(int selectedPosition) {
        if (listener != null) listener.onSelectedHolder(selectedPosition);
    }

    protected Context getContext() {
        return context;
    }

    protected void onBindViewHolder(List<T> o, int position) {
        overrideCount++;
        info();
    }

    protected void onBindViewHolder(T o) {
        overrideCount++;
        info();
    }

    protected void onBindViewHolder(T o, int position) {
        overrideCount++;
        info();
    }

    private void info() {
        if (overrideCount == 3) {
            Log.w(TAG, "override at least 1 onBindViewHolder");
        }
    }

    protected interface Listener {
        void onSelectedHolder(int index);
    }

    protected interface AdapterCallback {

    }


}