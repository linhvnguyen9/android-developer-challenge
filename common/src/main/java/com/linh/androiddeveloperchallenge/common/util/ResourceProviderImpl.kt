package com.linh.androiddeveloperchallenge.common.util

import android.content.Context
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(override val context: Context) : ResourceProvider {
    override fun getString(res: Int, vararg args: Any): String = context.getString(res, *args)
}
