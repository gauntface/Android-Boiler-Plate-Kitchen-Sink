package co.uk.gauntface.android.kitchensink.adapter;

import co.uk.gauntface.android.kitchensink.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GroupAdapter extends BaseAdapter {

	private String[] mStrings;
	private LayoutInflater mInflater;
	
	public GroupAdapter(Context context, String[] string) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mStrings = string;
	}

	@Override
	public int getCount() {
		return mStrings.length;
	}

	@Override
	public String getItem(int position) {
		return mStrings[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View v;
		GroupViewHolder vh;
		
		if(convertView == null) {
			// No view to convert, inflate a new one
			v = mInflater.inflate(R.layout.item_grouping_list, null);
			vh = new GroupViewHolder(v);
			v.setTag(vh);
		} else {
			v= convertView;
			vh = (GroupViewHolder) convertView.getTag();
		}
		
		vh.setUpItem(position);
		
		return v;
	}
	
	private class GroupViewHolder {
		
		private View mRootView;
		private TextView mTitleTextView;
		
		public GroupViewHolder(View v) {
			mRootView = v;
			mTitleTextView = (TextView) v.findViewById(R.id.item_grouping_heading_textview);
		}
		
		public void setUpItem(int position) {
			mTitleTextView.setText(mStrings[position]);
		}
		
	}
}
