/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.settings

import android.content.Context
import android.util.AttributeSet
import android.widget.Switch
import androidx.preference.Preference
import androidx.preference.PreferenceViewHolder
import mozilla.components.support.utils.Browsers
import org.mozilla.fenix.R

class DefaultBrowserPreference @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    attributeSetId: Int = android.R.attr.preferenceStyle
) : Preference(context, attrs, attributeSetId) {

    private var switchView: Switch? = null

    init {
        widgetLayoutResource = R.layout.preference_default_browser
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        switchView = holder.findViewById(R.id.switch_widget) as Switch

        updateSwitch()
    }

    fun updateSwitch() {
        val browsers = Browsers.all(context)
        switchView?.isChecked = browsers.isDefaultBrowser
    }
}
