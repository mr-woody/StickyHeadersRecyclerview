package com.okay.sticky;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

interface ViewRetriever {

    RecyclerView.ViewHolder getViewHolderForPosition(int headerPositionToShow);

    final class RecyclerViewRetriever implements ViewRetriever {

        private final RecyclerView recyclerView;

        private RecyclerView.ViewHolder currentViewHolder;
        private int currentViewType;

        RecyclerViewRetriever(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
            this.currentViewType = -1;
        }

        @Override
        public RecyclerView.ViewHolder getViewHolderForPosition(int position) {
            int itemViewType = recyclerView.getAdapter().getItemViewType(position);
            if (currentViewType != itemViewType) {
                currentViewType = itemViewType;
                currentViewHolder = recyclerView.getAdapter().createViewHolder(
                        (ViewGroup) recyclerView.getParent(), currentViewType);
            }
            return currentViewHolder;
        }
    }
}
