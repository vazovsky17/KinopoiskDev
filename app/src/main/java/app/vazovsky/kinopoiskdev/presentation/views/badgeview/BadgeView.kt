package app.vazovsky.kinopoiskdev.presentation.views.badgeview

import android.content.Context
import android.graphics.Canvas
import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.databinding.ViewBadgeBinding
import app.vazovsky.kinopoiskdev.extensions.getColorFromAttribute
import app.vazovsky.kinopoiskdev.extensions.setTextAppearanceCompat
import com.google.android.material.R as MaterialR

/** Бэйдж с косыми скругленными углами */
class BadgeView : LinearLayout {

    private val binding = ViewBadgeBinding.inflate(LayoutInflater.from(context), this)

    private var text = ""
    @ColorInt private var badgeColor = 0
    @ColorInt private var textColor: Int? = null
    private var isBig = false

    private var badgeCornerRadius = 0.0f
    private var badgePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var badgePath = Path()

    constructor(context: Context) : super(context) {
        init(context, null)
        this.setWillNotDraw(false)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
        this.setWillNotDraw(false)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
        this.setWillNotDraw(false)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        initAttrs(attrs, context)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setCanvasParams(measuredWidth.toFloat(), measuredHeight.toFloat())
        setMeasuredDimension(measuredWidth, measuredHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(badgePath, badgePaint)
    }

    private fun initAttrs(attrs: AttributeSet?, context: Context) {
        orientation = HORIZONTAL
        val paddingHorizontal = resources.getDimensionPixelOffset(R.dimen.badge_padding_horizontal)

        setPadding(paddingHorizontal, 0, paddingHorizontal, 0)

        if (attrs != null) {
            val typedArray = context.theme.obtainStyledAttributes(
                attrs, R.styleable.BadgeView, 0, 0
            )
            try {
                setBadgeSize(typedArray.getBoolean(R.styleable.BadgeView_badgeIsBig, false))
                setBadgeColor(typedArray.getColor(R.styleable.BadgeView_badgeColor, 0))
                setBadgeTextColor(
                    typedArray.getColor(
                        R.styleable.BadgeView_badgeTextColor,
                        context.getColorFromAttribute(MaterialR.attr.colorOnPrimary)
                    )
                )
                setBadgeText(typedArray.getString(R.styleable.BadgeView_badgeText) ?: "")
            } finally {
                typedArray.recycle()
            }
        } else {
            setBadgeSize(false)
        }
    }

    fun setBadgeColor(colorId: Int) {
        badgeColor = colorId
        invalidate()
    }

    fun setBadgeTextColor(@ColorInt colorId: Int) = with(binding) {
        textColor = colorId
        textViewBadgeValue.setTextColor(colorId)
    }

    fun setBadgeText(value: String) = with(binding) {
        text = value
        textViewBadgeValue.text = text
    }

    fun setBadgeSize(isBig: Boolean) = with(binding) {
        this@BadgeView.isBig = isBig

        textViewBadgeValue.setTextAppearanceCompat(
            if (isBig) R.style.Font_Caption_1_Medium else R.style.Font_Caption_2_Medium
        )
        textViewBadgeValue.setTextColor(
            textColor ?: context.getColorFromAttribute(MaterialR.attr.colorOnPrimary)
        )
        badgeCornerRadius = resources.getDimension(
            if (isBig) R.dimen.badge_corner_radius_big else R.dimen.badge_corner_radius_small
        )
    }

    private fun setCanvasParams(width: Float, height: Float) {
        // Константа скоса бейджа (соотношение - примерно 1/2 от высоты)
        val badgeEdgeShift = height / 2.0f
        // обратное значение
        val reversedEdgeShift = width - badgeEdgeShift

        val leftTopY = 0.0f
        val rightTopY = 0.0f
        val leftBottomX = 0.0f
        val centerTopX = width / 2.0f
        val centerTopY = 0.0f

        badgePaint.pathEffect = CornerPathEffect(badgeCornerRadius)
        badgePaint.color = badgeColor
        badgePaint.style = Paint.Style.FILL

        badgePath.apply {
            reset()
            moveTo(centerTopX, centerTopY)
            lineTo(width, rightTopY)
            lineTo(reversedEdgeShift, height)
            lineTo(leftBottomX, height)
            lineTo(badgeEdgeShift, leftTopY)
            lineTo(centerTopX, centerTopY)
        }
    }
}
