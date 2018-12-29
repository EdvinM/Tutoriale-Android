package ro.ramonnastase.tutorialeandroid.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import ro.ramonnastase.tutorialeandroid.Models.ListModel;
import ro.ramonnastase.tutorialeandroid.R;
import ro.ramonnastase.tutorialeandroid.ViewHolders.ListViewHolder;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private List<ListModel> listModels;
    private Context context;

    public ListViewAdapter(Context context, List<ListModel> listModels) {
        this.listModels = listModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_layout, viewGroup, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int position) {

        ListModel listModel = this.listModels.get(position);

        listViewHolder.textViewName.setText(listModel.getName());
        listViewHolder.textViewNumber.setText(listModel.getNumber());

        Glide.with(this.context).load(listModel.getImageUrl()).into(listViewHolder.imageViewPerson);
    }

    @Override
    public int getItemCount() {
        return this.listModels.size();
    }
}
