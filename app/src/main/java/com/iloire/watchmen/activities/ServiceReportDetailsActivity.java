package com.iloire.watchmen.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.iloire.watchmen.R;
import com.iloire.watchmen.Utilities.Time;
import com.iloire.watchmen.adapters.ServiceReportOutagesListAdapter;
import com.iloire.watchmen.charts.LatencyChartDataBuilder;
import com.iloire.watchmen.models.Last24Hours;
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

                Last24Hours statusLast24Hours = serviceReport.getStatus().getLast24Hours();

                // uptime
                ((TextView) findViewById(R.id.textServiceDetailsUptime)).setText(String.valueOf(
                        statusLast24Hours.getUptime()) + "%");

                // latency
                ((TextView) findViewById(R.id.textServiceDetailsLatency)).setText(String.valueOf(
                        statusLast24Hours.getLatency().getMean()) + " ms.");;

                // downtime
                TextView tvServiceDowntime = (TextView) findViewById(R.id.textServiceDetailsDowntime);
                long downtime = statusLast24Hours.getDowntime();
                if (downtime > 0) {
                    String downtimeStr = Time.getHumanizedOutageDuration(downtime);
                    tvServiceDowntime.setText(downtimeStr);
                } else {
                    tvServiceDowntime.setText("0");
                }

                // outages list
                if (serviceReport.getStatus().getLatestOutages().size() > 0) {
                    ServiceReportOutagesListAdapter outagesAdapter = new ServiceReportOutagesListAdapter(c, serviceReport.getStatus().getLatestOutages());
                    ListView listView = (ListView) findViewById(R.id.listViewServiceDetailsErrors);
                    listView.setAdapter(outagesAdapter);
                } else {
                    findViewById(R.id.textViewLatestOutagesCaption).setVisibility(View.INVISIBLE);
                }

                // latency chart last 24 h.
                LineChart chart = (LineChart) findViewById(R.id.chartServiceDetailsLatencyLast24Hours);
                LatencyChartDataBuilder dataBuilder = new LatencyChartDataBuilder();
                chart.setData(dataBuilder.getData(serviceReport.getStatus().getLast24Hours().getLatency().getList(), "HH:mm"));
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
