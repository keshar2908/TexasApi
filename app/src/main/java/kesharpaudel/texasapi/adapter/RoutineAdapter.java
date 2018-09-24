package kesharpaudel.texasapi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.models.Routine;
import kesharpaudel.texasapi.models.SemesterRoutineResponse;

public class RoutineAdapter extends RecyclerView.Adapter<RoutineAdapter.ViewHolder> {

    List<Routine> routineList;
    Context mContext;

    public RoutineAdapter(List<Routine> routineList, Context mContext) {
        this.routineList = routineList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_routine,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bindView(routineList.get(position));

    }

    @Override
    public int getItemCount() {
        return routineList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView time, sunday;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.timeID);
            sunday = itemView.findViewById(R.id.sundayID);

        }

        public void bindView(Routine routine) {
            time.setText(routine.getStartTime().toString()+" "+routine.getEndTime().toString());
            sunday.setText(routine.getSunday());
        }
    }


}
