package com.example.cryptoapp.adapter

import android.graphics.Color
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cryptoapp.databinding.ViewholderCryptoBinding
import com.example.cryptoapp.model.SampleModel

class CryptoAdapter(private val dataList: ArrayList<SampleModel>) :
    RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {

    private val formatter = DecimalFormat("###,###,###,###.##")

    class ViewHolder(val binding: ViewholderCryptoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ViewholderCryptoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.apply {
            cryptoNameText.text = item.symbol
            cryptoPriceText.text = "$${formatter.format(item.price)}"
            changePercentText.text = "${item.changePercent}%"
            propertySizeText.text = "${item.propertySize}${item.symbol}"
            propertyAmountText.text = "$${formatter.format(item.propertyAmount)}"
            sparkLineLayout.setData(item.lineData)

            val changeColor = when {
                item.changePercent > 0 -> Color.parseColor("#12c737")
                item.changePercent < 0 -> Color.parseColor("#ff0000")
                else -> Color.WHITE
            }

            changePercentText.setTextColor(changeColor)
            sparkLineLayout.sparkLineColor = changeColor

            val drawableResourceId = holder.itemView.context.resources.getIdentifier(
                item.name,
                "drawable",
                holder.itemView.context.packageName
            )

            Glide.with(holder.itemView.context)
                .load(drawableResourceId)
                .into(logoImage)
        }
    }

    override fun getItemCount(): Int = dataList.size

}