package ro.ramonnastase.tutorialeandroid.NavigationItems;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ro.ramonnastase.tutorialeandroid.Adapters.ListViewAdapter;
import ro.ramonnastase.tutorialeandroid.Models.ListModel;
import ro.ramonnastase.tutorialeandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private RecyclerView recyclerViewContacts;
    private List<ListModel> listModels;
    private ListViewAdapter listViewAdapter;

    public ListFragment() {
        // Required empty public constructor

        ListModel listModel1 = new ListModel();
        listModel1.setImageUrl("https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-ios7-contact-512.png");
        listModel1.setName("Johnny Bravo");
        listModel1.setNumber("+40123456789");

        ListModel listModel2 = new ListModel();
        listModel2.setImageUrl("https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-ios7-contact-512.png");
        listModel2.setName("Tom Doe");
        listModel2.setNumber("+40987654321");

        ListModel listModel3 = new ListModel();
        listModel3.setImageUrl("https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-ios7-contact-512.png");
        listModel3.setName("Arnold Lipstick");
        listModel3.setNumber("+40543216789");

        listModels = new ArrayList<>();
        listModels.add(listModel1);
        listModels.add(listModel2);
        listModels.add(listModel3);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {

        this.recyclerViewContacts = view.findViewById(R.id.recyclerViewContacts);

        this.recyclerViewContacts.setLayoutManager(new LinearLayoutManager(view.getContext()));

        this.listViewAdapter = new ListViewAdapter(view.getContext(), listModels);

        this.recyclerViewContacts.setAdapter(this.listViewAdapter);
    }
}
