package com.example.bankpypers;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FormAdapter extends BaseAdapter{
	
	private Context context;
	List<String> items;
	static int count=1;
	
	public FormAdapter(Context context, ArrayList<String>items)
	{
		this.items=items;
		this.context=context;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.form_item, null);
        }
		
		TextView title=(TextView)convertView.findViewById(R.id.title);
		title.setText(count+"\t"+items.get(position));
		count++;
		return convertView;
	}

}
