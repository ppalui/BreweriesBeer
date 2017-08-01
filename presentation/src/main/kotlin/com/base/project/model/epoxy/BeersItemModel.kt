package com.base.project.model.epoxy

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.base.project.R
import com.base.project.extensions.BeerItemClickListener
import com.base.project.model.BreweriesModel
import com.bumptech.glide.Glide
import com.navik.presentation.extensions.hide
import com.navik.presentation.extensions.show

@EpoxyModelClass(layout = R.layout.row_beer_item)
abstract class BeersItemModel : EpoxyModelWithHolder<BeersItemModel.ViewHolder>() {

	@JvmField @EpoxyAttribute protected var model: BreweriesModel? = null
	@JvmField @EpoxyAttribute protected var beerItemClickListener: BeerItemClickListener? = null

	override fun onViewAttachedToWindow(holder: ViewHolder) {
		super.onViewAttachedToWindow(holder)
		with(holder) {
			model?.let { model ->

				Glide.with(imageBeer.context)
					.load(model.images?.squareLarge)
					.centerCrop()
					.error(R.color.accent)
					.placeholder(R.color.primary_gray)
					.into(imageBeer)

				name.text = model.nameShortDisplay
				type.text = model.brandClassification

				if ("Y" == model.isOrganic) isOrganic.show() else isOrganic.hide()
				layout.setOnClickListener { beerItemClickListener?.invoke(model) }
			}
		}
	}

	inner class ViewHolder : EpoxyHolder() {

		lateinit var name: TextView
		lateinit var type: TextView
		lateinit var isOrganic: TextView
		lateinit var layout: View
		lateinit var imageBeer: ImageView

		override fun bindView(itemView: View) {
			imageBeer = itemView.findViewById(R.id.imageView) as ImageView
			name = itemView.findViewById(R.id.textViewBeersName) as TextView
			type = itemView.findViewById(R.id.textViewBeersType) as TextView
			isOrganic = itemView.findViewById(R.id.textViewIsOrganic) as TextView
			layout = itemView.findViewById(R.id.layoutBeerItem)
		}
	}
}