package com.devduo.countriesroom.base.base

interface BaseDelegate<Model> {
    fun onAction(
        code: Code,
        data: Model?
    )
}

sealed class Code {
    data class StringCode(val code: String) : Code()
    data class IntCode(val code: Int) : Code()
}