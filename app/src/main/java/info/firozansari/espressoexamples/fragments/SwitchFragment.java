package info.firozansari.espressoexamples.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import info.firozansari.espressoexamples.R;
import info.firozansari.espressoexamples.TextSwapper;


public class SwitchFragment extends Fragment {

    private TextView mExampleText;
    private Button mExampleButton;
    private TextSwapper mTextSwapper;

    public static SwitchFragment newInstance() {
        SwitchFragment fragment = new SwitchFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_switch, container, false);
    }
}
