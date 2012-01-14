package co.uk.gauntface.android.kitchensink.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import co.uk.gauntface.android.kitchensink.C;
import co.uk.gauntface.android.kitchensink.KitchenSinkFragment;
import co.uk.gauntface.android.kitchensink.R;
import co.uk.gauntface.android.kitchensink.activity.LaunchActivity;
import co.uk.gauntface.android.kitchensink.adapter.GroupAdapter;

public class GroupListFragment extends KitchenSinkFragment implements OnItemClickListener {

	private int FORM_WIDGET_INDEX;
	
	private GroupAdapter mGroupAdapter;
	private Context mContext;
	
	private ListView mListView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(C.TAG, "GroupListFragment: onCreate()");
		mContext = getActivity().getApplicationContext();
		
		Resources resources = getResources();
		
		String[] listStrings = resources.getStringArray(R.array.main_list_titles);
		
		FORM_WIDGET_INDEX = resources.getInteger(R.integer.form_widget_index);
		
		mGroupAdapter = new GroupAdapter(mContext, listStrings);
	}
	
	@Override
	public View  initViews(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_group_list, container, false);
		
		mListView = (ListView) v.findViewById(R.id.fragment_group_list_listview);
		
		setUpViews();
		
		return v;
	}
	
	private void setUpViews() {
		mListView.setAdapter(mGroupAdapter);
		mListView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch(parent.getId()) {
		case R.id.fragment_group_list_listview:
			handleListItemClick(view, position, id);
			break;
		}
	}
	
	private void handleListItemClick(View view, int position, long id) {
		if(position == FORM_WIDGET_INDEX) {
			handleFormWidgetSelection();
		}
	}
	
	private void handleFormWidgetSelection() {
		Intent i = new Intent(LaunchActivity.ACTION_SHOW_FORM_WIDGETS);
		i.setPackage(mContext.getPackageName());
		getActivity().startActivity(i);
	}
}
