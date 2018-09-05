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
import kesharpaudel.texasapi.models.NotificationDatum;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    List<NotificationDatum> data;
    Context mContext;

    public NotificationAdapter(List<NotificationDatum> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.n_display,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bindView(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, notification;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameID);
            notification = itemView.findViewById(R.id.notificaID);
        }

        public void bindView(NotificationDatum datum) {
            name.setText(datum.getSendBy());
            notification.setText(datum.getMessage());
        }
    }

}
