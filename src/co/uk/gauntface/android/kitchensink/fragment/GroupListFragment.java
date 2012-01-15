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
	private int DIALOG_INDEX;
	private int LISTVIEW_INDEX;
	
	private GroupAdapter mGroupAdapter;
	
	private ListView mListView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Resources resources = getResources();
		
		String[] listStrings = resources.getStringArray(R.array.main_list_titles);
		
		FORM_WIDGET_INDEX = resources.getInteger(R.integer.form_widget_index);
		DIALOG_INDEX = resources.getInteger(R.integer.dialog_index);
		LISTVIEW_INDEX = resources.getInteger(R.integer.listview_index);
		
		mGroupAdapter = new GroupAdapter(getApplicationContext(), listStrings);
	}
	
	@Override
	public int setFragmentContentView() {
		return R.layout.fragment_group_list;
	}
	
	@Override
	public void  initViews(View v, ViewGroup container,
            Bundle savedInstanceState) {
		mListView = (ListView) v.findViewById(R.id.fragment_group_list_listview);
		
		setUpViews();
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
		Intent i = new Intent();
		i.setPackage(getApplicationContext().getPackageName());
		
		if(position == FORM_WIDGET_INDEX) {
			i.setAction(LaunchActivity.ACTION_SHOW_FORM_WIDGETS);
		} else if(position == DIALOG_INDEX) {
			i.setAction(LaunchActivity.ACTION_SHOW_DIALOGS);
		} else if(position == LISTVIEW_INDEX) {
			i.setAction(LaunchActivity.ACTION_SHOW_LISTVIEWS);
		} else {
			return;
		}
		
		getActivity().startActivity(i);
	}
}
