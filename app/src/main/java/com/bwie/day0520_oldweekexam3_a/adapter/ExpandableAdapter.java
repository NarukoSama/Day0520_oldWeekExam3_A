package com.bwie.day0520_oldweekexam3_a.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.bwie.day0520_oldweekexam3_a.R;
import com.bwie.day0520_oldweekexam3_a.bean.FenLei;

import java.util.List;

/**
 * Created by
 * Chenxin
 * on 2017/5/20.
 */

/**
 * 二级列表Adapter类
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {

    List<FenLei> fenLeis;
    Context context;

    public ExpandableAdapter(Context context, List<FenLei> fenLeis) {

        this.context = context;

        this.fenLeis = fenLeis;

    }

    @Override
    public int getGroupCount() {
        return fenLeis.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return fenLeis.get(groupPosition).getNodes().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return fenLeis.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return fenLeis.get(groupPosition)
                .getNodes().get(childPosition);
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
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ViewHolderGroup group;

        if (convertView == null){
            group = new ViewHolderGroup();
            convertView = View.inflate(context, R.layout.group,null);

            group.group_tv = (TextView) convertView.findViewById(R.id.group_tv);

            convertView.setTag(group);
        }else{
            group = (ViewHolderGroup) convertView.getTag();
        }

        FenLei fenLei = fenLeis.get(groupPosition);

        group.group_tv.setText(fenLei.getCname());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ViewHolderChild child = null;

        if (convertView == null){

            child = new ViewHolderChild();
            convertView = View.inflate(context, R.layout.child,null);

            child.child_tv = (TextView) convertView.findViewById(R.id.child_tv);

            convertView.setTag(child);
        }else{
            child = (ViewHolderChild) convertView.getTag();
        }

        FenLei fenLei = fenLeis.get(groupPosition);

        child.child_tv.setText(fenLei.getNodes().get(childPosition).getCategory_name());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ViewHolderGroup{

        TextView group_tv;
    }

    class ViewHolderChild{
        TextView child_tv;
    }
}
