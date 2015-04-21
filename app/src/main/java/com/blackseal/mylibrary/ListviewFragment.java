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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven on 20/04/2015.
 */
public class ListviewFragment extends Fragment {

    MyRecyclerView recyclerView;
    MyAdapter adapter;

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


        List<Album> list = new ArrayList<Album>();
        list.add(new Album(R.drawable.album_1,"In a Perfect World","Kodaline"));
        list.add(new Album(R.drawable.album_2,"More Than Just A Dream","Fitz & The Tantrums"));
        list.add(new Album(R.drawable.album_3,"Jamie Lidell","Jamie Lidell"));
        list.add(new Album(R.drawable.album_4,"Nocturnal","Yuna"));
        list.add(new Album(R.drawable.album_5,"BLACK SANDS","BONOBO"));
        list.add(new Album(R.drawable.album_6,"GIRL","WHATEVER"));


        adapter = new MyAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    public void refresh(){
        recyclerView.removeAllViews();


        recyclerView.invalidate();

        recyclerView.setAdapter(adapter);


    }
}
