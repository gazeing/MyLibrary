package com.blackseal.mylibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;

/**
 * Created by Steven on 20/04/2015.
 */
public class ListviewFragment extends Fragment {

    MyRecyclerView recyclerView;

    public ListviewFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list, container,
                false);

        recyclerView = (MyRecyclerView) (rootView.findViewById(
                R.id.recycler_view));
        recyclerView.addItemDecoration(new MarginDecoration(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//     /   recyclerView.setLayoutAnimation(new LayoutAnimationController(getActivity(),new Animation,));
//        recyclerView.setItemAnimator(new SlideInOutBottomItemAnimator(recyclerView));
        recyclerView.setAdapter(new NumberedAdapter(30,getActivity()));


        return rootView;

    }

    public void refresh(){
        recyclerView.setAdapter(new NumberedAdapter(30,getActivity()));
        recyclerView.invalidate();
    }
}
