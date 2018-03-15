package com.example.tarasvolianskyi.retrofitapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.StrictMath.log;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    MyBaseAdapter myBaseAdapter;
    private ArrayAdapter<String> listAdapter;
    private List<Message> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {

        listView = (ListView) findViewById(R.id.lvListMainActivity);
        arrayList = new ArrayList<>();
/*
        for (long i = 0; i < 17; i++) {
            Message newMessage = new Message();
            newMessage.setId(i);
            newMessage.setTime(i * 2);
            newMessage.setText("Prise - " + i * 70);
            newMessage.setImage("Previous price - " + i * 90);
            arrayList.add(newMessage);
        }*/
        retrofit();
        myBaseAdapter = new MyBaseAdapter(arrayList, this);
        listView.setAdapter(myBaseAdapter);


    }

    private void retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rawgit.com/startandroid/data/master/messages/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MessagesApi messagesApi = retrofit.create(MessagesApi.class);

        final Call<List<Message>> messages = messagesApi.messages();

        messages.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (response.isSuccessful()) {
                    int size = response.body().size();
                    arrayList.addAll(response.body());
                    arrayList.size();
                    myBaseAdapter.notifyDataSetChanged();
                } else {
                    int code = response.code();
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Throwable error = t;
            }
        });
    }


}
