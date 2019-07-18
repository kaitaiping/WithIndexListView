package com.boji.withindexlistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.boji.listview.WithIndexExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xing on 1/8/16.
 */
public class MyAdapter extends WithIndexExpandableListAdapter {
    List<String> group ;
    List<ArrayList<String>> data ;

    public void setData(List<String> group,List<ArrayList<String>> data) {
        this.group = group ;
        this.data = data ;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition) ;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList children = (ArrayList) getGroup(groupPosition);

        return children.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView view ;
        if (convertView == null) {
            view = (TextView) View.inflate(parent.getContext(),android.R.layout.simple_list_item_1,null);
        } else {
            view = (TextView) convertView;
        }

        view.setBackgroundResource(android.R.color.white);
        view.setText(group.get(groupPosition));

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView view ;
        if (convertView == null) {
            view = (TextView) View.inflate(parent.getContext(),android.R.layout.simple_list_item_1,null);
        } else {
            view = (TextView) convertView;
        }

        view.setText((String) getChild(groupPosition, childPosition));

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public List<String> getIndexList() {
        return group;
    }

    @Override
    public void onIndexSelect(int position) {

    }
}
