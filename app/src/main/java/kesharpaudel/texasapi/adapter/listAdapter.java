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
import kesharpaudel.texasapi.activitis.Datum;

public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder> {

    List<Datum> contactList;
    Context context;

    public listAdapter(List<Datum> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_preview,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bindView(contactList.get(position));
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView fullName,mobileNo, email, createdBy, createdDate, t10,t11,t12,t13,t14;
        String s1,s2,s3,s4,s5,s6;
        public ViewHolder(View itemView){
            super(itemView);
            fullName= itemView.findViewById(R.id.textView2);
            mobileNo=itemView.findViewById(R.id.textView3);
            email=itemView.findViewById(R.id.textView4);
            createdBy=itemView.findViewById(R.id.textView5);
            createdDate=itemView.findViewById(R.id.textView6);
            t10 = itemView.findViewById(R.id.textView10);
            t11= itemView.findViewById(R.id.textView11);
            t12 = itemView.findViewById(R.id.textView12);
            t13 = itemView.findViewById(R.id.textView13);
            t14 = itemView.findViewById(R.id.textView14);

        }
        public  void bindView(Datum contact){
            s1= contact.getFirstName();
            fullName.setText(s1);
            s2=contact.getPhoneNumber();
            mobileNo.setText(s2);
            s3=contact.getEmail();
            email.setText(s3);
            s4=contact.getCreatedByName();
            createdBy.setText(s4);
            s5=contact.getCreatedDate();
            createdDate.setText(s5);

        }

    }



}

