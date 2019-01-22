package ro.ramonnastase.tutorialeandroid.NavigationItems;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import ro.ramonnastase.tutorialeandroid.Adapters.ViewPagerAdapter;
import ro.ramonnastase.tutorialeandroid.NavigationItems.ViewPagerFragments.Frag1;
import ro.ramonnastase.tutorialeandroid.NavigationItems.ViewPagerFragments.Frag2;
import ro.ramonnastase.tutorialeandroid.NavigationItems.ViewPagerFragments.Frag3;
import ro.ramonnastase.tutorialeandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainViewPagerFragment extends Fragment {

    private ViewPager viewPagerMain;

    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;

    private List<Fragment> fragmentList;
    private List<String> fragmentTitles;

    public MainViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_view_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {

        viewPagerMain = view.findViewById(R.id.viewPagerMain);
        tabLayout = view.findViewById(R.id.tabLayoutMain);

        this.fragmentList = new ArrayList<>();
        this.fragmentList.add(new Frag1());
        this.fragmentList.add(new Frag2());
        this.fragmentList.add(new Frag3());

        this.fragmentTitles = new ArrayList<>();
        this.fragmentTitles.add("Tab 1");
        this.fragmentTitles.add("Tab 2");
        this.fragmentTitles.add("Tab 3");

        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), this.fragmentList, this.fragmentTitles);

        viewPagerMain.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPagerMain);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_tab_1);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_tab_2);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_tab_3);

    }
}
