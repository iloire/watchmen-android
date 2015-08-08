package com.iloire.watchmen;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iloire.watchmen.models.ServiceReport;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ServicesList extends AppCompatActivity {

    public static final String API_BASE_URL = "http://ec2-54-204-149-175.compute-1.amazonaws.com:3334";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("ServicesList.onCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.homescreen);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_BASE_URL)
                .build();

        final Context c = this;

        WatchmenService watchmenService = restAdapter.create(WatchmenService.class);
        watchmenService.getServices(new Callback<List<ServiceReport>>() {
            @Override
            public void success(List<ServiceReport> serviceReports, Response response) {
                String [] titles = new String[serviceReports.size()];
                for (int i = 0; i < serviceReports.size(); i++) {
                    titles[i] = serviceReports.get(i).getService().getName();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(c, R.layout.service_list_item, titles);
                ListView listView = (ListView) findViewById(R.id.listView);
                System.out.println(adapter);
                listView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("=============================================");
                System.out.println("retrofit error");
                System.out.println(error);
                System.out.println("=============================================");
            }
        });
    }

}
