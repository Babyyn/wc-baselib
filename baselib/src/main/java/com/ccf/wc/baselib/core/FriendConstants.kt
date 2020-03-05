package com.ccf.wc.baselib.core

import com.ccf.wc.baselib.ui.Constants

object FriendConstants {
    private const val GROUP = "friend"

    const val ENTRY_FRAGMENT = "/$GROUP/${Constants.MAIN_FRAGMENT}"

    const val SERVICE_FRIEND = "/$GROUP/friendService"

    private const val DETAIL = "detail"
    private const val SEARCH = "search"

    const val FRIEND_DETAIL = "/$GROUP/$DETAIL"
    const val FRIEND_SEARCH = "/$GROUP/$SEARCH"

    const val EXTRA_FRIEND_DETAIL_NAME = "name"
    const val EXTRA_FRIEND_DETAIL_FROM = "from"
}