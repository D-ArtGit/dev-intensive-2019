package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    val view = this.currentFocus
    view?.let {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.let {
        it.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
    // else {
    // window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    // }
}

fun Activity.isKeyboardOpen(): Boolean {
    val rootView = findViewById<View>(android.R.id.content)
    val rect = Rect()
    rootView.getWindowVisibleDisplayFrame(rect)
    return rootView.height > rect.height()
}

fun Activity.isKeyboardClosed(): Boolean {
    val rootView = findViewById<View>(android.R.id.content)
    val rect = Rect()
    rootView.getWindowVisibleDisplayFrame(rect)
    return rootView.height <= rect.height()
}