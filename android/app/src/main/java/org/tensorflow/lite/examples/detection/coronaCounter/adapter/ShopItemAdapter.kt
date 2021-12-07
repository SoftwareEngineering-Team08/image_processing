package com.example.coronacounter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.coronacounter.model.BusinessType
import org.tensorflow.lite.examples.detection.R
import com.example.coronacounter.model.Shop
import com.example.coronacounter.view.MyPageDirections

class ShopItemAdapter(private val context: Context, private val dataset: List<Shop>) : RecyclerView.Adapter<ShopItemAdapter.ItemViewHolder>(){

    fun matchBusinessTypeWithDrawanle(type:BusinessType) : Int{
        return when(type){
            BusinessType.HOTEL -> R.drawable.ic_baseline_hotel_24
            BusinessType.RESTAURANT -> R.drawable.ic_baseline_restaurant_24
            BusinessType.GYM -> R.drawable.ic_baseline_gym_24
            BusinessType.ACADEMY -> R.drawable.ic_baseline_school_24
            BusinessType.BAR -> R.drawable.ic_baseline_wine_bar_24
        }

    }



    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view)  {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.shop_list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.shopName
        holder.imageView.setImageResource(matchBusinessTypeWithDrawanle(item.businessType!!))
        holder.itemView.setOnClickListener(
            Navigation.createNavigateOnClickListener(MyPageDirections.actionMyPageToEditStore(shop = item))
        )
    }

    override fun getItemCount(): Int {

        return dataset.size
    }

}