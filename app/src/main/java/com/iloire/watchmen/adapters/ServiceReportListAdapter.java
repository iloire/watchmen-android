package com.iloire.watchmen.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iloire.watchmen.R;
import com.iloire.watchmen.Utilities.Time;
import com.iloire.watchmen.models.ServiceReport;
import com.iloire.watchmen.models.Status;

import java.util.List;

public class ServiceReportListAdapter extends ArrayAdapter<ServiceReport> {

    // TODO: extract colors to resources
    private final int errorColor = Color.rgb(208, 68, 55); // AUI
    private final int okColor = Color.rgb(20, 137, 44); // AUI

    public ServiceReportListAdapter(Context context, List<ServiceReport> serviceReports) {
        super(context, 0, serviceReports);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ServiceReport serviceReport = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.service_list_item, parent, false);
        }

        // status icon (up/down)
        setIcon(serviceReport.getStatus(), (ImageView) convertView.findViewById(R.id.serviceStatusImageView));

        // uptime
        TextView tvUptime = (TextView) convertView.findViewById(R.id.serviceUptimeTextView);
        tvUptime.setText(String.valueOf(serviceReport.getStatus().getLast24Hours().getUptime()) + "%");

        // name
        TextView tvServiceName = (TextView) convertView.findViewById(R.id.serviceItemTextView);
        tvServiceName.setText(serviceReport.getService().getName());

        // downtime
        TextView tvServiceDowntime = (TextView) convertView.findViewById(R.id.serviceDowntimeTextView);
        long downtime = serviceReport.getStatus().getLast24Hours().getDowntime();
        if (downtime > 0) {
            tvServiceDowntime.setText(Time.getHumanizedOutageDuration(downtime) + " down");
        } else {
            tvServiceDowntime.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    private void setIcon (Status status, ImageView imageView){
        if (status.getCurrentOutage() != null) {
            imageView.setImageResource(R.drawable.ic_error_outline_white);
            imageView.setBackgroundColor(errorColor);
        }
        else {
            imageView.setImageResource(R.drawable.ic_check_circle_white);
            imageView.setBackgroundColor(okColor);
        }
    }
}