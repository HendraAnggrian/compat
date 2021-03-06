@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kota

import android.view.Menu
import android.view.MenuItem

inline fun Menu.find(id: Int): MenuItem = findItem(id)!!
inline fun Menu.findOrNull(id: Int): MenuItem? = findItem(id)

inline operator fun Menu.get(index: Int): MenuItem = getItem(index)!!
inline fun Menu.getOrNull(index: Int): MenuItem? = if (index in 0..lastIndex) getItem(index) else null

inline val Menu.items: List<MenuItem> get() = (0 until size()).map { getItem(it) }
inline val Menu.firstItem: MenuItem get() = this[0]
inline val Menu.firstItemOrNull: MenuItem? get() = if (isEmpty) null else firstItem
inline val Menu.lastItem: MenuItem get() = this[lastIndex]
inline val Menu.lastItemOrNull: MenuItem? get() = if (isEmpty) null else lastItem

inline val Menu.isEmpty: Boolean get() = size() == 0
inline val Menu.lastIndex: Int get() = size() - 1

inline fun Menu.forEachItem(action: (MenuItem) -> Unit) = items.forEach(action)
inline fun Menu.forEachItemIndexed(action: (Int, MenuItem) -> Unit) = items.forEachIndexed(action)