package com.blackseal.mylibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.GridLayoutAnimationController;

/**
 * Created by Steven on 20/04/2015.
 */
public class MyRecyclerView extends RecyclerView {

    public MyRecyclerView(Context context) {
        super(context);
    }
//
//    @Override
//    protected void attachLayoutAnimationParameters(View child,
//                                                   ViewGroup.LayoutParams params, int index, int count) {
//
//        GridLayoutAnimationController.AnimationParameters animationParams =
//                (GridLayoutAnimationController.AnimationParameters) params.layoutAnimationParameters;
//
//        if (animationParams == null) {
//            animationParams = new GridLayoutAnimationController.AnimationParameters();
//            params.layoutAnimationParameters = animationParams;
//        }
//
//        animationParams.count = count;
//        animationParams.index = index;
//        animationParams.columnsCount = mNumColumns;
//        animationParams.rowsCount = count / mNumColumns;
//
//        if (!mStackFromBottom) {
//            animationParams.column = index % mNumColumns;
//            animationParams.row = index / mNumColumns;
//        } else {
//            final int invertedIndex = count - 1 - index;
//
//            animationParams.column = mNumColumns - 1 - (invertedIndex % mNumColumns);
//            animationParams.row = animationParams.rowsCount - 1 - invertedIndex / mNumColumns;
//        }
//    }
}
