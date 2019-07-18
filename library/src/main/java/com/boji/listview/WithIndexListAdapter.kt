package com.boji.listview

import android.widget.BaseAdapter
import android.widget.BaseExpandableListAdapter

/**
 * Created by boji on 2019-07-17.
 */
abstract class WithIndexExpandableListAdapter : BaseExpandableListAdapter(), IWithIndex

abstract class WithIndexListViewAdapter : BaseAdapter(), IWithIndex

interface IWithIndex {
    val indexList: List<String>
    fun onIndexSelect(position: Int)
}
