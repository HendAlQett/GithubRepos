package com.hend.githubrepos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import adapters.CardAdapter;
import modules.Data;
import modules.Github;
import retrofit.GithubService;
import retrofit.ServiceFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        final CardAdapter cardAdapter = new CardAdapter();
        mRecyclerView.setAdapter(cardAdapter);

        Button bFetch = (Button) findViewById(R.id.button_fetch);
        Button bClear = (Button) findViewById(R.id.button_clear);


        if (bClear != null) {
            bClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(LOG_TAG, "Completed");
                    cardAdapter.clear();
                }
            });
        }

        if (bFetch != null) {

            bFetch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GithubService githubService = ServiceFactory.createRetrofitService(GithubService.class, GithubService.SERVICE_ENDPOINT);
                    for (String login : Data.githubList) {
                        githubService.getUser(login).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Github>() {
                            @Override
                            public void onCompleted() {
                                //Called when it is totally finished
                                Log.d(LOG_TAG, "Completed");
                            }

                            @Override
                            public void onError(Throwable e) {

                                Log.d(LOG_TAG, e.getMessage());
                            }

                            @Override
                            public void onNext(Github github) {
                                //Called every new item in the list
                                Log.d(LOG_TAG, "Next");
                                cardAdapter.addData(github);
                            }
                        });
                    }

                }
            });
        }
    }


}
