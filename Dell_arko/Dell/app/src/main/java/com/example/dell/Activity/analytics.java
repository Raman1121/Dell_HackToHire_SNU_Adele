package com.example.dell.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.dell.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Map;

public class analytics extends AppCompatActivity {

    private BarChart barchart;
    private PieChart pieChart;
    private BubbleChart bubbleChart;
    private RadarChart radarChart;
    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        //Setting up the charts
        barchart = findViewById(R.id.bar_chart);
        pieChart = findViewById(R.id.pie_chart);
        lineChart = findViewById(R.id.line_chart);

        //Setting up the BAR CHART
        barchart.setDrawBarShadow(false);
        barchart.setDrawValueAboveBar(true);
        barchart.setMaxVisibleValueCount(50);
        barchart.setDrawGridBackground(true);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 10f));
        barEntries.add(new BarEntry(2, 12.5f));
        barEntries.add(new BarEntry(3, 14f));
        barEntries.add(new BarEntry(4, 11.8f));
        barEntries.add(new BarEntry(5, 16.7f));
        barEntries.add(new BarEntry(6, 12f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.9f);

        barchart.setData(data);

        //Setting up the PIE CHART
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(true);
        pieChart.setExtraOffsets(5,10,10,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(4f, "IT"));
        pieEntries.add(new PieEntry(6f, "Big Data"));
        pieEntries.add(new PieEntry(4.6f, "Cloud Services"));
        pieEntries.add(new PieEntry(5f, "Hardware"));
        pieEntries.add(new PieEntry(74f, "Networking"));
        pieEntries.add(new PieEntry(10f, "Analytics"));

        PieDataSet dataSet = new PieDataSet(pieEntries, "Revenue by Services");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData pieData = new PieData(dataSet);
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.YELLOW);

        pieChart.setData(pieData);

        //Setting up the LINE CHART
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);

        ArrayList<Entry> yValues = new ArrayList<>();
        yValues.add(new Entry(0,60f));
        yValues.add(new Entry(1,45f));
        yValues.add(new Entry(2,56f));
        yValues.add(new Entry(3,34f));
        yValues.add(new Entry(4,58f));
        yValues.add(new Entry(5,76f));
        yValues.add(new Entry(6,67f));

        LineDataSet set1 = new LineDataSet(yValues, "");

        set1.setFillAlpha(110);
        set1.setColor(Color.RED);
        set1.setLineWidth(3f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data1 = new LineData(dataSets);
        lineChart.setData(data1);

    }
}


