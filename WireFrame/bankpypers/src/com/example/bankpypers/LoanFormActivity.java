package com.example.bankpypers;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoanFormActivity extends Activity {

	EditText sal;
	EditText cash;
	EditText years;
	RadioGroup radio_group;
	Button submit;
	RadioButton radioButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loan_form);
		
		sal=(EditText)findViewById(R.id.salary);
		cash=(EditText)findViewById(R.id.amount);
		years=(EditText)findViewById(R.id.years);
		
		radio_group=(RadioGroup)findViewById(R.id.radioGroup1);
		
		submit=(Button)findViewById(R.id.button);
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				int selectedId = radio_group.getCheckedRadioButtonId();
				 
				// find the radiobutton by returned id
			        radioButton = (RadioButton) findViewById(selectedId);
			        String reason=radioButton.getText().toString();
			        //send data
			}
			
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.loan_form, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
