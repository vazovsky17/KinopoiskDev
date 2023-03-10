package app.vazovsky.kinopoiskdev.extensions

import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

/**
 * Добавление View внутреннего верхнего отступа, равного высоте статус бара
 */
fun View.fitTopInsetsWithPadding() {
    this.doOnApplyWindowInsets { view, insets, paddings ->
        val windowInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updatePadding(
            top = windowInsets.top + paddings.top
        )
        WindowInsetsCompat.Builder().setInsets(
            WindowInsetsCompat.Type.systemBars(), Insets.of(
                windowInsets.left, 0, windowInsets.right, windowInsets.bottom
            )
        ).build()
    }
}

fun View.doOnApplyWindowInsets(block: (View, WindowInsetsCompat, Rect) -> WindowInsetsCompat) {

    val initialPadding = recordInitialPaddingForView(this)

    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        block(v, insets, initialPadding)
    }

    requestApplyInsetsWhenAttached()
}

private fun recordInitialPaddingForView(view: View) =
    Rect(view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom)

private fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        requestApplyInsets()
    } else {
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.removeOnAttachStateChangeListener(this)
                v.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}

/** Обновление внешних отступов */
fun View.updateMargins(
    left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null
) {
    val lp = layoutParams as? ViewGroup.MarginLayoutParams ?: return

    lp.setMargins(
        left ?: lp.leftMargin, top ?: lp.topMargin, right ?: lp.rightMargin, bottom ?: lp.bottomMargin
    )

    layoutParams = lp
}

/** Скрытие системной клавиатуры */
fun View.hideSoftKeyboard() {
    val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.hideSoftInputFromWindow(windowToken, 0)
}