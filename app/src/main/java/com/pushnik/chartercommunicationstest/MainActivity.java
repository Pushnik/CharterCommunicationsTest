package com.pushnik.chartercommunicationstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
Create a simple list of School apps with Ratings:

Show the list of schools in  a list using the below API
https://data.cityofnewyork.us/resource/97mf-9njv.json

On Selecting a school, Open a new view to display the School ratings using the below API
https://data.cityofnewyork.us/resource/734v-jeq5.json?dbn=“<dbn for the selected school>”
We would like to evaluate the following on a high level out of this coding test.

Code Quality
Readability
Separation of concerns
Design patterns
Feel free to use any third party libraries when required.
* */

public class MainActivity extends AppCompatActivity implements PopupCallback {

    public static final String TAG = "MainActivity";
    public static final String SCHOOL_URL = "https://data.cityofnewyork.us/resource/97mf-9njv.json";
    public static final String RATING_URL = "https://data.cityofnewyork.us/resource/734v-jeq5.json?dbn=";

    private RecyclerView recyclerView;
    private SchoolAdapter schoolAdapter;
    private List<School> schoolList = new ArrayList();
    private OkHttpClient okHttpClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        schoolAdapter = new SchoolAdapter(schoolList, this);

        recyclerView.setAdapter(schoolAdapter);

        okHttpClient = new OkHttpClient();
        loadSchoolJSON();
    }

    public void loadSchoolJSON() {
        Request request = new Request.Builder()
                .url(SCHOOL_URL)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();
                try {
                    readLongStream(inputStream);
                } catch (IOException ex) {
                    Log.e(TAG, ex.getLocalizedMessage());
                }
                notifyDataSetChanged();

            }
        });
    }

    public void notifyDataSetChanged() {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                schoolAdapter.notifyDataSetChanged();
            }
        });
    }


    public void readLongStream(InputStream inputStream) throws IOException {
        Gson gson = new GsonBuilder().create();
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        reader.beginArray();
        int count = 0;
        while (reader.hasNext()) {
            School school = gson.fromJson(reader, School.class);
            schoolList.add(school);
            Log.d(TAG, "school with dbn " + school.getDbn() + " added.");
            if (count % 10 == 9) {
                notifyDataSetChanged();
            }
            count++;
        }
        reader.close();
    }

    public Rating[] readRatingStream(InputStream inputStream) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        Rating[] ratings = new Gson().fromJson(reader, Rating[].class);
        return ratings;
    }


    @Override
    public void showPopup(final View view, School school) {
        Request request = new Request.Builder()
                .url(RATING_URL + school.getDbn())
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();
                final Rating[] ratings;
                try {
                    ratings = readRatingStream(inputStream);
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showRatingPopup(view, ratings);
                        }
                    });
                } catch (IOException ex) {
                    Log.e(TAG, ex.getMessage());
                }

            }
        });
    }


    public void showRatingPopup(final View view, Rating[] ratings) {
        final PopupWindow popupWindow;
        final View inflatedView;
        LayoutInflater inflater = getLayoutInflater();
        if (ratings.length == 0) {
            inflatedView = inflater.inflate(R.layout.cell_rating_not_found, null);
        } else {
            inflatedView = inflater.inflate(R.layout.cell_rating, null);

            Rating rating = ratings[0];

            TextView dbn = (TextView) inflatedView.findViewById(R.id.dbn);
            TextView schoolName = (TextView) inflatedView.findViewById(R.id.schoolName);
            TextView sat = (TextView) inflatedView.findViewById(R.id.satTakers);
            TextView reading = (TextView) inflatedView.findViewById(R.id.readingScore);
            TextView math = (TextView) inflatedView.findViewById(R.id.mathScore);
            TextView writing = (TextView) inflatedView.findViewById(R.id.writingScore);

            dbn.setText(rating.getDbn());
            schoolName.setText(rating.getSchoolName());
            sat.setText(rating.getNumOfSatTestTakers());
            reading.setText(rating.getSatCriticalReadingAvgScore());
            math.setText(rating.getSatMathAvgScore());
            writing.setText(rating.getSatWritingAvgScore());
        }

        popupWindow = new PopupWindow(
                inflatedView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        View close = inflatedView.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

    }
}
