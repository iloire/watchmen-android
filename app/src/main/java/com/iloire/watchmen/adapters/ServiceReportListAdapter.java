package com.iloire.watchmen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.iloire.watchmen.R;
import com.iloire.watchmen.models.ServiceReport;

import java.util.List;

public class ServiceReportListAdapter extends ArrayAdapter<ServiceReport> {

    public ServiceReportListAdapter(Context context, List<ServiceReport> serviceReports) {
        super(context, 0, serviceReports);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ServiceReport serviceReport = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.service_list_item, parent, false);
        }

        TextView tvServiceName = (TextView) convertView.findViewById(R.id.serviceItemTextView);
        tvServiceName.setText(serviceReport.getService().getName());

        TextView tvUptime = (TextView) convertView.findViewById(R.id.serviceUptimeTextView);
        tvUptime.setText(String.valueOf(serviceReport.getStatus().getLast24Hours().getUptime()));

        return convertView;
    }
}