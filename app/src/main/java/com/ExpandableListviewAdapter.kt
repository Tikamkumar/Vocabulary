package com

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.tikamkumar.vocabulary.R

class ExpandableListviewAdapter(var context: Context,var title : MutableList<String>,var subTitle : MutableList<MutableList<String>>): BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return title.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return subTitle[groupPosition].size
    }

    override fun getGroup(groupPosition: Int): Any {
        return title[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return subTitle[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if(convertView == null)
        {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.title_layout,null)
        }
        val mTitle = convertView?.findViewById<TextView>(R.id.tv_title)
        mTitle?.text = getGroup(groupPosition) as CharSequence?
        return convertView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if(convertView == null)
        {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.subtitle_layout,null)
        }
        val mSubTitle = convertView?.findViewById<TextView>(R.id.tv_subtitle)
        mSubTitle?.text = getChild(groupPosition,childPosition) as CharSequence?
        return convertView!!
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}