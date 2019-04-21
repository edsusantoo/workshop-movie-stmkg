package com.edsusantoo.bismillah.moviestmkg;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edsusantoo.bismillah.moviestmkg.model.ResultsItem;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {

    RecyclerView rvPopularMovie;
    List<ResultsItem> listData = new ArrayList<>();


    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPopularMovie = view.findViewById(R.id.rv_popular_movie);
        rvPopularMovie.setAdapter(new MovieAdapter(getActivity(), listData));
        rvPopularMovie.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }
}
