package com.example.tester_cardview

import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter

class ItemAdapter(val titles: Array<String>, val content: Array<String>) : BaseExpandableListAdapter(){
// Group Methods

    override fun getGroupCount(): Int {
        return titles.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return titles[groupPosition]
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGroupId(groupPosition: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

// Children methods

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return content[childPosition]
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasStableIds(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}