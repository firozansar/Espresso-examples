package info.firozansari.espressoexamples.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import info.firozansari.espressoexamples.R;
import info.firozansari.espressoexamples.fragments.HierarchyFragment;


public class HierarchyActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, HierarchyFragment.newInstance()).commit();
		}
	}

}
