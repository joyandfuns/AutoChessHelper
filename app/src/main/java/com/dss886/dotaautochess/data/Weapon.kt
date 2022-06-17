package com.dss886.dotaautochess.data

import com.dss886.dotaautochess.R

/**
 * Created by wurf
 * on 2022/6/16.
 */
enum class Weapon(val title: String, val level: Int, val type: String, val desc: String, var iconRes: Int) {
    A("a", 1, "一级", "add a", R.mipmap.hero_axe_icon),
    B("b", 1, "一级", "add b", R.mipmap.hero_axe_icon),
    C("c", 1, "一级", "add c", R.mipmap.hero_axe_icon),
    D("d", 2, "二级", "add d", R.mipmap.hero_axe_icon),
    E("e", 2, "二级", "add e", R.mipmap.hero_axe_icon),
    F("f", 2, "二级", "add f", R.mipmap.hero_axe_icon),
    G("f", 3, "三级", "add g", R.mipmap.hero_axe_icon),
    H("f", 3, "三级", "add h", R.mipmap.hero_axe_icon),
    I("f", 3, "三级", "add i", R.mipmap.hero_axe_icon),
    J("j", 4, "四级", "add j", R.mipmap.hero_axe_icon),
    K("k", 4, "四级", "add k", R.mipmap.hero_axe_icon),
    L("l", 4, "四级", "add l", R.mipmap.hero_axe_icon),
}