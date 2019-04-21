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

import com.edsusantoo.bismillah.moviestmkg.model.PopularResponse;
import com.edsusantoo.bismillah.moviestmkg.model.ResultsItem;
import com.edsusantoo.bismillah.moviestmkg.network.RetrofitConfig;
import com.kennyc.view.MultiStateView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {

    RecyclerView rvPopularMovie;
    List<ResultsItem> listData = new ArrayList<>();
    MultiStateView multiStateView;


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
        multiStateView = view.findViewById(R.id.multiStateView);
        rvPopularMovie = view.findViewById(R.id.rv_popular_movie);
        //rvPopularMovie.setAdapter(new MovieAdapter(getActivity(), listData));
        rvPopularMovie.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        getPopularMovies();
    }

    private void getPopularMovies() {
        multiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
        Call<PopularResponse> popularmovie = RetrofitConfig.getApiServices().getPopularMovie();
        popularmovie.enqueue(new Callback<PopularResponse>() {
            @Override
            public void onResponse(Call<PopularResponse> call, Response<PopularResponse> response) {
                if (response.isSuccessful()) {
                    List<ResultsItem> resultsPopular = response.body().getResults();
                    if (resultsPopular != null && resultsPopular.size() != 0) {
                        multiStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
                        listData = response.body().getResults();
                        rvPopularMovie.setAdapter(new MovieAdapter(getActivity(), listData));
                    } else {
                        multiStateView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
                    }

                }
            }

            @Override
            public void onFailure(Call<PopularResponse> call, Throwable t) {
                multiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
            }
        });
    }
}
