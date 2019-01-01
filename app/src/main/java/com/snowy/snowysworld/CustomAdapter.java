package com.snowy.snowysworld;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
    int[] images;
    String[] types;
    Context mContext;

    public CustomAdapter(@NonNull Context context, int[] images, String[] types) {
        super(context, R.layout.custom_spinner_row);
        this.images = images;
        this.types = types;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_spinner_row, parent, false);
            mViewHolder.mMarker = (ImageView) convertView.findViewById(R.id.ivImage);
            mViewHolder.mType = (TextView) convertView.findViewById(R.id.ivType);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mMarker.setImageResource(images[position]);
        mViewHolder.mType.setText(types[position]);

        return convertView;    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    private static class ViewHolder {
        ImageView mMarker;
        TextView mType;
    }
}
