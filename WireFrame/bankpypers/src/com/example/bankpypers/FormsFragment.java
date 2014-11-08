package com.example.bankpypers;


import java.util.ArrayList;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class FormsFragment extends Fragment{
	
	ListView items;
	ArrayList<String> form_items=new ArrayList<String>();
	
	//Mandatory Constructor
    public FormsFragment() {
    	form_items.add("Withdrawal");
		form_items.add("Deposit");
		form_items.add("Money Transfer");
		form_items.add("Loan Application");
		form_items.add("Demand Draft");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.forms, container, false);
		
		items=(ListView)rootView.findViewById(R.id.list);
		
	    items.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> adapter, View arg1, int pos,
						long arg3) {
					switch(pos)
					{
					case 0:withdraw_dialog("Withdraw");
							break;
					case 1:withdraw_dialog("Deposit");
							break;
					case 2:break;
					case 3:Intent i=new Intent(getActivity(),LoanFormActivity.class);
							startActivity(i);
					case 4:break;
					case 5:break;
					
					}
					
				}
		    	 
		     });
	    items.setAdapter(new FormAdapter(getActivity(),form_items));

		return rootView; 
	
	}
    
   public void withdraw_dialog(String type)
	{
    	final Dialog dialog = new Dialog(getActivity());
		dialog.setContentView(R.layout.withdrawal_form);
		dialog.setTitle(type);

		final EditText amount=(EditText)dialog.findViewById(R.id.entry);
		
		//ARVIND: ADD TEXT LISTENER TO CONVERT INTO WORDS
		
		Button dialogButton = (Button) dialog.findViewById(R.id.OKButton);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				double cash=Double.parseDouble(amount.getText().toString());
				
				//send data
			}
		});

		dialog.show();
	}
   
}
