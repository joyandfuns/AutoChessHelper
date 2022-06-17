package com.dss886.dotaautochess.feature.hero.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dss886.dotaautochess.R
import com.dss886.dotaautochess.data.Weapon
import com.dss886.dotaautochess.utils.*

/**
 * Created by wrf on 2022/6/17.
 */
class AllWeaponViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mIconWeapon: ImageView = itemView.findViewById(R.id.icon_weapon)
    private val mTvName: TextView = itemView.findViewById(R.id.tv_name)

    fun bind(weapon: Weapon) {
        mIconWeapon.loadImage(weapon.iconRes)
        mTvName.text = weapon.title
    }

}
