package com.danilkinkin.buckwheat.adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*


class CurrencyAdapter(context: Context, private val items: MutableList<Currency>)
    : ArrayAdapter<Currency>(context, android.R.layout.simple_dropdown_item_1line, items), Filterable {

    override fun getCount(): Int = items.size

    override fun getItem(p0: Int): Currency {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return items[p0].numericCode.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView

        if (view == null) {
            val inflater = (context as Activity).layoutInflater
            view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false)
        }

        try {
            val currency: Currency = getItem(position)
            val cityAutoCompleteView = view!!.findViewById<TextView>(android.R.id.text1)
            cityAutoCompleteView.text = currency.displayName
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return view!!
    }
}