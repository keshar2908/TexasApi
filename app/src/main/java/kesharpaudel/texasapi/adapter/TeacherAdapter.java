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
import kesharpaudel.texasapi.models.TeacherDatum;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder>{

    List<TeacherDatum> datas;
    Context context;

    public TeacherAdapter(List<TeacherDatum> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_teacher_detail,parent,false);
         ViewHolder holder = new ViewHolder(view);
         return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.bindView(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nname,nphone,nemails,ncreatedby,ncreateddate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nname = itemView.findViewById(R.id.fullname);
            nphone = itemView.findViewById(R.id.phone);
            nemails = itemView.findViewById(R.id.emails);
            ncreatedby = itemView.findViewById(R.id.createdby);
            ncreateddate = itemView.findViewById(R.id.createddate);
        }

        public void bindView(TeacherDatum datum) {
            nname.setText(datum.getFirstName()+" "+datum.getMiddleName()+" "+datum.getLastName());
           nphone.setText(datum.getPhoneNumber().toString());
            nemails.setText(datum.getEmail());
            ncreatedby.setText(datum.getCreatedBy().toString());
            ncreateddate.setText(datum.getCreatedDate().toString());
        }
    }
}
