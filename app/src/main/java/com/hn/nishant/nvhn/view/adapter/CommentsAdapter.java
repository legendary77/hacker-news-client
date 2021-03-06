package com.hn.nishant.nvhn.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.hn.nishant.nvhn.R;
import com.hn.nishant.nvhn.model.Story;

import io.realm.OrderedCollectionChangeSet;
import io.realm.RealmResults;

/**
 * Created by nishant on 20.03.17.
 */

public class CommentsAdapter extends StoryAdapter {

    public CommentsAdapter(Context context, RealmResults<Story> stories) {
        super(context, stories);
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public StoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StoryHolder(getInflater().inflate(R.layout.comments_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(StoryHolder holder, int position) {
        holder.text.setText(getItemAtPosition(position).getText());
        holder.time.setText("by " + getItemAtPosition(position).getBy());
    }

    @Override
    public void onChange(RealmResults<Story> collection, OrderedCollectionChangeSet changeSet) {
        notifyDataSetChanged();
    }

}
