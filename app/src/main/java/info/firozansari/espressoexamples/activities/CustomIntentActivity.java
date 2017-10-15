package info.firozansari.espressoexamples.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import info.firozansari.espressoexamples.R;


/**
 * Activity that is launched with a custom intent
 */
public class CustomIntentActivity extends AppCompatActivity {

	public static final String CUSTOM_TEXT = "CUSTOM_TEXT";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_intent);

		setTextView();
	}

	private void setTextView() {
		String text = getIntent().getExtras().getString(CUSTOM_TEXT);

		TextView textView = (TextView) findViewById(R.id.custom_intent_textview);
		textView.setText(text);
	}

	public static void startActivity(Activity originActivity, String text) {
		Intent intent = new Intent(originActivity, CustomIntentActivity.class);
		intent.putExtra(CUSTOM_TEXT, text);
		originActivity.startActivity(intent);
	}

}
