package com.simplemobiletools.contacts.helpers

import android.content.Context
import com.simplemobiletools.commons.helpers.BaseConfig
import com.simplemobiletools.commons.helpers.SORTING
import com.simplemobiletools.commons.helpers.SORT_BY_FIRST_NAME

class Config(context: Context) : BaseConfig(context) {
    companion object {
        fun newInstance(context: Context) = Config(context)
    }

    var sorting: Int
        get() = prefs.getInt(SORTING, SORT_BY_FIRST_NAME)
        set(sorting) = prefs.edit().putInt(SORTING, sorting).apply()

    var callContact: Boolean
        get() = prefs.getBoolean(CALL_CONTACT_ON_CLICK, false)
        set(callContact) = prefs.edit().putBoolean(CALL_CONTACT_ON_CLICK, callContact).apply()

    var displayContactSources: Set<String>
        get() = prefs.getStringSet(DISPLAY_CONTACT_SOURCES, hashSetOf("-1"))
        set(displayContactSources) = prefs.edit().remove(DISPLAY_CONTACT_SOURCES).putStringSet(DISPLAY_CONTACT_SOURCES, displayContactSources).apply()

    fun showAllContacts() = displayContactSources.size == 1 && displayContactSources.first() == "-1"

    var showContactThumbnails: Boolean
        get() = prefs.getBoolean(SHOW_CONTACT_THUMBNAILS, true)
        set(showContactThumbnails) = prefs.edit().putBoolean(SHOW_CONTACT_THUMBNAILS, showContactThumbnails).apply()

    var showPhoneNumbers: Boolean
        get() = prefs.getBoolean(SHOW_PHONE_NUMBERS, false)
        set(showPhoneNumbers) = prefs.edit().putBoolean(SHOW_PHONE_NUMBERS, showPhoneNumbers).apply()

    var startNameWithSurname: Boolean
        get() = prefs.getBoolean(START_NAME_WITH_SURNAME, false)
        set(startNameWithSurname) = prefs.edit().putBoolean(START_NAME_WITH_SURNAME, startNameWithSurname).apply()

    var lastUsedContactSource: String
        get() = prefs.getString(LAST_USED_CONTACT_SOURCE, "")
        set(lastUsedContactSource) = prefs.edit().putString(LAST_USED_CONTACT_SOURCE, lastUsedContactSource).apply()

    var lastUsedViewPagerPage: Int
        get() = prefs.getInt(LAST_USED_VIEW_PAGER_PAGE, 0)
        set(lastUsedViewPagerPage) = prefs.edit().putInt(LAST_USED_VIEW_PAGER_PAGE, lastUsedViewPagerPage).apply()

    var localAccountName: String
        get() = prefs.getString(LOCAL_ACCOUNT_NAME, "-1")
        set(localAccountName) = prefs.edit().putString(LOCAL_ACCOUNT_NAME, localAccountName).apply()

    var localAccountType: String
        get() = prefs.getString(LOCAL_ACCOUNT_TYPE, "-1")
        set(localAccountType) = prefs.edit().putString(LOCAL_ACCOUNT_TYPE, localAccountType).apply()
}
