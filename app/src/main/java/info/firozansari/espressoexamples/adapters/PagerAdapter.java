package info.firozansari.espressoexamples.adapters;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import info.firozansari.espressoexamples.fragments.PagerFragment;


public class PagerAdapter extends FragmentStatePagerAdapter {
    public String[] mStrings;


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public PagerAdapter(FragmentManager fm, String[] strings) {
        super(fm);
        mStrings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return new PagerFragment().newInstance(mStrings[position]);
    }

    @Override
    public int getCount() {
        return mStrings.length;
    }
}
