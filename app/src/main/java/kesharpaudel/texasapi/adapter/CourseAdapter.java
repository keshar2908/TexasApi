package kesharpaudel.texasapi.adapter;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.activitis.CourseDetail;
import kesharpaudel.texasapi.models.Course;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    ArrayList<Course> courses;
    Context mContext;

    public CourseAdapter(ArrayList<Course> courses, Context mContext) {
        this.courses = courses;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_course,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(courses.get(position));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView courseName, affiliation;
        ConstraintLayout cLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.courseNameID);
            affiliation = itemView.findViewById(R.id.affiliationID);
            cLayout = itemView.findViewById(R.id.cLayoutID);
        }

        public void bindView(final Course course) {
            courseName.setText(course.getName());
            affiliation.setText(course.getAffilation());

            cLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, CourseDetail.class);
                    String name = course.getName();
                    String description = course.getDescription();
                    String affiliation = course.getAffilation();
                    Integer duration = course.getDuration();
                    String createdBy = course.getCreatedByName();
                    String createdDate = course.getCreatedDate();
                    intent.putExtra("Name",name);
                    intent.putExtra("Description",description);
                    intent.putExtra("Affiliation",affiliation);
                    intent.putExtra("Duration",duration);
                    intent.putExtra("CreatedBy",createdBy);
                    intent.putExtra("CreatedDate",createdDate);

                    mContext.startActivity(intent);
                }
            });
        }
    }

}
