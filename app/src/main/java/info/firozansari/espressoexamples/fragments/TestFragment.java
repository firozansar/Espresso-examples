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


/**
 * Created by jordan_terry on 03/02/2015.
 */
public class TestFragment extends Fragment {

    private TextView mExampleText;
    private Button mExampleButton;
    private TextSwapper mTextSwapper;

    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_test, container, false);
        mTextSwapper = new TextSwapper(getResources().getString(R.string.example_text_before), getResources().getString(R.string.example_text_after));
        mExampleText = (TextView) rootView.findViewById(R.id.test_fragment_example_text);
        mExampleButton = (Button) rootView.findViewById(R.id.change_text_button);

        mExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExampleText.setText(mTextSwapper.swap());
            }
        });

        return rootView;
    }
}
