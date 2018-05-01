package com.pushnik.chartercommunicationstest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by John Pushnik on 4/30/2018.
 */

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder> {

    private List<School> schoolList;
    private PopupCallback callback;

    public class SchoolViewHolder extends RecyclerView.ViewHolder {

        private TextView schoolName, dbn, phoneNumber;

        public SchoolViewHolder(View view) {
            super(view);

            schoolName = (TextView) view.findViewById(R.id.schoolName);
            dbn = (TextView) view.findViewById(R.id.dbn);
            phoneNumber = (TextView) view.findViewById(R.id.phoneNumber);
        }
    }

    public SchoolAdapter(List<School> schoolList, PopupCallback callback) {
        this.schoolList = schoolList;
        this.callback = callback;
    }

    @Override
    public SchoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_school, parent, false);
        return new SchoolViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SchoolViewHolder holder, int position) {
        School school = schoolList.get(position);

        holder.schoolName.setText(school.getSchoolName());
        holder.dbn.setText(school.getDbn());
        holder.phoneNumber.setText(school.getPhoneNumber());
        setOnClickListener(holder.itemView, school);
    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    private void setOnClickListener(View view, final School school) {
        view.setClickable(true);
        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        callback.showPopup(view, school);
                    }
                }
        );
    }

}
