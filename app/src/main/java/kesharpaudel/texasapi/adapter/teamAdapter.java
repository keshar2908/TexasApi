package kesharpaudel.texasapi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.models.Content;
import kesharpaudel.texasapi.models.Datum;
import kesharpaudel.texasapi.models.teamDto;

public class teamAdapter extends RecyclerView.Adapter<teamAdapter.ViewHolder> {

    List<Content> contactList;
    Context context;

    public teamAdapter(List<Content> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;

    }


    @NonNull
    @Override
    public teamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.teamlayout,parent,false);
        return new teamAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull teamAdapter.ViewHolder holder, int position) {

        holder.bindView(contactList.get(position));
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView id,createdByname, name, description, type,createdDate,createdBy  ,status;
        String s1,s2,s3,s4,s5,s6,s7,s8;
        public ViewHolder(View itemView){

            super(itemView);

            id= itemView.findViewById(R.id.textView);
            createdByname=itemView.findViewById(R.id.textView15);
            name=itemView.findViewById(R.id.textView16);
            description=itemView.findViewById(R.id.textView17);
            type = itemView.findViewById(R.id.textView18);
            createdDate= itemView.findViewById(R.id.textView19);
            createdBy = itemView.findViewById(R.id.textView20);
            status = itemView.findViewById(R.id.textView21);


        }
        public  void bindView(Content contact){
            s1 =contact.getId().toString();
            id.setText(s1);
            s3=contact.getCreatedByName();
            createdByname.setText(s3);
            s4=contact.getName();
            name.setText(s4);
            s5=contact.getDescription();
            description.setText(s5);
            s6=contact.getType();
            type.setText(s6);
            s7=contact.getCreatedDate();
            createdDate.setText(s7);
            s8=contact.getCreatedBy().toString();
            createdBy.setText(s8);
            s2 = contact.getStatus();
            status.setText(s2);

        }

    }
}
