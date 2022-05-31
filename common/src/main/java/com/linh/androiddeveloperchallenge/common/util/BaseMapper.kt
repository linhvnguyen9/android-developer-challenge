package com.linh.androiddeveloperchallenge.common.util

interface BaseMapper<A, B> {
    fun map(input: A): B
}
