package sg.edu.rp.c346.portfolio3;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<Activity> activities;


    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Activity> activities) {
        super(context, resource, activities);
        this.context = context;
        this.resource = resource;
        this.activities = activities;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @Nullable ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,null, false);

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvSub = view.findViewById(R.id.tvSub);
        ImageView ivActivity = view.findViewById(R.id.imageView5);
        ImageView ivNext = view.findViewById(R.id.imageView6);

        Activity activity = activities.get(position);
        tvTitle.setText(activity.getType());
        tvSub.setText(activity.getDate());

        if(activity.getType() == "Running"){
            ivActivity.setImageResource(R.drawable.running_white);
        }else {
            ivActivity.setImageResource(R.drawable.swimming_blue);
        }

        int checkEven = position + 1;
        boolean even = false;

        if(checkEven % 2 == 0){
            even = true;
        }else{
            even = false;
        }

        if(activity.getType()=="Running" && even == false){
            ivActivity.setImageResource(R.drawable.running_white);
            ivNext.setImageResource(R.drawable.arrow_white);
            tvTitle.setTextColor(Color.parseColor("#ffffff"));
            tvSub.setTextColor(Color.parseColor("#ffffff"));
        }else if(activity.getType()== "Running" && even == true){
            ivActivity.setImageResource(R.drawable.running_blue);
            ivNext.setImageResource(R.drawable.arrow_blue);
            tvTitle.setTextColor(Color.parseColor("#2eb2ff"));
            tvSub.setTextColor(Color.parseColor("#2eb2ff"));
            ivActivity.setBackgroundColor(Color.parseColor("#ffffff"));
            ivNext.setBackgroundColor(Color.parseColor("#ffffff"));
            tvSub.setBackgroundColor(Color.parseColor("#ffffff"));
            tvTitle.setBackgroundColor(Color.parseColor("#ffffff"));
        }else if(activity.getType() == "Swimming" && even == false){
            ivActivity.setImageResource(R.drawable.swimming_white);
            ivNext.setImageResource(R.drawable.arrow_white);
            tvTitle.setTextColor(Color.parseColor("#ffffff"));
            tvSub.setTextColor(Color.parseColor("#ffffff"));
        }else if(activity.getType()== "Swimming" && even == true) {
            ivActivity.setImageResource(R.drawable.swimming_blue);
            ivNext.setImageResource(R.drawable.arrow_blue);
            tvTitle.setTextColor(Color.parseColor("#2eb2ff"));
            tvSub.setTextColor(Color.parseColor("#2eb2ff"));
            ivActivity.setBackgroundColor(Color.parseColor("#ffffff"));
            ivNext.setBackgroundColor(Color.parseColor("#ffffff"));
            tvSub.setBackgroundColor(Color.parseColor("#ffffff"));
            tvTitle.setBackgroundColor(Color.parseColor("#ffffff"));
        }else if(activity.getType() == "Walking" && even == false){
            ivActivity.setImageResource(R.drawable.walking_white);
            ivNext.setImageResource(R.drawable.arrow_white);
            tvTitle.setTextColor(Color.parseColor("#ffffff"));
            tvSub.setTextColor(Color.parseColor("#ffffff"));
        }else if(activity.getType()== "Walking" && even == true) {
            ivActivity.setImageResource(R.drawable.walking_blue);
            ivNext.setImageResource(R.drawable.arrow_blue);
            tvTitle.setTextColor(Color.parseColor("#2eb2ff"));
            tvSub.setTextColor(Color.parseColor("#2eb2ff"));
            ivActivity.setBackgroundColor(Color.parseColor("#ffffff"));
            ivNext.setBackgroundColor(Color.parseColor("#ffffff"));
            tvSub.setBackgroundColor(Color.parseColor("#ffffff"));
            tvTitle.setBackgroundColor(Color.parseColor("#ffffff"));
        }else if(activity.getType() == "Cycling" && even == false) {
            ivActivity.setImageResource(R.drawable.cycle_white);
            ivNext.setImageResource(R.drawable.arrow_white);
            tvTitle.setTextColor(Color.parseColor("#ffffff"));
            tvSub.setTextColor(Color.parseColor("#ffffff"));
        }else if(activity.getType()== "Cycling" && even == true) {
            ivActivity.setImageResource(R.drawable.cycle_blue);
            ivNext.setImageResource(R.drawable.arrow_blue);
            tvTitle.setTextColor(Color.parseColor("#2eb2ff"));
            tvSub.setTextColor(Color.parseColor("#2eb2ff"));
            ivActivity.setBackgroundColor(Color.parseColor("#ffffff"));
            ivNext.setBackgroundColor(Color.parseColor("#ffffff"));
            tvSub.setBackgroundColor(Color.parseColor("#ffffff"));
            tvTitle.setBackgroundColor(Color.parseColor("#ffffff"));
        }


            return view;




    }
}
