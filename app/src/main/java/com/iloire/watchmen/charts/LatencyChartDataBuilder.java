package com.iloire.watchmen.charts;

import android.graphics.Color;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.iloire.watchmen.Utilities.Time;
import com.iloire.watchmen.models.LatencyRecord;

import java.util.ArrayList;
import java.util.List;

public class LatencyChartDataBuilder {

    /**
     * Builds latency chart data
     * @param latencyList
     * @param timeFormat
     * @return
     */
    public static LineData getData (List<LatencyRecord> latencyList, String timeFormat){
        int latencyListSize = latencyList.size();

        ArrayList<String> xVals = new ArrayList<>();
        ArrayList<Entry> yVals = new ArrayList<>();

        //TODO: deal with timezones
        int index = 0;
        for (int i = latencyListSize - 1; i >= 0; i--) {
            xVals.add(Time.humanizeEpoch(latencyList.get(i).getT(), timeFormat));
            yVals.add(new Entry((float)latencyList.get(i).getL(), index));
            index++;
        }

        LineDataSet set1 = new LineDataSet((List)yVals, "Latency last 24 hours");
        int chartMainColor = Color.rgb(20, 137, 44);
        set1.setColor(chartMainColor);
        set1.setCircleColor(chartMainColor);
        set1.setLineWidth(1.5f);
        set1.setCircleSize(2f);
        set1.setValueTextSize(0);
        set1.setFillAlpha(65);
        set1.setFillColor(chartMainColor);
        set1.setDrawFilled(true);

        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        return new LineData(xVals, dataSets);
    }
}
