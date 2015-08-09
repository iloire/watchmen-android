package com.iloire.watchmen;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.iloire.watchmen.adapters.ServiceReportListAdapter;
import com.iloire.watchmen.adapters.ServiceReportOutagesListAdapter;
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

        final WatchmenService watchmenService = restAdapter.create(WatchmenService.class);
        watchmenService.getServices(new Callback<List<ServiceReport>>() {
            @Override
            public void success(final List<ServiceReport> serviceReports, Response response) {
                ServiceReportListAdapter adapter = new ServiceReportListAdapter(c, serviceReports);
                ListView listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        watchmenService.getService(serviceReports.get(position).getService().getId(),
                                new Callback<ServiceReport>() {

                                    @Override
                                    public void success(ServiceReport serviceReport, Response response) {
                                        setContentView(R.layout.service_detail);

                                        TextView tvServiceDetailsUptime = (TextView) findViewById(R.id.textServiceDetailsUptime);
                                        tvServiceDetailsUptime.setText(String.valueOf(serviceReport.getStatus().getLast24Hours().getUptime()));

                                        TextView tvServiceDetailsLatency = (TextView) findViewById(R.id.textServiceDetailsLatency);
                                        tvServiceDetailsLatency.setText(String.valueOf(serviceReport.getStatus().getLast24Hours().getLatency().getMean()));

                                        // outages list
                                        ServiceReportOutagesListAdapter outagesAdapter = new ServiceReportOutagesListAdapter(c, serviceReport.getStatus().getLatestOutages());
                                        ListView listView = (ListView) findViewById(R.id.listViewServiceDetailsErrors);
                                        listView.setAdapter(outagesAdapter);
                                    }

                                    @Override
                                    public void failure(RetrofitError error) {
                                        // TODO better err handling
                                        System.err.println("=============================================");
                                        System.out.println("Error retrieving service report details (retrofit)");
                                        System.out.println(error);
                                        System.err.println("=============================================");
                                    }
                                });
                    }
                });
            }

            @Override
            public void failure(RetrofitError error) {
                // TODO better err handling
                System.err.println("=============================================");
                System.err.println("retrofit error");
                System.err.println(error);
                System.err.println("=============================================");
            }
        });
    }

}
