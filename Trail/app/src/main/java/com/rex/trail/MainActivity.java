package com.rex.trail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static android.graphics.Color.*;
import static android.graphics.Typeface.*;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    private PieChart pieChart;

    private ArrayList<PieEntry> pieChartData = new ArrayList<>();
    private ArrayList<BarEntry> barChartDataHyundai = new ArrayList<>();
    private ArrayList<BarEntry> barChartDataAlibaba = new ArrayList<>();
    private ArrayList<BarEntry> barChartDataApple = new ArrayList<>();
    private ArrayList<BarEntry> barChartDataGoogle = new ArrayList<>();


    private String [] days = new String[]{
      "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Fridays","Saturdays"
    };


    private ArrayList<Integer> paint = new ArrayList<>();
    private ArrayList<String> LabelName = new ArrayList<>();
    private ArrayList<String> LabelPrice = new ArrayList<>();

    private BarChart barChart;

    private DecimalFormat format;


    private SpannableStringBuilder string;

    private LinearLayout linearLayout;

    private PieDataSet pieDataSet;
    private PieData pieData;
    private BarDataSet barDataSet1,barDataSet2,barDataSet3,barDataSet4;
    private BarData barData1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = findViewById(R.id.chart);
        linearLayout = findViewById(R.id.custom_layout);
        barChart = findViewById(R.id.barcharts);
        format = new DecimalFormat("#,###,###");



        /**
         * Calling every method;
         */



        DataEntries();
        colorEntries();
        DataSetPie();
        DataSetBar();

        String Currency = "$";
        String Amount = "5000";
        String OverAll = "OverAll";
        String FormattedAmount = format.format(Integer.parseInt(Amount));
        String FinalText = OverAll + "\n" + Currency + " " + FormattedAmount;

        CenterStringPieFormat(FinalText);

        PieChartUX();
        BarChartUX();

        findViewById(R.id.textView23).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Account.class));

            }
        });


    }


    private void DataSetPie() {

        pieDataSet = new PieDataSet(pieChartData, " ");
        pieDataSet.setColors(paint);
        pieDataSet.setValueTextSize(0f);
        pieData = new PieData(pieDataSet);
    }

    private void DataSetBar() {
        barDataSet1 = new BarDataSet(barChartDataHyundai, "");
        barDataSet1.setColor(Color.parseColor("#506DF5"));
        barDataSet1.setValueTextSize(16f);
        barDataSet1.setDrawValues(false);


        barDataSet2 = new BarDataSet(barChartDataAlibaba,"");
        barDataSet2.setColor(Color.parseColor("#F5508B"));
        barDataSet2.setValueTextSize(16f);
        barDataSet2.setDrawValues(false);


        barDataSet3 = new BarDataSet(barChartDataApple,"");
        barDataSet3.setColor(Color.parseColor("#57C0BA"));
        barDataSet3.setValueTextSize(16f);
        barDataSet3.setDrawValues(false);

        barDataSet4 = new BarDataSet(barChartDataGoogle,"");
        barDataSet4.setColor(Color.parseColor("#FFAB00"));
        barDataSet4.setValueTextSize(16f);
        barDataSet4.setDrawValues(false);


        barData1 = new BarData(barDataSet1,barDataSet2,barDataSet3,barDataSet4);




    }

    private void colorEntries() {

        paint.add(Color.parseColor("#506DF5"));
        paint.add(Color.parseColor("#F5508B"));
        paint.add(Color.parseColor("#57C0BA"));
        paint.add(Color.parseColor("#FFAB00"));
        paint.add(Color.parseColor("#BC5A2B"));
    }

    private void DataEntries() {

        pieChartData.add(new PieEntry(30, ""));
        pieChartData.add(new PieEntry(40, ""));
        pieChartData.add(new PieEntry(70, ""));
        pieChartData.add(new PieEntry(20, ""));

        barChartDataHyundai.add(new BarEntry(1, 1250));
        barChartDataHyundai.add(new BarEntry(2, 1500));
        barChartDataHyundai.add(new BarEntry(3, 58));
        barChartDataHyundai.add(new BarEntry(4, 7852));
        barChartDataHyundai.add(new BarEntry(5, 1237));
        barChartDataHyundai.add(new BarEntry(6, 1137));
        barChartDataHyundai.add(new BarEntry(7, 1237));

        barChartDataAlibaba.add(new BarEntry(1, 1000));
        barChartDataAlibaba.add(new BarEntry(2, 100));
        barChartDataAlibaba.add(new BarEntry(3, 580));
        barChartDataAlibaba.add(new BarEntry(4, 752));
        barChartDataAlibaba.add(new BarEntry(5, 123));
        barChartDataAlibaba.add(new BarEntry(6, 1203));
        barChartDataAlibaba.add(new BarEntry(7, 1230));

        barChartDataApple.add(new BarEntry(1, 100));
        barChartDataApple.add(new BarEntry(2, 1050));
        barChartDataApple.add(new BarEntry(3, 5080));
        barChartDataApple.add(new BarEntry(4, 52));
        barChartDataApple.add(new BarEntry(5, 1203));
        barChartDataApple.add(new BarEntry(6, 803));
        barChartDataApple.add(new BarEntry(7, 1703));

        barChartDataGoogle.add(new BarEntry(1, 1500));
        barChartDataGoogle.add(new BarEntry(2, 1050));
        barChartDataGoogle.add(new BarEntry(3, 580));
        barChartDataGoogle.add(new BarEntry(4, 520));
        barChartDataGoogle.add(new BarEntry(5, 1403));
        barChartDataGoogle.add(new BarEntry(6, 1103));
        barChartDataGoogle.add(new BarEntry(7, 1003));





        LabelName.add("Hyundai Motors Co");
        LabelName.add("Alibaba");
        LabelName.add("Apple");
        LabelName.add("Google");

        LabelPrice.add(format.format(Integer.parseInt("25341")));
        LabelPrice.add(format.format(Integer.parseInt("26388")));
        LabelPrice.add(format.format(Integer.parseInt("63398")));
        LabelPrice.add(format.format(Integer.parseInt("42369")));
    }

    private void CenterStringPieFormat(String finalText){
        string = new SpannableStringBuilder(finalText);
        string.setSpan(new ForegroundColorSpan(parseColor("#839CB0")), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new ForegroundColorSpan(parseColor("#0C1947")), 8, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new StyleSpan(BOLD), 8, 9, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        string.setSpan(new RelativeSizeSpan(1.5f), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new RelativeSizeSpan(2f), 8, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new RelativeSizeSpan(2f), 10, finalText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        string.setSpan(new ForegroundColorSpan(parseColor("#0C1947")), 10, finalText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new StyleSpan(BOLD), 10, finalText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
    }

    private void PieChartUX(){
        pieChart.setDrawEntryLabels(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText(string);
        pieChart.getLegend().setEnabled(false);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleRadius(90f);
        pieChart.animateXY(2000, 2000);
        pieChart.setData(pieData);

        for (int i = 0; i < pieChartData.size(); i++) {
            createView(paint.get(i), LabelName.get(i), LabelPrice.get(i));
        }

    }

    private void createView(int i, String s1, String s) {

        View customView = getLayoutInflater().inflate(R.layout.custom_legend_lable, null, false);
        TextView companyName = customView.findViewById(R.id.companyName);
        TextView companyPrice = customView.findViewById(R.id.LabelPrice);
        CardView legend = customView.findViewById(R.id.legend_color);

        legend.setCardBackgroundColor(i);

        companyName.setText(s1);
        companyPrice.setText("$ " + s);

        linearLayout.addView(customView);
    }

    private void BarChartUX(){

        barChart.setFitBars(true);
        barChart.setDrawBarShadow(false);
        barChart.setPinchZoom(false);
        barChart.getDescription().setEnabled(false);
        barChart.animateY(2000);
        barChart.getLegend().setEnabled(false);
        barChart.setData(barData1);
        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(3f);


        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.getAxisLeft().setDrawAxisLine(false);
        barChart.getAxisLeft().setXOffset(20f);

        barChart.getAxisLeft().setValueFormatter(new LargeValueFormatter());
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(days));
        barChart.getXAxis().setCenterAxisLabels(true);
        barChart.getXAxis().setGranularity(1f);
        barChart.getXAxis().setGranularityEnabled(true);
        barChart.getXAxis().setAxisMinimum(0f);
        barChart.getBarData().setBarWidth(0.16f);
        float barSpace = 0.05f;
        float groupSpace = 0.16f;
        barChart.getXAxis().setAxisMaximum(0+barChart.getData().getGroupWidth(groupSpace,barSpace)*7);
        barChart.groupBars(0,groupSpace,barSpace);
        barChart.invalidate();
    }




}


