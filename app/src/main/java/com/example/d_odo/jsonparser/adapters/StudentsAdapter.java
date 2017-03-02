package com.example.d_odo.jsonparser.adapters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.d_odo.jsonparser.R;
import com.example.d_odo.jsonparser.models.Student;
import com.example.d_odo.jsonparser.services.ImageDownloaderTask;

import java.util.ArrayList;

/**
 * Created by d-odo on 27/02/2017.
 */

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> {

    private ArrayList<Student> dataSet = new ArrayList<>();


    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent,false);
        StudentViewHolder holder = new StudentViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {

        Student currentStudent = dataSet.get(position);
        holder.studentNameTV.setText(currentStudent.getName());
        holder.studentEmail.setText(currentStudent.getEmail());
        new ImageDownloaderTask(holder.studentImage).execute(currentStudent.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void setDataSet(ArrayList<Student> students) {
        dataSet = students;
        notifyDataSetChanged();

    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView studentNameTV;
        public TextView studentEmail;
        public ImageButton studentGithub;
        public ImageView studentImage;

        public StudentViewHolder(final View v) {
            super(v);
            studentNameTV = (TextView) v.findViewById(R.id.student_name);
            studentEmail = (TextView) v.findViewById(R.id.student_email);
            studentGithub = (ImageButton) v.findViewById(R.id.student_github);
            studentImage = (ImageView) v.findViewById(R.id.student_image);

            studentGithub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(dataSet.get(getAdapterPosition()).getGithub()));
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }

}
