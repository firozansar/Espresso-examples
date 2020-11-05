package info.firozansari.espressoexamples.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import info.firozansari.espressoexamples.R;
import info.firozansari.espressoexamples.fragments.PositionFragment;


public class PositionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, PositionFragment.newInstance()).commit();
        }
    }


}
