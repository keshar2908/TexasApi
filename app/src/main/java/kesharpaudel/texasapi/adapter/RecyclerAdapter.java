package kesharpaudel.texasapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.activitis.SingleUserDetail;
import kesharpaudel.texasapi.activitis.UserDetail;
import kesharpaudel.texasapi.models.Data;
import kesharpaudel.texasapi.models.ListDto;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    List<Data> data;
    Context context;


    public RecyclerAdapter(List<Data> data, Context context) {
        this.data = data;
        this.context = context;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_display, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, context);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.bindView(data.get(position));
        //String profilepicture=data.getProfilepicture();
        //Glide.with(context).asBitmap().load(profilepicture).into(holder.ProfilePicture);

        /*holder.Username.setText(data.get(position).getUsername());
        holder.Firstname.setText(data.get(position).getFirstName());
        holder.Lastname.setText(data.get(position).getLastName());
        holder.Email.setText(data.get(position).getEmail());*/

        if (data.get(position).getProfilepicture().length() > 0) {
            /*Glide.with(context).load(data.get(position).getProfilepicture())
                    .into(holder.ProfilePicture);*/
            Picasso.get().load((data.get(position).getProfilepicture())).placeholder(R.drawable.pic).into(holder.ProfilePicture);
        } else {
            holder.ProfilePicture.setImageResource(R.drawable.pic);
            //Glide.with(context).load(R.drawable.pic).into(holder.ProfilePicture);
        }



    }

    @Override
    public int getItemCount() {


        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView ProfilePicture;
        TextView Username, Firstname, Lastname, Email;
        Context context;




        public MyViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            ProfilePicture = itemView.findViewById(R.id.profilepicture);
            Firstname = itemView.findViewById(R.id.fn);
            Lastname = itemView.findViewById(R.id.ln);
            Username = itemView.findViewById(R.id.username);
            //Email = itemView.findViewById(R.id.email);

            this.context = context;


        }

        public void bindView(Data data) {


            String firstname, lastname, username, email;


            firstname = data.getFirstName();
            lastname = data.getLastName();
            username = data.getUsername();
            //email = data.getEmail();


            Firstname.setText(firstname);
            Lastname.setText(lastname);
            Username.setText(username);
            //Email.setText(email);


        }


    }
}
