package com.blackseal.mylibrary;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven on 21/04/2015.
 */
public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.AlbumViewHolder> {

    Context mContext;
    List<Album> mList;
    Boolean isLoaded;

    public MyAdapter(Context context, List<Album> list){
        this.mList = new ArrayList<Album>(list);
        this.mContext = context;

        isLoaded = false;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_withimage, parent, false);

        return new AlbumViewHolder(view);

    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {

        final Album album = mList.get(position);
        holder.textViewTitle.setText(album.getTitle());
        holder.textViewAuthor.setText(album.getAuthor());
        holder.imageview.setImageResource(album.getImageDrawableId());


        changeLayoutSize(holder);

        changeHolderColor(holder, position);


    }

    private void changeLayoutSize(AlbumViewHolder holder) {

        int orientation = mContext.getResources().getConfiguration().orientation;
        int spanCount = (orientation== mContext.getResources().getConfiguration().ORIENTATION_PORTRAIT)?2:3;

        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();

       float pxWidth = displayMetrics.widthPixels;

       int pxLayoutWidth = (int)(pxWidth-(spanCount-1)*2)/spanCount;
        holder.imageview.setLayoutParams(new LinearLayout.LayoutParams(pxLayoutWidth,pxLayoutWidth));
        holder.text_container.setLayoutParams(new LinearLayout.LayoutParams(pxLayoutWidth, LinearLayout.LayoutParams.WRAP_CONTENT));
    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void removeAt(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mList.size());
    }

    public void changeAllColor() {

        isLoaded = true;
        notifyDataSetChanged();


    }
    private void changeHolderColor(AlbumViewHolder holder, int position) {


        if (isLoaded) {

            int colorText = mContext.getResources().getColor(R.color.text1);
            int colorBackground = mContext.getResources().getColor(R.color.album1);

            switch (position % 4) {
                case 0: {
                    colorText = mContext.getResources().getColor(R.color.text1);
                    colorBackground = mContext.getResources().getColor(R.color.album1);
                }
                break;
                case 1:
                case 2: {
                    colorText = mContext.getResources().getColor(R.color.text2);
                    colorBackground = mContext.getResources().getColor(R.color.album2);
                }
                break;
                case 3: {
                    colorText = mContext.getResources().getColor(R.color.text4);
                    colorBackground = mContext.getResources().getColor(R.color.album4);
                }
                break;
            }

            Drawable icon_star = mContext.getResources().getDrawable(R.drawable.ic_star_white);

            icon_star.mutate().setColorFilter(colorText, PorterDuff.Mode.MULTIPLY);

            holder.textViewTitle.setTextColor(colorText);
            holder.textViewAuthor.setTextColor(colorText);
            holder.text_container.setBackgroundColor(colorBackground);
            holder.star.setImageDrawable(icon_star);

        }
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder  {
        public TextView textViewTitle;
        public TextView textViewAuthor;
        public ImageView imageview;
        public ImageView star;
        FrameLayout container;
        RelativeLayout text_container;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            container = (FrameLayout) itemView.findViewById(R.id.album_container);
            text_container = (RelativeLayout) itemView.findViewById(R.id.text_container);
            textViewTitle = (TextView) itemView.findViewById(R.id.textView);
            textViewAuthor = (TextView) itemView.findViewById(R.id.textView2);
            imageview = (ImageView) itemView.findViewById(R.id.image);
            star = (ImageView) itemView.findViewById(R.id.icon_star);


        }




    }
}
