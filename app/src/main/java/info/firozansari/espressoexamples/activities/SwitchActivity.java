package info.firozansari.espressoexamples.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import info.firozansari.espressoexamples.R;
import info.firozansari.espressoexamples.fragments.SwitchFragment;


public class SwitchActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, SwitchFragment.newInstance()).commit();
		}
	}
}
