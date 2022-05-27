package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelView

@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class VerticalCarousel @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : Carousel(context, attrs, defStyleAttr) {

    init {
        isNestedScrollingEnabled = false
    }

    override fun createLayoutManager(): LayoutManager {
        return LinearLayoutManager(context)
    }
}
