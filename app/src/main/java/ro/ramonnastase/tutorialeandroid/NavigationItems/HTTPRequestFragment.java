package ro.ramonnastase.tutorialeandroid.NavigationItems;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ro.ramonnastase.tutorialeandroid.R;
import ro.ramonnastase.tutorialeandroid.SendRequestAsync;

/**
 * A simple {@link Fragment} subclass.
 */
public class HTTPRequestFragment extends Fragment {

    private TextView textViewResponse;
    private ProgressBar progressBarLoading;
    private Button buttonSendRequest;

    public HTTPRequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_httprequest, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {

        textViewResponse = view.findViewById(R.id.textViewResponse);
        buttonSendRequest = view.findViewById(R.id.buttonSendRequest);
        progressBarLoading = view.findViewById(R.id.progressBarLoading);

        buttonSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SendRequestAsync(textViewResponse, progressBarLoading).execute();
            }
        });
    }
}
