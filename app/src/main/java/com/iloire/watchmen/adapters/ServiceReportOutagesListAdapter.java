package com.iloire.watchmen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.iloire.watchmen.R;
import com.iloire.watchmen.Utilities.Time;
import com.iloire.watchmen.models.Outage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ServiceReportOutagesListAdapter extends ArrayAdapter<Outage> {

    public ServiceReportOutagesListAdapter(Context context, List<Outage> serviceReports) {
        super(context, 0, serviceReports);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Outage outage = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.service_outage_list_item, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.textViewOutageTimestamp)).setText(
                Time.humanizeEpoch(outage.getTimestamp(), "dd MMM HH:mm:ss"));

        ((TextView) convertView.findViewById(R.id.textViewOutageError)).setText(
                humanizeError(outage.getError()));

        ((TextView) convertView.findViewById(R.id.textViewOutageDowntime)).setText(
                Time.getHumanizedOutageDuration(outage.getDowntime()));

        return convertView;
    }

    private String humanizeError (com.iloire.watchmen.models.Error err) {
        String errOutput = "";
        if (err.getErrno() != null) {
            errOutput += err.getErrno().toString();
        }
        if (err.getCode() != null) {
            errOutput += err.getCode().toString();
        }
        return errOutput;
    }
}