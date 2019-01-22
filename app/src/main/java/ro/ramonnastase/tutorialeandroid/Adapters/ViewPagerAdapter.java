package ro.ramonnastase.tutorialeandroid.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> fragmentTitles;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> fragmentTitles) {
        super(fm);

        this.fragmentList = fragmentList;
        this.fragmentTitles = fragmentTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return this.fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.fragmentTitles.get(position);
    }
}
