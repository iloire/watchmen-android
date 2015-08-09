package com.iloire.watchmen.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.iloire.watchmen.R;
import com.iloire.watchmen.adapters.ServiceReportOutagesListAdapter;
import com.iloire.watchmen.models.ServiceReport;
import com.iloire.watchmen.service.WatchmenService;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ServiceReportDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.loading);

        final Context c = this;
        String id = getIntent().getStringExtra("id");

        WatchmenService service = new WatchmenService();
        service.getService(id, new Callback<ServiceReport>() {
            @Override
            public void success(ServiceReport serviceReport, Response response) {
                setTitle(serviceReport.getService().getName());
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
                setTitle("Error");
                // TODO proper err handling
                System.err.println("=============================================");
                System.out.println("Error retrieving service report details (retrofit)");
                System.out.println(error);
                System.err.println("=============================================");
            }
        });
    }
}
