package com.example.realmdemo2;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private RealmResults<Person> mPersonRealmResults;
    private Context mContext;
    private static final String TAG = "Experiment";
    private int count;

    public MyAdapter(RealmResults<Person> persons, Context context){
        mPersonRealmResults = persons;
        mContext = context;
        count = 0;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        Log.i(TAG, "onCreateViewHolder: Triggered And Also the Parent Id is " + parent.getId());
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: Triggered");
        Person person = mPersonRealmResults.get(position);
        holder.name.setText(person.getName());
        holder.dept.setText(person.getDept());
        if(person.getDept().equalsIgnoreCase("cse"))
            holder.r.setBackgroundColor(Color.parseColor("#00ffff"));
        else if(person.getDept().equalsIgnoreCase("it"))
            holder.r.setBackgroundColor(Color.parseColor("#ff0000"));
        else if(person.getDept().equalsIgnoreCase("ece"))
            holder.r.setBackgroundColor(Color.parseColor("#00ff00"));
        else
            holder.r.setBackgroundColor(Color.parseColor("#0000ff"));
        holder.roll.setText(String.valueOf(person.getRoll()));
        holder.phone.setText(String.valueOf(person.getPhone()));
        holder.gender.setText(person.getGender());
    }

    @Override
    public int getItemCount() {
        return mPersonRealmResults.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView dept;
        private TextView roll;
        private TextView phone;
        private TextView gender;
         RelativeLayout r;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            count++;
            Log.i(TAG, "MyViewHolder: Number of Active ViewHolders:" + count);
            name = itemView.findViewById(R.id.name_tv);
            dept = itemView.findViewById(R.id.dept_tv);
            roll = itemView.findViewById(R.id.roll_tv);
            phone = itemView.findViewById(R.id.phone_tv);
            gender= itemView.findViewById(R.id.gender_tv);
            r=itemView.findViewById(R.id.category_image);
        }
    }
}
