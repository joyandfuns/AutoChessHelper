package com.dss886.dotaautochess.feature.hero

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dss886.dotaautochess.R
import com.dss886.dotaautochess.data.Hero
import com.dss886.dotaautochess.data.Weapon
import com.dss886.dotaautochess.feature.hero.holder.AllHeroViewHolder
import com.dss886.dotaautochess.feature.hero.holder.AllWeaponViewHolder
import com.dss886.dotaautochess.feature.hero.holder.HeroCountHolder
import com.dss886.dotaautochess.feature.hero.holder.TitleHolder
import com.dss886.dotaautochess.utils.DataWrapper
import java.util.*

/**
 * Created by wrf on 2022/6/17.
 */
class AllWeaponAdapter internal constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>(), IHeroItemCallback{

    companion object {
        private const val TYPE_HEADER = 1000
        private const val TYPE_FOOTER = 1001
        private const val TYPE_WEAPON = 1002
    }

    private var mRecyclerView: RecyclerView? = null
    private val mDataList = ArrayList<DataWrapper>()
    private var mCurrentExpandedPosition = -1
    private var mLastExpandCollapseTime = 0L

    init {
        var currentLevel = 0
        for (hero in Weapon.values()) {
            if (hero.level > currentLevel) {
                mDataList.add(DataWrapper(TYPE_HEADER, hero.type))
                currentLevel++
            }
            mDataList.add(DataWrapper(TYPE_WEAPON, hero))
        }
        mDataList.add(DataWrapper(TYPE_FOOTER, Weapon.values().size))
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_HEADER -> TitleHolder(inflater.inflate(R.layout.hero_item_header, parent, false))
            TYPE_FOOTER -> HeroCountHolder(inflater.inflate(R.layout.hero_item_footer, parent, false))
            else -> AllWeaponViewHolder(inflater.inflate(R.layout.weapon_item_all_list, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = mDataList[position]
        when (holder) {
            is TitleHolder -> holder.bind(data.get())
            is HeroCountHolder -> holder.bind(data.get())
            is AllWeaponViewHolder -> holder.bind(data.get())
        }
    }

    override fun getItemViewType(position: Int): Int {
        return mDataList[position].type
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    /**
     * Only allow one item to expand.
     * Method notifyItemChange() has some issues on performance here,
     * so we have to expand it by do our own animations.
     */
    override fun onItemClick(position: Int, hero: Hero) {
        if (position < 0 || mRecyclerView == null) {
            return
        }
        val now = System.currentTimeMillis()
        if (now - mLastExpandCollapseTime <= 300L) {
            return
        }
        mLastExpandCollapseTime = now

        val isExpand = mCurrentExpandedPosition != position
        if (isExpand && mCurrentExpandedPosition >= 0) {
            val holder = mRecyclerView?.findViewHolderForAdapterPosition(mCurrentExpandedPosition)
            if (holder is AllHeroViewHolder) {
                holder.doExpandOrCollapse(false)
            }
        }
        val holder = mRecyclerView?.findViewHolderForAdapterPosition(position)
        if (holder is AllHeroViewHolder) {
            holder.doExpandOrCollapse(isExpand)
        }
        mCurrentExpandedPosition = if (isExpand) position else -1
    }

}
