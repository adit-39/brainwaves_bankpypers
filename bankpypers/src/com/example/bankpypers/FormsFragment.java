package com.example.bankpypers;


import java.util.ArrayList;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class FormsFragment extends Fragment{
	
	ListView items;
	ArrayList<String> form_items=new ArrayList<String>();
	SharedPreferences p;
	
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
		
		p=getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
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
    
   public void withdraw_dialog(final String type)
	{
    	final Dialog dialog = new Dialog(getActivity());
		dialog.setContentView(R.layout.withdrawal_form);
		dialog.setTitle(type);

		final EditText amount=(EditText)dialog.findViewById(R.id.entry);
		
		final TextView ti =(TextView)dialog.findViewById(R.id.words);
		final String result[]=new String[1];
		amount.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	        	int i=0;
	        	android.util.Log.d("test","Called");
	            String str = amount.getText().toString();
	            if(str.length()>0)
	            {
		            ConvertNumberToText(Integer.parseInt(str), result);
		            ti.setText(result[0]+" only");
		            android.util.Log.d("test","Called");
	            }
	            //ti.setText("hello"+i++);
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
	        public void onTextChanged(CharSequence s, int start, int before, int count){}
	    });
		
		Button dialogButton = (Button) dialog.findViewById(R.id.OKButton);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				double cash=Double.parseDouble(amount.getText().toString());
						//MainActivity.flag=true;
				
				p.edit().putString("type", type);
				p.edit().putString("name", "Chiraag");
				p.edit().putFloat("amount", (float) cash);
				p.edit().commit();
				//send data
			}
		});

		dialog.show();
	}
   
   public boolean HelperConvertNumberToText(int num, String[] result) {
		String[] strones = { "One", "Two", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
				"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
				"Eighteen", "Nineteen", };

		String[] strtens = { "Ten", "Twenty", "Thirty", "Fourty", "Fifty",
				"Sixty", "Seventy", "Eighty", "Ninety", "Hundred" };

		result[0] = "";
		int single, tens, hundreds;

		if (num > 1000)
			return false;

		hundreds = num / 100;
		num = num - hundreds * 100;
		if (num < 20) {
			tens = 0; // special case
			single = num;
		} else {
			tens = num / 10;
			num = num - tens * 10;
			single = num;
		}

		if (hundreds > 0) {
			result[0] += strones[hundreds - 1];
			result[0] += " Hundred ";
		}
		if (tens > 0) {
			result[0] += strtens[tens - 1];
			result[0] += " ";
		}
		if (single > 0) {
			result[0] += strones[single - 1];
			result[0] += " ";
		}
		return true;
	}

	public boolean ConvertNumberToText(int num, String[] result) {
		String tempString[] = new String[1];
		tempString[0] = "";
		int thousands;
		int temp;
		result[0] = "";
		if (num < 0 || num > 100000) {
			System.out.println(num + " \tNot Supported");
			return false;
		}

		if (num == 0) {
			System.out.println(num + " \tZero");
			return false;
		}

		if (num < 1000) {
			HelperConvertNumberToText(num, tempString);
			result[0] += tempString[0];
		} else {
			thousands = num / 1000;
			temp = num - thousands * 1000;
			HelperConvertNumberToText(thousands, tempString);
			result[0] += tempString[0];
			result[0] += "Thousand ";
			HelperConvertNumberToText(temp, tempString);
			result[0] += tempString[0];
		}
		return true;
	}
   
}
