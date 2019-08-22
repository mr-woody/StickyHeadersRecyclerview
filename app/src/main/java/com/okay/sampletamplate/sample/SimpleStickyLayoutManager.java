package com.okay.sampletamplate.sample;

import android.content.Context;
import com.okay.sticky.StickyLayoutManager;
import com.okay.sticky.callback.StickyCallback;

public final class SimpleStickyLayoutManager extends StickyLayoutManager {

    public SimpleStickyLayoutManager(Context context, StickyCallback stickyCallback) {
        super(context, stickyCallback);
    }

    @Override
    public void scrollToPosition(int position) {
        super.scrollToPositionWithOffset(position, 0);
    }
}
