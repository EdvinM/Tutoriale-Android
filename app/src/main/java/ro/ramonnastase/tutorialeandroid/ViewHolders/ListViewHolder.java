package ro.ramonnastase.tutorialeandroid.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ro.ramonnastase.tutorialeandroid.R;

public class ListViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageViewPerson;
    public TextView textViewName;
    public TextView textViewNumber;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);

        this.imageViewPerson = itemView.findViewById(R.id.imageViewPerson);
        this.textViewName = itemView.findViewById(R.id.textViewName);
        this.textViewNumber = itemView.findViewById(R.id.textViewNumber);
    }
}
