package ma.ensa.myapplication.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ma.ensa.myapplication.Domains.CategoryDomain;
import ma.ensa.myapplication.R;

import com.bumptech.glide.Glide;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoryDomain> items;

    public CategoryAdapter(ArrayList<CategoryDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
    holder.titleTxt.setText(items.get(position).getTitle());
    int drawableresourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPicPath()
            ,"drawable",holder.itemView.getContext().getPackageName());

    Glide.with(holder.itemView.getContext())
            .load(drawableresourceId)
            .into(holder.picImg);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
 
    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView titleTxt;
        ImageView picImg;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            picImg=itemView.findViewById(R.id.catImg);
        }

    }
}
