package com.hardik.jetpackapplication.data

import androidx.annotation.RawRes
import com.hardik.jetpackapplication.R

class GetStartedData(@RawRes val resId: Int, val title: String, val desc: String)
val listData = listOf(
    GetStartedData(
        resId = R.raw.ill_goal,
        title = "Define Your Goal",
        desc = "Sign in to your account"
    ),
    GetStartedData(
        resId = R.raw.ill_ilustration,
        title = "Green Marketing",
        desc = "Sign up to your account"
    ),
    GetStartedData(
        resId = R.raw.ill_ilustration_1,
        title = "Clear Task",
        desc = "Forgot your password?"
    ),
    GetStartedData(
        resId = R.raw.ill_security,
        title = "Secured Storage",
        desc = "Reset your password"
    )
)