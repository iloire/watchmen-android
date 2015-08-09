package com.iloire.watchmen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.iloire.watchmen.R;
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

        TextView tvOutageTimestamp = (TextView) convertView.findViewById(R.id.textViewOutageTimestamp);
        tvOutageTimestamp.setText(humanizeEpoch(outage.getTimestamp()));

        TextView tvOutageError = (TextView) convertView.findViewById(R.id.textViewOutageError);
        tvOutageError.setText(humanizeError(outage.getError()));

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

    private String humanizeEpoch(long unixTimeInMs){
        Date dateTime = new java.util.Date((long) unixTimeInMs);
        SimpleDateFormat df = new SimpleDateFormat("dd MMM HH:mm:ss");
        return df.format(dateTime);
    }
}