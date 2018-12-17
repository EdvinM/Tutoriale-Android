package ro.ramonnastase.tutorialeandroid.NavigationItems;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ro.ramonnastase.tutorialeandroid.MainActivity;
import ro.ramonnastase.tutorialeandroid.R;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemHomeFragment extends Fragment {

    private ImageView imageViewPreview;
    private Button buttonSelectFromGallery;

    public static final int PICK_IMAGE = 1;

    public ItemHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_home, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle b) {

        imageViewPreview = v.findViewById(R.id.imageViewPreview);
        buttonSelectFromGallery = v.findViewById(R.id.buttonSelectFromGallery);

        buttonSelectFromGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE);

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Selecteaza o Imagine"), PICK_IMAGE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE)
        {
            if(resultCode == RESULT_OK)
            {
                Uri selectedImage  = data.getData();
                if(selectedImage != null)
                {
                    Glide.with(getActivity()).load(selectedImage).into(imageViewPreview);
                }
                else
                {
                    Log.d("MainActivity", "Nu am putut incarca imaginea din galerie");
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        switch (requestCode)
        {

        }
    }

    public boolean checkPermission(Activity activity, String permission)
    {
        List<String> listPermissionsNeeded = new ArrayList<>();

        if(ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(permission);

        if (!listPermissionsNeeded.isEmpty())
        {
            ActivityCompat.requestPermissions(activity, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 10 );
            return false;
        }
        return true;
    }
}
