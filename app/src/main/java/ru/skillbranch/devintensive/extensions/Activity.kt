package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import ru.skillbranch.devintensive.R

fun Activity.hideKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
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